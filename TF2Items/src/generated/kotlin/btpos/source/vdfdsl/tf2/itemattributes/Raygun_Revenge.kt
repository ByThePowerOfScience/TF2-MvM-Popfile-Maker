package btpos.source.vdfdsl.tf2.itemattributes

import btpos.source.vdfdsl.modeling.*
import btpos.source.vdfdsl.serialization.codecs.*
import btpos.source.vdfdsl.tf2.itemattributes.impl.*
import btpos.source.vdfdsl.tf2.tftypes.*
import java.util.*
import kotlin.time.Duration

interface Raygun_RevengeAttributes : RayGunAttributes {
	companion object : IBlockScoped {
		private val ammo: AmmoAttributes = AmmoAttributes()
	
		private val projectiles: ProjectilesAttributes = ProjectilesAttributes()
	
		private val damage: DamageAttributes = DamageAttributes()
	
		private val firing: FiringAttributes = FiringAttributes()
	
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

	override val ammo: AmmoAttributes get() = Raygun_RevengeAttributes.ammo
	
	override val projectiles: ProjectilesAttributes get() = Raygun_RevengeAttributes.projectiles
	
	override val damage: DamageAttributes get() = Raygun_RevengeAttributes.damage
	
	override val firing: FiringAttributes get() = Raygun_RevengeAttributes.firing
	
	override val afterburn: AfterburnAttributes get() = Raygun_RevengeAttributes.afterburn
	
	override val buildings: BuildingsAttributes get() = Raygun_RevengeAttributes.buildings
	
	override val crits: CritsAttributes get() = Raygun_RevengeAttributes.crits
	
	override val demoCharge: DemoChargeAttributes get() = Raygun_RevengeAttributes.demoCharge
	
	override val healthAndHealing: HealthAndHealingAttributes get() = Raygun_RevengeAttributes.healthAndHealing
	
	override val knockbackReceived: KnockbackReceivedAttributes get() = Raygun_RevengeAttributes.knockbackReceived
	
	override val meta: MetaAttributes get() = Raygun_RevengeAttributes.meta
	
	override val meter: MeterAttributes get() = Raygun_RevengeAttributes.meter
	
	override val movement: MovementAttributes get() = Raygun_RevengeAttributes.movement
	
	override val heads: HeadsAttributes get() = Raygun_RevengeAttributes.heads
	
	override val onHit: OnHitAttributes get() = Raygun_RevengeAttributes.onHit
	
	override val onKill: OnKillAttributes get() = Raygun_RevengeAttributes.onKill
	
	override val reloading: ReloadingAttributes get() = Raygun_RevengeAttributes.reloading
	
	override val resistance: ResistanceAttributes get() = Raygun_RevengeAttributes.resistance
	
	override val revengeCrits: RevengeCritsAttributes get() = Raygun_RevengeAttributes.revengeCrits
	
	override val statusEffects: StatusEffectsAttributes get() = Raygun_RevengeAttributes.statusEffects
	
	override val taunting: TauntingAttributes get() = Raygun_RevengeAttributes.taunting
	
	override val swapWeapons: SwapWeaponsAttributes get() = Raygun_RevengeAttributes.swapWeapons
	
	override val whenHit: WhenHitAttributes get() = Raygun_RevengeAttributes.whenHit
	
	override val ragdolls: RagdollsAttributes get() = Raygun_RevengeAttributes.ragdolls
	
	override val disguise: DisguiseAttributes get() = Raygun_RevengeAttributes.disguise

	open class AmmoAttributes : RayGunAttributes.AmmoAttributes() {
		override val clipSize: ClipSizeAttributes = ClipSizeAttributes()
	
		open class ClipSizeAttributes : RayGunAttributes.AmmoAttributes.ClipSizeAttributes() 
	}
	
	open class ProjectilesAttributes : RayGunAttributes.ProjectilesAttributes() {
		override val bullets: BulletsAttributes = BulletsAttributes()
	
		override val projectilePenetration: ProjectilePenetrationAttributes = ProjectilePenetrationAttributes()
	
		open class BulletsAttributes : RayGunAttributes.ProjectilesAttributes.BulletsAttributes() 
	
		open class ProjectilePenetrationAttributes : RayGunAttributes.ProjectilesAttributes.ProjectilePenetrationAttributes() 
	}
	
	open class DamageAttributes : RayGunAttributes.DamageAttributes() 
	
	open class FiringAttributes : RayGunAttributes.FiringAttributes() {
		override val fireRate: FireRateAttributes = FireRateAttributes()
	
		open class FireRateAttributes : RayGunAttributes.FiringAttributes.FireRateAttributes() 
	}
	
	open class AfterburnAttributes : RayGunAttributes.AfterburnAttributes() 
	
	open class BuildingsAttributes : RayGunAttributes.BuildingsAttributes() 
	
	open class CritsAttributes : RayGunAttributes.CritsAttributes() 
	
	open class DemoChargeAttributes : RayGunAttributes.DemoChargeAttributes() 
	
	open class HealthAndHealingAttributes : RayGunAttributes.HealthAndHealingAttributes() 
	
	open class KnockbackReceivedAttributes : RayGunAttributes.KnockbackReceivedAttributes() {
		override val damageForceReduction: DamageForceReductionAttributes = DamageForceReductionAttributes()
	
		open class DamageForceReductionAttributes : RayGunAttributes.KnockbackReceivedAttributes.DamageForceReductionAttributes() 
	}
	
	open class MetaAttributes : RayGunAttributes.MetaAttributes() {
		override val killfeed: KillfeedAttributes = KillfeedAttributes()
	
		override val viewmodel: ViewmodelAttributes = ViewmodelAttributes()
	
		override val items: ItemsAttributes = ItemsAttributes()
	
		override val particles: ParticlesAttributes = ParticlesAttributes()
	
		open class KillfeedAttributes : RayGunAttributes.MetaAttributes.KillfeedAttributes() 
	
		open class ViewmodelAttributes : RayGunAttributes.MetaAttributes.ViewmodelAttributes() 
	
		open class ItemsAttributes : RayGunAttributes.MetaAttributes.ItemsAttributes() 
	
		open class ParticlesAttributes : RayGunAttributes.MetaAttributes.ParticlesAttributes() 
	}
	
	open class MeterAttributes : RayGunAttributes.MeterAttributes() 
	
	open class MovementAttributes : RayGunAttributes.MovementAttributes() {
		override val moveSpeed: MoveSpeedAttributes = MoveSpeedAttributes()
	
		open class MoveSpeedAttributes : RayGunAttributes.MovementAttributes.MoveSpeedAttributes() 
	}
	
	open class HeadsAttributes : RayGunAttributes.HeadsAttributes() 
	
	open class OnHitAttributes : RayGunAttributes.OnHitAttributes() {
		override val healOnHitForRapidfire: HealOnHitForRapidfireAttributes = HealOnHitForRapidfireAttributes()
	
		override val generateRageOnDamage: GenerateRageOnDamageAttributes = GenerateRageOnDamageAttributes()
	
		open class HealOnHitForRapidfireAttributes : RayGunAttributes.OnHitAttributes.HealOnHitForRapidfireAttributes() 
	
		open class GenerateRageOnDamageAttributes : RayGunAttributes.OnHitAttributes.GenerateRageOnDamageAttributes() 
	}
	
	open class OnKillAttributes : RayGunAttributes.OnKillAttributes() 
	
	open class ReloadingAttributes : RayGunAttributes.ReloadingAttributes() 
	
	open class ResistanceAttributes : RayGunAttributes.ResistanceAttributes() 
	
	open class RevengeCritsAttributes : RayGunAttributes.RevengeCritsAttributes() 
	
	open class StatusEffectsAttributes : RayGunAttributes.StatusEffectsAttributes() 
	
	open class TauntingAttributes : RayGunAttributes.TauntingAttributes() 
	
	open class SwapWeaponsAttributes : RayGunAttributes.SwapWeaponsAttributes() {
		override val deploy: DeployAttributes = DeployAttributes()
	
		open class DeployAttributes : RayGunAttributes.SwapWeaponsAttributes.DeployAttributes() 
	}
	
	open class WhenHitAttributes : RayGunAttributes.WhenHitAttributes() 
	
	open class RagdollsAttributes : RayGunAttributes.RagdollsAttributes() 
	
	open class DisguiseAttributes : RayGunAttributes.DisguiseAttributes() 
}