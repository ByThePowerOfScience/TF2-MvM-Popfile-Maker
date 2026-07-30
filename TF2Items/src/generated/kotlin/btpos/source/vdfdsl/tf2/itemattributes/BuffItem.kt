package btpos.source.vdfdsl.tf2.itemattributes

import btpos.source.vdfdsl.modeling.*
import btpos.source.vdfdsl.serialization.codecs.*
import btpos.source.vdfdsl.tf2.itemattributes.impl.*
import btpos.source.vdfdsl.tf2.tftypes.*
import java.util.*



interface BuffItemAttributes : BaseMeleeAttributes {
	companion object {
		val buffItems: BuffItemsAttributes = BuffItemsAttributes()
	
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

	val buffItems: BuffItemsAttributes get() = BuffItemAttributes.buffItems
	
	override val crits: CritsAttributes get() = BuffItemAttributes.crits
	
	override val damage: DamageAttributes get() = BuffItemAttributes.damage
	
	override val onHit: OnHitAttributes get() = BuffItemAttributes.onHit
	
	override val swapWeapons: SwapWeaponsAttributes get() = BuffItemAttributes.swapWeapons
	
	override val afterburn: AfterburnAttributes get() = BuffItemAttributes.afterburn
	
	override val ammo: AmmoAttributes get() = BuffItemAttributes.ammo
	
	override val buildings: BuildingsAttributes get() = BuffItemAttributes.buildings
	
	override val demoCharge: DemoChargeAttributes get() = BuffItemAttributes.demoCharge
	
	override val firing: FiringAttributes get() = BuffItemAttributes.firing
	
	override val healthAndHealing: HealthAndHealingAttributes get() = BuffItemAttributes.healthAndHealing
	
	override val knockbackReceived: KnockbackReceivedAttributes get() = BuffItemAttributes.knockbackReceived
	
	override val meta: MetaAttributes get() = BuffItemAttributes.meta
	
	override val meter: MeterAttributes get() = BuffItemAttributes.meter
	
	override val movement: MovementAttributes get() = BuffItemAttributes.movement
	
	override val heads: HeadsAttributes get() = BuffItemAttributes.heads
	
	override val onKill: OnKillAttributes get() = BuffItemAttributes.onKill
	
	override val projectiles: ProjectilesAttributes get() = BuffItemAttributes.projectiles
	
	override val reloading: ReloadingAttributes get() = BuffItemAttributes.reloading
	
	override val resistance: ResistanceAttributes get() = BuffItemAttributes.resistance
	
	override val revengeCrits: RevengeCritsAttributes get() = BuffItemAttributes.revengeCrits
	
	override val statusEffects: StatusEffectsAttributes get() = BuffItemAttributes.statusEffects
	
	override val taunting: TauntingAttributes get() = BuffItemAttributes.taunting
	
	override val viewmodel: ViewmodelAttributes get() = BuffItemAttributes.viewmodel
	
	override val whenHit: WhenHitAttributes get() = BuffItemAttributes.whenHit
	
	override val ragdolls: RagdollsAttributes get() = BuffItemAttributes.ragdolls

	open class BuffItemsAttributes : IBlockScoped {
		open val buffDuration: VisHidden<Float> = VisHidden(ItemAttributeNamed<Float>("increase buff duration"), ItemAttributeNamed<Float>("increase buff duration HIDDEN"))
	
		open val buffType: BuffTypeAttributes = BuffTypeAttributes()
	
		open class BuffTypeAttributes : IBlockScoped {
			/**
			 * Sets which banner is used.
			 * 
			 * 0 = Buff Banner.
			 * 
			 * 1 = Battalion's Backup.
			 * 
			 * 2 = Concheror.
			 */
			open val soldierBuffType: ItemAttributeNamed<Int> = ItemAttributeNamed("mod soldier buff type")
	
			/**
			 * Sets which banner is used.
			 * 
			 * 0 = Buff Banner.
			 * 
			 * 1 = Battalion's Backup.
			 * 
			 * 2 = Concheror.
			 */
			open val demoBuffType: ItemAttributeNamed<Int> = ItemAttributeNamed("mod demo buff type")
		}
	}
	
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