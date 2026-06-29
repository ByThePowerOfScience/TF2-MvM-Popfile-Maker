package btpos.tf2.popfiledsl.tf2.itemattributes

import btpos.tf2.popfiledsl.modeling.*
import btpos.tf2.popfiledsl.serialization.codecs.*


/**
 * Items: All Stock Minigun skins, Natascha, The Brass Beast, Tomislav
 * 
 */
interface MinigunAttributes : BaseGunAttributes {
	companion object : MinigunAttributes
	
	
	context(attrs: IKeyValueMap)
	var minigunNoSpinSounds: Boolean?
		get() = attrs.getTyped("minigun no spin sounds", BinaryIntCodec)
		set(value) = attrs.setNullable("minigun no spin sounds", value, BinaryIntCodec)
	
	/**
	 * 
	 * Bonus:
	 * 	- Value type: inverted_percentage
	 * 	- N% faster spin up time
	 * 
	 * Penalty:
	 * 	- Value type: percentage
	 * 	- N% slower spin up time
	 */
	val minigunSpinupTime get() = BonusPenalty<Float, Float>("minigun spinup time decreased", "minigun spinup time increased")
	
	/**
	 * Overridden by "raid gamemode" to 1
	 * 
	 */
	context(attrs: IKeyValueMap)
	var attackProjectiles: Boolean?
		get() = attrs.getTyped("attack projectiles", BinaryIntCodec)
		set(value) = attrs.setNullable("attack projectiles", value, BinaryIntCodec)
	
	
	context(attrs: IKeyValueMap)
	var ringOfFireWhileAiming: Int?
		get() = attrs.getTyped("ring of fire while aiming")
		set(value) = attrs.setNullable("ring of fire while aiming", value)
	
	/**
	 * Amount of ammo drained per second
	 * 
	 */
	context(attrs: IKeyValueMap)
	var usesAmmoWhileAiming: Int?
		get() = attrs.getTyped("uses ammo while aiming")
		set(value) = attrs.setNullable("uses ammo while aiming", value)
}

inline operator fun MinigunAttributes.invoke(scope: MinigunAttributes.() -> Unit) {
	this.apply(scope)
}

