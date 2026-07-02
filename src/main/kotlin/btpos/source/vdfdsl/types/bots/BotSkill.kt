package btpos.source.vdfdsl.types.bots

import btpos.source.vdfdsl.serialization.IVDFRepresentableValue
import btpos.source.vdfdsl.backing.VDFPrimitive

class BotSkill(val name: String) : IVDFRepresentableValue<VDFPrimitive> {
	
	override val _vdfRepr get() = VDFPrimitive(name)
	
	companion object {
		val Easy = BotSkill("Easy")
		val Normal = BotSkill("Normal")
		val HARD = BotSkill("Hard")
		val Expert = BotSkill("Expert")
	}
	
}
