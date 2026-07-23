package btpos.source.vdfdsl.tf2.itemattributes

import btpos.source.vdfdsl.modeling.*
import btpos.source.vdfdsl.serialization.codecs.*
import btpos.source.vdfdsl.tf2.itemattributes.impl.*
import java.util.*


object PowerUpBottleAttributes {
	inline operator fun invoke(scope: PowerUpBottleAttributes.() -> Unit) {
		this.apply(scope)
	}
	
	val type get() = TypeAttributes
	
	/**
	 * In-Game: "Each charge lasts N seconds"
	 */
	context(attrs: IKeyValueMap)
	var powerupDuration: Int?
		get() = attrs.getTyped("powerup duration")
		set(value) = attrs.setNullable("powerup duration", value)
	
	/**
	 * In-Game: "Share Canteens with your heal target. +1 duration, -10 price per point (minimum cost: 5)"
	 */
	context(attrs: IKeyValueMap)
	var canteenSpecialist: Int?
		get() = attrs.getTyped("canteen specialist")
		set(value) = attrs.setNullable("canteen specialist", value)
	
	/**
	 * In-Game: "Holds a maximum of N charges"
	 */
	context(attrs: IKeyValueMap)
	var powerupMaxCharges: Int?
		get() = attrs.getTyped("powerup max charges")
		set(value) = attrs.setNullable("powerup max charges", value)
	
	/**
	 * In-Game: "On Kill: +50 health on nearby teammates On Kill: +10% Crit Chance on nearby teammates"
	 */
	context(attrs: IKeyValueMap)
	var fistsHaveRadialBuff: Boolean?
		get() = attrs.getTyped("fists have radial buff", NumberSelectorCodec(1))
		set(value) = attrs.setNullable("fists have radial buff", value, NumberSelectorCodec(1))
	
	/**
	 * In-Game: "Cloak Type: Feign Death. Leave a fake corpse on taking damage and temporarily gain invisibility, speed, and damage resistance."
	 */
	context(attrs: IKeyValueMap)
	var setCloakIsFeignDeath: Boolean?
		get() = attrs.getTyped("set cloak is feign death", NumberSelectorCodec(2))
		set(value) = attrs.setNullable("set cloak is feign death", value, NumberSelectorCodec(2))
	
	/**
	 * In-Game: "Alt-Fire: Launches a ball that slows opponents"
	 */
	context(attrs: IKeyValueMap)
	var batLaunchesBalls: Boolean?
		get() = attrs.getTyped("mod bat launches balls", NumberSelectorCodec(1))
		set(value) = attrs.setNullable("mod bat launches balls", value, NumberSelectorCodec(1))
	
	/**
	 * In-Game: "No headshots"
	 */
	context(attrs: IKeyValueMap)
	var cannotHeadshot: Boolean?
		get() = attrs.getTyped("sniper no headshots", NumberSelectorCodec(1))
		set(value) = attrs.setNullable("sniper no headshots", value, NumberSelectorCodec(1))
	
	/**
	 * In-Game: "Cloak Type: Motion Sensitive. Alt-fire: Turn invisible. Cannot attack while invisible. Bumping in to enemies will make you slightly visible to enemies. Cloak drain rate based on movement speed."
	 */
	context(attrs: IKeyValueMap)
	var setCloakIsMovementBased: Boolean?
		get() = attrs.getTyped("set cloak is movement based", NumberSelectorCodec(1))
		set(value) = attrs.setNullable("set cloak is movement based", value, NumberSelectorCodec(1))
	
	/**
	 * In-Game: "Crits on headshot"
	 */
	context(attrs: IKeyValueMap)
	var revolverUseHitLocations: Boolean?
		get() = attrs.getTyped("revolver use hit locations", NumberSelectorCodec(1))
		set(value) = attrs.setNullable("revolver use hit locations", value, NumberSelectorCodec(1))
	
	/**
	 * In-Game: "Damage increases as the user becomes injured"
	 */
	context(attrs: IKeyValueMap)
	var isEqualizer: Boolean?
		get() = attrs.getTyped("mod shovel damage boost", NumberSelectorCodec(1))
		set(value) = attrs.setNullable("mod shovel damage boost", value, NumberSelectorCodec(1))
	
