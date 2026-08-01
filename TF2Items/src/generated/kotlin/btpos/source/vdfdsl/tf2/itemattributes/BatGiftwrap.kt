package btpos.source.vdfdsl.tf2.itemattributes

import btpos.source.vdfdsl.modeling.*
import btpos.source.vdfdsl.serialization.codecs.*
import btpos.source.vdfdsl.tf2.itemattributes.impl.*
import btpos.source.vdfdsl.tf2.tftypes.*
import java.util.*
import kotlin.time.Duration

interface BatGiftwrapAttributes : BatWoodAttributes {
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

	override val crits: CritsAttributes get() = BatGiftwrapAttributes.crits
	
	override val damage: DamageAttributes get() = BatGiftwrapAttributes.damage
	
	override val onHit: OnHitAttributes get() = BatGiftwrapAttributes.onHit
	
	override val swapWeapons: SwapWeaponsAttributes get() = BatGiftwrapAttributes.swapWeapons
	
	override val afterburn: AfterburnAttributes get() = BatGiftwrapAttributes.afterburn
	
	override val ammo: AmmoAttributes get() = BatGiftwrapAttributes.ammo
	
	override val buildings: BuildingsAttributes get() = BatGiftwrapAttributes.buildings
	
	override val demoCharge: DemoChargeAttributes get() = BatGiftwrapAttributes.demoCharge
	
	override val firing: FiringAttributes get() = BatGiftwrapAttributes.firing
	
	override val healthAndHealing: HealthAndHealingAttributes get() = BatGiftwrapAttributes.healthAndHealing
	
	override val knockbackReceived: KnockbackReceivedAttributes get() = BatGiftwrapAttributes.knockbackReceived
	
	override val meta: MetaAttributes get() = BatGiftwrapAttributes.meta
	
	override val meter: MeterAttributes get() = BatGiftwrapAttributes.meter
	
	override val movement: MovementAttributes get() = BatGiftwrapAttributes.movement
	
	override val heads: HeadsAttributes get() = BatGiftwrapAttributes.heads
	
	override val onKill: OnKillAttributes get() = BatGiftwrapAttributes.onKill
	
	override val projectiles: ProjectilesAttributes get() = BatGiftwrapAttributes.projectiles
	
	override val reloading: ReloadingAttributes get() = BatGiftwrapAttributes.reloading
	
	override val resistance: ResistanceAttributes get() = BatGiftwrapAttributes.resistance
	
	override val revengeCrits: RevengeCritsAttributes get() = BatGiftwrapAttributes.revengeCrits
	
	override val statusEffects: StatusEffectsAttributes get() = BatGiftwrapAttributes.statusEffects
	
	override val taunting: TauntingAttributes get() = BatGiftwrapAttributes.taunting
	
	override val whenHit: WhenHitAttributes get() = BatGiftwrapAttributes.whenHit
	
	override val ragdolls: RagdollsAttributes get() = BatGiftwrapAttributes.ragdolls
	
	override val disguise: DisguiseAttributes get() = BatGiftwrapAttributes.disguise

	open class CritsAttributes : BatWoodAttributes.CritsAttributes() 
	
	open class DamageAttributes : BatWoodAttributes.DamageAttributes() 
	
	open class OnHitAttributes : BatWoodAttributes.OnHitAttributes() {
		override val healOnHitForRapidfire: HealOnHitForRapidfireAttributes = HealOnHitForRapidfireAttributes()
	
		override val generateRageOnDamage: GenerateRageOnDamageAttributes = GenerateRageOnDamageAttributes()
	
		open class HealOnHitForRapidfireAttributes : BatWoodAttributes.OnHitAttributes.HealOnHitForRapidfireAttributes() 
	
		open class GenerateRageOnDamageAttributes : BatWoodAttributes.OnHitAttributes.GenerateRageOnDamageAttributes() 
	}
	
	open class SwapWeaponsAttributes : BatWoodAttributes.SwapWeaponsAttributes() {
		override val deploy: DeployAttributes = DeployAttributes()
	
