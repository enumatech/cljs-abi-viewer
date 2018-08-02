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

(def #_once T
  "Application time"
  (atom 0))

(def initial-state
  {:time @T
   Alice {:party      Alice
          :balances   {'WETH 100
                       'ASD  123}
          :order-book #{(new-trade Bob 4 'ASD 1 'WETH)
                        (new-trade Bob 5 'ASD 1 'WETH)
                        (new-trade Bob 6 'ASD 1 'WETH)}}

   Bob   {:party      Bob
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
    (h1 "DEX (time: " (:time state) ")")
    (h-map (get state Alice))
    (hr)
    (h-map (get state Bob))
    (table {:class "dex"}
           (tr
             (td (party> (get state Alice)))
             (td (party> (get state Bob)))))))

(defn shift? [^js/KeyboardEvent ev]
  (and (.-shiftKey ev)
       (not (.-ctrlKey ev))
       (not (.-altKey ev))
       (not (.-metaKey ev))))

(defn shift-left? [^js/KeyboardEvent ev]
  (and (shift? ev) (= (.-key ev) "ArrowLeft")))

(defn shift-right? [^js/KeyboardEvent ev]
  (and (shift? ev) (= (.-key ev) "ArrowRight")))

(defn dispatch-keypress [^js/KeyboardEvent ev]
  ;(log "Key:" ev)
  (cond
    (shift-left? ev) (swap! T dec)
    (shift-right? ev) (swap! T inc)))

(defonce keypresses
         (atom (js/document.addEventListener "keydown" dispatch-keypress)))

(defn show-app [state]
  ;(log :state state)
  (time (mount ($ "#app") [(app state)])))

(defn on-state-change [_key _ref old new]
  (when-not (= old new)
    (show-app new)))

(add-watch state :app-state on-state-change)

(defn on-time-change [_key _ref old new]
  (when-not (= old new)
    (show-app (assoc @state :time new))))

(add-watch T :app-time on-time-change)

(show-app @state)
