(ns project-euler-clj.problem12)

(defn triangle [n]
	(/ (* n (inc n)) 2))

(defn divisor? [n d]
	(zero? (mod n d)))

;slow
(defn divisors [num]
	(filter (fn [n] (zero? (mod num n)))
		(range 1 (inc num))))

;MUCH quicker
(defn divisors* 
	([num] (divisors* num 1 [] num))
	([num curr divs stop]
	(if (< curr stop )
		(if (divisor? num curr)
			(recur num (inc curr) (conj divs curr (/ num curr) ) (/ num curr))
			(recur num (inc curr) divs stop))
		divs)))

(def tri-nums (map triangle (iterate inc 1)))

(defn problem12 [num-divisors]
	(let [divisor-counts (map (fn [tr] [tr (count (divisors* tr))]) tri-nums)]
		(first (drop-while (fn [[tr cnt]] (< cnt num-divisors )) divisor-counts) )))

