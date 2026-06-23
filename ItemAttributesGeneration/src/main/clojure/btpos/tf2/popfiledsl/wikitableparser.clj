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

(def thing "{{Item Attribute|id=1|name=damage penalty|description={{lang|en='''%s1'''% damage penalty|da='''%s1'''% skadestraf|de='''%s1'''% geringerer Schaden|es='''%s1''' % de daño|fi='''%s1'''% vahinkovähennys|fr=Pénalité de dégâts '''%s1'''%|hu='''%s1'''% sebzéscsökkentés|it='''%s1'''% di riduzione dei danni|ja=与ダメージ '''%s1'''%|ko=피해량 '''%s1'''% 감소|nl='''%s1'''% toegebrachte schade|no='''%s1'''% skadestraff|pl='''%s1'''% zadawanych obrażeń|pt=Penalidade de '''%s1'''% de dano|pt-br=Dano causado '''%s1'''% menor|ro='''%s1'''% penalizare de damage|ru=Урон: '''%s1'''%|sv='''%s1'''% mindre skada|tr='''%s1'''% hasar verir|zh-hans=伤害 -'''%s1'''%|zh-hant=傷害值 '''%s1'''%}}|value-type=percentage|class=mult_dmg|effect-type=negative|notes=}}")
(defn parse-table [^String input] ((table) (seq input)))