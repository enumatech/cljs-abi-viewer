(ns eth.explorer
  (:require
    [clojure.string :as str]
    [com.rpl.specter :as s
     :refer [NIL->SET VAL END NONE-ELEM NONE MAP-KEYS MAP-VALS ALL FIRST
             keypath subset set-elem path selected? submap view]
     :refer-macros [select select-one transform setval]]

    [cljs.dom :refer [mount $ log fragment
                      table tr td th]]

    [kitchen-async.promise :as p]
    [cljs.pprint :refer [pprint]]
    [eth.contract]
    [eth.fixtures]))

(def node-url "http://localhost:8410/")

(def #_once state (atom {:msg "Loading..."}))

(declare app)

(defn show-app [state]
  (mount ($ "#app") [(app state)]))

(defn on-state-change [_key _ref old new]
  (when-not (= old new)
    (show-app new)))

(add-watch state :app-state on-state-change)



(defn event-desc [{:keys [name inputs]}]
  (str name "(" (str/join "," (map :type inputs)) ")"))


(defn app [state]
  (let [contracts   (:contracts state)
        event-ifs   (->> contracts
                         (select [MAP-VALS :jsonInterface ALL
                                  (selected? [:type #(= % "event")])]))

        event-types (->> event-ifs
                         (mapcat (juxt :signature event-desc))
                         (apply hash-map))

        events      (:events state)
        events     (transform [ALL :topics FIRST]
                              event-types
                              events)
        {txs :transactions :as blk} (:block state)
        blk-meta    (dissoc blk :transactions)]
    (table
      (tr
        (th "Events")
        (th "Event interfaces")
        (th "Contracts")
        (th "Block"))
      (tr
        (td {} events)
        (td {} event-ifs)
        (td {} contracts)
        (td {}
            blk-meta
            txs)))))

(defn as-clj [o] (js->clj o :keywordize-keys true))

(defn post-opts [data]
  (clj->js {:method  "POST"
            :mode    "cors"
            :headers {"Content-Type" "application/json; charset=utf-8"}
            :body    (js/JSON.stringify (clj->js data))}))

(defn json-rpc [method & params] {:jsonrpc "2.0", :method method, :params (vec params), :id 123})
(def web3-version (partial json-rpc "web3_clientVersion"))
(def eth-syncing (partial json-rpc "eth_syncing"))
(def eth-accounts (partial json-rpc "eth_accounts"))
(def eth-block-number (partial json-rpc "eth_blockNumber"))
(def eth-get-balance (partial json-rpc "eth_getBalance"))
(defn eth-get-block-by-number [block tx-data?]
  (json-rpc "eth_getBlockByNumber" block tx-data?))

(def fetch (js/fetch.bind js/window))

(defn rpc [& [method & params]]
  (letfn [(response-to-result-or-error [js-response]
            (let [{:keys [result error]} (as-clj js-response)]
              (p/resolve (or result
                             {:error  error
                              :method method
                              :params (vec params)}))))]
    (p/-> (->> params (apply json-rpc method) post-opts (vector (str node-url method))
               (apply fetch))
          ((memfn json))
          response-to-result-or-error)))

;==================== Main ==============

;(rpc! "eth_blockNumber")
;(rpc! "eth_getBlockByNumber" "0x2a87c8" true)
;(rpc* "eth_getLogs" {:fromBlock "0x263C1E" :toBlock "0x2b87c8" :address "0x475CDA4A73EE3f01748a9D553A8c19Ca2853A8Aa"})
;(rpc* "eth_accounts")

(p/try
  (p/let [contract-names    [:oax :weth]
          contract-json-ifs (p/all (map eth.contract/load contract-names))
          contracts         (zipmap contract-names contract-json-ifs)
          block             (rpc "eth_getBlockByNumber" "0x2a87c8" true)
          events            (rpc "eth_getLogs" {:fromBlock "0x263C1E"
                                                :toBlock   "0x2b87c8"
                                                :address   (-> contracts :oax :address)})]

    ; Expose some data to be used in REPL
    (def oax (:oax contracts))
    (def weth (:weth contracts))

    (swap! state assoc
           :contracts contracts
           :block block
           :events events))
  (p/catch js/Error e
    (js/console.error e)
    (reset! state eth.fixtures/example-state)))

(show-app @state)
