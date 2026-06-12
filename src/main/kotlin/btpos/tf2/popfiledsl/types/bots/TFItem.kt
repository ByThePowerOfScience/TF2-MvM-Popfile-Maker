package btpos.tf2.popfiledsl.types.bots

import btpos.tf2.popfiledsl.serialization.IPopFileSerializable
import btpos.tf2.popfiledsl.serialization.PopFileEntry
import btpos.tf2.popfiledsl.serialization.PopFileStringLiteral

data class TFItem(val name: String, val attributes: ItemAttributeContainer = ItemAttributeContainer(name))
	: IPopFileSerializable<Iterable<PopFileEntry>>
{
	override val _popFileRepr
		get() = listOf(
			PopFileEntry("Item", PopFileStringLiteral(name)),
			attributes._popFileRepr
		)
	
	inline fun withAttributes(attributeBuilder: ItemAttributeContainer.() -> Unit): TFItem {
		return TFItem(this.name, ItemAttributeContainer(this.name).apply(attributeBuilder))
	}
	
	inline operator fun invoke(attributeBuilder: AttributeContainer.() -> Unit) = withAttributes(attributeBuilder)
	
	companion object
}

object WeaponAttributes {
	object OnHitFoe {
		// I use context parameters so you can reference them as a namespaced `OnHitFoe.MARK_FOR_DEATH = true`
		// instead of an un-namepaced "this.MARK_FOR_DEATH = true" where everything from every category is visible at once
		context(attr: AttributeContainer)
		var MARK_FOR_DEATH: Boolean?
			get() = attr.get("mark_for_death")
			set(value) = attr.set("mark for death", value)
		
		context(attr: AttributeContainer)
		var STUN_MIDAIR_ENEMIES: Boolean?
			get() = attr.get("mod stun waist high airborne")
			set(value) = attr.set("mod stun waist high airborne", value)
	}
	
	object Downsides {
		context(attr: AttributeContainer)
		var FIRERATE_PENALTY: Double?
			get() = attr.get("fire rate penalty")
			set(value) = attr.set("fire rate penalty", value)
	}
}