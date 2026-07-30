package btpos.source.vdfdsl.tf2.itemattributes

import btpos.source.vdfdsl.modeling.*
import btpos.source.vdfdsl.serialization.codecs.*
import btpos.source.vdfdsl.tf2.itemattributes.impl.*
import btpos.source.vdfdsl.tf2.tftypes.*
import java.util.*



interface PlayerAttributes : EntityAttributes {
	companion object {
		val ammo: AmmoAttributes = AmmoAttributes()
	
		val buffItems: BuffItemsAttributes = BuffItemsAttributes()
	
		val cloak: CloakAttributes = CloakAttributes()
	
		val damage: DamageAttributes = DamageAttributes()
	
		val demoCharge: DemoChargeAttributes = DemoChargeAttributes()
	
		val disguise: DisguiseAttributes = DisguiseAttributes()
	
		val firing: FiringAttributes = FiringAttributes()
	
		val knockbackReceived: KnockbackReceivedAttributes = KnockbackReceivedAttributes()
	
		val onHit: OnHitAttributes = OnHitAttributes()
	
		val onKill: OnKillAttributes = OnKillAttributes()
	
		val taunting: TauntingAttributes = TauntingAttributes()
	
		val swapWeapons: SwapWeaponsAttributes = SwapWeaponsAttributes()
	
		val whenHit: WhenHitAttributes = WhenHitAttributes()
	
		/**
		 * In-Game: "Über duration increased N seconds"
		 * 
		 * Duration in seconds.
		 */
		val uberDurationBonus: ItemAttributeNamed<Duration> = ItemAttributeNamed("uber duration bonus")
	
		val heavyOnly: HeavyOnlyAttributes = HeavyOnlyAttributes()
	
		val sniperOnly: SniperOnlyAttributes = SniperOnlyAttributes()
	
		val medicOnly: MedicOnlyAttributes = MedicOnlyAttributes()
	
		val spyOnly: SpyOnlyAttributes = SpyOnlyAttributes()
	
		val buildings: BuildingsAttributes = BuildingsAttributes()
	
		val healthAndHealing: HealthAndHealingAttributes = HealthAndHealingAttributes()
	
		val meta: MetaAttributes = MetaAttributes()
	
		val meter: MeterAttributes = MeterAttributes()
	
		val movement: MovementAttributes = MovementAttributes()
	
		val hud: HudAttributes = HudAttributes()
	
		val resistance: ResistanceAttributes = ResistanceAttributes()
	}

	val ammo: AmmoAttributes get() = PlayerAttributes.ammo
	
	val buffItems: BuffItemsAttributes get() = PlayerAttributes.buffItems
	
	override val buildings: BuildingsAttributes get() = PlayerAttributes.buildings
	
	val cloak: CloakAttributes get() = PlayerAttributes.cloak
	
	val damage: DamageAttributes get() = PlayerAttributes.damage
	
	val demoCharge: DemoChargeAttributes get() = PlayerAttributes.demoCharge
	
	val disguise: DisguiseAttributes get() = PlayerAttributes.disguise
	
	val firing: FiringAttributes get() = PlayerAttributes.firing
	
	override val healthAndHealing: HealthAndHealingAttributes get() = PlayerAttributes.healthAndHealing
	
	override val hud: HudAttributes get() = PlayerAttributes.hud
	
	val knockbackReceived: KnockbackReceivedAttributes get() = PlayerAttributes.knockbackReceived
	
	override val meta: MetaAttributes get() = PlayerAttributes.meta
	
	override val meter: MeterAttributes get() = PlayerAttributes.meter
	
	override val movement: MovementAttributes get() = PlayerAttributes.movement
	
	val onHit: OnHitAttributes get() = PlayerAttributes.onHit
	
	val onKill: OnKillAttributes get() = PlayerAttributes.onKill
	
	override val resistance: ResistanceAttributes get() = PlayerAttributes.resistance
	
	val taunting: TauntingAttributes get() = PlayerAttributes.taunting
	
	val swapWeapons: SwapWeaponsAttributes get() = PlayerAttributes.swapWeapons
	
	val whenHit: WhenHitAttributes get() = PlayerAttributes.whenHit
	
	/**
	 * In-Game: "Über duration increased N seconds"
	 * 
	 * Duration in seconds.
	 */
	val uberDurationBonus: ItemAttributeNamed<Duration> get() = PlayerAttributes.uberDurationBonus
	
	val heavyOnly: HeavyOnlyAttributes get() = PlayerAttributes.heavyOnly
	
	val sniperOnly: SniperOnlyAttributes get() = PlayerAttributes.sniperOnly
	
	val medicOnly: MedicOnlyAttributes get() = PlayerAttributes.medicOnly
	
	val spyOnly: SpyOnlyAttributes get() = PlayerAttributes.spyOnly

	open class AmmoAttributes {
		open val grenades1ResupplyDenied: ItemAttributeNamed<Boolean> = ItemAttributeNamed("grenades1_resupply_denied")
	
