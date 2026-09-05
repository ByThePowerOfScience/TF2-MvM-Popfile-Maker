package btpos.source.vdfdsl.tf2.rafmod.waveschedule

import btpos.source.vdfdsl.modeling.IExtensibleSubtree
import btpos.source.vdfdsl.modeling.IExtensibleSubtree.Companion.addField
import btpos.source.vdfdsl.tf2.itemattributes.impl.IBlockScoped
import btpos.source.vdfdsl.tf2.rafmod.RafmodConstants.SIGSEGV
import btpos.source.vdfdsl.tf2.rafmod.RafmodSerializers
import btpos.source.vdfdsl.tf2.rafmod.tftypes.TFTeam
import btpos.source.vdfdsl.types.WaveSchedule
import kotlin.time.Duration

abstract class RafmodReverseMvM : IBlockScoped {
	companion object {
		@PublishedApi @JvmField internal val INSTANCE = object : RafmodReverseMvM() {}
	}
	
	/**
	 * If true, the player team wins if the bomb is delivered to the hatch.
	 */
	val enable by addField<Boolean>("ReverseWinConditions", conditional = SIGSEGV)
	
	/**
	 * If `TFTeam.BLU`, only the BLU team can pick up money instead of the RED team.
	 */
	val teamThatCanPickUpMoney by addField<TFTeam>("SetCreditTeam", conditional = SIGSEGV, serializer = RafmodSerializers.TFTEAM_NUMBER)
	
	
	/**
	 * If true, blu humans can capture the flag/bomb.
	 */
	val canHumansCaptureBomb by addField<Boolean>("BluHumanFlagCapture", conditional = SIGSEGV)
	
	/**
	 * If true, BLU players can pick up the bomb.
	 */
	val canHumansPickupBomb by addField<Boolean>("BluHumanFlagPickup", conditional = SIGSEGV)
	
	/**
	 * If true, BLU players have infinite ammo. (Default: true)
	 */
	val bluHasInfiniteAmmo by addField<Boolean>("BluHumanInfiniteAmmo", conditional = SIGSEGV)
	
	/**
	 * If true, BLU players have infinite cloak. (Default: true)
	 */
	val bluHasInfiniteCloak by addField<Boolean>("BluHumanInfiniteCloak", conditional = SIGSEGV)
	
	/**
	 * Sets the maximum number of players that can exist on the BLU team at any given time.
	 *
	 * Example:
	 * ```kotlin
	 * maxAllowedOnBlu = 4
	 * ```
	 */
	val maxAllowedOnBlu by addField<Int>("AllowJoinTeamBlueMax", conditional = SIGSEGV)
	
	/**
	 * If true, human players can join the BLU team.
	 */
	val canPlayersJoinBluTeam by addField<Boolean>("AllowJoinTeamBlue", conditional = SIGSEGV)
	
	/**
	 * If true, human players are forcibly assigned to BLU upon joining.
	 *
	 * Also sets [teamThatCanPickUpMoney] to true and, if not already set, sets [maxAllowedOnBlu] to 6.
	 */
	val playersMustJoinBlu by addField<Boolean>("HumansMustJoinTeam", conditional = SIGSEGV)
	
	
	/**
	 * If true, BLU players use robot models, regardless of if they are human or not.
	 */
	val bluPlayersUseRobotModels by addField<Boolean>("BluPlayersAreRobots", conditional = SIGSEGV)
	
	/**
	 * If true, reanimators will drop when a BLU player dies, allowing them to be revived by a Medic. (Default: false)
	 */
	val allowBluPlayerReanimators by addField<Boolean>("AllowBluPlayerReanimators", conditional = SIGSEGV)
	
	/**
	 * If true, removes the 1000 HU/s velocity limit for BLU team members. (Default: false)
	 */
	val removeBluVelocityLimit by addField<Boolean>("RemoveBluVelocityLimit", conditional = SIGSEGV)
	
	
	/**
	 * If true, BLU players can shoot while in spawn. (Default: false)
	 */
	val canBluShootInSpawn by addField<Boolean>("BluHumanSpawnNoShoot", conditional = SIGSEGV, serializer = BOOL_SER_INVERT)
	
	/**
	 * If true, BLU players are invincible in spawn. (Default: true)
	 */
	val bluHumanSpawnProtection by addField<Boolean>("BluHumanSpawnProtection", conditional = SIGSEGV)
	
	/**
	 * If true, disables robot footsteps for BLU humans (default: false)
	 */
	val noBluHumanFootsteps by addField<Boolean>("NoBluHumanFootsteps", conditional = SIGSEGV)
	
	/**
	 * When [Reverse MvM win conditions are enabled][enable], enemy bots will be spawned on this team instead of BLU. (Default: [TFTeam.RED])
	 *
	 * Example:
	 * ```kotlin
	 * enemyTeamForReverse = TFTeam.RED
	 * ```
	 */
	val enemyTeamForReverse by addField<TFTeam>("EnemyTeamForReverse", conditional = SIGSEGV, serializer = RafmodSerializers.TFTEAM_NAME)
	
	
	
	/**
	 * How many seconds the "stock ubercharge" invincibility effect should be applied to BLU entities exiting a BLU teleporter. (Default: 5)
	 *
	 * Example:
	 * ```kotlin
	 * botPostTeleportUberDuration = 5.seconds
	 * ```
	 */
	val botPostTeleportUberDuration by addField<Duration>("BotTeleportUberDuration", conditional = SIGSEGV, serializer = IExtensibleSubtree.Serializers.durationInSeconds())
	
	/**
	 * If true, humans should be teleported to an Engineer-bot's teleporter when spawning instead of their default spawn location. (Default: false)
	 */
	val spawnOnBotTeleporter by addField<Boolean>("BluHumanTeleportOnSpawn", conditional = SIGSEGV)
	
	/**
	 * If true, player-built teleporters teleport players and robots on spawn.
	 */
	val spawnOnHumanTeleporter by addField<Boolean>("BluHumanBotTeleporter", conditional = SIGSEGV)
	
	
}