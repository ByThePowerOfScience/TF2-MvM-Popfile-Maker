package btpos.tf2.popfiledsl.tf2.itemattributes

import btpos.tf2.popfiledsl.modeling.*
import btpos.tf2.popfiledsl.serialization.codecs.*


/**
 * 
 */
interface ProjectileGrenadeAttributes : WeaponBaseAttributes {
	companion object : ProjectileGrenadeAttributes
	
	/**
	 * Checked on launcher
	 * 
	 */
	context(attrs: IKeyValueMap)
	var useLargeSmokeExplosion: Boolean?
		get() = attrs.getTyped("use large smoke explosion", BinaryIntCodec)
		set(value) = attrs.setNullable("use large smoke explosion", value, BinaryIntCodec)
	
	/**
	 * Checked on launcher
	 * 
	 */
	context(attrs: IKeyValueMap)
	var sPELLHalloweenPumpkinExplosions: Boolean?
		get() = attrs.getTyped("SPELL: Halloween pumpkin explosions", BinaryIntCodec)
		set(value) = attrs.setNullable("SPELL: Halloween pumpkin explosions", value, BinaryIntCodec)
	
	/**
	 * Checked on launcher
	 * 
	 * 
	 * Bonus:
	 * 	- Value type: percentage
	 * 	- +N% explosion radius
	 * 
	 * Penalty:
	 * 	- Value type: percentage
	 * 	- N% explosion radius
	 */
	val blastRadiusDecreased get() = BonusPenalty<Float, Float>("Blast radius increased", "Blast radius decreased")
	
	/**
	 * Value type: percentage
	 * 
	 * Checked on owner
	 * 
	 */
	context(attrs: IKeyValueMap)
	var fuseBonus: Float?
		get() = attrs.getTyped("fuse bonus")
		set(value) = attrs.setNullable("fuse bonus", value)
}

operator fun ProjectileGrenadeAttributes.invoke(scope: ProjectileGrenadeAttributes.() -> Unit) {
	this.apply(scope)
}

