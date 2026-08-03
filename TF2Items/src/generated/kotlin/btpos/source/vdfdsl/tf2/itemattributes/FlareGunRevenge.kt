package btpos.source.vdfdsl.tf2.itemattributes

import btpos.source.vdfdsl.modeling.*
import btpos.source.vdfdsl.serialization.codecs.*
import btpos.source.vdfdsl.tf2.itemattributes.impl.*
import btpos.source.vdfdsl.tf2.tftypes.*
import java.util.*
import kotlin.time.Duration

interface FlareGunRevengeAttributes : IBlockScoped, FlareGunAttributes {
	companion object : IBlockScoped {
		private val ammo: AmmoAttributes = AmmoAttributes()
	
		private val damage: DamageAttributes = DamageAttributes()
	
		private val firing: FiringAttributes = FiringAttributes()
	
		private val projectiles: ProjectilesAttributes = ProjectilesAttributes()
	
		private val afterburn: AfterburnAttributes = AfterburnAttributes()
	
		private val buildings: BuildingsAttributes = BuildingsAttributes()
	
		private val crits: CritsAttributes = CritsAttributes()
	
		private val demoCharge: DemoChargeAttributes = DemoChargeAttributes()
	
		private val healthAndHealing: HealthAndHealingAttributes = HealthAndHealingAttributes()
	
		private val knockbackReceived: KnockbackReceivedAttributes = KnockbackReceivedAttributes()
	
		private val meta: MetaAttributes = MetaAttributes()
	
		private val meter: MeterAttributes = MeterAttributes()
	
		private val movement: MovementAttributes = MovementAttributes()
	
		private val heads: HeadsAttributes = HeadsAttributes()
	
		private val onHit: OnHitAttributes = OnHitAttributes()
	
		private val onKill: OnKillAttributes = OnKillAttributes()
	
		private val reloading: ReloadingAttributes = ReloadingAttributes()
	
		private val resistance: ResistanceAttributes = ResistanceAttributes()
	
		private val revengeCrits: RevengeCritsAttributes = RevengeCritsAttributes()
	
		private val statusEffects: StatusEffectsAttributes = StatusEffectsAttributes()
	
		private val taunting: TauntingAttributes = TauntingAttributes()
	
		private val swapWeapons: SwapWeaponsAttributes = SwapWeaponsAttributes()
	
		private val whenHit: WhenHitAttributes = WhenHitAttributes()
	
		private val ragdolls: RagdollsAttributes = RagdollsAttributes()
	
		private val disguise: DisguiseAttributes = DisguiseAttributes()
	}

	override val ammo: AmmoAttributes get() = FlareGunRevengeAttributes.ammo
	
	override val damage: DamageAttributes get() = FlareGunRevengeAttributes.damage
	
	override val firing: FiringAttributes get() = FlareGunRevengeAttributes.firing
	
	override val projectiles: ProjectilesAttributes get() = FlareGunRevengeAttributes.projectiles
	
	override val afterburn: AfterburnAttributes get() = FlareGunRevengeAttributes.afterburn
	
	override val buildings: BuildingsAttributes get() = FlareGunRevengeAttributes.buildings
	
	override val crits: CritsAttributes get() = FlareGunRevengeAttributes.crits
	
	override val demoCharge: DemoChargeAttributes get() = FlareGunRevengeAttributes.demoCharge
	
	override val healthAndHealing: HealthAndHealingAttributes get() = FlareGunRevengeAttributes.healthAndHealing
	
	override val knockbackReceived: KnockbackReceivedAttributes get() = FlareGunRevengeAttributes.knockbackReceived
	
	override val meta: MetaAttributes get() = FlareGunRevengeAttributes.meta
	
	override val meter: MeterAttributes get() = FlareGunRevengeAttributes.meter
	
	override val movement: MovementAttributes get() = FlareGunRevengeAttributes.movement
	
	override val heads: HeadsAttributes get() = FlareGunRevengeAttributes.heads
	
	override val onHit: OnHitAttributes get() = FlareGunRevengeAttributes.onHit
	
	override val onKill: OnKillAttributes get() = FlareGunRevengeAttributes.onKill
	
	override val reloading: ReloadingAttributes get() = FlareGunRevengeAttributes.reloading
	
	override val resistance: ResistanceAttributes get() = FlareGunRevengeAttributes.resistance
	
	override val revengeCrits: RevengeCritsAttributes get() = FlareGunRevengeAttributes.revengeCrits
	
	override val statusEffects: StatusEffectsAttributes get() = FlareGunRevengeAttributes.statusEffects
	
	override val taunting: TauntingAttributes get() = FlareGunRevengeAttributes.taunting
	
	override val swapWeapons: SwapWeaponsAttributes get() = FlareGunRevengeAttributes.swapWeapons
	
	override val whenHit: WhenHitAttributes get() = FlareGunRevengeAttributes.whenHit
	
	override val ragdolls: RagdollsAttributes get() = FlareGunRevengeAttributes.ragdolls
	
	override val disguise: DisguiseAttributes get() = FlareGunRevengeAttributes.disguise

