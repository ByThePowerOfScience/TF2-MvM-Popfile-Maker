package btpos.source.vdfdsl.tf2.itemattributes

import btpos.source.vdfdsl.modeling.*
import btpos.source.vdfdsl.serialization.codecs.*
import btpos.source.vdfdsl.tf2.itemattributes.impl.*
import java.util.*


interface WeaponBaseAttributes : BaseCombatWeaponAttributes, IBlockScoped {
	companion object : WeaponBaseAttributes
	
	/**
	 * In-Game: "Ammo boxes collected also give Charge"
	 *
	 * 
	 *
	 * If true, and player has a demoman charge meter, add charge based on ammo pack size.
	 */
	context(attrs: IKeyValueMap)
	var ammoPacksGiveDemoknightCharge: Boolean?
		get() = attrs.getTyped("ammo gives charge", BinaryIntCodec)
		set(value) = attrs.setNullable("ammo gives charge", value, BinaryIntCodec)
	
	/**
	 * In-Game: "No ammo from dispensers when active"
	 *
	 * 
	 */
	context(attrs: IKeyValueMap)
	var noPrimaryAmmoFromDispensersWhileActive: Boolean?
		get() = attrs.getTyped("no primary ammo from dispensers while active", BinaryIntCodec)
		set(value) = attrs.setNullable("no primary ammo from dispensers while active", value, BinaryIntCodec)
	
	/**
	 * In-Game: "No metal from dispensers when active."
	 *
	 * 
	 */
	context(attrs: IKeyValueMap)
	var noMetalFromDispensersWhileActive: Boolean?
		get() = attrs.getTyped("no metal from dispensers while active", BinaryIntCodec)
		set(value) = attrs.setNullable("no metal from dispensers while active", value, BinaryIntCodec)
	
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
	val dmgVsBuildings get() = BonusPenalty<Number, Number>("dmg bonus vs buildings", "dmg penalty vs buildings")
	
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
	val clipSize get() = BonusPenalty_PenaltyNested<Number, VisHidden<Number, Number>>("clip size bonus", VisHidden<Number, Number>("clip size penalty", "clip size penalty HIDDEN"))
	
	/**
	 * In-Game: "+N% clip size"
	 *
	 * 
	 *
	 * Stacks with [clipSize].
	 */
	context(attrs: IKeyValueMap)
	var clipSizeBonusUpgrade: Number?
		get() = attrs.getTyped("clip size bonus upgrade")
		set(value) = attrs.setNullable("clip size bonus upgrade", value)
	
	/**
	 * In-Game: "+N clip size"
	 *
	 * 
	 *
	 * MVM attribute that specifically handles rocket and grenade launchers.
	 *
	 * Note that [clipSize], [clipSizeBonusUpgrade], and [clipSizeUpgradeAtomic] all stack with one another.
	 */
	context(attrs: IKeyValueMap)
	var clipSizeUpgradeAtomic: Int?
		get() = attrs.getTyped("clip size upgrade atomic")
		set(value) = attrs.setNullable("clip size upgrade atomic", value)
	
	/**
	 * In-Game: "Clip size increased on kill"
	 *
	 * 
	 */
	context(attrs: IKeyValueMap)
	var clipsizeIncreaseOnKill: Int?
		get() = attrs.getTyped("clipsize increase on kill")
		set(value) = attrs.setNullable("clipsize increase on kill", value)
	
	/**
	 * In-Game: "Replaces the Sentry with a Mini-Sentry"
	 *
	 * 
	 *
	 * Determines the hand used in the model.
	 */
	context(attrs: IKeyValueMap)
	var wrenchBuildsMinisentry: Boolean?
		get() = attrs.getTyped("mod wrench builds minisentry", BinaryIntCodec)
		set(value) = attrs.setNullable("mod wrench builds minisentry", value, BinaryIntCodec)
	
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
	val deployTime get() = BonusPenalty<Number, Number>("deploy time decreased", "deploy time increased")
	
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
	val singleWepDeployTime get() = BonusPenalty<Number, Number>("single wep deploy time decreased", "single wep deploy time increased")
	
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
	val singleWepHolsterTime get() = BonusPenalty<Number, Number>("switch from wep deploy time decreased", "single wep holster time increased")
	
	/**
	 * In-Game: "This Weapon has a large melee range and deploys and holsters slower"
	 *
	 * 
	 *
	 * If true, make weapon deploy and holster 75% slower.
	 */
	context(attrs: IKeyValueMap)
	var isASword: Boolean?
		get() = attrs.getTyped("is_a_sword", BinaryIntCodec)
		set(value) = attrs.setNullable("is_a_sword", value, BinaryIntCodec)
	
	/**
	 * In-Game: "While not being healed by a medic, your weapon switch time is N% longer"
	 *
	 * 
	 *
	 * On player.
	 *
	 * Multiplier applied if NOT being healed by a medic.
	 */
	context(attrs: IKeyValueMap)
	var medicHealedDeployTimePenalty: Number?
		get() = attrs.getTyped("mod medic healed deploy time penalty")
		set(value) = attrs.setNullable("mod medic healed deploy time penalty", value)
	
	/**
	 * 
	 *
	 * Should force switch to this item on some condition.
	 */
	context(attrs: IKeyValueMap)
	var forceWeaponSwitch: Boolean?
		get() = attrs.getTyped("force weapon switch", BinaryIntCodec)
		set(value) = attrs.setNullable("force weapon switch", value, BinaryIntCodec)
	
	/**
	 * In-Game: "When weapon is active:"
	 *
	 * 
	 *
	 * If true, only applies attributes when weapon is active, and unapplies them when switching off.
	 *
	 * This also means you can't have "only active when holding weapon" and "always active" attributes on the same weapon (excluding the specific attributes that are _always_ "only when active"), since the order you specify attributes in doesn't matter.
	 */
	context(attrs: IKeyValueMap)
	var provideOnActive: Boolean?
		get() = attrs.getTyped("provide on active", BinaryIntCodec)
		set(value) = attrs.setNullable("provide on active", value, BinaryIntCodec)
	
	/**
	 * In-Game: "Projectiles penetrate enemy players"
	 *
	 * 
	 *
	 * How many players your "projectile" (*including bullets*) should penetrate.
	 */
	context(attrs: IKeyValueMap)
	var projectilePenetration: Int?
		get() = attrs.getTyped("projectile penetration")
		set(value) = attrs.setNullable("projectile penetration", value)
	
	/**
	 * In-Game: "Bullets penetrate +N enemies"
	 *
	 * 
	 *
	 * How many players your "projectile" (*including bullets*) should penetrate.
	 */
	context(attrs: IKeyValueMap)
	var projectilePenetrationHeavy: Int?
		get() = attrs.getTyped("projectile penetration heavy")
		set(value) = attrs.setNullable("projectile penetration heavy", value)
	