		open val grenades2ResupplyDenied: ItemAttributeNamed<Boolean> = ItemAttributeNamed("grenades2_resupply_denied")
	
		open val grenades3ResupplyDenied: ItemAttributeNamed<Boolean> = ItemAttributeNamed("grenades3_resupply_denied")
	
		/**
		 * In-Game: "+N% ammo regenerated every 5 seconds on wearer"
		 * 
		 * Percentage of ammo regenerated every 5 seconds.
		 */
		open val ammoRegen: ItemAttributeNamed<Float> = ItemAttributeNamed("ammo regen")
	
		/**
		 * In-Game: "N% less metal from pickups and dispensers"
		 * 
		 * Multiplier applied to metal gained from ammo boxes.
		 */
		open val metalPickupDecreased: ItemAttributeNamed<Float> = ItemAttributeNamed("metal_pickup_decreased")
	
		/**
		 * In-Game: "+N metal regenerated every 5 seconds on wearer"
		 * 
		 * Amount of metal regenerated every 5 seconds.
		 */
		open val metalRegen: ItemAttributeNamed<Int> = ItemAttributeNamed("metal regen")
	
		open val maxAmmo: MaxAmmoAttributes = MaxAmmoAttributes()
	
		open class MaxAmmoAttributes {
			open val maxammoPrimaryReduced: BonusPenaltyHidden<Int, ItemAttributeNamed<Int>> = BonusPenaltyHidden(
				ItemAttributeNamed<Int>("maxammo primary increased"),
				ItemAttributeNamed<Int>("maxammo primary reduced"),
				ItemAttributeNamed<Int>("hidden primary max ammo bonus"),
			)
	
			open val maxammoSecondaryReduced: BonusPenaltyHidden<Int, ItemAttributeNamed<Int>> = BonusPenaltyHidden(
				ItemAttributeNamed<Int>("maxammo secondary increased"),
				ItemAttributeNamed<Int>("maxammo secondary reduced"),
				ItemAttributeNamed<Int>("hidden secondary max ammo penalty"),
			)
	
			open val maxammoMetalReduced: BonusPenalty<Int> = BonusPenalty(
				ItemAttributeNamed("maxammo metal increased"),
				ItemAttributeNamed("maxammo metal reduced"),
			)
	
			/**
			 * In-Game: "+N% max misc ammo on wearer"
			 * 
			 * Only used for bat balls.
			 */
			open val maxammoGrenades1Increased: ItemAttributeNamed<Int> = ItemAttributeNamed("maxammo grenades1 increased")
		}
	}
	
	open class BuffItemsAttributes {
		open val buffDuration: VisHidden<Float> = VisHidden(ItemAttributeNamed<Float>("increase buff duration"), ItemAttributeNamed<Float>("increase buff duration HIDDEN"))
	
		open val buffType: BuffTypeAttributes = BuffTypeAttributes()
	
		open class BuffTypeAttributes {
			/**
			 * Note that Phlogistinator's rage has a small cooldown after expiring before it can gain rage again, to prevent the lingering crit flames from immediately filling it up again.
			 */
			open val soldierBuffType: ItemAttributeNamed<Int> = ItemAttributeNamed("mod soldier buff type")
	
			/**
			 * Note that Phlogistinator's rage has a small cooldown after expiring before it can gain rage again, to prevent the lingering crit flames from immediately filling it up again.
			 */
			open val demoBuffType: ItemAttributeNamed<Int> = ItemAttributeNamed("mod demo buff type")
		}
	}
	
	open class BuildingsAttributes : EntityAttributes.BuildingsAttributes() {
		/**
		 * In-Game: "Cannot carry buildings"
		 * 
		 * Prevents player from picking up buildings.
		 */
		open val cannotPickUpBuildings: ItemAttributeNamed<Boolean> = ItemAttributeNamed("cannot pick up buildings")
	
		/**
		 * In-Game: "N metal reduction in building cost"
		 * 
		 * Sets the cost to construct any building type to this value.
		 */
		open val buildingCostReduction: ItemAttributeNamed<Int> = ItemAttributeNamed("building cost reduction")
	
		/**
		 * In-Game: "Sentry build speed increased by N%"
		 */
		open val engineerSentryBuildRateMultiplier: ItemAttributeNamed<Float> = ItemAttributeNamed("engineer sentry build rate multiplier")
	
		override val sentryGun: SentryGunAttributes = SentryGunAttributes()
	
		override val dispenser: DispenserAttributes = DispenserAttributes()
	
		override val teleporter: TeleporterAttributes = TeleporterAttributes()
	
		open class SentryGunAttributes : EntityAttributes.BuildingsAttributes.SentryGunAttributes() {
			/**
			 * In-Game: "Build +N additional disposable-sentry"
			 * 
			 * Number of disposable sentries you're allowed to build.
			 * 
			 * Checked when checking if the player can build something.
			 * 
			 * Only works if the "uses upgrades" gamerule is set.
			 */
			open val engyDisposableSentries: ItemAttributeNamed<Int> = ItemAttributeNamed("engy disposable sentries")
		}
	
