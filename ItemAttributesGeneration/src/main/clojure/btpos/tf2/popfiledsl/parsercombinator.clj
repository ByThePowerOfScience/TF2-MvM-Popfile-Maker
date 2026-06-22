(ns btpos.tf2.popfiledsl.parsercombinator
  (:import (clojure.lang StringSeq)
           (java.util.regex Matcher)))

(defn result [item ^StringSeq rest-of-seq]
  [item rest-of-seq])



(def empty
  "Matches the empty string."
  (fn [^StringSeq input]
    (result nil input)))

(defn terminal "Matches a character literal. Yields the character matched."
  [c]
  (fn [^StringSeq input]
    (when-some [in (seq input)]
      (when (= c (first in))
        (result { :type :char :value c } (rest in))))))

(def literal terminal)

(def chartoliteral #(if (char? %) (terminal %) %))


(defn or
  "Parser combinator, does a buncha fuckin stuff idfk whatever"
  [& parsers]
  (let [parsers (map chartoliteral parsers)]
    (fn [^StringSeq input]
      (set (->> (seq parsers)
                (map #(apply % input))
                (keep identity))))))


(defn then
  [& parsers]
  (let [parsers (map chartoliteral parsers)]
    (fn [input]
      (reduce
        (fn [[previtems prevrest], curr_parser]
          (if-some [[ouritem ourrest] (curr_parser prevrest)]
            (result (conj previtems ouritem) ourrest)
            (reduced nil)))
        [[] input]
        (seq parsers)))))



(defn star [parser]
  (fn [input]
    (loop [currseq input
           curritems []]
      (if-some [[item outiter] (parser currseq)]
        (recur outiter (conj curritems item))
        (result { :type :list :value curritems } currseq))
      )
  ))

(defn parsermap [mapper parser]
  (fn [^StringSeq input]
    (when-some [[item, ^StringSeq seq] (parser input)]
      (result (mapper item) seq))))

(defn plus [parser]
  (parsermap
    #({ :type :list
       :value (let [items (:value %)]
                (vec (cons (items 0) (items 1)))) }) (then parser (star parser))))

(def takewhile
  (fn [charpredicate]                                                ; (Char) -> Boolean
    (fn [^StringSeq input]
      (loop [currseq input
             curritems (clojure.core/empty [])]
        (when-some [currseq (seq currseq)]
          (let [^Character currentchar (first currseq)]
            (if (charpredicate currentchar)
              (recur (rest currseq) (conj curritems currentchar))
              (result { :type :string :value (apply str curritems) } currseq))))))))

(def word (takewhile #(Character/isLetterOrDigit (.charValue %))))

(defn take-until [^Character c] (takewhile #(not (= c %))))
