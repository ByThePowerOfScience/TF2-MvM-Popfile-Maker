package btpos.tf2.popfiledsl.tf2.itemattributes

import btpos.tf2.popfiledsl.modeling.*
import btpos.tf2.popfiledsl.serialization.codecs.*


/**
 * Items: TF_WEAPON_FLAMETHROWER, The Backburner, Upgradeable TF_WEAPON_FLAMETHROWER, The Degreaser, The Phlogistinator, Festive Flamethrower 2011, The Rainblower, Silver Botkiller Flame Thrower Mk.I, Gold Botkiller Flame Thrower Mk.I, Rust Botkiller Flame Thrower Mk.I, Blood Botkiller Flame Thrower Mk.I, Carbonado Botkiller Flame Thrower Mk.I, Diamond Botkiller Flame Thrower Mk.I, Silver Botkiller Flame Thrower Mk.II, Gold Botkiller Flame Thrower Mk.II, Festive Backburner 2014, The Nostromo Napalmer
 * 
 */
interface FlamethrowerAttributes : WeaponBaseAttributes {
	companion object : FlamethrowerAttributes
	
	/**
	 * Determines flame particle effect
	 * 
	 * 1 = phlog
	 * 
	 * 2 = MvM giant pyrobot
	 * 
	 * 3 = rainblower (Also makes a bubble wand while taunting)
	 * 
	 */
	context(attrs: IKeyValueMap)
	var fistsHaveRadialBuff: Boolean?
		get() = attrs.getTyped("fists have radial buff", NumberSelectorCodec(1))
		set(value) = attrs.setNullable("fists have radial buff", value, NumberSelectorCodec(1))
	
	/**
	 * Determines flame particle effect
	 * 
	 * 1 = phlog
	 * 
	 * 2 = MvM giant pyrobot
	 * 
	 * 3 = rainblower (Also makes a bubble wand while taunting)
	 * 
	 */
	context(attrs: IKeyValueMap)
	var setCloakIsFeignDeath: Boolean?
		get() = attrs.getTyped("set cloak is feign death", NumberSelectorCodec(2))
		set(value) = attrs.setNullable("set cloak is feign death", value, NumberSelectorCodec(2))
	
	/**
	 * Determines flame particle effect
	 * 
	 * 1 = phlog
	 * 
	 * 2 = MvM giant pyrobot
	 * 
	 * 3 = rainblower (Also makes a bubble wand while taunting)
	 * 
	 */
	context(attrs: IKeyValueMap)
	var modBatLaunchesBalls: Boolean?
		get() = attrs.getTyped("mod bat launches balls", NumberSelectorCodec(1))
		set(value) = attrs.setNullable("mod bat launches balls", value, NumberSelectorCodec(1))
	
	/**
	 * Determines flame particle effect
	 * 
	 * 1 = phlog
	 * 
	 * 2 = MvM giant pyrobot
	 * 
	 * 3 = rainblower (Also makes a bubble wand while taunting)
	 * 
	 */
	context(attrs: IKeyValueMap)
	var sniperNoHeadshots: Boolean?
		get() = attrs.getTyped("sniper no headshots", NumberSelectorCodec(1))
		set(value) = attrs.setNullable("sniper no headshots", value, NumberSelectorCodec(1))
	
	/**
	 * Determines flame particle effect
	 * 
	 * 1 = phlog
	 * 
	 * 2 = MvM giant pyrobot
	 * 
	 * 3 = rainblower (Also makes a bubble wand while taunting)
	 * 
	 */
	context(attrs: IKeyValueMap)
	var setCloakIsMovementBased: Boolean?
		get() = attrs.getTyped("set cloak is movement based", NumberSelectorCodec(1))
		set(value) = attrs.setNullable("set cloak is movement based", value, NumberSelectorCodec(1))
	
	/**
	 * Determines flame particle effect
	 * 
	 * 1 = phlog
	 * 
	 * 2 = MvM giant pyrobot
	 * 
	 * 3 = rainblower (Also makes a bubble wand while taunting)
	 * 
	 */
	context(attrs: IKeyValueMap)
	var revolverUseHitLocations: Boolean?
		get() = attrs.getTyped("revolver use hit locations", NumberSelectorCodec(1))
		set(value) = attrs.setNullable("revolver use hit locations", value, NumberSelectorCodec(1))
	
