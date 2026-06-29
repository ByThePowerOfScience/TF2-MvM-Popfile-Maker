package btpos.tf2.popfiledsl.tf2.itemattributes

import btpos.tf2.popfiledsl.modeling.*
import btpos.tf2.popfiledsl.serialization.codecs.*


/**
 * Items: The Chargin' Targe, The Splendid Screen, The Tide Turner, Festive Targe 2014
 * 
 */
interface WearableDemoShieldAttributes : WearableAttributes {
	companion object : WearableDemoShieldAttributes
	
	
	context(attrs: IKeyValueMap)
	var attackNotCancelCharge: Boolean?
		get() = attrs.getTyped("Attack not cancel charge", BinaryIntCodec)
		set(value) = attrs.setNullable("Attack not cancel charge", value, BinaryIntCodec)
	
	/**
	 * On player
	 * 
	 * Charge time mult
	 * 
	 * 
	 * Bonus:
	 * 	- N sec increase in charge duration
	 * 
	 * Penalty:
	 * 	- N sec decrease in charge duration
	 */
	val chargeTime get() = BonusPenalty<Int, Int>("charge time increased", "charge time decreased")
	
	/**
	 * On player
	 * 
	 * Impact damage mult
	 * 
	 * 
	 * Bonus:
	 * 	- Value type: percentage
	 * 	- +N% increase in charge impact damage
	 * 
	 * Penalty:
	 * 	- Value type: percentage
	 * 	- N% decrease in charge impact damage
	 */
	val chargeImpactDamage get() = BonusPenalty<Float, Float>("charge impact damage increased", "charge impact damage decreased")
}

inline operator fun WearableDemoShieldAttributes.invoke(scope: WearableDemoShieldAttributes.() -> Unit) {
	this.apply(scope)
}

