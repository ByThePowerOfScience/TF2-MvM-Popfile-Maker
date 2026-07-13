package btpos.source.vdfdsl.tf2.itemattributes

import btpos.source.vdfdsl.serialization.codecs.BinaryIntCodec
import btpos.source.vdfdsl.tf2.attributes.impl.BonusPenalty
import btpos.source.vdfdsl.tf2.attributes.impl.IBlockScoped


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
	context(attrs: btpos.source.vdfdsl.modeling.IKeyValueMap)
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
	context(attrs: btpos.source.vdfdsl.modeling.IKeyValueMap)
	var attackProjectiles: Boolean?
		get() = attrs.getTyped("attack projectiles", BinaryIntCodec)
		set(value) = attrs.setNullable("attack projectiles", value, BinaryIntCodec)
	
	/**
	 * In-Game: "Creates a ring of flames while spun up"
	 *
	 * 
	 */
	context(attrs: btpos.source.vdfdsl.modeling.IKeyValueMap)
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
	context(attrs: btpos.source.vdfdsl.modeling.IKeyValueMap)
	var spinupAmmoDrain: Int?
		get() = attrs.getTyped("uses ammo while aiming")
		set(value) = attrs.setNullable("uses ammo while aiming", value)
}

