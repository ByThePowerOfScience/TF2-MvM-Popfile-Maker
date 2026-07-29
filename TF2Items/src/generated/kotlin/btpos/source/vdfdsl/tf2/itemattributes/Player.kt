package btpos.source.vdfdsl.tf2.itemattributes

import btpos.source.vdfdsl.modeling.*
import btpos.source.vdfdsl.serialization.codecs.*
import btpos.source.vdfdsl.tf2.itemattributes.impl.*
import btpos.source.vdfdsl.tf2.tftypes.*
import java.util.*




interface PlayerAttributes : EntityAttributes {
	
	companion object {
		val vaccinator: VaccinatorAttributes = VaccinatorAttributes()
	
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
	
		/**
		 * In-Game: "N% increased air control."
		 * 
		 * Sidenote: the jetpack always multiplies your air acceleration by 50%.
		 */
		val increasedAirControl: ItemAttributeNamed<Float> = ItemAttributeNamed("increased air control")
	
		/**
		 * In-Game: "N% increased air control when blast jumping."
		 * 
		 * Specifically while blast-jumping, as opposed to global.
		 */
		val airControlBlastJump: ItemAttributeNamed<Float> = ItemAttributeNamed("mod_air_control_blast_jump")
	
		/**
		 * In-Game: "Share Canteens with your heal target. +1 duration, -10 price per point (minimum cost: 5)"
		 * 
		 * Discounts canteens by 10 * level.
		 */
		val canteenSpecialist: ItemAttributeNamed<Int> = ItemAttributeNamed("canteen specialist")
	
		/**
		 * In-Game: "Increased Melee damage against Isolated Merc Set"
		 */
		val setBonusAlienIsolationXenoBonusPos: ItemAttributeNamed<Boolean> = ItemAttributeNamed("SET BONUS: alien isolation xeno bonus pos")
	
		/**
		 * In-Game: "Increased Nostromo Napalmer damage against Isolationist Pack Set"
		 */
		val setBonusAlienIsolationMercBonusPos: ItemAttributeNamed<Boolean> = ItemAttributeNamed("SET BONUS: alien isolation merc bonus pos")
	
		/**
		 * In-Game: "When backstabbed: Jarate attacker"
		 * 
		 * If true, jarates anyone who backstabs this player.
		 * 
		 * Note: does not block backstabs on its own.
		 */
		val jarateBackstabber: ItemAttributeNamed<Boolean> = ItemAttributeNamed("jarate backstabber")
	
		/**
		 * In-Game: "Immune to fire damage while disguised"
		 * 
		 * Prevent afterburn while disguised.
		 */
		val disguiseNoBurn: ItemAttributeNamed<Boolean> = ItemAttributeNamed("disguise no burn")
	
		val dmgTakenFromCritReduced: DmgTakenFromCritReducedAttributes = DmgTakenFromCritReducedAttributes()
	
		val dmgTakenFromFireReduced: DmgTakenFromFireReducedAttributes = DmgTakenFromFireReducedAttributes()
	
		val dmgTakenFromBlast: BonusPenalty<Float> = BonusPenalty(
			ItemAttributeNamed("dmg taken from blast reduced"),
			ItemAttributeNamed("dmg taken from blast increased"),
		)
	
		val dmgTakenFromBulletsReduced: DmgTakenFromBulletsReducedAttributes = DmgTakenFromBulletsReducedAttributes()
	
		/**
		 * In-Game: "N% damage resistance when below 50% health and spun up"
		 * 
		 * Only procs on Heavies that are currently spun up on less than 50% HP.
		 */
		val spunupDamageResistance: ItemAttributeNamed<Float> = ItemAttributeNamed("spunup_damage_resistance")
	
		/**
		 * In-Game: "N% damage vulnerability on wearer"
		 * 
		 * Multiplier to damage taken from all sources.
		 */
		val dmgTakenIncreased: ItemAttributeNamed<Float> = ItemAttributeNamed("dmg taken increased")
	
		/**
		 * In-Game: "+N% sentry damage resistance on wearer"
		 */
		val setBonusDmgFromSentryReduced: ItemAttributeNamed<Float> = ItemAttributeNamed("SET BONUS: dmg from sentry reduced")
	
		val rocketJumpDamageReduction: VisHidden<Float> = VisHidden(ItemAttributeNamed<Float>("rocket jump damage reduction"), ItemAttributeNamed<Float>("rocket jump damage reduction HIDDEN"))
	
		/**
		 * In-Game: "Wearer never takes falling damage"
		 */
		val cancelFallingDamage: ItemAttributeNamed<Boolean> = ItemAttributeNamed("cancel falling damage")
	
		/**
		 * Number of seconds the player who hit this entity should be marked for death.
		 * 
		 * If attacker is affected by `TF_COND_ENERGY_BUFF` (Crit-a-Cola, Cleaner's Carbine, Buffalo Steak, etc.), the attacker receives `TF_COND_MARKEDFORDEATH_SILENT`.
		 */
		val markAttackerForDeath: ItemAttributeNamed<Float> = ItemAttributeNamed("mod_mark_attacker_for_death")
	
		val generateRageOnDamage: GenerateRageOnDamageAttributes = GenerateRageOnDamageAttributes()
	
		/**
		 * In-Game: "On Hit: Builds Hype"
		 * 
		 * Adds the amount of damage dealt to the Scout hype meter, to a maximum of 200 damage which adds 50% meter.
		 */
		val hypeOnDamage: ItemAttributeNamed<Boolean> = ItemAttributeNamed("hype on damage")
	
		/**
		 * Only procs on Sniper. Gain this amount of rage meter on assists.
		 */
		val rageOnAssists: ItemAttributeNamed<Float> = ItemAttributeNamed("rage on assists")
	
		/**
		 * In-Game: "Killstreaks Active"
		 */
		val killstreakTier: ItemAttributeNamed<Int> = ItemAttributeNamed("killstreak tier")
	
		/**
		 * In-Game: "+N capture rate on wearer"
		 */
		val increasePlayerCaptureValue: ItemAttributeNamed<Int> = ItemAttributeNamed("increase player capture value")
	
		/**
		 * If 1, create a soccer ball on the ground when the player spawns.
		 */
		val spawnWithPhysicsToy: ItemAttributeNamed<Int> = ItemAttributeNamed("spawn with physics toy")
	
		/**
		 * If `mult_item_meter_charge_rate` is set, checks this attribute to see what type of meter should be modified, and also only allows it to activate if the active weapon is not a TF_WEAPON_FLAME_BALL.
		 */
		val itemMeterChargeType: ItemAttributeNamed<Int> = ItemAttributeNamed("item_meter_charge_type")
	
		val healthFromHealersReduced: BonusPenalty<Float> = BonusPenalty(
			ItemAttributeNamed("health from healers increased"),
			ItemAttributeNamed("health from healers reduced"),
		)
	
		/**
		 * In-Game: "N sec longer cloak blink time"
		 * 
		 * Multiplier.
		 */
		val setBonusCloakBlinkTimePenalty: ItemAttributeNamed<Float> = ItemAttributeNamed("SET BONUS: cloak blink time penalty")
	
		val multChargeTurnControl: MultChargeTurnControlAttributes = MultChargeTurnControlAttributes()
	
		/**
		 * In-Game: "Taking damage while shield charging reduces remaining charging time"
		 * 
		 * Used to detect the Tide Turner when deciding whether to give you minicrits or crits.
		 */
		val loseDemoChargeOnDamageWhenCharging: ItemAttributeNamed<Boolean> = ItemAttributeNamed("lose demo charge on damage when charging")
	
		/**
		 * In-Game: "N sec increase in time to cloak"
		 */
		val multCloakRate: ItemAttributeNamed<Float> = ItemAttributeNamed("mult cloak rate")
	
		/**
		 * In-Game: "Reduced decloak sound volume"
		 * 
		 * If true, plays `Player.Spy_UnCloakReduced` when decloaking.
		 */
		val setBonusQuietUnstealth: ItemAttributeNamed<Boolean> = ItemAttributeNamed("SET BONUS: quiet unstealth")
	
		/**
		 * In-Game: "Deals 3x falling damage to the player you land on"
		 * 
		 * Deal 3x falling damage to player you land on.
		 */
		val bootsFallingStomp: ItemAttributeNamed<Boolean> = ItemAttributeNamed("boots falling stomp")
	
		val multDecloakRate: ItemAttributeNamed<Float> = ItemAttributeNamed("mult decloak rate")
	
		/**
		 * In-Game: "Über duration increased N seconds"
		 * 
		 * Duration in seconds.
		 */
		val uberDurationBonus: ItemAttributeNamed<Float> = ItemAttributeNamed("uber duration bonus")
	
		val aimingMovespeed: AimingMovespeedAttributes = AimingMovespeedAttributes()
	
		val moveSpeed: MoveSpeedAttributes = MoveSpeedAttributes()
	
		/**
		 * In-Game: "+N% faster move speed on wearer (shield required)"
		 */
		val moveSpeedBonusShieldRequired: ItemAttributeNamed<Float> = ItemAttributeNamed("move speed bonus shield required")
	
		/**
		 * In-Game: "Wearer cannot carry the intelligence briefcase or PASS Time JACK"
		 */
		val cannotPickUpIntelligence: ItemAttributeNamed<Boolean> = ItemAttributeNamed("cannot pick up intelligence")
	
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
		 * In-Game: "N% metal cost when constructing or upgrading teleporters"
		 * 
		 * Multiplier applied to teleporter build cost.
		 */
		val teleporterCost: ItemAttributeNamed<Float> = ItemAttributeNamed("mod teleporter cost")
	
		/**
		 * In-Game: "N metal reduction in building cost"
		 * 
		 * Overrides the building cost for all buildings.
		 */
		val buildingCostReduction: ItemAttributeNamed<Int> = ItemAttributeNamed("building cost reduction")
	
		val overrideFootstepSoundSet: ItemAttributeNamed<FootstepOverride> = ItemAttributeNamed("override footstep sound set")
	
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
	
		/**
		 * Prevents player from attacking.
		 */
		val noAttack: ItemAttributeNamed<Boolean> = ItemAttributeNamed("no_attack")
	
		/**
		 * Prevents player from jumping.
		 */
		val noJump: ItemAttributeNamed<Boolean> = ItemAttributeNamed("no_jump")
	
		/**
		 * Prevents player from crouching.
		 */
		val noDuck: ItemAttributeNamed<Boolean> = ItemAttributeNamed("no_duck")
	
		/**
		 * In-Game: "Cannot carry buildings"
		 * 
		 * Prevents player from picking up buildings.
		 */
		val cannotPickUpBuildings: ItemAttributeNamed<Boolean> = ItemAttributeNamed("cannot pick up buildings")
	
		val disableWeaponSwitch: ItemAttributeNamed<Boolean> = ItemAttributeNamed("disable weapon switch")
	
		/**
		 * In-Game: "Wearer cannot disguise"
		 */
		val cannotDisguise: ItemAttributeNamed<Boolean> = ItemAttributeNamed("cannot disguise")
	
		val maxammoPrimaryReduced: BonusPenaltyHidden<Int, ItemAttributeNamed<Int>> = BonusPenaltyHidden(
			ItemAttributeNamed<Int>("maxammo primary increased"),
			ItemAttributeNamed<Int>("maxammo primary reduced"),
			ItemAttributeNamed<Int>("hidden primary max ammo bonus"),
		)
	
		val maxammoSecondaryReduced: BonusPenaltyHidden<Int, ItemAttributeNamed<Int>> = BonusPenaltyHidden(
			ItemAttributeNamed<Int>("maxammo secondary increased"),
			ItemAttributeNamed<Int>("maxammo secondary reduced"),
			ItemAttributeNamed<Int>("hidden secondary max ammo penalty"),
		)
	
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
	
		val buffType: BuffTypeAttributes = BuffTypeAttributes()
	
		val BuffDuration: VisHidden<Float> = VisHidden(ItemAttributeNamed<Float>("increase buff duration"), ItemAttributeNamed<Float>("increase buff duration HIDDEN"))
	
		/**
		 * In-Game: "Blocks healing while in use"
		 */
		val weaponBlocksHealing: ItemAttributeNamed<Boolean> = ItemAttributeNamed("mod weapon blocks healing")
	
		val healthRegen: HealthRegenAttributes = HealthRegenAttributes()
	
		/**
		 * In-Game: "+N% ammo regenerated every 5 seconds on wearer"
		 * 
		 * Percentage of ammo regenerated every 5 seconds.
		 */
		val ammoRegen: ItemAttributeNamed<Float> = ItemAttributeNamed("ammo regen")
	
		/**
		 * In-Game: "+N metal regenerated every 5 seconds on wearer"
		 * 
		 * Amount of metal regenerated every 5 seconds.
		 */
		val metalRegen: ItemAttributeNamed<Int> = ItemAttributeNamed("metal regen")
	
		val airblastVulnerabilityMultiplier: VisHidden<Float> = VisHidden(ItemAttributeNamed<Float>("airblast vulnerability multiplier"), ItemAttributeNamed<Float>("airblast vulnerability multiplier hidden"))
	
		val airblastVerticalVulnerabilityMultiplier: ItemAttributeNamed<Float> = ItemAttributeNamed("airblast vertical vulnerability multiplier")
	
		/**
		 * In-Game: "Noise Maker"
		 * 
		 * Uses noise maker when pressing action slot key.
		 */
		val noiseMaker: ItemAttributeNamed<Boolean> = ItemAttributeNamed("noise maker")
	
		/**
		 * In-Game: "Leave a Calling Card on your victims."
		 * 
		 * Defines the calling card that should be dropped when this player kills another player.
		 */
		val setBonusCallingCardOnKill: ItemAttributeNamed<Int> = ItemAttributeNamed("SET BONUS: calling card on kill")
	
		/**
		 * In-Game: "Sentry build speed increased by N%"
		 */
		val engineerSentryBuildRateMultiplier: ItemAttributeNamed<Float> = ItemAttributeNamed("engineer sentry build rate multiplier")
	
		/**
		 * In-Game: "Increases teleporter build speed by N%."
		 * 
		 * Also used for dispensers.
		 */
		val engineerTeleporterBuildRateMultiplier: ItemAttributeNamed<Float> = ItemAttributeNamed("engineer teleporter build rate multiplier")
	
		/**
		 * In-Game: "Headshots deal an extra +N% damage"
		 * 
		 * Multiplier applied to headshot damage.
		 */
		val headshotDamageIncrease: ItemAttributeNamed<Float> = ItemAttributeNamed("headshot damage increase")
	
		/**
		 * In-Game: "N% damage penalty"
		 * 
		 * More like a boolean.  Doesn't actually determine any kind of decapitation, just if it CAN decapitate.
		 * 
		 * Checked on all hitscan attacks.
		 */
		val decapitateType: ItemAttributeNamed<Int> = ItemAttributeNamed("decapitate type")
	
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
		 * Multiplier applied to rage gained by dealing damage, taking damage, or dealing burn damage.
		 */
		val rageGivingScale: ItemAttributeNamed<Float> = ItemAttributeNamed("rage giving scale")
	
		/**
		 * If the weapon is a Holy Mackerel reskin (AKA either the fish or the Unarmed Combat) and this is set, use the Unarmed Combat "arm hit" killfeed notice instead of the "fish hit" notice.
		 */
		val fishDamageOverride: ItemAttributeNamed<Boolean> = ItemAttributeNamed("fish damage override")
	
		/**
		 * In-Game: "Explode spectacularly on death"
		 */
		val bombinomiconEffectOnDeath: ItemAttributeNamed<Boolean> = ItemAttributeNamed("bombinomicon effect on death")
	
		/**
		 * In-Game: "N% less metal from pickups and dispensers"
		 * 
		 * Multiplier applied to metal gained from ammo boxes.
		 */
		val metalPickupDecreased: ItemAttributeNamed<Float> = ItemAttributeNamed("metal_pickup_decreased")
	
		/**
		 * In-Game: "+N max health on wearer"
		 * 
		 * Additive base-health increase.
		 */
		val hiddenMaxhealthNonBuffed: ItemAttributeNamed<Int> = ItemAttributeNamed("hidden maxhealth non buffed")
	
		val maxHealthAdditive: MaxHealthAdditiveAttributes = MaxHealthAdditiveAttributes()
	
		val unlimitedQuantity: VisHidden<Boolean> = VisHidden(ItemAttributeNamed<Boolean>("unlimited quantity"), ItemAttributeNamed<Boolean>("unlimited quantity hidden"))
	
		/**
		 * If true, the zombiezombiezombiezombie skin is equipped.
		 */
		val zombiezombiezombiezombie: ItemAttributeNamed<Boolean> = ItemAttributeNamed("zombiezombiezombiezombie")
	
		/**
		 * In-Game: "+N% faster taunt speed on wearer"
		 * 
		 * Multiplier applied to taunt speed.
		 */
		val gestureSpeedIncrease: ItemAttributeNamed<Float> = ItemAttributeNamed("gesture speed increase")
	
		/**
		 * Sound to be played when performing a taunt.
		 */
		val cosmeticTauntSound: ItemAttributeNamed<String> = ItemAttributeNamed("cosmetic taunt sound")
	
		/**
		 * DSP used when emitting sounds created by this player.
		 */
		val setBonusSpecialDsp: ItemAttributeNamed<Int> = ItemAttributeNamed("SET BONUS: special dsp")
	
		/**
		 * In-Game: "Disables double jump"
		 */
		val headScale: ItemAttributeNamed<Float> = ItemAttributeNamed("head scale")
	
		val torsoScale: ItemAttributeNamed<Float> = ItemAttributeNamed("torso scale")
	
		val handScale: ItemAttributeNamed<Float> = ItemAttributeNamed("hand scale")
	
		val onDamageTaken: OnDamageTakenAttributes = OnDamageTakenAttributes()
	
		val onKill: OnKillAttributes = OnKillAttributes()
	
		val denyResupply: DenyResupplyAttributes = DenyResupplyAttributes()
	
		val scoutOnly: ScoutOnlyAttributes = ScoutOnlyAttributes()
	
		val demomanOnly: DemomanOnlyAttributes = DemomanOnlyAttributes()
	
		val sniperOnly: SniperOnlyAttributes = SniperOnlyAttributes()
	
		val medicOnly: MedicOnlyAttributes = MedicOnlyAttributes()
	
		val spyOnly: SpyOnlyAttributes = SpyOnlyAttributes()
	
		val jumpHeight: JumpHeightAttributes = JumpHeightAttributes()
	
		val buildings: BuildingsAttributes = BuildingsAttributes()
	}

