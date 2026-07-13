package btpos.source.vdfdsl.tf2.attributes

import btpos.source.vdfdsl.modeling.*
import btpos.source.vdfdsl.serialization.codecs.*
import btpos.source.vdfdsl.tf2.attributes.impl.*
import java.util.*


interface PlayerAttributes : EntityAttributes, IBlockScoped {
	companion object : PlayerAttributes
	
	/**
	 * In-Game: "+N% greater jump height when active"
	 *
	 * 
	 */
	context(attrs: IKeyValueMap)
	override var increasedJumpHeight: Float?
		get() = super.increasedJumpHeight
		set(value) { super.increasedJumpHeight = value }
	
	/**
	 * 
	 */
	context(attrs: IKeyValueMap)
	override var majorIncreasedJumpHeight: Float?
		get() = super.majorIncreasedJumpHeight
		set(value) { super.majorIncreasedJumpHeight = value }
	
	/**
	 * 
	 */
	context(attrs: IKeyValueMap)
	override var halloweenIncreasedJumpHeight: Float?
		get() = super.halloweenIncreasedJumpHeight
		set(value) { super.halloweenIncreasedJumpHeight = value }
	
	/**
	 * In-Game: "Boost reduced on air jumps"
	 *
	 * 
	 *
	 * Lose this amount of hype if you airdash.
	 *
	 * Note that this only applies to scout hype, not rage in general.
	 *
	 * The amount to be subtracted from the hype meter when the Scout double-jumps.
	 */
	context(attrs: IKeyValueMap)
	override var hypeResetsOnJump: Int?
		get() = super.hypeResetsOnJump
		set(value) { super.hypeResetsOnJump = value }
	
	/**
	 * 
	 *
	 * Allows parachute to be deployed.
	 *
	 * Allows the parachute to be deployed.
	 */
	context(attrs: IKeyValueMap)
	override var parachuteAttribute: Boolean?
		get() = super.parachuteAttribute
		set(value) { super.parachuteAttribute = value }
	
	/**
	 * In-Game: "N% increased air control."
	 *
	 * 
	 *
	 * Sidenote: the jetpack always multiplies your air acceleration by 50%.
	 */
	context(attrs: IKeyValueMap)
	var increasedAirControl: Float?
		get() = attrs.getTyped("increased air control")
		set(value) = attrs.setNullable("increased air control", value)
	
	/**
	 * In-Game: "N% increased air control when blast jumping."
	 *
	 * 
	 *
	 * Specifically while blast-jumping, as opposed to global.
	 */
	context(attrs: IKeyValueMap)
	var airControlBlastJump: Float?
		get() = attrs.getTyped("mod_air_control_blast_jump")
		set(value) = attrs.setNullable("mod_air_control_blast_jump", value)
	
	/**
	 * In-Game: "Share Canteens with your heal target. +1 duration, -10 price per point (minimum cost: 5)"
	 *
	 * 
	 *
	 * Discounts canteens by 10 * level.
	 */
	context(attrs: IKeyValueMap)
	var canteenSpecialist: Int?
		get() = attrs.getTyped("canteen specialist")
		set(value) = attrs.setNullable("canteen specialist", value)
	
	/**
	 * In-Game: "Increased Melee damage against Isolated Merc Set"
	 *
	 * 
	 */
	context(attrs: IKeyValueMap)
	var setBonusAlienIsolationXenoBonusPos: Boolean?
		get() = attrs.getTyped("SET BONUS: alien isolation xeno bonus pos", BinaryIntCodec)
		set(value) = attrs.setNullable("SET BONUS: alien isolation xeno bonus pos", value, BinaryIntCodec)
	
	/**
	 * In-Game: "Increased Nostromo Napalmer damage against Isolationist Pack Set"
	 *
	 * 
	 */
	context(attrs: IKeyValueMap)
	var setBonusAlienIsolationMercBonusPos: Boolean?
		get() = attrs.getTyped("SET BONUS: alien isolation merc bonus pos", BinaryIntCodec)
		set(value) = attrs.setNullable("SET BONUS: alien isolation merc bonus pos", value, BinaryIntCodec)
	
	/**
	 * In-Game: "When backstabbed: Jarate attacker"
	 *
	 * 
	 *
	 * If true, jarates anyone who backstabs this player.
	 *
	 * Note: does not block backstabs on its own.
	 */
	context(attrs: IKeyValueMap)
	var jarateBackstabber: Boolean?
		get() = attrs.getTyped("jarate backstabber", BinaryIntCodec)
		set(value) = attrs.setNullable("jarate backstabber", value, BinaryIntCodec)
	
	/**
	 * 
	 *
	 * Multiplier to damage taken if player has  TF_COND_MEDIGUN_UBER_BULLET_RESIST.
	 */
	context(attrs: IKeyValueMap)
	var medigunBulletResistDeployed: Int?
		get() = attrs.getTyped("medigun bullet resist deployed")
		set(value) = attrs.setNullable("medigun bullet resist deployed", value)
	
	/**
	 * 
	 *
	 * Multiplier to damage taken if player has TF_COND_MEDIGUN_SMALL_BULLET_RESIST.
	 */
	context(attrs: IKeyValueMap)
	var medigunBulletResistPassive: Int?
		get() = attrs.getTyped("medigun bullet resist passive")
		set(value) = attrs.setNullable("medigun bullet resist passive", value)
	
	/**
	 * 
	 *
	 * Multiplier to damage taken if player has TF_COND_MEDIGUN_UBER_BLAST_RESIST.
	 */
	context(attrs: IKeyValueMap)
	var medigunBlastResistDeployed: Int?
		get() = attrs.getTyped("medigun blast resist deployed")
		set(value) = attrs.setNullable("medigun blast resist deployed", value)
	
