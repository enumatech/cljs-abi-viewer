(ns dex.demo
  (:require [dex.core :as dex :refer [->Party new-order]]
            [com.rpl.specter :as s
             :refer [NIL->SET VAL END NONE-ELEM NONE
                     keypath subset set-elem]
             :refer-macros [select transform setval]]))

(def Alice (->Party "Alice" "0x1111"))
(def Bob (->Party "Bob" "0x2222"))
(def Charlie (->Party "Charlie" "0x3333"))
(def Dave (->Party "Dave" "0x4444"))
(def Eve (->Party "Eve" "0x666"))

(def step1
  {Alice    {:party      Alice
             :balances   {'WETH 10
                          'ASD  0}
             :order-book #{}}
   :whisper #{}
   Bob      {:party      Alice
             :balances   {'WETH 0
                          'ASD  30}
             :order-book #{}}})

(def alices-order (new-order Alice 2 'WETH 4 'ASD))

(def step2
  (->> step1
       (setval [(keypath Alice) :order-book NONE-ELEM] alices-order)))

(def step3
  (->> step2
       (setval [:whisper NONE-ELEM] alices-order)))

(def step4
  (->> step3
       (setval [(keypath Bob) :order-book NONE-ELEM] alices-order)
       (setval [:whisper (set-elem alices-order)] NONE)))

(def steps
  [step1 step2 step3 step4

   {Alice   {:party      Alice
             :balances   {'WETH 100
                          'ASD  123}
             :order-book #{(new-order Bob 4 'ASD 1 'WETH)
                           (new-order Bob 5 'ASD 1 'WETH)
                           (new-order Bob 6 'ASD 1 'WETH)}}

    Bob     {:party      Bob
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
           :order-book #{(new-order Bob 4 'ASD 1 'WETH)
                         (new-order Bob 5 'ASD 1 'WETH)
                         (new-order Bob 6 'ASD 1 'WETH)}}

    Bob   {:party      Bob
           :balances   {'WETH 90
                        'ASD  456}
           :order-book [(new-order Alice 2 'WETH 6 'ASD)
                        (new-order Alice 12 'WETH 16 'ASD)]}}])