		open class DeployAttributes : BatWoodAttributes.SwapWeaponsAttributes.DeployAttributes() 
	}
	
	open class AfterburnAttributes : BatWoodAttributes.AfterburnAttributes() 
	
	open class AmmoAttributes : BatWoodAttributes.AmmoAttributes() {
		override val clipSize: ClipSizeAttributes = ClipSizeAttributes()
	
		open class ClipSizeAttributes : BatWoodAttributes.AmmoAttributes.ClipSizeAttributes() 
	}
	
	open class BuildingsAttributes : BatWoodAttributes.BuildingsAttributes() 
	
	open class DemoChargeAttributes : BatWoodAttributes.DemoChargeAttributes() 
	
	open class FiringAttributes : BatWoodAttributes.FiringAttributes() {
		override val fireRate: FireRateAttributes = FireRateAttributes()
	
		open class FireRateAttributes : BatWoodAttributes.FiringAttributes.FireRateAttributes() 
	}
	
	open class HealthAndHealingAttributes : BatWoodAttributes.HealthAndHealingAttributes() 
	
	open class KnockbackReceivedAttributes : BatWoodAttributes.KnockbackReceivedAttributes() {
		override val damageForceReduction: DamageForceReductionAttributes = DamageForceReductionAttributes()
	
		open class DamageForceReductionAttributes : BatWoodAttributes.KnockbackReceivedAttributes.DamageForceReductionAttributes() 
	}
	
	open class MetaAttributes : BatWoodAttributes.MetaAttributes() {
		override val killfeed: KillfeedAttributes = KillfeedAttributes()
	
		override val viewmodel: ViewmodelAttributes = ViewmodelAttributes()
	
		override val items: ItemsAttributes = ItemsAttributes()
	
		override val particles: ParticlesAttributes = ParticlesAttributes()
	
		open class KillfeedAttributes : BatWoodAttributes.MetaAttributes.KillfeedAttributes() 
	
		open class ViewmodelAttributes : BatWoodAttributes.MetaAttributes.ViewmodelAttributes() 
	
		open class ItemsAttributes : BatWoodAttributes.MetaAttributes.ItemsAttributes() 
	
		open class ParticlesAttributes : BatWoodAttributes.MetaAttributes.ParticlesAttributes() 
	}
	
	open class MeterAttributes : BatWoodAttributes.MeterAttributes() 
	
	open class MovementAttributes : BatWoodAttributes.MovementAttributes() {
		override val moveSpeed: MoveSpeedAttributes = MoveSpeedAttributes()
	
		open class MoveSpeedAttributes : BatWoodAttributes.MovementAttributes.MoveSpeedAttributes() 
	}
	
	open class HeadsAttributes : BatWoodAttributes.HeadsAttributes() 
	
	open class OnKillAttributes : BatWoodAttributes.OnKillAttributes() 
	
	open class ProjectilesAttributes : BatWoodAttributes.ProjectilesAttributes() {
		override val projectilePenetration: ProjectilePenetrationAttributes = ProjectilePenetrationAttributes()
	
		override val bullets: BulletsAttributes = BulletsAttributes()
	
		open class ProjectilePenetrationAttributes : BatWoodAttributes.ProjectilesAttributes.ProjectilePenetrationAttributes() 
	
		open class BulletsAttributes : BatWoodAttributes.ProjectilesAttributes.BulletsAttributes() 
	}
	
	open class ReloadingAttributes : BatWoodAttributes.ReloadingAttributes() 
	
	open class ResistanceAttributes : BatWoodAttributes.ResistanceAttributes() 
	
	open class RevengeCritsAttributes : BatWoodAttributes.RevengeCritsAttributes() 
	
	open class StatusEffectsAttributes : BatWoodAttributes.StatusEffectsAttributes() 
	
	open class TauntingAttributes : BatWoodAttributes.TauntingAttributes() 
	
	open class WhenHitAttributes : BatWoodAttributes.WhenHitAttributes() 
	
	open class RagdollsAttributes : BatWoodAttributes.RagdollsAttributes() 
	
	open class DisguiseAttributes : BatWoodAttributes.DisguiseAttributes() 
}