	val vaccinator: VaccinatorAttributes get() = PlayerAttributes.vaccinator
	
	/**
	 * In-Game: "Allows you to see enemy health"
	 */
	val seeEnemyHealth: ItemAttributeNamed<Boolean> get() = PlayerAttributes.seeEnemyHealth
	
	/**
	 * In-Game: "Unable to see enemy health"
	 * 
	 * Always true in MvM.
	 */
	val hideEnemyHealth: ItemAttributeNamed<Boolean> get() = PlayerAttributes.hideEnemyHealth
	
	override val jumpHeight: JumpHeightAttributes get() = PlayerAttributes.jumpHeight
	
	/**
	 * In-Game: "Boost reduced on air jumps"
	 * 
	 * The amount to be subtracted from the hype meter when the Scout double-jumps.
	 */
	override val hypeResetsOnJump: ItemAttributeNamed<Int> get() = super.hypeResetsOnJump
	
	/**
	 * Allows the parachute to be deployed.
	 */
	override val parachuteAttribute: ItemAttributeNamed<Boolean> get() = super.parachuteAttribute
	
	/**
	 * In-Game: "N% increased air control."
	 * 
	 * Sidenote: the jetpack always multiplies your air acceleration by 50%.
	 */
	val increasedAirControl: ItemAttributeNamed<Float> get() = PlayerAttributes.increasedAirControl
	
