(ns abi.viewer
  (:require
    [nightlight.repl-server]
    [cljs.dom :refer [log mount $ text elem frag fragment
                      div h1 h2 h3 h4 hr ul li table tr th td
                      v-array h-array v-map h-map x xi]]
    [cljs.fetch :as fetch]
    [abi.widget :as abi]
    [cljs.dom.playground :as playground]
    [highland.js :as S]))

(defn as-clj [o] (js->clj o :keywordize-keys true))

(def contract-names [:oax :xchg])

(defn contract-file [contract-name-kw]
  (str "/net/4/" (name contract-name-kw) ".json"))

(def contract-filenames (mapv contract-file contract-names))

(def initial-state
  {; Example for 1st time rendering
   :oax  {:jsonInterface
          [{:name    "Loading..."
            :type    "function"
            :inputs  [{:type "address" :name "param"}
                      {:type "bool"}]
            :outputs [{:type "uint256" :name "result"}]}]}
   :xchg nil})

(def state (atom initial-state))

(defn reset-contracts! [contracts]
  (reset! state (zipmap contract-names contracts)))

(defn app [state]
  (fragment
    (h1 {:style "color: blue"} (text "Smart Contracts"))
    (h2 (text "Example"))
    (abi/render abi/example)
    (x (fn [contract]
         (fragment (h2 (text (name contract)))
                   (abi/render (-> state contract :jsonInterface))))
       contract-names)))

(defn render [state]
  (time (mount ($ "#app") [(app state) #_(playground/render)])))

(defn re-render-on-state-change []
  (add-watch state :app-state
             (fn [_key _ref _old new]
               (render new))))

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
        (.toArray reset-contracts!))))

;;; Load contracts in different ways
;
;(load-contracts-with-promise-all)
;(load-contracts-with-stream-chain)
(load-contracts-with-stream-pipeline)

(render @state)
