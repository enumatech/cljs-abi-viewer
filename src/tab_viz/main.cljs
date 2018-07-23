(ns tab-viz.main
  (:require
    [cljs.dom :refer [log render-into $ text tag
                      h1 div table tr th td
                      v-array h-array v-map h-map]]))

(def example-array
  ["asd" "qwe" "zxc"])

(def example-map
  {:asd 123
   :qwe "zxc"
   :xxx 'symbol
   :yyy :keyword})

(defn app []
  (vector
    (h1 {:style "color: blue"} (text "Tablular visualisations"))
    (table
      (tr {:style "background-color: gold"}
          (td
            (text "asd")
            (table
              (tr {:style "background-color: wheat"}
                  (td (text "qwe")))))))

    (apply table (v-array example-array))
    (apply table (h-array example-array))
    (apply table (h-map example-map))))

;(log (time (doall (repeat 1000000 (app)))))

(render-into ($ "#app") (app))