	/**
	 * In-Game: "+N% bullets per shot"
	 *
	 * 
	 */
	context(attrs: IKeyValueMap)
	var bulletsPerShotBonus: Number?
		get() = attrs.getTyped("bullets per shot bonus")
		set(value) = attrs.setNullable("bullets per shot bonus", value)
	
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
	val damage get() = BonusPenalty_BonusNested<VisHidden<Number, Number>, Number>(VisHidden<Number, Number>("damage bonus", "damage bonus HIDDEN"), "damage penalty")
	
	/**
	 * In-Game: "No random critical hits"
	 *
	 * 
	 *
	 * "No random crits" sets this to `0.0`.
	 */
	context(attrs: IKeyValueMap)
	var critModDisabled: Number?
		get() = attrs.getTyped("crit mod disabled")
		set(value) = attrs.setNullable("crit mod disabled", value)
	
	/**
	 * In-Game: "No random critical hits"
	 *
	 * 
	 *
	 * "No random crits" sets this to `0.0`.
	 */
	context(attrs: IKeyValueMap)
	var critModDisabledHidden: Number?
		get() = attrs.getTyped("crit mod disabled hidden")
		set(value) = attrs.setNullable("crit mod disabled hidden", value)
	
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
	val autoFiresFullClip get() = BonusPenalty<Boolean, Boolean>("auto fires full clip", "auto fires full clip penalty")
	
	/**
	 * 
	 */
	context(attrs: IKeyValueMap)
	var autoFiresFullClipAllAtOnce: Boolean?
		get() = attrs.getTyped("auto fires full clip all at once", BinaryIntCodec)
		set(value) = attrs.setNullable("auto fires full clip all at once", value, BinaryIntCodec)
	
	/**
	 * In-Game: "Overloading the chamber will cause a misfire"
	 *
	 * 
	 *
	 * Deals damage to the player when overloaded.
	 */
	context(attrs: IKeyValueMap)
	var canOverload: Boolean?
		get() = attrs.getTyped("can overload", BinaryIntCodec)
		set(value) = attrs.setNullable("can overload", value, BinaryIntCodec)
	
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
	val fireRate get() = BonusPenalty_BothNested<VisHidden<Number, Number>, VisHidden<Number, Number>>(VisHidden<Number, Number>("fire rate bonus", "fire rate bonus HIDDEN"), VisHidden<Number, Number>("fire rate penalty", "fire rate penalty HIDDEN"))
	
	/**
	 * 
	 */
	context(attrs: IKeyValueMap)
	var autoFiresWhenFull: Boolean?
		get() = attrs.getTyped("auto fires when full", BinaryIntCodec)
		set(value) = attrs.setNullable("auto fires when full", value, BinaryIntCodec)
	
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
	val reloadTime get() = BonusPenalty<Number, Number>("Reload time decreased", "Reload time increased")
	
	/**
	 * In-Game: "N% slower reload time"
	 *
	 * 
	 */
	context(attrs: IKeyValueMap)
	var reloadTimeIncreasedHidden: Number?
		get() = attrs.getTyped("reload time increased hidden")
		set(value) = attrs.setNullable("reload time increased hidden", value)
	
	/**
	 * In-Game: "+N% faster reload time"
	 *
	 * 
	 *
	 * This is what's used for weapons that draw directly from reserve ammo, like the flare gun and sniper rifle.
	 */
	context(attrs: IKeyValueMap)
	var fasterReloadRate: Number?
		get() = attrs.getTyped("faster reload rate")
		set(value) = attrs.setNullable("faster reload rate", value)
	
	/**
	 * 
	 *
	 * On player.
	 *
	 * Halloween reload time multiplier.
	 */
	context(attrs: IKeyValueMap)
	var halloweenReloadTimeDecreased: Number?
		get() = attrs.getTyped("halloween reload time decreased")
		set(value) = attrs.setNullable("halloween reload time decreased", value)
	
	/**
	 * In-Game: "N% faster reload time while being healed"
	 *
	 * 
	 */
	context(attrs: IKeyValueMap)
	var reloadTimeDecreasedWhileHealed: Number?
		get() = attrs.getTyped("reload time decreased while healed")
		set(value) = attrs.setNullable("reload time decreased while healed", value)
	
	/**
	 * 
	 */
	context(attrs: IKeyValueMap)
	var weaponAllowInspect: Boolean?
		get() = attrs.getTyped("weapon_allow_inspect", BinaryIntCodec)
		set(value) = attrs.setNullable("weapon_allow_inspect", value, BinaryIntCodec)
	
	/**
	 * 
	 */
	val onHit get() = OnHitAttributes
	
	/**
	 * In-Game: "On Hit by Fire: Fireproof for 1 second and Afterburn immunity for N seconds"
	 *
	 * 
	 *
	 * Addcond parameter.
	 */
	context(attrs: IKeyValueMap)
	var becomeFireproofOnHitByFire: Int?
		get() = attrs.getTyped("become fireproof on hit by fire")
		set(value) = attrs.setNullable("become fireproof on hit by fire", value)
	
	/**
	 * 
	 *
	 * Again, "projectile" includes bullets.
	 */
	context(attrs: IKeyValueMap)
	var centerfireProjectile: Boolean?
		get() = attrs.getTyped("centerfire projectile", BinaryIntCodec)
		set(value) = attrs.setNullable("centerfire projectile", value, BinaryIntCodec)
	
	/**
	 * In-Game: "+N degrees random projectile deviation"
	 *
	 * 
	 *
	 * Ok this time it _doesn't_ include bullets. I think.
	 */
	context(attrs: IKeyValueMap)
	var projectileSpreadAnglePenalty: Int?
		get() = attrs.getTyped("projectile spread angle penalty")
		set(value) = attrs.setNullable("projectile spread angle penalty", value)
	
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
	val activeHealthDegen get() = BonusPenalty<Int, Int>("active health regen", "active health degen")
	
	/**
	 * 
	 */
	context(attrs: IKeyValueMap)
	var killEaterKillType: Int?
		get() = attrs.getTyped("kill eater kill type")
		set(value) = attrs.setNullable("kill eater kill type", value)
	
	/**
	 * In-Game: "Silent Killer: No attack noise from backstabs"
	 *
	 * 
	 */
	context(attrs: IKeyValueMap)
	var silentKiller: Boolean?
		get() = attrs.getTyped("silent killer", BinaryIntCodec)
		set(value) = attrs.setNullable("silent killer", value, BinaryIntCodec)
	
	/**
	 * In-Game: "Cannot be crit boosted"
	 *
	 * 
	 *
	 * Can't be crit-boosted.
	 */
	context(attrs: IKeyValueMap)
	var noCritBoost: Boolean?
		get() = attrs.getTyped("no crit boost", BinaryIntCodec)
		set(value) = attrs.setNullable("no crit boost", value, BinaryIntCodec)
	
