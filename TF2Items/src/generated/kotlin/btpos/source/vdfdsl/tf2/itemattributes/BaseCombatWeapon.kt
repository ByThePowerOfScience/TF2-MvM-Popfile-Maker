package btpos.source.vdfdsl.tf2.itemattributes

import btpos.source.vdfdsl.modeling.*
import btpos.source.vdfdsl.serialization.codecs.*
import btpos.source.vdfdsl.tf2.itemattributes.impl.*
import btpos.source.vdfdsl.tf2.tftypes.*
import java.util.*
import kotlin.time.Duration

interface BaseCombatWeaponAttributes : IBlockScoped, EconEntityAttributes {
	companion object : IBlockScoped {
		/**
		 * Attributes related to max ammo, clip-size, and resupply.
		 */
		val ammo: AmmoAttributes = AmmoAttributes()
	
		/**
		 * Attributes related to the scoreboard, killfeed, HuD, item descriptions, and interactions with the wider game-state. (including capture rate)
		 */
		private val meta: MetaAttributes = MetaAttributes()
	
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
		 * Attributes governing how much damage the player takes from various sources.  Also includes the passive and active effects of the Vaccinator on the user.
		 * 
		 * For outgoing damage, see [damage].
		 */
		private val resistance: ResistanceAttributes = ResistanceAttributes()
	
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
	 * Attributes related to max ammo, clip-size, and resupply.
	 */
	override val ammo: AmmoAttributes get() = BaseCombatWeaponAttributes.ammo
	
	/**
	 * Attributes related to the scoreboard, killfeed, HuD, item descriptions, and interactions with the wider game-state. (including capture rate)
	 */
	override val meta: MetaAttributes get() = BaseCombatWeaponAttributes.meta
	
	override val buffItems: BuffItemsAttributes get() = BaseCombatWeaponAttributes.buffItems
	
	/**
	 * Attributes related to moving, constructing, and interacting with the Engineer's buildings.
	 */
	override val buildings: BuildingsAttributes get() = BaseCombatWeaponAttributes.buildings
	
	override val cloak: CloakAttributes get() = BaseCombatWeaponAttributes.cloak
	
	/**
	 * Multipliers governing the damage you deal to different targets.
	 * 
	 * For damage _taken_, see [resistance].
	 */
	override val damage: DamageAttributes get() = BaseCombatWeaponAttributes.damage
	
	/**
	 * Attributes governing the Demoknight's shield-charge.
	 * 
	 * Some of these attributes are hardcoded to only work on the Demoman. These are noted in their documentation.
	 */
	override val demoCharge: DemoChargeAttributes get() = BaseCombatWeaponAttributes.demoCharge
	
	/**
	 * Attributes related to disguising.
	 */
	override val disguise: DisguiseAttributes get() = BaseCombatWeaponAttributes.disguise
	
	/**
	 * Attributes governing rate-of-fire.
	 */
	override val firing: FiringAttributes get() = BaseCombatWeaponAttributes.firing
	
	/**
	 * Attributes related to the collection and passive effects of "heads".
	 * 
	 * While originally made for the Eyelander, this stat is used by many other weapons that track players hit or killed: the Vita-Saw, the Bazaar Bargain, etc.
	 * 
	 * For "revenge crits", like the Frontier Justice, Manmelter, and Diamondback, see [revengeCrits].
	 */
	override val heads: HeadsAttributes get() = BaseCombatWeaponAttributes.heads
	
	/**
	 * Attributes related to the player's HP stat and healing players.
	 */
	override val healthAndHealing: HealthAndHealingAttributes get() = BaseCombatWeaponAttributes.healthAndHealing
	
	override val hud: HudAttributes get() = BaseCombatWeaponAttributes.hud
	
	/**
	 * Attributes governing how much you are pushed when hit by different push sources.
	 */
	override val knockbackReceived: KnockbackReceivedAttributes get() = BaseCombatWeaponAttributes.knockbackReceived
	
	/**
	 * Attributes related to rage and items that recharge on a meter/timer.
	 */
	override val meter: MeterAttributes get() = BaseCombatWeaponAttributes.meter
	
	/**
	 * Attributes governing the player's move-speed, jump height, swimming, air-strafing capabilities, and all things mobility-related.
	 */
	override val movement: MovementAttributes get() = BaseCombatWeaponAttributes.movement
	
	/**
	 * Attributes governing what happens when you hit another player, such as applying conditions or debuffs.
	 * 
	 * @see onKill
	 */
	override val onHit: OnHitAttributes get() = BaseCombatWeaponAttributes.onHit
	
	/**
	 * Attributes governing what happens when you kill another player, usually applying bonuses to yourself.
	 * 
	 * @see onHit
	 */
	override val onKill: OnKillAttributes get() = BaseCombatWeaponAttributes.onKill
	
	/**
	 * Attributes governing how much damage the player takes from various sources.  Also includes the passive and active effects of the Vaccinator on the user.
	 * 
	 * For outgoing damage, see [damage].
	 */
	override val resistance: ResistanceAttributes get() = BaseCombatWeaponAttributes.resistance
	
	/**
	 * Attributes governing taunt speed and the effects of taunts.
	 */
	override val taunting: TauntingAttributes get() = BaseCombatWeaponAttributes.taunting
	
	/**
	 * Attributes governing weapon deploy/holster speed, things that activate when a weapon is deployed, and whether a player can swap weapons at all.
	 */
	override val swapWeapons: SwapWeaponsAttributes get() = BaseCombatWeaponAttributes.swapWeapons
	
	/**
	 * Attributes governing what happens when this player is hit by an enemy.
	 * 
	 * For what happens when _this player_ hits an enemy, see [onHit] and [onKill].
	 */
	override val whenHit: WhenHitAttributes get() = BaseCombatWeaponAttributes.whenHit
	
	override val spyOnly: SpyOnlyAttributes get() = BaseCombatWeaponAttributes.spyOnly
	
	/**
	 * Attributes related to dealing or preventing critical hits and mini-crits.
	 */
	override val crits: CritsAttributes get() = BaseCombatWeaponAttributes.crits
	
	open class AmmoAttributes : EconEntityAttributes.AmmoAttributes() {
		/**
		 * In-Game: "Uses metal for ammo"
		 * 
		 * Reminder: non-engies start with 100 metal.
		 */
		open val useMetalAmmoType: ItemAttributeNamed<Boolean> = ItemAttributeNamed("mod use metal ammo type")
	
		/**
		 * In-Game: "No reload necessary"
		 * 
		 * In the "DoesReloadSingly" check, this _is_ actually checked, so it's actually _not_ "display-only".
		 * 
		 * If != 1.0 (if present), says the weapon "does not reload one shot at a time".
		 */
		open val noReload_displayOnly: ItemAttributeNamed<Number> = ItemAttributeNamed("mod no reload DISPLAY ONLY")
	
		/**
		 * Checked in `DoesReloadSingly`. If true, weapon does not reload one shot at a time. (e.g. FaN).
		 * 
		 * Note that for the most part, this logic is set inside the weapon itself. The scattergun attribute is the only way to control this with attributes.
		 */
		open val scattergunNoReloadSingle: ItemAttributeNamed<Boolean> = ItemAttributeNamed("scattergun no reload single")
	
		open val clipSize: ClipSizeAttributes = ClipSizeAttributes()
	
		override val modMaxAmmo: MaxAmmoAttributes = MaxAmmoAttributes()
	
		open class ClipSizeAttributes : IBlockScoped {
			/**
			 * Overwrites the max clipsize to a flat value. Applied before other multipliers.
			 */
			open val maxPrimaryClipOverride: ItemAttributeNamed<Int> = ItemAttributeNamed("mod max primary clip override")
		}
	
		open class MaxAmmoAttributes : EconEntityAttributes.AmmoAttributes.MaxAmmoAttributes() 
	}
	
	open class MetaAttributes : EconEntityAttributes.MetaAttributes() {
		override val items: ItemsAttributes = ItemsAttributes()
	
		override val particles: ParticlesAttributes = ParticlesAttributes()
	
		override val killfeed: KillfeedAttributes = KillfeedAttributes()
	
		override val noisemakers: NoisemakersAttributes = NoisemakersAttributes()
	
		override val player: PlayerAttributes = PlayerAttributes()
	
		override val gameplay: GameplayAttributes = GameplayAttributes()
	
		open class ItemsAttributes : EconEntityAttributes.MetaAttributes.ItemsAttributes() 
	
		open class ParticlesAttributes : EconEntityAttributes.MetaAttributes.ParticlesAttributes() 
	
		open class KillfeedAttributes : EconEntityAttributes.MetaAttributes.KillfeedAttributes() 
	
		open class NoisemakersAttributes : EconEntityAttributes.MetaAttributes.NoisemakersAttributes() 
	
		open class PlayerAttributes : EconEntityAttributes.MetaAttributes.PlayerAttributes() 
	
		open class GameplayAttributes : EconEntityAttributes.MetaAttributes.GameplayAttributes() 
	}
	
	open class BuffItemsAttributes : EconEntityAttributes.BuffItemsAttributes() 
	
	open class BuildingsAttributes : EconEntityAttributes.BuildingsAttributes() {
		override val sentryGun: SentryGunAttributes = SentryGunAttributes()
	
		override val dispenser: DispenserAttributes = DispenserAttributes()
	
		override val teleporter: TeleporterAttributes = TeleporterAttributes()
	
		open class SentryGunAttributes : EconEntityAttributes.BuildingsAttributes.SentryGunAttributes() 
	
		open class DispenserAttributes : EconEntityAttributes.BuildingsAttributes.DispenserAttributes() 
	
		open class TeleporterAttributes : EconEntityAttributes.BuildingsAttributes.TeleporterAttributes() 
	}
	
	open class CloakAttributes : EconEntityAttributes.CloakAttributes() 
	
	open class DamageAttributes : EconEntityAttributes.DamageAttributes() {
		override val alien: AlienAttributes = AlienAttributes()
	
		open class AlienAttributes : EconEntityAttributes.DamageAttributes.AlienAttributes() 
	}
	
	open class DemoChargeAttributes : EconEntityAttributes.DemoChargeAttributes() {
		override val multChargeTurnControl: MultChargeTurnControlAttributes = MultChargeTurnControlAttributes()
	
		open class MultChargeTurnControlAttributes : EconEntityAttributes.DemoChargeAttributes.MultChargeTurnControlAttributes() 
	}
	
	open class DisguiseAttributes : EconEntityAttributes.DisguiseAttributes() 
	
	open class FiringAttributes : EconEntityAttributes.FiringAttributes() 
	
	open class HeadsAttributes : EconEntityAttributes.HeadsAttributes() 
	
	open class HealthAndHealingAttributes : EconEntityAttributes.HealthAndHealingAttributes() {
		override val healthRegen: HealthRegenAttributes = HealthRegenAttributes()
	
		override val maxHealthAdditiveBonus: MaxHealthAdditiveAttributes = MaxHealthAdditiveAttributes()
	
		open class HealthRegenAttributes : EconEntityAttributes.HealthAndHealingAttributes.HealthRegenAttributes() 
	
		open class MaxHealthAdditiveAttributes : EconEntityAttributes.HealthAndHealingAttributes.MaxHealthAdditiveAttributes() 
	}
	
	open class HudAttributes : EconEntityAttributes.HudAttributes() 
	
	open class KnockbackReceivedAttributes : EconEntityAttributes.KnockbackReceivedAttributes() 
	
	open class MeterAttributes : EconEntityAttributes.MeterAttributes() {
		override val generateRageOnDamage: GenerateRageOnDamageAttributes = GenerateRageOnDamageAttributes()
	
		open class GenerateRageOnDamageAttributes : EconEntityAttributes.MeterAttributes.GenerateRageOnDamageAttributes() 
	}
	
	open class MovementAttributes : EconEntityAttributes.MovementAttributes() {
		override val increasedJumpHeight: jumpHeightAttributes = jumpHeightAttributes()
	
		override val moveSpeed: MoveSpeedAttributes = MoveSpeedAttributes()
	
		open class jumpHeightAttributes : EconEntityAttributes.MovementAttributes.jumpHeightAttributes() 
	
		open class MoveSpeedAttributes : EconEntityAttributes.MovementAttributes.MoveSpeedAttributes() {
			override val aimingMovespeedIncreased: AimingMovespeedAttributes = AimingMovespeedAttributes()
	
			override val moveSpeedPenalty: MoveSpeedAttributes = MoveSpeedAttributes()
	
			open class AimingMovespeedAttributes : EconEntityAttributes.MovementAttributes.MoveSpeedAttributes.AimingMovespeedAttributes() 
	
			open class MoveSpeedAttributes : EconEntityAttributes.MovementAttributes.MoveSpeedAttributes.MoveSpeedAttributes() 
		}
	}
	
	open class OnHitAttributes : EconEntityAttributes.OnHitAttributes() {
		override val falling: FallingAttributes = FallingAttributes()
	
		open class FallingAttributes : EconEntityAttributes.OnHitAttributes.FallingAttributes() 
	}
	
	open class OnKillAttributes : EconEntityAttributes.OnKillAttributes() 
	
	open class ResistanceAttributes : EconEntityAttributes.ResistanceAttributes() {
		override val dmgTakenFromCritReduced: DmgTakenFromCritReducedAttributes = DmgTakenFromCritReducedAttributes()
	
		override val dmgTakenFromFireReduced: DmgTakenFromFireReducedAttributes = DmgTakenFromFireReducedAttributes()
	
		override val dmgTakenFromBulletsReduced: DmgTakenFromBulletsReducedAttributes = DmgTakenFromBulletsReducedAttributes()
	
		override val vaccinator: VaccinatorAttributes = VaccinatorAttributes()
	
		open class DmgTakenFromCritReducedAttributes : EconEntityAttributes.ResistanceAttributes.DmgTakenFromCritReducedAttributes() 
	
		open class DmgTakenFromFireReducedAttributes : EconEntityAttributes.ResistanceAttributes.DmgTakenFromFireReducedAttributes() 
	
		open class DmgTakenFromBulletsReducedAttributes : EconEntityAttributes.ResistanceAttributes.DmgTakenFromBulletsReducedAttributes() 
	
		open class VaccinatorAttributes : EconEntityAttributes.ResistanceAttributes.VaccinatorAttributes() 
	}
	
	open class TauntingAttributes : EconEntityAttributes.TauntingAttributes() 
	
	open class SwapWeaponsAttributes : EconEntityAttributes.SwapWeaponsAttributes() 
	
	open class WhenHitAttributes : EconEntityAttributes.WhenHitAttributes() 
	
	open class SpyOnlyAttributes : EconEntityAttributes.SpyOnlyAttributes() 
	
	open class CritsAttributes : EconEntityAttributes.CritsAttributes() 
	
	object Inherited : BaseCombatWeaponAttributes 
}