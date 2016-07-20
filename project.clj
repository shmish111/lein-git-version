(defproject shmish111/lein-git-version "1.0.13"
  :description "Use git for project versions"
  :url "https://github.com/shmish111/lein-git-version"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :eval-in-leiningen true

  :pedantic? :abort

  :plugins [[lein-cljfmt "0.3.0"]
            [lein-midje "2.0.0-SNAPSHOT"]
            [lein-ancient "0.6.7"]]
  :profiles {:dev {:dependencies [[midje "1.8.3"]]}})
