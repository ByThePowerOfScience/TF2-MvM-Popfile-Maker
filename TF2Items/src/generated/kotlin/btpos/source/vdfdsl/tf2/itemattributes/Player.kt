package btpos.source.vdfdsl.tf2.itemattributes

import btpos.source.vdfdsl.modeling.*
import btpos.source.vdfdsl.serialization.codecs.*
import btpos.source.vdfdsl.tf2.itemattributes.impl.*
import btpos.source.vdfdsl.tf2.tftypes.*
import java.util.*




interface PlayerAttributes : IBlockScoped {
	companion object {
		/**
		 * 
		 */
		val vaccinator = VaccinatorAttributes()
		
		/**
		 * In-Game: "Allows you to see enemy health"
		 *
		 * 
		 */
		val seeEnemyHealth = ItemAttributeNamed<Boolean>("mod see enemy health")
		
		/**
		 * In-Game: "Unable to see enemy health"
		 *
		 * 
		 *
		 * Always true in MvM.
		 */
		val hideEnemyHealth = ItemAttributeNamed<Boolean>("hide enemy health")
		
		/**
		 * In-Game: "+N% greater jump height when active"
		 *
		 * 
		 */
		val increasedJumpHeight = ItemAttributeNamed<Float>("increased jump height")
		
		/**
		 * 
		 */
		val majorIncreasedJumpHeight = ItemAttributeNamed<Float>("major increased jump height")
		
		/**
		 * 
		 */
		val halloweenIncreasedJumpHeight = ItemAttributeNamed<Float>("halloween increased jump height")
		
		/**
		 * In-Game: "Boost reduced on air jumps"
		 *
		 * 
		 *
		 * The amount to be subtracted from the hype meter when the Scout double-jumps.
		 */
		val hypeResetsOnJump = ItemAttributeNamed<Int>("hype resets on jump")
		
		/**
		 * 
		 *
		 * Allows the parachute to be deployed.
		 */
		val parachuteAttribute = ItemAttributeNamed<Boolean>("parachute attribute")
		
		/**
		 * In-Game: "N% increased air control."
		 *
		 * 
		 *
		 * Sidenote: the jetpack always multiplies your air acceleration by 50%.
		 */
		val increasedAirControl = ItemAttributeNamed<Float>("increased air control")
		
		/**
		 * In-Game: "N% increased air control when blast jumping."
		 *
		 * 
		 *
		 * Specifically while blast-jumping, as opposed to global.
		 */
		val airControlBlastJump = ItemAttributeNamed<Float>("mod_air_control_blast_jump")
		
		/**
		 * In-Game: "Share Canteens with your heal target. +1 duration, -10 price per point (minimum cost: 5)"
		 *
		 * 
		 *
		 * Discounts canteens by 10 * level.
		 */
		val canteenSpecialist = ItemAttributeNamed<Int>("canteen specialist")
		
		/**
		 * In-Game: "Increased Melee damage against Isolated Merc Set"
		 *
		 * 
		 */
		val setBonusAlienIsolationXenoBonusPos = ItemAttributeNamed<Boolean>("SET BONUS: alien isolation xeno bonus pos")
		
		/**
		 * In-Game: "Increased Nostromo Napalmer damage against Isolationist Pack Set"
		 *
		 * 
		 */
		val setBonusAlienIsolationMercBonusPos = ItemAttributeNamed<Boolean>("SET BONUS: alien isolation merc bonus pos")
		
		/**
		 * In-Game: "When backstabbed: Jarate attacker"
		 *
		 * 
		 *
		 * If true, jarates anyone who backstabs this player.
		 *
		 * Note: does not block backstabs on its own.
		 */
		val jarateBackstabber = ItemAttributeNamed<Boolean>("jarate backstabber")
		
		/**
		 * In-Game: "Immune to fire damage while disguised"
		 *
		 * 
		 *
		 * Prevent afterburn while disguised.
		 */
		val disguiseNoBurn = ItemAttributeNamed<Boolean>("disguise no burn")
		
		/**
		 * Bonus:
		 *
		 * 	- In-Game: "+N% critical hit damage resistance on wearer"
		 *
		 * 
		 *
		 * Penalty:
		 *
		 * 	- In-Game: "N% critical hit damage vulnerability on wearer"
		 *
		 * 
		 */
		val dmgTakenFromCrit = BonusPenalty(
			ItemAttributeNamed<Float>("dmg taken from crit reduced"),
			ItemAttributeNamed<Float>("dmg taken from crit increased")
		)
		
		/**
		 * Bonus:
		 *
		 * 	- In-Game: "+N% fire damage resistance on wearer"
		 *
		 * 
		 *
		 * Penalty:
		 *
		 * 	- In-Game: "N% fire damage vulnerability on wearer"
		 *
		 * 
		 */
		val dmgTakenFromFire = BonusPenalty(
			ItemAttributeNamed<Float>("dmg taken from fire reduced"),
			ItemAttributeNamed<Float>("dmg taken from fire increased")
		)
		
		/**
		 * Bonus:
		 *
		 * 	- In-Game: "+N% explosive damage resistance on wearer"
		 *
		 * 
		 *
		 * Penalty:
		 *
		 * 	- In-Game: "N% explosive damage vulnerability on wearer"
		 *
		 * 
		 */
		val dmgTakenFromBlast = BonusPenalty(
			ItemAttributeNamed<Float>("dmg taken from blast reduced"),
			ItemAttributeNamed<Float>("dmg taken from blast increased")
		)
		
		/**
		 * Bonus:
		 *
		 * 	- In-Game: "+N% bullet damage resistance on wearer"
		 *
		 * 
		 *
		 * Penalty:
		 *
		 * 	- In-Game: "N% bullet damage vulnerability on wearer"
		 *
		 * 
		 */
		val dmgTakenFromBullets = BonusPenalty(
			ItemAttributeNamed<Float>("dmg taken from bullets reduced"),
			ItemAttributeNamed<Float>("dmg taken from bullets increased")
		)
		
		/**
		 * In-Game: "N% damage resistance when below 50% health and spun up"
		 *
		 * 
		 *
		 * Only procs on Heavies that are currently spun up on less than 50% HP.
		 */
		val spunupDamageResistance = ItemAttributeNamed<Float>("spunup_damage_resistance")
		
		/**
		 * In-Game: "N% damage vulnerability on wearer"
		 *
		 * 
		 *
		 * Multiplier to damage taken from all sources.
		 */
		val dmgTakenIncreased = ItemAttributeNamed<Float>("dmg taken increased")
		
		/**
		 * In-Game: "+N% sentry damage resistance on wearer"
		 *
		 * 
		 */
		val setBonusDmgFromSentryReduced = ItemAttributeNamed<Float>("SET BONUS: dmg from sentry reduced")
		
		/**
		 * In-Game: "N% blast damage from rocket jumps"
		 *
		 * 
		 *
		 * Multiplier applied to damage taken IF: it's blast damage or a flare explosion, the damage was caused by the user (self-damage), the user did not damage other players, and it is not a taunt-kill grenade (Escape Plan, Equalizer).
		 */
		val rocketJumpDamageReduction = ItemAttributeNamed<Float>("rocket jump damage reduction")
		
		/**
		 * In-Game: "N% blast damage from rocket jumps"
		 *
		 * 
		 *
		 * Multiplier applied to damage taken IF: it's blast damage or a flare explosion, the damage was caused by the user (self-damage), the user did not damage other players, and it is not a taunt-kill grenade (Escape Plan, Equalizer).
		 */
		val rocketJumpDamageReductionHidden = ItemAttributeNamed<Float>("rocket jump damage reduction HIDDEN")
		
		/**
		 * In-Game: "Wearer never takes falling damage"
		 *
		 * 
		 */
		val cancelFallingDamage = ItemAttributeNamed<Boolean>("cancel falling damage")
		
		/**
		 * 
		 *
		 * Number of seconds the player who hit this entity should be marked for death.
		 *
		 * If attacker is affected by `TF_COND_ENERGY_BUFF` (Crit-a-Cola, Cleaner's Carbine, Buffalo Steak, etc.), the attacker receives `TF_COND_MARKEDFORDEATH_SILENT`.
		 */
		val markAttackerForDeath = ItemAttributeNamed<Float>("mod_mark_attacker_for_death")
		
		/**
		 * In-Game: "Generate Rage by dealing damage.  When fully charged, press the Special-Attack key to activate knockback"
		 *
		 * 
		 *
		 * Only procs on Heavies, multiplies damage by 50% while rage is draining.
		 */
		val generateRageOnDamage = ItemAttributeNamed<Boolean>("generate rage on damage")
		
		/**
		 * In-Game: "Generate building rescue energy on damage"
		 *
		 * 
		 *
		 * Only procs on Heavies, multiplies damage by 50% while rage is draining.
		 */
		val engineerRageOnDmg = ItemAttributeNamed<Boolean>("engineer rage on dmg")
		
		/**
		 * In-Game: "On Hit: Builds Hype"
		 *
		 * 
		 *
		 * Adds the amount of damage dealt to the Scout hype meter, to a maximum of 200 damage which adds 50% meter.
		 */
		val hypeOnDamage = ItemAttributeNamed<Boolean>("hype on damage")
		
		/**
		 * 
		 *
		 * Only procs on Sniper. Gain this amount of rage meter on assists.
		 */
		val rageOnAssists = ItemAttributeNamed<Float>("rage on assists")
		
		/**
		 * In-Game: "Killstreaks Active"
		 *
		 * 
		 */
		val killstreakTier = ItemAttributeNamed<Int>("killstreak tier")
		
		/**
		 * In-Game: "+N capture rate on wearer"
		 *
		 * 
		 */
		val increasePlayerCaptureValue = ItemAttributeNamed<Int>("increase player capture value")
		
		/**
		 * 
		 *
		 * If 1, create a soccer ball on the ground when the player spawns.
		 */
		val spawnWithPhysicsToy = ItemAttributeNamed<Int>("spawn with physics toy")
		
		/**
		 * 
		 *
		 * If `mult_item_meter_charge_rate` is set, checks this attribute to see what type of meter should be modified, and also only allows it to activate if the active weapon is not a TF_WEAPON_FLAME_BALL.
		 */
		val itemMeterChargeType = ItemAttributeNamed<Int>("item_meter_charge_type")
		
		/**
		 * Bonus:
		 *
		 * 	- In-Game: "+N% health from healers on wearer"
		 *
		 * 
		 *
		 * Penalty:
		 *
		 * 	- In-Game: "N% health from healers on wearer"
		 *
		 * 
		 */
		val healthFromHealersReduced = BonusPenalty(
			ItemAttributeNamed<Float>("health from healers increased"),
			ItemAttributeNamed<Float>("health from healers reduced")
		)
		
		/**
		 * In-Game: "N sec longer cloak blink time"
		 *
		 * 
		 *
		 * Multiplier.
		 */
		val setBonusCloakBlinkTimePenalty = ItemAttributeNamed<Float>("SET BONUS: cloak blink time penalty")
		
		/**
		 * In-Game: "+N% increase in turning control while charging"
		 *
		 * 
		 *
		 * Default is 0.45f, and this class is a multiplier applied to it.
		 */
		val multChargeTurnControl = ItemAttributeNamed<Float>("mult charge turn control")
		
		/**
		 * In-Game: "Full turning control while charging"
		 *
		 * 
		 *
		 * Default is 0.45f, and this class is a multiplier applied to it.
		 */
		val fullChargeTurnControl = ItemAttributeNamed<Float>("full charge turn control")
		
		/**
		 * In-Game: "Taking damage while shield charging reduces remaining charging time"
		 *
		 * 
		 *
		 * Used to detect the Tide Turner when deciding whether to give you minicrits or crits.
		 */
		val loseDemoChargeOnDamageWhenCharging = ItemAttributeNamed<Boolean>("lose demo charge on damage when charging")
		
		/**
		 * In-Game: "N sec increase in time to cloak"
		 *
		 * 
		 */
		val multCloakRate = ItemAttributeNamed<Float>("mult cloak rate")
		
		/**
		 * In-Game: "Reduced decloak sound volume"
		 *
		 * 
		 *
		 * If true, plays `Player.Spy_UnCloakReduced` when decloaking.
		 */
		val setBonusQuietUnstealth = ItemAttributeNamed<Boolean>("SET BONUS: quiet unstealth")
		
		/**
		 * In-Game: "Deals 3x falling damage to the player you land on"
		 *
		 * 
		 *
		 * Deal 3x falling damage to player you land on.
		 */
		val bootsFallingStomp = ItemAttributeNamed<Boolean>("boots falling stomp")
		
		/**
		 * 
		 */
		val multDecloakRate = ItemAttributeNamed<Float>("mult decloak rate")
		
		/**
		 * In-Game: "Über duration increased N seconds"
		 *
		 * 
		 *
		 * Duration in seconds.
		 */
		val uberDurationBonus = ItemAttributeNamed<Float>("uber duration bonus")
		
		/**
		 * Bonus:
		 *
		 * 	- In-Game: "+N% faster move speed while deployed"
		 *
		 * 
		 *
		 * Penalty:
		 *
		 * 	- In-Game: "N% slower move speed while deployed"
		 *
		 * 
		 *
		 * Only applies to players that have TF_COND_AIMING.
		 *
		 * If Heavy, default aiming movespeed is 110.
		 *
		 * Else if player is using a compound bow, 160.
		 *
		 * Else 80.
		 */
		val aimingMovespeed = BonusPenalty(
			ItemAttributeNamed<Float>("aiming movespeed increased"),
			ItemAttributeNamed<Float>("aiming movespeed decreased")
		)
		
		/**
		 * Bonus:
		 *
		 * 	- In-Game: "+N% faster move speed on wearer"
		 *
		 * 
		 *
		 * Penalty:
		 *
		 * 	- In-Game: "N% slower move speed on wearer"
		 *
		 * 
		 */
		val moveSpeed = BonusPenalty(
			ItemAttributeNamed<Float>("move speed bonus"),
			ItemAttributeNamed<Float>("move speed penalty")
		)
		
		/**
		 * In-Game: "+N% faster move speed on wearer (shield required)"
		 *
		 * 
		 */
		val moveSpeedBonusShieldRequired = ItemAttributeNamed<Float>("move speed bonus shield required")
		
		/**
		 * In-Game: "Wearer cannot carry the intelligence briefcase or PASS Time JACK"
		 *
		 * 
		 */
		val cannotPickUpIntelligence = ItemAttributeNamed<Boolean>("cannot pick up intelligence")
		
		/**
		 * In-Game: "Build +N additional disposable-sentry"
		 *
		 * 
		 *
		 * Number of disposable sentries you're allowed to build.
		 *
		 * Checked when checking if the player can build something.
		 *
		 * Only works if the "uses upgrades" gamerule is set.
		 */
		val engyDisposableSentries = ItemAttributeNamed<Int>("engy disposable sentries")
		
		/**
		 * In-Game: "N% metal cost when constructing or upgrading teleporters"
		 *
		 * 
		 *
		 * Multiplier applied to teleporter build cost.
		 */
		val teleporterCost = ItemAttributeNamed<Float>("mod teleporter cost")
		
		/**
		 * In-Game: "N metal reduction in building cost"
		 *
		 * 
		 *
		 * Overrides the building cost for all buildings.
		 */
		val buildingCostReduction = ItemAttributeNamed<Int>("building cost reduction")
		
		/**
		 * 
		 */
		val overrideFootstepSoundSet = ItemAttributeNamed<FootstepOverride>("override footstep sound set")
		
		/**
		 * In-Game: "Jingle all the way"
		 *
		 * 
		 *
		 * If 1, use xmas.jingle, if 2 or higher use xmas.jingle_higher.
		 */
		val addJingleToFootsteps = ItemAttributeNamed<Int>("add jingle to footsteps")
		
		/**
		 * In-Game: "N"
		 *
		 * 
		 *
		 * Decimal version of the 4-byte hex code determining color of footsteps (e.g. `0xFFFFFFFF`, but in decimal).
		 */
		val spellSetHalloweenFootstepType = ItemAttributeNamed<Int>("SPELL: set Halloween footstep type")
		
		/**
		 * 
		 *
		 * Prevents player from attacking.
		 */
		val noAttack = ItemAttributeNamed<Boolean>("no_attack")
		
		/**
		 * 
		 *
		 * Prevents player from jumping.
		 */
		val noJump = ItemAttributeNamed<Boolean>("no_jump")
		
		/**
		 * 
		 *
		 * Prevents player from crouching.
		 */
		val noDuck = ItemAttributeNamed<Boolean>("no_duck")
		
		/**
		 * In-Game: "Cannot carry buildings"
		 *
		 * 
		 *
		 * Prevents player from picking up buildings.
		 */
		val cannotPickUpBuildings = ItemAttributeNamed<Boolean>("cannot pick up buildings")
		
		/**
		 * 
		 */
		val disableWeaponSwitch = ItemAttributeNamed<Boolean>("disable weapon switch")
		
		/**
		 * In-Game: "Wearer cannot disguise"
		 *
		 * 
		 */
		val cannotDisguise = ItemAttributeNamed<Boolean>("cannot disguise")
		
		/**
		 * Bonus:
		 *
		 * 	- Visible:
		 *
		 * 		- In-Game: "+N% max primary ammo on wearer"
		 *
		 * 	- Hidden:
		 *
		 * 
		 *
		 * Penalty:
		 *
		 * 	- In-Game: "N% max primary ammo on wearer"
		 *
		 * 
		 */
		val maxammoPrimaryReduced = BonusPenalty(
			VisHidden("ItemAttributeNamed<Int>("maxammo primary increased")", "ItemAttributeNamed<Int>("hidden primary max ammo bonus")"),
			ItemAttributeNamed<Int>("maxammo primary reduced")
		)
		
		/**
		 * 
		 */
		val secondaryMaxAmmo = SecondaryMaxAmmoAttributes()
		
		/**
		 * Bonus:
		 *
		 * 	- In-Game: "+N% max metal on wearer"
		 *
		 * 
		 *
		 * Penalty:
		 *
		 * 	- In-Game: "N% max metal on wearer"
		 *
		 * 
		 */
		val maxammoMetalReduced = BonusPenalty(
			ItemAttributeNamed<Int>("maxammo metal increased"),
			ItemAttributeNamed<Int>("maxammo metal reduced")
		)
		
		/**
		 * In-Game: "+N% max misc ammo on wearer"
		 *
		 * 
		 *
		 * Only used for bat balls.
		 */
		val maxammoGrenades1Increased = ItemAttributeNamed<Int>("maxammo grenades1 increased")
		
		/**
		 * 
		 *
		 * Note that Phlogistinator's rage has a small cooldown after expiring before it can gain rage again, to prevent the lingering crit flames from immediately filling it up again.
		 */
		val soldierBuffType = ItemAttributeNamed<TFBuffType>("mod soldier buff type")
		
		/**
		 * 
		 *
		 * Note that Phlogistinator's rage has a small cooldown after expiring before it can gain rage again, to prevent the lingering crit flames from immediately filling it up again.
		 */
		val demoBuffType = ItemAttributeNamed<TFBuffType>("mod demo buff type")
		
		/**
		 * In-Game: "+N% buff duration"
		 *
		 * 
		 *
		 * Multiplier applied to buff duration.
		 */
		val increaseBuffDuration = ItemAttributeNamed<Float>("increase buff duration")
		
		/**
		 * In-Game: "+N% buff duration"
		 *
		 * 
		 *
		 * Multiplier applied to buff duration.
		 */
		val increaseBuffDurationHidden = ItemAttributeNamed<Float>("increase buff duration HIDDEN")
		
		/**
		 * In-Game: "Blocks healing while in use"
		 *
		 * 
		 */
		val weaponBlocksHealing = ItemAttributeNamed<Boolean>("mod weapon blocks healing")
		
		/**
		 * Bonus:
		 *
		 * 	- In-Game: "+N health regenerated per second on wearer"
		 *
		 * 
		 *
		 * Penalty:
		 *
		 * 	- In-Game: "N health drained per second on wearer"
		 *
		 * 
		 *
		 * Amount of health regenerated per regen tick.  Scales by the amount of time since the player last took damage in non-MvM modes.
		 */
		val healthDrain = BonusPenalty(
			ItemAttributeNamed<Float>("health regen"),
			ItemAttributeNamed<Float>("health drain")
		)
		
		/**
		 * In-Game: "+N% ammo regenerated every 5 seconds on wearer"
		 *
		 * 
		 *
		 * Percentage of ammo regenerated every 5 seconds.
		 */
		val ammoRegen = ItemAttributeNamed<Float>("ammo regen")
		
		/**
		 * In-Game: "+N metal regenerated every 5 seconds on wearer"
		 *
		 * 
		 *
		 * Amount of metal regenerated every 5 seconds.
		 */
		val metalRegen = ItemAttributeNamed<Int>("metal regen")
		
		/**
		 * Bonus:
		 *
		 * 	- In-Game: "N% reduction in airblast vulnerability"
		 *
		 * 
		 *
		 * Penalty:
		 *
		 * 	- In-Game: "N% reduction in airblast vulnerability"
		 *
		 * 
		 */
		val airblastVulnerabilityMultiplier = BonusPenalty(
			ItemAttributeNamed<Float>("airblast vulnerability multiplier"),
			ItemAttributeNamed<Float>("airblast vulnerability multiplier hidden")
		)
		
		/**
		 * 
		 */
		val airblastVerticalVulnerabilityMultiplier = ItemAttributeNamed<Float>("airblast vertical vulnerability multiplier")
		
		/**
		 * In-Game: "Noise Maker"
		 *
		 * 
		 *
		 * Uses noise maker when pressing action slot key.
		 */
		val noiseMaker = ItemAttributeNamed<Boolean>("noise maker")
		
		/**
		 * In-Game: "Leave a Calling Card on your victims."
		 *
		 * 
		 *
		 * Defines the calling card that should be dropped when this player kills another player.
		 */
		val setBonusCallingCardOnKill = ItemAttributeNamed<Int>("SET BONUS: calling card on kill")
		
		/**
		 * In-Game: "Sentry build speed increased by N%"
		 *
		 * 
		 */
		val engineerSentryBuildRateMultiplier = ItemAttributeNamed<Float>("engineer sentry build rate multiplier")
		
		/**
		 * In-Game: "Increases teleporter build speed by N%."
		 *
		 * 
		 *
		 * Also used for dispensers.
		 */
		val engineerTeleporterBuildRateMultiplier = ItemAttributeNamed<Float>("engineer teleporter build rate multiplier")
		
		/**
		 * In-Game: "Headshots deal an extra +N% damage"
		 *
		 * 
		 *
		 * Multiplier applied to headshot damage.
		 */
		val headshotDamageIncrease = ItemAttributeNamed<Float>("headshot damage increase")
		
		/**
		 * In-Game: "N% damage penalty"
		 *
		 * 
		 *
		 * More like a boolean.  Doesn't actually determine any kind of decapitation, just if it CAN decapitate.
		 *
		 * Checked on all hitscan attacks.
		 */
		val decapitateType = ItemAttributeNamed<Int>("decapitate type")
		
		/**
		 * In-Game: "Push enemies back when you land (force and radius based on velocity)"
		 *
		 * 
		 *
		 * Requires player to have the `TF_COND_ROCKETPACK` condition.
		 *
		 * Pushes back nearby players around the landing site.
		 */
		val fallingImpactRadiusPushback = ItemAttributeNamed<Boolean>("falling_impact_radius_pushback")
		
		/**
		 * In-Game: "Stun enemies when you land"
		 *
		 * 
		 *
		 * If `falling_impact_radius_pushback` is set, this will also stun any enemies in the impact radius.
		 */
		val fallingImpactRadiusStun = ItemAttributeNamed<Boolean>("falling_impact_radius_stun")
		
		/**
		 * 
		 *
		 * Multiplier applied to rage gained by dealing damage, taking damage, or dealing burn damage.
		 */
		val rageGivingScale = ItemAttributeNamed<Float>("rage giving scale")
		
		/**
		 * 
		 *
		 * If the weapon is a Holy Mackerel reskin (AKA either the fish or the Unarmed Combat) and this is set, use the Unarmed Combat "arm hit" killfeed notice instead of the "fish hit" notice.
		 */
		val fishDamageOverride = ItemAttributeNamed<Boolean>("fish damage override")
		
		/**
		 * In-Game: "Explode spectacularly on death"
		 *
		 * 
		 */
		val bombinomiconEffectOnDeath = ItemAttributeNamed<Boolean>("bombinomicon effect on death")
		
		/**
		 * In-Game: "N% less metal from pickups and dispensers"
		 *
		 * 
		 *
		 * Multiplier applied to metal gained from ammo boxes.
		 */
		val metalPickupDecreased = ItemAttributeNamed<Float>("metal_pickup_decreased")
		
		/**
		 * In-Game: "+N max health on wearer"
		 *
		 * 
		 *
		 * Additive base-health increase.
		 */
		val hiddenMaxhealthNonBuffed = ItemAttributeNamed<Int>("hidden maxhealth non buffed")
		
		/**
		 * Bonus:
		 *
		 * 	- In-Game: "+N max health on wearer"
		 *
		 * 
		 *
		 * Penalty:
		 *
		 * 	- In-Game: "N max health on wearer"
		 *
		 * 
		 *
		 * Additive maximum health increase only used when overhealing.
		 */
		val maxHealthAdditive = BonusPenalty(
			ItemAttributeNamed<int>("max health additive bonus"),
			ItemAttributeNamed<int>("max health additive penalty")
		)
		
		/**
		 * In-Game: "Unlimited use"
		 *
		 * 
		 *
		 * If true, noisemakers are unlimited usage.
		 */
		val unlimitedQuantity = ItemAttributeNamed<Boolean>("unlimited quantity")
		
		/**
		 * 
		 *
		 * If true, noisemakers are unlimited usage.
		 */
		val unlimitedQuantityHidden = ItemAttributeNamed<Boolean>("unlimited quantity hidden")
		
		/**
		 * 
		 *
		 * If true, the zombiezombiezombiezombie skin is equipped.
		 */
		val zombiezombiezombiezombie = ItemAttributeNamed<Boolean>("zombiezombiezombiezombie")
		
		/**
		 * In-Game: "+N% faster taunt speed on wearer"
		 *
		 * 
		 *
		 * Multiplier applied to taunt speed.
		 */
		val gestureSpeedIncrease = ItemAttributeNamed<Float>("gesture speed increase")
		
		/**
		 * 
		 *
		 * Sound to be played when performing a taunt.
		 */
		val cosmeticTauntSound = ItemAttributeNamed<String>("cosmetic taunt sound")
		
		/**
		 * 
		 *
		 * DSP used when emitting sounds created by this player.
		 */
		val setBonusSpecialDsp = ItemAttributeNamed<Int>("SET BONUS: special dsp")
		
		/**
		 * In-Game: "Disables double jump"
		 *
		 * 
		 */
		val headScale = ItemAttributeNamed<Float>("head scale")
		
		/**
		 * 
		 */
		val torsoScale = ItemAttributeNamed<Float>("torso scale")
		
		/**
		 * 
		 */
		val handScale = ItemAttributeNamed<Float>("hand scale")
		
		/**
		 * 
		 */
		val onDamageTaken = OnDamageTakenAttributes()
		
		/**
		 * 
		 */
		val onKill = OnKillAttributes()
		
		/**
		 * 
		 */
		val denyResupply = DenyResupplyAttributes()
		
		/**
		 * 
		 */
		val scoutOnly = ScoutOnlyAttributes()
		
		/**
		 * 
		 */
		val demomanOnly = DemomanOnlyAttributes()
		
		/**
		 * 
		 */
		val sniperOnly = SniperOnlyAttributes()
		
		/**
		 * 
		 */
		val medicOnly = MedicOnlyAttributes()
		
		/**
		 * 
		 */
		val spyOnly = SpyOnlyAttributes()
	}

