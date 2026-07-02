package btpos.source.vdfdsl.modeling

import btpos.source.vdfdsl.serialization.IVDFRepresentableValue
import btpos.source.vdfdsl.backing.VDFKeyValue
import btpos.source.vdfdsl.backing.VDFPrimitive
import btpos.source.vdfdsl.backing.VDFSubtree
import btpos.source.vdfdsl.serialization.IVDFRepresentableValue.Companion.serializeDynamic
import btpos.source.vdfdsl.serialization.codecs.Codec
import kotlin.collections.set

/**
 * Only allows a single instance of each key in the map.
 */
interface IKeyValueMap {
	fun <T> getTyped(key: Any): T?
	
	fun setNullable(key: Any, value: Any?)
	
	operator fun set(key: Any, value: Any?) = setNullable(key, value)
	
	operator fun <T> get(key: Any) = getTyped<T>(key)
	
	fun <FRONTEND : Any> getTyped(key: Any, codec: Codec<FRONTEND, Any>): FRONTEND?
	
	fun <FRONTEND : Any> setNullable(key: Any, value: FRONTEND?, codec: Codec<FRONTEND, Any>)
}


class KeyValueMapImpl(private val _attributes: MutableMap<Any, Any> = mutableMapOf())
	: IVDFRepresentableValue<VDFSubtree>, IKeyValueMap
{
	override val _vdfRepr
		get() = VDFSubtree(_attributes.map { (k, v) ->
			VDFKeyValue(serializeDynamic(k), serializeDynamic(v))
		})
	
	@Suppress("UNCHECKED_CAST")
	override fun <T> getTyped(key: Any): T? {
		return _attributes[key] as T?
	}
	
	override fun setNullable(key: Any, value: Any?) {
		if (value == null)
			_attributes.remove(key)
		else
			_attributes[key] = value
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
