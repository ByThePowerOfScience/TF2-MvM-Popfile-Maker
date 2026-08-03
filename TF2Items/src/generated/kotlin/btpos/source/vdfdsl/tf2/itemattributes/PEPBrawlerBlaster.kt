package btpos.source.vdfdsl.tf2.itemattributes

import btpos.source.vdfdsl.modeling.*
import btpos.source.vdfdsl.serialization.codecs.*
import btpos.source.vdfdsl.tf2.itemattributes.impl.*
import btpos.source.vdfdsl.tf2.tftypes.*
import java.util.*
import kotlin.time.Duration

interface PEPBrawlerBlasterAttributes : IBlockScoped, ScattergunAttributes {
	companion object : IBlockScoped {
		private val onHit: OnHitAttributes = OnHitAttributes()
	
		private val reloading: ReloadingAttributes = ReloadingAttributes()
	
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
	
		private val onKill: OnKillAttributes = OnKillAttributes()
	
		private val resistance: ResistanceAttributes = ResistanceAttributes()
	
		private val revengeCrits: RevengeCritsAttributes = RevengeCritsAttributes()
	
		private val statusEffects: StatusEffectsAttributes = StatusEffectsAttributes()
	
		private val taunting: TauntingAttributes = TauntingAttributes()
	
		private val swapWeapons: SwapWeaponsAttributes = SwapWeaponsAttributes()
	
		private val whenHit: WhenHitAttributes = WhenHitAttributes()
	
		private val ragdolls: RagdollsAttributes = RagdollsAttributes()
	
		private val disguise: DisguiseAttributes = DisguiseAttributes()
	}

	override val onHit: OnHitAttributes get() = PEPBrawlerBlasterAttributes.onHit
	
	override val reloading: ReloadingAttributes get() = PEPBrawlerBlasterAttributes.reloading
	
	override val ammo: AmmoAttributes get() = PEPBrawlerBlasterAttributes.ammo
	
	override val damage: DamageAttributes get() = PEPBrawlerBlasterAttributes.damage
	
	override val firing: FiringAttributes get() = PEPBrawlerBlasterAttributes.firing
	
	override val projectiles: ProjectilesAttributes get() = PEPBrawlerBlasterAttributes.projectiles
	
	override val afterburn: AfterburnAttributes get() = PEPBrawlerBlasterAttributes.afterburn
	
	override val buildings: BuildingsAttributes get() = PEPBrawlerBlasterAttributes.buildings
	
	override val crits: CritsAttributes get() = PEPBrawlerBlasterAttributes.crits
	
	override val demoCharge: DemoChargeAttributes get() = PEPBrawlerBlasterAttributes.demoCharge
	
	override val healthAndHealing: HealthAndHealingAttributes get() = PEPBrawlerBlasterAttributes.healthAndHealing
	
	override val knockbackReceived: KnockbackReceivedAttributes get() = PEPBrawlerBlasterAttributes.knockbackReceived
	
	override val meta: MetaAttributes get() = PEPBrawlerBlasterAttributes.meta
	
	override val meter: MeterAttributes get() = PEPBrawlerBlasterAttributes.meter
	
	override val movement: MovementAttributes get() = PEPBrawlerBlasterAttributes.movement
	
	override val heads: HeadsAttributes get() = PEPBrawlerBlasterAttributes.heads
	
	override val onKill: OnKillAttributes get() = PEPBrawlerBlasterAttributes.onKill
	
	override val resistance: ResistanceAttributes get() = PEPBrawlerBlasterAttributes.resistance
	
	override val revengeCrits: RevengeCritsAttributes get() = PEPBrawlerBlasterAttributes.revengeCrits
	
	override val statusEffects: StatusEffectsAttributes get() = PEPBrawlerBlasterAttributes.statusEffects
	
	override val taunting: TauntingAttributes get() = PEPBrawlerBlasterAttributes.taunting
	
	override val swapWeapons: SwapWeaponsAttributes get() = PEPBrawlerBlasterAttributes.swapWeapons
	
	override val whenHit: WhenHitAttributes get() = PEPBrawlerBlasterAttributes.whenHit
	
	override val ragdolls: RagdollsAttributes get() = PEPBrawlerBlasterAttributes.ragdolls
	
	override val disguise: DisguiseAttributes get() = PEPBrawlerBlasterAttributes.disguise

	open class OnHitAttributes : ScattergunAttributes.OnHitAttributes() {
		override val healOnHitForRapidfire: HealOnHitForRapidfireAttributes = HealOnHitForRapidfireAttributes()
	
		override val generateRageOnDamage: GenerateRageOnDamageAttributes = GenerateRageOnDamageAttributes()
	
