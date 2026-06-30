package btpos.source.vdfdsl.tf2.itemattributes

import btpos.source.vdfdsl.modeling.*


/**
 * Items: TF_WEAPON_GRENADELAUNCHER, Upgradeable TF_WEAPON_GRENADELAUNCHER, The Loch-n-Load, Festive Grenade Launcher, The Iron Bomber, The Loose Cannon
 */
interface GrenadeLauncherAttributes : btpos.source.vdfdsl.tf2.itemattributes.BaseGunAttributes, btpos.source.vdfdsl.tf2.itemattributes.IBlockScoped {
	companion object : GrenadeLauncherAttributes
	
	/**
	 * In-Game: "N% damage on grenades that explode on timer"
	 *
	 * 
	 *
	 * Flat multiplier applied to initial damage.
	 */
	context(attrs: btpos.source.vdfdsl.modeling.IKeyValueMap)
	var grenadeDetonationDamagePenalty: Float?
		get() = attrs.getTyped("grenade detonation damage penalty")
		set(value) = attrs.setNullable("grenade detonation damage penalty", value)
	
	/**
	 * Bonus:
	 *
	 * 	- Visible:
	 *
	 * 		- In-Game: "+N% projectile speed"
	 *
	 * 	- Hidden:
	 *
	 * 		- In-Game: "+N% projectile speed"
	 *
	 * 
	 *
	 * Penalty:
	 *
	 * 	- In-Game: "N% projectile speed"
	 *
	 * 
	 */
	val projectileSpeed get() = _root_ide_package_.btpos.source.vdfdsl.tf2.itemattributes.BonusPenalty_BonusNested<btpos.source.vdfdsl.tf2.itemattributes.VisHidden<Float, Float>, Float>(_root_ide_package_.btpos.source.vdfdsl.tf2.itemattributes.VisHidden<Float, Float>("Projectile speed increased", "Projectile speed increased HIDDEN"), "Projectile speed decreased")
	
	/**
	 * In-Game: "Cannonballs have a fuse time of 1 second; fuses can be primed to explode earlier by holding down the fire key."
	 *
	 * 
	 *
	 * "Mortar" (loose cannon) detonation time length.
	 */
	context(attrs: btpos.source.vdfdsl.modeling.IKeyValueMap)
	var grenadeLauncherMortarMode: Int?
		get() = attrs.getTyped("grenade launcher mortar mode")
		set(value) = attrs.setNullable("grenade launcher mortar mode", value)
}

