package btpos.source.vdfdsl.tf2.itemattributes

import btpos.source.vdfdsl.modeling.*
import btpos.source.vdfdsl.serialization.*
import btpos.source.vdfdsl.serialization.codecs.*
import btpos.source.vdfdsl.tf2.itemattributes.impl.*
import btpos.source.vdfdsl.tf2.tftypes.*
import java.util.*
import kotlin.time.Duration

interface PlayerAttributes : IBlockScoped, BaseEntityAttributes {
	companion object : IBlockScoped {
		/**
		 * Attributes related to max ammo, clip-size, and resupply.
		 */
		val ammo: AmmoAttributes = AmmoAttributes()
	
		val buffItems: BuffItemsAttributes = BuffItemsAttributes()
	
		/**
		 * Attributes related to moving, constructing, and interacting with the Engineer's buildings.
		 */
		val buildings: BuildingsAttributes = BuildingsAttributes()
	
		val cloak: CloakAttributes = CloakAttributes()
	
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
		 * Attributes related to disguising.
		 */
		val disguise: DisguiseAttributes = DisguiseAttributes()
	
		/**
		 * Attributes governing rate-of-fire.
		 */
		val firing: FiringAttributes = FiringAttributes()
	
		/**
		 * Attributes related to the collection and passive effects of "heads".
		 * 
		 * While originally made for the Eyelander, this stat is used by many other weapons that track players hit or killed: the Vita-Saw, the Bazaar Bargain, etc.
		 * 
		 * For "revenge crits", like the Frontier Justice, Manmelter, and Diamondback, see [revengeCrits].
		 */
		val heads: HeadsAttributes = HeadsAttributes()
	
		/**
		 * Attributes related to the player's HP stat and healing players.
		 */
		val healthAndHealing: HealthAndHealingAttributes = HealthAndHealingAttributes()
	
		val hud: HudAttributes = HudAttributes()
	
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
		 * Attributes governing how much damage the player takes from various sources.  Also includes the passive and active effects of the Vaccinator on the user.
		 * 
		 * For outgoing damage, see [damage].
		 */
		val resistance: ResistanceAttributes = ResistanceAttributes()
	
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
	
		val spyOnly: SpyOnlyAttributes = SpyOnlyAttributes()
	
		/**
		 * Attributes related to dealing or preventing critical hits and mini-crits.
		 */
		private val crits: CritsAttributes = CritsAttributes()
	}
	
	/**
	 * Attributes related to max ammo, clip-size, and resupply.
	 */
	val ammo: AmmoAttributes get() = PlayerAttributes.ammo
	
	val buffItems: BuffItemsAttributes get() = PlayerAttributes.buffItems
	
	/**
	 * Attributes related to moving, constructing, and interacting with the Engineer's buildings.
	 */
	val buildings: BuildingsAttributes get() = PlayerAttributes.buildings
	
	val cloak: CloakAttributes get() = PlayerAttributes.cloak
	
	/**
	 * Multipliers governing the damage you deal to different targets.
	 * 
	 * For damage _taken_, see [resistance].
	 */
	override val damage: DamageAttributes get() = PlayerAttributes.damage
	
	/**
	 * Attributes governing the Demoknight's shield-charge.
	 * 
	 * Some of these attributes are hardcoded to only work on the Demoman. These are noted in their documentation.
	 */
	val demoCharge: DemoChargeAttributes get() = PlayerAttributes.demoCharge
	
	/**
	 * Attributes related to disguising.
	 */
	override val disguise: DisguiseAttributes get() = PlayerAttributes.disguise
	
	/**
	 * Attributes governing rate-of-fire.
	 */
	val firing: FiringAttributes get() = PlayerAttributes.firing
	
	/**
	 * Attributes related to the collection and passive effects of "heads".
	 * 
	 * While originally made for the Eyelander, this stat is used by many other weapons that track players hit or killed: the Vita-Saw, the Bazaar Bargain, etc.
	 * 
	 * For "revenge crits", like the Frontier Justice, Manmelter, and Diamondback, see [revengeCrits].
	 */
	val heads: HeadsAttributes get() = PlayerAttributes.heads
	
	/**
	 * Attributes related to the player's HP stat and healing players.
	 */
	val healthAndHealing: HealthAndHealingAttributes get() = PlayerAttributes.healthAndHealing
	
	val hud: HudAttributes get() = PlayerAttributes.hud
	
	/**
	 * Attributes governing how much you are pushed when hit by different push sources.
	 */
	override val knockbackReceived: KnockbackReceivedAttributes get() = PlayerAttributes.knockbackReceived
	
	/**
	 * Attributes related to the scoreboard, killfeed, HuD, item descriptions, and interactions with the wider game-state. (including capture rate)
	 */
	override val meta: MetaAttributes get() = PlayerAttributes.meta
	
	/**
	 * Attributes related to rage and items that recharge on a meter/timer.
	 */
	override val meter: MeterAttributes get() = PlayerAttributes.meter
	
	/**
	 * Attributes governing the player's move-speed, jump height, swimming, air-strafing capabilities, and all things mobility-related.
	 */
	val movement: MovementAttributes get() = PlayerAttributes.movement
	
	/**
	 * Attributes governing what happens when you hit another player, such as applying conditions or debuffs.
	 * 
	 * @see onKill
	 */
	val onHit: OnHitAttributes get() = PlayerAttributes.onHit
	
	/**
	 * Attributes governing what happens when you kill another player, usually applying bonuses to yourself.
	 * 
	 * @see onHit
	 */
	val onKill: OnKillAttributes get() = PlayerAttributes.onKill
	
	/**
	 * Attributes governing how much damage the player takes from various sources.  Also includes the passive and active effects of the Vaccinator on the user.
	 * 
	 * For outgoing damage, see [damage].
	 */
	override val resistance: ResistanceAttributes get() = PlayerAttributes.resistance
	
	/**
	 * Attributes governing taunt speed and the effects of taunts.
	 */
	val taunting: TauntingAttributes get() = PlayerAttributes.taunting
	
	/**
	 * Attributes governing weapon deploy/holster speed, things that activate when a weapon is deployed, and whether a player can swap weapons at all.
	 */
	val swapWeapons: SwapWeaponsAttributes get() = PlayerAttributes.swapWeapons
	
	/**
	 * Attributes governing what happens when this player is hit by an enemy.
	 * 
	 * For what happens when _this player_ hits an enemy, see [onHit] and [onKill].
	 */
	val whenHit: WhenHitAttributes get() = PlayerAttributes.whenHit
	
	val spyOnly: SpyOnlyAttributes get() = PlayerAttributes.spyOnly
	
	/**
	 * Attributes related to dealing or preventing critical hits and mini-crits.
	 */
	override val crits: CritsAttributes get() = PlayerAttributes.crits
	
	open class AmmoAttributes : IBlockScoped {
		open val grenades1ResupplyDenied: ItemAttributeNamed<Boolean> = ItemAttributeNamed("grenades1_resupply_denied")
	
		open val grenades2ResupplyDenied: ItemAttributeNamed<Boolean> = ItemAttributeNamed("grenades2_resupply_denied")
	
		open val grenades3ResupplyDenied: ItemAttributeNamed<Boolean> = ItemAttributeNamed("grenades3_resupply_denied")
	
