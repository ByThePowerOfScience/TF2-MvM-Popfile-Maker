package btpos.source.vdfdsl.tf2.itemattributes.impl

import btpos.source.vdfdsl.modeling.IKeyValueMap

class BonusPenalty<I, D>(private val increase_attrName: String, private val decrease_attrName: String) {
	context(attrs: IKeyValueMap)
	var bonus: I?
		get() = attrs.getTyped(increase_attrName)
		set(value) = attrs.setNullable(increase_attrName, value)
	
	context(attrs: IKeyValueMap)
	var penalty: D?
		get() = attrs.getTyped(decrease_attrName)
		set(value) = attrs.setNullable(decrease_attrName, value)
}

inline fun <I, D> BonusPenalty<I, D>.invoke(configure: BonusPenalty<I, D>.() -> Unit) {
    apply(configure)
}

class BonusPenalty_BonusNested<I, D>(val bonus: I, private val decrease_attrName: String) {
	context(attrs: IKeyValueMap)
	var penalty: D?
		get() = attrs.getTyped(decrease_attrName)
		set(value) = attrs.setNullable(decrease_attrName, value)
}

inline fun <I, D> BonusPenalty_BonusNested<I, D>.invoke(configure: BonusPenalty_BonusNested<I, D>.() -> Unit) {
	apply(configure)
}


class BonusPenalty_PenaltyNested<I, D>(private val increase_attrName: String, val penalty: D) {
	context(attrs: IKeyValueMap)
	var bonus: I?
		get() = attrs.getTyped(increase_attrName)
		set(value) = attrs.setNullable(increase_attrName, value)
}

inline fun <I, D> BonusPenalty_PenaltyNested<I, D>.invoke(configure: BonusPenalty_PenaltyNested<I, D>.() -> Unit) {
	apply(configure)
}


class BonusPenalty_BothNested<I, D>(val increase: I, val decrease: D)

inline fun <I, D> BonusPenalty_BothNested<I, D>.invoke(configure: BonusPenalty_BothNested<I, D>.() -> Unit) {
	apply(configure)
}