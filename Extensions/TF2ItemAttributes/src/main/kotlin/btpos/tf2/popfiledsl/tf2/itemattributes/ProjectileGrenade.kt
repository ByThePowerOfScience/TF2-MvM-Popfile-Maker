package btpos.tf2.popfiledsl.tf2.itemattributes

import btpos.tf2.popfiledsl.modeling.*
import btpos.tf2.popfiledsl.serialization.codecs.*


/**
 * 
 */
abstract class ProjectileGrenadeAttributes : WeaponBaseAttributes() {
	companion object : ProjectileGrenadeAttributes() {
		operator fun invoke(scope: ProjectileGrenadeAttributes.Companion.() -> Unit) {
			this.apply(scope)
		}
	}
	
	/**
	 * Checked on launcher
	 */
	context(attrs: IKeyValueMap)
	var useLargeSmokeExplosion: Boolean?
		get() = attrs.getTyped("use large smoke explosion", BinaryIntCodec)
		set(value) = attrs.setNullable("use large smoke explosion", value, BinaryIntCodec)
	
	/**
	 * Checked on launcher
	 */
	context(attrs: IKeyValueMap)
	var SPELLHalloweenPumpkinExplosions: Boolean?
		get() = attrs.getTyped("SPELL: Halloween pumpkin explosions", BinaryIntCodec)
		set(value) = attrs.setNullable("SPELL: Halloween pumpkin explosions", value, BinaryIntCodec)
	
	/**
	 * Checked on launcher
	 * 
	 * Bonus:
	 * 	Value type: percentage
	 * 	
	 * 
	 * Penalty:
	 * 	Value type: percentage
	 * 	
	 */
	val BlastRadiusDecreased = BonusPenalty<Float, Float>("Blast radius increased", "Blast radius decreased")
	
	/**
	 * Value type: percentage
	 * 
	 * Checked on owner
	 */
	context(attrs: IKeyValueMap)
	var fuseBonus: Float?
		get() = attrs.getTyped("fuse bonus")
		set(value) = attrs.setNullable("fuse bonus", value)
}

