package btpos.source.vdfdsl.tf2.itemattributes

import btpos.source.vdfdsl.modeling.*
import btpos.source.vdfdsl.serialization.codecs.*
import btpos.source.vdfdsl.tf2.itemattributes.impl.*
import btpos.source.vdfdsl.tf2.tftypes.*
import java.util.*
import kotlin.time.Duration

interface WearableVMAttributes : IBlockScoped, WearableAttributes {
	companion object : IBlockScoped {
		/**
		 * Attributes governing how much damage the player takes from various sources.  Also includes the passive and active effects of the Vaccinator on the user.
		 * 
		 * For outgoing damage, see [damage].
		 */
		private val resistance: ResistanceAttributes = ResistanceAttributes()
	
		/**
		 * Attributes related to the scoreboard, killfeed, HuD, item descriptions, and interactions with the wider game-state. (including capture rate)
		 */
		private val meta: MetaAttributes = MetaAttributes()
	
		/**
		 * Attributes related to max ammo, clip-size, and resupply.
		 */
		private val ammo: AmmoAttributes = AmmoAttributes()
	
		private val buffItems: BuffItemsAttributes = BuffItemsAttributes()
	
		/**
		 * Attributes related to moving, constructing, and interacting with the Engineer's buildings.
		 */
		private val buildings: BuildingsAttributes = BuildingsAttributes()
	
		private val cloak: CloakAttributes = CloakAttributes()
	
		/**
		 * Multipliers governing the damage you deal to different targets.
		 * 
		 * For damage _taken_, see [resistance].
		 */
		private val damage: DamageAttributes = DamageAttributes()
	
		/**
		 * Attributes governing the Demoknight's shield-charge.
		 * 
		 * Some of these attributes are hardcoded to only work on the Demoman. These are noted in their documentation.
		 */
		private val demoCharge: DemoChargeAttributes = DemoChargeAttributes()
	
		/**
		 * Attributes related to disguising.
		 */
		private val disguise: DisguiseAttributes = DisguiseAttributes()
	
		/**
		 * Attributes governing rate-of-fire.
		 */
		private val firing: FiringAttributes = FiringAttributes()
	
		/**
		 * Attributes related to the collection and passive effects of "heads".
		 * 
		 * While originally made for the Eyelander, this stat is used by many other weapons that track players hit or killed: the Vita-Saw, the Bazaar Bargain, etc.
		 * 
		 * For "revenge crits", like the Frontier Justice, Manmelter, and Diamondback, see [revengeCrits].
		 */
		private val heads: HeadsAttributes = HeadsAttributes()
	
		/**
		 * Attributes related to the player's HP stat and healing players.
		 */
		private val healthAndHealing: HealthAndHealingAttributes = HealthAndHealingAttributes()
	
		private val hud: HudAttributes = HudAttributes()
	
		/**
		 * Attributes governing how much you are pushed when hit by different push sources.
		 */
		private val knockbackReceived: KnockbackReceivedAttributes = KnockbackReceivedAttributes()
	
		/**
		 * Attributes related to rage and items that recharge on a meter/timer.
		 */
		private val meter: MeterAttributes = MeterAttributes()
	
		/**
		 * Attributes governing the player's move-speed, jump height, swimming, air-strafing capabilities, and all things mobility-related.
		 */
		private val movement: MovementAttributes = MovementAttributes()
	
		/**
		 * Attributes governing what happens when you hit another player, such as applying conditions or debuffs.
		 * 
		 * @see onKill
		 */
		private val onHit: OnHitAttributes = OnHitAttributes()
	
		/**
		 * Attributes governing what happens when you kill another player, usually applying bonuses to yourself.
		 * 
		 * @see onHit
		 */
		private val onKill: OnKillAttributes = OnKillAttributes()
	
		/**
		 * Attributes governing taunt speed and the effects of taunts.
		 */
		private val taunting: TauntingAttributes = TauntingAttributes()
	
		/**
		 * Attributes governing weapon deploy/holster speed, things that activate when a weapon is deployed, and whether a player can swap weapons at all.
		 */
		private val swapWeapons: SwapWeaponsAttributes = SwapWeaponsAttributes()
	
		/**
		 * Attributes governing what happens when this player is hit by an enemy.
		 * 
		 * For what happens when _this player_ hits an enemy, see [onHit] and [onKill].
		 */
		private val whenHit: WhenHitAttributes = WhenHitAttributes()
	
		private val spyOnly: SpyOnlyAttributes = SpyOnlyAttributes()
	
		/**
		 * Attributes related to dealing or preventing critical hits and mini-crits.
		 */
		private val crits: CritsAttributes = CritsAttributes()
	}
	
