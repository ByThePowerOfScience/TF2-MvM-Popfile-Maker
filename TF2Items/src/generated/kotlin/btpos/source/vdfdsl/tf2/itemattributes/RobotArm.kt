package btpos.source.vdfdsl.tf2.itemattributes

import btpos.source.vdfdsl.modeling.*
import btpos.source.vdfdsl.serialization.codecs.*
import btpos.source.vdfdsl.tf2.itemattributes.impl.*
import btpos.source.vdfdsl.tf2.tftypes.*
import java.util.*
import kotlin.time.Duration

interface RobotArmAttributes : IBlockScoped, WrenchAttributes {
	companion object : IBlockScoped {
		private val buildings: BuildingsAttributes = BuildingsAttributes()
	
		private val crits: CritsAttributes = CritsAttributes()
	
		private val damage: DamageAttributes = DamageAttributes()
	
		private val onHit: OnHitAttributes = OnHitAttributes()
	
		private val swapWeapons: SwapWeaponsAttributes = SwapWeaponsAttributes()
	
		private val afterburn: AfterburnAttributes = AfterburnAttributes()
	
		private val ammo: AmmoAttributes = AmmoAttributes()
	
		private val demoCharge: DemoChargeAttributes = DemoChargeAttributes()
	
		private val firing: FiringAttributes = FiringAttributes()
	
		private val healthAndHealing: HealthAndHealingAttributes = HealthAndHealingAttributes()
	
		private val knockbackReceived: KnockbackReceivedAttributes = KnockbackReceivedAttributes()
	
		private val meta: MetaAttributes = MetaAttributes()
	
		private val meter: MeterAttributes = MeterAttributes()
	
		private val movement: MovementAttributes = MovementAttributes()
	
		private val heads: HeadsAttributes = HeadsAttributes()
	
		private val onKill: OnKillAttributes = OnKillAttributes()
	
		private val projectiles: ProjectilesAttributes = ProjectilesAttributes()
	
		private val reloading: ReloadingAttributes = ReloadingAttributes()
	
		private val resistance: ResistanceAttributes = ResistanceAttributes()
	
		private val revengeCrits: RevengeCritsAttributes = RevengeCritsAttributes()
	
		private val statusEffects: StatusEffectsAttributes = StatusEffectsAttributes()
	
		private val taunting: TauntingAttributes = TauntingAttributes()
	
		private val whenHit: WhenHitAttributes = WhenHitAttributes()
	
		private val ragdolls: RagdollsAttributes = RagdollsAttributes()
	
		private val disguise: DisguiseAttributes = DisguiseAttributes()
	}

	override val buildings: BuildingsAttributes get() = RobotArmAttributes.buildings
	
	override val crits: CritsAttributes get() = RobotArmAttributes.crits
	
	override val damage: DamageAttributes get() = RobotArmAttributes.damage
	
	override val onHit: OnHitAttributes get() = RobotArmAttributes.onHit
	
	override val swapWeapons: SwapWeaponsAttributes get() = RobotArmAttributes.swapWeapons
	
	override val afterburn: AfterburnAttributes get() = RobotArmAttributes.afterburn
	
	override val ammo: AmmoAttributes get() = RobotArmAttributes.ammo
	
	override val demoCharge: DemoChargeAttributes get() = RobotArmAttributes.demoCharge
	
	override val firing: FiringAttributes get() = RobotArmAttributes.firing
	
	override val healthAndHealing: HealthAndHealingAttributes get() = RobotArmAttributes.healthAndHealing
	
	override val knockbackReceived: KnockbackReceivedAttributes get() = RobotArmAttributes.knockbackReceived
	
	override val meta: MetaAttributes get() = RobotArmAttributes.meta
	
	override val meter: MeterAttributes get() = RobotArmAttributes.meter
	
	override val movement: MovementAttributes get() = RobotArmAttributes.movement
	
	override val heads: HeadsAttributes get() = RobotArmAttributes.heads
	
	override val onKill: OnKillAttributes get() = RobotArmAttributes.onKill
	
	override val projectiles: ProjectilesAttributes get() = RobotArmAttributes.projectiles
	
	override val reloading: ReloadingAttributes get() = RobotArmAttributes.reloading
	
	override val resistance: ResistanceAttributes get() = RobotArmAttributes.resistance
	
	override val revengeCrits: RevengeCritsAttributes get() = RobotArmAttributes.revengeCrits
	
	override val statusEffects: StatusEffectsAttributes get() = RobotArmAttributes.statusEffects
	
	override val taunting: TauntingAttributes get() = RobotArmAttributes.taunting
	
	override val whenHit: WhenHitAttributes get() = RobotArmAttributes.whenHit
	
	override val ragdolls: RagdollsAttributes get() = RobotArmAttributes.ragdolls
	
	override val disguise: DisguiseAttributes get() = RobotArmAttributes.disguise

	open class BuildingsAttributes : WrenchAttributes.BuildingsAttributes() {
		override val sentryGun: SentryGunAttributes = SentryGunAttributes()
	
