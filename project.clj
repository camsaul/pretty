(defproject pretty "1.0.5"
  :description "A standard protocol for making custom types in Clojure pretty print in the REPL and elsewhere."
  :url "https://github.com/camsaul/pretty"
  :min-lein-version "2.5.0"

  :license {:name "Eclipse Public License"
            :url "https://raw.githubusercontent.com/camsaul/pretty/master/LICENSE"}

  :aliases
  {"test"                      ["with-profile" "+test" "test"]
   "bikeshed"                  ["with-profile" "+bikeshed" "bikeshed" "--max-line-length" "120"]
   "check-namespace-decls"     ["with-profile" "+check-namespace-decls" "check-namespace-decls"]
   "eastwood"                  ["with-profile" "+eastwood" "eastwood"]
   "check-reflection-warnings" ["with-profile" "+reflection-warnings" "check"]
   "docstring-checker"         ["with-profile" "+docstring-checker" "docstring-checker"]
   ;; `lein lint` will run all linters
   "lint"                      ["do" ["eastwood"] ["bikeshed"] ["check-namespace-decls"] ["docstring-checker"]]}

  :dependencies []

  :profiles
  {:dev
   {:dependencies
    [[org.clojure/clojure "1.10.3"]
     [pjstadig/humane-test-output "0.10.0"]]

    :injections
    [(require 'pjstadig.humane-test-output)
     (pjstadig.humane-test-output/activate!)]

    :jvm-opts
    ["-Xverify:none"]}

   :eastwood
   {:plugins
    [[jonase/eastwood "0.3.5" :exclusions [org.clojure/clojure]]]

    :add-linters
    [:unused-private-vars
     :unused-namespaces
     :unused-fn-args
     :unused-locals]

    :exclude-linters
    [:deprecations]}

   :docstring-checker
   {:plugins
    [[docstring-checker "1.0.3"]]

    :docstring-checker
    {:exclude [#"test"]}}

   :bikeshed
   {:plugins
    [[lein-bikeshed "0.5.2"]]}

   :check-namespace-decls
   {:plugins               [[lein-check-namespace-decls "1.0.2"]]
    :source-paths          ["test"]
    :check-namespace-decls {:prefix-rewriting true}}}

  :deploy-repositories
  [["clojars"
    {:url           "https://clojars.org/repo"
     :username      :env/clojars_username
     :password      :env/clojars_password
     :sign-releases false}]])