	/**
	 * 
	 *
	 * Multiplier to damage taken if player has TF_COND_MEDIGUN_SMALL_BLAST_RESIST.
	 */
	context(attrs: IKeyValueMap)
	var medigunBlastResistPassive: Int?
		get() = attrs.getTyped("medigun blast resist passive")
		set(value) = attrs.setNullable("medigun blast resist passive", value)
	
	/**
	 * 
	 *
	 * Multiplier to damage taken if player has TF_COND_MEDIGUN_UBER_FIRE_RESIST.
	 */
	context(attrs: IKeyValueMap)
	var medigunFireResistDeployed: Int?
		get() = attrs.getTyped("medigun fire resist deployed")
		set(value) = attrs.setNullable("medigun fire resist deployed", value)
	
	/**
	 * 
	 *
	 * Multiplier to damage taken if player has TF_COND_MEDIGUN_SMALL_FIRE_RESIST.
	 */
	context(attrs: IKeyValueMap)
	var medigunFireResistPassive: Int?
		get() = attrs.getTyped("medigun fire resist passive")
		set(value) = attrs.setNullable("medigun fire resist passive", value)
	
	/**
	 * In-Game: "Immune to fire damage while disguised"
	 *
	 * 
	 *
	 * Prevent afterburn while disguised.
	 */
	context(attrs: IKeyValueMap)
	var disguiseNoBurn: Boolean?
		get() = attrs.getTyped("disguise no burn", BinaryIntCodec)
		set(value) = attrs.setNullable("disguise no burn", value, BinaryIntCodec)
	
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
	val dmgTakenFromCrit get() = BonusPenalty<Float, Float>("dmg taken from crit reduced", "dmg taken from crit increased")
	
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
	val dmgTakenFromFire get() = BonusPenalty<Float, Float>("dmg taken from fire reduced", "dmg taken from fire increased")
	
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
	val dmgTakenFromBlast get() = BonusPenalty<Float, Float>("dmg taken from blast reduced", "dmg taken from blast increased")
	
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
	val dmgTakenFromBullets get() = BonusPenalty<Float, Float>("dmg taken from bullets reduced", "dmg taken from bullets increased")
	
	/**
	 * In-Game: "N% damage resistance when below 50% health and spun up"
	 *
	 * 
	 *
	 * Only procs on Heavies that are currently spun up on less than 50% HP.
	 */
	context(attrs: IKeyValueMap)
	var spunupDamageResistance: Float?
		get() = attrs.getTyped("spunup_damage_resistance")
		set(value) = attrs.setNullable("spunup_damage_resistance", value)
	
	/**
	 * In-Game: "N% damage vulnerability on wearer"
	 *
	 * 
	 *
	 * Multiplier to damage taken from all sources.
	 */
	context(attrs: IKeyValueMap)
	var dmgTakenIncreased: Float?
		get() = attrs.getTyped("dmg taken increased")
		set(value) = attrs.setNullable("dmg taken increased", value)
	
	/**
	 * In-Game: "+N% sentry damage resistance on wearer"
	 *
	 * 
	 */
	context(attrs: IKeyValueMap)
	var setBonusDmgFromSentryReduced: Float?
		get() = attrs.getTyped("SET BONUS: dmg from sentry reduced")
		set(value) = attrs.setNullable("SET BONUS: dmg from sentry reduced", value)
	
	/**
	 * In-Game: "Generate Rage by dealing damage.  When fully charged, press the Special-Attack key to activate knockback"
	 *
	 * 
	 *
	 * Only procs on Heavies, multiplies damage by 50% while rage is draining.
	 */
	context(attrs: IKeyValueMap)
	var generateRageOnDamage: Boolean?
		get() = attrs.getTyped("generate rage on damage", BinaryIntCodec)
		set(value) = attrs.setNullable("generate rage on damage", value, BinaryIntCodec)
	
	/**
	 * In-Game: "Generate building rescue energy on damage"
	 *
	 * 
	 *
	 * Only procs on Heavies, multiplies damage by 50% while rage is draining.
	 */
	context(attrs: IKeyValueMap)
	var engineerRageOnDmg: Boolean?
		get() = attrs.getTyped("engineer rage on dmg", BinaryIntCodec)
		set(value) = attrs.setNullable("engineer rage on dmg", value, BinaryIntCodec)
	
	/**
	 * In-Game: "N% blast damage from rocket jumps"
	 *
	 * 
	 *
	 * Multiplier applied to damage taken IF: it's blast damage or a flare explosion, the damage was caused by the user (self-damage), the user did not damage other players, and it is not a taunt-kill grenade (Escape Plan, Equalizer).
	 */
	context(attrs: IKeyValueMap)
	var rocketJumpDamageReduction: Float?
		get() = attrs.getTyped("rocket jump damage reduction")
		set(value) = attrs.setNullable("rocket jump damage reduction", value)
	
	/**
	 * In-Game: "N% blast damage from rocket jumps"
	 *
	 * 
	 *
	 * Multiplier applied to damage taken IF: it's blast damage or a flare explosion, the damage was caused by the user (self-damage), the user did not damage other players, and it is not a taunt-kill grenade (Escape Plan, Equalizer).
	 */
	context(attrs: IKeyValueMap)
	var rocketJumpDamageReductionHidden: Float?
		get() = attrs.getTyped("rocket jump damage reduction HIDDEN")
		set(value) = attrs.setNullable("rocket jump damage reduction HIDDEN", value)
	