		/**
		 * In-Game: "+N% ammo regenerated every 5 seconds on wearer"
		 * 
		 * Percentage of ammo regenerated every 5 seconds.
		 */
		open val ammoRegen: ItemAttributeNamed<Number> = ItemAttributeNamed("ammo regen")
	
		/**
		 * In-Game: "N% less metal from pickups and dispensers"
		 * 
		 * Multiplier applied to metal gained from ammo boxes.
		 */
		open val multMetalPickup: ItemAttributeNamed<Number> = ItemAttributeNamed("metal_pickup_decreased")
	
		/**
		 * In-Game: "+N metal regenerated every 5 seconds on wearer"
		 * 
		 * Amount of metal regenerated every 5 seconds.
		 */
		open val metalRegen: ItemAttributeNamed<Int> = ItemAttributeNamed("metal regen")
	
		open val multMaxAmmo: MaxAmmoAttributes = MaxAmmoAttributes()
	
		open class MaxAmmoAttributes : IBlockScoped {
			/**
			 * Bonus:
			 * 
			 * 	- In-Game: "+N% max primary ammo on wearer"
			 * 
			 * Penalty:
			 * 
			 * 	- In-Game: "N% max primary ammo on wearer"
			 * 
			 * Hidden:
			 */
			open val primary: BonusPenaltyHidden<Number, ItemAttributeNamed<Number>> = BonusPenaltyHidden(
			    ItemAttributeNamed<Number>("maxammo primary increased"),
			    ItemAttributeNamed<Number>("maxammo primary reduced"),
			    ItemAttributeNamed<Number>("hidden primary max ammo bonus"),
			)
	
			/**
			 * Bonus:
			 * 
			 * 	- In-Game: "+N% max secondary ammo on wearer"
			 * 
			 * Penalty:
			 * 
			 * 	- In-Game: "N% max secondary ammo on wearer"
			 * 
			 * Hidden:
			 */
			open val secondary: BonusPenaltyHidden<Number, ItemAttributeNamed<Number>> = BonusPenaltyHidden(
			    ItemAttributeNamed<Number>("maxammo secondary increased"),
			    ItemAttributeNamed<Number>("maxammo secondary reduced"),
			    ItemAttributeNamed<Number>("hidden secondary max ammo penalty"),
			)
	
			/**
			 * Bonus:
			 * 
			 * 	- In-Game: "+N% max metal on wearer"
			 * 
			 * Penalty:
			 * 
			 * 	- In-Game: "N% max metal on wearer"
			 */
			open val metal: BonusPenalty<Number> = BonusPenalty(
			    ItemAttributeNamed("maxammo metal increased"),
			    ItemAttributeNamed("maxammo metal reduced"),
			)
	
			/**
			 * In-Game: "+N% max misc ammo on wearer"
			 * 
			 * Only used for bat balls.
			 */
			open val batBalls: ItemAttributeNamed<Number> = ItemAttributeNamed("maxammo grenades1 increased")
		}
	}
	
	open class BuffItemsAttributes : IBlockScoped {
		/**
		 * Note that Phlogistinator's rage has a small cooldown after expiring before it can gain rage again, to prevent the lingering crit flames from immediately filling it up again.
		 */
		open val soldierBuffType: ItemAttributeNamed<Int> = ItemAttributeNamed("mod soldier buff type")
	
		/**
		 * Note that Phlogistinator's rage has a small cooldown after expiring before it can gain rage again, to prevent the lingering crit flames from immediately filling it up again.
		 */
		open val demoBuffType: ItemAttributeNamed<Int> = ItemAttributeNamed("mod demo buff type")
	
		/**
		 * Multiplier applied to buff duration.
		 * 
		 * Visible:
		 * 
		 * 	- In-Game: "+N% buff duration"
		 * 
		 * 
		 * 
		 * Hidden:
		 * 
		 * 	- In-Game: "+N% buff duration"
		 */
		open val multBuffDuration: VisHidden<Number> = VisHidden(
		    ItemAttributeNamed("increase buff duration"),
		    ItemAttributeNamed("increase buff duration HIDDEN")
		)
	}
	
	open class BuildingsAttributes : IBlockScoped {
		/**
		 * In-Game: "+N% faster build speed"
		 * 
		 * Multiplies building build time by this amount.
		 */
		open val multBuildRate: ItemAttributeNamed<Number> = ItemAttributeNamed("build rate bonus")
	
		/**
		 * In-Game: "N% slower upgrade rate"
		 * 
		 * Multiplier to the amount of metal given to any building hit by this player, using player's metal reserve.
		 * 
		 * Recall that all players have 100 hidden metal.
		 */
		open val multMetalGivenOnHit: ItemAttributeNamed<Number> = ItemAttributeNamed("upgrade rate decrease")
	
		/**
		 * In-Game: "+N% max building health"
		 * 
		 * Only applied if the building is NOT a disposable sentry.
		 */
		open val multBuildingHealth: ItemAttributeNamed<Number> = ItemAttributeNamed("engy building health bonus")
	
		/**
		 * In-Game: "Cannot carry buildings"
		 * 
		 * Prevents player from picking up buildings.
		 */
		open val cannotPickUpBuildings: ItemAttributeNamed<Boolean> = ItemAttributeNamed("cannot pick up buildings")
	
		/**
		 * In-Game: "N metal reduction in building cost"
		 * 
		 * Multiplier to the metal required to construct a building.
		 */
		open val multConstructionCost: ItemAttributeNamed<Number> = ItemAttributeNamed("building cost reduction")
	
		open val sentryGun: SentryGunAttributes = SentryGunAttributes()
	
		open val dispenser: DispenserAttributes = DispenserAttributes()
	
		open val teleporter: TeleporterAttributes = TeleporterAttributes()
	
		open class SentryGunAttributes : IBlockScoped {
			/**
			 * In-Game: "Sentry build speed increased by N%"
			 */
			open val multBuildRate: ItemAttributeNamed<Number> = ItemAttributeNamed("engineer sentry build rate multiplier")
	
			/**
			 * In-Game: "+N% sentry range"
			 */
			open val multRadius: ItemAttributeNamed<Number> = ItemAttributeNamed("engy sentry radius increased")
	
			/**
			 * In-Game: "+N% sentry firing speed"
			 */
			open val multFireRate: ItemAttributeNamed<Number> = ItemAttributeNamed("engy sentry fire rate increased")
	
			/**
			 * In-Game: "Build +N additional disposable-sentry"
			 * 
			 * Number of disposable sentries you're allowed to build.
			 * 
			 * Checked when checking if the player can build something.
			 * 
			 * Only works if the "uses upgrades" gamerule is set.
			 */
			open val numDisposableSentries: ItemAttributeNamed<Int> = ItemAttributeNamed("engy disposable sentries")
		}
	
		open class DispenserAttributes : IBlockScoped {
			/**
			 * In-Game: "+N% dispenser range"
			 */
			open val multRadius: ItemAttributeNamed<Number> = ItemAttributeNamed("engy dispenser radius increased")
	
			/**
			 * In-Game: "Increases teleporter build speed by N%."
			 * 
			 * Multiplier applied to passive build time for dispensers and teleporters.
			 */
			open val multBuildRate: ItemAttributeNamed<Number> = ItemAttributeNamed("engineer teleporter build rate multiplier")
		}
	
