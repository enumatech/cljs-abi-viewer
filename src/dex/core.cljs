(ns dex.core)

(defrecord Party [nickname address])
(defrecord Amt [amount token])
(defrecord Order [party buy sell])

(defn new-order [party buy-amt buy-token sell-amt sell-token]
  (->Order party
           (->Amt buy-amt buy-token)
           (->Amt sell-amt sell-token)))
