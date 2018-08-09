(ns ^:figwheel-hooks history.viewer
  (:require
    [cljs.dom
     :refer [Elem render log mount $ text elem frag fragment
             div span i img br hr h1 h2 h3 h4 hr ul li table tr th td
             v-array h-array v-map h-map x xi]]
    [state-channel.demo :as scenario]
    [state-channel.two-party-swap-sprites]))

(def steps scenario/steps)

; Application time
(defonce T (atom 0))

(def #_once state (atom nil))

(defn viewer [state]
  (fragment
    (h1 "Application state @ step " (:time state))
    ;(h-array scenario/steps)
    state))

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
  (time (mount ($ "#app") [(viewer state)])))

(defn on-state-change [_key _ref old new]
  (when-not (= old new)
    (show-app new)))

(add-watch state :app-state on-state-change)

(defn app-state-at [t]
  (assoc (get steps t) :time t))

(defn on-time-change [_key _ref _old-time new-time]
  (reset! state (app-state-at new-time)))

(add-watch T :app-time on-time-change)

; Force app-state recalculation
(swap! T identity)
(show-app @state)
