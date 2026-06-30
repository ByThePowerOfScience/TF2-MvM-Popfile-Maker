package btpos.source.vdfdsl.tf2.itemattributes

import btpos.source.vdfdsl.modeling.*
import btpos.source.vdfdsl.serialization.codecs.*



interface ProjectileGrenadeAttributes : btpos.source.vdfdsl.tf2.itemattributes.WeaponBaseAttributes, btpos.source.vdfdsl.tf2.itemattributes.IBlockScoped {
	companion object : ProjectileGrenadeAttributes
	
	/**
	 * 
	 *
	 * Checked on launcher.
	 */
	context(attrs: btpos.source.vdfdsl.modeling.IKeyValueMap)
	var useLargeSmokeExplosion: Boolean?
		get() = attrs.getTyped("use large smoke explosion", _root_ide_package_.btpos.source.vdfdsl.serialization.codecs.BinaryIntCodec)
		set(value) = attrs.setNullable("use large smoke explosion", value, _root_ide_package_.btpos.source.vdfdsl.serialization.codecs.BinaryIntCodec)
	
	/**
	 * In-Game: "Pumpkin Bombs"
	 *
	 * 
	 *
	 * Checked on launcher.
	 */
	context(attrs: btpos.source.vdfdsl.modeling.IKeyValueMap)
	var spellHalloweenPumpkinExplosions: Boolean?
		get() = attrs.getTyped("SPELL: Halloween pumpkin explosions", _root_ide_package_.btpos.source.vdfdsl.serialization.codecs.BinaryIntCodec)
		set(value) = attrs.setNullable("SPELL: Halloween pumpkin explosions", value, _root_ide_package_.btpos.source.vdfdsl.serialization.codecs.BinaryIntCodec)
	
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
	val blastRadius get() = _root_ide_package_.btpos.source.vdfdsl.tf2.itemattributes.BonusPenalty<Float, Float>("Blast radius increased", "Blast radius decreased")
	
	/**
	 * In-Game: "N% fuse time on grenades"
	 *
	 * 
	 *
	 * Checked on owner.
	 */
	context(attrs: btpos.source.vdfdsl.modeling.IKeyValueMap)
	var fuseBonus: Float?
		get() = attrs.getTyped("fuse bonus")
		set(value) = attrs.setNullable("fuse bonus", value)
}

