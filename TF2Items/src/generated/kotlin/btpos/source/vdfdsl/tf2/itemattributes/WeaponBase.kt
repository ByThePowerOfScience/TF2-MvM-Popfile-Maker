package btpos.source.vdfdsl.tf2.itemattributes

import btpos.source.vdfdsl.modeling.*
import btpos.source.vdfdsl.serialization.codecs.*
import btpos.source.vdfdsl.tf2.itemattributes.impl.*
import btpos.source.vdfdsl.tf2.tftypes.*
import java.util.*




interface WeaponBaseAttributes : IBlockScoped {
	companion object {
		/**
		 * In-Game: "Ammo boxes collected also give Charge"
		 *
		 * 
		 *
		 * If true, and player has a demoman charge meter, add charge based on ammo pack size.
		 */
		val ammoPacksGiveDemoknightCharge = ItemAttributeNamed<Boolean>("ammo gives charge")
		
		/**
		 * In-Game: "No ammo from dispensers when active"
		 *
		 * 
		 */
		val noPrimaryAmmoFromDispensersWhileActive = ItemAttributeNamed<Boolean>("no primary ammo from dispensers while active")
		
		/**
		 * In-Game: "No metal from dispensers when active."
		 *
		 * 
		 */
		val noMetalFromDispensersWhileActive = ItemAttributeNamed<Boolean>("no metal from dispensers while active")
		
		/**
		 * Bonus:
		 *
		 * 	- In-Game: "+N% damage vs buildings"
		 *
		 * 
		 *
		 * Penalty:
		 *
		 * 	- In-Game: "N% damage penalty vs buildings"
		 *
		 * 
		 */
		val dmgVsBuildings = BonusPenalty(
			ItemAttributeNamed<Float>("dmg bonus vs buildings"),
			ItemAttributeNamed<Float>("dmg penalty vs buildings")
		)
		
		/**
		 * Bonus:
		 *
		 * 	- In-Game: "+N% clip size"
		 *
		 * 
		 *
		 * Penalty:
		 *
		 * 	- Visible:
		 *
		 * 		- In-Game: "N% clip size"
		 *
		 * 	- Hidden:
		 *
		 * 		- In-Game: "N% clip size"
		 *
		 * 
		 */
		val clipSize = BonusPenalty(
			ItemAttributeNamed<Float>("clip size bonus"),
			VisHidden("ItemAttributeNamed<Float>("clip size penalty")", "ItemAttributeNamed<Float>("clip size penalty HIDDEN")")
		)
		
		/**
		 * In-Game: "+N% clip size"
		 *
		 * 
		 */
		val clipSizeBonusUpgrade = ItemAttributeNamed<Int>("clip size bonus upgrade")
		
		/**
		 * In-Game: "+N clip size"
		 *
		 * 
		 *
		 * MVM attribute that specifically handles rocket and grenade launchers.
		 *
		 * Note that all three of these are different classes, which means they stack.
		 */
		val clipSizeUpgradeAtomic = ItemAttributeNamed<Int>("clip size upgrade atomic")
		
		/**
		 * In-Game: "Clip size increased on kill"
		 *
		 * 
		 */
		val clipsizeIncreaseOnKill = ItemAttributeNamed<Int>("clipsize increase on kill")
		
		/**
		 * In-Game: "Replaces the Sentry with a Mini-Sentry"
		 *
		 * 
		 *
		 * cast to an int, used as a boolean, so idk.
		 *
		 * Determines the hand used in the model.
		 */
		val wrenchBuildsMinisentry = ItemAttributeNamed<Float>("mod wrench builds minisentry")
		
		/**
		 * Bonus:
		 *
		 * 	- In-Game: "N% faster weapon switch"
		 *
		 * 
		 *
		 * Penalty:
		 *
		 * 	- In-Game: "N% longer weapon switch"
		 *
		 * 
		 *
		 * Checked on player.
		 */
		val deployTime = BonusPenalty(
			ItemAttributeNamed<Float>("deploy time decreased"),
			ItemAttributeNamed<Float>("deploy time increased")
		)
		
		/**
		 * Bonus:
		 *
		 * 	- In-Game: "This weapon deploys N% faster"
		 *
		 * 
		 *
		 * Penalty:
		 *
		 * 	- In-Game: "This weapon deploys N% slower"
		 *
		 * 
		 */
		val singleWepDeployTime = BonusPenalty(
			ItemAttributeNamed<Float>("single wep deploy time decreased"),
			ItemAttributeNamed<Float>("single wep deploy time increased")
		)
		
		/**
		 * Bonus:
		 *
		 * 	- In-Game: "This weapon holsters N% faster"
		 *
		 * 
		 *
		 * Penalty:
		 *
		 * 	- In-Game: "This weapon holsters N% slower"
		 *
		 * 
		 */
		val singleWepHolsterTime = BonusPenalty(
			ItemAttributeNamed<Float>("switch from wep deploy time decreased"),
			ItemAttributeNamed<Float>("single wep holster time increased")
		)
		
		/**
		 * In-Game: "This Weapon has a large melee range and deploys and holsters slower"
		 *
		 * 
		 *
		 * If true, make weapon deploy and holster 75% slower.
		 */
		val isASword = ItemAttributeNamed<Boolean>("is_a_sword")
		
		/**
		 * In-Game: "While not being healed by a medic, your weapon switch time is N% longer"
		 *
		 * 
		 *
		 * Multiplier applied if NOT being healed by a medic.
		 *
		 * Checked on player.
		 */
		val medicHealedDeployTimePenalty = ItemAttributeNamed<Float>("mod medic healed deploy time penalty")
		
		/**
		 * 
		 *
		 * Should force switch to this item when... something happens.  Probably when your current weapon is unavailable?.
		 */
		val forceWeaponSwitch = ItemAttributeNamed<Boolean>("force weapon switch")
		
		/**
		 * In-Game: "When weapon is active:"
		 *
		 * 
		 *
		 * If true, only applies attributes when weapon is active, and unapplies them when switching off.
		 *
		 * I think this also means you can't have "only active when holding weapon" and "always active" attributes on the same weapon, since the order you specify attributes in doesn't matter.
		 */
		val provideOnActive = ItemAttributeNamed<Boolean>("provide on active")
		
		/**
		 * In-Game: "Projectiles penetrate enemy players"
		 *
		 * 
		 *
		 * How many players your "projectile" (*including bullets*) should penetrate.
		 */
		val projectilePenetration = ItemAttributeNamed<Int>("projectile penetration")
		
		/**
		 * In-Game: "Bullets penetrate +N enemies"
		 *
		 * 
		 *
		 * How many players your "projectile" (*including bullets*) should penetrate.
		 */
		val projectilePenetrationHeavy = ItemAttributeNamed<Int>("projectile penetration heavy")
		
		/**
		 * In-Game: "+N% bullets per shot"
		 *
		 * 
		 */
		val bulletsPerShotBonus = ItemAttributeNamed<Float>("bullets per shot bonus")
		
		/**
		 * Bonus:
		 *
		 * 	- Visible:
		 *
		 * 		- In-Game: "+N% damage bonus"
		 *
		 * 	- Hidden:
		 *
		 * 		- In-Game: "+N% damage bonus"
		 *
		 * 
		 *
		 * Penalty:
		 *
		 * 	- In-Game: "N% damage penalty"
		 *
		 * 
		 */
		val damage = BonusPenalty(
			VisHidden("ItemAttributeNamed<Float>("damage bonus")", "ItemAttributeNamed<Float>("damage bonus HIDDEN")"),
			ItemAttributeNamed<Float>("damage penalty")
		)
		
		/**
		 * In-Game: "No random critical hits"
		 *
		 * 
		 */
		val critChance = ItemAttributeNamed<Float>("crit mod disabled")
		
		/**
		 * In-Game: "No random critical hits"
		 *
		 * 
		 */
		val critModDisabledHidden = ItemAttributeNamed<Float>("crit mod disabled hidden")
		
		/**
		 * Bonus:
		 *
		 * 	- In-Game: "Hold Fire to load up to three rockets Release Fire to unleash the barrage"
		 *
		 * 
		 *
		 * Penalty:
		 *
		 * 
		 */
		val autoFiresFullClip = BonusPenalty(
			ItemAttributeNamed<Boolean>("auto fires full clip"),
			ItemAttributeNamed<Boolean>("auto fires full clip penalty")
		)
		
		/**
		 * 
		 */
		val autoFiresFullClipAllAtOnce = ItemAttributeNamed<Boolean>("auto fires full clip all at once")
		
		/**
		 * In-Game: "Overloading the chamber will cause a misfire"
		 *
		 * 
		 *
		 * Deals damage to the player when overloaded.
		 */
		val canOverload = ItemAttributeNamed<Boolean>("can overload")
		
		/**
		 * Bonus:
		 *
		 * 	- Visible:
		 *
		 * 		- In-Game: "+N% faster firing speed"
		 *
		 * 	- Hidden:
		 *
		 * 		- In-Game: "+N% faster firing speed"
		 *
		 * 
		 *
		 * Penalty:
		 *
		 * 	- Visible:
		 *
		 * 		- In-Game: "N% slower firing speed"
		 *
		 * 	- Hidden:
		 *
		 * 
		 *
		 * After firing, you wait a bit before you can fire again. That's the "delay".
		 */
		val fireRate = BonusPenalty(
			VisHidden("ItemAttributeNamed<Float>("fire rate bonus")", "ItemAttributeNamed<Float>("fire rate bonus HIDDEN")"),
			VisHidden("ItemAttributeNamed<Float>("fire rate penalty")", "ItemAttributeNamed<Float>("fire rate penalty HIDDEN")")
		)
		
		/**
		 * 
		 */
		val autoFiresWhenFull = ItemAttributeNamed<Boolean>("auto fires when full")
		
		/**
		 * Bonus:
		 *
		 * 	- In-Game: "N% faster reload time"
		 *
		 * 
		 *
		 * Penalty:
		 *
		 * 	- In-Game: "N% slower reload time"
		 *
		 * 
		 */
		val reloadTime = BonusPenalty(
			ItemAttributeNamed<Float>("Reload time decreased"),
			ItemAttributeNamed<Float>("Reload time increased")
		)
		
		/**
		 * In-Game: "N% slower reload time"
		 *
		 * 
		 */
		val reloadTimeIncreasedHidden = ItemAttributeNamed<Float>("reload time increased hidden")
		
		/**
		 * In-Game: "+N% faster reload time"
		 *
		 * 
		 *
		 * This is what's used for weapons that draw directly from reserve ammo, like the flare gun and sniper rifle.
		 */
		val fasterReloadRate = ItemAttributeNamed<Float>("faster reload rate")
		
		/**
		 * 
		 *
		 * Halloween reload time multiplier.
		 *
		 * Checked on player.
		 */
		val halloweenReloadTimeDecreased = ItemAttributeNamed<Float>("halloween reload time decreased")
		
		/**
		 * In-Game: "N% faster reload time while being healed"
		 *
		 * 
		 */
		val reloadTimeDecreasedWhileHealed = ItemAttributeNamed<Float>("reload time decreased while healed")
		
		/**
		 * 
		 */
		val weaponAllowInspect = ItemAttributeNamed<Boolean>("weapon_allow_inspect")
		
		/**
		 * 
		 */
		val onHit = OnHitAttributes()
		
		/**
		 * In-Game: "On Hit by Fire: Fireproof for 1 second and Afterburn immunity for N seconds"
		 *
		 * 
		 *
		 * Addcond parameter.
		 */
		val becomeFireproofOnHitByFire = ItemAttributeNamed<Float>("become fireproof on hit by fire")
		
		/**
		 * 
		 */
		val centerfireProjectile = ItemAttributeNamed<Boolean>("centerfire projectile")
		
		/**
		 * In-Game: "+N degrees random projectile deviation"
		 *
		 * 
		 *
		 * Does not include bullets.
		 */
		val projectileSpreadAnglePenalty = ItemAttributeNamed<Float>("projectile spread angle penalty")
		
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
		 * Cast to an int when healing, idk why this is a float.
		 */
		val activeHealthDegen = BonusPenalty(
			ItemAttributeNamed<Float>("active health regen"),
			ItemAttributeNamed<Float>("active health degen")
		)
		
		/**
		 * 
		 *
		 * Strange part kills with this weapon should contribute to.
		 */
		val killEaterKillType = ItemAttributeNamed<Int>("kill eater kill type")
		
		/**
		 * In-Game: "Silent Killer: No attack noise from backstabs"
		 *
		 * 
		 *
		 * Kills will not show up in the killfeed.
		 */
		val silentKiller = ItemAttributeNamed<Boolean>("silent killer")
		
		/**
		 * In-Game: "Cannot be crit boosted"
		 *
		 * 
		 *
		 * Can't be crit-boosted.
		 */
		val noCritBoost = ItemAttributeNamed<Boolean>("no crit boost")
		
		/**
		 * 
		 */
		val revengeCrits = RevengeCritsAttributes()
		
		/**
		 * In-Game: "Honorbound: Once drawn sheathing deals 50 damage to yourself unless it kills."
		 *
		 * 
		 *
		 * Takes 50 health when holstering before it gets a kill.
		 */
		val honorbound = ItemAttributeNamed<Boolean>("honorbound")
		
		/**
		 * 
		 */
		val weaponStattrakModuleScale = ItemAttributeNamed<Float>("weapon_stattrak_module_scale")
		
		/**
		 * 
		 */
		val minViewmodelOffset = ItemAttributeNamed<String>("min_viewmodel_offset")
		
		/**
		 * In-Game: "+N% increase in recharge rate"
		 *
		 * 
		 *
		 * Things like throwable recharge timers, jetpack charging, etc. How much it recharges per... some amount of time.
		 */
		val effectBarRechargeRateIncreased = ItemAttributeNamed<Float>("effect bar recharge rate increased")
		
		/**
		 * In-Game: "Blocks healing while in use"
		 *
		 * 
		 *
		 * Prevents mediguns from latching onto you.
		 */
		val weaponBlocksHealing = ItemAttributeNamed<Boolean>("mod weapon blocks healing")
		
		/**
		 * In-Game: "+N% ÜberCharge rate for the medic healing you This effect does not work in the respawn room"
		 *
		 * 
		 *
		 * Multiplier applied to your healer's ubercharge rate.
		 *
		 * NOTE: Only applied if user is outside of the respawn room.
		 */
		val uberchargeRateBonusForHealer = ItemAttributeNamed<Float>("ubercharge rate bonus for healer")
		
		/**
		 * In-Game: "+N% greater jump height when active"
		 *
		 * 
		 *
		 * One of the "only when weapon is active" kind of attributes.  These always only work if the weapon that provides them is active, while still allowing other attributes to be globally-applied.
		 */
		val increasedJumpHeightFromWeapon = ItemAttributeNamed<Float>("increased jump height from weapon")
		
		/**
		 * In-Game: "On Hit: Gain up to +N health per attack"
		 *
		 * 
		 *
		 * Maximum amount of health that can be gained from an AoE damage source.  Health received is multiplied by `damage dealt / base damage of the weapon`, to a max of 100% of the defined value.
		 */
		val healthOnRadiusDamage = ItemAttributeNamed<Int>("health on radius damage")
		
		/**
		 * In-Game: "Attacks pierce damage resistance effects and bonuses"
		 *
		 * 
		 */
		val dmgPiercesResistsAbsorbs = ItemAttributeNamed<Int>("dmg pierces resists absorbs")
		
		/**
		 * In-Game: "100% critical hit vs burning players"
		 *
		 * 
		 *
		 * The weapon's "crit players with X condition" stat.
		 */
		val critVsBurningPlayers = ItemAttributeNamed<EnumSet<TFCritCondition>>("crit vs burning players", EnumSetOrCodec())
		
		/**
		 * In-Game: "100% critical hit vs disguised players"
		 *
		 * 
		 *
		 * The weapon's "crit players with X condition" stat.
		 */
		val critVsDisguisedPlayers = ItemAttributeNamed<EnumSet<TFCritCondition>>("crit vs disguised players", EnumSetOrCodec())
		
		/**
		 * In-Game: "100% critical hit vs stunned players"
		 *
		 * 
		 *
		 * The weapon's "crit players with X condition" stat.
		 */
		val critVsStunnedPlayers = ItemAttributeNamed<EnumSet<TFCritCondition>>("crit vs stunned players", EnumSetOrCodec())
		
		/**
		 * In-Game: "100% critical hit vs wet players"
		 *
		 * 
		 */
		val critVsWetPlayers = ItemAttributeNamed<Boolean>("crit vs wet players")
		
		/**
		 * In-Game: "100% critical hit vs non-burning players"
		 *
		 * 
		 *
		 * Crit against players that DON'T have these conditions.
		 */
		val critVsNonBurningPlayers = ItemAttributeNamed<EnumSet<TFCritCondition>>("crit vs non burning players", EnumSetOrCodec())
		
		/**
		 * In-Game: "100% critical hits burning players from behind. Mini-crits burning players from the front."
		 *
		 * 
		 *
		 * On hitting a burning player, crit them from behind or minicrit them otherwise.
		 */
		val axtinguisherProperties = ItemAttributeNamed<Boolean>("axtinguisher properties")
		
		/**
		 * In-Game: "Deals crits while the wielder is rocket jumping"
		 *
		 * 
		 *
		 * Critical hit enemies if the player was launched into the air by an explosion.
		 *
		 * Only works when not in Mannpower mode.
		 */
		val critWhileAirborne = ItemAttributeNamed<Boolean>("mod crit while airborne")
		
		/**
		 * In-Game: "Mini-crits burning targets and extinguishes them. Damage increases based on remaining duration of afterburn. Killing blows on burning players grant a speed boost."
		 *
		 * 
		 *
		 * Only activates if the weapon deals `DMG_MELEE`.
		 */
		val attackMinicritsAndConsumesBurning = ItemAttributeNamed<Boolean>("attack_minicrits_and_consumes_burning")
		
		/**
		 * In-Game: "Grants Triple Jump while deployed. Melee attacks mini-crit while airborne."
		 *
		 * 
		 *
		 * If greater than 0, attacks minicrit while airborne.
		 *
		 * Only procs on Scout.
		 */
		val airDashCount = ItemAttributeNamed<Int>("air dash count")
		
		/**
		 * In-Game: "100% minicrits vs burning players"
		 *
		 * 
		 *
		 * Minicrits if the damage dealt is NOT `DMG_BURN`.
		 */
		val minicritVsBurningPlayer = ItemAttributeNamed<Boolean>("minicrit vs burning player")
		
		/**
		 * In-Game: "Mini-crits targets launched airborne by explosions, grapple hooks or rocket packs"
		 *
		 * 
		 *
		 * Mini-crits targets launched airborne by an explosion.
		 *
		 * Only procs when not in Mannpower mode.
		 */
		val miniCritAirborne = ItemAttributeNamed<Boolean>("mod mini-crit airborne")
		
		/**
		 * In-Game: "Mini-crits targets when fired at their back from close range"
		 *
		 * 
		 *
		 * If true, minicrits targets facing away from the attacker that are within 22.6 HU of the attacker (sqrt 512).
		 */
		val closerangeBackattackMinicrits = ItemAttributeNamed<Boolean>("closerange backattack minicrits")
		
		/**
		 * In-Game: "Crits whenever it would normally mini-crit"
		 *
		 * 
		 */
		val minicritsBecomeCrits = ItemAttributeNamed<Boolean>("minicrits become crits")
		
		/**
		 * In-Game: "N% damage vs players"
		 *
		 * 
		 */
		val dmgPenaltyVsPlayers = ItemAttributeNamed<Float>("dmg penalty vs players")
		
		/**
		 * In-Game: "No critical hits vs non-burning players"
		 *
		 * 
		 *
		 * Note: Even prevents criticals when crit-boosted.
		 */
		val noCritVsNonburning = ItemAttributeNamed<Boolean>("no crit vs nonburning")
		
		/**
		 * In-Game: "N% damage vs non-burning players"
		 *
		 * 
		 */
		val dmgPenaltyVsNonburning = ItemAttributeNamed<Float>("dmg penalty vs nonburning")
		
		/**
		 * In-Game: "Critical damage is affected by range"
		 *
		 * 
		 *
		 * If true, crits have damage falloff (Ambassador).
		 */
		val critDmgFalloff = ItemAttributeNamed<Boolean>("crit_dmg_falloff")
		
		/**
		 * In-Game: "Minicrits whenever it would normally crit"
		 *
		 * 
		 */
		val critsBecomeMinicrits = ItemAttributeNamed<Boolean>("crits_become_minicrits")
		
		/**
		 * In-Game: "+N% damage vulnerability while active"
		 *
		 * 
		 *
		 * Increases damage taken while minicrit-boosted by Crit-a-Cola, Buffalo Steak, etc.
		 */
		val energyBuffDmgTakenMultiplier = ItemAttributeNamed<Float>("energy buff dmg taken multiplier")
		
		/**
		 * In-Game: "+N% cloak on hit"
		 *
		 * 
		 *
		 * Adds this amount of cloak on hit.
		 *
		 * Only procs on Spy.
		 */
		val addCloakOnHit = ItemAttributeNamed<Int>("add cloak on hit")
		
		/**
		 * In-Game: "On Hit: target is engulfed in flames"
		 *
		 * 
		 *
		 * Ignites player on hit.
		 */
		val setDamagetypeIgnite = ItemAttributeNamed<Boolean>("Set DamageType Ignite")
		
		/**
		 * In-Game: "+N% fire damage resistance while deployed"
		 *
		 * 
		 *
		 * Gain fire resistance only when this weapon is active.
		 */
		val dmgTakenFromFireReducedOnActive = ItemAttributeNamed<Float>("dmg taken from fire reduced on active")
		
		/**
		 * In-Game: "N% damage bonus vs burning players"
		 *
		 * 
		 */
		val damageBonusVsBurning = ItemAttributeNamed<Float>("damage bonus vs burning")
		
		/**
		 * In-Game: "N% damage vulnerability on wearer"
		 *
		 * 
		 */
		val multDmgtakenActive = ItemAttributeNamed<Float>("mult_dmgtaken_active")
		
		/**
		 * In-Game: "+N% damage from melee sources while active"
		 *
		 * 
		 */
		val dmgFromMeleeIncreased = ItemAttributeNamed<Float>("dmg from melee increased")
		
		/**
		 * In-Game: "N% damage from ranged sources while active"
		 *
		 * 
		 *
		 * Applies to blast, bullet, buckshot, ignite, and sonic damage types.
		 */
		val dmgFromRangedReduced = ItemAttributeNamed<Float>("dmg from ranged reduced")
		
		/**
		 * In-Game: "No self inflicted blast damage taken"
		 *
		 * 
		 */
		val noSelfBlastDmg = ItemAttributeNamed<Boolean>("no self blast dmg")
		
		/**
		 * In-Game: "+N% damage to self"
		 *
		 * 
		 *
		 * Multiplier applied to blast damage taken from an explosion caused by said entity.
		 */
		val blastDmgToSelfIncreased = ItemAttributeNamed<Float>("blast dmg to self increased")
		
		/**
		 * 
		 *
		 * Used for killfeed.
		 */
		val isGigerCounter = ItemAttributeNamed<Boolean>("is giger counter")
		
		/**
		 * 
		 *
		 * Sets killfeed background gold.
		 */
		val isAustraliumItem = ItemAttributeNamed<Boolean>("is australium item")
		
		/**
		 * In-Game: "Imbued with an ancient power"
		 *
		 * 
		 *
		 * Sets killfeed background gold.
		 */
		val turnToGold = ItemAttributeNamed<Boolean>("turn to gold")
		
		/**
		 * In-Game: "N% health from healers on wearer"
		 *
		 * 
		 *
		 * Attribute class is a flat multiplier applied to health from healers while weapon is active.
		 */
		val multHealthFromhealersPenaltyActive = ItemAttributeNamed<Float>("mult_health_fromhealers_penalty_active")
		
		/**
		 * In-Game: "N% Overheal build rate."
		 *
		 * 
		 *
		 * Checked on the player that is healing an entity.
		 */
		val overhealFillRateReduced = ItemAttributeNamed<Float>("overheal fill rate reduced")
		
		/**
		 * In-Game: "N% less healing from Medic sources"
		 *
		 * 
		 *
		 * Applies to all non-dispenser forms of healing that apply the `TF_COND_HEAL_BUFF` status.
		 */
		val reducedHealingFromMedics = ItemAttributeNamed<Float>("reduced_healing_from_medics")
		
		/**
		 * Bonus:
		 *
		 * 	- In-Game: "+N% afterburn damage bonus"
		 *
		 * 
		 *
		 * Penalty:
		 *
		 * 	- In-Game: "N% afterburn damage penalty"
		 *
		 * 
		 *
		 * Afterburn damage.
		 */
		val weaponBurnDmgReduced = BonusPenalty(
			ItemAttributeNamed<Float>("weapon burn dmg increased"),
			ItemAttributeNamed<Float>("weapon burn dmg reduced")
		)
		
		/**
		 * In-Game: "Halloween Fire"
		 *
		 * 
		 *
		 * Makes afterburn green.
		 */
		val spellHalloweenGreenFlames = ItemAttributeNamed<Boolean>("SPELL: Halloween green flames")
		
		/**
		 * In-Game: "Syringes deliver a highly concentrated dose of Mad Milk. Duration increases per hit to a max of 4 seconds."
		 *
		 * 
		 *
		 * Duration of 4 seconds, and increases by 0.5 seconds each hit.
		 */
		val madMilkSyringes = ItemAttributeNamed<Boolean>("mad milk syringes")
		
		/**
		 * In-Game: "Alt-Fire: Applies a healing effect to all nearby teammates"
		 *
		 * 
		 *
		 * Makes default weapon taunt perform the Amputator radial healing effect.
		 */
		val enablesAoeHeal = ItemAttributeNamed<Boolean>("enables aoe heal")
		
		/**
		 * Bonus:
		 *
		 * 	- In-Game: "+N% afterburn duration"
		 *
		 * 
		 *
		 * Penalty:
		 *
		 * 	- In-Game: "N% afterburn duration"
		 *
		 * 
		 *
		 * Afterburn duration.
		 */
		val weaponBurnTimeReduced = BonusPenalty(
			ItemAttributeNamed<Float>("weapon burn time increased"),
			ItemAttributeNamed<Float>("weapon burn time reduced")
		)
		
		/**
		 * In-Game: "Fires tracer rounds"
		 *
		 * 
		 *
		 * Note: Sniper rage forcibly draws a tracer regardless of this setting.
		 *
		 * Used when firing bullets.
		 */
		val sniperFiresTracer = ItemAttributeNamed<Boolean>("sniper fires tracer")
		
		/**
		 * In-Game: "Fires tracer rounds"
		 *
		 * 
		 *
		 * Same as `sniper_fires_tracer`.
		 */
		val sniperFiresTracerHidden = ItemAttributeNamed<Boolean>("sniper fires tracer HIDDEN")
		
		/**
		 * In-Game: "N% increased damage to your sentry's target"
		 *
		 * 
		 */
		val damageBonusBulletVsSentryTarget = ItemAttributeNamed<Float>("damage bonus bullet vs sentry target")
		
		/**
		 * In-Game: "On Full Charge: Projectiles penetrate players"
		 *
		 * 
		 */
		val penetratesWhenFullyCharged = ItemAttributeNamed<Boolean>("sniper penetrate players when charged")
		
		/**
		 * 
		 *
		 * Multiplier applied to movement speed scaled by ubercharge percentage.
		 *
		 * Only works if the player using this item is a Medic with a Medigun.
		 */
		val moveSpeedBonusResourceLevel = ItemAttributeNamed<Float>("move speed bonus resource level")
		
		/**
		 * In-Game: "+N% faster move speed on wearer"
		 *
		 * 
		 *
		 * Multiplier applied to player movement speed only while this is the active weapon.
		 */
		val multPlayerMovespeedActive = ItemAttributeNamed<Float>("mult_player_movespeed_active")
		
		/**
		 * 
		 *
		 * If greater than 0 (like with the Thermal Thruster), takes that amount of time to holster BEFORE actually swapping weapons.
		 */
		val holsterAnimTime = ItemAttributeNamed<Float>("holster_anim_time")
		
		/**
		 * In-Game: "Alt-Fire: Use N metal to pick up your targeted building from long range"
		 *
		 * 
		 *
		 * Metal cost to pick up a building at range.
		 *
		 * Restricted to the default rescue ranger range, but can be used by any weapon.
		 */
		val engineerBuildingTeleportingPickup = ItemAttributeNamed<Int>("engineer building teleporting pickup")
		
		/**
		 * In-Game: "N% damage on body shot"
		 *
		 * 
		 *
		 * Multiplier applied to bodyshot damage.
		 */
		val damagePenaltyOnBodyshot = ItemAttributeNamed<Float>("damage penalty on bodyshot")
		
		/**
		 * Bonus:
		 *
		 * 	- In-Game: "+N% bonus healing from all sources"
		 *
		 * 
		 *
		 * Penalty:
		 *
		 * 	- In-Game: "N% less healing from all sources"
		 *
		 * 
		 */
		val healingReceived = BonusPenalty(
			ItemAttributeNamed<Float>("healing received bonus"),
			ItemAttributeNamed<Float>("healing received penalty")
		)
		
		/**
		 * In-Game: "Stuns enemies who are also wielding this weapon"
		 *
		 * 
		 */
		val stunEnemiesWieldingSameWeapon = ItemAttributeNamed<Boolean>("stun enemies wielding same weapon")
		
		/**
		 * In-Game: "All players connected via Medigun beams are hit"
		 *
		 * 
		 *
		 * Damage all players connected to the target by medigun beams.
		 */
		val damageAllConnected = ItemAttributeNamed<Boolean>("damage all connected")
		
		/**
		 * 
		 *
		 * Apply this amount of z velocity to players hit with this weapon.
		 */
		val applyZVelocityOnDamage = ItemAttributeNamed<Float>("apply z velocity on damage")
		
		/**
		 * 
		 *
		 * Apply this amount of velocity in the direction you're facing to players hit with this weapon.
		 */
		val applyLookVelocityOnDamage = ItemAttributeNamed<Float>("apply look velocity on damage")
		
		/**
		 * In-Game: "Ignited enemies explode"
		 *
		 * 
		 *
		 * Applies when *any weapon* with this attribute is in the second loadout slot of the player who covered someone in gas.  This attribute does not specifically check for the Gas Passer.  For example, f a Soldier has a rocket launcher that applies `TF_COND_GAS` and their shotgun in their secondary has this attribute, they'll still explode on ignite.
		 *
		 * Only the afterburn specifically checks for the Gas Passer.
		 */
		val explodeOnIgnite = ItemAttributeNamed<Boolean>("explode_on_ignite")
		
		/**
		 * Bonus:
		 *
		 * 	- In-Game: "+N% self damage force"
		 *
		 * 
		 *
		 * Penalty:
		 *
		 * 	- In-Game: "N% self damage force"
		 *
		 * 
		 *
		 * Applies to all self-damage taken from any source.
		 */
		val selfDmgPushForce = BonusPenalty(
			ItemAttributeNamed<Float>("self dmg push force increased"),
			ItemAttributeNamed<Float>("self dmg push force decreased")
		)
		
		/**
		 * 
		 *
		 * Knocks back attacker when wielder receives damage.
		 */
		val damageCausesAirblast = ItemAttributeNamed<Boolean>("damage causes airblast")
		
		/**
		 * 
		 *
		 * Push force applied to target when hitting an enemy.
		 *
		 * Scales by range, to a minimum of 50% of the given value.
		 */
		val damageBlastPush = ItemAttributeNamed<Float>("damage blast push")
		
		/**
		 * Bonus:
		 *
		 * 	- In-Game: "N% reduction in push force taken from damage"
		 *
		 * 
		 *
		 * Penalty:
		 *
		 * 	- Visible:
		 *
		 * 		- In-Game: "N% increase in push force taken from damage"
		 *
		 * 	- Hidden:
		 *
		 * 		- In-Game: "N% increase in push force taken from damage"
		 *
		 * 
		 *
		 * Attribute class is a flat multiplier applied to push force received from damage.
		 */
		val damageForce = BonusPenalty(
			ItemAttributeNamed<Float>("damage force reduction"),
			VisHidden("ItemAttributeNamed<Float>("damage force increase")", "ItemAttributeNamed<Float>("damage force increase hidden")")
		)
		
		/**
		 * In-Game: "On Hit: Bleed for N seconds"
		 *
		 * 
		 *
		 * Apply bleed on hit.
		 *
		 * Value is a time in seconds.
		 */
		val bleedingDuration = ItemAttributeNamed<Float>("bleeding duration")
		
		/**
		 * In-Game: "The wearer cannot be killed by headshots"
		 *
		 * 
		 *
		 * When a headshot would kill you, reduce health to 1.
		 */
		val setBonusNoDeathFromHeadshots = ItemAttributeNamed<Boolean>("SET BONUS: no death from headshots")
		
		/**
		 * In-Game: "Increased headshot explosion radius and damage to nearby enemies"
		 *
		 * 
		 *
		 * Only applies if in a gamemode with upgrades, but applies to all headshots.
		 *
		 * Also applies to any hitscan weapon with a `jarate_time` attribute that hit the head.
		 */
		val explosiveHeadshotLevel = ItemAttributeNamed<Boolean>("explosive sniper shot")
		
		/**
		 * In-Game: "Killing an enemy with a critical hit will dismember your victim. Painfully."
		 *
		 * 
		 */
		val critKillWillGib = ItemAttributeNamed<Boolean>("crit kill will gib")
		
		/**
		 * 
		 *
		 * If false, this weapon can only gib if it deals blast damage or half-falloff damage.
		 */
		val critOnHardHit = ItemAttributeNamed<Boolean>("crit on hard hit")
		
		/**
		 * In-Game: "On Kill: N seconds of 100% critical chance"
		 *
		 * 
		 *
		 * Seconds of crit-boost gained on kill.
		 *
		 * Note: actual time is `this + 1`.
		 */
		val critboostOnKill = ItemAttributeNamed<Int>("critboost on kill")
		
		/**
		 * In-Game: "On Kill: Gain Mini-crits for N seconds."
		 *
		 * 
		 *
		 * Seconds of minicrit-boost gained on kill.
		 *
		 * Note: actual time is `this + 1`.
		 */
		val minicritboostOnKill = ItemAttributeNamed<Int>("minicritboost on kill")
		
		/**
		 * In-Game: "Exorcism"
		 *
		 * 
		 *
		 * Exorcism spell effect.
		 */
		val spellHalloweenDeathGhosts = ItemAttributeNamed<Boolean>("SPELL: Halloween death ghosts")
		
		/**
		 * In-Game: "On Kill: Gain N% of base health on kill"
		 *
		 * 
		 *
		 * Percentage of health to be restored upon killing an enemy. (e.g. `25` is 25%).
		 *
		 * Post-heal player health value is capped at 1.5x the player's normal max health.
		 *
		 * Negative values are ignored.
		 */
		val restoreHealthOnKill = ItemAttributeNamed<Int>("restore health on kill")
		
		/**
		 * In-Game: "+N health restored on kill"
		 *
		 * 
		 *
		 * Restores this flat amount of health on killing an enemy. Post-heal player health value is capped at the player's maximum overheal.
		 *
		 * Negative values are NOT ignored.
		 */
		val healOnKill = ItemAttributeNamed<Int>("heal on kill")
		
		/**
		 * In-Game: "Gain a speed boost on kill"
		 *
		 * 
		 */
		val speedBoostOnKill = ItemAttributeNamed<Int>("speed_boost_on_kill")
		
		/**
		 * In-Game: "Maximum health is drained while item is active"
		 *
		 * 
		 *
		 * Maximum health decrease per tick while weapon is active. (Gloves of Running Urgently/Eviction Notice).
		 */
		val maxhealthDrainRate = ItemAttributeNamed<Float>("mod_maxhealth_drain_rate")
		
		/**
		 * 
		 *
		 * If true, prevents holiday taunts from being used.
		 */
		val specialTaunt = ItemAttributeNamed<Boolean>("special taunt")
		
		/**
		 * 
		 */
		val ragdolls = RagdollsAttributes()
	}

