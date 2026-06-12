(ns btpos.tf2.popfiledsl.serializer
  (:require [clojure.string :as str])
  (:import (btpos.tf2.popfiledsl.serialization IPopFileSerializable PopFileEntry PopFileMap PopFileStringLiteral)
           (clojure.lang ISeq)
           (java.util Collection)))



(derive Collection ::collection)
(derive ISeq ::collection)

; Serialize some item to a popfile form
(defmulti pop-file-serialize (fn [item] (class item)))

; Different kinds of entries do need to be formatted differently
(defmulti pop-file-serialize-entry (fn [_key value] (type (.getValue value))))



; default, just `toString` it
(defmethod pop-file-serialize :default [item]
  (str item))

; string literals need to be quoted, but any other primitive (including normal strings) can be pasted as-is
(defmethod pop-file-serialize PopFileStringLiteral [^PopFileStringLiteral item]
  (str \" (.string item) \"))

; get the representation from the item
(defmethod pop-file-serialize IPopFileSerializable [^IPopFileSerializable item]
  (pop-file-serialize (.get_popFileRepr item)))

; raw lists should have their elements separated by spaces,
; though I'm wondering if this is necessary since we handle collections through `pop-file-serialize-entry`
; TODO
(defmethod pop-file-serialize Collection [^Collection item]
  (->> item
       (map pop-file-serialize)
       (str/join " ")))



; Really, everything is just identifier-value pairs, it's just that structs have their own identifiers.
(defmethod pop-file-serialize PopFileEntry [^PopFileEntry entry]
  (pop-file-serialize-entry (.getKey entry) (.getValue entry)))

; surround maps' elements with braces
(defmethod pop-file-serialize PopFileMap [^PopFileMap subtree]
  (str
    "{\n"
    (pop-file-serialize (.getEntries subtree))
    "\n}"))



; ===== FORMATTING ENTRIES =====

(defmethod pop-file-serialize-entry PopFileMap [key value]
  (str (pop-file-serialize key) "\n"
       (pop-file-serialize value)))

; Convert a list of [key [value1 value2 value3]] into a [[key value1] [key value2] ...]
(defmethod pop-file-serialize-entry ::collection [key ^Collection value]
  (pop-file-serialize (map #(.PopFileEntry key %) (seq value))))

; If the value isn't a list we need to destructure or a map we need to offset with a newline, just write both normally
(defmethod pop-file-serialize-entry :default [key value]
  (str (pop-file-serialize key) " " (pop-file-serialize value)))


