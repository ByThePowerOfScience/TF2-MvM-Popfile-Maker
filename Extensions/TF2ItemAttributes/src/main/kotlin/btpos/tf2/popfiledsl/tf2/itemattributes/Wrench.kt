package btpos.tf2.popfiledsl.tf2.itemattributes

import btpos.tf2.popfiledsl.modeling.*
import btpos.tf2.popfiledsl.serialization.codecs.*


/**
 * Items: Stock Wrench + Reskins, Golden Wrench, The Southern Hospitality, The Jag, The Eureka Effect, The Gunslinger
 * 
 */
abstract class WrenchAttributes : BaseMeleeAttributes() {
	companion object : WrenchAttributes() {
		operator fun invoke(scope: WrenchAttributes.Companion.() -> Unit) {
			this.apply(scope)
		}
	}
	
	/**
	 * If set, pressing reload shows the Eureka Effect menu
	 */
	context(attrs: IKeyValueMap)
	var altFireTeleportToSpawn: Boolean?
		get() = attrs.getTyped("alt fire teleport to spawn", BinaryIntCodec)
		set(value) = attrs.setNullable("alt fire teleport to spawn", value, BinaryIntCodec)
	
	/**
	 * Determines the hand used in the model
	 * 
	 * Detonates leveled sentries when equipping a wrench with this attribute
	 * If not in MvM (player is not on team "PVE_DEFENDERS"), detonate minis when unequipping a wrench with this attribute
	 * Removes engineer's glove on his model
	 * Also determines if it's a "PDQ", which obviously builds minisentries
	 */
	override context(attrs: IKeyValueMap)
	var modWrenchBuildsMinisentry: Boolean?
		get() = attrs.getTyped("mod wrench builds minisentry", BinaryIntCodec)
		set(value) = attrs.setNullable("mod wrench builds minisentry", value, BinaryIntCodec)
	
	/**
	 * Passive build rate multiplier, same as the convar `tf_construction_build_rate_multiplier`
	 * 
	 * Bonus:
	 * 	Value type: percentage
	 * 	
	 * 
	 * Penalty:
	 * 	Value type: inverted_percentage
	 * 	
	 */
	val ConstructionRateDecreased = BonusPenalty<Float, Float>("Construction rate increased", "Construction rate decreased")
}

