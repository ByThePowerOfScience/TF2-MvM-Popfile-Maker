package btpos.source.vdfdsl.tf2.itemattributes

import btpos.source.vdfdsl.modeling.*
import btpos.source.vdfdsl.serialization.codecs.*


/**
 * Items: Stock Wrench + Reskins, Golden Wrench, The Southern Hospitality, The Jag, The Eureka Effect, The Gunslinger
 */
interface WrenchAttributes : btpos.source.vdfdsl.tf2.itemattributes.BaseMeleeAttributes, btpos.source.vdfdsl.tf2.itemattributes.IBlockScoped {
	companion object : WrenchAttributes
	
	/**
	 * In-Game: "Press your reload key to choose to teleport to spawn or your exit teleporter"
	 *
	 * 
	 *
	 * If set, pressing reload shows the Eureka Effect menu.
	 */
	context(attrs: btpos.source.vdfdsl.modeling.IKeyValueMap)
	var altFireTeleportToSpawn: Boolean?
		get() = attrs.getTyped("alt fire teleport to spawn", _root_ide_package_.btpos.source.vdfdsl.serialization.codecs.BinaryIntCodec)
		set(value) = attrs.setNullable("alt fire teleport to spawn", value, _root_ide_package_.btpos.source.vdfdsl.serialization.codecs.BinaryIntCodec)
	
	/**
	 * In-Game: "Replaces the Sentry with a Mini-Sentry"
	 *
	 * 
	 *
	 * Determines the hand used in the model.
	 *
	 * Detonates leveled sentries when equipping a wrench with this attribute.
	 *
	 * If not in MvM (player is not on team "PVE_DEFENDERS"), detonate minis when unequipping a wrench with this attribute.
	 *
	 * Removes engineer's glove on his model.
	 *
	 * Also determines if it's a "PDQ", which obviously builds minisentries.
	 */
	context(attrs: btpos.source.vdfdsl.modeling.IKeyValueMap)
	override var wrenchBuildsMinisentry: Boolean?
		get() = super.wrenchBuildsMinisentry
		set(value) { super.wrenchBuildsMinisentry = value }
	
	/**
	 * Bonus:
	 *
	 * 	- In-Game: "Construction hit speed boost increased by N%"
	 *
	 * 
	 *
	 * Penalty:
	 *
	 * 	- In-Game: "Construction hit speed boost decreased by N%"
	 *
	 * 
	 *
	 * Passive build rate multiplier, same as the convar `tf_construction_build_rate_multiplier`.
	 */
	val constructionRate get() = _root_ide_package_.btpos.source.vdfdsl.tf2.itemattributes.BonusPenalty<Float, Float>("Construction rate increased", "Construction rate decreased")
}

