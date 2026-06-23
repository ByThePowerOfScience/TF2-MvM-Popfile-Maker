(ns btpos.tf2.popfiledsl.parsercombinator
  (:import (clojure.lang StringSeq))
  (:refer-clojure :exclude [map empty or partial]))

(defn result [item ^StringSeq rest-of-seq]
  [item rest-of-seq])

(defn partial [reason item ^StringSeq rest-of-seq]
  (result (conj item [[:partial true] [:reason reason]]) rest-of-seq))

(defn partial? [[item, _seq]]
  (:partial item))

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

(defn flatten-partials [partials]
  (reduce
    (fn [acc, el]
      (conj acc (el 0)))
    []
    partials))

(defn or
  "Parser combinator, does a buncha fuckin stuff idfk whatever"
  [& parsers]
  (let [parsers (clojure.core/map chartoliteral parsers)]
    (fn [^StringSeq input]
      (let [postapply (->> (seq parsers) (clojure.core/map #(apply % input)))]
        (set ((if
          (clojure.core/every? :partial postapply)
          flatten-partials
          (filter #(not (:partial %)))) postapply))))))


(defn then
  [& parsers]
  (let [parsers (clojure.core/map chartoliteral parsers)]
    (fn [input]
      (loop [previtems []
             nextseq input
             parsers parsers]
        (if-some [curr_parser (first parsers)]
          (if-some [[ouritem ourrest] (curr_parser nextseq)]
            (recur (conj previtems ouritem) ourrest (rest parsers))
            (partial ::FAIL { :type :list :value previtems } nextseq))
          (result { :type :list :value previtems } nextseq))))))



(defn star [parser]
  (fn [input]
    (loop [currseq input
           curritems []]
      (if-some [[item outiter] (parser currseq)]
        (recur outiter (conj curritems item))
        (result { :type :list :value curritems } currseq))
      )
  ))


(defn map [mapper parser]
  (fn [^StringSeq input]
    (when-some [[item, ^StringSeq seq] (parser input)]
      (result (mapper item) seq))))

(defn plus [parser]
  (map
    #({ :type :list
       :value (let [items (:value %)]
                (vec (cons (items 0) (items 1)))) }) (then parser (star parser))))

(def takewhile
  (fn [charpredicate]                                                ; (Char) -> Boolean
    (fn [^StringSeq input]
      (loop [currseq input
             curritems (clojure.core/empty [])]
        (if-some [currseq (seq currseq)]
          (let [^Character currentchar (first currseq)]
            (if (charpredicate currentchar)
              (recur (rest currseq) (conj curritems currentchar))
              (result { :type :string :value (apply str curritems) } currseq)))
          (partial ::EOF { :type :string :value (apply str curritems) } currseq))))))

(def word (takewhile (fn [^Character c] (Character/isLetterOrDigit (.charValue c)))))

(defn take-until [^Character c] (takewhile #(not (= c %))))