	/**
	 * In-Game: "Ammo boxes collected also give Charge"
	 *
	 * 
	 *
	 * If true, and player has a demoman charge meter, add charge based on ammo pack size.
	 */
	val ammoPacksGiveDemoknightCharge: ItemAttribute<Boolean> get() = WeaponBaseAttributes.ammoPacksGiveDemoknightCharge
	
	/**
	 * In-Game: "No ammo from dispensers when active"
	 *
	 * 
	 */
	val noPrimaryAmmoFromDispensersWhileActive: ItemAttribute<Boolean> get() = WeaponBaseAttributes.noPrimaryAmmoFromDispensersWhileActive
	
	/**
	 * In-Game: "No metal from dispensers when active."
	 *
	 * 
	 */
	val noMetalFromDispensersWhileActive: ItemAttribute<Boolean> get() = WeaponBaseAttributes.noMetalFromDispensersWhileActive
	
	/**
	 * Bonus:
	 *
	 * 	- In-Game: "+N% damage vs buildings"
	 *
	 * 
	 *
	 * Penalty:
	 *
	 * 	- In-Game: "N% damage penalty vs buildings"
	 *
	 * 
	 */
	val dmgVsBuildings: ItemAttribute<Float> get() = WeaponBaseAttributes.dmgVsBuildings
	
