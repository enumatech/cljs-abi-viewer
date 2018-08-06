(ns state-channel.demo
  (:require [com.rpl.specter :as s
             :refer [NIL->SET VAL END NONE-ELEM NONE
                     keypath subset set-elem path]
             :refer-macros [select transform setval]]))

(def Alice :Alice)
(def Bob :Bob)
(def Charlie :Charlie)
(def Dave :Dave)
(def Eve :Eve)

(def step1
  {Alice             {}
   :channel-registry {:channel-counter 0
                      :channels        {}}
   :weth             {:balanceOf {Alice      50
                                  Bob        80
                                  "Registry" 0}}
   Bob               {}})

(defn open-channel [state party1 party2]
  (let [channel-id (-> state :channel-registry :channel-counter)]
    (->> state
         (transform [:channel-registry :channels]
                   #(assoc % channel-id {:channel-id channel-id
                                         :left       {:party      party1
                                                      :deposit    0
                                                      :credit     0
                                                      :withdrawal 0}
                                         :right      {:party      party2
                                                      :deposit    0
                                                      :credit     0
                                                      :withdrawal 0}}))
         (transform [:channel-registry :channel-counter] inc))))

(defn dec-by [by amount] (- amount by))
(defn inc-by [by amount] (+ amount by))

(defn weth-balance [party]
  (path [:weth :balanceOf (keypath party)]))

(defn deposit [state party amount]
  (->> state
       (transform (weth-balance party) (partial dec-by amount))
       (transform (weth-balance "Registry") (partial inc-by amount))))

(def step2 (-> step1 (open-channel Alice Bob)))

(def step3 (-> step2 (deposit Alice 10)))

(def steps
  [step1 step2 step3])
