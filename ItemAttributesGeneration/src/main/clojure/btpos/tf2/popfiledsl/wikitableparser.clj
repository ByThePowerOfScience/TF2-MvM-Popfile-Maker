(ns btpos.tf2.popfiledsl.wikitableparser
  (:require [btpos.tf2.popfiledsl.parsercombinator :as p]))

(def double-open-bracket (p/then (p/terminal \{) (p/terminal \{)))
(def double-close-bracket (p/then (p/terminal \}) (p/terminal \})))

; T -> {{ K ("|" K V)* }}
; K -> \\w+
; V -> "=" (V1 | T)
; V1 -> [^|]+

(defn table [])

(def V1
  (let [anythingButLine (p/take-until \|)]
    (p/plus anythingButLine)))

(def V
  (p/then
    (p/literal \=)
    (p/or
      V1
      (table))))

(def K p/word)

(defn table []
  (p/then
    double-open-bracket
    K
    (p/star
      (p/then
        (p/literal \|)
        K
        V))
    double-close-bracket))