		open class DispenserAttributes : EntityAttributes.BuildingsAttributes.DispenserAttributes() {
			/**
			 * In-Game: "Increases teleporter build speed by N%."
			 * 
			 * Multiplier applied to passive build time for dispensers and teleporters.
			 */
			open val engineerTeleporterBuildRateMultiplier: ItemAttributeNamed<Float> = ItemAttributeNamed("engineer teleporter build rate multiplier")
		}
	
		open class TeleporterAttributes : EntityAttributes.BuildingsAttributes.TeleporterAttributes() {
			/**
			 * In-Game: "N% metal cost when constructing or upgrading teleporters"
			 * 
			 * Multiplier applied to teleporter construction cost.
			 */
			override val teleporterCost: ItemAttributeNamed<Float> get() = super.teleporterCost
	
			/**
			 * In-Game: "Increases teleporter build speed by N%."
			 * 
			 * Multiplier applied to passive build time for dispensers and teleporters.
			 */
			open val engineerTeleporterBuildRateMultiplier: ItemAttributeNamed<Float> = ItemAttributeNamed("engineer teleporter build rate multiplier")
		}
	}
	
	open class CloakAttributes {
		/**
		 * In-Game: "N sec longer cloak blink time"
		 * 
		 * Multiplier.
		 */
		open val setBonusCloakBlinkTimePenalty: ItemAttributeNamed<Float> = ItemAttributeNamed("SET BONUS: cloak blink time penalty")
	
		/**
		 * In-Game: "N sec increase in time to cloak"
		 */
		open val multCloakRate: ItemAttributeNamed<Float> = ItemAttributeNamed("mult cloak rate")
	
		/**
		 * In-Game: "Reduced decloak sound volume"
		 * 
		 * If true, plays `Player.Spy_UnCloakReduced` when decloaking.
		 */
		open val setBonusQuietUnstealth: ItemAttributeNamed<Boolean> = ItemAttributeNamed("SET BONUS: quiet unstealth")
	
		open val multDecloakRate: ItemAttributeNamed<Float> = ItemAttributeNamed("mult decloak rate")
	}
	
	open class DamageAttributes {
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
		open val headshotDamageIncrease: ItemAttributeNamed<Float> = ItemAttributeNamed("headshot damage increase")
	
		open val alien: AlienAttributes = AlienAttributes()
	
		open class AlienAttributes {
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
	
	open class DemoChargeAttributes {
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
		open val killRefillsMeter: ItemAttributeNamed<Float> = ItemAttributeNamed("kill refills meter")
	
		open val chargeTime: VisHidden<Float> = VisHidden(ItemAttributeNamed<Float>("charge time increased"), ItemAttributeNamed<Float>("charge time decreased"))
	
		/**
		 * In-Game: "+N% increase in charge recharge rate"
		 * 
		 * Only applies to Demoman.
		 */
		open val chargeRechargeRateIncreased: ItemAttributeNamed<Float> = ItemAttributeNamed("charge recharge rate increased")
	
		open val multChargeTurnControl: MultChargeTurnControlAttributes = MultChargeTurnControlAttributes()
	
		open class MultChargeTurnControlAttributes {
			/**
			 * In-Game: "+N% increase in turning control while charging"
			 * 
			 * Default is 0.45f, and this is a multiplier applied to it.
			 */
			open val multChargeTurnControl: ItemAttributeNamed<Float> = ItemAttributeNamed("mult charge turn control")
	
			/**
			 * In-Game: "Full turning control while charging"
			 * 
			 * Default is 0.45f, and this is a multiplier applied to it.
			 */
			open val fullChargeTurnControl: ItemAttributeNamed<Float> = ItemAttributeNamed("full charge turn control")
		}
	}
	
	open class DisguiseAttributes {
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
	
	open class FiringAttributes {
		/**
		 * Prevents player from attacking.
		 */
		open val noAttack: ItemAttributeNamed<Boolean> = ItemAttributeNamed("no_attack")
	}
	
	open class HealthAndHealingAttributes : EntityAttributes.HealthAndHealingAttributes() {
		open val healthFromHealersReduced: BonusPenalty<Float> = BonusPenalty(
			ItemAttributeNamed("health from healers increased"),
			ItemAttributeNamed("health from healers reduced"),
		)
	
		/**
		 * In-Game: "Blocks healing while in use"
		 */
		open val weaponBlocksHealing: ItemAttributeNamed<Boolean> = ItemAttributeNamed("mod weapon blocks healing")
	
		/**
		 * In-Game: "+N max health on wearer"
		 * 
		 * Additive base-health increase.
		 */
		open val hiddenMaxhealthNonBuffed: ItemAttributeNamed<Int> = ItemAttributeNamed("hidden maxhealth non buffed")
	
