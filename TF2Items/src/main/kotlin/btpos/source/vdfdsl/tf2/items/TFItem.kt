package btpos.source.vdfdsl.tf2.items

import btpos.source.vdfdsl.backing.VDFKeyValue
import btpos.source.vdfdsl.backing.VDFPrimitive
import btpos.source.vdfdsl.backing.VDFSubtree
import btpos.source.vdfdsl.modeling.IKeyValueMap
import btpos.source.vdfdsl.modeling.KeyValueMapImpl
import btpos.source.vdfdsl.serialization.IVDFRepresentableKeyValue
import btpos.source.vdfdsl.tf2.PopFileDSL
import btpos.source.vdfdsl.tf2.items.weapons.WeaponsAll
import btpos.source.vdfdsl.tf2.items.weapons.WeaponsMelee

@PopFileDSL
open class TFItem<ATTR : Any>(val name: String, val attributes: KeyValueMapImpl? = null, @PublishedApi internal val scopedAttributeFunctions: ATTR)
	: IVDFRepresentableKeyValue
{
	override fun _serializeInto(input: VDFSubtree) {
		input +=
			listOfNotNull(
				VDFKeyValue(VDFPrimitive("Item"), VDFPrimitive (name)),
				VDFKeyValue.orNull(
					VDFPrimitive("ItemAttributes"),
					attributes?._vdfRepr(input)?.withEntry(VDFKeyValue(VDFPrimitive("ItemName"), VDFPrimitive(this.name)))
				)
		)
	}
	
	/**
	 * Create a new instance of this item with the provided attributes added.
	 */
	inline fun withAttributes(attributesScope: context(IKeyValueMap) ATTR.() -> Unit): TFItem<ATTR> {
		val attrs = attributes?.copy() ?: KeyValueMapImpl()
		usingAttributesScope(attrs, attributesScope)
		return this.copy(attributes=attrs)
	}
	
	/**
	 * Create a copy of this item with the provided attributes added.
	 */
	inline operator fun invoke(attributesScope: context(IKeyValueMap) ATTR.() -> Unit) = withAttributes(attributesScope)
	
	/**
	 * Just configure an attributes map in the _context_ of an item's allowed attributes, without creating a new TFItem object for it.
	 *
	 * This is only needed if you're using a template that already has an item set on it, and you just want to configure that item.
	 *
	 * @param configure A block scope to allow you to easily access the attributes defined in the items [ATTR] parameter.
	 */
	inline fun <MAP : IKeyValueMap> usingAttributesScope(map: MAP, configure: context(IKeyValueMap) ATTR.() -> Unit): MAP {
		return map.apply {
			scopedAttributeFunctions.configure()
			this.setNullable("ItemName", this@TFItem.name)
		}
	}
	
	fun copy(name: String = this.name, attributes: KeyValueMapImpl? = this.attributes?.copy()): TFItem<ATTR> {
		return TFItem(name, attributes, this.scopedAttributeFunctions)
	}
	
	companion object {
		@Suppress("RemoveRedundantQualifierName", "RedundantSuppression")
		val WeaponsByClass get() = btpos.source.vdfdsl.tf2.items.weapons.WeaponsByClass
		
		val WeaponsByName get() = WeaponsAll
		
		val MeleeWeapons get() = WeaponsMelee
	}
}

