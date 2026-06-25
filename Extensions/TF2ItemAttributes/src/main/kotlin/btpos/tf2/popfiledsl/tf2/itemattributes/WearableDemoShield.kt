package btpos.tf2.popfiledsl.tf2.itemattributes

import btpos.tf2.popfiledsl.modeling.*
import btpos.tf2.popfiledsl.serialization.codecs.*


/**
 * Items: The Chargin' Targe, The Splendid Screen, The Tide Turner, Festive Targe 2014
 * 
 */
abstract class WearableDemoShieldAttributes : WearableAttributes() {
	companion object : WearableDemoShieldAttributes() {
		operator fun invoke(scope: WearableDemoShieldAttributes.Companion.() -> Unit) {
			this.apply(scope)
		}
	}
	
	
	context(attrs: IKeyValueMap)
	var AttackNotCancelCharge: Boolean?
		get() = attrs.getTyped("Attack not cancel charge", BinaryIntCodec)
		set(value) = attrs.setNullable("Attack not cancel charge", value, BinaryIntCodec)
	
	/**
	 * On player
	 * Charge time mult
	 * 
	 * Bonus:
	 * 
	 * Penalty:
	 */
	val chargeTimeDecreased = BonusPenalty<Int, Int>("charge time increased", "charge time decreased")
	
	/**
	 * On player
	 * Impact damage mult
	 * 
	 * Bonus:
	 * 	Value type: percentage
	 * 	
	 * 
	 * Penalty:
	 * 	Value type: percentage
	 * 	
	 */
	val chargeImpactDamageDecreased = BonusPenalty<Float, Float>("charge impact damage increased", "charge impact damage decreased")
}