	/**
	 * 
	 */
	val vaccinator: ItemAttribute<Vaccinator> get() = PlayerAttributes.vaccinator
	
	/**
	 * In-Game: "Allows you to see enemy health"
	 *
	 * 
	 */
	val seeEnemyHealth: ItemAttribute<Boolean> get() = PlayerAttributes.seeEnemyHealth
	
	/**
	 * In-Game: "Unable to see enemy health"
	 *
	 * 
	 *
	 * Always true in MvM.
	 */
	val hideEnemyHealth: ItemAttribute<Boolean> get() = PlayerAttributes.hideEnemyHealth
	
	/**
	 * In-Game: "+N% greater jump height when active"
	 *
	 * 
	 */
	val increasedJumpHeight: ItemAttribute<Float> get() = PlayerAttributes.increasedJumpHeight
	
	/**
	 * 
	 */
	val majorIncreasedJumpHeight: ItemAttribute<Float> get() = PlayerAttributes.majorIncreasedJumpHeight
	
	/**
	 * 
	 */
	val halloweenIncreasedJumpHeight: ItemAttribute<Float> get() = PlayerAttributes.halloweenIncreasedJumpHeight
	
	/**
	 * In-Game: "Boost reduced on air jumps"
	 *
	 * 
	 *
	 * The amount to be subtracted from the hype meter when the Scout double-jumps.
	 */
	val hypeResetsOnJump: ItemAttribute<Int> get() = PlayerAttributes.hypeResetsOnJump
	
