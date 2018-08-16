(ns dev)

(comment
  (in-ns 'cljs.user)

  (-> "{\"jsonrpc\":\"2.0\",\"method\":\"web3_clientVersion\",\"params\":[],\"id\":67}"
      js/JSON.parse (js->clj :keywordize-keys true))

  (in-ns 'history.viewer)

  (in-ns 'eth.explorer)
  (-> state deref)
  (def contracts (-> state deref :contracts))
  (let [event-types (->> contracts
                         (select [MAP-VALS :jsonInterface ALL
                                  (selected? [:type #(= % "event")])]))
        ev (get event-types 4)]
    (event-desc ev))

  (in-ns 'cljs.dom)
  (h1 "asd")

  #__)