	/**
	 * In-Game: "N% increased air control when blast jumping."
	 * 
	 * Specifically while blast-jumping, as opposed to global.
	 */
	val airControlBlastJump: ItemAttributeNamed<Float> get() = PlayerAttributes.airControlBlastJump
	
	/**
	 * In-Game: "Share Canteens with your heal target. +1 duration, -10 price per point (minimum cost: 5)"
	 * 
	 * Discounts canteens by 10 * level.
	 */
	val canteenSpecialist: ItemAttributeNamed<Int> get() = PlayerAttributes.canteenSpecialist
	
	/**
	 * In-Game: "Increased Melee damage against Isolated Merc Set"
	 */
	val setBonusAlienIsolationXenoBonusPos: ItemAttributeNamed<Boolean> get() = PlayerAttributes.setBonusAlienIsolationXenoBonusPos
	
	/**
	 * In-Game: "Increased Nostromo Napalmer damage against Isolationist Pack Set"
	 */
	val setBonusAlienIsolationMercBonusPos: ItemAttributeNamed<Boolean> get() = PlayerAttributes.setBonusAlienIsolationMercBonusPos
	
	/**
	 * In-Game: "When backstabbed: Jarate attacker"
	 * 
	 * If true, jarates anyone who backstabs this player.
	 * 
	 * Note: does not block backstabs on its own.
	 */
	val jarateBackstabber: ItemAttributeNamed<Boolean> get() = PlayerAttributes.jarateBackstabber
	
