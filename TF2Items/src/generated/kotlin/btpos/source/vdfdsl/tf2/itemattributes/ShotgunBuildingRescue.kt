package btpos.source.vdfdsl.tf2.itemattributes

import btpos.source.vdfdsl.modeling.*
import btpos.source.vdfdsl.serialization.codecs.*
import btpos.source.vdfdsl.tf2.itemattributes.impl.*
import btpos.source.vdfdsl.tf2.tftypes.*
import java.util.*
import kotlin.time.Duration

interface ShotgunBuildingRescueAttributes : IBlockScoped, ShotgunAttributes {
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

	override val ammo: AmmoAttributes get() = ShotgunBuildingRescueAttributes.ammo
	
	override val damage: DamageAttributes get() = ShotgunBuildingRescueAttributes.damage
	
	override val firing: FiringAttributes get() = ShotgunBuildingRescueAttributes.firing
	
	override val projectiles: ProjectilesAttributes get() = ShotgunBuildingRescueAttributes.projectiles
	
	override val afterburn: AfterburnAttributes get() = ShotgunBuildingRescueAttributes.afterburn
	
	override val buildings: BuildingsAttributes get() = ShotgunBuildingRescueAttributes.buildings
	
	override val crits: CritsAttributes get() = ShotgunBuildingRescueAttributes.crits
	
	override val demoCharge: DemoChargeAttributes get() = ShotgunBuildingRescueAttributes.demoCharge
	
	override val healthAndHealing: HealthAndHealingAttributes get() = ShotgunBuildingRescueAttributes.healthAndHealing
	
	override val knockbackReceived: KnockbackReceivedAttributes get() = ShotgunBuildingRescueAttributes.knockbackReceived
	
	override val meta: MetaAttributes get() = ShotgunBuildingRescueAttributes.meta
	
	override val meter: MeterAttributes get() = ShotgunBuildingRescueAttributes.meter
	
	override val movement: MovementAttributes get() = ShotgunBuildingRescueAttributes.movement
	
	override val heads: HeadsAttributes get() = ShotgunBuildingRescueAttributes.heads
	
	override val onHit: OnHitAttributes get() = ShotgunBuildingRescueAttributes.onHit
	
	override val onKill: OnKillAttributes get() = ShotgunBuildingRescueAttributes.onKill
	
	override val reloading: ReloadingAttributes get() = ShotgunBuildingRescueAttributes.reloading
	
	override val resistance: ResistanceAttributes get() = ShotgunBuildingRescueAttributes.resistance
	
	override val revengeCrits: RevengeCritsAttributes get() = ShotgunBuildingRescueAttributes.revengeCrits
	
	override val statusEffects: StatusEffectsAttributes get() = ShotgunBuildingRescueAttributes.statusEffects
	
	override val taunting: TauntingAttributes get() = ShotgunBuildingRescueAttributes.taunting
	
	override val swapWeapons: SwapWeaponsAttributes get() = ShotgunBuildingRescueAttributes.swapWeapons
	
	override val whenHit: WhenHitAttributes get() = ShotgunBuildingRescueAttributes.whenHit
	
	override val ragdolls: RagdollsAttributes get() = ShotgunBuildingRescueAttributes.ragdolls
	
	override val disguise: DisguiseAttributes get() = ShotgunBuildingRescueAttributes.disguise

	open class AmmoAttributes : ShotgunAttributes.AmmoAttributes() {
		override val clipSize: ClipSizeAttributes = ClipSizeAttributes()
	
		open class ClipSizeAttributes : ShotgunAttributes.AmmoAttributes.ClipSizeAttributes() 
	}
	
	open class DamageAttributes : ShotgunAttributes.DamageAttributes() 
	
	open class FiringAttributes : ShotgunAttributes.FiringAttributes() {
		override val fireRate: FireRateAttributes = FireRateAttributes()
	
		open class FireRateAttributes : ShotgunAttributes.FiringAttributes.FireRateAttributes() 
	}
	
	open class ProjectilesAttributes : ShotgunAttributes.ProjectilesAttributes() {
		override val bullets: BulletsAttributes = BulletsAttributes()
	
		override val projectilePenetration: ProjectilePenetrationAttributes = ProjectilePenetrationAttributes()
	
