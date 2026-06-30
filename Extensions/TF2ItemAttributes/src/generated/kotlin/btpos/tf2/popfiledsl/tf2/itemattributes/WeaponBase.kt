package btpos.tf2.popfiledsl.tf2.itemattributes

import btpos.tf2.popfiledsl.modeling.*
import btpos.tf2.popfiledsl.serialization.codecs.*



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
	val dmgVsBuildings get() = BonusPenalty<Float, Float>("dmg bonus vs buildings", "dmg penalty vs buildings")
	
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
	val clipSize get() = BonusPenalty_PenaltyNested<Float, VisHidden<Float, Float>>("clip size bonus", VisHidden<Float, Float>("clip size penalty", "clip size penalty HIDDEN"))
	
	/**
	 * In-Game: "+N% clip size"
	 *
	 * 
	 *
	 * Stacks with [clipSize].
	 */
	context(attrs: IKeyValueMap)
	var clipSizeBonusUpgrade: Float?
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
	val deployTime get() = BonusPenalty<Float, Float>("deploy time decreased", "deploy time increased")
	
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
	val singleWepDeployTime get() = BonusPenalty<Float, Float>("single wep deploy time decreased", "single wep deploy time increased")
	
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
	val singleWepHolsterTime get() = BonusPenalty<Float, Float>("switch from wep deploy time decreased", "single wep holster time increased")
	
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
	var medicHealedDeployTimePenalty: Float?
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
	var bulletsPerShotBonus: Float?
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
	val damage get() = BonusPenalty_BonusNested<VisHidden<Float, Float>, Float>(VisHidden<Float, Float>("damage bonus", "damage bonus HIDDEN"), "damage penalty")
	
	/**
	 * In-Game: "No random critical hits"
	 *
	 * 
	 *
	 * "No random crits" sets this to `0.0`.
	 */
	context(attrs: IKeyValueMap)
	var critModDisabled: Float?
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
	var critModDisabledHidden: Float?
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
	val fireRate get() = BonusPenalty_BothNested<VisHidden<Float, Float>, VisHidden<Float, Float>>(VisHidden<Float, Float>("fire rate bonus", "fire rate bonus HIDDEN"), VisHidden<Float, Float>("fire rate penalty", "fire rate penalty HIDDEN"))
	
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
	val reloadTime get() = BonusPenalty<Float, Float>("Reload time decreased", "Reload time increased")
	
	/**
	 * In-Game: "N% slower reload time"
	 *
	 * 
	 */
	context(attrs: IKeyValueMap)
	var reloadTimeIncreasedHidden: Float?
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
	var fasterReloadRate: Float?
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
	var halloweenReloadTimeDecreased: Float?
		get() = attrs.getTyped("halloween reload time decreased")
		set(value) = attrs.setNullable("halloween reload time decreased", value)
	
	/**
	 * In-Game: "N% faster reload time while being healed"
	 *
	 * 
	 */
	context(attrs: IKeyValueMap)
	var reloadTimeDecreasedWhileHealed: Float?
		get() = attrs.getTyped("reload time decreased while healed")
		set(value) = attrs.setNullable("reload time decreased while healed", value)
	
	/**
	 * 
	 */
	context(attrs: IKeyValueMap)
	var weaponAllowInspect: Boolean?
		get() = attrs.getTyped("weapon_allow_inspect", BinaryIntCodec)
		set(value) = attrs.setNullable("weapon_allow_inspect", value, BinaryIntCodec)
}

