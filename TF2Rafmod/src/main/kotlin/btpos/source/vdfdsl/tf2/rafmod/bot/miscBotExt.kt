package btpos.source.vdfdsl.tf2.rafmod.bot

import btpos.source.vdfdsl.modeling.IExtensibleSubtree.Companion.addField
import btpos.source.vdfdsl.serialization.codecs.BinaryIntCodec
import btpos.source.vdfdsl.tf2.rafmod.RafmodConstants.SIGSEGV
import btpos.source.vdfdsl.tf2.rafmod.types.Sound
import btpos.source.vdfdsl.types.spawners.TFBotSpawner

/**
 * If true, this bot will not upgrade over time while carrying the bomb.
 */
var TFBotSpawner.noBombUpgrades: Boolean? by addField("NoBombUpgrades", conditional = SIGSEGV)

/**
 * Override the sound played when this bot takes damage.
 * 
 * Example:
 * ```kotlin
 * painSound = Sound("GoldPipe_MissionIntro.mp3", volume=70)
 * ```
 */
var TFBotSpawner.painSound: Sound? by addField("PainSound", conditional = SIGSEGV)

/**
 * Override the sound played when this bot dies.
 * 
 * Example:
 * ```kotlin
 * deathSound = Sound("GoldPipe_MissionIntro.mp3", volume=70)
 * ```
 */
var TFBotSpawner.deathSound: Sound? by addField("DeathSound", conditional = SIGSEGV)

/**
 * How close to the target the bot should want to move when trying to attack.
 *
 * For melee weapons, default is `100`.
 *
 * For other weapons except sniper rifles, default is `500`.
 * 
 * Example:
 * ```kotlin
 * TFBot {
 *     `class` = Scout
 *     desiredAttackRange = 50 // Bot tries to keep its target within 50 units to get a perfect meatshot
 * }
 * ```
 */
var TFBotSpawner.desiredAttackRange: Int? by addField("DesiredAttackRange", conditional = SIGSEGV)


/**
 * If true, the bot will attempt to get behind its target similarly to how Spy-bots behave.
 *
 * This is a simple toggle that sets the default behavior.
 * To instead have the bot start doing this based on its distance to its target, see [moveBehindEnemyDistance].
 */
var TFBotSpawner.moveBehindEnemy: Boolean? by addField("MoveBehindEnemy", conditional = SIGSEGV, serializer = BinaryIntCodec::write)

/**
 * When the bot gets within this distance from its target, it will attempt to strafe out of its target's line-of-sight.
 *
 * Example:
 * ```kotlin
 * moveBehindEnemyDistance = 12
 * ```
 *
 * This is a distance-based way to trigger this bot behavior.
 * To make this the default behavior regardless of distance, see [moveBehindEnemy].
 */
var TFBotSpawner.moveBehindEnemyDistance: Int? by addField("MoveBehindEnemy", conditional = SIGSEGV)

