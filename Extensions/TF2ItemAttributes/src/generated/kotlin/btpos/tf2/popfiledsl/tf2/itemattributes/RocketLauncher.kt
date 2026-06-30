package btpos.tf2.popfiledsl.tf2.itemattributes

import btpos.tf2.popfiledsl.modeling.*
import btpos.tf2.popfiledsl.serialization.codecs.*


/**
 * Items: TF_WEAPON_ROCKETLAUNCHER, Upgradeable TF_WEAPON_ROCKETLAUNCHER, The Black Box, Rocket Jumper, The Liberty Launcher, The Original, Festive Rocket Launcher 2011, The Beggar's Bazooka, Silver Botkiller Rocket Launcher Mk.I, Gold Botkiller Rocket Launcher Mk.I, Rust Botkiller Rocket Launcher Mk.I, Blood Botkiller Rocket Launcher Mk.I, Carbonado Botkiller Rocket Launcher Mk.I, Diamond Botkiller Rocket Launcher Mk.I, Silver Botkiller Rocket Launcher Mk.II, Gold Botkiller Rocket Launcher Mk.II, Festive Black Box
 */
interface RocketLauncherAttributes : BaseGunAttributes {
	companion object : RocketLauncherAttributes
	
	/**
	 * In-Game: "Overrides the projectile fired from the weapon. Takes values from 1 to 26, each representing a different projectile, and not all projectiles work on all weapons"
	 *
	 * 
	 *
	 * If unset, uses the weapon's default projectile type.
	 *
	 * Else use a numbered [ProjectileType]
	 */
	context(attrs: IKeyValueMap)
	override var overrideProjectileType: Int?
		get() = super.overrideProjectileType
		set(value) { super.overrideProjectileType = value }
	
	/**
	 * 
	 *
	 * Allows the player to rocket jump with the projectile. (note that "rocket launcher" is the base for most projectile launchers, including the Crossbow :3)
	 */
	context(attrs: IKeyValueMap)
	var canRocketJumpWithExplosion: Boolean?
		get() = attrs.getTyped("rocket launch impulse", BinaryIntCodec)
		set(value) = attrs.setNullable("rocket launch impulse", value, BinaryIntCodec)
}

inline operator fun RocketLauncherAttributes.invoke(scope: RocketLauncherAttributes.() -> Unit) {
	this.apply(scope)
}