	/**
	 * In-Game: "Gives one guaranteed critical hit for each building destroyed with your sapper attached or backstab kill"
	 *
	 * 
	 *
	 * The weapon supports revenge crits if this, `extinguish_revenge`, or `sentry_killed_revenge` are set.
	 *
	 * Note that the logic for _gaining_ said crits depends on the weapon. Having one of these set just says it _can_ have them.
	 */
	context(attrs: IKeyValueMap)
	var sapperKillsCollectCrits: Boolean?
		get() = attrs.getTyped("sapper kills collect crits", BinaryIntCodec)
		set(value) = attrs.setNullable("sapper kills collect crits", value, BinaryIntCodec)
	
	/**
	 * In-Game: "Alt-Fire: Extinguish teammates to gain guaranteed critical hits"
	 *
	 * 
	 *
	 * The weapon supports revenge crits if this, `sapper_kills_collect_crits`, or `sentry_killed_revenge` are set.
	 *
	 * Note that the logic for _gaining_ said crits depends on the weapon. Having one of these set just says it _can_ have them.
	 */
	context(attrs: IKeyValueMap)
	var extinguishEarnsRevengeCrits: Boolean?
		get() = attrs.getTyped("extinguish earns revenge crits", BinaryIntCodec)
		set(value) = attrs.setNullable("extinguish earns revenge crits", value, BinaryIntCodec)
	
	/**
	 * In-Game: "Gain 2 revenge crits for each sentry kill and 1 for each sentry assist when your sentry is destroyed."
	 *
	 * 
	 *
	 * The weapon supports revenge crits if this, `extinguish_revenge`, or `sapper_kills_collect_crits` are set.
	 *
	 * Note that the logic for _gaining_ said crits depends on the weapon. Having one of these set just says it _can_ have them.
	 */
	context(attrs: IKeyValueMap)
	var canGainRevengeCrits: Boolean?
		get() = attrs.getTyped("mod sentry killed revenge", BinaryIntCodec)
		set(value) = attrs.setNullable("mod sentry killed revenge", value, BinaryIntCodec)
	
	/**
	 * In-Game: "Honorbound: Once drawn sheathing deals 50 damage to yourself unless it kills."
	 *
	 * 
	 *
	 * Takes 50 health when holstering before it gets a kill.
	 */
	context(attrs: IKeyValueMap)
	var honorbound: Boolean?
		get() = attrs.getTyped("honorbound", BinaryIntCodec)
		set(value) = attrs.setNullable("honorbound", value, BinaryIntCodec)
	
	/**
	 * 
	 */
	context(attrs: IKeyValueMap)
	var weaponStattrakModuleScale: Number?
		get() = attrs.getTyped("weapon_stattrak_module_scale")
		set(value) = attrs.setNullable("weapon_stattrak_module_scale", value)
	
	/**
	 * 
	 */
	context(attrs: IKeyValueMap)
	var minViewmodelOffset: Int?
		get() = attrs.getTyped("min_viewmodel_offset")
		set(value) = attrs.setNullable("min_viewmodel_offset", value)
	
	/**
	 * In-Game: "+N% increase in recharge rate"
	 *
	 * 
	 *
	 * Things like throwable recharge timers, jetpack charging, etc. How much it recharges per... some amount of time.
	 */
	context(attrs: IKeyValueMap)
	var effectBarRechargeRateIncreased: Number?
		get() = attrs.getTyped("effect bar recharge rate increased")
		set(value) = attrs.setNullable("effect bar recharge rate increased", value)
	
	/**
	 * In-Game: "Blocks healing while in use"
	 *
	 * 
	 *
	 * Prevents mediguns from latching onto you.
	 */
	context(attrs: IKeyValueMap)
	override var weaponBlocksHealing: Boolean?
		get() = super.weaponBlocksHealing
		set(value) { super.weaponBlocksHealing = value }
	
	/**
	 * In-Game: "+N% ÜberCharge rate for the medic healing you This effect does not work in the respawn room"
	 *
	 * 
	 *
	 * Multiplier applied to your healer's ubercharge rate.
	 *
	 * NOTE: Only applied if user is outside of the respawn room.
	 */
	context(attrs: IKeyValueMap)
	var uberchargeRateBonusForHealer: Number?
		get() = attrs.getTyped("ubercharge rate bonus for healer")
		set(value) = attrs.setNullable("ubercharge rate bonus for healer", value)
	
	/**
	 * In-Game: "+N% greater jump height when active"
	 *
	 * 
	 *
	 * One of the "only when weapon is active" kind of attributes.  These always only work if the weapon that provides them is active, while still allowing other attributes to be globally-applied.
	 */
	context(attrs: IKeyValueMap)
	var increasedJumpHeightFromWeapon: Number?
		get() = attrs.getTyped("increased jump height from weapon")
		set(value) = attrs.setNullable("increased jump height from weapon", value)
	
	/**
	 * In-Game: "On Hit: Gain up to +N health per attack"
	 *
	 * 
	 *
	 * Maximum amount of health that can be gained from an AoE damage source.  Health received is multiplied by `damage dealt / base damage of the weapon`, to a max of 100% of the defined value.
	 */
	context(attrs: IKeyValueMap)
	var healthOnRadiusDamage: Int?
		get() = attrs.getTyped("health on radius damage")
		set(value) = attrs.setNullable("health on radius damage", value)
	
	/**
	 * In-Game: "Attacks pierce damage resistance effects and bonuses"
	 *
	 * 
	 */
	context(attrs: IKeyValueMap)
	var dmgPiercesResistsAbsorbs: Boolean?
		get() = attrs.getTyped("dmg pierces resists absorbs", BinaryIntCodec)
		set(value) = attrs.setNullable("dmg pierces resists absorbs", value, BinaryIntCodec)
	
	/**
	 * In-Game: "100% critical hit vs burning players"
	 *
	 * 
	 *
	 * The weapon's "crit players with X condition" stat.  Each bit of this number specifies a condition that'll cause a forced crit, from [CritConditions][#CritConditions].
	 */
	context(attrs: IKeyValueMap)
	var critVsBurningPlayers: EnumSet<TFCritCondition>?
		get() = attrs.getTyped("crit vs burning players", EnumSetOrCodec())
		set(value) = attrs.setNullable("crit vs burning players", value, EnumSetOrCodec())
	
	/**
	 * In-Game: "100% critical hit vs disguised players"
	 *
	 * 
	 *
	 * The weapon's "crit players with X condition" stat.  Each bit of this number specifies a condition that'll cause a forced crit, from [CritConditions][#CritConditions].
	 */
	context(attrs: IKeyValueMap)
	var critVsDisguisedPlayers: EnumSet<TFCritCondition>?
		get() = attrs.getTyped("crit vs disguised players", EnumSetOrCodec())
		set(value) = attrs.setNullable("crit vs disguised players", value, EnumSetOrCodec())
	