	/**
	 * In-Game: "On Hit: Builds Hype"
	 *
	 * 
	 *
	 * Adds the amount of damage dealt to the Scout hype meter, to a maximum of 200 damage which adds 50% meter.
	 */
	context(attrs: IKeyValueMap)
	var hypeOnDamage: Boolean?
		get() = attrs.getTyped("hype on damage", BinaryIntCodec)
		set(value) = attrs.setNullable("hype on damage", value, BinaryIntCodec)
	
	/**
	 * 
	 *
	 * Only procs on Sniper. Gain this amount of rage meter on assists.
	 */
	context(attrs: IKeyValueMap)
	var rageOnAssists: Int?
		get() = attrs.getTyped("rage on assists")
		set(value) = attrs.setNullable("rage on assists", value)
	
	/**
	 * In-Game: "Killstreaks Active"
	 *
	 * 
	 */
	context(attrs: IKeyValueMap)
	var killstreakTier: Int?
		get() = attrs.getTyped("killstreak tier")
		set(value) = attrs.setNullable("killstreak tier", value)
	
	/**
	 * In-Game: "Wearer never takes falling damage"
	 *
	 * 
	 */
	context(attrs: IKeyValueMap)
	var cancelFallingDamage: Boolean?
		get() = attrs.getTyped("cancel falling damage", BinaryIntCodec)
		set(value) = attrs.setNullable("cancel falling damage", value, BinaryIntCodec)
	
	/**
	 * In-Game: "+N capture rate on wearer"
	 *
	 * 
	 */
	context(attrs: IKeyValueMap)
	var increasePlayerCaptureValue: Int?
		get() = attrs.getTyped("increase player capture value")
		set(value) = attrs.setNullable("increase player capture value", value)
	
	/**
	 * 
	 *
	 * If 1, create a soccer ball on the ground when the player spawns.
	 */
	context(attrs: IKeyValueMap)
	var spawnWithPhysicsToy: Int?
		get() = attrs.getTyped("spawn with physics toy")
		set(value) = attrs.setNullable("spawn with physics toy", value)
	
	/**
	 * 
	 *
	 * If `mult_item_meter_charge_rate` is set, checks this attribute to see what type of meter should be modified, and also only allows it to activate if the active weapon is not a TF_WEAPON_FLAME_BALL.
	 */
	context(attrs: IKeyValueMap)
	var itemMeterChargeType: Int?
		get() = attrs.getTyped("item_meter_charge_type")
		set(value) = attrs.setNullable("item_meter_charge_type", value)
	
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
	val healthFromHealersReduced get() = BonusPenalty<Float, Float>("health from healers increased", "health from healers reduced")
	
	/**
	 * In-Game: "N sec longer cloak blink time"
	 *
	 * 
	 *
	 * This attribute class is a multiplier to the amount of time, not a flat amount of time.
	 */
	context(attrs: IKeyValueMap)
	var setBonusCloakBlinkTimePenalty: Int?
		get() = attrs.getTyped("SET BONUS: cloak blink time penalty")
		set(value) = attrs.setNullable("SET BONUS: cloak blink time penalty", value)
	
	/**
	 * 
	 *
	 * Number of seconds the player who hit this entity should be marked for death.
	 *
	 * If attacker is affected by `TF_COND_ENERGY_BUFF` (Crit-a-Cola, Cleaner's Carbine, Buffalo Steak, etc.), the attacker receives `TF_COND_MARKEDFORDEATH_SILENT`.
	 */
	context(attrs: IKeyValueMap)
	var markAttackerForDeath: Float?
		get() = attrs.getTyped("mod_mark_attacker_for_death")
		set(value) = attrs.setNullable("mod_mark_attacker_for_death", value)
	
	/**
	 * In-Game: "+N% increase in turning control while charging"
	 *
	 * 
	 *
	 * Default is 0.45f, and this class is a multiplier applied to it.
	 */
	context(attrs: IKeyValueMap)
	var multChargeTurnControl: Float?
		get() = attrs.getTyped("mult charge turn control")
		set(value) = attrs.setNullable("mult charge turn control", value)
	
	/**
	 * In-Game: "Full turning control while charging"
	 *
	 * 
	 *
	 * Default is 0.45f, and this class is a multiplier applied to it.
	 */
	context(attrs: IKeyValueMap)
	var fullChargeTurnControl: Int?
		get() = attrs.getTyped("full charge turn control")
		set(value) = attrs.setNullable("full charge turn control", value)
	
	/**
	 * In-Game: "Taking damage while shield charging reduces remaining charging time"
	 *
	 * 
	 *
	 * Used to detect the Tide Turner when deciding whether to give you minicrits or crits.
	 */
	context(attrs: IKeyValueMap)
	var loseDemoChargeOnDamageWhenCharging: Boolean?
		get() = attrs.getTyped("lose demo charge on damage when charging", BinaryIntCodec)
		set(value) = attrs.setNullable("lose demo charge on damage when charging", value, BinaryIntCodec)
	
	/**
	 * In-Game: "N sec increase in time to cloak"
	 *
	 * 
	 */
	context(attrs: IKeyValueMap)
	var multCloakRate: Int?
		get() = attrs.getTyped("mult cloak rate")
		set(value) = attrs.setNullable("mult cloak rate", value)
	
	/**
	 * 
	 */
	context(attrs: IKeyValueMap)
	var multDecloakRate: Int?
		get() = attrs.getTyped("mult decloak rate")
		set(value) = attrs.setNullable("mult decloak rate", value)
	
