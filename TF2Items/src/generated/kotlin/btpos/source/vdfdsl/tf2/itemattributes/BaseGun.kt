package btpos.source.vdfdsl.tf2.itemattributes

import btpos.source.vdfdsl.modeling.*
import btpos.source.vdfdsl.serialization.*
import btpos.source.vdfdsl.serialization.codecs.*
import btpos.source.vdfdsl.tf2.itemattributes.impl.*
import btpos.source.vdfdsl.tf2.tftypes.*
import java.util.*
import kotlin.time.Duration

interface BaseGunAttributes : IBlockScoped, WeaponBaseAttributes {
	companion object : IBlockScoped {
		/**
		 * Attributes related to max ammo, clip-size, and resupply.
		 */
		val ammo: AmmoAttributes = AmmoAttributes()
	
		/**
		 * Multipliers governing the damage you deal to different targets.
		 * 
		 * For damage _taken_, see [resistance].
		 */
		val damage: DamageAttributes = DamageAttributes()
	
		/**
		 * Attributes governing rate-of-fire.
		 */
		val firing: FiringAttributes = FiringAttributes()
	
		/**
		 * All attributes governing what projectile or bullet this weapon can fire, and how that projectile or bullet acts once fired.
		 * 
		 * Each type of projectile also has a subcategory with every attribute it checks for on the gun that fired it.
		 */
		val projectiles: ProjectilesAttributes = ProjectilesAttributes()
	
		/**
		 * Attributes related to afterburn.
		 */
		private val afterburn: AfterburnAttributes = AfterburnAttributes()
	
		/**
		 * Attributes related to moving, constructing, and interacting with the Engineer's buildings.
		 */
		private val buildings: BuildingsAttributes = BuildingsAttributes()
	
		/**
		 * Attributes related to dealing or preventing critical hits and mini-crits.
		 */
		private val crits: CritsAttributes = CritsAttributes()
	
		/**
		 * Attributes governing the Demoknight's shield-charge.
		 * 
		 * Some of these attributes are hardcoded to only work on the Demoman. These are noted in their documentation.
		 */
		private val demoCharge: DemoChargeAttributes = DemoChargeAttributes()
	
		/**
		 * Attributes related to the player's HP stat and healing players.
		 */
		private val healthAndHealing: HealthAndHealingAttributes = HealthAndHealingAttributes()
	
		/**
		 * Attributes governing how much you are pushed when hit by different push sources.
		 */
		private val knockbackReceived: KnockbackReceivedAttributes = KnockbackReceivedAttributes()
	
		/**
		 * Attributes related to the scoreboard, killfeed, HuD, item descriptions, and interactions with the wider game-state. (including capture rate)
		 */
		private val meta: MetaAttributes = MetaAttributes()
	
		/**
		 * Attributes related to rage and items that recharge on a meter/timer.
		 */
		private val meter: MeterAttributes = MeterAttributes()
	
		/**
		 * Attributes governing the player's move-speed, jump height, swimming, air-strafing capabilities, and all things mobility-related.
		 */
		private val movement: MovementAttributes = MovementAttributes()
	
		/**
		 * Attributes related to the collection and passive effects of "heads".
		 * 
		 * While originally made for the Eyelander, this stat is used by many other weapons that track players hit or killed: the Vita-Saw, the Bazaar Bargain, etc.
		 * 
		 * For "revenge crits", like the Frontier Justice, Manmelter, and Diamondback, see [revengeCrits].
		 */
		private val heads: HeadsAttributes = HeadsAttributes()
	
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
		 * Attributes governing either the time taken to reload a weapon's magazine or the cooldown time for weapons that draw directly from reserve ammo like the Sniper Rifle and Flare Gun.
		 */
		private val reloading: ReloadingAttributes = ReloadingAttributes()
	
		/**
		 * Attributes governing how much damage the player takes from various sources.  Also includes the passive and active effects of the Vaccinator on the user.
		 * 
		 * For outgoing damage, see [damage].
		 */
		private val resistance: ResistanceAttributes = ResistanceAttributes()
	
		/**
		 * Attributes governing the collection of "Revenge Crits", guaranteed criticals gained by fulfilling certain requirements.
		 * 
		 * It should be noted that for the most part, these attributes just state whether or not a weapon CAN gain revenge crits. Actually _using_ them is bound to the weapon type, not any attribute.
		 * 
		 * For the collection and usage of "heads", see [heads].
		 */
		private val revengeCrits: RevengeCritsAttributes = RevengeCritsAttributes()
	
		/**
		 * Attributes related to Mad Milk, Jarate, and Gas.
		 * 
		 * This will be empty for most weapons unless a mod adds something.  Notably, "explode on ignite" is available for all weapons.
		 */
		private val statusEffects: StatusEffectsAttributes = StatusEffectsAttributes()
	
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
	
		/**
		 * Attributes governing ragdolls, gibs, and statues.
		 */
		private val ragdolls: RagdollsAttributes = RagdollsAttributes()
	
		private val buffItems: BuffItemsAttributes = BuffItemsAttributes()
	
		private val cloak: CloakAttributes = CloakAttributes()
	
		/**
		 * Attributes related to disguising.
		 */
		private val disguise: DisguiseAttributes = DisguiseAttributes()
	
		private val hud: HudAttributes = HudAttributes()
	
		private val spyOnly: SpyOnlyAttributes = SpyOnlyAttributes()
	}
	