	/**
	 * In-Game: "100% critical hit vs stunned players"
	 *
	 * 
	 *
	 * The weapon's "crit players with X condition" stat.  Each bit of this number specifies a condition that'll cause a forced crit, from [CritConditions][#CritConditions].
	 */
	context(attrs: IKeyValueMap)
	var critVsStunnedPlayers: EnumSet<TFCritCondition>?
		get() = attrs.getTyped("crit vs stunned players", EnumSetOrCodec())
		set(value) = attrs.setNullable("crit vs stunned players", value, EnumSetOrCodec())
	
	/**
	 * In-Game: "100% critical hit vs wet players"
	 *
	 * 
	 */
	context(attrs: IKeyValueMap)
	var critVsWetPlayers: Boolean?
		get() = attrs.getTyped("crit vs wet players", BinaryIntCodec)
		set(value) = attrs.setNullable("crit vs wet players", value, BinaryIntCodec)
	
	/**
	 * In-Game: "100% critical hit vs non-burning players"
	 *
	 * 
	 *
	 * Crit against players that DON'T have these conditions.
	 *
	 * Uses same values as above list.
	 */
	context(attrs: IKeyValueMap)
	var critVsNonBurningPlayers: EnumSet<TFCritCondition>?
		get() = attrs.getTyped("crit vs non burning players", EnumSetOrCodec())
		set(value) = attrs.setNullable("crit vs non burning players", value, EnumSetOrCodec())
	
	/**
	 * In-Game: "100% critical hits burning players from behind. Mini-crits burning players from the front."
	 *
	 * 
	 *
	 * On hitting a burning player, crit them from behind or minicrit them otherwise.
	 */
	context(attrs: IKeyValueMap)
	var axtinguisherProperties: Boolean?
		get() = attrs.getTyped("axtinguisher properties", BinaryIntCodec)
		set(value) = attrs.setNullable("axtinguisher properties", value, BinaryIntCodec)
	
	/**
	 * In-Game: "Deals crits while the wielder is rocket jumping"
	 *
	 * 
	 *
	 * Critical hit enemies if the player was launched into the air by an explosion.
	 *
	 * Only works when not in Mannpower mode.
	 */
	context(attrs: IKeyValueMap)
	var critWhileAirborne: Boolean?
		get() = attrs.getTyped("mod crit while airborne", BinaryIntCodec)
		set(value) = attrs.setNullable("mod crit while airborne", value, BinaryIntCodec)
	
	/**
	 * In-Game: "Mini-crits burning targets and extinguishes them. Damage increases based on remaining duration of afterburn. Killing blows on burning players grant a speed boost."
	 *
	 * 
	 *
	 * Only activates if the weapon deals `DMG_MELEE`.
	 */
	context(attrs: IKeyValueMap)
	var attackMinicritsAndConsumesBurning: Boolean?
		get() = attrs.getTyped("attack_minicrits_and_consumes_burning", BinaryIntCodec)
		set(value) = attrs.setNullable("attack_minicrits_and_consumes_burning", value, BinaryIntCodec)
	
	/**
	 * In-Game: "Grants Triple Jump while deployed. Melee attacks mini-crit while airborne."
	 *
	 * 
	 *
	 * If greater than 0, attacks minicrit while airborne.
	 *
	 * Only procs on Scout.
	 */
	context(attrs: IKeyValueMap)
	var airDashCount: Int?
		get() = attrs.getTyped("air dash count")
		set(value) = attrs.setNullable("air dash count", value)
	
	/**
	 * In-Game: "100% minicrits vs burning players"
	 *
	 * 
	 *
	 * Only procs if the damage dealt is NOT `DMG_BURN`.
	 */
	context(attrs: IKeyValueMap)
	var minicritVsBurningPlayer: Boolean?
		get() = attrs.getTyped("minicrit vs burning player", BinaryIntCodec)
		set(value) = attrs.setNullable("minicrit vs burning player", value, BinaryIntCodec)
	
	/**
	 * In-Game: "Mini-crits targets launched airborne by explosions, grapple hooks or rocket packs"
	 *
	 * 
	 *
	 * Mini-crits targets launched airborne by an explosion.
	 *
	 * Only procs when not in Mannpower mode.
	 */
	context(attrs: IKeyValueMap)
	var miniCritAirborne: Boolean?
		get() = attrs.getTyped("mod mini-crit airborne", BinaryIntCodec)
		set(value) = attrs.setNullable("mod mini-crit airborne", value, BinaryIntCodec)
	
	/**
	 * In-Game: "Mini-crits targets when fired at their back from close range"
	 *
	 * 
	 *
	 * If true, minicrits targets facing away from the attacker that are within 22.6 HU of the attacker (sqrt 512).
	 */
	context(attrs: IKeyValueMap)
	var closerangeBackattackMinicrits: Boolean?
		get() = attrs.getTyped("closerange backattack minicrits", BinaryIntCodec)
		set(value) = attrs.setNullable("closerange backattack minicrits", value, BinaryIntCodec)
	
	/**
	 * In-Game: "Crits whenever it would normally mini-crit"
	 *
	 * 
	 */
	context(attrs: IKeyValueMap)
	var minicritsBecomeCrits: Boolean?
		get() = attrs.getTyped("minicrits become crits", BinaryIntCodec)
		set(value) = attrs.setNullable("minicrits become crits", value, BinaryIntCodec)
	
	/**
	 * In-Game: "N% damage vs players"
	 *
	 * 
	 */
	context(attrs: IKeyValueMap)
	var dmgPenaltyVsPlayers: Number?
		get() = attrs.getTyped("dmg penalty vs players")
		set(value) = attrs.setNullable("dmg penalty vs players", value)
	
	/**
	 * In-Game: "No critical hits vs non-burning players"
	 *
	 * 
	 *
	 * Note: prevents criticals even when crit-boosted.
	 */
	context(attrs: IKeyValueMap)
	var noCritVsNonburning: Boolean?
		get() = attrs.getTyped("no crit vs nonburning", BinaryIntCodec)
		set(value) = attrs.setNullable("no crit vs nonburning", value, BinaryIntCodec)
	
	/**
	 * In-Game: "N% damage vs non-burning players"
	 *
	 * 
	 */
	context(attrs: IKeyValueMap)
	var dmgPenaltyVsNonburning: Number?
		get() = attrs.getTyped("dmg penalty vs nonburning")
		set(value) = attrs.setNullable("dmg penalty vs nonburning", value)
	
	/**
	 * In-Game: "Critical damage is affected by range"
	 *
	 * 
	 *
	 * If true, crits have damage falloff (Ambassador).
	 */
	context(attrs: IKeyValueMap)
	var critDmgFalloff: Boolean?
		get() = attrs.getTyped("crit_dmg_falloff", BinaryIntCodec)
		set(value) = attrs.setNullable("crit_dmg_falloff", value, BinaryIntCodec)
	
	/**
	 * In-Game: "Minicrits whenever it would normally crit"
	 *
	 * 
	 */
	context(attrs: IKeyValueMap)
	var critsBecomeMinicrits: Boolean?
		get() = attrs.getTyped("crits_become_minicrits", BinaryIntCodec)
		set(value) = attrs.setNullable("crits_become_minicrits", value, BinaryIntCodec)
	
