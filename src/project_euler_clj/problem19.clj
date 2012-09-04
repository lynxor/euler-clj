(ns project-euler-clj.problem19
	(:use clj-time.core)
	(:use clj-time.format))


(def start-time (date-time 1901 1 1))
(def end-time (date-time 2001 1 1))
(def twentieth-century (interval start-time end-time))
(def myformatter (formatter "EE MM YYYY  "))

;recursive solution
(defn get-sundays [date sundays]
	(if (within? twentieth-century date)
		(if (= 7 (day-of-week date))
			(recur (plus date (months 1)) (conj sundays date))
			(recur (plus date (months 1)) sundays))
		sundays))

;alternative approach with reduce
(defn get-sundays* []
	(reduce (fn [acc n] 
		(let [date (plus start-time (months n))]
			(if (= 7 (day-of-week date)) (conj acc date) acc ))) 
		[] (range (in-months (interval start-time end-time)))))
			

(defn problem19 []
	(let [sundays (get-sundays*)
		  numsundays (count sundays)]
		  (println "Number of sundays: " numsundays)
		  ;(doseq [s (map #(unparse myformatter %1) sundays)]
		  ;	(println s))
		  ))