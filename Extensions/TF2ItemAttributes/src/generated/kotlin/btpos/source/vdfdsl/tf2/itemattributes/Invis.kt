package btpos.source.vdfdsl.tf2.itemattributes

import btpos.source.vdfdsl.modeling.*
import btpos.source.vdfdsl.serialization.codecs.*


/**
 * Items: TF_WEAPON_INVIS, The Dead Ringer, The Cloak and Dagger, Upgradeable TF_WEAPON_INVIS, The Quackenbirdt
 */
interface InvisAttributes : btpos.source.vdfdsl.tf2.itemattributes.WeaponBaseAttributes, btpos.source.vdfdsl.tf2.itemattributes.IBlockScoped {
	companion object : InvisAttributes
	
	/**
	 * In-Game: "Cloak Type: Feign Death. Leave a fake corpse on taking damage and temporarily gain invisibility, speed, and damage resistance."
	 *
	 * 
	 */
	context(attrs: btpos.source.vdfdsl.modeling.IKeyValueMap)
	var setCloakIsFeignDeath: Boolean?
		get() = attrs.getTyped("set cloak is feign death", _root_ide_package_.btpos.source.vdfdsl.serialization.codecs.NumberSelectorCodec(2))
		set(value) = attrs.setNullable("set cloak is feign death", value, _root_ide_package_.btpos.source.vdfdsl.serialization.codecs.NumberSelectorCodec(2))
	
	/**
	 * In-Game: "Cloak Type: Motion Sensitive. Alt-fire: Turn invisible. Cannot attack while invisible. Bumping in to enemies will make you slightly visible to enemies. Cloak drain rate based on movement speed."
	 *
	 * 
	 */
	context(attrs: btpos.source.vdfdsl.modeling.IKeyValueMap)
	var setCloakIsMovementBased: Boolean?
		get() = attrs.getTyped("set cloak is movement based", _root_ide_package_.btpos.source.vdfdsl.serialization.codecs.NumberSelectorCodec(1))
		set(value) = attrs.setNullable("set cloak is movement based", value, _root_ide_package_.btpos.source.vdfdsl.serialization.codecs.NumberSelectorCodec(1))
	
	/**
	 * 
	 *
	 * How many seconds it takes to decloak (or a multiplier).
	 *
	 * Note that values less than or equal to `0.0` become `1.0`.
	 */
	context(attrs: btpos.source.vdfdsl.modeling.IKeyValueMap)
	var multDecloakRate: Int?
		get() = attrs.getTyped("mult decloak rate")
		set(value) = attrs.setNullable("mult decloak rate", value)
	
	/**
	 * Bonus:
	 *
	 * 	- In-Game: "+N% cloak duration"
	 *
	 * 
	 *
	 * Penalty:
	 *
	 * 	- In-Game: "+N% cloak drain rate"
	 *
	 * 
	 *
	 * On player.
	 *
	 * Multiply cloak consumption rate by this value.
	 */
	val multCloakMeterConsumeRate get() = _root_ide_package_.btpos.source.vdfdsl.tf2.itemattributes.BonusPenalty<Float, Float>("cloak consume rate decreased", "mult cloak meter consume rate")
	
	/**
	 * Bonus:
	 *
	 * 	- In-Game: "+N% cloak regen rate"
	 *
	 * 
	 *
	 * Penalty:
	 *
	 * 	- In-Game: "N% cloak regeneration rate"
	 *
	 * 
	 */
	val cloakRegenRate get() = _root_ide_package_.btpos.source.vdfdsl.tf2.itemattributes.BonusPenalty<Float, Float>("mult cloak meter regen rate", "cloak regen rate decreased")
}

