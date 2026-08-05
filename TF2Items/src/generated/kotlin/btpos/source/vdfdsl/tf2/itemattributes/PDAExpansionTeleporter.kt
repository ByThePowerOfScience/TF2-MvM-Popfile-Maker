package btpos.source.vdfdsl.tf2.itemattributes

import btpos.source.vdfdsl.modeling.*
import btpos.source.vdfdsl.serialization.*
import btpos.source.vdfdsl.serialization.codecs.*
import btpos.source.vdfdsl.tf2.itemattributes.impl.*
import btpos.source.vdfdsl.tf2.tftypes.*
import java.util.*
import kotlin.time.Duration

interface PDAExpansionTeleporterAttributes : IBlockScoped, WearableAttributes {
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
	override val resistance: ResistanceAttributes get() = PDAExpansionTeleporterAttributes.resistance
	
	/**
	 * Attributes related to the scoreboard, killfeed, HuD, item descriptions, and interactions with the wider game-state. (including capture rate)
	 */
	override val meta: MetaAttributes get() = PDAExpansionTeleporterAttributes.meta
	
	/**
	 * Attributes related to max ammo, clip-size, and resupply.
	 */
	override val ammo: AmmoAttributes get() = PDAExpansionTeleporterAttributes.ammo
	
	override val buffItems: BuffItemsAttributes get() = PDAExpansionTeleporterAttributes.buffItems
	
	/**
	 * Attributes related to moving, constructing, and interacting with the Engineer's buildings.
	 */
	override val buildings: BuildingsAttributes get() = PDAExpansionTeleporterAttributes.buildings
	
	override val cloak: CloakAttributes get() = PDAExpansionTeleporterAttributes.cloak
	
	/**
	 * Multipliers governing the damage you deal to different targets.
	 * 
	 * For damage _taken_, see [resistance].
	 */
	override val damage: DamageAttributes get() = PDAExpansionTeleporterAttributes.damage
	
	/**
	 * Attributes governing the Demoknight's shield-charge.
	 * 
	 * Some of these attributes are hardcoded to only work on the Demoman. These are noted in their documentation.
	 */
	override val demoCharge: DemoChargeAttributes get() = PDAExpansionTeleporterAttributes.demoCharge
	
	/**
	 * Attributes related to disguising.
	 */
	override val disguise: DisguiseAttributes get() = PDAExpansionTeleporterAttributes.disguise
	
	/**
	 * Attributes governing rate-of-fire.
	 */
	override val firing: FiringAttributes get() = PDAExpansionTeleporterAttributes.firing
	
	/**
	 * Attributes related to the collection and passive effects of "heads".
	 * 
	 * While originally made for the Eyelander, this stat is used by many other weapons that track players hit or killed: the Vita-Saw, the Bazaar Bargain, etc.
	 * 
	 * For "revenge crits", like the Frontier Justice, Manmelter, and Diamondback, see [revengeCrits].
	 */
	override val heads: HeadsAttributes get() = PDAExpansionTeleporterAttributes.heads
	
	/**
	 * Attributes related to the player's HP stat and healing players.
	 */
	override val healthAndHealing: HealthAndHealingAttributes get() = PDAExpansionTeleporterAttributes.healthAndHealing
	
	override val hud: HudAttributes get() = PDAExpansionTeleporterAttributes.hud
	
	/**
	 * Attributes governing how much you are pushed when hit by different push sources.
	 */
	override val knockbackReceived: KnockbackReceivedAttributes get() = PDAExpansionTeleporterAttributes.knockbackReceived
	
	/**
	 * Attributes related to rage and items that recharge on a meter/timer.
	 */
	override val meter: MeterAttributes get() = PDAExpansionTeleporterAttributes.meter
	
	/**
	 * Attributes governing the player's move-speed, jump height, swimming, air-strafing capabilities, and all things mobility-related.
	 */
	override val movement: MovementAttributes get() = PDAExpansionTeleporterAttributes.movement
	
	/**
	 * Attributes governing what happens when you hit another player, such as applying conditions or debuffs.
	 * 
	 * @see onKill
	 */
	override val onHit: OnHitAttributes get() = PDAExpansionTeleporterAttributes.onHit
	
	/**
	 * Attributes governing what happens when you kill another player, usually applying bonuses to yourself.
	 * 
	 * @see onHit
	 */
	override val onKill: OnKillAttributes get() = PDAExpansionTeleporterAttributes.onKill
	
	/**
	 * Attributes governing taunt speed and the effects of taunts.
	 */
	override val taunting: TauntingAttributes get() = PDAExpansionTeleporterAttributes.taunting
	
	/**
	 * Attributes governing weapon deploy/holster speed, things that activate when a weapon is deployed, and whether a player can swap weapons at all.
	 */
	override val swapWeapons: SwapWeaponsAttributes get() = PDAExpansionTeleporterAttributes.swapWeapons
	
	/**
	 * Attributes governing what happens when this player is hit by an enemy.
	 * 
	 * For what happens when _this player_ hits an enemy, see [onHit] and [onKill].
	 */
	override val whenHit: WhenHitAttributes get() = PDAExpansionTeleporterAttributes.whenHit
	
	override val spyOnly: SpyOnlyAttributes get() = PDAExpansionTeleporterAttributes.spyOnly
	
