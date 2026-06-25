package btpos.tf2.popfiledsl.tf2.itemattributes

import btpos.tf2.popfiledsl.modeling.*
import btpos.tf2.popfiledsl.serialization.codecs.*


/**
 * Items: TF_WEAPON_INVIS, The Dead Ringer, The Cloak and Dagger, Upgradeable TF_WEAPON_INVIS, The Quackenbirdt
 * 
 */
abstract class InvisAttributes : WeaponBaseAttributes() {
	companion object : InvisAttributes() {
		operator fun invoke(scope: InvisAttributes.Companion.() -> Unit) {
			this.apply(scope)
		}
	}
	
	/**
	 * How many seconds it takes to decloak (or a multiplier?)
	 * Note that values less than or equal to `0.0` become `1.0`
	 */
	context(attrs: IKeyValueMap)
	var multDecloakRate: Int?
		get() = attrs.getTyped("mult decloak rate")
		set(value) = attrs.setNullable("mult decloak rate", value)
	
	/**
	 * On player
	 * Multiply cloak consumption rate by this value.
	 * 
	 * Bonus:
	 * 	Value type: inverted_percentage
	 * 	
	 * 
	 * Penalty:
	 * 	Value type: percentage
	 * 	
	 */
	val multCloakMeterConsumeRate = BonusPenalty<Float, Float>("cloak consume rate decreased", "mult cloak meter consume rate")
	
	/**
	 * 
	 * Bonus:
	 * 	Value type: percentage
	 * 	
	 * 
	 * Penalty:
	 * 	Value type: percentage
	 * 	
	 */
	val cloakRegenRateDecreased = BonusPenalty<Float, Float>("mult cloak meter regen rate", "cloak regen rate decreased")
}

