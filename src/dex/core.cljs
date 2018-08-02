(ns dex.core)

(defrecord Party [nickname address])
(defrecord Amt [amount token])
(defrecord Trade [party buy sell])

(defn new-trade [party buy-amt buy-token sell-amt sell-token]
  (->Trade party
           (->Amt buy-amt buy-token)
           (->Amt sell-amt sell-token)))