	/**
	 * In-Game: "Reduced decloak sound volume"
	 *
	 * 
	 *
	 * If true, plays `Player.Spy_UnCloakReduced` when decloaking.
	 */
	context(attrs: IKeyValueMap)
	var setBonusQuietUnstealth: Boolean?
		get() = attrs.getTyped("SET BONUS: quiet unstealth", BinaryIntCodec)
		set(value) = attrs.setNullable("SET BONUS: quiet unstealth", value, BinaryIntCodec)
	
	/**
	 * In-Game: "Deals 3x falling damage to the player you land on"
	 *
	 * 
	 *
	 * Deal 3x falling damage to player you land on.
	 */
	context(attrs: IKeyValueMap)
	var bootsFallingStomp: Boolean?
		get() = attrs.getTyped("boots falling stomp", BinaryIntCodec)
		set(value) = attrs.setNullable("boots falling stomp", value, BinaryIntCodec)
	
	/**
	 * In-Game: "Über duration increased N seconds"
	 *
	 * 
	 *
	 * Duration in seconds.
	 */
	context(attrs: IKeyValueMap)
	var uberDurationBonus: Int?
		get() = attrs.getTyped("uber duration bonus")
		set(value) = attrs.setNullable("uber duration bonus", value)
	
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
	val aimingMovespeed get() = BonusPenalty<Float, Float>("aiming movespeed increased", "aiming movespeed decreased")
	
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
	val moveSpeed get() = BonusPenalty<Float, Float>("move speed bonus", "move speed penalty")
	
	/**
	 * In-Game: "+N% faster move speed on wearer (shield required)"
	 *
	 * 
	 */
	context(attrs: IKeyValueMap)
	var moveSpeedBonusShieldRequired: Float?
		get() = attrs.getTyped("move speed bonus shield required")
		set(value) = attrs.setNullable("move speed bonus shield required", value)
	
	/**
	 * 
	 *
	 * This part is only semi-implemented...
	 *
	 * Gives extra player movespeed the more heads you have.
	 *
	 * Will not work if the player is not a Medic wielding the VitaSaw.
	 */
	context(attrs: IKeyValueMap)
	var addHeadOnHit: Boolean?
		get() = attrs.getTyped("add head on hit", BinaryIntCodec)
		set(value) = attrs.setNullable("add head on hit", value, BinaryIntCodec)
	
	/**
	 * In-Game: "Wearer cannot carry the intelligence briefcase or PASS Time JACK"
	 *
	 * 
	 */
	context(attrs: IKeyValueMap)
	var cannotPickUpIntelligence: Boolean?
		get() = attrs.getTyped("cannot pick up intelligence", BinaryIntCodec)
		set(value) = attrs.setNullable("cannot pick up intelligence", value, BinaryIntCodec)
	
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
	context(attrs: IKeyValueMap)
	var engyDisposableSentries: Int?
		get() = attrs.getTyped("engy disposable sentries")
		set(value) = attrs.setNullable("engy disposable sentries", value)
	
	/**
	 * In-Game: "N% metal cost when constructing or upgrading teleporters"
	 *
	 * 
	 *
	 * Multiplier applied to teleporter build cost.
	 */
	context(attrs: IKeyValueMap)
	var teleporterCost: Float?
		get() = attrs.getTyped("mod teleporter cost")
		set(value) = attrs.setNullable("mod teleporter cost", value)
	
	/**
	 * In-Game: "N metal reduction in building cost"
	 *
	 * 
	 *
	 * Overrides the building cost for all buildings.
	 */
	context(attrs: IKeyValueMap)
	var buildingCostReduction: Float?
		get() = attrs.getTyped("building cost reduction")
		set(value) = attrs.setNullable("building cost reduction", value)
	
	/**
	 * 
	 */
	context(attrs: IKeyValueMap)
	var overrideFootstepSoundSet: Int?
		get() = attrs.getTyped("override footstep sound set")
		set(value) = attrs.setNullable("override footstep sound set", value)
	
	/**
	 * In-Game: "Jingle all the way"
	 *
	 * 
	 *
	 * If 1, use xmas.jingle, if 2 or higher use xmas.jingle_higher.
	 */
	context(attrs: IKeyValueMap)
	var addJingleToFootsteps: Int?
		get() = attrs.getTyped("add jingle to footsteps")
		set(value) = attrs.setNullable("add jingle to footsteps", value)
	
	/**
	 * In-Game: "N"
	 *
	 * 
	 *
	 * Decimal version of the 4-byte hex code determining color of footsteps (e.g. `0xFFFFFFFF`, but in decimal).
	 */
	context(attrs: IKeyValueMap)
	var spellSetHalloweenFootstepType: Int?
		get() = attrs.getTyped("SPELL: set Halloween footstep type")
		set(value) = attrs.setNullable("SPELL: set Halloween footstep type", value)
	
	/**
	 * 
	 *
	 * Prevents player from attacking.
	 */
	context(attrs: IKeyValueMap)
	var noAttack: Boolean?
		get() = attrs.getTyped("no_attack", BinaryIntCodec)
		set(value) = attrs.setNullable("no_attack", value, BinaryIntCodec)
	
	/**
	 * 
	 *
	 * Prevents player from jumping.
	 */
	context(attrs: IKeyValueMap)
	var noJump: Boolean?
		get() = attrs.getTyped("no_jump", BinaryIntCodec)
		set(value) = attrs.setNullable("no_jump", value, BinaryIntCodec)
	
	/**
	 * 
	 *
	 * Prevents player from crouching.
	 */
	context(attrs: IKeyValueMap)
	var noDuck: Boolean?
		get() = attrs.getTyped("no_duck", BinaryIntCodec)
		set(value) = attrs.setNullable("no_duck", value, BinaryIntCodec)
	
