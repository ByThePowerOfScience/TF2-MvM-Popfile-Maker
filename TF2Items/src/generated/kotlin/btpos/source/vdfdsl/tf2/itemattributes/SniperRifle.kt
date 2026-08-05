package btpos.source.vdfdsl.tf2.itemattributes

import btpos.source.vdfdsl.modeling.*
import btpos.source.vdfdsl.serialization.*
import btpos.source.vdfdsl.serialization.codecs.*
import btpos.source.vdfdsl.tf2.itemattributes.impl.*
import btpos.source.vdfdsl.tf2.tftypes.*
import java.util.*
import kotlin.time.Duration

interface SniperRifleAttributes : IBlockScoped, BaseGunAttributes {
	companion object : IBlockScoped {
		/**
		 * Multipliers governing the damage you deal to different targets.
		 * 
		 * For damage _taken_, see [resistance].
		 */
		val damage: DamageAttributes = DamageAttributes()
	
		/**
		 * Attributes governing what happens when you hit another player, such as applying conditions or debuffs.
		 * 
		 * @see onKill
		 */
		val onHit: OnHitAttributes = OnHitAttributes()
	
		/**
		 * In-Game: "No headshots"
		 * 
		 * 0: Normal.
		 * 
		 * 1: Sydney Sleeper.
		 * 
		 * 2: Machina.
		 * 
		 * 3: Classic.
		 */
		val cannotHeadshot: ItemAttributeNamed<Boolean> = ItemAttributeNamed("sniper no headshots", NumberSelectorCodec(1))
	
		/**
		 * If greater than 0, activates rage buff when pressing reload and rage meter is full (or above full).
		 */
		val soldierBuffType: ItemAttributeNamed<Int> = ItemAttributeNamed("mod soldier buff type")
	
		/**
		 * If greater than 0, activates rage buff when pressing reload and rage meter is full (or above full).
		 */
		val demoBuffType: ItemAttributeNamed<Int> = ItemAttributeNamed("mod demo buff type")
	
		val multSniperChargePerSec: MultSniperChargePerSecAttributes = MultSniperChargePerSecAttributes()
	
		/**
		 * In-Game: "+N% faster reload time"
		 * 
		 * Mult to zoom and unzoom delay on clipless weapons.
		 * 
		 * Fun fact: this is also affected by the Precision mannpower powerup.
		 */
		val fasterReloadRate: ItemAttributeNamed<Number> = ItemAttributeNamed("faster reload rate")
	
		/**
		 * In-Game: "Cannot fire unless zoomed"
		 */
		val canOnlyFireWhenZoomed: ItemAttributeNamed<Boolean> = ItemAttributeNamed("sniper only fire zoomed")
	
		/**
		 * In-Game: "On Full Charge: Projectiles penetrate players"
		 */
		val penetratesWhenFullyCharged: ItemAttributeNamed<Boolean> = ItemAttributeNamed("sniper penetrate players when charged")
	
		/**
		 * In-Game: "No headshots when not fully charged"
		 */
		val cannotHeadshotWithoutFullCharge: ItemAttributeNamed<Boolean> = ItemAttributeNamed("sniper no headshot without full charge")
	
		/**
		 * In-Game: "Charge and fire shots independent of zoom"
		 * 
		 * Whether the rifle can headshot without being zoomed.
		 * 
		 * Funnily enough, it checks if your FOV is lower than your default FOV to see if you're zoomed.
		 */
		val canHeadshotUnscoped: ItemAttributeNamed<Boolean> = ItemAttributeNamed("sniper crit no scope")
	
		/**
		 * In-Game: "Increased headshot explosion radius and damage to nearby enemies"
		 * 
		 * Level of explosive headshot.
		 * 
		 * Checked on attacker.
		 */
		val explosiveHeadshotLevel: ItemAttributeNamed<Int> = ItemAttributeNamed("explosive sniper shot")
	
		/**
		 * In-Game: "On Scoped Hit: Apply Jarate for 2 to N seconds based on charge level. Nature's Call: Scoped headshots always mini-crits and reduce the remaining cooldown of Jarate by 1 second."
		 * 
		 * If greater than 0:.
		 * 
		 * Makes weapon not eject brass.
		 * 
		 * Makes weapon only penetrate non-burning teammates, as opposed to penetrating all teammates.
		 * 
		 * Note: Not actually used in Sydney Sleeper Jarate calculation, as far as I could tell.
		 */
		val jarateDuration: ItemAttributeNamed<Number> = ItemAttributeNamed("jarate duration")
	
		/**
		 * In-Game: "No flinching when aiming and fully charged"
		 * 
		 * Prevents flinching from damage when scoped and fully charged.
		 */
		val aimingNoFlinch: ItemAttributeNamed<Boolean> = ItemAttributeNamed("aiming no flinch")
	
		/**
		 * Attributes related to max ammo, clip-size, and resupply.
		 */
		private val ammo: AmmoAttributes = AmmoAttributes()
	
		/**
		 * Attributes governing rate-of-fire.
		 */
		private val firing: FiringAttributes = FiringAttributes()
	
		/**
		 * All attributes governing what projectile or bullet this weapon can fire, and how that projectile or bullet acts once fired.
		 * 
		 * Each type of projectile also has a subcategory with every attribute it checks for on the gun that fired it.
		 */
		private val projectiles: ProjectilesAttributes = ProjectilesAttributes()
	
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
	 * Multipliers governing the damage you deal to different targets.
	 * 
	 * For damage _taken_, see [resistance].
	 */
	override val damage: DamageAttributes get() = SniperRifleAttributes.damage
	
	/**
	 * Attributes governing what happens when you hit another player, such as applying conditions or debuffs.
	 * 
	 * @see onKill
	 */
	override val onHit: OnHitAttributes get() = SniperRifleAttributes.onHit
	
	/**
	 * In-Game: "No headshots"
	 * 
	 * 0: Normal.
	 * 
	 * 1: Sydney Sleeper.
	 * 
	 * 2: Machina.
	 * 
	 * 3: Classic.
	 */
	val cannotHeadshot: ItemAttributeNamed<Boolean> get() = SniperRifleAttributes.cannotHeadshot
	
	/**
	 * If greater than 0, activates rage buff when pressing reload and rage meter is full (or above full).
	 */
	val soldierBuffType: ItemAttributeNamed<Int> get() = SniperRifleAttributes.soldierBuffType
	
	/**
	 * If greater than 0, activates rage buff when pressing reload and rage meter is full (or above full).
	 */
	val demoBuffType: ItemAttributeNamed<Int> get() = SniperRifleAttributes.demoBuffType
	
	val multSniperChargePerSec: MultSniperChargePerSecAttributes get() = SniperRifleAttributes.multSniperChargePerSec
	
	/**
	 * In-Game: "+N% faster reload time"
	 * 
	 * Mult to zoom and unzoom delay on clipless weapons.
	 * 
	 * Fun fact: this is also affected by the Precision mannpower powerup.
	 */
	val fasterReloadRate: ItemAttributeNamed<Number> get() = SniperRifleAttributes.fasterReloadRate
	
	/**
	 * In-Game: "Cannot fire unless zoomed"
	 */
	val canOnlyFireWhenZoomed: ItemAttributeNamed<Boolean> get() = SniperRifleAttributes.canOnlyFireWhenZoomed
	
	/**
	 * In-Game: "On Full Charge: Projectiles penetrate players"
	 */
	val penetratesWhenFullyCharged: ItemAttributeNamed<Boolean> get() = SniperRifleAttributes.penetratesWhenFullyCharged
	
	/**
	 * In-Game: "No headshots when not fully charged"
	 */
	val cannotHeadshotWithoutFullCharge: ItemAttributeNamed<Boolean> get() = SniperRifleAttributes.cannotHeadshotWithoutFullCharge
	
	/**
	 * In-Game: "Charge and fire shots independent of zoom"
	 * 
	 * Whether the rifle can headshot without being zoomed.
	 * 
	 * Funnily enough, it checks if your FOV is lower than your default FOV to see if you're zoomed.
	 */
	val canHeadshotUnscoped: ItemAttributeNamed<Boolean> get() = SniperRifleAttributes.canHeadshotUnscoped
	
	/**
	 * In-Game: "Increased headshot explosion radius and damage to nearby enemies"
	 * 
	 * Level of explosive headshot.
	 * 
	 * Checked on attacker.
	 */
	val explosiveHeadshotLevel: ItemAttributeNamed<Int> get() = SniperRifleAttributes.explosiveHeadshotLevel
	
	/**
	 * In-Game: "On Scoped Hit: Apply Jarate for 2 to N seconds based on charge level. Nature's Call: Scoped headshots always mini-crits and reduce the remaining cooldown of Jarate by 1 second."
	 * 
	 * If greater than 0:.
	 * 
	 * Makes weapon not eject brass.
	 * 
	 * Makes weapon only penetrate non-burning teammates, as opposed to penetrating all teammates.
	 * 
	 * Note: Not actually used in Sydney Sleeper Jarate calculation, as far as I could tell.
	 */
	val jarateDuration: ItemAttributeNamed<Number> get() = SniperRifleAttributes.jarateDuration
	
	/**
	 * In-Game: "No flinching when aiming and fully charged"
	 * 
	 * Prevents flinching from damage when scoped and fully charged.
	 */
	val aimingNoFlinch: ItemAttributeNamed<Boolean> get() = SniperRifleAttributes.aimingNoFlinch
	
	/**
	 * Attributes related to max ammo, clip-size, and resupply.
	 */
	override val ammo: AmmoAttributes get() = SniperRifleAttributes.ammo
	
	/**
	 * Attributes governing rate-of-fire.
	 */
	override val firing: FiringAttributes get() = SniperRifleAttributes.firing
	
	/**
	 * All attributes governing what projectile or bullet this weapon can fire, and how that projectile or bullet acts once fired.
	 * 
	 * Each type of projectile also has a subcategory with every attribute it checks for on the gun that fired it.
	 */
	override val projectiles: ProjectilesAttributes get() = SniperRifleAttributes.projectiles
	
	/**
	 * Attributes related to afterburn.
	 */
	override val afterburn: AfterburnAttributes get() = SniperRifleAttributes.afterburn
	
	/**
	 * Attributes related to moving, constructing, and interacting with the Engineer's buildings.
	 */
	override val buildings: BuildingsAttributes get() = SniperRifleAttributes.buildings
	
	/**
	 * Attributes related to dealing or preventing critical hits and mini-crits.
	 */
	override val crits: CritsAttributes get() = SniperRifleAttributes.crits
	
	/**
	 * Attributes governing the Demoknight's shield-charge.
	 * 
	 * Some of these attributes are hardcoded to only work on the Demoman. These are noted in their documentation.
	 */
	override val demoCharge: DemoChargeAttributes get() = SniperRifleAttributes.demoCharge
	
	/**
	 * Attributes related to the player's HP stat and healing players.
	 */
	override val healthAndHealing: HealthAndHealingAttributes get() = SniperRifleAttributes.healthAndHealing
	
	/**
	 * Attributes governing how much you are pushed when hit by different push sources.
	 */
	override val knockbackReceived: KnockbackReceivedAttributes get() = SniperRifleAttributes.knockbackReceived
	
	/**
	 * Attributes related to the scoreboard, killfeed, HuD, item descriptions, and interactions with the wider game-state. (including capture rate)
	 */
	override val meta: MetaAttributes get() = SniperRifleAttributes.meta
	
	/**
	 * Attributes related to rage and items that recharge on a meter/timer.
	 */
	override val meter: MeterAttributes get() = SniperRifleAttributes.meter
	
	/**
	 * Attributes governing the player's move-speed, jump height, swimming, air-strafing capabilities, and all things mobility-related.
	 */
	override val movement: MovementAttributes get() = SniperRifleAttributes.movement
	
	/**
	 * Attributes related to the collection and passive effects of "heads".
	 * 
	 * While originally made for the Eyelander, this stat is used by many other weapons that track players hit or killed: the Vita-Saw, the Bazaar Bargain, etc.
	 * 
	 * For "revenge crits", like the Frontier Justice, Manmelter, and Diamondback, see [revengeCrits].
	 */
	override val heads: HeadsAttributes get() = SniperRifleAttributes.heads
	
	/**
	 * Attributes governing what happens when you kill another player, usually applying bonuses to yourself.
	 * 
	 * @see onHit
	 */
	override val onKill: OnKillAttributes get() = SniperRifleAttributes.onKill
	
	/**
	 * Attributes governing either the time taken to reload a weapon's magazine or the cooldown time for weapons that draw directly from reserve ammo like the Sniper Rifle and Flare Gun.
	 */
	override val reloading: ReloadingAttributes get() = SniperRifleAttributes.reloading
	
	/**
	 * Attributes governing how much damage the player takes from various sources.  Also includes the passive and active effects of the Vaccinator on the user.
	 * 
	 * For outgoing damage, see [damage].
	 */
	override val resistance: ResistanceAttributes get() = SniperRifleAttributes.resistance
	
	/**
	 * Attributes governing the collection of "Revenge Crits", guaranteed criticals gained by fulfilling certain requirements.
	 * 
	 * It should be noted that for the most part, these attributes just state whether or not a weapon CAN gain revenge crits. Actually _using_ them is bound to the weapon type, not any attribute.
	 * 
	 * For the collection and usage of "heads", see [heads].
	 */
	override val revengeCrits: RevengeCritsAttributes get() = SniperRifleAttributes.revengeCrits
	
	/**
	 * Attributes related to Mad Milk, Jarate, and Gas.
	 * 
	 * This will be empty for most weapons unless a mod adds something.  Notably, "explode on ignite" is available for all weapons.
	 */
	override val statusEffects: StatusEffectsAttributes get() = SniperRifleAttributes.statusEffects
	
	/**
	 * Attributes governing taunt speed and the effects of taunts.
	 */
	override val taunting: TauntingAttributes get() = SniperRifleAttributes.taunting
	
	/**
	 * Attributes governing weapon deploy/holster speed, things that activate when a weapon is deployed, and whether a player can swap weapons at all.
	 */
	override val swapWeapons: SwapWeaponsAttributes get() = SniperRifleAttributes.swapWeapons
	
	/**
	 * Attributes governing what happens when this player is hit by an enemy.
	 * 
	 * For what happens when _this player_ hits an enemy, see [onHit] and [onKill].
	 */
	override val whenHit: WhenHitAttributes get() = SniperRifleAttributes.whenHit
	
	/**
	 * Attributes governing ragdolls, gibs, and statues.
	 */
	override val ragdolls: RagdollsAttributes get() = SniperRifleAttributes.ragdolls
	
	override val buffItems: BuffItemsAttributes get() = SniperRifleAttributes.buffItems
	
	override val cloak: CloakAttributes get() = SniperRifleAttributes.cloak
	
	/**
	 * Attributes related to disguising.
	 */
	override val disguise: DisguiseAttributes get() = SniperRifleAttributes.disguise
	
	override val hud: HudAttributes get() = SniperRifleAttributes.hud
	
	override val spyOnly: SpyOnlyAttributes get() = SniperRifleAttributes.spyOnly
	
	open class DamageAttributes : BaseGunAttributes.DamageAttributes() {
		/**
		 * In-Game: "On Full Charge: +N% damage per shot"
		 * 
		 * If greater than 1.0, weapon plays cool fully-charged-Machina railgun sound when firing at full charge.
		 */
		open val fullChargeDamageBonus: ItemAttributeNamed<Number> = ItemAttributeNamed("sniper full charge damage bonus")
	
		override val alien: AlienAttributes = AlienAttributes()
	
		open class AlienAttributes : BaseGunAttributes.DamageAttributes.AlienAttributes() 
	}
	
	open class OnHitAttributes : BaseGunAttributes.OnHitAttributes() {
		/**
		 * In-Game: "N% movement speed on targets"
		 * 
		 * Multiplier applied to target move-speed on hit.
		 * 
		 * Duration is equal to the rifle's `jarate_duration` attribute.
		 */
		open val appliesSnareEffect: ItemAttributeNamed<Number> = ItemAttributeNamed("applies snare effect")
	
		/**
		 * Add this amount of health on hit.
		 */
		override val addOnhitAddhealth: AddOnhitAddhealthAttributes = AddOnhitAddhealthAttributes()
	
		/**
		 * Knockback rage on enemy if you're a heavy and your rage is draining.
		 */
		override val generateRageOnDmg: GenerateRageOnDmgAttributes = GenerateRageOnDmgAttributes()
	
		override val falling: FallingAttributes = FallingAttributes()
	
		open class AddOnhitAddhealthAttributes : BaseGunAttributes.OnHitAttributes.AddOnhitAddhealthAttributes() 
	
		open class GenerateRageOnDmgAttributes : BaseGunAttributes.OnHitAttributes.GenerateRageOnDmgAttributes(), ItemAttribute<Boolean> 
	
		open class FallingAttributes : BaseGunAttributes.OnHitAttributes.FallingAttributes() 
	}
	
	open class MultSniperChargePerSecAttributes : IBlockScoped {
		/**
		 * In-Game: "+N% charge rate"
		 */
		open val sniperChargePerSec: ItemAttributeNamed<Number> = ItemAttributeNamed("sniper charge per sec")
	
		/**
		 * In-Game: "N% faster power charge"
		 */
		open val srifleChargeRateIncreased: ItemAttributeNamed<Number> = ItemAttributeNamed("SRifle Charge rate increased")
	
		/**
		 * In-Game: "N% slower power charge"
		 */
		open val srifleChargeRateDecreased: ItemAttributeNamed<Number> = ItemAttributeNamed("SRifle Charge rate decreased")
	}
	
	open class AmmoAttributes : BaseGunAttributes.AmmoAttributes() {
		override val clipSize: ClipSizeAttributes = ClipSizeAttributes()
	
		override val multMaxAmmo: MaxAmmoAttributes = MaxAmmoAttributes()
	
		open class ClipSizeAttributes : BaseGunAttributes.AmmoAttributes.ClipSizeAttributes() 
	
		open class MaxAmmoAttributes : BaseGunAttributes.AmmoAttributes.MaxAmmoAttributes() 
	}
	
	open class FiringAttributes : BaseGunAttributes.FiringAttributes() {
		override val fireRate: FireRateAttributes = FireRateAttributes()
	
		open class FireRateAttributes : BaseGunAttributes.FiringAttributes.FireRateAttributes() 
	}
	
	open class ProjectilesAttributes : BaseGunAttributes.ProjectilesAttributes() {
		override val bullets: BulletsAttributes = BulletsAttributes()
	
		/**
		 * How many players your "projectile" (*including bullets*) should penetrate.
		 */
		override val penetration: ProjectilePenetrationAttributes = ProjectilePenetrationAttributes()
	
		open class BulletsAttributes : BaseGunAttributes.ProjectilesAttributes.BulletsAttributes() 
	
		open class ProjectilePenetrationAttributes : BaseGunAttributes.ProjectilesAttributes.ProjectilePenetrationAttributes(), ItemAttribute<Int> 
	}
	
	open class AfterburnAttributes : BaseGunAttributes.AfterburnAttributes() 
	
	open class BuildingsAttributes : BaseGunAttributes.BuildingsAttributes() {
		override val sentryGun: SentryGunAttributes = SentryGunAttributes()
	
		override val dispenser: DispenserAttributes = DispenserAttributes()
	
		override val teleporter: TeleporterAttributes = TeleporterAttributes()
	
		open class SentryGunAttributes : BaseGunAttributes.BuildingsAttributes.SentryGunAttributes() 
	
		open class DispenserAttributes : BaseGunAttributes.BuildingsAttributes.DispenserAttributes() 
	
		open class TeleporterAttributes : BaseGunAttributes.BuildingsAttributes.TeleporterAttributes() 
	}
	
	open class CritsAttributes : BaseGunAttributes.CritsAttributes() 
	
	open class DemoChargeAttributes : BaseGunAttributes.DemoChargeAttributes() {
		/**
		 * Default is 0.45f, and this is a multiplier applied to it.
		 */
		override val multChargeTurnControl: ChargeTurnControlAttributes = ChargeTurnControlAttributes()
	
		open class ChargeTurnControlAttributes : BaseGunAttributes.DemoChargeAttributes.ChargeTurnControlAttributes(), ItemAttribute<Number> 
	}
	
	open class HealthAndHealingAttributes : BaseGunAttributes.HealthAndHealingAttributes() {
		/**
		 * Amount of health regenerated per regen tick.  Scales by the amount of time since the player last took damage in non-MvM modes.
		 */
		override val healthRegenPerSecond: AddHealthRegenAttributes = AddHealthRegenAttributes()
	
		/**
		 * Additive maximum health increase. Influences the player's overheal cap.
		 */
		override val addMaxHealth: AddMaxhealthAttributes = AddMaxhealthAttributes()
	
		open class AddHealthRegenAttributes : BaseGunAttributes.HealthAndHealingAttributes.AddHealthRegenAttributes(), ItemAttribute<Int> 
	
		open class AddMaxhealthAttributes : BaseGunAttributes.HealthAndHealingAttributes.AddMaxhealthAttributes(), ItemAttribute<Int> 
	}
	
	open class KnockbackReceivedAttributes : BaseGunAttributes.KnockbackReceivedAttributes() {
		/**
		 * Attribute class is a flat multiplier applied to push force received from damage.
		 */
		override val damageForceReduction: DamageForceReductionAttributes = DamageForceReductionAttributes()
	
		open class DamageForceReductionAttributes : BaseGunAttributes.KnockbackReceivedAttributes.DamageForceReductionAttributes() 
	}
	
	open class MetaAttributes : BaseGunAttributes.MetaAttributes() {
		override val killfeed: KillfeedAttributes = KillfeedAttributes()
	
		override val viewmodel: ViewmodelAttributes = ViewmodelAttributes()
	
		override val items: ItemsAttributes = ItemsAttributes()
	
		override val particles: ParticlesAttributes = ParticlesAttributes()
	
		override val noisemakers: NoisemakersAttributes = NoisemakersAttributes()
	
		override val player: PlayerAttributes = PlayerAttributes()
	
		override val gameplay: GameplayAttributes = GameplayAttributes()
	
		open class KillfeedAttributes : BaseGunAttributes.MetaAttributes.KillfeedAttributes() 
	
		open class ViewmodelAttributes : BaseGunAttributes.MetaAttributes.ViewmodelAttributes() 
	
		open class ItemsAttributes : BaseGunAttributes.MetaAttributes.ItemsAttributes() 
	
		open class ParticlesAttributes : BaseGunAttributes.MetaAttributes.ParticlesAttributes() 
	
		open class NoisemakersAttributes : BaseGunAttributes.MetaAttributes.NoisemakersAttributes() 
	
		open class PlayerAttributes : BaseGunAttributes.MetaAttributes.PlayerAttributes() 
	
		open class GameplayAttributes : BaseGunAttributes.MetaAttributes.GameplayAttributes() 
	}
	
	open class MeterAttributes : BaseGunAttributes.MeterAttributes() {
		/**
		 * Only works on Engineer and Heavy.
		 * 
		 * On Engineer, adds all damage dealt to the rage meter.
		 * 
		 * On Heavy, adds `0.22` * the damage to the meter, and reduces damage by 50% while the meter is draining.
		 */
		override val generateRageOnDmg: GenerateRageOnDmgAttributes = GenerateRageOnDmgAttributes()
	
		open class GenerateRageOnDmgAttributes : BaseGunAttributes.MeterAttributes.GenerateRageOnDmgAttributes(), ItemAttribute<Boolean> 
	}
	
	open class MovementAttributes : BaseGunAttributes.MovementAttributes() {
		override val moveSpeed: MoveSpeedAttributes = MoveSpeedAttributes()
	
		override val multJumpHeight: ModJumpHeightAttributes = ModJumpHeightAttributes()
	
		open class MoveSpeedAttributes : BaseGunAttributes.MovementAttributes.MoveSpeedAttributes() {
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
	
			open class MultPlayerAimingMovespeedAttributes : BaseGunAttributes.MovementAttributes.MoveSpeedAttributes.MultPlayerAimingMovespeedAttributes() 
	
			open class MultPlayerMovespeedAttributes : BaseGunAttributes.MovementAttributes.MoveSpeedAttributes.MultPlayerMovespeedAttributes(), ItemAttribute<Number> 
		}
	
		open class ModJumpHeightAttributes : BaseGunAttributes.MovementAttributes.ModJumpHeightAttributes(), ItemAttribute<Number> 
	}
	
	open class HeadsAttributes : BaseGunAttributes.HeadsAttributes() 
	
	open class OnKillAttributes : BaseGunAttributes.OnKillAttributes() 
	
	open class ReloadingAttributes : BaseGunAttributes.ReloadingAttributes() 
	
	open class ResistanceAttributes : BaseGunAttributes.ResistanceAttributes() {
		override val multDmgTakenCrits: MultDmgtakenFromCritAttributes = MultDmgtakenFromCritAttributes()
	
		override val multDmgTakenFire: MultDmgtakenFromFireAttributes = MultDmgtakenFromFireAttributes()
	
		override val multDmgTakenBullets: MultDmgtakenFromBulletsAttributes = MultDmgtakenFromBulletsAttributes()
	
		override val vaccinator: VaccinatorAttributes = VaccinatorAttributes()
	
		open class MultDmgtakenFromCritAttributes : BaseGunAttributes.ResistanceAttributes.MultDmgtakenFromCritAttributes(), ItemAttribute<Number> 
	
		open class MultDmgtakenFromFireAttributes : BaseGunAttributes.ResistanceAttributes.MultDmgtakenFromFireAttributes(), ItemAttribute<Number> 
	
		open class MultDmgtakenFromBulletsAttributes : BaseGunAttributes.ResistanceAttributes.MultDmgtakenFromBulletsAttributes(), ItemAttribute<Number> 
	
		open class VaccinatorAttributes : BaseGunAttributes.ResistanceAttributes.VaccinatorAttributes() 
	}
	
	open class RevengeCritsAttributes : BaseGunAttributes.RevengeCritsAttributes() 
	
	open class StatusEffectsAttributes : BaseGunAttributes.StatusEffectsAttributes() 
	
	open class TauntingAttributes : BaseGunAttributes.TauntingAttributes() 
	
	open class SwapWeaponsAttributes : BaseGunAttributes.SwapWeaponsAttributes() {
		override val deploy: DeployAttributes = DeployAttributes()
	
		open class DeployAttributes : BaseGunAttributes.SwapWeaponsAttributes.DeployAttributes() 
	}
	
	open class WhenHitAttributes : BaseGunAttributes.WhenHitAttributes() 
	
	open class RagdollsAttributes : BaseGunAttributes.RagdollsAttributes() 
	
	open class BuffItemsAttributes : BaseGunAttributes.BuffItemsAttributes() 
	
	open class CloakAttributes : BaseGunAttributes.CloakAttributes() 
	
	open class DisguiseAttributes : BaseGunAttributes.DisguiseAttributes() 
	
	open class HudAttributes : BaseGunAttributes.HudAttributes() 
	
	open class SpyOnlyAttributes : BaseGunAttributes.SpyOnlyAttributes() 
	
	object Inherited : SniperRifleAttributes 
}