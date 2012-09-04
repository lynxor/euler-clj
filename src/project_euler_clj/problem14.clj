(ns project-euler-clj.problem14)

(defn the-seq 
	([n] (the-seq n []))
	([n sq]
		(if (not= 1 n)
			(if (even? n)
				(recur (/ n 2) (conj sq n))
				(recur (+ (* 3 n) 1) (conj sq n)))
			(conj sq 1))))

(defn seq-lengths []
	(map (fn [num] [num (count (the-seq num))]) (range 1 1000001) ))

(defn problem14 []
	(reduce (fn [[max-num max-cnt] [num cnt]] (if (> max-cnt cnt) [max-num max-cnt] [num cnt] )) (seq-lengths)))