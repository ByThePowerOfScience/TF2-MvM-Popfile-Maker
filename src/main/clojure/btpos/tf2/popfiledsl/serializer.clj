(ns btpos.tf2.popfiledsl.serializer
  (:require [clojure.string :as str])
  (:import (btpos.tf2.popfiledsl.serialization IPopFileItem NamedMap PopFileKeyword)
           (java.util Collection Map)))

(comment "Literal strings are quoted, so keywords are the only way to have unquoted strings.")

(defmulti ^String pop-file-serialize (fn [item] (class item)))

(defmethod pop-file-serialize :default [item] (str item))

(defmethod pop-file-serialize String [^String item]
  (str \" item \"))

(defmethod pop-file-serialize PopFileKeyword [^PopFileKeyword item]
  (.getKeyword item))

(defmethod pop-file-serialize IPopFileItem [^IPopFileItem item]
  (pop-file-serialize (.getPopFileRepr item)))

(defmethod pop-file-serialize Collection [^Collection coll]
  (str/join " " (map pop-file-serialize coll)))

(defmethod pop-file-serialize NamedMap [^NamedMap item]
  (let [name (.getName item)
        map (.getMap item)]
    (str name "\n" (pop-file-serialize map))))

(defmethod pop-file-serialize Map [^Map item]
  (str "{"
       (str/join "\n" (map (fn [[k v]] (str (pop-file-serialize k) " " (pop-file-serialize v))) (seq item)))
       "\n}"))



