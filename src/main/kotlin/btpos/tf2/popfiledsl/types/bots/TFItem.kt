package btpos.tf2.popfiledsl.types.bots

import btpos.tf2.popfiledsl.serialization.IPopFileRepresentable
import btpos.tf2.popfiledsl.serialization.PopFileQuotedString

data class TFItem(val name: String, val attributes: ItemAttributeContainer = ItemAttributeContainer(name)) : IPopFileRepresentable<PopFileQuotedString> {
	override val popFileRepr
		get() = PopFileQuotedString(name)
	
	inline fun withAttributes(attributeBuilder: ItemAttributeContainer.() -> Unit): TFItem {
		return TFItem(this.name, ItemAttributeContainer(this.name).apply(attributeBuilder))
	}
	
	inline operator fun invoke(attributeBuilder: AttributeContainer.() -> Unit) = withAttributes(attributeBuilder)
	
	companion object
}

object WeaponAttributes {
	object OnHit {
		context(attr: AttributeContainer)
		var MARK_FOR_DEATH_ON_HIT: Boolean?
			get() = attr.get("mark_for_death")
			set(value) = attr.set("mark for death", value)
		
		context(attr: AttributeContainer)
		var STUN_MIDAIR_ENEMIES: Boolean?
			get() = attr.get("mod stun waist high airborne")
			set(value) = attr.set("mod stun waist high airborne", value)
	}
	
	object Penalties {
		context(attr: AttributeContainer)
		var FIRERATE_PENALTY: Double?
			get() = attr.get("fire rate penalty")
			set(value) = attr.set("fire rate penalty", value)
	}
}