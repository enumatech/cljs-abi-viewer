(ns ^:figwheel-hooks dex.viewer
  (:require
    [cljs.dom
     :refer [Elem render log mount $ text elem frag fragment
             div span br hr h1 h2 h3 h4 hr ul li table tr th td
             v-array h-array v-map h-map x xi]]))

(defrecord Amt [amount token]
  Elem
  (render [this] (render (str amount " " (name token)))))

(defrecord Trade [buy sell]
  Elem
  (render [_] (div "Buy " buy " & Sell " sell "")))

(defn new-trade [buy-amt buy-token sell-amt sell-token]
  (->Trade (->Amt buy-amt buy-token)
           (->Amt sell-amt sell-token)))

(def initial-state
  {:alice {:nick       "Alice"
           :balances   {:WETH 100
                        :ASD  123}
           :order-book #{(new-trade 4 :ASD 1 :WETH)}}

   :bob   {:nick       "Bob"
           :balances   {:WETH 90
                        :ASD  456}
           :order-book [(new-trade 2 :WETH 6 :ASD)
                        (new-trade 12 :WETH 16 :ASD)]}})

(def #_once state (atom initial-state))

(defn order-book> [order-book]
  (v-array order-book))

(defn party> [party]
  (let [{:keys [nick balances order-book]} party]
    (fragment
      (h2 nick)
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
