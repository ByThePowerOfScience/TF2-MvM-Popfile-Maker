package btpos.tf2.popfiledsl.tf2.itemattributes

import btpos.tf2.popfiledsl.modeling.*
import btpos.tf2.popfiledsl.serialization.codecs.*


/**
 * 
 */
interface PowerUpBottleAttributes : WearableAttributes {
	companion object : PowerUpBottleAttributes
	
	
	context(attrs: IKeyValueMap)
	var powerupDuration: Int?
		get() = attrs.getTyped("powerup duration")
		set(value) = attrs.setNullable("powerup duration", value)
	
	/**
	 * Adds extra time to the base powerup duration based on level?
	 * 
	 * Checked on player
	 * 
	 */
	context(attrs: IKeyValueMap)
	var canteenSpecialist: Int?
		get() = attrs.getTyped("canteen specialist")
		set(value) = attrs.setNullable("canteen specialist", value)
	
	
	context(attrs: IKeyValueMap)
	var powerupMaxCharges: Int?
		get() = attrs.getTyped("powerup max charges")
		set(value) = attrs.setNullable("powerup max charges", value)
	
	/**
	 * If true, is "base" powerup canteen
	 * 
	 */
	context(attrs: IKeyValueMap)
	var fistsHaveRadialBuff: Boolean?
		get() = attrs.getTyped("fists have radial buff", NumberSelectorCodec(1))
		set(value) = attrs.setNullable("fists have radial buff", value, NumberSelectorCodec(1))
	
	/**
	 * If true, is "base" powerup canteen
	 * 
	 */
	context(attrs: IKeyValueMap)
	var setCloakIsFeignDeath: Boolean?
		get() = attrs.getTyped("set cloak is feign death", NumberSelectorCodec(2))
		set(value) = attrs.setNullable("set cloak is feign death", value, NumberSelectorCodec(2))
	
	/**
	 * If true, is "base" powerup canteen
	 * 
	 */
	context(attrs: IKeyValueMap)
	var modBatLaunchesBalls: Boolean?
		get() = attrs.getTyped("mod bat launches balls", NumberSelectorCodec(1))
		set(value) = attrs.setNullable("mod bat launches balls", value, NumberSelectorCodec(1))
	
	/**
	 * If true, is "base" powerup canteen
	 * 
	 */
	context(attrs: IKeyValueMap)
	var sniperNoHeadshots: Boolean?
		get() = attrs.getTyped("sniper no headshots", NumberSelectorCodec(1))
		set(value) = attrs.setNullable("sniper no headshots", value, NumberSelectorCodec(1))
	
	/**
	 * If true, is "base" powerup canteen
	 * 
	 */
	context(attrs: IKeyValueMap)
	var setCloakIsMovementBased: Boolean?
		get() = attrs.getTyped("set cloak is movement based", NumberSelectorCodec(1))
		set(value) = attrs.setNullable("set cloak is movement based", value, NumberSelectorCodec(1))
	
	/**
	 * If true, is "base" powerup canteen
	 * 
	 */
	context(attrs: IKeyValueMap)
	var revolverUseHitLocations: Boolean?
		get() = attrs.getTyped("revolver use hit locations", NumberSelectorCodec(1))
		set(value) = attrs.setNullable("revolver use hit locations", value, NumberSelectorCodec(1))
	
	/**
	 * If true, is "base" powerup canteen
	 * 
	 */
	context(attrs: IKeyValueMap)
	var modShovelDamageBoost: Boolean?
		get() = attrs.getTyped("mod shovel damage boost", NumberSelectorCodec(1))
		set(value) = attrs.setNullable("mod shovel damage boost", value, NumberSelectorCodec(1))
	
	/**
	 * If true, is "base" powerup canteen
	 * 
	 */
	context(attrs: IKeyValueMap)
	var lunchboxAddsMaxhealthBonus: Boolean?
		get() = attrs.getTyped("lunchbox adds maxhealth bonus", NumberSelectorCodec(1))
		set(value) = attrs.setNullable("lunchbox adds maxhealth bonus", value, NumberSelectorCodec(1))
	
	/**
	 * If true, is "base" powerup canteen
	 * 
	 */
	context(attrs: IKeyValueMap)
	var lunchboxAddsMinicrits: Boolean?
		get() = attrs.getTyped("lunchbox adds minicrits", NumberSelectorCodec(2))
		set(value) = attrs.setNullable("lunchbox adds minicrits", value, NumberSelectorCodec(2))
	
	/**
	 * If true, is "base" powerup canteen
	 * 
	 */
	context(attrs: IKeyValueMap)
	var modShovelSpeedBoost: Boolean?
		get() = attrs.getTyped("mod shovel speed boost", NumberSelectorCodec(2))
		set(value) = attrs.setNullable("mod shovel speed boost", value, NumberSelectorCodec(2))
	
	/**
	 * If true, is "base" powerup canteen
	 * 
	 */
	context(attrs: IKeyValueMap)
	var modBatLaunchesOrnaments: Boolean?
		get() = attrs.getTyped("mod bat launches ornaments", NumberSelectorCodec(2))
		set(value) = attrs.setNullable("mod bat launches ornaments", value, NumberSelectorCodec(2))
	
	/**
	 * If true, is "base" powerup canteen
	 * 
	 */
	context(attrs: IKeyValueMap)
	var setIcicleKnifeMode: Boolean?
		get() = attrs.getTyped("set icicle knife mode", NumberSelectorCodec(3))
		set(value) = attrs.setNullable("set icicle knife mode", value, NumberSelectorCodec(3))
	
	/**
	 * If true, is "base" powerup canteen
	 * 
	 */
	context(attrs: IKeyValueMap)
	var modFlaregunFiresPelletsWithKnockback: Boolean?
		get() = attrs.getTyped("mod flaregun fires pellets with knockback", NumberSelectorCodec(3))
		set(value) = attrs.setNullable("mod flaregun fires pellets with knockback", value, NumberSelectorCodec(3))
	
	/**
	 * Items: 
	 * 
	 */
	val type get() = TypeAttributes
}

operator fun PowerUpBottleAttributes.invoke(scope: PowerUpBottleAttributes.() -> Unit) {
	this.apply(scope)
}

/**
 * Items: 
 * 
 */
object TypeAttributes {
	operator fun invoke(scope: TypeAttributes.() -> Unit) {
		this.apply(scope)
	}
	
	
	context(attrs: IKeyValueMap)
	var critboost: Boolean?
		get() = attrs.getTyped("critboost", BinaryIntCodec)
		set(value) = attrs.setNullable("critboost", value, BinaryIntCodec)
	
	
	context(attrs: IKeyValueMap)
	var ubercharge: Boolean?
		get() = attrs.getTyped("ubercharge", BinaryIntCodec)
		set(value) = attrs.setNullable("ubercharge", value, BinaryIntCodec)
	
	
	context(attrs: IKeyValueMap)
	var recall: Boolean?
		get() = attrs.getTyped("recall", BinaryIntCodec)
		set(value) = attrs.setNullable("recall", value, BinaryIntCodec)
	
	
	context(attrs: IKeyValueMap)
	var buildingInstantUpgrade: Boolean?
		get() = attrs.getTyped("building instant upgrade", BinaryIntCodec)
		set(value) = attrs.setNullable("building instant upgrade", value, BinaryIntCodec)
}

