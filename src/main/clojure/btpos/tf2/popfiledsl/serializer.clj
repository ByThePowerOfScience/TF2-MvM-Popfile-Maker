(ns btpos.tf2.popfiledsl.serializer
  (:import (btpos.tf2.popfiledsl.serialization IPopFileRepresentable PopFileEntry PopFileMap PopFileQuotedString)))


(defmulti pop-file-serialize (fn [item] (class item)))

; Primitives
(defmethod pop-file-serialize :default [item]
  (str item))

(defmethod pop-file-serialize PopFileQuotedString [^PopFileQuotedString item]
  (str \" (.string item) \"))


(defmethod pop-file-serialize IPopFileRepresentable [^IPopFileRepresentable item]
  (pop-file-serialize (.getPopFileRepr item)))


; Really, everything is just identifier-value pairs, it's just that structs have their own identifiers and values tend not to
(defmethod pop-file-serialize PopFileEntry [^PopFileEntry pair]
  (str (.getKey pair) (if (instance? PopFileMap (.getValue pair)) "\n" " ") (.getValue pair)))

(defmethod pop-file-serialize PopFileMap [^PopFileMap subtree]
  (str
    "{"
    (->> (.getEntries subtree)
         (map pop-file-serialize)
         (str "\n"))
    "\n}"))




