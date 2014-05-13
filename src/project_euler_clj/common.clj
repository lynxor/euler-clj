(ns project-euler-clj.common)

(defn divisor? [n d]
	(zero? (mod n d)))

;slow
(defn divisors* [num]
	(filter (fn [n] (zero? (mod num n)))
		(range 1 (inc num))))

;MUCH quicker
(defn divisors 
	([num] (divisors num 1 [] num))
	([num curr divs stop]
	(if (< curr stop )
		(if (divisor? num curr)
			(recur num (inc curr) (conj divs curr (/ num curr) ) (/ num curr))
			(recur num (inc curr) divs stop))
		divs)))

(defn proper-divisors [num]
	(drop-last (apply sorted-set (divisors num))))

(defn in? 
  "true if seq contains elm"
  [seq elm]  
  (some #(= elm %) seq))

(defn sum [s] (reduce + s))