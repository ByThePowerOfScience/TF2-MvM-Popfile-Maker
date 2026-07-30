package btpos.source.vdfdsl.tf2.itemattributes

import btpos.source.vdfdsl.modeling.*
import btpos.source.vdfdsl.serialization.codecs.*
import btpos.source.vdfdsl.tf2.itemattributes.impl.*
import btpos.source.vdfdsl.tf2.tftypes.*
import java.util.*



interface StickybombLauncherAttributes : BaseGunAttributes {
	companion object {
		/**
		 * In-Game: "Max charge time decreased by N%"
		 * 
		 * Not actually the "rate", rather the time it takes to fully charge a stickybomb launch when holding MOUSE1.
		 */
		val stickybombChargeRate: ItemAttributeNamed<Float> = ItemAttributeNamed("stickybomb charge rate")
	
		/**
		 * In-Game: "Able to destroy enemy stickybomb"
		 * 
		 * If 1, stickies destroy other stickies.
		 */
		val stickiesDetonateStickies: ItemAttributeNamed<Boolean> = ItemAttributeNamed("stickies detonate stickies")
	
		/**
		 * In-Game: "Up to +N% damage based on charge"
		 * 
		 * damage = `2*basedamage * (this - 1.0) * currentChargeProportion`.
		 */
		val stickybombChargeDamageIncrease: ItemAttributeNamed<Float> = ItemAttributeNamed("stickybomb_charge_damage_increase")
	
		val maxStickies: BonusPenalty<Int> = BonusPenalty(
			ItemAttributeNamed("max pipebombs increased"),
			ItemAttributeNamed("max pipebombs decreased"),
		)
	
		private val ammo: AmmoAttributes = AmmoAttributes()
	
		private val damage: DamageAttributes = DamageAttributes()
	
		val firing: FiringAttributes = FiringAttributes()
	
		val projectiles: ProjectilesAttributes = ProjectilesAttributes()
	
		val afterburn: AfterburnAttributes = AfterburnAttributes()
	
		val buildings: BuildingsAttributes = BuildingsAttributes()
	
		private val crits: CritsAttributes = CritsAttributes()
	
		val demoCharge: DemoChargeAttributes = DemoChargeAttributes()
	
		val healthAndHealing: HealthAndHealingAttributes = HealthAndHealingAttributes()
	
		private val knockbackReceived: KnockbackReceivedAttributes = KnockbackReceivedAttributes()
	
		private val meta: MetaAttributes = MetaAttributes()
	
		private val meter: MeterAttributes = MeterAttributes()
	
		val movement: MovementAttributes = MovementAttributes()
	
		val heads: HeadsAttributes = HeadsAttributes()
	
		val onHit: OnHitAttributes = OnHitAttributes()
	
		val onKill: OnKillAttributes = OnKillAttributes()
	
		val reloading: ReloadingAttributes = ReloadingAttributes()
	
		private val resistance: ResistanceAttributes = ResistanceAttributes()
	
		val revengeCrits: RevengeCritsAttributes = RevengeCritsAttributes()
	
		val statusEffects: StatusEffectsAttributes = StatusEffectsAttributes()
	
		val taunting: TauntingAttributes = TauntingAttributes()
	
		val viewmodel: ViewmodelAttributes = ViewmodelAttributes()
	
		val swapWeapons: SwapWeaponsAttributes = SwapWeaponsAttributes()
	
		val whenHit: WhenHitAttributes = WhenHitAttributes()
	
		val ragdolls: RagdollsAttributes = RagdollsAttributes()
	}

	/**
	 * In-Game: "Max charge time decreased by N%"
	 * 
	 * Not actually the "rate", rather the time it takes to fully charge a stickybomb launch when holding MOUSE1.
	 */
	val stickybombChargeRate: ItemAttributeNamed<Float> get() = StickybombLauncherAttributes.stickybombChargeRate
	
	/**
	 * In-Game: "Able to destroy enemy stickybomb"
	 * 
	 * If 1, stickies destroy other stickies.
	 */
	val stickiesDetonateStickies: ItemAttributeNamed<Boolean> get() = StickybombLauncherAttributes.stickiesDetonateStickies
	