		open class BulletsAttributes : ShotgunAttributes.ProjectilesAttributes.BulletsAttributes() 
	
		open class ProjectilePenetrationAttributes : ShotgunAttributes.ProjectilesAttributes.ProjectilePenetrationAttributes() 
	}
	
	open class AfterburnAttributes : ShotgunAttributes.AfterburnAttributes() 
	
	open class BuildingsAttributes : ShotgunAttributes.BuildingsAttributes() 
	
	open class CritsAttributes : ShotgunAttributes.CritsAttributes() 
	
	open class DemoChargeAttributes : ShotgunAttributes.DemoChargeAttributes() 
	
	open class HealthAndHealingAttributes : ShotgunAttributes.HealthAndHealingAttributes() 
	
	open class KnockbackReceivedAttributes : ShotgunAttributes.KnockbackReceivedAttributes() {
		override val damageForceReduction: DamageForceReductionAttributes = DamageForceReductionAttributes()
	
		open class DamageForceReductionAttributes : ShotgunAttributes.KnockbackReceivedAttributes.DamageForceReductionAttributes() 
	}
	
	open class MetaAttributes : ShotgunAttributes.MetaAttributes() {
		override val killfeed: KillfeedAttributes = KillfeedAttributes()
	
		override val viewmodel: ViewmodelAttributes = ViewmodelAttributes()
	
		override val items: ItemsAttributes = ItemsAttributes()
	
		override val particles: ParticlesAttributes = ParticlesAttributes()
	
		open class KillfeedAttributes : ShotgunAttributes.MetaAttributes.KillfeedAttributes() 
	
		open class ViewmodelAttributes : ShotgunAttributes.MetaAttributes.ViewmodelAttributes() 
	
		open class ItemsAttributes : ShotgunAttributes.MetaAttributes.ItemsAttributes() 
	
		open class ParticlesAttributes : ShotgunAttributes.MetaAttributes.ParticlesAttributes() 
	}
	
	open class MeterAttributes : ShotgunAttributes.MeterAttributes() 
	
	open class MovementAttributes : ShotgunAttributes.MovementAttributes() {
		override val moveSpeed: MoveSpeedAttributes = MoveSpeedAttributes()
	
		open class MoveSpeedAttributes : ShotgunAttributes.MovementAttributes.MoveSpeedAttributes() 
	}
	
	open class HeadsAttributes : ShotgunAttributes.HeadsAttributes() 
	
	open class OnHitAttributes : ShotgunAttributes.OnHitAttributes() {
		override val healOnHitForRapidfire: HealOnHitForRapidfireAttributes = HealOnHitForRapidfireAttributes()
	
		override val generateRageOnDamage: GenerateRageOnDamageAttributes = GenerateRageOnDamageAttributes()
	
		open class HealOnHitForRapidfireAttributes : ShotgunAttributes.OnHitAttributes.HealOnHitForRapidfireAttributes() 
	
		open class GenerateRageOnDamageAttributes : ShotgunAttributes.OnHitAttributes.GenerateRageOnDamageAttributes() 
	}
	
	open class OnKillAttributes : ShotgunAttributes.OnKillAttributes() 
	
	open class ReloadingAttributes : ShotgunAttributes.ReloadingAttributes() 
	
	open class ResistanceAttributes : ShotgunAttributes.ResistanceAttributes() 
	
	open class RevengeCritsAttributes : ShotgunAttributes.RevengeCritsAttributes() 
	
	open class StatusEffectsAttributes : ShotgunAttributes.StatusEffectsAttributes() 
	
	open class TauntingAttributes : ShotgunAttributes.TauntingAttributes() 
	
	open class SwapWeaponsAttributes : ShotgunAttributes.SwapWeaponsAttributes() {
		override val deploy: DeployAttributes = DeployAttributes()
	
		open class DeployAttributes : ShotgunAttributes.SwapWeaponsAttributes.DeployAttributes() 
	}
	
	open class WhenHitAttributes : ShotgunAttributes.WhenHitAttributes() 
	
	open class RagdollsAttributes : ShotgunAttributes.RagdollsAttributes() 
	
	open class DisguiseAttributes : ShotgunAttributes.DisguiseAttributes() 
}