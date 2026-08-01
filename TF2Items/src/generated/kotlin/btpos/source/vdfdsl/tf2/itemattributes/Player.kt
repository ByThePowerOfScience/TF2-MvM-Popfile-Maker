package btpos.source.vdfdsl.tf2.itemattributes

import btpos.source.vdfdsl.modeling.*
import btpos.source.vdfdsl.serialization.codecs.*
import btpos.source.vdfdsl.tf2.itemattributes.impl.*
import btpos.source.vdfdsl.tf2.tftypes.*
import java.util.*
import kotlin.time.Duration

interface PlayerAttributes : BaseEntityAttributes {
	companion object : IBlockScoped {
		val ammo: AmmoAttributes = AmmoAttributes()
	
		val buffItems: BuffItemsAttributes = BuffItemsAttributes()
	
		val buildings: BuildingsAttributes = BuildingsAttributes()
	
		val cloak: CloakAttributes = CloakAttributes()
	
		val demoCharge: DemoChargeAttributes = DemoChargeAttributes()
	
		val firing: FiringAttributes = FiringAttributes()
	
		val heads: HeadsAttributes = HeadsAttributes()
	
		val healthAndHealing: HealthAndHealingAttributes = HealthAndHealingAttributes()
	
		val hud: HudAttributes = HudAttributes()
	
		val movement: MovementAttributes = MovementAttributes()
	
		val onHit: OnHitAttributes = OnHitAttributes()
	
		val onKill: OnKillAttributes = OnKillAttributes()
	
		val taunting: TauntingAttributes = TauntingAttributes()
	
		val swapWeapons: SwapWeaponsAttributes = SwapWeaponsAttributes()
	
		val whenHit: WhenHitAttributes = WhenHitAttributes()
	
		val spyOnly: SpyOnlyAttributes = SpyOnlyAttributes()
	
		private val disguise: DisguiseAttributes = DisguiseAttributes()
	
		private val crits: CritsAttributes = CritsAttributes()
	
		private val damage: DamageAttributes = DamageAttributes()
	
		private val meta: MetaAttributes = MetaAttributes()
	
		private val meter: MeterAttributes = MeterAttributes()
	
		private val knockbackReceived: KnockbackReceivedAttributes = KnockbackReceivedAttributes()
	
		private val resistance: ResistanceAttributes = ResistanceAttributes()
	
		val grenades1ResupplyDenied: ItemAttributeNamed<Boolean> = ItemAttributeNamed("grenades1_resupply_denied")
	
		val grenades2ResupplyDenied: ItemAttributeNamed<Boolean> = ItemAttributeNamed("grenades2_resupply_denied")
	
		val grenades3ResupplyDenied: ItemAttributeNamed<Boolean> = ItemAttributeNamed("grenades3_resupply_denied")
	
		/**
		 * In-Game: "+N% ammo regenerated every 5 seconds on wearer"
		 * 
		 * Percentage of ammo regenerated every 5 seconds.
		 */
		val ammoRegen: ItemAttributeNamed<Number> = ItemAttributeNamed("ammo regen")
	
		/**
		 * In-Game: "N% less metal from pickups and dispensers"
		 * 
		 * Multiplier applied to metal gained from ammo boxes.
		 */
		val metalPickupDecreased: ItemAttributeNamed<Number> = ItemAttributeNamed("metal_pickup_decreased")
	
		/**
		 * In-Game: "+N metal regenerated every 5 seconds on wearer"
		 * 
		 * Amount of metal regenerated every 5 seconds.
		 */
		val metalRegen: ItemAttributeNamed<Int> = ItemAttributeNamed("metal regen")
	
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
		val maxammoPrimaryReduced: BonusPenaltyHidden<Int, ItemAttributeNamed<Int>> = BonusPenaltyHidden(
			ItemAttributeNamed<Int>("maxammo primary increased"),
			ItemAttributeNamed<Int>("maxammo primary reduced"),
			ItemAttributeNamed<Int>("hidden primary max ammo bonus"),
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
		val maxammoSecondaryReduced: BonusPenaltyHidden<Int, ItemAttributeNamed<Int>> = BonusPenaltyHidden(
			ItemAttributeNamed<Int>("maxammo secondary increased"),
			ItemAttributeNamed<Int>("maxammo secondary reduced"),
			ItemAttributeNamed<Int>("hidden secondary max ammo penalty"),
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
		val maxammoMetalReduced: BonusPenalty<Int> = BonusPenalty(
			ItemAttributeNamed("maxammo metal increased"),
			ItemAttributeNamed("maxammo metal reduced"),
		)
	
		/**
		 * In-Game: "+N% max misc ammo on wearer"
		 * 
		 * Only used for bat balls.
		 */
		val maxammoGrenades1Increased: ItemAttributeNamed<Int> = ItemAttributeNamed("maxammo grenades1 increased")
	
		/**
		 * Note that Phlogistinator's rage has a small cooldown after expiring before it can gain rage again, to prevent the lingering crit flames from immediately filling it up again.
		 */
		val soldierBuffType: ItemAttributeNamed<Int> = ItemAttributeNamed("mod soldier buff type")
	
		/**
		 * Note that Phlogistinator's rage has a small cooldown after expiring before it can gain rage again, to prevent the lingering crit flames from immediately filling it up again.
		 */
		val demoBuffType: ItemAttributeNamed<Int> = ItemAttributeNamed("mod demo buff type")
	
		val buffDuration: VisHidden<Number> = VisHidden(ItemAttributeNamed<Number>("increase buff duration"), ItemAttributeNamed<Number>("increase buff duration HIDDEN"))
	
		/**
		 * In-Game: "+N% faster build speed"
		 * 
		 * Multiplies building build time by this amount.
		 */
		val buildRateBonus: ItemAttributeNamed<Number> = ItemAttributeNamed("build rate bonus")
	
		/**
		 * In-Game: "N% slower upgrade rate"
		 * 
		 * Add this amount of metal to any building hit by this player, using player's metal reserve.
		 * 
		 * Recall that all players have 100 hidden metal.
		 */
		val upgradeRateDecrease: ItemAttributeNamed<Int> = ItemAttributeNamed("upgrade rate decrease")
	
		/**
		 * In-Game: "+N% max building health"
		 * 
		 * Only applied if the building is NOT a disposable sentry.
		 */
		val engyBuildingHealthBonus: ItemAttributeNamed<Int> = ItemAttributeNamed("engy building health bonus")
	
		/**
		 * In-Game: "Cannot carry buildings"
		 * 
		 * Prevents player from picking up buildings.
		 */
		val cannotPickUpBuildings: ItemAttributeNamed<Boolean> = ItemAttributeNamed("cannot pick up buildings")
	
		/**
		 * In-Game: "N metal reduction in building cost"
		 * 
		 * Sets the cost to construct any building type to this value.
		 */
		val buildingCostReduction: ItemAttributeNamed<Int> = ItemAttributeNamed("building cost reduction")
	
		/**
		 * In-Game: "Sentry build speed increased by N%"
		 */
		val engineerSentryBuildRateMultiplier: ItemAttributeNamed<Number> = ItemAttributeNamed("engineer sentry build rate multiplier")
	
		/**
		 * In-Game: "+N% sentry range"
		 */
		val engySentryRadiusIncreased: ItemAttributeNamed<Number> = ItemAttributeNamed("engy sentry radius increased")
	
		/**
		 * In-Game: "+N% sentry firing speed"
		 */
		val engySentryFireRateIncreased: ItemAttributeNamed<Number> = ItemAttributeNamed("engy sentry fire rate increased")
	
		/**
		 * In-Game: "Build +N additional disposable-sentry"
		 * 
		 * Number of disposable sentries you're allowed to build.
		 * 
		 * Checked when checking if the player can build something.
		 * 
		 * Only works if the "uses upgrades" gamerule is set.
		 */
		val engyDisposableSentries: ItemAttributeNamed<Int> = ItemAttributeNamed("engy disposable sentries")
	
		/**
		 * In-Game: "+N% dispenser range"
		 */
		val engyDispenserRadiusIncreased: ItemAttributeNamed<Number> = ItemAttributeNamed("engy dispenser radius increased")
	
		/**
		 * In-Game: "Increases teleporter build speed by N%."
		 * 
		 * Multiplier applied to passive build time for dispensers and teleporters.
		 */
		val engineerTeleporterBuildRateMultiplier: ItemAttributeNamed<Number> = ItemAttributeNamed("engineer teleporter build rate multiplier")
	
		/**
		 * In-Game: "Teleporters can be used in both directions"
		 */
		val bidirectionalTeleport: ItemAttributeNamed<Boolean> = ItemAttributeNamed("bidirectional teleport")
	
		/**
		 * In-Game: "N% metal cost when constructing or upgrading teleporters"
		 * 
		 * Multiplier applied to teleporter construction cost.
		 */
		val teleporterCost: ItemAttributeNamed<Number> = ItemAttributeNamed("mod teleporter cost")
	
		/**
		 * In-Game: "N sec longer cloak blink time"
		 * 
		 * Multiplier.
		 */
		val setBonusCloakBlinkTimePenalty: ItemAttributeNamed<Number> = ItemAttributeNamed("SET BONUS: cloak blink time penalty")
	
		/**
		 * In-Game: "N sec increase in time to cloak"
		 */
		val multCloakRate: ItemAttributeNamed<Number> = ItemAttributeNamed("mult cloak rate")
	
		/**
		 * In-Game: "Reduced decloak sound volume"
		 * 
		 * If true, plays `Player.Spy_UnCloakReduced` when decloaking.
		 */
		val setBonusQuietUnstealth: ItemAttributeNamed<Boolean> = ItemAttributeNamed("SET BONUS: quiet unstealth")
	
		val multDecloakRate: ItemAttributeNamed<Number> = ItemAttributeNamed("mult decloak rate")
	
		/**
		 * In-Game: "Deals 3x falling damage to the player you land on"
		 * 
		 * Deal 3x falling damage to player you land on.
		 */
		val bootsFallingStomp: ItemAttributeNamed<Boolean> = ItemAttributeNamed("boots falling stomp")
	
		/**
		 * In-Game: "Headshots deal an extra +N% damage"
		 * 
		 * Multiplier applied to headshot damage.
		 */
		val headshotDamageIncrease: ItemAttributeNamed<Number> = ItemAttributeNamed("headshot damage increase")
	
		/**
		 * In-Game: "Increased Melee damage against Isolated Merc Set"
		 * 
		 * Deal extra damage to players wearing the Alien set.
		 */
		val setBonusAlienIsolationXenoBonusPos: ItemAttributeNamed<Boolean> = ItemAttributeNamed("SET BONUS: alien isolation xeno bonus pos")
	
		/**
		 * In-Game: "Increased Nostromo Napalmer damage against Isolationist Pack Set"
		 * 
		 * Deal extra damage to players wearing the Xenomorph set.
		 */
		val setBonusAlienIsolationMercBonusPos: ItemAttributeNamed<Boolean> = ItemAttributeNamed("SET BONUS: alien isolation merc bonus pos")
	
		/**
		 * In-Game: "Taking damage while shield charging reduces remaining charging time"
		 * 
		 * Used to detect the Tide Turner when deciding whether to give you minicrits or crits.
		 */
		val loseDemoChargeOnDamageWhenCharging: ItemAttributeNamed<Boolean> = ItemAttributeNamed("lose demo charge on damage when charging")
	
		/**
		 * In-Game: "Melee kills refill N% of your charge meter."
		 * 
		 * Amount of targe-charge meter gained on kill.  Scaled by various values.
		 */
		val killRefillsMeter: ItemAttributeNamed<Number> = ItemAttributeNamed("kill refills meter")
	
		val chargeTime: VisHidden<Number> = VisHidden(ItemAttributeNamed<Number>("charge time increased"), ItemAttributeNamed<Number>("charge time decreased"))
	
		/**
		 * In-Game: "+N% increase in charge recharge rate"
		 * 
		 * Only applies to Demoman.
		 */
		val chargeRechargeRateIncreased: ItemAttributeNamed<Number> = ItemAttributeNamed("charge recharge rate increased")
	
		/**
		 * In-Game: "+N% increase in turning control while charging"
		 * 
		 * Default is 0.45f, and this is a multiplier applied to it.
		 */
		val multChargeTurnControl: ItemAttributeNamed<Number> = ItemAttributeNamed("mult charge turn control")
	
		/**
		 * In-Game: "Full turning control while charging"
		 * 
		 * Default is 0.45f, and this is a multiplier applied to it.
		 */
		val fullChargeTurnControl: ItemAttributeNamed<Number> = ItemAttributeNamed("full charge turn control")
	
		/**
		 * In-Game: "Immune to fire damage while disguised"
		 * 
		 * Prevent afterburn while disguised.
		 */
		val disguiseNoBurn: ItemAttributeNamed<Boolean> = ItemAttributeNamed("disguise no burn")
	
		/**
		 * In-Game: "Wearer cannot disguise"
		 */
		val cannotDisguise: ItemAttributeNamed<Boolean> = ItemAttributeNamed("cannot disguise")
	
		/**
		 * Prevents player from attacking.
		 */
		val noAttack: ItemAttributeNamed<Boolean> = ItemAttributeNamed("no_attack")
	
		/**
		 * This attribute only works on players that are a Medic wielding the Vitasaw. For the all-class version, see `extra_damage_on_hit` (unimplemented in vanilla, accessible via Rafmod).
		 * 
		 * Gives extra player movespeed the more heads you have. (Partially implemented.).
		 * 
		 * Will not work if the player is not a Medic wielding the VitaSaw.
		 */
		val addHeadOnHit: ItemAttributeNamed<Boolean> = ItemAttributeNamed("add head on hit")
	
		/**
		 * In-Game: "+25% heal rate for patient, +25% faster revive rate, and +25% self heal rate, per point"
		 * 
		 * On Medic only, each level raises the Medic's passive regen by 25% of its normal value.
		 */
		val healingMastery: ItemAttributeNamed<Int> = ItemAttributeNamed("healing mastery")
	
		/**
		 * Bonus:
		 * 
		 * 	- In-Game: "+N% health from packs on wearer"
		 * 
		 * Penalty:
		 * 
		 * 	- In-Game: "N% health from packs on wearer"
		 */
		val healthFromPacks: BonusPenalty<Number> = BonusPenalty(
			ItemAttributeNamed("health from packs increased"),
			ItemAttributeNamed("health from packs decreased"),
		)
	
		/**
		 * In-Game: "N% less healing from Medic sources"
		 * 
		 * Specifically checked on Crossbow Bolt impacts.
		 */
		val reducedHealingFromMedics: ItemAttributeNamed<Number> = ItemAttributeNamed("reduced_healing_from_medics")
	
		/**
		 * Bonus:
		 * 
		 * 	- In-Game: "+N% health from healers on wearer"
		 * 
		 * Penalty:
		 * 
		 * 	- In-Game: "N% health from healers on wearer"
		 */
		val healthFromHealersReduced: BonusPenalty<Number> = BonusPenalty(
			ItemAttributeNamed("health from healers increased"),
			ItemAttributeNamed("health from healers reduced"),
		)
	
		/**
		 * In-Game: "Blocks healing while in use"
		 * 
		 * If set, this player may not be targeted by heal-beams or healed from Crossbow impacts.
		 */
		val weaponBlocksHealing: ItemAttributeNamed<Boolean> = ItemAttributeNamed("mod weapon blocks healing")
	
		/**
		 * In-Game: "+N max health on wearer"
		 * 
		 * Additive maximum health increase. See also: [addMaxHealth].
		 */
		val hiddenMaxhealthNonBuffed: ItemAttributeNamed<Int> = ItemAttributeNamed("hidden maxhealth non buffed")
	
		/**
		 * In-Game: "+N health regenerated per second on wearer"
		 * 
		 * Amount of health regenerated per regen tick.  Scales by the amount of time since the player last took damage in non-MvM modes.
		 */
		val healthRegen: ItemAttributeNamed<Number> = ItemAttributeNamed("health regen")
	
		/**
		 * In-Game: "N health drained per second on wearer"
		 * 
		 * Amount of health regenerated per regen tick.  Scales by the amount of time since the player last took damage in non-MvM modes.
		 */
		val healthDrain: ItemAttributeNamed<Number> = ItemAttributeNamed("health drain")
	
		/**
		 * In-Game: "+N health regenerated per second on wearer"
		 * 
		 * Amount of health regenerated per regen tick.  Scales by the amount of time since the player last took damage in non-MvM modes.
		 */
		val setBonusHealthRegenSetBonus: ItemAttributeNamed<Number> = ItemAttributeNamed("SET BONUS: health regen set bonus")
	
		/**
		 * In-Game: "N health regenerated per second on wearer"
		 * 
		 * Amount of health regenerated per regen tick.  Scales by the amount of time since the player last took damage in non-MvM modes.
		 */
		val healthDrainMedic: ItemAttributeNamed<Number> = ItemAttributeNamed("health drain medic")
	
		/**
		 * In-Game: "+N health regenerated per second on wearer"
		 * 
		 * Amount of health regenerated per regen tick.  Scales by the amount of time since the player last took damage in non-MvM modes.
		 */
		val cardHealthRegen: ItemAttributeNamed<Number> = ItemAttributeNamed("CARD: health regen")
	
		/**
		 * In-Game: "+N max health on wearer"
		 * 
		 * Additive maximum health increase only checked when overhealing.
		 */
		val maxHealthAdditiveBonus: ItemAttributeNamed<Int> = ItemAttributeNamed("max health additive bonus")
	
		/**
		 * In-Game: "N max health on wearer"
		 * 
		 * Additive maximum health increase only checked when overhealing.
		 */
		val maxHealthAdditivePenalty: ItemAttributeNamed<Int> = ItemAttributeNamed("max health additive penalty")
	
		/**
		 * In-Game: "+N max health on wearer"
		 * 
		 * Additive maximum health increase only checked when overhealing.
		 */
		val setBonusMaxHealthAdditiveBonus: ItemAttributeNamed<Int> = ItemAttributeNamed("SET BONUS: max health additive bonus")
	
		/**
		 * Only used if the build menu is actually shown.
		 * 
		 * 0 = default.
		 * 
		 * 1 = pipboy.
		 * 
		 * Works on Engineer and Spy (if you can give him a build menu).
		 */
		val hasPipboyBuildInterface: ItemAttributeNamed<Int> = ItemAttributeNamed("has pipboy build interface")
	
		/**
		 * In-Game: "Allows you to see enemy health"
		 */
		val seeEnemyHealth: ItemAttributeNamed<Boolean> = ItemAttributeNamed("mod see enemy health")
	
		/**
		 * In-Game: "Unable to see enemy health"
		 * 
		 * Always true in MvM.
		 */
		val hideEnemyHealth: ItemAttributeNamed<Boolean> = ItemAttributeNamed("hide enemy health")
	
		val airblastVulnerabilityMultiplier: VisHidden<Number> = VisHidden(ItemAttributeNamed<Number>("airblast vulnerability multiplier"), ItemAttributeNamed<Number>("airblast vulnerability multiplier hidden"))
	
		val airblastVerticalVulnerabilityMultiplier: ItemAttributeNamed<Number> = ItemAttributeNamed("airblast vertical vulnerability multiplier")
	
		/**
		 * In-Game: "Knockback reduced by N% when aiming"
		 * 
		 * Only works on Sniper.
		 */
		val aimingKnockbackResistance: ItemAttributeNamed<Number> = ItemAttributeNamed("aiming knockback resistance")
	
		/**
		 * If 1, create a soccer ball on the ground when the player spawns.
		 */
		val spawnWithPhysicsToy: ItemAttributeNamed<Int> = ItemAttributeNamed("spawn with physics toy")
	
		/**
		 * In-Game: "Leave a Calling Card on your victims."
		 * 
		 * Defines the calling card that should be dropped when this player kills another player.
		 */
		val setBonusCallingCardOnKill: ItemAttributeNamed<Int> = ItemAttributeNamed("SET BONUS: calling card on kill")
	
		/**
		 * If the weapon is a Holy Mackerel reskin (AKA either the fish or the Unarmed Combat) and this is set, use the Unarmed Combat "arm hit" killfeed notice instead of the "fish hit" notice.
		 */
		val fishDamageOverride: ItemAttributeNamed<Boolean> = ItemAttributeNamed("fish damage override")
	
		/**
		 * In-Game: "Noise Maker"
		 * 
		 * Uses noise maker when pressing action slot key.
		 */
		val noiseMaker: ItemAttributeNamed<Boolean> = ItemAttributeNamed("noise maker")
	
		val unlimitedQuantity: VisHidden<Boolean> = VisHidden(ItemAttributeNamed<Boolean>("unlimited quantity"), ItemAttributeNamed<Boolean>("unlimited quantity hidden"))
	
		/**
		 * In-Game: "Killstreaks Active"
		 */
		val killstreakTier: ItemAttributeNamed<Int> = ItemAttributeNamed("killstreak tier")
	
		/**
		 * In-Game: "Jingle all the way"
		 * 
		 * If 1, use xmas.jingle, if 2 or higher use xmas.jingle_higher.
		 */
		val addJingleToFootsteps: ItemAttributeNamed<Int> = ItemAttributeNamed("add jingle to footsteps")
	
		/**
		 * In-Game: "N"
		 * 
		 * Decimal version of the 4-byte hex code determining color of footsteps (e.g. `0xFFFFFFFF`, but in decimal).
		 */
		val spellSetHalloweenFootstepType: ItemAttributeNamed<Int> = ItemAttributeNamed("SPELL: set Halloween footstep type")
	
		val overrideFootstepSoundSet: ItemAttributeNamed<FootstepOverride> = ItemAttributeNamed("override footstep sound set")
	
		/**
		 * In-Game: "Explode spectacularly on death"
		 */
		val bombinomiconEffectOnDeath: ItemAttributeNamed<Boolean> = ItemAttributeNamed("bombinomicon effect on death")
	
		/**
		 * If true, the Voodoo-Cursed Soul skin is equipped.
		 */
		val zombiezombiezombiezombie: ItemAttributeNamed<Boolean> = ItemAttributeNamed("zombiezombiezombiezombie")
	
		/**
		 * In-Game: "Disables double jump"
		 */
		val headScale: ItemAttributeNamed<Number> = ItemAttributeNamed("head scale")
	
		val torsoScale: ItemAttributeNamed<Number> = ItemAttributeNamed("torso scale")
	
		val handScale: ItemAttributeNamed<Number> = ItemAttributeNamed("hand scale")
	
		/**
		 * DSP used when emitting sounds created by this player.
		 */
		val setBonusSpecialDsp: ItemAttributeNamed<Int> = ItemAttributeNamed("SET BONUS: special dsp")
	
		/**
		 * In-Game: "+N capture rate on wearer"
		 */
		val increasePlayerCaptureValue: ItemAttributeNamed<Int> = ItemAttributeNamed("increase player capture value")
	
		/**
		 * In-Game: "Share Canteens with your heal target. +1 duration, -10 price per point (minimum cost: 5)"
		 * 
		 * Discounts canteens by 10 * level.
		 */
		val canteenSpecialist: ItemAttributeNamed<Int> = ItemAttributeNamed("canteen specialist")
	
		/**
		 * In-Game: "Wearer cannot carry the intelligence briefcase or PASS Time JACK"
		 */
		val cannotPickUpIntelligence: ItemAttributeNamed<Boolean> = ItemAttributeNamed("cannot pick up intelligence")
	
		val useHeadOrigin: ItemAttributeNamed<Boolean> = ItemAttributeNamed("particle effect use head origin")
	
		val verticalOffset: ItemAttributeNamed<Number> = ItemAttributeNamed("particle effect vertical offset")
	
		/**
		 * In-Game: "Build energy by healing teammates.  When fully charged, press the Special-Attack key to deploy a frontal projectile shield."
		 * 
		 * Gain shield meter from damage healed. Only works on Medic.
		 */
		val generateRageOnHeal: ItemAttributeNamed<Boolean> = ItemAttributeNamed("generate rage on heal")
	
		/**
		 * In-Game: "Gain Focus on kills and assists"
		 * 
		 * Amount of Sniper rage gained on kill.  Only works on Sniper.
		 */
		val rageOnKill: ItemAttributeNamed<Number> = ItemAttributeNamed("rage on kill")
	
		/**
		 * In-Game: "Boost reduced on air jumps"
		 * 
		 * Lose this amount of hype if you airdash.
		 * 
		 * Note that this only applies to scout hype, not rage in general.
		 */
		val hypeResetsOnJump: ItemAttributeNamed<Int> = ItemAttributeNamed("hype resets on jump")
	
		/**
		 * Multiplier applied to rage gained by dealing damage, taking damage, or dealing burn damage.
		 */
		val rageGivingScale: ItemAttributeNamed<Number> = ItemAttributeNamed("rage giving scale")
	
		/**
		 * In-Game: "On Hit: Builds Hype"
		 * 
		 * Adds the amount of damage dealt to the Scout hype meter, to a maximum of 200 damage which adds 50% meter.
		 */
		val hypeOnDamage: ItemAttributeNamed<Boolean> = ItemAttributeNamed("hype on damage")
	
		/**
		 * Only procs on Sniper. Gain this amount of rage meter on assists.
		 */
		val rageOnAssists: ItemAttributeNamed<Number> = ItemAttributeNamed("rage on assists")
	
		/**
		 * In-Game: "Hype Decays Over Time."
		 * 
		 * How much the Scout's hype meter decays every tick.
		 */
		val hypeDecaysOverTime: ItemAttributeNamed<Number> = ItemAttributeNamed("hype decays over time")
	
		/**
		 * In-Game: "Boost reduced when hit"
		 * 
		 * Amount of hype lost per point of damage taken.
		 */
		val loseHypeOnTakeDamage: ItemAttributeNamed<Int> = ItemAttributeNamed("lose hype on take damage")
	
		/**
		 * In-Game: "Generate Rage by dealing damage.  When fully charged, press the Special-Attack key to activate knockback"
		 * 
		 * Only works on Engineer and Heavy.
		 * 
		 * On Engineer, adds all damage dealt to the rage meter.
		 * 
		 * On Heavy, adds `0.22` * the damage to the meter, and reduces damage by 50% while the meter is draining.
		 */
		val generateRageOnDamage: ItemAttributeNamed<Boolean> = ItemAttributeNamed("generate rage on damage")
	
		/**
		 * In-Game: "Generate building rescue energy on damage"
		 * 
		 * Only works on Engineer and Heavy.
		 * 
		 * On Engineer, adds all damage dealt to the rage meter.
		 * 
		 * On Heavy, adds `0.22` * the damage to the meter, and reduces damage by 50% while the meter is draining.
		 */
		val engineerRageOnDmg: ItemAttributeNamed<Boolean> = ItemAttributeNamed("engineer rage on dmg")
	
		/**
		 * Allows parachute to be deployed. Parachute prop only appears if the BASE Jumper is equipped, but the functionality is the same regardless.
		 */
		val parachuteAttribute: ItemAttributeNamed<Boolean> = ItemAttributeNamed("parachute attribute")
	
		/**
		 * In-Game: "N% increased air control."
		 * 
		 * Note: the jetpack condition always multiplies your air acceleration by 50%.
		 */
		val increasedAirControl: ItemAttributeNamed<Number> = ItemAttributeNamed("increased air control")
	
		/**
		 * In-Game: "N% increased air control when blast jumping."
		 * 
		 * Specifically while blast-jumping, as opposed to global.
		 */
		val airControlBlastJump: ItemAttributeNamed<Number> = ItemAttributeNamed("mod_air_control_blast_jump")
	
		/**
		 * Prevents player from jumping.
		 */
		val noJump: ItemAttributeNamed<Boolean> = ItemAttributeNamed("no_jump")
	
		/**
		 * Prevents player from crouching.
		 */
		val noDuck: ItemAttributeNamed<Boolean> = ItemAttributeNamed("no_duck")
	
		/**
		 * In-Game: "Disables double jump"
		 */
		val noDoubleJump: ItemAttributeNamed<Boolean> = ItemAttributeNamed("no double jump")
	
		/**
		 * In-Game: "+N% greater jump height when active"
		 */
		val increasedJumpHeight: ItemAttributeNamed<Number> = ItemAttributeNamed("increased jump height")
	
		val majorIncreasedJumpHeight: ItemAttributeNamed<Number> = ItemAttributeNamed("major increased jump height")
	
		val halloweenIncreasedJumpHeight: ItemAttributeNamed<Number> = ItemAttributeNamed("halloween increased jump height")
	
		/**
		 * In-Game: "+N% faster move speed on wearer (shield required)"
		 */
		val moveSpeedBonusShieldRequired: ItemAttributeNamed<Number> = ItemAttributeNamed("move speed bonus shield required")
	
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
		val aimingMovespeedIncreased: ItemAttributeNamed<Number> = ItemAttributeNamed("aiming movespeed increased")
	
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
		val aimingMovespeedDecreased: ItemAttributeNamed<Number> = ItemAttributeNamed("aiming movespeed decreased")
	
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
		val sniperAimingMovespeedDecreased: ItemAttributeNamed<Number> = ItemAttributeNamed("sniper aiming movespeed decreased")
	
		/**
		 * In-Game: "N% slower move speed on wearer"
		 */
		val moveSpeedPenalty: ItemAttributeNamed<Number> = ItemAttributeNamed("move speed penalty")
	
		/**
		 * In-Game: "+N% faster move speed on wearer"
		 */
		val moveSpeedBonus: ItemAttributeNamed<Number> = ItemAttributeNamed("move speed bonus")
	
		val majorMoveSpeedBonus: ItemAttributeNamed<Number> = ItemAttributeNamed("major move speed bonus")
	
		/**
		 * In-Game: "+N% faster move speed on wearer"
		 */
		val setBonusMoveSpeedSetBonus: ItemAttributeNamed<Number> = ItemAttributeNamed("SET BONUS: move speed set bonus")
	
		/**
		 * In-Game: "+N% faster move speed on wearer"
		 */
		val cardMoveSpeedBonus: ItemAttributeNamed<Number> = ItemAttributeNamed("CARD: move speed bonus")
	
		/**
		 * In-Game: "Push enemies back when you land (force and radius based on velocity)"
		 * 
		 * Requires player to have the `TF_COND_ROCKETPACK` condition.
		 * 
		 * Pushes back nearby players around the landing site.
		 */
		val fallingImpactRadiusPushback: ItemAttributeNamed<Boolean> = ItemAttributeNamed("falling_impact_radius_pushback")
	
		/**
		 * In-Game: "Stun enemies when you land"
		 * 
		 * If `falling_impact_radius_pushback` is set, this will also stun any enemies in the impact radius.
		 */
		val fallingImpactRadiusStun: ItemAttributeNamed<Boolean> = ItemAttributeNamed("falling_impact_radius_stun")
	
		/**
		 * In-Game: "On Kill: A small health pack is dropped"
		 * 
		 * Drop a small health pack when killing an enemy.
		 */
		val dropHealthPackOnKill: ItemAttributeNamed<Boolean> = ItemAttributeNamed("drop health pack on kill")
	
		/**
		 * In-Game: "On Kill: Burst into joyous laughter"
		 * 
		 * On killing an enemy, schadenfreude.
		 */
		val killForcesAttackerToLaugh: ItemAttributeNamed<Boolean> = ItemAttributeNamed("kill forces attacker to laugh")
	
		/**
		 * In-Game: "N% damage penalty"
		 * 
		 * More like a boolean.  Doesn't actually determine any kind of decapitation, just if it CAN decapitate.
		 * 
		 * Checked on all hitscan attacks, including melee swings.
		 */
		val decapitateType: ItemAttributeNamed<Int> = ItemAttributeNamed("decapitate type")
	
		/**
		 * In-Game: "+N% cloak on kill"
		 * 
		 * Value: amount of cloak gained on kill.
		 * 
		 * Only works on Spy.
		 */
		val addCloakOnKill: ItemAttributeNamed<Int> = ItemAttributeNamed("add cloak on kill")
	
		/**
		 * Bonus:
		 * 
		 * 	- In-Game: "+N% explosive damage resistance on wearer"
		 * 
		 * Penalty:
		 * 
		 * 	- In-Game: "N% explosive damage vulnerability on wearer"
		 */
		val dmgTakenFromBlast: BonusPenalty<Number> = BonusPenalty(
			ItemAttributeNamed("dmg taken from blast reduced"),
			ItemAttributeNamed("dmg taken from blast increased"),
		)
	
		/**
		 * In-Game: "N% damage vulnerability on wearer"
		 * 
		 * Multiplier to damage taken from all sources.
		 */
		val dmgTakenIncreased: ItemAttributeNamed<Number> = ItemAttributeNamed("dmg taken increased")
	
		/**
		 * In-Game: "+N% sentry damage resistance on wearer"
		 */
		val setBonusDmgFromSentryReduced: ItemAttributeNamed<Number> = ItemAttributeNamed("SET BONUS: dmg from sentry reduced")
	
		val rocketJumpDamageReduction: VisHidden<Number> = VisHidden(ItemAttributeNamed<Number>("rocket jump damage reduction"), ItemAttributeNamed<Number>("rocket jump damage reduction HIDDEN"))
	
		/**
		 * In-Game: "Wearer never takes falling damage"
		 */
		val cancelFallingDamage: ItemAttributeNamed<Boolean> = ItemAttributeNamed("cancel falling damage")
	
		/**
		 * In-Game: "N% damage resistance when below 50% health and spun up"
		 * 
		 * Only procs on Heavies that are currently spun up on less than 50% HP.
		 */
		val spunupDamageResistance: ItemAttributeNamed<Number> = ItemAttributeNamed("spunup_damage_resistance")
	
		/**
		 * In-Game: "+N% critical hit damage resistance on wearer"
		 */
		val dmgTakenFromCritReduced: ItemAttributeNamed<Number> = ItemAttributeNamed("dmg taken from crit reduced")
	
		/**
		 * In-Game: "N% critical hit damage vulnerability on wearer"
		 */
		val dmgTakenFromCritIncreased: ItemAttributeNamed<Number> = ItemAttributeNamed("dmg taken from crit increased")
	
		/**
		 * In-Game: "+N% critical hit damage resistance on wearer"
		 */
		val setBonusDmgTakenFromCritReducedSetBonus: ItemAttributeNamed<Number> = ItemAttributeNamed("SET BONUS: dmg taken from crit reduced set bonus")
	
		/**
		 * In-Game: "+N% fire damage resistance on wearer"
		 */
		val dmgTakenFromFireReduced: ItemAttributeNamed<Number> = ItemAttributeNamed("dmg taken from fire reduced")
	
		/**
		 * In-Game: "N% fire damage vulnerability on wearer"
		 */
		val dmgTakenFromFireIncreased: ItemAttributeNamed<Number> = ItemAttributeNamed("dmg taken from fire increased")
	
		/**
		 * In-Game: "+N% fire damage resistance on wearer"
		 */
		val setBonusDmgTakenFromFireReducedSetBonus: ItemAttributeNamed<Number> = ItemAttributeNamed("SET BONUS: dmg taken from fire reduced set bonus")
	
		/**
		 * In-Game: "+N% bullet damage resistance on wearer"
		 */
		val dmgTakenFromBulletsReduced: ItemAttributeNamed<Number> = ItemAttributeNamed("dmg taken from bullets reduced")
	
		/**
		 * In-Game: "N% bullet damage vulnerability on wearer"
		 */
		val dmgTakenFromBulletsIncreased: ItemAttributeNamed<Number> = ItemAttributeNamed("dmg taken from bullets increased")
	
		/**
		 * In-Game: "N% bullet damage vulnerability on wearer"
		 */
		val setBonusDmgTakenFromBulletsIncreased: ItemAttributeNamed<Number> = ItemAttributeNamed("SET BONUS: dmg taken from bullets increased")
	
		/**
		 * In-Game: "+N% bullet damage resistance on wearer"
		 */
		val cardDmgTakenFromBulletsReduced: ItemAttributeNamed<Number> = ItemAttributeNamed("CARD: dmg taken from bullets reduced")
	
		/**
		 * Multiplier to damage taken if player has TF_COND_MEDIGUN_UBER_BULLET_RESIST.
		 */
		val medigunBulletResistDeployed: ItemAttributeNamed<Number> = ItemAttributeNamed("medigun bullet resist deployed")
	
		/**
		 * Multiplier to damage taken if player has TF_COND_MEDIGUN_SMALL_BULLET_RESIST.
		 */
		val medigunBulletResistPassive: ItemAttributeNamed<Number> = ItemAttributeNamed("medigun bullet resist passive")
	
		/**
		 * Multiplier to damage taken if player has TF_COND_MEDIGUN_UBER_BLAST_RESIST.
		 */
		val medigunBlastResistDeployed: ItemAttributeNamed<Number> = ItemAttributeNamed("medigun blast resist deployed")
	
		/**
		 * Multiplier to damage taken if player has TF_COND_MEDIGUN_SMALL_BLAST_RESIST.
		 */
		val medigunBlastResistPassive: ItemAttributeNamed<Number> = ItemAttributeNamed("medigun blast resist passive")
	
		/**
		 * Multiplier to damage taken if player has TF_COND_MEDIGUN_UBER_FIRE_RESIST.
		 */
		val medigunFireResistDeployed: ItemAttributeNamed<Number> = ItemAttributeNamed("medigun fire resist deployed")
	
		/**
		 * Multiplier to damage taken if player has TF_COND_MEDIGUN_SMALL_FIRE_RESIST.
		 */
		val medigunFireResistPassive: ItemAttributeNamed<Number> = ItemAttributeNamed("medigun fire resist passive")
	
		/**
		 * In-Game: "+N% faster taunt speed on wearer"
		 * 
		 * Multiplier applied to taunt speed.
		 */
		val gestureSpeedIncrease: ItemAttributeNamed<Number> = ItemAttributeNamed("gesture speed increase")
	
		/**
		 * Sound to be played when performing a taunt.
		 */
		val cosmeticTauntSound: ItemAttributeNamed<String> = ItemAttributeNamed("cosmetic taunt sound")
	
		/**
		 * In-Game: "Extra effects when taunting."
		 * 
		 * Use Saharan Spy particle effect when performing a stock knife taunt.  Only works on Spy.
		 */
		val setBonusCustomTauntParticleAttr: ItemAttributeNamed<Boolean> = ItemAttributeNamed("SET BONUS: custom taunt particle attr")
	
		val disableWeaponSwitch: ItemAttributeNamed<Boolean> = ItemAttributeNamed("disable weapon switch")
	
		/**
		 * Number of seconds the player who hit this entity should be marked for death.
		 * 
		 * If attacker is affected by `TF_COND_ENERGY_BUFF` (Crit-a-Cola, Cleaner's Carbine, Buffalo Steak, etc.), the attacker receives `TF_COND_MARKEDFORDEATH_SILENT`.
		 */
		val markAttackerForDeath: ItemAttributeNamed<Number> = ItemAttributeNamed("mod_mark_attacker_for_death")
	
		/**
		 * In-Game: "When backstabbed: Jarate attacker"
		 * 
		 * If true, jarates anyone who backstabs this player.
		 * 
		 * Note: does not block backstabs on its own.
		 */
		val jarateBackstabber: ItemAttributeNamed<Boolean> = ItemAttributeNamed("jarate backstabber")
	}

	val ammo: AmmoAttributes get() = PlayerAttributes.ammo
	
	val buffItems: BuffItemsAttributes get() = PlayerAttributes.buffItems
	
	val buildings: BuildingsAttributes get() = PlayerAttributes.buildings
	
	val cloak: CloakAttributes get() = PlayerAttributes.cloak
	
	override val damage: DamageAttributes get() = PlayerAttributes.damage
	
	val demoCharge: DemoChargeAttributes get() = PlayerAttributes.demoCharge
	
	override val disguise: DisguiseAttributes get() = PlayerAttributes.disguise
	
	val firing: FiringAttributes get() = PlayerAttributes.firing
	
	val heads: HeadsAttributes get() = PlayerAttributes.heads
	
	val healthAndHealing: HealthAndHealingAttributes get() = PlayerAttributes.healthAndHealing
	
	val hud: HudAttributes get() = PlayerAttributes.hud
	
	override val knockbackReceived: KnockbackReceivedAttributes get() = PlayerAttributes.knockbackReceived
	
	override val meta: MetaAttributes get() = PlayerAttributes.meta
	
	override val meter: MeterAttributes get() = PlayerAttributes.meter
	
	val movement: MovementAttributes get() = PlayerAttributes.movement
	
	val onHit: OnHitAttributes get() = PlayerAttributes.onHit
	
	val onKill: OnKillAttributes get() = PlayerAttributes.onKill
	
	override val resistance: ResistanceAttributes get() = PlayerAttributes.resistance
	
	val taunting: TauntingAttributes get() = PlayerAttributes.taunting
	
	val swapWeapons: SwapWeaponsAttributes get() = PlayerAttributes.swapWeapons
	
	val whenHit: WhenHitAttributes get() = PlayerAttributes.whenHit
	
	val spyOnly: SpyOnlyAttributes get() = PlayerAttributes.spyOnly
	
	override val crits: CritsAttributes get() = PlayerAttributes.crits

	open class AmmoAttributes : IBlockScoped {
		companion object : IBlockScoped {
			val maxAmmo: MaxAmmoAttributes = MaxAmmoAttributes()
		}
	
		context(attrs: IAttributeContainer)
		open var grenades1ResupplyDenied: Boolean? 
			get() = PlayerAttributes.grenades1ResupplyDenied.get()
			set(value) { PlayerAttributes.grenades1ResupplyDenied.set(value) }
	
		context(attrs: IAttributeContainer)
		open var grenades2ResupplyDenied: Boolean? 
			get() = PlayerAttributes.grenades2ResupplyDenied.get()
			set(value) { PlayerAttributes.grenades2ResupplyDenied.set(value) }
	
		context(attrs: IAttributeContainer)
		open var grenades3ResupplyDenied: Boolean? 
			get() = PlayerAttributes.grenades3ResupplyDenied.get()
			set(value) { PlayerAttributes.grenades3ResupplyDenied.set(value) }
	
		/**
		 * In-Game: "+N% ammo regenerated every 5 seconds on wearer"
		 * 
		 * Percentage of ammo regenerated every 5 seconds.
		 */
		context(attrs: IAttributeContainer)
		open var ammoRegen: Number? 
			get() = PlayerAttributes.ammoRegen.get()
			set(value) { PlayerAttributes.ammoRegen.set(value) }
	
		/**
		 * In-Game: "N% less metal from pickups and dispensers"
		 * 
		 * Multiplier applied to metal gained from ammo boxes.
		 */
		context(attrs: IAttributeContainer)
		open var metalPickupDecreased: Number? 
			get() = PlayerAttributes.metalPickupDecreased.get()
			set(value) { PlayerAttributes.metalPickupDecreased.set(value) }
	
		/**
		 * In-Game: "+N metal regenerated every 5 seconds on wearer"
		 * 
		 * Amount of metal regenerated every 5 seconds.
		 */
		context(attrs: IAttributeContainer)
		open var metalRegen: Int? 
			get() = PlayerAttributes.metalRegen.get()
			set(value) { PlayerAttributes.metalRegen.set(value) }
	
		open val maxAmmo: MaxAmmoAttributes = MaxAmmoAttributes()
	
		open class MaxAmmoAttributes : IBlockScoped {
			companion object : IBlockScoped 
	
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
			context(attrs: IAttributeContainer)
			open var maxammoPrimaryReduced: Int? 
				get() = PlayerAttributes.maxammoPrimaryReduced.get()
				set(value) { PlayerAttributes.maxammoPrimaryReduced.set(value) }
	
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
			context(attrs: IAttributeContainer)
			open var maxammoSecondaryReduced: Int? 
				get() = PlayerAttributes.maxammoSecondaryReduced.get()
				set(value) { PlayerAttributes.maxammoSecondaryReduced.set(value) }
	
			/**
			 * Bonus:
			 * 
			 * 	- In-Game: "+N% max metal on wearer"
			 * 
			 * Penalty:
			 * 
			 * 	- In-Game: "N% max metal on wearer"
			 */
			context(attrs: IAttributeContainer)
			open var maxammoMetalReduced: Int? 
				get() = PlayerAttributes.maxammoMetalReduced.get()
				set(value) { PlayerAttributes.maxammoMetalReduced.set(value) }
	
			/**
			 * In-Game: "+N% max misc ammo on wearer"
			 * 
			 * Only used for bat balls.
			 */
			context(attrs: IAttributeContainer)
			open var maxammoGrenades1Increased: Int? 
				get() = PlayerAttributes.maxammoGrenades1Increased.get()
				set(value) { PlayerAttributes.maxammoGrenades1Increased.set(value) }
		}
	}
	
	open class BuffItemsAttributes : IBlockScoped {
		companion object : IBlockScoped 
	
		/**
		 * Note that Phlogistinator's rage has a small cooldown after expiring before it can gain rage again, to prevent the lingering crit flames from immediately filling it up again.
		 */
		context(attrs: IAttributeContainer)
		open var soldierBuffType: Int? 
			get() = PlayerAttributes.soldierBuffType.get()
			set(value) { PlayerAttributes.soldierBuffType.set(value) }
	
		/**
		 * Note that Phlogistinator's rage has a small cooldown after expiring before it can gain rage again, to prevent the lingering crit flames from immediately filling it up again.
		 */
		context(attrs: IAttributeContainer)
		open var demoBuffType: Int? 
			get() = PlayerAttributes.demoBuffType.get()
			set(value) { PlayerAttributes.demoBuffType.set(value) }
	
		context(attrs: IAttributeContainer)
		open var buffDuration: Number? 
			get() = PlayerAttributes.buffDuration.get()
			set(value) { PlayerAttributes.buffDuration.set(value) }
	}
	
	open class BuildingsAttributes : IBlockScoped {
		companion object : IBlockScoped {
			val sentryGun: SentryGunAttributes = SentryGunAttributes()
	
			val dispenser: DispenserAttributes = DispenserAttributes()
	
			val teleporter: TeleporterAttributes = TeleporterAttributes()
		}
	
		/**
		 * In-Game: "+N% faster build speed"
		 * 
		 * Multiplies building build time by this amount.
		 */
		context(attrs: IAttributeContainer)
		open var buildRateBonus: Number? 
			get() = PlayerAttributes.buildRateBonus.get()
			set(value) { PlayerAttributes.buildRateBonus.set(value) }
	
		/**
		 * In-Game: "N% slower upgrade rate"
		 * 
		 * Add this amount of metal to any building hit by this player, using player's metal reserve.
		 * 
		 * Recall that all players have 100 hidden metal.
		 */
		context(attrs: IAttributeContainer)
		open var upgradeRateDecrease: Int? 
			get() = PlayerAttributes.upgradeRateDecrease.get()
			set(value) { PlayerAttributes.upgradeRateDecrease.set(value) }
	
		/**
		 * In-Game: "+N% max building health"
		 * 
		 * Only applied if the building is NOT a disposable sentry.
		 */
		context(attrs: IAttributeContainer)
		open var engyBuildingHealthBonus: Int? 
			get() = PlayerAttributes.engyBuildingHealthBonus.get()
			set(value) { PlayerAttributes.engyBuildingHealthBonus.set(value) }
	
		/**
		 * In-Game: "Cannot carry buildings"
		 * 
		 * Prevents player from picking up buildings.
		 */
		context(attrs: IAttributeContainer)
		open var cannotPickUpBuildings: Boolean? 
			get() = PlayerAttributes.cannotPickUpBuildings.get()
			set(value) { PlayerAttributes.cannotPickUpBuildings.set(value) }
	
		/**
		 * In-Game: "N metal reduction in building cost"
		 * 
		 * Sets the cost to construct any building type to this value.
		 */
		context(attrs: IAttributeContainer)
		open var buildingCostReduction: Int? 
			get() = PlayerAttributes.buildingCostReduction.get()
			set(value) { PlayerAttributes.buildingCostReduction.set(value) }
	
		/**
		 * In-Game: "Sentry build speed increased by N%"
		 */
		context(attrs: IAttributeContainer)
		open var engineerSentryBuildRateMultiplier: Number? 
			get() = PlayerAttributes.engineerSentryBuildRateMultiplier.get()
			set(value) { PlayerAttributes.engineerSentryBuildRateMultiplier.set(value) }
	
		open val sentryGun: SentryGunAttributes = SentryGunAttributes()
	
		open val dispenser: DispenserAttributes = DispenserAttributes()
	
		open val teleporter: TeleporterAttributes = TeleporterAttributes()
	
		open class SentryGunAttributes : IBlockScoped {
			companion object : IBlockScoped 
	
			/**
			 * In-Game: "+N% sentry range"
			 */
			context(attrs: IAttributeContainer)
			open var engySentryRadiusIncreased: Number? 
				get() = PlayerAttributes.engySentryRadiusIncreased.get()
				set(value) { PlayerAttributes.engySentryRadiusIncreased.set(value) }
	
			/**
			 * In-Game: "+N% sentry firing speed"
			 */
			context(attrs: IAttributeContainer)
			open var engySentryFireRateIncreased: Number? 
				get() = PlayerAttributes.engySentryFireRateIncreased.get()
				set(value) { PlayerAttributes.engySentryFireRateIncreased.set(value) }
	
			/**
			 * In-Game: "Build +N additional disposable-sentry"
			 * 
			 * Number of disposable sentries you're allowed to build.
			 * 
			 * Checked when checking if the player can build something.
			 * 
			 * Only works if the "uses upgrades" gamerule is set.
			 */
			context(attrs: IAttributeContainer)
			open var engyDisposableSentries: Int? 
				get() = PlayerAttributes.engyDisposableSentries.get()
				set(value) { PlayerAttributes.engyDisposableSentries.set(value) }
		}
	
		open class DispenserAttributes : IBlockScoped {
			companion object : IBlockScoped 
	
			/**
			 * In-Game: "+N% dispenser range"
			 */
			context(attrs: IAttributeContainer)
			open var engyDispenserRadiusIncreased: Number? 
				get() = PlayerAttributes.engyDispenserRadiusIncreased.get()
				set(value) { PlayerAttributes.engyDispenserRadiusIncreased.set(value) }
	
			/**
			 * In-Game: "Increases teleporter build speed by N%."
			 * 
			 * Multiplier applied to passive build time for dispensers and teleporters.
			 */
			context(attrs: IAttributeContainer)
			open var engineerTeleporterBuildRateMultiplier: Number? 
				get() = PlayerAttributes.engineerTeleporterBuildRateMultiplier.get()
				set(value) { PlayerAttributes.engineerTeleporterBuildRateMultiplier.set(value) }
		}
	
		open class TeleporterAttributes : IBlockScoped {
			companion object : IBlockScoped 
	
			/**
			 * In-Game: "Teleporters can be used in both directions"
			 */
			context(attrs: IAttributeContainer)
			open var bidirectionalTeleport: Boolean? 
				get() = PlayerAttributes.bidirectionalTeleport.get()
				set(value) { PlayerAttributes.bidirectionalTeleport.set(value) }
	
			/**
			 * In-Game: "N% metal cost when constructing or upgrading teleporters"
			 * 
			 * Multiplier applied to teleporter construction cost.
			 */
			context(attrs: IAttributeContainer)
			open var teleporterCost: Number? 
				get() = PlayerAttributes.teleporterCost.get()
				set(value) { PlayerAttributes.teleporterCost.set(value) }
	
			/**
			 * In-Game: "Increases teleporter build speed by N%."
			 * 
			 * Multiplier applied to passive build time for dispensers and teleporters.
			 */
			context(attrs: IAttributeContainer)
			open var engineerTeleporterBuildRateMultiplier: Number? 
				get() = PlayerAttributes.engineerTeleporterBuildRateMultiplier.get()
				set(value) { PlayerAttributes.engineerTeleporterBuildRateMultiplier.set(value) }
		}
	}
	
	open class CloakAttributes : IBlockScoped {
		companion object : IBlockScoped 
	
		/**
		 * In-Game: "N sec longer cloak blink time"
		 * 
		 * Multiplier.
		 */
		context(attrs: IAttributeContainer)
		open var setBonusCloakBlinkTimePenalty: Number? 
			get() = PlayerAttributes.setBonusCloakBlinkTimePenalty.get()
			set(value) { PlayerAttributes.setBonusCloakBlinkTimePenalty.set(value) }
	
		/**
		 * In-Game: "N sec increase in time to cloak"
		 */
		context(attrs: IAttributeContainer)
		open var multCloakRate: Number? 
			get() = PlayerAttributes.multCloakRate.get()
			set(value) { PlayerAttributes.multCloakRate.set(value) }
	
		/**
		 * In-Game: "Reduced decloak sound volume"
		 * 
		 * If true, plays `Player.Spy_UnCloakReduced` when decloaking.
		 */
		context(attrs: IAttributeContainer)
		open var setBonusQuietUnstealth: Boolean? 
			get() = PlayerAttributes.setBonusQuietUnstealth.get()
			set(value) { PlayerAttributes.setBonusQuietUnstealth.set(value) }
	
		context(attrs: IAttributeContainer)
		open var multDecloakRate: Number? 
			get() = PlayerAttributes.multDecloakRate.get()
			set(value) { PlayerAttributes.multDecloakRate.set(value) }
	}
	
	open class DamageAttributes : BaseEntityAttributes.DamageAttributes() {
		companion object : IBlockScoped {
			val alien: AlienAttributes = AlienAttributes()
		}
	
		/**
		 * In-Game: "Deals 3x falling damage to the player you land on"
		 * 
		 * Deal 3x falling damage to player you land on.
		 */
		context(attrs: IAttributeContainer)
		open var bootsFallingStomp: Boolean? 
			get() = PlayerAttributes.bootsFallingStomp.get()
			set(value) { PlayerAttributes.bootsFallingStomp.set(value) }
	
		/**
		 * In-Game: "Headshots deal an extra +N% damage"
		 * 
		 * Multiplier applied to headshot damage.
		 */
		context(attrs: IAttributeContainer)
		open var headshotDamageIncrease: Number? 
			get() = PlayerAttributes.headshotDamageIncrease.get()
			set(value) { PlayerAttributes.headshotDamageIncrease.set(value) }
	
		open val alien: AlienAttributes = AlienAttributes()
	
		open class AlienAttributes : IBlockScoped {
			companion object : IBlockScoped 
	
			/**
			 * In-Game: "Increased Melee damage against Isolated Merc Set"
			 * 
			 * Deal extra damage to players wearing the Alien set.
			 */
			context(attrs: IAttributeContainer)
			open var setBonusAlienIsolationXenoBonusPos: Boolean? 
				get() = PlayerAttributes.setBonusAlienIsolationXenoBonusPos.get()
				set(value) { PlayerAttributes.setBonusAlienIsolationXenoBonusPos.set(value) }
	
			/**
			 * In-Game: "Increased Nostromo Napalmer damage against Isolationist Pack Set"
			 * 
			 * Deal extra damage to players wearing the Xenomorph set.
			 */
			context(attrs: IAttributeContainer)
			open var setBonusAlienIsolationMercBonusPos: Boolean? 
				get() = PlayerAttributes.setBonusAlienIsolationMercBonusPos.get()
				set(value) { PlayerAttributes.setBonusAlienIsolationMercBonusPos.set(value) }
		}
	}
	
	open class DemoChargeAttributes : IBlockScoped {
		companion object : IBlockScoped {
			val multChargeTurnControl: MultChargeTurnControlAttributes = MultChargeTurnControlAttributes()
		}
	
		/**
		 * In-Game: "Taking damage while shield charging reduces remaining charging time"
		 * 
		 * Used to detect the Tide Turner when deciding whether to give you minicrits or crits.
		 */
		context(attrs: IAttributeContainer)
		open var loseDemoChargeOnDamageWhenCharging: Boolean? 
			get() = PlayerAttributes.loseDemoChargeOnDamageWhenCharging.get()
			set(value) { PlayerAttributes.loseDemoChargeOnDamageWhenCharging.set(value) }
	
		/**
		 * In-Game: "Melee kills refill N% of your charge meter."
		 * 
		 * Amount of targe-charge meter gained on kill.  Scaled by various values.
		 */
		context(attrs: IAttributeContainer)
		open var killRefillsMeter: Number? 
			get() = PlayerAttributes.killRefillsMeter.get()
			set(value) { PlayerAttributes.killRefillsMeter.set(value) }
	
		context(attrs: IAttributeContainer)
		open var chargeTime: Number? 
			get() = PlayerAttributes.chargeTime.get()
			set(value) { PlayerAttributes.chargeTime.set(value) }
	
		/**
		 * In-Game: "+N% increase in charge recharge rate"
		 * 
		 * Only applies to Demoman.
		 */
		context(attrs: IAttributeContainer)
		open var chargeRechargeRateIncreased: Number? 
			get() = PlayerAttributes.chargeRechargeRateIncreased.get()
			set(value) { PlayerAttributes.chargeRechargeRateIncreased.set(value) }
	
		open val multChargeTurnControl: MultChargeTurnControlAttributes = MultChargeTurnControlAttributes()
	
		open class MultChargeTurnControlAttributes : IBlockScoped {
			companion object : IBlockScoped 
	
			/**
			 * In-Game: "+N% increase in turning control while charging"
			 * 
			 * Default is 0.45f, and this is a multiplier applied to it.
			 */
			context(attrs: IAttributeContainer)
			open var multChargeTurnControl: Number? 
				get() = PlayerAttributes.multChargeTurnControl.get()
				set(value) { PlayerAttributes.multChargeTurnControl.set(value) }
	
			/**
			 * In-Game: "Full turning control while charging"
			 * 
			 * Default is 0.45f, and this is a multiplier applied to it.
			 */
			context(attrs: IAttributeContainer)
			open var fullChargeTurnControl: Number? 
				get() = PlayerAttributes.fullChargeTurnControl.get()
				set(value) { PlayerAttributes.fullChargeTurnControl.set(value) }
		}
	}
	
	open class DisguiseAttributes : BaseEntityAttributes.DisguiseAttributes() {
		companion object : IBlockScoped 
	
		/**
		 * In-Game: "Immune to fire damage while disguised"
		 * 
		 * Prevent afterburn while disguised.
		 */
		context(attrs: IAttributeContainer)
		open var disguiseNoBurn: Boolean? 
			get() = PlayerAttributes.disguiseNoBurn.get()
			set(value) { PlayerAttributes.disguiseNoBurn.set(value) }
	
		/**
		 * In-Game: "Wearer cannot disguise"
		 */
		context(attrs: IAttributeContainer)
		open var cannotDisguise: Boolean? 
			get() = PlayerAttributes.cannotDisguise.get()
			set(value) { PlayerAttributes.cannotDisguise.set(value) }
	}
	
	open class FiringAttributes : IBlockScoped {
		companion object : IBlockScoped 
	
		/**
		 * Prevents player from attacking.
		 */
		context(attrs: IAttributeContainer)
		open var noAttack: Boolean? 
			get() = PlayerAttributes.noAttack.get()
			set(value) { PlayerAttributes.noAttack.set(value) }
	}
	
	open class HeadsAttributes : IBlockScoped {
		companion object : IBlockScoped 
	
		/**
		 * This attribute only works on players that are a Medic wielding the Vitasaw. For the all-class version, see `extra_damage_on_hit` (unimplemented in vanilla, accessible via Rafmod).
		 * 
		 * Gives extra player movespeed the more heads you have. (Partially implemented.).
		 * 
		 * Will not work if the player is not a Medic wielding the VitaSaw.
		 */
		context(attrs: IAttributeContainer)
		open var addHeadOnHit: Boolean? 
			get() = PlayerAttributes.addHeadOnHit.get()
			set(value) { PlayerAttributes.addHeadOnHit.set(value) }
	}
	
	open class HealthAndHealingAttributes : IBlockScoped {
		companion object : IBlockScoped {
			val healthRegen: HealthRegenAttributes = HealthRegenAttributes()
	
			val maxHealthAdditive: MaxHealthAdditiveAttributes = MaxHealthAdditiveAttributes()
		}
	
		/**
		 * In-Game: "+25% heal rate for patient, +25% faster revive rate, and +25% self heal rate, per point"
		 * 
		 * On Medic only, each level raises the Medic's passive regen by 25% of its normal value.
		 */
		context(attrs: IAttributeContainer)
		open var healingMastery: Int? 
			get() = PlayerAttributes.healingMastery.get()
			set(value) { PlayerAttributes.healingMastery.set(value) }
	
		/**
		 * Bonus:
		 * 
		 * 	- In-Game: "+N% health from packs on wearer"
		 * 
		 * Penalty:
		 * 
		 * 	- In-Game: "N% health from packs on wearer"
		 */
		context(attrs: IAttributeContainer)
		open var healthFromPacks: Number? 
			get() = PlayerAttributes.healthFromPacks.get()
			set(value) { PlayerAttributes.healthFromPacks.set(value) }
	
		/**
		 * In-Game: "N% less healing from Medic sources"
		 * 
		 * Specifically checked on Crossbow Bolt impacts.
		 */
		context(attrs: IAttributeContainer)
		open var reducedHealingFromMedics: Number? 
			get() = PlayerAttributes.reducedHealingFromMedics.get()
			set(value) { PlayerAttributes.reducedHealingFromMedics.set(value) }
	
		/**
		 * Bonus:
		 * 
		 * 	- In-Game: "+N% health from healers on wearer"
		 * 
		 * Penalty:
		 * 
		 * 	- In-Game: "N% health from healers on wearer"
		 */
		context(attrs: IAttributeContainer)
		open var healthFromHealersReduced: Number? 
			get() = PlayerAttributes.healthFromHealersReduced.get()
			set(value) { PlayerAttributes.healthFromHealersReduced.set(value) }
	
		/**
		 * In-Game: "Blocks healing while in use"
		 * 
		 * If set, this player may not be targeted by heal-beams or healed from Crossbow impacts.
		 */
		context(attrs: IAttributeContainer)
		open var weaponBlocksHealing: Boolean? 
			get() = PlayerAttributes.weaponBlocksHealing.get()
			set(value) { PlayerAttributes.weaponBlocksHealing.set(value) }
	
		/**
		 * In-Game: "+N max health on wearer"
		 * 
		 * Additive maximum health increase. See also: [addMaxHealth].
		 */
		context(attrs: IAttributeContainer)
		open var hiddenMaxhealthNonBuffed: Int? 
			get() = PlayerAttributes.hiddenMaxhealthNonBuffed.get()
			set(value) { PlayerAttributes.hiddenMaxhealthNonBuffed.set(value) }
	
		open val healthRegen: HealthRegenAttributes = HealthRegenAttributes()
	
		open val maxHealthAdditive: MaxHealthAdditiveAttributes = MaxHealthAdditiveAttributes()
	
		open class HealthRegenAttributes : IBlockScoped {
			companion object : IBlockScoped 
	
			/**
			 * In-Game: "+N health regenerated per second on wearer"
			 * 
			 * Amount of health regenerated per regen tick.  Scales by the amount of time since the player last took damage in non-MvM modes.
			 */
			context(attrs: IAttributeContainer)
			open var healthRegen: Number? 
				get() = PlayerAttributes.healthRegen.get()
				set(value) { PlayerAttributes.healthRegen.set(value) }
	
			/**
			 * In-Game: "N health drained per second on wearer"
			 * 
			 * Amount of health regenerated per regen tick.  Scales by the amount of time since the player last took damage in non-MvM modes.
			 */
			context(attrs: IAttributeContainer)
			open var healthDrain: Number? 
				get() = PlayerAttributes.healthDrain.get()
				set(value) { PlayerAttributes.healthDrain.set(value) }
	
			/**
			 * In-Game: "+N health regenerated per second on wearer"
			 * 
			 * Amount of health regenerated per regen tick.  Scales by the amount of time since the player last took damage in non-MvM modes.
			 */
			context(attrs: IAttributeContainer)
			open var setBonusHealthRegenSetBonus: Number? 
				get() = PlayerAttributes.setBonusHealthRegenSetBonus.get()
				set(value) { PlayerAttributes.setBonusHealthRegenSetBonus.set(value) }
	
			/**
			 * In-Game: "N health regenerated per second on wearer"
			 * 
			 * Amount of health regenerated per regen tick.  Scales by the amount of time since the player last took damage in non-MvM modes.
			 */
			context(attrs: IAttributeContainer)
			open var healthDrainMedic: Number? 
				get() = PlayerAttributes.healthDrainMedic.get()
				set(value) { PlayerAttributes.healthDrainMedic.set(value) }
	
			/**
			 * In-Game: "+N health regenerated per second on wearer"
			 * 
			 * Amount of health regenerated per regen tick.  Scales by the amount of time since the player last took damage in non-MvM modes.
			 */
			context(attrs: IAttributeContainer)
			open var cardHealthRegen: Number? 
				get() = PlayerAttributes.cardHealthRegen.get()
				set(value) { PlayerAttributes.cardHealthRegen.set(value) }
		}
	
		open class MaxHealthAdditiveAttributes : IBlockScoped {
			companion object : IBlockScoped 
	
			/**
			 * In-Game: "+N max health on wearer"
			 * 
			 * Additive maximum health increase only checked when overhealing.
			 */
			context(attrs: IAttributeContainer)
			open var maxHealthAdditiveBonus: Int? 
				get() = PlayerAttributes.maxHealthAdditiveBonus.get()
				set(value) { PlayerAttributes.maxHealthAdditiveBonus.set(value) }
	
			/**
			 * In-Game: "N max health on wearer"
			 * 
			 * Additive maximum health increase only checked when overhealing.
			 */
			context(attrs: IAttributeContainer)
			open var maxHealthAdditivePenalty: Int? 
				get() = PlayerAttributes.maxHealthAdditivePenalty.get()
				set(value) { PlayerAttributes.maxHealthAdditivePenalty.set(value) }
	
			/**
			 * In-Game: "+N max health on wearer"
			 * 
			 * Additive maximum health increase only checked when overhealing.
			 */
			context(attrs: IAttributeContainer)
			open var setBonusMaxHealthAdditiveBonus: Int? 
				get() = PlayerAttributes.setBonusMaxHealthAdditiveBonus.get()
				set(value) { PlayerAttributes.setBonusMaxHealthAdditiveBonus.set(value) }
		}
	}
	
	open class HudAttributes : IBlockScoped {
		companion object : IBlockScoped 
	
		/**
		 * Only used if the build menu is actually shown.
		 * 
		 * 0 = default.
		 * 
		 * 1 = pipboy.
		 * 
		 * Works on Engineer and Spy (if you can give him a build menu).
		 */
		context(attrs: IAttributeContainer)
		open var hasPipboyBuildInterface: Int? 
			get() = PlayerAttributes.hasPipboyBuildInterface.get()
			set(value) { PlayerAttributes.hasPipboyBuildInterface.set(value) }
	
		/**
		 * In-Game: "Allows you to see enemy health"
		 */
		context(attrs: IAttributeContainer)
		open var seeEnemyHealth: Boolean? 
			get() = PlayerAttributes.seeEnemyHealth.get()
			set(value) { PlayerAttributes.seeEnemyHealth.set(value) }
	
		/**
		 * In-Game: "Unable to see enemy health"
		 * 
		 * Always true in MvM.
		 */
		context(attrs: IAttributeContainer)
		open var hideEnemyHealth: Boolean? 
			get() = PlayerAttributes.hideEnemyHealth.get()
			set(value) { PlayerAttributes.hideEnemyHealth.set(value) }
	}
	
	open class KnockbackReceivedAttributes : BaseEntityAttributes.KnockbackReceivedAttributes() {
		companion object : IBlockScoped 
	
		context(attrs: IAttributeContainer)
		open var airblastVulnerabilityMultiplier: Number? 
			get() = PlayerAttributes.airblastVulnerabilityMultiplier.get()
			set(value) { PlayerAttributes.airblastVulnerabilityMultiplier.set(value) }
	
		context(attrs: IAttributeContainer)
		open var airblastVerticalVulnerabilityMultiplier: Number? 
			get() = PlayerAttributes.airblastVerticalVulnerabilityMultiplier.get()
			set(value) { PlayerAttributes.airblastVerticalVulnerabilityMultiplier.set(value) }
	
		/**
		 * In-Game: "Knockback reduced by N% when aiming"
		 * 
		 * Only works on Sniper.
		 */
		context(attrs: IAttributeContainer)
		open var aimingKnockbackResistance: Number? 
			get() = PlayerAttributes.aimingKnockbackResistance.get()
			set(value) { PlayerAttributes.aimingKnockbackResistance.set(value) }
	}
	
	open class MetaAttributes : BaseEntityAttributes.MetaAttributes() {
		companion object : IBlockScoped {
			val noisemakers: NoisemakersAttributes = NoisemakersAttributes()
	
			val items: ItemsAttributes = ItemsAttributes()
	
			val player: PlayerAttributes = PlayerAttributes()
	
			val gameplay: GameplayAttributes = GameplayAttributes()
	
			val particles: ParticlesAttributes = ParticlesAttributes()
		}
	
		/**
		 * If 1, create a soccer ball on the ground when the player spawns.
		 */
		context(attrs: IAttributeContainer)
		open var spawnWithPhysicsToy: Int? 
			get() = PlayerAttributes.spawnWithPhysicsToy.get()
			set(value) { PlayerAttributes.spawnWithPhysicsToy.set(value) }
	
		/**
		 * In-Game: "Leave a Calling Card on your victims."
		 * 
		 * Defines the calling card that should be dropped when this player kills another player.
		 */
		context(attrs: IAttributeContainer)
		open var setBonusCallingCardOnKill: Int? 
			get() = PlayerAttributes.setBonusCallingCardOnKill.get()
			set(value) { PlayerAttributes.setBonusCallingCardOnKill.set(value) }
	
		override val killfeed: KillfeedAttributes = KillfeedAttributes()
	
		open val noisemakers: NoisemakersAttributes = NoisemakersAttributes()
	
		open val items: ItemsAttributes = ItemsAttributes()
	
		open val player: PlayerAttributes = PlayerAttributes()
	
		open val gameplay: GameplayAttributes = GameplayAttributes()
	
		open val particles: ParticlesAttributes = ParticlesAttributes()
	
		open class KillfeedAttributes : BaseEntityAttributes.MetaAttributes.KillfeedAttributes() {
			companion object : IBlockScoped 
	
			/**
			 * If the weapon is a Holy Mackerel reskin (AKA either the fish or the Unarmed Combat) and this is set, use the Unarmed Combat "arm hit" killfeed notice instead of the "fish hit" notice.
			 */
			context(attrs: IAttributeContainer)
			open var fishDamageOverride: Boolean? 
				get() = PlayerAttributes.fishDamageOverride.get()
				set(value) { PlayerAttributes.fishDamageOverride.set(value) }
		}
	
		open class NoisemakersAttributes : IBlockScoped {
			companion object : IBlockScoped 
	
			/**
			 * In-Game: "Noise Maker"
			 * 
			 * Uses noise maker when pressing action slot key.
			 */
			context(attrs: IAttributeContainer)
			open var noiseMaker: Boolean? 
				get() = PlayerAttributes.noiseMaker.get()
				set(value) { PlayerAttributes.noiseMaker.set(value) }
	
			context(attrs: IAttributeContainer)
			open var unlimitedQuantity: Boolean? 
				get() = PlayerAttributes.unlimitedQuantity.get()
				set(value) { PlayerAttributes.unlimitedQuantity.set(value) }
		}
	
		open class ItemsAttributes : IBlockScoped {
			companion object : IBlockScoped 
	
			/**
			 * In-Game: "Killstreaks Active"
			 */
			context(attrs: IAttributeContainer)
			open var killstreakTier: Int? 
				get() = PlayerAttributes.killstreakTier.get()
				set(value) { PlayerAttributes.killstreakTier.set(value) }
		}
	
		open class PlayerAttributes : IBlockScoped {
			companion object : IBlockScoped 
	
			/**
			 * In-Game: "Jingle all the way"
			 * 
			 * If 1, use xmas.jingle, if 2 or higher use xmas.jingle_higher.
			 */
			context(attrs: IAttributeContainer)
			open var addJingleToFootsteps: Int? 
				get() = PlayerAttributes.addJingleToFootsteps.get()
				set(value) { PlayerAttributes.addJingleToFootsteps.set(value) }
	
			/**
			 * In-Game: "N"
			 * 
			 * Decimal version of the 4-byte hex code determining color of footsteps (e.g. `0xFFFFFFFF`, but in decimal).
			 */
			context(attrs: IAttributeContainer)
			open var spellSetHalloweenFootstepType: Int? 
				get() = PlayerAttributes.spellSetHalloweenFootstepType.get()
				set(value) { PlayerAttributes.spellSetHalloweenFootstepType.set(value) }
	
			context(attrs: IAttributeContainer)
			open var overrideFootstepSoundSet: FootstepOverride? 
				get() = PlayerAttributes.overrideFootstepSoundSet.get()
				set(value) { PlayerAttributes.overrideFootstepSoundSet.set(value) }
	
			/**
			 * In-Game: "Explode spectacularly on death"
			 */
			context(attrs: IAttributeContainer)
			open var bombinomiconEffectOnDeath: Boolean? 
				get() = PlayerAttributes.bombinomiconEffectOnDeath.get()
				set(value) { PlayerAttributes.bombinomiconEffectOnDeath.set(value) }
	
			/**
			 * If true, the Voodoo-Cursed Soul skin is equipped.
			 */
			context(attrs: IAttributeContainer)
			open var zombiezombiezombiezombie: Boolean? 
				get() = PlayerAttributes.zombiezombiezombiezombie.get()
				set(value) { PlayerAttributes.zombiezombiezombiezombie.set(value) }
	
			/**
			 * In-Game: "Disables double jump"
			 */
			context(attrs: IAttributeContainer)
			open var headScale: Number? 
				get() = PlayerAttributes.headScale.get()
				set(value) { PlayerAttributes.headScale.set(value) }
	
			context(attrs: IAttributeContainer)
			open var torsoScale: Number? 
				get() = PlayerAttributes.torsoScale.get()
				set(value) { PlayerAttributes.torsoScale.set(value) }
	
			context(attrs: IAttributeContainer)
			open var handScale: Number? 
				get() = PlayerAttributes.handScale.get()
				set(value) { PlayerAttributes.handScale.set(value) }
	
			/**
			 * DSP used when emitting sounds created by this player.
			 */
			context(attrs: IAttributeContainer)
			open var setBonusSpecialDsp: Int? 
				get() = PlayerAttributes.setBonusSpecialDsp.get()
				set(value) { PlayerAttributes.setBonusSpecialDsp.set(value) }
		}
	
		open class GameplayAttributes : IBlockScoped {
			companion object : IBlockScoped 
	
			/**
			 * In-Game: "+N capture rate on wearer"
			 */
			context(attrs: IAttributeContainer)
			open var increasePlayerCaptureValue: Int? 
				get() = PlayerAttributes.increasePlayerCaptureValue.get()
				set(value) { PlayerAttributes.increasePlayerCaptureValue.set(value) }
	
			/**
			 * In-Game: "Share Canteens with your heal target. +1 duration, -10 price per point (minimum cost: 5)"
			 * 
			 * Discounts canteens by 10 * level.
			 */
			context(attrs: IAttributeContainer)
			open var canteenSpecialist: Int? 
				get() = PlayerAttributes.canteenSpecialist.get()
				set(value) { PlayerAttributes.canteenSpecialist.set(value) }
	
			/**
			 * In-Game: "Wearer cannot carry the intelligence briefcase or PASS Time JACK"
			 */
			context(attrs: IAttributeContainer)
			open var cannotPickUpIntelligence: Boolean? 
				get() = PlayerAttributes.cannotPickUpIntelligence.get()
				set(value) { PlayerAttributes.cannotPickUpIntelligence.set(value) }
		}
	
		open class ParticlesAttributes : IBlockScoped {
			companion object : IBlockScoped 
	
			context(attrs: IAttributeContainer)
			open var useHeadOrigin: Boolean? 
				get() = PlayerAttributes.useHeadOrigin.get()
				set(value) { PlayerAttributes.useHeadOrigin.set(value) }
	
			context(attrs: IAttributeContainer)
			open var verticalOffset: Number? 
				get() = PlayerAttributes.verticalOffset.get()
				set(value) { PlayerAttributes.verticalOffset.set(value) }
		}
	}
	
	open class MeterAttributes : BaseEntityAttributes.MeterAttributes() {
		companion object : IBlockScoped {
			val generateRageOnDamage: GenerateRageOnDamageAttributes = GenerateRageOnDamageAttributes()
		}
	
		/**
		 * In-Game: "Build energy by healing teammates.  When fully charged, press the Special-Attack key to deploy a frontal projectile shield."
		 * 
		 * Gain shield meter from damage healed. Only works on Medic.
		 */
		context(attrs: IAttributeContainer)
		open var generateRageOnHeal: Boolean? 
			get() = PlayerAttributes.generateRageOnHeal.get()
			set(value) { PlayerAttributes.generateRageOnHeal.set(value) }
	
		/**
		 * In-Game: "Gain Focus on kills and assists"
		 * 
		 * Amount of Sniper rage gained on kill.  Only works on Sniper.
		 */
		context(attrs: IAttributeContainer)
		open var rageOnKill: Number? 
			get() = PlayerAttributes.rageOnKill.get()
			set(value) { PlayerAttributes.rageOnKill.set(value) }
	
		/**
		 * In-Game: "Boost reduced on air jumps"
		 * 
		 * Lose this amount of hype if you airdash.
		 * 
		 * Note that this only applies to scout hype, not rage in general.
		 */
		context(attrs: IAttributeContainer)
		open var hypeResetsOnJump: Int? 
			get() = PlayerAttributes.hypeResetsOnJump.get()
			set(value) { PlayerAttributes.hypeResetsOnJump.set(value) }
	
		/**
		 * Multiplier applied to rage gained by dealing damage, taking damage, or dealing burn damage.
		 */
		context(attrs: IAttributeContainer)
		open var rageGivingScale: Number? 
			get() = PlayerAttributes.rageGivingScale.get()
			set(value) { PlayerAttributes.rageGivingScale.set(value) }
	
		/**
		 * In-Game: "On Hit: Builds Hype"
		 * 
		 * Adds the amount of damage dealt to the Scout hype meter, to a maximum of 200 damage which adds 50% meter.
		 */
		context(attrs: IAttributeContainer)
		open var hypeOnDamage: Boolean? 
			get() = PlayerAttributes.hypeOnDamage.get()
			set(value) { PlayerAttributes.hypeOnDamage.set(value) }
	
		/**
		 * Only procs on Sniper. Gain this amount of rage meter on assists.
		 */
		context(attrs: IAttributeContainer)
		open var rageOnAssists: Number? 
			get() = PlayerAttributes.rageOnAssists.get()
			set(value) { PlayerAttributes.rageOnAssists.set(value) }
	
		/**
		 * If `mult_item_meter_charge_rate` is set, checks this attribute to see what type of meter should be modified, and also only allows it to activate if the active weapon is not a TF_WEAPON_FLAMEBALL.
		 */
		context(attrs: IAttributeContainer)
		override var itemMeterChargeType: TFMeterRechargeType? 
			get() = super.itemMeterChargeType
			set(value) { super.itemMeterChargeType = value }
	
		/**
		 * In-Game: "Hype Decays Over Time."
		 * 
		 * How much the Scout's hype meter decays every tick.
		 */
		context(attrs: IAttributeContainer)
		open var hypeDecaysOverTime: Number? 
			get() = PlayerAttributes.hypeDecaysOverTime.get()
			set(value) { PlayerAttributes.hypeDecaysOverTime.set(value) }
	
		/**
		 * In-Game: "Boost reduced when hit"
		 * 
		 * Amount of hype lost per point of damage taken.
		 */
		context(attrs: IAttributeContainer)
		open var loseHypeOnTakeDamage: Int? 
			get() = PlayerAttributes.loseHypeOnTakeDamage.get()
			set(value) { PlayerAttributes.loseHypeOnTakeDamage.set(value) }
	
		open val generateRageOnDamage: GenerateRageOnDamageAttributes = GenerateRageOnDamageAttributes()
	
		open class GenerateRageOnDamageAttributes : IBlockScoped {
			companion object : IBlockScoped 
	
			/**
			 * In-Game: "Generate Rage by dealing damage.  When fully charged, press the Special-Attack key to activate knockback"
			 * 
			 * Only works on Engineer and Heavy.
			 * 
			 * On Engineer, adds all damage dealt to the rage meter.
			 * 
			 * On Heavy, adds `0.22` * the damage to the meter, and reduces damage by 50% while the meter is draining.
			 */
			context(attrs: IAttributeContainer)
			open var generateRageOnDamage: Boolean? 
				get() = PlayerAttributes.generateRageOnDamage.get()
				set(value) { PlayerAttributes.generateRageOnDamage.set(value) }
	
			/**
			 * In-Game: "Generate building rescue energy on damage"
			 * 
			 * Only works on Engineer and Heavy.
			 * 
			 * On Engineer, adds all damage dealt to the rage meter.
			 * 
			 * On Heavy, adds `0.22` * the damage to the meter, and reduces damage by 50% while the meter is draining.
			 */
			context(attrs: IAttributeContainer)
			open var engineerRageOnDmg: Boolean? 
				get() = PlayerAttributes.engineerRageOnDmg.get()
				set(value) { PlayerAttributes.engineerRageOnDmg.set(value) }
		}
	}
	
	open class MovementAttributes : IBlockScoped {
		companion object : IBlockScoped {
			val jumpHeight: jumpHeightAttributes = jumpHeightAttributes()
	
			val moveSpeed: MoveSpeedAttributes = MoveSpeedAttributes()
		}
	
		/**
		 * Allows parachute to be deployed. Parachute prop only appears if the BASE Jumper is equipped, but the functionality is the same regardless.
		 */
		context(attrs: IAttributeContainer)
		open var parachuteAttribute: Boolean? 
			get() = PlayerAttributes.parachuteAttribute.get()
			set(value) { PlayerAttributes.parachuteAttribute.set(value) }
	
		/**
		 * In-Game: "N% increased air control."
		 * 
		 * Note: the jetpack condition always multiplies your air acceleration by 50%.
		 */
		context(attrs: IAttributeContainer)
		open var increasedAirControl: Number? 
			get() = PlayerAttributes.increasedAirControl.get()
			set(value) { PlayerAttributes.increasedAirControl.set(value) }
	
		/**
		 * In-Game: "N% increased air control when blast jumping."
		 * 
		 * Specifically while blast-jumping, as opposed to global.
		 */
		context(attrs: IAttributeContainer)
		open var airControlBlastJump: Number? 
			get() = PlayerAttributes.airControlBlastJump.get()
			set(value) { PlayerAttributes.airControlBlastJump.set(value) }
	
		/**
		 * Prevents player from jumping.
		 */
		context(attrs: IAttributeContainer)
		open var noJump: Boolean? 
			get() = PlayerAttributes.noJump.get()
			set(value) { PlayerAttributes.noJump.set(value) }
	
		/**
		 * Prevents player from crouching.
		 */
		context(attrs: IAttributeContainer)
		open var noDuck: Boolean? 
			get() = PlayerAttributes.noDuck.get()
			set(value) { PlayerAttributes.noDuck.set(value) }
	
		/**
		 * In-Game: "Disables double jump"
		 */
		context(attrs: IAttributeContainer)
		open var noDoubleJump: Boolean? 
			get() = PlayerAttributes.noDoubleJump.get()
			set(value) { PlayerAttributes.noDoubleJump.set(value) }
	
		open val jumpHeight: jumpHeightAttributes = jumpHeightAttributes()
	
		open val moveSpeed: MoveSpeedAttributes = MoveSpeedAttributes()
	
		open class jumpHeightAttributes : IBlockScoped {
			companion object : IBlockScoped 
	
			/**
			 * In-Game: "+N% greater jump height when active"
			 */
			context(attrs: IAttributeContainer)
			open var increasedJumpHeight: Number? 
				get() = PlayerAttributes.increasedJumpHeight.get()
				set(value) { PlayerAttributes.increasedJumpHeight.set(value) }
	
			context(attrs: IAttributeContainer)
			open var majorIncreasedJumpHeight: Number? 
				get() = PlayerAttributes.majorIncreasedJumpHeight.get()
				set(value) { PlayerAttributes.majorIncreasedJumpHeight.set(value) }
	
			context(attrs: IAttributeContainer)
			open var halloweenIncreasedJumpHeight: Number? 
				get() = PlayerAttributes.halloweenIncreasedJumpHeight.get()
				set(value) { PlayerAttributes.halloweenIncreasedJumpHeight.set(value) }
		}
	
		open class MoveSpeedAttributes : IBlockScoped {
			companion object : IBlockScoped {
				val aimingMovespeed: AimingMovespeedAttributes = AimingMovespeedAttributes()
	
				val moveSpeed: MoveSpeedAttributes = MoveSpeedAttributes()
			}
	
			/**
			 * In-Game: "+N% faster move speed on wearer (shield required)"
			 */
			context(attrs: IAttributeContainer)
			open var moveSpeedBonusShieldRequired: Number? 
				get() = PlayerAttributes.moveSpeedBonusShieldRequired.get()
				set(value) { PlayerAttributes.moveSpeedBonusShieldRequired.set(value) }
	
			open val aimingMovespeed: AimingMovespeedAttributes = AimingMovespeedAttributes()
	
			open val moveSpeed: MoveSpeedAttributes = MoveSpeedAttributes()
	
			open class AimingMovespeedAttributes : IBlockScoped {
				companion object : IBlockScoped 
	
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
				context(attrs: IAttributeContainer)
				open var aimingMovespeedIncreased: Number? 
					get() = PlayerAttributes.aimingMovespeedIncreased.get()
					set(value) { PlayerAttributes.aimingMovespeedIncreased.set(value) }
	
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
				context(attrs: IAttributeContainer)
				open var aimingMovespeedDecreased: Number? 
					get() = PlayerAttributes.aimingMovespeedDecreased.get()
					set(value) { PlayerAttributes.aimingMovespeedDecreased.set(value) }
	
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
				context(attrs: IAttributeContainer)
				open var sniperAimingMovespeedDecreased: Number? 
					get() = PlayerAttributes.sniperAimingMovespeedDecreased.get()
					set(value) { PlayerAttributes.sniperAimingMovespeedDecreased.set(value) }
			}
	
			open class MoveSpeedAttributes : IBlockScoped {
				companion object : IBlockScoped 
	
				/**
				 * In-Game: "N% slower move speed on wearer"
				 */
				context(attrs: IAttributeContainer)
				open var moveSpeedPenalty: Number? 
					get() = PlayerAttributes.moveSpeedPenalty.get()
					set(value) { PlayerAttributes.moveSpeedPenalty.set(value) }
	
				/**
				 * In-Game: "+N% faster move speed on wearer"
				 */
				context(attrs: IAttributeContainer)
				open var moveSpeedBonus: Number? 
					get() = PlayerAttributes.moveSpeedBonus.get()
					set(value) { PlayerAttributes.moveSpeedBonus.set(value) }
	
				context(attrs: IAttributeContainer)
				open var majorMoveSpeedBonus: Number? 
					get() = PlayerAttributes.majorMoveSpeedBonus.get()
					set(value) { PlayerAttributes.majorMoveSpeedBonus.set(value) }
	
				/**
				 * In-Game: "+N% faster move speed on wearer"
				 */
				context(attrs: IAttributeContainer)
				open var setBonusMoveSpeedSetBonus: Number? 
					get() = PlayerAttributes.setBonusMoveSpeedSetBonus.get()
					set(value) { PlayerAttributes.setBonusMoveSpeedSetBonus.set(value) }
	
				/**
				 * In-Game: "+N% faster move speed on wearer"
				 */
				context(attrs: IAttributeContainer)
				open var cardMoveSpeedBonus: Number? 
					get() = PlayerAttributes.cardMoveSpeedBonus.get()
					set(value) { PlayerAttributes.cardMoveSpeedBonus.set(value) }
			}
		}
	}
	
	open class OnHitAttributes : IBlockScoped {
		companion object : IBlockScoped {
			val falling: FallingAttributes = FallingAttributes()
		}
	
		open val falling: FallingAttributes = FallingAttributes()
	
		open class FallingAttributes : IBlockScoped {
			companion object : IBlockScoped 
	
			/**
			 * In-Game: "Push enemies back when you land (force and radius based on velocity)"
			 * 
			 * Requires player to have the `TF_COND_ROCKETPACK` condition.
			 * 
			 * Pushes back nearby players around the landing site.
			 */
			context(attrs: IAttributeContainer)
			open var fallingImpactRadiusPushback: Boolean? 
				get() = PlayerAttributes.fallingImpactRadiusPushback.get()
				set(value) { PlayerAttributes.fallingImpactRadiusPushback.set(value) }
	
			/**
			 * In-Game: "Stun enemies when you land"
			 * 
			 * If `falling_impact_radius_pushback` is set, this will also stun any enemies in the impact radius.
			 */
			context(attrs: IAttributeContainer)
			open var fallingImpactRadiusStun: Boolean? 
				get() = PlayerAttributes.fallingImpactRadiusStun.get()
				set(value) { PlayerAttributes.fallingImpactRadiusStun.set(value) }
		}
	}
	
	open class OnKillAttributes : IBlockScoped {
		companion object : IBlockScoped 
	
		/**
		 * In-Game: "On Kill: A small health pack is dropped"
		 * 
		 * Drop a small health pack when killing an enemy.
		 */
		context(attrs: IAttributeContainer)
		open var dropHealthPackOnKill: Boolean? 
			get() = PlayerAttributes.dropHealthPackOnKill.get()
			set(value) { PlayerAttributes.dropHealthPackOnKill.set(value) }
	
		/**
		 * In-Game: "On Kill: Burst into joyous laughter"
		 * 
		 * On killing an enemy, schadenfreude.
		 */
		context(attrs: IAttributeContainer)
		open var killForcesAttackerToLaugh: Boolean? 
			get() = PlayerAttributes.killForcesAttackerToLaugh.get()
			set(value) { PlayerAttributes.killForcesAttackerToLaugh.set(value) }
	
		/**
		 * In-Game: "N% damage penalty"
		 * 
		 * More like a boolean.  Doesn't actually determine any kind of decapitation, just if it CAN decapitate.
		 * 
		 * Checked on all hitscan attacks, including melee swings.
		 */
		context(attrs: IAttributeContainer)
		open var decapitateType: Int? 
			get() = PlayerAttributes.decapitateType.get()
			set(value) { PlayerAttributes.decapitateType.set(value) }
	
		/**
		 * In-Game: "+N% cloak on kill"
		 * 
		 * Value: amount of cloak gained on kill.
		 * 
		 * Only works on Spy.
		 */
		context(attrs: IAttributeContainer)
		open var addCloakOnKill: Int? 
			get() = PlayerAttributes.addCloakOnKill.get()
			set(value) { PlayerAttributes.addCloakOnKill.set(value) }
	}
	
	open class ResistanceAttributes : BaseEntityAttributes.ResistanceAttributes() {
		companion object : IBlockScoped {
			val dmgTakenFromCritReduced: DmgTakenFromCritReducedAttributes = DmgTakenFromCritReducedAttributes()
	
			val dmgTakenFromFireReduced: DmgTakenFromFireReducedAttributes = DmgTakenFromFireReducedAttributes()
	
			val dmgTakenFromBulletsReduced: DmgTakenFromBulletsReducedAttributes = DmgTakenFromBulletsReducedAttributes()
	
			val vaccinator: VaccinatorAttributes = VaccinatorAttributes()
		}
	
		/**
		 * Bonus:
		 * 
		 * 	- In-Game: "+N% explosive damage resistance on wearer"
		 * 
		 * Penalty:
		 * 
		 * 	- In-Game: "N% explosive damage vulnerability on wearer"
		 */
		context(attrs: IAttributeContainer)
		open var dmgTakenFromBlast: Number? 
			get() = PlayerAttributes.dmgTakenFromBlast.get()
			set(value) { PlayerAttributes.dmgTakenFromBlast.set(value) }
	
		/**
		 * In-Game: "N% damage vulnerability on wearer"
		 * 
		 * Multiplier to damage taken from all sources.
		 */
		context(attrs: IAttributeContainer)
		open var dmgTakenIncreased: Number? 
			get() = PlayerAttributes.dmgTakenIncreased.get()
			set(value) { PlayerAttributes.dmgTakenIncreased.set(value) }
	
		/**
		 * In-Game: "+N% sentry damage resistance on wearer"
		 */
		context(attrs: IAttributeContainer)
		open var setBonusDmgFromSentryReduced: Number? 
			get() = PlayerAttributes.setBonusDmgFromSentryReduced.get()
			set(value) { PlayerAttributes.setBonusDmgFromSentryReduced.set(value) }
	
		context(attrs: IAttributeContainer)
		open var rocketJumpDamageReduction: Number? 
			get() = PlayerAttributes.rocketJumpDamageReduction.get()
			set(value) { PlayerAttributes.rocketJumpDamageReduction.set(value) }
	
		/**
		 * In-Game: "Wearer never takes falling damage"
		 */
		context(attrs: IAttributeContainer)
		open var cancelFallingDamage: Boolean? 
			get() = PlayerAttributes.cancelFallingDamage.get()
			set(value) { PlayerAttributes.cancelFallingDamage.set(value) }
	
		/**
		 * In-Game: "N% damage resistance when below 50% health and spun up"
		 * 
		 * Only procs on Heavies that are currently spun up on less than 50% HP.
		 */
		context(attrs: IAttributeContainer)
		open var spunupDamageResistance: Number? 
			get() = PlayerAttributes.spunupDamageResistance.get()
			set(value) { PlayerAttributes.spunupDamageResistance.set(value) }
	
		open val dmgTakenFromCritReduced: DmgTakenFromCritReducedAttributes = DmgTakenFromCritReducedAttributes()
	
		open val dmgTakenFromFireReduced: DmgTakenFromFireReducedAttributes = DmgTakenFromFireReducedAttributes()
	
		open val dmgTakenFromBulletsReduced: DmgTakenFromBulletsReducedAttributes = DmgTakenFromBulletsReducedAttributes()
	
		open val vaccinator: VaccinatorAttributes = VaccinatorAttributes()
	
		open class DmgTakenFromCritReducedAttributes : IBlockScoped {
			companion object : IBlockScoped 
	
			/**
			 * In-Game: "+N% critical hit damage resistance on wearer"
			 */
			context(attrs: IAttributeContainer)
			open var dmgTakenFromCritReduced: Number? 
				get() = PlayerAttributes.dmgTakenFromCritReduced.get()
				set(value) { PlayerAttributes.dmgTakenFromCritReduced.set(value) }
	
			/**
			 * In-Game: "N% critical hit damage vulnerability on wearer"
			 */
			context(attrs: IAttributeContainer)
			open var dmgTakenFromCritIncreased: Number? 
				get() = PlayerAttributes.dmgTakenFromCritIncreased.get()
				set(value) { PlayerAttributes.dmgTakenFromCritIncreased.set(value) }
	
			/**
			 * In-Game: "+N% critical hit damage resistance on wearer"
			 */
			context(attrs: IAttributeContainer)
			open var setBonusDmgTakenFromCritReducedSetBonus: Number? 
				get() = PlayerAttributes.setBonusDmgTakenFromCritReducedSetBonus.get()
				set(value) { PlayerAttributes.setBonusDmgTakenFromCritReducedSetBonus.set(value) }
		}
	
		open class DmgTakenFromFireReducedAttributes : IBlockScoped {
			companion object : IBlockScoped 
	
			/**
			 * In-Game: "+N% fire damage resistance on wearer"
			 */
			context(attrs: IAttributeContainer)
			open var dmgTakenFromFireReduced: Number? 
				get() = PlayerAttributes.dmgTakenFromFireReduced.get()
				set(value) { PlayerAttributes.dmgTakenFromFireReduced.set(value) }
	
			/**
			 * In-Game: "N% fire damage vulnerability on wearer"
			 */
			context(attrs: IAttributeContainer)
			open var dmgTakenFromFireIncreased: Number? 
				get() = PlayerAttributes.dmgTakenFromFireIncreased.get()
				set(value) { PlayerAttributes.dmgTakenFromFireIncreased.set(value) }
	
			/**
			 * In-Game: "+N% fire damage resistance on wearer"
			 */
			context(attrs: IAttributeContainer)
			open var setBonusDmgTakenFromFireReducedSetBonus: Number? 
				get() = PlayerAttributes.setBonusDmgTakenFromFireReducedSetBonus.get()
				set(value) { PlayerAttributes.setBonusDmgTakenFromFireReducedSetBonus.set(value) }
		}
	
		open class DmgTakenFromBulletsReducedAttributes : IBlockScoped {
			companion object : IBlockScoped 
	
			/**
			 * In-Game: "+N% bullet damage resistance on wearer"
			 */
			context(attrs: IAttributeContainer)
			open var dmgTakenFromBulletsReduced: Number? 
				get() = PlayerAttributes.dmgTakenFromBulletsReduced.get()
				set(value) { PlayerAttributes.dmgTakenFromBulletsReduced.set(value) }
	
			/**
			 * In-Game: "N% bullet damage vulnerability on wearer"
			 */
			context(attrs: IAttributeContainer)
			open var dmgTakenFromBulletsIncreased: Number? 
				get() = PlayerAttributes.dmgTakenFromBulletsIncreased.get()
				set(value) { PlayerAttributes.dmgTakenFromBulletsIncreased.set(value) }
	
			/**
			 * In-Game: "N% bullet damage vulnerability on wearer"
			 */
			context(attrs: IAttributeContainer)
			open var setBonusDmgTakenFromBulletsIncreased: Number? 
				get() = PlayerAttributes.setBonusDmgTakenFromBulletsIncreased.get()
				set(value) { PlayerAttributes.setBonusDmgTakenFromBulletsIncreased.set(value) }
	
			/**
			 * In-Game: "+N% bullet damage resistance on wearer"
			 */
			context(attrs: IAttributeContainer)
			open var cardDmgTakenFromBulletsReduced: Number? 
				get() = PlayerAttributes.cardDmgTakenFromBulletsReduced.get()
				set(value) { PlayerAttributes.cardDmgTakenFromBulletsReduced.set(value) }
		}
	
		open class VaccinatorAttributes : IBlockScoped {
			companion object : IBlockScoped 
	
			/**
			 * Multiplier to damage taken if player has TF_COND_MEDIGUN_UBER_BULLET_RESIST.
			 */
			context(attrs: IAttributeContainer)
			open var medigunBulletResistDeployed: Number? 
				get() = PlayerAttributes.medigunBulletResistDeployed.get()
				set(value) { PlayerAttributes.medigunBulletResistDeployed.set(value) }
	
			/**
			 * Multiplier to damage taken if player has TF_COND_MEDIGUN_SMALL_BULLET_RESIST.
			 */
			context(attrs: IAttributeContainer)
			open var medigunBulletResistPassive: Number? 
				get() = PlayerAttributes.medigunBulletResistPassive.get()
				set(value) { PlayerAttributes.medigunBulletResistPassive.set(value) }
	
			/**
			 * Multiplier to damage taken if player has TF_COND_MEDIGUN_UBER_BLAST_RESIST.
			 */
			context(attrs: IAttributeContainer)
			open var medigunBlastResistDeployed: Number? 
				get() = PlayerAttributes.medigunBlastResistDeployed.get()
				set(value) { PlayerAttributes.medigunBlastResistDeployed.set(value) }
	
			/**
			 * Multiplier to damage taken if player has TF_COND_MEDIGUN_SMALL_BLAST_RESIST.
			 */
			context(attrs: IAttributeContainer)
			open var medigunBlastResistPassive: Number? 
				get() = PlayerAttributes.medigunBlastResistPassive.get()
				set(value) { PlayerAttributes.medigunBlastResistPassive.set(value) }
	
			/**
			 * Multiplier to damage taken if player has TF_COND_MEDIGUN_UBER_FIRE_RESIST.
			 */
			context(attrs: IAttributeContainer)
			open var medigunFireResistDeployed: Number? 
				get() = PlayerAttributes.medigunFireResistDeployed.get()
				set(value) { PlayerAttributes.medigunFireResistDeployed.set(value) }
	
			/**
			 * Multiplier to damage taken if player has TF_COND_MEDIGUN_SMALL_FIRE_RESIST.
			 */
			context(attrs: IAttributeContainer)
			open var medigunFireResistPassive: Number? 
				get() = PlayerAttributes.medigunFireResistPassive.get()
				set(value) { PlayerAttributes.medigunFireResistPassive.set(value) }
		}
	}
	
	open class TauntingAttributes : IBlockScoped {
		companion object : IBlockScoped 
	
		/**
		 * In-Game: "+N% faster taunt speed on wearer"
		 * 
		 * Multiplier applied to taunt speed.
		 */
		context(attrs: IAttributeContainer)
		open var gestureSpeedIncrease: Number? 
			get() = PlayerAttributes.gestureSpeedIncrease.get()
			set(value) { PlayerAttributes.gestureSpeedIncrease.set(value) }
	
		/**
		 * Sound to be played when performing a taunt.
		 */
		context(attrs: IAttributeContainer)
		open var cosmeticTauntSound: String? 
			get() = PlayerAttributes.cosmeticTauntSound.get()
			set(value) { PlayerAttributes.cosmeticTauntSound.set(value) }
	
		/**
		 * In-Game: "Extra effects when taunting."
		 * 
		 * Use Saharan Spy particle effect when performing a stock knife taunt.  Only works on Spy.
		 */
		context(attrs: IAttributeContainer)
		open var setBonusCustomTauntParticleAttr: Boolean? 
			get() = PlayerAttributes.setBonusCustomTauntParticleAttr.get()
			set(value) { PlayerAttributes.setBonusCustomTauntParticleAttr.set(value) }
	}
	
	open class SwapWeaponsAttributes : IBlockScoped {
		companion object : IBlockScoped 
	
		context(attrs: IAttributeContainer)
		open var disableWeaponSwitch: Boolean? 
			get() = PlayerAttributes.disableWeaponSwitch.get()
			set(value) { PlayerAttributes.disableWeaponSwitch.set(value) }
	}
	
	open class WhenHitAttributes : IBlockScoped {
		companion object : IBlockScoped 
	
		/**
		 * Number of seconds the player who hit this entity should be marked for death.
		 * 
		 * If attacker is affected by `TF_COND_ENERGY_BUFF` (Crit-a-Cola, Cleaner's Carbine, Buffalo Steak, etc.), the attacker receives `TF_COND_MARKEDFORDEATH_SILENT`.
		 */
		context(attrs: IAttributeContainer)
		open var markAttackerForDeath: Number? 
			get() = PlayerAttributes.markAttackerForDeath.get()
			set(value) { PlayerAttributes.markAttackerForDeath.set(value) }
	
		/**
		 * In-Game: "When backstabbed: Jarate attacker"
		 * 
		 * If true, jarates anyone who backstabs this player.
		 * 
		 * Note: does not block backstabs on its own.
		 */
		context(attrs: IAttributeContainer)
		open var jarateBackstabber: Boolean? 
			get() = PlayerAttributes.jarateBackstabber.get()
			set(value) { PlayerAttributes.jarateBackstabber.set(value) }
	}
	
	open class SpyOnlyAttributes : IBlockScoped {
		companion object : IBlockScoped 
	}
	
	open class CritsAttributes : BaseEntityAttributes.CritsAttributes() 
}