(ns cljs.dom.playground
  (:require
    [cljs.dom :refer [log mount $ text elem frag fragment
                      div h1 h2 h3 h4 hr ul li table tr th td
                      v-array h-array v-map h-map]]))

(def example-array
  ["asd" "qwe" "zxc"])

(def example-map
  {:asd 123
   :qwe "zxc"
   :xxx 'symbol
   :yyy :keyword})

(defn render []
  (fragment
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
