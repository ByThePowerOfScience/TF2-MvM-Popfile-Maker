package btpos.source.vdfdsl.tf2.itemattributes

import btpos.source.vdfdsl.modeling.*
import btpos.source.vdfdsl.serialization.codecs.*


/**
 * Items: TF_WEAPON_ROCKETLAUNCHER, Upgradeable TF_WEAPON_ROCKETLAUNCHER, The Black Box, Rocket Jumper, The Liberty Launcher, The Original, Festive Rocket Launcher 2011, The Beggar's Bazooka, Silver Botkiller Rocket Launcher Mk.I, Gold Botkiller Rocket Launcher Mk.I, Rust Botkiller Rocket Launcher Mk.I, Blood Botkiller Rocket Launcher Mk.I, Carbonado Botkiller Rocket Launcher Mk.I, Diamond Botkiller Rocket Launcher Mk.I, Silver Botkiller Rocket Launcher Mk.II, Gold Botkiller Rocket Launcher Mk.II, Festive Black Box
 */
interface RocketLauncherAttributes : btpos.source.vdfdsl.tf2.itemattributes.BaseGunAttributes, btpos.source.vdfdsl.tf2.itemattributes.IBlockScoped {
	companion object : RocketLauncherAttributes
	
	/**
	 * In-Game: "Overrides the projectile fired from the weapon. Takes values from 1 to 26, each representing a different projectile, and not all projectiles work on all weapons"
	 *
	 * 
	 *
	 * If unset, uses the weapon's default projectile type.
	 *
	 * Else use a numbered [btpos.source.vdfdsl.tf2.itemattributes.ProjectileType].
	 */
	context(attrs: btpos.source.vdfdsl.modeling.IKeyValueMap)
	override var overrideProjectileType: Int?
		get() = super.overrideProjectileType
		set(value) { super.overrideProjectileType = value }
	
	/**
	 * 
	 *
	 * Allows the player to rocket jump with the projectile. (note that "rocket launcher" is the base for most projectile launchers, including the Crossbow :3).
	 */
	context(attrs: btpos.source.vdfdsl.modeling.IKeyValueMap)
	var canRocketJumpWithExplosion: Boolean?
		get() = attrs.getTyped("rocket launch impulse", _root_ide_package_.btpos.source.vdfdsl.serialization.codecs.BinaryIntCodec)
		set(value) = attrs.setNullable("rocket launch impulse", value, _root_ide_package_.btpos.source.vdfdsl.serialization.codecs.BinaryIntCodec)
}