		open val healthRegen: HealthRegenAttributes = HealthRegenAttributes()
	
		open val maxHealthAdditive: MaxHealthAdditiveAttributes = MaxHealthAdditiveAttributes()
	
		open class HealthRegenAttributes {
			/**
			 * In-Game: "+N health regenerated per second on wearer"
			 * 
			 * Amount of health regenerated per regen tick.	Scales by the amount of time since the player last took damage in non-MvM modes.
			 */
			open val healthRegen: ItemAttributeNamed<Float> = ItemAttributeNamed("health regen")
	
			/**
			 * In-Game: "N health drained per second on wearer"
			 * 
			 * Amount of health regenerated per regen tick.	Scales by the amount of time since the player last took damage in non-MvM modes.
			 */
			open val healthDrain: ItemAttributeNamed<Float> = ItemAttributeNamed("health drain")
	
			/**
			 * In-Game: "+N health regenerated per second on wearer"
			 * 
			 * Amount of health regenerated per regen tick.	Scales by the amount of time since the player last took damage in non-MvM modes.
			 */
			open val setBonusHealthRegenSetBonus: ItemAttributeNamed<Float> = ItemAttributeNamed("SET BONUS: health regen set bonus")
	
			/**
			 * In-Game: "N health regenerated per second on wearer"
			 * 
			 * Amount of health regenerated per regen tick.	Scales by the amount of time since the player last took damage in non-MvM modes.
			 */
			open val healthDrainMedic: ItemAttributeNamed<Float> = ItemAttributeNamed("health drain medic")
	
			/**
			 * In-Game: "+N health regenerated per second on wearer"
			 * 
			 * Amount of health regenerated per regen tick.	Scales by the amount of time since the player last took damage in non-MvM modes.
			 */
			open val cardHealthRegen: ItemAttributeNamed<Float> = ItemAttributeNamed("CARD: health regen")
		}
	
		open class MaxHealthAdditiveAttributes {
			/**
			 * In-Game: "+N max health on wearer"
			 * 
			 * Additive maximum health increase only checked when overhealing.
			 */
			open val maxHealthAdditiveBonus: ItemAttributeNamed<Int> = ItemAttributeNamed("max health additive bonus")
	
			/**
			 * In-Game: "N max health on wearer"
			 * 
			 * Additive maximum health increase only checked when overhealing.
			 */
			open val maxHealthAdditivePenalty: ItemAttributeNamed<Int> = ItemAttributeNamed("max health additive penalty")
	
			/**
			 * In-Game: "+N max health on wearer"
			 * 
			 * Additive maximum health increase only checked when overhealing.
			 */
			open val setBonusMaxHealthAdditiveBonus: ItemAttributeNamed<Int> = ItemAttributeNamed("SET BONUS: max health additive bonus")
		}
	}
	
	open class HudAttributes : EntityAttributes.HudAttributes() {
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
	
	open class KnockbackReceivedAttributes {
		open val airblastVulnerabilityMultiplier: VisHidden<Float> = VisHidden(ItemAttributeNamed<Float>("airblast vulnerability multiplier"), ItemAttributeNamed<Float>("airblast vulnerability multiplier hidden"))
	
		open val airblastVerticalVulnerabilityMultiplier: ItemAttributeNamed<Float> = ItemAttributeNamed("airblast vertical vulnerability multiplier")
	}
	
	open class MetaAttributes : EntityAttributes.MetaAttributes() {
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
	
		open val killfeed: KillfeedAttributes = KillfeedAttributes()
	
		open val noisemakers: NoisemakersAttributes = NoisemakersAttributes()
	
		open val items: ItemsAttributes = ItemsAttributes()
	
		open val player: PlayerAttributes = PlayerAttributes()
	
		open val gameplay: GameplayAttributes = GameplayAttributes()
	
		open class KillfeedAttributes {
			/**
			 * If the weapon is a Holy Mackerel reskin (AKA either the fish or the Unarmed Combat) and this is set, use the Unarmed Combat "arm hit" killfeed notice instead of the "fish hit" notice.
			 */
			open val fishDamageOverride: ItemAttributeNamed<Boolean> = ItemAttributeNamed("fish damage override")
		}
	
		open class NoisemakersAttributes {
			/**
			 * In-Game: "Noise Maker"
			 * 
			 * Uses noise maker when pressing action slot key.
			 */
			open val noiseMaker: ItemAttributeNamed<Boolean> = ItemAttributeNamed("noise maker")
	
			open val unlimitedQuantity: VisHidden<Boolean> = VisHidden(ItemAttributeNamed<Boolean>("unlimited quantity"), ItemAttributeNamed<Boolean>("unlimited quantity hidden"))
		}
	
		open class ItemsAttributes {
			/**
			 * In-Game: "Killstreaks Active"
			 */
			open val killstreakTier: ItemAttributeNamed<Int> = ItemAttributeNamed("killstreak tier")
		}
	
