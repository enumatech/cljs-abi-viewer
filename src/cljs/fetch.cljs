(ns cljs.fetch)

(defn uri [uri*] (js/fetch uri*))
(defn json [uri*] (-> (uri uri*) (.then #(.json %))))
(defn as-clj [js-object] (js->clj js-object :keywordize-keys true))
(defn cljson [uri*] (-> (json uri*) (.then as-clj)))
