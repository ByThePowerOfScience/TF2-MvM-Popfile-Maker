package btpos.source.vdfdsl.tf2.itemattributes

import btpos.source.vdfdsl.modeling.*
import btpos.source.vdfdsl.serialization.codecs.*
import btpos.source.vdfdsl.tf2.itemattributes.impl.*
import btpos.source.vdfdsl.tf2.tftypes.*
import java.util.*
import kotlin.time.Duration

interface LunchboxDrinkAttributes : LunchboxAttributes {
	companion object : IBlockScoped {
		val afterburn: AfterburnAttributes = AfterburnAttributes()
	
		val ammo: AmmoAttributes = AmmoAttributes()
	
		val buildings: BuildingsAttributes = BuildingsAttributes()
	
		val crits: CritsAttributes = CritsAttributes()
	
		val damage: DamageAttributes = DamageAttributes()
	
		val demoCharge: DemoChargeAttributes = DemoChargeAttributes()
	
		val firing: FiringAttributes = FiringAttributes()
	
		val healthAndHealing: HealthAndHealingAttributes = HealthAndHealingAttributes()
	
		val knockbackReceived: KnockbackReceivedAttributes = KnockbackReceivedAttributes()
	
		val meta: MetaAttributes = MetaAttributes()
	
		val meter: MeterAttributes = MeterAttributes()
	
		val movement: MovementAttributes = MovementAttributes()
	
		val heads: HeadsAttributes = HeadsAttributes()
	
		val onHit: OnHitAttributes = OnHitAttributes()
	
		val onKill: OnKillAttributes = OnKillAttributes()
	
		val projectiles: ProjectilesAttributes = ProjectilesAttributes()
	
		val reloading: ReloadingAttributes = ReloadingAttributes()
	
		val resistance: ResistanceAttributes = ResistanceAttributes()
	
		val revengeCrits: RevengeCritsAttributes = RevengeCritsAttributes()
	
		val statusEffects: StatusEffectsAttributes = StatusEffectsAttributes()
	
		val taunting: TauntingAttributes = TauntingAttributes()
	
		val viewmodel: ViewmodelAttributes = ViewmodelAttributes()
	
		val swapWeapons: SwapWeaponsAttributes = SwapWeaponsAttributes()
	
		val whenHit: WhenHitAttributes = WhenHitAttributes()
	
		val ragdolls: RagdollsAttributes = RagdollsAttributes()
	
		val disguise: DisguiseAttributes = DisguiseAttributes()
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
	
	override val viewmodel: ViewmodelAttributes get() = LunchboxDrinkAttributes.viewmodel
	
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
	
	open class CritsAttributes : LunchboxAttributes.CritsAttributes() {
		override val critVsBurningPlayers: CritVsBurningPlayersAttributes = CritVsBurningPlayersAttributes()
	
		open class CritVsBurningPlayersAttributes : LunchboxAttributes.CritsAttributes.CritVsBurningPlayersAttributes() 
	}
	
	open class DamageAttributes : LunchboxAttributes.DamageAttributes() {
		override val damage: DamageAttributes = DamageAttributes()
	
		open class DamageAttributes : LunchboxAttributes.DamageAttributes.DamageAttributes() 
	}
	
	open class DemoChargeAttributes : LunchboxAttributes.DemoChargeAttributes() 
	
	open class FiringAttributes : LunchboxAttributes.FiringAttributes() {
		override val fireRate: FireRateAttributes = FireRateAttributes()
	
		open class FireRateAttributes : LunchboxAttributes.FiringAttributes.FireRateAttributes() {
			override val fireRate: FireRateAttributes = FireRateAttributes()
	
			open class FireRateAttributes : LunchboxAttributes.FiringAttributes.FireRateAttributes.FireRateAttributes() 
		}
	}
	
	open class HealthAndHealingAttributes : LunchboxAttributes.HealthAndHealingAttributes() 
	
	open class KnockbackReceivedAttributes : LunchboxAttributes.KnockbackReceivedAttributes() {
		override val damageForceReduction: DamageForceReductionAttributes = DamageForceReductionAttributes()
	
		open class DamageForceReductionAttributes : LunchboxAttributes.KnockbackReceivedAttributes.DamageForceReductionAttributes() 
	}
	
	open class MetaAttributes : LunchboxAttributes.MetaAttributes() {
		override val killfeed: KillfeedAttributes = KillfeedAttributes()
	
		override val items: ItemsAttributes = ItemsAttributes()
	
		override val particles: ParticlesAttributes = ParticlesAttributes()
	
		open class KillfeedAttributes : LunchboxAttributes.MetaAttributes.KillfeedAttributes() 
	
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
	
	open class ViewmodelAttributes : LunchboxAttributes.ViewmodelAttributes() 
	
	open class SwapWeaponsAttributes : LunchboxAttributes.SwapWeaponsAttributes() {
		override val deploy: DeployAttributes = DeployAttributes()
	
		open class DeployAttributes : LunchboxAttributes.SwapWeaponsAttributes.DeployAttributes() 
	}
	
	open class WhenHitAttributes : LunchboxAttributes.WhenHitAttributes() 
	
	open class RagdollsAttributes : LunchboxAttributes.RagdollsAttributes() 
	
	open class DisguiseAttributes : LunchboxAttributes.DisguiseAttributes() 
}