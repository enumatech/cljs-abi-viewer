(ns eth.core-test
  (:require [clojure.test :refer [deftest]]
            [devcards.core :as dc])
  (:require-macros
    [devcards.core :refer [defcard]]))

(devcards.core/start-devcard-ui!)

(defcard my-first-card
  "Devcards is freaking awesome!")