	/**
	 * In-Game: "Immune to fire damage while disguised"
	 * 
	 * Prevent afterburn while disguised.
	 */
	val disguiseNoBurn: ItemAttributeNamed<Boolean> get() = PlayerAttributes.disguiseNoBurn
	
	val dmgTakenFromCritReduced: DmgTakenFromCritReducedAttributes get() = PlayerAttributes.dmgTakenFromCritReduced
	
	val dmgTakenFromFireReduced: DmgTakenFromFireReducedAttributes get() = PlayerAttributes.dmgTakenFromFireReduced
	
	val dmgTakenFromBlast: BonusPenalty<Float> get() = PlayerAttributes.dmgTakenFromBlast
	
	val dmgTakenFromBulletsReduced: DmgTakenFromBulletsReducedAttributes get() = PlayerAttributes.dmgTakenFromBulletsReduced
	
	/**
	 * In-Game: "N% damage resistance when below 50% health and spun up"
	 * 
	 * Only procs on Heavies that are currently spun up on less than 50% HP.
	 */
	val spunupDamageResistance: ItemAttributeNamed<Float> get() = PlayerAttributes.spunupDamageResistance
	
	/**
	 * In-Game: "N% damage vulnerability on wearer"
	 * 
	 * Multiplier to damage taken from all sources.
	 */
	val dmgTakenIncreased: ItemAttributeNamed<Float> get() = PlayerAttributes.dmgTakenIncreased
	
	/**
	 * In-Game: "+N% sentry damage resistance on wearer"
	 */
	val setBonusDmgFromSentryReduced: ItemAttributeNamed<Float> get() = PlayerAttributes.setBonusDmgFromSentryReduced
	
	val rocketJumpDamageReduction: VisHidden<Float> get() = PlayerAttributes.rocketJumpDamageReduction
	
	/**
	 * In-Game: "Wearer never takes falling damage"
	 */
	val cancelFallingDamage: ItemAttributeNamed<Boolean> get() = PlayerAttributes.cancelFallingDamage
	
	/**
	 * Number of seconds the player who hit this entity should be marked for death.
	 * 
	 * If attacker is affected by `TF_COND_ENERGY_BUFF` (Crit-a-Cola, Cleaner's Carbine, Buffalo Steak, etc.), the attacker receives `TF_COND_MARKEDFORDEATH_SILENT`.
	 */
	val markAttackerForDeath: ItemAttributeNamed<Float> get() = PlayerAttributes.markAttackerForDeath
	
	val generateRageOnDamage: GenerateRageOnDamageAttributes get() = PlayerAttributes.generateRageOnDamage
	
	/**
	 * In-Game: "On Hit: Builds Hype"
	 * 
	 * Adds the amount of damage dealt to the Scout hype meter, to a maximum of 200 damage which adds 50% meter.
	 */
	val hypeOnDamage: ItemAttributeNamed<Boolean> get() = PlayerAttributes.hypeOnDamage
	
