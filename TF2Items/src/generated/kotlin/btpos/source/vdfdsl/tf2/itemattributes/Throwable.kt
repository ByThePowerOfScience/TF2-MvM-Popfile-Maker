package btpos.source.vdfdsl.tf2.itemattributes

import btpos.source.vdfdsl.modeling.*
import btpos.source.vdfdsl.serialization.codecs.*
import btpos.source.vdfdsl.tf2.itemattributes.impl.*
import btpos.source.vdfdsl.tf2.tftypes.*
import java.util.*



interface ThrowableAttributes : JarAttributes {
	companion object {
		val throwableRechargeTime: ItemAttributeNamed<Float> = ItemAttributeNamed("throwable recharge time")
	
		val throwableDetonationTime: ItemAttributeNamed<Float> = ItemAttributeNamed("throwable detonation time")
	
		/**
		 * For timed explosions.
		 */
		val isThrowablePrimable: ItemAttributeNamed<Boolean> = ItemAttributeNamed("is throwable primable")
	
		/**
		 * For things like distance/power increases.
		 */
		val isThrowableChargeable: ItemAttributeNamed<Boolean> = ItemAttributeNamed("is throwable chargeable")
	
		val projectiles: ProjectilesAttributes = ProjectilesAttributes()
	
		private val meter: MeterAttributes = MeterAttributes()
	
		val onHit: OnHitAttributes = OnHitAttributes()
	
		private val ammo: AmmoAttributes = AmmoAttributes()
	
		private val damage: DamageAttributes = DamageAttributes()
	
		val firing: FiringAttributes = FiringAttributes()
	
		val afterburn: AfterburnAttributes = AfterburnAttributes()
	
		val buildings: BuildingsAttributes = BuildingsAttributes()
	
		private val crits: CritsAttributes = CritsAttributes()
	
		val demoCharge: DemoChargeAttributes = DemoChargeAttributes()
	
		val healthAndHealing: HealthAndHealingAttributes = HealthAndHealingAttributes()
	
		private val knockbackReceived: KnockbackReceivedAttributes = KnockbackReceivedAttributes()
	
		private val meta: MetaAttributes = MetaAttributes()
	
		val movement: MovementAttributes = MovementAttributes()
	
		val heads: HeadsAttributes = HeadsAttributes()
	
		val onKill: OnKillAttributes = OnKillAttributes()
	
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

	val throwableRechargeTime: ItemAttributeNamed<Float> get() = ThrowableAttributes.throwableRechargeTime
	
	val throwableDetonationTime: ItemAttributeNamed<Float> get() = ThrowableAttributes.throwableDetonationTime
	
	/**
	 * For timed explosions.
	 */
	val isThrowablePrimable: ItemAttributeNamed<Boolean> get() = ThrowableAttributes.isThrowablePrimable
	
	/**
	 * For things like distance/power increases.
	 */
	val isThrowableChargeable: ItemAttributeNamed<Boolean> get() = ThrowableAttributes.isThrowableChargeable
	
	override val projectiles: ProjectilesAttributes get() = ThrowableAttributes.projectiles
	
	override val meter: MeterAttributes get() = ThrowableAttributes.meter
	
	override val onHit: OnHitAttributes get() = ThrowableAttributes.onHit
	
	override val ammo: AmmoAttributes get() = ThrowableAttributes.ammo
	
	override val damage: DamageAttributes get() = ThrowableAttributes.damage
	
	override val firing: FiringAttributes get() = ThrowableAttributes.firing
	
	override val afterburn: AfterburnAttributes get() = ThrowableAttributes.afterburn
	
	override val buildings: BuildingsAttributes get() = ThrowableAttributes.buildings
	
	override val crits: CritsAttributes get() = ThrowableAttributes.crits
	
	override val demoCharge: DemoChargeAttributes get() = ThrowableAttributes.demoCharge
	
	override val healthAndHealing: HealthAndHealingAttributes get() = ThrowableAttributes.healthAndHealing
	
	override val knockbackReceived: KnockbackReceivedAttributes get() = ThrowableAttributes.knockbackReceived
	
	override val meta: MetaAttributes get() = ThrowableAttributes.meta
	
	override val movement: MovementAttributes get() = ThrowableAttributes.movement
	
	override val heads: HeadsAttributes get() = ThrowableAttributes.heads
	
	override val onKill: OnKillAttributes get() = ThrowableAttributes.onKill
	
	override val reloading: ReloadingAttributes get() = ThrowableAttributes.reloading
	
	override val resistance: ResistanceAttributes get() = ThrowableAttributes.resistance
	
	override val revengeCrits: RevengeCritsAttributes get() = ThrowableAttributes.revengeCrits
	
	override val statusEffects: StatusEffectsAttributes get() = ThrowableAttributes.statusEffects
	
	override val taunting: TauntingAttributes get() = ThrowableAttributes.taunting
	
	override val viewmodel: ViewmodelAttributes get() = ThrowableAttributes.viewmodel
	
	override val swapWeapons: SwapWeaponsAttributes get() = ThrowableAttributes.swapWeapons
	
	override val whenHit: WhenHitAttributes get() = ThrowableAttributes.whenHit
	
	override val ragdolls: RagdollsAttributes get() = ThrowableAttributes.ragdolls

	open class ProjectilesAttributes : JarAttributes.ProjectilesAttributes() {
		override val bullets: BulletsAttributes = BulletsAttributes()
	
		override val projectilePenetration: ProjectilePenetrationAttributes = ProjectilePenetrationAttributes()
	
		open class BulletsAttributes : JarAttributes.ProjectilesAttributes.BulletsAttributes() 
	
		open class ProjectilePenetrationAttributes : JarAttributes.ProjectilesAttributes.ProjectilePenetrationAttributes() 
	}
	
	open class MeterAttributes : JarAttributes.MeterAttributes() 
	
	open class OnHitAttributes : JarAttributes.OnHitAttributes() {
		override val healOnHitForRapidfire: HealOnHitForRapidfireAttributes = HealOnHitForRapidfireAttributes()
	
		override val generateRageOnDamage: GenerateRageOnDamageAttributes = GenerateRageOnDamageAttributes()
	
		open class HealOnHitForRapidfireAttributes : JarAttributes.OnHitAttributes.HealOnHitForRapidfireAttributes() 
	
		open class GenerateRageOnDamageAttributes : JarAttributes.OnHitAttributes.GenerateRageOnDamageAttributes() 
	}
	
	open class AmmoAttributes : JarAttributes.AmmoAttributes() {
		override val clipSize: ClipSizeAttributes = ClipSizeAttributes()
	
		open class ClipSizeAttributes : JarAttributes.AmmoAttributes.ClipSizeAttributes() 
	}
	
	open class DamageAttributes : JarAttributes.DamageAttributes() {
		override val damage: DamageAttributes = DamageAttributes()
	
		open class DamageAttributes : JarAttributes.DamageAttributes.DamageAttributes() 
	}
	
	open class FiringAttributes : JarAttributes.FiringAttributes() {
		override val fireRate: FireRateAttributes = FireRateAttributes()
	
		open class FireRateAttributes : JarAttributes.FiringAttributes.FireRateAttributes() {
			override val fireRate: FireRateAttributes = FireRateAttributes()
	
			open class FireRateAttributes : JarAttributes.FiringAttributes.FireRateAttributes.FireRateAttributes() 
		}
	}
	
	open class AfterburnAttributes : JarAttributes.AfterburnAttributes() 
	
	open class BuildingsAttributes : JarAttributes.BuildingsAttributes() 
	
	open class CritsAttributes : JarAttributes.CritsAttributes() {
		override val critVsBurningPlayers: CritVsBurningPlayersAttributes = CritVsBurningPlayersAttributes()
	
		open class CritVsBurningPlayersAttributes : JarAttributes.CritsAttributes.CritVsBurningPlayersAttributes() 
	}
	
	open class DemoChargeAttributes : JarAttributes.DemoChargeAttributes() 
	
	open class HealthAndHealingAttributes : JarAttributes.HealthAndHealingAttributes() 
	
	open class KnockbackReceivedAttributes : JarAttributes.KnockbackReceivedAttributes() {
		override val damageForceReduction: DamageForceReductionAttributes = DamageForceReductionAttributes()
	
		open class DamageForceReductionAttributes : JarAttributes.KnockbackReceivedAttributes.DamageForceReductionAttributes() 
	}
	
	open class MetaAttributes : JarAttributes.MetaAttributes() {
		override val killfeed: KillfeedAttributes = KillfeedAttributes()
	
		open class KillfeedAttributes : JarAttributes.MetaAttributes.KillfeedAttributes() 
	}
	
	open class MovementAttributes : JarAttributes.MovementAttributes() {
		override val moveSpeed: MoveSpeedAttributes = MoveSpeedAttributes()
	
		open class MoveSpeedAttributes : JarAttributes.MovementAttributes.MoveSpeedAttributes() 
	}
	
	open class HeadsAttributes : JarAttributes.HeadsAttributes() 
	
	open class OnKillAttributes : JarAttributes.OnKillAttributes() 
	
	open class ReloadingAttributes : JarAttributes.ReloadingAttributes() 
	
	open class ResistanceAttributes : JarAttributes.ResistanceAttributes() 
	
	open class RevengeCritsAttributes : JarAttributes.RevengeCritsAttributes() 
	
	open class StatusEffectsAttributes : JarAttributes.StatusEffectsAttributes() 
	
	open class TauntingAttributes : JarAttributes.TauntingAttributes() 
	
	open class ViewmodelAttributes : JarAttributes.ViewmodelAttributes() 
	
	open class SwapWeaponsAttributes : JarAttributes.SwapWeaponsAttributes() {
		override val deploy: DeployAttributes = DeployAttributes()
	
		open class DeployAttributes : JarAttributes.SwapWeaponsAttributes.DeployAttributes() 
	}
	
	open class WhenHitAttributes : JarAttributes.WhenHitAttributes() 
	
	open class RagdollsAttributes : JarAttributes.RagdollsAttributes() 
}