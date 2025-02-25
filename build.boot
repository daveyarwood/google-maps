(set-env!
  :resource-paths #{"src"}
  :dependencies '[[adzerk/bootlaces     "0.2.0" :scope "test"]
                  [adzerk/env           "0.4.0"]
                  [adzerk/cljs-console  "0.1.1"]
                  [cljsjs/google-maps   "3.18-1"]
                  [hoplon               "7.1.0" :scope "provided"]])

(require '[adzerk.bootlaces :refer :all])

(def +version+ "3.18.11")

(bootlaces! +version+)

(task-options!
  push {:repo        "clojars-upload"}
  pom  {:project     'adzerk/google-maps
        :version     +version+
        :description "hoplon google maps component"
        :url         "https://developers.google.com/maps/documentation/javascript/"
        :scm         {:url "https://github.com/hoplon/google-maps"}
        :license     {"" ""}})

(deftask deploy
  []
  (comp (build-jar) (push-release)))
