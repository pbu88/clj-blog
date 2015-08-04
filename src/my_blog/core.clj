(ns my-blog.core
  (:require [compojure.core :refer :all]
            [compojure.route :as route]))

(use 'ring.util.response)
(use 'selmer.parser)

(set-resource-path! (clojure.java.io/resource "templates"))

; views
(defn home [request]
  (render-file "index.html" {:nav_active "home"}))

(defn about [request]
  (render-file "about.html" {:nav_active "about"}))

; routes
(defroutes app
  (GET "/" [] home)
  (GET "/about" [] about)
  (route/resources "/")
  (route/not-found "<h1>Page not found</h1>"))