	/**
	 * Bonus:
	 *
	 * 	- In-Game: "+N% clip size"
	 *
	 * 
	 *
	 * Penalty:
	 *
	 * 	- Visible:
	 *
	 * 		- In-Game: "N% clip size"
	 *
	 * 	- Hidden:
	 *
	 * 		- In-Game: "N% clip size"
	 *
	 * 
	 */
	val clipSize: ItemAttribute<Float> get() = WeaponBaseAttributes.clipSize
	
	/**
	 * In-Game: "+N% clip size"
	 *
	 * 
	 */
	val clipSizeBonusUpgrade: ItemAttribute<Int> get() = WeaponBaseAttributes.clipSizeBonusUpgrade
	
	/**
	 * In-Game: "+N clip size"
	 *
	 * 
	 *
	 * MVM attribute that specifically handles rocket and grenade launchers.
	 *
	 * Note that all three of these are different classes, which means they stack.
	 */
	val clipSizeUpgradeAtomic: ItemAttribute<Int> get() = WeaponBaseAttributes.clipSizeUpgradeAtomic
	
	/**
	 * In-Game: "Clip size increased on kill"
	 *
	 * 
	 */
	val clipsizeIncreaseOnKill: ItemAttribute<Int> get() = WeaponBaseAttributes.clipsizeIncreaseOnKill
	
