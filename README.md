[![Downloads](https://versions.deps.co/camsaul/pretty/downloads.svg)](https://versions.deps.co/camsaul/pretty)
[![Dependencies Status](https://versions.deps.co/camsaul/pretty/status.svg)](https://versions.deps.co/camsaul/pretty)
[![Circle CI](https://circleci.com/gh/camsaul/pretty.svg?style=svg)](https://circleci.com/gh/camsaul/pretty)
[![License](https://img.shields.io/badge/license-Eclipse%20Public%20License-blue.svg)](https://raw.githubusercontent.com/camsaul/pretty/master/LICENSE)
[![cljdoc badge](https://cljdoc.org/badge/camsaul/pretty)](https://cljdoc.org/d/camsaul/pretty/CURRENT)

[![Clojars Project](https://clojars.org/camsaul/pretty/latest-version.svg)](http://clojars.org/camsaul/pretty)

A standard protocol for making custom types in Clojure pretty print in the REPL and elsewhere.

```clj
(defrecord MyInt [i]
  PrettyPrintable
  (pretty [_] (list 'my-int i)))

(MyInt. 100)
;; -> (my-int 100)
```
