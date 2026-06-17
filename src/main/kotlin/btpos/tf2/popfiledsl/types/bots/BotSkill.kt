package btpos.tf2.popfiledsl.types.bots

import btpos.tf2.popfiledsl.serialization.IVDFSerializableValue

class BotSkill(override val _vdfRepr: String) : IVDFSerializableValue<String> {
	companion object {
		val Easy = BotSkill("Easy")
		val Normal = BotSkill("Normal")
		val HARD = BotSkill("Hard")
		val Expert = BotSkill("Expert")
	}
	
}
