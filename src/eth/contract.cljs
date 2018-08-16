(ns eth.contract
  (:require [kitchen-async.promise :as p]
            [cljs.fetch]))

(defn path [contract-name]
    (str "/net/4/" (name contract-name) ".json"))

(defn load [contract-path] (-> contract-path path cljs.fetch/cljson))