		open class TeleporterAttributes : IBlockScoped {
			/**
			 * In-Game: "Teleporters can be used in both directions"
			 */
			open val bidirectionalTeleport: ItemAttributeNamed<Boolean> = ItemAttributeNamed("bidirectional teleport")
	
			/**
			 * In-Game: "N% metal cost when constructing or upgrading teleporters"
			 * 
			 * Multiplier applied to teleporter construction cost.
			 */
			open val multMetalCost: ItemAttributeNamed<Number> = ItemAttributeNamed("mod teleporter cost")
	
			/**
			 * In-Game: "Increases teleporter build speed by N%."
			 * 
			 * Multiplier applied to passive build time for dispensers and teleporters.
			 */
			open val multBuildRate: ItemAttributeNamed<Number> = ItemAttributeNamed("engineer teleporter build rate multiplier")
		}
	}
	
	open class CloakAttributes : IBlockScoped {
		/**
		 * In-Game: "N sec longer cloak blink time"
		 * 
		 * Multiplier.
		 */
		open val multBlinkTime: ItemAttributeNamed<Number> = ItemAttributeNamed("SET BONUS: cloak blink time penalty")
	
		/**
		 * In-Game: "N sec increase in time to cloak"
		 */
		open val multCloakRate: ItemAttributeNamed<Number> = ItemAttributeNamed("mult cloak rate")
	
		/**
		 * In-Game: "Reduced decloak sound volume"
		 * 
		 * If true, plays `Player.Spy_UnCloakReduced` when decloaking.
		 */
		open val quietDecloak: ItemAttributeNamed<Boolean> = ItemAttributeNamed("SET BONUS: quiet unstealth")
	
		open val multDecloakRate: ItemAttributeNamed<Number> = ItemAttributeNamed("mult decloak rate")
	}
	
	open class DamageAttributes : BaseEntityAttributes.DamageAttributes() {
		/**
		 * In-Game: "Deals 3x falling damage to the player you land on"
		 * 
		 * Deal 3x falling damage to player you land on.
		 */
		open val bootsFallingStomp: ItemAttributeNamed<Boolean> = ItemAttributeNamed("boots falling stomp")
	
		/**
		 * In-Game: "Headshots deal an extra +N% damage"
		 * 
		 * Multiplier applied to headshot damage.
		 */
		open val multHeadshotDamage: ItemAttributeNamed<Number> = ItemAttributeNamed("headshot damage increase")
	
		open val alien: AlienAttributes = AlienAttributes()
	
		open class AlienAttributes : IBlockScoped {
			/**
			 * In-Game: "Increased Melee damage against Isolated Merc Set"
			 * 
			 * Deal extra damage to players wearing the Alien set.
			 */
			open val setBonusAlienIsolationXenoBonusPos: ItemAttributeNamed<Boolean> = ItemAttributeNamed("SET BONUS: alien isolation xeno bonus pos")
	
			/**
			 * In-Game: "Increased Nostromo Napalmer damage against Isolationist Pack Set"
			 * 
			 * Deal extra damage to players wearing the Xenomorph set.
			 */
			open val setBonusAlienIsolationMercBonusPos: ItemAttributeNamed<Boolean> = ItemAttributeNamed("SET BONUS: alien isolation merc bonus pos")
		}
	}
	
	open class DemoChargeAttributes : IBlockScoped {
		/**
		 * Default is 0.45f, and this is a multiplier applied to it.
		 */
		open val multChargeTurnControl: ChargeTurnControlAttributes = ChargeTurnControlAttributes()
	
		/**
		 * In-Game: "Taking damage while shield charging reduces remaining charging time"
		 * 
		 * Used to detect the Tide Turner when deciding whether to give you minicrits or crits.
		 */
		open val loseDemoChargeOnDamageWhenCharging: ItemAttributeNamed<Boolean> = ItemAttributeNamed("lose demo charge on damage when charging")
	
		/**
		 * In-Game: "Melee kills refill N% of your charge meter."
		 * 
		 * Amount of targe-charge meter gained on kill.  Scaled by various values.
		 */
		open val killRefillsMeter: ItemAttributeNamed<Number> = ItemAttributeNamed("kill refills meter")
	
		/**
		 * Only applies to Demoman, even if a targe is equipped on another class.
		 * 
		 * Flat multiplier applied to total charge time when charging.
		 * 
		 * Visible:
		 * 
		 * 	- In-Game: "N sec increase in charge duration"
		 * 
		 * 
		 * 
		 * Hidden:
		 * 
		 * 	- In-Game: "N sec decrease in charge duration"
		 */
		open val modChargeTime: VisHidden<Number> = VisHidden(
		    ItemAttributeNamed("charge time increased"),
		    ItemAttributeNamed("charge time decreased")
		)
	
		/**
		 * In-Game: "+N% increase in charge recharge rate"
		 * 
		 * Only applies to Demoman.
		 */
		open val multRechargeRate: ItemAttributeNamed<Number> = ItemAttributeNamed("charge recharge rate increased")
	
		open class ChargeTurnControlAttributes : IBlockScoped, ItemAttribute<Number> {
			/**
			 * In-Game: "+N% increase in turning control while charging"
			 * 
			 * Default is 0.45f, and this is a multiplier applied to it.
			 */
			open val standard: ItemAttributeNamed<Number> = ItemAttributeNamed("mult charge turn control")
	
			/**
			 * In-Game: "Full turning control while charging"
			 * 
			 * Default is 0.45f, and this is a multiplier applied to it.
			 */
			open val fullTurnControl: ItemAttributeNamed<Number> = ItemAttributeNamed("full charge turn control")
	
			context(attrs: IAttributeContainer)
			override fun set(value: Number?) {
			    standard.set(value)
			}
	
			context(attrs: IAttributeContainer)
			override fun get(): Number? {
			    return standard.get()
			}
	
			override fun serialize(value: Number?): IVDFRepresentableKeyValue {
			    return standard.serialize(value)
			}
		}
	}
	
	open class DisguiseAttributes : BaseEntityAttributes.DisguiseAttributes() {
		/**
		 * In-Game: "Immune to fire damage while disguised"
		 * 
		 * Prevent afterburn while disguised.
		 */
		open val disguiseNoBurn: ItemAttributeNamed<Boolean> = ItemAttributeNamed("disguise no burn")
	
		/**
		 * In-Game: "Wearer cannot disguise"
		 */
		open val cannotDisguise: ItemAttributeNamed<Boolean> = ItemAttributeNamed("cannot disguise")
	}
	
	open class FiringAttributes : IBlockScoped {
		/**
		 * Prevents player from attacking.
		 */
		open val noAttack: ItemAttributeNamed<Boolean> = ItemAttributeNamed("no_attack")
	}
	
	open class HeadsAttributes : IBlockScoped {
		/**
		 * This attribute only works on players that are a Medic wielding the Vitasaw. For the all-class version, see `extra_damage_on_hit` (unimplemented in vanilla, accessible via Rafmod).
		 * 
		 * Gives extra player movespeed the more heads you have. (Partially implemented.).
		 * 
		 * Will not work if the player is not a Medic wielding the VitaSaw.
		 */
		open val addHeadOnHit: ItemAttributeNamed<Number> = ItemAttributeNamed("add head on hit")
	}
	
