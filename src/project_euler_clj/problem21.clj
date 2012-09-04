(ns project-euler-clj.problem21)
(use 'clojure.set)

(defn proper-divisors [num]
  (filter (fn [pd] (= 0 (mod num pd))) (range 1 num)))

(defn sum-of-proper-divisors [num] (reduce + (proper-divisors num) ))

(defn amicable-pair [num] 
	(let [asum (sum-of-proper-divisors num) 
		  bsum (sum-of-proper-divisors asum)]
		  (if (and (= bsum num) (not= asum bsum))
		  	#{asum bsum}
		  	#{})))

(defn amicables [num max known]
	(if (< num max) 
		(if (contains? known num)
			(recur (inc num) max known)
			(recur (inc num) max (union known (amicable-pair num))))
		known))


(defn problem21 []
	(let [ams (amicables 1 10000 #{})]
  		(println ams)
  		(println (reduce + ams))))