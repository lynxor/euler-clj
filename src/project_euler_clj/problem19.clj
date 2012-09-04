(ns project-euler-clj.problem19
	(:use clj-time.core)
	(:use clj-time.format))


(def start-time (date-time 1901 1 1))
(def end-time (date-time 2001 1 1))
(def twentieth-century (interval start-time end-time))
(def myformatter (formatter "yyyy/MM/dd "))

(defn count-sundays [date sundays]
	(if (within? twentieth-century date)
		(if (= 7 (day-of-week date))
			(recur (plus date (months 1)) (conj sundays date))
			(recur (plus date (months 1)) sundays))
		sundays))

(defn problem19 []
	(let [sundays (count-sundays start-time [])
		  numsundays (count sundays)]
		  (println "Number of sundays: " numsundays)
		  ;(println (map #(unparse myformatter %1) sundays))
		  ))