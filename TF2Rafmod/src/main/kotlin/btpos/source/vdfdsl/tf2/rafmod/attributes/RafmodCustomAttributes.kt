@file:Suppress("UnusedReceiverParameter", "unused")

package btpos.source.vdfdsl.tf2.rafmod.attributes

import btpos.source.vdfdsl.modeling.IKeyValueMap
import btpos.source.vdfdsl.serialization.codecs.BinaryIntCodec
import btpos.source.vdfdsl.tf2.itemattributes.BaseEntityAttributes
import btpos.source.vdfdsl.tf2.itemattributes.BaseGunAttributes
import btpos.source.vdfdsl.tf2.itemattributes.BaseMeleeAttributes
import btpos.source.vdfdsl.tf2.itemattributes.BaseProjectileAttributes
import btpos.source.vdfdsl.tf2.itemattributes.BuildingsAttributes
import btpos.source.vdfdsl.tf2.itemattributes.ColorCodec
import btpos.source.vdfdsl.tf2.itemattributes.CompoundBowAttributes
import btpos.source.vdfdsl.tf2.itemattributes.FlamethrowerAttributes
import btpos.source.vdfdsl.tf2.itemattributes.GrenadeLauncherAttributes
import btpos.source.vdfdsl.tf2.itemattributes.MvMBotAttributes
import btpos.source.vdfdsl.tf2.itemattributes.PlayerAttributes
import btpos.source.vdfdsl.tf2.itemattributes.SentryGunAttributes
import btpos.source.vdfdsl.tf2.itemattributes.SniperRifleAttributes
import btpos.source.vdfdsl.tf2.itemattributes.StickBombAttributes
import btpos.source.vdfdsl.tf2.itemattributes.WeaponBaseAttributes
import btpos.source.vdfdsl.tf2.itemattributes.impl.IBlockScoped
import btpos.source.vdfdsl.tf2.rafmod.codecs.DurationCodec
import btpos.source.vdfdsl.tf2.rafmod.data.Rot3
import btpos.source.vdfdsl.tf2.rafmod.data.Vec3
import btpos.source.vdfdsl.tf2.rafmod.types.Sound
import java.awt.Color
import kotlin.time.Duration

object RafmodCustomAttributes {
	
	/**
	 * Turns the victim ragdoll to ice
	 */
	context(attrs: IKeyValueMap)
	var WeaponBaseAttributes.setTurnToIce: Boolean?
		get() = attrs.getTyped("set turn to ice")
		set(value) = attrs.setNullable("set turn to ice", value)
	
	/**
	 * Lets the Huntsman shoot 2 additional arrows per level, 25 base damage each. Can headshot.
	 */
	context(attrs: IKeyValueMap)
	var CompoundBowAttributes.arrowMastery: Int?
		get() = attrs.getTyped("arrow mastery")
		set(value) = attrs.setNullable("arrow mastery", value)
	
	/**
	 * If set to 1, the player can move teleporters with double tapped movement keys. Does not work.
	 */
	context(attrs: IKeyValueMap)
	var PlayerAttributes.abilityDoubletapTeleport: Boolean?
		get() = attrs.getTyped("ability doubletap teleport")
		set(value) = attrs.setNullable("ability doubletap teleport", value)
	
	/**
	 * A worse version of damage piercing since it only ignores the Battalion's Backup's 35% damage reduction. Does not work?
	 */
	context(attrs: IKeyValueMap)
	var WeaponBaseAttributes.modIgnoreResistsAbsorbs: Int?
		get() = attrs.getTyped("mod ignore resists absorbs")
		set(value) = attrs.setNullable("mod ignore resists absorbs", value)
	
	/**
	 * Configure projectiles' heat-seeking capabilities
	 */
	val BaseProjectileAttributes.heatSeeking get() = ProjectileHeatSeekingAttributes
	
	object ProjectileHeatSeekingAttributes : IBlockScoped {
		/**
		 * The weapon's homing seek power, in degrees per second.
		 *
		 * This attribute is required for the other "mod projectile heat" attributes to work!
		 */
		context(attrs: IKeyValueMap)
		var heatSeekPower: Number?
			get() = attrs.getTyped("mod projectile heat seek power")
			set(value) = attrs.setNullable("mod projectile heat seek power", value)
		