	/**
	 * Only procs on Sniper. Gain this amount of rage meter on assists.
	 */
	val rageOnAssists: ItemAttributeNamed<Float> get() = PlayerAttributes.rageOnAssists
	
	/**
	 * In-Game: "Killstreaks Active"
	 */
	val killstreakTier: ItemAttributeNamed<Int> get() = PlayerAttributes.killstreakTier
	
	/**
	 * In-Game: "+N capture rate on wearer"
	 */
	val increasePlayerCaptureValue: ItemAttributeNamed<Int> get() = PlayerAttributes.increasePlayerCaptureValue
	
	/**
	 * If 1, create a soccer ball on the ground when the player spawns.
	 */
	val spawnWithPhysicsToy: ItemAttributeNamed<Int> get() = PlayerAttributes.spawnWithPhysicsToy
	
	/**
	 * If `mult_item_meter_charge_rate` is set, checks this attribute to see what type of meter should be modified, and also only allows it to activate if the active weapon is not a TF_WEAPON_FLAME_BALL.
	 */
	val itemMeterChargeType: ItemAttributeNamed<Int> get() = PlayerAttributes.itemMeterChargeType
	
	val healthFromHealersReduced: BonusPenalty<Float> get() = PlayerAttributes.healthFromHealersReduced
	
	/**
	 * In-Game: "N sec longer cloak blink time"
	 * 
	 * Multiplier.
	 */
	val setBonusCloakBlinkTimePenalty: ItemAttributeNamed<Float> get() = PlayerAttributes.setBonusCloakBlinkTimePenalty
	
	val multChargeTurnControl: MultChargeTurnControlAttributes get() = PlayerAttributes.multChargeTurnControl
	
	/**
	 * In-Game: "Taking damage while shield charging reduces remaining charging time"
	 * 
	 * Used to detect the Tide Turner when deciding whether to give you minicrits or crits.
	 */
	val loseDemoChargeOnDamageWhenCharging: ItemAttributeNamed<Boolean> get() = PlayerAttributes.loseDemoChargeOnDamageWhenCharging
	
	/**
	 * In-Game: "N sec increase in time to cloak"
	 */
	val multCloakRate: ItemAttributeNamed<Float> get() = PlayerAttributes.multCloakRate
	
	/**
	 * In-Game: "Reduced decloak sound volume"
	 * 
	 * If true, plays `Player.Spy_UnCloakReduced` when decloaking.
	 */
	val setBonusQuietUnstealth: ItemAttributeNamed<Boolean> get() = PlayerAttributes.setBonusQuietUnstealth
	
	/**
	 * In-Game: "Deals 3x falling damage to the player you land on"
	 * 
	 * Deal 3x falling damage to player you land on.
	 */
	val bootsFallingStomp: ItemAttributeNamed<Boolean> get() = PlayerAttributes.bootsFallingStomp
	
	val multDecloakRate: ItemAttributeNamed<Float> get() = PlayerAttributes.multDecloakRate
	
	/**
	 * In-Game: "Über duration increased N seconds"
	 * 
	 * Duration in seconds.
	 */
	val uberDurationBonus: ItemAttributeNamed<Float> get() = PlayerAttributes.uberDurationBonus
	
	val aimingMovespeed: AimingMovespeedAttributes get() = PlayerAttributes.aimingMovespeed
	
	val moveSpeed: MoveSpeedAttributes get() = PlayerAttributes.moveSpeed
	
	/**
	 * In-Game: "+N% faster move speed on wearer (shield required)"
	 */
	val moveSpeedBonusShieldRequired: ItemAttributeNamed<Float> get() = PlayerAttributes.moveSpeedBonusShieldRequired
	
	/**
	 * In-Game: "Wearer cannot carry the intelligence briefcase or PASS Time JACK"
	 */
	val cannotPickUpIntelligence: ItemAttributeNamed<Boolean> get() = PlayerAttributes.cannotPickUpIntelligence
	
	/**
	 * In-Game: "Build +N additional disposable-sentry"
	 * 
	 * Number of disposable sentries you're allowed to build.
	 * 
	 * Checked when checking if the player can build something.
	 * 
	 * Only works if the "uses upgrades" gamerule is set.
	 */
	val engyDisposableSentries: ItemAttributeNamed<Int> get() = PlayerAttributes.engyDisposableSentries
	
	/**
	 * In-Game: "N% metal cost when constructing or upgrading teleporters"
	 * 
	 * Multiplier applied to teleporter build cost.
	 */
	val teleporterCost: ItemAttributeNamed<Float> get() = PlayerAttributes.teleporterCost
	
	/**
	 * In-Game: "N metal reduction in building cost"
	 * 
	 * Overrides the building cost for all buildings.
	 */
	val buildingCostReduction: ItemAttributeNamed<Int> get() = PlayerAttributes.buildingCostReduction
	
	val overrideFootstepSoundSet: ItemAttributeNamed<FootstepOverride> get() = PlayerAttributes.overrideFootstepSoundSet
	
	/**
	 * In-Game: "Jingle all the way"
	 * 
	 * If 1, use xmas.jingle, if 2 or higher use xmas.jingle_higher.
	 */
	val addJingleToFootsteps: ItemAttributeNamed<Int> get() = PlayerAttributes.addJingleToFootsteps
	
	/**
	 * In-Game: "N"
	 * 
	 * Decimal version of the 4-byte hex code determining color of footsteps (e.g. `0xFFFFFFFF`, but in decimal).
	 */
	val spellSetHalloweenFootstepType: ItemAttributeNamed<Int> get() = PlayerAttributes.spellSetHalloweenFootstepType
	
	/**
	 * Prevents player from attacking.
	 */
	val noAttack: ItemAttributeNamed<Boolean> get() = PlayerAttributes.noAttack
	
	/**
	 * Prevents player from jumping.
	 */
	val noJump: ItemAttributeNamed<Boolean> get() = PlayerAttributes.noJump
	
	/**
	 * Prevents player from crouching.
	 */
	val noDuck: ItemAttributeNamed<Boolean> get() = PlayerAttributes.noDuck
	
