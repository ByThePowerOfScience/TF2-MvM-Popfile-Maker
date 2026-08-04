package btpos.source.vdfdsl.tf2.itemattributes

import btpos.source.vdfdsl.modeling.*
import btpos.source.vdfdsl.serialization.codecs.*
import btpos.source.vdfdsl.tf2.itemattributes.impl.*
import btpos.source.vdfdsl.tf2.tftypes.*
import java.util.*
import kotlin.time.Duration

interface WearableAttributes : IBlockScoped, EconEntityAttributes {
	companion object : IBlockScoped {
		/**
		 * Attributes governing how much damage the player takes from various sources.  Also includes the passive and active effects of the Vaccinator on the user.
		 * 
		 * For outgoing damage, see [damage].
		 */
		val resistance: ResistanceAttributes = ResistanceAttributes()
	
		/**
		 * Attributes related to the scoreboard, killfeed, HuD, item descriptions, and interactions with the wider game-state. (including capture rate)
		 */
		val meta: MetaAttributes = MetaAttributes()
	
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
	override val resistance: ResistanceAttributes get() = WearableAttributes.resistance
	
	/**
	 * Attributes related to the scoreboard, killfeed, HuD, item descriptions, and interactions with the wider game-state. (including capture rate)
	 */
	override val meta: MetaAttributes get() = WearableAttributes.meta
	
	/**
	 * Attributes related to max ammo, clip-size, and resupply.
	 */
	override val ammo: AmmoAttributes get() = WearableAttributes.ammo
	
	override val buffItems: BuffItemsAttributes get() = WearableAttributes.buffItems
	
	/**
	 * Attributes related to moving, constructing, and interacting with the Engineer's buildings.
	 */
	override val buildings: BuildingsAttributes get() = WearableAttributes.buildings
	
	override val cloak: CloakAttributes get() = WearableAttributes.cloak
	
	/**
	 * Multipliers governing the damage you deal to different targets.
	 * 
	 * For damage _taken_, see [resistance].
	 */
	override val damage: DamageAttributes get() = WearableAttributes.damage
	
	/**
	 * Attributes governing the Demoknight's shield-charge.
	 * 
	 * Some of these attributes are hardcoded to only work on the Demoman. These are noted in their documentation.
	 */
	override val demoCharge: DemoChargeAttributes get() = WearableAttributes.demoCharge
	
	/**
	 * Attributes related to disguising.
	 */
	override val disguise: DisguiseAttributes get() = WearableAttributes.disguise
	
	/**
	 * Attributes governing rate-of-fire.
	 */
	override val firing: FiringAttributes get() = WearableAttributes.firing
	
	/**
	 * Attributes related to the collection and passive effects of "heads".
	 * 
	 * While originally made for the Eyelander, this stat is used by many other weapons that track players hit or killed: the Vita-Saw, the Bazaar Bargain, etc.
	 * 
	 * For "revenge crits", like the Frontier Justice, Manmelter, and Diamondback, see [revengeCrits].
	 */
	override val heads: HeadsAttributes get() = WearableAttributes.heads
	
	/**
	 * Attributes related to the player's HP stat and healing players.
	 */
	override val healthAndHealing: HealthAndHealingAttributes get() = WearableAttributes.healthAndHealing
	
	override val hud: HudAttributes get() = WearableAttributes.hud
	
	/**
	 * Attributes governing how much you are pushed when hit by different push sources.
	 */
	override val knockbackReceived: KnockbackReceivedAttributes get() = WearableAttributes.knockbackReceived
	
	/**
	 * Attributes related to rage and items that recharge on a meter/timer.
	 */
	override val meter: MeterAttributes get() = WearableAttributes.meter
	
	/**
	 * Attributes governing the player's move-speed, jump height, swimming, air-strafing capabilities, and all things mobility-related.
	 */
	override val movement: MovementAttributes get() = WearableAttributes.movement
	
	/**
	 * Attributes governing what happens when you hit another player, such as applying conditions or debuffs.
	 * 
	 * @see onKill
	 */
	override val onHit: OnHitAttributes get() = WearableAttributes.onHit
	
	/**
	 * Attributes governing what happens when you kill another player, usually applying bonuses to yourself.
	 * 
	 * @see onHit
	 */
	override val onKill: OnKillAttributes get() = WearableAttributes.onKill
	
	/**
	 * Attributes governing taunt speed and the effects of taunts.
	 */
	override val taunting: TauntingAttributes get() = WearableAttributes.taunting
	
	/**
	 * Attributes governing weapon deploy/holster speed, things that activate when a weapon is deployed, and whether a player can swap weapons at all.
	 */
	override val swapWeapons: SwapWeaponsAttributes get() = WearableAttributes.swapWeapons
	
	/**
	 * Attributes governing what happens when this player is hit by an enemy.
	 * 
	 * For what happens when _this player_ hits an enemy, see [onHit] and [onKill].
	 */
	override val whenHit: WhenHitAttributes get() = WearableAttributes.whenHit
	
	override val spyOnly: SpyOnlyAttributes get() = WearableAttributes.spyOnly
	
	/**
	 * Attributes related to dealing or preventing critical hits and mini-crits.
	 */
	override val crits: CritsAttributes get() = WearableAttributes.crits
	
	open class ResistanceAttributes : EconEntityAttributes.ResistanceAttributes() {
		/**
		 * In-Game: "Immune to the effects of afterburn."
		 * 
		 * For the base "`Wearable`", only checked on Sniper.
		 */
		open val afterburnImmunity: ItemAttributeNamed<Boolean> = ItemAttributeNamed("afterburn immunity")
	
		override val dmgTakenFromCritReduced: DmgTakenFromCritReducedAttributes = DmgTakenFromCritReducedAttributes()
	
		override val dmgTakenFromFireReduced: DmgTakenFromFireReducedAttributes = DmgTakenFromFireReducedAttributes()
	
		override val dmgTakenFromBulletsReduced: DmgTakenFromBulletsReducedAttributes = DmgTakenFromBulletsReducedAttributes()
	
		override val vaccinator: VaccinatorAttributes = VaccinatorAttributes()
	
		open class DmgTakenFromCritReducedAttributes : EconEntityAttributes.ResistanceAttributes.DmgTakenFromCritReducedAttributes() 
	
		open class DmgTakenFromFireReducedAttributes : EconEntityAttributes.ResistanceAttributes.DmgTakenFromFireReducedAttributes() 
	
		open class DmgTakenFromBulletsReducedAttributes : EconEntityAttributes.ResistanceAttributes.DmgTakenFromBulletsReducedAttributes() 
	
		open class VaccinatorAttributes : EconEntityAttributes.ResistanceAttributes.VaccinatorAttributes() 
	}
	
	open class MetaAttributes : EconEntityAttributes.MetaAttributes() {
		override val player: PlayerAttributes = PlayerAttributes()
	
		override val items: ItemsAttributes = ItemsAttributes()
	
		override val particles: ParticlesAttributes = ParticlesAttributes()
	
		override val killfeed: KillfeedAttributes = KillfeedAttributes()
	
		override val noisemakers: NoisemakersAttributes = NoisemakersAttributes()
	
		override val gameplay: GameplayAttributes = GameplayAttributes()
	
		open class PlayerAttributes : EconEntityAttributes.MetaAttributes.PlayerAttributes() {
			/**
			 * Overrides the skin used for the player. (e.g. Zombie).
			 */
			open val playerSkinOverride: ItemAttributeNamed<Int> = ItemAttributeNamed("player skin override")
		}
	
		open class ItemsAttributes : EconEntityAttributes.MetaAttributes.ItemsAttributes() {
			/**
			 * In-Game: "Duck Power : N / 5"
			 * 
			 * Determines if ***BONUS DUCKSSSS*** should increment the badge level.
			 */
			open val duckBadgeLevel: ItemAttributeNamed<Int> = ItemAttributeNamed("duck badge level")
		}
	
		open class ParticlesAttributes : EconEntityAttributes.MetaAttributes.ParticlesAttributes() 
	
		open class KillfeedAttributes : EconEntityAttributes.MetaAttributes.KillfeedAttributes() 
	
		open class NoisemakersAttributes : EconEntityAttributes.MetaAttributes.NoisemakersAttributes() 
	
		open class GameplayAttributes : EconEntityAttributes.MetaAttributes.GameplayAttributes() 
	}
	
	open class AmmoAttributes : EconEntityAttributes.AmmoAttributes() {
		override val modMaxAmmo: MaxAmmoAttributes = MaxAmmoAttributes()
	
		open class MaxAmmoAttributes : EconEntityAttributes.AmmoAttributes.MaxAmmoAttributes() 
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
	
	open class TauntingAttributes : EconEntityAttributes.TauntingAttributes() 
	
	open class SwapWeaponsAttributes : EconEntityAttributes.SwapWeaponsAttributes() 
	
	open class WhenHitAttributes : EconEntityAttributes.WhenHitAttributes() 
	
	open class SpyOnlyAttributes : EconEntityAttributes.SpyOnlyAttributes() 
	
	open class CritsAttributes : EconEntityAttributes.CritsAttributes() 
	
	object Inherited : WearableAttributes 
}