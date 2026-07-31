package btpos.source.vdfdsl.tf2.itemattributes

import btpos.source.vdfdsl.modeling.*
import btpos.source.vdfdsl.serialization.codecs.*
import btpos.source.vdfdsl.tf2.itemattributes.impl.*
import btpos.source.vdfdsl.tf2.tftypes.*
import java.util.*
import kotlin.time.Duration

interface ScoutPistolAttributes : PistolAttributes {
	companion object : IBlockScoped {
		/**
		 * If true, can headshot when behind an enemy.
		 */
		val backHeadshot: ItemAttributeNamed<Boolean> = ItemAttributeNamed("back headshot")
	
		val ammo: AmmoAttributes = AmmoAttributes()
	
		val damage: DamageAttributes = DamageAttributes()
	
		val firing: FiringAttributes = FiringAttributes()
	
		val projectiles: ProjectilesAttributes = ProjectilesAttributes()
	
		val afterburn: AfterburnAttributes = AfterburnAttributes()
	
		val buildings: BuildingsAttributes = BuildingsAttributes()
	
		val crits: CritsAttributes = CritsAttributes()
	
		val demoCharge: DemoChargeAttributes = DemoChargeAttributes()
	
		val healthAndHealing: HealthAndHealingAttributes = HealthAndHealingAttributes()
	
		val knockbackReceived: KnockbackReceivedAttributes = KnockbackReceivedAttributes()
	
		val meta: MetaAttributes = MetaAttributes()
	
		val meter: MeterAttributes = MeterAttributes()
	
		val movement: MovementAttributes = MovementAttributes()
	
		val heads: HeadsAttributes = HeadsAttributes()
	
		val onHit: OnHitAttributes = OnHitAttributes()
	
		val onKill: OnKillAttributes = OnKillAttributes()
	
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
	
	override val viewmodel: ViewmodelAttributes get() = ScoutPistolAttributes.viewmodel
	
	override val swapWeapons: SwapWeaponsAttributes get() = ScoutPistolAttributes.swapWeapons
	
	override val whenHit: WhenHitAttributes get() = ScoutPistolAttributes.whenHit
	
	override val ragdolls: RagdollsAttributes get() = ScoutPistolAttributes.ragdolls
	
	override val disguise: DisguiseAttributes get() = ScoutPistolAttributes.disguise

	open class AmmoAttributes : PistolAttributes.AmmoAttributes() {
		override val clipSize: ClipSizeAttributes = ClipSizeAttributes()
	
		open class ClipSizeAttributes : PistolAttributes.AmmoAttributes.ClipSizeAttributes() 
	}
	
	open class DamageAttributes : PistolAttributes.DamageAttributes() {
		override val damage: DamageAttributes = DamageAttributes()
	
		open class DamageAttributes : PistolAttributes.DamageAttributes.DamageAttributes() 
	}
	
	open class FiringAttributes : PistolAttributes.FiringAttributes() {
		override val fireRate: FireRateAttributes = FireRateAttributes()
	
		open class FireRateAttributes : PistolAttributes.FiringAttributes.FireRateAttributes() {
			override val fireRate: FireRateAttributes = FireRateAttributes()
	
			open class FireRateAttributes : PistolAttributes.FiringAttributes.FireRateAttributes.FireRateAttributes() 
		}
	}
	
	open class ProjectilesAttributes : PistolAttributes.ProjectilesAttributes() {
		override val bullets: BulletsAttributes = BulletsAttributes()
	
		override val projectilePenetration: ProjectilePenetrationAttributes = ProjectilePenetrationAttributes()
	
		open class BulletsAttributes : PistolAttributes.ProjectilesAttributes.BulletsAttributes() 
	
		open class ProjectilePenetrationAttributes : PistolAttributes.ProjectilesAttributes.ProjectilePenetrationAttributes() 
	}
	
	open class AfterburnAttributes : PistolAttributes.AfterburnAttributes() 
	
	open class BuildingsAttributes : PistolAttributes.BuildingsAttributes() 
	
	open class CritsAttributes : PistolAttributes.CritsAttributes() {
		override val critVsBurningPlayers: CritVsBurningPlayersAttributes = CritVsBurningPlayersAttributes()
	
		open class CritVsBurningPlayersAttributes : PistolAttributes.CritsAttributes.CritVsBurningPlayersAttributes() 
	}
	
	open class DemoChargeAttributes : PistolAttributes.DemoChargeAttributes() 
	
	open class HealthAndHealingAttributes : PistolAttributes.HealthAndHealingAttributes() 
	
	open class KnockbackReceivedAttributes : PistolAttributes.KnockbackReceivedAttributes() {
		override val damageForceReduction: DamageForceReductionAttributes = DamageForceReductionAttributes()
	
		open class DamageForceReductionAttributes : PistolAttributes.KnockbackReceivedAttributes.DamageForceReductionAttributes() 
	}
	
	open class MetaAttributes : PistolAttributes.MetaAttributes() {
		override val killfeed: KillfeedAttributes = KillfeedAttributes()
	
		override val items: ItemsAttributes = ItemsAttributes()
	
		override val particles: ParticlesAttributes = ParticlesAttributes()
	
		open class KillfeedAttributes : PistolAttributes.MetaAttributes.KillfeedAttributes() 
	
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
	
	open class ViewmodelAttributes : PistolAttributes.ViewmodelAttributes() 
	
	open class SwapWeaponsAttributes : PistolAttributes.SwapWeaponsAttributes() {
		override val deploy: DeployAttributes = DeployAttributes()
	
		open class DeployAttributes : PistolAttributes.SwapWeaponsAttributes.DeployAttributes() 
	}
	
	open class WhenHitAttributes : PistolAttributes.WhenHitAttributes() 
	
	open class RagdollsAttributes : PistolAttributes.RagdollsAttributes() 
	
	open class DisguiseAttributes : PistolAttributes.DisguiseAttributes() 
}