		open class PlayerAttributes {
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
			open val zombiezombiezombiezombie: ItemAttributeNamed<Boolean> = ItemAttributeNamed("zombiezombiezombiezombie")
	
			/**
			 * In-Game: "Disables double jump"
			 */
			open val headScale: ItemAttributeNamed<Float> = ItemAttributeNamed("head scale")
	
			open val torsoScale: ItemAttributeNamed<Float> = ItemAttributeNamed("torso scale")
	
			open val handScale: ItemAttributeNamed<Float> = ItemAttributeNamed("hand scale")
	
			/**
			 * DSP used when emitting sounds created by this player.
			 */
			open val setBonusSpecialDsp: ItemAttributeNamed<Int> = ItemAttributeNamed("SET BONUS: special dsp")
		}
	
		open class GameplayAttributes {
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
	}
	
	open class MeterAttributes : EntityAttributes.MeterAttributes() {
		/**
		 * Multiplier applied to rage gained by dealing damage, taking damage, or dealing burn damage.
		 */
		open val rageGivingScale: ItemAttributeNamed<Float> = ItemAttributeNamed("rage giving scale")
	
		/**
		 * In-Game: "On Hit: Builds Hype"
		 * 
		 * Adds the amount of damage dealt to the Scout hype meter, to a maximum of 200 damage which adds 50% meter.
		 */
		open val hypeOnDamage: ItemAttributeNamed<Boolean> = ItemAttributeNamed("hype on damage")
	
		/**
		 * Only procs on Sniper. Gain this amount of rage meter on assists.
		 */
		open val rageOnAssists: ItemAttributeNamed<Float> = ItemAttributeNamed("rage on assists")
	
		/**
		 * In-Game: "Boost reduced on air jumps"
		 * 
		 * The amount to be subtracted from the hype meter when the Scout double-jumps.
		 */
		override val hypeResetsOnJump: ItemAttributeNamed<Int> get() = super.hypeResetsOnJump
	
		/**
		 * If `mult_item_meter_charge_rate` is set, checks this attribute to see what type of meter should be modified, and also only allows it to activate if the active weapon is not a TF_WEAPON_FLAMEBALL.
		 */
		open val chargeType: ItemAttributeNamed<Int> = ItemAttributeNamed("item_meter_charge_type")
	
		/**
		 * In-Game: "Hype Decays Over Time."
		 * 
		 * How much the Scout's hype meter decays every tick.
		 */
		open val hypeDecaysOverTime: ItemAttributeNamed<Float> = ItemAttributeNamed("hype decays over time")
	
		/**
		 * In-Game: "Boost reduced when hit"
		 * 
		 * Amount of hype lost per point of damage taken.
		 */
		open val loseHypeOnTakeDamage: ItemAttributeNamed<Int> = ItemAttributeNamed("lose hype on take damage")
	
		open val generateRageOnDamage: GenerateRageOnDamageAttributes = GenerateRageOnDamageAttributes()
	
		open class GenerateRageOnDamageAttributes {
			/**
			 * In-Game: "Generate Rage by dealing damage.  When fully charged, press the Special-Attack key to activate knockback"
			 * 
			 * Only works on Engineer and Heavy.
			 * 
			 * On Engineer, adds all damage dealt to the rage meter.
			 * 
			 * On Heavy, adds `0.22` * the damage.
			 */
			open val generateRageOnDamage: ItemAttributeNamed<Boolean> = ItemAttributeNamed("generate rage on damage")
	
			/**
			 * In-Game: "Generate building rescue energy on damage"
			 * 
			 * Only works on Engineer and Heavy.
			 * 
			 * On Engineer, adds all damage dealt to the rage meter.
			 * 
			 * On Heavy, adds `0.22` * the damage.
			 */
			open val engineerRageOnDmg: ItemAttributeNamed<Boolean> = ItemAttributeNamed("engineer rage on dmg")
		}
	}
	
	open class MovementAttributes : EntityAttributes.MovementAttributes() {
		/**
		 * In-Game: "N% increased air control."
		 * 
		 * Note: the jetpack condition always multiplies your air acceleration by 50%.
		 */
		open val increasedAirControl: ItemAttributeNamed<Float> = ItemAttributeNamed("increased air control")
	
		/**
		 * In-Game: "N% increased air control when blast jumping."
		 * 
		 * Specifically while blast-jumping, as opposed to global.
		 */
		open val airControlBlastJump: ItemAttributeNamed<Float> = ItemAttributeNamed("mod_air_control_blast_jump")
	
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
	
		override val jumpHeight: jumpHeightAttributes = jumpHeightAttributes()
	
		open val moveSpeed: MoveSpeedAttributes = MoveSpeedAttributes()
	
		open class jumpHeightAttributes : EntityAttributes.MovementAttributes.jumpHeightAttributes() {
			/**
			 * In-Game: "+N% greater jump height when active"
			 */
			override val increasedJumpHeight: ItemAttributeNamed<Float> get() = super.increasedJumpHeight
	
