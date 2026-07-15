package btpos.source.vdfdsl.tf2.itemattributes

import btpos.source.vdfdsl.modeling.*
import btpos.source.vdfdsl.serialization.codecs.*
import btpos.source.vdfdsl.tf2.itemattributes.impl.*
import java.util.*

/**
 * Items: The Chargin' Targe, The Splendid Screen, The Tide Turner, Festive Targe 2014
 */
interface WearableDemoShieldAttributes : WearableAttributes, IBlockScoped {
	companion object : WearableDemoShieldAttributes
	
	/**
	 * 
	 */
	context(attrs: IKeyValueMap)
	var attackNotCancelCharge: Boolean?
		get() = attrs.getTyped("Attack not cancel charge", BinaryIntCodec)
		set(value) = attrs.setNullable("Attack not cancel charge", value, BinaryIntCodec)
	
	/**
	 * Bonus:
	 *
	 * 	- In-Game: "N sec increase in charge duration"
	 *
	 * 
	 *
	 * Penalty:
	 *
	 * 	- In-Game: "N sec decrease in charge duration"
	 *
	 * 
	 *
	 * On player.
	 *
	 * Charge time mult.
	 */
	val chargeTime get() = BonusPenalty<Int, Int>("charge time increased", "charge time decreased")
	
	/**
	 * Bonus:
	 *
	 * 	- In-Game: "+N% increase in charge impact damage"
	 *
	 * 
	 *
	 * Penalty:
	 *
	 * 	- In-Game: "N% decrease in charge impact damage"
	 *
	 * 
	 *
	 * On player.
	 *
	 * Impact damage mult.
	 */
	val chargeImpactDamage get() = BonusPenalty<Number, Number>("charge impact damage increased", "charge impact damage decreased")
	
	/**
	 * In-Game: "Immune to the effects of afterburn."
	 *
	 * 
	 */
	context(attrs: IKeyValueMap)
	var afterburnImmunity: Boolean?
		get() = attrs.getTyped("afterburn immunity", BinaryIntCodec)
		set(value) = attrs.setNullable("afterburn immunity", value, BinaryIntCodec)
}