	/**
	 * In-Game: "Up to +N% damage based on charge"
	 * 
	 * damage = `2*basedamage * (this - 1.0) * currentChargeProportion`.
	 */
	val stickybombChargeDamageIncrease: ItemAttributeNamed<Float> get() = StickybombLauncherAttributes.stickybombChargeDamageIncrease
	
	val maxStickies: BonusPenalty<Int> get() = StickybombLauncherAttributes.maxStickies
	
	override val ammo: AmmoAttributes get() = StickybombLauncherAttributes.ammo
	
	override val damage: DamageAttributes get() = StickybombLauncherAttributes.damage
	
	override val firing: FiringAttributes get() = StickybombLauncherAttributes.firing
	
	override val projectiles: ProjectilesAttributes get() = StickybombLauncherAttributes.projectiles
	
	override val afterburn: AfterburnAttributes get() = StickybombLauncherAttributes.afterburn
	
	override val buildings: BuildingsAttributes get() = StickybombLauncherAttributes.buildings
	
	override val crits: CritsAttributes get() = StickybombLauncherAttributes.crits
	
	override val demoCharge: DemoChargeAttributes get() = StickybombLauncherAttributes.demoCharge
	
	override val healthAndHealing: HealthAndHealingAttributes get() = StickybombLauncherAttributes.healthAndHealing
	
	override val knockbackReceived: KnockbackReceivedAttributes get() = StickybombLauncherAttributes.knockbackReceived
	
	override val meta: MetaAttributes get() = StickybombLauncherAttributes.meta
	
	override val meter: MeterAttributes get() = StickybombLauncherAttributes.meter
	
	override val movement: MovementAttributes get() = StickybombLauncherAttributes.movement
	
	override val heads: HeadsAttributes get() = StickybombLauncherAttributes.heads
	
	override val onHit: OnHitAttributes get() = StickybombLauncherAttributes.onHit
	
	override val onKill: OnKillAttributes get() = StickybombLauncherAttributes.onKill
	
	override val reloading: ReloadingAttributes get() = StickybombLauncherAttributes.reloading
	
	override val resistance: ResistanceAttributes get() = StickybombLauncherAttributes.resistance
	
	override val revengeCrits: RevengeCritsAttributes get() = StickybombLauncherAttributes.revengeCrits
	
	override val statusEffects: StatusEffectsAttributes get() = StickybombLauncherAttributes.statusEffects
	
	override val taunting: TauntingAttributes get() = StickybombLauncherAttributes.taunting
	
	override val viewmodel: ViewmodelAttributes get() = StickybombLauncherAttributes.viewmodel
	
	override val swapWeapons: SwapWeaponsAttributes get() = StickybombLauncherAttributes.swapWeapons
	
	override val whenHit: WhenHitAttributes get() = StickybombLauncherAttributes.whenHit
	
	override val ragdolls: RagdollsAttributes get() = StickybombLauncherAttributes.ragdolls

	open class AmmoAttributes : BaseGunAttributes.AmmoAttributes() {
		override val clipSize: ClipSizeAttributes = ClipSizeAttributes()
	
		open class ClipSizeAttributes : BaseGunAttributes.AmmoAttributes.ClipSizeAttributes() 
	}
	
	open class DamageAttributes : BaseGunAttributes.DamageAttributes() {
		override val damage: DamageAttributes = DamageAttributes()
	
		open class DamageAttributes : BaseGunAttributes.DamageAttributes.DamageAttributes() 
	}
	
	open class FiringAttributes : BaseGunAttributes.FiringAttributes() {
		override val fireRate: FireRateAttributes = FireRateAttributes()
	
		open class FireRateAttributes : BaseGunAttributes.FiringAttributes.FireRateAttributes() {
			override val fireRate: FireRateAttributes = FireRateAttributes()
	
			open class FireRateAttributes : BaseGunAttributes.FiringAttributes.FireRateAttributes.FireRateAttributes() 
		}
	}
	
	open class ProjectilesAttributes : BaseGunAttributes.ProjectilesAttributes() {
		override val bullets: BulletsAttributes = BulletsAttributes()
	