	/**
	 * Attributes related to max ammo, clip-size, and resupply.
	 */
	override val ammo: AmmoAttributes get() = BaseGunAttributes.ammo
	
	/**
	 * Multipliers governing the damage you deal to different targets.
	 * 
	 * For damage _taken_, see [resistance].
	 */
	override val damage: DamageAttributes get() = BaseGunAttributes.damage
	
	/**
	 * Attributes governing rate-of-fire.
	 */
	override val firing: FiringAttributes get() = BaseGunAttributes.firing
	
	/**
	 * All attributes governing what projectile or bullet this weapon can fire, and how that projectile or bullet acts once fired.
	 * 
	 * Each type of projectile also has a subcategory with every attribute it checks for on the gun that fired it.
	 */
	override val projectiles: ProjectilesAttributes get() = BaseGunAttributes.projectiles
	
	/**
	 * Attributes related to afterburn.
	 */
	override val afterburn: AfterburnAttributes get() = BaseGunAttributes.afterburn
	
	/**
	 * Attributes related to moving, constructing, and interacting with the Engineer's buildings.
	 */
	override val buildings: BuildingsAttributes get() = BaseGunAttributes.buildings
	
	/**
	 * Attributes related to dealing or preventing critical hits and mini-crits.
	 */
	override val crits: CritsAttributes get() = BaseGunAttributes.crits
	
	/**
	 * Attributes governing the Demoknight's shield-charge.
	 * 
	 * Some of these attributes are hardcoded to only work on the Demoman. These are noted in their documentation.
	 */
	override val demoCharge: DemoChargeAttributes get() = BaseGunAttributes.demoCharge
	
	/**
	 * Attributes related to the player's HP stat and healing players.
	 */
	override val healthAndHealing: HealthAndHealingAttributes get() = BaseGunAttributes.healthAndHealing
	
	/**
	 * Attributes governing how much you are pushed when hit by different push sources.
	 */
	override val knockbackReceived: KnockbackReceivedAttributes get() = BaseGunAttributes.knockbackReceived
	
	/**
	 * Attributes related to the scoreboard, killfeed, HuD, item descriptions, and interactions with the wider game-state. (including capture rate)
	 */
	override val meta: MetaAttributes get() = BaseGunAttributes.meta
	
	/**
	 * Attributes related to rage and items that recharge on a meter/timer.
	 */
	override val meter: MeterAttributes get() = BaseGunAttributes.meter
	
	/**
	 * Attributes governing the player's move-speed, jump height, swimming, air-strafing capabilities, and all things mobility-related.
	 */
	override val movement: MovementAttributes get() = BaseGunAttributes.movement
	
