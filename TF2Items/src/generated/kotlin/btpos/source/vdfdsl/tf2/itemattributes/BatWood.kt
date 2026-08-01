package btpos.source.vdfdsl.tf2.itemattributes

import btpos.source.vdfdsl.modeling.*
import btpos.source.vdfdsl.serialization.codecs.*
import btpos.source.vdfdsl.tf2.itemattributes.impl.*
import btpos.source.vdfdsl.tf2.tftypes.*
import java.util.*
import kotlin.time.Duration

interface BatWoodAttributes : BatAttributes {
	companion object : IBlockScoped {
		private val crits: CritsAttributes = CritsAttributes()
	
		private val damage: DamageAttributes = DamageAttributes()
	
		private val onHit: OnHitAttributes = OnHitAttributes()
	
		private val swapWeapons: SwapWeaponsAttributes = SwapWeaponsAttributes()
	
		private val afterburn: AfterburnAttributes = AfterburnAttributes()
	
		private val ammo: AmmoAttributes = AmmoAttributes()
	
		private val buildings: BuildingsAttributes = BuildingsAttributes()
	
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

	override val crits: CritsAttributes get() = BatWoodAttributes.crits
	
	override val damage: DamageAttributes get() = BatWoodAttributes.damage
	
	override val onHit: OnHitAttributes get() = BatWoodAttributes.onHit
	
	override val swapWeapons: SwapWeaponsAttributes get() = BatWoodAttributes.swapWeapons
	
	override val afterburn: AfterburnAttributes get() = BatWoodAttributes.afterburn
	
	override val ammo: AmmoAttributes get() = BatWoodAttributes.ammo
	
	override val buildings: BuildingsAttributes get() = BatWoodAttributes.buildings
	
	override val demoCharge: DemoChargeAttributes get() = BatWoodAttributes.demoCharge
	
	override val firing: FiringAttributes get() = BatWoodAttributes.firing
	
	override val healthAndHealing: HealthAndHealingAttributes get() = BatWoodAttributes.healthAndHealing
	
	override val knockbackReceived: KnockbackReceivedAttributes get() = BatWoodAttributes.knockbackReceived
	
	override val meta: MetaAttributes get() = BatWoodAttributes.meta
	
	override val meter: MeterAttributes get() = BatWoodAttributes.meter
	
	override val movement: MovementAttributes get() = BatWoodAttributes.movement
	
	override val heads: HeadsAttributes get() = BatWoodAttributes.heads
	
	override val onKill: OnKillAttributes get() = BatWoodAttributes.onKill
	
	override val projectiles: ProjectilesAttributes get() = BatWoodAttributes.projectiles
	
	override val reloading: ReloadingAttributes get() = BatWoodAttributes.reloading
	
	override val resistance: ResistanceAttributes get() = BatWoodAttributes.resistance
	
	override val revengeCrits: RevengeCritsAttributes get() = BatWoodAttributes.revengeCrits
	
	override val statusEffects: StatusEffectsAttributes get() = BatWoodAttributes.statusEffects
	
	override val taunting: TauntingAttributes get() = BatWoodAttributes.taunting
	
	override val whenHit: WhenHitAttributes get() = BatWoodAttributes.whenHit
	
	override val ragdolls: RagdollsAttributes get() = BatWoodAttributes.ragdolls
	
	override val disguise: DisguiseAttributes get() = BatWoodAttributes.disguise

	open class CritsAttributes : BatAttributes.CritsAttributes() 
	
	open class DamageAttributes : BatAttributes.DamageAttributes() 
	
	open class OnHitAttributes : BatAttributes.OnHitAttributes() {
		override val healOnHitForRapidfire: HealOnHitForRapidfireAttributes = HealOnHitForRapidfireAttributes()
	
		override val generateRageOnDamage: GenerateRageOnDamageAttributes = GenerateRageOnDamageAttributes()
	
		open class HealOnHitForRapidfireAttributes : BatAttributes.OnHitAttributes.HealOnHitForRapidfireAttributes() 
	
		open class GenerateRageOnDamageAttributes : BatAttributes.OnHitAttributes.GenerateRageOnDamageAttributes() 
	}
	
	open class SwapWeaponsAttributes : BatAttributes.SwapWeaponsAttributes() {
		override val deploy: DeployAttributes = DeployAttributes()
	
		open class DeployAttributes : BatAttributes.SwapWeaponsAttributes.DeployAttributes() 
	}
	
	open class AfterburnAttributes : BatAttributes.AfterburnAttributes() 
	
	open class AmmoAttributes : BatAttributes.AmmoAttributes() {
		override val clipSize: ClipSizeAttributes = ClipSizeAttributes()
	
		open class ClipSizeAttributes : BatAttributes.AmmoAttributes.ClipSizeAttributes() 
	}
	
	open class BuildingsAttributes : BatAttributes.BuildingsAttributes() 
	
	open class DemoChargeAttributes : BatAttributes.DemoChargeAttributes() 
	
	open class FiringAttributes : BatAttributes.FiringAttributes() {
		override val fireRate: FireRateAttributes = FireRateAttributes()
	
		open class FireRateAttributes : BatAttributes.FiringAttributes.FireRateAttributes() 
	}
	
	open class HealthAndHealingAttributes : BatAttributes.HealthAndHealingAttributes() 
	
	open class KnockbackReceivedAttributes : BatAttributes.KnockbackReceivedAttributes() {
		override val damageForceReduction: DamageForceReductionAttributes = DamageForceReductionAttributes()
	
		open class DamageForceReductionAttributes : BatAttributes.KnockbackReceivedAttributes.DamageForceReductionAttributes() 
	}
	
	open class MetaAttributes : BatAttributes.MetaAttributes() {
		override val killfeed: KillfeedAttributes = KillfeedAttributes()
	
		override val viewmodel: ViewmodelAttributes = ViewmodelAttributes()
	
		override val items: ItemsAttributes = ItemsAttributes()
	
		override val particles: ParticlesAttributes = ParticlesAttributes()
	
		open class KillfeedAttributes : BatAttributes.MetaAttributes.KillfeedAttributes() 
	
		open class ViewmodelAttributes : BatAttributes.MetaAttributes.ViewmodelAttributes() 
	
		open class ItemsAttributes : BatAttributes.MetaAttributes.ItemsAttributes() 
	
		open class ParticlesAttributes : BatAttributes.MetaAttributes.ParticlesAttributes() 
	}
	
	open class MeterAttributes : BatAttributes.MeterAttributes() 
	
	open class MovementAttributes : BatAttributes.MovementAttributes() {
		override val moveSpeed: MoveSpeedAttributes = MoveSpeedAttributes()
	
		open class MoveSpeedAttributes : BatAttributes.MovementAttributes.MoveSpeedAttributes() 
	}
	
	open class HeadsAttributes : BatAttributes.HeadsAttributes() 
	
	open class OnKillAttributes : BatAttributes.OnKillAttributes() 
	
	open class ProjectilesAttributes : BatAttributes.ProjectilesAttributes() {
		override val projectilePenetration: ProjectilePenetrationAttributes = ProjectilePenetrationAttributes()
	
		override val bullets: BulletsAttributes = BulletsAttributes()
	
		open class ProjectilePenetrationAttributes : BatAttributes.ProjectilesAttributes.ProjectilePenetrationAttributes() 
	
		open class BulletsAttributes : BatAttributes.ProjectilesAttributes.BulletsAttributes() 
	}
	
	open class ReloadingAttributes : BatAttributes.ReloadingAttributes() 
	
	open class ResistanceAttributes : BatAttributes.ResistanceAttributes() 
	
	open class RevengeCritsAttributes : BatAttributes.RevengeCritsAttributes() 
	
	open class StatusEffectsAttributes : BatAttributes.StatusEffectsAttributes() 
	
	open class TauntingAttributes : BatAttributes.TauntingAttributes() 
	
	open class WhenHitAttributes : BatAttributes.WhenHitAttributes() 
	
	open class RagdollsAttributes : BatAttributes.RagdollsAttributes() 
	
	open class DisguiseAttributes : BatAttributes.DisguiseAttributes() 
}