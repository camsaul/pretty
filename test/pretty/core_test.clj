(ns pretty.core-test
  (:require [clojure.test :refer :all]
            [pretty.core :as pretty]))

(deftest qualify-symbol-for-*ns*-test
  (binding [*ns* (the-ns 'pretty.core-test)]
    (testing "no alias, not referred"
      (is (= 'clojure.pprint/pprint
             (pretty/qualify-symbol-for-*ns* 'clojure.pprint/pprint))))
    (testing "refers should be unqualified"
      (testing "from clojure.core"
        (is (= '+
               (pretty/qualify-symbol-for-*ns* 'clojure.core/+))))
      (is (= 'is
             (pretty/qualify-symbol-for-*ns* 'clojure.test/is))))
    (testing "aliased"
      (is (= 'pretty/pretty
             (pretty/qualify-symbol-for-*ns* 'pretty.core/pretty))))))