	/**
	 * In-Game: "+N% damage vulnerability while active"
	 *
	 * 
	 *
	 * Increases damage taken while minicrit-boosted by Crit-a-Cola, Buffalo Steak, etc.
	 */
	context(attrs: IKeyValueMap)
	var energyBuffDmgTakenMultiplier: Number?
		get() = attrs.getTyped("energy buff dmg taken multiplier")
		set(value) = attrs.setNullable("energy buff dmg taken multiplier", value)
	
	/**
	 * In-Game: "+N% cloak on hit"
	 *
	 * 
	 *
	 * Adds this amount of cloak on hit.
	 *
	 * Only procs on Spy.
	 */
	context(attrs: IKeyValueMap)
	var addCloakOnHit: Int?
		get() = attrs.getTyped("add cloak on hit")
		set(value) = attrs.setNullable("add cloak on hit", value)
	
	/**
	 * In-Game: "On Hit: target is engulfed in flames"
	 *
	 * 
	 *
	 * Ignites player on hit.
	 */
	context(attrs: IKeyValueMap)
	var setDamagetypeIgnite: Boolean?
		get() = attrs.getTyped("Set DamageType Ignite", BinaryIntCodec)
		set(value) = attrs.setNullable("Set DamageType Ignite", value, BinaryIntCodec)
	
	/**
	 * In-Game: "+N% fire damage resistance while deployed"
	 *
	 * 
	 *
	 * Gain fire resistance only when this weapon is active.
	 */
	context(attrs: IKeyValueMap)
	var dmgTakenFromFireReducedOnActive: Number?
		get() = attrs.getTyped("dmg taken from fire reduced on active")
		set(value) = attrs.setNullable("dmg taken from fire reduced on active", value)
	
	/**
	 * In-Game: "N% damage bonus vs burning players"
	 *
	 * 
	 */
	context(attrs: IKeyValueMap)
	var damageBonusVsBurning: Number?
		get() = attrs.getTyped("damage bonus vs burning")
		set(value) = attrs.setNullable("damage bonus vs burning", value)
	
	/**
	 * In-Game: "N% damage vulnerability on wearer"
	 *
	 * 
	 */
	context(attrs: IKeyValueMap)
	var multDmgtakenActive: Number?
		get() = attrs.getTyped("mult_dmgtaken_active")
		set(value) = attrs.setNullable("mult_dmgtaken_active", value)
	
	/**
	 * In-Game: "+N% damage from melee sources while active"
	 *
	 * 
	 */
	context(attrs: IKeyValueMap)
	var dmgFromMeleeIncreased: Number?
		get() = attrs.getTyped("dmg from melee increased")
		set(value) = attrs.setNullable("dmg from melee increased", value)
	
	/**
	 * In-Game: "N% damage from ranged sources while active"
	 *
	 * 
	 *
	 * Applies to blast, bullet, buckshot, ignite, and sonic damage types.
	 */
	context(attrs: IKeyValueMap)
	var dmgFromRangedReduced: Number?
		get() = attrs.getTyped("dmg from ranged reduced")
		set(value) = attrs.setNullable("dmg from ranged reduced", value)
	
	/**
	 * In-Game: "No self inflicted blast damage taken"
	 *
	 * 
	 */
	context(attrs: IKeyValueMap)
	var noSelfBlastDmg: Boolean?
		get() = attrs.getTyped("no self blast dmg", BinaryIntCodec)
		set(value) = attrs.setNullable("no self blast dmg", value, BinaryIntCodec)
	
	/**
	 * In-Game: "+N% damage to self"
	 *
	 * 
	 *
	 * Multiplier applied to blast damage taken from an explosion caused by said entity.
	 */
	context(attrs: IKeyValueMap)
	var blastDmgToSelfIncreased: Number?
		get() = attrs.getTyped("blast dmg to self increased")
		set(value) = attrs.setNullable("blast dmg to self increased", value)
	
	/**
	 * 
	 *
	 * Used for killfeed.
	 */
	context(attrs: IKeyValueMap)
	var isGigerCounter: Boolean?
		get() = attrs.getTyped("is giger counter", BinaryIntCodec)
		set(value) = attrs.setNullable("is giger counter", value, BinaryIntCodec)
	
	/**
	 * 
	 *
	 * Sets killfeed background gold.
	 */
	context(attrs: IKeyValueMap)
	var isAustraliumItem: Boolean?
		get() = attrs.getTyped("is australium item", BinaryIntCodec)
		set(value) = attrs.setNullable("is australium item", value, BinaryIntCodec)
	
	/**
	 * In-Game: "Imbued with an ancient power"
	 *
	 * 
	 *
	 * Sets killfeed background gold.
	 */
	context(attrs: IKeyValueMap)
	var turnToGold: Boolean?
		get() = attrs.getTyped("turn to gold", BinaryIntCodec)
		set(value) = attrs.setNullable("turn to gold", value, BinaryIntCodec)
	
	/**
	 * In-Game: "N% health from healers on wearer"
	 *
	 * 
	 *
	 * Attribute class is a flat multiplier applied to health from healers while weapon is active.
	 */
	context(attrs: IKeyValueMap)
	var multHealthFromhealersPenaltyActive: Number?
		get() = attrs.getTyped("mult_health_fromhealers_penalty_active")
		set(value) = attrs.setNullable("mult_health_fromhealers_penalty_active", value)
	
	/**
	 * In-Game: "N% Overheal build rate."
	 *
	 * 
	 *
	 * Checked on the player that is healing an entity.
	 */
	context(attrs: IKeyValueMap)
	var overhealFillRateReduced: Number?
		get() = attrs.getTyped("overheal fill rate reduced")
		set(value) = attrs.setNullable("overheal fill rate reduced", value)
	
	/**
	 * In-Game: "N% less healing from Medic sources"
	 *
	 * 
	 *
	 * Specifically checked on Crossbow Bolt impacts.
	 *
	 * Applies to all non-dispenser forms of healing that apply the TF_COND_HEAL_BUFF status.
	 */
	context(attrs: IKeyValueMap)
	override var reducedHealingFromMedics: Number?
		get() = super.reducedHealingFromMedics
		set(value) { super.reducedHealingFromMedics = value }
	
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
	val weaponBurnDmgReduced get() = BonusPenalty<Number, Number>("weapon burn dmg increased", "weapon burn dmg reduced")
	
	/**
	 * In-Game: "Halloween Fire"
	 *
	 * 
	 *
	 * Makes afterburn green.
	 */
	context(attrs: IKeyValueMap)
	var spellHalloweenGreenFlames: Boolean?
		get() = attrs.getTyped("SPELL: Halloween green flames", BinaryIntCodec)
		set(value) = attrs.setNullable("SPELL: Halloween green flames", value, BinaryIntCodec)
	
