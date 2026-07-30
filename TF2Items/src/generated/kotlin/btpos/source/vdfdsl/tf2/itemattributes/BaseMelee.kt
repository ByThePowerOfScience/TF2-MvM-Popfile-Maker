package btpos.source.vdfdsl.tf2.itemattributes

import btpos.source.vdfdsl.modeling.*
import btpos.source.vdfdsl.serialization.codecs.*
import btpos.source.vdfdsl.tf2.itemattributes.impl.*
import btpos.source.vdfdsl.tf2.tftypes.*
import java.util.*



interface BaseMeleeAttributes : WeaponBaseAttributes {
	companion object {
		/**
		 * Multiplier applied to the bounding box of the swing to detect if a player is inside it.
		 */
		val meleeBoundsMultiplier: ItemAttributeNamed<Float> = ItemAttributeNamed("melee bounds multiplier")
	
		/**
		 * In-Game: "On Miss: Hit yourself. Idiot."
		 * 
		 * Idiot.
		 */
		val hitSelfOnMiss: ItemAttributeNamed<Boolean> = ItemAttributeNamed("hit self on miss")
	
		val afterburn: AfterburnAttributes = AfterburnAttributes()
	
		private val ammo: AmmoAttributes = AmmoAttributes()
	
		val buildings: BuildingsAttributes = BuildingsAttributes()
	
		private val crits: CritsAttributes = CritsAttributes()
	
		private val damage: DamageAttributes = DamageAttributes()
	
		val demoCharge: DemoChargeAttributes = DemoChargeAttributes()
	
		val firing: FiringAttributes = FiringAttributes()
	
		val healthAndHealing: HealthAndHealingAttributes = HealthAndHealingAttributes()
	
		private val knockbackReceived: KnockbackReceivedAttributes = KnockbackReceivedAttributes()
	
		private val meta: MetaAttributes = MetaAttributes()
	
		private val meter: MeterAttributes = MeterAttributes()
	
		val movement: MovementAttributes = MovementAttributes()
	
		val heads: HeadsAttributes = HeadsAttributes()
	
		val onHit: OnHitAttributes = OnHitAttributes()
	
		val onKill: OnKillAttributes = OnKillAttributes()
	
		val projectiles: ProjectilesAttributes = ProjectilesAttributes()
	
		val reloading: ReloadingAttributes = ReloadingAttributes()
	
		private val resistance: ResistanceAttributes = ResistanceAttributes()
	
		val revengeCrits: RevengeCritsAttributes = RevengeCritsAttributes()
	
		val statusEffects: StatusEffectsAttributes = StatusEffectsAttributes()
	
		val taunting: TauntingAttributes = TauntingAttributes()
	
		val viewmodel: ViewmodelAttributes = ViewmodelAttributes()
	
		val swapWeapons: SwapWeaponsAttributes = SwapWeaponsAttributes()
	
		val whenHit: WhenHitAttributes = WhenHitAttributes()
	
		val ragdolls: RagdollsAttributes = RagdollsAttributes()
	}

	override val crits: CritsAttributes get() = BaseMeleeAttributes.crits
	
	override val damage: DamageAttributes get() = BaseMeleeAttributes.damage
	
	override val onHit: OnHitAttributes get() = BaseMeleeAttributes.onHit
	
	override val swapWeapons: SwapWeaponsAttributes get() = BaseMeleeAttributes.swapWeapons
	
	/**
	 * In-Game: "This Weapon has a large melee range and deploys and holsters slower"
	 * 
	 * If true, set swing range to 72, else 48.
	 * 
	 * If true, make weapon deploy and holster 75% slower. (This part can be used on all weapons.  See SwapWeapons.Deploy).
	 */
	override val isASword: ItemAttributeNamed<Boolean> get() = super.isASword
	
	/**
	 * Multiplier applied to the bounding box of the swing to detect if a player is inside it.
	 */
	val meleeBoundsMultiplier: ItemAttributeNamed<Float> get() = BaseMeleeAttributes.meleeBoundsMultiplier
	
	/**
	 * In-Game: "On Miss: Hit yourself. Idiot."
	 * 
	 * Idiot.
	 */
	val hitSelfOnMiss: ItemAttributeNamed<Boolean> get() = BaseMeleeAttributes.hitSelfOnMiss
	
	override val afterburn: AfterburnAttributes get() = BaseMeleeAttributes.afterburn
	
	override val ammo: AmmoAttributes get() = BaseMeleeAttributes.ammo
	
	override val buildings: BuildingsAttributes get() = BaseMeleeAttributes.buildings
	
	override val demoCharge: DemoChargeAttributes get() = BaseMeleeAttributes.demoCharge
	
	override val firing: FiringAttributes get() = BaseMeleeAttributes.firing
	