	/**
	 * In-Game: "Cannot carry buildings"
	 * 
	 * Prevents player from picking up buildings.
	 */
	val cannotPickUpBuildings: ItemAttributeNamed<Boolean> get() = PlayerAttributes.cannotPickUpBuildings
	
	val disableWeaponSwitch: ItemAttributeNamed<Boolean> get() = PlayerAttributes.disableWeaponSwitch
	
	/**
	 * In-Game: "Wearer cannot disguise"
	 */
	val cannotDisguise: ItemAttributeNamed<Boolean> get() = PlayerAttributes.cannotDisguise
	
	val maxammoPrimaryReduced: BonusPenaltyHidden<Int, ItemAttributeNamed<Int>> get() = PlayerAttributes.maxammoPrimaryReduced
	
	val maxammoSecondaryReduced: BonusPenaltyHidden<Int, ItemAttributeNamed<Int>> get() = PlayerAttributes.maxammoSecondaryReduced
	
	val maxammoMetalReduced: BonusPenalty<Int> get() = PlayerAttributes.maxammoMetalReduced
	
	/**
	 * In-Game: "+N% max misc ammo on wearer"
	 * 
	 * Only used for bat balls.
	 */
	val maxammoGrenades1Increased: ItemAttributeNamed<Int> get() = PlayerAttributes.maxammoGrenades1Increased
	
	val buffType: BuffTypeAttributes get() = PlayerAttributes.buffType
	
	val BuffDuration: VisHidden<Float> get() = PlayerAttributes.BuffDuration
	
	/**
	 * In-Game: "Blocks healing while in use"
	 */
	val weaponBlocksHealing: ItemAttributeNamed<Boolean> get() = PlayerAttributes.weaponBlocksHealing
	
	val healthRegen: HealthRegenAttributes get() = PlayerAttributes.healthRegen
	
	/**
	 * In-Game: "+N% ammo regenerated every 5 seconds on wearer"
	 * 
	 * Percentage of ammo regenerated every 5 seconds.
	 */
	val ammoRegen: ItemAttributeNamed<Float> get() = PlayerAttributes.ammoRegen
	
	/**
	 * In-Game: "+N metal regenerated every 5 seconds on wearer"
	 * 
	 * Amount of metal regenerated every 5 seconds.
	 */
	val metalRegen: ItemAttributeNamed<Int> get() = PlayerAttributes.metalRegen
	
	val airblastVulnerabilityMultiplier: VisHidden<Float> get() = PlayerAttributes.airblastVulnerabilityMultiplier
	
	val airblastVerticalVulnerabilityMultiplier: ItemAttributeNamed<Float> get() = PlayerAttributes.airblastVerticalVulnerabilityMultiplier
	
	/**
	 * In-Game: "Noise Maker"
	 * 
	 * Uses noise maker when pressing action slot key.
	 */
	val noiseMaker: ItemAttributeNamed<Boolean> get() = PlayerAttributes.noiseMaker
	
	/**
	 * In-Game: "Leave a Calling Card on your victims."
	 * 
	 * Defines the calling card that should be dropped when this player kills another player.
	 */
	val setBonusCallingCardOnKill: ItemAttributeNamed<Int> get() = PlayerAttributes.setBonusCallingCardOnKill
	
	/**
	 * In-Game: "Sentry build speed increased by N%"
	 */
	val engineerSentryBuildRateMultiplier: ItemAttributeNamed<Float> get() = PlayerAttributes.engineerSentryBuildRateMultiplier
	
	/**
	 * In-Game: "Increases teleporter build speed by N%."
	 * 
	 * Also used for dispensers.
	 */
	val engineerTeleporterBuildRateMultiplier: ItemAttributeNamed<Float> get() = PlayerAttributes.engineerTeleporterBuildRateMultiplier
	
	/**
	 * In-Game: "Headshots deal an extra +N% damage"
	 * 
	 * Multiplier applied to headshot damage.
	 */
	val headshotDamageIncrease: ItemAttributeNamed<Float> get() = PlayerAttributes.headshotDamageIncrease
	
	/**
	 * In-Game: "N% damage penalty"
	 * 
	 * More like a boolean.  Doesn't actually determine any kind of decapitation, just if it CAN decapitate.
	 * 
	 * Checked on all hitscan attacks.
	 */
	val decapitateType: ItemAttributeNamed<Int> get() = PlayerAttributes.decapitateType
	
	/**
	 * In-Game: "Push enemies back when you land (force and radius based on velocity)"
	 * 
	 * Requires player to have the `TF_COND_ROCKETPACK` condition.
	 * 
	 * Pushes back nearby players around the landing site.
	 */
	val fallingImpactRadiusPushback: ItemAttributeNamed<Boolean> get() = PlayerAttributes.fallingImpactRadiusPushback
	
	/**
	 * In-Game: "Stun enemies when you land"
	 * 
	 * If `falling_impact_radius_pushback` is set, this will also stun any enemies in the impact radius.
	 */
	val fallingImpactRadiusStun: ItemAttributeNamed<Boolean> get() = PlayerAttributes.fallingImpactRadiusStun
	
	/**
	 * Multiplier applied to rage gained by dealing damage, taking damage, or dealing burn damage.
	 */
	val rageGivingScale: ItemAttributeNamed<Float> get() = PlayerAttributes.rageGivingScale
	
	/**
	 * If the weapon is a Holy Mackerel reskin (AKA either the fish or the Unarmed Combat) and this is set, use the Unarmed Combat "arm hit" killfeed notice instead of the "fish hit" notice.
	 */
	val fishDamageOverride: ItemAttributeNamed<Boolean> get() = PlayerAttributes.fishDamageOverride
	
	/**
	 * In-Game: "Explode spectacularly on death"
	 */
	val bombinomiconEffectOnDeath: ItemAttributeNamed<Boolean> get() = PlayerAttributes.bombinomiconEffectOnDeath
	
	/**
	 * In-Game: "N% less metal from pickups and dispensers"
	 * 
	 * Multiplier applied to metal gained from ammo boxes.
	 */
	val metalPickupDecreased: ItemAttributeNamed<Float> get() = PlayerAttributes.metalPickupDecreased
	
