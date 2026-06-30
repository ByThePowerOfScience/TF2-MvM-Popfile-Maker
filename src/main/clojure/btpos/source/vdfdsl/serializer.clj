(ns btpos.source.vdfdsl.serializer
  (:require [clojure.string :as str])
  (:import (btpos.source.vdfdsl.serialization VDFKeyValue VDFSubtree VDFStringLiteral)
           (clojure.lang ISeq)
           (java.util Collection)))

; By the time we get here, EVERYTHING should be a serializable representation.
(derive Collection ::collection)
(derive ISeq ::collection)


; Different kinds of entries do need to be formatted differently
(defmulti pop-file-serialize-keyvalue (fn [_key value] (type (.getValue value))))

; Serialize some item to a popfile form
(defmulti pop-file-serialize-key-or-value (fn [item] (class item)))




; This should ONLY be called on the top-level. Anywhere else, this is an error...
(defmethod pop-file-serialize-key-or-value VDFKeyValue [^VDFKeyValue entry]
  (pop-file-serialize-keyvalue (.getKey entry) (.getValue entry)))


; ===== FORMATTING ENTRIES =====

; If the value is a Map, add a newline between the key and the value
(defmethod pop-file-serialize-keyvalue VDFSubtree [key value]
  (str (pop-file-serialize-key-or-value key) "\n"
       (pop-file-serialize-key-or-value value)))

; If the value isn't a map we need to offset with a newline, just write both normally
(defmethod pop-file-serialize-keyvalue :default [key value]
  (str (pop-file-serialize-key-or-value key) " " (pop-file-serialize-key-or-value value)))




; default, just `toString` it
(defmethod pop-file-serialize-key-or-value :default [item]
  (str item))

; I swear I saw this done once, but this might be an error.
(defmethod pop-file-serialize-key-or-value ::collection [item]
  (str/join " " (seq item)))

; string literals need to be quoted, but any other primitive (including normal strings) can be pasted as-is
(defmethod pop-file-serialize-key-or-value VDFStringLiteral [^VDFStringLiteral item]
  (str \" (.string item) \"))


; surround subtrees' elements with braces
(defmethod pop-file-serialize-key-or-value VDFSubtree [^VDFSubtree subtree]
  (str
    "{\n"
    (str/join "\n" (map pop-file-serialize-keyvalue (.getEntries subtree)))
    "\n}"))