	/**
	 * Attributes governing how much damage the player takes from various sources.  Also includes the passive and active effects of the Vaccinator on the user.
	 * 
	 * For outgoing damage, see [damage].
	 */
	override val resistance: ResistanceAttributes get() = WearableVMAttributes.resistance
	
	/**
	 * Attributes related to the scoreboard, killfeed, HuD, item descriptions, and interactions with the wider game-state. (including capture rate)
	 */
	override val meta: MetaAttributes get() = WearableVMAttributes.meta
	
	/**
	 * Attributes related to max ammo, clip-size, and resupply.
	 */
	override val ammo: AmmoAttributes get() = WearableVMAttributes.ammo
	
	override val buffItems: BuffItemsAttributes get() = WearableVMAttributes.buffItems
	
	/**
	 * Attributes related to moving, constructing, and interacting with the Engineer's buildings.
	 */
	override val buildings: BuildingsAttributes get() = WearableVMAttributes.buildings
	
	override val cloak: CloakAttributes get() = WearableVMAttributes.cloak
	
	/**
	 * Multipliers governing the damage you deal to different targets.
	 * 
	 * For damage _taken_, see [resistance].
	 */
	override val damage: DamageAttributes get() = WearableVMAttributes.damage
	
	/**
	 * Attributes governing the Demoknight's shield-charge.
	 * 
	 * Some of these attributes are hardcoded to only work on the Demoman. These are noted in their documentation.
	 */
	override val demoCharge: DemoChargeAttributes get() = WearableVMAttributes.demoCharge
	
	/**
	 * Attributes related to disguising.
	 */
	override val disguise: DisguiseAttributes get() = WearableVMAttributes.disguise
	
	/**
	 * Attributes governing rate-of-fire.
	 */
	override val firing: FiringAttributes get() = WearableVMAttributes.firing
	
	/**
	 * Attributes related to the collection and passive effects of "heads".
	 * 
	 * While originally made for the Eyelander, this stat is used by many other weapons that track players hit or killed: the Vita-Saw, the Bazaar Bargain, etc.
	 * 
	 * For "revenge crits", like the Frontier Justice, Manmelter, and Diamondback, see [revengeCrits].
	 */
	override val heads: HeadsAttributes get() = WearableVMAttributes.heads
	
	/**
	 * Attributes related to the player's HP stat and healing players.
	 */
	override val healthAndHealing: HealthAndHealingAttributes get() = WearableVMAttributes.healthAndHealing
	
	override val hud: HudAttributes get() = WearableVMAttributes.hud
	
	/**
	 * Attributes governing how much you are pushed when hit by different push sources.
	 */
	override val knockbackReceived: KnockbackReceivedAttributes get() = WearableVMAttributes.knockbackReceived
	
	/**
	 * Attributes related to rage and items that recharge on a meter/timer.
	 */
	override val meter: MeterAttributes get() = WearableVMAttributes.meter
	
	/**
	 * Attributes governing the player's move-speed, jump height, swimming, air-strafing capabilities, and all things mobility-related.
	 */
	override val movement: MovementAttributes get() = WearableVMAttributes.movement
	
	/**
	 * Attributes governing what happens when you hit another player, such as applying conditions or debuffs.
	 * 
	 * @see onKill
	 */
	override val onHit: OnHitAttributes get() = WearableVMAttributes.onHit
	
	/**
	 * Attributes governing what happens when you kill another player, usually applying bonuses to yourself.
	 * 
	 * @see onHit
	 */
	override val onKill: OnKillAttributes get() = WearableVMAttributes.onKill
	
