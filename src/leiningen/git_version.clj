(ns leiningen.git-version
  (:require [leiningen.help]
            [leiningen.jar]
            [leiningen.compile]
            [leiningen.core.main]
            [leiningen.core.project]
            [robert.hooke]
            [leiningen.test]
            [clojure.string :as s])
  (:use
    [clojure.java.shell :only [sh]]))

(defn get-git-version
  []
  (apply str (rest (clojure.string/trim
                     (:out (sh
                             "git" "describe" "--match" "v*.*" "--abbrev=0"))))))

(defn get-git-ref
  []
  (apply str (clojure.string/trim
               (:out (sh
                       "git" "rev-parse" "--verify" "HEAD")))))

(defn get-git-last-message
  []
  (s/replace (apply str (clojure.string/trim
                          (:out (sh
                                  "git" "log" "-1" "HEAD"))))
             #"\"" "'"))

(defn git-version
  "Show project version, as tagged in git."
  ^{:doc "Show git project version"}
  [project & args]
  (println "Version:" (:version project) "\n" (get-git-last-message)))
