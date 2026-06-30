package btpos.source.vdfdsl.tf2.itemattributes

import btpos.source.vdfdsl.modeling.*
import btpos.source.vdfdsl.serialization.codecs.*



interface BaseRocketAttributes : btpos.source.vdfdsl.tf2.itemattributes.BaseProjectileAttributes, btpos.source.vdfdsl.tf2.itemattributes.IBlockScoped {
	companion object : BaseRocketAttributes
	
	/**
	 * 
	 *
	 * Uses the "mini rockets" model.
	 */
	context(attrs: btpos.source.vdfdsl.modeling.IKeyValueMap)
	var miniRockets: Boolean?
		get() = attrs.getTyped("mini rockets", _root_ide_package_.btpos.source.vdfdsl.serialization.codecs.BinaryIntCodec)
		set(value) = attrs.setNullable("mini rockets", value, _root_ide_package_.btpos.source.vdfdsl.serialization.codecs.BinaryIntCodec)
	
	/**
	 * In-Game: "Increased attack speed and smaller blast radius while blast jumping"
	 *
	 * 
	 *
	 * If set on anything that fires a rocket, the rocket assumes it was fired by the Air Strike and reduces blast radius to 80%.
	 */
	context(attrs: btpos.source.vdfdsl.modeling.IKeyValueMap)
	var rocketjumpAttackrateBonus: Float?
		get() = attrs.getTyped("rocketjump attackrate bonus")
		set(value) = attrs.setNullable("rocketjump attackrate bonus", value)
	
	/**
	 * Bonus:
	 *
	 * 	- Visible:
	 *
	 * 		- In-Game: "+N% projectile speed"
	 *
	 * 	- Hidden:
	 *
	 * 		- In-Game: "+N% projectile speed"
	 *
	 * 
	 *
	 * Penalty:
	 *
	 * 	- In-Game: "N% projectile speed"
	 *
	 * 
	 */
	val projectileSpeed get() = _root_ide_package_.btpos.source.vdfdsl.tf2.itemattributes.BonusPenalty_BonusNested<btpos.source.vdfdsl.tf2.itemattributes.VisHidden<Float, Float>, Float>(_root_ide_package_.btpos.source.vdfdsl.tf2.itemattributes.VisHidden<Float, Float>("Projectile speed increased", "Projectile speed increased HIDDEN"), "Projectile speed decreased")
	
	/**
	 * In-Game: "+15% rocket speed per point.  On direct hits: rocket does maximum damage, stuns target, and blast radius increased +15% per point."
	 *
	 * 
	 */
	context(attrs: btpos.source.vdfdsl.modeling.IKeyValueMap)
	var rocketSpecialist: Int?
		get() = attrs.getTyped("rocket specialist")
		set(value) = attrs.setNullable("rocket specialist", value)
	
	/**
	 * In-Game: "Pumpkin Bombs"
	 *
	 * 
	 *
	 * Does pumpkin bombs particle effect.
	 */
	context(attrs: btpos.source.vdfdsl.modeling.IKeyValueMap)
	var spellHalloweenPumpkinExplosions: Boolean?
		get() = attrs.getTyped("SPELL: Halloween pumpkin explosions", _root_ide_package_.btpos.source.vdfdsl.serialization.codecs.BinaryIntCodec)
		set(value) = attrs.setNullable("SPELL: Halloween pumpkin explosions", value, _root_ide_package_.btpos.source.vdfdsl.serialization.codecs.BinaryIntCodec)
	
	/**
	 * 
	 *
	 * Use the big MvM particle when it explodes.
	 */
	context(attrs: btpos.source.vdfdsl.modeling.IKeyValueMap)
	var useLargeSmokeExplosion: Int?
		get() = attrs.getTyped("use large smoke explosion")
		set(value) = attrs.setNullable("use large smoke explosion", value)
	
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
	 */
	val blastRadius get() = _root_ide_package_.btpos.source.vdfdsl.tf2.itemattributes.BonusPenalty<Float, Float>("Blast radius increased", "Blast radius decreased")
}

