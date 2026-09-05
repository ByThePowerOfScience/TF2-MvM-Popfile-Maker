package btpos.source.vdfdsl.tf2.rafmod.bot

import btpos.source.vdfdsl.modeling.IExtensibleSubtree.Companion.addField
import btpos.source.vdfdsl.serialization.codecs.BinaryIntCodec
import btpos.source.vdfdsl.tf2.rafmod.RafmodConstants.SIGSEGV
import btpos.source.vdfdsl.tf2.rafmod.types.Sound
import btpos.source.vdfdsl.types.spawners.TFBotSpawner

/**
 * If true, this bot will not upgrade over time while carrying the bomb.
 */
val TFBotSpawner.noBombUpgrades by addField<Boolean>("NoBombUpgrades", conditional = SIGSEGV)

/**
 * Override the sound played when this bot takes damage.
 * 
 * Example:
 * ```kotlin
 * painSound = Sound("GoldPipe_MissionIntro.mp3", volume=70)
 * ```
 */
val TFBotSpawner.painSound by addField<Sound>("PainSound", conditional = SIGSEGV)

/**
 * Override the sound played when this bot dies.
 * 
 * Example:
 * ```kotlin
 * deathSound = Sound("GoldPipe_MissionIntro.mp3", volume=70)
 * ```
 */
val TFBotSpawner.deathSound by addField<Sound>("DeathSound", conditional = SIGSEGV)

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
val TFBotSpawner.desiredAttackRange by addField<Int>("DesiredAttackRange", conditional = SIGSEGV)


/**
 * If true, the bot will attempt to get behind its target similarly to how Spy-bots behave.
 *
 * This is a simple toggle that sets the default behavior.
 * To instead have the bot start doing this based on its distance to its target, see [moveBehindEnemyDistance].
 */
val TFBotSpawner.moveBehindEnemy by addField<Boolean>("MoveBehindEnemy", conditional = SIGSEGV, serializer = BinaryIntCodec::write)

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
val TFBotSpawner.moveBehindEnemyDistance by addField<Int>("MoveBehindEnemy", conditional = SIGSEGV)

