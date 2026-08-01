package btpos.source.vdfdsl.tf2.itemattributes

import btpos.source.vdfdsl.modeling.*
import btpos.source.vdfdsl.serialization.codecs.*
import btpos.source.vdfdsl.tf2.itemattributes.impl.*
import btpos.source.vdfdsl.tf2.tftypes.*
import java.util.*
import kotlin.time.Duration

interface ScoutPistolSecondaryAttributes : ScoutPistolAttributes {
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

	override val ammo: AmmoAttributes get() = ScoutPistolSecondaryAttributes.ammo
	
	override val damage: DamageAttributes get() = ScoutPistolSecondaryAttributes.damage
	
	override val firing: FiringAttributes get() = ScoutPistolSecondaryAttributes.firing
	
	override val projectiles: ProjectilesAttributes get() = ScoutPistolSecondaryAttributes.projectiles
	
	override val afterburn: AfterburnAttributes get() = ScoutPistolSecondaryAttributes.afterburn
	
	override val buildings: BuildingsAttributes get() = ScoutPistolSecondaryAttributes.buildings
	
	override val crits: CritsAttributes get() = ScoutPistolSecondaryAttributes.crits
	
	override val demoCharge: DemoChargeAttributes get() = ScoutPistolSecondaryAttributes.demoCharge
	
	override val healthAndHealing: HealthAndHealingAttributes get() = ScoutPistolSecondaryAttributes.healthAndHealing
	
	override val knockbackReceived: KnockbackReceivedAttributes get() = ScoutPistolSecondaryAttributes.knockbackReceived
	
	override val meta: MetaAttributes get() = ScoutPistolSecondaryAttributes.meta
	
	override val meter: MeterAttributes get() = ScoutPistolSecondaryAttributes.meter
	
	override val movement: MovementAttributes get() = ScoutPistolSecondaryAttributes.movement
	
	override val heads: HeadsAttributes get() = ScoutPistolSecondaryAttributes.heads
	
	override val onHit: OnHitAttributes get() = ScoutPistolSecondaryAttributes.onHit
	
	override val onKill: OnKillAttributes get() = ScoutPistolSecondaryAttributes.onKill
	
	override val reloading: ReloadingAttributes get() = ScoutPistolSecondaryAttributes.reloading
	
	override val resistance: ResistanceAttributes get() = ScoutPistolSecondaryAttributes.resistance
	
	override val revengeCrits: RevengeCritsAttributes get() = ScoutPistolSecondaryAttributes.revengeCrits
	
	override val statusEffects: StatusEffectsAttributes get() = ScoutPistolSecondaryAttributes.statusEffects
	
	override val taunting: TauntingAttributes get() = ScoutPistolSecondaryAttributes.taunting
	
	override val swapWeapons: SwapWeaponsAttributes get() = ScoutPistolSecondaryAttributes.swapWeapons
	
	override val whenHit: WhenHitAttributes get() = ScoutPistolSecondaryAttributes.whenHit
	
	override val ragdolls: RagdollsAttributes get() = ScoutPistolSecondaryAttributes.ragdolls
	
	override val disguise: DisguiseAttributes get() = ScoutPistolSecondaryAttributes.disguise

	open class AmmoAttributes : ScoutPistolAttributes.AmmoAttributes() {
		override val clipSize: ClipSizeAttributes = ClipSizeAttributes()
	
		open class ClipSizeAttributes : ScoutPistolAttributes.AmmoAttributes.ClipSizeAttributes() 
	}
	
	open class DamageAttributes : ScoutPistolAttributes.DamageAttributes() 
	
	open class FiringAttributes : ScoutPistolAttributes.FiringAttributes() {
		override val fireRate: FireRateAttributes = FireRateAttributes()
	
		open class FireRateAttributes : ScoutPistolAttributes.FiringAttributes.FireRateAttributes() 
	}
	
	open class ProjectilesAttributes : ScoutPistolAttributes.ProjectilesAttributes() {
		override val bullets: BulletsAttributes = BulletsAttributes()
	
		override val projectilePenetration: ProjectilePenetrationAttributes = ProjectilePenetrationAttributes()
	
		open class BulletsAttributes : ScoutPistolAttributes.ProjectilesAttributes.BulletsAttributes() 
	
