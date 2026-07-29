package btpos.source.vdfdsl.tf2.itemattributes

import btpos.source.vdfdsl.modeling.*
import btpos.source.vdfdsl.serialization.codecs.*
import btpos.source.vdfdsl.tf2.itemattributes.impl.*
import btpos.source.vdfdsl.tf2.tftypes.*
import java.util.*




interface BaseMeleeAttributes : WeaponBaseAttributes {
	
	companion object {
		/**
		 * In-Game: "You are Marked-For-Death while active, and for short period after switching weapons"
		 * 
		 * Marked for death when switching to weapon.
		 */
		val selfMarkForDeath: ItemAttributeNamed<Boolean> = ItemAttributeNamed("self mark for death")
	
		/**
		 * Multiplier applied to the bounding box of the swing to detect if a player is inside it.
		 * 
		 * Yes, it DOES use a bounding box. I think. That's what this implies, I guess.
		 */
		val meleeBoundsMultiplier: ItemAttributeNamed<Float> = ItemAttributeNamed("melee bounds multiplier")
	
		/**
		 * In-Game: "Damage removes Sappers"
		 * 
		 * Damage sappers with swing.
		 */
		val damageAppliesToSappers: ItemAttributeNamed<Int> = ItemAttributeNamed("damage applies to sappers")
	
		/**
		 * In-Game: "On Hit Teammate: Boosts both players' speed for several seconds"
		 * 
		 * Applies speed boost cond to yourself and the teammate you hit.
		 */
		val speedBuffAlly: ItemAttributeNamed<Boolean> = ItemAttributeNamed("speed buff ally")
	
		/**
		 * In-Game: "On Miss: Hit yourself. Idiot."
		 * 
		 * Idiot.
		 */
		val hitSelfOnMiss: ItemAttributeNamed<Boolean> = ItemAttributeNamed("hit self on miss")
	
		/**
		 * In-Game: "Gain a speed boost when you hit an enemy player"
		 * 
		 * Used as arg to addcond speedboost.
		 */
		val speedBoostOnHitEnemy: ItemAttributeNamed<Float> = ItemAttributeNamed("speed_boost_on_hit_enemy")
	
		/**
		 * In-Game: "Always critical hit from behind"
		 */
		val critFromBehind: ItemAttributeNamed<Boolean> = ItemAttributeNamed("crit from behind")
	
		/**
		 * In-Game: "Critical hit forces victim to laugh"
		 */
		val critForcesVictimToLaugh: ItemAttributeNamed<Boolean> = ItemAttributeNamed("crit forces victim to laugh")
	
		/**
		 * In-Game: "On Hit: Force enemies to laugh who are also wearing this item"
		 * 
		 * Force enemies to laugh if they're also wielding this weapon.
		 */
		val tickleEnemiesWieldingSameWeapon: ItemAttributeNamed<Boolean> = ItemAttributeNamed("tickle enemies wielding same weapon")
	
		/**
		 * In-Game: "Critical hits do no damage"
		 */
		val critDoesNoDamage: ItemAttributeNamed<Boolean> = ItemAttributeNamed("crit does no damage")
	
		/**
		 * In-Game: "N% increase in damage when health <50% of max"
		 * 
		 * If health < 50%, apply mult.
		 */
		val dmgBonusWhileHalfDead: ItemAttributeNamed<Float> = ItemAttributeNamed("dmg bonus while half dead")
	
		/**
		 * In-Game: "N% decrease in damage when health >50% of max"
		 * 
		 * If health >= 50%, apply mult.
		 */
		val dmgPenaltyWhileHalfAlive: ItemAttributeNamed<Float> = ItemAttributeNamed("dmg penalty while half alive")
	
		val projectilePenetration: ProjectilePenetrationAttributes = ProjectilePenetrationAttributes()
	
		val damage: DamageAttributes = DamageAttributes()
	
		val fireRate: FireRateAttributes = FireRateAttributes()
	
		val onHit: OnHitAttributes = OnHitAttributes()
	
		val revengeCrits: RevengeCritsAttributes = RevengeCritsAttributes()
	
		val critVsBurningPlayers: CritVsBurningPlayersAttributes = CritVsBurningPlayersAttributes()
	
		val damageForceReduction: DamageForceReductionAttributes = DamageForceReductionAttributes()
	
		val ragdolls: RagdollsAttributes = RagdollsAttributes()
	}

	/**
	 * In-Game: "You are Marked-For-Death while active, and for short period after switching weapons"
	 * 
	 * Marked for death when switching to weapon.
	 */
	val selfMarkForDeath: ItemAttributeNamed<Boolean> get() = BaseMeleeAttributes.selfMarkForDeath
	
	/**
	 * In-Game: "This Weapon has a large melee range and deploys and holsters slower"
	 * 
	 * If 1, set swing range to 72, else 48.
	 */
	override val isASword: ItemAttributeNamed<Boolean> get() = super.isASword
	
	/**
	 * Multiplier applied to the bounding box of the swing to detect if a player is inside it.
	 * 
	 * Yes, it DOES use a bounding box. I think. That's what this implies, I guess.
	 */
	val meleeBoundsMultiplier: ItemAttributeNamed<Float> get() = BaseMeleeAttributes.meleeBoundsMultiplier
	