	/**
	 * 
	 *
	 * Allows the parachute to be deployed.
	 */
	val parachuteAttribute: ItemAttribute<Boolean> get() = PlayerAttributes.parachuteAttribute
	
	/**
	 * In-Game: "N% increased air control."
	 *
	 * 
	 *
	 * Sidenote: the jetpack always multiplies your air acceleration by 50%.
	 */
	val increasedAirControl: ItemAttribute<Float> get() = PlayerAttributes.increasedAirControl
	
	/**
	 * In-Game: "N% increased air control when blast jumping."
	 *
	 * 
	 *
	 * Specifically while blast-jumping, as opposed to global.
	 */
	val airControlBlastJump: ItemAttribute<Float> get() = PlayerAttributes.airControlBlastJump
	
	/**
	 * In-Game: "Share Canteens with your heal target. +1 duration, -10 price per point (minimum cost: 5)"
	 *
	 * 
	 *
	 * Discounts canteens by 10 * level.
	 */
	val canteenSpecialist: ItemAttribute<Int> get() = PlayerAttributes.canteenSpecialist
	
	/**
	 * In-Game: "Increased Melee damage against Isolated Merc Set"
	 *
	 * 
	 */
	val setBonusAlienIsolationXenoBonusPos: ItemAttribute<Boolean> get() = PlayerAttributes.setBonusAlienIsolationXenoBonusPos
	