	/**
	 * Determines flame particle effect
	 * 
	 * 1 = phlog
	 * 
	 * 2 = MvM giant pyrobot
	 * 
	 * 3 = rainblower (Also makes a bubble wand while taunting)
	 * 
	 */
	context(attrs: IKeyValueMap)
	var modShovelDamageBoost: Boolean?
		get() = attrs.getTyped("mod shovel damage boost", NumberSelectorCodec(1))
		set(value) = attrs.setNullable("mod shovel damage boost", value, NumberSelectorCodec(1))
	
	/**
	 * Determines flame particle effect
	 * 
	 * 1 = phlog
	 * 
	 * 2 = MvM giant pyrobot
	 * 
	 * 3 = rainblower (Also makes a bubble wand while taunting)
	 * 
	 */
	context(attrs: IKeyValueMap)
	var lunchboxAddsMaxhealthBonus: Boolean?
		get() = attrs.getTyped("lunchbox adds maxhealth bonus", NumberSelectorCodec(1))
		set(value) = attrs.setNullable("lunchbox adds maxhealth bonus", value, NumberSelectorCodec(1))
	
	/**
	 * Determines flame particle effect
	 * 
	 * 1 = phlog
	 * 
	 * 2 = MvM giant pyrobot
	 * 
	 * 3 = rainblower (Also makes a bubble wand while taunting)
	 * 
	 */
	context(attrs: IKeyValueMap)
	var lunchboxAddsMinicrits: Boolean?
		get() = attrs.getTyped("lunchbox adds minicrits", NumberSelectorCodec(2))
		set(value) = attrs.setNullable("lunchbox adds minicrits", value, NumberSelectorCodec(2))
	
	/**
	 * Determines flame particle effect
	 * 
	 * 1 = phlog
	 * 
	 * 2 = MvM giant pyrobot
	 * 
	 * 3 = rainblower (Also makes a bubble wand while taunting)
	 * 
	 */
	context(attrs: IKeyValueMap)
	var modShovelSpeedBoost: Boolean?
		get() = attrs.getTyped("mod shovel speed boost", NumberSelectorCodec(2))
		set(value) = attrs.setNullable("mod shovel speed boost", value, NumberSelectorCodec(2))
	
	/**
	 * Determines flame particle effect
	 * 
	 * 1 = phlog
	 * 
	 * 2 = MvM giant pyrobot
	 * 
	 * 3 = rainblower (Also makes a bubble wand while taunting)
	 * 
	 */
	context(attrs: IKeyValueMap)
	var modBatLaunchesOrnaments: Boolean?
		get() = attrs.getTyped("mod bat launches ornaments", NumberSelectorCodec(2))
		set(value) = attrs.setNullable("mod bat launches ornaments", value, NumberSelectorCodec(2))
	
	/**
	 * Determines flame particle effect
	 * 
	 * 1 = phlog
	 * 
	 * 2 = MvM giant pyrobot
	 * 
	 * 3 = rainblower (Also makes a bubble wand while taunting)
	 * 
	 */
	context(attrs: IKeyValueMap)
	var setIcicleKnifeMode: Boolean?
		get() = attrs.getTyped("set icicle knife mode", NumberSelectorCodec(3))
		set(value) = attrs.setNullable("set icicle knife mode", value, NumberSelectorCodec(3))
	
	/**
	 * Determines flame particle effect
	 * 
	 * 1 = phlog
	 * 
	 * 2 = MvM giant pyrobot
	 * 
	 * 3 = rainblower (Also makes a bubble wand while taunting)
	 * 
	 */
	context(attrs: IKeyValueMap)
	var modFlaregunFiresPelletsWithKnockback: Boolean?
		get() = attrs.getTyped("mod flaregun fires pellets with knockback", NumberSelectorCodec(3))
		set(value) = attrs.setNullable("mod flaregun fires pellets with knockback", value, NumberSelectorCodec(3))
	
	/**
	 * If greater than 0, enables Phlog crits on having full rage
	 * 
	 */
	context(attrs: IKeyValueMap)
	var modSoldierBuffType: Int?
		get() = attrs.getTyped("mod soldier buff type")
		set(value) = attrs.setNullable("mod soldier buff type", value)
	