		/**
		 * The weapon's max error in aim in degrees. If no target is within this degree, the projectile will not home.
		 */
		context(attrs: IKeyValueMap)
		var maxError: Number?
			get() = attrs.getTyped("mod projectile heat aim error")
			set(value) = attrs.setNullable("mod projectile heat aim error", value)
		
		/**
		 * How long the projectile will home for.
		 *
		 * Example:
		 * ```kotlin
		 * aimTime = 5.seconds
		 *
		 * aimTime = Duration.INFINITE
		 * ```
		 */
		context(attrs: IKeyValueMap)
		var aimTime: Duration?
			get() = attrs.getTyped("mod projectile heat aim time", DurationCodec)
			set(value) = attrs.setNullable("mod projectile heat aim time", value, DurationCodec)
		
		/**
		 * Disables movement prediction for homing projectiles. Might be useful for very slow projectiles.
		 */
		context(attrs: IKeyValueMap)
		var noPredictTargetSpeed: Boolean?
			get() = attrs.getTyped("mod projectile heat no predict target speed", BinaryIntCodec)
			set(value) = attrs.setNullable("mod projectile heat no predict target speed", value, BinaryIntCodec)
		
		/**
		 * Homing projectiles will follow the crosshair instead of enemies.
		 */
		context(attrs: IKeyValueMap)
		var followCrosshair: Boolean?
			get() = attrs.getTyped("mod projectile heat follow crosshair", BinaryIntCodec)
			set(value) = attrs.setNullable("mod projectile heat follow crosshair", value, BinaryIntCodec)
		
		/**
		 * Time before the projectile starts homing.
		 *
		 * Example:
		 * ```kotlin
		 * aimStartTime = 5.minutes
		 * ```
		 */
		context(attrs: IKeyValueMap)
		var aimStartTime: Duration?
			get() = attrs.getTyped("mod projectile heat aim start time", DurationCodec)
			set(value) = attrs.setNullable("mod projectile heat aim start time", value, DurationCodec)
	}
	
	
	/**
	 * On building hit: Disable for x seconds
	 */
	context(attrs: IKeyValueMap)
	var WeaponBaseAttributes.disableBuildingsOnHit: Duration?
		get() = attrs.getTyped("disable buildings on hit", DurationCodec)
		set(value) = attrs.setNullable("disable buildings on hit", value, DurationCodec)
	
	/**
	 * Regenerates Ullapool Caber after a hit.
	 */
	context(attrs: IKeyValueMap)
	var StickBombAttributes.regenerateStickbomb: Boolean?
		get() = attrs.getTyped("regenerate stickbomb")
		set(value) = attrs.setNullable("regenerate stickbomb", value)
	
	/**
	 * Melee "smack time" multiplier; time between pressing the fire button and the attack being dealt (0.2s default)
	 */
	context(attrs: IKeyValueMap)
	var BaseMeleeAttributes.multSmackTime: Number?
		get() = attrs.getTyped("mult smack time")
		set(value) = attrs.setNullable("mult smack time", value)
	
	/**
	 * Custom item model name
	 */
	context(attrs: IKeyValueMap)
	var WeaponBaseAttributes.customItemModel: String?
		get() = attrs.getTyped("custom item model")
		set(value) = attrs.setNullable("custom item model", value)
	
	/**
	 * Custom weapon fire sound. Does not work for the weapon owner
	 */
	context(attrs: IKeyValueMap)
	var WeaponBaseAttributes.customWeaponFireSound: Sound?
		get() = attrs.getTyped("custom weapon fire sound")
		set(value) = attrs.setNullable("custom weapon fire sound", value)
	
	/**
	 * Bullets explode in x radius on hit (147 is rocket launcher radius)
	 */
	context(attrs: IKeyValueMap)
	var BaseGunAttributes.explosiveBullets: Int?
		get() = attrs.getTyped("explosive bullets")
		set(value) = attrs.setNullable("explosive bullets", value)
	
	/**
	 * Projectile model scale multipier
	 */
	context(attrs: IKeyValueMap)
	var BaseProjectileAttributes.multProjectileScale: Number?
		get() = attrs.getTyped("mult projectile scale")
		set(value) = attrs.setNullable("mult projectile scale", value)
	