	/**
	 * Attributes related to dealing or preventing critical hits and mini-crits.
	 */
	override val crits: CritsAttributes get() = PDAExpansionTeleporterAttributes.crits
	
	open class ResistanceAttributes : WearableAttributes.ResistanceAttributes() {
		override val multDmgTakenCrits: MultDmgtakenFromCritAttributes = MultDmgtakenFromCritAttributes()
	
		override val multDmgTakenFire: MultDmgtakenFromFireAttributes = MultDmgtakenFromFireAttributes()
	
		override val multDmgTakenBullets: MultDmgtakenFromBulletsAttributes = MultDmgtakenFromBulletsAttributes()
	
		override val vaccinator: VaccinatorAttributes = VaccinatorAttributes()
	
		open class MultDmgtakenFromCritAttributes : WearableAttributes.ResistanceAttributes.MultDmgtakenFromCritAttributes(), ItemAttribute<Number> 
	
		open class MultDmgtakenFromFireAttributes : WearableAttributes.ResistanceAttributes.MultDmgtakenFromFireAttributes(), ItemAttribute<Number> 
	
		open class MultDmgtakenFromBulletsAttributes : WearableAttributes.ResistanceAttributes.MultDmgtakenFromBulletsAttributes(), ItemAttribute<Number> 
	
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
		override val multMaxAmmo: MaxAmmoAttributes = MaxAmmoAttributes()
	
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
		/**
		 * Default is 0.45f, and this is a multiplier applied to it.
		 */
		override val multChargeTurnControl: ChargeTurnControlAttributes = ChargeTurnControlAttributes()
	
		open class ChargeTurnControlAttributes : WearableAttributes.DemoChargeAttributes.ChargeTurnControlAttributes(), ItemAttribute<Number> 
	}
	
	open class DisguiseAttributes : WearableAttributes.DisguiseAttributes() 
	
	open class FiringAttributes : WearableAttributes.FiringAttributes() 
	
	open class HeadsAttributes : WearableAttributes.HeadsAttributes() 
	
	open class HealthAndHealingAttributes : WearableAttributes.HealthAndHealingAttributes() {
		/**
		 * Amount of health regenerated per regen tick.  Scales by the amount of time since the player last took damage in non-MvM modes.
		 */
		override val healthRegenPerSecond: AddHealthRegenAttributes = AddHealthRegenAttributes()
	
		/**
		 * Additive maximum health increase. Influences the player's overheal cap.
		 */
		override val addMaxHealth: AddMaxhealthAttributes = AddMaxhealthAttributes()
	
		open class AddHealthRegenAttributes : WearableAttributes.HealthAndHealingAttributes.AddHealthRegenAttributes(), ItemAttribute<Int> 
	
		open class AddMaxhealthAttributes : WearableAttributes.HealthAndHealingAttributes.AddMaxhealthAttributes(), ItemAttribute<Int> 
	}
	
	open class HudAttributes : WearableAttributes.HudAttributes() 
	
	open class KnockbackReceivedAttributes : WearableAttributes.KnockbackReceivedAttributes() 
	
	open class MeterAttributes : WearableAttributes.MeterAttributes() {
		/**
		 * Only works on Engineer and Heavy.
		 * 
		 * On Engineer, adds all damage dealt to the rage meter.
		 * 
		 * On Heavy, adds `0.22` * the damage to the meter, and reduces damage by 50% while the meter is draining.
		 */
		override val generateRageOnDmg: GenerateRageOnDmgAttributes = GenerateRageOnDmgAttributes()
	
		open class GenerateRageOnDmgAttributes : WearableAttributes.MeterAttributes.GenerateRageOnDmgAttributes(), ItemAttribute<Boolean> 
	}
	
	open class MovementAttributes : WearableAttributes.MovementAttributes() {
		override val multJumpHeight: ModJumpHeightAttributes = ModJumpHeightAttributes()
	
		override val moveSpeed: MoveSpeedAttributes = MoveSpeedAttributes()
	
		open class ModJumpHeightAttributes : WearableAttributes.MovementAttributes.ModJumpHeightAttributes(), ItemAttribute<Number> 
	
		open class MoveSpeedAttributes : WearableAttributes.MovementAttributes.MoveSpeedAttributes() {
			/**
			 * Only applies to players that have TF_COND_AIMING.
			 * 
			 * If Heavy, default aiming movespeed is 110.
			 * 
			 * Else if player is using a compound bow, 160.
			 * 
			 * Else 80.
			 */
			override val multPlayerAimingMovespeed: MultPlayerAimingMovespeedAttributes = MultPlayerAimingMovespeedAttributes()
	
			override val multMoveSpeed: MultPlayerMovespeedAttributes = MultPlayerMovespeedAttributes()
	
			open class MultPlayerAimingMovespeedAttributes : WearableAttributes.MovementAttributes.MoveSpeedAttributes.MultPlayerAimingMovespeedAttributes() 
	
			open class MultPlayerMovespeedAttributes : WearableAttributes.MovementAttributes.MoveSpeedAttributes.MultPlayerMovespeedAttributes(), ItemAttribute<Number> 
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
	
	object Inherited : PDAExpansionTeleporterAttributes 
}