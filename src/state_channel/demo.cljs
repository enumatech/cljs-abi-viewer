(ns state-channel.demo
  (:require [com.rpl.specter :as s
             :refer [NIL->SET VAL END NONE-ELEM NONE MAP-KEYS
                     keypath subset set-elem path]
             :refer-macros [select select-one transform setval]]
            [cljs.dom
             :refer [Elem render log mount $ text elem frag fragment
                     div span i b img br hr h1 h2 h3 h4 hr ul li table tr th td
                     v-array h-array v-map h-map x xi robohash]
             :as dom]))

(defrecord Party [nickname])

(extend-type Party
  Elem
  (render [{:keys [nickname]}]
    (span {:class "party"}
          (img {:src (robohash nickname 3)})
          ;(br)
          nickname))

  IPrintWithWriter
  (-pr-writer [party writer _opts]
    (-write writer (:nickname party))))

(def Alice (->Party "Alice"))
(def Bob (->Party "Bob"))

(defrecord ChannelSide [party deposit credit withdrawal])

(defrecord Channel [channel-id round left right signed])

(extend-type Channel dom/Elem
  (render [{:keys [channel-id round left right signed] :as ch}]
    (let [side-row (fn [{:keys [party deposit credit withdrawal] :as _side}]
                     (tr (th {} party) (td deposit) (td credit) (td withdrawal)))]
      (table (if signed {:class "signed"} {})
        (tr (td (i (str "chID: " channel-id)) (br)
                (str "Round: " round))
            (th "Deposit") (th "Credit") (th "Withdrawal"))
        (side-row left)
        (side-row right)))))

(defrecord System [])
(extend-type System Elem
  (render [sys] (v-map sys)))

(def initial-state
  (map->System
    {Alice             {:channel nil}
     :channel-registry {:channel-counter 0
                        :channels        {}}
     :weth             {:balanceOf {Alice      50
                                    Bob        80
                                    "Registry" 0}}
     Bob               {:channel nil}}))

; ============  Paths and helper functions  ==============

(defn dec-by [by amount] (- amount by))
(defn inc-by [by amount] (+ amount by))

(defn weth-balance [party]
  (path [:weth :balanceOf (keypath party)]))

(defn channel-state [cid]
  (path [:channel-registry :channels cid]))

; ============  Actions  ==============

(defn open-channel [state party1 party2]
  (let [channel-id (-> state :channel-registry :channel-counter)
        channel    (map->Channel {:channel-id channel-id
                                  :round      -1
                                  :left       (map->ChannelSide
                                                {:party      party1
                                                 :deposit    0
                                                 :credit     0
                                                 :withdrawal 0})
                                  :right      (map->ChannelSide
                                                {:party      party2
                                                 :deposit    0
                                                 :credit     0
                                                 :withdrawal 0})})]
    (->> state
         (transform [:channel-registry :channels] #(assoc % channel-id channel))
         (transform [:channel-registry :channel-counter] inc)
         (setval [(keypath party1) :channel] channel)
         (setval [(keypath party2) :channel] channel))))

(defn deposit-plan [state party channel-id amount]
  (->> state
       (transform [(keypath party) :channel :left :deposit]
                  (partial inc-by amount))
       (transform [(keypath party) :channel :round] inc)))

(defn transfer-plan [state src dst channel-id amount]
  (->> state
       (transform [(keypath src) :channel :left :credit]
                  (partial dec-by amount))
       (transform [(keypath src) :channel :right :credit]
                  (partial inc-by amount))
       (transform [(keypath src) :channel :round] inc)))

(defn deposit [state party channel-id amount]
  (->> state
       (transform (weth-balance party) (partial dec-by amount))
       (transform (weth-balance "Registry") (partial inc-by amount))
       (transform [:channel-registry :channels channel-id :left :deposit] (partial inc-by amount))
       (transform [:channel-registry :channels channel-id :round] inc)))

; ============  Steps  ==============

(def step-open-channel
  (-> initial-state (open-channel Alice Bob)))

(def alice-bob-cid
  (->> step-open-channel
       (select [:channel-registry :channels MAP-KEYS])
       (apply max)))

(def step-deposit-plan
  (-> step-open-channel
      (deposit-plan Alice alice-bob-cid 10)))

(def step-deposit
  (-> step-deposit-plan (deposit Alice alice-bob-cid 10)))

(def step-deposit-event
  (->> step-deposit
       (setval [(keypath Bob) :channel]
               (select-one (channel-state alice-bob-cid) step-deposit))))

(def step-transfer-plan
  (-> step-deposit-event
      (transfer-plan Alice Bob alice-bob-cid 7)))

(def step-transfer
  (->> step-transfer-plan
       (setval [(keypath Bob) :channel]
               (select-one [(keypath Alice) :channel] step-transfer-plan))))

(defn channel-balance [ch side]
  (let [{:keys [deposit credit withdrawal]} (-> ch side)]
    (-> deposit
        (+ credit)
        (- withdrawal))))


(def step-update-plan
  (let [alice-ch (select-one [(keypath Alice) :channel] step-transfer)]
    (->> step-transfer
         (setval [(keypath Alice) :channel :left :withdrawal]
                 (channel-balance alice-ch :left))
         (setval [(keypath Alice) :channel :right :withdrawal]
                 (channel-balance alice-ch :right))
         (transform [(keypath Alice) :channel :round] inc)
         (setval [(keypath Alice) :channel :signed] true))))

(def step-send-update-plan
  (->> step-update-plan
       (setval [(keypath Bob) :channel]
               (select-one [(keypath Alice) :channel] step-update-plan))))

(def step-update
  (let [bob-ch (-> (select-one [(keypath Bob) :channel] step-send-update-plan)
                   (assoc :signed false))]
    (->> step-send-update-plan
         (setval [(channel-state (-> bob-ch :channel-id))]
                 bob-ch))))

(def step-alice-withdraw
  step-update)

(def step-bob-withdraw
  step-alice-withdraw)

; TODO
;   Non-cooperative withdrawal
;   Tokens
;   Conditional payment

(def steps
  [initial-state
   step-open-channel
   step-deposit-plan
   step-deposit
   step-deposit-event
   step-transfer-plan
   step-transfer
   step-update-plan
   step-send-update-plan
   step-update
   step-alice-withdraw])


