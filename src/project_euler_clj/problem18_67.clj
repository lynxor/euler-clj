(ns project-euler-clj.problem18_67)

(def datas (slurp "../../problem67_data"))
(def layered (seq (map (fn [rstr] (map #(Integer. %) (seq (.split #"\s" rstr)))) (seq (.split #"\n" datas )))))

(defn calc-row [row row-num parent-row]
	(map (fn [col-num] 
		(let [col (nth row col-num)]
			(cond (= col-num 0) (+ col (nth parent-row col-num))
				  (= col-num (dec (count row))) (+ col (nth parent-row (dec col-num)))
				  :else (let [lparent (nth parent-row (dec col-num))
				  			  rparent (nth parent-row col-num)]
				  			  (+ col (max lparent rparent)))))) (range 0 (inc row-num)) ))

(defn calc [row parent-row]
	(let [row-num (dec (count row))
	  num-rows (count layered)
	  result-row (calc-row row row-num parent-row)]
	  (if (< row-num (dec num-rows))
  		(recur (nth layered (inc row-num)) result-row )
	  	result-row)))

(defn problem [] 
	(apply max (calc (nth layered 0) [0])))

; (println (nth layered 0))
(println (problem))



