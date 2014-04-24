(ns gae-app-demo.handler
  (:require [compojure.core :refer [defroutes routes]]
            [compojure.handler :as handler]
            [compojure.route :as route]
            [gae-app-demo.routes.home :refer [home-routes]]))

(defn init []
  (println "gae-app-demo is starting"))

(defn destroy []
  (println "gae-app-demo is shutting down"))

(defroutes app-routes
  (route/resources "/")
  (route/not-found "Not Found"))

(def app
  (-> (routes home-routes app-routes)
      (handler/site)))
