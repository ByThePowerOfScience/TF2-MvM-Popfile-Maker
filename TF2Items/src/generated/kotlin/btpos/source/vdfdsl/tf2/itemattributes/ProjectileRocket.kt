package btpos.source.vdfdsl.tf2.itemattributes

import btpos.source.vdfdsl.modeling.*
import btpos.source.vdfdsl.serialization.codecs.*
import btpos.source.vdfdsl.tf2.itemattributes.impl.*
import btpos.source.vdfdsl.tf2.tftypes.*
import java.util.*
import kotlin.time.Duration

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