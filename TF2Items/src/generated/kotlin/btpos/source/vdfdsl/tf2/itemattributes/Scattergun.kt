package btpos.source.vdfdsl.tf2.itemattributes

import btpos.source.vdfdsl.modeling.*
import btpos.source.vdfdsl.serialization.codecs.*
import btpos.source.vdfdsl.tf2.itemattributes.impl.*
import btpos.source.vdfdsl.tf2.tftypes.*
import java.util.*
import kotlin.time.Duration

interface ScattergunAttributes : IBlockScoped, ShotgunAttributes {
	companion object : IBlockScoped {
		val onHit: OnHitAttributes = OnHitAttributes()
	
		val reloading: ReloadingAttributes = ReloadingAttributes()
	
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

	override val onHit: OnHitAttributes get() = ScattergunAttributes.onHit
	
	override val reloading: ReloadingAttributes get() = ScattergunAttributes.reloading
	
	override val ammo: AmmoAttributes get() = ScattergunAttributes.ammo
	
	override val damage: DamageAttributes get() = ScattergunAttributes.damage
	
	override val firing: FiringAttributes get() = ScattergunAttributes.firing
	
	override val projectiles: ProjectilesAttributes get() = ScattergunAttributes.projectiles
	
	override val afterburn: AfterburnAttributes get() = ScattergunAttributes.afterburn
	
	override val buildings: BuildingsAttributes get() = ScattergunAttributes.buildings
	
	override val crits: CritsAttributes get() = ScattergunAttributes.crits
	
	override val demoCharge: DemoChargeAttributes get() = ScattergunAttributes.demoCharge
	
	override val healthAndHealing: HealthAndHealingAttributes get() = ScattergunAttributes.healthAndHealing
	
	override val knockbackReceived: KnockbackReceivedAttributes get() = ScattergunAttributes.knockbackReceived
	
	override val meta: MetaAttributes get() = ScattergunAttributes.meta
	
	override val meter: MeterAttributes get() = ScattergunAttributes.meter
	
	override val movement: MovementAttributes get() = ScattergunAttributes.movement
	
	override val heads: HeadsAttributes get() = ScattergunAttributes.heads
	
	override val onKill: OnKillAttributes get() = ScattergunAttributes.onKill
	
	override val resistance: ResistanceAttributes get() = ScattergunAttributes.resistance
	
	override val revengeCrits: RevengeCritsAttributes get() = ScattergunAttributes.revengeCrits
	
	override val statusEffects: StatusEffectsAttributes get() = ScattergunAttributes.statusEffects
	
	override val taunting: TauntingAttributes get() = ScattergunAttributes.taunting
	
	override val swapWeapons: SwapWeaponsAttributes get() = ScattergunAttributes.swapWeapons
	
	override val whenHit: WhenHitAttributes get() = ScattergunAttributes.whenHit
	
	override val ragdolls: RagdollsAttributes get() = ScattergunAttributes.ragdolls
	
	override val disguise: DisguiseAttributes get() = ScattergunAttributes.disguise

	open class OnHitAttributes : ShotgunAttributes.OnHitAttributes() {
		/**
		 * In-Game: "Knockback on the target and shooter"
		 * 
		 * Note: if `scattergun_knockback_mult` is greater than 1.0, this is not necessary.
		 */
		open val scattergunHasKnockback: ItemAttributeNamed<Boolean> = ItemAttributeNamed("scattergun has knockback")
	
		open val scattergunKnockbackMult: ItemAttributeNamed<Number> = ItemAttributeNamed("scattergun knockback mult")
	
		override val healOnHitForRapidfire: HealOnHitForRapidfireAttributes = HealOnHitForRapidfireAttributes()
	
		override val generateRageOnDamage: GenerateRageOnDamageAttributes = GenerateRageOnDamageAttributes()
	
		open class HealOnHitForRapidfireAttributes : ShotgunAttributes.OnHitAttributes.HealOnHitForRapidfireAttributes() 
	
		open class GenerateRageOnDamageAttributes : ShotgunAttributes.OnHitAttributes.GenerateRageOnDamageAttributes() 
	}
	
	open class ReloadingAttributes : ShotgunAttributes.ReloadingAttributes() {
		/**
		 * If 1, reloads entire clip at once.
		 */
		open val scattergunNoReloadSingle: ItemAttributeNamed<Boolean> = ItemAttributeNamed("scattergun no reload single")
	}
	
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
	
	open class OnKillAttributes : ShotgunAttributes.OnKillAttributes() 
	
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