@file:Suppress("UnusedReceiverParameter", "unused")

package btpos.source.vdfdsl.tf2.rafmod.attributes

import btpos.source.vdfdsl.tf2.itemattributes.*
import btpos.source.vdfdsl.tf2.itemattributes.impl.IBlockScoped
import btpos.source.vdfdsl.tf2.rafmod.attributes.RafmodCustomAttributes.canFriendlyFire
import btpos.source.vdfdsl.tf2.rafmod.attributes.RafmodCustomAttributes.projectileAcceleration
import btpos.source.vdfdsl.tf2.rafmod.attributes.RafmodCustomAttributes.projectileAccelerationStartTime
import btpos.source.vdfdsl.tf2.rafmod.attributes.RafmodCustomAttributes.projectileAccelerationTime
import btpos.source.vdfdsl.tf2.rafmod.attributes.RafmodCustomAttributes.receiveFriendlyFire
import btpos.source.vdfdsl.tf2.rafmod.data.Rot3
import btpos.source.vdfdsl.tf2.rafmod.data.Vec3
import btpos.source.vdfdsl.tf2.rafmod.types.Sound
import btpos.source.vdfdsl.utils.toSeconds
import java.awt.Color
import kotlin.time.Duration

object RafmodCustomAttributes {
	/**
	 * Turns the victim ragdoll into an ice statue, like [freezeBackstabVictim][btpos.source.vdfdsl.tf2.itemattributes.WeaponBaseAttributes.RagdollsAttributes.freezeBackstabVictim] but for all weapons.
	 */
	val WeaponBaseAttributes.RagdollsAttributes.setTurnToIce: ItemAttributeNamed<Boolean> by ItemAttributeNamed<Boolean>("set turn to ice")
	
	val CompoundBowAttributes.arrowMasteryLevel: ItemAttributeNamed<Int> by ItemAttributeNamed("arrow mastery")
	
	/**
	 * If set to 1, the player can move teleporters with double tapped movement keys. Does not work.
	 */
	val PlayerAttributes.BuildingsAttributes.TeleporterAttributes.abilityDoubletapTeleport: ItemAttributeNamed<Boolean> by ItemAttributeNamed("ability doubletap teleport")
	
	/**
	 * A worse version of damage piercing since it only ignores the Battalion's Backup's 35% damage reduction. Does not work?
	 */
	val WeaponBaseAttributes.DamageAttributes.modIgnoreResistsAbsorbs: ItemAttributeNamed<Boolean> by ItemAttributeNamed("mod ignore resists absorbs")
	
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
		val heatSeekPower: ItemAttributeNamed<Number> by ItemAttributeNamed("mod projectile heat seek power")
		
		/**
		 * The weapon's max error in aim in degrees. If no target is within this degree, the projectile will not home.
		 */
		val maxError: ItemAttributeNamed<Number> by ItemAttributeNamed("mod projectile heat aim error")
		
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
		val aimTime: ItemAttributeNamed<Duration> by ItemAttributeNamed("mod projectile heat aim time", Duration::toSeconds)
		
		/**
		 * Disables movement prediction for homing projectiles. Might be useful for very slow projectiles.
		 */
		val noPredictTargetSpeed: ItemAttributeNamed<Boolean> by ItemAttributeNamed("mod projectile heat no predict target speed")
		
		/**
		 * Homing projectiles will follow the crosshair instead of enemies.
		 */
		val followCrosshair: ItemAttributeNamed<Boolean> by ItemAttributeNamed("mod projectile heat follow crosshair")
		
