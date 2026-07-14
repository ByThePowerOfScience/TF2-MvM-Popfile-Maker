package btpos.source.vdfdsl.modeling

import btpos.source.vdfdsl.serialization.IVDFRepresentableKeyValue
import btpos.source.vdfdsl.backing.VDFPrimitive
import btpos.source.vdfdsl.backing.VDFSubtree
import btpos.source.vdfdsl.serialization.IVDFRepresentableValue


@JvmRecord
data class NamedValue<V : Any>(val key: String, val value: V, val serializer: ((V) -> Any)?)
	: IVDFRepresentableKeyValue
{
	override fun _serializeInto(input: VDFSubtree) {
		val value = serializer?.invoke(value) ?: value
		
		if (value is IVDFRepresentableKeyValue) {
			return value._serializeInto(input)
		}
		
		val dynamic = IVDFRepresentableValue.serializeDynamic(VDFPrimitive(key), value)
		
		return dynamic._serializeInto(input)
	}
}

@JvmRecord
data class SelfNamedValue<T : IVDFRepresentableKeyValue>(val item: T) : IVDFRepresentableKeyValue {
	override fun _serializeInto(input: VDFSubtree) {
		item._serializeInto(input)
	}
}

/**
 * A list of items that each defines their own key to specify their type, so the parent map can't assign a key to them.
 *
 * All of these values will be placed flatly on the top level of the tree they're nested in.
 */
data class SelfNamedValueList<T : IVDFRepresentableKeyValue>(val innerList: List<T>)
	: IVDFRepresentableKeyValue, List<T> by innerList
{
	override fun _serializeInto(input: VDFSubtree) {
		innerList.forEach { it._serializeInto(input) }
	}
}