	/**
	 * In-Game: "+N max health on wearer"
	 * 
	 * Additive base-health increase.
	 */
	val hiddenMaxhealthNonBuffed: ItemAttributeNamed<Int> get() = PlayerAttributes.hiddenMaxhealthNonBuffed
	
	val maxHealthAdditive: MaxHealthAdditiveAttributes get() = PlayerAttributes.maxHealthAdditive
	
	val unlimitedQuantity: VisHidden<Boolean> get() = PlayerAttributes.unlimitedQuantity
	
	/**
	 * If true, the zombiezombiezombiezombie skin is equipped.
	 */
	val zombiezombiezombiezombie: ItemAttributeNamed<Boolean> get() = PlayerAttributes.zombiezombiezombiezombie
	
	/**
	 * In-Game: "+N% faster taunt speed on wearer"
	 * 
	 * Multiplier applied to taunt speed.
	 */
	val gestureSpeedIncrease: ItemAttributeNamed<Float> get() = PlayerAttributes.gestureSpeedIncrease
	
	/**
	 * Sound to be played when performing a taunt.
	 */
	val cosmeticTauntSound: ItemAttributeNamed<String> get() = PlayerAttributes.cosmeticTauntSound
	
	/**
	 * DSP used when emitting sounds created by this player.
	 */
	val setBonusSpecialDsp: ItemAttributeNamed<Int> get() = PlayerAttributes.setBonusSpecialDsp
	
	/**
	 * In-Game: "Disables double jump"
	 */
	val headScale: ItemAttributeNamed<Float> get() = PlayerAttributes.headScale
	
	val torsoScale: ItemAttributeNamed<Float> get() = PlayerAttributes.torsoScale
	
	val handScale: ItemAttributeNamed<Float> get() = PlayerAttributes.handScale
	
	val onDamageTaken: OnDamageTakenAttributes get() = PlayerAttributes.onDamageTaken
	
	val onKill: OnKillAttributes get() = PlayerAttributes.onKill
	
	val denyResupply: DenyResupplyAttributes get() = PlayerAttributes.denyResupply
	
	val scoutOnly: ScoutOnlyAttributes get() = PlayerAttributes.scoutOnly
	
	val demomanOnly: DemomanOnlyAttributes get() = PlayerAttributes.demomanOnly
	
	val sniperOnly: SniperOnlyAttributes get() = PlayerAttributes.sniperOnly
	
	val medicOnly: MedicOnlyAttributes get() = PlayerAttributes.medicOnly
	
	val spyOnly: SpyOnlyAttributes get() = PlayerAttributes.spyOnly
	
	override val buildings: BuildingsAttributes get() = PlayerAttributes.buildings

	
	open class VaccinatorAttributes : IBlockScoped {
		/**
		 * Multiplier to damage taken if player has  TF_COND_MEDIGUN_UBER_BULLET_RESIST.
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
	
	
	open class JumpHeightAttributes : EntityAttributes.JumpHeightAttributes() {
		/**
		 * In-Game: "+N% greater jump height when active"
		 */
		override val increasedJumpHeight: ItemAttributeNamed<Float> get() = super.increasedJumpHeight
	
		override val majorIncreasedJumpHeight: ItemAttributeNamed<Float> get() = super.majorIncreasedJumpHeight
	
		override val halloweenIncreasedJumpHeight: ItemAttributeNamed<Float> get() = super.halloweenIncreasedJumpHeight
	}
	
	
	open class DmgTakenFromCritReducedAttributes : IBlockScoped {
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
	
	
	open class DmgTakenFromFireReducedAttributes : IBlockScoped {
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
	
	
	open class DmgTakenFromBulletsReducedAttributes : IBlockScoped {
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
	
	
	open class GenerateRageOnDamageAttributes : IBlockScoped {
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
	
	
	open class MultChargeTurnControlAttributes : IBlockScoped {
		/**
		 * In-Game: "+N% increase in turning control while charging"
		 * 
		 * Default is 0.45f, and this class is a multiplier applied to it.
		 */
		open val multChargeTurnControl: ItemAttributeNamed<Float> = ItemAttributeNamed("mult charge turn control")
	
		/**
		 * In-Game: "Full turning control while charging"
		 * 
		 * Default is 0.45f, and this class is a multiplier applied to it.
		 */
		open val fullChargeTurnControl: ItemAttributeNamed<Float> = ItemAttributeNamed("full charge turn control")
	}
	
	
	open class AimingMovespeedAttributes : IBlockScoped {
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
	
	
	open class MoveSpeedAttributes : IBlockScoped {
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
	
	
	open class BuffTypeAttributes : IBlockScoped {
		/**
		 * Note that Phlogistinator's rage has a small cooldown after expiring before it can gain rage again, to prevent the lingering crit flames from immediately filling it up again.
		 */
		open val soldierBuffType: ItemAttributeNamed<Int> = ItemAttributeNamed("mod soldier buff type")
	
		/**
		 * Note that Phlogistinator's rage has a small cooldown after expiring before it can gain rage again, to prevent the lingering crit flames from immediately filling it up again.
		 */
		open val demoBuffType: ItemAttributeNamed<Int> = ItemAttributeNamed("mod demo buff type")
	}
	
	
	open class HealthRegenAttributes : IBlockScoped {
		/**
		 * In-Game: "+N health regenerated per second on wearer"
		 * 
		 * Amount of health regenerated per regen tick.  Scales by the amount of time since the player last took damage in non-MvM modes.
		 */
		open val healthRegen: ItemAttributeNamed<Float> = ItemAttributeNamed("health regen")
	
		/**
		 * In-Game: "N health drained per second on wearer"
		 * 
		 * Amount of health regenerated per regen tick.  Scales by the amount of time since the player last took damage in non-MvM modes.
		 */
		open val healthDrain: ItemAttributeNamed<Float> = ItemAttributeNamed("health drain")
	
		/**
		 * In-Game: "+N health regenerated per second on wearer"
		 * 
		 * Amount of health regenerated per regen tick.  Scales by the amount of time since the player last took damage in non-MvM modes.
		 */
		open val setBonusHealthRegenSetBonus: ItemAttributeNamed<Float> = ItemAttributeNamed("SET BONUS: health regen set bonus")
	