	/**
	 * Attributes governing taunt speed and the effects of taunts.
	 */
	override val taunting: TauntingAttributes get() = WearableVMAttributes.taunting
	
	/**
	 * Attributes governing weapon deploy/holster speed, things that activate when a weapon is deployed, and whether a player can swap weapons at all.
	 */
	override val swapWeapons: SwapWeaponsAttributes get() = WearableVMAttributes.swapWeapons
	
	/**
	 * Attributes governing what happens when this player is hit by an enemy.
	 * 
	 * For what happens when _this player_ hits an enemy, see [onHit] and [onKill].
	 */
	override val whenHit: WhenHitAttributes get() = WearableVMAttributes.whenHit
	
	override val spyOnly: SpyOnlyAttributes get() = WearableVMAttributes.spyOnly
	
	/**
	 * Attributes related to dealing or preventing critical hits and mini-crits.
	 */
	override val crits: CritsAttributes get() = WearableVMAttributes.crits
	
	open class ResistanceAttributes : WearableAttributes.ResistanceAttributes() {
		override val dmgTakenFromCritReduced: DmgTakenFromCritReducedAttributes = DmgTakenFromCritReducedAttributes()
	
		override val dmgTakenFromFireReduced: DmgTakenFromFireReducedAttributes = DmgTakenFromFireReducedAttributes()
	
		override val dmgTakenFromBulletsReduced: DmgTakenFromBulletsReducedAttributes = DmgTakenFromBulletsReducedAttributes()
	
		override val vaccinator: VaccinatorAttributes = VaccinatorAttributes()
	
		open class DmgTakenFromCritReducedAttributes : WearableAttributes.ResistanceAttributes.DmgTakenFromCritReducedAttributes() 
	
		open class DmgTakenFromFireReducedAttributes : WearableAttributes.ResistanceAttributes.DmgTakenFromFireReducedAttributes() 
	
		open class DmgTakenFromBulletsReducedAttributes : WearableAttributes.ResistanceAttributes.DmgTakenFromBulletsReducedAttributes() 
	
		open class VaccinatorAttributes : WearableAttributes.ResistanceAttributes.VaccinatorAttributes() 
	}
	
	open class MetaAttributes : WearableAttributes.MetaAttributes() {
		override val player: PlayerAttributes = PlayerAttributes()
	
		override val items: ItemsAttributes = ItemsAttributes()
	
		override val particles: ParticlesAttributes = ParticlesAttributes()
	
		override val killfeed: KillfeedAttributes = KillfeedAttributes()
	
		override val noisemakers: NoisemakersAttributes = NoisemakersAttributes()
	
		override val gameplay: GameplayAttributes = GameplayAttributes()
	
		open class PlayerAttributes : WearableAttributes.MetaAttributes.PlayerAttributes() 
	
		open class ItemsAttributes : WearableAttributes.MetaAttributes.ItemsAttributes() 
	
		open class ParticlesAttributes : WearableAttributes.MetaAttributes.ParticlesAttributes() 
	
		open class KillfeedAttributes : WearableAttributes.MetaAttributes.KillfeedAttributes() 
	
		open class NoisemakersAttributes : WearableAttributes.MetaAttributes.NoisemakersAttributes() 
	
		open class GameplayAttributes : WearableAttributes.MetaAttributes.GameplayAttributes() 
	}
	
	open class AmmoAttributes : WearableAttributes.AmmoAttributes() {
		override val modMaxAmmo: MaxAmmoAttributes = MaxAmmoAttributes()
	
		open class MaxAmmoAttributes : WearableAttributes.AmmoAttributes.MaxAmmoAttributes() 
	}
	
	open class BuffItemsAttributes : WearableAttributes.BuffItemsAttributes() 
	
	open class BuildingsAttributes : WearableAttributes.BuildingsAttributes() {
		override val sentryGun: SentryGunAttributes = SentryGunAttributes()
	
		override val dispenser: DispenserAttributes = DispenserAttributes()
	
		override val teleporter: TeleporterAttributes = TeleporterAttributes()
	
		open class SentryGunAttributes : WearableAttributes.BuildingsAttributes.SentryGunAttributes() 
	