	/**
	 * In-Game: "Replaces the Sentry with a Mini-Sentry"
	 *
	 * 
	 *
	 * cast to an int, used as a boolean, so idk.
	 *
	 * Determines the hand used in the model.
	 */
	val wrenchBuildsMinisentry: ItemAttribute<Float> get() = WeaponBaseAttributes.wrenchBuildsMinisentry
	
	/**
	 * Bonus:
	 *
	 * 	- In-Game: "N% faster weapon switch"
	 *
	 * 
	 *
	 * Penalty:
	 *
	 * 	- In-Game: "N% longer weapon switch"
	 *
	 * 
	 *
	 * Checked on player.
	 */
	val deployTime: ItemAttribute<Float> get() = WeaponBaseAttributes.deployTime
	
	/**
	 * Bonus:
	 *
	 * 	- In-Game: "This weapon deploys N% faster"
	 *
	 * 
	 *
	 * Penalty:
	 *
	 * 	- In-Game: "This weapon deploys N% slower"
	 *
	 * 
	 */
	val singleWepDeployTime: ItemAttribute<Float> get() = WeaponBaseAttributes.singleWepDeployTime
	
	/**
	 * Bonus:
	 *
	 * 	- In-Game: "This weapon holsters N% faster"
	 *
	 * 
	 *
	 * Penalty:
	 *
	 * 	- In-Game: "This weapon holsters N% slower"
	 *
	 * 
	 */
	val singleWepHolsterTime: ItemAttribute<Float> get() = WeaponBaseAttributes.singleWepHolsterTime
	