	/**
	 * Attributes related to the collection and passive effects of "heads".
	 * 
	 * While originally made for the Eyelander, this stat is used by many other weapons that track players hit or killed: the Vita-Saw, the Bazaar Bargain, etc.
	 * 
	 * For "revenge crits", like the Frontier Justice, Manmelter, and Diamondback, see [revengeCrits].
	 */
	override val heads: HeadsAttributes get() = BaseGunAttributes.heads
	
	/**
	 * Attributes governing what happens when you hit another player, such as applying conditions or debuffs.
	 * 
	 * @see onKill
	 */
	override val onHit: OnHitAttributes get() = BaseGunAttributes.onHit
	
	/**
	 * Attributes governing what happens when you kill another player, usually applying bonuses to yourself.
	 * 
	 * @see onHit
	 */
	override val onKill: OnKillAttributes get() = BaseGunAttributes.onKill
	
	/**
	 * Attributes governing either the time taken to reload a weapon's magazine or the cooldown time for weapons that draw directly from reserve ammo like the Sniper Rifle and Flare Gun.
	 */
	override val reloading: ReloadingAttributes get() = BaseGunAttributes.reloading
	
	/**
	 * Attributes governing how much damage the player takes from various sources.  Also includes the passive and active effects of the Vaccinator on the user.
	 * 
	 * For outgoing damage, see [damage].
	 */
	override val resistance: ResistanceAttributes get() = BaseGunAttributes.resistance
	
	/**
	 * Attributes governing the collection of "Revenge Crits", guaranteed criticals gained by fulfilling certain requirements.
	 * 
	 * It should be noted that for the most part, these attributes just state whether or not a weapon CAN gain revenge crits. Actually _using_ them is bound to the weapon type, not any attribute.
	 * 
	 * For the collection and usage of "heads", see [heads].
	 */
	override val revengeCrits: RevengeCritsAttributes get() = BaseGunAttributes.revengeCrits
	
	/**
	 * Attributes related to Mad Milk, Jarate, and Gas.
	 * 
	 * This will be empty for most weapons unless a mod adds something.  Notably, "explode on ignite" is available for all weapons.
	 */
	override val statusEffects: StatusEffectsAttributes get() = BaseGunAttributes.statusEffects
	
	/**
	 * Attributes governing taunt speed and the effects of taunts.
	 */
	override val taunting: TauntingAttributes get() = BaseGunAttributes.taunting
	
	/**
	 * Attributes governing weapon deploy/holster speed, things that activate when a weapon is deployed, and whether a player can swap weapons at all.
	 */
	override val swapWeapons: SwapWeaponsAttributes get() = BaseGunAttributes.swapWeapons
	
	/**
	 * Attributes governing what happens when this player is hit by an enemy.
	 * 
	 * For what happens when _this player_ hits an enemy, see [onHit] and [onKill].
	 */
	override val whenHit: WhenHitAttributes get() = BaseGunAttributes.whenHit
	
	/**
	 * Attributes governing ragdolls, gibs, and statues.
	 */
	override val ragdolls: RagdollsAttributes get() = BaseGunAttributes.ragdolls
	
	override val buffItems: BuffItemsAttributes get() = BaseGunAttributes.buffItems
	
	override val cloak: CloakAttributes get() = BaseGunAttributes.cloak
	
	/**
	 * Attributes related to disguising.
	 */
	override val disguise: DisguiseAttributes get() = BaseGunAttributes.disguise
	
	override val hud: HudAttributes get() = BaseGunAttributes.hud
	
	override val spyOnly: SpyOnlyAttributes get() = BaseGunAttributes.spyOnly
	
	open class AmmoAttributes : WeaponBaseAttributes.AmmoAttributes() {
		/**
		 * In-Game: "Per Shot: -N ammo"
		 * 
		 * How much ammo is used per shot. If 0, uses default.
		 */
		open val ammoPerShot: ItemAttributeNamed<Int> = ItemAttributeNamed("mod ammo per shot")
	
		override val clipSize: ClipSizeAttributes = ClipSizeAttributes()
	
		override val multMaxAmmo: MaxAmmoAttributes = MaxAmmoAttributes()
	