	/**
	 * In-Game: "Cannot carry buildings"
	 *
	 * 
	 *
	 * Prevents player from picking up buildings.
	 */
	context(attrs: IKeyValueMap)
	var cannotPickUpBuildings: Boolean?
		get() = attrs.getTyped("cannot pick up buildings", BinaryIntCodec)
		set(value) = attrs.setNullable("cannot pick up buildings", value, BinaryIntCodec)
	
	/**
	 * 
	 */
	context(attrs: IKeyValueMap)
	var disableWeaponSwitch: Boolean?
		get() = attrs.getTyped("disable weapon switch", BinaryIntCodec)
		set(value) = attrs.setNullable("disable weapon switch", value, BinaryIntCodec)
	
	/**
	 * In-Game: "Disables double jump"
	 *
	 * 
	 */
	context(attrs: IKeyValueMap)
	var noDoubleJump: Boolean?
		get() = attrs.getTyped("no double jump", BinaryIntCodec)
		set(value) = attrs.setNullable("no double jump", value, BinaryIntCodec)
	
	/**
	 * In-Game: "Wearer cannot disguise"
	 *
	 * 
	 */
	context(attrs: IKeyValueMap)
	var cannotDisguise: Boolean?
		get() = attrs.getTyped("cannot disguise", BinaryIntCodec)
		set(value) = attrs.setNullable("cannot disguise", value, BinaryIntCodec)
	
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
	val maxammoPrimaryReduced get() = BonusPenalty_BonusNested<VisHidden<Float, Float>, Float>(VisHidden<Float, Float>("maxammo primary increased", "hidden primary max ammo bonus"), "maxammo primary reduced")
	
	/**
	 * 
	 */
	val secondaryMaxAmmo get() = SecondaryMaxAmmoAttributes
	
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
	val maxammoMetalReduced get() = BonusPenalty<Float, Float>("maxammo metal increased", "maxammo metal reduced")
	
	/**
	 * In-Game: "+N% max misc ammo on wearer"
	 *
	 * 
	 *
	 * Only used for bat balls.
	 */
	context(attrs: IKeyValueMap)
	var maxammoGrenades1Increased: Float?
		get() = attrs.getTyped("maxammo grenades1 increased")
		set(value) = attrs.setNullable("maxammo grenades1 increased", value)
	
	/**
	 * 
	 *
	 * Note that Phlogistinator's rage has a small cooldown after expiring before it can gain rage again, to prevent the lingering crit flames from immediately filling it up again.
	 */
	context(attrs: IKeyValueMap)
	var soldierBuffType: Int?
		get() = attrs.getTyped("mod soldier buff type")
		set(value) = attrs.setNullable("mod soldier buff type", value)
	
	/**
	 * 
	 *
	 * Note that Phlogistinator's rage has a small cooldown after expiring before it can gain rage again, to prevent the lingering crit flames from immediately filling it up again.
	 */
	context(attrs: IKeyValueMap)
	var demoBuffType: Int?
		get() = attrs.getTyped("mod demo buff type")
		set(value) = attrs.setNullable("mod demo buff type", value)
	
	/**
	 * In-Game: "+N% buff duration"
	 *
	 * 
	 *
	 * Multiplier applied to buff duration.
	 */
	context(attrs: IKeyValueMap)
	var increaseBuffDuration: Float?
		get() = attrs.getTyped("increase buff duration")
		set(value) = attrs.setNullable("increase buff duration", value)
	
	/**
	 * In-Game: "+N% buff duration"
	 *
	 * 
	 *
	 * Multiplier applied to buff duration.
	 */
	context(attrs: IKeyValueMap)
	var increaseBuffDurationHidden: Float?
		get() = attrs.getTyped("increase buff duration HIDDEN")
		set(value) = attrs.setNullable("increase buff duration HIDDEN", value)
	
	/**
	 * In-Game: "Blocks healing while in use"
	 *
	 * 
	 */
	context(attrs: IKeyValueMap)
	var weaponBlocksHealing: Boolean?
		get() = attrs.getTyped("mod weapon blocks healing", BinaryIntCodec)
		set(value) = attrs.setNullable("mod weapon blocks healing", value, BinaryIntCodec)
	
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
	val healthDrain get() = BonusPenalty<Int, Int>("health regen", "health drain")
	
	/**
	 * In-Game: "+N% ammo regenerated every 5 seconds on wearer"
	 *
	 * 
	 *
	 * Percentage of ammo regenerated every 5 seconds.
	 */
	context(attrs: IKeyValueMap)
	var ammoRegen: Float?
		get() = attrs.getTyped("ammo regen")
		set(value) = attrs.setNullable("ammo regen", value)
	
	/**
	 * In-Game: "+N metal regenerated every 5 seconds on wearer"
	 *
	 * 
	 *
	 * Amount of metal regenerated every 5 seconds.
	 */
	context(attrs: IKeyValueMap)
	var metalRegen: Int?
		get() = attrs.getTyped("metal regen")
		set(value) = attrs.setNullable("metal regen", value)
	
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
	val airblastVulnerabilityMultiplier get() = BonusPenalty<Float, Float>("airblast vulnerability multiplier", "airblast vulnerability multiplier hidden")
	
	/**
	 * 
	 */
	context(attrs: IKeyValueMap)
	var airblastVerticalVulnerabilityMultiplier: Float?
		get() = attrs.getTyped("airblast vertical vulnerability multiplier")
		set(value) = attrs.setNullable("airblast vertical vulnerability multiplier", value)
	