	/**
	 * In-Game: "This Weapon has a large melee range and deploys and holsters slower"
	 *
	 * 
	 *
	 * If true, make weapon deploy and holster 75% slower.
	 */
	val isASword: ItemAttribute<Boolean> get() = WeaponBaseAttributes.isASword
	
	/**
	 * In-Game: "While not being healed by a medic, your weapon switch time is N% longer"
	 *
	 * 
	 *
	 * Multiplier applied if NOT being healed by a medic.
	 *
	 * Checked on player.
	 */
	val medicHealedDeployTimePenalty: ItemAttribute<Float> get() = WeaponBaseAttributes.medicHealedDeployTimePenalty
	
	/**
	 * 
	 *
	 * Should force switch to this item when... something happens.  Probably when your current weapon is unavailable?.
	 */
	val forceWeaponSwitch: ItemAttribute<Boolean> get() = WeaponBaseAttributes.forceWeaponSwitch
	
	/**
	 * In-Game: "When weapon is active:"
	 *
	 * 
	 *
	 * If true, only applies attributes when weapon is active, and unapplies them when switching off.
	 *
	 * I think this also means you can't have "only active when holding weapon" and "always active" attributes on the same weapon, since the order you specify attributes in doesn't matter.
	 */
	val provideOnActive: ItemAttribute<Boolean> get() = WeaponBaseAttributes.provideOnActive
	
	/**
	 * In-Game: "Projectiles penetrate enemy players"
	 *
	 * 
	 *
	 * How many players your "projectile" (*including bullets*) should penetrate.
	 */
	val projectilePenetration: ItemAttribute<Int> get() = WeaponBaseAttributes.projectilePenetration
	
	/**
	 * In-Game: "Bullets penetrate +N enemies"
	 *
	 * 
	 *
	 * How many players your "projectile" (*including bullets*) should penetrate.
	 */
	val projectilePenetrationHeavy: ItemAttribute<Int> get() = WeaponBaseAttributes.projectilePenetrationHeavy
	
	/**
	 * In-Game: "+N% bullets per shot"
	 *
	 * 
	 */
	val bulletsPerShotBonus: ItemAttribute<Float> get() = WeaponBaseAttributes.bulletsPerShotBonus
	
	/**
	 * Bonus:
	 *
	 * 	- Visible:
	 *
	 * 		- In-Game: "+N% damage bonus"
	 *
	 * 	- Hidden:
	 *
	 * 		- In-Game: "+N% damage bonus"
	 *
	 * 
	 *
	 * Penalty:
	 *
	 * 	- In-Game: "N% damage penalty"
	 *
	 * 
	 */
	val damage: ItemAttribute<Float> get() = WeaponBaseAttributes.damage
	
	/**
	 * In-Game: "No random critical hits"
	 *
	 * 
	 */
	val critChance: ItemAttribute<Float> get() = WeaponBaseAttributes.critChance
	
	/**
	 * In-Game: "No random critical hits"
	 *
	 * 
	 */
	val critModDisabledHidden: ItemAttribute<Float> get() = WeaponBaseAttributes.critModDisabledHidden
	
	/**
	 * Bonus:
	 *
	 * 	- In-Game: "Hold Fire to load up to three rockets Release Fire to unleash the barrage"
	 *
	 * 
	 *
	 * Penalty:
	 *
	 * 
	 */
	val autoFiresFullClip: ItemAttribute<Boolean> get() = WeaponBaseAttributes.autoFiresFullClip
	
	/**
	 * 
	 */
	val autoFiresFullClipAllAtOnce: ItemAttribute<Boolean> get() = WeaponBaseAttributes.autoFiresFullClipAllAtOnce
	
	/**
	 * In-Game: "Overloading the chamber will cause a misfire"
	 *
	 * 
	 *
	 * Deals damage to the player when overloaded.
	 */
	val canOverload: ItemAttribute<Boolean> get() = WeaponBaseAttributes.canOverload
	
	/**
	 * Bonus:
	 *
	 * 	- Visible:
	 *
	 * 		- In-Game: "+N% faster firing speed"
	 *
	 * 	- Hidden:
	 *
	 * 		- In-Game: "+N% faster firing speed"
	 *
	 * 
	 *
	 * Penalty:
	 *
	 * 	- Visible:
	 *
	 * 		- In-Game: "N% slower firing speed"
	 *
	 * 	- Hidden:
	 *
	 * 
	 *
	 * After firing, you wait a bit before you can fire again. That's the "delay".
	 */
	val fireRate: ItemAttribute<Float> get() = WeaponBaseAttributes.fireRate
	
	/**
	 * 
	 */
	val autoFiresWhenFull: ItemAttribute<Boolean> get() = WeaponBaseAttributes.autoFiresWhenFull
	
	/**
	 * Bonus:
	 *
	 * 	- In-Game: "N% faster reload time"
	 *
	 * 
	 *
	 * Penalty:
	 *
	 * 	- In-Game: "N% slower reload time"
	 *
	 * 
	 */
	val reloadTime: ItemAttribute<Float> get() = WeaponBaseAttributes.reloadTime
	
	/**
	 * In-Game: "N% slower reload time"
	 *
	 * 
	 */
	val reloadTimeIncreasedHidden: ItemAttribute<Float> get() = WeaponBaseAttributes.reloadTimeIncreasedHidden
	
	/**
	 * In-Game: "+N% faster reload time"
	 *
	 * 
	 *
	 * This is what's used for weapons that draw directly from reserve ammo, like the flare gun and sniper rifle.
	 */
	val fasterReloadRate: ItemAttribute<Float> get() = WeaponBaseAttributes.fasterReloadRate
	
	/**
	 * 
	 *
	 * Halloween reload time multiplier.
	 *
	 * Checked on player.
	 */
	val halloweenReloadTimeDecreased: ItemAttribute<Float> get() = WeaponBaseAttributes.halloweenReloadTimeDecreased
	
	/**
	 * In-Game: "N% faster reload time while being healed"
	 *
	 * 
	 */
	val reloadTimeDecreasedWhileHealed: ItemAttribute<Float> get() = WeaponBaseAttributes.reloadTimeDecreasedWhileHealed
	
	/**
	 * 
	 */
	val weaponAllowInspect: ItemAttribute<Boolean> get() = WeaponBaseAttributes.weaponAllowInspect
	
	/**
	 * 
	 */
	val onHit: ItemAttribute<OnHit> get() = WeaponBaseAttributes.onHit
	
	/**
	 * In-Game: "On Hit by Fire: Fireproof for 1 second and Afterburn immunity for N seconds"
	 *
	 * 
	 *
	 * Addcond parameter.
	 */
	val becomeFireproofOnHitByFire: ItemAttribute<Float> get() = WeaponBaseAttributes.becomeFireproofOnHitByFire
	
	/**
	 * 
	 */
	val centerfireProjectile: ItemAttribute<Boolean> get() = WeaponBaseAttributes.centerfireProjectile
	
	/**
	 * In-Game: "+N degrees random projectile deviation"
	 *
	 * 
	 *
	 * Does not include bullets.
	 */
	val projectileSpreadAnglePenalty: ItemAttribute<Float> get() = WeaponBaseAttributes.projectileSpreadAnglePenalty
	
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
	 * Cast to an int when healing, idk why this is a float.
	 */
	val activeHealthDegen: ItemAttribute<Float> get() = WeaponBaseAttributes.activeHealthDegen
	
	/**
	 * 
	 *
	 * Strange part kills with this weapon should contribute to.
	 */
	val killEaterKillType: ItemAttribute<Int> get() = WeaponBaseAttributes.killEaterKillType
	
	/**
	 * In-Game: "Silent Killer: No attack noise from backstabs"
	 *
	 * 
	 *
	 * Kills will not show up in the killfeed.
	 */
	val silentKiller: ItemAttribute<Boolean> get() = WeaponBaseAttributes.silentKiller
	
	/**
	 * In-Game: "Cannot be crit boosted"
	 *
	 * 
	 *
	 * Can't be crit-boosted.
	 */
	val noCritBoost: ItemAttribute<Boolean> get() = WeaponBaseAttributes.noCritBoost
	
	/**
	 * 
	 */
	val revengeCrits: ItemAttribute<RevengeCrits> get() = WeaponBaseAttributes.revengeCrits
	
	/**
	 * In-Game: "Honorbound: Once drawn sheathing deals 50 damage to yourself unless it kills."
	 *
	 * 
	 *
	 * Takes 50 health when holstering before it gets a kill.
	 */
	val honorbound: ItemAttribute<Boolean> get() = WeaponBaseAttributes.honorbound
	
	/**
	 * 
	 */
	val weaponStattrakModuleScale: ItemAttribute<Float> get() = WeaponBaseAttributes.weaponStattrakModuleScale
	
	/**
	 * 
	 */
	val minViewmodelOffset: ItemAttribute<String> get() = WeaponBaseAttributes.minViewmodelOffset
	
	/**
	 * In-Game: "+N% increase in recharge rate"
	 *
	 * 
	 *
	 * Things like throwable recharge timers, jetpack charging, etc. How much it recharges per... some amount of time.
	 */
	val effectBarRechargeRateIncreased: ItemAttribute<Float> get() = WeaponBaseAttributes.effectBarRechargeRateIncreased
	