	open class HealthAndHealingAttributes : IBlockScoped {
		/**
		 * In-Game: "+25% heal rate for patient, +25% faster revive rate, and +25% self heal rate, per point"
		 * 
		 * On Medic only, each level raises the Medic's passive regen by 25% of its normal value.
		 */
		open val healingMastery: ItemAttributeNamed<Int> = ItemAttributeNamed("healing mastery")
	
		/**
		 * Bonus:
		 * 
		 * 	- In-Game: "+N% health from packs on wearer"
		 * 
		 * Penalty:
		 * 
		 * 	- In-Game: "N% health from packs on wearer"
		 */
		open val multHealthFromPacks: BonusPenalty<Number> = BonusPenalty(
		    ItemAttributeNamed("health from packs increased"),
		    ItemAttributeNamed("health from packs decreased"),
		)
	
		/**
		 * In-Game: "N% less healing from Medic sources"
		 * 
		 * Specifically checked on Crossbow Bolt impacts.
		 */
		open val multHealingFromMedics: ItemAttributeNamed<Number> = ItemAttributeNamed("reduced_healing_from_medics")
	
		/**
		 * Bonus:
		 * 
		 * 	- In-Game: "+N% health from healers on wearer"
		 * 
		 * Penalty:
		 * 
		 * 	- In-Game: "N% health from healers on wearer"
		 */
		open val multHealthFromHealers: BonusPenalty<Number> = BonusPenalty(
		    ItemAttributeNamed("health from healers increased"),
		    ItemAttributeNamed("health from healers reduced"),
		)
	
		/**
		 * In-Game: "Blocks healing while in use"
		 * 
		 * If set, this player may not be targeted by heal-beams or healed from Crossbow impacts.
		 */
		open val weaponBlocksHealing: ItemAttributeNamed<Boolean> = ItemAttributeNamed("mod weapon blocks healing")
	
		/**
		 * Amount of health regenerated per regen tick.  Scales by the amount of time since the player last took damage in non-MvM modes.
		 */
		open val healthRegenPerSecond: AddHealthRegenAttributes = AddHealthRegenAttributes()
	
		/**
		 * In-Game: "+N max health on wearer"
		 * 
		 * Additive maximum health increase that does not influence the player's overheal cap. See also: [addMaxHealth].
		 */
		open val addMaxHealth_nonBuffed: ItemAttributeNamed<Int> = ItemAttributeNamed("hidden maxhealth non buffed")
	
		/**
		 * Additive maximum health increase. Influences the player's overheal cap.
		 */
		open val addMaxHealth: AddMaxhealthAttributes = AddMaxhealthAttributes()
	
		open class AddHealthRegenAttributes : IBlockScoped, ItemAttribute<Int> {
			/**
			 * In-Game: "+N health regenerated per second on wearer"
			 * 
			 * Amount of health regenerated per regen tick.  Scales by the amount of time since the player last took damage in non-MvM modes.
			 */
			open val regen: ItemAttributeNamed<Int> = ItemAttributeNamed("health regen")
	
			/**
			 * In-Game: "N health drained per second on wearer"
			 * 
			 * Amount of health regenerated per regen tick.  Scales by the amount of time since the player last took damage in non-MvM modes.
			 */
			open val drain: ItemAttributeNamed<Int> = ItemAttributeNamed("health drain")
	
			/**
			 * In-Game: "+N health regenerated per second on wearer"
			 * 
			 * Amount of health regenerated per regen tick.  Scales by the amount of time since the player last took damage in non-MvM modes.
			 */
			open val regen_setBonus: ItemAttributeNamed<Int> = ItemAttributeNamed("SET BONUS: health regen set bonus")
	
			/**
			 * In-Game: "N health regenerated per second on wearer"
			 * 
			 * Amount of health regenerated per regen tick.  Scales by the amount of time since the player last took damage in non-MvM modes.
			 */
			open val drain_medic: ItemAttributeNamed<Int> = ItemAttributeNamed("health drain medic")
	
			/**
			 * In-Game: "+N health regenerated per second on wearer"
			 * 
			 * Amount of health regenerated per regen tick.  Scales by the amount of time since the player last took damage in non-MvM modes.
			 */
			open val card: ItemAttributeNamed<Int> = ItemAttributeNamed("CARD: health regen")
	
			context(attrs: IAttributeContainer)
			override fun set(value: Int?) {
			    regen.set(value)
			}
	
			context(attrs: IAttributeContainer)
			override fun get(): Int? {
			    return regen.get()
			}
	
			override fun serialize(value: Int?): IVDFRepresentableKeyValue {
			    return regen.serialize(value)
			}
		}
	
		open class AddMaxhealthAttributes : IBlockScoped, ItemAttribute<Int> {
			/**
			 * In-Game: "+N max health on wearer"
			 * 
			 * Additive maximum health increase. Influences the player's overheal cap.
			 */
			open val bonus: ItemAttributeNamed<Int> = ItemAttributeNamed("max health additive bonus")
	
			/**
			 * In-Game: "N max health on wearer"
			 * 
			 * Additive maximum health increase. Influences the player's overheal cap.
			 */
			open val penalty: ItemAttributeNamed<Int> = ItemAttributeNamed("max health additive penalty")
	
			/**
			 * In-Game: "+N max health on wearer"
			 * 
			 * Additive maximum health increase. Influences the player's overheal cap.
			 */
			open val setBonus: ItemAttributeNamed<Int> = ItemAttributeNamed("SET BONUS: max health additive bonus")
	
			context(attrs: IAttributeContainer)
			override fun set(value: Int?) {
			    bonus.set(value)
			}
	
			context(attrs: IAttributeContainer)
			override fun get(): Int? {
			    return bonus.get()
			}
	
			override fun serialize(value: Int?): IVDFRepresentableKeyValue {
			    return bonus.serialize(value)
			}
		}
	}
	
	open class HudAttributes : IBlockScoped {
		/**
		 * Only used if the build menu is actually shown.
		 * 
		 * 0 = default.
		 * 
		 * 1 = pipboy.
		 * 
		 * Works on Engineer and Spy (if you can give him a build menu).
		 */
		open val hasPipboyBuildInterface: ItemAttributeNamed<Int> = ItemAttributeNamed("has pipboy build interface")
	
		/**
		 * In-Game: "Allows you to see enemy health"
		 */
		open val seeEnemyHealth: ItemAttributeNamed<Boolean> = ItemAttributeNamed("mod see enemy health")
	
		/**
		 * In-Game: "Unable to see enemy health"
		 * 
		 * Always true in MvM.
		 */
		open val hideEnemyHealth: ItemAttributeNamed<Boolean> = ItemAttributeNamed("hide enemy health")
	}
	
	open class KnockbackReceivedAttributes : BaseEntityAttributes.KnockbackReceivedAttributes() {
		/**
		 * Visible:
		 * 
		 * 	- In-Game: "N% reduction in airblast vulnerability"
		 * 
		 * 
		 * 
		 * Hidden:
		 * 
		 * 	- In-Game: "N% reduction in airblast vulnerability"
		 */
		open val multAirblastVulnerability: VisHidden<Number> = VisHidden(
		    ItemAttributeNamed("airblast vulnerability multiplier"),
		    ItemAttributeNamed("airblast vulnerability multiplier hidden")
		)
	
