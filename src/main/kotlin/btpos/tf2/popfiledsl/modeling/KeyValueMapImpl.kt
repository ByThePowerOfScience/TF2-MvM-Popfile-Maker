package btpos.tf2.popfiledsl.modeling

import btpos.tf2.popfiledsl.serialization.IVDFSerializableValue
import btpos.tf2.popfiledsl.serialization.VDFKeyValue
import btpos.tf2.popfiledsl.serialization.VDFSubtree
import btpos.tf2.popfiledsl.serialization.codecs.Codec
import kotlin.collections.set
import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

interface IKeyValueMap : MutableMap<Any, Any> {
	fun <T> getTyped(key: Any): T?
	
	fun setNullable(key: Any, value: Any?)
	
	fun <FRONTEND : Any> getTyped(key: Any, codec: Codec<FRONTEND, Any>): FRONTEND?
	
	fun <FRONTEND : Any> setNullable(key: Any, value: FRONTEND?, codec: Codec<FRONTEND, Any>)
}

class KeyValueMapImpl(private val _attributes: MutableMap<Any, Any> = mutableMapOf())
	: IVDFSerializableValue<VDFSubtree>, IKeyValueMap, MutableMap<Any, Any> by _attributes
{
	override val _vdfRepr
		get() = VDFSubtree(_attributes.map { (k, v) -> VDFKeyValue(k, v) })
	
	override fun <T> getTyped(key: Any): T? {
		return _attributes[key] as T?
	}
	
	override fun setNullable(key: Any, value: Any?) {
		if (value == null)
			remove(key)
		else
			this[key] = value
	}
	
	override fun <FRONTEND : Any> getTyped(key: Any, codec: Codec<FRONTEND, Any>): FRONTEND? {
		return getTyped<Any>(key)?.let { codec.read(it) }
	}
	
	override fun <FRONTEND : Any> setNullable(key: Any, value: FRONTEND?, codec: Codec<FRONTEND, Any>) {
		return setNullable(key, value?.let { codec.write(it) })
	}
}

fun <T : Any> IKeyValueMap.delegate(key: Any) = object : ReadWriteProperty<Any?, T?> {
	override fun getValue(thisRef: Any?, property: KProperty<*>): T? {
		return this@delegate.getTyped(key)
	}
	
	override fun setValue(thisRef: Any?, property: KProperty<*>, value: T?) {
		this@delegate.setNullable(key, value)
	}
}

fun <T : Any, SERIALIZED : Any> IKeyValueMap.delegate(key: Any, codec: Codec<T, SERIALIZED>) = object : ReadWriteProperty<Any?, T?> {
	override fun getValue(thisRef: Any?, property: KProperty<*>): T? {
		return this@delegate.getTyped<SERIALIZED>(key)?.let { codec.read(it) }
	}
	
	override fun setValue(thisRef: Any?, property: KProperty<*>, value: T?) {
		this@delegate.setNullable(key, value?.let { codec.write(it) })
	}
}


class BonusPenalty<I, D>(private val increase_attrName: String, private val decrease_attrName: String) {
	context(attrs: IKeyValueMap)
	var increase: I?
		get() = attrs.getTyped(increase_attrName)
		set(value) = attrs.setNullable(increase_attrName, value)
	
	context(attrs: IKeyValueMap)
	var decrease: D?
		get() = attrs.getTyped(decrease_attrName)
		set(value) = attrs.setNullable(decrease_attrName, value)
}

inline fun <I, D> BonusPenalty<I, D>.invoke(configure: BonusPenalty<I, D>.() -> Unit) {
    apply(configure)
}

class BonusPenalty_BonusNested<I, D>(val increase: I, private val decrease_attrName: String) {
	context(attrs: IKeyValueMap)
	var decrease: D?
		get() = attrs.getTyped(decrease_attrName)
		set(value) = attrs.setNullable(decrease_attrName, value)
}

inline fun <I, D> BonusPenalty_BonusNested<I, D>.invoke(configure: BonusPenalty_BonusNested<I, D>.() -> Unit) {
	apply(configure)
}


class BonusPenalty_PenaltyNested<I, D>(private val increase_attrName: String, val decrease: D) {
	context(attrs: IKeyValueMap)
	var increase: I?
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


open class VisHidden<VIS : Any, HIDDEN : Any>(private val visible_attrName: String, private val hidden_attrName: String, private val visibleCodec: Codec<VIS, Any> = Codec.identity(), private val hiddenCodec: Codec<HIDDEN, Any> = Codec.identity()) {
	context(attrs: IKeyValueMap)
	var visible: VIS?
	    get() = attrs.getTyped(visible_attrName, visibleCodec)
	    set(value) = attrs.setNullable(visible_attrName, value, visibleCodec)
	
	context(attrs: IKeyValueMap)
	var hidden: HIDDEN?
	    get() = attrs.getTyped(hidden_attrName, hiddenCodec)
	    set(value) = attrs.setNullable(hidden_attrName, value, hiddenCodec)
}