		override val projectilePenetration: ProjectilePenetrationAttributes = ProjectilePenetrationAttributes()
	
		open class BulletsAttributes : BaseGunAttributes.ProjectilesAttributes.BulletsAttributes() 
	
		open class ProjectilePenetrationAttributes : BaseGunAttributes.ProjectilesAttributes.ProjectilePenetrationAttributes() 
	}
	
	open class AfterburnAttributes : BaseGunAttributes.AfterburnAttributes() 
	
	open class BuildingsAttributes : BaseGunAttributes.BuildingsAttributes() 
	
	open class CritsAttributes : BaseGunAttributes.CritsAttributes() {
		override val critVsBurningPlayers: CritVsBurningPlayersAttributes = CritVsBurningPlayersAttributes()
	
		open class CritVsBurningPlayersAttributes : BaseGunAttributes.CritsAttributes.CritVsBurningPlayersAttributes() 
	}
	
	open class DemoChargeAttributes : BaseGunAttributes.DemoChargeAttributes() 
	
	open class HealthAndHealingAttributes : BaseGunAttributes.HealthAndHealingAttributes() 
	
	open class KnockbackReceivedAttributes : BaseGunAttributes.KnockbackReceivedAttributes() {
		override val damageForceReduction: DamageForceReductionAttributes = DamageForceReductionAttributes()
	
		open class DamageForceReductionAttributes : BaseGunAttributes.KnockbackReceivedAttributes.DamageForceReductionAttributes() 
	}
	
	open class MetaAttributes : BaseGunAttributes.MetaAttributes() {
		override val killfeed: KillfeedAttributes = KillfeedAttributes()
	
		open class KillfeedAttributes : BaseGunAttributes.MetaAttributes.KillfeedAttributes() 
	}
	
	open class MeterAttributes : BaseGunAttributes.MeterAttributes() 
	
	open class MovementAttributes : BaseGunAttributes.MovementAttributes() {
		override val moveSpeed: MoveSpeedAttributes = MoveSpeedAttributes()
	
		open class MoveSpeedAttributes : BaseGunAttributes.MovementAttributes.MoveSpeedAttributes() 
	}
	
	open class HeadsAttributes : BaseGunAttributes.HeadsAttributes() 
	
	open class OnHitAttributes : BaseGunAttributes.OnHitAttributes() {
		override val healOnHitForRapidfire: HealOnHitForRapidfireAttributes = HealOnHitForRapidfireAttributes()
	
		override val generateRageOnDamage: GenerateRageOnDamageAttributes = GenerateRageOnDamageAttributes()
	
		open class HealOnHitForRapidfireAttributes : BaseGunAttributes.OnHitAttributes.HealOnHitForRapidfireAttributes() 
	
		open class GenerateRageOnDamageAttributes : BaseGunAttributes.OnHitAttributes.GenerateRageOnDamageAttributes() 
	}
	
	open class OnKillAttributes : BaseGunAttributes.OnKillAttributes() 
	
	open class ReloadingAttributes : BaseGunAttributes.ReloadingAttributes() 
	
	open class ResistanceAttributes : BaseGunAttributes.ResistanceAttributes() 
	
	open class RevengeCritsAttributes : BaseGunAttributes.RevengeCritsAttributes() 
	
	open class StatusEffectsAttributes : BaseGunAttributes.StatusEffectsAttributes() 
	
	open class TauntingAttributes : BaseGunAttributes.TauntingAttributes() 
	
	open class ViewmodelAttributes : BaseGunAttributes.ViewmodelAttributes() 
	
	open class SwapWeaponsAttributes : BaseGunAttributes.SwapWeaponsAttributes() {
		override val deploy: DeployAttributes = DeployAttributes()
	
		open class DeployAttributes : BaseGunAttributes.SwapWeaponsAttributes.DeployAttributes() 
	}
	
	open class WhenHitAttributes : BaseGunAttributes.WhenHitAttributes() 
	
	open class RagdollsAttributes : BaseGunAttributes.RagdollsAttributes() 
}