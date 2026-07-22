package btpos.source.vdfdsl.tf2.rafmod

import btpos.source.vdfdsl.modeling.IExtensibleSubtree.Companion.addField
import btpos.source.vdfdsl.modeling.IExtensibleSubtree.Serializers.flatListWithKey
import btpos.source.vdfdsl.tf2.rafmod.RafmodConstants.SIGSEGV
import btpos.source.vdfdsl.types.populators.WaveSpawnPopulator

abstract class RafmodWaveSpawnExtensions {
	companion object {
		@PublishedApi @JvmField internal val INSTANCE = object : RafmodWaveSpawnExtensions() {}
	}
	
	/**
	 * Lines displayed in chat when this wavespawn stops waiting for other wavespawns.
	 * 
	 * Example:
	 * ```kotlin
	 * startWaveMessages += "Wave start"
	 * ```
	 * 
	 * @see firstSpawnMessage
	 * @see lastSpawnMessage
	 * @see doneMessage
	 */
	var WaveSpawnPopulator.startWaveMessages: List<String> by addField("StartWaveMessage", conditional = SIGSEGV, serializer = flatListWithKey(), initialValue = ::listOf)
	
	/**
	 * Line displayed in chat when a bot is spawned for the first time.
	 * 
	 * Example:
	 * ```kotlin
	 * firstSpawnMessage = "First spawn"
	 * ```
	 * 
	 * @see startWaveMessages
	 * @see lastSpawnMessage
	 * @see doneMessage
	 */
	var WaveSpawnPopulator.firstSpawnMessage: String? by addField("FirstSpawnMessage", conditional = SIGSEGV)
	
	
	/**
	 * Line displayed in chat when the last bot in this subwave spawns.
	 * 
	 * Example:
	 * ```kotlin
	 * lastSpawnMessage = "Last spawn"
	 * ```
	 * 
	 * @see startWaveMessages
	 * @see firstSpawnMessage
	 * @see doneMessage
	 */
	var WaveSpawnPopulator.lastSpawnMessage: String? by addField("LastSpawnMessage", conditional = SIGSEGV)
	
	/**
	 * Chat message displayed when all bots in the subwave have been defeated.
	 * 
	 * Example:
	 * ```kotlin
	 * doneMessage = "Done"
	 * ```
	 * 
	 * @see startWaveMessages
	 * @see firstSpawnMessage
	 * @see lastSpawnMessage
	 */
	var WaveSpawnPopulator.doneMessage: String? by addField("DoneMessage", conditional = SIGSEGV)
}

@Suppress("UnusedReceiverParameter")
inline fun WaveSpawnPopulator.rafmod(scope: RafmodWaveSpawnExtensions.() -> Unit) {
	RafmodWaveSpawnExtensions.INSTANCE.scope()
}

