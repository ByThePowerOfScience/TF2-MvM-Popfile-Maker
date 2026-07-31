package btpos.source.vdfdsl.tf2.itemattributes

import btpos.source.vdfdsl.modeling.*
import btpos.source.vdfdsl.serialization.codecs.*
import btpos.source.vdfdsl.tf2.itemattributes.impl.*
import btpos.source.vdfdsl.tf2.tftypes.*
import java.util.*
import kotlin.time.Duration

interface MinigunAttributes : BaseGunAttributes {
	companion object : IBlockScoped {
		/**
		 * In-Game: "Silent Killer: No barrel spin sound"
		 */
		val silentBarrel: ItemAttributeNamed<Boolean> = ItemAttributeNamed("minigun no spin sounds")
	
		val minigunSpinupTime: BonusPenalty<Number> = BonusPenalty(
			ItemAttributeNamed("minigun spinup time decreased"),
			ItemAttributeNamed("minigun spinup time increased"),
		)
	
		/**
		 * In-Game: "Bullets destroy rockets and grenades in-flight.  Increased accuracy and frequency per-level."
		 * 
		 * Overridden by "raid gamemode" to 1.
		 */
		val attackProjectiles: ItemAttributeNamed<Boolean> = ItemAttributeNamed("attack projectiles")
	
		/**
		 * In-Game: "Creates a ring of flames while spun up"
		 */
		val ringOfFireWhileAiming: ItemAttributeNamed<Int> = ItemAttributeNamed("ring of fire while aiming")
	
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

	override val ammo: AmmoAttributes get() = MinigunAttributes.ammo
	
	/**
	 * In-Game: "Silent Killer: No barrel spin sound"
	 */
	val silentBarrel: ItemAttributeNamed<Boolean> get() = MinigunAttributes.silentBarrel
	
	val minigunSpinupTime: BonusPenalty<Number> get() = MinigunAttributes.minigunSpinupTime
	
	/**
	 * In-Game: "Bullets destroy rockets and grenades in-flight.  Increased accuracy and frequency per-level."
	 * 
	 * Overridden by "raid gamemode" to 1.
	 */
	val attackProjectiles: ItemAttributeNamed<Boolean> get() = MinigunAttributes.attackProjectiles
	
	/**
	 * In-Game: "Creates a ring of flames while spun up"
	 */
	val ringOfFireWhileAiming: ItemAttributeNamed<Int> get() = MinigunAttributes.ringOfFireWhileAiming
	
	override val damage: DamageAttributes get() = MinigunAttributes.damage
	
	override val firing: FiringAttributes get() = MinigunAttributes.firing
	
	override val projectiles: ProjectilesAttributes get() = MinigunAttributes.projectiles
	
	override val afterburn: AfterburnAttributes get() = MinigunAttributes.afterburn
	
	override val buildings: BuildingsAttributes get() = MinigunAttributes.buildings
	
	override val crits: CritsAttributes get() = MinigunAttributes.crits
	
	override val demoCharge: DemoChargeAttributes get() = MinigunAttributes.demoCharge
	
	override val healthAndHealing: HealthAndHealingAttributes get() = MinigunAttributes.healthAndHealing
	
	override val knockbackReceived: KnockbackReceivedAttributes get() = MinigunAttributes.knockbackReceived
	
	override val meta: MetaAttributes get() = MinigunAttributes.meta
	
	override val meter: MeterAttributes get() = MinigunAttributes.meter
	
	override val movement: MovementAttributes get() = MinigunAttributes.movement
	
	override val heads: HeadsAttributes get() = MinigunAttributes.heads
	
	override val onHit: OnHitAttributes get() = MinigunAttributes.onHit
	
	override val onKill: OnKillAttributes get() = MinigunAttributes.onKill
	
	override val reloading: ReloadingAttributes get() = MinigunAttributes.reloading
	
	override val resistance: ResistanceAttributes get() = MinigunAttributes.resistance
	
	override val revengeCrits: RevengeCritsAttributes get() = MinigunAttributes.revengeCrits
	
	override val statusEffects: StatusEffectsAttributes get() = MinigunAttributes.statusEffects
	
	override val taunting: TauntingAttributes get() = MinigunAttributes.taunting
	
	override val viewmodel: ViewmodelAttributes get() = MinigunAttributes.viewmodel
	
	override val swapWeapons: SwapWeaponsAttributes get() = MinigunAttributes.swapWeapons
	
	override val whenHit: WhenHitAttributes get() = MinigunAttributes.whenHit
	
	override val ragdolls: RagdollsAttributes get() = MinigunAttributes.ragdolls
	
	override val disguise: DisguiseAttributes get() = MinigunAttributes.disguise

	open class AmmoAttributes : BaseGunAttributes.AmmoAttributes() {
		companion object : IBlockScoped {
			/**
			 * In-Game: "Consumes an additional N ammo per second while spun up"
			 * 
			 * Amount of ammo drained per second.
			 */
			val spinupAmmoDrain: ItemAttributeNamed<Int> = ItemAttributeNamed("uses ammo while aiming")
		}
	
		/**
		 * In-Game: "Consumes an additional N ammo per second while spun up"
		 * 
		 * Amount of ammo drained per second.
		 */
		context(attrs: IAttributeContainer)
		open var spinupAmmoDrain: Int? 
			get() = AmmoAttributes.spinupAmmoDrain.get()
			set(value) { AmmoAttributes.spinupAmmoDrain.set(value) }
	
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
	
		override val items: ItemsAttributes = ItemsAttributes()
	
		override val particles: ParticlesAttributes = ParticlesAttributes()
	
		open class KillfeedAttributes : BaseGunAttributes.MetaAttributes.KillfeedAttributes() 
	
		open class ItemsAttributes : BaseGunAttributes.MetaAttributes.ItemsAttributes() 
	
		open class ParticlesAttributes : BaseGunAttributes.MetaAttributes.ParticlesAttributes() 
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
	
	open class DisguiseAttributes : BaseGunAttributes.DisguiseAttributes() 
}