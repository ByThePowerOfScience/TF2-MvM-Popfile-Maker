package btpos.source.vdfdsl.tf2.itemattributes

import btpos.source.vdfdsl.modeling.*
import btpos.source.vdfdsl.serialization.codecs.*
import btpos.source.vdfdsl.tf2.itemattributes.impl.*
import btpos.source.vdfdsl.tf2.tftypes.*
import java.util.*
import kotlin.time.Duration

interface BonesawAttributes : IBlockScoped, BaseMeleeAttributes {
	companion object : IBlockScoped {
		val heads: HeadsAttributes = HeadsAttributes()
	
		val taunting: TauntingAttributes = TauntingAttributes()
	
		/**
		 * In-Game: "Collect the organs of people you hit"
		 */
		val uberchargePreservedOnSpawnMax: ItemAttributeNamed<Number> = ItemAttributeNamed("ubercharge_preserved_on_spawn_max")
	
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
	
		private val onKill: OnKillAttributes = OnKillAttributes()
	
		private val projectiles: ProjectilesAttributes = ProjectilesAttributes()
	
		private val reloading: ReloadingAttributes = ReloadingAttributes()
	
		private val resistance: ResistanceAttributes = ResistanceAttributes()
	
		private val revengeCrits: RevengeCritsAttributes = RevengeCritsAttributes()
	
		private val statusEffects: StatusEffectsAttributes = StatusEffectsAttributes()
	
		private val whenHit: WhenHitAttributes = WhenHitAttributes()
	
		private val ragdolls: RagdollsAttributes = RagdollsAttributes()
	
		private val disguise: DisguiseAttributes = DisguiseAttributes()
	}

	override val heads: HeadsAttributes get() = BonesawAttributes.heads
	
	override val taunting: TauntingAttributes get() = BonesawAttributes.taunting
	
	/**
	 * In-Game: "Collect the organs of people you hit"
	 */
	val uberchargePreservedOnSpawnMax: ItemAttributeNamed<Number> get() = BonesawAttributes.uberchargePreservedOnSpawnMax
	
	override val crits: CritsAttributes get() = BonesawAttributes.crits
	
	override val damage: DamageAttributes get() = BonesawAttributes.damage
	
	override val onHit: OnHitAttributes get() = BonesawAttributes.onHit
	
	override val swapWeapons: SwapWeaponsAttributes get() = BonesawAttributes.swapWeapons
	
	override val afterburn: AfterburnAttributes get() = BonesawAttributes.afterburn
	
	override val ammo: AmmoAttributes get() = BonesawAttributes.ammo
	
	override val buildings: BuildingsAttributes get() = BonesawAttributes.buildings
	
	override val demoCharge: DemoChargeAttributes get() = BonesawAttributes.demoCharge
	
	override val firing: FiringAttributes get() = BonesawAttributes.firing
	
	override val healthAndHealing: HealthAndHealingAttributes get() = BonesawAttributes.healthAndHealing
	
	override val knockbackReceived: KnockbackReceivedAttributes get() = BonesawAttributes.knockbackReceived
	
	override val meta: MetaAttributes get() = BonesawAttributes.meta
	
	override val meter: MeterAttributes get() = BonesawAttributes.meter
	
	override val movement: MovementAttributes get() = BonesawAttributes.movement
	
	override val onKill: OnKillAttributes get() = BonesawAttributes.onKill
	
	override val projectiles: ProjectilesAttributes get() = BonesawAttributes.projectiles
	
	override val reloading: ReloadingAttributes get() = BonesawAttributes.reloading
	
	override val resistance: ResistanceAttributes get() = BonesawAttributes.resistance
	
	override val revengeCrits: RevengeCritsAttributes get() = BonesawAttributes.revengeCrits
	
	override val statusEffects: StatusEffectsAttributes get() = BonesawAttributes.statusEffects
	
	override val whenHit: WhenHitAttributes get() = BonesawAttributes.whenHit
	
	override val ragdolls: RagdollsAttributes get() = BonesawAttributes.ragdolls
	
	override val disguise: DisguiseAttributes get() = BonesawAttributes.disguise

	open class HeadsAttributes : BaseMeleeAttributes.HeadsAttributes() {
		/**
		 * In-Game: "Collect the organs of your victims"
		 * 
		 * On kill, take an organ (uses "heads" field like usual).
		 */
		open val addHeadOnKill: ItemAttributeNamed<Boolean> = ItemAttributeNamed("add_head_on_kill")
	
		/**
		 * If the player should take a "head" when dealing damage with a melee.
		 */
		open val addHeadOnHit: ItemAttributeNamed<Boolean> = ItemAttributeNamed("add head on hit")
	}
	
	open class TauntingAttributes : BaseMeleeAttributes.TauntingAttributes() {
		/**
		 * If set, the player will taunt on right click.
		 */
		override val specialTaunt: ItemAttributeNamed<Boolean> get() = super.specialTaunt
	}
	
	open class CritsAttributes : BaseMeleeAttributes.CritsAttributes() 
	
