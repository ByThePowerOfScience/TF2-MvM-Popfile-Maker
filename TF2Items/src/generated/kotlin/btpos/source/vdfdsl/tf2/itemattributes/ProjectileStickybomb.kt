package btpos.source.vdfdsl.tf2.itemattributes

import btpos.source.vdfdsl.modeling.*
import btpos.source.vdfdsl.serialization.codecs.*
import btpos.source.vdfdsl.tf2.itemattributes.impl.*
import java.util.*


interface ProjectileStickybombAttributes : BaseProjectileAttributes, IBlockScoped {
	companion object : ProjectileStickybombAttributes
	
	/**
	 * In-Game: "Stickybombs fizzle N seconds after landing"
	 *
	 * 
	 *
	 * Checked on launcher.
	 */
	context(attrs: IKeyValueMap)
	var stickybombFizzleTime: Int?
		get() = attrs.getTyped("stickybomb fizzle time")
		set(value) = attrs.setNullable("stickybomb fizzle time", value)
	
	/**
	 * In-Game: "Grenades have very little bounce and roll"
	 *
	 * 
	 *
	 * Checked on launcher.
	 */
	context(attrs: IKeyValueMap)
	var grenadeNoBounce: Boolean?
		get() = attrs.getTyped("grenade no bounce", BinaryIntCodec)
		set(value) = attrs.setNullable("grenade no bounce", value, BinaryIntCodec)
	
	/**
	 * Bonus:
	 *
	 * 	- In-Game: "N sec faster bomb arm time"
	 *
	 * 
	 *
	 * Penalty:
	 *
	 * 	- In-Game: "N sec slower bomb arm time"
	 *
	 * 
	 *
	 * Checked on launcher.
	 */
	val stickyArmTime get() = BonusPenalty<Int, Int>("sticky arm time bonus", "sticky arm time penalty")
	
	/**
	 * In-Game: "N% damage on contact with surfaces"
	 *
	 * 
	 *
	 * Checked on launcher.
	 */
	context(attrs: IKeyValueMap)
	var grenadeDamageReductionOnWorldContact: Number?
		get() = attrs.getTyped("grenade damage reduction on world contact")
		set(value) = attrs.setNullable("grenade damage reduction on world contact", value)
}

