package btpos.source.vdfdsl.types.populators

import btpos.source.vdfdsl.modeling.ExtensibleSubtreeImpl
import btpos.source.vdfdsl.modeling.IExtensibleSubtree.Companion.addField
import btpos.source.vdfdsl.modeling.IExtensibleSubtree.Companion.multiStruct
import btpos.source.vdfdsl.types.PopulationManager
import btpos.source.vdfdsl.types.populators
import btpos.source.vdfdsl.types.specifics.OutputAction

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

val WavePopulator.waveSpawn: MutableList<WaveSpawnPopulator>? by multiStruct()

var WavePopulator.sound: String? by addField("Sound")

var WavePopulator.description: String? by addField("Description")

var WavePopulator.waitWhenDone: Double? by addField("WaitWhenDone")

@Deprecated("Apparently doesn't do anything?")
var WavePopulator.checkpoint: Boolean? by addField("Checkpoint")

var WavePopulator.startWaveOutput: OutputAction? by addField("StartWaveOutput")

var WavePopulator.doneOutput: OutputAction? by addField("DoneOutput")

var WavePopulator.initWaveOutput: OutputAction? by addField("InitWaveOutput")

