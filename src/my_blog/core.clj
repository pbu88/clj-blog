(ns my-blog.core
  (:require [compojure.core :refer :all]
            [compojure.route :as route]))

(use 'ring.util.response)
(use 'selmer.parser)

(selmer.parser/set-resource-path! "/Users/pbu/clojure-web/clj-blog/src/my_blog/templates/")
(selmer.parser/cache-off!)

(defn hello [request]
  (render-file "index.html" {}))

(defroutes app
  (GET "/" [] hello)
  (route/resources "/")
  (route/not-found "<h1>Page not found</h1>"))

(defn handler [request]
  (-> (response "Hello World")
      (content-type "text/html")))
