package btpos.source.vdfdsl.tf2.rafmod.waveschedule

import btpos.source.vdfdsl.modeling.IExtensibleSubtree.Companion.addField
import btpos.source.vdfdsl.modeling.IExtensibleSubtree.Serializers.durationInSeconds
import btpos.source.vdfdsl.tf2.rafmod.RafmodConstants.SIGSEGV
import btpos.source.vdfdsl.types.WaveSchedule
import kotlin.time.Duration

abstract class RafmodTeleporters {
	companion object {
		@PublishedApi @JvmField internal val INSTANCE = object : RafmodTeleporters() {}
	}
	
	/**
	 * How long uber should last for robots exiting an Engineer-bot's teleporter. (Default: 5 seconds)
	 *
	 * Example:
	 * ```kotlin
	 * botTeleportUberDuration = 2.seconds
	 * ```
	 */
	open var WaveSchedule.botTeleportUberDuration: Duration? by addField("BotTeleportUberDuration", conditional = SIGSEGV, serializer = durationInSeconds())
	
	/**
	 * If true, robots can use players' teleporter entrances. (Default: true)
	 */
	open var WaveSchedule.canBotsUsePlayerTeleporters: Boolean? by addField("BotsUsePlayerTeleporters", conditional = SIGSEGV)
}