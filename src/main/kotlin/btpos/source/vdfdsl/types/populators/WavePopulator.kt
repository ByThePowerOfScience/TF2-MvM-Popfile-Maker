package btpos.source.vdfdsl.types.populators

import btpos.source.vdfdsl.modeling.ExtensibleSubtreeImpl
import btpos.source.vdfdsl.modeling.IExtensibleSubtree.Companion.addField
import btpos.source.vdfdsl.modeling.IExtensibleSubtree.Companion.multiStruct
import btpos.source.vdfdsl.types.PopulationManager
import btpos.source.vdfdsl.types.populators
import btpos.source.vdfdsl.types.specifics.OutputAction
import btpos.source.vdfdsl.utils.ReadOnlyConstant
import kotlin.properties.ReadOnlyProperty
import kotlin.reflect.KProperty

class WavePopulator(_subtree: ExtensibleSubtreeImpl = ExtensibleSubtreeImpl()) : Populator(_subtree) {
	override val _structIdentifier: String
		get() = "Wave"
	
	override fun copy() = WavePopulator(this.copyInternal())
}

inline fun Populator.Companion.Wave(configure: WavePopulator.() -> Unit) = WavePopulator().apply(configure)
/**
 * Creates and adds a new Wave populator to the PopulationManager
 */
fun PopulationManager.Wave(configure: WavePopulator.() -> Unit) = WavePopulator().apply(configure).also {
	this.populators += it
}

val WavePopulator.waveSpawn: MutableList<WaveSpawnPopulator> by multiStruct()

/**
 * Create a new subwave with the given name and implicitly add it to this wave.
 */
inline fun WavePopulator.WaveSpawn(name: String? = null, configure: WaveSpawnPopulator.() -> Unit) = WaveSpawnPopulator()
	.also { it.name = name }
	.apply(configure)
	.also { this.waveSpawn += it }

/**
 * Create a wave spawn with the name of this property.
 *
 * Example:
 * ```kotlin
 * fun myWave() = Wave {
 *      val subwave_1 by WaveSpawn { // Implicitly sets name to "subwave_1"
 *          // ...
 *      }
 * }
 * ```
 */
operator fun WaveSpawnPopulator.provideDelegate(thisRef: Any?, prop: KProperty<*>): ReadOnlyProperty<Any?, WaveSpawnPopulator> {
	this.name = prop.name
	return ReadOnlyConstant(this)
}

var WavePopulator.sound: String? by addField("Sound")

var WavePopulator.description: String? by addField("Description")

var WavePopulator.waitWhenDone: Number? by addField("WaitWhenDone")

@Deprecated("Apparently doesn't do anything?")
var WavePopulator.checkpoint: Boolean? by addField("Checkpoint")

/**
 * The action that should be triggered at the start of a wave.
 * 
 * @see OutputAction
 */
var WavePopulator.startWaveOutput: OutputAction? by addField("StartWaveOutput")

/**
 * Define the action that should be triggered at the start of a wave.
 * 
 * @see OutputAction
 */
inline fun WavePopulator.startWaveOutput(configure: OutputAction.() -> Unit) {
	this.startWaveOutput = OutputAction().apply(configure)
}

/**
 * The action that should be triggered when a wave is completed.
 *
 * @see OutputAction
 */
var WavePopulator.doneOutput: OutputAction? by addField("DoneOutput")

/**
 * Define the action that should be triggered when a wave is completed.
 *
 * @see OutputAction
 */
inline fun WavePopulator.doneOutput(configure: OutputAction.() -> Unit) {
	this.doneOutput = OutputAction().apply(configure)
}

/**
 * The action that should be triggered when a wave is TODO
 *
 * @see OutputAction
 */
var WavePopulator.initWaveOutput: OutputAction? by addField("InitWaveOutput")

/**
 * Define the action that should be triggered when a wave is TODO
 *
 * @see OutputAction
 */
inline fun WavePopulator.initWaveOutput(configure: OutputAction.() -> Unit) {
	this.initWaveOutput = OutputAction().apply(configure)
}