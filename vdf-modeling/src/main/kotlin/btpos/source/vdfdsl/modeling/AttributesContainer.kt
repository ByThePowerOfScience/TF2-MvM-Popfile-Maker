package btpos.source.vdfdsl.modeling

import btpos.source.vdfdsl.backing.VDFPrimitive
import btpos.source.vdfdsl.backing.VDFSubtree
import btpos.source.vdfdsl.serialization.IVDFRepresentableValue
import btpos.source.vdfdsl.serialization.IVDFRepresentableValue_Subtree
import btpos.source.vdfdsl.serialization.codecs.Codec
import kotlin.collections.set
import kotlin.collections.toMutableMap

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


open class AttributesContainer(
	/**
	 * Map of attribute string to (value, value_serializer)
	 */
	private val _attributes: MutableMap<Any, Pair<Any, (Any) -> Any>> = mutableMapOf()
)
	: IVDFRepresentableValue_Subtree, IKeyValueMap
{
	override fun _vdfRepr(parent: VDFSubtree): VDFSubtree {
		return VDFSubtree(parent).apply {
			_attributes.forEach { (k, v) ->
				IVDFRepresentableValue.serializeDynamic(VDFPrimitive(k), v.second(v.first))._serializeInto(this)
			}
		}
	}
	
	@Suppress("UNCHECKED_CAST")
	override fun <T> getTyped(key: String): T? {
		return _attributes[key]?.second as T?
	}
	
	override fun setNullable(key: String, value: Any?) {
		setNullable(key, value, Codec.identity())
	}
	
	override fun <FRONTEND : Any> getTyped(key: String, codec: Codec<FRONTEND, Any>): FRONTEND? {
		return getTyped(key)
	}
	
	override fun <FRONTEND : Any> setNullable(key: String, value: FRONTEND?, codec: Codec<FRONTEND, Any>) {
		if (value == null)
			_attributes.remove(key)
		else
			_attributes[key] = value to (codec::write as (Any) -> Any)
	}
	
	fun copy(): AttributesContainer {
		return AttributesContainer(_attributes.toMutableMap())
	}
}
