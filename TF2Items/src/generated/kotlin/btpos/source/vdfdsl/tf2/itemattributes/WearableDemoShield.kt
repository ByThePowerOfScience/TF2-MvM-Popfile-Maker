package btpos.source.vdfdsl.tf2.itemattributes

import btpos.source.vdfdsl.modeling.*
import btpos.source.vdfdsl.serialization.codecs.*
import btpos.source.vdfdsl.tf2.itemattributes.impl.*
import btpos.source.vdfdsl.tf2.tftypes.*
import java.util.*




interface WearableDemoShieldAttributes : WearableAttributes {
	
	companion object {
		val attackNotCancelCharge: ItemAttributeNamed<Boolean> = ItemAttributeNamed("Attack not cancel charge")
	
		val chargeTime: VisHidden<Float> = VisHidden(ItemAttributeNamed<Float>("charge time increased"), ItemAttributeNamed<Float>("charge time decreased"))
	
		val chargeImpactDamage: VisHidden<Float> = VisHidden(ItemAttributeNamed<Float>("charge impact damage increased"), ItemAttributeNamed<Float>("charge impact damage decreased"))
	}

	val attackNotCancelCharge: ItemAttributeNamed<Boolean> get() = WearableDemoShieldAttributes.attackNotCancelCharge
	
	val chargeTime: VisHidden<Float> get() = WearableDemoShieldAttributes.chargeTime
	
	val chargeImpactDamage: VisHidden<Float> get() = WearableDemoShieldAttributes.chargeImpactDamage
	
	/**
	 * In-Game: "Immune to the effects of afterburn."
	 */
	override val afterburnImmunity: ItemAttributeNamed<Boolean> get() = super.afterburnImmunity
}