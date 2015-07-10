(use 'ring.util.response)
(use 'selmer.parser)

(ns my-blog.core
  (:require [compojure.core :refer :all]
            [compojure.route :as route]))

; root of the project source
(def ROOT 
  (.getCanonicalPath (clojure.java.io/file ".")))
; set templates folder
(selmer.parser/set-resource-path! 
  (clojure.string/join "/" [ROOT "src/my_blog/templates/"]))
; turns off template cache for development
(selmer.parser/cache-off!)

; routes
(defroutes app
  (GET "/" [] home)
  (route/resources "/")
  (route/not-found "<h1>Page not found</h1>"))

; views
(defn home [request]
  (render-file "index.html" {}))
