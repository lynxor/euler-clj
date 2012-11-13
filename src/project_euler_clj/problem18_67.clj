(ns project-euler-clj.problem18_67)

(def datas (slurp "problem18_data"))
(def topological (seq (.split #"\s" datas )))

; (def layered (map-indexed vector 
; 		(map (fn [row] (map-indexed vector 
; 			(map #(Integer. %) (seq (.split #"\s" row))))) (.split #"\n" datas))))








