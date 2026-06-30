package btpos.source.vdfdsl.tf2.itemattributes

import btpos.source.vdfdsl.modeling.*
import btpos.source.vdfdsl.serialization.codecs.*


/**
 * Items: The Chargin' Targe, The Splendid Screen, The Tide Turner, Festive Targe 2014
 */
interface WearableDemoShieldAttributes : btpos.source.vdfdsl.tf2.itemattributes.WearableAttributes, btpos.source.vdfdsl.tf2.itemattributes.IBlockScoped {
	companion object : WearableDemoShieldAttributes
	
	/**
	 * 
	 */
	context(attrs: btpos.source.vdfdsl.modeling.IKeyValueMap)
	var attackNotCancelCharge: Boolean?
		get() = attrs.getTyped("Attack not cancel charge", _root_ide_package_.btpos.source.vdfdsl.serialization.codecs.BinaryIntCodec)
		set(value) = attrs.setNullable("Attack not cancel charge", value, _root_ide_package_.btpos.source.vdfdsl.serialization.codecs.BinaryIntCodec)
	
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
	val chargeTime get() = _root_ide_package_.btpos.source.vdfdsl.tf2.itemattributes.BonusPenalty<Int, Int>("charge time increased", "charge time decreased")
	
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
	val chargeImpactDamage get() = _root_ide_package_.btpos.source.vdfdsl.tf2.itemattributes.BonusPenalty<Float, Float>("charge impact damage increased", "charge impact damage decreased")
}

