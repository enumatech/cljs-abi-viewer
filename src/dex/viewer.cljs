(ns ^:figwheel-hooks dex.viewer
  (:require
    [cljs.dom
     :refer [Elem render log mount $ text elem frag fragment
             div span i img br hr h1 h2 h3 h4 hr ul li table tr th td
             v-array h-array v-map h-map x xi]]
    [dex.core :as dex]
    [dex.demo :as demo :refer [Alice Bob Charlie]]))

(defn robohash [name & [set]]
  (str "https://robohash.org/" name (when set (str "?set=set" set))))

(extend-protocol Elem
  dex/Party
  (render [{:keys [nickname address icon]}]
    (span {:class "party"}
          nickname
          ;(br) address
          (img {:src (or icon (robohash nickname 3))})))

  dex/Amt
  (render [{:keys [amount token]}]
    (fragment amount " " token))


  dex/Order
  (render [{:keys [party buy sell]}]
    (span {} party (i "has ") buy " & " (i "wants ") sell "")))

(def #_once T
  "Application time"
  (atom 0))

(def initial-state
  (merge {:time @T} (first demo/steps)))

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
    ;(h-map (get state Alice))
    ;(hr)
    ;(h-map (get state Bob))
    (table {:class "dex"}
           (tr (th "Alice")
               (th "Whisper")
               (th "Bob"))
           (tr
             (td (party> (get state Alice)))
             (td (v-array (get state :whisper)))
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

(defn on-time-change [_key _ref old-time new-time]
  (when-not (= old-time new-time)
    (reset! state (assoc (get demo/steps new-time) :time new-time))))

(add-watch T :app-time on-time-change)

(show-app @state)
