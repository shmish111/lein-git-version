(ns leiningen.test.git-version
  (:require [leiningen.git-version :refer :all]
            [clojure.test :refer :all]
            [midje.sweet :refer :all]))

(deftest git-version-facts
  (facts
   (get-git-version) => "1.0.5"
   (count (get-git-ref)) => 40
   (re-matcher #"commit.*\nAuthor.*\nDate.*" (get-git-last-message)) => truthy))