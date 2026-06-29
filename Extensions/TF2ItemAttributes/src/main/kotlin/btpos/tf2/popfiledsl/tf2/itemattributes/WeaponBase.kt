package btpos.tf2.popfiledsl.tf2.itemattributes

import btpos.tf2.popfiledsl.modeling.*
import btpos.tf2.popfiledsl.serialization.codecs.*


/**
 * 
 */
interface WeaponBaseAttributes : BaseCombatWeaponAttributes {
	companion object : WeaponBaseAttributes
	
	/**
	 * If true, and player has a demoman charge meter, add charge based on ammo pack size
	 * 
	 */
	context(attrs: IKeyValueMap)
	var ammoGivesCharge: Boolean?
		get() = attrs.getTyped("ammo gives charge", BinaryIntCodec)
		set(value) = attrs.setNullable("ammo gives charge", value, BinaryIntCodec)
	
	
	context(attrs: IKeyValueMap)
	var noPrimaryAmmoFromDispensersWhileActive: Boolean?
		get() = attrs.getTyped("no primary ammo from dispensers while active", BinaryIntCodec)
		set(value) = attrs.setNullable("no primary ammo from dispensers while active", value, BinaryIntCodec)
	
	
	context(attrs: IKeyValueMap)
	var noMetalFromDispensersWhileActive: Boolean?
		get() = attrs.getTyped("no metal from dispensers while active", BinaryIntCodec)
		set(value) = attrs.setNullable("no metal from dispensers while active", value, BinaryIntCodec)
	
	/**
	 * 
	 * Bonus:
	 * 	- Value type: percentage
	 * 	- +N% damage vs buildings
	 * 
	 * Penalty:
	 * 	- Value type: percentage
	 * 	- N% damage penalty vs buildings
	 */
	val dmgVsBuildings get() = BonusPenalty<Float, Float>("dmg bonus vs buildings", "dmg penalty vs buildings")
	
	/**
	 * 
	 * Bonus:
	 * 	- Value type: percentage
	 * 	- +N% clip size
	 * 
	 * Penalty:
	 * 	- Visible:
	 * 	- 	- Value type: percentage
	 * 	- 	- N% clip size
	 * 	- Hidden:
	 * 	- 	- Value type: percentage
	 * 	- 	- N% clip size
	 */
	val clipSize get() = BonusPenalty_PenaltyNested<Float, VisHidden<Float, Float>>("clip size bonus", VisHidden<Float, Float>("clip size penalty", "clip size penalty HIDDEN"))
	
	/**
	 * Value type: percentage
	 * 
	 */
	context(attrs: IKeyValueMap)
	var clipSizeBonusUpgrade: Float?
		get() = attrs.getTyped("clip size bonus upgrade")
		set(value) = attrs.setNullable("clip size bonus upgrade", value)
	
	/**
	 * MVM attribute that specifically handles rocket and grenade launchers
	 * 
	 * Note that all three of these are different classes, which means they stack.
	 * 
	 */
	context(attrs: IKeyValueMap)
	var clipSizeUpgradeAtomic: Int?
		get() = attrs.getTyped("clip size upgrade atomic")
		set(value) = attrs.setNullable("clip size upgrade atomic", value)
	
	
	context(attrs: IKeyValueMap)
	var clipsizeIncreaseOnKill: Int?
		get() = attrs.getTyped("clipsize increase on kill")
		set(value) = attrs.setNullable("clipsize increase on kill", value)
	
	/**
	 * Determines the hand used in the model
	 * 
	 */
	context(attrs: IKeyValueMap)
	var modWrenchBuildsMinisentry: Int?
		get() = attrs.getTyped("mod wrench builds minisentry")
		set(value) = attrs.setNullable("mod wrench builds minisentry", value)
	
	/**
	 * Checked on player
	 * 
	 * 
	 * Bonus:
	 * 	- Value type: inverted_percentage
	 * 	- N% faster weapon switch
	 * 
	 * Penalty:
	 * 	- Value type: percentage
	 * 	- N% longer weapon switch
	 */
	val deployTime get() = BonusPenalty<Float, Float>("deploy time decreased", "deploy time increased")
	
	/**
	 * 
	 * Bonus:
	 * 	- Value type: inverted_percentage
	 * 	- This weapon deploys N% faster
	 * 
	 * Penalty:
	 * 	- Value type: inverted_percentage
	 * 	- This weapon deploys N% slower
	 */
	val singleWepDeployTime get() = BonusPenalty<Float, Float>("single wep deploy time decreased", "single wep deploy time increased")
	
