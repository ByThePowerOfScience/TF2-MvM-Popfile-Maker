package btpos.tf2.popfiledsl.tf2.itemattributes

import btpos.tf2.popfiledsl.modeling.*
import btpos.tf2.popfiledsl.serialization.codecs.*



interface BaseRocketAttributes : BaseProjectileAttributes, IBlockScoped {
	companion object : BaseRocketAttributes
	
	/**
	 * 
	 *
	 * Uses the "mini rockets" model.
	 */
	context(attrs: IKeyValueMap)
	var miniRockets: Boolean?
		get() = attrs.getTyped("mini rockets", BinaryIntCodec)
		set(value) = attrs.setNullable("mini rockets", value, BinaryIntCodec)
	
	/**
	 * In-Game: "Increased attack speed and smaller blast radius while blast jumping"
	 *
	 * 
	 *
	 * If set on anything that fires a rocket, the rocket assumes it was fired by the Air Strike and reduces blast radius to 80%.
	 */
	context(attrs: IKeyValueMap)
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
	val projectileSpeed get() = BonusPenalty_BonusNested<VisHidden<Float, Float>, Float>(VisHidden<Float, Float>("Projectile speed increased", "Projectile speed increased HIDDEN"), "Projectile speed decreased")
	
	/**
	 * In-Game: "+15% rocket speed per point.  On direct hits: rocket does maximum damage, stuns target, and blast radius increased +15% per point."
	 *
	 * 
	 */
	context(attrs: IKeyValueMap)
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
	context(attrs: IKeyValueMap)
	var spellHalloweenPumpkinExplosions: Boolean?
		get() = attrs.getTyped("SPELL: Halloween pumpkin explosions", BinaryIntCodec)
		set(value) = attrs.setNullable("SPELL: Halloween pumpkin explosions", value, BinaryIntCodec)
	
	/**
	 * 
	 *
	 * Use the big MvM particle when it explodes.
	 */
	context(attrs: IKeyValueMap)
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
	val blastRadius get() = BonusPenalty<Float, Float>("Blast radius increased", "Blast radius decreased")
}