	/**
	 * Fire x projectiles at once. Add "ignores other projectiles" 1 to Rocket Launchers so that rockets don't collide with each other.
	 */
	context(attrs: IKeyValueMap)
	var BaseProjectileAttributes.multProjectileCount: Number?
		get() = attrs.getTyped("mult projectile count")
		set(value) = attrs.setNullable("mult projectile count", value)
	
	/**
	 * Projectile trail particle name. Prefix the particle name with ~ to remove the original particle.
	 */
	context(attrs: IKeyValueMap)
	var BaseProjectileAttributes.projectileTrailParticle: String?
		get() = attrs.getTyped("projectile trail particle")
		set(value) = attrs.setNullable("projectile trail particle", value)
	
	/**
	 * Explosion particle name
	 */
	context(attrs: IKeyValueMap)
	var WeaponBaseAttributes.explosionParticle: String?
		get() = attrs.getTyped("explosion particle")
		set(value) = attrs.setNullable("explosion particle", value)
	
	/**
	 * Restores the Sydney Sleeper's old "Jarate explosion" on headshot and fully-charged bodyshot.
	 */
	context(attrs: IKeyValueMap)
	var SniperRifleAttributes.radiusSleeper: Boolean?
		get() = attrs.getTyped("radius sleeper")
		set(value) = attrs.setNullable("radius sleeper", value)
	
	/**
	 * Bots with this attribute cannot be affected by the Sapper
	 */
	context(attrs: IKeyValueMap)
	var MvMBotAttributes.cannotBeSapped: Int?
		get() = attrs.getTyped("cannot be sapped")
		set(value) = attrs.setNullable("cannot be sapped", value)
	
	/**
	 * Item tint color
	 */
	context(attrs: IKeyValueMap)
	var BaseEntityAttributes.itemColorRgb: Color?
		get() = attrs.getTyped("item color rgb", ColorCodec)
		set(value) = attrs.setNullable("item color rgb", value, ColorCodec)
	
	/**
	 * Turns item invisible
	 */
	context(attrs: IKeyValueMap)
	var BaseEntityAttributes.isInvisible: Boolean?
		get() = attrs.getTyped("is invisible")
		set(value) = attrs.setNullable("is invisible", value)
	
	/**
	 * If set to 1, cannot taunt
	 */
	context(attrs: IKeyValueMap)
	var PlayerAttributes.cannotTaunt: Boolean?
		get() = attrs.getTyped("cannot taunt")
		set(value) = attrs.setNullable("cannot taunt", value)
	
	/**
	 * Projectile acceleration in hu/s^2
	 *
	 * @see projectileAccelerationTime
	 * @see projectileAccelerationStartTime
	 */
	context(attrs: IKeyValueMap)
	var BaseProjectileAttributes.projectileAcceleration: Number?
		get() = attrs.getTyped("projectile acceleration")
		set(value) = attrs.setNullable("projectile acceleration", value)
	
	/**
	 * How long the projectile should accelerate with the acceleration defined in [projectileAcceleration]
	 *
	 * @see projectileAccelerationStartTime
	 */
	context(attrs: IKeyValueMap)
	var BaseProjectileAttributes.projectileAccelerationTime: Duration?
		get() = attrs.getTyped("projectile acceleration time", DurationCodec)
		set(value) = attrs.setNullable("projectile acceleration time", value, DurationCodec)
	
	/**
	 * Time before projectile starts accelerating with the acceleration defined in [projectileAcceleration].
	 *
	 * @see projectileAccelerationTime
	 */
	context(attrs: IKeyValueMap)
	var BaseProjectileAttributes.projectileAccelerationStartTime: Duration?
		get() = attrs.getTyped("projectile acceleration start time", DurationCodec)
		set(value) = attrs.setNullable("projectile acceleration start time", value, DurationCodec)
	
	/**
	 * The player is counted as a miniboss. Sappers will not fully stun, backstabs deal set damage, will not receive bomb buffs.
	 */
	context(attrs: IKeyValueMap)
	var PlayerAttributes.isMiniboss: Boolean?
		get() = attrs.getTyped("is miniboss")
		set(value) = attrs.setNullable("is miniboss", value)
	
