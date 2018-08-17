(ns eth.event-test
  (:require [devcards.core :as dc]
            [eth.event])
  (:require-macros
    [cljs.test :refer [is testing]]
    [devcards.core :refer [defcard deftest dom-node]]))

(def mint-if
  {:anonymous false,
   :inputs    [{:indexed true, :name "guy", :type "address"}
               {:indexed false, :name "wad", :type "uint256"}],
   :name      "Mint",
   :type      "event",
   :signature "0x0f6798a560793a54c3bcfe86a93cde1e73087d944c0ea20544137d4121396885"})

(def transfer-if
  {:anonymous false,
   :inputs    [{:indexed true, :name "src", :type "address"}
               {:indexed true, :name "dst", :type "address"}
               {:indexed false, :name "wad", :type "uint256"}],
   :name      "Transfer",
   :type      "event",
   :signature "0xddf252ad1be2c89b69c2b068fc378daa952ba7f163c4a11628f55a4df523b3ef"})

(defcard log-params
  "Log parameters can be either indexed or not indexed.

  The actual values of the indexed parameters go into the topics array
  in the same order as they occur in the log's parameter list.

  The values of non-indexed parameters can be found under the `:data` field")

(deftest decode
  (is (= (eth.event/decode
           {:address          "0x475cda4a73ee3f01748a9d553a8c19ca2853a8aa",
            :transactionHash  "0x93868d03131c5a370f0535033b5d867c2bc3e0d760a6206376b230abba096d46",
            :blockHash        "0xecc749c03f5354099132caf15bb364af163ad0f06487fd1ad22132ca88eac5d7",
            :transactionIndex "0x5",
            :topics           ["0xddf252ad1be2c89b69c2b068fc378daa952ba7f163c4a11628f55a4df523b3ef"
                               "0x00000000000000000000000029a6feab1ff84f69e2b70f7b4aa1149706a35658"
                               "0x000000000000000000000000ebcbdc877c0e07c1a1e1b15e2d75c732e22e546f"],
            :blockNumber      "0x263c41",
            :logIndex         "0x3",
            :removed          false,
            :data             "0x00000000000000000000000000000000000000000000021e19e0c9bab2400000"}
           [{:anonymous false,
             :inputs    [{:indexed true, :name "src", :type "address"}
                         {:indexed true, :name "dst", :type "address"}
                         {:indexed false, :name "wad", :type "uint256"}],
             :name      "Transfer",
             :type      "event",
             :signature "0xddf252ad1be2c89b69c2b068fc378daa952ba7f163c4a11628f55a4df523b3ef"}])
         {:NAME "Transfer"
          :src  "0x00000000000000000000000029a6feab1ff84f69e2b70f7b4aa1149706a35658"
          :dst  "0x000000000000000000000000ebcbdc877c0e07c1a1e1b15e2d75c732e22e546f"
          :wad  "0x00000000000000000000000000000000000000000000021e19e0c9bab2400000"})))

