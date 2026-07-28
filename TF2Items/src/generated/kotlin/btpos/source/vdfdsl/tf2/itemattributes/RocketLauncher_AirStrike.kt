package btpos.source.vdfdsl.tf2.itemattributes

import btpos.source.vdfdsl.modeling.*
import btpos.source.vdfdsl.serialization.codecs.*
import btpos.source.vdfdsl.tf2.itemattributes.impl.*
import btpos.source.vdfdsl.tf2.tftypes.*
import java.util.*



/**
 * Items: The Air Strike
 */
interface RocketLauncher_AirStrikeAttributes : IBlockScoped {
	companion object {
		/**
		 * In-Game: "Clip size increased on kill"
		 *
		 * 
		 *
		 * This attribute is on all weapons, but it's specifically checked for here as well.
		 */
		val clipsizeIncreaseOnKill = ItemAttributeNamed<Int>("clipsize increase on kill")
	}

	/**
	 * In-Game: "Clip size increased on kill"
	 *
	 * 
	 *
	 * This attribute is on all weapons, but it's specifically checked for here as well.
	 */
	val clipsizeIncreaseOnKill: ItemAttribute<Int> get() = RocketLauncher_AirStrikeAttributes.clipsizeIncreaseOnKill

   
}

