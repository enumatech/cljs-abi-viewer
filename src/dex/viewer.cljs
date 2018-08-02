(ns ^:figwheel-hooks dex.viewer
  (:require
    [cljs.dom
     :refer [Elem render log mount $ text elem frag fragment
             div span i img br hr h1 h2 h3 h4 hr ul li table tr th td
             v-array h-array v-map h-map x xi]]))

(defn robohash [name & [set]]
  (str "https://robohash.org/" name (when set (str "?set=set" set))))

(defrecord Party [nickname address] Elem
  (render [this]
    (span {:class "party"}
          nickname
          ;(br) address
          (img {:src (or (:icon this) (robohash nickname 3))}))))


(defrecord Amt [amount token]
  Elem
  (render [this] (fragment amount " " token)))

(defrecord Trade [party buy sell]
  Elem
  (render [_]
    (span {} party (i "has ") buy " & " (i "wants ") sell "")))

(defn new-trade [party buy-amt buy-token sell-amt sell-token]
  (->Trade party
           (->Amt buy-amt buy-token)
           (->Amt sell-amt sell-token)))

(def Alice (->Party "Alice" "0x1111"))
(def Bob (->Party "Bob" "0x2222"))
(def Charlie (->Party "Charlie" "0x3333"))
(def Dave (->Party "Dave" "0x4444"))
(def Eve (->Party "Eve" "0x666"))

(def initial-state
  {:alice {:party      Alice
           :balances   {'WETH 100
                        'ASD  123}
           :order-book #{(new-trade Bob 4 'ASD 1 'WETH)
                         (new-trade Bob 5 'ASD 1 'WETH)
                         (new-trade Bob 6 'ASD 1 'WETH)}}

   :bob   {:party      Bob
           :balances   {'WETH 90
                        'ASD  456}
           :order-book [(new-trade Alice 2 'WETH 6 'ASD)
                        (new-trade Alice 12 'WETH 16 'ASD)]}})

(def #_once state (atom initial-state))

(defn order-book> [order-book]
  (v-array order-book))

(defn party> [party]
  (let [{:keys [party balances order-book]} party]
    (fragment
      (h2 party)
      (h3 "Balances")
      (h-map balances)
      (h3 "Order book")
      (order-book> order-book))))

(defn app [state]
  (fragment
    (h1 "DEX")
    (h-map (:alice state))
    (hr)
    (h-map (:bob state))
    (table {:class "dex"}
           (tr
             (td (party> (:alice state)))
             (td (party> (:bob state)))))))

(defn show-app [state]
  (log :state state)
  (time (mount ($ "#app") [(app state)])))

(defn on-state-change [_key _ref old new] (when-not (= old new) (show-app new)))
(add-watch state :app-state on-state-change)
(show-app @state)
