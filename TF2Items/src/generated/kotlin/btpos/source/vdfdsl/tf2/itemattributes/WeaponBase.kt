package btpos.source.vdfdsl.tf2.itemattributes

import btpos.source.vdfdsl.modeling.*
import btpos.source.vdfdsl.serialization.*
import btpos.source.vdfdsl.serialization.codecs.*
import btpos.source.vdfdsl.tf2.itemattributes.impl.*
import btpos.source.vdfdsl.tf2.tftypes.*
import java.util.*
import kotlin.time.Duration

interface WeaponBaseAttributes : IBlockScoped, BaseCombatWeaponAttributes {
	companion object : IBlockScoped {
		/**
		 * In-Game: "This Weapon has a large melee range and deploys and holsters slower"
		 * 
		 * If true, make weapon deploy and holster 75% slower.
		 */
		val isASword: ItemAttributeNamed<Boolean> = ItemAttributeNamed("is_a_sword")
	
		/**
		 * In-Game: "Replaces the Sentry with a Mini-Sentry"
		 * 
		 * Determines the hand used in the model.
		 */
		val wrenchBuildsMinisentry: ItemAttributeNamed<Boolean> = ItemAttributeNamed("mod wrench builds minisentry")
	
		/**
		 * Attributes related to afterburn.
		 */
		val afterburn: AfterburnAttributes = AfterburnAttributes()
	
		/**
		 * Attributes related to max ammo, clip-size, and resupply.
		 */
		val ammo: AmmoAttributes = AmmoAttributes()
	
		/**
		 * Attributes related to moving, constructing, and interacting with the Engineer's buildings.
		 */
		val buildings: BuildingsAttributes = BuildingsAttributes()
	
		/**
		 * Attributes related to dealing or preventing critical hits and mini-crits.
		 */
		val crits: CritsAttributes = CritsAttributes()
	
		/**
		 * Multipliers governing the damage you deal to different targets.
		 * 
		 * For damage _taken_, see [resistance].
		 */
		val damage: DamageAttributes = DamageAttributes()
	
		/**
		 * Attributes governing the Demoknight's shield-charge.
		 * 
		 * Some of these attributes are hardcoded to only work on the Demoman. These are noted in their documentation.
		 */
		val demoCharge: DemoChargeAttributes = DemoChargeAttributes()
	
		/**
		 * Attributes governing rate-of-fire.
		 */
		val firing: FiringAttributes = FiringAttributes()
	
		/**
		 * Attributes related to the player's HP stat and healing players.
		 */
		val healthAndHealing: HealthAndHealingAttributes = HealthAndHealingAttributes()
	
		/**
		 * Attributes governing how much you are pushed when hit by different push sources.
		 */
		val knockbackReceived: KnockbackReceivedAttributes = KnockbackReceivedAttributes()
	
		/**
		 * Attributes related to the scoreboard, killfeed, HuD, item descriptions, and interactions with the wider game-state. (including capture rate)
		 */
		val meta: MetaAttributes = MetaAttributes()
	
		/**
		 * Attributes related to rage and items that recharge on a meter/timer.
		 */
		val meter: MeterAttributes = MeterAttributes()
	
		/**
		 * Attributes governing the player's move-speed, jump height, swimming, air-strafing capabilities, and all things mobility-related.
		 */
		val movement: MovementAttributes = MovementAttributes()
	
		/**
		 * Attributes related to the collection and passive effects of "heads".
		 * 
		 * While originally made for the Eyelander, this stat is used by many other weapons that track players hit or killed: the Vita-Saw, the Bazaar Bargain, etc.
		 * 
		 * For "revenge crits", like the Frontier Justice, Manmelter, and Diamondback, see [revengeCrits].
		 */
		val heads: HeadsAttributes = HeadsAttributes()
	
		/**
		 * Attributes governing what happens when you hit another player, such as applying conditions or debuffs.
		 * 
		 * @see onKill
		 */
		val onHit: OnHitAttributes = OnHitAttributes()
	
		/**
		 * Attributes governing what happens when you kill another player, usually applying bonuses to yourself.
		 * 
		 * @see onHit
		 */
		val onKill: OnKillAttributes = OnKillAttributes()
	
		/**
		 * All attributes governing what projectile or bullet this weapon can fire, and how that projectile or bullet acts once fired.
		 * 
		 * Each type of projectile also has a subcategory with every attribute it checks for on the gun that fired it.
		 */
		val projectiles: ProjectilesAttributes = ProjectilesAttributes()
	
		/**
		 * Attributes governing either the time taken to reload a weapon's magazine or the cooldown time for weapons that draw directly from reserve ammo like the Sniper Rifle and Flare Gun.
		 */
		val reloading: ReloadingAttributes = ReloadingAttributes()
	
		/**
		 * Attributes governing how much damage the player takes from various sources.  Also includes the passive and active effects of the Vaccinator on the user.
		 * 
		 * For outgoing damage, see [damage].
		 */
		val resistance: ResistanceAttributes = ResistanceAttributes()
	
		/**
		 * Attributes governing the collection of "Revenge Crits", guaranteed criticals gained by fulfilling certain requirements.
		 * 
		 * It should be noted that for the most part, these attributes just state whether or not a weapon CAN gain revenge crits. Actually _using_ them is bound to the weapon type, not any attribute.
		 * 
		 * For the collection and usage of "heads", see [heads].
		 */
		val revengeCrits: RevengeCritsAttributes = RevengeCritsAttributes()
	
		/**
		 * Attributes related to Mad Milk, Jarate, and Gas.
		 * 
		 * This will be empty for most weapons unless a mod adds something.  Notably, "explode on ignite" is available for all weapons.
		 */
		val statusEffects: StatusEffectsAttributes = StatusEffectsAttributes()
	
		/**
		 * Attributes governing taunt speed and the effects of taunts.
		 */
		val taunting: TauntingAttributes = TauntingAttributes()
	
		/**
		 * Attributes governing weapon deploy/holster speed, things that activate when a weapon is deployed, and whether a player can swap weapons at all.
		 */
		val swapWeapons: SwapWeaponsAttributes = SwapWeaponsAttributes()
	
		/**
		 * Attributes governing what happens when this player is hit by an enemy.
		 * 
		 * For what happens when _this player_ hits an enemy, see [onHit] and [onKill].
		 */
		val whenHit: WhenHitAttributes = WhenHitAttributes()
	
		/**
		 * Attributes governing ragdolls, gibs, and statues.
		 */
		val ragdolls: RagdollsAttributes = RagdollsAttributes()
	
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
	 * In-Game: "This Weapon has a large melee range and deploys and holsters slower"
	 * 
	 * If true, make weapon deploy and holster 75% slower.
	 */
	val isASword: ItemAttributeNamed<Boolean> get() = WeaponBaseAttributes.isASword
	
	/**
	 * In-Game: "Replaces the Sentry with a Mini-Sentry"
	 * 
	 * Determines the hand used in the model.
	 */
	val wrenchBuildsMinisentry: ItemAttributeNamed<Boolean> get() = WeaponBaseAttributes.wrenchBuildsMinisentry
	
	/**
	 * Attributes related to afterburn.
	 */
	val afterburn: AfterburnAttributes get() = WeaponBaseAttributes.afterburn
	
	/**
	 * Attributes related to max ammo, clip-size, and resupply.
	 */
	override val ammo: AmmoAttributes get() = WeaponBaseAttributes.ammo
	
	/**
	 * Attributes related to moving, constructing, and interacting with the Engineer's buildings.
	 */
	override val buildings: BuildingsAttributes get() = WeaponBaseAttributes.buildings
	
	/**
	 * Attributes related to dealing or preventing critical hits and mini-crits.
	 */
	override val crits: CritsAttributes get() = WeaponBaseAttributes.crits
	
	/**
	 * Multipliers governing the damage you deal to different targets.
	 * 
	 * For damage _taken_, see [resistance].
	 */
	override val damage: DamageAttributes get() = WeaponBaseAttributes.damage
	
	/**
	 * Attributes governing the Demoknight's shield-charge.
	 * 
	 * Some of these attributes are hardcoded to only work on the Demoman. These are noted in their documentation.
	 */
	override val demoCharge: DemoChargeAttributes get() = WeaponBaseAttributes.demoCharge
	
	/**
	 * Attributes governing rate-of-fire.
	 */
	override val firing: FiringAttributes get() = WeaponBaseAttributes.firing
	
	/**
	 * Attributes related to the player's HP stat and healing players.
	 */
	override val healthAndHealing: HealthAndHealingAttributes get() = WeaponBaseAttributes.healthAndHealing
	
	/**
	 * Attributes governing how much you are pushed when hit by different push sources.
	 */
	override val knockbackReceived: KnockbackReceivedAttributes get() = WeaponBaseAttributes.knockbackReceived
	
	/**
	 * Attributes related to the scoreboard, killfeed, HuD, item descriptions, and interactions with the wider game-state. (including capture rate)
	 */
	override val meta: MetaAttributes get() = WeaponBaseAttributes.meta
	
	/**
	 * Attributes related to rage and items that recharge on a meter/timer.
	 */
	override val meter: MeterAttributes get() = WeaponBaseAttributes.meter
	
	/**
	 * Attributes governing the player's move-speed, jump height, swimming, air-strafing capabilities, and all things mobility-related.
	 */
	override val movement: MovementAttributes get() = WeaponBaseAttributes.movement
	
	/**
	 * Attributes related to the collection and passive effects of "heads".
	 * 
	 * While originally made for the Eyelander, this stat is used by many other weapons that track players hit or killed: the Vita-Saw, the Bazaar Bargain, etc.
	 * 
	 * For "revenge crits", like the Frontier Justice, Manmelter, and Diamondback, see [revengeCrits].
	 */
	override val heads: HeadsAttributes get() = WeaponBaseAttributes.heads
	
	/**
	 * Attributes governing what happens when you hit another player, such as applying conditions or debuffs.
	 * 
	 * @see onKill
	 */
	override val onHit: OnHitAttributes get() = WeaponBaseAttributes.onHit
	
	/**
	 * Attributes governing what happens when you kill another player, usually applying bonuses to yourself.
	 * 
	 * @see onHit
	 */
	override val onKill: OnKillAttributes get() = WeaponBaseAttributes.onKill
	
	/**
	 * All attributes governing what projectile or bullet this weapon can fire, and how that projectile or bullet acts once fired.
	 * 
	 * Each type of projectile also has a subcategory with every attribute it checks for on the gun that fired it.
	 */
	val projectiles: ProjectilesAttributes get() = WeaponBaseAttributes.projectiles
	
	/**
	 * Attributes governing either the time taken to reload a weapon's magazine or the cooldown time for weapons that draw directly from reserve ammo like the Sniper Rifle and Flare Gun.
	 */
	val reloading: ReloadingAttributes get() = WeaponBaseAttributes.reloading
	
	/**
	 * Attributes governing how much damage the player takes from various sources.  Also includes the passive and active effects of the Vaccinator on the user.
	 * 
	 * For outgoing damage, see [damage].
	 */
	override val resistance: ResistanceAttributes get() = WeaponBaseAttributes.resistance
	
	/**
	 * Attributes governing the collection of "Revenge Crits", guaranteed criticals gained by fulfilling certain requirements.
	 * 
	 * It should be noted that for the most part, these attributes just state whether or not a weapon CAN gain revenge crits. Actually _using_ them is bound to the weapon type, not any attribute.
	 * 
	 * For the collection and usage of "heads", see [heads].
	 */
	val revengeCrits: RevengeCritsAttributes get() = WeaponBaseAttributes.revengeCrits
	
	/**
	 * Attributes related to Mad Milk, Jarate, and Gas.
	 * 
	 * This will be empty for most weapons unless a mod adds something.  Notably, "explode on ignite" is available for all weapons.
	 */
	val statusEffects: StatusEffectsAttributes get() = WeaponBaseAttributes.statusEffects
	
	/**
	 * Attributes governing taunt speed and the effects of taunts.
	 */
	override val taunting: TauntingAttributes get() = WeaponBaseAttributes.taunting
	
	/**
	 * Attributes governing weapon deploy/holster speed, things that activate when a weapon is deployed, and whether a player can swap weapons at all.
	 */
	override val swapWeapons: SwapWeaponsAttributes get() = WeaponBaseAttributes.swapWeapons
	
	/**
	 * Attributes governing what happens when this player is hit by an enemy.
	 * 
	 * For what happens when _this player_ hits an enemy, see [onHit] and [onKill].
	 */
	override val whenHit: WhenHitAttributes get() = WeaponBaseAttributes.whenHit
	
	/**
	 * Attributes governing ragdolls, gibs, and statues.
	 */
	val ragdolls: RagdollsAttributes get() = WeaponBaseAttributes.ragdolls
	
	override val buffItems: BuffItemsAttributes get() = WeaponBaseAttributes.buffItems
	
	override val cloak: CloakAttributes get() = WeaponBaseAttributes.cloak
	
	/**
	 * Attributes related to disguising.
	 */
	override val disguise: DisguiseAttributes get() = WeaponBaseAttributes.disguise
	
	override val hud: HudAttributes get() = WeaponBaseAttributes.hud
	
	override val spyOnly: SpyOnlyAttributes get() = WeaponBaseAttributes.spyOnly
	
	open class AfterburnAttributes : IBlockScoped {
		/**
		 * In-Game: "On Hit: target is engulfed in flames"
		 * 
		 * Ignites player on hit.
		 */
		open val setDamagetypeIgnite: ItemAttributeNamed<Boolean> = ItemAttributeNamed("Set DamageType Ignite")
	
		/**
		 * Bonus:
		 * 
		 * 	- In-Game: "+N% afterburn damage bonus"
		 * 
		 * Penalty:
		 * 
		 * 	- In-Game: "N% afterburn damage penalty"
		 */
		open val multWpnBurndmg: BonusPenalty<Number> = BonusPenalty(
		    ItemAttributeNamed("weapon burn dmg increased"),
		    ItemAttributeNamed("weapon burn dmg reduced"),
		)
	
		/**
		 * Bonus:
		 * 
		 * 	- In-Game: "+N% afterburn duration"
		 * 
		 * Penalty:
		 * 
		 * 	- In-Game: "N% afterburn duration"
		 */
		open val multWpnBurntime: BonusPenalty<Number> = BonusPenalty(
		    ItemAttributeNamed("weapon burn time increased"),
		    ItemAttributeNamed("weapon burn time reduced"),
		)
	
		/**
		 * In-Game: "Halloween Fire"
		 * 
		 * Makes afterburn green.
		 */
		open val spellHalloweenGreenFlames: ItemAttributeNamed<Boolean> = ItemAttributeNamed("SPELL: Halloween green flames")
	}
	
	open class AmmoAttributes : BaseCombatWeaponAttributes.AmmoAttributes() {
		/**
		 * In-Game: "No ammo from dispensers when active"
		 */
		open val noPrimaryAmmoFromDispensersWhileActive: ItemAttributeNamed<Boolean> = ItemAttributeNamed("no primary ammo from dispensers while active")
	
		/**
		 * In-Game: "No metal from dispensers when active."
		 */
		open val noMetalFromDispensersWhileActive: ItemAttributeNamed<Boolean> = ItemAttributeNamed("no metal from dispensers while active")
	
		override val clipSize: ClipSizeAttributes = ClipSizeAttributes()
	
		override val multMaxAmmo: MaxAmmoAttributes = MaxAmmoAttributes()
	
		open class ClipSizeAttributes : BaseCombatWeaponAttributes.AmmoAttributes.ClipSizeAttributes() {
			/**
			 * Bonus:
			 * 
			 * 	- In-Game: "+N% clip size"
			 * 
			 * Penalty:
			 * 
			 * 	- In-Game: "N% clip size"
			 * 
			 * Hidden:
			 * 
			 * 	- In-Game: "N% clip size"
			 */
			open val multClipsize: BonusPenaltyHidden<Number, ItemAttributeNamed<Number>> = BonusPenaltyHidden(
			    ItemAttributeNamed<Number>("clip size bonus"),
			    ItemAttributeNamed<Number>("clip size penalty"),
			    ItemAttributeNamed<Number>("clip size penalty HIDDEN"),
			)
	
			/**
			 * In-Game: "+N% clip size"
			 */
			open val clipSizeBonusUpgrade: ItemAttributeNamed<Number> = ItemAttributeNamed("clip size bonus upgrade")
	
			/**
			 * In-Game: "+N clip size"
			 * 
			 * MVM attribute that specifically handles rocket and grenade launchers.
			 * 
			 * Note that all three of these are different classes, which means they stack.
			 */
			open val clipSizeUpgradeAtomic: ItemAttributeNamed<Int> = ItemAttributeNamed("clip size upgrade atomic")
	
			/**
			 * In-Game: "Clip size increased on kill"
			 */
			open val clipsizeIncreaseOnKill: ItemAttributeNamed<Int> = ItemAttributeNamed("clipsize increase on kill")
		}
	
		open class MaxAmmoAttributes : BaseCombatWeaponAttributes.AmmoAttributes.MaxAmmoAttributes() 
	}
	
	open class BuildingsAttributes : BaseCombatWeaponAttributes.BuildingsAttributes() {
		/**
		 * In-Game: "Alt-Fire: Use N metal to pick up your targeted building from long range"
		 * 
		 * Metal cost to pick up a building at range.
		 * 
		 * Restricted to the default rescue ranger range, but can be used by any weapon.
		 */
		open val buildingRescueMetalCost: ItemAttributeNamed<Int> = ItemAttributeNamed("engineer building teleporting pickup")
	
		override val sentryGun: SentryGunAttributes = SentryGunAttributes()
	
		override val dispenser: DispenserAttributes = DispenserAttributes()
	
		override val teleporter: TeleporterAttributes = TeleporterAttributes()
	
		open class SentryGunAttributes : BaseCombatWeaponAttributes.BuildingsAttributes.SentryGunAttributes() 
	
		open class DispenserAttributes : BaseCombatWeaponAttributes.BuildingsAttributes.DispenserAttributes() 
	
		open class TeleporterAttributes : BaseCombatWeaponAttributes.BuildingsAttributes.TeleporterAttributes() 
	}
	
	open class CritsAttributes : BaseCombatWeaponAttributes.CritsAttributes() {
		/**
		 * Visible:
		 * 
		 * 	- In-Game: "No random critical hits"
		 * 
		 * 
		 * 
		 * Hidden:
		 * 
		 * 	- In-Game: "No random critical hits"
		 */
		open val multCritChance: VisHidden<Number> = VisHidden(
		    ItemAttributeNamed("crit mod disabled"),
		    ItemAttributeNamed("crit mod disabled hidden")
		)
	
		/**
		 * In-Game: "Cannot be crit boosted"
		 * 
		 * Can't be crit-boosted.
		 */
		open val noCritBoost: ItemAttributeNamed<Boolean> = ItemAttributeNamed("no crit boost")
	
		/**
		 * The weapon's "crit players with X condition" stat.
		 */
		open val critVsConditions: ItemAttributeNamed<EnumSet<TFCritCondition>> = ItemAttributeNamed("crit vs burning players", EnumSetOrCodec())
	
		/**
		 * In-Game: "100% critical hit vs burning players"
		 * 
		 * The weapon's "crit players with X condition" stat.
		 */
		open val critVsBurningPlayers: ItemAttributeNamed<EnumSet<TFCritCondition>> = ItemAttributeNamed("crit vs burning players", EnumSetOrCodec())
	
		/**
		 * In-Game: "100% critical hit vs disguised players"
		 * 
		 * The weapon's "crit players with X condition" stat.
		 */
		open val critVsDisguisedPlayers: ItemAttributeNamed<EnumSet<TFCritCondition>> = ItemAttributeNamed("crit vs disguised players", EnumSetOrCodec())
	
		/**
		 * In-Game: "100% critical hit vs wet players"
		 */
		open val critVsWetPlayers: ItemAttributeNamed<Boolean> = ItemAttributeNamed("crit vs wet players")
	
		/**
		 * In-Game: "100% critical hit vs non-burning players"
		 * 
		 * Crit against players that DON'T have these conditions.
		 */
		open val critVsNonBurningPlayers: ItemAttributeNamed<EnumSet<TFCritCondition>> = ItemAttributeNamed("crit vs non burning players", EnumSetOrCodec())
	
		/**
		 * In-Game: "100% critical hits burning players from behind. Mini-crits burning players from the front."
		 * 
		 * On hitting a burning player, crit them from behind or minicrit them otherwise.
		 */
		open val axtinguisherProperties: ItemAttributeNamed<Boolean> = ItemAttributeNamed("axtinguisher properties")
	
		/**
		 * In-Game: "Deals crits while the wielder is rocket jumping"
		 * 
		 * Critical hit enemies if the player was launched into the air by an explosion.
		 * 
		 * Only works when not in Mannpower mode.
		 */
		open val critWhileAirborne: ItemAttributeNamed<Boolean> = ItemAttributeNamed("mod crit while airborne")
	
		/**
		 * In-Game: "Mini-crits burning targets and extinguishes them. Damage increases based on remaining duration of afterburn. Killing blows on burning players grant a speed boost."
		 * 
		 * Only activates if the weapon deals `DMG_MELEE`.
		 */
		open val attackMinicritsAndConsumesBurning: ItemAttributeNamed<Boolean> = ItemAttributeNamed("attack_minicrits_and_consumes_burning")
	
		/**
		 * In-Game: "100% minicrits vs burning players"
		 * 
		 * Minicrits if the damage dealt is NOT `DMG_BURN`.
		 */
		open val minicritVsBurningPlayer: ItemAttributeNamed<Boolean> = ItemAttributeNamed("minicrit vs burning player")
	
		/**
		 * In-Game: "Mini-crits targets launched airborne by explosions, grapple hooks or rocket packs"
		 * 
		 * Mini-crits targets launched airborne by an explosion.
		 * 
		 * Only procs when not in Mannpower mode.
		 */
		open val minicritAirborne: ItemAttributeNamed<Boolean> = ItemAttributeNamed("mod mini-crit airborne")
	
		/**
		 * In-Game: "Mini-crits targets when fired at their back from close range"
		 * 
		 * If true, minicrits targets facing away from the attacker that are within 22.6 HU of the attacker (sqrt 512).
		 */
		open val closerangeBackattackMinicrits: ItemAttributeNamed<Boolean> = ItemAttributeNamed("closerange backattack minicrits")
	
		/**
		 * In-Game: "Crits whenever it would normally mini-crit"
		 */
		open val minicritsBecomeCrits: ItemAttributeNamed<Boolean> = ItemAttributeNamed("minicrits become crits")
	
		/**
		 * In-Game: "No critical hits vs non-burning players"
		 * 
		 * Note: Even prevents criticals when crit-boosted.
		 */
		open val noCritVsNonburning: ItemAttributeNamed<Boolean> = ItemAttributeNamed("no crit vs nonburning")
	
		/**
		 * In-Game: "Critical damage is affected by range"
		 * 
		 * If true, crits have damage falloff (Ambassador).
		 */
		open val critDmgFalloff: ItemAttributeNamed<Boolean> = ItemAttributeNamed("crit_dmg_falloff")
	
		/**
		 * In-Game: "Minicrits whenever it would normally crit"
		 */
		open val critsBecomeMinicrits: ItemAttributeNamed<Boolean> = ItemAttributeNamed("crits_become_minicrits")
	}
	
	open class DamageAttributes : BaseCombatWeaponAttributes.DamageAttributes() {
		/**
		 * Bonus:
		 * 
		 * 	- In-Game: "+N% damage bonus"
		 * 
		 * Penalty:
		 * 
		 * 	- In-Game: "N% damage penalty"
		 * 
		 * Neutral:
		 * 
		 * 	- In-Game: "+N% damage bonus"
		 * 
		 * Hidden:
		 * 
		 * 	- In-Game: "+N% damage bonus"
		 */
		open val multDmg: BonusPenaltyNeutralHidden<Number, ItemAttributeNamed<Number>> = BonusPenaltyNeutralHidden(
		    ItemAttributeNamed<Number>("damage bonus"),
		    ItemAttributeNamed<Number>("damage penalty"),
		    ItemAttributeNamed<Number>("CARD: damage bonus"),
		    ItemAttributeNamed<Number>("damage bonus HIDDEN"),
		)
	
		/**
		 * Visible:
		 * 
		 * 	- In-Game: "+N% damage vs buildings"
		 * 
		 * 
		 * 
		 * Hidden:
		 * 
		 * 	- In-Game: "N% damage penalty vs buildings"
		 */
		open val multDmgVsBuildings: VisHidden<Number> = VisHidden(
		    ItemAttributeNamed("dmg bonus vs buildings"),
		    ItemAttributeNamed("dmg penalty vs buildings")
		)
	
		/**
		 * In-Game: "N% damage vs players"
		 */
		open val dmgPenaltyVsPlayers: ItemAttributeNamed<Number> = ItemAttributeNamed("dmg penalty vs players")
	
		/**
		 * In-Game: "N% damage vs non-burning players"
		 */
		open val dmgPenaltyVsNonburning: ItemAttributeNamed<Number> = ItemAttributeNamed("dmg penalty vs nonburning")
	
		/**
		 * In-Game: "N% damage bonus vs burning players"
		 */
		open val damageBonusVsBurning: ItemAttributeNamed<Number> = ItemAttributeNamed("damage bonus vs burning")
	
		/**
		 * In-Game: "Attacks pierce damage resistance effects and bonuses"
		 * 
		 * Damage pierces through all resistances, such as Vaccinator ubercharges and the Battalion's Backup.
		 */
		open val dmgPiercesResistsAbsorbs: ItemAttributeNamed<Boolean> = ItemAttributeNamed("dmg pierces resists absorbs")
	
		/**
		 * In-Game: "N% increased damage to your sentry's target"
		 */
		open val damageBonusBulletVsSentryTarget: ItemAttributeNamed<Number> = ItemAttributeNamed("damage bonus bullet vs sentry target")
	
		/**
		 * In-Game: "N% damage on body shot"
		 * 
		 * Multiplier applied to bodyshot damage.
		 */
		open val damagePenaltyOnBodyshot: ItemAttributeNamed<Number> = ItemAttributeNamed("damage penalty on bodyshot")
	
		override val alien: AlienAttributes = AlienAttributes()
	
		open class AlienAttributes : BaseCombatWeaponAttributes.DamageAttributes.AlienAttributes() 
	}
	
	open class DemoChargeAttributes : BaseCombatWeaponAttributes.DemoChargeAttributes() {
		/**
		 * In-Game: "Melee hits refill  N% of your charge meter."
		 * 
		 * Restores demoman shield charge on hit.
		 */
		open val chargeMeterOnHit: ItemAttributeNamed<Number> = ItemAttributeNamed("charge meter on hit")
	
		/**
		 * In-Game: "Ammo boxes collected also give Charge"
		 * 
		 * If true, and player has a demoman charge meter, add charge based on ammo pack size.
		 */
		open val ammoPacksGiveDemoknightCharge: ItemAttributeNamed<Boolean> = ItemAttributeNamed("ammo gives charge")
	
		/**
		 * Default is 0.45f, and this is a multiplier applied to it.
		 */
		override val multChargeTurnControl: ChargeTurnControlAttributes = ChargeTurnControlAttributes()
	
		open class ChargeTurnControlAttributes : BaseCombatWeaponAttributes.DemoChargeAttributes.ChargeTurnControlAttributes(), ItemAttribute<Number> 
	}
	
	open class FiringAttributes : BaseCombatWeaponAttributes.FiringAttributes() {
		/**
		 * Bonus:
		 * 
		 * 	- In-Game: "Hold Fire to load up to three rockets Release Fire to unleash the barrage"
		 * 
		 * Penalty:
		 */
		open val autoFiresFullClip: BonusPenalty<Boolean> = BonusPenalty(
		    ItemAttributeNamed("auto fires full clip"),
		    ItemAttributeNamed("auto fires full clip penalty"),
		)
	
		open val autoFiresFullClipAllAtOnce: ItemAttributeNamed<Boolean> = ItemAttributeNamed("auto fires full clip all at once")
	
		open val autoFiresWhenFull: ItemAttributeNamed<Boolean> = ItemAttributeNamed("auto fires when full")
	
		/**
		 * In-Game: "Overloading the chamber will cause a misfire"
		 * 
		 * Deals damage to the player when overloaded.
		 */
		open val canOverload: ItemAttributeNamed<Boolean> = ItemAttributeNamed("can overload")
	
		open val fireRate: FireRateAttributes = FireRateAttributes()
	
		open class FireRateAttributes : IBlockScoped {
			/**
			 * Bonus:
			 * 
			 * 	- In-Game: "+N% faster firing speed"
			 * 
			 * Penalty:
			 * 
			 * 	- In-Game: "N% slower firing speed"
			 * 
			 * Neutral:
			 * 
			 * 	- In-Game: "+N% faster melee attack speed"
			 * 
			 * Hidden:
			 */
			open val multPostFireDelay: BonusPenaltyNeutralHidden<Number, BonusPenalty<Number>> = BonusPenaltyNeutralHidden(
			    ItemAttributeNamed<Number>("fire rate bonus"),
			    ItemAttributeNamed<Number>("fire rate penalty"),
			    ItemAttributeNamed<Number>("melee attack rate bonus"),
			    BonusPenalty(
			        ItemAttributeNamed<Number>("fire rate bonus HIDDEN"),
			        ItemAttributeNamed<Number>("fire rate penalty HIDDEN"),
			    ),
			)
		}
	}
	
	open class HealthAndHealingAttributes : BaseCombatWeaponAttributes.HealthAndHealingAttributes() {
		/**
		 * In-Game: "Blocks healing while in use"
		 * 
		 * Prevents mediguns/dispensers from targeting you and crossbow bolts from healing you while the weapon is active.
		 */
		override val weaponBlocksHealing: ItemAttributeNamed<Boolean> get() = super.weaponBlocksHealing
	
		/**
		 * Bonus:
		 * 
		 * 	- In-Game: "+N health regenerated per second on wearer"
		 * 
		 * Penalty:
		 * 
		 * 	- In-Game: "N health drained per second on wearer"
		 */
		open val activeItemHealthRegen: BonusPenalty<Int> = BonusPenalty(
		    ItemAttributeNamed("active health regen"),
		    ItemAttributeNamed("active health degen"),
		)
	
		/**
		 * In-Game: "+N% ÜberCharge rate for the medic healing you This effect does not work in the respawn room"
		 * 
		 * Multiplier applied to your healer's ubercharge rate.
		 * 
		 * NOTE: Only applied if user is outside of the respawn room.
		 */
		open val uberchargeRateBonusForHealer: ItemAttributeNamed<Number> = ItemAttributeNamed("ubercharge rate bonus for healer")
	
		/**
		 * In-Game: "On Hit: Gain up to +N health per attack"
		 * 
		 * Maximum amount of health that can be gained from an AoE damage source.
		 * 
		 * Health received is multiplied by `damage dealt / base damage of the weapon`, to a max of 100% of the defined value.
		 */
		open val healOnHit_radial: ItemAttributeNamed<Int> = ItemAttributeNamed("health on radius damage")
	
		/**
		 * In-Game: "N% health from healers on wearer"
		 * 
		 * Attribute class is a flat multiplier applied to health from healers while weapon is active.
		 */
		open val multHealthFromHealersWhileActive: ItemAttributeNamed<Number> = ItemAttributeNamed("mult_health_fromhealers_penalty_active")
	
		/**
		 * In-Game: "N% Overheal build rate."
		 * 
		 * Checked on the player that is healing an entity.
		 */
		open val multOverhealFillRate: ItemAttributeNamed<Number> = ItemAttributeNamed("overheal fill rate reduced")
	
		/**
		 * In-Game: "N% less healing from Medic sources"
		 * 
		 * Applies to all non-dispenser forms of healing that apply the `TF_COND_HEAL_BUFF` status.
		 */
		override val multHealingFromMedics: ItemAttributeNamed<Number> get() = super.multHealingFromMedics
	
		/**
		 * Bonus:
		 * 
		 * 	- In-Game: "+N% bonus healing from all sources"
		 * 
		 * Penalty:
		 * 
		 * 	- In-Game: "N% less healing from all sources"
		 */
		open val multHealingReceived: BonusPenalty<Number> = BonusPenalty(
		    ItemAttributeNamed("healing received bonus"),
		    ItemAttributeNamed("healing received penalty"),
		)
	
		/**
		 * In-Game: "Maximum health is drained while item is active"
		 * 
		 * Maximum health decrease per tick while weapon is active. (Gloves of Running Urgently/Eviction Notice).
		 */
		open val maxHealthDrainedWhileActive: ItemAttributeNamed<Number> = ItemAttributeNamed("mod_maxhealth_drain_rate")
	
		/**
		 * Amount of health regenerated per regen tick.  Scales by the amount of time since the player last took damage in non-MvM modes.
		 */
		override val healthRegenPerSecond: AddHealthRegenAttributes = AddHealthRegenAttributes()
	
		/**
		 * Additive maximum health increase. Influences the player's overheal cap.
		 */
		override val addMaxHealth: AddMaxhealthAttributes = AddMaxhealthAttributes()
	
		open class AddHealthRegenAttributes : BaseCombatWeaponAttributes.HealthAndHealingAttributes.AddHealthRegenAttributes(), ItemAttribute<Int> 
	
		open class AddMaxhealthAttributes : BaseCombatWeaponAttributes.HealthAndHealingAttributes.AddMaxhealthAttributes(), ItemAttribute<Int> 
	}
	
	open class KnockbackReceivedAttributes : BaseCombatWeaponAttributes.KnockbackReceivedAttributes() {
		/**
		 * Bonus:
		 * 
		 * 	- In-Game: "+N% self damage force"
		 * 
		 * Penalty:
		 * 
		 * 	- In-Game: "N% self damage force"
		 */
		open val multDmgselfPushForce: BonusPenalty<Number> = BonusPenalty(
		    ItemAttributeNamed("self dmg push force increased"),
		    ItemAttributeNamed("self dmg push force decreased"),
		)
	
		/**
		 * Attribute class is a flat multiplier applied to push force received from damage.
		 */
		open val damageForceReduction: DamageForceReductionAttributes = DamageForceReductionAttributes()
	
		open class DamageForceReductionAttributes : IBlockScoped {
			/**
			 * In-Game: "N% reduction in push force taken from damage"
			 * 
			 * Attribute class is a flat multiplier applied to push force received from damage.
			 */
			open val damageForceReduction: ItemAttributeNamed<Number> = ItemAttributeNamed("damage force reduction")
	
			/**
			 * In-Game: "N% increase in push force taken from damage"
			 * 
			 * Attribute class is a flat multiplier applied to push force received from damage.
			 */
			open val damageForceIncrease: ItemAttributeNamed<Number> = ItemAttributeNamed("damage force increase")
	
			/**
			 * In-Game: "N% increase in push force taken from damage"
			 * 
			 * Attribute class is a flat multiplier applied to push force received from damage.
			 */
			open val damageForceIncreaseHidden: ItemAttributeNamed<Number> = ItemAttributeNamed("damage force increase hidden")
	
			/**
			 * In-Game: "Increase in push force taken from damage and airblast"
			 * 
			 * Attribute class is a flat multiplier applied to push force received from damage.
			 */
			open val damageForceIncreaseText: ItemAttributeNamed<Number> = ItemAttributeNamed("damage force increase text")
		}
	}
	
	open class MetaAttributes : BaseCombatWeaponAttributes.MetaAttributes() {
		/**
		 * What "Strange Part" kills with this weapon should contribute to.
		 */
		open val killEaterKillType: ItemAttributeNamed<Int> = ItemAttributeNamed("kill eater kill type")
	
		override val killfeed: KillfeedAttributes = KillfeedAttributes()
	
		open val viewmodel: ViewmodelAttributes = ViewmodelAttributes()
	
		override val items: ItemsAttributes = ItemsAttributes()
	
		override val particles: ParticlesAttributes = ParticlesAttributes()
	
		override val noisemakers: NoisemakersAttributes = NoisemakersAttributes()
	
		override val player: PlayerAttributes = PlayerAttributes()
	
		override val gameplay: GameplayAttributes = GameplayAttributes()
	
		open class KillfeedAttributes : BaseCombatWeaponAttributes.MetaAttributes.KillfeedAttributes() {
			open val isGigerCounter: ItemAttributeNamed<Boolean> = ItemAttributeNamed("is giger counter")
	
			/**
			 * Sets killfeed background gold.
			 */
			open val isAustraliumItem: ItemAttributeNamed<Boolean> = ItemAttributeNamed("is australium item")
	
			/**
			 * In-Game: "Imbued with an ancient power"
			 * 
			 * Sets killfeed background gold.
			 */
			open val turnToGold: ItemAttributeNamed<Boolean> = ItemAttributeNamed("turn to gold")
	
			/**
			 * In-Game: "Silent Killer: No attack noise from backstabs"
			 * 
			 * Kills will not show up in the killfeed.
			 */
			open val silentKiller: ItemAttributeNamed<Boolean> = ItemAttributeNamed("silent killer")
		}
	
		open class ViewmodelAttributes : IBlockScoped {
			open val weaponAllowInspect: ItemAttributeNamed<Boolean> = ItemAttributeNamed("weapon_allow_inspect")
	
			open val weaponStattrakModuleScale: ItemAttributeNamed<Number> = ItemAttributeNamed("weapon_stattrak_module_scale")
	
			open val minViewmodelOffset: ItemAttributeNamed<String> = ItemAttributeNamed("min_viewmodel_offset")
		}
	
		open class ItemsAttributes : BaseCombatWeaponAttributes.MetaAttributes.ItemsAttributes() 
	
		open class ParticlesAttributes : BaseCombatWeaponAttributes.MetaAttributes.ParticlesAttributes() 
	
		open class NoisemakersAttributes : BaseCombatWeaponAttributes.MetaAttributes.NoisemakersAttributes() 
	
		open class PlayerAttributes : BaseCombatWeaponAttributes.MetaAttributes.PlayerAttributes() 
	
		open class GameplayAttributes : BaseCombatWeaponAttributes.MetaAttributes.GameplayAttributes() 
	}
	
	open class MeterAttributes : BaseCombatWeaponAttributes.MeterAttributes() {
		/**
		 * In-Game: "+N% increase in recharge rate"
		 * 
		 * For things like throwable recharge timers, jetpack charging, etc: how much it recharges per second.
		 */
		open val effectBarRechargeRateIncreased: ItemAttributeNamed<Number> = ItemAttributeNamed("effect bar recharge rate increased")
	
		/**
		 * Only works on Engineer and Heavy.
		 * 
		 * On Engineer, adds all damage dealt to the rage meter.
		 * 
		 * On Heavy, adds `0.22` * the damage to the meter, and reduces damage by 50% while the meter is draining.
		 */
		override val generateRageOnDmg: GenerateRageOnDmgAttributes = GenerateRageOnDmgAttributes()
	
		open class GenerateRageOnDmgAttributes : BaseCombatWeaponAttributes.MeterAttributes.GenerateRageOnDmgAttributes(), ItemAttribute<Boolean> 
	}
	
	open class MovementAttributes : BaseCombatWeaponAttributes.MovementAttributes() {
		/**
		 * In-Game: "+N% greater jump height when active"
		 * 
		 * Only takes effect while this weapon is active.
		 */
		open val increasedJumpHeightFromWeapon: ItemAttributeNamed<Number> = ItemAttributeNamed("increased jump height from weapon")
	
		/**
		 * In-Game: "Grants Triple Jump while deployed. Melee attacks mini-crit while airborne."
		 * 
		 * If greater than 0, attacks minicrit while airborne.
		 * 
		 * Only procs on Scout.
		 */
		open val airDashCount: ItemAttributeNamed<Int> = ItemAttributeNamed("air dash count")
	
		override val moveSpeed: MoveSpeedAttributes = MoveSpeedAttributes()
	
		override val multJumpHeight: ModJumpHeightAttributes = ModJumpHeightAttributes()
	
		open class MoveSpeedAttributes : BaseCombatWeaponAttributes.MovementAttributes.MoveSpeedAttributes() {
			/**
			 * Multiplier applied to movement speed scaled by ubercharge percentage.
			 * 
			 * Only works if the player using this item is a Medic with a Medigun.
			 */
			open val moveSpeedBonusResourceLevel: ItemAttributeNamed<Number> = ItemAttributeNamed("move speed bonus resource level")
	
			/**
			 * In-Game: "+N% faster move speed on wearer"
			 * 
			 * Multiplier applied to player movement speed only while this is the active weapon.
			 */
			open val multPlayerMovespeedActive: ItemAttributeNamed<Number> = ItemAttributeNamed("mult_player_movespeed_active")
	
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
	
			open class MultPlayerAimingMovespeedAttributes : BaseCombatWeaponAttributes.MovementAttributes.MoveSpeedAttributes.MultPlayerAimingMovespeedAttributes() 
	
			open class MultPlayerMovespeedAttributes : BaseCombatWeaponAttributes.MovementAttributes.MoveSpeedAttributes.MultPlayerMovespeedAttributes(), ItemAttribute<Number> 
		}
	
		open class ModJumpHeightAttributes : BaseCombatWeaponAttributes.MovementAttributes.ModJumpHeightAttributes(), ItemAttribute<Number> 
	}
	
	open class HeadsAttributes : BaseCombatWeaponAttributes.HeadsAttributes() 
	
	open class OnHitAttributes : BaseCombatWeaponAttributes.OnHitAttributes() {
		/**
		 * In-Game: "+N% cloak on hit"
		 * 
		 * Adds this amount of cloak on hit.
		 * 
		 * Only procs on Spy.
		 */
		open val addCloak: ItemAttributeNamed<Int> = ItemAttributeNamed("add cloak on hit")
	
		/**
		 * In-Game: "On Hit: damage dealt is returned as ammo"
		 * 
		 * Gain ammo equivalent to damage dealt on hit.
		 */
		open val addOnhitAddammo: ItemAttributeNamed<Boolean> = ItemAttributeNamed("add onhit addammo")
	
		/**
		 * In-Game: "On Hit Spy: Reveal cloaked Spy"
		 */
		open val revealCloakedVictim: ItemAttributeNamed<Boolean> = ItemAttributeNamed("reveal cloaked victim on hit")
	
		/**
		 * In-Game: "On Hit Spy: Reveal disguised Spy"
		 */
		open val revealDisguisedVictim: ItemAttributeNamed<Boolean> = ItemAttributeNamed("reveal disguised victim on hit")
	
		/**
		 * Add this amount of health on hit.
		 */
		open val addOnhitAddhealth: AddOnhitAddhealthAttributes = AddOnhitAddhealthAttributes()
	
		/**
		 * In-Game: "On Hit: Gain a speed boost"
		 * 
		 * Just does `addcond(SPEED_BOOST, speed_boost_on_hit)`.
		 */
		open val speedBoost: ItemAttributeNamed<Int> = ItemAttributeNamed("speed_boost_on_hit")
	
		/**
		 * In-Game: "On Hit: N% ÜberCharge added"
		 * 
		 * Only procs if on a Medic.
		 */
		open val addUberCharge: ItemAttributeNamed<Number> = ItemAttributeNamed("add uber charge on hit")
	
		/**
		 * Bonus:
		 * 
		 * 	- In-Game: "N% rage gained on hit"
		 * 
		 * Penalty:
		 * 
		 * 	- In-Game: "N% rage lost on hit"
		 */
		open val rage: BonusPenalty<Int> = BonusPenalty(
		    ItemAttributeNamed("mod rage on hit bonus"),
		    ItemAttributeNamed("mod rage on hit penalty"),
		)
	
		/**
		 * In-Game: "On Hit: Builds Boost Run speed increased with Boost"
		 * 
		 * Gain Scout's "hype" meter on hit.
		 * 
		 * This exists for everything, but specifically modifies Scout's "hype" meter, which is only used for the Soda Popper and Baby Face's Blaster.
		 */
		open val boostOnDamage: ItemAttributeNamed<Boolean> = ItemAttributeNamed("boost on damage")
	
		/**
		 * Knockback rage on enemy if you're a heavy and your rage is draining.
		 */
		open val generateRageOnDmg: GenerateRageOnDmgAttributes = GenerateRageOnDmgAttributes()
	
		/**
		 * In-Game: "On Hit: One target at a time is Marked-For-Death, causing all damage taken to be mini-crits"
		 */
		open val markForDeath: ItemAttributeNamed<Boolean> = ItemAttributeNamed("mark for death")
	
		/**
		 * In-Game: "On Hit: If enemy's belt is at or above eye level, stun them for N seconds"
		 * 
		 * Stun airborne targets.
		 */
		open val stunWaistHighAirborne: ItemAttributeNamed<Boolean> = ItemAttributeNamed("mod stun waist high airborne")
	
		/**
		 * In-Game: "On Hit: Victim loses up to N% Medigun charge"
		 * 
		 * Percentage as an int, e.g. `25` = 25% = 0.25.
		 * 
		 * Drain scaled over distance.
		 */
		open val subtractVictimMedigunCharge: ItemAttributeNamed<Int> = ItemAttributeNamed("subtract victim medigun charge on hit")
	
		/**
		 * In-Game: "On Hit: Victim loses up to N% cloak"
		 * 
		 * Subtracts an actual value.
		 * 
		 * Drain still scaled over distance.
		 */
		open val subtractVictimCloak: ItemAttributeNamed<Int> = ItemAttributeNamed("subtract victim cloak on hit")
	
		/**
		 * In-Game: "On Hit: N% chance to slow target"
		 * 
		 * Gain speedboost on hit.
		 */
		open val slowEnemy: ItemAttributeNamed<Number> = ItemAttributeNamed("slow enemy on hit")
	
		/**
		 * In-Game: "On Hit: Slow target movement by 40% for Ns"
		 * 
		 * Gain speedboost for N seconds.
		 */
		open val slowEnemyMajor: ItemAttributeNamed<Number> = ItemAttributeNamed("slow enemy on hit major")
	
		/**
		 * In-Game: "Syringes deliver a highly concentrated dose of Mad Milk. Duration increases per hit to a max of 4 seconds."
		 * 
		 * Applies Mad Milk with a duration of 4 seconds, and each subsequent hit on the same target adds 0.5 seconds to the duration.
		 */
		open val madMilkSyringes: ItemAttributeNamed<Boolean> = ItemAttributeNamed("mad milk syringes")
	
		/**
		 * In-Game: "Stuns enemies who are also wielding this weapon"
		 */
		open val stunEnemiesWieldingSameWeapon: ItemAttributeNamed<Boolean> = ItemAttributeNamed("stun enemies wielding same weapon")
	
		/**
		 * In-Game: "All players connected via Medigun beams are hit"
		 * 
		 * Damage all players connected to the target by medigun beams.
		 */
		open val damageAllConnected: ItemAttributeNamed<Boolean> = ItemAttributeNamed("damage all connected")
	
		/**
		 * Apply this amount of z velocity to players hit with this weapon.
		 */
		open val applyZVelocityOnDamage: ItemAttributeNamed<Number> = ItemAttributeNamed("apply z velocity on damage")
	
		/**
		 * Apply this amount of velocity in the direction you're facing to players hit with this weapon.
		 */
		open val applyLookVelocityOnDamage: ItemAttributeNamed<Number> = ItemAttributeNamed("apply look velocity on damage")
	
		/**
		 * Push force applied to target when hitting an enemy.
		 * 
		 * Scales by range, to a minimum of 50% of the given value.
		 */
		open val damageBlastPush: ItemAttributeNamed<Number> = ItemAttributeNamed("damage blast push")
	
		/**
		 * In-Game: "On Hit: Bleed for N seconds"
		 * 
		 * Apply bleed on hit.
		 * 
		 * Value is a time in seconds.
		 */
		open val bleedingDuration: ItemAttributeNamed<Number> = ItemAttributeNamed("bleeding duration")
	
		override val falling: FallingAttributes = FallingAttributes()
	
		open class AddOnhitAddhealthAttributes : IBlockScoped {
			/**
			 * In-Game: "On Hit: Gain up to +N health"
			 * 
			 * Add this amount of health on hit.
			 */
			open val healOnHitForRapidfire: ItemAttributeNamed<Int> = ItemAttributeNamed("heal on hit for rapidfire")
	
			/**
			 * In-Game: "On Hit: N health"
			 * 
			 * Add this amount of health on hit.
			 */
			open val selfdmgOnHitForRapidfire: ItemAttributeNamed<Int> = ItemAttributeNamed("selfdmg on hit for rapidfire")
	
			/**
			 * In-Game: "On Hit: Gain up to +N health"
			 * 
			 * Add this amount of health on hit.
			 */
			open val healOnHitForSlowfire: ItemAttributeNamed<Int> = ItemAttributeNamed("heal on hit for slowfire")
	
			/**
			 * In-Game: "On Hit: N health"
			 * 
			 * Add this amount of health on hit.
			 */
			open val selfdmgOnHitForSlowfire: ItemAttributeNamed<Int> = ItemAttributeNamed("selfdmg on hit for slowfire")
		}
	
		open class GenerateRageOnDmgAttributes : IBlockScoped, ItemAttribute<Boolean> {
			/**
			 * In-Game: "Generate Rage by dealing damage.  When fully charged, press the Special-Attack key to activate knockback"
			 * 
			 * Knockback rage on enemy if you're a heavy and your rage is draining.
			 */
			open val standard: ItemAttributeNamed<Boolean> = ItemAttributeNamed("generate rage on damage")
	
			/**
			 * In-Game: "Generate building rescue energy on damage"
			 * 
			 * Knockback rage on enemy if you're a heavy and your rage is draining.
			 */
			open val buildingRescue: ItemAttributeNamed<Boolean> = ItemAttributeNamed("engineer rage on dmg")
	
			context(attrs: IAttributeContainer)
			override fun set(value: Boolean?) {
			    standard.set(value)
			}
	
			context(attrs: IAttributeContainer)
			override fun get(): Boolean? {
			    return standard.get()
			}
	
			override fun serialize(value: Boolean?): IVDFRepresentableKeyValue {
			    return standard.serialize(value)
			}
		}
	
		open class FallingAttributes : BaseCombatWeaponAttributes.OnHitAttributes.FallingAttributes() 
	}
	
	open class OnKillAttributes : BaseCombatWeaponAttributes.OnKillAttributes() {
		/**
		 * In-Game: "On Kill: N seconds of 100% critical chance"
		 * 
		 * Seconds of crit-boost gained on kill.
		 * 
		 * Note: actual time is `this + 1`.
		 */
		open val critboost: ItemAttributeNamed<Int> = ItemAttributeNamed("critboost on kill")
	
		/**
		 * In-Game: "On Kill: Gain Mini-crits for N seconds."
		 * 
		 * Seconds of minicrit-boost gained on kill.
		 * 
		 * Note: actual time is `this + 1`.
		 */
		open val minicritboost: ItemAttributeNamed<Int> = ItemAttributeNamed("minicritboost on kill")
	
		/**
		 * In-Game: "On Kill: Gain N% of base health on kill"
		 * 
		 * Percentage of health to be restored upon killing an enemy. (e.g. `25` is 25%).
		 * 
		 * Post-heal player health value is capped at 1.5x the player's normal max health.
		 * 
		 * Negative values are ignored.
		 */
		open val restoreHealthPercent: ItemAttributeNamed<Int> = ItemAttributeNamed("restore health on kill")
	
		/**
		 * In-Game: "+N health restored on kill"
		 * 
		 * Restores this flat amount of health on killing an enemy. Post-heal player health value is capped at the player's maximum overheal.
		 * 
		 * Negative values are NOT ignored.
		 */
		open val restoreHealthFlat: ItemAttributeNamed<Int> = ItemAttributeNamed("heal on kill")
	
		/**
		 * In-Game: "Gain a speed boost on kill"
		 */
		open val speedBoost: ItemAttributeNamed<Int> = ItemAttributeNamed("speed_boost_on_kill")
	
		/**
		 * In-Game: "Exorcism"
		 * 
		 * Exorcism spell effect.
		 */
		open val spellHalloweenDeathGhosts: ItemAttributeNamed<Boolean> = ItemAttributeNamed("SPELL: Halloween death ghosts")
	}
	
	open class ProjectilesAttributes : IBlockScoped {
		/**
		 * Bonus:
		 * 
		 * 	- In-Game: "N% splash damage fall off"
		 * 
		 * Penalty:
		 */
		open val multDmgFalloff: BonusPenalty<Number> = BonusPenalty(
		    ItemAttributeNamed("dmg falloff decreased"),
		    ItemAttributeNamed("dmg falloff increased"),
		)
	
		/**
		 * How many players your "projectile" (*including bullets*) should penetrate.
		 */
		open val penetration: ProjectilePenetrationAttributes = ProjectilePenetrationAttributes()
	
		/**
		 * Note: "Projectile" includes bullets.
		 */
		open val centerfire: ItemAttributeNamed<Boolean> = ItemAttributeNamed("centerfire projectile")
	
		/**
		 * In-Game: "+N degrees random projectile deviation"
		 * 
		 * Does not include bullets.
		 */
		open val spreadAnglePenalty: ItemAttributeNamed<Number> = ItemAttributeNamed("projectile spread angle penalty")
	
		open val bullets: BulletsAttributes = BulletsAttributes()
	
		open class ProjectilePenetrationAttributes : IBlockScoped, ItemAttribute<Int> {
			/**
			 * In-Game: "Projectiles penetrate enemy players"
			 * 
			 * How many players your "projectile" (*including bullets*) should penetrate.
			 */
			open val projectiles: ItemAttributeNamed<Int> = ItemAttributeNamed("projectile penetration")
	
			/**
			 * In-Game: "Bullets penetrate +N enemies"
			 * 
			 * How many players your "projectile" (*including bullets*) should penetrate.
			 */
			open val bullets: ItemAttributeNamed<Int> = ItemAttributeNamed("projectile penetration heavy")
	
			context(attrs: IAttributeContainer)
			override fun set(value: Int?) {
			    projectiles.set(value)
			}
	
			context(attrs: IAttributeContainer)
			override fun get(): Int? {
			    return projectiles.get()
			}
	
			override fun serialize(value: Int?): IVDFRepresentableKeyValue {
			    return projectiles.serialize(value)
			}
		}
	
		open class BulletsAttributes : IBlockScoped {
			/**
			 * In-Game: "+N% bullets per shot"
			 */
			open val modBulletsPerShot: ItemAttributeNamed<Number> = ItemAttributeNamed("bullets per shot bonus")
	
			/**
			 * In-Game: "Fires tracer rounds"
			 * 
			 * Note: Sniper rage forcibly draws a tracer regardless of this setting.
			 * 
			 * Used when firing bullets.
			 */
			open val sniperFiresTracer: ItemAttributeNamed<Boolean> = ItemAttributeNamed("sniper fires tracer")
	
			/**
			 * In-Game: "Fires tracer rounds"
			 * 
			 * Same as `sniper_fires_tracer`.
			 */
			open val sniperFiresTracerHidden: ItemAttributeNamed<Boolean> = ItemAttributeNamed("sniper fires tracer HIDDEN")
	
			/**
			 * In-Game: "On Full Charge: Projectiles penetrate players"
			 */
			open val penetratesWhenFullyCharged: ItemAttributeNamed<Boolean> = ItemAttributeNamed("sniper penetrate players when charged")
	
			/**
			 * In-Game: "Increased headshot explosion radius and damage to nearby enemies"
			 * 
			 * Only applies if in a gamemode with upgrades, but applies to all headshots.
			 * 
			 * Also applies to any hitscan weapon with a `jarate_time` attribute that hit the head.
			 */
			open val explosiveHeadshotLevel: ItemAttributeNamed<Int> = ItemAttributeNamed("explosive sniper shot")
		}
	}
	
	open class ReloadingAttributes : IBlockScoped {
		/**
		 * Bonus:
		 * 
		 * 	- In-Game: "N% faster reload time"
		 * 
		 * Penalty:
		 * 
		 * 	- In-Game: "N% slower reload time"
		 */
		open val multReloadTime: BonusPenalty<Number> = BonusPenalty(
		    ItemAttributeNamed("Reload time decreased"),
		    ItemAttributeNamed("Reload time increased"),
		)
	
		/**
		 * In-Game: "N% slower reload time"
		 */
		open val reloadTimeIncreasedHidden: ItemAttributeNamed<Number> = ItemAttributeNamed("reload time increased hidden")
	
		/**
		 * In-Game: "+N% faster reload time"
		 * 
		 * This is what's used for weapons that draw directly from reserve ammo, like the flare gun and sniper rifle.
		 */
		open val fasterReloadRate: ItemAttributeNamed<Number> = ItemAttributeNamed("faster reload rate")
	
		/**
		 * Halloween reload time multiplier.
		 * 
		 * Checked on player.
		 */
		open val halloweenReloadTimeDecreased: ItemAttributeNamed<Number> = ItemAttributeNamed("halloween reload time decreased")
	
		/**
		 * In-Game: "N% faster reload time while being healed"
		 */
		open val reloadTimeDecreasedWhileHealed: ItemAttributeNamed<Number> = ItemAttributeNamed("reload time decreased while healed")
	}
	
	open class ResistanceAttributes : BaseCombatWeaponAttributes.ResistanceAttributes() {
		/**
		 * In-Game: "On Hit by Fire: Fireproof for 1 second and Afterburn immunity for N seconds"
		 * 
		 * Addcond parameter.
		 */
		open val becomeFireproofOnHitByFire: ItemAttributeNamed<Number> = ItemAttributeNamed("become fireproof on hit by fire")
	
		/**
		 * In-Game: "N% damage vulnerability on wearer"
		 */
		open val multDmgtakenActive: ItemAttributeNamed<Number> = ItemAttributeNamed("mult_dmgtaken_active")
	
		/**
		 * In-Game: "+N% damage from melee sources while active"
		 * 
		 * Multiplier applied to incoming melee damage.
		 */
		open val dmgFromMeleeIncreased: ItemAttributeNamed<Number> = ItemAttributeNamed("dmg from melee increased")
	
		/**
		 * In-Game: "N% damage from ranged sources while active"
		 * 
		 * Multiplier applied to incoming blast, bullet, buckshot, ignite, and sonic damage.
		 */
		open val dmgFromRangedReduced: ItemAttributeNamed<Number> = ItemAttributeNamed("dmg from ranged reduced")
	
		/**
		 * In-Game: "No self inflicted blast damage taken"
		 * 
		 * Also forces the "whistling" sound to play when rocket jumping.
		 */
		open val noSelfBlastDmg: ItemAttributeNamed<Boolean> = ItemAttributeNamed("no self blast dmg")
	
		/**
		 * In-Game: "+N% damage to self"
		 * 
		 * Multiplier applied to blast damage taken from an explosion caused by said entity.
		 */
		open val blastDmgToSelfIncreased: ItemAttributeNamed<Number> = ItemAttributeNamed("blast dmg to self increased")
	
		/**
		 * In-Game: "+N% fire damage resistance while deployed"
		 * 
		 * Resist this proportion of fire damage only while this weapon is active.
		 */
		open val dmgTakenFromFireReducedOnActive: ItemAttributeNamed<Number> = ItemAttributeNamed("dmg taken from fire reduced on active")
	
		/**
		 * In-Game: "+N% damage vulnerability while active"
		 * 
		 * Increases damage taken while minicrit-boosted by Crit-a-Cola, Buffalo Steak, etc.
		 */
		open val energyBuffDmgTakenMultiplier: ItemAttributeNamed<Number> = ItemAttributeNamed("energy buff dmg taken multiplier")
	
		/**
		 * In-Game: "The wearer cannot be killed by headshots"
		 * 
		 * When a headshot would kill you, reduce health to 1.
		 */
		open val setBonusNoDeathFromHeadshots: ItemAttributeNamed<Boolean> = ItemAttributeNamed("SET BONUS: no death from headshots")
	
		override val multDmgTakenCrits: MultDmgtakenFromCritAttributes = MultDmgtakenFromCritAttributes()
	
		override val multDmgTakenFire: MultDmgtakenFromFireAttributes = MultDmgtakenFromFireAttributes()
	
		override val multDmgTakenBullets: MultDmgtakenFromBulletsAttributes = MultDmgtakenFromBulletsAttributes()
	
		override val vaccinator: VaccinatorAttributes = VaccinatorAttributes()
	
		open class MultDmgtakenFromCritAttributes : BaseCombatWeaponAttributes.ResistanceAttributes.MultDmgtakenFromCritAttributes(), ItemAttribute<Number> 
	
		open class MultDmgtakenFromFireAttributes : BaseCombatWeaponAttributes.ResistanceAttributes.MultDmgtakenFromFireAttributes(), ItemAttribute<Number> 
	
		open class MultDmgtakenFromBulletsAttributes : BaseCombatWeaponAttributes.ResistanceAttributes.MultDmgtakenFromBulletsAttributes(), ItemAttribute<Number> 
	
		open class VaccinatorAttributes : BaseCombatWeaponAttributes.ResistanceAttributes.VaccinatorAttributes() 
	}
	
	open class RevengeCritsAttributes : IBlockScoped {
		/**
		 * In-Game: "Gives one guaranteed critical hit for each building destroyed with your sapper attached or backstab kill"
		 * 
		 * Weapon supports revenge crits if this, `extinguish_revenge`, or `sentry_killed_revenge` is set.
		 */
		open val sapperKillsCollectCrits: ItemAttributeNamed<Boolean> = ItemAttributeNamed("sapper kills collect crits")
	
		/**
		 * In-Game: "Alt-Fire: Extinguish teammates to gain guaranteed critical hits"
		 * 
		 * Weapon supports revenge crits if this, `sapper_kills_collect_crits`, or `sentry_killed_revenge` is set.
		 */
		open val extinguishEarnsRevengeCrits: ItemAttributeNamed<Boolean> = ItemAttributeNamed("extinguish earns revenge crits")
	
		/**
		 * In-Game: "Gain 2 revenge crits for each sentry kill and 1 for each sentry assist when your sentry is destroyed."
		 * 
		 * Weapon supports revenge crits if this, `sapper_kills_collect_crits`, or `extinguish_revenge` is set.
		 */
		open val canGainRevengeCrits: ItemAttributeNamed<Boolean> = ItemAttributeNamed("mod sentry killed revenge")
	}
	
	open class StatusEffectsAttributes : IBlockScoped {
		/**
		 * In-Game: "Ignited enemies explode"
		 * 
		 * Applies when *any weapon* with this attribute is in the second loadout slot of the player who covered someone in gas.  This attribute does not specifically check for the Gas Passer.  For example, if a Soldier has a rocket launcher that applies `TF_COND_GAS` and their shotgun in their secondary has this attribute, they'll still explode on ignite.
		 * 
		 * Only the afterburn specifically checks for the Gas Passer.
		 */
		open val explodeOnIgnite: ItemAttributeNamed<Boolean> = ItemAttributeNamed("explode_on_ignite")
	}
	
	open class TauntingAttributes : BaseCombatWeaponAttributes.TauntingAttributes() {
		/**
		 * In-Game: "Alt-Fire: Applies a healing effect to all nearby teammates"
		 * 
		 * Makes default weapon taunt perform the Amputator radial healing effect.
		 */
		open val enablesAoeHeal: ItemAttributeNamed<Boolean> = ItemAttributeNamed("enables aoe heal")
	
		/**
		 * If true, prevents holiday taunts from being used.
		 */
		open val specialTaunt: ItemAttributeNamed<Boolean> = ItemAttributeNamed("special taunt")
	}
	
	open class SwapWeaponsAttributes : BaseCombatWeaponAttributes.SwapWeaponsAttributes() {
		/**
		 * In-Game: "When weapon is active:"
		 * 
		 * If true, only applies attributes when weapon is active, and unapplies them when switching off.
		 * 
		 * I think this also means you can't have "only active when holding weapon" and "always active" attributes on the same weapon, since the order you specify attributes in doesn't matter.
		 */
		open val provideOnActive: ItemAttributeNamed<Boolean> = ItemAttributeNamed("provide on active")
	
		/**
		 * In-Game: "While not being healed by a medic, your weapon switch time is N% longer"
		 * 
		 * Multiplier applied if NOT being healed by a medic.
		 * 
		 * Checked on player.
		 */
		open val medicHealedDeployTimePenalty: ItemAttributeNamed<Number> = ItemAttributeNamed("mod medic healed deploy time penalty")
	
		/**
		 * Should force switch to this item when your current weapon is unavailable?.
		 */
		open val forceWeaponSwitch: ItemAttributeNamed<Boolean> = ItemAttributeNamed("force weapon switch")
	
		/**
		 * In-Game: "Honorbound: Once drawn sheathing deals 50 damage to yourself unless it kills."
		 * 
		 * Takes 50 health when holstering before it gets a kill.
		 */
		open val honorbound: ItemAttributeNamed<Boolean> = ItemAttributeNamed("honorbound")
	
		/**
		 * If greater than 0 (like with the Thermal Thruster), takes that amount of time to holster BEFORE actually swapping weapons.
		 */
		open val holsterAnimTime: ItemAttributeNamed<Number> = ItemAttributeNamed("holster_anim_time")
	
		open val deploy: DeployAttributes = DeployAttributes()
	
		open class DeployAttributes : IBlockScoped {
			/**
			 * Bonus:
			 * 
			 * 	- In-Game: "N% faster weapon switch"
			 * 
			 * Penalty:
			 * 
			 * 	- In-Game: "N% longer weapon switch"
			 */
			open val multDeployTime: BonusPenalty<Number> = BonusPenalty(
			    ItemAttributeNamed("deploy time decreased"),
			    ItemAttributeNamed("deploy time increased"),
			)
	
			/**
			 * Bonus:
			 * 
			 * 	- In-Game: "This weapon deploys N% faster"
			 * 
			 * Penalty:
			 * 
			 * 	- In-Game: "This weapon deploys N% slower"
			 */
			open val multSingleWepDeployTime: BonusPenalty<Number> = BonusPenalty(
			    ItemAttributeNamed("single wep deploy time decreased"),
			    ItemAttributeNamed("single wep deploy time increased"),
			)
	
			/**
			 * Bonus:
			 * 
			 * 	- In-Game: "This weapon holsters N% faster"
			 * 
			 * Penalty:
			 * 
			 * 	- In-Game: "This weapon holsters N% slower"
			 */
			open val multSwitchFromWepDeployTime: BonusPenalty<Number> = BonusPenalty(
			    ItemAttributeNamed("switch from wep deploy time decreased"),
			    ItemAttributeNamed("single wep holster time increased"),
			)
		}
	}
	
	open class WhenHitAttributes : BaseCombatWeaponAttributes.WhenHitAttributes() {
		/**
		 * Knocks back attacker when wielder receives damage.
		 */
		open val damageCausesAirblast: ItemAttributeNamed<Boolean> = ItemAttributeNamed("damage causes airblast")
	}
	
	open class RagdollsAttributes : IBlockScoped {
		/**
		 * In-Game: "Killing an enemy with a critical hit will dismember your victim. Painfully."
		 */
		open val critKillWillGib: ItemAttributeNamed<Boolean> = ItemAttributeNamed("crit kill will gib")
	
		/**
		 * If false, this weapon can only gib if it deals blast damage or over half of its damage falloff.
		 */
		open val critOnHardHit: ItemAttributeNamed<Boolean> = ItemAttributeNamed("crit on hard hit")
	
		/**
		 * In-Game: "Backstab turns victim to ice"
		 * 
		 * Upon killing an enemy with a backstab, replace their ragdoll with an ice statue.
		 */
		open val freezeBackstabVictim: ItemAttributeNamed<Boolean> = ItemAttributeNamed("freeze backstab victim")
	
		/**
		 * In-Game: "Imbued with an ancient power"
		 * 
		 * Saxxy/golden pan effect.
		 */
		open val turnToGold: ItemAttributeNamed<Boolean> = ItemAttributeNamed("turn to gold")
	
		/**
		 * Flamethrower kills.
		 */
		open val ragdollsBecomeAsh: ItemAttributeNamed<Boolean> = ItemAttributeNamed("ragdolls become ash")
	
		/**
		 * Phlogistinator kills.
		 */
		open val ragdollsPlasmaEffect: ItemAttributeNamed<Boolean> = ItemAttributeNamed("ragdolls plasma effect")
	}
	
	open class BuffItemsAttributes : BaseCombatWeaponAttributes.BuffItemsAttributes() 
	
	open class CloakAttributes : BaseCombatWeaponAttributes.CloakAttributes() 
	
	open class DisguiseAttributes : BaseCombatWeaponAttributes.DisguiseAttributes() 
	
	open class HudAttributes : BaseCombatWeaponAttributes.HudAttributes() 
	
	open class SpyOnlyAttributes : BaseCombatWeaponAttributes.SpyOnlyAttributes() 
	
	object Inherited : WeaponBaseAttributes 
}