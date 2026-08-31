package btpos.source.vdfdsl.modeling

import btpos.source.vdfdsl.serialization.IVDFRepresentableKeyValue
import btpos.source.vdfdsl.backing.VDFPrimitive
import btpos.source.vdfdsl.backing.VDFSubtree
import btpos.source.vdfdsl.serialization.IVDFRepresentableValue
import btpos.source.vdfdsl.util.collectionviews.lenses.ListView

interface SubtreeEntry<T : SubtreeEntry<T>> {
	fun withConditional(conditional: String?): T
}

@JvmRecord
data class NamedValue<V : Any>(val key: String, val value: V, val conditional: String?, val serializer: ((V) -> Any?)?)
	: IVDFRepresentableKeyValue, SubtreeEntry<NamedValue<V>>
{
	override fun _serializeInto(input: VDFSubtree, forcedConditional: String?) {
		val value = if (serializer == null) {
			value
		} else {
			serializer.invoke(value)
				?: return; // allow setting "null" to stop it from being serialized
		}
		
		
		if (value is IVDFRepresentableKeyValue) {
			return value._serializeInto(input, forcedConditional)
		}
		
		val dynamic = IVDFRepresentableValue.serializeDynamic(VDFPrimitive(key), value, forcedConditional ?: conditional)
		
		return dynamic._serializeInto(input, forcedConditional)
	}
	
	override fun withConditional(conditional: String?): NamedValue<V> {
		return this.copy(conditional = conditional)
	}
}

@JvmRecord
data class SelfNamedValue<T : Any>(val item: T, val conditional: String? = null, val transformer: (T) -> IVDFRepresentableKeyValue)
	: IVDFRepresentableKeyValue, SubtreeEntry<SelfNamedValue<T>>
{
	override fun _serializeInto(input: VDFSubtree, forcedConditional: String?) {
		transformer(item)._serializeInto(input, forcedConditional)
	}
	
	override fun withConditional(conditional: String?): SelfNamedValue<T> {
		return this.copy(transformer = { item ->
			IVDFRepresentableKeyValue { parent, forcedCond ->
				transformer(item)._serializeInto(parent, forcedCond ?: conditional)
			}
		})
	}
}

/**
 * A list of items that each defines their own key to specify their type, so the parent map can't assign a key to them.
 *
 * All of these values will be placed flatly on the top level of the tree they're nested in.
 */
data class SelfNamedValueList<T : IVDFRepresentableKeyValue>(val innerList: List<T>, val transformer: (T) -> IVDFRepresentableKeyValue)
	: IVDFRepresentableKeyValue, List<T> by innerList, SubtreeEntry<SelfNamedValueList<T>>
{
	override fun _serializeInto(input: VDFSubtree, forcedConditional: String?) {
		innerList.forEach { transformer(it)._serializeInto(input, forcedConditional) }
	}
	
	override fun withConditional(conditional: String?): SelfNamedValueList<T> {
		return this.copy(transformer = { item ->
			IVDFRepresentableKeyValue { parent, forcedConditional ->
				item._serializeInto(parent, forcedConditional ?: conditional)
			}
		})
	}
	
	
}

@JvmRecord
data class ConditionalValue<T>(val item: T, val conditional: String?)

class ConditionalList<T>(private val backing: List<ConditionalValue<T>>)
	: List<T> by ListView<ConditionalValue<T>, T>(backing, { it.item }, { ConditionalValue(it, null) })
{
	operator fun plus(condValue: ConditionalValue<T>): ConditionalList<T> {
		return ConditionalList(backing + condValue)
	}
}

data class UnserializedValue<T : Any>(val value: T) : IVDFRepresentableKeyValue {
	override fun _serializeInto(input: VDFSubtree, forcedConditional: String?) {}
}