	override val healthAndHealing: HealthAndHealingAttributes get() = BaseMeleeAttributes.healthAndHealing
	
	override val knockbackReceived: KnockbackReceivedAttributes get() = BaseMeleeAttributes.knockbackReceived
	
	override val meta: MetaAttributes get() = BaseMeleeAttributes.meta
	
	override val meter: MeterAttributes get() = BaseMeleeAttributes.meter
	
	override val movement: MovementAttributes get() = BaseMeleeAttributes.movement
	
	override val heads: HeadsAttributes get() = BaseMeleeAttributes.heads
	
	override val onKill: OnKillAttributes get() = BaseMeleeAttributes.onKill
	
	override val projectiles: ProjectilesAttributes get() = BaseMeleeAttributes.projectiles
	
	override val reloading: ReloadingAttributes get() = BaseMeleeAttributes.reloading
	
	override val resistance: ResistanceAttributes get() = BaseMeleeAttributes.resistance
	
	override val revengeCrits: RevengeCritsAttributes get() = BaseMeleeAttributes.revengeCrits
	
	override val statusEffects: StatusEffectsAttributes get() = BaseMeleeAttributes.statusEffects
	
	override val taunting: TauntingAttributes get() = BaseMeleeAttributes.taunting
	
	override val viewmodel: ViewmodelAttributes get() = BaseMeleeAttributes.viewmodel
	
	override val whenHit: WhenHitAttributes get() = BaseMeleeAttributes.whenHit
	
	override val ragdolls: RagdollsAttributes get() = BaseMeleeAttributes.ragdolls

	open class CritsAttributes : WeaponBaseAttributes.CritsAttributes() {
		/**
		 * In-Game: "Always critical hit from behind"
		 */
		open val critFromBehind: ItemAttributeNamed<Boolean> = ItemAttributeNamed("crit from behind")
	
		/**
		 * In-Game: "Critical hit forces victim to laugh"
		 */
		open val critForcesVictimToLaugh: ItemAttributeNamed<Boolean> = ItemAttributeNamed("crit forces victim to laugh")
	
		/**
		 * In-Game: "Critical hits do no damage"
		 */
		open val critDoesNoDamage: ItemAttributeNamed<Boolean> = ItemAttributeNamed("crit does no damage")
	
		override val critVsBurningPlayers: CritVsBurningPlayersAttributes = CritVsBurningPlayersAttributes()
	
		open class CritVsBurningPlayersAttributes : WeaponBaseAttributes.CritsAttributes.CritVsBurningPlayersAttributes() 
	}
	
	open class DamageAttributes : WeaponBaseAttributes.DamageAttributes() {
		/**
		 * In-Game: "N% increase in damage when health <50% of max"
		 * 
		 * If health < 50%, apply mult.
		 */
		open val dmgBonusWhileHalfDead: ItemAttributeNamed<Float> = ItemAttributeNamed("dmg bonus while half dead")
	
		/**
		 * In-Game: "N% decrease in damage when health >50% of max"
		 * 
		 * If health >= 50%, apply mult.
		 */
		open val dmgPenaltyWhileHalfAlive: ItemAttributeNamed<Float> = ItemAttributeNamed("dmg penalty while half alive")
	
		override val damage: DamageAttributes = DamageAttributes()
	
		open class DamageAttributes : WeaponBaseAttributes.DamageAttributes.DamageAttributes() 
	}
	
	open class OnHitAttributes : WeaponBaseAttributes.OnHitAttributes() {
		/**
		 * In-Game: "Damage removes Sappers"
		 * 
		 * Damage sappers with swing.
		 */
		open val damageAppliesToSappers: ItemAttributeNamed<Int> = ItemAttributeNamed("damage applies to sappers")
	
		/**
		 * In-Game: "On Hit Teammate: Boosts both players' speed for several seconds"
		 * 
		 * Applies speed boost cond to yourself and the teammate you hit.
		 */
		open val speedBuffAlly: ItemAttributeNamed<Boolean> = ItemAttributeNamed("speed buff ally")
	
		/**
		 * In-Game: "Gain a speed boost when you hit an enemy player"
		 * 
		 * Used as arg to addcond speedboost.
		 */
		open val speedBoostOnHitEnemy: ItemAttributeNamed<Float> = ItemAttributeNamed("speed_boost_on_hit_enemy")
	
		/**
		 * In-Game: "On Hit: Force enemies to laugh who are also wearing this item"
		 * 
		 * Force enemies to laugh if they're also wielding this weapon.
		 */
		open val tickleEnemiesWieldingSameWeapon: ItemAttributeNamed<Boolean> = ItemAttributeNamed("tickle enemies wielding same weapon")
	
		override val healOnHitForRapidfire: HealOnHitForRapidfireAttributes = HealOnHitForRapidfireAttributes()
	