		open class SentryGunAttributes : WrenchAttributes.BuildingsAttributes.SentryGunAttributes() 
	}
	
	open class CritsAttributes : WrenchAttributes.CritsAttributes() 
	
	open class DamageAttributes : WrenchAttributes.DamageAttributes() 
	
	open class OnHitAttributes : WrenchAttributes.OnHitAttributes() {
		override val healOnHitForRapidfire: HealOnHitForRapidfireAttributes = HealOnHitForRapidfireAttributes()
	
		override val generateRageOnDamage: GenerateRageOnDamageAttributes = GenerateRageOnDamageAttributes()
	
		open class HealOnHitForRapidfireAttributes : WrenchAttributes.OnHitAttributes.HealOnHitForRapidfireAttributes() 
	
		open class GenerateRageOnDamageAttributes : WrenchAttributes.OnHitAttributes.GenerateRageOnDamageAttributes() 
	}
	
	open class SwapWeaponsAttributes : WrenchAttributes.SwapWeaponsAttributes() {
		override val deploy: DeployAttributes = DeployAttributes()
	
		open class DeployAttributes : WrenchAttributes.SwapWeaponsAttributes.DeployAttributes() 
	}
	
	open class AfterburnAttributes : WrenchAttributes.AfterburnAttributes() 
	
	open class AmmoAttributes : WrenchAttributes.AmmoAttributes() {
		override val clipSize: ClipSizeAttributes = ClipSizeAttributes()
	
		open class ClipSizeAttributes : WrenchAttributes.AmmoAttributes.ClipSizeAttributes() 
	}
	
	open class DemoChargeAttributes : WrenchAttributes.DemoChargeAttributes() 
	
	open class FiringAttributes : WrenchAttributes.FiringAttributes() {
		override val fireRate: FireRateAttributes = FireRateAttributes()
	
		open class FireRateAttributes : WrenchAttributes.FiringAttributes.FireRateAttributes() 
	}
	
	open class HealthAndHealingAttributes : WrenchAttributes.HealthAndHealingAttributes() 
	
	open class KnockbackReceivedAttributes : WrenchAttributes.KnockbackReceivedAttributes() {
		override val damageForceReduction: DamageForceReductionAttributes = DamageForceReductionAttributes()
	
		open class DamageForceReductionAttributes : WrenchAttributes.KnockbackReceivedAttributes.DamageForceReductionAttributes() 
	}
	
	open class MetaAttributes : WrenchAttributes.MetaAttributes() {
		override val killfeed: KillfeedAttributes = KillfeedAttributes()
	
		override val viewmodel: ViewmodelAttributes = ViewmodelAttributes()
	
		override val items: ItemsAttributes = ItemsAttributes()
	
		override val particles: ParticlesAttributes = ParticlesAttributes()
	
		open class KillfeedAttributes : WrenchAttributes.MetaAttributes.KillfeedAttributes() 
	
		open class ViewmodelAttributes : WrenchAttributes.MetaAttributes.ViewmodelAttributes() 
	
		open class ItemsAttributes : WrenchAttributes.MetaAttributes.ItemsAttributes() 
	
		open class ParticlesAttributes : WrenchAttributes.MetaAttributes.ParticlesAttributes() 
	}
	
	open class MeterAttributes : WrenchAttributes.MeterAttributes() 
	
	open class MovementAttributes : WrenchAttributes.MovementAttributes() {
		override val moveSpeed: MoveSpeedAttributes = MoveSpeedAttributes()
	
		open class MoveSpeedAttributes : WrenchAttributes.MovementAttributes.MoveSpeedAttributes() 
	}
	
	open class HeadsAttributes : WrenchAttributes.HeadsAttributes() 
	
	open class OnKillAttributes : WrenchAttributes.OnKillAttributes() 
	
	open class ProjectilesAttributes : WrenchAttributes.ProjectilesAttributes() {
		override val projectilePenetration: ProjectilePenetrationAttributes = ProjectilePenetrationAttributes()
	
		override val bullets: BulletsAttributes = BulletsAttributes()
	
		open class ProjectilePenetrationAttributes : WrenchAttributes.ProjectilesAttributes.ProjectilePenetrationAttributes() 
	
		open class BulletsAttributes : WrenchAttributes.ProjectilesAttributes.BulletsAttributes() 
	}
	
	open class ReloadingAttributes : WrenchAttributes.ReloadingAttributes() 
	
	open class ResistanceAttributes : WrenchAttributes.ResistanceAttributes() 
	
	open class RevengeCritsAttributes : WrenchAttributes.RevengeCritsAttributes() 
	
	open class StatusEffectsAttributes : WrenchAttributes.StatusEffectsAttributes() 
	
	open class TauntingAttributes : WrenchAttributes.TauntingAttributes() 
	
	open class WhenHitAttributes : WrenchAttributes.WhenHitAttributes() 
	
	open class RagdollsAttributes : WrenchAttributes.RagdollsAttributes() 
	
	open class DisguiseAttributes : WrenchAttributes.DisguiseAttributes() 
}