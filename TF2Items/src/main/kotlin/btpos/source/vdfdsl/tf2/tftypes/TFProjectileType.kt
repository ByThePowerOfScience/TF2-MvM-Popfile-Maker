package btpos.source.vdfdsl.tf2.tftypes

import btpos.source.vdfdsl.backing.VDFPrimitive
import btpos.source.vdfdsl.serialization.IVDFRepresentableValue_Trivial

class TFProjectileType(val number: Int) : IVDFRepresentableValue_Trivial {
	override val _vdfRepr: VDFPrimitive get() = VDFPrimitive(number)
	
	companion object {
		/**
		 * In [overrideProjectileType][btpos.source.vdfdsl.tf2.itemattributes.BaseGunAttributes.ProjectilesAttributes.overrideType],
		 * makes the weapon default to its "default projectile" for its weapon class, which may be null.
		 */
		val NONE = TFProjectileType(0)
		
		/**
		 * A hitscan shot.  Like other projectiles, does not penetrate teammates.
		 * 
		 * For the attributes governing behavior unique to this projectile type, either use the 
		 * [projectiles.bullets][btpos.source.vdfdsl.tf2.itemattributes.WeaponBaseAttributes.ProjectilesAttributes.bullets]
		 * scope of your weapon's attribute configuration, or access the same scopes on the [WeaponBaseAttributes.Inherited][btpos.source.vdfdsl.tf2.itemattributes.WeaponBaseAttributes.Inherited] object.
		 */
		val BULLET = TFProjectileType(1)
		
		/**
		 * A rocket fired by the rocket launchers.
		 *
		 * For the attributes governing behavior unique to this projectile type, use [ProjectileRocketAttributes.Inherited][btpos.source.vdfdsl.tf2.itemattributes.ProjectileRocketAttributes.Inherited].
		 *
		 * @see SENTRY_ROCKET
		 */
		val ROCKET = TFProjectileType(2)
		
		
		/**
		 * **Unimplemented in the base game.**
		 *
		 * This *would* be the projectile fired by the [Dragon's Fury][btpos.source.vdfdsl.tf2.items.weapons.Weapons.DRAGONS_FURY] projectile,
		 * except that this entry in the `ProjectileType` enum is wholly unused in the base game.
		 * As such, this variable only exists for completion's/extensibility's sake.
		 *
		 *
		 * Flies in a straight line, dissipates after a short distance, and inflicts the [TFCondition.BurningPyro] condition on hit enemies for a short duration.
		 *
		 * Note that in the base game, the Dragon's Fury is hardcoded to always fire this projectile.
		 *
		 * For the attributes governing behavior unique to this projectile type, use [ProjectileDragonsFuryAttributes.Inherited][btpos.source.vdfdsl.tf2.itemattributes.ProjectileDragonsFuryAttributes.Inherited].
		 */
		val FLAME_BALL = TFProjectileType(30)
		
		
		/**
		 * A grenade launcher "pill" fired by the [Grenade Launcher][btpos.source.vdfdsl.tf2.items.weapons.Weapons.STOCK_GRENADE_LAUNCHER],
		 * [Iron Bomber][btpos.source.vdfdsl.tf2.items.weapons.Weapons.IRON_BOMBER], and
		 * [Loch n' Load][btpos.source.vdfdsl.tf2.items.weapons.Weapons.LOCHNLOAD].
		 *
		 * Flies in an arc affected by gravity, and explodes on contact dealing Explosive damage.
		 *
		 * For the attributes governing behavior unique to this projectile type, use [ProjectilePipebombAttributes.Inherited][btpos.source.vdfdsl.tf2.itemattributes.ProjectilePipebombAttributes.Inherited].
		 *
		 * @see PIPEBOMB_REMOTE
		 * @see CANNONBALL
		 */
		val PIPEBOMB = TFProjectileType(3)
		
		/**
		 * A stickybomb fired by the [Stickybomb Launcher][btpos.source.vdfdsl.tf2.items.weapons.Weapons.STOCK_STICKYBOMB_LAUNCHER] ([+ festive counterpart][btpos.source.vdfdsl.tf2.items.weapons.Weapons.STICKYBOMB_LAUNCHER_FESTIVE]),
		 * [Scottish Resistance][btpos.source.vdfdsl.tf2.items.weapons.Weapons.SCOTTISH_RESISTANCE], and
		 * [Quickiebomb Launcher][btpos.source.vdfdsl.tf2.items.weapons.Weapons.QUICKIEBOMB_LAUNCHER].
		 *
		 * Flies in an arc affected by gravity and sticks to surfaces.
		 *
		 * For the attributes governing behavior unique to this projectile type, use [ProjectilePipebombAttributes.Inherited][btpos.source.vdfdsl.tf2.itemattributes.ProjectilePipebombAttributes.Inherited].
		 *
		 * @see PIPEBOMB
		 * @see PIPEBOMB_PRACTICE
		 */
		val PIPEBOMB_REMOTE = TFProjectileType(4)
		
		/**
		 * The projectile fired by the [Sticky Jumper][btpos.source.vdfdsl.tf2.items.weapons.Weapons.STICKYBOMB_JUMPER].
		 *
		 * Uses the "practice sticky" model and deals "practice sticky" damage, which does not deal self-damage.
		 * Behaves identically to [PIPEBOMB_REMOTE] in all other respects.
		 *
		 * @see PIPEBOMB
		 * @see PIPEBOMB_REMOTE
		 */
		val PIPEBOMB_PRACTICE = TFProjectileType(14)
		
		/**
		 * The projectile fired by the [Loose Cannon][btpos.source.vdfdsl.tf2.items.weapons.Weapons.LOOSE_CANNON].
		 *
		 * A cannonball that flies in an arc affected by gravity and does not stick to surfaces.
		 *
		 *
		 */
		val CANNONBALL = TFProjectileType(17)
		
		
		
		/**
		 * The projectile fired by the [Syringe Gun][btpos.source.vdfdsl.tf2.items.weapons.Weapons.STOCK_SYRINGE_GUN],
		 * [Blutsauger][btpos.source.vdfdsl.tf2.items.weapons.Weapons.BLUTSAUGER],
		 * and [Overdose][btpos.source.vdfdsl.tf2.items.weapons.Weapons.OVERDOSE].
		 *
		 * A small needle that flies in an arc affected by gravity and deals bullet damage on contact.
		 *
		 * For the attributes governing behavior unique to this projectile type, use [ProjectileSyringeAttributes.Inherited][btpos.source.vdfdsl.tf2.itemattributes.ProjectileSyringeAttributes.Inherited].
		 */
		val SYRINGE = TFProjectileType(5)
		
		/**
		 * The projectile fired by all flare guns, including the Manmelter.
		 *
		 * For the attributes governing behavior unique to this projectile type, use [ProjectileFlareAttributes.Inherited][btpos.source.vdfdsl.tf2.itemattributes.ProjectileFlareAttributes.Inherited].
		 */
		val FLARE = TFProjectileType(6)
		
		
		
		
		/**
		 * The projectile fired by the [Jarate][btpos.source.vdfdsl.tf2.items.weapons.Weapons.JARATE].
		 *
		 * NOTE: This projectile will only function on weapons that inherit from [Jar][btpos.source.vdfdsl.tf2.itemattributes.JarAttributes],
		 * as while every weapon has a "throw jar" action, subtypes of Jar are the only ones that actually do anything in it.
		 *
		 * For the attributes governing behavior unique to this projectile type, use [ProjectileJarAttributes.Inherited][btpos.source.vdfdsl.tf2.itemattributes.ProjectileJarAttributes.Inherited].
		 *
		 * @see FESTIVE_JAR
		 * @see BREADMONSTER_JARATE
		 */
		val JAR = TFProjectileType(7)
		
		/**
		 * The projectile fired by the [Festive Jarate][btpos.source.vdfdsl.tf2.items.weapons.Weapons.JARATE_FESTIVE].
		 *
		 * NOTE: This projectile will only function on weapons that inherit from [Jar][btpos.source.vdfdsl.tf2.itemattributes.JarAttributes],
		 * as while every weapon has a "throw jar" action, subtypes of Jar are the only ones that actually do anything in it.
		 *
		 * For the attributes governing behavior unique to this projectile type, use [ProjectileJarAttributes.Inherited][btpos.source.vdfdsl.tf2.itemattributes.ProjectileJarAttributes.Inherited].
		 *
		 * @see JAR
		 * @see BREADMONSTER_JARATE
		 */
		val FESTIVE_JAR = TFProjectileType(22)
		
		/**
		 * The projectile fired by the [Self-Aware Beauty Mark][btpos.source.vdfdsl.tf2.items.weapons.Weapons.SELFAWARE_BEAUTY_MARK],
		 * the "Expiration Date" version of the Jarate.
		 *
		 * NOTE: This projectile will only function on weapons that inherit from [Jar][btpos.source.vdfdsl.tf2.itemattributes.JarAttributes],
		 * as while every weapon has a "throw jar" action, subtypes of Jar are the only ones that actually do anything in it.
		 *
		 * For the attributes governing behavior unique to this projectile type, use [ProjectileJarAttributes.Inherited][btpos.source.vdfdsl.tf2.itemattributes.ProjectileJarAttributes.Inherited].
		 *
		 * @see JAR
		 * @see FESTIVE_JAR
		 */
		val BREADMONSTER_JARATE = TFProjectileType(24)
		
		
		/**
		 * The projectile fired by the Mad Milk.
		 *
		 * NOTE: This projectile will only function on weapons that inherit from [Jar][btpos.source.vdfdsl.tf2.itemattributes.JarAttributes],
		 * as while every weapon has a "throw jar" action, subtypes of Jar are the only ones that actually do anything in it.
		 *
		 * For the attributes governing behavior unique to this projectile type, use [ProjectileJarMilkAttributes.Inherited][btpos.source.vdfdsl.tf2.itemattributes.ProjectileJarMilkAttributes.Inherited].
		 *
		 * @see BREADMONSTER_MADMILK
		 */
		val JAR_MILK = TFProjectileType(10)
		
		/**
		 * The projectile fired by the Mutated Milk, the "Expiration Date" version of the Mad Milk.
		 *
		 * NOTE: This projectile will only function on weapons that inherit from [Jar][btpos.source.vdfdsl.tf2.itemattributes.JarAttributes],
		 * as while every weapon has a "throw jar" action, subtypes of Jar are the only ones that actually do anything in it.
		 *
		 * For the attributes governing behavior unique to this projectile type, use [ProjectileJarMilkAttributes.Inherited][btpos.source.vdfdsl.tf2.itemattributes.ProjectileJarMilkAttributes.Inherited].
		 *
		 * @see JAR_MILK
		 */
		val BREADMONSTER_MADMILK = TFProjectileType(25)
		
		
		/**
		 * The projectile fired by the Flying Guillotine.
		 *
		 * NOTE: This projectile will only function on weapons that inherit from [Jar][btpos.source.vdfdsl.tf2.itemattributes.JarAttributes],
		 * as while every weapon has a "throw jar" action, subtypes of Jar are the only ones that actually do anything in it.
		 *
		 * For the attributes governing behavior unique to this projectile type, use [ProjectileCleaverAttributes.Inherited][btpos.source.vdfdsl.tf2.itemattributes.ProjectileCleaverAttributes.Inherited].
		 */
		val CLEAVER = TFProjectileType(15)
		
		
		/**
		 * The projectile thrown by the [Gas Passer][btpos.source.vdfdsl.tf2.items.weapons.Weapons.GAS_PASSER].
		 *
		 * NOTE: This projectile will only function on weapons that inherit from [Jar][btpos.source.vdfdsl.tf2.itemattributes.JarAttributes],
		 * as while every weapon has a "throw jar" action, subtypes of Jar are the only ones that actually do anything in it.
		 *
		 * For the attributes governing behavior unique to this projectile type, use [ProjectileJarGasAttributes.Inherited][btpos.source.vdfdsl.tf2.itemattributes.ProjectileJarGasAttributes.Inherited].
		 */
		val JAR_GAS = TFProjectileType(29)
		
		
		
		
		
		/**
		 * The projectile fired by the [Huntsman][btpos.source.vdfdsl.tf2.items.weapons.Weapons.HUNTSMAN] and 
		 * [Fortified Compound][btpos.source.vdfdsl.tf2.items.weapons.Weapons.FORTIFIED_COMPOUND].
		 * 
		 * Flies in an arc affected by gravity, deals bullet damage, and can headshot.
		 *
		 * For the attributes governing behavior unique to this projectile type, use [ProjectileArrowAttributes.Inherited][btpos.source.vdfdsl.tf2.itemattributes.ProjectileArrowAttributes.Inherited].
		 *
		 * @see FESTIVE_ARROW
		 */
		val ARROW = TFProjectileType(8)
		
		/**
		 * The projectile fired by the [Festive Huntsman][btpos.source.vdfdsl.tf2.items.weapons.Weapons.HUNTSMAN_FESTIVE].
		 * 
		 * Flies in an arc affected by gravity, deals bullet damage, and can headshot.
		 * 
		 * Identical to [ARROW] save for the Christmas light on the tip.
		 *
		 * For the attributes governing behavior unique to this projectile type, use [ProjectileArrowAttributes.Inherited][btpos.source.vdfdsl.tf2.itemattributes.ProjectileArrowAttributes.Inherited].
		 * 
		 * @see ARROW
		 */
		val FESTIVE_ARROW = TFProjectileType(19)
		
		
		/**
		 * The projectile fired by the [Rescue Ranger][btpos.source.vdfdsl.tf2.items.weapons.Weapons.RESCUE_RANGER].  
		 * 
		 * Flies in an arc affected by gravity and deals bullet damage.  
		 * 
		 * Unlike other arrows, *cannot* headshot.
		 *
		 * For the attributes governing behavior unique to this projectile type, use 
		 * [ProjectileArrowAttributes.Inherited][btpos.source.vdfdsl.tf2.itemattributes.ProjectileArrowAttributes.Inherited].
		 *
		 * Note that this will not heal buildings by default, and can only heal buildings if
		 * [ProjectileArrowAttributes.arrowHealsBuildings][btpos.source.vdfdsl.tf2.itemattributes.ProjectileArrowAttributes.arrowHealsBuildings]
		 * is set on either the weapon or the owning player.
		 *
		 * @see HEALING_BOLT
		 */
		val BUILDING_REPAIR_BOLT = TFProjectileType(18)
		
		
		
		
		
		
		
		
		/**
		 * The projectile fired by the [Crusader's Crossbow][btpos.source.vdfdsl.tf2.items.weapons.Weapons.CRUSADERS_CROSSBOW].  
		 * 
		 * A small team-colored syringe that flies in a straight line unaffected by gravity,
		 * deals bullet damage increasing with distance traveled,
		 * and heals allies hit by this projectile for the amount of damage that would have been dealt.
		 *
		 * For the attributes governing behavior unique to this projectile type, use [ProjectileArrowAttributes.Inherited][btpos.source.vdfdsl.tf2.itemattributes.ProjectileArrowAttributes.Inherited].
		 *
		 * @see BUILDING_REPAIR_BOLT
		 * @see FESTIVE_HEALING_BOLT
		 */
		val HEALING_BOLT = TFProjectileType(11)
		
		/**
		 * The projectile fired by the [Festive Crusader's Crossbow][btpos.source.vdfdsl.tf2.items.weapons.Weapons.CRUSADERS_CROSSBOW_FESTIVE].  
		 * 
		 * A small team-colored candy cane that flies in a straight line unaffected by gravity,
		 * deals bullet damage increasing with distance traveled,
		 * and heals allies hit by this projectile for the amount of damage that would have been dealt.
		 *
		 * For the attributes governing behavior unique to this projectile type, use [ProjectileArrowAttributes.Inherited][btpos.source.vdfdsl.tf2.itemattributes.ProjectileArrowAttributes.Inherited].
		 *
		 * @see HEALING_BOLT
		 */
		val FESTIVE_HEALING_BOLT = TFProjectileType(23)
		
		
		
		
		
		/**
		 * The projectile fired by the [Pomson 6000][btpos.source.vdfdsl.tf2.items.weapons.Weapons.POMSON_6000].  
		 * 
		 * A fist-sized team-colored plasma ball that flies slowly in a straight line unaffected by gravity
		 * and deals Plasma damage on contact.
		 *
		 * Note that the effects normally associated with the Pomson are located in the [onHit attribute scope][btpos.source.vdfdsl.tf2.itemattributes.WeaponBaseAttributes.OnHitAttributes].
		 *
		 * For the attributes governing behavior unique to this projectile type, use [ProjectileEnergyBallAttributes.Inherited][btpos.source.vdfdsl.tf2.itemattributes.ProjectileEnergyBallAttributes.Inherited].
		 *
		 * @see ENERGY_RING
		 */
		val ENERGY_BALL = TFProjectileType(12)
		
		/**
		 * The projectile fired by the [Righteous Bison][btpos.source.vdfdsl.tf2.items.weapons.Weapons.RIGHTEOUS_BISON].  
		 * 
		 * A translucent team-colored cloud banded by rings that flies in a straight line unaffected by gravity
		 * and deals Plasma damage on contact.
		 *
		 * Note that this can only pierce players and Medic shields when
		 * [energyWeaponPenetration][btpos.source.vdfdsl.tf2.itemattributes.ProjectileEnergyRingAttributes.energyWeaponPenetration] is set.
		 *
		 * For the attributes governing behavior unique to this projectile type, use [ProjectileEnergyRingAttributes.Inherited][btpos.source.vdfdsl.tf2.itemattributes.ProjectileEnergyRingAttributes.Inherited].
		 *
		 * @see ENERGY_BALL
		 */
		val ENERGY_RING = TFProjectileType(13)
		
		
		
		
		
		/**
		 * Unimplemented in the base game.
		 */
		@Deprecated("Unimplemented in the base game")
		val FLAME_ROCKET = TFProjectileType(9)
		
		
		/**
		 * Unimplemented in the base game.
		 *
		 * Uses the model of the baseball. Like arrows, sticks enemies to surfaces.
		 */
		@Deprecated("Unimplemented in the base game")
		val STICKY_BALL = TFProjectileType(16)
		
		
		
		
		
		/**
		 * The projectile fired by the TODO
		 */
		val THROWABLE = TFProjectileType(20)
		
		
		// TODO
		val SPELL = TFProjectileType(21)
		
		/**
		 * The projectile fired by the Grappling Hook from Mannpower Mode.
		 *
		 * Travels in a straight line unaffected by gravity, and pulls the player to its location when it lands on a wall or player.
		 *
		 * For the attributes governing behavior unique to this projectile type, use [ProjectileGrapplingHookAttributes.Inherited][btpos.source.vdfdsl.tf2.itemattributes.ProjectileGrapplingHookAttributes.Inherited].
		 */
		val GRAPPLINGHOOK = TFProjectileType(26)
		
		
		/**
		 * A rocket fired by the level 3 sentry gun.
		 *
		 * For the attributes governing behavior unique to this projectile type, use [ProjectileSentryRocketAttributes.Inherited][btpos.source.vdfdsl.tf2.itemattributes.ProjectileSentryRocketAttributes.Inherited].
		 *
		 * @see ROCKET
		 */
		val SENTRY_ROCKET = TFProjectileType(27)
		
		
		val BREAD_MONSTER = TFProjectileType(28)
	}
}