	/**
	 * 
	 * Bonus:
	 * 	- Value type: inverted_percentage
	 * 	- This weapon holsters N% faster
	 * 
	 * Penalty:
	 * 	- Value type: percentage
	 * 	- This weapon holsters N% slower
	 */
	val singleWepHolsterTime get() = BonusPenalty<Float, Float>("switch from wep deploy time decreased", "single wep holster time increased")
	
	/**
	 * If true, make weapon deploy and holster 75% slower
	 * 
	 */
	context(attrs: IKeyValueMap)
	var isASword: Boolean?
		get() = attrs.getTyped("is_a_sword", BinaryIntCodec)
		set(value) = attrs.setNullable("is_a_sword", value, BinaryIntCodec)
	
	/**
	 * Value type: percentage
	 * 
	 * On player
	 * 
	 * Multiplier applied if NOT being healed by a medic
	 * 
	 */
	context(attrs: IKeyValueMap)
	var modMedicHealedDeployTimePenalty: Float?
		get() = attrs.getTyped("mod medic healed deploy time penalty")
		set(value) = attrs.setNullable("mod medic healed deploy time penalty", value)
	
	/**
	 * Should force switch to this item
	 * 
	 */
	context(attrs: IKeyValueMap)
	var forceWeaponSwitch: Boolean?
		get() = attrs.getTyped("force weapon switch", BinaryIntCodec)
		set(value) = attrs.setNullable("force weapon switch", value, BinaryIntCodec)
	
	/**
	 * If true, only applies attributes when weapon is active, and unapplies them when switching off.
	 * 
	 * This also means you can't have "only active when holding weapon" and "always active" attributes on the same weapon (excluding the specific attributes that are _always_ "only when active"), since the order you specify attributes in doesn't matter.
	 * 
	 */
	context(attrs: IKeyValueMap)
	var provideOnActive: Boolean?
		get() = attrs.getTyped("provide on active", BinaryIntCodec)
		set(value) = attrs.setNullable("provide on active", value, BinaryIntCodec)
	
	/**
	 * How many players your "projectile" (*including bullets*) should penetrate.
	 * 
	 */
	context(attrs: IKeyValueMap)
	var projectilePenetration: Int?
		get() = attrs.getTyped("projectile penetration")
		set(value) = attrs.setNullable("projectile penetration", value)
	
	/**
	 * How many players your "projectile" (*including bullets*) should penetrate.
	 * 
	 */
	context(attrs: IKeyValueMap)
	var projectilePenetrationHeavy: Int?
		get() = attrs.getTyped("projectile penetration heavy")
		set(value) = attrs.setNullable("projectile penetration heavy", value)
	
	/**
	 * Value type: percentage
	 * 
	 */
	context(attrs: IKeyValueMap)
	var bulletsPerShotBonus: Float?
		get() = attrs.getTyped("bullets per shot bonus")
		set(value) = attrs.setNullable("bullets per shot bonus", value)
	
	/**
	 * 
	 * Bonus:
	 * 	- Visible:
	 * 		- Value type: percentage
	 * 		- +N% damage bonus
	 * 	- Hidden:
	 * 		- Value type: percentage
	 * 		- +N% damage bonus
	 * 
	 * Penalty:
	 * 	- Value type: percentage
	 * 	- N% damage penalty
	 */
	val damage get() = BonusPenalty_BonusNested<VisHidden<Float, Float>, Float>(VisHidden<Float, Float>("damage bonus", "damage bonus HIDDEN"), "damage penalty")
	
	/**
	 * Value type: percentage
	 * 
	 * "No random crits" sets this to `0.0`
	 * 
	 */
	context(attrs: IKeyValueMap)
	var critModDisabled: Float?
		get() = attrs.getTyped("crit mod disabled")
		set(value) = attrs.setNullable("crit mod disabled", value)
	
	/**
	 * Value type: percentage
	 * 
	 * "No random crits" sets this to `0.0`
	 * 
	 */
	context(attrs: IKeyValueMap)
	var critModDisabledHidden: Float?
		get() = attrs.getTyped("crit mod disabled hidden")
		set(value) = attrs.setNullable("crit mod disabled hidden", value)
	
