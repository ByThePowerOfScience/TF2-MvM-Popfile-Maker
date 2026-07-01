package btpos.source.vdfdsl.modeling

import btpos.source.vdfdsl.serialization.IVDFSerializableValue
import btpos.source.vdfdsl.serialization.VDFKeyValue
import btpos.source.vdfdsl.serialization.VDFSubtree
import btpos.source.vdfdsl.serialization.codecs.Codec
import kotlin.collections.set

interface IKeyValueMap : MutableMap<Any, Any> {
	fun <T> getTyped(key: Any): T?
	
	fun setNullable(key: Any, value: Any?)
	
	fun <FRONTEND : Any> getTyped(key: Any, codec: Codec<FRONTEND, Any>): FRONTEND?
	
	fun <FRONTEND : Any> setNullable(key: Any, value: FRONTEND?, codec: Codec<FRONTEND, Any>)
}

/**
 * Only allows a single instance of each key in the map.
 */
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
	
	fun copy(): KeyValueMapImpl {
		return KeyValueMapImpl(_attributes.toMutableMap())
	}
}
