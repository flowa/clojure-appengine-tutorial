(ns gae-app-demo.routes.home
  (:require [compojure.core :refer [defroutes GET POST]]
            [gae-app-demo.views.layout :as layout]))

(defn form-page []
  (layout/common (layout/registeration-form)))

(defn result-page [{:keys [form-params]}]
  (layout/common (layout/result form-params)))

(defroutes home-routes
  (GET "/" [] (form-page))
  (POST "/" request (result-page request)))
