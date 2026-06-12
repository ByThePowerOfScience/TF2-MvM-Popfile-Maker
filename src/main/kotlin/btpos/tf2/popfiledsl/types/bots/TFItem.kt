package btpos.tf2.popfiledsl.types.bots

import btpos.tf2.popfiledsl.attributes.ItemAttributesContainer
import btpos.tf2.popfiledsl.modeling.KeyValueMapImpl
import btpos.tf2.popfiledsl.serialization.IPopFileSerializable
import btpos.tf2.popfiledsl.serialization.PopFileEntry
import btpos.tf2.popfiledsl.serialization.PopFileStringLiteral

class TFItem(val name: String, val attributes: ItemAttributesContainer? = null)
	: IPopFileSerializable<Iterable<PopFileEntry>>
{
	override val _popFileRepr
		get() = listOfNotNull(
			PopFileEntry("Item", PopFileStringLiteral(name)),
			PopFileEntry.orNull(
				"ItemAttributes",
				attributes?._popFileRepr?.withEntry(PopFileEntry("ItemName", this.name))
			)
		)
	
	inline fun withAttributes(attributeBuilder: ItemAttributesContainer.() -> Unit): TFItem {
		return TFItem(this.name, ItemAttributesContainer().apply(attributeBuilder))
	}
	
	inline operator fun invoke(attributeBuilder: ItemAttributesContainer.() -> Unit) = withAttributes(attributeBuilder)
	
	companion object
}