	/**
	 * In-Game: "Syringes deliver a highly concentrated dose of Mad Milk. Duration increases per hit to a max of 4 seconds."
	 *
	 * 
	 *
	 * Duration of 4 seconds, and increases by 0.5 seconds each hit.
	 */
	context(attrs: IKeyValueMap)
	var madMilkSyringes: Boolean?
		get() = attrs.getTyped("mad milk syringes", BinaryIntCodec)
		set(value) = attrs.setNullable("mad milk syringes", value, BinaryIntCodec)
	
	/**
	 * In-Game: "Alt-Fire: Applies a healing effect to all nearby teammates"
	 *
	 * 
	 *
	 * Makes default weapon taunt perform the Amputator radial healing effect.
	 */
	context(attrs: IKeyValueMap)
	var enablesAoeHeal: Boolean?
		get() = attrs.getTyped("enables aoe heal", BinaryIntCodec)
		set(value) = attrs.setNullable("enables aoe heal", value, BinaryIntCodec)
	
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
	val weaponBurnTimeReduced get() = BonusPenalty<Number, Number>("weapon burn time increased", "weapon burn time reduced")
	
	/**
	 * In-Game: "Fires tracer rounds"
	 *
	 * 
	 *
	 * Note: Sniper rage forcibly draws a tracer regardless of this setting.
	 *
	 * Used when firing bullets.
	 */
	context(attrs: IKeyValueMap)
	var sniperFiresTracer: Boolean?
		get() = attrs.getTyped("sniper fires tracer", BinaryIntCodec)
		set(value) = attrs.setNullable("sniper fires tracer", value, BinaryIntCodec)
	
	/**
	 * In-Game: "Fires tracer rounds"
	 *
	 * 
	 *
	 * Same as `sniper_fires_tracer`.
	 */
	context(attrs: IKeyValueMap)
	var sniperFiresTracerHidden: Boolean?
		get() = attrs.getTyped("sniper fires tracer HIDDEN", BinaryIntCodec)
		set(value) = attrs.setNullable("sniper fires tracer HIDDEN", value, BinaryIntCodec)
	
	/**
	 * In-Game: "N% increased damage to your sentry's target"
	 *
	 * 
	 */
	context(attrs: IKeyValueMap)
	var damageBonusBulletVsSentryTarget: Number?
		get() = attrs.getTyped("damage bonus bullet vs sentry target")
		set(value) = attrs.setNullable("damage bonus bullet vs sentry target", value)
	
	/**
	 * In-Game: "On Full Charge: Projectiles penetrate players"
	 *
	 * 
	 */
	context(attrs: IKeyValueMap)
	var penetratesWhenFullyCharged: Boolean?
		get() = attrs.getTyped("sniper penetrate players when charged", BinaryIntCodec)
		set(value) = attrs.setNullable("sniper penetrate players when charged", value, BinaryIntCodec)
	
	/**
	 * 
	 *
	 * Multiplier applied to movement speed scaled by ubercharge percentage.
	 *
	 * Only works if the player using this item is a Medic with a Medigun.
	 */
	context(attrs: IKeyValueMap)
	var moveSpeedBonusResourceLevel: Number?
		get() = attrs.getTyped("move speed bonus resource level")
		set(value) = attrs.setNullable("move speed bonus resource level", value)
	
	/**
	 * In-Game: "+N% faster move speed on wearer"
	 *
	 * 
	 *
	 * Multiplier applied to player movement speed only while this is the active weapon.
	 */
	context(attrs: IKeyValueMap)
	var multPlayerMovespeedActive: Number?
		get() = attrs.getTyped("mult_player_movespeed_active")
		set(value) = attrs.setNullable("mult_player_movespeed_active", value)
	
	/**
	 * 
	 *
	 * If greater than 0 (like with the Thermal Thruster), takes that amount of time to holster BEFORE actually swapping weapons.
	 */
	context(attrs: IKeyValueMap)
	var holsterAnimTime: Int?
		get() = attrs.getTyped("holster_anim_time")
		set(value) = attrs.setNullable("holster_anim_time", value)
	
	/**
	 * In-Game: "Alt-Fire: Use N metal to pick up your targeted building from long range"
	 *
	 * 
	 *
	 * Metal cost to pick up a building at range.
	 *
	 * Restricted to the default rescue ranger range, but can be used by any weapon.
	 */
	context(attrs: IKeyValueMap)
	var engineerBuildingTeleportingPickup: Int?
		get() = attrs.getTyped("engineer building teleporting pickup")
		set(value) = attrs.setNullable("engineer building teleporting pickup", value)
	
	/**
	 * In-Game: "N% damage on body shot"
	 *
	 * 
	 *
	 * Multiplier applied to bodyshot damage.
	 */
	context(attrs: IKeyValueMap)
	var damagePenaltyOnBodyshot: Number?
		get() = attrs.getTyped("damage penalty on bodyshot")
		set(value) = attrs.setNullable("damage penalty on bodyshot", value)
	
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
	val healingReceived get() = BonusPenalty<Number, Number>("healing received bonus", "healing received penalty")
	
	/**
	 * In-Game: "Stuns enemies who are also wielding this weapon"
	 *
	 * 
	 */
	context(attrs: IKeyValueMap)
	var stunEnemiesWieldingSameWeapon: Boolean?
		get() = attrs.getTyped("stun enemies wielding same weapon", BinaryIntCodec)
		set(value) = attrs.setNullable("stun enemies wielding same weapon", value, BinaryIntCodec)
	
	/**
	 * In-Game: "All players connected via Medigun beams are hit"
	 *
	 * 
	 *
	 * Damage all players connected to the target by medigun beams.
	 */
	context(attrs: IKeyValueMap)
	var damageAllConnected: Boolean?
		get() = attrs.getTyped("damage all connected", BinaryIntCodec)
		set(value) = attrs.setNullable("damage all connected", value, BinaryIntCodec)
	
	/**
	 * 
	 *
	 * Apply this amount of z velocity to players hit with this weapon.
	 */
	context(attrs: IKeyValueMap)
	var applyZVelocityOnDamage: Int?
		get() = attrs.getTyped("apply z velocity on damage")
		set(value) = attrs.setNullable("apply z velocity on damage", value)
	
	/**
	 * 
	 *
	 * Apply this amount of velocity in the direction you're facing to players hit with this weapon.
	 */
	context(attrs: IKeyValueMap)
	var applyLookVelocityOnDamage: Int?
		get() = attrs.getTyped("apply look velocity on damage")
		set(value) = attrs.setNullable("apply look velocity on damage", value)
	
	/**
	 * In-Game: "Ignited enemies explode"
	 *
	 * 
	 *
	 * Applies when *any weapon* with this attribute is in the second loadout slot of the player who covered someone in gas.  This attribute does not specifically check for the Gas Passer.  For example, f a Soldier has a rocket launcher that applies `TF_COND_GAS` and their shotgun in their secondary has this attribute, they'll still explode on ignite.
	 *
	 * Only the afterburn specifically checks for the Gas Passer.
	 */
	context(attrs: IKeyValueMap)
	var explodeOnIgnite: Boolean?
		get() = attrs.getTyped("explode_on_ignite", BinaryIntCodec)
		set(value) = attrs.setNullable("explode_on_ignite", value, BinaryIntCodec)
	
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
	val selfDmgPushForce get() = BonusPenalty<Number, Number>("self dmg push force increased", "self dmg push force decreased")
	
