@file:Suppress("UNUSED")
package btpos.source.vdfdsl.types.populators

import btpos.source.vdfdsl.codegen.Codegen
import btpos.source.vdfdsl.modeling.ExtensibleSubtreeImpl
import btpos.source.vdfdsl.modeling.IExtensibleSubtree
import btpos.source.vdfdsl.modeling.IExtensibleSubtree.Companion.addField
import btpos.source.vdfdsl.modeling.IExtensibleSubtree.Companion.selfNamedList
import btpos.source.vdfdsl.modeling.IExtensibleSubtree.Serializers.map
import btpos.source.vdfdsl.modeling.IExtensibleSubtree_VDFRepresentable
import btpos.source.vdfdsl.types.specifics.OutputAction
import btpos.source.vdfdsl.util.ReadOnlyConstant
import kotlin.properties.ReadOnlyProperty
import kotlin.reflect.KProperty

class WavePopulator(_subtree: IExtensibleSubtree_VDFRepresentable = ExtensibleSubtreeImpl()) : AbstractPopulator(_subtree) {
	override val _structIdentifier: String
		get() = "Wave"
	
	override fun copy() = WavePopulator(this.copyInternal())
	
	operator fun WaveSpawnPopulator.unaryPlus() {
		this@WavePopulator.waveSpawns += this@unaryPlus
	}
	
	
	val waveSpawns by selfNamedList<WaveSpawnPopulator>()
	
	val sound by addField<String>("Sound")
	
	val description by addField<String>("Description")
	
	val waitWhenDone by addField<Number>("WaitWhenDone")
	
	@Deprecated("According to sigsegv, doesn't do anything.")
	val checkpoint by addField<Boolean>("Checkpoint", serializer = map({ if (it) "yes" else "no" }))
	
	/**
	 * The action that should be triggered once the bots start spawning.
	 *
	 * @see initWaveOutput
	 * @see OutputAction
	 */
	val startWaveOutput by addField<OutputAction>("StartWaveOutput")
	
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
	val doneOutput by addField<OutputAction>("DoneOutput")
	
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
	val initWaveOutput by addField<OutputAction>("InitWaveOutput")
	
	/**
	 * Define the action that should be triggered when a wave is first started.
	 *
	 * @see startWaveOutput
	 * @see OutputAction
	 */
	fun initWaveOutput(configure: OutputAction.() -> Unit) {
		this.initWaveOutput = OutputAction().apply(configure)
	}
	
	companion object {
		val CODEGEN = IExtensibleSubtree.Codegen.registerCodegen<WavePopulator> { Codegen.basicBlockScope(::Wave) }
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




