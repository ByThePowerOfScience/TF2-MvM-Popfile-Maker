package btpos.source.vdfdsl.tf2.itemattributes

import btpos.source.vdfdsl.modeling.*
import btpos.source.vdfdsl.serialization.codecs.*
import btpos.source.vdfdsl.tf2.itemattributes.impl.*
import btpos.source.vdfdsl.tf2.tftypes.*
import java.util.*
import kotlin.time.Duration

interface RobotArmAttributes : WrenchAttributes {
	companion object : IBlockScoped {
		val buildings: BuildingsAttributes = BuildingsAttributes()
	
		val crits: CritsAttributes = CritsAttributes()
	
		val damage: DamageAttributes = DamageAttributes()
	
		val onHit: OnHitAttributes = OnHitAttributes()
	
		val swapWeapons: SwapWeaponsAttributes = SwapWeaponsAttributes()
	
		val afterburn: AfterburnAttributes = AfterburnAttributes()
	
		val ammo: AmmoAttributes = AmmoAttributes()
	
		val demoCharge: DemoChargeAttributes = DemoChargeAttributes()
	
		val firing: FiringAttributes = FiringAttributes()
	
		val healthAndHealing: HealthAndHealingAttributes = HealthAndHealingAttributes()
	
		val knockbackReceived: KnockbackReceivedAttributes = KnockbackReceivedAttributes()
	
		val meta: MetaAttributes = MetaAttributes()
	
		val meter: MeterAttributes = MeterAttributes()
	
		val movement: MovementAttributes = MovementAttributes()
	
		val heads: HeadsAttributes = HeadsAttributes()
	
		val onKill: OnKillAttributes = OnKillAttributes()
	
		val projectiles: ProjectilesAttributes = ProjectilesAttributes()
	
		val reloading: ReloadingAttributes = ReloadingAttributes()
	
		val resistance: ResistanceAttributes = ResistanceAttributes()
	
		val revengeCrits: RevengeCritsAttributes = RevengeCritsAttributes()
	
		val statusEffects: StatusEffectsAttributes = StatusEffectsAttributes()
	
		val taunting: TauntingAttributes = TauntingAttributes()
	
		val viewmodel: ViewmodelAttributes = ViewmodelAttributes()
	
		val whenHit: WhenHitAttributes = WhenHitAttributes()
	
		val ragdolls: RagdollsAttributes = RagdollsAttributes()
	
		val disguise: DisguiseAttributes = DisguiseAttributes()
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
	
	override val viewmodel: ViewmodelAttributes get() = RobotArmAttributes.viewmodel
	
	override val whenHit: WhenHitAttributes get() = RobotArmAttributes.whenHit
	
	override val ragdolls: RagdollsAttributes get() = RobotArmAttributes.ragdolls
	
	override val disguise: DisguiseAttributes get() = RobotArmAttributes.disguise

	open class BuildingsAttributes : WrenchAttributes.BuildingsAttributes() {
		override val sentryGun: SentryGunAttributes = SentryGunAttributes()
	
		open class SentryGunAttributes : WrenchAttributes.BuildingsAttributes.SentryGunAttributes() 
	}
	
	open class CritsAttributes : WrenchAttributes.CritsAttributes() {
		override val critVsBurningPlayers: CritVsBurningPlayersAttributes = CritVsBurningPlayersAttributes()
	
		open class CritVsBurningPlayersAttributes : WrenchAttributes.CritsAttributes.CritVsBurningPlayersAttributes() 
	}
	
	open class DamageAttributes : WrenchAttributes.DamageAttributes() {
		override val damage: DamageAttributes = DamageAttributes()
	
		open class DamageAttributes : WrenchAttributes.DamageAttributes.DamageAttributes() 
	}
	
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
	
		open class FireRateAttributes : WrenchAttributes.FiringAttributes.FireRateAttributes() {
			override val fireRate: FireRateAttributes = FireRateAttributes()
	
			open class FireRateAttributes : WrenchAttributes.FiringAttributes.FireRateAttributes.FireRateAttributes() 
		}
	}
	
	open class HealthAndHealingAttributes : WrenchAttributes.HealthAndHealingAttributes() 
	
	open class KnockbackReceivedAttributes : WrenchAttributes.KnockbackReceivedAttributes() {
		override val damageForceReduction: DamageForceReductionAttributes = DamageForceReductionAttributes()
	
		open class DamageForceReductionAttributes : WrenchAttributes.KnockbackReceivedAttributes.DamageForceReductionAttributes() 
	}
	
	open class MetaAttributes : WrenchAttributes.MetaAttributes() {
		override val killfeed: KillfeedAttributes = KillfeedAttributes()
	
		override val items: ItemsAttributes = ItemsAttributes()
	
		override val particles: ParticlesAttributes = ParticlesAttributes()
	
		open class KillfeedAttributes : WrenchAttributes.MetaAttributes.KillfeedAttributes() 
	
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
	
	open class ViewmodelAttributes : WrenchAttributes.ViewmodelAttributes() 
	
	open class WhenHitAttributes : WrenchAttributes.WhenHitAttributes() 
	
	open class RagdollsAttributes : WrenchAttributes.RagdollsAttributes() 
	
	open class DisguiseAttributes : WrenchAttributes.DisguiseAttributes() 
}