	/**
	 * If greater than 0, enables Phlog crits on having full rage
	 * 
	 */
	context(attrs: IKeyValueMap)
	var modDemoBuffType: Int?
		get() = attrs.getTyped("mod demo buff type")
		set(value) = attrs.setNullable("mod demo buff type", value)
	
	
	context(attrs: IKeyValueMap)
	var airblastDisabled: Boolean?
		get() = attrs.getTyped("airblast disabled", BinaryIntCodec)
		set(value) = attrs.setNullable("airblast disabled", value, BinaryIntCodec)
	
	/**
	 * Enables charging an airblast for longer for higher push
	 * 
	 * Fun fact: apparently this was going to be a FLAME ROCKET, but got changed later to be an airblast
	 * 
	 */
	context(attrs: IKeyValueMap)
	var chargedAirblast: Boolean?
		get() = attrs.getTyped("charged airblast", BinaryIntCodec)
		set(value) = attrs.setNullable("charged airblast", value, BinaryIntCodec)
	
	/**
	 * 
	 */
	val airblastCostIncreased get() = AirblastCostIncreasedAttributes
	
	
	context(attrs: IKeyValueMap)
	var modFlamethrowerBackCrit: Boolean?
		get() = attrs.getTyped("mod flamethrower back crit", BinaryIntCodec)
		set(value) = attrs.setNullable("mod flamethrower back crit", value, BinaryIntCodec)
	
	/**
	 * 
	 * Bonus:
	 * 	- Value type: percentage
	 * 	- N% flamethrower ammo consumed per second
	 * 
	 * Penalty:
	 * 	- Value type: percentage
	 * 	- +N% flamethrower ammo consumed per second
	 */
	val flameAmmopersecIncreased get() = BonusPenalty<Float, Float>("flame ammopersec decreased", "flame ammopersec increased")
	
	/**
	 * Value type: percentage
	 * 
	 * Multiplier for how long after airblasting until you can fire a primary OR secondary attack
	 * 
	 * Secondary attack delay = 0.75 * this
	 * 
	 */
	context(attrs: IKeyValueMap)
	var multAirblastRefireTime: Float?
		get() = attrs.getTyped("mult airblast refire time")
		set(value) = attrs.setNullable("mult airblast refire time", value)
	
	/**
	 * Scales the reflect hitbox for your airblast
	 * 
	 */
	context(attrs: IKeyValueMap)
	var deflectionSizeMultiplier: Int?
		get() = attrs.getTyped("deflection size multiplier")
		set(value) = attrs.setNullable("deflection size multiplier", value)
	
	/**
	 * How much health your extinguish restores
	 * 
	 */
	context(attrs: IKeyValueMap)
	var extinguishRestoresHealth: Int?
		get() = attrs.getTyped("extinguish restores health")
		set(value) = attrs.setNullable("extinguish restores health", value)
	
	/**
	 * Value type: percentage
	 * 
	 */
	context(attrs: IKeyValueMap)
	var airblastPushbackScale: Float?
		get() = attrs.getTyped("airblast pushback scale")
		set(value) = attrs.setNullable("airblast pushback scale", value)
	
	/**
	 * Value type: percentage
	 * 
	 */
	context(attrs: IKeyValueMap)
	var airblastVerticalPushbackScale: Float?
		get() = attrs.getTyped("airblast vertical pushback scale")
		set(value) = attrs.setNullable("airblast vertical pushback scale", value)
	
	
	context(attrs: IKeyValueMap)
	var sPELLHalloweenGreenFlames: Boolean?
		get() = attrs.getTyped("SPELL: Halloween green flames", BinaryIntCodec)
		set(value) = attrs.setNullable("SPELL: Halloween green flames", value, BinaryIntCodec)
	
	/**
	 * Checked on owner
	 * 
	 * 
	 * Bonus:
	 * 	- Value type: percentage
	 * 	- +N% more flame spread area
	 * 
	 * Penalty:
	 * 	- Value type: percentage
	 * 	- N% less flame spread area
	 */
	val flameSizePenalty get() = BonusPenalty<Float, Float>("flame size bonus", "flame size penalty")
	