		open val multAirblastVerticalVulnerability: ItemAttributeNamed<Number> = ItemAttributeNamed("airblast vertical vulnerability multiplier")
	
		/**
		 * In-Game: "Knockback reduced by N% when aiming"
		 * 
		 * Only works on Sniper.
		 */
		open val multKnockbackWhileAiming: ItemAttributeNamed<Number> = ItemAttributeNamed("aiming knockback resistance")
	}
	
	open class MetaAttributes : BaseEntityAttributes.MetaAttributes() {
		/**
		 * If 1, create a soccer ball on the ground when the player spawns.
		 */
		open val spawnWithPhysicsToy: ItemAttributeNamed<Int> = ItemAttributeNamed("spawn with physics toy")
	
		/**
		 * In-Game: "Leave a Calling Card on your victims."
		 * 
		 * Defines the calling card that should be dropped when this player kills another player.
		 */
		open val setBonusCallingCardOnKill: ItemAttributeNamed<Int> = ItemAttributeNamed("SET BONUS: calling card on kill")
	
		override val killfeed: KillfeedAttributes = KillfeedAttributes()
	
		open val noisemakers: NoisemakersAttributes = NoisemakersAttributes()
	
		open val items: ItemsAttributes = ItemsAttributes()
	
		open val player: PlayerAttributes = PlayerAttributes()
	
		open val gameplay: GameplayAttributes = GameplayAttributes()
	
		open val particles: ParticlesAttributes = ParticlesAttributes()
	
		open class KillfeedAttributes : BaseEntityAttributes.MetaAttributes.KillfeedAttributes() {
			/**
			 * If the weapon is a Holy Mackerel reskin (AKA either the fish or the Unarmed Combat) and this is set, use the Unarmed Combat "arm hit" killfeed notice instead of the "fish hit" notice.
			 */
			open val fishDamageOverride: ItemAttributeNamed<Boolean> = ItemAttributeNamed("fish damage override")
		}
	
		open class NoisemakersAttributes : IBlockScoped {
			/**
			 * In-Game: "Noise Maker"
			 * 
			 * Uses noise maker when pressing action slot key.
			 */
			open val noiseMaker: ItemAttributeNamed<Boolean> = ItemAttributeNamed("noise maker")
	
			/**
			 * If true, noisemakers are unlimited usage.
			 * 
			 * Visible:
			 * 
			 * 	- In-Game: "Unlimited use"
			 * 
			 * 
			 * 
			 * Hidden:
			 */
			open val unlimitedQuantity: VisHidden<Boolean> = VisHidden(
			    ItemAttributeNamed("unlimited quantity"),
			    ItemAttributeNamed("unlimited quantity hidden")
			)
		}
	
		open class ItemsAttributes : IBlockScoped {
			/**
			 * In-Game: "Killstreaks Active"
			 */
			open val killstreakTier: ItemAttributeNamed<Int> = ItemAttributeNamed("killstreak tier")
		}
	
		open class PlayerAttributes : IBlockScoped {
			/**
			 * In-Game: "Jingle all the way"
			 * 
			 * If 1, use xmas.jingle, if 2 or higher use xmas.jingle_higher.
			 */
			open val addJingleToFootsteps: ItemAttributeNamed<Int> = ItemAttributeNamed("add jingle to footsteps")
	
			/**
			 * In-Game: "N"
			 * 
			 * Decimal version of the 4-byte hex code determining color of footsteps (e.g. `0xFFFFFFFF`, but in decimal).
			 */
			open val spellSetHalloweenFootstepType: ItemAttributeNamed<Int> = ItemAttributeNamed("SPELL: set Halloween footstep type")
	
			open val overrideFootstepSoundSet: ItemAttributeNamed<FootstepOverride> = ItemAttributeNamed("override footstep sound set")
	
			/**
			 * In-Game: "Explode spectacularly on death"
			 */
			open val bombinomiconEffectOnDeath: ItemAttributeNamed<Boolean> = ItemAttributeNamed("bombinomicon effect on death")
	
			/**
			 * If true, the Voodoo-Cursed Soul skin is equipped.
			 */
			open val useZombieSkin: ItemAttributeNamed<Boolean> = ItemAttributeNamed("zombiezombiezombiezombie")
	
			/**
			 * In-Game: "Disables double jump"
			 */
			open val headScale: ItemAttributeNamed<Number> = ItemAttributeNamed("head scale")
	
			open val torsoScale: ItemAttributeNamed<Number> = ItemAttributeNamed("torso scale")
	
			open val handScale: ItemAttributeNamed<Number> = ItemAttributeNamed("hand scale")
	
			/**
			 * DSP used when emitting sounds created by this player.
			 */
			open val setBonusSpecialDsp: ItemAttributeNamed<Int> = ItemAttributeNamed("SET BONUS: special dsp")
		}
	
		open class GameplayAttributes : IBlockScoped {
			/**
			 * In-Game: "+N capture rate on wearer"
			 */
			open val increasePlayerCaptureValue: ItemAttributeNamed<Int> = ItemAttributeNamed("increase player capture value")
	
			/**
			 * In-Game: "Share Canteens with your heal target. +1 duration, -10 price per point (minimum cost: 5)"
			 * 
			 * Discounts canteens by 10 * level.
			 */
			open val canteenSpecialist: ItemAttributeNamed<Int> = ItemAttributeNamed("canteen specialist")
	
			/**
			 * In-Game: "Wearer cannot carry the intelligence briefcase or PASS Time JACK"
			 */
			open val cannotPickUpIntelligence: ItemAttributeNamed<Boolean> = ItemAttributeNamed("cannot pick up intelligence")
		}
	
		open class ParticlesAttributes : IBlockScoped {
			open val useHeadOrigin: ItemAttributeNamed<Boolean> = ItemAttributeNamed("particle effect use head origin")
	
			open val verticalOffset: ItemAttributeNamed<Number> = ItemAttributeNamed("particle effect vertical offset")
		}
	}
	
	open class MeterAttributes : BaseEntityAttributes.MeterAttributes() {
		/**
		 * In-Game: "Build energy by healing teammates.  When fully charged, press the Special-Attack key to deploy a frontal projectile shield."
		 * 
		 * Gain shield meter from damage healed. Only works on Medic.
		 */
		open val generateRageOnHeal: ItemAttributeNamed<Boolean> = ItemAttributeNamed("generate rage on heal")
	
		/**
		 * In-Game: "Gain Focus on kills and assists"
		 * 
		 * Amount of Sniper rage gained on kill.  Only works on Sniper.
		 */
		open val rageOnKill: ItemAttributeNamed<Number> = ItemAttributeNamed("rage on kill")
	
		/**
		 * In-Game: "Boost reduced on air jumps"
		 * 
		 * Lose this amount of hype if you airdash.
		 * 
		 * Note that this only applies to scout hype, not rage in general.
		 */
		open val hypeResetsOnJump: ItemAttributeNamed<Int> = ItemAttributeNamed("hype resets on jump")
	