		open class HealOnHitForRapidfireAttributes : ScattergunAttributes.OnHitAttributes.HealOnHitForRapidfireAttributes() 
	
		open class GenerateRageOnDamageAttributes : ScattergunAttributes.OnHitAttributes.GenerateRageOnDamageAttributes() 
	}
	
	open class ReloadingAttributes : ScattergunAttributes.ReloadingAttributes() 
	
	open class AmmoAttributes : ScattergunAttributes.AmmoAttributes() {
		override val clipSize: ClipSizeAttributes = ClipSizeAttributes()
	
		open class ClipSizeAttributes : ScattergunAttributes.AmmoAttributes.ClipSizeAttributes() 
	}
	
	open class DamageAttributes : ScattergunAttributes.DamageAttributes() 
	
	open class FiringAttributes : ScattergunAttributes.FiringAttributes() {
		override val fireRate: FireRateAttributes = FireRateAttributes()
	
		open class FireRateAttributes : ScattergunAttributes.FiringAttributes.FireRateAttributes() 
	}
	
	open class ProjectilesAttributes : ScattergunAttributes.ProjectilesAttributes() {
		override val bullets: BulletsAttributes = BulletsAttributes()
	
		override val projectilePenetration: ProjectilePenetrationAttributes = ProjectilePenetrationAttributes()
	
		open class BulletsAttributes : ScattergunAttributes.ProjectilesAttributes.BulletsAttributes() 
	
		open class ProjectilePenetrationAttributes : ScattergunAttributes.ProjectilesAttributes.ProjectilePenetrationAttributes() 
	}
	
	open class AfterburnAttributes : ScattergunAttributes.AfterburnAttributes() 
	
	open class BuildingsAttributes : ScattergunAttributes.BuildingsAttributes() 
	
	open class CritsAttributes : ScattergunAttributes.CritsAttributes() 
	
	open class DemoChargeAttributes : ScattergunAttributes.DemoChargeAttributes() 
	
	open class HealthAndHealingAttributes : ScattergunAttributes.HealthAndHealingAttributes() 
	
	open class KnockbackReceivedAttributes : ScattergunAttributes.KnockbackReceivedAttributes() {
		override val damageForceReduction: DamageForceReductionAttributes = DamageForceReductionAttributes()
	
		open class DamageForceReductionAttributes : ScattergunAttributes.KnockbackReceivedAttributes.DamageForceReductionAttributes() 
	}
	
	open class MetaAttributes : ScattergunAttributes.MetaAttributes() {
		override val killfeed: KillfeedAttributes = KillfeedAttributes()
	
		override val viewmodel: ViewmodelAttributes = ViewmodelAttributes()
	
		override val items: ItemsAttributes = ItemsAttributes()
	
		override val particles: ParticlesAttributes = ParticlesAttributes()
	
		open class KillfeedAttributes : ScattergunAttributes.MetaAttributes.KillfeedAttributes() 
	
		open class ViewmodelAttributes : ScattergunAttributes.MetaAttributes.ViewmodelAttributes() 
	
		open class ItemsAttributes : ScattergunAttributes.MetaAttributes.ItemsAttributes() 
	
		open class ParticlesAttributes : ScattergunAttributes.MetaAttributes.ParticlesAttributes() 
	}
	
	open class MeterAttributes : ScattergunAttributes.MeterAttributes() 
	
	open class MovementAttributes : ScattergunAttributes.MovementAttributes() {
		override val moveSpeed: MoveSpeedAttributes = MoveSpeedAttributes()
	
		open class MoveSpeedAttributes : ScattergunAttributes.MovementAttributes.MoveSpeedAttributes() 
	}
	
	open class HeadsAttributes : ScattergunAttributes.HeadsAttributes() 
	
	open class OnKillAttributes : ScattergunAttributes.OnKillAttributes() 
	
	open class ResistanceAttributes : ScattergunAttributes.ResistanceAttributes() 
	
	open class RevengeCritsAttributes : ScattergunAttributes.RevengeCritsAttributes() 
	
	open class StatusEffectsAttributes : ScattergunAttributes.StatusEffectsAttributes() 
	
	open class TauntingAttributes : ScattergunAttributes.TauntingAttributes() 
	
	open class SwapWeaponsAttributes : ScattergunAttributes.SwapWeaponsAttributes() {
		override val deploy: DeployAttributes = DeployAttributes()
	
		open class DeployAttributes : ScattergunAttributes.SwapWeaponsAttributes.DeployAttributes() 
	}
	
	open class WhenHitAttributes : ScattergunAttributes.WhenHitAttributes() 
	
	open class RagdollsAttributes : ScattergunAttributes.RagdollsAttributes() 
	
	open class DisguiseAttributes : ScattergunAttributes.DisguiseAttributes() 
}