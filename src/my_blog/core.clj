(ns my-blog.core
  (:require [compojure.core :refer :all]
            [compojure.route :as route]))

(use 'ring.util.response)
(use 'selmer.parser)

; views
(defn home [request]
  (render-file "templates/index.html" {:nav_active "home"}))

(defn about [request]
  (render-file "templates/about.html" {:nav_active "about"}))

; routes
(defroutes app
  (GET "/" [] home)
  (GET "/about" [] about)
  (route/resources "/")
  (route/not-found "<h1>Page not found</h1>"))