			override val majorIncreasedJumpHeight: ItemAttributeNamed<Float> get() = super.majorIncreasedJumpHeight
	
			override val halloweenIncreasedJumpHeight: ItemAttributeNamed<Float> get() = super.halloweenIncreasedJumpHeight
		}
	
		open class MoveSpeedAttributes {
			/**
			 * In-Game: "+N% faster move speed on wearer (shield required)"
			 */
			open val moveSpeedBonusShieldRequired: ItemAttributeNamed<Float> = ItemAttributeNamed("move speed bonus shield required")
	
			open val aimingMovespeed: AimingMovespeedAttributes = AimingMovespeedAttributes()
	
			open val moveSpeed: MoveSpeedAttributes = MoveSpeedAttributes()
	
			open class AimingMovespeedAttributes {
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
				open val aimingMovespeedIncreased: ItemAttributeNamed<Float> = ItemAttributeNamed("aiming movespeed increased")
	
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
				open val aimingMovespeedDecreased: ItemAttributeNamed<Float> = ItemAttributeNamed("aiming movespeed decreased")
	
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
				open val sniperAimingMovespeedDecreased: ItemAttributeNamed<Float> = ItemAttributeNamed("sniper aiming movespeed decreased")
			}
	
			open class MoveSpeedAttributes {
				/**
				 * In-Game: "N% slower move speed on wearer"
				 */
				open val moveSpeedPenalty: ItemAttributeNamed<Float> = ItemAttributeNamed("move speed penalty")
	
				/**
				 * In-Game: "+N% faster move speed on wearer"
				 */
				open val moveSpeedBonus: ItemAttributeNamed<Float> = ItemAttributeNamed("move speed bonus")
	
				open val majorMoveSpeedBonus: ItemAttributeNamed<Float> = ItemAttributeNamed("major move speed bonus")
	
				/**
				 * In-Game: "+N% faster move speed on wearer"
				 */
				open val setBonusMoveSpeedSetBonus: ItemAttributeNamed<Float> = ItemAttributeNamed("SET BONUS: move speed set bonus")
	
				/**
				 * In-Game: "+N% faster move speed on wearer"
				 */
				open val cardMoveSpeedBonus: ItemAttributeNamed<Float> = ItemAttributeNamed("CARD: move speed bonus")
			}
		}
	}
	
	open class OnHitAttributes {
		open val falling: FallingAttributes = FallingAttributes()
	
		open class FallingAttributes {
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
	
	open class OnKillAttributes {
		/**
		 * In-Game: "On Kill: A small health pack is dropped"
		 * 
		 * Drop a small health pack when killing an enemy.
		 */
		open val dropHealthPackOnKill: ItemAttributeNamed<Boolean> = ItemAttributeNamed("drop health pack on kill")
	
		/**
		 * In-Game: "On Kill: Burst into joyous laughter"
		 * 
		 * On killing an enemy, schadenfreude.
		 */
		open val killForcesAttackerToLaugh: ItemAttributeNamed<Boolean> = ItemAttributeNamed("kill forces attacker to laugh")
	
		/**
		 * In-Game: "N% damage penalty"
		 * 
		 * More like a boolean.	Doesn't actually determine any kind of decapitation, just if it CAN decapitate.
		 * 
		 * Checked on all hitscan attacks.
		 */
		open val decapitateType: ItemAttributeNamed<Int> = ItemAttributeNamed("decapitate type")
	}
	
	open class ResistanceAttributes : EntityAttributes.ResistanceAttributes() {
		open val dmgTakenFromBlast: BonusPenalty<Float> = BonusPenalty(
			ItemAttributeNamed("dmg taken from blast reduced"),
			ItemAttributeNamed("dmg taken from blast increased"),
		)
	
		/**
		 * In-Game: "N% damage vulnerability on wearer"
		 * 
		 * Multiplier to damage taken from all sources.
		 */
		open val dmgTakenIncreased: ItemAttributeNamed<Float> = ItemAttributeNamed("dmg taken increased")
	
		/**
		 * In-Game: "+N% sentry damage resistance on wearer"
		 */
		open val setBonusDmgFromSentryReduced: ItemAttributeNamed<Float> = ItemAttributeNamed("SET BONUS: dmg from sentry reduced")
	
		open val rocketJumpDamageReduction: VisHidden<Float> = VisHidden(ItemAttributeNamed<Float>("rocket jump damage reduction"), ItemAttributeNamed<Float>("rocket jump damage reduction HIDDEN"))
	
		/**
		 * In-Game: "Wearer never takes falling damage"
		 */
		open val cancelFallingDamage: ItemAttributeNamed<Boolean> = ItemAttributeNamed("cancel falling damage")
	
