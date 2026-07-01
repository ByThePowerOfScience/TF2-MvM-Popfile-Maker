package btpos.source.vdfdsl.tf2.itemattributes

import btpos.source.vdfdsl.tf2.itemattributes.impl.IBlockScoped


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
	context(attrs: btpos.source.vdfdsl.modeling.IKeyValueMap)
	override var spellHalloweenPumpkinExplosions: Boolean?
		get() = super.spellHalloweenPumpkinExplosions
		set(value) {
			super.spellHalloweenPumpkinExplosions = value
		}
}

