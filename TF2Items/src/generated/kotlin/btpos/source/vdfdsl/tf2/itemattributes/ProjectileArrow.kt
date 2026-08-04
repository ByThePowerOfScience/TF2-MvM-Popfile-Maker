package btpos.source.vdfdsl.tf2.itemattributes

import btpos.source.vdfdsl.tf2.itemattributes.impl.*

interface ProjectileArrowAttributes : IBlockScoped, BaseRocketAttributes {
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