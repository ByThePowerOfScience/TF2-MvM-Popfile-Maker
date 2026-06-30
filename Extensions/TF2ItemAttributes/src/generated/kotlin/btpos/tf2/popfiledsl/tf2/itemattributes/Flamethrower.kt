package btpos.tf2.popfiledsl.tf2.itemattributes

import btpos.tf2.popfiledsl.modeling.*
import btpos.tf2.popfiledsl.serialization.codecs.*


/**
 * Items: TF_WEAPON_FLAMETHROWER, The Backburner, Upgradeable TF_WEAPON_FLAMETHROWER, The Degreaser, The Phlogistinator, Festive Flamethrower 2011, The Rainblower, Silver Botkiller Flame Thrower Mk.I, Gold Botkiller Flame Thrower Mk.I, Rust Botkiller Flame Thrower Mk.I, Blood Botkiller Flame Thrower Mk.I, Carbonado Botkiller Flame Thrower Mk.I, Diamond Botkiller Flame Thrower Mk.I, Silver Botkiller Flame Thrower Mk.II, Gold Botkiller Flame Thrower Mk.II, Festive Backburner 2014, The Nostromo Napalmer
 */
interface FlamethrowerAttributes : WeaponBaseAttributes, IBlockScoped {
	companion object : FlamethrowerAttributes
	
	/**
	 * 
	 *
	 * If greater than 0, enables Phlog crits on having full rage.
	 */
	context(attrs: IKeyValueMap)
	var soldierBuffType: Int?
		get() = attrs.getTyped("mod soldier buff type")
		set(value) = attrs.setNullable("mod soldier buff type", value)
	
	/**
	 * 
	 *
	 * If greater than 0, enables Phlog crits on having full rage.
	 */
	context(attrs: IKeyValueMap)
	var demoBuffType: Int?
		get() = attrs.getTyped("mod demo buff type")
		set(value) = attrs.setNullable("mod demo buff type", value)
	
	/**
	 * In-Game: "No airblast"
	 *
	 * 
	 */
	context(attrs: IKeyValueMap)
	var airblastDisabled: Boolean?
		get() = attrs.getTyped("airblast disabled", BinaryIntCodec)
		set(value) = attrs.setNullable("airblast disabled", value, BinaryIntCodec)
	
	/**
	 * In-Game: "Airblast can now be charged, which will push enemies further"
	 *
	 * 
	 *
	 * Enables charging an airblast for longer for higher push.
	 */
	context(attrs: IKeyValueMap)
	var chargedAirblast: Boolean?
		get() = attrs.getTyped("charged airblast", BinaryIntCodec)
		set(value) = attrs.setNullable("charged airblast", value, BinaryIntCodec)
	
	/**
	 * 
	 */
	val airblastCost get() = AirblastCostAttributes
	
	/**
	 * In-Game: "100% critical hits from behind"
	 *
	 * 
	 */
	context(attrs: IKeyValueMap)
	var flamethrowerBackCrit: Boolean?
		get() = attrs.getTyped("mod flamethrower back crit", BinaryIntCodec)
		set(value) = attrs.setNullable("mod flamethrower back crit", value, BinaryIntCodec)
	
	/**
	 * Bonus:
	 *
	 * 	- In-Game: "N% flamethrower ammo consumed per second"
	 *
	 * 
	 *
	 * Penalty:
	 *
	 * 	- In-Game: "+N% flamethrower ammo consumed per second"
	 *
	 * 
	 */
	val flameAmmopersec get() = BonusPenalty<Float, Float>("flame ammopersec decreased", "flame ammopersec increased")
	
	/**
	 * 
	 *
	 * How long after airblasting until you can fire a primary OR secondary attack.
	 */
	context(attrs: IKeyValueMap)
	var multAirblastRefireTime: Float?
		get() = attrs.getTyped("mult airblast refire time")
		set(value) = attrs.setNullable("mult airblast refire time", value)
	
