KB=/keybase/public/onetom/

time clojure -A:build
cp resources/public/build.html ${KB}/state-channels/index.html
cp resources/public/app.css ${KB}/state-channels/
cp target/public/cljs-out/build-main.js ${KB}/state-channels/
