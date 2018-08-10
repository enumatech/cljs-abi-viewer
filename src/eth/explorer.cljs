(ns eth.explorer
  (:require [cljs.dom
             :refer [mount $ log]]
            [highland.js :as S]))

(def node-url "http://localhost:8420/")

(def #_once state (atom "Loading..."))

(declare app)

(defn show-app [state]
  (mount ($ "#app") [(app state)]))

(defn on-state-change [_key _ref old new]
  (when-not (= old new)
    (show-app new)))

(add-watch state :app-state on-state-change)

(defn app [state]
  state)

(defn as-clj [o] (js->clj o :keywordize-keys true))

(defn post-opts [data]
  (clj->js {:method  "POST"
            :mode    "cors"
            :headers {"Content-Type" "application/json; charset=utf-8"}
            :body    (js/JSON.stringify (clj->js data))}))

(def |cljson
  (S/pipeline
    (S/flatMap (comp S (partial apply js/fetch)))
    (S/flatMap (comp S (memfn json)))
    (S/map as-clj)))

(defn json-rpc [method & params] {:jsonrpc "2.0", :method method, :params (vec params), :id 123})
(def web3-version (partial json-rpc "web3_clientVersion"))
(def eth-syncing (partial json-rpc "eth_syncing"))
(def eth-accounts (partial json-rpc "eth_accounts"))
(def eth-block-number (partial json-rpc "eth_blockNumber"))
(def eth-get-balance (partial json-rpc "eth_getBalance"))
(defn eth-get-block-by-number [block tx-data?]
  (json-rpc "eth_getBlockByNumber" block tx-data?))

(def fetch (js/fetch.bind js/window))

(defn rpc [& args]
  (-> (->> args (apply json-rpc) post-opts (vector node-url) array S)
      (.flatMap (comp S (partial apply fetch)))
      (.flatMap (comp S (memfn json)))
      (.map (comp :result as-clj))
      (.toArray #(reset! state (first %)))))

;(rpc "eth_blockNumber")
;(rpc "eth_getBlockByNumber" "0x2a87c8" true)
(rpc "eth_getLogs" {:fromBlock "0x263C1E" :toBlock "0x2b87c8" :address "0x475CDA4A73EE3f01748a9D553A8c19Ca2853A8Aa"})
;(rpc "eth_accounts")

(show-app @state)

(comment
  (-> "{\"jsonrpc\":\"2.0\",\"method\":\"web3_clientVersion\",\"params\":[],\"id\":67}"
      js/JSON.parse (js->clj :keywordize-keys true))

  (defn load-contracts-with-promise-all []
    (letfn [(load-contract [contract-name-kw]
              (-> contract-name-kw contract-file fetch/cljson
                  (.then #(swap! state assoc contract-name-kw %))))]

      (-> (map load-contract contract-names) into-array js/Promise.all
          (.then #(render @state)))))

  (defn load-contracts-with-stream-chain []
    (re-render-on-state-change)

    (let [filename$ (-> contract-filenames to-array S)]
      (-> filename$
          (.flatMap (comp S js/fetch))
          (.flatMap (comp S (memfn json)))
          (.map as-clj)
          (.toArray reset-contracts!))))

  (defn load-contracts-with-stream-pipeline []
    (re-render-on-state-change)

    (let [filename$ (-> contract-filenames to-array S)
          |cljson   (S/pipeline
                      (S/flatMap (comp S js/fetch))
                      (S/flatMap (comp S (memfn json)))
                      (S/map as-clj))]
      (-> filename$
          (.pipe |cljson)
          (.toArray reset-contracts!)))))
