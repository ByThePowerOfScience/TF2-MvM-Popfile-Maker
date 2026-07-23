package btpos.source.vdfdsl.tf2.itemattributes

import btpos.source.vdfdsl.modeling.*
import btpos.source.vdfdsl.serialization.codecs.*
import btpos.source.vdfdsl.tf2.itemattributes.impl.*
import java.util.*

/**
 * Items: TF_WEAPON_INVIS, The Dead Ringer, The Cloak and Dagger, Upgradeable TF_WEAPON_INVIS, The Quackenbirdt, The Enthusiast's Timepiece
 */
interface InvisAttributes : WeaponBaseAttributes, IBlockScoped {
	companion object : InvisAttributes
	
	/**
	 * In-Game: "Cloak Type: Feign Death. Leave a fake corpse on taking damage and temporarily gain invisibility, speed, and damage resistance."
	 *
	 * 
	 *
	 * Used to specify "invis type".
	 */
	context(attrs: IKeyValueMap)
	var setCloakIsFeignDeath: Boolean?
		get() = attrs.getTyped("set cloak is feign death", NumberSelectorCodec(2))
		set(value) = attrs.setNullable("set cloak is feign death", value, NumberSelectorCodec(2))
	
	/**
	 * In-Game: "Cloak Type: Motion Sensitive. Alt-fire: Turn invisible. Cannot attack while invisible. Bumping in to enemies will make you slightly visible to enemies. Cloak drain rate based on movement speed."
	 *
	 * 
	 *
	 * Used to specify "invis type".
	 */
	context(attrs: IKeyValueMap)
	var setCloakIsMovementBased: Boolean?
		get() = attrs.getTyped("set cloak is movement based", NumberSelectorCodec(1))
		set(value) = attrs.setNullable("set cloak is movement based", value, NumberSelectorCodec(1))
	
	/**
	 * 
	 *
	 * How many seconds it takes to decloak.
	 *
	 * Note that values less than or equal to `0.0` become `1.0`.
	 */
	context(attrs: IKeyValueMap)
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
	 * Multiply cloak consumption rate by this value.
	 *
	 * Checked on player.
	 */
	val multCloakMeterConsumeRate get() = BonusPenalty<Number, Number>("cloak consume rate decreased", "mult cloak meter consume rate")
	
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
	val cloakRegenRate get() = BonusPenalty<Number, Number>("mult cloak meter regen rate", "cloak regen rate decreased")
	
	/**
	 * 
	 *
	 * Disallows ammo boxes from affecting the cloak meter.
	 */
	context(attrs: IKeyValueMap)
	var cloakNoRegenFromItems: Boolean?
		get() = attrs.getTyped("mod_cloak_no_regen_from_items", BinaryIntCodec)
		set(value) = attrs.setNullable("mod_cloak_no_regen_from_items", value, BinaryIntCodec)
	
	/**
	 * In-Game: "No cloak meter from ammo boxes when invisible"
	 *
	 * 
	 *
	 * If true, cannot receive cloak while cloaked.
	 */
	context(attrs: IKeyValueMap)
	var noCloakWhenCloaked: Boolean?
		get() = attrs.getTyped("NoCloakWhenCloaked", BinaryIntCodec)
		set(value) = attrs.setNullable("NoCloakWhenCloaked", value, BinaryIntCodec)
	
	/**
	 * In-Game: "N% cloak meter from ammo boxes"
	 *
	 * 
	 *
	 * Multiplier applied to cloak gained from ammo boxes.
	 */
	context(attrs: IKeyValueMap)
	var reducedCloakFromAmmo: Number?
		get() = attrs.getTyped("ReducedCloakFromAmmo")
		set(value) = attrs.setNullable("ReducedCloakFromAmmo", value)
}

