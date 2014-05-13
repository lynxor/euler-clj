(ns project-euler-clj.problem22)

(def sorted-names (sort (.split #"," (slurp "names.txt"))))
(defn number-value [name]
	(+ (reduce (fn [total c] (+ total (- (int c) 64))) 0 name) 60))


(defn calc-values []
	(map (fn [ [ind name] ] 
		( * (inc ind) (number-value name )))
		(map-indexed vector sorted-names)))

(defn problem22 []
	(reduce + (calc-values)))
