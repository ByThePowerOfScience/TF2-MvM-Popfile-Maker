package btpos.source.vdfdsl.types.bots

import btpos.source.vdfdsl.serialization.IVDFRepresentableValue_Trivial
import btpos.source.vdfdsl.backing.VDFPrimitive
import btpos.source.vdfdsl.codegen.ConstantsDecoder

open class BotSkill(val name: String) : IVDFRepresentableValue_Trivial {
	override val _vdfRepr get() = VDFPrimitive(name)
	
	companion object {
		val Easy = BotSkill("Easy")
		val Normal = BotSkill("Normal")
		val Hard = BotSkill("Hard")
		val Expert = BotSkill("Expert")
		
		val CODEGEN = ConstantsDecoder<BotSkill>()
	}
}