	/**
	 * Player's model scale. 1.75 is used for giant bots.
	 */
	context(attrs: IKeyValueMap)
	var PlayerAttributes.modelScale: Number?
		get() = attrs.getTyped("model scale")
		set(value) = attrs.setNullable("model scale", value)
	
	/**
	 * If set to 1, the player cannot use upgrade stations
	 */
	context(attrs: IKeyValueMap)
	var PlayerAttributes.cannotUpgrade: Boolean?
		get() = attrs.getTyped("cannot upgrade")
		set(value) = attrs.setNullable("cannot upgrade", value)
	
	/**
	 * Minimal respawn time
	 */
	context(attrs: IKeyValueMap)
	var minRespawnTime: Duration?
		get() = attrs.getTyped("min respawn time", DurationCodec)
		set(value) = attrs.setNullable("min respawn time", value, DurationCodec)
	
	/**
	 * Weapon always crits. Less reliable with higher ping.
	 */
	context(attrs: IKeyValueMap)
	var WeaponBaseAttributes.alwaysCrit: Boolean?
		get() = attrs.getTyped("always crit")
		set(value) = attrs.setNullable("always crit", value)
	
	/**
	 * Level 3 Sentry rocket fire rate
	 */
	context(attrs: IKeyValueMap)
	var SentryGunAttributes.multRocketFireRate: Number?
		get() = attrs.getTyped("mult firerocket rate")
		set(value) = attrs.setNullable("mult firerocket rate", value)
	
	/**
	 * Building max level limit
	 */
	context(attrs: IKeyValueMap)
	var BuildingsAttributes.buildingMaxLevel: Int?
		get() = attrs.getTyped("building max level")
		set(value) = attrs.setNullable("building max level", value)
	
	/**
	 * Allows for faster sentry fire rate, up to 66 shots per second. Effectively fixes sentry fire rate upgrades by not simulating it every 3 ticks, but every tick.
	 */
	context(attrs: IKeyValueMap)
	var SentryGunAttributes.sentryRapidFire: Int?
		get() = attrs.getTyped("sentry rapid fire")
		set(value) = attrs.setNullable("sentry rapid fire", value)
	
	/**
	 * Dealing damage with weapon does not increase crit rate
	 */
	context(attrs: IKeyValueMap)
	var WeaponBaseAttributes.dontCountDamageTowardsCritRate: Int?
		get() = attrs.getTyped("dont count damage towards crit rate")
		set(value) = attrs.setNullable("dont count damage towards crit rate", value)
	
	/**
	 * Sets the weapon's maximum damage rampup to 20% (similar to Stickybomb Launchers)
	 */
	context(attrs: IKeyValueMap)
	var WeaponBaseAttributes.reducedDamageRampup: Int?
		get() = attrs.getTyped("reduced damage rampup")
		set(value) = attrs.setNullable("reduced damage rampup", value)
	
	/**
	 * Sets the weapon's maximum damage rampup to 50% (similar to Shotguns)
	 */
	context(attrs: IKeyValueMap)
	var WeaponBaseAttributes.noReducedDamageRampup: Int?
		get() = attrs.getTyped("no reduced damage rampup")
		set(value) = attrs.setNullable("no reduced damage rampup", value)
	
	/**
	 * Forces the weapon to have damage rampup and falloff
	 */
	context(attrs: IKeyValueMap)
	var WeaponBaseAttributes.forceDamageFalloff: Int?
		get() = attrs.getTyped("force damage falloff")
		set(value) = attrs.setNullable("force damage falloff", value)
	
	/**
	 * Weapon can headshot. Hitscan only; inconsistent on multi-pellet weapons such as Shotguns.
	 */
	context(attrs: IKeyValueMap)
	var BaseGunAttributes.canHeadshot: Int?
		get() = attrs.getTyped("can headshot")
		set(value) = attrs.setNullable("can headshot", value)
	
	/**
	 * Building tint color
	 */
	context(attrs: IKeyValueMap)
	var BuildingsAttributes.buildingColorRgb: Color?
		get() = attrs.getTyped("building color rgb", ColorCodec)
		set(value) = attrs.setNullable("building color rgb", value, ColorCodec)
	
