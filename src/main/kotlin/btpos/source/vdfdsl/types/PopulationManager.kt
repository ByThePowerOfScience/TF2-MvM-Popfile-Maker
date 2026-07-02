package btpos.source.vdfdsl.types

import btpos.source.vdfdsl.modeling.IExtensibleSubtree
import btpos.source.vdfdsl.modeling.IExtensibleSubtree.Companion.addField
import btpos.source.vdfdsl.modeling.IExtensibleSubtree.Companion.multiStruct
import btpos.source.vdfdsl.serialization.IVDFRepresentableKeyValue
import btpos.source.vdfdsl.serialization.codecs.Codec
import btpos.source.vdfdsl.tf2.PopFileDSL
import btpos.source.vdfdsl.types.populators.Populator

@PopFileDSL
class PopulationManager : IExtensibleSubtree {
	override val _rawEntries: MutableMap<Any, IVDFRepresentableKeyValue> = mutableMapOf()
	
	override val _instantiationSite: Array<StackTraceElement> = Throwable().stackTrace
}

val PopulationManager.populators: MutableList<Populator> by multiStruct(isRequired = true)

/**
 * Default: 0
 */
val PopulationManager.startingCurrency by addField<Int>("StartingCurrency")

/**
 * Default: 10
 */
val PopulationManager.respawnWaveTime by addField<Int>("RespawnWaveTime")

/**
 * e.g. `"Halloween"`
 */
val PopulationManager.eventPopFile by addField<String>("EventPopFile")
val PopulationManager.fixedRespawnWaveTime by addField<Boolean>("FixedRespawnWaveTime")

/**
 * Default: 3000
 */
val PopulationManager.addSentryBusterWhenDamageDealtExceeds by addField<Int>("AddSentryBusterWhenDamageDealtExceeds")

/**
 * Default: 15
 */
val PopulationManager.addSentryBusterWhenKillCountExceeds by addField<Int>("AddSentryBusterWhenKillCountExceeds")

val PopulationManager.canBotsAttackWhileInSpawnRoom: Boolean? by addField("CanBotsAttackWhileInSpawnRoom", object : Codec<Boolean, String> {
	override fun read(data: String): Boolean {
		return when (data) {
			"no", "false" -> false
			else -> true
		}
	}
	
	override fun write(input: Boolean): String {
		return if (input) "true" else "false"
	}
})

val PopulationManager.advanced by addField<Boolean>("Advanced")
val PopulationManager.isEndless by addField<Boolean>("IsEndless")


