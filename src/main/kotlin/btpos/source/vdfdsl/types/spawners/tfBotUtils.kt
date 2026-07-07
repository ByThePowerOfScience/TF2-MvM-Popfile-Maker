package btpos.source.vdfdsl.types.spawners

import btpos.source.vdfdsl.types.bots.TFBotAttributes

/**
 * Create a copy of this bot with the `AlwaysCrit` attribute.
 */
val TFBotSpawner.critBoosted
	get() = this.copy().apply {
		attributes += TFBotAttributes.AlwaysCrit
	}