	/**
	 * 
	 *
	 * Knocks back attacker when wielder receives damage.
	 */
	context(attrs: IKeyValueMap)
	var damageCausesAirblast: Boolean?
		get() = attrs.getTyped("damage causes airblast", BinaryIntCodec)
		set(value) = attrs.setNullable("damage causes airblast", value, BinaryIntCodec)
	
	/**
	 * 
	 *
	 * Push force applied to target when hitting an enemy.
	 *
	 * Scales by range, to a minimum of 50% of the given value.
	 */
	context(attrs: IKeyValueMap)
	var damageBlastPush: Number?
		get() = attrs.getTyped("damage blast push")
		set(value) = attrs.setNullable("damage blast push", value)
	
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
	val damageForce get() = BonusPenalty_PenaltyNested<Number, VisHidden<Number, Number>>("damage force reduction", VisHidden<Number, Number>("damage force increase", "damage force increase hidden"))
	
	/**
	 * In-Game: "On Hit: Bleed for N seconds"
	 *
	 * 
	 *
	 * Apply bleed on hit.
	 *
	 * Value is a time in seconds.
	 */
	context(attrs: IKeyValueMap)
	var bleedingDuration: Int?
		get() = attrs.getTyped("bleeding duration")
		set(value) = attrs.setNullable("bleeding duration", value)
	
	/**
	 * In-Game: "The wearer cannot be killed by headshots"
	 *
	 * 
	 *
	 * When a headshot would kill you, reduce health to 1.
	 */
	context(attrs: IKeyValueMap)
	var setBonusNoDeathFromHeadshots: Boolean?
		get() = attrs.getTyped("SET BONUS: no death from headshots", BinaryIntCodec)
		set(value) = attrs.setNullable("SET BONUS: no death from headshots", value, BinaryIntCodec)
	
	/**
	 * In-Game: "Increased headshot explosion radius and damage to nearby enemies"
	 *
	 * 
	 *
	 * Only applies if in a gamemode with upgrades, but applies to all headshots.
	 *
	 * Also applies to any hitscan weapon with a `jarate_time` attribute that hit the head.
	 */
	context(attrs: IKeyValueMap)
	var explosiveHeadshotLevel: Int?
		get() = attrs.getTyped("explosive sniper shot")
		set(value) = attrs.setNullable("explosive sniper shot", value)
	
	/**
	 * In-Game: "Killing an enemy with a critical hit will dismember your victim. Painfully."
	 *
	 * 
	 */
	context(attrs: IKeyValueMap)
	var critKillWillGib: Boolean?
		get() = attrs.getTyped("crit kill will gib", BinaryIntCodec)
		set(value) = attrs.setNullable("crit kill will gib", value, BinaryIntCodec)
	
	/**
	 * 
	 *
	 * If false, this weapon can only gib if it deals blast damage or half-falloff damage.
	 */
	context(attrs: IKeyValueMap)
	var critOnHardHit: Boolean?
		get() = attrs.getTyped("crit on hard hit", BinaryIntCodec)
		set(value) = attrs.setNullable("crit on hard hit", value, BinaryIntCodec)
	
	/**
	 * In-Game: "On Kill: N seconds of 100% critical chance"
	 *
	 * 
	 *
	 * Seconds of crit-boost gained on kill.
	 *
	 * Note: actual time is `this + 1`.
	 */
	context(attrs: IKeyValueMap)
	var critboostOnKill: Int?
		get() = attrs.getTyped("critboost on kill")
		set(value) = attrs.setNullable("critboost on kill", value)
	
	/**
	 * In-Game: "On Kill: Gain Mini-crits for N seconds."
	 *
	 * 
	 *
	 * Seconds of minicrit-boost gained on kill.
	 *
	 * Note: actual time is `this + 1`.
	 */
	context(attrs: IKeyValueMap)
	var minicritboostOnKill: Int?
		get() = attrs.getTyped("minicritboost on kill")
		set(value) = attrs.setNullable("minicritboost on kill", value)
	
	/**
	 * In-Game: "Exorcism"
	 *
	 * 
	 *
	 * Exorcism spell effect.
	 */
	context(attrs: IKeyValueMap)
	var spellHalloweenDeathGhosts: Boolean?
		get() = attrs.getTyped("SPELL: Halloween death ghosts", BinaryIntCodec)
		set(value) = attrs.setNullable("SPELL: Halloween death ghosts", value, BinaryIntCodec)
	
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
	context(attrs: IKeyValueMap)
	var restoreHealthOnKill: Int?
		get() = attrs.getTyped("restore health on kill")
		set(value) = attrs.setNullable("restore health on kill", value)
	
	/**
	 * In-Game: "+N health restored on kill"
	 *
	 * 
	 *
	 * Restores this flat amount of health on killing an enemy. Post-heal player health value is capped at the player's maximum overheal.
	 *
	 * Negative values are NOT ignored.
	 */
	context(attrs: IKeyValueMap)
	var healOnKill: Int?
		get() = attrs.getTyped("heal on kill")
		set(value) = attrs.setNullable("heal on kill", value)
	
	/**
	 * In-Game: "Gain a speed boost on kill"
	 *
	 * 
	 */
	context(attrs: IKeyValueMap)
	var speedBoostOnKill: Int?
		get() = attrs.getTyped("speed_boost_on_kill")
		set(value) = attrs.setNullable("speed_boost_on_kill", value)
	
	/**
	 * In-Game: "Maximum health is drained while item is active"
	 *
	 * 
	 *
	 * Maximum health decrease per tick while weapon is active. (Gloves of Running Urgently).
	 */
	context(attrs: IKeyValueMap)
	var maxhealthDrainRate: Int?
		get() = attrs.getTyped("mod_maxhealth_drain_rate")
		set(value) = attrs.setNullable("mod_maxhealth_drain_rate", value)
	
	/**
	 * 
	 *
	 * If true, prevents holiday taunts from being used.
	 */
	context(attrs: IKeyValueMap)
	var specialTaunt: Boolean?
		get() = attrs.getTyped("special taunt", BinaryIntCodec)
		set(value) = attrs.setNullable("special taunt", value, BinaryIntCodec)
	
	/**
	 * 
	 */
	val ragdolls get() = RagdollsAttributes
}


object OnHitAttributes {
	inline operator fun invoke(scope: OnHitAttributes.() -> Unit) {
		this.apply(scope)
	}
	/**
	 * In-Game: "On Hit: damage dealt is returned as ammo"
	 */
	context(attrs: IKeyValueMap)
	var addOnhitAddammo: Boolean?
		get() = attrs.getTyped("add onhit addammo", BinaryIntCodec)
		set(value) = attrs.setNullable("add onhit addammo", value, BinaryIntCodec)
	
