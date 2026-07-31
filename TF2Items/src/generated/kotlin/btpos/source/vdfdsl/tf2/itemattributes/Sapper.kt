package btpos.source.vdfdsl.tf2.itemattributes

import btpos.source.vdfdsl.modeling.*
import btpos.source.vdfdsl.serialization.codecs.*
import btpos.source.vdfdsl.tf2.itemattributes.impl.*
import btpos.source.vdfdsl.tf2.tftypes.*
import java.util.*
import kotlin.time.Duration

interface SapperAttributes : BuilderAttributes {
	companion object : IBlockScoped {
		/**
		 * In-Game: "Reverses enemy building construction"
		 * 
		 * How fast the building should reverse construction.
		 * 
		 * Checked on player.
		 */
		val sapperDegeneratesBuildings: ItemAttributeNamed<Number> = ItemAttributeNamed("sapper degenerates buildings")
	
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

	/**
	 * In-Game: "Reverses enemy building construction"
	 * 
	 * How fast the building should reverse construction.
	 * 
	 * Checked on player.
	 */
	val sapperDegeneratesBuildings: ItemAttributeNamed<Number> get() = SapperAttributes.sapperDegeneratesBuildings
	
	/**
	 * In-Game: "Increased robot Sapper radius and duration"
	 * 
	 * When the sapper is applied to a player (including MvM bots):.
	 * 
	 * 2 - stun time is 5.5 seconds, radius is 225 hammer units.
	 * 
	 * 3 - stuns for 7 seconds, radius is 250 hammer units.
	 * 
	 * else stuns for 4 seconds and radius is 200 HU.
	 */
	override val roboSapper: ItemAttributeNamed<Int> get() = super.roboSapper
	
	override val afterburn: AfterburnAttributes get() = SapperAttributes.afterburn
	
	override val ammo: AmmoAttributes get() = SapperAttributes.ammo
	
	override val buildings: BuildingsAttributes get() = SapperAttributes.buildings
	
	override val crits: CritsAttributes get() = SapperAttributes.crits
	
	override val damage: DamageAttributes get() = SapperAttributes.damage
	
	override val demoCharge: DemoChargeAttributes get() = SapperAttributes.demoCharge
	
	override val firing: FiringAttributes get() = SapperAttributes.firing
	
	override val healthAndHealing: HealthAndHealingAttributes get() = SapperAttributes.healthAndHealing
	
	override val knockbackReceived: KnockbackReceivedAttributes get() = SapperAttributes.knockbackReceived
	
	override val meta: MetaAttributes get() = SapperAttributes.meta
	
	override val meter: MeterAttributes get() = SapperAttributes.meter
	
	override val movement: MovementAttributes get() = SapperAttributes.movement
	
	override val heads: HeadsAttributes get() = SapperAttributes.heads
	
	override val onHit: OnHitAttributes get() = SapperAttributes.onHit
	
	override val onKill: OnKillAttributes get() = SapperAttributes.onKill
	
	override val projectiles: ProjectilesAttributes get() = SapperAttributes.projectiles
	
	override val reloading: ReloadingAttributes get() = SapperAttributes.reloading
	
	override val resistance: ResistanceAttributes get() = SapperAttributes.resistance
	
	override val revengeCrits: RevengeCritsAttributes get() = SapperAttributes.revengeCrits
	
	override val statusEffects: StatusEffectsAttributes get() = SapperAttributes.statusEffects
	
	override val taunting: TauntingAttributes get() = SapperAttributes.taunting
	
	override val viewmodel: ViewmodelAttributes get() = SapperAttributes.viewmodel
	
	override val swapWeapons: SwapWeaponsAttributes get() = SapperAttributes.swapWeapons
	
	override val whenHit: WhenHitAttributes get() = SapperAttributes.whenHit
	
	override val ragdolls: RagdollsAttributes get() = SapperAttributes.ragdolls
	
	override val disguise: DisguiseAttributes get() = SapperAttributes.disguise

	open class AfterburnAttributes : BuilderAttributes.AfterburnAttributes() 
	
	open class AmmoAttributes : BuilderAttributes.AmmoAttributes() {
		override val clipSize: ClipSizeAttributes = ClipSizeAttributes()
	
		open class ClipSizeAttributes : BuilderAttributes.AmmoAttributes.ClipSizeAttributes() 
	}
	
	open class BuildingsAttributes : BuilderAttributes.BuildingsAttributes() 
	
	open class CritsAttributes : BuilderAttributes.CritsAttributes() {
		override val critVsBurningPlayers: CritVsBurningPlayersAttributes = CritVsBurningPlayersAttributes()
	
		open class CritVsBurningPlayersAttributes : BuilderAttributes.CritsAttributes.CritVsBurningPlayersAttributes() 
	}
	
	open class DamageAttributes : BuilderAttributes.DamageAttributes() {
		override val damage: DamageAttributes = DamageAttributes()
	
		open class DamageAttributes : BuilderAttributes.DamageAttributes.DamageAttributes() 
	}
	
	open class DemoChargeAttributes : BuilderAttributes.DemoChargeAttributes() 
	
	open class FiringAttributes : BuilderAttributes.FiringAttributes() {
		override val fireRate: FireRateAttributes = FireRateAttributes()
	
		open class FireRateAttributes : BuilderAttributes.FiringAttributes.FireRateAttributes() {
			override val fireRate: FireRateAttributes = FireRateAttributes()
	
			open class FireRateAttributes : BuilderAttributes.FiringAttributes.FireRateAttributes.FireRateAttributes() 
		}
	}
	
	open class HealthAndHealingAttributes : BuilderAttributes.HealthAndHealingAttributes() 
	
	open class KnockbackReceivedAttributes : BuilderAttributes.KnockbackReceivedAttributes() {
		override val damageForceReduction: DamageForceReductionAttributes = DamageForceReductionAttributes()
	
		open class DamageForceReductionAttributes : BuilderAttributes.KnockbackReceivedAttributes.DamageForceReductionAttributes() 
	}
	
	open class MetaAttributes : BuilderAttributes.MetaAttributes() {
		override val killfeed: KillfeedAttributes = KillfeedAttributes()
	
		override val items: ItemsAttributes = ItemsAttributes()
	
		override val particles: ParticlesAttributes = ParticlesAttributes()
	
		open class KillfeedAttributes : BuilderAttributes.MetaAttributes.KillfeedAttributes() 
	
		open class ItemsAttributes : BuilderAttributes.MetaAttributes.ItemsAttributes() 
	
		open class ParticlesAttributes : BuilderAttributes.MetaAttributes.ParticlesAttributes() 
	}
	
	open class MeterAttributes : BuilderAttributes.MeterAttributes() 
	
	open class MovementAttributes : BuilderAttributes.MovementAttributes() {
		override val moveSpeed: MoveSpeedAttributes = MoveSpeedAttributes()
	
		open class MoveSpeedAttributes : BuilderAttributes.MovementAttributes.MoveSpeedAttributes() 
	}
	
	open class HeadsAttributes : BuilderAttributes.HeadsAttributes() 
	
	open class OnHitAttributes : BuilderAttributes.OnHitAttributes() {
		override val healOnHitForRapidfire: HealOnHitForRapidfireAttributes = HealOnHitForRapidfireAttributes()
	
		override val generateRageOnDamage: GenerateRageOnDamageAttributes = GenerateRageOnDamageAttributes()
	
		open class HealOnHitForRapidfireAttributes : BuilderAttributes.OnHitAttributes.HealOnHitForRapidfireAttributes() 
	
		open class GenerateRageOnDamageAttributes : BuilderAttributes.OnHitAttributes.GenerateRageOnDamageAttributes() 
	}
	
	open class OnKillAttributes : BuilderAttributes.OnKillAttributes() 
	
	open class ProjectilesAttributes : BuilderAttributes.ProjectilesAttributes() {
		override val projectilePenetration: ProjectilePenetrationAttributes = ProjectilePenetrationAttributes()
	
		override val bullets: BulletsAttributes = BulletsAttributes()
	
		open class ProjectilePenetrationAttributes : BuilderAttributes.ProjectilesAttributes.ProjectilePenetrationAttributes() 
	
		open class BulletsAttributes : BuilderAttributes.ProjectilesAttributes.BulletsAttributes() 
	}
	
	open class ReloadingAttributes : BuilderAttributes.ReloadingAttributes() 
	
	open class ResistanceAttributes : BuilderAttributes.ResistanceAttributes() 
	
	open class RevengeCritsAttributes : BuilderAttributes.RevengeCritsAttributes() 
	
	open class StatusEffectsAttributes : BuilderAttributes.StatusEffectsAttributes() 
	
	open class TauntingAttributes : BuilderAttributes.TauntingAttributes() 
	
	open class ViewmodelAttributes : BuilderAttributes.ViewmodelAttributes() 
	
	open class SwapWeaponsAttributes : BuilderAttributes.SwapWeaponsAttributes() {
		override val deploy: DeployAttributes = DeployAttributes()
	
		open class DeployAttributes : BuilderAttributes.SwapWeaponsAttributes.DeployAttributes() 
	}
	
	open class WhenHitAttributes : BuilderAttributes.WhenHitAttributes() 
	
	open class RagdollsAttributes : BuilderAttributes.RagdollsAttributes() 
	
	open class DisguiseAttributes : BuilderAttributes.DisguiseAttributes() 
}