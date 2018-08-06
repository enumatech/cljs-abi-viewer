(ns ^:figwheel-hooks dex.ui
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

(defn ui [state]
  (fragment
    (h1 "DEX (time: " (:time state) ")")
    ;(h-map (get state Alice))
    ;(get state :whisper)
    ;(h-map (get state Bob))
    (table {:class "dex"}
           (tr (th "Alice")
               (th "Whisper")
               (th "Bob"))
           (tr
             (td (party> (get state Alice)))
             (td (get state :whisper))
             (td (party> (get state Bob)))))))
