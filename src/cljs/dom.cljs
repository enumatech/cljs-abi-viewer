(ns cljs.dom)

(defprotocol Elem
  (render [data]))

(defn log [& args] (apply js/console.log args) (first args))
(defn $ [selector] (js/document.querySelector selector))
(defn text [text] (js/document.createTextNode text))
(defn element [tag-name] (js/document.createElement tag-name))
(defn append [node kid] (.appendChild node kid))

(defn slurp [node kids]
  (doseq [kid kids]
    (try
      (when-not (nil? kid)
        (append node
                (if (satisfies? Elem kid)
                  (render kid)
                  kid)))
      (catch js/TypeError e
        (js/console.error "Can't render elem" (type kid) (pr-str kid))
        (throw e)
        (append node
                (text (pr-str kid))))))
  node)

(defn frag [kids] (doto (js/document.createDocumentFragment) (slurp kids)))
(defn fragment [& kids] (frag kids))
(def x (comp frag map))
(def xi (comp frag map-indexed))
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
(def span (H "span"))
(def code (H "code"))
(def i (H "i"))
(def b (H "b"))
(def img (H "img"))
(def br (H "br"))
(def hr (H "hr"))

(def h1 (H "h1"))
(def h2 (H "h2"))
(def h3 (H "h3"))
(def h4 (H "h4"))

(def ol (H "ol"))
(def ul (H "ul"))
(def li (H "li"))

(def table (H "table"))
(def tr (H "tr"))
(def th (H "th"))
(def td (H "td"))

(defn v-array [arr]
  (letfn [(column [idx el]
            (tr (th (text (pr-str idx)))
                (td {} el)))]
    (xi column arr)))

(defn h-array [arr]
  (fragment
    (tr (xi (fn [idx _el] (th (text (pr-str idx)))) arr))
    (tr (xi (fn [_idx el] (td {} el)) arr))))

(defn v-map [m]
  (letfn [(column [[key val]]
            (tr (th (text (pr-str key)))
                (td {} val)))]
    (x column m)))

(defn h-map [m]
  (fragment
    (tr (x (fn [[key _val]] (th (text (pr-str key)))) m))
    (tr (x (fn [[_key val]] (td {} val)) m))))

(extend-protocol Elem
  number
  (render [num]
    (if (zero? num)
     (span {:class "number zero"} (pr-str num))
     (span {:class "number"} (pr-str num))))

  Keyword
  (render [num] (span {:class "keyword"} (code (pr-str num))))

  string
  (render [s] (text s))

  PersistentVector
  (render [v] (span {:class "vector"} (v-array v)))

  PersistentHashSet
  (render [a-set]
    (div {:class "set"}
         (frag (->> a-set
                    (map render)
                    (map #(attrs % {:class "elem"}))))))

  PersistentArrayMap
  (render [m] (table {:class "map"} (v-map m)))

  Symbol
  (render [sym] (span {:class "symbol"} (name sym))))
