package btpos.tf2.popfiledsl.types

import btpos.tf2.popfiledsl.modeling.CustomHandler
import btpos.tf2.popfiledsl.modeling.IMvMSubtree.Companion.addField
import btpos.tf2.popfiledsl.modeling.IMvMSubtree.Companion.multiStruct
import btpos.tf2.popfiledsl.modeling.IMvMSubtreeMap
import btpos.tf2.popfiledsl.modeling.PopFileDSL
import btpos.tf2.popfiledsl.serialization.IPopFileSerializable
import btpos.tf2.popfiledsl.serialization.PopFileEntry
import btpos.tf2.popfiledsl.serialization.codecs.Codec
import btpos.tf2.popfiledsl.types.populators.Populator

@PopFileDSL
class PopulationManager : IMvMSubtreeMap {
	override val _rawEntries: MutableMap<Any, IPopFileSerializable<Iterable<PopFileEntry>>> = mutableMapOf()
	override val _customHandlers: MutableMap<Any, CustomHandler<*>> = mutableMapOf()
	
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