	/**
	 * In-Game: "Increased Nostromo Napalmer damage against Isolationist Pack Set"
	 *
	 * 
	 */
	val setBonusAlienIsolationMercBonusPos: ItemAttribute<Boolean> get() = PlayerAttributes.setBonusAlienIsolationMercBonusPos
	
	/**
	 * In-Game: "When backstabbed: Jarate attacker"
	 *
	 * 
	 *
	 * If true, jarates anyone who backstabs this player.
	 *
	 * Note: does not block backstabs on its own.
	 */
	val jarateBackstabber: ItemAttribute<Boolean> get() = PlayerAttributes.jarateBackstabber
	
	/**
	 * In-Game: "Immune to fire damage while disguised"
	 *
	 * 
	 *
	 * Prevent afterburn while disguised.
	 */
	val disguiseNoBurn: ItemAttribute<Boolean> get() = PlayerAttributes.disguiseNoBurn
	
	/**
	 * Bonus:
	 *
	 * 	- In-Game: "+N% critical hit damage resistance on wearer"
	 *
	 * 
	 *
	 * Penalty:
	 *
	 * 	- In-Game: "N% critical hit damage vulnerability on wearer"
	 *
	 * 
	 */
	val dmgTakenFromCrit: ItemAttribute<Float> get() = PlayerAttributes.dmgTakenFromCrit
	
	/**
	 * Bonus:
	 *
	 * 	- In-Game: "+N% fire damage resistance on wearer"
	 *
	 * 
	 *
	 * Penalty:
	 *
	 * 	- In-Game: "N% fire damage vulnerability on wearer"
	 *
	 * 
	 */
	val dmgTakenFromFire: ItemAttribute<Float> get() = PlayerAttributes.dmgTakenFromFire
	
