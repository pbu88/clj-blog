(ns my-blog.core
  (:require [compojure.core :refer :all]
            [compojure.route :as route]))

(use 'ring.util.response)
(use 'selmer.parser)

; util functions
(defn path-join [path1 path2]
  (str (java.nio.file.Paths/get path1 (into-array String [path2]))))

; root of the project source
(def ROOT 
  (.getCanonicalPath (clojure.java.io/file ".")))
; set templates folder
(selmer.parser/set-resource-path! 
  (path-join ROOT "src/my_blog/templates/"))
; turns off template cache for development
(selmer.parser/cache-off!)

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
