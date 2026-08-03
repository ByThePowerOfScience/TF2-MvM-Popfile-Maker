package btpos.source.vdfdsl.tf2.items

import btpos.source.vdfdsl.backing.VDFKeyValue
import btpos.source.vdfdsl.backing.VDFPrimitive
import btpos.source.vdfdsl.backing.VDFSubtree
import btpos.source.vdfdsl.serialization.IVDFRepresentableKeyValue
import btpos.source.vdfdsl.tf2.PopFileDSL
import btpos.source.vdfdsl.tf2.itemattributes.AttributeContainerImpl
import btpos.source.vdfdsl.tf2.itemattributes.AttributeContainerSubtreeSerializable
import btpos.source.vdfdsl.tf2.itemattributes.IAttributeContainer
import btpos.source.vdfdsl.tf2.itemattributes.ItemAttributeNamed
import btpos.source.vdfdsl.tf2.items.weapons.Weapons
import btpos.source.vdfdsl.tf2.items.weapons.WeaponsMelee

@PopFileDSL
class TFItem<ATTR : Any>(
	val name: String,
	val attributes: AttributeContainerSubtreeSerializable? = null,
	val scopedAttributeFunctions: ATTR,
	private val conditional: String? = null
) : IVDFRepresentableKeyValue
{
	val namePrimitive = VDFPrimitive(name)
	
	override fun _serializeInto(input: VDFSubtree) {
		input +=
			listOfNotNull(
				VDFKeyValue(VDFPrimitive("Item"), namePrimitive, null),
				VDFKeyValue.orNull(
					VDFPrimitive("ItemAttributes"),
					attributes?._vdfRepr(input)?.withEntry(VDFKeyValue(VDFPrimitive("ItemName"), namePrimitive, null)),
					conditional
				)
		)
	}
	
	/**
	 * Create a new instance of this item with the provided attributes added.
	 */
	inline fun withAttributes(attributesScope: context(IAttributeContainer) ATTR.() -> Unit): TFItem<ATTR> {
		val attrs = attributes?.copy() ?: AttributeContainerSubtreeSerializable()
		configureAttributes(attrs, attributesScope)
		return this.copy(attributes=attrs)
	}
	
	/**
	 * Create a copy of this item with the provided attributes added.
	 */
	inline operator fun invoke(attributesScope: context(IAttributeContainer) ATTR.() -> Unit) = withAttributes(attributesScope)
	
	/**
	 * Just configure an attributes map in the _context_ of an item's allowed attributes, without creating a new TFItem object for it.
	 *
	 * This is only needed if you're using a template that already has an item set on it, and you just want to configure that item.
	 *
	 * @param configure A block scope to allow you to easily access the attributes defined in the items [ATTR] parameter.
	 */
	inline fun <MAP : IAttributeContainer> configureAttributes(map: MAP, configure: context(MAP) ATTR.() -> Unit): MAP {
		return map.apply {
			scopedAttributeFunctions.configure()
			this.set(ATTR_NAME, this@TFItem.name)
		}
	}
	
	/**
	 * Create a new attributes map in the _context_ of an item's allowed attributes, without creating a new TFItem object for it as well.
	 *
	 * This is generally only needed if you're using a template that already has an item set on it, and you just want to configure that item.
	 *
	 * @param configurationScope A block scope to allow you to easily access the attributes that are valid for this item.
	 */
	inline fun configureAttributes(configurationScope: context(AttributeContainerImpl) ATTR.() -> Unit): AttributeContainerImpl {
		return configureAttributes(AttributeContainerImpl(), configurationScope)
	}
	
	fun copy(name: String = this.name, attributes: AttributeContainerSubtreeSerializable? = this.attributes?.copy(), conditional: String? = this.conditional): TFItem<ATTR> {
		return TFItem(name, attributes, this.scopedAttributeFunctions, conditional)
	}
	
	companion object {
		@Suppress("RemoveRedundantQualifierName", "RedundantSuppression")
		val WeaponsByClass get() = btpos.source.vdfdsl.tf2.items.weapons.WeaponsByClass
		
		val WeaponsByName get() = Weapons
		
		val MeleeWeapons get() = WeaponsMelee
		
		val ATTR_NAME = ItemAttributeNamed<String>("ItemName")
	}
}