		/**
		 * Only works on Engineer and Heavy.
		 * 
		 * On Engineer, adds all damage dealt to the rage meter.
		 * 
		 * On Heavy, adds `0.22` * the damage to the meter, and reduces damage by 50% while the meter is draining.
		 */
		open val generateRageOnDmg: GenerateRageOnDmgAttributes = GenerateRageOnDmgAttributes()
	
		/**
		 * Multiplier applied to rage gained by dealing damage, taking damage, or dealing burn damage.
		 */
		open val multRageGained: ItemAttributeNamed<Number> = ItemAttributeNamed("rage giving scale")
	
		/**
		 * In-Game: "On Hit: Builds Hype"
		 * 
		 * Adds the amount of damage dealt to the Scout hype meter, to a maximum of 200 damage which adds 50% meter.
		 */
		open val gainHypeOnDamage: ItemAttributeNamed<Boolean> = ItemAttributeNamed("hype on damage")
	
		/**
		 * Only procs on Sniper. Gain this amount of rage meter on assists.
		 */
		open val rageOnAssists: ItemAttributeNamed<Number> = ItemAttributeNamed("rage on assists")
	
		/**
		 * If `mult_item_meter_charge_rate` is set, checks this attribute to see what type of meter should be modified, and also only allows it to activate if the active weapon is not a TF_WEAPON_FLAMEBALL (Dragon's Fury).
		 */
		override val chargeType: ItemAttributeNamed<TFMeterRechargeType> get() = super.chargeType
	
		/**
		 * In-Game: "Hype Decays Over Time."
		 * 
		 * How much the Scout's hype meter decays every tick.
		 */
		open val hypeDecaysOverTime: ItemAttributeNamed<Number> = ItemAttributeNamed("hype decays over time")
	
		/**
		 * In-Game: "Boost reduced when hit"
		 * 
		 * Amount of hype lost per point of damage taken.
		 */
		open val hypeLostPerDamageTaken: ItemAttributeNamed<Int> = ItemAttributeNamed("lose hype on take damage")
	
		open class GenerateRageOnDmgAttributes : IBlockScoped, ItemAttribute<Boolean> {
			/**
			 * In-Game: "Generate Rage by dealing damage.  When fully charged, press the Special-Attack key to activate knockback"
			 * 
			 * Only works on Engineer and Heavy.
			 * 
			 * On Engineer, adds all damage dealt to the rage meter.
			 * 
			 * On Heavy, adds `0.22` * the damage to the meter, and reduces damage by 50% while the meter is draining.
			 */
			open val standard: ItemAttributeNamed<Boolean> = ItemAttributeNamed("generate rage on damage")
	
			/**
			 * In-Game: "Generate building rescue energy on damage"
			 * 
			 * Only works on Engineer and Heavy.
			 * 
			 * On Engineer, adds all damage dealt to the rage meter.
			 * 
			 * On Heavy, adds `0.22` * the damage to the meter, and reduces damage by 50% while the meter is draining.
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
	}
	
	open class MovementAttributes : IBlockScoped {
		open val multJumpHeight: ModJumpHeightAttributes = ModJumpHeightAttributes()
	
		/**
		 * Allows parachute to be deployed. Parachute prop only appears if the BASE Jumper is equipped, but the functionality is the same regardless.
		 */
		open val parachuteAttribute: ItemAttributeNamed<Boolean> = ItemAttributeNamed("parachute attribute")
	
		/**
		 * In-Game: "N% increased air control."
		 * 
		 * Note: the jetpack condition always multiplies your air acceleration by 50%.
		 */
		open val increasedAirControl: ItemAttributeNamed<Number> = ItemAttributeNamed("increased air control")
	
		/**
		 * In-Game: "N% increased air control when blast jumping."
		 * 
		 * Specifically while blast-jumping, as opposed to global.
		 */
		open val airControlBlastJump: ItemAttributeNamed<Number> = ItemAttributeNamed("mod_air_control_blast_jump")
	
		/**
		 * Prevents player from jumping.
		 */
		open val noJump: ItemAttributeNamed<Boolean> = ItemAttributeNamed("no_jump")
	
		/**
		 * Prevents player from crouching.
		 */
		open val noDuck: ItemAttributeNamed<Boolean> = ItemAttributeNamed("no_duck")
	
		/**
		 * In-Game: "Disables double jump"
		 */
		open val noDoubleJump: ItemAttributeNamed<Boolean> = ItemAttributeNamed("no double jump")
	
		open val moveSpeed: MoveSpeedAttributes = MoveSpeedAttributes()
	
		open class ModJumpHeightAttributes : IBlockScoped, ItemAttribute<Number> {
			/**
			 * In-Game: "+N% greater jump height when active"
			 */
			open val standard: ItemAttributeNamed<Number> = ItemAttributeNamed("increased jump height")
	
			/**
			 * Shows in the "On Wearer:" list in the loadout screen. Note that _all_ attributes apply on wearer unless [provideOnActive][WeaponBaseAttributes.SwapWeaponsAttributes.provideOnActive] is set.
			 */
			open val descOnWearer: ItemAttributeNamed<Number> = ItemAttributeNamed("major increased jump height")
	
			open val halloween: ItemAttributeNamed<Number> = ItemAttributeNamed("halloween increased jump height")
	
			context(attrs: IAttributeContainer)
			override fun set(value: Number?) {
			    standard.set(value)
			}
	
			context(attrs: IAttributeContainer)
			override fun get(): Number? {
			    return standard.get()
			}
	
			override fun serialize(value: Number?): IVDFRepresentableKeyValue {
			    return standard.serialize(value)
			}
		}
	
		open class MoveSpeedAttributes : IBlockScoped {
			/**
			 * Only applies to players that have TF_COND_AIMING.
			 * 
			 * If Heavy, default aiming movespeed is 110.
			 * 
			 * Else if player is using a compound bow, 160.
			 * 
			 * Else 80.
			 */
			open val multPlayerAimingMovespeed: MultPlayerAimingMovespeedAttributes = MultPlayerAimingMovespeedAttributes()
	
			open val multMoveSpeed: MultPlayerMovespeedAttributes = MultPlayerMovespeedAttributes()
	
			/**
			 * In-Game: "+N% faster move speed on wearer (shield required)"
			 */
			open val moveSpeedBonusShieldRequired: ItemAttributeNamed<Number> = ItemAttributeNamed("move speed bonus shield required")
	
			open class MultPlayerAimingMovespeedAttributes : IBlockScoped {
				/**
				 * In-Game: "+N% faster move speed while deployed"
				 * 
				 * Only applies to players that have TF_COND_AIMING.
				 * 
				 * If Heavy, default aiming movespeed is 110.
				 * 
				 * Else if player is using a compound bow, 160.
				 * 
				 * Else 80.
				 */
				open val bonus: ItemAttributeNamed<Number> = ItemAttributeNamed("aiming movespeed increased")
	
				/**
				 * In-Game: "N% slower move speed while deployed"
				 * 
				 * Only applies to players that have TF_COND_AIMING.
				 * 
				 * If Heavy, default aiming movespeed is 110.
				 * 
				 * Else if player is using a compound bow, 160.
				 * 
				 * Else 80.
				 */
				open val penalty: ItemAttributeNamed<Number> = ItemAttributeNamed("aiming movespeed decreased")
	
