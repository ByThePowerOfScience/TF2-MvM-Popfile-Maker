package btpos.source.vdfdsl.modeling

import btpos.source.vdfdsl.serialization.IVDFRepresentableKeyValue
import btpos.source.vdfdsl.backing.VDFPrimitive
import btpos.source.vdfdsl.backing.VDFSubtree
import btpos.source.vdfdsl.serialization.IVDFRepresentableValue

abstract class SubtreeEntry(val fieldName: String, val isRequired: Boolean) : IVDFRepresentableKeyValue {
	protected fun throwIfRequired() {
		if (isRequired)
			error("Missing required field: $fieldName")
	}
}

class NamedValue<V : Any>(isRequired: Boolean, var key: String, var value: V?, val serializer: ((V) -> Any)?)
	: SubtreeEntry(key, isRequired)
{
	override fun _serializeInto(input: VDFSubtree) {
		val value = value?.let {
			serializer?.invoke(it) ?: it
		} ?: run {
			throwIfRequired()
			return;
		}
		
		if (value is IVDFRepresentableKeyValue) {
			return value._serializeInto(input)
		}
		
		val dynamic = IVDFRepresentableValue.serializeDynamic(VDFPrimitive(key), value)
		
		return dynamic._serializeInto(input)
	}
}

class SelfNamedValue<T : IVDFRepresentableKeyValue>(isRequired: Boolean)
	: SubtreeEntry("subtree", isRequired)
{
	var item: T? = null
	
	override fun _serializeInto(input: VDFSubtree) {
		return item?._serializeInto(input) ?: run {
			throwIfRequired()
			input
		}
	}
}

/**
 * A list of items that each defines their own key to specify their type, so the parent map can't assign a key to them.
 *
 * All of these values will be placed flatly on the top level of the tree they're nested in.
 */
class SelfNamedValueList<T : IVDFRepresentableKeyValue>(isRequired: Boolean, val innerList: MutableList<T> = mutableListOf())
	: SubtreeEntry("subtrees", isRequired), MutableList<T> by innerList
{
	override fun _serializeInto(input: VDFSubtree) {
		if (innerList.isEmpty())
			throwIfRequired()
		
		innerList.forEach { it._serializeInto(input) }
	}
}