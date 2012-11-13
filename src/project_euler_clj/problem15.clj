(ns project-euler-clj.problem15)

(defn halfway-points [dim]
	(let [the-range (range (inc dim))]
		(set (map vector the-range (reverse the-range)))))
	
(defn travel [dim [x y :as point] ]
	(let [points (halfway-points dim)]
		(cond (contains? points point ) [point]
			(or (> y dim) (> x dim)) []
			:else (into (travel dim [(inc x) y]) (travel dim [x (inc y)])))))

(defn num-points [points] 
		(map (fn [p] (count (filter #(= p %1) points ))) (set points)))

(defn problem15 [dim]
	(reduce (fn [acc nump] (+ acc (* nump nump))) 0 (num-points (travel dim [0 0]))))



(defn fac [n]
	(if (= n 1)
		1
		(*' n (fac (dec n) ))))

(defn binom [n k]
	(/ (fac n) (*' (fac k) (fac (- n k) ))))

; with binom thingy
(defn problem15* [dim]
	(binom (* 2 dim) dim))