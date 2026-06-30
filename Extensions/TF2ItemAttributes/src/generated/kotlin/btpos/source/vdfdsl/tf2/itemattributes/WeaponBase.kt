package btpos.source.vdfdsl.tf2.itemattributes

import btpos.source.vdfdsl.modeling.*
import btpos.source.vdfdsl.serialization.codecs.*



interface WeaponBaseAttributes : btpos.source.vdfdsl.tf2.itemattributes.BaseCombatWeaponAttributes, btpos.source.vdfdsl.tf2.itemattributes.IBlockScoped {
	companion object : WeaponBaseAttributes
	
	/**
	 * In-Game: "Ammo boxes collected also give Charge"
	 *
	 * 
	 *
	 * If true, and player has a demoman charge meter, add charge based on ammo pack size.
	 */
	context(attrs: btpos.source.vdfdsl.modeling.IKeyValueMap)
	var ammoPacksGiveDemoknightCharge: Boolean?
		get() = attrs.getTyped("ammo gives charge", _root_ide_package_.btpos.source.vdfdsl.serialization.codecs.BinaryIntCodec)
		set(value) = attrs.setNullable("ammo gives charge", value, _root_ide_package_.btpos.source.vdfdsl.serialization.codecs.BinaryIntCodec)
	
	/**
	 * In-Game: "No ammo from dispensers when active"
	 *
	 * 
	 */
	context(attrs: btpos.source.vdfdsl.modeling.IKeyValueMap)
	var noPrimaryAmmoFromDispensersWhileActive: Boolean?
		get() = attrs.getTyped("no primary ammo from dispensers while active", _root_ide_package_.btpos.source.vdfdsl.serialization.codecs.BinaryIntCodec)
		set(value) = attrs.setNullable("no primary ammo from dispensers while active", value, _root_ide_package_.btpos.source.vdfdsl.serialization.codecs.BinaryIntCodec)
	
	/**
	 * In-Game: "No metal from dispensers when active."
	 *
	 * 
	 */
	context(attrs: btpos.source.vdfdsl.modeling.IKeyValueMap)
	var noMetalFromDispensersWhileActive: Boolean?
		get() = attrs.getTyped("no metal from dispensers while active", _root_ide_package_.btpos.source.vdfdsl.serialization.codecs.BinaryIntCodec)
		set(value) = attrs.setNullable("no metal from dispensers while active", value, _root_ide_package_.btpos.source.vdfdsl.serialization.codecs.BinaryIntCodec)
	
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
	val dmgVsBuildings get() = _root_ide_package_.btpos.source.vdfdsl.tf2.itemattributes.BonusPenalty<Float, Float>("dmg bonus vs buildings", "dmg penalty vs buildings")
	
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
	val clipSize get() = _root_ide_package_.btpos.source.vdfdsl.tf2.itemattributes.BonusPenalty_PenaltyNested<Float, btpos.source.vdfdsl.tf2.itemattributes.VisHidden<Float, Float>>("clip size bonus", _root_ide_package_.btpos.source.vdfdsl.tf2.itemattributes.VisHidden<Float, Float>("clip size penalty", "clip size penalty HIDDEN"))
	
	/**
	 * In-Game: "+N% clip size"
	 *
	 * 
	 *
	 * Stacks with [clipSize].
	 */
	context(attrs: btpos.source.vdfdsl.modeling.IKeyValueMap)
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
	context(attrs: btpos.source.vdfdsl.modeling.IKeyValueMap)
	var clipSizeUpgradeAtomic: Int?
		get() = attrs.getTyped("clip size upgrade atomic")
		set(value) = attrs.setNullable("clip size upgrade atomic", value)
	
	/**
	 * In-Game: "Clip size increased on kill"
	 *
	 * 
	 */
	context(attrs: btpos.source.vdfdsl.modeling.IKeyValueMap)
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
	context(attrs: btpos.source.vdfdsl.modeling.IKeyValueMap)
	var wrenchBuildsMinisentry: Boolean?
		get() = attrs.getTyped("mod wrench builds minisentry", _root_ide_package_.btpos.source.vdfdsl.serialization.codecs.BinaryIntCodec)
		set(value) = attrs.setNullable("mod wrench builds minisentry", value, _root_ide_package_.btpos.source.vdfdsl.serialization.codecs.BinaryIntCodec)
	
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
	val deployTime get() = _root_ide_package_.btpos.source.vdfdsl.tf2.itemattributes.BonusPenalty<Float, Float>("deploy time decreased", "deploy time increased")
	
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
	val singleWepDeployTime get() = _root_ide_package_.btpos.source.vdfdsl.tf2.itemattributes.BonusPenalty<Float, Float>("single wep deploy time decreased", "single wep deploy time increased")
	
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
	val singleWepHolsterTime get() = _root_ide_package_.btpos.source.vdfdsl.tf2.itemattributes.BonusPenalty<Float, Float>("switch from wep deploy time decreased", "single wep holster time increased")
	
