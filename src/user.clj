(ns ^:figwheel-no-load user
  (:require [figwheel.main.api :as fig]))

(defn start []
  (fig/start {:mode :serve} "dev"))

(defn cljs-repl [& [build-id]]
  (fig/cljs-repl (or build-id "dev")))
