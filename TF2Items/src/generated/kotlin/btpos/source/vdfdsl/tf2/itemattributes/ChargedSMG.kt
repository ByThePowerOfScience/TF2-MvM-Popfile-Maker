package btpos.source.vdfdsl.tf2.itemattributes

import btpos.source.vdfdsl.modeling.*
import btpos.source.vdfdsl.serialization.codecs.*
import btpos.source.vdfdsl.tf2.itemattributes.impl.*
import btpos.source.vdfdsl.tf2.tftypes.*
import java.util.*
import kotlin.time.Duration

interface ChargedSMGAttributes : SMGAttributes {
	companion object : IBlockScoped {
		/**
		 * In-Game: "Secondary fire when charged grants mini-crits for N seconds."
		 * 
		 * Minicrit buff duration.
		 */
		val minicritBoostWhenCharged: ItemAttributeNamed<Number> = ItemAttributeNamed("minicrit_boost_when_charged")
	
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
	 * In-Game: "Secondary fire when charged grants mini-crits for N seconds."
	 * 
	 * Minicrit buff duration.
	 */
	val minicritBoostWhenCharged: ItemAttributeNamed<Number> get() = ChargedSMGAttributes.minicritBoostWhenCharged
	
	override val ammo: AmmoAttributes get() = ChargedSMGAttributes.ammo
	
	override val damage: DamageAttributes get() = ChargedSMGAttributes.damage
	
	override val firing: FiringAttributes get() = ChargedSMGAttributes.firing
	
	override val projectiles: ProjectilesAttributes get() = ChargedSMGAttributes.projectiles
	
	override val afterburn: AfterburnAttributes get() = ChargedSMGAttributes.afterburn
	
	override val buildings: BuildingsAttributes get() = ChargedSMGAttributes.buildings
	
	override val crits: CritsAttributes get() = ChargedSMGAttributes.crits
	
	override val demoCharge: DemoChargeAttributes get() = ChargedSMGAttributes.demoCharge
	
	override val healthAndHealing: HealthAndHealingAttributes get() = ChargedSMGAttributes.healthAndHealing
	
	override val knockbackReceived: KnockbackReceivedAttributes get() = ChargedSMGAttributes.knockbackReceived
	
	override val meta: MetaAttributes get() = ChargedSMGAttributes.meta
	
	override val meter: MeterAttributes get() = ChargedSMGAttributes.meter
	
	override val movement: MovementAttributes get() = ChargedSMGAttributes.movement
	
	override val heads: HeadsAttributes get() = ChargedSMGAttributes.heads
	
	override val onHit: OnHitAttributes get() = ChargedSMGAttributes.onHit
	
	override val onKill: OnKillAttributes get() = ChargedSMGAttributes.onKill
	
	override val reloading: ReloadingAttributes get() = ChargedSMGAttributes.reloading
	
	override val resistance: ResistanceAttributes get() = ChargedSMGAttributes.resistance
	
	override val revengeCrits: RevengeCritsAttributes get() = ChargedSMGAttributes.revengeCrits
	
	override val statusEffects: StatusEffectsAttributes get() = ChargedSMGAttributes.statusEffects
	
	override val taunting: TauntingAttributes get() = ChargedSMGAttributes.taunting
	
	override val viewmodel: ViewmodelAttributes get() = ChargedSMGAttributes.viewmodel
	
	override val swapWeapons: SwapWeaponsAttributes get() = ChargedSMGAttributes.swapWeapons
	
	override val whenHit: WhenHitAttributes get() = ChargedSMGAttributes.whenHit
	
	override val ragdolls: RagdollsAttributes get() = ChargedSMGAttributes.ragdolls
	
	override val disguise: DisguiseAttributes get() = ChargedSMGAttributes.disguise

	open class AmmoAttributes : SMGAttributes.AmmoAttributes() {
		override val clipSize: ClipSizeAttributes = ClipSizeAttributes()
	
		open class ClipSizeAttributes : SMGAttributes.AmmoAttributes.ClipSizeAttributes() 
	}
	
	open class DamageAttributes : SMGAttributes.DamageAttributes() {
		override val damage: DamageAttributes = DamageAttributes()
	
		open class DamageAttributes : SMGAttributes.DamageAttributes.DamageAttributes() 
	}
	
	open class FiringAttributes : SMGAttributes.FiringAttributes() {
		override val fireRate: FireRateAttributes = FireRateAttributes()
	
		open class FireRateAttributes : SMGAttributes.FiringAttributes.FireRateAttributes() {
			override val fireRate: FireRateAttributes = FireRateAttributes()
	
			open class FireRateAttributes : SMGAttributes.FiringAttributes.FireRateAttributes.FireRateAttributes() 
		}
	}
	
	open class ProjectilesAttributes : SMGAttributes.ProjectilesAttributes() {
		override val bullets: BulletsAttributes = BulletsAttributes()
	
		override val projectilePenetration: ProjectilePenetrationAttributes = ProjectilePenetrationAttributes()
	
		open class BulletsAttributes : SMGAttributes.ProjectilesAttributes.BulletsAttributes() 
	
		open class ProjectilePenetrationAttributes : SMGAttributes.ProjectilesAttributes.ProjectilePenetrationAttributes() 
	}
	
	open class AfterburnAttributes : SMGAttributes.AfterburnAttributes() 
	
	open class BuildingsAttributes : SMGAttributes.BuildingsAttributes() 
	
	open class CritsAttributes : SMGAttributes.CritsAttributes() {
		override val critVsBurningPlayers: CritVsBurningPlayersAttributes = CritVsBurningPlayersAttributes()
	
		open class CritVsBurningPlayersAttributes : SMGAttributes.CritsAttributes.CritVsBurningPlayersAttributes() 
	}
	
	open class DemoChargeAttributes : SMGAttributes.DemoChargeAttributes() 
	
	open class HealthAndHealingAttributes : SMGAttributes.HealthAndHealingAttributes() 
	
	open class KnockbackReceivedAttributes : SMGAttributes.KnockbackReceivedAttributes() {
		override val damageForceReduction: DamageForceReductionAttributes = DamageForceReductionAttributes()
	
		open class DamageForceReductionAttributes : SMGAttributes.KnockbackReceivedAttributes.DamageForceReductionAttributes() 
	}
	
	open class MetaAttributes : SMGAttributes.MetaAttributes() {
		override val killfeed: KillfeedAttributes = KillfeedAttributes()
	
		override val items: ItemsAttributes = ItemsAttributes()
	
		override val particles: ParticlesAttributes = ParticlesAttributes()
	
		open class KillfeedAttributes : SMGAttributes.MetaAttributes.KillfeedAttributes() 
	
		open class ItemsAttributes : SMGAttributes.MetaAttributes.ItemsAttributes() 
	
		open class ParticlesAttributes : SMGAttributes.MetaAttributes.ParticlesAttributes() 
	}
	
	open class MeterAttributes : SMGAttributes.MeterAttributes() 
	
	open class MovementAttributes : SMGAttributes.MovementAttributes() {
		override val moveSpeed: MoveSpeedAttributes = MoveSpeedAttributes()
	
		open class MoveSpeedAttributes : SMGAttributes.MovementAttributes.MoveSpeedAttributes() 
	}
	
	open class HeadsAttributes : SMGAttributes.HeadsAttributes() 
	
	open class OnHitAttributes : SMGAttributes.OnHitAttributes() {
		override val healOnHitForRapidfire: HealOnHitForRapidfireAttributes = HealOnHitForRapidfireAttributes()
	
		override val generateRageOnDamage: GenerateRageOnDamageAttributes = GenerateRageOnDamageAttributes()
	
		open class HealOnHitForRapidfireAttributes : SMGAttributes.OnHitAttributes.HealOnHitForRapidfireAttributes() 
	
		open class GenerateRageOnDamageAttributes : SMGAttributes.OnHitAttributes.GenerateRageOnDamageAttributes() 
	}
	
	open class OnKillAttributes : SMGAttributes.OnKillAttributes() 
	
	open class ReloadingAttributes : SMGAttributes.ReloadingAttributes() 
	
	open class ResistanceAttributes : SMGAttributes.ResistanceAttributes() 
	
	open class RevengeCritsAttributes : SMGAttributes.RevengeCritsAttributes() 
	
	open class StatusEffectsAttributes : SMGAttributes.StatusEffectsAttributes() 
	
	open class TauntingAttributes : SMGAttributes.TauntingAttributes() 
	
	open class ViewmodelAttributes : SMGAttributes.ViewmodelAttributes() 
	
	open class SwapWeaponsAttributes : SMGAttributes.SwapWeaponsAttributes() {
		override val deploy: DeployAttributes = DeployAttributes()
	
		open class DeployAttributes : SMGAttributes.SwapWeaponsAttributes.DeployAttributes() 
	}
	
	open class WhenHitAttributes : SMGAttributes.WhenHitAttributes() 
	
	open class RagdollsAttributes : SMGAttributes.RagdollsAttributes() 
	
	open class DisguiseAttributes : SMGAttributes.DisguiseAttributes() 
}