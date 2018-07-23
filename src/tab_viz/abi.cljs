(ns tab-viz.abi
  (:require
    [cljs.dom :refer [log mount $ text elem frag fragment
                      h1 div table tr th td
                      v-array h-array v-map h-map]]))

(def example
  (js->clj
    (js*
      "[{\"inputs\": [{\"type\": \"address\", \"name\": \"\"}], \"constant\": true, \"name\": \"isInstantiation\", \"payable\": false, \"outputs\": [{\"type\": \"bool\", \"name\": \"\"}], \"type\": \"function\"}, {\"inputs\": [{\"type\": \"address[]\", \"name\": \"_owners\"}, {\"type\": \"uint256\", \"name\": \"_required\"}, {\"type\": \"uint256\", \"name\": \"_dailyLimit\"}], \"constant\": false, \"name\": \"create\", \"payable\": false, \"outputs\": [{\"type\": \"address\", \"name\": \"wallet\"}], \"type\": \"function\"}, {\"inputs\": [{\"type\": \"address\", \"name\": \"\"}, {\"type\": \"uint256\", \"name\": \"\"}], \"constant\": true, \"name\": \"instantiations\", \"payable\": false, \"outputs\": [{\"type\": \"address\", \"name\": \"\"}], \"type\": \"function\"}, {\"inputs\": [{\"type\": \"address\", \"name\": \"creator\"}], \"constant\": true, \"name\": \"getInstantiationCount\", \"payable\": false, \"outputs\": [{\"type\": \"uint256\", \"name\": \"\"}], \"type\": \"function\"}, {\"inputs\": [{\"indexed\": false, \"type\": \"address\", \"name\": \"sender\"}, {\"indexed\": false, \"type\": \"address\", \"name\": \"instantiation\"}], \"type\": \"event\", \"name\": \"ContractInstantiation\", \"anonymous\": false}]")
    :keywordize-keys true))

(defn render [abi]
  (v-map abi))
