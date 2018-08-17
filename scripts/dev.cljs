(ns dev)

(comment
  (in-ns 'cljs.user)

  (-> "{\"jsonrpc\":\"2.0\",\"method\":\"web3_clientVersion\",\"params\":[],\"id\":67}"
      js/JSON.parse (js->clj :keywordize-keys true))

  (in-ns 'history.viewer)

  (in-ns 'eth.explorer)
  (-> state deref)
  (def contracts (-> state deref :contracts))

  ; Events with more than one non-indexed inputs
  (->> oax :jsonInterface
       (select [ALL (selected? [:type (pred= "event")])
                (subselect #(->> % :inputs
                                 (filter (complement :indexed))
                                 count (< 1)))]))

  (in-ns 'cljs.dom)
  (h1 "asd")

  #__)