	/**
	 * In-Game: "Adds +50 max health for 30 seconds"
	 */
	context(attrs: IKeyValueMap)
	var lunchboxAddsMaxhealthBonus: Boolean?
		get() = attrs.getTyped("lunchbox adds maxhealth bonus", NumberSelectorCodec(1))
		set(value) = attrs.setNullable("lunchbox adds maxhealth bonus", value, NumberSelectorCodec(1))
	
	/**
	 * In-Game: "Sets weapon mode #N"
	 */
	context(attrs: IKeyValueMap)
	var lunchboxAddsMinicrits: Boolean?
		get() = attrs.getTyped("lunchbox adds minicrits", NumberSelectorCodec(2))
		set(value) = attrs.setNullable("lunchbox adds minicrits", value, NumberSelectorCodec(2))
	
	/**
	 * In-Game: "Move speed increases as the user becomes injured"
	 */
	context(attrs: IKeyValueMap)
	var isEscapePlan: Boolean?
		get() = attrs.getTyped("mod shovel speed boost", NumberSelectorCodec(2))
		set(value) = attrs.setNullable("mod shovel speed boost", value, NumberSelectorCodec(2))
	
	/**
	 * In-Game: "Alt-Fire: Launches a festive ornament that shatters causing bleed"
	 */
	context(attrs: IKeyValueMap)
	var batLaunchesOrnaments: Boolean?
		get() = attrs.getTyped("mod bat launches ornaments", NumberSelectorCodec(2))
		set(value) = attrs.setNullable("mod bat launches ornaments", value, NumberSelectorCodec(2))
	
	
	context(attrs: IKeyValueMap)
	var setIcicleKnifeMode: Boolean?
		get() = attrs.getTyped("set icicle knife mode", NumberSelectorCodec(3))
		set(value) = attrs.setNullable("set icicle knife mode", value, NumberSelectorCodec(3))
	
	/**
	 * In-Game: "Flare knocks back target on hit and explodes when it hits the ground. Increased knock back on burning players"
	 */
	context(attrs: IKeyValueMap)
	var flaregunFiresPelletsWithKnockback: Boolean?
		get() = attrs.getTyped("mod flaregun fires pellets with knockback", NumberSelectorCodec(3))
		set(value) = attrs.setNullable("mod flaregun fires pellets with knockback", value, NumberSelectorCodec(3))
}


object TypeAttributes {
	inline operator fun invoke(scope: TypeAttributes.() -> Unit) {
		this.apply(scope)
	}
	/**
	 * In-Game: "Consumable: Become Crit Boosted for 5 seconds (and double your sentry's firing speed)"
	 */
	context(attrs: IKeyValueMap)
	var critboost: Boolean?
		get() = attrs.getTyped("critboost", BinaryIntCodec)
		set(value) = attrs.setNullable("critboost", value, BinaryIntCodec)
	
	/**
	 * In-Game: "Consumable: Become Übercharged for 5 seconds (and shield your sentry from damage)"
	 */
	context(attrs: IKeyValueMap)
	var ubercharge: Boolean?
		get() = attrs.getTyped("ubercharge", BinaryIntCodec)
		set(value) = attrs.setNullable("ubercharge", value, BinaryIntCodec)
	
	/**
	 * In-Game: "Consumable: Instantly teleport to spawn"
	 */
	context(attrs: IKeyValueMap)
	var recall: Boolean?
		get() = attrs.getTyped("recall", BinaryIntCodec)
		set(value) = attrs.setNullable("recall", value, BinaryIntCodec)
	
	/**
	 * In-Game: "Consumable: Instantly refill all weapon clips and ammo"
	 */
	context(attrs: IKeyValueMap)
	var refillAmmo: Boolean?
		get() = attrs.getTyped("refill_ammo", BinaryIntCodec)
		set(value) = attrs.setNullable("refill_ammo", value, BinaryIntCodec)
	
	/**
	 * In-Game: "Consumable: Instantly upgrade all buildings to max level"
	 */
	context(attrs: IKeyValueMap)
	var buildingInstantUpgrade: Boolean?
		get() = attrs.getTyped("building instant upgrade", BinaryIntCodec)
		set(value) = attrs.setNullable("building instant upgrade", value, BinaryIntCodec)
}