	/**
	 * Building scale. Values above 1.17 make it difficult for players to build on uneven ground
	 */
	context(attrs: IKeyValueMap)
	var BuildingsAttributes.buildingScale: Number?
		get() = attrs.getTyped("building scale")
		set(value) = attrs.setNullable("building scale", value)
	
	/**
	 * Stun and slow multiplier. 0 to be fully stun/slow immune
	 */
	context(attrs: IKeyValueMap)
	var PlayerAttributes.multStunResistance: Number?
		get() = attrs.getTyped("mult stun resistance")
		set(value) = attrs.setNullable("mult stun resistance", value)
	
	/**
	 * If set to 1, the player can deal friendly fire damage
	 *
	 * @see receiveFriendlyFire
	 */
	context(attrs: IKeyValueMap)
	var PlayerAttributes.canFriendlyFire: Boolean?
		get() = attrs.getTyped("allow friendly fire")
		set(value) = attrs.setNullable("allow friendly fire", value)
	
	/**
	 * If set to 1, the player can receive friendly fire from teammates
	 *
	 * @see canFriendlyFire
	 */
	context(attrs: IKeyValueMap)
	var PlayerAttributes.receiveFriendlyFire: Boolean?
		get() = attrs.getTyped("receive friendly fire")
		set(value) = attrs.setNullable("receive friendly fire", value)
	
	/**
	 * Weapon cannot headshot
	 */
	context(attrs: IKeyValueMap)
	var BaseGunAttributes.cannotHeadshot: Int?
		get() = attrs.getTyped("cannot headshot")
		set(value) = attrs.setNullable("cannot headshot", value)
	
	/**
	 * Crit damage multiplier
	 */
	context(attrs: IKeyValueMap)
	var WeaponBaseAttributes.multCritDmg: Number?
		get() = attrs.getTyped("mult crit dmg")
		set(value) = attrs.setNullable("mult crit dmg", value)
	
	/**
	 * If set to 1, the player cannot be headshot. Only blocks hitscan headshots
	 */
	context(attrs: IKeyValueMap)
	var PlayerAttributes.cannotBeHeadshot: Boolean?
		get() = attrs.getTyped("cannot be headshot")
		set(value) = attrs.setNullable("cannot be headshot", value)
	
	/**
	 * Configure how this item's model is attached to the entity holding it.
	 */
	val BaseEntityAttributes.itemModelAttachmentConfiguration get() = ModelAttachments
	
	object ModelAttachments : IBlockScoped {
		/**
		 * Use this model attachment instead of bonemerging. If the name is empty, it will follow player origin instead.
		 *
		 * Common attachments for robot models: `"head"`, `"eye_1"`, `"flag"`. Some bot models also have `"eye_2"`, `"partyhat"`. Demo & Soldier additionally contain `"foot_L"` and `"foot_R"`.
		 *
		 * Common attachments for player models: `"head"`, `"eyes"`, `"flag"`, `"partyhat"`, `"bread_face"`, `"bread_head"`, `"effect_hand_L"`, `"effect_hand_R"`, `"bread_hand_r"`, `"bread_hand_l"`, `"bread_butt"`, `"bread_heel_l"`, `"foot_L"`, `"foot_R"`
		 *
		 * This attribute is **required** to make other "attachment" attributes work!
		 */
		context(attrs: IKeyValueMap)
		var name: String?
			get() = attrs.getTyped("attachment name")
			set(value) = attrs.setNullable("attachment name", value)
		
		/**
		 * Item offset from the attachment origin
		 */
		context(attrs: IKeyValueMap)
		var offset: Vec3?
			get() = attrs.getTyped("attachment offset")
			set(value) = attrs.setNullable("attachment offset", value)
		
		/**
		 * Rotation for attached items
		 */
		context(attrs: IKeyValueMap)
		var rotation: Rot3?
			get() = attrs.getTyped("attachment angles")
			set(value) = attrs.setNullable("attachment angles", value)
		