	/**
	 * In-Game: "This Weapon has a large melee range and deploys and holsters slower"
	 *
	 * 
	 *
	 * If true, make weapon deploy and holster 75% slower.
	 */
	context(attrs: btpos.source.vdfdsl.modeling.IKeyValueMap)
	var isASword: Boolean?
		get() = attrs.getTyped("is_a_sword", _root_ide_package_.btpos.source.vdfdsl.serialization.codecs.BinaryIntCodec)
		set(value) = attrs.setNullable("is_a_sword", value, _root_ide_package_.btpos.source.vdfdsl.serialization.codecs.BinaryIntCodec)
	
	/**
	 * In-Game: "While not being healed by a medic, your weapon switch time is N% longer"
	 *
	 * 
	 *
	 * On player.
	 *
	 * Multiplier applied if NOT being healed by a medic.
	 */
	context(attrs: btpos.source.vdfdsl.modeling.IKeyValueMap)
	var medicHealedDeployTimePenalty: Float?
		get() = attrs.getTyped("mod medic healed deploy time penalty")
		set(value) = attrs.setNullable("mod medic healed deploy time penalty", value)
	
	/**
	 * 
	 *
	 * Should force switch to this item on some condition.
	 */
	context(attrs: btpos.source.vdfdsl.modeling.IKeyValueMap)
	var forceWeaponSwitch: Boolean?
		get() = attrs.getTyped("force weapon switch", _root_ide_package_.btpos.source.vdfdsl.serialization.codecs.BinaryIntCodec)
		set(value) = attrs.setNullable("force weapon switch", value, _root_ide_package_.btpos.source.vdfdsl.serialization.codecs.BinaryIntCodec)
	
	/**
	 * In-Game: "When weapon is active:"
	 *
	 * 
	 *
	 * If true, only applies attributes when weapon is active, and unapplies them when switching off.
	 *
	 * This also means you can't have "only active when holding weapon" and "always active" attributes on the same weapon (excluding the specific attributes that are _always_ "only when active"), since the order you specify attributes in doesn't matter.
	 */
	context(attrs: btpos.source.vdfdsl.modeling.IKeyValueMap)
	var provideOnActive: Boolean?
		get() = attrs.getTyped("provide on active", _root_ide_package_.btpos.source.vdfdsl.serialization.codecs.BinaryIntCodec)
		set(value) = attrs.setNullable("provide on active", value, _root_ide_package_.btpos.source.vdfdsl.serialization.codecs.BinaryIntCodec)
	
	/**
	 * In-Game: "Projectiles penetrate enemy players"
	 *
	 * 
	 *
	 * How many players your "projectile" (*including bullets*) should penetrate.
	 */
	context(attrs: btpos.source.vdfdsl.modeling.IKeyValueMap)
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
	context(attrs: btpos.source.vdfdsl.modeling.IKeyValueMap)
	var projectilePenetrationHeavy: Int?
		get() = attrs.getTyped("projectile penetration heavy")
		set(value) = attrs.setNullable("projectile penetration heavy", value)
	
	/**
	 * In-Game: "+N% bullets per shot"
	 *
	 * 
	 */
	context(attrs: btpos.source.vdfdsl.modeling.IKeyValueMap)
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
	val damage get() = _root_ide_package_.btpos.source.vdfdsl.tf2.itemattributes.BonusPenalty_BonusNested<btpos.source.vdfdsl.tf2.itemattributes.VisHidden<Float, Float>, Float>(_root_ide_package_.btpos.source.vdfdsl.tf2.itemattributes.VisHidden<Float, Float>("damage bonus", "damage bonus HIDDEN"), "damage penalty")
	
