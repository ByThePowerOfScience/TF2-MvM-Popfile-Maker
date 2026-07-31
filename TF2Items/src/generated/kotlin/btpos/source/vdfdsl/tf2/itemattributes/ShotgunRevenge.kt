package btpos.source.vdfdsl.tf2.itemattributes

import btpos.source.vdfdsl.modeling.*
import btpos.source.vdfdsl.serialization.codecs.*
import btpos.source.vdfdsl.tf2.itemattributes.impl.*
import btpos.source.vdfdsl.tf2.tftypes.*
import java.util.*
import kotlin.time.Duration

interface ShotgunRevengeAttributes : ShotgunAttributes {
	companion object : IBlockScoped {
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

	override val revengeCrits: RevengeCritsAttributes get() = ShotgunRevengeAttributes.revengeCrits
	
	override val ammo: AmmoAttributes get() = ShotgunRevengeAttributes.ammo
	
	override val damage: DamageAttributes get() = ShotgunRevengeAttributes.damage
	
	override val firing: FiringAttributes get() = ShotgunRevengeAttributes.firing
	
	override val projectiles: ProjectilesAttributes get() = ShotgunRevengeAttributes.projectiles
	
	override val afterburn: AfterburnAttributes get() = ShotgunRevengeAttributes.afterburn
	
	override val buildings: BuildingsAttributes get() = ShotgunRevengeAttributes.buildings
	
	override val crits: CritsAttributes get() = ShotgunRevengeAttributes.crits
	
	override val demoCharge: DemoChargeAttributes get() = ShotgunRevengeAttributes.demoCharge
	
	override val healthAndHealing: HealthAndHealingAttributes get() = ShotgunRevengeAttributes.healthAndHealing
	
	override val knockbackReceived: KnockbackReceivedAttributes get() = ShotgunRevengeAttributes.knockbackReceived
	
	override val meta: MetaAttributes get() = ShotgunRevengeAttributes.meta
	
	override val meter: MeterAttributes get() = ShotgunRevengeAttributes.meter
	
	override val movement: MovementAttributes get() = ShotgunRevengeAttributes.movement
	
	override val heads: HeadsAttributes get() = ShotgunRevengeAttributes.heads
	
	override val onHit: OnHitAttributes get() = ShotgunRevengeAttributes.onHit
	
	override val onKill: OnKillAttributes get() = ShotgunRevengeAttributes.onKill
	
	override val reloading: ReloadingAttributes get() = ShotgunRevengeAttributes.reloading
	
	override val resistance: ResistanceAttributes get() = ShotgunRevengeAttributes.resistance
	
	override val statusEffects: StatusEffectsAttributes get() = ShotgunRevengeAttributes.statusEffects
	
	override val taunting: TauntingAttributes get() = ShotgunRevengeAttributes.taunting
	
	override val viewmodel: ViewmodelAttributes get() = ShotgunRevengeAttributes.viewmodel
	
	override val swapWeapons: SwapWeaponsAttributes get() = ShotgunRevengeAttributes.swapWeapons
	
	override val whenHit: WhenHitAttributes get() = ShotgunRevengeAttributes.whenHit
	
	override val ragdolls: RagdollsAttributes get() = ShotgunRevengeAttributes.ragdolls
	
	override val disguise: DisguiseAttributes get() = ShotgunRevengeAttributes.disguise

	open class RevengeCritsAttributes : ShotgunAttributes.RevengeCritsAttributes() {
		companion object : IBlockScoped 
	
		/**
		 * In-Game: "Gain 2 revenge crits for each sentry kill and 1 for each sentry assist when your sentry is destroyed."
		 * 
		 * Specifically checked here when it tries to gain revenge crits, which means removing this attribute from the Frontier Justice will remove its ability to gain revenge crits.
		 */
		context(attrs: IAttributeContainer)
		override var canGainRevengeCrits: Boolean? 
			get() = super.canGainRevengeCrits
			set(value) { super.canGainRevengeCrits = value }
	}
	
	open class AmmoAttributes : ShotgunAttributes.AmmoAttributes() {
		override val clipSize: ClipSizeAttributes = ClipSizeAttributes()
	
		open class ClipSizeAttributes : ShotgunAttributes.AmmoAttributes.ClipSizeAttributes() 
	}
	
	open class DamageAttributes : ShotgunAttributes.DamageAttributes() {
		override val damage: DamageAttributes = DamageAttributes()
	
		open class DamageAttributes : ShotgunAttributes.DamageAttributes.DamageAttributes() 
	}
	
	open class FiringAttributes : ShotgunAttributes.FiringAttributes() {
		override val fireRate: FireRateAttributes = FireRateAttributes()
	
		open class FireRateAttributes : ShotgunAttributes.FiringAttributes.FireRateAttributes() {
			override val fireRate: FireRateAttributes = FireRateAttributes()
	
			open class FireRateAttributes : ShotgunAttributes.FiringAttributes.FireRateAttributes.FireRateAttributes() 
		}
	}
	
	open class ProjectilesAttributes : ShotgunAttributes.ProjectilesAttributes() {
		override val bullets: BulletsAttributes = BulletsAttributes()
	
		override val projectilePenetration: ProjectilePenetrationAttributes = ProjectilePenetrationAttributes()
	
		open class BulletsAttributes : ShotgunAttributes.ProjectilesAttributes.BulletsAttributes() 
	
		open class ProjectilePenetrationAttributes : ShotgunAttributes.ProjectilesAttributes.ProjectilePenetrationAttributes() 
	}
	
	open class AfterburnAttributes : ShotgunAttributes.AfterburnAttributes() 
	
	open class BuildingsAttributes : ShotgunAttributes.BuildingsAttributes() 
	
	open class CritsAttributes : ShotgunAttributes.CritsAttributes() {
		override val critVsBurningPlayers: CritVsBurningPlayersAttributes = CritVsBurningPlayersAttributes()
	
		open class CritVsBurningPlayersAttributes : ShotgunAttributes.CritsAttributes.CritVsBurningPlayersAttributes() 
	}
	
	open class DemoChargeAttributes : ShotgunAttributes.DemoChargeAttributes() 
	
	open class HealthAndHealingAttributes : ShotgunAttributes.HealthAndHealingAttributes() 
	
	open class KnockbackReceivedAttributes : ShotgunAttributes.KnockbackReceivedAttributes() {
		override val damageForceReduction: DamageForceReductionAttributes = DamageForceReductionAttributes()
	
		open class DamageForceReductionAttributes : ShotgunAttributes.KnockbackReceivedAttributes.DamageForceReductionAttributes() 
	}
	
	open class MetaAttributes : ShotgunAttributes.MetaAttributes() {
		override val killfeed: KillfeedAttributes = KillfeedAttributes()
	
		override val items: ItemsAttributes = ItemsAttributes()
	
		override val particles: ParticlesAttributes = ParticlesAttributes()
	
		open class KillfeedAttributes : ShotgunAttributes.MetaAttributes.KillfeedAttributes() 
	
		open class ItemsAttributes : ShotgunAttributes.MetaAttributes.ItemsAttributes() 
	
		open class ParticlesAttributes : ShotgunAttributes.MetaAttributes.ParticlesAttributes() 
	}
	
	open class MeterAttributes : ShotgunAttributes.MeterAttributes() 
	
	open class MovementAttributes : ShotgunAttributes.MovementAttributes() {
		override val moveSpeed: MoveSpeedAttributes = MoveSpeedAttributes()
	
		open class MoveSpeedAttributes : ShotgunAttributes.MovementAttributes.MoveSpeedAttributes() 
	}
	
	open class HeadsAttributes : ShotgunAttributes.HeadsAttributes() 
	
	open class OnHitAttributes : ShotgunAttributes.OnHitAttributes() {
		override val healOnHitForRapidfire: HealOnHitForRapidfireAttributes = HealOnHitForRapidfireAttributes()
	
		override val generateRageOnDamage: GenerateRageOnDamageAttributes = GenerateRageOnDamageAttributes()
	
		open class HealOnHitForRapidfireAttributes : ShotgunAttributes.OnHitAttributes.HealOnHitForRapidfireAttributes() 
	
		open class GenerateRageOnDamageAttributes : ShotgunAttributes.OnHitAttributes.GenerateRageOnDamageAttributes() 
	}
	
	open class OnKillAttributes : ShotgunAttributes.OnKillAttributes() 
	
	open class ReloadingAttributes : ShotgunAttributes.ReloadingAttributes() 
	
	open class ResistanceAttributes : ShotgunAttributes.ResistanceAttributes() 
	
	open class StatusEffectsAttributes : ShotgunAttributes.StatusEffectsAttributes() 
	
	open class TauntingAttributes : ShotgunAttributes.TauntingAttributes() 
	
	open class ViewmodelAttributes : ShotgunAttributes.ViewmodelAttributes() 
	
	open class SwapWeaponsAttributes : ShotgunAttributes.SwapWeaponsAttributes() {
		override val deploy: DeployAttributes = DeployAttributes()
	
		open class DeployAttributes : ShotgunAttributes.SwapWeaponsAttributes.DeployAttributes() 
	}
	
	open class WhenHitAttributes : ShotgunAttributes.WhenHitAttributes() 
	
	open class RagdollsAttributes : ShotgunAttributes.RagdollsAttributes() 
	
	open class DisguiseAttributes : ShotgunAttributes.DisguiseAttributes() 
}