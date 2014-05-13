(ns project-euler-clj.problem24)

(defn without [l v] (filter #(not (= % v)) l ))

(defn combos [l, r] 
	(cond (empty? l) r
		  :else (map #(combos (without l %) (conj r %) ) l )))

(defn as-number [l]
	(Float. (clojure.string/join "" (map str l))))

(defn problem24 [nums, n]
	(nth (sort (map as-number (partition (count nums) (flatten (combos nums []))))) n))



(println (problem24 [0 1 2 3 4 5 6 7 8 9] 1000000))