		/**
		 * In-Game: "N% damage resistance when below 50% health and spun up"
		 * 
		 * Only procs on Heavies that are currently spun up on less than 50% HP.
		 */
		open val spunupDamageResistance: ItemAttributeNamed<Float> = ItemAttributeNamed("spunup_damage_resistance")
	
		open val dmgTakenFromCritReduced: DmgTakenFromCritReducedAttributes = DmgTakenFromCritReducedAttributes()
	
		open val dmgTakenFromFireReduced: DmgTakenFromFireReducedAttributes = DmgTakenFromFireReducedAttributes()
	
		open val dmgTakenFromBulletsReduced: DmgTakenFromBulletsReducedAttributes = DmgTakenFromBulletsReducedAttributes()
	
		open val vaccinator: VaccinatorAttributes = VaccinatorAttributes()
	
		open class DmgTakenFromCritReducedAttributes {
			/**
			 * In-Game: "+N% critical hit damage resistance on wearer"
			 */
			open val dmgTakenFromCritReduced: ItemAttributeNamed<Float> = ItemAttributeNamed("dmg taken from crit reduced")
	
			/**
			 * In-Game: "N% critical hit damage vulnerability on wearer"
			 */
			open val dmgTakenFromCritIncreased: ItemAttributeNamed<Float> = ItemAttributeNamed("dmg taken from crit increased")
	
			/**
			 * In-Game: "+N% critical hit damage resistance on wearer"
			 */
			open val setBonusDmgTakenFromCritReducedSetBonus: ItemAttributeNamed<Float> = ItemAttributeNamed("SET BONUS: dmg taken from crit reduced set bonus")
		}
	
		open class DmgTakenFromFireReducedAttributes {
			/**
			 * In-Game: "+N% fire damage resistance on wearer"
			 */
			open val dmgTakenFromFireReduced: ItemAttributeNamed<Float> = ItemAttributeNamed("dmg taken from fire reduced")
	
			/**
			 * In-Game: "N% fire damage vulnerability on wearer"
			 */
			open val dmgTakenFromFireIncreased: ItemAttributeNamed<Float> = ItemAttributeNamed("dmg taken from fire increased")
	
			/**
			 * In-Game: "+N% fire damage resistance on wearer"
			 */
			open val setBonusDmgTakenFromFireReducedSetBonus: ItemAttributeNamed<Float> = ItemAttributeNamed("SET BONUS: dmg taken from fire reduced set bonus")
		}
	
		open class DmgTakenFromBulletsReducedAttributes {
			/**
			 * In-Game: "+N% bullet damage resistance on wearer"
			 */
			open val dmgTakenFromBulletsReduced: ItemAttributeNamed<Float> = ItemAttributeNamed("dmg taken from bullets reduced")
	
			/**
			 * In-Game: "N% bullet damage vulnerability on wearer"
			 */
			open val dmgTakenFromBulletsIncreased: ItemAttributeNamed<Float> = ItemAttributeNamed("dmg taken from bullets increased")
	
			/**
			 * In-Game: "N% bullet damage vulnerability on wearer"
			 */
			open val setBonusDmgTakenFromBulletsIncreased: ItemAttributeNamed<Float> = ItemAttributeNamed("SET BONUS: dmg taken from bullets increased")
	
			/**
			 * In-Game: "+N% bullet damage resistance on wearer"
			 */
			open val cardDmgTakenFromBulletsReduced: ItemAttributeNamed<Float> = ItemAttributeNamed("CARD: dmg taken from bullets reduced")
		}
	
		open class VaccinatorAttributes {
			/**
			 * Multiplier to damage taken if player has TF_COND_MEDIGUN_UBER_BULLET_RESIST.
			 */
			open val medigunBulletResistDeployed: ItemAttributeNamed<Float> = ItemAttributeNamed("medigun bullet resist deployed")
	
			/**
			 * Multiplier to damage taken if player has TF_COND_MEDIGUN_SMALL_BULLET_RESIST.
			 */
			open val medigunBulletResistPassive: ItemAttributeNamed<Float> = ItemAttributeNamed("medigun bullet resist passive")
	
			/**
			 * Multiplier to damage taken if player has TF_COND_MEDIGUN_UBER_BLAST_RESIST.
			 */
			open val medigunBlastResistDeployed: ItemAttributeNamed<Float> = ItemAttributeNamed("medigun blast resist deployed")
	
			/**
			 * Multiplier to damage taken if player has TF_COND_MEDIGUN_SMALL_BLAST_RESIST.
			 */
			open val medigunBlastResistPassive: ItemAttributeNamed<Float> = ItemAttributeNamed("medigun blast resist passive")
	
			/**
			 * Multiplier to damage taken if player has TF_COND_MEDIGUN_UBER_FIRE_RESIST.
			 */
			open val medigunFireResistDeployed: ItemAttributeNamed<Float> = ItemAttributeNamed("medigun fire resist deployed")
	
