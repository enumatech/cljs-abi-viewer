(ns abi.viewer
  (:require
    [cljs.dom :refer [log mount $ text elem frag fragment
                      div h1 h2 h3 h4 hr ul li table tr th td
                      v-array h-array v-map h-map]]
    [cljs.fetch :as fetch]
    [abi.widget :as abi]
    [cljs.dom.playground :as playground]))

(def state
  (atom {:oax  nil
         :xchg nil}))

(defn app []
  (fragment
    (h1 {:style "color: blue"} (text "Smart Contracts"))
    (h2 (text "Example"))
    (abi/render abi/example)
    (h2 (text "OAX demo token"))
    (abi/render (-> @state :oax :jsonInterface))
    (h2 (text "0x Exchange"))
    (abi/render (-> @state :xchg :jsonInterface))))

;(time (log "Many apps" (doall (repeatedly 100 app))))

(defn render []
  (time (mount ($ "#app") (repeatedly 1 app #_playground/render))))

(defn load-contract [contract]
  (-> (str "/net/4/" (name contract) ".json")
      fetch/cljson
      (.then #(swap! state assoc contract %))))

(-> (map load-contract [:oax :xchg])
    into-array
    js/Promise.all
    (.then render))
