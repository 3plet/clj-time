(ns clj-time.format-test
  (:refer-clojure :exclude [extend])
  (:use clojure.test
        (clj-time core format)))

(deftest test-formatter
  (let [fmt (formatter "yyyyMMdd")]
    (is (= (date-time 2010 3 11)
           (parse fmt "20100311")))))

(deftest test-parse
  (let [fmt (formatters :date)]
    (is (= (date-time 2010 3 11)
           (parse fmt "2010-03-11"))))
  (let [fmt (formatters :basic-date-time)]
    (is (= (date-time 2010 3 11 17 49 20 881)
           (parse fmt "20100311T174920.881Z")))))

(deftest test-unparse
  (let [fmt (formatters :date)]
    (is (= "2010-03-11"
           (unparse fmt (date-time 2010 3 11)))))
  (let [fmt (formatters :basic-date-time)]
    (is (= "20100311T174920.881Z"
           (unparse fmt (date-time 2010 3 11 17 49 20 881))))))