	/**
	 * In-Game: "No random critical hits"
	 *
	 * 
	 *
	 * "No random crits" sets this to `0.0`.
	 */
	context(attrs: btpos.source.vdfdsl.modeling.IKeyValueMap)
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
	context(attrs: btpos.source.vdfdsl.modeling.IKeyValueMap)
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
	val autoFiresFullClip get() = _root_ide_package_.btpos.source.vdfdsl.tf2.itemattributes.BonusPenalty<Boolean, Boolean>("auto fires full clip", "auto fires full clip penalty")
	
	/**
	 * 
	 */
	context(attrs: btpos.source.vdfdsl.modeling.IKeyValueMap)
	var autoFiresFullClipAllAtOnce: Boolean?
		get() = attrs.getTyped("auto fires full clip all at once", _root_ide_package_.btpos.source.vdfdsl.serialization.codecs.BinaryIntCodec)
		set(value) = attrs.setNullable("auto fires full clip all at once", value, _root_ide_package_.btpos.source.vdfdsl.serialization.codecs.BinaryIntCodec)
	
	/**
	 * In-Game: "Overloading the chamber will cause a misfire"
	 *
	 * 
	 *
	 * Deals damage to the player when overloaded.
	 */
	context(attrs: btpos.source.vdfdsl.modeling.IKeyValueMap)
	var canOverload: Boolean?
		get() = attrs.getTyped("can overload", _root_ide_package_.btpos.source.vdfdsl.serialization.codecs.BinaryIntCodec)
		set(value) = attrs.setNullable("can overload", value, _root_ide_package_.btpos.source.vdfdsl.serialization.codecs.BinaryIntCodec)
	
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
	val fireRate get() = _root_ide_package_.btpos.source.vdfdsl.tf2.itemattributes.BonusPenalty_BothNested<btpos.source.vdfdsl.tf2.itemattributes.VisHidden<Float, Float>, btpos.source.vdfdsl.tf2.itemattributes.VisHidden<Float, Float>>(_root_ide_package_.btpos.source.vdfdsl.tf2.itemattributes.VisHidden<Float, Float>("fire rate bonus", "fire rate bonus HIDDEN"), _root_ide_package_.btpos.source.vdfdsl.tf2.itemattributes.VisHidden<Float, Float>("fire rate penalty", "fire rate penalty HIDDEN"))
	
	/**
	 * 
	 */
	context(attrs: btpos.source.vdfdsl.modeling.IKeyValueMap)
	var autoFiresWhenFull: Boolean?
		get() = attrs.getTyped("auto fires when full", _root_ide_package_.btpos.source.vdfdsl.serialization.codecs.BinaryIntCodec)
		set(value) = attrs.setNullable("auto fires when full", value, _root_ide_package_.btpos.source.vdfdsl.serialization.codecs.BinaryIntCodec)
	
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
	val reloadTime get() = _root_ide_package_.btpos.source.vdfdsl.tf2.itemattributes.BonusPenalty<Float, Float>("Reload time decreased", "Reload time increased")
	
	/**
	 * In-Game: "N% slower reload time"
	 *
	 * 
	 */
	context(attrs: btpos.source.vdfdsl.modeling.IKeyValueMap)
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
	context(attrs: btpos.source.vdfdsl.modeling.IKeyValueMap)
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
	context(attrs: btpos.source.vdfdsl.modeling.IKeyValueMap)
	var halloweenReloadTimeDecreased: Float?
		get() = attrs.getTyped("halloween reload time decreased")
		set(value) = attrs.setNullable("halloween reload time decreased", value)
	
	/**
	 * In-Game: "N% faster reload time while being healed"
	 *
	 * 
	 */
	context(attrs: btpos.source.vdfdsl.modeling.IKeyValueMap)
	var reloadTimeDecreasedWhileHealed: Float?
		get() = attrs.getTyped("reload time decreased while healed")
		set(value) = attrs.setNullable("reload time decreased while healed", value)
	
	/**
	 * 
	 */
	context(attrs: btpos.source.vdfdsl.modeling.IKeyValueMap)
	var weaponAllowInspect: Boolean?
		get() = attrs.getTyped("weapon_allow_inspect", _root_ide_package_.btpos.source.vdfdsl.serialization.codecs.BinaryIntCodec)
		set(value) = attrs.setNullable("weapon_allow_inspect", value, _root_ide_package_.btpos.source.vdfdsl.serialization.codecs.BinaryIntCodec)
}