	/**
	 * Bonus:
	 *
	 * 	- In-Game: "+N% explosive damage resistance on wearer"
	 *
	 * 
	 *
	 * Penalty:
	 *
	 * 	- In-Game: "N% explosive damage vulnerability on wearer"
	 *
	 * 
	 */
	val dmgTakenFromBlast: ItemAttribute<Float> get() = PlayerAttributes.dmgTakenFromBlast
	
	/**
	 * Bonus:
	 *
	 * 	- In-Game: "+N% bullet damage resistance on wearer"
	 *
	 * 
	 *
	 * Penalty:
	 *
	 * 	- In-Game: "N% bullet damage vulnerability on wearer"
	 *
	 * 
	 */
	val dmgTakenFromBullets: ItemAttribute<Float> get() = PlayerAttributes.dmgTakenFromBullets
	
	/**
	 * In-Game: "N% damage resistance when below 50% health and spun up"
	 *
	 * 
	 *
	 * Only procs on Heavies that are currently spun up on less than 50% HP.
	 */
	val spunupDamageResistance: ItemAttribute<Float> get() = PlayerAttributes.spunupDamageResistance
	
	/**
	 * In-Game: "N% damage vulnerability on wearer"
	 *
	 * 
	 *
	 * Multiplier to damage taken from all sources.
	 */
	val dmgTakenIncreased: ItemAttribute<Float> get() = PlayerAttributes.dmgTakenIncreased
	
	/**
	 * In-Game: "+N% sentry damage resistance on wearer"
	 *
	 * 
	 */
	val setBonusDmgFromSentryReduced: ItemAttribute<Float> get() = PlayerAttributes.setBonusDmgFromSentryReduced
	
	/**
	 * In-Game: "N% blast damage from rocket jumps"
	 *
	 * 
	 *
	 * Multiplier applied to damage taken IF: it's blast damage or a flare explosion, the damage was caused by the user (self-damage), the user did not damage other players, and it is not a taunt-kill grenade (Escape Plan, Equalizer).
	 */
	val rocketJumpDamageReduction: ItemAttribute<Float> get() = PlayerAttributes.rocketJumpDamageReduction
	
	/**
	 * In-Game: "N% blast damage from rocket jumps"
	 *
	 * 
	 *
	 * Multiplier applied to damage taken IF: it's blast damage or a flare explosion, the damage was caused by the user (self-damage), the user did not damage other players, and it is not a taunt-kill grenade (Escape Plan, Equalizer).
	 */
	val rocketJumpDamageReductionHidden: ItemAttribute<Float> get() = PlayerAttributes.rocketJumpDamageReductionHidden
	
	/**
	 * In-Game: "Wearer never takes falling damage"
	 *
	 * 
	 */
	val cancelFallingDamage: ItemAttribute<Boolean> get() = PlayerAttributes.cancelFallingDamage
	
	/**
	 * 
	 *
	 * Number of seconds the player who hit this entity should be marked for death.
	 *
	 * If attacker is affected by `TF_COND_ENERGY_BUFF` (Crit-a-Cola, Cleaner's Carbine, Buffalo Steak, etc.), the attacker receives `TF_COND_MARKEDFORDEATH_SILENT`.
	 */
	val markAttackerForDeath: ItemAttribute<Float> get() = PlayerAttributes.markAttackerForDeath
	
	/**
	 * In-Game: "Generate Rage by dealing damage.  When fully charged, press the Special-Attack key to activate knockback"
	 *
	 * 
	 *
	 * Only procs on Heavies, multiplies damage by 50% while rage is draining.
	 */
	val generateRageOnDamage: ItemAttribute<Boolean> get() = PlayerAttributes.generateRageOnDamage
	
	/**
	 * In-Game: "Generate building rescue energy on damage"
	 *
	 * 
	 *
	 * Only procs on Heavies, multiplies damage by 50% while rage is draining.
	 */
	val engineerRageOnDmg: ItemAttribute<Boolean> get() = PlayerAttributes.engineerRageOnDmg
	
	/**
	 * In-Game: "On Hit: Builds Hype"
	 *
	 * 
	 *
	 * Adds the amount of damage dealt to the Scout hype meter, to a maximum of 200 damage which adds 50% meter.
	 */
	val hypeOnDamage: ItemAttribute<Boolean> get() = PlayerAttributes.hypeOnDamage
	
	/**
	 * 
	 *
	 * Only procs on Sniper. Gain this amount of rage meter on assists.
	 */
	val rageOnAssists: ItemAttribute<Float> get() = PlayerAttributes.rageOnAssists
	
	/**
	 * In-Game: "Killstreaks Active"
	 *
	 * 
	 */
	val killstreakTier: ItemAttribute<Int> get() = PlayerAttributes.killstreakTier
	
	/**
	 * In-Game: "+N capture rate on wearer"
	 *
	 * 
	 */
	val increasePlayerCaptureValue: ItemAttribute<Int> get() = PlayerAttributes.increasePlayerCaptureValue
	
	/**
	 * 
	 *
	 * If 1, create a soccer ball on the ground when the player spawns.
	 */
	val spawnWithPhysicsToy: ItemAttribute<Int> get() = PlayerAttributes.spawnWithPhysicsToy
	
	/**
	 * 
	 *
	 * If `mult_item_meter_charge_rate` is set, checks this attribute to see what type of meter should be modified, and also only allows it to activate if the active weapon is not a TF_WEAPON_FLAME_BALL.
	 */
	val itemMeterChargeType: ItemAttribute<Int> get() = PlayerAttributes.itemMeterChargeType
	
	/**
	 * Bonus:
	 *
	 * 	- In-Game: "+N% health from healers on wearer"
	 *
	 * 
	 *
	 * Penalty:
	 *
	 * 	- In-Game: "N% health from healers on wearer"
	 *
	 * 
	 */
	val healthFromHealersReduced: ItemAttribute<Float> get() = PlayerAttributes.healthFromHealersReduced
	
	/**
	 * In-Game: "N sec longer cloak blink time"
	 *
	 * 
	 *
	 * Multiplier.
	 */
	val setBonusCloakBlinkTimePenalty: ItemAttribute<Float> get() = PlayerAttributes.setBonusCloakBlinkTimePenalty
	
	/**
	 * In-Game: "+N% increase in turning control while charging"
	 *
	 * 
	 *
	 * Default is 0.45f, and this class is a multiplier applied to it.
	 */
	val multChargeTurnControl: ItemAttribute<Float> get() = PlayerAttributes.multChargeTurnControl
	
	/**
	 * In-Game: "Full turning control while charging"
	 *
	 * 
	 *
	 * Default is 0.45f, and this class is a multiplier applied to it.
	 */
	val fullChargeTurnControl: ItemAttribute<Float> get() = PlayerAttributes.fullChargeTurnControl
	
	/**
	 * In-Game: "Taking damage while shield charging reduces remaining charging time"
	 *
	 * 
	 *
	 * Used to detect the Tide Turner when deciding whether to give you minicrits or crits.
	 */
	val loseDemoChargeOnDamageWhenCharging: ItemAttribute<Boolean> get() = PlayerAttributes.loseDemoChargeOnDamageWhenCharging
	
	/**
	 * In-Game: "N sec increase in time to cloak"
	 *
	 * 
	 */
	val multCloakRate: ItemAttribute<Float> get() = PlayerAttributes.multCloakRate
	
	/**
	 * In-Game: "Reduced decloak sound volume"
	 *
	 * 
	 *
	 * If true, plays `Player.Spy_UnCloakReduced` when decloaking.
	 */
	val setBonusQuietUnstealth: ItemAttribute<Boolean> get() = PlayerAttributes.setBonusQuietUnstealth
	
	/**
	 * In-Game: "Deals 3x falling damage to the player you land on"
	 *
	 * 
	 *
	 * Deal 3x falling damage to player you land on.
	 */
	val bootsFallingStomp: ItemAttribute<Boolean> get() = PlayerAttributes.bootsFallingStomp
	
	/**
	 * 
	 */
	val multDecloakRate: ItemAttribute<Float> get() = PlayerAttributes.multDecloakRate
	
	/**
	 * In-Game: "Über duration increased N seconds"
	 *
	 * 
	 *
	 * Duration in seconds.
	 */
	val uberDurationBonus: ItemAttribute<Float> get() = PlayerAttributes.uberDurationBonus
	
