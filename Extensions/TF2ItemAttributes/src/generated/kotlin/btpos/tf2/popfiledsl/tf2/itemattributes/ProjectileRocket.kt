package btpos.tf2.popfiledsl.tf2.itemattributes

import btpos.tf2.popfiledsl.modeling.*
import btpos.tf2.popfiledsl.serialization.codecs.*



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

