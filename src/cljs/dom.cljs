(ns cljs.dom)

(defn log [& args] (apply js/console.log args))
(defn $ [selector] (js/document.querySelector selector))
(defn text [text] (js/document.createTextNode text))

(defn render-into [elem kids]
  (set! (.-innerHTML elem) "")
  (doseq [kid kids]
    (.appendChild elem kid)))

(defn tag [tag-name attrs & kids]
  (let [elem (js/document.createElement tag-name)]
    (doseq [[attr-name attr-value] attrs]
      (.setAttribute elem (clj->js attr-name) (clj->js attr-value)))
    (render-into elem kids)
    elem))

(defn H [tag-name]
  (fn [& attrs-kids]
    (let [maybe-attrs (first attrs-kids)
          is-attr?    (map? maybe-attrs)
          attrs       (if is-attr? maybe-attrs {})
          kids        (if is-attr? (rest attrs-kids) attrs-kids)]
      (apply tag tag-name attrs kids))))

(def div (H "div"))
(def h1 (H "h1"))
(def h2 (H "h2"))
(def h3 (H "h3"))
(def table (H "table"))
(def tr (H "tr"))
(def th (H "th"))
(def td (H "td"))

(defn v-array [arr]
  (map-indexed
    (fn [idx el]
      (tr (th (text (pr-str idx)))
          (td (text (pr-str el)))))
    arr))

(defn h-array [arr]
  (vector
    (apply tr (map-indexed (fn [idx _el] (th (text (pr-str idx)))) arr))
    (apply tr (map-indexed (fn [_idx el] (td (text (pr-str el)))) arr))))

(defn v-map [m]
  (map
    (fn [[key val]]
      (tr (th (text (pr-str key)))
          (td (text (pr-str val)))))
    m))

(defn h-map [m]
  (vector
    (apply tr (map (fn [[key _val]] (th (text (pr-str key)))) m))
    (apply tr (map (fn [[_key val]] (td (text (pr-str val)))) m))))
