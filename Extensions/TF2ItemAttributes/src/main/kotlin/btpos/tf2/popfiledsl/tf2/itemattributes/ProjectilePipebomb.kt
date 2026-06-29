package btpos.tf2.popfiledsl.tf2.itemattributes

import btpos.tf2.popfiledsl.modeling.*
import btpos.tf2.popfiledsl.serialization.codecs.*


/**
 * 
 */
interface ProjectilePipebombAttributes : ProjectileGrenadeAttributes {
	companion object : ProjectilePipebombAttributes
	
	/**
	 * Checked on launcher
	 * 
	 */
	context(attrs: IKeyValueMap)
	var stickybombFizzleTime: Int?
		get() = attrs.getTyped("stickybomb fizzle time")
		set(value) = attrs.setNullable("stickybomb fizzle time", value)
	
	/**
	 * Checked on launcher
	 * 
	 */
	context(attrs: IKeyValueMap)
	var grenadeNoBounce: Boolean?
		get() = attrs.getTyped("grenade no bounce", BinaryIntCodec)
		set(value) = attrs.setNullable("grenade no bounce", value, BinaryIntCodec)
	
	/**
	 * Checked on launcher
	 * 
	 * 
	 * Bonus:
	 * 	- N sec faster bomb arm time
	 * 
	 * Penalty:
	 * 	- N sec slower bomb arm time
	 */
	val stickyArmTime get() = BonusPenalty<Int, Int>("sticky arm time bonus", "sticky arm time penalty")
	
	/**
	 * Value type: percentage
	 * 
	 * Checked on launcher
	 * 
	 */
	context(attrs: IKeyValueMap)
	var grenadeDamageReductionOnWorldContact: Float?
		get() = attrs.getTyped("grenade damage reduction on world contact")
		set(value) = attrs.setNullable("grenade damage reduction on world contact", value)
}

inline operator fun ProjectilePipebombAttributes.invoke(scope: ProjectilePipebombAttributes.() -> Unit) {
	this.apply(scope)
}

