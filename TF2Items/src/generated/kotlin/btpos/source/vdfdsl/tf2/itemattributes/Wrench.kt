package btpos.source.vdfdsl.tf2.itemattributes

import btpos.source.vdfdsl.modeling.*
import btpos.source.vdfdsl.serialization.codecs.*
import btpos.source.vdfdsl.tf2.itemattributes.impl.*
import btpos.source.vdfdsl.tf2.tftypes.*
import java.util.*
import kotlin.time.Duration

interface WrenchAttributes : BaseMeleeAttributes {
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
	
		/**
		 * Bonus:
		 * 
		 * 	- In-Game: "Construction hit speed boost increased by N%"
		 * 
		 * Penalty:
		 * 
		 * 	- In-Game: "Construction hit speed boost decreased by N%"
		 */
		val constructionRate: BonusPenalty<Number> = BonusPenalty(
			ItemAttributeNamed("Construction rate increased"),
			ItemAttributeNamed("Construction rate decreased"),
		)
	
		/**
		 * Bonus:
		 * 
		 * 	- In-Game: "N% faster repair rate"
		 * 
		 * Penalty:
		 * 
		 * 	- In-Game: "N% slower repair rate"
		 */
		val repairRate: BonusPenalty<Number> = BonusPenalty(
			ItemAttributeNamed("Repair rate increased"),
			ItemAttributeNamed("Repair rate decreased"),
		)
	
		/**
		 * In-Game: "Replaces the Sentry with a Mini-Sentry"
		 * 
		 * Sentry built is a minisentry.
		 * 
		 * Detonates leveled sentries when equipping a wrench with this attribute.
		 * 
		 * If not in MvM (player is not on team "PVE_DEFENDERS"), detonate minis when unequipping a wrench with this attribute.
		 * 
		 * Removes engineer's glove on his model.
		 */
		val wrenchBuildsMinisentry: ItemAttributeNamed<Boolean> = ItemAttributeNamed("mod wrench builds minisentry")
	}

	override val buildings: BuildingsAttributes get() = WrenchAttributes.buildings
	
	/**
	 * In-Game: "Press your reload key to choose to teleport to spawn or your exit teleporter"
	 * 
	 * If set, pressing reload shows the Eureka Effect teleport menu.
	 */
	val altFireTeleportToSpawn: ItemAttributeNamed<Boolean> get() = WrenchAttributes.altFireTeleportToSpawn.get()
	
	override val crits: CritsAttributes get() = WrenchAttributes.crits
	
	override val damage: DamageAttributes get() = WrenchAttributes.damage
	
	override val onHit: OnHitAttributes get() = WrenchAttributes.onHit
	
	override val swapWeapons: SwapWeaponsAttributes get() = WrenchAttributes.swapWeapons
	
	override val afterburn: AfterburnAttributes get() = WrenchAttributes.afterburn
	
	override val ammo: AmmoAttributes get() = WrenchAttributes.ammo
	
	override val demoCharge: DemoChargeAttributes get() = WrenchAttributes.demoCharge
	
	override val firing: FiringAttributes get() = WrenchAttributes.firing
	
	override val healthAndHealing: HealthAndHealingAttributes get() = WrenchAttributes.healthAndHealing
	
	override val knockbackReceived: KnockbackReceivedAttributes get() = WrenchAttributes.knockbackReceived
	
	override val meta: MetaAttributes get() = WrenchAttributes.meta
	
	override val meter: MeterAttributes get() = WrenchAttributes.meter
	
	override val movement: MovementAttributes get() = WrenchAttributes.movement
	
	override val heads: HeadsAttributes get() = WrenchAttributes.heads
	
	override val onKill: OnKillAttributes get() = WrenchAttributes.onKill
	
	override val projectiles: ProjectilesAttributes get() = WrenchAttributes.projectiles
	
	override val reloading: ReloadingAttributes get() = WrenchAttributes.reloading
	
	override val resistance: ResistanceAttributes get() = WrenchAttributes.resistance
	
	override val revengeCrits: RevengeCritsAttributes get() = WrenchAttributes.revengeCrits
	
	override val statusEffects: StatusEffectsAttributes get() = WrenchAttributes.statusEffects
	
	override val taunting: TauntingAttributes get() = WrenchAttributes.taunting
	
	override val whenHit: WhenHitAttributes get() = WrenchAttributes.whenHit
	
	override val ragdolls: RagdollsAttributes get() = WrenchAttributes.ragdolls
	
	override val disguise: DisguiseAttributes get() = WrenchAttributes.disguise

	open class BuildingsAttributes : BaseMeleeAttributes.BuildingsAttributes() {
		companion object : IBlockScoped {
			val sentryGun: SentryGunAttributes = SentryGunAttributes()
		}
	
		/**
		 * Bonus:
		 * 
		 * 	- In-Game: "Construction hit speed boost increased by N%"
		 * 
		 * Penalty:
		 * 
		 * 	- In-Game: "Construction hit speed boost decreased by N%"
		 */
		context(attrs: IAttributeContainer)
		open var constructionRate: Number? 
			get() = WrenchAttributes.constructionRate.get()
			set(value) { WrenchAttributes.constructionRate.set(value) }
	
		/**
		 * Bonus:
		 * 
		 * 	- In-Game: "N% faster repair rate"
		 * 
		 * Penalty:
		 * 
		 * 	- In-Game: "N% slower repair rate"
		 */
		context(attrs: IAttributeContainer)
		open var repairRate: Number? 
			get() = WrenchAttributes.repairRate.get()
			set(value) { WrenchAttributes.repairRate.set(value) }
	
		open val sentryGun: SentryGunAttributes = SentryGunAttributes()
	
		open class SentryGunAttributes : IBlockScoped {
			companion object : IBlockScoped 
	
			/**
			 * In-Game: "Replaces the Sentry with a Mini-Sentry"
			 * 
			 * Sentry built is a minisentry.
			 * 
			 * Detonates leveled sentries when equipping a wrench with this attribute.
			 * 
			 * If not in MvM (player is not on team "PVE_DEFENDERS"), detonate minis when unequipping a wrench with this attribute.
			 * 
			 * Removes engineer's glove on his model.
			 */
			context(attrs: IAttributeContainer)
			open var wrenchBuildsMinisentry: Boolean? 
				get() = WrenchAttributes.wrenchBuildsMinisentry.get()
				set(value) { WrenchAttributes.wrenchBuildsMinisentry.set(value) }
		}
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
	
	open class HeadsAttributes : BaseMeleeAttributes.HeadsAttributes() 
	
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
	
	open class TauntingAttributes : BaseMeleeAttributes.TauntingAttributes() 
	
	open class WhenHitAttributes : BaseMeleeAttributes.WhenHitAttributes() 
	
	open class RagdollsAttributes : BaseMeleeAttributes.RagdollsAttributes() 
	
	open class DisguiseAttributes : BaseMeleeAttributes.DisguiseAttributes() 
}