(ns tab-viz.abi
  (:require
    [cljs.dom :refer [log mount $ text frag fragment x
                      h1 h2 h3 h4 div span table tr th td
                      v-array h-array v-map h-map]]))

(def example
  (js->clj
    (js*
      "[{\"inputs\": [{\"type\": \"address\", \"name\": \"\"}], \"constant\": true, \"name\": \"isInstantiation\", \"payable\": false, \"outputs\": [{\"type\": \"bool\", \"name\": \"\"}], \"type\": \"function\"}, {\"inputs\": [{\"type\": \"address[]\", \"name\": \"_owners\"}, {\"type\": \"uint256\", \"name\": \"_required\"}, {\"type\": \"uint256\", \"name\": \"_dailyLimit\"}], \"constant\": false, \"name\": \"create\", \"payable\": false, \"outputs\": [{\"type\": \"address\", \"name\": \"wallet\"}], \"type\": \"function\"}, {\"inputs\": [{\"type\": \"address\", \"name\": \"\"}, {\"type\": \"uint256\", \"name\": \"\"}], \"constant\": true, \"name\": \"instantiations\", \"payable\": false, \"outputs\": [{\"type\": \"address\", \"name\": \"\"}], \"type\": \"function\"}, {\"inputs\": [{\"type\": \"address\", \"name\": \"creator\"}], \"constant\": true, \"name\": \"getInstantiationCount\", \"payable\": false, \"outputs\": [{\"type\": \"uint256\", \"name\": \"\"}], \"type\": \"function\"}, {\"inputs\": [{\"indexed\": false, \"type\": \"address\", \"name\": \"sender\"}, {\"indexed\": false, \"type\": \"address\", \"name\": \"instantiation\"}], \"type\": \"event\", \"name\": \"ContractInstantiation\", \"anonymous\": false}]")
    :keywordize-keys true))

(defn name-or-type [klass inp]
  (let [{:keys [name indexed type]} inp
        idx? (when indexed "indexed")]
    (if (empty? name)
      (span {:class (str klass " type " idx?)} (text type))
      (span {:class (str klass " name " idx?) :title type} (text name)))))

(defn function [f]
  (let [{:keys [name inputs outputs constant payable type]} f
        hint {:title (pr-str f)}
        hint nil]
    (if-not (= "function" type)
      (do (js/console.error "ABI should be a function" f)
          (div hint (text "ABI ERROR")))
      (tr (th (merge hint {:class "name"}) (text name))
          (td (x (partial name-or-type "input") inputs)
              (x (partial name-or-type "return") outputs))))))

(defn event [e]
  (let [{:keys [name inputs anonymous type]} e
        hint {:title (pr-str e)}
        hint nil]
    (if-not (= "event" type)
      (do (js/console.error "ABI should be an event" e)
          (div hint (text "ABI ERROR")))
      (tr (th (merge hint {:class "name"}) (text name))
          (td (x (partial name-or-type "input") inputs))))))

(defn entry [abi]
  (let [{fns :function evs :event} (group-by (comp keyword :type) abi)]
    (div
      {:class "abi"}
      (h4 (text "Functions"))
      (table (x function fns))
      (h4 (text "Events"))
      (table (x event evs)))))
