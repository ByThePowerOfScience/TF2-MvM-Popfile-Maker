package btpos.source.vdfdsl.tf2.itemattributes

import btpos.source.vdfdsl.modeling.*
import btpos.source.vdfdsl.serialization.codecs.*
import btpos.source.vdfdsl.tf2.itemattributes.impl.*
import btpos.source.vdfdsl.tf2.tftypes.*
import java.util.*



/**
 * Items: The Chargin' Targe, The Splendid Screen, The Tide Turner, Festive Targe 2014
 */
interface WearableDemoShieldAttributes : IBlockScoped {
	companion object {
		/**
		 * 
		 */
		val attackNotCancelCharge = ItemAttributeNamed<Boolean>("Attack not cancel charge")
		
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
		 * Charge time mult.
		 *
		 * Checked on player.
		 */
		val chargeTime = BonusPenalty(
			ItemAttributeNamed<Float>("charge time increased"),
			ItemAttributeNamed<Float>("charge time decreased")
		)
		
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
		 * Impact damage mult.
		 *
		 * Checked on player.
		 */
		val chargeImpactDamage = BonusPenalty(
			ItemAttributeNamed<Float>("charge impact damage increased"),
			ItemAttributeNamed<Float>("charge impact damage decreased")
		)
		
		/**
		 * In-Game: "Immune to the effects of afterburn."
		 *
		 * 
		 */
		val afterburnImmunity = ItemAttributeNamed<Boolean>("afterburn immunity")
	}

	/**
	 * 
	 */
	val attackNotCancelCharge: ItemAttribute<Boolean> get() = WearableDemoShieldAttributes.attackNotCancelCharge
	
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
	 * Charge time mult.
	 *
	 * Checked on player.
	 */
	val chargeTime: ItemAttribute<Float> get() = WearableDemoShieldAttributes.chargeTime
	
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
	 * Impact damage mult.
	 *
	 * Checked on player.
	 */
	val chargeImpactDamage: ItemAttribute<Float> get() = WearableDemoShieldAttributes.chargeImpactDamage
	
	/**
	 * In-Game: "Immune to the effects of afterburn."
	 *
	 * 
	 */
	val afterburnImmunity: ItemAttribute<Boolean> get() = WearableDemoShieldAttributes.afterburnImmunity

   
}