	open class AmmoAttributes : FlareGunAttributes.AmmoAttributes() {
		override val clipSize: ClipSizeAttributes = ClipSizeAttributes()
	
		open class ClipSizeAttributes : FlareGunAttributes.AmmoAttributes.ClipSizeAttributes() 
	}
	
	open class DamageAttributes : FlareGunAttributes.DamageAttributes() 
	
	open class FiringAttributes : FlareGunAttributes.FiringAttributes() {
		override val fireRate: FireRateAttributes = FireRateAttributes()
	
		open class FireRateAttributes : FlareGunAttributes.FiringAttributes.FireRateAttributes() 
	}
	
	open class ProjectilesAttributes : FlareGunAttributes.ProjectilesAttributes() {
		override val bullets: BulletsAttributes = BulletsAttributes()
	
		override val projectilePenetration: ProjectilePenetrationAttributes = ProjectilePenetrationAttributes()
	
		open class BulletsAttributes : FlareGunAttributes.ProjectilesAttributes.BulletsAttributes() 
	
		open class ProjectilePenetrationAttributes : FlareGunAttributes.ProjectilesAttributes.ProjectilePenetrationAttributes() 
	}
	
	open class AfterburnAttributes : FlareGunAttributes.AfterburnAttributes() 
	
	open class BuildingsAttributes : FlareGunAttributes.BuildingsAttributes() 
	
	open class CritsAttributes : FlareGunAttributes.CritsAttributes() 
	
	open class DemoChargeAttributes : FlareGunAttributes.DemoChargeAttributes() 
	
	open class HealthAndHealingAttributes : FlareGunAttributes.HealthAndHealingAttributes() 
	
	open class KnockbackReceivedAttributes : FlareGunAttributes.KnockbackReceivedAttributes() {
		override val damageForceReduction: DamageForceReductionAttributes = DamageForceReductionAttributes()
	
		open class DamageForceReductionAttributes : FlareGunAttributes.KnockbackReceivedAttributes.DamageForceReductionAttributes() 
	}
	
	open class MetaAttributes : FlareGunAttributes.MetaAttributes() {
		override val killfeed: KillfeedAttributes = KillfeedAttributes()
	
		override val viewmodel: ViewmodelAttributes = ViewmodelAttributes()
	
		override val items: ItemsAttributes = ItemsAttributes()
	
		override val particles: ParticlesAttributes = ParticlesAttributes()
	
		open class KillfeedAttributes : FlareGunAttributes.MetaAttributes.KillfeedAttributes() 
	
		open class ViewmodelAttributes : FlareGunAttributes.MetaAttributes.ViewmodelAttributes() 
	
		open class ItemsAttributes : FlareGunAttributes.MetaAttributes.ItemsAttributes() 
	
		open class ParticlesAttributes : FlareGunAttributes.MetaAttributes.ParticlesAttributes() 
	}
	
	open class MeterAttributes : FlareGunAttributes.MeterAttributes() 
	
	open class MovementAttributes : FlareGunAttributes.MovementAttributes() {
		override val moveSpeed: MoveSpeedAttributes = MoveSpeedAttributes()
	
		open class MoveSpeedAttributes : FlareGunAttributes.MovementAttributes.MoveSpeedAttributes() 
	}
	
	open class HeadsAttributes : FlareGunAttributes.HeadsAttributes() 
	
	open class OnHitAttributes : FlareGunAttributes.OnHitAttributes() {
		override val healOnHitForRapidfire: HealOnHitForRapidfireAttributes = HealOnHitForRapidfireAttributes()
	
		override val generateRageOnDamage: GenerateRageOnDamageAttributes = GenerateRageOnDamageAttributes()
	
		open class HealOnHitForRapidfireAttributes : FlareGunAttributes.OnHitAttributes.HealOnHitForRapidfireAttributes() 
	
		open class GenerateRageOnDamageAttributes : FlareGunAttributes.OnHitAttributes.GenerateRageOnDamageAttributes() 
	}
	
	open class OnKillAttributes : FlareGunAttributes.OnKillAttributes() 
	
	open class ReloadingAttributes : FlareGunAttributes.ReloadingAttributes() 
	
	open class ResistanceAttributes : FlareGunAttributes.ResistanceAttributes() 
	
	open class RevengeCritsAttributes : FlareGunAttributes.RevengeCritsAttributes() 
	
	open class StatusEffectsAttributes : FlareGunAttributes.StatusEffectsAttributes() 
	
	open class TauntingAttributes : FlareGunAttributes.TauntingAttributes() 
	
	open class SwapWeaponsAttributes : FlareGunAttributes.SwapWeaponsAttributes() {
		override val deploy: DeployAttributes = DeployAttributes()
	
		open class DeployAttributes : FlareGunAttributes.SwapWeaponsAttributes.DeployAttributes() 
	}
	
	open class WhenHitAttributes : FlareGunAttributes.WhenHitAttributes() 
	
	open class RagdollsAttributes : FlareGunAttributes.RagdollsAttributes() 
	
	open class DisguiseAttributes : FlareGunAttributes.DisguiseAttributes() 
}