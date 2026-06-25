package btpos.tf2.popfiledsl.tf2.itemattributes

import btpos.tf2.popfiledsl.modeling.*
import btpos.tf2.popfiledsl.serialization.codecs.*


/**
 * Items: TF_WEAPON_BONESAW, The Ubersaw, The Vita-Saw, Upgradeable TF_WEAPON_BONESAW, The Amputator, The Solemn Vow, Festive Ubersaw, Festive Bonesaw 2014
 * 
 */
interface BonesawAttributes : BaseMeleeAttributes {
	companion object : BonesawAttributes
	
	/**
	 * Used to specify "bonesaw type"
	 * 
	 */
	context(attrs: IKeyValueMap)
	var fistsHaveRadialBuff: Boolean?
		get() = attrs.getTyped("fists have radial buff", NumberSelectorCodec(1))
		set(value) = attrs.setNullable("fists have radial buff", value, NumberSelectorCodec(1))
	
	/**
	 * Used to specify "bonesaw type"
	 * 
	 */
	context(attrs: IKeyValueMap)
	var setCloakIsFeignDeath: Boolean?
		get() = attrs.getTyped("set cloak is feign death", NumberSelectorCodec(2))
		set(value) = attrs.setNullable("set cloak is feign death", value, NumberSelectorCodec(2))
	
	/**
	 * Used to specify "bonesaw type"
	 * 
	 */
	context(attrs: IKeyValueMap)
	var modBatLaunchesBalls: Boolean?
		get() = attrs.getTyped("mod bat launches balls", NumberSelectorCodec(1))
		set(value) = attrs.setNullable("mod bat launches balls", value, NumberSelectorCodec(1))
	
	/**
	 * Used to specify "bonesaw type"
	 * 
	 */
	context(attrs: IKeyValueMap)
	var sniperNoHeadshots: Boolean?
		get() = attrs.getTyped("sniper no headshots", NumberSelectorCodec(1))
		set(value) = attrs.setNullable("sniper no headshots", value, NumberSelectorCodec(1))
	
	/**
	 * Used to specify "bonesaw type"
	 * 
	 */
	context(attrs: IKeyValueMap)
	var setCloakIsMovementBased: Boolean?
		get() = attrs.getTyped("set cloak is movement based", NumberSelectorCodec(1))
		set(value) = attrs.setNullable("set cloak is movement based", value, NumberSelectorCodec(1))
	
	/**
	 * Used to specify "bonesaw type"
	 * 
	 */
	context(attrs: IKeyValueMap)
	var revolverUseHitLocations: Boolean?
		get() = attrs.getTyped("revolver use hit locations", NumberSelectorCodec(1))
		set(value) = attrs.setNullable("revolver use hit locations", value, NumberSelectorCodec(1))
	
	/**
	 * Used to specify "bonesaw type"
	 * 
	 */
	context(attrs: IKeyValueMap)
	var modShovelDamageBoost: Boolean?
		get() = attrs.getTyped("mod shovel damage boost", NumberSelectorCodec(1))
		set(value) = attrs.setNullable("mod shovel damage boost", value, NumberSelectorCodec(1))
	
	/**
	 * Used to specify "bonesaw type"
	 * 
	 */
	context(attrs: IKeyValueMap)
	var lunchboxAddsMaxhealthBonus: Boolean?
		get() = attrs.getTyped("lunchbox adds maxhealth bonus", NumberSelectorCodec(1))
		set(value) = attrs.setNullable("lunchbox adds maxhealth bonus", value, NumberSelectorCodec(1))
	
	/**
	 * Used to specify "bonesaw type"
	 * 
	 */
	context(attrs: IKeyValueMap)
	var lunchboxAddsMinicrits: Boolean?
		get() = attrs.getTyped("lunchbox adds minicrits", NumberSelectorCodec(2))
		set(value) = attrs.setNullable("lunchbox adds minicrits", value, NumberSelectorCodec(2))
	
	/**
	 * Used to specify "bonesaw type"
	 * 
	 */
	context(attrs: IKeyValueMap)
	var modShovelSpeedBoost: Boolean?
		get() = attrs.getTyped("mod shovel speed boost", NumberSelectorCodec(2))
		set(value) = attrs.setNullable("mod shovel speed boost", value, NumberSelectorCodec(2))
	
	/**
	 * Used to specify "bonesaw type"
	 * 
	 */
	context(attrs: IKeyValueMap)
	var modBatLaunchesOrnaments: Boolean?
		get() = attrs.getTyped("mod bat launches ornaments", NumberSelectorCodec(2))
		set(value) = attrs.setNullable("mod bat launches ornaments", value, NumberSelectorCodec(2))
	
	/**
	 * Used to specify "bonesaw type"
	 * 
	 */
	context(attrs: IKeyValueMap)
	var setIcicleKnifeMode: Boolean?
		get() = attrs.getTyped("set icicle knife mode", NumberSelectorCodec(3))
		set(value) = attrs.setNullable("set icicle knife mode", value, NumberSelectorCodec(3))
	
	/**
	 * Used to specify "bonesaw type"
	 * 
	 */
	context(attrs: IKeyValueMap)
	var modFlaregunFiresPelletsWithKnockback: Boolean?
		get() = attrs.getTyped("mod flaregun fires pellets with knockback", NumberSelectorCodec(3))
		set(value) = attrs.setNullable("mod flaregun fires pellets with knockback", value, NumberSelectorCodec(3))
	
	/**
	 * If the player should taunt on right click
	 * 
	 */
	context(attrs: IKeyValueMap)
	var specialTaunt: Boolean?
		get() = attrs.getTyped("special taunt", BinaryIntCodec)
		set(value) = attrs.setNullable("special taunt", value, BinaryIntCodec)
	
	/**
	 * Value type: additive_percentage
	 * 
	 * If the player should take a "head" when dealing damage with a melee
	 * 
	 * Also, is there a "speed modifier" for taking heads??????
	 * 
	 */
	context(attrs: IKeyValueMap)
	var addHeadOnHit: Boolean?
		get() = attrs.getTyped("add head on hit", BinaryIntCodec)
		set(value) = attrs.setNullable("add head on hit", value, BinaryIntCodec)
	
	/**
	 * Value type: additive_percentage
	 * 
	 */
	context(attrs: IKeyValueMap)
	var uberchargePreservedOnSpawnMax: Float?
		get() = attrs.getTyped("ubercharge_preserved_on_spawn_max")
		set(value) = attrs.setNullable("ubercharge_preserved_on_spawn_max", value)
	
	/**
	 * Value type: additive_percentage
	 * 
	 * On kill, take an organ (uses "heads" field like usual)
	 * 
	 */
	context(attrs: IKeyValueMap)
	var addHeadOnKill: Boolean?
		get() = attrs.getTyped("add_head_on_kill", BinaryIntCodec)
		set(value) = attrs.setNullable("add_head_on_kill", value, BinaryIntCodec)
}

operator fun BonesawAttributes.invoke(scope: BonesawAttributes.() -> Unit) {
	this.apply(scope)
}

