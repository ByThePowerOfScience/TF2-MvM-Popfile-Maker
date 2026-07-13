package btpos.source.vdfdsl.tf2.attributes

import btpos.source.vdfdsl.modeling.*
import btpos.source.vdfdsl.serialization.codecs.*
import btpos.source.vdfdsl.tf2.attributes.impl.*
import java.util.*


interface ProjectileRocketAttributes : BaseRocketAttributes, IBlockScoped {
	companion object : ProjectileRocketAttributes
	
	/**
	 * In-Game: "Pumpkin Bombs"
	 *
	 * 
	 *
	 * Does pumpkin bombs particle effect.
	 *
	 * Checks on owner or sentry's owner.
	 */
	context(attrs: IKeyValueMap)
	override var spellHalloweenPumpkinExplosions: Boolean?
		get() = super.spellHalloweenPumpkinExplosions
		set(value) { super.spellHalloweenPumpkinExplosions = value }
}

