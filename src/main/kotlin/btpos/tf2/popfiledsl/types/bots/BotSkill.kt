package btpos.tf2.popfiledsl.types.bots

import btpos.tf2.popfiledsl.serialization.IPopFileRepresentable

class BotSkill(override val popFileRepr: String) : IPopFileRepresentable<String> {
	companion object {
		val Easy = BotSkill("Easy")
		val Normal = BotSkill("Normal")
		val HARD = BotSkill("Hard")
		val Expert = BotSkill("Expert")
	}
	
}
