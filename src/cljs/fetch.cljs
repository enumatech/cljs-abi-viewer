(ns cljs.fetch)

(defn uri [uri] (js/fetch uri))
(defn json [uri*] (-> (uri uri*) (.then #(.json %))))
(defn cljson [uri*] (-> (json uri*) (.then #(js->clj % :keywordize-keys true))))