		/**
		 * Model scale for attached items
		 */
		context(attrs: IKeyValueMap)
		var scale: Number?
			get() = attrs.getTyped("attachment scale")
			set(value) = attrs.setNullable("attachment scale", value)
	}
	
	
	/**
	 * Projectile gravity in hu/s^2
	 */
	context(attrs: IKeyValueMap)
	var BaseProjectileAttributes.projectileGravity: Int?
		get() = attrs.getTyped("projectile gravity")
		set(value) = attrs.setNullable("projectile gravity", value)
	
	/**
	 * Grenades explode on impact with the world, similar to rockets
	 */
	context(attrs: IKeyValueMap)
	var GrenadeLauncherAttributes.grenadeExplodeOnImpact: Int?
		get() = attrs.getTyped("grenade explode on impact")
		set(value) = attrs.setNullable("grenade explode on impact", value)
	
	/**
	 * Projectile lifetime in seconds; deletes projectiles, does not cause explosions for explosive projectiles.
	 */
	context(attrs: IKeyValueMap)
	var BaseProjectileAttributes.projectileLifetime: Duration?
		get() = attrs.getTyped("projectile lifetime", DurationCodec)
		set(value) = attrs.setNullable("projectile lifetime", value, DurationCodec)
	
	/**
	 * The player is not solid to other players
	 */
	context(attrs: IKeyValueMap)
	var PlayerAttributes.notSolidToPlayers: Int?
		get() = attrs.getTyped("not solid to players")
		set(value) = attrs.setNullable("not solid to players", value)
	
	/**
	 * If set, the player takes this amount of damage per second, ignores uber, does not apply damage force
	 */
	context(attrs: IKeyValueMap)
	var PlayerAttributes.takeConstantDamage: Int?
		get() = attrs.getTyped("is suicide counter")
		set(value) = attrs.setNullable("is suicide counter", value)
	
	/**
	 * Always allow the player to continue taunting, even midair. The player cannot start a taunt in midair, but their taunts will not be interrupted by being launched or falling off a bot.
	 */
	context(attrs: IKeyValueMap)
	var PlayerAttributes.alwaysAllowTaunt: Int?
		get() = attrs.getTyped("always allow taunt")
		set(value) = attrs.setNullable("always allow taunt", value)
	
	/**
	 * Reflected projectile speed multiplier
	 */
	context(attrs: IKeyValueMap)
	var FlamethrowerAttributes.multReflectVelocity: Number?
		get() = attrs.getTyped("mult reflect velocity")
		set(value) = attrs.setNullable("mult reflect velocity", value)
	
	/**
	 * Use custom kill icon. Icons are defined in scripts/mod_textures.txt in tf_misc_dir.vpk
	 */
	context(attrs: IKeyValueMap)
	var WeaponBaseAttributes.customKillIcon: Any?
		get() = attrs.getTyped("custom kill icon")
		set(value) = attrs.setNullable("custom kill icon", value)
	
	/**
	 * If set to 1, the weapon cannot be upgraded, but the player can still use the upgrade station
	 */
	context(attrs: IKeyValueMap)
	var BaseEntityAttributes.cannotBeUpgraded: Boolean?
		get() = attrs.getTyped("cannot be upgraded")
		set(value) = attrs.setNullable("cannot be upgraded", value)
	
	/**
	 * Projectile cannot be deflected (such as by miniguns) or reflected (such as by flamethrowers). Short Circuit orb will still delete the projectile.
	 */
	context(attrs: IKeyValueMap)
	var BaseProjectileAttributes.projectileNoDeflect: Boolean?
		get() = attrs.getTyped("projectile no deflect")
		set(value) = attrs.setNullable("projectile no deflect", value)
	
	/**
	 * Player gravity multiplier when affected by the balloon head condition (TF_COND_BALLOON_HEAD). 0 is for regular gravity
	 */
	context(attrs: IKeyValueMap)
	var PlayerAttributes.playerGravityBallonHead: Number?
		get() = attrs.getTyped("player gravity ballon head")
		set(value) = attrs.setNullable("player gravity ballon head", value)
	
	/**
	 * Custom projectile hitbox size
	 */
	context(attrs: IKeyValueMap)
	var BaseProjectileAttributes.customProjectileSize: Number?
		get() = attrs.getTyped("custom projectile size")
		set(value) = attrs.setNullable("custom projectile size", value)
	
	
}