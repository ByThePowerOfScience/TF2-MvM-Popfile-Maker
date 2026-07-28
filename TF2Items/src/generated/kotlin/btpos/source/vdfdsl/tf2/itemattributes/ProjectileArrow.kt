package btpos.source.vdfdsl.tf2.itemattributes

import btpos.source.vdfdsl.modeling.*
import btpos.source.vdfdsl.serialization.codecs.*
import btpos.source.vdfdsl.tf2.itemattributes.impl.*
import btpos.source.vdfdsl.tf2.tftypes.*
import java.util.*



/**
 * Items: The Huntsman, The Crusader's Crossbow, The Rescue Ranger
 */
interface ProjectileArrowAttributes : IBlockScoped {
	companion object {
		/**
		 * In-Game: "Fires a special bolt that can repair friendly buildings"
		 *
		 * 
		 *
		 * Checked on player.
		 */
		val arrowHealsBuildings = ItemAttributeNamed<Boolean>("arrow heals buildings")
	}

	/**
	 * In-Game: "Fires a special bolt that can repair friendly buildings"
	 *
	 * 
	 *
	 * Checked on player.
	 */
	val arrowHealsBuildings: ItemAttribute<Boolean> get() = ProjectileArrowAttributes.arrowHealsBuildings

   
}