	/**
	 * In-Game: "Noise Maker"
	 *
	 * 
	 *
	 * Uses noise maker when pressing action slot key.
	 */
	context(attrs: IKeyValueMap)
	var noiseMaker: Boolean?
		get() = attrs.getTyped("noise maker", BinaryIntCodec)
		set(value) = attrs.setNullable("noise maker", value, BinaryIntCodec)
	
	/**
	 * In-Game: "Leave a Calling Card on your victims."
	 *
	 * 
	 *
	 * Defines the calling card that should be dropped when this player kills another player.
	 */
	context(attrs: IKeyValueMap)
	var setBonusCallingCardOnKill: Int?
		get() = attrs.getTyped("SET BONUS: calling card on kill")
		set(value) = attrs.setNullable("SET BONUS: calling card on kill", value)
	
	/**
	 * In-Game: "Sentry build speed increased by N%"
	 *
	 * 
	 */
	context(attrs: IKeyValueMap)
	var engineerSentryBuildRateMultiplier: Float?
		get() = attrs.getTyped("engineer sentry build rate multiplier")
		set(value) = attrs.setNullable("engineer sentry build rate multiplier", value)
	
	/**
	 * In-Game: "Increases teleporter build speed by N%."
	 *
	 * 
	 *
	 * Also used for dispensers.
	 */
	context(attrs: IKeyValueMap)
	var engineerTeleporterBuildRateMultiplier: Float?
		get() = attrs.getTyped("engineer teleporter build rate multiplier")
		set(value) = attrs.setNullable("engineer teleporter build rate multiplier", value)
	
	/**
	 * In-Game: "Headshots deal an extra +N% damage"
	 *
	 * 
	 *
	 * Multiplier applied to headshot damage.
	 */
	context(attrs: IKeyValueMap)
	var headshotDamageIncrease: Float?
		get() = attrs.getTyped("headshot damage increase")
		set(value) = attrs.setNullable("headshot damage increase", value)
	
	/**
	 * In-Game: "N% damage penalty"
	 *
	 * 
	 *
	 * More like a boolean.  Doesn't actually determine any kind of decapitation, just if it CAN decapitate.
	 *
	 * Checked on all hitscan attacks.
	 */
	context(attrs: IKeyValueMap)
	var decapitateType: Int?
		get() = attrs.getTyped("decapitate type")
		set(value) = attrs.setNullable("decapitate type", value)
	
	/**
	 * In-Game: "Push enemies back when you land (force and radius based on velocity)"
	 *
	 * 
	 *
	 * Requires player to have the `TF_COND_ROCKETPACK` condition.
	 *
	 * Pushes back nearby players around the landing site.
	 */
	context(attrs: IKeyValueMap)
	var fallingImpactRadiusPushback: Boolean?
		get() = attrs.getTyped("falling_impact_radius_pushback", BinaryIntCodec)
		set(value) = attrs.setNullable("falling_impact_radius_pushback", value, BinaryIntCodec)
	
	/**
	 * In-Game: "Stun enemies when you land"
	 *
	 * 
	 *
	 * If `falling_impact_radius_pushback` is set, this will also stun any enemies in the impact radius.
	 */
	context(attrs: IKeyValueMap)
	var fallingImpactRadiusStun: Boolean?
		get() = attrs.getTyped("falling_impact_radius_stun", BinaryIntCodec)
		set(value) = attrs.setNullable("falling_impact_radius_stun", value, BinaryIntCodec)
	
	/**
	 * 
	 *
	 * Multiplier applied to rage gained by dealing damage, taking damage, or dealing burn damage.
	 */
	context(attrs: IKeyValueMap)
	var rageGivingScale: Float?
		get() = attrs.getTyped("rage giving scale")
		set(value) = attrs.setNullable("rage giving scale", value)
	
	/**
	 * 
	 *
	 * If the weapon is a Holy Mackerel reskin (AKA either the fish or the Unarmed Combat) and this is set, use the Unarmed Combat "arm hit" killfeed notice instead of the "fish hit" notice.
	 */
	context(attrs: IKeyValueMap)
	var fishDamageOverride: Boolean?
		get() = attrs.getTyped("fish damage override", BinaryIntCodec)
		set(value) = attrs.setNullable("fish damage override", value, BinaryIntCodec)
	
	/**
	 * In-Game: "Explode spectacularly on death"
	 *
	 * 
	 */
	context(attrs: IKeyValueMap)
	var bombinomiconEffectOnDeath: Boolean?
		get() = attrs.getTyped("bombinomicon effect on death", BinaryIntCodec)
		set(value) = attrs.setNullable("bombinomicon effect on death", value, BinaryIntCodec)
	
	/**
	 * In-Game: "On Kill: A small health pack is dropped"
	 *
	 * 
	 *
	 * Drop a small health pack when killing an enemy.
	 */
	context(attrs: IKeyValueMap)
	var dropHealthPackOnKill: Boolean?
		get() = attrs.getTyped("drop health pack on kill", BinaryIntCodec)
		set(value) = attrs.setNullable("drop health pack on kill", value, BinaryIntCodec)
	
	/**
	 * In-Game: "On Kill: Burst into joyous laughter"
	 *
	 * 
	 *
	 * On killing an enemy, schadenfreude.
	 */
	context(attrs: IKeyValueMap)
	var killForcesAttackerToLaugh: Boolean?
		get() = attrs.getTyped("kill forces attacker to laugh", BinaryIntCodec)
		set(value) = attrs.setNullable("kill forces attacker to laugh", value, BinaryIntCodec)
	
