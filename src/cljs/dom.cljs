(ns cljs.dom)

(defn log [& args] (apply js/console.log args))
(defn $ [selector] (js/document.querySelector selector))
(defn text [text] (js/document.createTextNode text))
(defn element [tag-name] (js/document.createElement tag-name))
(defn append [node kid] (.appendChild node kid))
(defn slurp [node kids] (doseq [kid kids] (append node kid)) node)
(defn frag [kids] (doto (js/document.createDocumentFragment) (slurp kids)))
(defn fragment [& kids] (frag kids))
(defn clear [node] (-> node .-innerHTML (set! "")))
(defn mount [node kids] (doto node (clear) (append (frag kids))))
(defn set-attr [node a v] (doto node (.setAttribute (clj->js a) (clj->js v))))
(defn attrs [node attr-map] (doseq [[a v] attr-map] (set-attr node a v)) node)

(defn elem [tag-name attr-map & kids]
  (doto (element tag-name) (attrs attr-map) (mount kids)))

(defn H [tag-name]
  (fn [& attrs-kids]
    (let [maybe-attrs (first attrs-kids)
          is-attr?    (map? maybe-attrs)
          attrs       (if is-attr? maybe-attrs {})
          kids        (if is-attr? (rest attrs-kids) attrs-kids)]
      (apply elem tag-name attrs kids))))

(def div (H "div"))

(def h1 (H "h1"))
(def h2 (H "h2"))
(def h3 (H "h3"))

(def ol (H "ol"))
(def ul (H "ul"))
(def li (H "li"))

(def table (H "table"))
(def tr (H "tr"))
(def th (H "th"))
(def td (H "td"))

(defn v-array [arr]
  (letfn [(col [idx el]
            (tr (th (text (pr-str idx)))
                (td (text (pr-str el)))))]
    (frag (map-indexed col arr))))

(defn h-array [arr]
  (fragment
    (tr (frag (map-indexed (fn [idx _el] (th (text (pr-str idx)))) arr)))
    (tr (frag (map-indexed (fn [_idx el] (td (text (pr-str el)))) arr)))))

(defn v-map [m]
  (letfn [(col [[key val]]
            (tr (th (text (pr-str key)))
                (td (text (pr-str val)))))]
    (frag (map col m))))

(defn h-map [m]
  (fragment
    (tr (frag (map (fn [[key _val]] (th (text (pr-str key)))) m)))
    (tr (frag (map (fn [[_key val]] (td (text (pr-str val)))) m)))))