				/**
				 * In-Game: "N% slower move speed when aiming"
				 * 
				 * Only applies to players that have TF_COND_AIMING.
				 * 
				 * If Heavy, default aiming movespeed is 110.
				 * 
				 * Else if player is using a compound bow, 160.
				 * 
				 * Else 80.
				 */
				open val penalty_sniper: ItemAttributeNamed<Number> = ItemAttributeNamed("sniper aiming movespeed decreased")
			}
	
			open class MultPlayerMovespeedAttributes : IBlockScoped, ItemAttribute<Number> {
				/**
				 * In-Game: "N% slower move speed on wearer"
				 */
				open val penalty: ItemAttributeNamed<Number> = ItemAttributeNamed("move speed penalty")
	
				/**
				 * In-Game: "+N% faster move speed on wearer"
				 */
				open val bonus: ItemAttributeNamed<Number> = ItemAttributeNamed("move speed bonus")
	
				/**
				 * Shows in the "On Wearer:" list in the loadout screen. Note that _all_ attributes apply on wearer unless [provideOnActive][WeaponBaseAttributes.SwapWeaponsAttributes.provideOnActive] is set.
				 */
				open val bonus_descOnWearer: ItemAttributeNamed<Number> = ItemAttributeNamed("major move speed bonus")
	
				/**
				 * In-Game: "+N% faster move speed on wearer"
				 */
				open val bonus_setBonus: ItemAttributeNamed<Number> = ItemAttributeNamed("SET BONUS: move speed set bonus")
	
				/**
				 * In-Game: "+N% faster move speed on wearer"
				 */
				open val bonus_card: ItemAttributeNamed<Number> = ItemAttributeNamed("CARD: move speed bonus")
	
				context(attrs: IAttributeContainer)
				override fun set(value: Number?) {
				    bonus.set(value)
				}
	
				context(attrs: IAttributeContainer)
				override fun get(): Number? {
				    return bonus.get()
				}
	
				override fun serialize(value: Number?): IVDFRepresentableKeyValue {
				    return bonus.serialize(value)
				}
			}
		}
	}
	
	open class OnHitAttributes : IBlockScoped {
		open val falling: FallingAttributes = FallingAttributes()
	
		open class FallingAttributes : IBlockScoped {
			/**
			 * In-Game: "Push enemies back when you land (force and radius based on velocity)"
			 * 
			 * Requires player to have the `TF_COND_ROCKETPACK` condition.
			 * 
			 * Pushes back nearby players around the landing site.
			 */
			open val fallingImpactRadiusPushback: ItemAttributeNamed<Boolean> = ItemAttributeNamed("falling_impact_radius_pushback")
	
			/**
			 * In-Game: "Stun enemies when you land"
			 * 
			 * If `falling_impact_radius_pushback` is set, this will also stun any enemies in the impact radius.
			 */
			open val fallingImpactRadiusStun: ItemAttributeNamed<Boolean> = ItemAttributeNamed("falling_impact_radius_stun")
		}
	}
	
	open class OnKillAttributes : IBlockScoped {
		/**
		 * In-Game: "On Kill: A small health pack is dropped"
		 * 
		 * Drop a small health pack when killing an enemy.
		 */
		open val dropHealthPack: ItemAttributeNamed<Boolean> = ItemAttributeNamed("drop health pack on kill")
	
		/**
		 * In-Game: "On Kill: Burst into joyous laughter"
		 * 
		 * On killing an enemy, schadenfreude.
		 */
		open val forceLaugh: ItemAttributeNamed<Boolean> = ItemAttributeNamed("kill forces attacker to laugh")
	
		/**
		 * In-Game: "N% damage penalty"
		 * 
		 * More like a boolean.  Doesn't actually determine any kind of decapitation, just if it CAN decapitate.
		 * 
		 * Checked on all hitscan attacks, including melee swings.
		 */
		open val decapitateType: ItemAttributeNamed<Int> = ItemAttributeNamed("decapitate type")
	
		/**
		 * In-Game: "+N% cloak on kill"
		 * 
		 * Value: amount of cloak gained on kill.
		 * 
		 * Only works on Spy.
		 */
		open val addCloak: ItemAttributeNamed<Int> = ItemAttributeNamed("add cloak on kill")
	}
	
	open class ResistanceAttributes : BaseEntityAttributes.ResistanceAttributes() {
		open val multDmgTakenCrits: MultDmgtakenFromCritAttributes = MultDmgtakenFromCritAttributes()
	
		open val multDmgTakenFire: MultDmgtakenFromFireAttributes = MultDmgtakenFromFireAttributes()
	
		/**
		 * Bonus:
		 * 
		 * 	- In-Game: "+N% explosive damage resistance on wearer"
		 * 
		 * Penalty:
		 * 
		 * 	- In-Game: "N% explosive damage vulnerability on wearer"
		 */
		open val multDmgTakenExplosives: BonusPenalty<Number> = BonusPenalty(
		    ItemAttributeNamed("dmg taken from blast reduced"),
		    ItemAttributeNamed("dmg taken from blast increased"),
		)
	
		open val multDmgTakenBullets: MultDmgtakenFromBulletsAttributes = MultDmgtakenFromBulletsAttributes()
	
		/**
		 * In-Game: "N% damage vulnerability on wearer"
		 * 
		 * Multiplier to damage taken from all sources.
		 */
		open val multDmgTaken: ItemAttributeNamed<Number> = ItemAttributeNamed("dmg taken increased")
	
		/**
		 * In-Game: "+N% sentry damage resistance on wearer"
		 */
		open val multDmgTakenSentry: ItemAttributeNamed<Number> = ItemAttributeNamed("SET BONUS: dmg from sentry reduced")
	
		/**
		 * Multiplier applied to damage taken IF: it's blast damage or a flare explosion, the damage was caused by the user (self-damage), the user did not damage other players, and it is not a taunt-kill grenade (Escape Plan, Equalizer).
		 * 
		 * Visible:
		 * 
		 * 	- In-Game: "N% blast damage from rocket jumps"
		 * 
		 * 
		 * 
		 * Hidden:
		 * 
		 * 	- In-Game: "N% blast damage from rocket jumps"
		 */
		open val rocketJumpDmgReduction: VisHidden<Number> = VisHidden(
		    ItemAttributeNamed("rocket jump damage reduction"),
		    ItemAttributeNamed("rocket jump damage reduction HIDDEN")
		)
	
		/**
		 * In-Game: "Wearer never takes falling damage"
		 */
		open val cancelFallingDamage: ItemAttributeNamed<Boolean> = ItemAttributeNamed("cancel falling damage")
	
		/**
		 * In-Game: "N% damage resistance when below 50% health and spun up"
		 * 
		 * Only procs on Heavies that are currently spun up on less than 50% HP.
		 */
		open val spunupDamageResistance: ItemAttributeNamed<Number> = ItemAttributeNamed("spunup_damage_resistance")
	
		open val vaccinator: VaccinatorAttributes = VaccinatorAttributes()
	
		open class MultDmgtakenFromCritAttributes : IBlockScoped, ItemAttribute<Number> {
			/**
			 * In-Game: "+N% critical hit damage resistance on wearer"
			 */
			open val bonus: ItemAttributeNamed<Number> = ItemAttributeNamed("dmg taken from crit reduced")
	