	/**
	 * Bonus:
	 *
	 * 	- In-Game: "+N% faster move speed while deployed"
	 *
	 * 
	 *
	 * Penalty:
	 *
	 * 	- In-Game: "N% slower move speed while deployed"
	 *
	 * 
	 *
	 * Only applies to players that have TF_COND_AIMING.
	 *
	 * If Heavy, default aiming movespeed is 110.
	 *
	 * Else if player is using a compound bow, 160.
	 *
	 * Else 80.
	 */
	val aimingMovespeed: ItemAttribute<Float> get() = PlayerAttributes.aimingMovespeed
	
	/**
	 * Bonus:
	 *
	 * 	- In-Game: "+N% faster move speed on wearer"
	 *
	 * 
	 *
	 * Penalty:
	 *
	 * 	- In-Game: "N% slower move speed on wearer"
	 *
	 * 
	 */
	val moveSpeed: ItemAttribute<Float> get() = PlayerAttributes.moveSpeed
	
	/**
	 * In-Game: "+N% faster move speed on wearer (shield required)"
	 *
	 * 
	 */
	val moveSpeedBonusShieldRequired: ItemAttribute<Float> get() = PlayerAttributes.moveSpeedBonusShieldRequired
	
	/**
	 * In-Game: "Wearer cannot carry the intelligence briefcase or PASS Time JACK"
	 *
	 * 
	 */
	val cannotPickUpIntelligence: ItemAttribute<Boolean> get() = PlayerAttributes.cannotPickUpIntelligence
	
	/**
	 * In-Game: "Build +N additional disposable-sentry"
	 *
	 * 
	 *
	 * Number of disposable sentries you're allowed to build.
	 *
	 * Checked when checking if the player can build something.
	 *
	 * Only works if the "uses upgrades" gamerule is set.
	 */
	val engyDisposableSentries: ItemAttribute<Int> get() = PlayerAttributes.engyDisposableSentries
	
	/**
	 * In-Game: "N% metal cost when constructing or upgrading teleporters"
	 *
	 * 
	 *
	 * Multiplier applied to teleporter build cost.
	 */
	val teleporterCost: ItemAttribute<Float> get() = PlayerAttributes.teleporterCost
	
	/**
	 * In-Game: "N metal reduction in building cost"
	 *
	 * 
	 *
	 * Overrides the building cost for all buildings.
	 */
	val buildingCostReduction: ItemAttribute<Int> get() = PlayerAttributes.buildingCostReduction
	
	/**
	 * 
	 */
	val overrideFootstepSoundSet: ItemAttribute<FootstepOverride> get() = PlayerAttributes.overrideFootstepSoundSet
	
	/**
	 * In-Game: "Jingle all the way"
	 *
	 * 
	 *
	 * If 1, use xmas.jingle, if 2 or higher use xmas.jingle_higher.
	 */
	val addJingleToFootsteps: ItemAttribute<Int> get() = PlayerAttributes.addJingleToFootsteps
	
	/**
	 * In-Game: "N"
	 *
	 * 
	 *
	 * Decimal version of the 4-byte hex code determining color of footsteps (e.g. `0xFFFFFFFF`, but in decimal).
	 */
	val spellSetHalloweenFootstepType: ItemAttribute<Int> get() = PlayerAttributes.spellSetHalloweenFootstepType
	
	/**
	 * 
	 *
	 * Prevents player from attacking.
	 */
	val noAttack: ItemAttribute<Boolean> get() = PlayerAttributes.noAttack
	
	/**
	 * 
	 *
	 * Prevents player from jumping.
	 */
	val noJump: ItemAttribute<Boolean> get() = PlayerAttributes.noJump
	
	/**
	 * 
	 *
	 * Prevents player from crouching.
	 */
	val noDuck: ItemAttribute<Boolean> get() = PlayerAttributes.noDuck
	
	/**
	 * In-Game: "Cannot carry buildings"
	 *
	 * 
	 *
	 * Prevents player from picking up buildings.
	 */
	val cannotPickUpBuildings: ItemAttribute<Boolean> get() = PlayerAttributes.cannotPickUpBuildings
	
	/**
	 * 
	 */
	val disableWeaponSwitch: ItemAttribute<Boolean> get() = PlayerAttributes.disableWeaponSwitch
	
	/**
	 * In-Game: "Wearer cannot disguise"
	 *
	 * 
	 */
	val cannotDisguise: ItemAttribute<Boolean> get() = PlayerAttributes.cannotDisguise
	
	/**
	 * Bonus:
	 *
	 * 	- Visible:
	 *
	 * 		- In-Game: "+N% max primary ammo on wearer"
	 *
	 * 	- Hidden:
	 *
	 * 
	 *
	 * Penalty:
	 *
	 * 	- In-Game: "N% max primary ammo on wearer"
	 *
	 * 
	 */
	val maxammoPrimaryReduced: ItemAttribute<Int> get() = PlayerAttributes.maxammoPrimaryReduced
	
	/**
	 * 
	 */
	val secondaryMaxAmmo: ItemAttribute<SecondaryMaxAmmo> get() = PlayerAttributes.secondaryMaxAmmo
	
	/**
	 * Bonus:
	 *
	 * 	- In-Game: "+N% max metal on wearer"
	 *
	 * 
	 *
	 * Penalty:
	 *
	 * 	- In-Game: "N% max metal on wearer"
	 *
	 * 
	 */
	val maxammoMetalReduced: ItemAttribute<Int> get() = PlayerAttributes.maxammoMetalReduced
	
	/**
	 * In-Game: "+N% max misc ammo on wearer"
	 *
	 * 
	 *
	 * Only used for bat balls.
	 */
	val maxammoGrenades1Increased: ItemAttribute<Int> get() = PlayerAttributes.maxammoGrenades1Increased
	
	/**
	 * 
	 *
	 * Note that Phlogistinator's rage has a small cooldown after expiring before it can gain rage again, to prevent the lingering crit flames from immediately filling it up again.
	 */
	val soldierBuffType: ItemAttribute<TFBuffType> get() = PlayerAttributes.soldierBuffType
	
	/**
	 * 
	 *
	 * Note that Phlogistinator's rage has a small cooldown after expiring before it can gain rage again, to prevent the lingering crit flames from immediately filling it up again.
	 */
	val demoBuffType: ItemAttribute<TFBuffType> get() = PlayerAttributes.demoBuffType
	
	/**
	 * In-Game: "+N% buff duration"
	 *
	 * 
	 *
	 * Multiplier applied to buff duration.
	 */
	val increaseBuffDuration: ItemAttribute<Float> get() = PlayerAttributes.increaseBuffDuration
	
	/**
	 * In-Game: "+N% buff duration"
	 *
	 * 
	 *
	 * Multiplier applied to buff duration.
	 */
	val increaseBuffDurationHidden: ItemAttribute<Float> get() = PlayerAttributes.increaseBuffDurationHidden
	
	/**
	 * In-Game: "Blocks healing while in use"
	 *
	 * 
	 */
	val weaponBlocksHealing: ItemAttribute<Boolean> get() = PlayerAttributes.weaponBlocksHealing
	
	/**
	 * Bonus:
	 *
	 * 	- In-Game: "+N health regenerated per second on wearer"
	 *
	 * 
	 *
	 * Penalty:
	 *
	 * 	- In-Game: "N health drained per second on wearer"
	 *
	 * 
	 *
	 * Amount of health regenerated per regen tick.  Scales by the amount of time since the player last took damage in non-MvM modes.
	 */
	val healthDrain: ItemAttribute<Float> get() = PlayerAttributes.healthDrain
	
	/**
	 * In-Game: "+N% ammo regenerated every 5 seconds on wearer"
	 *
	 * 
	 *
	 * Percentage of ammo regenerated every 5 seconds.
	 */
	val ammoRegen: ItemAttribute<Float> get() = PlayerAttributes.ammoRegen
	
	/**
	 * In-Game: "+N metal regenerated every 5 seconds on wearer"
	 *
	 * 
	 *
	 * Amount of metal regenerated every 5 seconds.
	 */
	val metalRegen: ItemAttribute<Int> get() = PlayerAttributes.metalRegen
	
