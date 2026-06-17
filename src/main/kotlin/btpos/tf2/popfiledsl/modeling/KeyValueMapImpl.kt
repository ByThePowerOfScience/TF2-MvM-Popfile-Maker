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
}

class KeyValueMapImpl(private val _attributes: MutableMap<Any, Any> = mutableMapOf())
	: IVDFSerializableValue<VDFSubtree>, IKeyValueMap, MutableMap<Any, Any> by _attributes
{
	override val _vdfRepr: VDFSubtree
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