		/**
		 * In-Game: "N health regenerated per second on wearer"
		 * 
		 * Amount of health regenerated per regen tick.  Scales by the amount of time since the player last took damage in non-MvM modes.
		 */
		open val healthDrainMedic: ItemAttributeNamed<Float> = ItemAttributeNamed("health drain medic")
	
		/**
		 * In-Game: "+N health regenerated per second on wearer"
		 * 
		 * Amount of health regenerated per regen tick.  Scales by the amount of time since the player last took damage in non-MvM modes.
		 */
		open val cardHealthRegen: ItemAttributeNamed<Float> = ItemAttributeNamed("CARD: health regen")
	}
	
	
	open class MaxHealthAdditiveAttributes : IBlockScoped {
		/**
		 * In-Game: "+N max health on wearer"
		 * 
		 * Additive maximum health increase only used when overhealing.
		 */
		open val maxHealthAdditiveBonus: ItemAttributeNamed<Int> = ItemAttributeNamed("max health additive bonus")
	
		/**
		 * In-Game: "N max health on wearer"
		 * 
		 * Additive maximum health increase only used when overhealing.
		 */
		open val maxHealthAdditivePenalty: ItemAttributeNamed<Int> = ItemAttributeNamed("max health additive penalty")
	
		/**
		 * In-Game: "+N max health on wearer"
		 * 
		 * Additive maximum health increase only used when overhealing.
		 */
		open val setBonusMaxHealthAdditiveBonus: ItemAttributeNamed<Int> = ItemAttributeNamed("SET BONUS: max health additive bonus")
	}
	
	
	open class OnDamageTakenAttributes : IBlockScoped {
		open val dmgTakenFromBlast: BonusPenalty<Float> = BonusPenalty(
			ItemAttributeNamed("dmg taken from blast reduced"),
			ItemAttributeNamed("dmg taken from blast increased"),
		)
	
		/**
		 * In-Game: "N% damage resistance when below 50% health and spun up"
		 * 
		 * Only procs on Heavies that are currently spun up on less than 50% HP.
		 */
		open val spunupDamageResistance: ItemAttributeNamed<Float> = ItemAttributeNamed("spunup_damage_resistance")
	
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
	
		open val dmgTakenFromCritReduced: DmgTakenFromCritReducedAttributes = DmgTakenFromCritReducedAttributes()
	
		open val dmgTakenFromFireReduced: DmgTakenFromFireReducedAttributes = DmgTakenFromFireReducedAttributes()
	
		open val dmgTakenFromBulletsReduced: DmgTakenFromBulletsReducedAttributes = DmgTakenFromBulletsReducedAttributes()
	
	
		open class DmgTakenFromCritReducedAttributes : IBlockScoped {
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
	
	
		open class DmgTakenFromFireReducedAttributes : IBlockScoped {
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
	
	
		open class DmgTakenFromBulletsReducedAttributes : IBlockScoped {
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
	}
	
	
	open class OnKillAttributes : IBlockScoped {
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
	}
	
	
	open class DenyResupplyAttributes : IBlockScoped {
		open val grenades1ResupplyDenied: ItemAttributeNamed<Boolean> = ItemAttributeNamed("grenades1_resupply_denied")
	
		open val grenades2ResupplyDenied: ItemAttributeNamed<Boolean> = ItemAttributeNamed("grenades2_resupply_denied")
	
		open val grenades3ResupplyDenied: ItemAttributeNamed<Boolean> = ItemAttributeNamed("grenades3_resupply_denied")
	}
	
	
	open class ScoutOnlyAttributes : IBlockScoped {
		/**
		 * In-Game: "Disables double jump"
		 */
		open val noDoubleJump: ItemAttributeNamed<Boolean> = ItemAttributeNamed("no double jump")
	
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
	}
	
	
	open class DemomanOnlyAttributes : IBlockScoped {
		/**
		 * In-Game: "Taking damage while shield charging reduces remaining charging time"
		 */
		open val loseDemoChargeOnDamageWhenCharging: ItemAttributeNamed<Boolean> = ItemAttributeNamed("lose demo charge on damage when charging")
	
		/**
		 * In-Game: "Melee kills refill N% of your charge meter."
		 * 
		 * Amount of Targe-Charge gained on kill.  Scaled by various values.
		 */
		open val killRefillsMeter: ItemAttributeNamed<Float> = ItemAttributeNamed("kill refills meter")
	
		/**
		 * In-Game: "N% damage penalty"
		 * 
		 * If true, reduces max health gained from Knockout rune to 20.
		 */
		open val decapitateType: ItemAttributeNamed<Boolean> = ItemAttributeNamed("decapitate type")
	
		open val chargeTime: VisHidden<Float> = VisHidden(ItemAttributeNamed<Float>("charge time increased"), ItemAttributeNamed<Float>("charge time decreased"))
	
		/**
		 * In-Game: "+N% increase in charge recharge rate"
		 * 
		 * Only applies to Demoman.
		 */
		open val chargeRechargeRateIncreased: ItemAttributeNamed<Float> = ItemAttributeNamed("charge recharge rate increased")
	}
	
	
	open class SniperOnlyAttributes : IBlockScoped {
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
	
	
	open class MedicOnlyAttributes : IBlockScoped {
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
	
	
	open class SpyOnlyAttributes : IBlockScoped {
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
	
	
	open class BuildingsAttributes : EntityAttributes.BuildingsAttributes() {
		override val sentryGun: SentryGunAttributes = SentryGunAttributes()
	
		override val dispenser: DispenserAttributes = DispenserAttributes()
	
		override val teleporter: TeleporterAttributes = TeleporterAttributes()
	
	
		open class SentryGunAttributes : EntityAttributes.BuildingsAttributes.SentryGunAttributes() 
	
	
		open class DispenserAttributes : EntityAttributes.BuildingsAttributes.DispenserAttributes() 
	
	
		open class TeleporterAttributes : EntityAttributes.BuildingsAttributes.TeleporterAttributes() 
	}
}