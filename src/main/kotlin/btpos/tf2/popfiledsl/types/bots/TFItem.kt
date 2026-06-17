package btpos.tf2.popfiledsl.types.bots

import btpos.tf2.popfiledsl.attributes.ItemAttributesContainer
import btpos.tf2.popfiledsl.serialization.IVDFSerializableKeyValue
import btpos.tf2.popfiledsl.serialization.VDFKeyValue
import btpos.tf2.popfiledsl.serialization.VDFSubtree
import btpos.tf2.popfiledsl.serialization.VDFStringLiteral

class TFItem(val name: String, val attributes: ItemAttributesContainer? = null)
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
	
	inline fun withAttributes(attributeBuilder: ItemAttributesContainer.() -> Unit): TFItem {
		return TFItem(this.name, ItemAttributesContainer().apply(attributeBuilder))
	}
	
	inline operator fun invoke(attributeBuilder: ItemAttributesContainer.() -> Unit) = withAttributes(attributeBuilder)
	
	companion object
}