	/**
	 * 
	 */
	context(attrs: IKeyValueMap)
	var grenades1ResupplyDenied: Boolean?
		get() = attrs.getTyped("grenades1_resupply_denied", BinaryIntCodec)
		set(value) = attrs.setNullable("grenades1_resupply_denied", value, BinaryIntCodec)
	
	/**
	 * 
	 */
	context(attrs: IKeyValueMap)
	var grenades2ResupplyDenied: Boolean?
		get() = attrs.getTyped("grenades2_resupply_denied", BinaryIntCodec)
		set(value) = attrs.setNullable("grenades2_resupply_denied", value, BinaryIntCodec)
	
	/**
	 * 
	 */
	context(attrs: IKeyValueMap)
	var grenades3ResupplyDenied: Boolean?
		get() = attrs.getTyped("grenades3_resupply_denied", BinaryIntCodec)
		set(value) = attrs.setNullable("grenades3_resupply_denied", value, BinaryIntCodec)
	
	/**
	 * In-Game: "N% less metal from pickups and dispensers"
	 *
	 * 
	 *
	 * Multiplier applied to metal gained from ammo boxes.
	 */
	context(attrs: IKeyValueMap)
	var metalPickupDecreased: Float?
		get() = attrs.getTyped("metal_pickup_decreased")
		set(value) = attrs.setNullable("metal_pickup_decreased", value)
	
	/**
	 * In-Game: "+N max health on wearer"
	 *
	 * 
	 *
	 * Additive base-health increase.
	 */
	context(attrs: IKeyValueMap)
	var hiddenMaxhealthNonBuffed: Int?
		get() = attrs.getTyped("hidden maxhealth non buffed")
		set(value) = attrs.setNullable("hidden maxhealth non buffed", value)
	
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
	val maxHealthAdditive get() = BonusPenalty<Int, Int>("max health additive bonus", "max health additive penalty")
	
	/**
	 * In-Game: "Unlimited use"
	 *
	 * 
	 *
	 * If true, noisemakers are unlimited usage.
	 */
	context(attrs: IKeyValueMap)
	var unlimitedQuantity: Boolean?
		get() = attrs.getTyped("unlimited quantity", BinaryIntCodec)
		set(value) = attrs.setNullable("unlimited quantity", value, BinaryIntCodec)
	
	/**
	 * 
	 *
	 * If true, noisemakers are unlimited usage.
	 */
	context(attrs: IKeyValueMap)
	var unlimitedQuantityHidden: Boolean?
		get() = attrs.getTyped("unlimited quantity hidden", BinaryIntCodec)
		set(value) = attrs.setNullable("unlimited quantity hidden", value, BinaryIntCodec)
	
	/**
	 * 
	 *
	 * If true, the zombiezombiezombiezombie skin is equipped.
	 */
	context(attrs: IKeyValueMap)
	var zombiezombiezombiezombie: Boolean?
		get() = attrs.getTyped("zombiezombiezombiezombie", BinaryIntCodec)
		set(value) = attrs.setNullable("zombiezombiezombiezombie", value, BinaryIntCodec)
	
	/**
	 * In-Game: "+N% faster taunt speed on wearer"
	 *
	 * 
	 *
	 * Multiplier applied to taunt speed.
	 */
	context(attrs: IKeyValueMap)
	var gestureSpeedIncrease: Float?
		get() = attrs.getTyped("gesture speed increase")
		set(value) = attrs.setNullable("gesture speed increase", value)
	
	/**
	 * 
	 *
	 * Sound to be played when performing a taunt.
	 */
	context(attrs: IKeyValueMap)
	var cosmeticTauntSound: Int?
		get() = attrs.getTyped("cosmetic taunt sound")
		set(value) = attrs.setNullable("cosmetic taunt sound", value)
	
	/**
	 * 
	 *
	 * DSP used when emitting sounds created by this player.
	 */
	context(attrs: IKeyValueMap)
	var setBonusSpecialDsp: Int?
		get() = attrs.getTyped("SET BONUS: special dsp")
		set(value) = attrs.setNullable("SET BONUS: special dsp", value)
	
	/**
	 * In-Game: "Disables double jump"
	 *
	 * 
	 */
	context(attrs: IKeyValueMap)
	var headScale: Int?
		get() = attrs.getTyped("head scale")
		set(value) = attrs.setNullable("head scale", value)
	
	/**
	 * 
	 */
	context(attrs: IKeyValueMap)
	var torsoScale: Int?
		get() = attrs.getTyped("torso scale")
		set(value) = attrs.setNullable("torso scale", value)
	
	/**
	 * 
	 */
	context(attrs: IKeyValueMap)
	var handScale: Int?
		get() = attrs.getTyped("hand scale")
		set(value) = attrs.setNullable("hand scale", value)
	
	/**
	 * 
	 */
	val demomanOnly get() = DemomanOnlyAttributes
	
	/**
	 * 
	 */
	val scoutOnly get() = ScoutOnlyAttributes
	
	/**
	 * 
	 */
	val sniperOnly get() = SniperOnlyAttributes
	
	/**
	 * 
	 */
	val medicOnly get() = MedicOnlyAttributes
}


object SecondaryMaxAmmoAttributes {
	inline operator fun invoke(scope: SecondaryMaxAmmoAttributes.() -> Unit) {
		this.apply(scope)
	}
	
	context(attrs: IKeyValueMap)
	var hiddenSecondaryMaxAmmoPenalty: Float?
		get() = attrs.getTyped("hidden secondary max ammo penalty")
		set(value) = attrs.setNullable("hidden secondary max ammo penalty", value)
	