		open class ClipSizeAttributes : WeaponBaseAttributes.AmmoAttributes.ClipSizeAttributes() 
	
		open class MaxAmmoAttributes : WeaponBaseAttributes.AmmoAttributes.MaxAmmoAttributes() 
	}
	
	open class DamageAttributes : WeaponBaseAttributes.DamageAttributes() {
		/**
		 * In-Game: "+N% damage bonus while disguised"
		 * 
		 * When disguised (only checks if the player has the condition, doesn't check class), multiply damage by this amount.
		 */
		open val multDmgWhileDisguised: ItemAttributeNamed<Number> = ItemAttributeNamed("damage bonus while disguised")
	
		/**
		 * In-Game: "Gains a damage bonus as rage increases, up to N%"
		 * 
		 * If you're a Soldier or Pyro, increases damage by `(n - 1) * (rage gauge proportion)`.
		 */
		open val rageDamageBoost: ItemAttributeNamed<Number> = ItemAttributeNamed("mod rage damage boost")
	
		/**
		 * In-Game: "While a medic is healing you, this weapon's damage is increased by N%"
		 * 
		 * Multiply damage by this value once for each healer you have. (with 2 healers, that's `bonus * bonus`, exponential).
		 */
		open val multDmgPerHealer: ItemAttributeNamed<Number> = ItemAttributeNamed("mod medic healed damage bonus")
	
		/**
		 * In-Game: "Accuracy scales damage"
		 * 
		 * If the projectile being fired is a bullet, multiply damage by your hit ratio over the past few seconds.
		 */
		open val accuracyDamageMultiplier: ItemAttributeNamed<Number> = ItemAttributeNamed("accuracy scales damage")
	
		override val alien: AlienAttributes = AlienAttributes()
	
		open class AlienAttributes : WeaponBaseAttributes.DamageAttributes.AlienAttributes() 
	}
	
	open class FiringAttributes : WeaponBaseAttributes.FiringAttributes() {
		override val fireRate: FireRateAttributes = FireRateAttributes()
	
		open class FireRateAttributes : WeaponBaseAttributes.FiringAttributes.FireRateAttributes() {
			/**
			 * Multiplier applied to base fire delay for miniguns.
			 * 
			 * Checked on player.
			 */
			open val halloweenFireRateBonus: ItemAttributeNamed<Number> = ItemAttributeNamed("halloween fire rate bonus")
	
			/**
			 * In-Game: "Fire rate increases as health decreases"
			 * 
			 * Used with the pre-Blue Moon Panic Attack.
			 */
			open val fireRateBonusWithReducedHealth: ItemAttributeNamed<Number> = ItemAttributeNamed("fire rate bonus with reduced health")
	
			/**
			 * In-Game: "Increased attack speed and smaller blast radius while blast jumping"
			 * 
			 * Multiplier to fire delay while player is blast-jumping.
			 * 
			 * If set on anything that fires a rocket, the rocket assumes it was fired by the Air Strike and reduces blast radius to 80% of its normal range.
			 */
			open val rocketjumpAttackrateBonus: ItemAttributeNamed<Number> = ItemAttributeNamed("rocketjump attackrate bonus")
		}
	}
	
	open class ProjectilesAttributes : WeaponBaseAttributes.ProjectilesAttributes() {
		/**
		 * In-Game: "Overrides the projectile fired from the weapon. Takes values from 1 to 26, each representing a different projectile, and not all projectiles work on all weapons"
		 * 
		 * If unset, uses the weapon's default projectile type.
		 */
		open val overrideType: ItemAttributeNamed<TFProjectileType> = ItemAttributeNamed("override projectile type")
	
		/**
		 * In-Game: "+N degrees random projectile deviation"
		 * 
		 * Also applicable to stickies.
		 */
		override val spreadAnglePenalty: ItemAttributeNamed<Number> get() = super.spreadAnglePenalty
	
		/**
		 * Bonus:
		 * 
		 * 	- In-Game: "+N% projectile range"
		 * 
		 * Penalty:
		 * 
		 * 	- In-Game: "N% projectile range"
		 */
		open val multRange: BonusPenalty<Number> = BonusPenalty(
		    ItemAttributeNamed("Projectile range increased"),
		    ItemAttributeNamed("Projectile range decreased"),
		)
	
