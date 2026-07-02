package btpos.source.vdfdsl.types.populators

import btpos.source.vdfdsl.modeling.IExtensibleSubtree.Companion.addField
import btpos.source.vdfdsl.modeling.IExtensibleSubtree.Companion.multiStruct
import btpos.source.vdfdsl.types.specifics.OutputAction

class WavePopulator : Populator() {
	override val _structIdentifier: String
		get() = "Wave"
}

inline fun Populator.Companion.Wave(configure: WavePopulator.() -> Unit) = WavePopulator().apply(configure)


val WavePopulator.waveSpawn: MutableList<WaveSpawnPopulator>? by multiStruct()

var WavePopulator.sound: String? by addField("Sound")

var WavePopulator.description: String? by addField("Description")

var WavePopulator.waitWhenDone: Double? by addField("WaitWhenDone")

@Deprecated("Apparently doesn't do anything?")
var WavePopulator.checkpoint: Boolean? by addField("Checkpoint")

var WavePopulator.startWaveOutput: OutputAction? by addField("StartWaveOutput")

var WavePopulator.doneOutput: OutputAction? by addField("DoneOutput")

var WavePopulator.initWaveOutput: OutputAction? by addField("InitWaveOutput")

