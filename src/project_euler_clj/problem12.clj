(ns project-euler-clj.problem12)
(use 'project-euler-clj.common)


(defn triangle [n]
	(/ (* n (inc n)) 2))



(def tri-nums (map triangle (iterate inc 1)))

(defn problem12 [num-divisors]
	(let [divisor-counts (map (fn [tr] [tr (count (divisors tr))]) tri-nums)]
		(first (drop-while (fn [[tr cnt]] (< cnt num-divisors )) divisor-counts) )))

