(ns state-channel.two-party-swap-sprites
  (:require [com.rpl.specter :as s
             :refer [NIL->SET VAL END NONE-ELEM NONE MAP-KEYS
                     keypath subset set-elem path]
             :refer-macros [select select-one transform setval]]
            [cljs.dom
             :refer [Elem render log mount $ text elem frag fragment
                     div span i b img br hr h1 h2 h3 h4 hr ul li table tr th td
                     v-array h-array v-map h-map x xi robohash]
             :as dom]))

(def Alice :Alice)
(def Bob :Bob)

(defrecord System [])
(extend-type System Elem
  (render [{:keys [xform] :as sys}]
    (let [xf (meta xform)]
      (fragment
        (h2 (or (:doc xf) (:name xf)))
        (-> sys
            (dissoc :time :xform)
            v-map)))))

(def initial-state
  (map->System {Alice {}}))

(defn step-gen-secret
  "Alice generates a secret"
  [state]
  state)

(defn next-step [state xform]
  (-> state xform (assoc :xform xform)))

(def steps
  (->> [#'step-gen-secret]
       (reductions next-step initial-state)
       vec))