			/**
			 * Multiplier to damage taken if player has TF_COND_MEDIGUN_SMALL_FIRE_RESIST.
			 */
			open val medigunFireResistPassive: ItemAttributeNamed<Float> = ItemAttributeNamed("medigun fire resist passive")
		}
	}
	
	open class TauntingAttributes {
		/**
		 * In-Game: "+N% faster taunt speed on wearer"
		 * 
		 * Multiplier applied to taunt speed.
		 */
		open val gestureSpeedIncrease: ItemAttributeNamed<Float> = ItemAttributeNamed("gesture speed increase")
	
		/**
		 * Sound to be played when performing a taunt.
		 */
		open val cosmeticTauntSound: ItemAttributeNamed<String> = ItemAttributeNamed("cosmetic taunt sound")
	}
	
	open class SwapWeaponsAttributes {
		open val disableWeaponSwitch: ItemAttributeNamed<Boolean> = ItemAttributeNamed("disable weapon switch")
	}
	
	open class WhenHitAttributes {
		/**
		 * Number of seconds the player who hit this entity should be marked for death.
		 * 
		 * If attacker is affected by `TF_COND_ENERGY_BUFF` (Crit-a-Cola, Cleaner's Carbine, Buffalo Steak, etc.), the attacker receives `TF_COND_MARKEDFORDEATH_SILENT`.
		 */
		open val markAttackerForDeath: ItemAttributeNamed<Float> = ItemAttributeNamed("mod_mark_attacker_for_death")
	
		/**
		 * In-Game: "When backstabbed: Jarate attacker"
		 * 
		 * If true, jarates anyone who backstabs this player.
		 * 
		 * Note: does not block backstabs on its own.
		 */
		open val jarateBackstabber: ItemAttributeNamed<Boolean> = ItemAttributeNamed("jarate backstabber")
	}
	
	open class HeavyOnlyAttributes {
		open val generateRageOnDamage: GenerateRageOnDamageAttributes = GenerateRageOnDamageAttributes()
	
		open class GenerateRageOnDamageAttributes {
			/**
			 * In-Game: "Generate Rage by dealing damage.  When fully charged, press the Special-Attack key to activate knockback"
			 * 
			 * Only procs on Heavies, multiplies damage by 50% while rage is draining.
			 */
			open val generateRageOnDamage: ItemAttributeNamed<Boolean> = ItemAttributeNamed("generate rage on damage")
	
			/**
			 * In-Game: "Generate building rescue energy on damage"
			 * 
			 * Only procs on Heavies, multiplies damage by 50% while rage is draining.
			 */
			open val engineerRageOnDmg: ItemAttributeNamed<Boolean> = ItemAttributeNamed("engineer rage on dmg")
		}
	}
	
	open class SniperOnlyAttributes {
		/**
		 * In-Game: "Knockback reduced by N% when aiming"
		 */
		open val aimingKnockbackResistance: ItemAttributeNamed<Float> = ItemAttributeNamed("aiming knockback resistance")
	
		/**
		 * In-Game: "Gain Focus on kills and assists"
		 * 
		 * Amount of sniper rage gained on kill.
		 */
		open val rageOnKill: ItemAttributeNamed<Float> = ItemAttributeNamed("rage on kill")
	}
	
	open class MedicOnlyAttributes {
		/**
		 * In-Game: "+25% heal rate for patient, +25% faster revive rate, and +25% self heal rate, per point"
		 * 
		 * Each level gives +25% of the Medic's passive regen.
		 */
		open val healingMastery: ItemAttributeNamed<Int> = ItemAttributeNamed("healing mastery")
	
		/**
		 * In-Game: "Build energy by healing teammates.  When fully charged, press the Special-Attack key to deploy a frontal projectile shield."
		 * 
		 * Gain shield meter from damage healed.
		 */
		open val generateRageOnHeal: ItemAttributeNamed<Boolean> = ItemAttributeNamed("generate rage on heal")
	
		/**
		 * This part is only semi-implemented...
		 * 
		 * Gives extra player movespeed the more heads you have.
		 * 
		 * Will not work if the player is not a Medic wielding the VitaSaw.
		 */
		open val addHeadOnHit: ItemAttributeNamed<Boolean> = ItemAttributeNamed("add head on hit")
	}
	
	open class SpyOnlyAttributes {
		/**
		 * In-Game: "+N% cloak on kill"
		 * 
		 * Amount of cloak gained on kill.
		 */
		open val addCloakOnKill: ItemAttributeNamed<Int> = ItemAttributeNamed("add cloak on kill")
	
		/**
		 * In-Game: "Extra effects when taunting."
		 * 
		 * Use Saharan Spy particle effect when performing a stock knife taunt.
		 */
		open val setBonusCustomTauntParticleAttr: ItemAttributeNamed<Boolean> = ItemAttributeNamed("SET BONUS: custom taunt particle attr")
	
		open val hasPipboyBuildInterface: ItemAttributeNamed<Int> = ItemAttributeNamed("has pipboy build interface")
	}
}