package btpos.source.vdfdsl.tf2.itemattributes

import btpos.source.vdfdsl.modeling.*
import btpos.source.vdfdsl.serialization.codecs.*
import btpos.source.vdfdsl.tf2.itemattributes.impl.*
import btpos.source.vdfdsl.tf2.tftypes.*
import java.util.*




interface ProjectileRocketAttributes : BaseRocketAttributes {
	
	companion object 

	/**
	 * In-Game: "Pumpkin Bombs"
	 * 
	 * Checks on owner or sentry's owner.
	 */
	override val spellHalloweenPumpkinExplosions: ItemAttributeNamed<Boolean> get() = super.spellHalloweenPumpkinExplosions
}