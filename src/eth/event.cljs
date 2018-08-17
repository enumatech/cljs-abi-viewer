(ns eth.event
  (:require
    [com.rpl.specter :as s
     :refer [NIL->SET VAL END NONE-ELEM NONE MAP-KEYS MAP-VALS ALL FIRST
             keypath subset set-elem path selected? submap view pred=]
     :refer-macros [select select-one transform setval]]))

(defn decode [{:keys [topics data] :as event} json-interfaces]
  (let [is-event-if? #(-> % :type (= "event"))
        event-ifs    (filter is-event-if? json-interfaces)
        event-sigs   (->> event-ifs
                          (group-by :signature)
                          (transform [MAP-VALS] first))

        {:keys [inputs name]
         :as   event} (-> topics first event-sigs)]
    ; The :NAME key for the event name is capitalized to avoid conflict
    ; with event parameter names
    (conj {:NAME name}
          (zipmap
            (->> inputs
                 (filter :indexed)
                 (map (comp keyword :name)))
            (rest topics))
          (zipmap
            (->> inputs
                 (filter (complement :indexed))
                 (map (comp keyword :name)))
            (vector data)))))

