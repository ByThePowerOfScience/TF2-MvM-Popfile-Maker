package btpos.source.vdfdsl.tf2.rafmod.waveschedule

import btpos.source.vdfdsl.modeling.IExtensibleSubtree
import btpos.source.vdfdsl.modeling.IExtensibleSubtree.Companion.addField
import btpos.source.vdfdsl.serialization.codecs.BinaryIntCodec
import btpos.source.vdfdsl.tf2.rafmod.RafmodConstants.SIGSEGV
import btpos.source.vdfdsl.tf2.rafmod.RafmodSerializers
import btpos.source.vdfdsl.tf2.rafmod.tftypes.TFTeam
import btpos.source.vdfdsl.types.WaveSchedule
import kotlin.time.Duration

abstract class RafmodReverseMvM {
	companion object {
		@PublishedApi @JvmField internal val INSTANCE = object : RafmodReverseMvM() {}
	}
	
	/**
	 * If true, the player team wins if the bomb is delivered to the hatch.
	 */
	open var WaveSchedule.enable: Boolean? by addField("ReverseWinConditions", conditional = SIGSEGV, serializer = BinaryIntCodec::write)
	
	/**
	 * If `TFTeam.BLU`, only the BLU team can pick up money instead of the RED team.
	 */
	open var WaveSchedule.teamThatCanPickUpMoney: TFTeam? by addField("SetCreditTeam", conditional = SIGSEGV, serializer = RafmodSerializers.TFTEAM_NUMBER)
	
	
	/**
	 * If true, blu humans can capture the flag/bomb.
	 */
	open var WaveSchedule.canHumansCaptureBomb: Boolean? by addField("BluHumanFlagCapture", conditional = SIGSEGV, serializer = BinaryIntCodec::write)
	
	/**
	 * If true, BLU players can pick up the bomb.
	 */
	open var WaveSchedule.canHumansPickupBomb: Boolean? by addField("BluHumanFlagPickup", conditional = SIGSEGV, serializer = BinaryIntCodec::write)
	
	/**
	 * If true, BLU players have infinite ammo. (Default: true)
	 */
	open var WaveSchedule.bluHasInfiniteAmmo: Boolean? by addField("BluHumanInfiniteAmmo", conditional = SIGSEGV, serializer = BinaryIntCodec::write)
	
	/**
	 * If true, BLU players have infinite cloak. (Default: true)
	 */
	open var WaveSchedule.bluHasInfiniteCloak: Boolean? by addField("BluHumanInfiniteCloak", conditional = SIGSEGV, serializer = BinaryIntCodec::write)
	
	/**
	 * Sets the maximum number of players that can exist on the BLU team at any given time.
	 *
	 * Example:
	 * ```kotlin
	 * maxAllowedOnBlu = 4
	 * ```
	 */
	open var WaveSchedule.maxAllowedOnBlu: Int? by addField("AllowJoinTeamBlueMax", conditional = SIGSEGV)
	
	/**
	 * If true, human players can join the BLU team.
	 */
	open var WaveSchedule.canPlayersJoinBluTeam: Boolean? by addField("AllowJoinTeamBlue", conditional = SIGSEGV, serializer = BinaryIntCodec::write)
	
	/**
	 * If true, human players are forcibly assigned to BLU upon joining.
	 *
	 * Also sets [teamThatCanPickUpMoney] to true and, if not already set, sets [maxAllowedOnBlu] to 6.
	 */
	open var WaveSchedule.playersMustJoinBlu: Boolean? by addField("HumansMustJoinTeam", conditional = SIGSEGV, serializer = BinaryIntCodec::write)
	
	
	/**
	 * If true, BLU players use robot models, regardless of if they are human or not.
	 */
	open var WaveSchedule.bluPlayersUseRobotModels: Boolean? by addField("BluPlayersAreRobots", conditional = SIGSEGV, serializer = BinaryIntCodec::write)
	
	/**
	 * How many seconds the "stock ubercharge" invincibility effect should be applied to BLU entities exiting a BLU teleporter. (Default: 5)
	 *
	 * Example:
	 * ```kotlin
	 * botPostTeleportUberDuration = 5.seconds
	 * ```
	 */
	open var WaveSchedule.botPostTeleportUberDuration: Duration? by addField("BotTeleportUberDuration", conditional = SIGSEGV, serializer = IExtensibleSubtree.Serializers.durationInSeconds())
	
	/**
	 * If true, humans should be teleported to an Engineer-bot's teleporter when spawning instead of their default spawn location. (Default: false)
	 */
	open var WaveSchedule.spawnOnBotTeleporter: Boolean? by addField("BluHumanTeleportOnSpawn", conditional = SIGSEGV, serializer = BinaryIntCodec::write)
	
	/**
	 * If true, player-built teleporters teleport players and robots on spawn.
	 */
	open var WaveSchedule.spawnOnHumanTeleporter: Boolean? by addField("BluHumanBotTeleporter", conditional = SIGSEGV, serializer = BinaryIntCodec::write)
	
	
}