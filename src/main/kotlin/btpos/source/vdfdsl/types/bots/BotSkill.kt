package btpos.source.vdfdsl.types.bots

import btpos.source.vdfdsl.serialization.IVDFSerializableValue

class BotSkill(override val _vdfRepr: String) : IVDFSerializableValue<String> {
	companion object {
		val Easy = BotSkill("Easy")
		val Normal = BotSkill("Normal")
		val HARD = BotSkill("Hard")
		val Expert = BotSkill("Expert")
	}
	
}
