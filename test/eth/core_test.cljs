(ns eth.core-test
  (:require [devcards.core :as dc]
            [cljs.dom :refer [log mount h1 div v-map]])
  (:require-macros
    [cljs.test :refer [is testing]]
    [devcards.core :refer [defcard deftest dom-node]]))

(devcards.core/start-devcard-ui!)

(defcard my-first-card
  (dom-node
    (fn [data node]
      (let [el (div (v-map @data))]
        (set! el -onclick #(swap! data update :counter inc))
        (mount node [el]))))
  {:counter 123})

;(let [el (js/document.createElement "h1")]
;  (doto el
;    (set! -onclick #(swap! data update :counter inc))
;    (set! -innerText (-> data deref :counter str)))
;  (.appendChild node el))

(deftest some-test
  (is (= 0 0))
  (testing "first level nesting"
    (is (= 1 1)))
  (testing "another first level nesting"
    (is (= 1 1))
    (testing "second level nesting"
      (is (= 1 2))
      (is (= 2 2)))))