			/**
			 * In-Game: "N% critical hit damage vulnerability on wearer"
			 */
			open val penalty: ItemAttributeNamed<Number> = ItemAttributeNamed("dmg taken from crit increased")
	
			/**
			 * In-Game: "+N% critical hit damage resistance on wearer"
			 */
			open val bonus_setBonus: ItemAttributeNamed<Number> = ItemAttributeNamed("SET BONUS: dmg taken from crit reduced set bonus")
	
			context(attrs: IAttributeContainer)
			override fun set(value: Number?) {
			    bonus.set(value)
			}
	
			context(attrs: IAttributeContainer)
			override fun get(): Number? {
			    return bonus.get()
			}
	
			override fun serialize(value: Number?): IVDFRepresentableKeyValue {
			    return bonus.serialize(value)
			}
		}
	
		open class MultDmgtakenFromFireAttributes : IBlockScoped, ItemAttribute<Number> {
			/**
			 * In-Game: "+N% fire damage resistance on wearer"
			 */
			open val bonus: ItemAttributeNamed<Number> = ItemAttributeNamed("dmg taken from fire reduced")
	
			/**
			 * In-Game: "N% fire damage vulnerability on wearer"
			 */
			open val penalty: ItemAttributeNamed<Number> = ItemAttributeNamed("dmg taken from fire increased")
	
			/**
			 * In-Game: "+N% fire damage resistance on wearer"
			 */
			open val bonus_setBonus: ItemAttributeNamed<Number> = ItemAttributeNamed("SET BONUS: dmg taken from fire reduced set bonus")
	
			context(attrs: IAttributeContainer)
			override fun set(value: Number?) {
			    bonus.set(value)
			}
	
			context(attrs: IAttributeContainer)
			override fun get(): Number? {
			    return bonus.get()
			}
	
			override fun serialize(value: Number?): IVDFRepresentableKeyValue {
			    return bonus.serialize(value)
			}
		}
	
		open class MultDmgtakenFromBulletsAttributes : IBlockScoped, ItemAttribute<Number> {
			/**
			 * In-Game: "+N% bullet damage resistance on wearer"
			 */
			open val bonus: ItemAttributeNamed<Number> = ItemAttributeNamed("dmg taken from bullets reduced")
	
			/**
			 * In-Game: "N% bullet damage vulnerability on wearer"
			 */
			open val penalty: ItemAttributeNamed<Number> = ItemAttributeNamed("dmg taken from bullets increased")
	
			/**
			 * In-Game: "N% bullet damage vulnerability on wearer"
			 */
			open val penalty_setBonus: ItemAttributeNamed<Number> = ItemAttributeNamed("SET BONUS: dmg taken from bullets increased")
	
			/**
			 * In-Game: "+N% bullet damage resistance on wearer"
			 */
			open val penalty_card: ItemAttributeNamed<Number> = ItemAttributeNamed("CARD: dmg taken from bullets reduced")
	
			context(attrs: IAttributeContainer)
			override fun set(value: Number?) {
			    bonus.set(value)
			}
	
			context(attrs: IAttributeContainer)
			override fun get(): Number? {
			    return bonus.get()
			}
	
			override fun serialize(value: Number?): IVDFRepresentableKeyValue {
			    return bonus.serialize(value)
			}
		}
	
		open class VaccinatorAttributes : IBlockScoped {
			/**
			 * Multiplier to damage taken if player has TF_COND_MEDIGUN_UBER_BULLET_RESIST.
			 */
			open val medigunBulletResistDeployed: ItemAttributeNamed<Number> = ItemAttributeNamed("medigun bullet resist deployed")
	
			/**
			 * Multiplier to damage taken if player has TF_COND_MEDIGUN_SMALL_BULLET_RESIST.
			 */
			open val medigunBulletResistPassive: ItemAttributeNamed<Number> = ItemAttributeNamed("medigun bullet resist passive")
	
			/**
			 * Multiplier to damage taken if player has TF_COND_MEDIGUN_UBER_BLAST_RESIST.
			 */
			open val medigunBlastResistDeployed: ItemAttributeNamed<Number> = ItemAttributeNamed("medigun blast resist deployed")
	
			/**
			 * Multiplier to damage taken if player has TF_COND_MEDIGUN_SMALL_BLAST_RESIST.
			 */
			open val medigunBlastResistPassive: ItemAttributeNamed<Number> = ItemAttributeNamed("medigun blast resist passive")
	
			/**
			 * Multiplier to damage taken if player has TF_COND_MEDIGUN_UBER_FIRE_RESIST.
			 */
			open val medigunFireResistDeployed: ItemAttributeNamed<Number> = ItemAttributeNamed("medigun fire resist deployed")
	
			/**
			 * Multiplier to damage taken if player has TF_COND_MEDIGUN_SMALL_FIRE_RESIST.
			 */
			open val medigunFireResistPassive: ItemAttributeNamed<Number> = ItemAttributeNamed("medigun fire resist passive")
		}
	}
	
	open class TauntingAttributes : IBlockScoped {
		/**
		 * In-Game: "+N% faster taunt speed on wearer"
		 * 
		 * Multiplier applied to taunt speed.
		 */
		open val gestureSpeedIncrease: ItemAttributeNamed<Number> = ItemAttributeNamed("gesture speed increase")
	
		/**
		 * Sound to be played when performing a taunt.
		 */
		open val cosmeticTauntSound: ItemAttributeNamed<String> = ItemAttributeNamed("cosmetic taunt sound")
	
		/**
		 * In-Game: "Extra effects when taunting."
		 * 
		 * Use Saharan Spy particle effect when performing a stock knife taunt.  Only works on Spy.
		 */
		open val setBonusCustomTauntParticleAttr: ItemAttributeNamed<Boolean> = ItemAttributeNamed("SET BONUS: custom taunt particle attr")
	}
	
	open class SwapWeaponsAttributes : IBlockScoped {
		open val disableWeaponSwitch: ItemAttributeNamed<Boolean> = ItemAttributeNamed("disable weapon switch")
	}
	
	open class WhenHitAttributes : IBlockScoped {
		/**
		 * Number of seconds the player who hit this entity should be marked for death.
		 * 
		 * If attacker is affected by `TF_COND_ENERGY_BUFF` (Crit-a-Cola, Cleaner's Carbine, Buffalo Steak, etc.), the attacker receives `TF_COND_MARKEDFORDEATH_SILENT`.
		 */
		open val markAttackerForDeath: ItemAttributeNamed<Number> = ItemAttributeNamed("mod_mark_attacker_for_death")
	
		/**
		 * In-Game: "When backstabbed: Jarate attacker"
		 * 
		 * If true, jarates anyone who backstabs this player.
		 * 
		 * Note: does not block backstabs on its own.
		 */
		open val jarateBackstabber: ItemAttributeNamed<Boolean> = ItemAttributeNamed("jarate backstabber")
	}
	
	open class SpyOnlyAttributes : IBlockScoped 
	
	open class CritsAttributes : BaseEntityAttributes.CritsAttributes() 
	
	object Inherited : PlayerAttributes 
}