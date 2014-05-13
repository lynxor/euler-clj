(ns project-euler-clj.problem17)
(def separator "")

(def words {1 "one", 2 "two", 3 "three", 4 "four", 5 "five", 6 "six", 7 "seven", 8 "eight", 9 "nine", 10 "ten", 
	11 "eleven", 12 "twelve" 13 "thirteen", 14 "fourteen", 15 "fifteen", 16 "sixteen", 17 "seventeen", 18 "eighteen", 19 "nineteen", 
	20 "twenty", 30 "thirty", 40 "forty", 50 "fifty", 60 "sixty", 70 "seventy", 80 "eighty", 90 "ninety",  
	1000 (str "one" separator "thousand") })



(defn calculate [num words]
	(cond 
		(< num 100) 
			(let [base (* 10 (quot num 10)) 
				  lookup (words num)]
			  (if (nil? lookup)
			  	(str (words base) separator (words (- num base)))
			  	lookup))
		(> num 99)
			(let [hundreds (* 100 (quot num 100))
				  tens (- num hundreds)
				  word-tens (if (> tens 0) (str separator "and" separator (calculate tens words) ) "")]
				(str (words (quot num 100)) separator "hundred" word-tens))))

(defn words-for [num, words]
	(let [lookup (words num)]
		(if (nil? lookup) (calculate num words) lookup)))

(defn all-words [max] 
	(map #(words-for % words) (range 1 (inc max))))

(defn sum-words [words]
	(reduce + (map #(count %) words )))



(defn problem17 []
	(doseq [w (all-words 1000)] (println w))
	;(println (all-words 1000))
	(println (sum-words (all-words 1000))))