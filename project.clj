(defproject gae-app-demo "0.1.0-SNAPSHOT"
  :description "Clojure App Engine tutorial source code"
  :url "http://flowa.fi"
  :dependencies [[org.clojure/clojure "1.6.0"]
                 [compojure "1.1.6"]
                 [hiccup "1.0.5"]
                 [ring-server "0.3.1"]]
  :plugins [[lein-ring "0.8.10"]]
   :ring {:handler gae-app-demo.handler/app
          :init gae-app-demo.handler/init
          :destroy gae-app-demo.handler/destroy}
  :aot :all
  :profiles
  {:production
   {:ring
    {:open-browser? false, :stacktraces? false, :auto-reload? false}}
   :dev
   {:dependencies [[ring-mock "0.1.5"] [ring/ring-devel "1.2.1"]]}})
