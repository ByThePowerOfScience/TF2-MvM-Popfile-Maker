package btpos.source.vdfdsl.tf2.itemattributes

import btpos.source.vdfdsl.modeling.*
import btpos.source.vdfdsl.serialization.codecs.*
import btpos.source.vdfdsl.tf2.itemattributes.impl.*
import btpos.source.vdfdsl.tf2.tftypes.*
import java.util.*



/**
 * Items: The Crusader's Crossbow, Festive Crusader's Crossbow
 */
interface CrossbowAttributes : IBlockScoped {
	companion object {
		/**
		 * Bonus:
		 *
		 * 	- In-Game: "N% faster reload time"
		 *
		 * 
		 *
		 * Penalty:
		 *
		 * 	- In-Game: "N% slower reload time"
		 *
		 * 
		 */
		val reloadTime = BonusPenalty(
			ItemAttributeNamed<Float>("Reload time decreased"),
			ItemAttributeNamed<Float>("Reload time increased")
		)
		
		/**
		 * In-Game: "N% slower reload time"
		 *
		 * 
		 */
		val reloadTimeIncreasedHidden = ItemAttributeNamed<Float>("reload time increased hidden")
		
		/**
		 * In-Game: "+N% faster reload time"
		 *
		 * 
		 */
		val fasterReloadRate = ItemAttributeNamed<Float>("faster reload rate")
	}

	/**
	 * Bonus:
	 *
	 * 	- In-Game: "N% faster reload time"
	 *
	 * 
	 *
	 * Penalty:
	 *
	 * 	- In-Game: "N% slower reload time"
	 *
	 * 
	 */
	val reloadTime: ItemAttribute<Float> get() = CrossbowAttributes.reloadTime
	
	/**
	 * In-Game: "N% slower reload time"
	 *
	 * 
	 */
	val reloadTimeIncreasedHidden: ItemAttribute<Float> get() = CrossbowAttributes.reloadTimeIncreasedHidden
	
	/**
	 * In-Game: "+N% faster reload time"
	 *
	 * 
	 */
	val fasterReloadRate: ItemAttribute<Float> get() = CrossbowAttributes.fasterReloadRate

   
}