		/**
		 * Time before the projectile starts homing.
		 *
		 * Example:
		 * ```kotlin
		 * aimStartTime = 5.minutes
		 * ```
		 */
		val aimStartTime: ItemAttributeNamed<Duration> by ItemAttributeNamed("mod projectile heat aim start time", Duration::toSeconds)
	}
	
	
	/**
	 * On building hit: Disable for x seconds
	 */
	val WeaponBaseAttributes.OnHitAttributes.disableBuildings: ItemAttributeNamed<Duration> by ItemAttributeNamed("disable buildings on hit", Duration::toSeconds)
	
	/**
	 * Regenerates Ullapool Caber after a hit.
	 */
	val StickBombAttributes.regenerateStickbomb: ItemAttributeNamed<Boolean> by ItemAttributeNamed("regenerate stickbomb")
	
	/**
	 * Melee "smack time" multiplier; time between pressing the fire button and the attack being dealt (0.2s default)
	 */
	val BaseMeleeAttributes.FiringAttributes.multSmackTime: ItemAttributeNamed<Number> by ItemAttributeNamed("mult smack time")
	
	/**
	 * Custom item model name
	 */
	val WeaponBaseAttributes.MetaAttributes.customItemModel: ItemAttributeNamed<String> by ItemAttributeNamed("custom item model")
	
	/**
	 * Custom weapon fire sound. Does not work for the weapon owner
	 */
	val WeaponBaseAttributes.FiringAttributes.customWeaponFireSound: ItemAttributeNamed<Sound> by ItemAttributeNamed("custom weapon fire sound")
	
	/**
	 * Bullets explode in x radius on hit (147 is rocket launcher radius)
	 */
	val BaseGunAttributes.ProjectilesAttributes.BulletsAttributes.explosiveBullets: ItemAttributeNamed<Int> by ItemAttributeNamed("explosive bullets")
	
	/**
	 * Projectile model scale multipier
	 */
	val BaseProjectileAttributes.multProjectileScale: ItemAttributeNamed<Number> by ItemAttributeNamed("mult projectile scale")
	
	/**
	 * Fire x projectiles at once. Note: Add [btpos.source.vdfdsl.tf2.rafmod.attributes.PotatoCustomAttributes.ignoresOtherProjectiles] to Rocket Launchers so that rockets don't collide with each other.
	 */
	val BaseProjectileAttributes.multProjectileCount: ItemAttributeNamed<Int> by ItemAttributeNamed("mult projectile count")
	
	/**
	 * Projectile trail particle name. Prefix the particle name with ~ to remove the original particle.
	 */
	val BaseProjectileAttributes.projectileTrailParticle: ItemAttributeNamed<String> by ItemAttributeNamed("projectile trail particle")
	
	/**
	 * Explosion particle name
	 */
	val BaseProjectileAttributes.explosionParticle: ItemAttributeNamed<String> by ItemAttributeNamed("explosion particle")
	
	/**
	 * Restores the Sydney Sleeper's old "Jarate explosion" on headshot and fully-charged bodyshot.
	 */
	val SniperRifleAttributes.radiusSleeper: ItemAttributeNamed<Boolean> by ItemAttributeNamed("radius sleeper")
	
	/**
	 * Bots with this attribute cannot be affected by the Sapper
	 */
	val MvMBotAttributes.cannotBeSapped: ItemAttributeNamed<Boolean> by ItemAttributeNamed("cannot be sapped")
	
	/**
	 * Item tint color
	 */
	val EconEntityAttributes.MetaAttributes.itemColorRgb: ItemAttributeNamed<Color> by ItemAttributeNamed("item color rgb", ColorEncoder)
	
	/**
	 * Turns item invisible
	 */
	val EconEntityAttributes.MetaAttributes.isInvisible: ItemAttributeNamed<Boolean> by ItemAttributeNamed("is invisible")
	
	/**
	 * If set to 1, cannot taunt
	 */
	val PlayerAttributes.TauntingAttributes.cannotTaunt: ItemAttributeNamed<Boolean> by ItemAttributeNamed("cannot taunt")
	
	/**
	 * Projectile acceleration in hu/s^2
	 *
	 * @see projectileAccelerationTime
	 * @see projectileAccelerationStartTime
	 */
	val BaseProjectileAttributes.projectileAcceleration: ItemAttributeNamed<Number> by ItemAttributeNamed("projectile acceleration")
	
	/**
	 * How long the projectile should accelerate with the acceleration defined in [projectileAcceleration]
	 *
	 * @see projectileAccelerationStartTime
	 */
	val BaseProjectileAttributes.projectileAccelerationTime: ItemAttributeNamed<Duration> by ItemAttributeNamed("projectile acceleration time", Duration::toSeconds)
	
	/**
	 * Time before projectile starts accelerating with the acceleration defined in [projectileAcceleration].
	 *
	 * @see projectileAccelerationTime
	 */
	val BaseProjectileAttributes.projectileAccelerationStartTime: ItemAttributeNamed<Duration> by ItemAttributeNamed("projectile acceleration start time", Duration::toSeconds)
	
	/**
	 * The player is counted as a miniboss. Sappers will not fully stun, backstabs deal set damage, will not receive bomb buffs.
	 */
	val PlayerAttributes.isMiniboss: ItemAttributeNamed<Boolean> by ItemAttributeNamed("is miniboss")
	
	/**
	 * Player's model scale. 1.75 is used for giant bots.
	 */
	val PlayerAttributes.MetaAttributes.PlayerAttributes.modelScale: ItemAttributeNamed<Number> by ItemAttributeNamed("model scale")
	
	/**
	 * If set to 1, the player cannot use upgrade stations
	 */
	val PlayerAttributes.MetaAttributes.GameplayAttributes.cannotUpgrade: ItemAttributeNamed<Boolean> by ItemAttributeNamed("cannot upgrade")
	
	/**
	 * Minimal respawn time
	 */
	val PlayerAttributes.MetaAttributes.GameplayAttributes.minRespawnTime: ItemAttributeNamed<Duration> by ItemAttributeNamed("min respawn time", Duration::toSeconds)
	
	/**
	 * Weapon always crits. Less reliable with higher ping.
	 */
	val WeaponBaseAttributes.alwaysCrit: ItemAttributeNamed<Boolean> by ItemAttributeNamed("always crit")
	
	/**
	 * Level 3 Sentry rocket fire rate
	 */
	val PlayerAttributes.BuildingsAttributes.SentryGunAttributes.multRocketFireRate: ItemAttributeNamed<Number> by ItemAttributeNamed("mult firerocket rate")
	
	/**
	 * Building max level limit
	 */
	val PlayerAttributes.BuildingsAttributes.buildingMaxLevel: ItemAttributeNamed<Int> by ItemAttributeNamed("building max level")
	
	/**
	 * Allows for faster sentry fire rate, up to 66 shots per second. Effectively fixes sentry fire rate upgrades by not simulating it every 3 ticks, but every tick.
	 */
	val PlayerAttributes.BuildingsAttributes.SentryGunAttributes.sentryRapidFire: ItemAttributeNamed<Int> by ItemAttributeNamed("sentry rapid fire")
	
	/**
	 * Dealing damage with weapon does not increase crit rate
	 */
	val WeaponBaseAttributes.dontCountDamageTowardsCritRate: ItemAttributeNamed<Int> by ItemAttributeNamed("dont count damage towards crit rate")
	
	/**
	 * Sets the weapon's maximum damage rampup to 20% (similar to Stickybomb Launchers)
	 */
	val WeaponBaseAttributes.reducedDamageRampup: ItemAttributeNamed<Int> by ItemAttributeNamed("reduced damage rampup")
	
	/**
	 * Sets the weapon's maximum damage rampup to 50% (similar to Shotguns)
	 */
	val WeaponBaseAttributes.noReducedDamageRampup: ItemAttributeNamed<Int> by ItemAttributeNamed("no reduced damage rampup")
	
	/**
	 * Forces the weapon to have damage rampup and falloff
	 */
	val WeaponBaseAttributes.forceDamageFalloff: ItemAttributeNamed<Int> by ItemAttributeNamed("force damage falloff")
	
	/**
	 * Weapon can headshot. Hitscan only; inconsistent on multi-pellet weapons such as Shotguns.
	 */
	val BaseGunAttributes.canHeadshot: ItemAttributeNamed<Int> by ItemAttributeNamed("can headshot")
	
	/**
	 * Building tint color
	 */
	val PlayerAttributes.BuildingsAttributes.buildingColorRgb: ItemAttributeNamed<Color> by ItemAttributeNamed("building color rgb", ColorEncoder)
	
	/**
	 * Building scale. Values above 1.17 make it difficult for players to build on uneven ground
	 */
	val PlayerAttributes.BuildingsAttributes.buildingScale: ItemAttributeNamed<Number> by ItemAttributeNamed("building scale")
	
	/**
	 * Stun and slow multiplier. 0 to be fully stun/slow immune
	 */
	val PlayerAttributes.ResistanceAttributes.multStunResistance: ItemAttributeNamed<Number> by ItemAttributeNamed("mult stun resistance")
	
	/**
	 * If set to 1, the player can deal friendly fire damage
	 *
	 * @see receiveFriendlyFire
	 */
	val PlayerAttributes.DamageAttributes.canFriendlyFire: ItemAttributeNamed<Boolean> by ItemAttributeNamed("allow friendly fire")
	
	/**
	 * If set to 1, the player can receive friendly fire from teammates
	 *
	 * @see canFriendlyFire
	 */
	val PlayerAttributes.ResistanceAttributes.receiveFriendlyFire: ItemAttributeNamed<Boolean> by ItemAttributeNamed("receive friendly fire")
	
	/**
	 * Weapon cannot headshot
	 */
	val WeaponBaseAttributes.CritsAttributes.cannotHeadshot: ItemAttributeNamed<Int> by ItemAttributeNamed("cannot headshot")
	
	/**
	 * Crit damage multiplier
	 */
	val WeaponBaseAttributes.CritsAttributes.multCritDmg: ItemAttributeNamed<Number> by ItemAttributeNamed("mult crit dmg")
	
	/**
	 * If set to 1, the player cannot be headshot. Only blocks hitscan headshots
	 */
	val PlayerAttributes.ResistanceAttributes.cannotBeHeadshot: ItemAttributeNamed<Boolean> by ItemAttributeNamed("cannot be headshot")
	
	/**
	 * Configure how this item's model is attached to the entity holding it.
	 */
	val EconEntityAttributes.MetaAttributes.itemModelAttachmentConfiguration get() = ModelAttachments
	
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
		val name: ItemAttributeNamed<String> by ItemAttributeNamed("attachment name")
		
		/**
		 * Item offset from the attachment origin
		 */
		val offset: ItemAttributeNamed<Vec3> by ItemAttributeNamed("attachment offset")
		
		/**
		 * Rotation for attached items
		 */
		val rotation: ItemAttributeNamed<Rot3> by ItemAttributeNamed("attachment angles")
		
		/**
		 * Model scale for attached items
		 */
		val scale: ItemAttributeNamed<Number> by ItemAttributeNamed("attachment scale")
	}
	
	
	/**
	 * Projectile gravity in hu/s^2
	 */
	val BaseProjectileAttributes.projectileGravity: ItemAttributeNamed<Number> by ItemAttributeNamed("projectile gravity")
	
	/**
	 * Grenades explode on impact with the world, similar to rockets
	 */
	val GrenadeLauncherAttributes.grenadeExplodeOnImpact: ItemAttributeNamed<Boolean> by ItemAttributeNamed("grenade explode on impact")
	
	/**
	 * Projectile lifetime. After this amount of time has elapsed, deletes projectiles without causing explosions for explosive projectiles.
	 */
	val BaseProjectileAttributes.projectileLifetime: ItemAttributeNamed<Duration> by ItemAttributeNamed("projectile lifetime", Duration::toSeconds)
	
	/**
	 * The player is not solid to other players
	 */
	val PlayerAttributes.MovementAttributes.notSolidToPlayers: ItemAttributeNamed<Int> by ItemAttributeNamed("not solid to players")
	
	/**
	 * AKA "suicide counter"
	 *
	 * If set, the player takes this amount of damage per second, ignores uber, does not apply damage force
	 */
	val PlayerAttributes.takeConstantDamage: ItemAttributeNamed<Int> by ItemAttributeNamed("is suicide counter")
	
	/**
	 * Always allow the player to continue taunting, even midair. The player cannot start a taunt in midair, but their taunts will not be interrupted by being launched or falling off a bot.
	 */
	val PlayerAttributes.TauntingAttributes.alwaysAllowTaunt: ItemAttributeNamed<Int> by ItemAttributeNamed("always allow taunt")
	
	/**
	 * Reflected projectile speed multiplier
	 */
	val FlamethrowerAttributes.AirblastAttributes.multReflectVelocity: ItemAttributeNamed<Number> by ItemAttributeNamed("mult reflect velocity")
	
	/**
	 * Use custom kill icon. Icons are defined in scripts/mod_textures.txt in tf_misc_dir.vpk
	 */
	val WeaponBaseAttributes.MetaAttributes.customKillIcon: ItemAttributeNamed<String> by ItemAttributeNamed("custom kill icon")
	
	/**
	 * If set to 1, the weapon cannot be upgraded, but the player can still use the upgrade station
	 */
	val EconEntityAttributes.MetaAttributes.cannotBeUpgraded: ItemAttributeNamed<Boolean> by ItemAttributeNamed("cannot be upgraded")
	
	/**
	 * Projectile cannot be deflected (such as by miniguns) or reflected (such as by flamethrowers). Short Circuit orb will still delete the projectile.
	 */
	val BaseProjectileAttributes.cannotBeDeflectedOrReflected: ItemAttributeNamed<Boolean> by ItemAttributeNamed("projectile no deflect")
	
	/**
	 * Player gravity multiplier when affected by the balloon head condition (TF_COND_BALLOON_HEAD). 0 is for regular gravity
	 */
	val PlayerAttributes.playerGravityBalloonHead: ItemAttributeNamed<Number> by ItemAttributeNamed("player gravity ballon head")
	
	/**
	 * Custom projectile hitbox size
	 */
	val BaseProjectileAttributes.customProjectileSize: ItemAttributeNamed<Number> by ItemAttributeNamed("custom projectile size")
}