		/**
		 * Don't do tumble on tumbling projectiles.
		 */
		open val grenadeNoSpin: ItemAttributeNamed<Boolean> = ItemAttributeNamed("grenade no spin")
	
		override val bullets: BulletsAttributes = BulletsAttributes()
	
		/**
		 * How many players your "projectile" (*including bullets*) should penetrate.
		 */
		override val penetration: ProjectilePenetrationAttributes = ProjectilePenetrationAttributes()
	
		open class BulletsAttributes : WeaponBaseAttributes.ProjectilesAttributes.BulletsAttributes() {
			/**
			 * Bonus:
			 * 
			 * 	- In-Game: "N% more accurate"
			 * 
			 * Penalty:
			 * 
			 * 	- In-Game: "N% less accurate"
			 */
			open val multBulletSpread: BonusPenalty<Number> = BonusPenalty(
			    ItemAttributeNamed("weapon spread bonus"),
			    ItemAttributeNamed("spread penalty"),
			)
	
			/**
			 * In-Game: "Weapon spread increases as health decreases"
			 * 
			 * Multiplier applied to bullet spread as health gets lower.
			 */
			open val multSpreadAsHealthDecreases: ItemAttributeNamed<Number> = ItemAttributeNamed("panic_attack_negative")
	
			/**
			 * In-Game: "Successive shots become less accurate"
			 * 
			 * Scales weapon spread when firing consecutive shots, like the post-"Blue Moon" Panic Attack.
			 */
			open val spreadIncreasesOnConsecutiveShots: ItemAttributeNamed<Number> = ItemAttributeNamed("mult_spread_scales_consecutive")
	
			/**
			 * By default, all guns have perfect accuracy on the first shot, unless this is set.
			 */
			open val multBulletSpreadFirstShot: ItemAttributeNamed<Number> = ItemAttributeNamed("mult_spread_scale_first_shot")
	
			/**
			 * In-Game: "Fires a wide, fixed shot pattern"
			 * 
			 * Enables fixed weapon spread on the weapon as though `tf_use_fixed_weaponspreads` were set.
			 */
			open val fixedWeaponSpread: ItemAttributeNamed<Boolean> = ItemAttributeNamed("fixed_shot_pattern")
		}
	
		open class ProjectilePenetrationAttributes : WeaponBaseAttributes.ProjectilesAttributes.ProjectilePenetrationAttributes(), ItemAttribute<Int> 
	}
	
	open class AfterburnAttributes : WeaponBaseAttributes.AfterburnAttributes() 
	
	open class BuildingsAttributes : WeaponBaseAttributes.BuildingsAttributes() {
		override val sentryGun: SentryGunAttributes = SentryGunAttributes()
	
		override val dispenser: DispenserAttributes = DispenserAttributes()
	
		override val teleporter: TeleporterAttributes = TeleporterAttributes()
	
		open class SentryGunAttributes : WeaponBaseAttributes.BuildingsAttributes.SentryGunAttributes() 
	
		open class DispenserAttributes : WeaponBaseAttributes.BuildingsAttributes.DispenserAttributes() 
	
		open class TeleporterAttributes : WeaponBaseAttributes.BuildingsAttributes.TeleporterAttributes() 
	}
	
	open class CritsAttributes : WeaponBaseAttributes.CritsAttributes() 
	
	open class DemoChargeAttributes : WeaponBaseAttributes.DemoChargeAttributes() {
		/**
		 * Default is 0.45f, and this is a multiplier applied to it.
		 */
		override val multChargeTurnControl: ChargeTurnControlAttributes = ChargeTurnControlAttributes()
	
		open class ChargeTurnControlAttributes : WeaponBaseAttributes.DemoChargeAttributes.ChargeTurnControlAttributes(), ItemAttribute<Number> 
	}
	