	/**
	 * In-Game: "On Hit Spy: Reveal cloaked Spy"
	 */
	context(attrs: IKeyValueMap)
	var revealCloakedVictimOnHit: Boolean?
		get() = attrs.getTyped("reveal cloaked victim on hit", BinaryIntCodec)
		set(value) = attrs.setNullable("reveal cloaked victim on hit", value, BinaryIntCodec)
	
	/**
	 * In-Game: "On Hit Spy: Reveal disguised Spy"
	 */
	context(attrs: IKeyValueMap)
	var revealDisguisedVictimOnHit: Boolean?
		get() = attrs.getTyped("reveal disguised victim on hit", BinaryIntCodec)
		set(value) = attrs.setNullable("reveal disguised victim on hit", value, BinaryIntCodec)
	
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
	val selfdmgOnHitForRapidfire get() = BonusPenalty<Int, Int>("heal on hit for rapidfire", "selfdmg on hit for rapidfire")
	
	/**
	 * In-Game: "Melee hits refill  N% of your charge meter."
	 */
	context(attrs: IKeyValueMap)
	var chargeMeterOnHit: Number?
		get() = attrs.getTyped("charge meter on hit")
		set(value) = attrs.setNullable("charge meter on hit", value)
	
	/**
	 * In-Game: "On Hit: Gain a speed boost"
	 */
	context(attrs: IKeyValueMap)
	var speedBoostOnHit: Int?
		get() = attrs.getTyped("speed_boost_on_hit")
		set(value) = attrs.setNullable("speed_boost_on_hit", value)
	
	/**
	 * In-Game: "On Hit: N% ÜberCharge added"
	 */
	context(attrs: IKeyValueMap)
	var addUberChargeOnHit: Number?
		get() = attrs.getTyped("add uber charge on hit")
		set(value) = attrs.setNullable("add uber charge on hit", value)
	
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
	val rageOnHit get() = BonusPenalty<Int, Int>("mod rage on hit bonus", "mod rage on hit penalty")
	
	/**
	 * In-Game: "On Hit: Builds Boost Run speed increased with Boost"
	 */
	context(attrs: IKeyValueMap)
	var boostOnDamage: Boolean?
		get() = attrs.getTyped("boost on damage", BinaryIntCodec)
		set(value) = attrs.setNullable("boost on damage", value, BinaryIntCodec)
	
	/**
	 * In-Game: "Generate Rage by dealing damage.  When fully charged, press the Special-Attack key to activate knockback"
	 */
	context(attrs: IKeyValueMap)
	var generateRageOnDamage: Boolean?
		get() = attrs.getTyped("generate rage on damage", BinaryIntCodec)
		set(value) = attrs.setNullable("generate rage on damage", value, BinaryIntCodec)
	
	/**
	 * In-Game: "Generate building rescue energy on damage"
	 */
	context(attrs: IKeyValueMap)
	var engineerRageOnDmg: Boolean?
		get() = attrs.getTyped("engineer rage on dmg", BinaryIntCodec)
		set(value) = attrs.setNullable("engineer rage on dmg", value, BinaryIntCodec)
	
	/**
	 * In-Game: "On Hit: N% chance to slow target"
	 */
	context(attrs: IKeyValueMap)
	var slowEnemyOnHit: Number?
		get() = attrs.getTyped("slow enemy on hit")
		set(value) = attrs.setNullable("slow enemy on hit", value)
	
	/**
	 * In-Game: "On Hit: Slow target movement by 40% for Ns"
	 */
	context(attrs: IKeyValueMap)
	var slowEnemyOnHitMajor: Int?
		get() = attrs.getTyped("slow enemy on hit major")
		set(value) = attrs.setNullable("slow enemy on hit major", value)
	
	/**
	 * In-Game: "On Hit: One target at a time is Marked-For-Death, causing all damage taken to be mini-crits"
	 */
	context(attrs: IKeyValueMap)
	var markForDeath: Boolean?
		get() = attrs.getTyped("mark for death", BinaryIntCodec)
		set(value) = attrs.setNullable("mark for death", value, BinaryIntCodec)
	
	/**
	 * In-Game: "On Hit: If enemy's belt is at or above eye level, stun them for N seconds"
	 */
	context(attrs: IKeyValueMap)
	var stunWaistHighAirborne: Boolean?
		get() = attrs.getTyped("mod stun waist high airborne", BinaryIntCodec)
		set(value) = attrs.setNullable("mod stun waist high airborne", value, BinaryIntCodec)
	
	/**
	 * In-Game: "On Hit: Victim loses up to N% Medigun charge"
	 */
	context(attrs: IKeyValueMap)
	var subtractVictimMedigunChargeOnHit: Int?
		get() = attrs.getTyped("subtract victim medigun charge on hit")
		set(value) = attrs.setNullable("subtract victim medigun charge on hit", value)
	
	/**
	 * In-Game: "On Hit: Victim loses up to N% cloak"
	 */
	context(attrs: IKeyValueMap)
	var subtractVictimCloakOnHit: Int?
		get() = attrs.getTyped("subtract victim cloak on hit")
		set(value) = attrs.setNullable("subtract victim cloak on hit", value)
}


object RagdollsAttributes {
	inline operator fun invoke(scope: RagdollsAttributes.() -> Unit) {
		this.apply(scope)
	}
	/**
	 * In-Game: "Backstab turns victim to ice"
	 */
	context(attrs: IKeyValueMap)
	var freezeBackstabVictim: Boolean?
		get() = attrs.getTyped("freeze backstab victim", BinaryIntCodec)
		set(value) = attrs.setNullable("freeze backstab victim", value, BinaryIntCodec)
	
	/**
	 * In-Game: "Imbued with an ancient power"
	 */
	context(attrs: IKeyValueMap)
	var turnToGold: Boolean?
		get() = attrs.getTyped("turn to gold", BinaryIntCodec)
		set(value) = attrs.setNullable("turn to gold", value, BinaryIntCodec)
	
	
	context(attrs: IKeyValueMap)
	var ragdollsBecomeAsh: Boolean?
		get() = attrs.getTyped("ragdolls become ash", BinaryIntCodec)
		set(value) = attrs.setNullable("ragdolls become ash", value, BinaryIntCodec)
	
	
	context(attrs: IKeyValueMap)
	var ragdollsPlasmaEffect: Boolean?
		get() = attrs.getTyped("ragdolls plasma effect", BinaryIntCodec)
		set(value) = attrs.setNullable("ragdolls plasma effect", value, BinaryIntCodec)
	
	
	context(attrs: IKeyValueMap)
	var critOnHardHit: Boolean?
		get() = attrs.getTyped("crit on hard hit", BinaryIntCodec)
		set(value) = attrs.setNullable("crit on hard hit", value, BinaryIntCodec)
}

