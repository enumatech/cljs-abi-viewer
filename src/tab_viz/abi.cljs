(ns tab-viz.abi
  (:require
    [cljs.dom :refer [log mount $ text frag fragment x
                      h1 div span table tr th td
                      v-array h-array v-map h-map]]))

(def example
  (js->clj
    (js*
      "[{\"inputs\": [{\"type\": \"address\", \"name\": \"\"}], \"constant\": true, \"name\": \"isInstantiation\", \"payable\": false, \"outputs\": [{\"type\": \"bool\", \"name\": \"\"}], \"type\": \"function\"}, {\"inputs\": [{\"type\": \"address[]\", \"name\": \"_owners\"}, {\"type\": \"uint256\", \"name\": \"_required\"}, {\"type\": \"uint256\", \"name\": \"_dailyLimit\"}], \"constant\": false, \"name\": \"create\", \"payable\": false, \"outputs\": [{\"type\": \"address\", \"name\": \"wallet\"}], \"type\": \"function\"}, {\"inputs\": [{\"type\": \"address\", \"name\": \"\"}, {\"type\": \"uint256\", \"name\": \"\"}], \"constant\": true, \"name\": \"instantiations\", \"payable\": false, \"outputs\": [{\"type\": \"address\", \"name\": \"\"}], \"type\": \"function\"}, {\"inputs\": [{\"type\": \"address\", \"name\": \"creator\"}], \"constant\": true, \"name\": \"getInstantiationCount\", \"payable\": false, \"outputs\": [{\"type\": \"uint256\", \"name\": \"\"}], \"type\": \"function\"}, {\"inputs\": [{\"indexed\": false, \"type\": \"address\", \"name\": \"sender\"}, {\"indexed\": false, \"type\": \"address\", \"name\": \"instantiation\"}], \"type\": \"event\", \"name\": \"ContractInstantiation\", \"anonymous\": false}]")
    :keywordize-keys true))

(defn name-or-type [inp]
  (let [{:keys [name indexed type]} inp]
    (if (empty? name)
      (span {:class "type"} (text type))
      (span {:class "name" :title type} (text name)))))

(defn function [f]
  (let [{:keys [name inputs outputs constant payable type]} f
        hint {:title (pr-str f)}]
    (if-not (= "function" type)
      (do (js/console.error "ABI should be a function" f)
          (div hint (text "ABI ERROR")))
      (tr (th hint (text name))
          (x (comp td name-or-type) inputs)
          (x (comp (partial td {:class "return"}) name-or-type) outputs)))))

(defn event [abi]
  (let [{:keys [name inputs anonymous type]} abi
        hint {:title (pr-str abi)}]
    (if-not (= "event" type)
      (do (js/console.error "ABI should be an event" abi)
          (div hint (text "ABI ERROR")))
      (tr (th hint (text name))
          (x (comp td name-or-type) inputs)))))

(defn entry [abi]
  (let [fns-evts (group-by (comp keyword :type) abi)]
    (table
      {:class "abi"}
      (td (text "Functions"))
      (x function (:function fns-evts))
      (td (text "Events"))
      (x event (:event fns-evts)))))