	/**
	 * In-Game: "Blocks healing while in use"
	 *
	 * 
	 *
	 * Prevents mediguns from latching onto you.
	 */
	val weaponBlocksHealing: ItemAttribute<Boolean> get() = WeaponBaseAttributes.weaponBlocksHealing
	
	/**
	 * In-Game: "+N% ÜberCharge rate for the medic healing you This effect does not work in the respawn room"
	 *
	 * 
	 *
	 * Multiplier applied to your healer's ubercharge rate.
	 *
	 * NOTE: Only applied if user is outside of the respawn room.
	 */
	val uberchargeRateBonusForHealer: ItemAttribute<Float> get() = WeaponBaseAttributes.uberchargeRateBonusForHealer
	
	/**
	 * In-Game: "+N% greater jump height when active"
	 *
	 * 
	 *
	 * One of the "only when weapon is active" kind of attributes.  These always only work if the weapon that provides them is active, while still allowing other attributes to be globally-applied.
	 */
	val increasedJumpHeightFromWeapon: ItemAttribute<Float> get() = WeaponBaseAttributes.increasedJumpHeightFromWeapon
	
	/**
	 * In-Game: "On Hit: Gain up to +N health per attack"
	 *
	 * 
	 *
	 * Maximum amount of health that can be gained from an AoE damage source.  Health received is multiplied by `damage dealt / base damage of the weapon`, to a max of 100% of the defined value.
	 */
	val healthOnRadiusDamage: ItemAttribute<Int> get() = WeaponBaseAttributes.healthOnRadiusDamage
	
	/**
	 * In-Game: "Attacks pierce damage resistance effects and bonuses"
	 *
	 * 
	 */
	val dmgPiercesResistsAbsorbs: ItemAttribute<Int> get() = WeaponBaseAttributes.dmgPiercesResistsAbsorbs
	
	/**
	 * In-Game: "100% critical hit vs burning players"
	 *
	 * 
	 *
	 * The weapon's "crit players with X condition" stat.
	 */
	val critVsBurningPlayers: ItemAttribute<EnumSet<TFCritCondition>> get() = WeaponBaseAttributes.critVsBurningPlayers
	
	/**
	 * In-Game: "100% critical hit vs disguised players"
	 *
	 * 
	 *
	 * The weapon's "crit players with X condition" stat.
	 */
	val critVsDisguisedPlayers: ItemAttribute<EnumSet<TFCritCondition>> get() = WeaponBaseAttributes.critVsDisguisedPlayers
	
	/**
	 * In-Game: "100% critical hit vs stunned players"
	 *
	 * 
	 *
	 * The weapon's "crit players with X condition" stat.
	 */
	val critVsStunnedPlayers: ItemAttribute<EnumSet<TFCritCondition>> get() = WeaponBaseAttributes.critVsStunnedPlayers
	
	/**
	 * In-Game: "100% critical hit vs wet players"
	 *
	 * 
	 */
	val critVsWetPlayers: ItemAttribute<Boolean> get() = WeaponBaseAttributes.critVsWetPlayers
	
	/**
	 * In-Game: "100% critical hit vs non-burning players"
	 *
	 * 
	 *
	 * Crit against players that DON'T have these conditions.
	 */
	val critVsNonBurningPlayers: ItemAttribute<EnumSet<TFCritCondition>> get() = WeaponBaseAttributes.critVsNonBurningPlayers
	
	/**
	 * In-Game: "100% critical hits burning players from behind. Mini-crits burning players from the front."
	 *
	 * 
	 *
	 * On hitting a burning player, crit them from behind or minicrit them otherwise.
	 */
	val axtinguisherProperties: ItemAttribute<Boolean> get() = WeaponBaseAttributes.axtinguisherProperties
	
	/**
	 * In-Game: "Deals crits while the wielder is rocket jumping"
	 *
	 * 
	 *
	 * Critical hit enemies if the player was launched into the air by an explosion.
	 *
	 * Only works when not in Mannpower mode.
	 */
	val critWhileAirborne: ItemAttribute<Boolean> get() = WeaponBaseAttributes.critWhileAirborne
	
	/**
	 * In-Game: "Mini-crits burning targets and extinguishes them. Damage increases based on remaining duration of afterburn. Killing blows on burning players grant a speed boost."
	 *
	 * 
	 *
	 * Only activates if the weapon deals `DMG_MELEE`.
	 */
	val attackMinicritsAndConsumesBurning: ItemAttribute<Boolean> get() = WeaponBaseAttributes.attackMinicritsAndConsumesBurning
	
	/**
	 * In-Game: "Grants Triple Jump while deployed. Melee attacks mini-crit while airborne."
	 *
	 * 
	 *
	 * If greater than 0, attacks minicrit while airborne.
	 *
	 * Only procs on Scout.
	 */
	val airDashCount: ItemAttribute<Int> get() = WeaponBaseAttributes.airDashCount
	
	/**
	 * In-Game: "100% minicrits vs burning players"
	 *
	 * 
	 *
	 * Minicrits if the damage dealt is NOT `DMG_BURN`.
	 */
	val minicritVsBurningPlayer: ItemAttribute<Boolean> get() = WeaponBaseAttributes.minicritVsBurningPlayer
	
	/**
	 * In-Game: "Mini-crits targets launched airborne by explosions, grapple hooks or rocket packs"
	 *
	 * 
	 *
	 * Mini-crits targets launched airborne by an explosion.
	 *
	 * Only procs when not in Mannpower mode.
	 */
	val miniCritAirborne: ItemAttribute<Boolean> get() = WeaponBaseAttributes.miniCritAirborne
	
	/**
	 * In-Game: "Mini-crits targets when fired at their back from close range"
	 *
	 * 
	 *
	 * If true, minicrits targets facing away from the attacker that are within 22.6 HU of the attacker (sqrt 512).
	 */
	val closerangeBackattackMinicrits: ItemAttribute<Boolean> get() = WeaponBaseAttributes.closerangeBackattackMinicrits
	
	/**
	 * In-Game: "Crits whenever it would normally mini-crit"
	 *
	 * 
	 */
	val minicritsBecomeCrits: ItemAttribute<Boolean> get() = WeaponBaseAttributes.minicritsBecomeCrits
	
	/**
	 * In-Game: "N% damage vs players"
	 *
	 * 
	 */
	val dmgPenaltyVsPlayers: ItemAttribute<Float> get() = WeaponBaseAttributes.dmgPenaltyVsPlayers
	
	/**
	 * In-Game: "No critical hits vs non-burning players"
	 *
	 * 
	 *
	 * Note: Even prevents criticals when crit-boosted.
	 */
	val noCritVsNonburning: ItemAttribute<Boolean> get() = WeaponBaseAttributes.noCritVsNonburning
	
	/**
	 * In-Game: "N% damage vs non-burning players"
	 *
	 * 
	 */
	val dmgPenaltyVsNonburning: ItemAttribute<Float> get() = WeaponBaseAttributes.dmgPenaltyVsNonburning
	
	/**
	 * In-Game: "Critical damage is affected by range"
	 *
	 * 
	 *
	 * If true, crits have damage falloff (Ambassador).
	 */
	val critDmgFalloff: ItemAttribute<Boolean> get() = WeaponBaseAttributes.critDmgFalloff
	
	/**
	 * In-Game: "Minicrits whenever it would normally crit"
	 *
	 * 
	 */
	val critsBecomeMinicrits: ItemAttribute<Boolean> get() = WeaponBaseAttributes.critsBecomeMinicrits
	
	/**
	 * In-Game: "+N% damage vulnerability while active"
	 *
	 * 
	 *
	 * Increases damage taken while minicrit-boosted by Crit-a-Cola, Buffalo Steak, etc.
	 */
	val energyBuffDmgTakenMultiplier: ItemAttribute<Float> get() = WeaponBaseAttributes.energyBuffDmgTakenMultiplier
	
	/**
	 * In-Game: "+N% cloak on hit"
	 *
	 * 
	 *
	 * Adds this amount of cloak on hit.
	 *
	 * Only procs on Spy.
	 */
	val addCloakOnHit: ItemAttribute<Int> get() = WeaponBaseAttributes.addCloakOnHit
	
	/**
	 * In-Game: "On Hit: target is engulfed in flames"
	 *
	 * 
	 *
	 * Ignites player on hit.
	 */
	val setDamagetypeIgnite: ItemAttribute<Boolean> get() = WeaponBaseAttributes.setDamagetypeIgnite
	
	/**
	 * In-Game: "+N% fire damage resistance while deployed"
	 *
	 * 
	 *
	 * Gain fire resistance only when this weapon is active.
	 */
	val dmgTakenFromFireReducedOnActive: ItemAttribute<Float> get() = WeaponBaseAttributes.dmgTakenFromFireReducedOnActive
	
	/**
	 * In-Game: "N% damage bonus vs burning players"
	 *
	 * 
	 */
	val damageBonusVsBurning: ItemAttribute<Float> get() = WeaponBaseAttributes.damageBonusVsBurning
	
	/**
	 * In-Game: "N% damage vulnerability on wearer"
	 *
	 * 
	 */
	val multDmgtakenActive: ItemAttribute<Float> get() = WeaponBaseAttributes.multDmgtakenActive
	
	/**
	 * In-Game: "+N% damage from melee sources while active"
	 *
	 * 
	 */
	val dmgFromMeleeIncreased: ItemAttribute<Float> get() = WeaponBaseAttributes.dmgFromMeleeIncreased
	
	/**
	 * In-Game: "N% damage from ranged sources while active"
	 *
	 * 
	 *
	 * Applies to blast, bullet, buckshot, ignite, and sonic damage types.
	 */
	val dmgFromRangedReduced: ItemAttribute<Float> get() = WeaponBaseAttributes.dmgFromRangedReduced
	
	/**
	 * In-Game: "No self inflicted blast damage taken"
	 *
	 * 
	 */
	val noSelfBlastDmg: ItemAttribute<Boolean> get() = WeaponBaseAttributes.noSelfBlastDmg
	