		override val generateRageOnDamage: GenerateRageOnDamageAttributes = GenerateRageOnDamageAttributes()
	
		open class HealOnHitForRapidfireAttributes : WeaponBaseAttributes.OnHitAttributes.HealOnHitForRapidfireAttributes() 
	
		open class GenerateRageOnDamageAttributes : WeaponBaseAttributes.OnHitAttributes.GenerateRageOnDamageAttributes() 
	}
	
	open class SwapWeaponsAttributes : WeaponBaseAttributes.SwapWeaponsAttributes() {
		/**
		 * In-Game: "You are Marked-For-Death while active, and for short period after switching weapons"
		 * 
		 * Mark self for death when switching to this weapon.
		 */
		open val selfMarkForDeath: ItemAttributeNamed<Boolean> = ItemAttributeNamed("self mark for death")
	
		override val deploy: DeployAttributes = DeployAttributes()
	
		open class DeployAttributes : WeaponBaseAttributes.SwapWeaponsAttributes.DeployAttributes() 
	}
	
	open class AfterburnAttributes : WeaponBaseAttributes.AfterburnAttributes() 
	
	open class AmmoAttributes : WeaponBaseAttributes.AmmoAttributes() {
		override val clipSize: ClipSizeAttributes = ClipSizeAttributes()
	
		open class ClipSizeAttributes : WeaponBaseAttributes.AmmoAttributes.ClipSizeAttributes() 
	}
	
	open class BuildingsAttributes : WeaponBaseAttributes.BuildingsAttributes() 
	
	open class DemoChargeAttributes : WeaponBaseAttributes.DemoChargeAttributes() 
	
	open class FiringAttributes : WeaponBaseAttributes.FiringAttributes() {
		override val fireRate: FireRateAttributes = FireRateAttributes()
	
		open class FireRateAttributes : WeaponBaseAttributes.FiringAttributes.FireRateAttributes() {
			override val fireRate: FireRateAttributes = FireRateAttributes()
	
			open class FireRateAttributes : WeaponBaseAttributes.FiringAttributes.FireRateAttributes.FireRateAttributes() 
		}
	}
	
	open class HealthAndHealingAttributes : WeaponBaseAttributes.HealthAndHealingAttributes() 
	
	open class KnockbackReceivedAttributes : WeaponBaseAttributes.KnockbackReceivedAttributes() {
		override val damageForceReduction: DamageForceReductionAttributes = DamageForceReductionAttributes()
	
		open class DamageForceReductionAttributes : WeaponBaseAttributes.KnockbackReceivedAttributes.DamageForceReductionAttributes() 
	}
	
	open class MetaAttributes : WeaponBaseAttributes.MetaAttributes() {
		override val killfeed: KillfeedAttributes = KillfeedAttributes()
	
		open class KillfeedAttributes : WeaponBaseAttributes.MetaAttributes.KillfeedAttributes() 
	}
	
	open class MeterAttributes : WeaponBaseAttributes.MeterAttributes() 
	
	open class MovementAttributes : WeaponBaseAttributes.MovementAttributes() {
		override val moveSpeed: MoveSpeedAttributes = MoveSpeedAttributes()
	
		open class MoveSpeedAttributes : WeaponBaseAttributes.MovementAttributes.MoveSpeedAttributes() 
	}
	
	open class HeadsAttributes : WeaponBaseAttributes.HeadsAttributes() 
	
	open class OnKillAttributes : WeaponBaseAttributes.OnKillAttributes() 
	
	open class ProjectilesAttributes : WeaponBaseAttributes.ProjectilesAttributes() {
		override val projectilePenetration: ProjectilePenetrationAttributes = ProjectilePenetrationAttributes()
	
		override val bullets: BulletsAttributes = BulletsAttributes()
	
		open class ProjectilePenetrationAttributes : WeaponBaseAttributes.ProjectilesAttributes.ProjectilePenetrationAttributes() 
	
		open class BulletsAttributes : WeaponBaseAttributes.ProjectilesAttributes.BulletsAttributes() 
	}
	
	open class ReloadingAttributes : WeaponBaseAttributes.ReloadingAttributes() 
	
	open class ResistanceAttributes : WeaponBaseAttributes.ResistanceAttributes() 
	
	open class RevengeCritsAttributes : WeaponBaseAttributes.RevengeCritsAttributes() 
	
	open class StatusEffectsAttributes : WeaponBaseAttributes.StatusEffectsAttributes() 
	
	open class TauntingAttributes : WeaponBaseAttributes.TauntingAttributes() 
	
	open class ViewmodelAttributes : WeaponBaseAttributes.ViewmodelAttributes() 
	
	open class WhenHitAttributes : WeaponBaseAttributes.WhenHitAttributes() 
	
	open class RagdollsAttributes : WeaponBaseAttributes.RagdollsAttributes() 
}