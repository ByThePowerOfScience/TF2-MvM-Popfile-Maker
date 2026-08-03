package btpos.source.vdfdsl.tf2.itemattributes

import btpos.source.vdfdsl.modeling.*
import btpos.source.vdfdsl.serialization.codecs.*
import btpos.source.vdfdsl.tf2.itemattributes.impl.*
import btpos.source.vdfdsl.tf2.tftypes.*
import java.util.*
import kotlin.time.Duration

interface LunchboxDrinkAttributes : IBlockScoped, LunchboxAttributes {
	companion object : IBlockScoped {
		private val afterburn: AfterburnAttributes = AfterburnAttributes()
	
		private val ammo: AmmoAttributes = AmmoAttributes()
	
		private val buildings: BuildingsAttributes = BuildingsAttributes()
	
		private val crits: CritsAttributes = CritsAttributes()
	
		private val damage: DamageAttributes = DamageAttributes()
	
		private val demoCharge: DemoChargeAttributes = DemoChargeAttributes()
	
		private val firing: FiringAttributes = FiringAttributes()
	
		private val healthAndHealing: HealthAndHealingAttributes = HealthAndHealingAttributes()
	
		private val knockbackReceived: KnockbackReceivedAttributes = KnockbackReceivedAttributes()
	
		private val meta: MetaAttributes = MetaAttributes()
	
		private val meter: MeterAttributes = MeterAttributes()
	
		private val movement: MovementAttributes = MovementAttributes()
	
		private val heads: HeadsAttributes = HeadsAttributes()
	
		private val onHit: OnHitAttributes = OnHitAttributes()
	
		private val onKill: OnKillAttributes = OnKillAttributes()
	
		private val projectiles: ProjectilesAttributes = ProjectilesAttributes()
	
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

	override val afterburn: AfterburnAttributes get() = LunchboxDrinkAttributes.afterburn
	
	override val ammo: AmmoAttributes get() = LunchboxDrinkAttributes.ammo
	
	override val buildings: BuildingsAttributes get() = LunchboxDrinkAttributes.buildings
	
	override val crits: CritsAttributes get() = LunchboxDrinkAttributes.crits
	
	override val damage: DamageAttributes get() = LunchboxDrinkAttributes.damage
	
	override val demoCharge: DemoChargeAttributes get() = LunchboxDrinkAttributes.demoCharge
	
	override val firing: FiringAttributes get() = LunchboxDrinkAttributes.firing
	
	override val healthAndHealing: HealthAndHealingAttributes get() = LunchboxDrinkAttributes.healthAndHealing
	
	override val knockbackReceived: KnockbackReceivedAttributes get() = LunchboxDrinkAttributes.knockbackReceived
	
	override val meta: MetaAttributes get() = LunchboxDrinkAttributes.meta
	
	override val meter: MeterAttributes get() = LunchboxDrinkAttributes.meter
	
	override val movement: MovementAttributes get() = LunchboxDrinkAttributes.movement
	
	override val heads: HeadsAttributes get() = LunchboxDrinkAttributes.heads
	
	override val onHit: OnHitAttributes get() = LunchboxDrinkAttributes.onHit
	
	override val onKill: OnKillAttributes get() = LunchboxDrinkAttributes.onKill
	
	override val projectiles: ProjectilesAttributes get() = LunchboxDrinkAttributes.projectiles
	
	override val reloading: ReloadingAttributes get() = LunchboxDrinkAttributes.reloading
	
	override val resistance: ResistanceAttributes get() = LunchboxDrinkAttributes.resistance
	
	override val revengeCrits: RevengeCritsAttributes get() = LunchboxDrinkAttributes.revengeCrits
	
	override val statusEffects: StatusEffectsAttributes get() = LunchboxDrinkAttributes.statusEffects
	
	override val taunting: TauntingAttributes get() = LunchboxDrinkAttributes.taunting
	
	override val swapWeapons: SwapWeaponsAttributes get() = LunchboxDrinkAttributes.swapWeapons
	
	override val whenHit: WhenHitAttributes get() = LunchboxDrinkAttributes.whenHit
	
	override val ragdolls: RagdollsAttributes get() = LunchboxDrinkAttributes.ragdolls
	
	override val disguise: DisguiseAttributes get() = LunchboxDrinkAttributes.disguise

	open class AfterburnAttributes : LunchboxAttributes.AfterburnAttributes() 
	
	open class AmmoAttributes : LunchboxAttributes.AmmoAttributes() {
		override val clipSize: ClipSizeAttributes = ClipSizeAttributes()
	
		open class ClipSizeAttributes : LunchboxAttributes.AmmoAttributes.ClipSizeAttributes() 
	}
	
	open class BuildingsAttributes : LunchboxAttributes.BuildingsAttributes() 
	
	open class CritsAttributes : LunchboxAttributes.CritsAttributes() 
	
	open class DamageAttributes : LunchboxAttributes.DamageAttributes() 
	
	open class DemoChargeAttributes : LunchboxAttributes.DemoChargeAttributes() 
	
	open class FiringAttributes : LunchboxAttributes.FiringAttributes() {
		override val fireRate: FireRateAttributes = FireRateAttributes()
	
		open class FireRateAttributes : LunchboxAttributes.FiringAttributes.FireRateAttributes() 
	}
	
	open class HealthAndHealingAttributes : LunchboxAttributes.HealthAndHealingAttributes() 
	
	open class KnockbackReceivedAttributes : LunchboxAttributes.KnockbackReceivedAttributes() {
		override val damageForceReduction: DamageForceReductionAttributes = DamageForceReductionAttributes()
	
		open class DamageForceReductionAttributes : LunchboxAttributes.KnockbackReceivedAttributes.DamageForceReductionAttributes() 
	}
	
	open class MetaAttributes : LunchboxAttributes.MetaAttributes() {
		override val killfeed: KillfeedAttributes = KillfeedAttributes()
	
		override val viewmodel: ViewmodelAttributes = ViewmodelAttributes()
	
		override val items: ItemsAttributes = ItemsAttributes()
	
		override val particles: ParticlesAttributes = ParticlesAttributes()
	
		open class KillfeedAttributes : LunchboxAttributes.MetaAttributes.KillfeedAttributes() 
	
		open class ViewmodelAttributes : LunchboxAttributes.MetaAttributes.ViewmodelAttributes() 
	
		open class ItemsAttributes : LunchboxAttributes.MetaAttributes.ItemsAttributes() 
	
		open class ParticlesAttributes : LunchboxAttributes.MetaAttributes.ParticlesAttributes() 
	}
	
	open class MeterAttributes : LunchboxAttributes.MeterAttributes() 
	
	open class MovementAttributes : LunchboxAttributes.MovementAttributes() {
		override val moveSpeed: MoveSpeedAttributes = MoveSpeedAttributes()
	
		open class MoveSpeedAttributes : LunchboxAttributes.MovementAttributes.MoveSpeedAttributes() 
	}
	
	open class HeadsAttributes : LunchboxAttributes.HeadsAttributes() 
	
	open class OnHitAttributes : LunchboxAttributes.OnHitAttributes() {
		override val healOnHitForRapidfire: HealOnHitForRapidfireAttributes = HealOnHitForRapidfireAttributes()
	
		override val generateRageOnDamage: GenerateRageOnDamageAttributes = GenerateRageOnDamageAttributes()
	
		open class HealOnHitForRapidfireAttributes : LunchboxAttributes.OnHitAttributes.HealOnHitForRapidfireAttributes() 
	
		open class GenerateRageOnDamageAttributes : LunchboxAttributes.OnHitAttributes.GenerateRageOnDamageAttributes() 
	}
	
	open class OnKillAttributes : LunchboxAttributes.OnKillAttributes() 
	
	open class ProjectilesAttributes : LunchboxAttributes.ProjectilesAttributes() {
		override val projectilePenetration: ProjectilePenetrationAttributes = ProjectilePenetrationAttributes()
	
		override val bullets: BulletsAttributes = BulletsAttributes()
	
		open class ProjectilePenetrationAttributes : LunchboxAttributes.ProjectilesAttributes.ProjectilePenetrationAttributes() 
	
		open class BulletsAttributes : LunchboxAttributes.ProjectilesAttributes.BulletsAttributes() 
	}
	
	open class ReloadingAttributes : LunchboxAttributes.ReloadingAttributes() 
	
	open class ResistanceAttributes : LunchboxAttributes.ResistanceAttributes() 
	
	open class RevengeCritsAttributes : LunchboxAttributes.RevengeCritsAttributes() 
	
	open class StatusEffectsAttributes : LunchboxAttributes.StatusEffectsAttributes() 
	
	open class TauntingAttributes : LunchboxAttributes.TauntingAttributes() 
	
	open class SwapWeaponsAttributes : LunchboxAttributes.SwapWeaponsAttributes() {
		override val deploy: DeployAttributes = DeployAttributes()
	
		open class DeployAttributes : LunchboxAttributes.SwapWeaponsAttributes.DeployAttributes() 
	}
	
	open class WhenHitAttributes : LunchboxAttributes.WhenHitAttributes() 
	
	open class RagdollsAttributes : LunchboxAttributes.RagdollsAttributes() 
	
	open class DisguiseAttributes : LunchboxAttributes.DisguiseAttributes() 
}