	/**
	 * In-Game: "+N% damage to self"
	 *
	 * 
	 *
	 * Multiplier applied to blast damage taken from an explosion caused by said entity.
	 */
	val blastDmgToSelfIncreased: ItemAttribute<Float> get() = WeaponBaseAttributes.blastDmgToSelfIncreased
	
	/**
	 * 
	 *
	 * Used for killfeed.
	 */
	val isGigerCounter: ItemAttribute<Boolean> get() = WeaponBaseAttributes.isGigerCounter
	
	/**
	 * 
	 *
	 * Sets killfeed background gold.
	 */
	val isAustraliumItem: ItemAttribute<Boolean> get() = WeaponBaseAttributes.isAustraliumItem
	
	/**
	 * In-Game: "Imbued with an ancient power"
	 *
	 * 
	 *
	 * Sets killfeed background gold.
	 */
	val turnToGold: ItemAttribute<Boolean> get() = WeaponBaseAttributes.turnToGold
	
	/**
	 * In-Game: "N% health from healers on wearer"
	 *
	 * 
	 *
	 * Attribute class is a flat multiplier applied to health from healers while weapon is active.
	 */
	val multHealthFromhealersPenaltyActive: ItemAttribute<Float> get() = WeaponBaseAttributes.multHealthFromhealersPenaltyActive
	
	/**
	 * In-Game: "N% Overheal build rate."
	 *
	 * 
	 *
	 * Checked on the player that is healing an entity.
	 */
	val overhealFillRateReduced: ItemAttribute<Float> get() = WeaponBaseAttributes.overhealFillRateReduced
	
	/**
	 * In-Game: "N% less healing from Medic sources"
	 *
	 * 
	 *
	 * Applies to all non-dispenser forms of healing that apply the `TF_COND_HEAL_BUFF` status.
	 */
	val reducedHealingFromMedics: ItemAttribute<Float> get() = WeaponBaseAttributes.reducedHealingFromMedics
	
	/**
	 * Bonus:
	 *
	 * 	- In-Game: "+N% afterburn damage bonus"
	 *
	 * 
	 *
	 * Penalty:
	 *
	 * 	- In-Game: "N% afterburn damage penalty"
	 *
	 * 
	 *
	 * Afterburn damage.
	 */
	val weaponBurnDmgReduced: ItemAttribute<Float> get() = WeaponBaseAttributes.weaponBurnDmgReduced
	
	/**
	 * In-Game: "Halloween Fire"
	 *
	 * 
	 *
	 * Makes afterburn green.
	 */
	val spellHalloweenGreenFlames: ItemAttribute<Boolean> get() = WeaponBaseAttributes.spellHalloweenGreenFlames
	
	/**
	 * In-Game: "Syringes deliver a highly concentrated dose of Mad Milk. Duration increases per hit to a max of 4 seconds."
	 *
	 * 
	 *
	 * Duration of 4 seconds, and increases by 0.5 seconds each hit.
	 */
	val madMilkSyringes: ItemAttribute<Boolean> get() = WeaponBaseAttributes.madMilkSyringes
	
	/**
	 * In-Game: "Alt-Fire: Applies a healing effect to all nearby teammates"
	 *
	 * 
	 *
	 * Makes default weapon taunt perform the Amputator radial healing effect.
	 */
	val enablesAoeHeal: ItemAttribute<Boolean> get() = WeaponBaseAttributes.enablesAoeHeal
	
	/**
	 * Bonus:
	 *
	 * 	- In-Game: "+N% afterburn duration"
	 *
	 * 
	 *
	 * Penalty:
	 *
	 * 	- In-Game: "N% afterburn duration"
	 *
	 * 
	 *
	 * Afterburn duration.
	 */
	val weaponBurnTimeReduced: ItemAttribute<Float> get() = WeaponBaseAttributes.weaponBurnTimeReduced
	
	/**
	 * In-Game: "Fires tracer rounds"
	 *
	 * 
	 *
	 * Note: Sniper rage forcibly draws a tracer regardless of this setting.
	 *
	 * Used when firing bullets.
	 */
	val sniperFiresTracer: ItemAttribute<Boolean> get() = WeaponBaseAttributes.sniperFiresTracer
	
	/**
	 * In-Game: "Fires tracer rounds"
	 *
	 * 
	 *
	 * Same as `sniper_fires_tracer`.
	 */
	val sniperFiresTracerHidden: ItemAttribute<Boolean> get() = WeaponBaseAttributes.sniperFiresTracerHidden
	
	/**
	 * In-Game: "N% increased damage to your sentry's target"
	 *
	 * 
	 */
	val damageBonusBulletVsSentryTarget: ItemAttribute<Float> get() = WeaponBaseAttributes.damageBonusBulletVsSentryTarget
	
	/**
	 * In-Game: "On Full Charge: Projectiles penetrate players"
	 *
	 * 
	 */
	val penetratesWhenFullyCharged: ItemAttribute<Boolean> get() = WeaponBaseAttributes.penetratesWhenFullyCharged
	
	/**
	 * 
	 *
	 * Multiplier applied to movement speed scaled by ubercharge percentage.
	 *
	 * Only works if the player using this item is a Medic with a Medigun.
	 */
	val moveSpeedBonusResourceLevel: ItemAttribute<Float> get() = WeaponBaseAttributes.moveSpeedBonusResourceLevel
	
	/**
	 * In-Game: "+N% faster move speed on wearer"
	 *
	 * 
	 *
	 * Multiplier applied to player movement speed only while this is the active weapon.
	 */
	val multPlayerMovespeedActive: ItemAttribute<Float> get() = WeaponBaseAttributes.multPlayerMovespeedActive
	
	/**
	 * 
	 *
	 * If greater than 0 (like with the Thermal Thruster), takes that amount of time to holster BEFORE actually swapping weapons.
	 */
	val holsterAnimTime: ItemAttribute<Float> get() = WeaponBaseAttributes.holsterAnimTime
	
	/**
	 * In-Game: "Alt-Fire: Use N metal to pick up your targeted building from long range"
	 *
	 * 
	 *
	 * Metal cost to pick up a building at range.
	 *
	 * Restricted to the default rescue ranger range, but can be used by any weapon.
	 */
	val engineerBuildingTeleportingPickup: ItemAttribute<Int> get() = WeaponBaseAttributes.engineerBuildingTeleportingPickup
	
	/**
	 * In-Game: "N% damage on body shot"
	 *
	 * 
	 *
	 * Multiplier applied to bodyshot damage.
	 */
	val damagePenaltyOnBodyshot: ItemAttribute<Float> get() = WeaponBaseAttributes.damagePenaltyOnBodyshot
	
	/**
	 * Bonus:
	 *
	 * 	- In-Game: "+N% bonus healing from all sources"
	 *
	 * 
	 *
	 * Penalty:
	 *
	 * 	- In-Game: "N% less healing from all sources"
	 *
	 * 
	 */
	val healingReceived: ItemAttribute<Float> get() = WeaponBaseAttributes.healingReceived
	
	/**
	 * In-Game: "Stuns enemies who are also wielding this weapon"
	 *
	 * 
	 */
	val stunEnemiesWieldingSameWeapon: ItemAttribute<Boolean> get() = WeaponBaseAttributes.stunEnemiesWieldingSameWeapon
	
	/**
	 * In-Game: "All players connected via Medigun beams are hit"
	 *
	 * 
	 *
	 * Damage all players connected to the target by medigun beams.
	 */
	val damageAllConnected: ItemAttribute<Boolean> get() = WeaponBaseAttributes.damageAllConnected
	
	/**
	 * 
	 *
	 * Apply this amount of z velocity to players hit with this weapon.
	 */
	val applyZVelocityOnDamage: ItemAttribute<Float> get() = WeaponBaseAttributes.applyZVelocityOnDamage
	
	/**
	 * 
	 *
	 * Apply this amount of velocity in the direction you're facing to players hit with this weapon.
	 */
	val applyLookVelocityOnDamage: ItemAttribute<Float> get() = WeaponBaseAttributes.applyLookVelocityOnDamage
	
	/**
	 * In-Game: "Ignited enemies explode"
	 *
	 * 
	 *
	 * Applies when *any weapon* with this attribute is in the second loadout slot of the player who covered someone in gas.  This attribute does not specifically check for the Gas Passer.  For example, f a Soldier has a rocket launcher that applies `TF_COND_GAS` and their shotgun in their secondary has this attribute, they'll still explode on ignite.
	 *
	 * Only the afterburn specifically checks for the Gas Passer.
	 */
	val explodeOnIgnite: ItemAttribute<Boolean> get() = WeaponBaseAttributes.explodeOnIgnite
	
	/**
	 * Bonus:
	 *
	 * 	- In-Game: "+N% self damage force"
	 *
	 * 
	 *
	 * Penalty:
	 *
	 * 	- In-Game: "N% self damage force"
	 *
	 * 
	 *
	 * Applies to all self-damage taken from any source.
	 */
	val selfDmgPushForce: ItemAttribute<Float> get() = WeaponBaseAttributes.selfDmgPushForce
	
	/**
	 * 
	 *
	 * Knocks back attacker when wielder receives damage.
	 */
	val damageCausesAirblast: ItemAttribute<Boolean> get() = WeaponBaseAttributes.damageCausesAirblast
	
	/**
	 * 
	 *
	 * Push force applied to target when hitting an enemy.
	 *
	 * Scales by range, to a minimum of 50% of the given value.
	 */
	val damageBlastPush: ItemAttribute<Float> get() = WeaponBaseAttributes.damageBlastPush
	
	/**
	 * Bonus:
	 *
	 * 	- In-Game: "N% reduction in push force taken from damage"
	 *
	 * 
	 *
	 * Penalty:
	 *
	 * 	- Visible:
	 *
	 * 		- In-Game: "N% increase in push force taken from damage"
	 *
	 * 	- Hidden:
	 *
	 * 		- In-Game: "N% increase in push force taken from damage"
	 *
	 * 
	 *
	 * Attribute class is a flat multiplier applied to push force received from damage.
	 */
	val damageForce: ItemAttribute<Float> get() = WeaponBaseAttributes.damageForce
	
