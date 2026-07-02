package btpos.source.vdfdsl.modeling

import btpos.source.vdfdsl.serialization.IVDFRepresentableKeyValue
import btpos.source.vdfdsl.backing.VDFKeyValue
import btpos.source.vdfdsl.backing.VDFPrimitive
import btpos.source.vdfdsl.backing.VDFSubtree
import btpos.source.vdfdsl.serialization.IVDFRepresentable
import btpos.source.vdfdsl.serialization.IVDFRepresentableValue

abstract class SubtreeEntry(val fieldName: String, val isRequired: Boolean) : IVDFRepresentableKeyValue {
	protected fun throwIfRequired() {
		if (isRequired)
			error("Missing required field: $fieldName")
	}
}

// because we serialize all lists as Key Value1 Key Value2,
// properties that allow multiple values are fine to use a list as the entry
class NamedValue<V : Any>(isRequired: Boolean, var key: String, var value: V? = null)
	: SubtreeEntry(key, isRequired)
{
	override fun _serialize(input: VDFSubtree): VDFSubtree {
		val value = value ?: run {
			throwIfRequired()
			return input;
		}
		
		return input + VDFKeyValue(VDFPrimitive(key), IVDFRepresentableValue.serializeDynamic(value))
	}
}

class NamedValueList<V : Any>(isRequired: Boolean, var key: String, val values: MutableList<V> = mutableListOf())
	: SubtreeEntry(key, isRequired)
{
	override fun _serialize(input: VDFSubtree): VDFSubtree {
		if (values.isEmpty()) {
			throwIfRequired()
			return input;
		}
		
		val primKey = VDFPrimitive(key)
		
		return input.withEntries(values.map { VDFKeyValue(primKey, IVDFRepresentableValue.serializeDynamic(it)) })
	}
}

class SelfNamedValue<T : IVDFRepresentableKeyValue>(isRequired: Boolean)
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
 * A list of items that each defines their own key to specify their type, so the parent map can't assign a key to them.
 *
 * All of these values will be placed flatly on the top level of the tree they're nested in.
 */
class SelfNamedValueList<T : IVDFRepresentableKeyValue>(isRequired: Boolean, val innerList: MutableList<T> = mutableListOf())
	: SubtreeEntry("subtrees", isRequired), MutableList<T> by innerList
{
	override fun _serialize(input: VDFSubtree): VDFSubtree {
		if (innerList.isEmpty())
			throwIfRequired()
		
		return innerList.fold(input) { input, value -> value._serialize(input) }
	}
}