package btpos.source.vdfdsl.tf2.itemattributes

import btpos.source.vdfdsl.modeling.*
import btpos.source.vdfdsl.serialization.codecs.*
import btpos.source.vdfdsl.tf2.itemattributes.impl.*
import java.util.*


interface ProjectileGrenadeAttributes : WeaponBaseAttributes, IBlockScoped {
	companion object : ProjectileGrenadeAttributes
	
	/**
	 * 
	 *
	 * Checked on launcher.
	 */
	context(attrs: IKeyValueMap)
	var useLargeSmokeExplosion: Boolean?
		get() = attrs.getTyped("use large smoke explosion", BinaryIntCodec)
		set(value) = attrs.setNullable("use large smoke explosion", value, BinaryIntCodec)
	
	/**
	 * In-Game: "Pumpkin Bombs"
	 *
	 * 
	 *
	 * Checked on launcher.
	 */
	context(attrs: IKeyValueMap)
	var spellHalloweenPumpkinExplosions: Boolean?
		get() = attrs.getTyped("SPELL: Halloween pumpkin explosions", BinaryIntCodec)
		set(value) = attrs.setNullable("SPELL: Halloween pumpkin explosions", value, BinaryIntCodec)
	
	/**
	 * Bonus:
	 *
	 * 	- In-Game: "+N% explosion radius"
	 *
	 * 
	 *
	 * Penalty:
	 *
	 * 	- In-Game: "N% explosion radius"
	 *
	 * 
	 *
	 * Checked on launcher.
	 */
	val blastRadius get() = BonusPenalty<Number, Number>("Blast radius increased", "Blast radius decreased")
	
	/**
	 * In-Game: "N% fuse time on grenades"
	 *
	 * 
	 *
	 * Checked on owner.
	 */
	context(attrs: IKeyValueMap)
	var fuseBonus: Number?
		get() = attrs.getTyped("fuse bonus")
		set(value) = attrs.setNullable("fuse bonus", value)
}

