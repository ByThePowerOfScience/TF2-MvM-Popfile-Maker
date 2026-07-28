package btpos.source.vdfdsl.tf2.itemattributes

import btpos.source.vdfdsl.modeling.*
import btpos.source.vdfdsl.serialization.codecs.*
import btpos.source.vdfdsl.tf2.itemattributes.impl.*
import btpos.source.vdfdsl.tf2.tftypes.*
import java.util.*




interface ProjectileRocketAttributes : IBlockScoped {
	companion object {
		/**
		 * In-Game: "Pumpkin Bombs"
		 *
		 * 
		 *
		 * Checks on owner or sentry's owner.
		 */
		val spellHalloweenPumpkinExplosions = ItemAttributeNamed<Boolean>("SPELL: Halloween pumpkin explosions")
	}

	/**
	 * In-Game: "Pumpkin Bombs"
	 *
	 * 
	 *
	 * Checks on owner or sentry's owner.
	 */
	val spellHalloweenPumpkinExplosions: ItemAttribute<Boolean> get() = ProjectileRocketAttributes.spellHalloweenPumpkinExplosions

   
}

