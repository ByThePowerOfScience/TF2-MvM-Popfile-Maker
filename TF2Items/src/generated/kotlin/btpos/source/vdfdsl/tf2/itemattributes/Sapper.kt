package btpos.source.vdfdsl.tf2.itemattributes

import btpos.source.vdfdsl.modeling.*
import btpos.source.vdfdsl.serialization.codecs.*
import btpos.source.vdfdsl.tf2.itemattributes.impl.*
import btpos.source.vdfdsl.tf2.tftypes.*
import java.util.*



/**
 * Items: Stock Sapper, The Red-Tape Recorder, Promo Red-Tape Recorder, The Ap-Sap, Festive Sapper, The Snack Attack
 */
interface SapperAttributes : IBlockScoped {
	companion object {
		/**
		 * In-Game: "Reverses enemy building construction"
		 *
		 * 
		 *
		 * How fast the building should reverse construction.
		 *
		 * Checked on player.
		 */
		val sapperDegeneratesBuildings = ItemAttributeNamed<Float>("sapper degenerates buildings")
		
		/**
		 * In-Game: "Increased robot Sapper radius and duration"
		 *
		 * 
		 *
		 * When the sapper is applied to a player (including MvM bots):.
		 *
		 * 2 - stun time is 5.5 seconds, radius is 225 hammer units.
		 *
		 * 3 - stuns for 7 seconds, radius is 250 hammer units.
		 *
		 * else stuns for 4 seconds and radius is 200 HU.
		 */
		val roboSapper = ItemAttributeNamed<Int>("robo sapper")
	}

	/**
	 * In-Game: "Reverses enemy building construction"
	 *
	 * 
	 *
	 * How fast the building should reverse construction.
	 *
	 * Checked on player.
	 */
	val sapperDegeneratesBuildings: ItemAttribute<Float> get() = SapperAttributes.sapperDegeneratesBuildings
	
	/**
	 * In-Game: "Increased robot Sapper radius and duration"
	 *
	 * 
	 *
	 * When the sapper is applied to a player (including MvM bots):.
	 *
	 * 2 - stun time is 5.5 seconds, radius is 225 hammer units.
	 *
	 * 3 - stuns for 7 seconds, radius is 250 hammer units.
	 *
	 * else stuns for 4 seconds and radius is 200 HU.
	 */
	val roboSapper: ItemAttribute<Int> get() = SapperAttributes.roboSapper

   
}

