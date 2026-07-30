package btpos.source.vdfdsl.tf2.itemattributes

import btpos.source.vdfdsl.modeling.*
import btpos.source.vdfdsl.serialization.codecs.*
import btpos.source.vdfdsl.tf2.itemattributes.impl.*
import btpos.source.vdfdsl.tf2.tftypes.*
import java.util.*



interface FireAxeAttributes : BaseMeleeAttributes {
	companion object {
		/**
		 * In-Game: "On Hit: target is engulfed in flames"
		 * 
		 * Ignite enemies on hit.
		 */
		val setDamagetypeIgnite: ItemAttributeNamed<Boolean> = ItemAttributeNamed("Set DamageType Ignite")
	
		private val crits: CritsAttributes = CritsAttributes()
	
		private val damage: DamageAttributes = DamageAttributes()
	
		val onHit: OnHitAttributes = OnHitAttributes()
	
		val swapWeapons: SwapWeaponsAttributes = SwapWeaponsAttributes()
	
		val afterburn: AfterburnAttributes = AfterburnAttributes()
	
		private val ammo: AmmoAttributes = AmmoAttributes()
	
		val buildings: BuildingsAttributes = BuildingsAttributes()
	
		val demoCharge: DemoChargeAttributes = DemoChargeAttributes()
	
		val firing: FiringAttributes = FiringAttributes()
	
		val healthAndHealing: HealthAndHealingAttributes = HealthAndHealingAttributes()
	
		private val knockbackReceived: KnockbackReceivedAttributes = KnockbackReceivedAttributes()
	
		private val meta: MetaAttributes = MetaAttributes()
	
		private val meter: MeterAttributes = MeterAttributes()
	
		val movement: MovementAttributes = MovementAttributes()
	
		val heads: HeadsAttributes = HeadsAttributes()
	
		val onKill: OnKillAttributes = OnKillAttributes()
	
		val projectiles: ProjectilesAttributes = ProjectilesAttributes()
	
		val reloading: ReloadingAttributes = ReloadingAttributes()
	
		private val resistance: ResistanceAttributes = ResistanceAttributes()
	
		val revengeCrits: RevengeCritsAttributes = RevengeCritsAttributes()
	
		val statusEffects: StatusEffectsAttributes = StatusEffectsAttributes()
	
		val taunting: TauntingAttributes = TauntingAttributes()
	
		val viewmodel: ViewmodelAttributes = ViewmodelAttributes()
	
		val whenHit: WhenHitAttributes = WhenHitAttributes()
	
		val ragdolls: RagdollsAttributes = RagdollsAttributes()
	}

	/**
	 * In-Game: "On Hit: target is engulfed in flames"
	 * 
	 * Ignite enemies on hit.
	 */
	val setDamagetypeIgnite: ItemAttributeNamed<Boolean> get() = FireAxeAttributes.setDamagetypeIgnite
	
	override val crits: CritsAttributes get() = FireAxeAttributes.crits
	
	override val damage: DamageAttributes get() = FireAxeAttributes.damage
	
	override val onHit: OnHitAttributes get() = FireAxeAttributes.onHit
	
	override val swapWeapons: SwapWeaponsAttributes get() = FireAxeAttributes.swapWeapons
	
	override val afterburn: AfterburnAttributes get() = FireAxeAttributes.afterburn
	
	override val ammo: AmmoAttributes get() = FireAxeAttributes.ammo
	
	override val buildings: BuildingsAttributes get() = FireAxeAttributes.buildings
	
	override val demoCharge: DemoChargeAttributes get() = FireAxeAttributes.demoCharge
	
	override val firing: FiringAttributes get() = FireAxeAttributes.firing
	
	override val healthAndHealing: HealthAndHealingAttributes get() = FireAxeAttributes.healthAndHealing
	
	override val knockbackReceived: KnockbackReceivedAttributes get() = FireAxeAttributes.knockbackReceived
	
	override val meta: MetaAttributes get() = FireAxeAttributes.meta
	
	override val meter: MeterAttributes get() = FireAxeAttributes.meter
	
	override val movement: MovementAttributes get() = FireAxeAttributes.movement
	
	override val heads: HeadsAttributes get() = FireAxeAttributes.heads
	
	override val onKill: OnKillAttributes get() = FireAxeAttributes.onKill
	
	override val projectiles: ProjectilesAttributes get() = FireAxeAttributes.projectiles
	
	override val reloading: ReloadingAttributes get() = FireAxeAttributes.reloading
	
	override val resistance: ResistanceAttributes get() = FireAxeAttributes.resistance
	
	override val revengeCrits: RevengeCritsAttributes get() = FireAxeAttributes.revengeCrits
	
	override val statusEffects: StatusEffectsAttributes get() = FireAxeAttributes.statusEffects
	
	override val taunting: TauntingAttributes get() = FireAxeAttributes.taunting
	
	override val viewmodel: ViewmodelAttributes get() = FireAxeAttributes.viewmodel
	
	override val whenHit: WhenHitAttributes get() = FireAxeAttributes.whenHit
	
	override val ragdolls: RagdollsAttributes get() = FireAxeAttributes.ragdolls

	open class CritsAttributes : BaseMeleeAttributes.CritsAttributes() {
		override val critVsBurningPlayers: CritVsBurningPlayersAttributes = CritVsBurningPlayersAttributes()
	
		open class CritVsBurningPlayersAttributes : BaseMeleeAttributes.CritsAttributes.CritVsBurningPlayersAttributes() 
	}
	
	open class DamageAttributes : BaseMeleeAttributes.DamageAttributes() {
		override val damage: DamageAttributes = DamageAttributes()
	
		open class DamageAttributes : BaseMeleeAttributes.DamageAttributes.DamageAttributes() 
	}
	
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
	
		open class FireRateAttributes : BaseMeleeAttributes.FiringAttributes.FireRateAttributes() {
			override val fireRate: FireRateAttributes = FireRateAttributes()
	
			open class FireRateAttributes : BaseMeleeAttributes.FiringAttributes.FireRateAttributes.FireRateAttributes() 
		}
	}
	
	open class HealthAndHealingAttributes : BaseMeleeAttributes.HealthAndHealingAttributes() 
	
	open class KnockbackReceivedAttributes : BaseMeleeAttributes.KnockbackReceivedAttributes() {
		override val damageForceReduction: DamageForceReductionAttributes = DamageForceReductionAttributes()
	
		open class DamageForceReductionAttributes : BaseMeleeAttributes.KnockbackReceivedAttributes.DamageForceReductionAttributes() 
	}
	
	open class MetaAttributes : BaseMeleeAttributes.MetaAttributes() {
		override val killfeed: KillfeedAttributes = KillfeedAttributes()
	
		open class KillfeedAttributes : BaseMeleeAttributes.MetaAttributes.KillfeedAttributes() 
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
	
	open class ViewmodelAttributes : BaseMeleeAttributes.ViewmodelAttributes() 
	
	open class WhenHitAttributes : BaseMeleeAttributes.WhenHitAttributes() 
	
	open class RagdollsAttributes : BaseMeleeAttributes.RagdollsAttributes() 
}