	open class DamageAttributes : BaseMeleeAttributes.DamageAttributes() 
	
	open class OnHitAttributes : BaseMeleeAttributes.OnHitAttributes() {
		override val healOnHitForRapidfire: HealOnHitForRapidfireAttributes = HealOnHitForRapidfireAttributes()
	
		override val generateRageOnDamage: GenerateRageOnDamageAttributes = GenerateRageOnDamageAttributes()
	
		open class HealOnHitForRapidfireAttributes : BaseMeleeAttributes.OnHitAttributes.HealOnHitForRapidfireAttributes() 
	
		open class GenerateRageOnDamageAttributes : BaseMeleeAttributes.OnHitAttributes.GenerateRageOnDamageAttributes() 
	}
	
	open class SwapWeaponsAttributes : BaseMeleeAttributes.SwapWeaponsAttributes() {
		override val deploy: DeployAttributes = DeployAttributes()
	
		open class DeployAttributes : BaseMeleeAttributes.SwapWeaponsAttributes.DeployAttributes() 
	}
	
	open class AfterburnAttributes : BaseMeleeAttributes.AfterburnAttributes() 
	
	open class AmmoAttributes : BaseMeleeAttributes.AmmoAttributes() {
		override val clipSize: ClipSizeAttributes = ClipSizeAttributes()
	
		open class ClipSizeAttributes : BaseMeleeAttributes.AmmoAttributes.ClipSizeAttributes() 
	}
	
	open class BuildingsAttributes : BaseMeleeAttributes.BuildingsAttributes() 
	
	open class DemoChargeAttributes : BaseMeleeAttributes.DemoChargeAttributes() 
	
	open class FiringAttributes : BaseMeleeAttributes.FiringAttributes() {
		override val fireRate: FireRateAttributes = FireRateAttributes()
	
		open class FireRateAttributes : BaseMeleeAttributes.FiringAttributes.FireRateAttributes() 
	}
	
	open class HealthAndHealingAttributes : BaseMeleeAttributes.HealthAndHealingAttributes() 
	
	open class KnockbackReceivedAttributes : BaseMeleeAttributes.KnockbackReceivedAttributes() {
		override val damageForceReduction: DamageForceReductionAttributes = DamageForceReductionAttributes()
	
		open class DamageForceReductionAttributes : BaseMeleeAttributes.KnockbackReceivedAttributes.DamageForceReductionAttributes() 
	}
	
	open class MetaAttributes : BaseMeleeAttributes.MetaAttributes() {
		override val killfeed: KillfeedAttributes = KillfeedAttributes()
	
		override val viewmodel: ViewmodelAttributes = ViewmodelAttributes()
	
		override val items: ItemsAttributes = ItemsAttributes()
	
		override val particles: ParticlesAttributes = ParticlesAttributes()
	
		open class KillfeedAttributes : BaseMeleeAttributes.MetaAttributes.KillfeedAttributes() 
	
		open class ViewmodelAttributes : BaseMeleeAttributes.MetaAttributes.ViewmodelAttributes() 
	
		open class ItemsAttributes : BaseMeleeAttributes.MetaAttributes.ItemsAttributes() 
	
		open class ParticlesAttributes : BaseMeleeAttributes.MetaAttributes.ParticlesAttributes() 
	}
	
	open class MeterAttributes : BaseMeleeAttributes.MeterAttributes() 
	
	open class MovementAttributes : BaseMeleeAttributes.MovementAttributes() {
		override val moveSpeed: MoveSpeedAttributes = MoveSpeedAttributes()
	
		open class MoveSpeedAttributes : BaseMeleeAttributes.MovementAttributes.MoveSpeedAttributes() 
	}
	
	open class OnKillAttributes : BaseMeleeAttributes.OnKillAttributes() 
	
	open class ProjectilesAttributes : BaseMeleeAttributes.ProjectilesAttributes() {
		override val projectilePenetration: ProjectilePenetrationAttributes = ProjectilePenetrationAttributes()
	
		override val bullets: BulletsAttributes = BulletsAttributes()
	
		open class ProjectilePenetrationAttributes : BaseMeleeAttributes.ProjectilesAttributes.ProjectilePenetrationAttributes() 
	
		open class BulletsAttributes : BaseMeleeAttributes.ProjectilesAttributes.BulletsAttributes() 
	}
	
	open class ReloadingAttributes : BaseMeleeAttributes.ReloadingAttributes() 
	
	open class ResistanceAttributes : BaseMeleeAttributes.ResistanceAttributes() 
	
	open class RevengeCritsAttributes : BaseMeleeAttributes.RevengeCritsAttributes() 
	
	open class StatusEffectsAttributes : BaseMeleeAttributes.StatusEffectsAttributes() 
	
	open class WhenHitAttributes : BaseMeleeAttributes.WhenHitAttributes() 
	
	open class RagdollsAttributes : BaseMeleeAttributes.RagdollsAttributes() 
	
	open class DisguiseAttributes : BaseMeleeAttributes.DisguiseAttributes() 
}