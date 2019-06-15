(ns pretty.core
  "Standard protocol to make it easier to nicely print a custom type in the REPL or elsewhere."
  (:require [clojure.pprint :as pprint])
  (:import [clojure.lang IPersistentMap IRecord]
           java.util.Map))

(defprotocol PrettyPrintable
  "Implmement this protocol to return custom representations of objects when printing them. This only seems to work if
  it's done as part of the type declaration (`defrecord`); it doesn't seem to be respected if you use
  `extend-protocol` for an existing type. Not sure why this is :("
  (pretty [_]
    "Return an appropriate representation of this object to be used when printing it, such as in the REPL or in log
    messages."))

(defmethod print-method pretty.core.PrettyPrintable
  [s writer]
  (print-method (pretty s) writer))

(defmethod pprint/simple-dispatch pretty.core.PrettyPrintable
  [s]
  (pprint/write-out (pretty s)))

(doseq [method [print-method pprint/simple-dispatch]
        tyype  [IRecord Map IPersistentMap]]
  (prefer-method method pretty.core.PrettyPrintable tyype))