	/**
	 * Checked on owner
	 * 
	 * 
	 * Bonus:
	 * 	- Value type: percentage
	 * 	- +N% more flame distance
	 * 
	 * Penalty:
	 * 	- Value type: percentage
	 * 	- N% less flame distance
	 */
	val flameLifePenalty get() = BonusPenalty<Float, Float>("flame life bonus", "flame life penalty")
	
	
	context(attrs: IKeyValueMap)
	var airblastDestroyProjectile: Boolean?
		get() = attrs.getTyped("airblast_destroy_projectile", BinaryIntCodec)
		set(value) = attrs.setNullable("airblast_destroy_projectile", value, BinaryIntCodec)
	
	
	context(attrs: IKeyValueMap)
	var airblastPushbackDisabled: Boolean?
		get() = attrs.getTyped("airblast_pushback_disabled", BinaryIntCodec)
		set(value) = attrs.setNullable("airblast_pushback_disabled", value, BinaryIntCodec)
	
	/**
	 * Items: 
	 * 
	 */
	val flame get() = FlameAttributes
}

operator fun FlamethrowerAttributes.invoke(scope: FlamethrowerAttributes.() -> Unit) {
	this.apply(scope)
}

/**
 * 
 */
object AirblastCostIncreasedAttributes {
	operator fun invoke(scope: AirblastCostIncreasedAttributes.() -> Unit) {
		this.apply(scope)
	}
	
	/**
	 * Value type: percentage
	 * 
	 * +N% airblast cost
	 * 
	 */
	context(attrs: IKeyValueMap)
	var airblastCostIncreased: Float?
		get() = attrs.getTyped("airblast cost increased")
		set(value) = attrs.setNullable("airblast cost increased", value)
	
	/**
	 * Value type: percentage
	 * 
	 * N% airblast cost
	 * 
	 */
	context(attrs: IKeyValueMap)
	var airblastCostDecreased: Float?
		get() = attrs.getTyped("airblast cost decreased")
		set(value) = attrs.setNullable("airblast cost decreased", value)
	
	/**
	 * Value type: percentage
	 * 
	 */
	context(attrs: IKeyValueMap)
	var airblastCostScaleHidden: Float?
		get() = attrs.getTyped("airblast cost scale hidden")
		set(value) = attrs.setNullable("airblast cost scale hidden", value)
}

/**
 * Items: 
 * 
 */
object FlameAttributes {
	operator fun invoke(scope: FlameAttributes.() -> Unit) {
		this.apply(scope)
	}
	
	
	context(attrs: IKeyValueMap)
	var flameSpreadDegree: Int?
		get() = attrs.getTyped("flame_spread_degree")
		set(value) = attrs.setNullable("flame_spread_degree", value)
	
	/**
	 * Value type: percentage
	 * 
	 */
	context(attrs: IKeyValueMap)
	var redirectedFlameSizeMult: Float?
		get() = attrs.getTyped("redirected_flame_size_mult")
		set(value) = attrs.setNullable("redirected_flame_size_mult", value)
	
	/**
	 * 
	 * Bonus:
	 * 	- Value type: percentage
	 * 	- +N% more flame spread area
	 * 
	 * Penalty:
	 * 	- Value type: percentage
	 * 	- N% less flame spread area
	 */
	val flameSizePenalty get() = BonusPenalty<Float, Float>("flame size bonus", "flame size penalty")
	
	/**
	 * Value type: percentage
	 * 
	 */
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
	
	/**
	 * Value type: percentage
	 * 
	 */
	context(attrs: IKeyValueMap)
	var reflectedFlameDmgReduction: Float?
		get() = attrs.getTyped("reflected_flame_dmg_reduction")
		set(value) = attrs.setNullable("reflected_flame_dmg_reduction", value)
	
	
	context(attrs: IKeyValueMap)
	var maxFlameReflectionCount: Int?
		get() = attrs.getTyped("max_flame_reflection_count")
		set(value) = attrs.setNullable("max_flame_reflection_count", value)
	
	
	context(attrs: IKeyValueMap)
	var flameReflectOnCollision: Int?
		get() = attrs.getTyped("flame_reflect_on_collision")
		set(value) = attrs.setNullable("flame_reflect_on_collision", value)
	
	
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

