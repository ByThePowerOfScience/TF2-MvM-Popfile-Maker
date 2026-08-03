package btpos.source.vdfdsl.tf2.itemattributes

import btpos.source.vdfdsl.modeling.*
import btpos.source.vdfdsl.serialization.codecs.*
import btpos.source.vdfdsl.tf2.itemattributes.impl.*
import btpos.source.vdfdsl.tf2.tftypes.*
import java.util.*
import kotlin.time.Duration

interface ScoutPistolAttributes : IBlockScoped, PistolAttributes {
	companion object : IBlockScoped {
		/**
		 * If true, can headshot when behind an enemy.
		 */
		val backHeadshot: ItemAttributeNamed<Boolean> = ItemAttributeNamed("back headshot")
	
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

	/**
	 * If true, can headshot when behind an enemy.
	 */
	val backHeadshot: ItemAttributeNamed<Boolean> get() = ScoutPistolAttributes.backHeadshot
	
	override val ammo: AmmoAttributes get() = ScoutPistolAttributes.ammo
	
	override val damage: DamageAttributes get() = ScoutPistolAttributes.damage
	
	override val firing: FiringAttributes get() = ScoutPistolAttributes.firing
	
	override val projectiles: ProjectilesAttributes get() = ScoutPistolAttributes.projectiles
	
	override val afterburn: AfterburnAttributes get() = ScoutPistolAttributes.afterburn
	
	override val buildings: BuildingsAttributes get() = ScoutPistolAttributes.buildings
	
	override val crits: CritsAttributes get() = ScoutPistolAttributes.crits
	
	override val demoCharge: DemoChargeAttributes get() = ScoutPistolAttributes.demoCharge
	
	override val healthAndHealing: HealthAndHealingAttributes get() = ScoutPistolAttributes.healthAndHealing
	
	override val knockbackReceived: KnockbackReceivedAttributes get() = ScoutPistolAttributes.knockbackReceived
	
	override val meta: MetaAttributes get() = ScoutPistolAttributes.meta
	
	override val meter: MeterAttributes get() = ScoutPistolAttributes.meter
	
	override val movement: MovementAttributes get() = ScoutPistolAttributes.movement
	
	override val heads: HeadsAttributes get() = ScoutPistolAttributes.heads
	
	override val onHit: OnHitAttributes get() = ScoutPistolAttributes.onHit
	
	override val onKill: OnKillAttributes get() = ScoutPistolAttributes.onKill
	
	override val reloading: ReloadingAttributes get() = ScoutPistolAttributes.reloading
	
	override val resistance: ResistanceAttributes get() = ScoutPistolAttributes.resistance
	
	override val revengeCrits: RevengeCritsAttributes get() = ScoutPistolAttributes.revengeCrits
	
	override val statusEffects: StatusEffectsAttributes get() = ScoutPistolAttributes.statusEffects
	
	override val taunting: TauntingAttributes get() = ScoutPistolAttributes.taunting
	
	override val swapWeapons: SwapWeaponsAttributes get() = ScoutPistolAttributes.swapWeapons
	
	override val whenHit: WhenHitAttributes get() = ScoutPistolAttributes.whenHit
	
	override val ragdolls: RagdollsAttributes get() = ScoutPistolAttributes.ragdolls
	
	override val disguise: DisguiseAttributes get() = ScoutPistolAttributes.disguise

	open class AmmoAttributes : PistolAttributes.AmmoAttributes() {
		override val clipSize: ClipSizeAttributes = ClipSizeAttributes()
	
		open class ClipSizeAttributes : PistolAttributes.AmmoAttributes.ClipSizeAttributes() 
	}
	
	open class DamageAttributes : PistolAttributes.DamageAttributes() 
	
	open class FiringAttributes : PistolAttributes.FiringAttributes() {
		override val fireRate: FireRateAttributes = FireRateAttributes()
	
		open class FireRateAttributes : PistolAttributes.FiringAttributes.FireRateAttributes() 
	}
	
	open class ProjectilesAttributes : PistolAttributes.ProjectilesAttributes() {
		override val bullets: BulletsAttributes = BulletsAttributes()
	
		override val projectilePenetration: ProjectilePenetrationAttributes = ProjectilePenetrationAttributes()
	
		open class BulletsAttributes : PistolAttributes.ProjectilesAttributes.BulletsAttributes() 
	
		open class ProjectilePenetrationAttributes : PistolAttributes.ProjectilesAttributes.ProjectilePenetrationAttributes() 
	}
	
	open class AfterburnAttributes : PistolAttributes.AfterburnAttributes() 
	
	open class BuildingsAttributes : PistolAttributes.BuildingsAttributes() 
	
	open class CritsAttributes : PistolAttributes.CritsAttributes() 
	
	open class DemoChargeAttributes : PistolAttributes.DemoChargeAttributes() 
	
	open class HealthAndHealingAttributes : PistolAttributes.HealthAndHealingAttributes() 
	
	open class KnockbackReceivedAttributes : PistolAttributes.KnockbackReceivedAttributes() {
		override val damageForceReduction: DamageForceReductionAttributes = DamageForceReductionAttributes()
	
		open class DamageForceReductionAttributes : PistolAttributes.KnockbackReceivedAttributes.DamageForceReductionAttributes() 
	}
	
	open class MetaAttributes : PistolAttributes.MetaAttributes() {
		override val killfeed: KillfeedAttributes = KillfeedAttributes()
	
		override val viewmodel: ViewmodelAttributes = ViewmodelAttributes()
	
		override val items: ItemsAttributes = ItemsAttributes()
	
		override val particles: ParticlesAttributes = ParticlesAttributes()
	
		open class KillfeedAttributes : PistolAttributes.MetaAttributes.KillfeedAttributes() 
	
		open class ViewmodelAttributes : PistolAttributes.MetaAttributes.ViewmodelAttributes() 
	
		open class ItemsAttributes : PistolAttributes.MetaAttributes.ItemsAttributes() 
	
		open class ParticlesAttributes : PistolAttributes.MetaAttributes.ParticlesAttributes() 
	}
	
	open class MeterAttributes : PistolAttributes.MeterAttributes() 
	
	open class MovementAttributes : PistolAttributes.MovementAttributes() {
		override val moveSpeed: MoveSpeedAttributes = MoveSpeedAttributes()
	
		open class MoveSpeedAttributes : PistolAttributes.MovementAttributes.MoveSpeedAttributes() 
	}
	
	open class HeadsAttributes : PistolAttributes.HeadsAttributes() 
	
	open class OnHitAttributes : PistolAttributes.OnHitAttributes() {
		override val healOnHitForRapidfire: HealOnHitForRapidfireAttributes = HealOnHitForRapidfireAttributes()
	
		override val generateRageOnDamage: GenerateRageOnDamageAttributes = GenerateRageOnDamageAttributes()
	
		open class HealOnHitForRapidfireAttributes : PistolAttributes.OnHitAttributes.HealOnHitForRapidfireAttributes() 
	
		open class GenerateRageOnDamageAttributes : PistolAttributes.OnHitAttributes.GenerateRageOnDamageAttributes() 
	}
	
	open class OnKillAttributes : PistolAttributes.OnKillAttributes() 
	
	open class ReloadingAttributes : PistolAttributes.ReloadingAttributes() 
	
	open class ResistanceAttributes : PistolAttributes.ResistanceAttributes() 
	
	open class RevengeCritsAttributes : PistolAttributes.RevengeCritsAttributes() 
	
	open class StatusEffectsAttributes : PistolAttributes.StatusEffectsAttributes() 
	
	open class TauntingAttributes : PistolAttributes.TauntingAttributes() 
	
	open class SwapWeaponsAttributes : PistolAttributes.SwapWeaponsAttributes() {
		override val deploy: DeployAttributes = DeployAttributes()
	
		open class DeployAttributes : PistolAttributes.SwapWeaponsAttributes.DeployAttributes() 
	}
	
	open class WhenHitAttributes : PistolAttributes.WhenHitAttributes() 
	
	open class RagdollsAttributes : PistolAttributes.RagdollsAttributes() 
	
	open class DisguiseAttributes : PistolAttributes.DisguiseAttributes() 
}