	/**
	 * 
	 *
	 * Scales the reflect hitbox for your airblast.
	 */
	context(attrs: IKeyValueMap)
	var deflectionSizeMultiplier: Int?
		get() = attrs.getTyped("deflection size multiplier")
		set(value) = attrs.setNullable("deflection size multiplier", value)
	
	/**
	 * In-Game: "Extinguishing teammates restores N health"
	 *
	 * 
	 *
	 * How much health your extinguish restores.
	 */
	context(attrs: IKeyValueMap)
	var extinguishRestoresHealth: Int?
		get() = attrs.getTyped("extinguish restores health")
		set(value) = attrs.setNullable("extinguish restores health", value)
	
	/**
	 * In-Game: "+N% airblast push force"
	 *
	 * 
	 */
	context(attrs: IKeyValueMap)
	var airblastPushbackScale: Float?
		get() = attrs.getTyped("airblast pushback scale")
		set(value) = attrs.setNullable("airblast pushback scale", value)
	
	/**
	 * 
	 */
	context(attrs: IKeyValueMap)
	var airblastVerticalPushbackScale: Float?
		get() = attrs.getTyped("airblast vertical pushback scale")
		set(value) = attrs.setNullable("airblast vertical pushback scale", value)
	
	/**
	 * In-Game: "Halloween Fire"
	 *
	 * 
	 */
	context(attrs: IKeyValueMap)
	var spellHalloweenGreenFlames: Boolean?
		get() = attrs.getTyped("SPELL: Halloween green flames", BinaryIntCodec)
		set(value) = attrs.setNullable("SPELL: Halloween green flames", value, BinaryIntCodec)
	
	/**
	 * Bonus:
	 *
	 * 	- In-Game: "+N% more flame spread area"
	 *
	 * 
	 *
	 * Penalty:
	 *
	 * 	- In-Game: "N% less flame spread area"
	 *
	 * 
	 *
	 * Checked on owner.
	 */
	val flameSize get() = BonusPenalty<Float, Float>("flame size bonus", "flame size penalty")
	
	/**
	 * Bonus:
	 *
	 * 	- In-Game: "+N% more flame distance"
	 *
	 * 
	 *
	 * Penalty:
	 *
	 * 	- In-Game: "N% less flame distance"
	 *
	 * 
	 *
	 * Checked on owner.
	 */
	val flameLife get() = BonusPenalty<Float, Float>("flame life bonus", "flame life penalty")
	
	/**
	 * 
	 */
	context(attrs: IKeyValueMap)
	var airblastDestroyProjectile: Boolean?
		get() = attrs.getTyped("airblast_destroy_projectile", BinaryIntCodec)
		set(value) = attrs.setNullable("airblast_destroy_projectile", value, BinaryIntCodec)
	
	/**
	 * 
	 */
	context(attrs: IKeyValueMap)
	var airblastPushbackDisabled: Boolean?
		get() = attrs.getTyped("airblast_pushback_disabled", BinaryIntCodec)
		set(value) = attrs.setNullable("airblast_pushback_disabled", value, BinaryIntCodec)
	
	/**
	 * 
	 */
	val flame get() = FlameAttributes
}


object AirblastCostAttributes {
	inline operator fun invoke(scope: AirblastCostAttributes.() -> Unit) {
		this.apply(scope)
	}
	/**
	 * In-Game: "+N% airblast cost"
	 */
	context(attrs: IKeyValueMap)
	var airblastCostIncreased: Float?
		get() = attrs.getTyped("airblast cost increased")
		set(value) = attrs.setNullable("airblast cost increased", value)
	
	/**
	 * In-Game: "N% airblast cost"
	 */
	context(attrs: IKeyValueMap)
	var airblastCostDecreased: Float?
		get() = attrs.getTyped("airblast cost decreased")
		set(value) = attrs.setNullable("airblast cost decreased", value)
	
	
	context(attrs: IKeyValueMap)
	var airblastCostScaleHidden: Float?
		get() = attrs.getTyped("airblast cost scale hidden")
		set(value) = attrs.setNullable("airblast cost scale hidden", value)
}


