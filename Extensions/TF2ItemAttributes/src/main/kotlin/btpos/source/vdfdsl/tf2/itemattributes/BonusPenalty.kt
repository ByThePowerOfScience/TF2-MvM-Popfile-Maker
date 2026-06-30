package btpos.source.vdfdsl.tf2.itemattributes

import btpos.source.vdfdsl.modeling.IKeyValueMap

class BonusPenalty<I, D>(private val increase_attrName: String, private val decrease_attrName: String) {
	context(attrs: btpos.source.vdfdsl.modeling.IKeyValueMap)
	var increase: I?
		get() = attrs.getTyped(increase_attrName)
		set(value) = attrs.setNullable(increase_attrName, value)
	
	context(attrs: btpos.source.vdfdsl.modeling.IKeyValueMap)
	var decrease: D?
		get() = attrs.getTyped(decrease_attrName)
		set(value) = attrs.setNullable(decrease_attrName, value)
}

inline fun <I, D> btpos.source.vdfdsl.tf2.itemattributes.BonusPenalty<I, D>.invoke(configure: btpos.source.vdfdsl.tf2.itemattributes.BonusPenalty<I, D>.() -> Unit) {
    apply(configure)
}

class BonusPenalty_BonusNested<I, D>(val increase: I, private val decrease_attrName: String) {
	context(attrs: btpos.source.vdfdsl.modeling.IKeyValueMap)
	var decrease: D?
		get() = attrs.getTyped(decrease_attrName)
		set(value) = attrs.setNullable(decrease_attrName, value)
}

inline fun <I, D> btpos.source.vdfdsl.tf2.itemattributes.BonusPenalty_BonusNested<I, D>.invoke(configure: btpos.source.vdfdsl.tf2.itemattributes.BonusPenalty_BonusNested<I, D>.() -> Unit) {
	apply(configure)
}


class BonusPenalty_PenaltyNested<I, D>(private val increase_attrName: String, val decrease: D) {
	context(attrs: btpos.source.vdfdsl.modeling.IKeyValueMap)
	var increase: I?
		get() = attrs.getTyped(increase_attrName)
		set(value) = attrs.setNullable(increase_attrName, value)
}

inline fun <I, D> btpos.source.vdfdsl.tf2.itemattributes.BonusPenalty_PenaltyNested<I, D>.invoke(configure: btpos.source.vdfdsl.tf2.itemattributes.BonusPenalty_PenaltyNested<I, D>.() -> Unit) {
	apply(configure)
}


class BonusPenalty_BothNested<I, D>(val increase: I, val decrease: D)

inline fun <I, D> btpos.source.vdfdsl.tf2.itemattributes.BonusPenalty_BothNested<I, D>.invoke(configure: btpos.source.vdfdsl.tf2.itemattributes.BonusPenalty_BothNested<I, D>.() -> Unit) {
	apply(configure)
}