	/**
	 * In-Game: "Damage removes Sappers"
	 * 
	 * Damage sappers with swing.
	 */
	val damageAppliesToSappers: ItemAttributeNamed<Int> get() = BaseMeleeAttributes.damageAppliesToSappers
	
	/**
	 * In-Game: "On Hit Teammate: Boosts both players' speed for several seconds"
	 * 
	 * Applies speed boost cond to yourself and the teammate you hit.
	 */
	val speedBuffAlly: ItemAttributeNamed<Boolean> get() = BaseMeleeAttributes.speedBuffAlly
	
	/**
	 * In-Game: "On Miss: Hit yourself. Idiot."
	 * 
	 * Idiot.
	 */
	val hitSelfOnMiss: ItemAttributeNamed<Boolean> get() = BaseMeleeAttributes.hitSelfOnMiss
	
	/**
	 * In-Game: "Gain a speed boost when you hit an enemy player"
	 * 
	 * Used as arg to addcond speedboost.
	 */
	val speedBoostOnHitEnemy: ItemAttributeNamed<Float> get() = BaseMeleeAttributes.speedBoostOnHitEnemy
	
	/**
	 * In-Game: "Always critical hit from behind"
	 */
	val critFromBehind: ItemAttributeNamed<Boolean> get() = BaseMeleeAttributes.critFromBehind
	
	/**
	 * In-Game: "Critical hit forces victim to laugh"
	 */
	val critForcesVictimToLaugh: ItemAttributeNamed<Boolean> get() = BaseMeleeAttributes.critForcesVictimToLaugh
	
	/**
	 * In-Game: "On Hit: Force enemies to laugh who are also wearing this item"
	 * 
	 * Force enemies to laugh if they're also wielding this weapon.
	 */
	val tickleEnemiesWieldingSameWeapon: ItemAttributeNamed<Boolean> get() = BaseMeleeAttributes.tickleEnemiesWieldingSameWeapon
	
	/**
	 * In-Game: "Critical hits do no damage"
	 */
	val critDoesNoDamage: ItemAttributeNamed<Boolean> get() = BaseMeleeAttributes.critDoesNoDamage
	
	/**
	 * In-Game: "N% increase in damage when health <50% of max"
	 * 
	 * If health < 50%, apply mult.
	 */
	val dmgBonusWhileHalfDead: ItemAttributeNamed<Float> get() = BaseMeleeAttributes.dmgBonusWhileHalfDead
	
	/**
	 * In-Game: "N% decrease in damage when health >50% of max"
	 * 
	 * If health >= 50%, apply mult.
	 */
	val dmgPenaltyWhileHalfAlive: ItemAttributeNamed<Float> get() = BaseMeleeAttributes.dmgPenaltyWhileHalfAlive
	
	override val projectilePenetration: ProjectilePenetrationAttributes get() = BaseMeleeAttributes.projectilePenetration
	
	override val damage: DamageAttributes get() = BaseMeleeAttributes.damage
	
	override val fireRate: FireRateAttributes get() = BaseMeleeAttributes.fireRate
	
	override val onHit: OnHitAttributes get() = BaseMeleeAttributes.onHit
	
	override val revengeCrits: RevengeCritsAttributes get() = BaseMeleeAttributes.revengeCrits
	
	override val critVsBurningPlayers: CritVsBurningPlayersAttributes get() = BaseMeleeAttributes.critVsBurningPlayers
	
	override val damageForceReduction: DamageForceReductionAttributes get() = BaseMeleeAttributes.damageForceReduction
	
	override val ragdolls: RagdollsAttributes get() = BaseMeleeAttributes.ragdolls

	
	open class ProjectilePenetrationAttributes : WeaponBaseAttributes.ProjectilePenetrationAttributes() 
	
	
	open class DamageAttributes : WeaponBaseAttributes.DamageAttributes() 
	
	
	open class FireRateAttributes : WeaponBaseAttributes.FireRateAttributes() 
	
	
	open class OnHitAttributes : WeaponBaseAttributes.OnHitAttributes() {
		override val healOnHitForRapidfire: HealOnHitForRapidfireAttributes = HealOnHitForRapidfireAttributes()
	
		override val generateRageOnDamage: GenerateRageOnDamageAttributes = GenerateRageOnDamageAttributes()
	
	
		open class HealOnHitForRapidfireAttributes : WeaponBaseAttributes.OnHitAttributes.HealOnHitForRapidfireAttributes() 
	
	
		open class GenerateRageOnDamageAttributes : WeaponBaseAttributes.OnHitAttributes.GenerateRageOnDamageAttributes() 
	}
	
	
	open class RevengeCritsAttributes : WeaponBaseAttributes.RevengeCritsAttributes() 
	
	
	open class CritVsBurningPlayersAttributes : WeaponBaseAttributes.CritVsBurningPlayersAttributes() 
	
	
	open class DamageForceReductionAttributes : WeaponBaseAttributes.DamageForceReductionAttributes() 
	
	
	open class RagdollsAttributes : WeaponBaseAttributes.RagdollsAttributes() 
}