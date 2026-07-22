package btpos.source.vdfdsl.modeling

import btpos.source.vdfdsl.backing.VDFPrimitive
import btpos.source.vdfdsl.backing.VDFSubtree
import btpos.source.vdfdsl.serialization.IVDFRepresentableValue
import btpos.source.vdfdsl.serialization.IVDFRepresentableValue_Subtree
import btpos.source.vdfdsl.serialization.codecs.Codec
import kotlin.collections.set

/**
 * Only allows a single instance of each key in the map.
 */
interface IKeyValueMap {
	fun <T> getTyped(key: String): T? {
		return getTyped(key, Codec.identity())
	}
	
	fun setNullable(key: String, value: Any?) {
		return setNullable(key, value, Codec.identity())
	}
	
	operator fun set(key: String, value: Any?) = setNullable(key, value)
	
	operator fun <T> get(key: String) = getTyped<T>(key)
	
	fun <FRONTEND : Any> getTyped(key: String, codec: Codec<FRONTEND, Any>): FRONTEND?
	
	fun <FRONTEND : Any> setNullable(key: String, value: FRONTEND?, codec: Codec<FRONTEND, Any>)
}


open class KeyValueMapImpl(private val _attributes: MutableMap<Any, Any> = mutableMapOf())
	: IVDFRepresentableValue_Subtree, IKeyValueMap
{
	override fun _vdfRepr(parent: VDFSubtree): VDFSubtree {
		return VDFSubtree(parent).apply {
			_attributes.forEach { (k, v) ->
				IVDFRepresentableValue.serializeDynamic(VDFPrimitive(k), v)._serializeInto(this)
			}
		}
	}
	
	@Suppress("UNCHECKED_CAST")
	override fun <T> getTyped(key: String): T? {
		return _attributes[key] as T?
	}
	
	override fun setNullable(key: String, value: Any?) {
		if (value == null)
			_attributes.remove(key)
		else
			_attributes[key] = value
	}
	
	override fun <FRONTEND : Any> getTyped(key: String, codec: Codec<FRONTEND, Any>): FRONTEND? {
		return getTyped<Any>(key)?.let { codec.read(it) }
	}
	
	override fun <FRONTEND : Any> setNullable(key: String, value: FRONTEND?, codec: Codec<FRONTEND, Any>) {
		return setNullable(key, value?.let { codec.write(it) })
	}
	
	fun copy(): KeyValueMapImpl {
		return KeyValueMapImpl(_attributes.toMutableMap())
	}
}
