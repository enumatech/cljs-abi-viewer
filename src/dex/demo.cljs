(ns dex.demo
  (:require [dex.core :as dex :refer [->Party new-trade]]))

(def Alice (->Party "Alice" "0x1111"))
(def Bob (->Party "Bob" "0x2222"))
(def Charlie (->Party "Charlie" "0x3333"))
(def Dave (->Party "Dave" "0x4444"))
(def Eve (->Party "Eve" "0x666"))

(def steps
  [{Alice {:party      Alice
           :balances   {'WETH 100
                        'ASD  123}
           :order-book #{}}}

   {Alice {:party      Alice
           :balances   {'WETH 100
                        'ASD  123}
           :order-book #{(new-trade Bob 4 'ASD 1 'WETH)
                         (new-trade Bob 5 'ASD 1 'WETH)
                         (new-trade Bob 6 'ASD 1 'WETH)}}}

   {Alice {:party      Alice
           :balances   {'WETH 100
                        'ASD  123}
           :order-book #{(new-trade Bob 4 'ASD 1 'WETH)
                         (new-trade Bob 5 'ASD 1 'WETH)
                         (new-trade Bob 6 'ASD 1 'WETH)}}

    Bob   {:party      Bob
           :balances   {'WETH 90
                        'ASD  456}
           :order-book []}

    Charlie {:party      Charlie
           :balances   {'WETH 90
                        'ASD  456}
           :order-book []}}

   {Alice {:party      Alice
           :balances   {'WETH 100
                        'ASD  123}
           :order-book #{(new-trade Bob 4 'ASD 1 'WETH)
                         (new-trade Bob 5 'ASD 1 'WETH)
                         (new-trade Bob 6 'ASD 1 'WETH)}}

    Bob   {:party      Bob
           :balances   {'WETH 90
                        'ASD  456}
           :order-book [(new-trade Alice 2 'WETH 6 'ASD)
                        (new-trade Alice 12 'WETH 16 'ASD)]}}])