object FlameAttributes {
	inline operator fun invoke(scope: FlameAttributes.() -> Unit) {
		this.apply(scope)
	}
	
	context(attrs: IKeyValueMap)
	var flameSpreadDegree: Int?
		get() = attrs.getTyped("flame_spread_degree")
		set(value) = attrs.setNullable("flame_spread_degree", value)
	
	
	context(attrs: IKeyValueMap)
	var redirectedFlameSizeMult: Float?
		get() = attrs.getTyped("redirected_flame_size_mult")
		set(value) = attrs.setNullable("redirected_flame_size_mult", value)
	
	/**
	 * Bonus:
	 *
	 * 	- In-Game: "+N% more flame spread area"
	 *
	 * 
	 *
	 * Penalty:
	 *
	 * 	- In-Game: "N% less flame spread area"
	 */
	val flameSize get() = BonusPenalty<Float, Float>("flame size bonus", "flame size penalty")
	
	
	context(attrs: IKeyValueMap)
	var multEndFlameSize: Float?
		get() = attrs.getTyped("mult_end_flame_size")
		set(value) = attrs.setNullable("mult_end_flame_size", value)
	
	
	context(attrs: IKeyValueMap)
	var flameIgnorePlayerVelocity: Int?
		get() = attrs.getTyped("flame_ignore_player_velocity")
		set(value) = attrs.setNullable("flame_ignore_player_velocity", value)
	
	
	context(attrs: IKeyValueMap)
	var flameReflectionAddLifeTime: Int?
		get() = attrs.getTyped("flame_reflection_add_life_time")
		set(value) = attrs.setNullable("flame_reflection_add_life_time", value)
	
	
	context(attrs: IKeyValueMap)
	var reflectedFlameDmgReduction: Float?
		get() = attrs.getTyped("reflected_flame_dmg_reduction")
		set(value) = attrs.setNullable("reflected_flame_dmg_reduction", value)
	
	
	context(attrs: IKeyValueMap)
	var maxFlameReflectionCount: Int?
		get() = attrs.getTyped("max_flame_reflection_count")
		set(value) = attrs.setNullable("max_flame_reflection_count", value)
	
	
	context(attrs: IKeyValueMap)
	var flameReflectOnCollision: Boolean?
		get() = attrs.getTyped("flame_reflect_on_collision", BinaryIntCodec)
		set(value) = attrs.setNullable("flame_reflect_on_collision", value, BinaryIntCodec)
	
	
	context(attrs: IKeyValueMap)
	var flameSpeed: Int?
		get() = attrs.getTyped("flame_speed")
		set(value) = attrs.setNullable("flame_speed", value)
	
	
	context(attrs: IKeyValueMap)
	var flameLifetime: Int?
		get() = attrs.getTyped("flame_lifetime")
		set(value) = attrs.setNullable("flame_lifetime", value)
	
	
	context(attrs: IKeyValueMap)
	var flameRandomLifeTimeOffset: Int?
		get() = attrs.getTyped("flame_random_life_time_offset")
		set(value) = attrs.setNullable("flame_random_life_time_offset", value)
	
	
	context(attrs: IKeyValueMap)
	var flameGravity: Int?
		get() = attrs.getTyped("flame_gravity")
		set(value) = attrs.setNullable("flame_gravity", value)
	
	
	context(attrs: IKeyValueMap)
	var flameDrag: Int?
		get() = attrs.getTyped("flame_drag")
		set(value) = attrs.setNullable("flame_drag", value)
	
	
	context(attrs: IKeyValueMap)
	var flameUpSpeed: Int?
		get() = attrs.getTyped("flame_up_speed")
		set(value) = attrs.setNullable("flame_up_speed", value)
}

