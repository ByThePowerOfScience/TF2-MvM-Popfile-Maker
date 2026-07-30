package btpos.source.vdfdsl.tf2.itemattributes

import btpos.source.vdfdsl.modeling.*
import btpos.source.vdfdsl.serialization.codecs.*
import btpos.source.vdfdsl.tf2.itemattributes.impl.*
import btpos.source.vdfdsl.tf2.tftypes.*
import java.util.*



interface GrenadeLauncherAttributes : BaseGunAttributes {
	companion object {
		/**
		 * In-Game: "Cannonballs have a fuse time of 1 second; fuses can be primed to explode earlier by holding down the fire key."
		 */
		val grenadeLauncherMortarMode: ItemAttributeNamed<Duration> = ItemAttributeNamed("grenade launcher mortar mode")
	
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

	override val projectiles: ProjectilesAttributes get() = GrenadeLauncherAttributes.projectiles
	
	override val damage: DamageAttributes get() = GrenadeLauncherAttributes.damage
	
	/**
	 * In-Game: "Cannonballs have a fuse time of 1 second; fuses can be primed to explode earlier by holding down the fire key."
	 */
	val grenadeLauncherMortarMode: ItemAttributeNamed<Duration> get() = GrenadeLauncherAttributes.grenadeLauncherMortarMode
	
	override val ammo: AmmoAttributes get() = GrenadeLauncherAttributes.ammo
	
	override val firing: FiringAttributes get() = GrenadeLauncherAttributes.firing
	
	override val afterburn: AfterburnAttributes get() = GrenadeLauncherAttributes.afterburn
	
	override val buildings: BuildingsAttributes get() = GrenadeLauncherAttributes.buildings
	
	override val crits: CritsAttributes get() = GrenadeLauncherAttributes.crits
	
	override val demoCharge: DemoChargeAttributes get() = GrenadeLauncherAttributes.demoCharge
	
	override val healthAndHealing: HealthAndHealingAttributes get() = GrenadeLauncherAttributes.healthAndHealing
	
	override val knockbackReceived: KnockbackReceivedAttributes get() = GrenadeLauncherAttributes.knockbackReceived
	
	override val meta: MetaAttributes get() = GrenadeLauncherAttributes.meta
	
	override val meter: MeterAttributes get() = GrenadeLauncherAttributes.meter
	
	override val movement: MovementAttributes get() = GrenadeLauncherAttributes.movement
	
	override val heads: HeadsAttributes get() = GrenadeLauncherAttributes.heads
	
	override val onHit: OnHitAttributes get() = GrenadeLauncherAttributes.onHit
	
	override val onKill: OnKillAttributes get() = GrenadeLauncherAttributes.onKill
	
	override val reloading: ReloadingAttributes get() = GrenadeLauncherAttributes.reloading
	
	override val resistance: ResistanceAttributes get() = GrenadeLauncherAttributes.resistance
	
	override val revengeCrits: RevengeCritsAttributes get() = GrenadeLauncherAttributes.revengeCrits
	
	override val statusEffects: StatusEffectsAttributes get() = GrenadeLauncherAttributes.statusEffects
	
	override val taunting: TauntingAttributes get() = GrenadeLauncherAttributes.taunting
	
	override val viewmodel: ViewmodelAttributes get() = GrenadeLauncherAttributes.viewmodel
	
	override val swapWeapons: SwapWeaponsAttributes get() = GrenadeLauncherAttributes.swapWeapons
	
	override val whenHit: WhenHitAttributes get() = GrenadeLauncherAttributes.whenHit
	
	override val ragdolls: RagdollsAttributes get() = GrenadeLauncherAttributes.ragdolls

	open class ProjectilesAttributes : BaseGunAttributes.ProjectilesAttributes() {
		open val projectileSpeed: BonusPenaltyHidden<Float, ItemAttributeNamed<Float>> = BonusPenaltyHidden(
			ItemAttributeNamed<Float>("Projectile speed increased"),
			ItemAttributeNamed<Float>("Projectile speed decreased"),
			ItemAttributeNamed<Float>("Projectile speed increased HIDDEN"),
		)
	
		override val bullets: BulletsAttributes = BulletsAttributes()
	
		override val projectilePenetration: ProjectilePenetrationAttributes = ProjectilePenetrationAttributes()
	
		open class BulletsAttributes : BaseGunAttributes.ProjectilesAttributes.BulletsAttributes() 
	
		open class ProjectilePenetrationAttributes : BaseGunAttributes.ProjectilesAttributes.ProjectilePenetrationAttributes() 
	}
	
	open class DamageAttributes : BaseGunAttributes.DamageAttributes() {
		/**
		 * In-Game: "N% damage on grenades that explode on timer"
		 * 
		 * Flat multiplier applied to initial damage.
		 */
		open val grenadeDetonationDamagePenalty: ItemAttributeNamed<Float> = ItemAttributeNamed("grenade detonation damage penalty")
	
		override val damage: DamageAttributes = DamageAttributes()
	
		open class DamageAttributes : BaseGunAttributes.DamageAttributes.DamageAttributes() 
	}
	
	open class AmmoAttributes : BaseGunAttributes.AmmoAttributes() {
		override val clipSize: ClipSizeAttributes = ClipSizeAttributes()
	
		open class ClipSizeAttributes : BaseGunAttributes.AmmoAttributes.ClipSizeAttributes() 
	}
	
	open class FiringAttributes : BaseGunAttributes.FiringAttributes() {
		override val fireRate: FireRateAttributes = FireRateAttributes()
	
		open class FireRateAttributes : BaseGunAttributes.FiringAttributes.FireRateAttributes() {
			override val fireRate: FireRateAttributes = FireRateAttributes()
	
			open class FireRateAttributes : BaseGunAttributes.FiringAttributes.FireRateAttributes.FireRateAttributes() 
		}
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