	/**
	 * In-Game: "+N% max secondary ammo on wearer"
	 */
	context(attrs: IKeyValueMap)
	var maxammoSecondaryIncreased: Float?
		get() = attrs.getTyped("maxammo secondary increased")
		set(value) = attrs.setNullable("maxammo secondary increased", value)
	
	/**
	 * In-Game: "N% max secondary ammo on wearer"
	 */
	context(attrs: IKeyValueMap)
	var maxammoSecondaryReduced: Float?
		get() = attrs.getTyped("maxammo secondary reduced")
		set(value) = attrs.setNullable("maxammo secondary reduced", value)
}


object DemomanOnlyAttributes {
	inline operator fun invoke(scope: DemomanOnlyAttributes.() -> Unit) {
		this.apply(scope)
	}
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
	val chargeTime get() = BonusPenalty<Int, Int>("charge time increased", "charge time decreased")
	
	/**
	 * In-Game: "+N% increase in charge recharge rate"
	 */
	context(attrs: IKeyValueMap)
	var chargeRechargeRateIncreased: Float?
		get() = attrs.getTyped("charge recharge rate increased")
		set(value) = attrs.setNullable("charge recharge rate increased", value)
	
	/**
	 * In-Game: "Taking damage while shield charging reduces remaining charging time"
	 */
	context(attrs: IKeyValueMap)
	var loseDemoChargeOnDamageWhenCharging: Boolean?
		get() = attrs.getTyped("lose demo charge on damage when charging", BinaryIntCodec)
		set(value) = attrs.setNullable("lose demo charge on damage when charging", value, BinaryIntCodec)
	
	/**
	 * In-Game: "Melee kills refill N% of your charge meter."
	 */
	context(attrs: IKeyValueMap)
	var killRefillsMeter: Float?
		get() = attrs.getTyped("kill refills meter")
		set(value) = attrs.setNullable("kill refills meter", value)
	
	/**
	 * In-Game: "N% damage penalty"
	 */
	context(attrs: IKeyValueMap)
	var decapitateType: Boolean?
		get() = attrs.getTyped("decapitate type", BinaryIntCodec)
		set(value) = attrs.setNullable("decapitate type", value, BinaryIntCodec)
}


object ScoutOnlyAttributes {
	inline operator fun invoke(scope: ScoutOnlyAttributes.() -> Unit) {
		this.apply(scope)
	}
	/**
	 * In-Game: "Disables double jump"
	 */
	context(attrs: IKeyValueMap)
	var noDoubleJump: Boolean?
		get() = attrs.getTyped("no double jump", BinaryIntCodec)
		set(value) = attrs.setNullable("no double jump", value, BinaryIntCodec)
	
	/**
	 * In-Game: "Hype Decays Over Time."
	 */
	context(attrs: IKeyValueMap)
	var hypeDecaysOverTime: Int?
		get() = attrs.getTyped("hype decays over time")
		set(value) = attrs.setNullable("hype decays over time", value)
	
	/**
	 * In-Game: "Boost reduced when hit"
	 */
	context(attrs: IKeyValueMap)
	var loseHypeOnTakeDamage: Int?
		get() = attrs.getTyped("lose hype on take damage")
		set(value) = attrs.setNullable("lose hype on take damage", value)
}


object SniperOnlyAttributes {
	inline operator fun invoke(scope: SniperOnlyAttributes.() -> Unit) {
		this.apply(scope)
	}
	/**
	 * In-Game: "Knockback reduced by N% when aiming"
	 */
	context(attrs: IKeyValueMap)
	var aimingKnockbackResistance: Float?
		get() = attrs.getTyped("aiming knockback resistance")
		set(value) = attrs.setNullable("aiming knockback resistance", value)
	
	/**
	 * In-Game: "Gain Focus on kills and assists"
	 */
	context(attrs: IKeyValueMap)
	var rageOnKill: Int?
		get() = attrs.getTyped("rage on kill")
		set(value) = attrs.setNullable("rage on kill", value)
}


object MedicOnlyAttributes {
	inline operator fun invoke(scope: MedicOnlyAttributes.() -> Unit) {
		this.apply(scope)
	}
	/**
	 * In-Game: "+25% heal rate for patient, +25% faster revive rate, and +25% self heal rate, per point"
	 */
	context(attrs: IKeyValueMap)
	var healingMastery: Int?
		get() = attrs.getTyped("healing mastery")
		set(value) = attrs.setNullable("healing mastery", value)
	
	/**
	 * In-Game: "Build energy by healing teammates.  When fully charged, press the Special-Attack key to deploy a frontal projectile shield."
	 */
	context(attrs: IKeyValueMap)
	var generateRageOnHeal: Boolean?
		get() = attrs.getTyped("generate rage on heal", BinaryIntCodec)
		set(value) = attrs.setNullable("generate rage on heal", value, BinaryIntCodec)
	
	
	val spyOnly get() = SpyOnlyAttributes
}


object SpyOnlyAttributes {
	inline operator fun invoke(scope: SpyOnlyAttributes.() -> Unit) {
		this.apply(scope)
	}
	/**
	 * In-Game: "+N% cloak on kill"
	 */
	context(attrs: IKeyValueMap)
	var addCloakOnKill: Int?
		get() = attrs.getTyped("add cloak on kill")
		set(value) = attrs.setNullable("add cloak on kill", value)
	
	/**
	 * In-Game: "Extra effects when taunting."
	 */
	context(attrs: IKeyValueMap)
	var setBonusCustomTauntParticleAttr: Boolean?
		get() = attrs.getTyped("SET BONUS: custom taunt particle attr", BinaryIntCodec)
		set(value) = attrs.setNullable("SET BONUS: custom taunt particle attr", value, BinaryIntCodec)
}