	/**
	 * 
	 * Bonus:
	 * 	- Hold Fire to load up to three rockets Release Fire to unleash the barrage
	 * 
	 * Penalty:
	 * 	- Attrib_AutoFiresFullClipNegative}}
	 */
	val autoFiresFullClip get() = BonusPenalty<Boolean, Boolean>("auto fires full clip", "auto fires full clip penalty")
	
	
	context(attrs: IKeyValueMap)
	var autoFiresFullClipAllAtOnce: Boolean?
		get() = attrs.getTyped("auto fires full clip all at once", BinaryIntCodec)
		set(value) = attrs.setNullable("auto fires full clip all at once", value, BinaryIntCodec)
	
	/**
	 * Deals damage to the player when overloaded.
	 * 
	 */
	context(attrs: IKeyValueMap)
	var canOverload: Boolean?
		get() = attrs.getTyped("can overload", BinaryIntCodec)
		set(value) = attrs.setNullable("can overload", value, BinaryIntCodec)
	
	/**
	 * After firing, you wait a bit before you can fire again. That's the "delay".
	 * 
	 * 
	 * Bonus:
	 * 	- Visible:
	 * 		- Value type: inverted_percentage
	 * 		- +N% faster firing speed
	 * 	- Hidden:
	 * 		- Value type: inverted_percentage
	 * 		- +N% faster firing speed
	 * 
	 * Penalty:
	 * 	- Visible:
	 * 	- 	- Value type: inverted_percentage
	 * 	- 	- N% slower firing speed
	 * 	- Hidden:
	 * 	- 	- Value type: inverted_percentage
	 */
	val fireRate get() = BonusPenalty_BothNested<VisHidden<Float, Float>, VisHidden<Float, Float>>(VisHidden<Float, Float>("fire rate bonus", "fire rate bonus HIDDEN"), VisHidden<Float, Float>("fire rate penalty", "fire rate penalty HIDDEN"))
	
	
	context(attrs: IKeyValueMap)
	var autoFiresWhenFull: Boolean?
		get() = attrs.getTyped("auto fires when full", BinaryIntCodec)
		set(value) = attrs.setNullable("auto fires when full", value, BinaryIntCodec)
	
	/**
	 * 
	 * Bonus:
	 * 	- Value type: inverted_percentage
	 * 	- N% faster reload time
	 * 
	 * Penalty:
	 * 	- Value type: percentage
	 * 	- N% slower reload time
	 */
	val reloadTime get() = BonusPenalty<Float, Float>("Reload time decreased", "Reload time increased")
	
	/**
	 * Value type: percentage
	 * 
	 */
	context(attrs: IKeyValueMap)
	var reloadTimeIncreasedHidden: Float?
		get() = attrs.getTyped("reload time increased hidden")
		set(value) = attrs.setNullable("reload time increased hidden", value)
	
	/**
	 * Value type: inverted_percentage
	 * 
	 * This is what's used for weapons that draw directly from reserve ammo, like the flare gun and sniper rifle.
	 * 
	 */
	context(attrs: IKeyValueMap)
	var fasterReloadRate: Float?
		get() = attrs.getTyped("faster reload rate")
		set(value) = attrs.setNullable("faster reload rate", value)
	
	/**
	 * Value type: inverted_percentage
	 * 
	 * On player
	 * 
	 * Halloween reload time multiplier.
	 * 
	 */
	context(attrs: IKeyValueMap)
	var halloweenReloadTimeDecreased: Float?
		get() = attrs.getTyped("halloween reload time decreased")
		set(value) = attrs.setNullable("halloween reload time decreased", value)
	
	/**
	 * Value type: inverted_percentage
	 * 
	 */
	context(attrs: IKeyValueMap)
	var reloadTimeDecreasedWhileHealed: Float?
		get() = attrs.getTyped("reload time decreased while healed")
		set(value) = attrs.setNullable("reload time decreased while healed", value)
	
	
	context(attrs: IKeyValueMap)
	var weaponAllowInspect: Boolean?
		get() = attrs.getTyped("weapon_allow_inspect", BinaryIntCodec)
		set(value) = attrs.setNullable("weapon_allow_inspect", value, BinaryIntCodec)
}

inline operator fun WeaponBaseAttributes.invoke(scope: WeaponBaseAttributes.() -> Unit) {
	this.apply(scope)
}

