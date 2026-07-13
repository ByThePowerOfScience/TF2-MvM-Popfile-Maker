package btpos.source.vdfdsl.tf2.attributes

import btpos.source.vdfdsl.modeling.*
import btpos.source.vdfdsl.serialization.codecs.*
import btpos.source.vdfdsl.tf2.attributes.impl.*
import java.util.*

/**
 * Items: All Stock Minigun skins, Natascha, The Brass Beast, Tomislav
 */
interface MinigunAttributes : BaseGunAttributes, IBlockScoped {
	companion object : MinigunAttributes
	
	/**
	 * In-Game: "Silent Killer: No barrel spin sound"
	 *
	 * 
	 */
	context(attrs: IKeyValueMap)
	var silentBarrel: Boolean?
		get() = attrs.getTyped("minigun no spin sounds", BinaryIntCodec)
		set(value) = attrs.setNullable("minigun no spin sounds", value, BinaryIntCodec)
	
	/**
	 * Bonus:
	 *
	 * 	- In-Game: "N% faster spin up time"
	 *
	 * 
	 *
	 * Penalty:
	 *
	 * 	- In-Game: "N% slower spin up time"
	 *
	 * 
	 */
	val minigunSpinupTime get() = BonusPenalty<Float, Float>("minigun spinup time decreased", "minigun spinup time increased")
	
	/**
	 * In-Game: "Bullets destroy rockets and grenades in-flight.  Increased accuracy and frequency per-level."
	 *
	 * 
	 */
	context(attrs: IKeyValueMap)
	var attackProjectiles: Boolean?
		get() = attrs.getTyped("attack projectiles", BinaryIntCodec)
		set(value) = attrs.setNullable("attack projectiles", value, BinaryIntCodec)
	
	/**
	 * In-Game: "Creates a ring of flames while spun up"
	 *
	 * 
	 */
	context(attrs: IKeyValueMap)
	var ringOfFireWhileAiming: Int?
		get() = attrs.getTyped("ring of fire while aiming")
		set(value) = attrs.setNullable("ring of fire while aiming", value)
	
	/**
	 * In-Game: "Consumes an additional N ammo per second while spun up"
	 *
	 * 
	 *
	 * Amount of ammo drained per second.
	 */
	context(attrs: IKeyValueMap)
	var spinupAmmoDrain: Int?
		get() = attrs.getTyped("uses ammo while aiming")
		set(value) = attrs.setNullable("uses ammo while aiming", value)
}

