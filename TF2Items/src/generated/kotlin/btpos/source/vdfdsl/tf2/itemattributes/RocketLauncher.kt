package btpos.source.vdfdsl.tf2.itemattributes

import btpos.source.vdfdsl.modeling.*
import btpos.source.vdfdsl.serialization.codecs.*
import btpos.source.vdfdsl.tf2.itemattributes.impl.*
import btpos.source.vdfdsl.tf2.tftypes.*
import java.util.*



/**
 * Items: Stock Rocket Launcher + Reskins + The Original, The Black Box + Festive, Rocket Jumper, The Liberty Launcher, The Beggar's Bazooka, The Direct Hit, The Cow Mangler 5000
 */
interface RocketLauncherAttributes : IBlockScoped {
	companion object {
		/**
		 * In-Game: "Overrides the projectile fired from the weapon. Takes values from 1 to 26, each representing a different projectile, and not all projectiles work on all weapons"
		 *
		 * 
		 *
		 * If unset, uses the weapon's default projectile type.
		 */
		val overrideProjectileType = ItemAttributeNamed<TFProjectileType>("override projectile type")
		
		/**
		 * 
		 *
		 * Allows the player to rocket jump with the projectile. (note that "rocket launcher" is the base for most projectile launchers, including the Crossbow :3).
		 */
		val canRocketJumpWithExplosion = ItemAttributeNamed<Boolean>("rocket launch impulse")
	}

	/**
	 * In-Game: "Overrides the projectile fired from the weapon. Takes values from 1 to 26, each representing a different projectile, and not all projectiles work on all weapons"
	 *
	 * 
	 *
	 * If unset, uses the weapon's default projectile type.
	 */
	val overrideProjectileType: ItemAttribute<TFProjectileType> get() = RocketLauncherAttributes.overrideProjectileType
	
	/**
	 * 
	 *
	 * Allows the player to rocket jump with the projectile. (note that "rocket launcher" is the base for most projectile launchers, including the Crossbow :3).
	 */
	val canRocketJumpWithExplosion: ItemAttribute<Boolean> get() = RocketLauncherAttributes.canRocketJumpWithExplosion

   
}

