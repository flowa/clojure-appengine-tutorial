(ns gae-app-demo.views.layout
  (:require [hiccup.page :refer [html5 include-css]])
  (:require [hiccup.form :refer [form-to submit-button]]))

(defn common [& body]
  (html5
    [:head
     [:title "GAE demo"]]
     (include-css "/css/screen.css")
    [:body body]))

(defn custom-input [type name label placeholder]
  [:div
   [:label label
    [:input {:type type :name name :placeholder placeholder}]]])

(defn registeration-form []
  [:div
   [:h1 "A form for the ages"]
   (form-to [:post "/"]
            (custom-input "text" "first-name" "First name" "First name")
            (custom-input "text" "last-name" "Last name" "Last name")
            (custom-input "text" "email" "Email" "Your email")
            (submit-button "Submit"))])

(defn result [form-params]
  [:div
   [:h1 "Form data sent to the server"]
   (for [[field-name field-value] form-params]
     [:div (str field-name ": " field-value)])])
