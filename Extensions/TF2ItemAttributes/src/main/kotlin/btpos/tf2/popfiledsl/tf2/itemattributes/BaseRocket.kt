package btpos.tf2.popfiledsl.tf2.itemattributes

import btpos.tf2.popfiledsl.modeling.*
import btpos.tf2.popfiledsl.serialization.codecs.*


/**
 * 
 */
abstract class BaseRocketAttributes : BaseProjectileAttributes() {
	companion object : BaseRocketAttributes() {
		operator fun invoke(scope: BaseRocketAttributes.Companion.() -> Unit) {
			this.apply(scope)
		}
	}
	
	/**
	 *     - Uses the "mini rockets" model
	 */
	context(attrs: IKeyValueMap)
	var miniRockets: Boolean?
		get() = attrs.getTyped("mini rockets", BinaryIntCodec)
		set(value) = attrs.setNullable("mini rockets", value, BinaryIntCodec)
	
	/**
	 * Value type: percentage
	 * 
	 *     - If set on anything that fires a rocket, the rocket assumes it was fired by the Air Strike and reduces blast radius to 80%
	 */
	context(attrs: IKeyValueMap)
	var rocketjumpAttackrateBonus: Float?
		get() = attrs.getTyped("rocketjump attackrate bonus")
		set(value) = attrs.setNullable("rocketjump attackrate bonus", value)
	
	/**
	 * 
	 * Bonus:
	 * 	Visible:
	 * 		Value type: percentage
	 * 		
	 * 		+N% projectile speed
	 * 		
	 * 	
	 * 	Hidden:
	 * 		Value type: percentage
	 * 		
	 * 		+N% projectile speed
	 * 		
	 * 
	 * Penalty:
	 * 	Value type: percentage
	 * 	
	 */
	open val ProjectileSpeedDecreased = BonusPenalty_BonusNested<VisHidden<Float, Float>, Float>(VisHidden<Float, Float>("Projectile speed increased", "Projectile speed increased HIDDEN"), "Projectile speed decreased")
	
	
	context(attrs: IKeyValueMap)
	var rocketSpecialist: Int?
		get() = attrs.getTyped("rocket specialist")
		set(value) = attrs.setNullable("rocket specialist", value)
	
	/**
	 *     - Does pumpkin bombs particle effect
	 */
	open context(attrs: IKeyValueMap)
	var SPELLHalloweenPumpkinExplosions: Int?
		get() = attrs.getTyped("SPELL: Halloween pumpkin explosions")
		set(value) = attrs.setNullable("SPELL: Halloween pumpkin explosions", value)
	
	/**
	 *     - Use the big MvM particle when it explodes
	 */
	context(attrs: IKeyValueMap)
	var useLargeSmokeExplosion: Int?
		get() = attrs.getTyped("use large smoke explosion")
		set(value) = attrs.setNullable("use large smoke explosion", value)
	
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
	open val BlastRadiusDecreased = BonusPenalty<Float, Float>("Blast radius increased", "Blast radius decreased")
	
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
	open val BlastRadiusDecreased = BonusPenalty<Float, Float>("Blast radius increased", "Blast radius decreased")
}

