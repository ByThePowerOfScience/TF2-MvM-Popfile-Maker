package btpos.source.vdfdsl.tf2.itemattributes

import btpos.source.vdfdsl.modeling.*
import btpos.source.vdfdsl.serialization.codecs.*
import btpos.source.vdfdsl.tf2.itemattributes.impl.*
import btpos.source.vdfdsl.tf2.tftypes.*
import java.util.*
import kotlin.time.Duration

interface ProjectileArrowAttributes : BaseRocketAttributes {
	companion object : IBlockScoped {
		/**
		 * In-Game: "Fires a special bolt that can repair friendly buildings"
		 * 
		 * Checked on player.
		 */
		val arrowHealsBuildings: ItemAttributeNamed<Boolean> = ItemAttributeNamed("arrow heals buildings")
	}

	/**
	 * In-Game: "Fires a special bolt that can repair friendly buildings"
	 * 
	 * Checked on player.
	 */
	val arrowHealsBuildings: ItemAttributeNamed<Boolean> get() = ProjectileArrowAttributes.arrowHealsBuildings
}