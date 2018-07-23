(ns tab-viz.main
  (:require
    [cljs.dom :refer [log mount $ text elem frag fragment
                      div h1 ul li table tr th td
                      v-array h-array v-map h-map]]
    [cljs.fetch :as fetch]
    [tab-viz.abi :as abi]))

(def state
  (atom {:oax  nil
         :xchg nil}))

(def example-array
  ["asd" "qwe" "zxc"])

(def example-map
  {:asd 123
   :qwe "zxc"
   :xxx 'symbol
   :yyy :keyword})

(defn app []
  (fragment
    (h1 {:style "color: blue"} (text "Tablular visualisations"))
    (abi/entry abi/example)
    (abi/entry (-> @state :oax :jsonInterface))
    (abi/entry (-> @state :xchg :jsonInterface))
    (table
      (tr {:style "background-color: gold"}
          (td
            (text "asd")
            (table
              (tr {:style "background-color: wheat"}
                  (td (text "qwe")))))))

    (table (v-array example-array))
    (table (h-array example-array))
    (table (v-map example-map))
    (table (h-map example-map))))

;(time (log "Many apps" (doall (repeatedly 100 app))))

(defn render []
  (time (mount ($ "#app") (repeatedly 1 app))))

(defn load-contract [contract]
  (-> (str "/net/4/" (name contract) ".json")
      fetch/cljson
      (.then #(swap! state assoc contract %))))

(-> (js/Promise.all (into-array (map load-contract [:oax :xchg])))
    (.then render))