	/**
	 * Bonus:
	 *
	 * 	- In-Game: "N% reduction in airblast vulnerability"
	 *
	 * 
	 *
	 * Penalty:
	 *
	 * 	- In-Game: "N% reduction in airblast vulnerability"
	 *
	 * 
	 */
	val airblastVulnerabilityMultiplier: ItemAttribute<Float> get() = PlayerAttributes.airblastVulnerabilityMultiplier
	
	/**
	 * 
	 */
	val airblastVerticalVulnerabilityMultiplier: ItemAttribute<Float> get() = PlayerAttributes.airblastVerticalVulnerabilityMultiplier
	
	/**
	 * In-Game: "Noise Maker"
	 *
	 * 
	 *
	 * Uses noise maker when pressing action slot key.
	 */
	val noiseMaker: ItemAttribute<Boolean> get() = PlayerAttributes.noiseMaker
	
	/**
	 * In-Game: "Leave a Calling Card on your victims."
	 *
	 * 
	 *
	 * Defines the calling card that should be dropped when this player kills another player.
	 */
	val setBonusCallingCardOnKill: ItemAttribute<Int> get() = PlayerAttributes.setBonusCallingCardOnKill
	
	/**
	 * In-Game: "Sentry build speed increased by N%"
	 *
	 * 
	 */
	val engineerSentryBuildRateMultiplier: ItemAttribute<Float> get() = PlayerAttributes.engineerSentryBuildRateMultiplier
	
	/**
	 * In-Game: "Increases teleporter build speed by N%."
	 *
	 * 
	 *
	 * Also used for dispensers.
	 */
	val engineerTeleporterBuildRateMultiplier: ItemAttribute<Float> get() = PlayerAttributes.engineerTeleporterBuildRateMultiplier
	
	/**
	 * In-Game: "Headshots deal an extra +N% damage"
	 *
	 * 
	 *
	 * Multiplier applied to headshot damage.
	 */
	val headshotDamageIncrease: ItemAttribute<Float> get() = PlayerAttributes.headshotDamageIncrease
	
	/**
	 * In-Game: "N% damage penalty"
	 *
	 * 
	 *
	 * More like a boolean.  Doesn't actually determine any kind of decapitation, just if it CAN decapitate.
	 *
	 * Checked on all hitscan attacks.
	 */
	val decapitateType: ItemAttribute<Int> get() = PlayerAttributes.decapitateType
	
	/**
	 * In-Game: "Push enemies back when you land (force and radius based on velocity)"
	 *
	 * 
	 *
	 * Requires player to have the `TF_COND_ROCKETPACK` condition.
	 *
	 * Pushes back nearby players around the landing site.
	 */
	val fallingImpactRadiusPushback: ItemAttribute<Boolean> get() = PlayerAttributes.fallingImpactRadiusPushback
	
	/**
	 * In-Game: "Stun enemies when you land"
	 *
	 * 
	 *
	 * If `falling_impact_radius_pushback` is set, this will also stun any enemies in the impact radius.
	 */
	val fallingImpactRadiusStun: ItemAttribute<Boolean> get() = PlayerAttributes.fallingImpactRadiusStun
	
	/**
	 * 
	 *
	 * Multiplier applied to rage gained by dealing damage, taking damage, or dealing burn damage.
	 */
	val rageGivingScale: ItemAttribute<Float> get() = PlayerAttributes.rageGivingScale
	
	/**
	 * 
	 *
	 * If the weapon is a Holy Mackerel reskin (AKA either the fish or the Unarmed Combat) and this is set, use the Unarmed Combat "arm hit" killfeed notice instead of the "fish hit" notice.
	 */
	val fishDamageOverride: ItemAttribute<Boolean> get() = PlayerAttributes.fishDamageOverride
	
	/**
	 * In-Game: "Explode spectacularly on death"
	 *
	 * 
	 */
	val bombinomiconEffectOnDeath: ItemAttribute<Boolean> get() = PlayerAttributes.bombinomiconEffectOnDeath
	
	/**
	 * In-Game: "N% less metal from pickups and dispensers"
	 *
	 * 
	 *
	 * Multiplier applied to metal gained from ammo boxes.
	 */
	val metalPickupDecreased: ItemAttribute<Float> get() = PlayerAttributes.metalPickupDecreased
	
	/**
	 * In-Game: "+N max health on wearer"
	 *
	 * 
	 *
	 * Additive base-health increase.
	 */
	val hiddenMaxhealthNonBuffed: ItemAttribute<Int> get() = PlayerAttributes.hiddenMaxhealthNonBuffed
	
	/**
	 * Bonus:
	 *
	 * 	- In-Game: "+N max health on wearer"
	 *
	 * 
	 *
	 * Penalty:
	 *
	 * 	- In-Game: "N max health on wearer"
	 *
	 * 
	 *
	 * Additive maximum health increase only used when overhealing.
	 */
	val maxHealthAdditive: ItemAttribute<int> get() = PlayerAttributes.maxHealthAdditive
	
	/**
	 * In-Game: "Unlimited use"
	 *
	 * 
	 *
	 * If true, noisemakers are unlimited usage.
	 */
	val unlimitedQuantity: ItemAttribute<Boolean> get() = PlayerAttributes.unlimitedQuantity
	
	/**
	 * 
	 *
	 * If true, noisemakers are unlimited usage.
	 */
	val unlimitedQuantityHidden: ItemAttribute<Boolean> get() = PlayerAttributes.unlimitedQuantityHidden
	
	/**
	 * 
	 *
	 * If true, the zombiezombiezombiezombie skin is equipped.
	 */
	val zombiezombiezombiezombie: ItemAttribute<Boolean> get() = PlayerAttributes.zombiezombiezombiezombie
	
	/**
	 * In-Game: "+N% faster taunt speed on wearer"
	 *
	 * 
	 *
	 * Multiplier applied to taunt speed.
	 */
	val gestureSpeedIncrease: ItemAttribute<Float> get() = PlayerAttributes.gestureSpeedIncrease
	
	/**
	 * 
	 *
	 * Sound to be played when performing a taunt.
	 */
	val cosmeticTauntSound: ItemAttribute<String> get() = PlayerAttributes.cosmeticTauntSound
	
	/**
	 * 
	 *
	 * DSP used when emitting sounds created by this player.
	 */
	val setBonusSpecialDsp: ItemAttribute<Int> get() = PlayerAttributes.setBonusSpecialDsp
	
	/**
	 * In-Game: "Disables double jump"
	 *
	 * 
	 */
	val headScale: ItemAttribute<Float> get() = PlayerAttributes.headScale
	
	/**
	 * 
	 */
	val torsoScale: ItemAttribute<Float> get() = PlayerAttributes.torsoScale
	
	/**
	 * 
	 */
	val handScale: ItemAttribute<Float> get() = PlayerAttributes.handScale
	
	/**
	 * 
	 */
	val onDamageTaken: ItemAttribute<OnDamageTaken> get() = PlayerAttributes.onDamageTaken
	
	/**
	 * 
	 */
	val onKill: ItemAttribute<OnKill> get() = PlayerAttributes.onKill
	
	/**
	 * 
	 */
	val denyResupply: ItemAttribute<DenyResupply> get() = PlayerAttributes.denyResupply
	
	/**
	 * 
	 */
	val scoutOnly: ItemAttribute<ScoutOnly> get() = PlayerAttributes.scoutOnly
	
	/**
	 * 
	 */
	val demomanOnly: ItemAttribute<DemomanOnly> get() = PlayerAttributes.demomanOnly
	
	/**
	 * 
	 */
	val sniperOnly: ItemAttribute<SniperOnly> get() = PlayerAttributes.sniperOnly
	
	/**
	 * 
	 */
	val medicOnly: ItemAttribute<MedicOnly> get() = PlayerAttributes.medicOnly
	
	/**
	 * 
	 */
	val spyOnly: ItemAttribute<SpyOnly> get() = PlayerAttributes.spyOnly

   
open class VaccinatorAttributes : IBlockScoped {
	
