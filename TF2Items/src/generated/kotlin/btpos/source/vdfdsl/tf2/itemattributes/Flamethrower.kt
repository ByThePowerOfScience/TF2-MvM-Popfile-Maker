package btpos.source.vdfdsl.tf2.itemattributes

import btpos.source.vdfdsl.modeling.*
import btpos.source.vdfdsl.serialization.codecs.*
import btpos.source.vdfdsl.tf2.itemattributes.impl.*
import java.util.*

/**
 * Items: TF_WEAPON_FLAMETHROWER, The Backburner, Upgradeable TF_WEAPON_FLAMETHROWER, The Degreaser, The Phlogistinator, Festive Flamethrower 2011, The Rainblower, Silver Botkiller Flame Thrower Mk.I, Gold Botkiller Flame Thrower Mk.I, Rust Botkiller Flame Thrower Mk.I, Blood Botkiller Flame Thrower Mk.I, Carbonado Botkiller Flame Thrower Mk.I, Diamond Botkiller Flame Thrower Mk.I, Silver Botkiller Flame Thrower Mk.II, Gold Botkiller Flame Thrower Mk.II, Festive Backburner 2014, The Nostromo Napalmer
 */
interface FlamethrowerAttributes : WeaponBaseAttributes, IBlockScoped {
	companion object : FlamethrowerAttributes
	
	/**
	 * 
	 *
	 * Note that Phlogistinator's rage has a small cooldown after expiring before it can gain rage again, to prevent the lingering crit flames from immediately filling it up again.
	 *
	 * If greater than 0, enables Phlog crits on having full rage.
	 */
	context(attrs: IKeyValueMap)
	override var soldierBuffType: Int?
		get() = super.soldierBuffType
		set(value) { super.soldierBuffType = value }
	
	/**
	 * 
	 *
	 * Note that Phlogistinator's rage has a small cooldown after expiring before it can gain rage again, to prevent the lingering crit flames from immediately filling it up again.
	 *
	 * If greater than 0, enables Phlog crits on having full rage.
	 */
	context(attrs: IKeyValueMap)
	override var demoBuffType: Int?
		get() = super.demoBuffType
		set(value) { super.demoBuffType = value }
	
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
	val flameAmmopersec get() = BonusPenalty<Number, Number>("flame ammopersec decreased", "flame ammopersec increased")
	
	/**
	 * 
	 *
	 * How long after airblasting until you can fire a primary OR secondary attack.
	 */
	context(attrs: IKeyValueMap)
	var multAirblastRefireTime: Number?
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
	var airblastPushbackScale: Number?
		get() = attrs.getTyped("airblast pushback scale")
		set(value) = attrs.setNullable("airblast pushback scale", value)
	
	/**
	 * 
	 */
	context(attrs: IKeyValueMap)
	var airblastVerticalPushbackScale: Number?
		get() = attrs.getTyped("airblast vertical pushback scale")
		set(value) = attrs.setNullable("airblast vertical pushback scale", value)
	
	/**
	 * In-Game: "Halloween Fire"
	 *
	 * 
	 *
	 * Makes afterburn green.
	 */
	context(attrs: IKeyValueMap)
	override var spellHalloweenGreenFlames: Boolean?
		get() = super.spellHalloweenGreenFlames
		set(value) { super.spellHalloweenGreenFlames = value }
	
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
	val flameSize get() = BonusPenalty<Number, Number>("flame size bonus", "flame size penalty")
	
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
	val flameLife get() = BonusPenalty<Number, Number>("flame life bonus", "flame life penalty")
	
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
	var airblastCostIncreased: Number?
		get() = attrs.getTyped("airblast cost increased")
		set(value) = attrs.setNullable("airblast cost increased", value)
	
	/**
	 * In-Game: "N% airblast cost"
	 */
	context(attrs: IKeyValueMap)
	var airblastCostDecreased: Number?
		get() = attrs.getTyped("airblast cost decreased")
		set(value) = attrs.setNullable("airblast cost decreased", value)
	
	
	context(attrs: IKeyValueMap)
	var airblastCostScaleHidden: Number?
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
	var redirectedFlameSizeMult: Number?
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
	val flameSize get() = BonusPenalty<Number, Number>("flame size bonus", "flame size penalty")
	
	
	context(attrs: IKeyValueMap)
	var multEndFlameSize: Number?
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
	var reflectedFlameDmgReduction: Number?
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

