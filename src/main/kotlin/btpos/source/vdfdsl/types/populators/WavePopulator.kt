@file:Suppress("UNUSED")
package btpos.source.vdfdsl.types.populators

import btpos.source.vdfdsl.modeling.ExtensibleSubtreeImpl
import btpos.source.vdfdsl.modeling.IExtensibleSubtree.Companion.addField
import btpos.source.vdfdsl.modeling.IExtensibleSubtree.Companion.selfNamedList
import btpos.source.vdfdsl.modeling.IExtensibleSubtree_VDFRepresentable
import btpos.source.vdfdsl.types.specifics.OutputAction
import btpos.source.vdfdsl.utils.ReadOnlyConstant
import kotlin.properties.ReadOnlyProperty
import kotlin.reflect.KProperty

class WavePopulator(_subtree: IExtensibleSubtree_VDFRepresentable = ExtensibleSubtreeImpl()) : AbstractPopulator(_subtree) {
	override val _structIdentifier: String
		get() = "Wave"
	
	override fun copy() = WavePopulator(this.copyInternal())
	
	operator fun WaveSpawnPopulator.unaryPlus() {
		this@WavePopulator.waveSpawns += this@unaryPlus
	}
	
	
	var waveSpawns: List<WaveSpawnPopulator> by selfNamedList()
	
	var sound: String? by addField("Sound")
	
	var description: String? by addField("Description")
	
	var waitWhenDone: Number? by addField("WaitWhenDone")
	
	@Deprecated("According to sigsegv, doesn't do anything.")
	var checkpoint: Boolean? by addField("Checkpoint", serializer = { if (it) "yes" else "no" })
	
	/**
	 * The action that should be triggered once the bots start spawning.
	 *
	 * @see initWaveOutput
	 * @see OutputAction
	 */
	var startWaveOutput: OutputAction? by addField("StartWaveOutput")
	
	/**
	 * Define the action that should be triggered once the bots start spawning.
	 *
	 * @see initWaveOutput
	 * @see OutputAction
	 */
	fun startWaveOutput(configure: OutputAction.() -> Unit) {
		this.startWaveOutput = OutputAction().apply(configure)
	}
	
	/**
	 * The action that should be triggered when a wave is completed.
	 *
	 * @see OutputAction
	 */
	var doneOutput: OutputAction? by addField("DoneOutput")
	
	/**
	 * Define the action that should be triggered when a wave is completed.
	 *
	 * @see OutputAction
	 */
	fun doneOutput(configure: OutputAction.() -> Unit) {
		this.doneOutput = OutputAction().apply(configure)
	}
	
	/**
	 * The action that should be triggered when a wave is first started.
	 *
	 * @see startWaveOutput
	 * @see OutputAction
	 */
	var initWaveOutput: OutputAction? by addField("InitWaveOutput")
	
	/**
	 * Define the action that should be triggered when a wave is first started.
	 *
	 * @see startWaveOutput
	 * @see OutputAction
	 */
	fun initWaveOutput(configure: OutputAction.() -> Unit) {
		this.initWaveOutput = OutputAction().apply(configure)
	}
}

inline fun Populators.Wave(configure: WavePopulator.() -> Unit) = WavePopulator().apply(configure)
/**
 * Creates and adds a new Wave populator to the PopulationManager
 */
fun Wave(configure: WavePopulator.() -> Unit) = WavePopulator().apply(configure)


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




