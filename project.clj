(defproject my-blog "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.6.0"]
                 [ring "1.4.0-RC2"]
                 [selmer "0.8.2"]
                 [compojure "1.3.4"]]
  :plugins [[lein-ring "0.9.6"]]
  :ring {:handler my-blog.core/app})