	open class HealthAndHealingAttributes : WeaponBaseAttributes.HealthAndHealingAttributes() {
		/**
		 * Amount of health regenerated per regen tick.  Scales by the amount of time since the player last took damage in non-MvM modes.
		 */
		override val healthRegenPerSecond: AddHealthRegenAttributes = AddHealthRegenAttributes()
	
		/**
		 * Additive maximum health increase. Influences the player's overheal cap.
		 */
		override val addMaxHealth: AddMaxhealthAttributes = AddMaxhealthAttributes()
	
		open class AddHealthRegenAttributes : WeaponBaseAttributes.HealthAndHealingAttributes.AddHealthRegenAttributes(), ItemAttribute<Int> 
	
		open class AddMaxhealthAttributes : WeaponBaseAttributes.HealthAndHealingAttributes.AddMaxhealthAttributes(), ItemAttribute<Int> 
	}
	
	open class KnockbackReceivedAttributes : WeaponBaseAttributes.KnockbackReceivedAttributes() {
		/**
		 * Attribute class is a flat multiplier applied to push force received from damage.
		 */
		override val damageForceReduction: DamageForceReductionAttributes = DamageForceReductionAttributes()
	
		open class DamageForceReductionAttributes : WeaponBaseAttributes.KnockbackReceivedAttributes.DamageForceReductionAttributes() 
	}
	
	open class MetaAttributes : WeaponBaseAttributes.MetaAttributes() {
		override val killfeed: KillfeedAttributes = KillfeedAttributes()
	
		override val viewmodel: ViewmodelAttributes = ViewmodelAttributes()
	
		override val items: ItemsAttributes = ItemsAttributes()
	
		override val particles: ParticlesAttributes = ParticlesAttributes()
	
		override val noisemakers: NoisemakersAttributes = NoisemakersAttributes()
	
		override val player: PlayerAttributes = PlayerAttributes()
	
		override val gameplay: GameplayAttributes = GameplayAttributes()
	
		open class KillfeedAttributes : WeaponBaseAttributes.MetaAttributes.KillfeedAttributes() 
	
		open class ViewmodelAttributes : WeaponBaseAttributes.MetaAttributes.ViewmodelAttributes() 
	
		open class ItemsAttributes : WeaponBaseAttributes.MetaAttributes.ItemsAttributes() 
	
		open class ParticlesAttributes : WeaponBaseAttributes.MetaAttributes.ParticlesAttributes() 
	
		open class NoisemakersAttributes : WeaponBaseAttributes.MetaAttributes.NoisemakersAttributes() 
	
		open class PlayerAttributes : WeaponBaseAttributes.MetaAttributes.PlayerAttributes() 
	
		open class GameplayAttributes : WeaponBaseAttributes.MetaAttributes.GameplayAttributes() 
	}
	
	open class MeterAttributes : WeaponBaseAttributes.MeterAttributes() {
		/**
		 * Only works on Engineer and Heavy.
		 * 
		 * On Engineer, adds all damage dealt to the rage meter.
		 * 
		 * On Heavy, adds `0.22` * the damage to the meter, and reduces damage by 50% while the meter is draining.
		 */
		override val generateRageOnDmg: GenerateRageOnDmgAttributes = GenerateRageOnDmgAttributes()
	
		open class GenerateRageOnDmgAttributes : WeaponBaseAttributes.MeterAttributes.GenerateRageOnDmgAttributes(), ItemAttribute<Boolean> 
	}
	
	open class MovementAttributes : WeaponBaseAttributes.MovementAttributes() {
		override val moveSpeed: MoveSpeedAttributes = MoveSpeedAttributes()
	
		override val multJumpHeight: ModJumpHeightAttributes = ModJumpHeightAttributes()
	
		open class MoveSpeedAttributes : WeaponBaseAttributes.MovementAttributes.MoveSpeedAttributes() {
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
	
			open class MultPlayerAimingMovespeedAttributes : WeaponBaseAttributes.MovementAttributes.MoveSpeedAttributes.MultPlayerAimingMovespeedAttributes() 
	
			open class MultPlayerMovespeedAttributes : WeaponBaseAttributes.MovementAttributes.MoveSpeedAttributes.MultPlayerMovespeedAttributes(), ItemAttribute<Number> 
		}
	
