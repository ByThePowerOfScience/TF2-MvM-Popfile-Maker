package btpos.source.vdfdsl.tf2.itemattributes

import btpos.source.vdfdsl.modeling.*
import btpos.source.vdfdsl.serialization.codecs.*
import btpos.source.vdfdsl.tf2.itemattributes.impl.*
import java.util.*

/**
 * Items: Stock Rocket Launcher + Reskins + The Original, The Black Box + Festive, Rocket Jumper, The Liberty Launcher, The Beggar's Bazooka, The Direct Hit, The Cow Mangler 5000
 */
interface RocketLauncherAttributes : BaseGunAttributes, IBlockScoped {
	companion object : RocketLauncherAttributes
	
	/**
	 * In-Game: "Overrides the projectile fired from the weapon. Takes values from 1 to 26, each representing a different projectile, and not all projectiles work on all weapons"
	 *
	 * 
	 *
	 * If unset, uses the weapon's default projectile type.
	 *
	 * If unset, uses the weapon's default projectile type.
	 *
	 * Else it can be used with anything in `ProjectileType_t`, as seen in [BaseGun](#BaseGun).
	 */
	context(attrs: IKeyValueMap)
	override var overrideProjectileType: Int?
		get() = super.overrideProjectileType
		set(value) { super.overrideProjectileType = value }
	
	/**
	 * 
	 *
	 * Allows the player to rocket jump with the projectile. (note that "rocket launcher" is the base for most projectile launchers, including the Crossbow :3).
	 */
	context(attrs: IKeyValueMap)
	var canRocketJumpWithExplosion: Boolean?
		get() = attrs.getTyped("rocket launch impulse", BinaryIntCodec)
		set(value) = attrs.setNullable("rocket launch impulse", value, BinaryIntCodec)
}