		open class ProjectilePenetrationAttributes : ScoutPistolAttributes.ProjectilesAttributes.ProjectilePenetrationAttributes() 
	}
	
	open class AfterburnAttributes : ScoutPistolAttributes.AfterburnAttributes() 
	
	open class BuildingsAttributes : ScoutPistolAttributes.BuildingsAttributes() 
	
	open class CritsAttributes : ScoutPistolAttributes.CritsAttributes() 
	
	open class DemoChargeAttributes : ScoutPistolAttributes.DemoChargeAttributes() 
	
	open class HealthAndHealingAttributes : ScoutPistolAttributes.HealthAndHealingAttributes() 
	
	open class KnockbackReceivedAttributes : ScoutPistolAttributes.KnockbackReceivedAttributes() {
		override val damageForceReduction: DamageForceReductionAttributes = DamageForceReductionAttributes()
	
		open class DamageForceReductionAttributes : ScoutPistolAttributes.KnockbackReceivedAttributes.DamageForceReductionAttributes() 
	}
	
	open class MetaAttributes : ScoutPistolAttributes.MetaAttributes() {
		override val killfeed: KillfeedAttributes = KillfeedAttributes()
	
		override val viewmodel: ViewmodelAttributes = ViewmodelAttributes()
	
		override val items: ItemsAttributes = ItemsAttributes()
	
		override val particles: ParticlesAttributes = ParticlesAttributes()
	
		open class KillfeedAttributes : ScoutPistolAttributes.MetaAttributes.KillfeedAttributes() 
	
		open class ViewmodelAttributes : ScoutPistolAttributes.MetaAttributes.ViewmodelAttributes() 
	
		open class ItemsAttributes : ScoutPistolAttributes.MetaAttributes.ItemsAttributes() 
	
		open class ParticlesAttributes : ScoutPistolAttributes.MetaAttributes.ParticlesAttributes() 
	}
	
	open class MeterAttributes : ScoutPistolAttributes.MeterAttributes() 
	
	open class MovementAttributes : ScoutPistolAttributes.MovementAttributes() {
		override val moveSpeed: MoveSpeedAttributes = MoveSpeedAttributes()
	
		open class MoveSpeedAttributes : ScoutPistolAttributes.MovementAttributes.MoveSpeedAttributes() 
	}
	
	open class HeadsAttributes : ScoutPistolAttributes.HeadsAttributes() 
	
	open class OnHitAttributes : ScoutPistolAttributes.OnHitAttributes() {
		override val healOnHitForRapidfire: HealOnHitForRapidfireAttributes = HealOnHitForRapidfireAttributes()
	
		override val generateRageOnDamage: GenerateRageOnDamageAttributes = GenerateRageOnDamageAttributes()
	
		open class HealOnHitForRapidfireAttributes : ScoutPistolAttributes.OnHitAttributes.HealOnHitForRapidfireAttributes() 
	
		open class GenerateRageOnDamageAttributes : ScoutPistolAttributes.OnHitAttributes.GenerateRageOnDamageAttributes() 
	}
	
	open class OnKillAttributes : ScoutPistolAttributes.OnKillAttributes() 
	
	open class ReloadingAttributes : ScoutPistolAttributes.ReloadingAttributes() 
	
	open class ResistanceAttributes : ScoutPistolAttributes.ResistanceAttributes() 
	
	open class RevengeCritsAttributes : ScoutPistolAttributes.RevengeCritsAttributes() 
	
	open class StatusEffectsAttributes : ScoutPistolAttributes.StatusEffectsAttributes() 
	
	open class TauntingAttributes : ScoutPistolAttributes.TauntingAttributes() 
	
	open class SwapWeaponsAttributes : ScoutPistolAttributes.SwapWeaponsAttributes() {
		override val deploy: DeployAttributes = DeployAttributes()
	
		open class DeployAttributes : ScoutPistolAttributes.SwapWeaponsAttributes.DeployAttributes() 
	}
	
	open class WhenHitAttributes : ScoutPistolAttributes.WhenHitAttributes() 
	
	open class RagdollsAttributes : ScoutPistolAttributes.RagdollsAttributes() 
	
	open class DisguiseAttributes : ScoutPistolAttributes.DisguiseAttributes() 
}