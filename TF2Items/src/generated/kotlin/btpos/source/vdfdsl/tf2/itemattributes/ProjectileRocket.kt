package btpos.source.vdfdsl.tf2.itemattributes

import btpos.source.vdfdsl.tf2.itemattributes.impl.*

interface ProjectileRocketAttributes : IBlockScoped, BaseRocketAttributes {
	companion object : IBlockScoped {
		/**
		 * In-Game: "Pumpkin Bombs"
		 * 
		 * Checks on owner or sentry's owner.
		 */
		val spellHalloweenPumpkinExplosions: ItemAttributeNamed<Boolean> = ItemAttributeNamed("SPELL: Halloween pumpkin explosions")
	}

	/**
	 * In-Game: "Pumpkin Bombs"
	 * 
	 * Checks on owner or sentry's owner.
	 */
	override val spellHalloweenPumpkinExplosions: ItemAttributeNamed<Boolean> get() = super.spellHalloweenPumpkinExplosions
}