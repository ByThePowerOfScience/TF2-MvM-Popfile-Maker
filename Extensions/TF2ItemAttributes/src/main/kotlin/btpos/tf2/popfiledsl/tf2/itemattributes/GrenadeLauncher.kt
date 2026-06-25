package btpos.tf2.popfiledsl.tf2.itemattributes

import btpos.tf2.popfiledsl.modeling.*
import btpos.tf2.popfiledsl.serialization.codecs.*


/**
 * Items: TF_WEAPON_GRENADELAUNCHER, Upgradeable TF_WEAPON_GRENADELAUNCHER, The Loch-n-Load, Festive Grenade Launcher, The Iron Bomber, The Loose Cannon
 * 
 */
interface GrenadeLauncherAttributes : BaseGunAttributes {
	companion object : GrenadeLauncherAttributes
	
	/**
	 * Value type: percentage
	 * 
	 * Flat multiplier applied to initial damage
	 * 
	 */
	context(attrs: IKeyValueMap)
	var grenadeDetonationDamagePenalty: Float?
		get() = attrs.getTyped("grenade detonation damage penalty")
		set(value) = attrs.setNullable("grenade detonation damage penalty", value)
	
	/**
	 * 
	 * Bonus:
	 * 	- Visible:
	 * 		- Value type: percentage
	 * 		- +N% projectile speed
	 * 	- Hidden:
	 * 		- Value type: percentage
	 * 		- +N% projectile speed
	 * 
	 * Penalty:
	 * 	- Value type: percentage
	 * 	- N% projectile speed
	 */
	val projectileSpeedDecreased get() = BonusPenalty_BonusNested<VisHidden<Float, Float>, Float>(VisHidden<Float, Float>("Projectile speed increased", "Projectile speed increased HIDDEN"), "Projectile speed decreased")
	
	/**
	 * If 0, uses standard "detonate all stickies on rclick". Else, uses Scottish Resistance's "only detonate stickies on crosshair" function.
	 * 
	 * 
	 * Bonus:
	 * 	- Detonates stickybombs near the crosshair and directly under your feet
	 * 
	 * Penalty:
	 * 	- Launched bombs shatter on surfaces
	 */
	val stickyAirBurstMode get() = BonusPenalty<Int, Int>("sticky detonate mode", "sticky air burst mode")
	
	/**
	 * "Mortar" (loose cannon) detonation time length
	 * 
	 */
	context(attrs: IKeyValueMap)
	var grenadeLauncherMortarMode: Int?
		get() = attrs.getTyped("grenade launcher mortar mode")
		set(value) = attrs.setNullable("grenade launcher mortar mode", value)
}

operator fun GrenadeLauncherAttributes.invoke(scope: GrenadeLauncherAttributes.() -> Unit) {
	this.apply(scope)
}

