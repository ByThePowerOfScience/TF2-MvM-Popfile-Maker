package btpos.source.vdfdsl.modeling

import btpos.source.vdfdsl.serialization.IVDFSerializableKeyValue
import btpos.source.vdfdsl.serialization.VDFKeyValue
import btpos.source.vdfdsl.serialization.VDFSubtree

abstract class SubtreeEntry(val fieldName: String, val isRequired: Boolean) : IVDFSerializableKeyValue {
	protected fun throwIfRequired() {
		if (isRequired)
			error("Missing required field: $fieldName")
	}
}

// because we serialize all lists as Key Value1 Key Value2,
// properties that allow multiple values are fine to use a list as the entry
class NamedValue<K : Any, V : Any>(isRequired: Boolean, var key: K, var value: V? = null,)
	: SubtreeEntry(key.toString(), isRequired)
{
	override fun _serialize(input: VDFSubtree): VDFSubtree {
		val value = value ?: run {
			throwIfRequired()
			return input;
		}
		
		return input + VDFKeyValue(key, value)
	}
}

class SelfNamedValue<T : IVDFSerializableKeyValue>(isRequired: Boolean)
	: SubtreeEntry("subtree", isRequired)
{
	var item: T? = null
	
	override fun _serialize(input: VDFSubtree): VDFSubtree {
		return item?._serialize(input) ?: run {
			throwIfRequired()
			input
		}
	}
}

/**
 * A list of items that each defines their own key to specify their type, so the parent map can't assign a key to them
 */
class SelfNamedValueList<T : IVDFSerializableKeyValue>(isRequired: Boolean, val innerList: MutableList<T> = mutableListOf())
	: SubtreeEntry("subtrees", isRequired), MutableList<T> by innerList
{
	override fun _serialize(input: VDFSubtree): VDFSubtree {
		if (innerList.isEmpty())
			throwIfRequired()
		
		return innerList.fold(input) { input, value -> value._serialize(input) }
	}
}