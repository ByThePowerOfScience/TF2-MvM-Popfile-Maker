package btpos.source.vdfdsl.types.items

import btpos.source.vdfdsl.modeling.IKeyValueMap
import btpos.source.vdfdsl.modeling.KeyValueMapImpl
import btpos.source.vdfdsl.modeling.PopFileDSL
import btpos.source.vdfdsl.serialization.IVDFSerializableKeyValue
import btpos.source.vdfdsl.serialization.VDFKeyValue
import btpos.source.vdfdsl.serialization.VDFStringLiteral
import btpos.source.vdfdsl.serialization.VDFSubtree

@PopFileDSL
class TFItem<ATTR>(val name: String, val attributes: KeyValueMapImpl? = null, @PublishedApi internal val scopedAttributeFunctions: ATTR)
	: IVDFSerializableKeyValue
{
	override fun _serialize(input: VDFSubtree): VDFSubtree {
		return input + listOfNotNull(
			VDFKeyValue("Item", VDFStringLiteral(name)),
			VDFKeyValue.orNull(
				"ItemAttributes",
				attributes?._vdfRepr?.withEntry(VDFKeyValue("ItemName", this.name))
			)
		)
	}
	
	/**
	 * Create a new instance of this item with the provided attributes added.
	 */
	inline fun withAttributes(attributesScope: context(IKeyValueMap) ATTR.() -> Unit): TFItem<ATTR> {
		val attrs = attributes?.copy() ?: KeyValueMapImpl()
		context(attrs) {
			scopedAttributeFunctions.attributesScope() // configures attrs
		}
		return this.copy(attributes=attrs)
	}
	
	/**
	 * Create a new instance of this item with the provided attributes added.
	 */
	inline operator fun invoke(attributesScope: context(IKeyValueMap) ATTR.() -> Unit) = withAttributes(attributesScope)
	
	
	fun copy(name: String = this.name, attributes: KeyValueMapImpl? = this.attributes?.copy()): TFItem<ATTR> {
		return TFItem(name, attributes, this.scopedAttributeFunctions)
	}
	
	companion object
}