		open class ModJumpHeightAttributes : WeaponBaseAttributes.MovementAttributes.ModJumpHeightAttributes(), ItemAttribute<Number> 
	}
	
	open class HeadsAttributes : WeaponBaseAttributes.HeadsAttributes() 
	
	open class OnHitAttributes : WeaponBaseAttributes.OnHitAttributes() {
		/**
		 * Add this amount of health on hit.
		 */
		override val addOnhitAddhealth: AddOnhitAddhealthAttributes = AddOnhitAddhealthAttributes()
	
		/**
		 * Knockback rage on enemy if you're a heavy and your rage is draining.
		 */
		override val generateRageOnDmg: GenerateRageOnDmgAttributes = GenerateRageOnDmgAttributes()
	
		override val falling: FallingAttributes = FallingAttributes()
	
		open class AddOnhitAddhealthAttributes : WeaponBaseAttributes.OnHitAttributes.AddOnhitAddhealthAttributes() 
	
		open class GenerateRageOnDmgAttributes : WeaponBaseAttributes.OnHitAttributes.GenerateRageOnDmgAttributes(), ItemAttribute<Boolean> 
	
		open class FallingAttributes : WeaponBaseAttributes.OnHitAttributes.FallingAttributes() 
	}
	
	open class OnKillAttributes : WeaponBaseAttributes.OnKillAttributes() 
	
	open class ReloadingAttributes : WeaponBaseAttributes.ReloadingAttributes() 
	
	open class ResistanceAttributes : WeaponBaseAttributes.ResistanceAttributes() {
		override val multDmgTakenCrits: MultDmgtakenFromCritAttributes = MultDmgtakenFromCritAttributes()
	
		override val multDmgTakenFire: MultDmgtakenFromFireAttributes = MultDmgtakenFromFireAttributes()
	
		override val multDmgTakenBullets: MultDmgtakenFromBulletsAttributes = MultDmgtakenFromBulletsAttributes()
	
		override val vaccinator: VaccinatorAttributes = VaccinatorAttributes()
	
		open class MultDmgtakenFromCritAttributes : WeaponBaseAttributes.ResistanceAttributes.MultDmgtakenFromCritAttributes(), ItemAttribute<Number> 
	
		open class MultDmgtakenFromFireAttributes : WeaponBaseAttributes.ResistanceAttributes.MultDmgtakenFromFireAttributes(), ItemAttribute<Number> 
	
		open class MultDmgtakenFromBulletsAttributes : WeaponBaseAttributes.ResistanceAttributes.MultDmgtakenFromBulletsAttributes(), ItemAttribute<Number> 
	
		open class VaccinatorAttributes : WeaponBaseAttributes.ResistanceAttributes.VaccinatorAttributes() 
	}
	
	open class RevengeCritsAttributes : WeaponBaseAttributes.RevengeCritsAttributes() 
	
	open class StatusEffectsAttributes : WeaponBaseAttributes.StatusEffectsAttributes() 
	
	open class TauntingAttributes : WeaponBaseAttributes.TauntingAttributes() 
	
	open class SwapWeaponsAttributes : WeaponBaseAttributes.SwapWeaponsAttributes() {
		override val deploy: DeployAttributes = DeployAttributes()
	
		open class DeployAttributes : WeaponBaseAttributes.SwapWeaponsAttributes.DeployAttributes() 
	}
	
	open class WhenHitAttributes : WeaponBaseAttributes.WhenHitAttributes() 
	
	open class RagdollsAttributes : WeaponBaseAttributes.RagdollsAttributes() 
	
	open class BuffItemsAttributes : WeaponBaseAttributes.BuffItemsAttributes() 
	
	open class CloakAttributes : WeaponBaseAttributes.CloakAttributes() 
	
	open class DisguiseAttributes : WeaponBaseAttributes.DisguiseAttributes() 
	
	open class HudAttributes : WeaponBaseAttributes.HudAttributes() 
	
	open class SpyOnlyAttributes : WeaponBaseAttributes.SpyOnlyAttributes() 
	
	object Inherited : BaseGunAttributes 
}