	open val medigunBulletResistDeployed = ItemAttributeNamed<Float>("medigun bullet resist deployed")
	
	
	open val medigunBulletResistPassive = ItemAttributeNamed<Float>("medigun bullet resist passive")
	
	
	open val medigunBlastResistDeployed = ItemAttributeNamed<Float>("medigun blast resist deployed")
	
	
	open val medigunBlastResistPassive = ItemAttributeNamed<Float>("medigun blast resist passive")
	
	
	open val medigunFireResistDeployed = ItemAttributeNamed<Float>("medigun fire resist deployed")
	
	
	open val medigunFireResistPassive = ItemAttributeNamed<Float>("medigun fire resist passive")

	
}

	
open class SecondaryMaxAmmoAttributes : IBlockScoped {
	
	open val hiddenSecondaryMaxAmmoPenalty = ItemAttributeNamed<Int>("hidden secondary max ammo penalty")
	
	/**
	 * In-Game: "+N% max secondary ammo on wearer"
	 */
	open val maxammoSecondaryIncreased = ItemAttributeNamed<Int>("maxammo secondary increased")
	
	/**
	 * In-Game: "N% max secondary ammo on wearer"
	 */
	open val maxammoSecondaryReduced = ItemAttributeNamed<Int>("maxammo secondary reduced")

	
}

	
open class OnDamageTakenAttributes : IBlockScoped {
	/**
	 * Bonus:
	 *
	 * 	- In-Game: "+N% critical hit damage resistance on wearer"
	 *
	 * 
	 *
	 * Penalty:
	 *
	 * 	- In-Game: "N% critical hit damage vulnerability on wearer"
	 */
	open val dmgTakenFromCrit = BonusPenalty(
		ItemAttributeNamed<Float>("dmg taken from crit reduced"),
		ItemAttributeNamed<Float>("dmg taken from crit increased")
	)
	
	/**
	 * Bonus:
	 *
	 * 	- In-Game: "+N% fire damage resistance on wearer"
	 *
	 * 
	 *
	 * Penalty:
	 *
	 * 	- In-Game: "N% fire damage vulnerability on wearer"
	 */
	open val dmgTakenFromFire = BonusPenalty(
		ItemAttributeNamed<Float>("dmg taken from fire reduced"),
		ItemAttributeNamed<Float>("dmg taken from fire increased")
	)
	
	/**
	 * Bonus:
	 *
	 * 	- In-Game: "+N% explosive damage resistance on wearer"
	 *
	 * 
	 *
	 * Penalty:
	 *
	 * 	- In-Game: "N% explosive damage vulnerability on wearer"
	 */
	open val dmgTakenFromBlast = BonusPenalty(
		ItemAttributeNamed<Float>("dmg taken from blast reduced"),
		ItemAttributeNamed<Float>("dmg taken from blast increased")
	)
	
	/**
	 * Bonus:
	 *
	 * 	- In-Game: "+N% bullet damage resistance on wearer"
	 *
	 * 
	 *
	 * Penalty:
	 *
	 * 	- In-Game: "N% bullet damage vulnerability on wearer"
	 */
	open val dmgTakenFromBullets = BonusPenalty(
		ItemAttributeNamed<Float>("dmg taken from bullets reduced"),
		ItemAttributeNamed<Float>("dmg taken from bullets increased")
	)
	
	/**
	 * In-Game: "N% damage resistance when below 50% health and spun up"
	 */
	open val spunupDamageResistance = ItemAttributeNamed<Float>("spunup_damage_resistance")
	
	/**
	 * In-Game: "N% damage vulnerability on wearer"
	 */
	open val dmgTakenIncreased = ItemAttributeNamed<Float>("dmg taken increased")
	
	/**
	 * In-Game: "+N% sentry damage resistance on wearer"
	 */
	open val setBonusDmgFromSentryReduced = ItemAttributeNamed<Float>("SET BONUS: dmg from sentry reduced")
	
	/**
	 * In-Game: "N% blast damage from rocket jumps"
	 */
	open val rocketJumpDamageReduction = ItemAttributeNamed<Float>("rocket jump damage reduction")
	
	/**
	 * In-Game: "N% blast damage from rocket jumps"
	 */
	open val rocketJumpDamageReductionHidden = ItemAttributeNamed<Float>("rocket jump damage reduction HIDDEN")

	
}

	
open class OnKillAttributes : IBlockScoped {
	/**
	 * In-Game: "On Kill: A small health pack is dropped"
	 */
	open val dropHealthPackOnKill = ItemAttributeNamed<Boolean>("drop health pack on kill")
	
	/**
	 * In-Game: "On Kill: Burst into joyous laughter"
	 */
	open val killForcesAttackerToLaugh = ItemAttributeNamed<Boolean>("kill forces attacker to laugh")

	
}

	
open class DenyResupplyAttributes : IBlockScoped {
	
	open val grenades1ResupplyDenied = ItemAttributeNamed<Boolean>("grenades1_resupply_denied")
	
	
	open val grenades2ResupplyDenied = ItemAttributeNamed<Boolean>("grenades2_resupply_denied")
	
	
	open val grenades3ResupplyDenied = ItemAttributeNamed<Boolean>("grenades3_resupply_denied")

	
}

	
open class ScoutOnlyAttributes : IBlockScoped {
	/**
	 * In-Game: "Disables double jump"
	 */
	open val noDoubleJump = ItemAttributeNamed<Boolean>("no double jump")
	
	/**
	 * In-Game: "Hype Decays Over Time."
	 */
	open val hypeDecaysOverTime = ItemAttributeNamed<Float>("hype decays over time")
	
	/**
	 * In-Game: "Boost reduced when hit"
	 */
	open val loseHypeOnTakeDamage = ItemAttributeNamed<Int>("lose hype on take damage")

	
}

	
open class DemomanOnlyAttributes : IBlockScoped {
	/**
	 * In-Game: "Taking damage while shield charging reduces remaining charging time"
	 */
	open val loseDemoChargeOnDamageWhenCharging = ItemAttributeNamed<Boolean>("lose demo charge on damage when charging")
	
	/**
	 * In-Game: "Melee kills refill N% of your charge meter."
	 */
	open val killRefillsMeter = ItemAttributeNamed<Float>("kill refills meter")
	
	/**
	 * In-Game: "N% damage penalty"
	 */
	open val decapitateType = ItemAttributeNamed<Boolean>("decapitate type")
	
	/**
	 * Bonus:
	 *
	 * 	- In-Game: "N sec increase in charge duration"
	 *
	 * 
	 *
	 * Penalty:
	 *
	 * 	- In-Game: "N sec decrease in charge duration"
	 */
	open val chargeTime = BonusPenalty(
		ItemAttributeNamed<Float>("charge time increased"),
		ItemAttributeNamed<Float>("charge time decreased")
	)
	
	/**
	 * In-Game: "+N% increase in charge recharge rate"
	 */
	open val chargeRechargeRateIncreased = ItemAttributeNamed<Float>("charge recharge rate increased")

	
}

	
open class SniperOnlyAttributes : IBlockScoped {
	/**
	 * In-Game: "Knockback reduced by N% when aiming"
	 */
	open val aimingKnockbackResistance = ItemAttributeNamed<Float>("aiming knockback resistance")
	
	/**
	 * In-Game: "Gain Focus on kills and assists"
	 */
	open val rageOnKill = ItemAttributeNamed<Float>("rage on kill")

	
}

	
open class MedicOnlyAttributes : IBlockScoped {
	/**
	 * In-Game: "+25% heal rate for patient, +25% faster revive rate, and +25% self heal rate, per point"
	 */
	open val healingMastery = ItemAttributeNamed<Int>("healing mastery")
	
	/**
	 * In-Game: "Build energy by healing teammates.  When fully charged, press the Special-Attack key to deploy a frontal projectile shield."
	 */
	open val generateRageOnHeal = ItemAttributeNamed<Boolean>("generate rage on heal")
	
	
	open val addHeadOnHit = ItemAttributeNamed<Boolean>("add head on hit")

	
}

	
open class SpyOnlyAttributes : IBlockScoped {
	/**
	 * In-Game: "+N% cloak on kill"
	 */
	open val addCloakOnKill = ItemAttributeNamed<Int>("add cloak on kill")
	
	/**
	 * In-Game: "Extra effects when taunting."
	 */
	open val setBonusCustomTauntParticleAttr = ItemAttributeNamed<Boolean>("SET BONUS: custom taunt particle attr")
	
	
	open val hasPipboyBuildInterface = ItemAttributeNamed<Int>("has pipboy build interface")

	
}
}

