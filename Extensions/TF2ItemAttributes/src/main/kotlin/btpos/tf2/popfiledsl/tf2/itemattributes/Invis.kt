package btpos.tf2.popfiledsl.tf2.itemattributes

import btpos.tf2.popfiledsl.modeling.*
import btpos.tf2.popfiledsl.serialization.codecs.*


/**
 * Items: TF_WEAPON_INVIS, The Dead Ringer, The Cloak and Dagger, Upgradeable TF_WEAPON_INVIS, The Quackenbirdt
 * 
 */
interface InvisAttributes : WeaponBaseAttributes {
	companion object : InvisAttributes
	
	/**
	 * Used to specify "invis type"
	 * 
	 */
	context(attrs: IKeyValueMap)
	var setCloakIsFeignDeath: Boolean?
		get() = attrs.getTyped("set cloak is feign death", NumberSelectorCodec(2))
		set(value) = attrs.setNullable("set cloak is feign death", value, NumberSelectorCodec(2))
	
	/**
	 * Used to specify "invis type"
	 * 
	 */
	context(attrs: IKeyValueMap)
	var setCloakIsMovementBased: Boolean?
		get() = attrs.getTyped("set cloak is movement based", NumberSelectorCodec(1))
		set(value) = attrs.setNullable("set cloak is movement based", value, NumberSelectorCodec(1))
	
	/**
	 * How many seconds it takes to decloak (or a multiplier?)
	 * 
	 * Note that values less than or equal to `0.0` become `1.0`
	 * 
	 */
	context(attrs: IKeyValueMap)
	var multDecloakRate: Int?
		get() = attrs.getTyped("mult decloak rate")
		set(value) = attrs.setNullable("mult decloak rate", value)
	
	/**
	 * On player
	 * 
	 * Multiply cloak consumption rate by this value.
	 * 
	 * 
	 * Bonus:
	 * 	- Value type: inverted_percentage
	 * 	- +N% cloak duration
	 * 
	 * Penalty:
	 * 	- Value type: percentage
	 * 	- +N% cloak drain rate
	 */
	val multCloakMeterConsumeRate get() = BonusPenalty<Float, Float>("cloak consume rate decreased", "mult cloak meter consume rate")
	
	/**
	 * 
	 * Bonus:
	 * 	- Value type: percentage
	 * 	- +N% cloak regen rate
	 * 
	 * Penalty:
	 * 	- Value type: percentage
	 * 	- N% cloak regeneration rate
	 */
	val cloakRegenRate get() = BonusPenalty<Float, Float>("mult cloak meter regen rate", "cloak regen rate decreased")
}

inline operator fun InvisAttributes.invoke(scope: InvisAttributes.() -> Unit) {
	this.apply(scope)
}