	/**
	 * In-Game: "On Hit: Bleed for N seconds"
	 *
	 * 
	 *
	 * Apply bleed on hit.
	 *
	 * Value is a time in seconds.
	 */
	val bleedingDuration: ItemAttribute<Float> get() = WeaponBaseAttributes.bleedingDuration
	
	/**
	 * In-Game: "The wearer cannot be killed by headshots"
	 *
	 * 
	 *
	 * When a headshot would kill you, reduce health to 1.
	 */
	val setBonusNoDeathFromHeadshots: ItemAttribute<Boolean> get() = WeaponBaseAttributes.setBonusNoDeathFromHeadshots
	
	/**
	 * In-Game: "Increased headshot explosion radius and damage to nearby enemies"
	 *
	 * 
	 *
	 * Only applies if in a gamemode with upgrades, but applies to all headshots.
	 *
	 * Also applies to any hitscan weapon with a `jarate_time` attribute that hit the head.
	 */
	val explosiveHeadshotLevel: ItemAttribute<Boolean> get() = WeaponBaseAttributes.explosiveHeadshotLevel
	
	/**
	 * In-Game: "Killing an enemy with a critical hit will dismember your victim. Painfully."
	 *
	 * 
	 */
	val critKillWillGib: ItemAttribute<Boolean> get() = WeaponBaseAttributes.critKillWillGib
	
	/**
	 * 
	 *
	 * If false, this weapon can only gib if it deals blast damage or half-falloff damage.
	 */
	val critOnHardHit: ItemAttribute<Boolean> get() = WeaponBaseAttributes.critOnHardHit
	
	/**
	 * In-Game: "On Kill: N seconds of 100% critical chance"
	 *
	 * 
	 *
	 * Seconds of crit-boost gained on kill.
	 *
	 * Note: actual time is `this + 1`.
	 */
	val critboostOnKill: ItemAttribute<Int> get() = WeaponBaseAttributes.critboostOnKill
	
	/**
	 * In-Game: "On Kill: Gain Mini-crits for N seconds."
	 *
	 * 
	 *
	 * Seconds of minicrit-boost gained on kill.
	 *
	 * Note: actual time is `this + 1`.
	 */
	val minicritboostOnKill: ItemAttribute<Int> get() = WeaponBaseAttributes.minicritboostOnKill
	
	/**
	 * In-Game: "Exorcism"
	 *
	 * 
	 *
	 * Exorcism spell effect.
	 */
	val spellHalloweenDeathGhosts: ItemAttribute<Boolean> get() = WeaponBaseAttributes.spellHalloweenDeathGhosts
	
	/**
	 * In-Game: "On Kill: Gain N% of base health on kill"
	 *
	 * 
	 *
	 * Percentage of health to be restored upon killing an enemy. (e.g. `25` is 25%).
	 *
	 * Post-heal player health value is capped at 1.5x the player's normal max health.
	 *
	 * Negative values are ignored.
	 */
	val restoreHealthOnKill: ItemAttribute<Int> get() = WeaponBaseAttributes.restoreHealthOnKill
	
	/**
	 * In-Game: "+N health restored on kill"
	 *
	 * 
	 *
	 * Restores this flat amount of health on killing an enemy. Post-heal player health value is capped at the player's maximum overheal.
	 *
	 * Negative values are NOT ignored.
	 */
	val healOnKill: ItemAttribute<Int> get() = WeaponBaseAttributes.healOnKill
	
	/**
	 * In-Game: "Gain a speed boost on kill"
	 *
	 * 
	 */
	val speedBoostOnKill: ItemAttribute<Int> get() = WeaponBaseAttributes.speedBoostOnKill
	
	/**
	 * In-Game: "Maximum health is drained while item is active"
	 *
	 * 
	 *
	 * Maximum health decrease per tick while weapon is active. (Gloves of Running Urgently/Eviction Notice).
	 */
	val maxhealthDrainRate: ItemAttribute<Float> get() = WeaponBaseAttributes.maxhealthDrainRate
	
	/**
	 * 
	 *
	 * If true, prevents holiday taunts from being used.
	 */
	val specialTaunt: ItemAttribute<Boolean> get() = WeaponBaseAttributes.specialTaunt
	
	/**
	 * 
	 */
	val ragdolls: ItemAttribute<Ragdolls> get() = WeaponBaseAttributes.ragdolls

   
open class OnHitAttributes : IBlockScoped {
	/**
	 * In-Game: "On Hit: damage dealt is returned as ammo"
	 */
	open val addOnhitAddammo = ItemAttributeNamed<Boolean>("add onhit addammo")
	
	/**
	 * In-Game: "On Hit Spy: Reveal cloaked Spy"
	 */
	open val revealCloakedVictimOnHit = ItemAttributeNamed<Boolean>("reveal cloaked victim on hit")
	
	/**
	 * In-Game: "On Hit Spy: Reveal disguised Spy"
	 */
	open val revealDisguisedVictimOnHit = ItemAttributeNamed<Boolean>("reveal disguised victim on hit")
	
	/**
	 * Bonus:
	 *
	 * 	- In-Game: "On Hit: Gain up to +N health"
	 *
	 * 
	 *
	 * Penalty:
	 *
	 * 	- In-Game: "On Hit: N health"
	 */
	open val selfdmgOnHitForRapidfire = BonusPenalty(
		ItemAttributeNamed<Int>("heal on hit for rapidfire"),
		ItemAttributeNamed<Int>("selfdmg on hit for rapidfire")
	)
	
	/**
	 * In-Game: "Melee hits refill  N% of your charge meter."
	 */
	open val chargeMeterOnHit = ItemAttributeNamed<Float>("charge meter on hit")
	
	/**
	 * In-Game: "On Hit: Gain a speed boost"
	 */
	open val speedBoostOnHit = ItemAttributeNamed<Int>("speed_boost_on_hit")
	
	/**
	 * In-Game: "On Hit: N% ÜberCharge added"
	 */
	open val addUberChargeOnHit = ItemAttributeNamed<Float>("add uber charge on hit")
	
	/**
	 * Bonus:
	 *
	 * 	- In-Game: "N% rage gained on hit"
	 *
	 * 
	 *
	 * Penalty:
	 *
	 * 	- In-Game: "N% rage lost on hit"
	 */
	open val rageOnHit = BonusPenalty(
		ItemAttributeNamed<Int>("mod rage on hit bonus"),
		ItemAttributeNamed<Int>("mod rage on hit penalty")
	)
	
	/**
	 * In-Game: "On Hit: Builds Boost Run speed increased with Boost"
	 */
	open val boostOnDamage = ItemAttributeNamed<Boolean>("boost on damage")
	
	/**
	 * In-Game: "Generate Rage by dealing damage.  When fully charged, press the Special-Attack key to activate knockback"
	 */
	open val generateRageOnDamage = ItemAttributeNamed<Boolean>("generate rage on damage")
	
	/**
	 * In-Game: "Generate building rescue energy on damage"
	 */
	open val engineerRageOnDmg = ItemAttributeNamed<Boolean>("engineer rage on dmg")
	
	/**
	 * In-Game: "On Hit: N% chance to slow target"
	 */
	open val slowEnemyOnHit = ItemAttributeNamed<Float>("slow enemy on hit")
	
	/**
	 * In-Game: "On Hit: Slow target movement by 40% for Ns"
	 */
	open val slowEnemyOnHitMajor = ItemAttributeNamed<Float>("slow enemy on hit major")
	
	/**
	 * In-Game: "On Hit: One target at a time is Marked-For-Death, causing all damage taken to be mini-crits"
	 */
	open val markForDeath = ItemAttributeNamed<Boolean>("mark for death")
	
	/**
	 * In-Game: "On Hit: If enemy's belt is at or above eye level, stun them for N seconds"
	 */
	open val stunWaistHighAirborne = ItemAttributeNamed<Boolean>("mod stun waist high airborne")
	
	/**
	 * In-Game: "On Hit: Victim loses up to N% Medigun charge"
	 */
	open val subtractVictimMedigunChargeOnHit = ItemAttributeNamed<Int>("subtract victim medigun charge on hit")
	
	/**
	 * In-Game: "On Hit: Victim loses up to N% cloak"
	 */
	open val subtractVictimCloakOnHit = ItemAttributeNamed<Int>("subtract victim cloak on hit")

	
}

	
open class RevengeCritsAttributes : IBlockScoped {
	/**
	 * In-Game: "Gives one guaranteed critical hit for each building destroyed with your sapper attached or backstab kill"
	 */
	open val sapperKillsCollectCrits = ItemAttributeNamed<Boolean>("sapper kills collect crits")
	
	/**
	 * In-Game: "Alt-Fire: Extinguish teammates to gain guaranteed critical hits"
	 */
	open val extinguishEarnsRevengeCrits = ItemAttributeNamed<Boolean>("extinguish earns revenge crits")
	
	/**
	 * In-Game: "Gain 2 revenge crits for each sentry kill and 1 for each sentry assist when your sentry is destroyed."
	 */
	open val canGainRevengeCrits = ItemAttributeNamed<Boolean>("mod sentry killed revenge")

	
}

	
open class RagdollsAttributes : IBlockScoped {
	/**
	 * In-Game: "Backstab turns victim to ice"
	 */
	open val freezeBackstabVictim = ItemAttributeNamed<Boolean>("freeze backstab victim")
	
	/**
	 * In-Game: "Imbued with an ancient power"
	 */
	open val turnToGold = ItemAttributeNamed<Boolean>("turn to gold")
	
	
	open val ragdollsBecomeAsh = ItemAttributeNamed<Boolean>("ragdolls become ash")
	
	
	open val ragdollsPlasmaEffect = ItemAttributeNamed<Boolean>("ragdolls plasma effect")
	
	
	open val critOnHardHit = ItemAttributeNamed<Boolean>("crit on hard hit")

	
}
}