		open class DispenserAttributes : WearableAttributes.BuildingsAttributes.DispenserAttributes() 
	
		open class TeleporterAttributes : WearableAttributes.BuildingsAttributes.TeleporterAttributes() 
	}
	
	open class CloakAttributes : WearableAttributes.CloakAttributes() 
	
	open class DamageAttributes : WearableAttributes.DamageAttributes() {
		override val alien: AlienAttributes = AlienAttributes()
	
		open class AlienAttributes : WearableAttributes.DamageAttributes.AlienAttributes() 
	}
	
	open class DemoChargeAttributes : WearableAttributes.DemoChargeAttributes() {
		override val multChargeTurnControl: MultChargeTurnControlAttributes = MultChargeTurnControlAttributes()
	
		open class MultChargeTurnControlAttributes : WearableAttributes.DemoChargeAttributes.MultChargeTurnControlAttributes() 
	}
	
	open class DisguiseAttributes : WearableAttributes.DisguiseAttributes() 
	
	open class FiringAttributes : WearableAttributes.FiringAttributes() 
	
	open class HeadsAttributes : WearableAttributes.HeadsAttributes() 
	
	open class HealthAndHealingAttributes : WearableAttributes.HealthAndHealingAttributes() {
		override val healthRegen: HealthRegenAttributes = HealthRegenAttributes()
	
		override val maxHealthAdditiveBonus: MaxHealthAdditiveAttributes = MaxHealthAdditiveAttributes()
	
		open class HealthRegenAttributes : WearableAttributes.HealthAndHealingAttributes.HealthRegenAttributes() 
	
		open class MaxHealthAdditiveAttributes : WearableAttributes.HealthAndHealingAttributes.MaxHealthAdditiveAttributes() 
	}
	
	open class HudAttributes : WearableAttributes.HudAttributes() 
	
	open class KnockbackReceivedAttributes : WearableAttributes.KnockbackReceivedAttributes() 
	
	open class MeterAttributes : WearableAttributes.MeterAttributes() {
		override val generateRageOnDamage: GenerateRageOnDamageAttributes = GenerateRageOnDamageAttributes()
	
		open class GenerateRageOnDamageAttributes : WearableAttributes.MeterAttributes.GenerateRageOnDamageAttributes() 
	}
	
	open class MovementAttributes : WearableAttributes.MovementAttributes() {
		override val increasedJumpHeight: jumpHeightAttributes = jumpHeightAttributes()
	
		override val moveSpeed: MoveSpeedAttributes = MoveSpeedAttributes()
	
		open class jumpHeightAttributes : WearableAttributes.MovementAttributes.jumpHeightAttributes() 
	
		open class MoveSpeedAttributes : WearableAttributes.MovementAttributes.MoveSpeedAttributes() {
			override val aimingMovespeedIncreased: AimingMovespeedAttributes = AimingMovespeedAttributes()
	
			override val moveSpeedPenalty: MoveSpeedAttributes = MoveSpeedAttributes()
	
			open class AimingMovespeedAttributes : WearableAttributes.MovementAttributes.MoveSpeedAttributes.AimingMovespeedAttributes() 
	
			open class MoveSpeedAttributes : WearableAttributes.MovementAttributes.MoveSpeedAttributes.MoveSpeedAttributes() 
		}
	}
	
	open class OnHitAttributes : WearableAttributes.OnHitAttributes() {
		override val falling: FallingAttributes = FallingAttributes()
	
		open class FallingAttributes : WearableAttributes.OnHitAttributes.FallingAttributes() 
	}
	
	open class OnKillAttributes : WearableAttributes.OnKillAttributes() 
	
	open class TauntingAttributes : WearableAttributes.TauntingAttributes() 
	
	open class SwapWeaponsAttributes : WearableAttributes.SwapWeaponsAttributes() 
	
	open class WhenHitAttributes : WearableAttributes.WhenHitAttributes() 
	
	open class SpyOnlyAttributes : WearableAttributes.SpyOnlyAttributes() 
	
	open class CritsAttributes : WearableAttributes.CritsAttributes() 
	
	object Inherited : WearableVMAttributes 
}