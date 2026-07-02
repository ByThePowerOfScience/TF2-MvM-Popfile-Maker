package btpos.source.vdfdsl.tf2.items

import btpos.source.vdfdsl.modeling.IKeyValueMap
import btpos.source.vdfdsl.modeling.KeyValueMapImpl
import btpos.source.vdfdsl.tf2.PopFileDSL
import btpos.source.vdfdsl.serialization.IVDFRepresentableKeyValue
import btpos.source.vdfdsl.backing.VDFKeyValue
import btpos.source.vdfdsl.backing.VDFPrimitive
import btpos.source.vdfdsl.backing.VDFSubtree
import btpos.source.vdfdsl.tf2.items.weapons.WeaponsAll
import btpos.source.vdfdsl.tf2.items.weapons.WeaponsMelee

@PopFileDSL
class TFItem<ATTR>(val name: String, val attributes: KeyValueMapImpl? = null, @PublishedApi internal val scopedAttributeFunctions: ATTR)
	: IVDFRepresentableKeyValue
{
	override fun _serialize(input: VDFSubtree): VDFSubtree {
		return input + listOfNotNull(
			VDFKeyValue(VDFPrimitive("Item"), VDFPrimitive (name)),
			VDFKeyValue.orNull(
				VDFPrimitive("ItemAttributes"),
				attributes?._vdfRepr?.withEntry(VDFKeyValue(VDFPrimitive("ItemName"), VDFPrimitive(this.name)))
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
	
	companion object {
		@Suppress("RemoveRedundantQualifierName")
		val WeaponsByClass get() = btpos.source.vdfdsl.tf2.items.weapons.WeaponsByClass
		
		val WeaponsByName get() = WeaponsAll
		
		val MeleeWeapons get() = WeaponsMelee
	}
}