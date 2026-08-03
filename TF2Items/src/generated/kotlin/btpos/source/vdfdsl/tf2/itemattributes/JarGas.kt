package btpos.source.vdfdsl.tf2.itemattributes

import btpos.source.vdfdsl.modeling.*
import btpos.source.vdfdsl.serialization.codecs.*
import btpos.source.vdfdsl.tf2.itemattributes.impl.*
import btpos.source.vdfdsl.tf2.tftypes.*
import java.util.*
import kotlin.time.Duration

interface JarGasAttributes : IBlockScoped, JarAttributes {
	companion object : IBlockScoped {
		private val projectiles: ProjectilesAttributes = ProjectilesAttributes()
	
		private val meter: MeterAttributes = MeterAttributes()
	
		private val onHit: OnHitAttributes = OnHitAttributes()
	
		private val ammo: AmmoAttributes = AmmoAttributes()
	
		private val damage: DamageAttributes = DamageAttributes()
	
		private val firing: FiringAttributes = FiringAttributes()
	
		private val afterburn: AfterburnAttributes = AfterburnAttributes()
	
		private val buildings: BuildingsAttributes = BuildingsAttributes()
	
		private val crits: CritsAttributes = CritsAttributes()
	
		private val demoCharge: DemoChargeAttributes = DemoChargeAttributes()
	
		private val healthAndHealing: HealthAndHealingAttributes = HealthAndHealingAttributes()
	
		private val knockbackReceived: KnockbackReceivedAttributes = KnockbackReceivedAttributes()
	
		private val meta: MetaAttributes = MetaAttributes()
	
		private val movement: MovementAttributes = MovementAttributes()
	
		private val heads: HeadsAttributes = HeadsAttributes()
	
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

	override val projectiles: ProjectilesAttributes get() = JarGasAttributes.projectiles
	
	override val meter: MeterAttributes get() = JarGasAttributes.meter
	
	override val onHit: OnHitAttributes get() = JarGasAttributes.onHit
	
	override val ammo: AmmoAttributes get() = JarGasAttributes.ammo
	
	override val damage: DamageAttributes get() = JarGasAttributes.damage
	
	override val firing: FiringAttributes get() = JarGasAttributes.firing
	
	override val afterburn: AfterburnAttributes get() = JarGasAttributes.afterburn
	
	override val buildings: BuildingsAttributes get() = JarGasAttributes.buildings
	
	override val crits: CritsAttributes get() = JarGasAttributes.crits
	
	override val demoCharge: DemoChargeAttributes get() = JarGasAttributes.demoCharge
	
	override val healthAndHealing: HealthAndHealingAttributes get() = JarGasAttributes.healthAndHealing
	
	override val knockbackReceived: KnockbackReceivedAttributes get() = JarGasAttributes.knockbackReceived
	
	override val meta: MetaAttributes get() = JarGasAttributes.meta
	
	override val movement: MovementAttributes get() = JarGasAttributes.movement
	
	override val heads: HeadsAttributes get() = JarGasAttributes.heads
	
	override val onKill: OnKillAttributes get() = JarGasAttributes.onKill
	
	override val reloading: ReloadingAttributes get() = JarGasAttributes.reloading
	
	override val resistance: ResistanceAttributes get() = JarGasAttributes.resistance
	
	override val revengeCrits: RevengeCritsAttributes get() = JarGasAttributes.revengeCrits
	
	override val statusEffects: StatusEffectsAttributes get() = JarGasAttributes.statusEffects
	
	override val taunting: TauntingAttributes get() = JarGasAttributes.taunting
	
	override val swapWeapons: SwapWeaponsAttributes get() = JarGasAttributes.swapWeapons
	
	override val whenHit: WhenHitAttributes get() = JarGasAttributes.whenHit
	
	override val ragdolls: RagdollsAttributes get() = JarGasAttributes.ragdolls
	
	override val disguise: DisguiseAttributes get() = JarGasAttributes.disguise

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
	
	open class DamageAttributes : JarAttributes.DamageAttributes() 
	
	open class FiringAttributes : JarAttributes.FiringAttributes() {
		override val fireRate: FireRateAttributes = FireRateAttributes()
	
		open class FireRateAttributes : JarAttributes.FiringAttributes.FireRateAttributes() 
	}
	
	open class AfterburnAttributes : JarAttributes.AfterburnAttributes() 
	
	open class BuildingsAttributes : JarAttributes.BuildingsAttributes() 
	
	open class CritsAttributes : JarAttributes.CritsAttributes() 
	
	open class DemoChargeAttributes : JarAttributes.DemoChargeAttributes() 
	
	open class HealthAndHealingAttributes : JarAttributes.HealthAndHealingAttributes() 
	
	open class KnockbackReceivedAttributes : JarAttributes.KnockbackReceivedAttributes() {
		override val damageForceReduction: DamageForceReductionAttributes = DamageForceReductionAttributes()
	
		open class DamageForceReductionAttributes : JarAttributes.KnockbackReceivedAttributes.DamageForceReductionAttributes() 
	}
	
	open class MetaAttributes : JarAttributes.MetaAttributes() {
		override val killfeed: KillfeedAttributes = KillfeedAttributes()
	
		override val viewmodel: ViewmodelAttributes = ViewmodelAttributes()
	
		override val items: ItemsAttributes = ItemsAttributes()
	
		override val particles: ParticlesAttributes = ParticlesAttributes()
	
		open class KillfeedAttributes : JarAttributes.MetaAttributes.KillfeedAttributes() 
	
		open class ViewmodelAttributes : JarAttributes.MetaAttributes.ViewmodelAttributes() 
	
		open class ItemsAttributes : JarAttributes.MetaAttributes.ItemsAttributes() 
	
		open class ParticlesAttributes : JarAttributes.MetaAttributes.ParticlesAttributes() 
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
	
	open class SwapWeaponsAttributes : JarAttributes.SwapWeaponsAttributes() {
		override val deploy: DeployAttributes = DeployAttributes()
	
		open class DeployAttributes : JarAttributes.SwapWeaponsAttributes.DeployAttributes() 
	}
	
	open class WhenHitAttributes : JarAttributes.WhenHitAttributes() 
	
	open class RagdollsAttributes : JarAttributes.RagdollsAttributes() 
	
	open class DisguiseAttributes : JarAttributes.DisguiseAttributes() 
}