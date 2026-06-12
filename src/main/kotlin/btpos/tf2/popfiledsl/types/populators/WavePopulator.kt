package btpos.tf2.popfiledsl.types.populators

import btpos.tf2.popfiledsl.modeling.IMvMSubtree.Companion.addField
import btpos.tf2.popfiledsl.modeling.IMvMSubtree.Companion.multiStruct
import btpos.tf2.popfiledsl.serialization.codecs.StringLiteralCodec
import btpos.tf2.popfiledsl.types.specifics.OutputAction

class WavePopulator : Populator() {
	override val _popFileStructIdentifier: Any
		get() = "Wave"
}

inline fun Populator.Companion.Wave(configure: WavePopulator.() -> Unit) = WavePopulator().apply(configure)


val WavePopulator.waveSpawn: MutableList<WaveSpawnPopulator>? by multiStruct()

var WavePopulator.sound: String? by addField("Sound", StringLiteralCodec)

var WavePopulator.description: String? by addField("Description", StringLiteralCodec)

var WavePopulator.waitWhenDone: Double? by addField("WaitWhenDone")

@Deprecated("Apparently doesn't do anything?")
var WavePopulator.checkpoint: Boolean? by addField("Checkpoint")

var WavePopulator.startWaveOutput: OutputAction? by addField("StartWaveOutput")

var WavePopulator.doneOutput: OutputAction? by addField("DoneOutput")

var WavePopulator.initWaveOutput: OutputAction? by addField("InitWaveOutput")

