package btpos.source.vdfdsl.tf2.rafmod.types

import btpos.source.vdfdsl.backing.VDFPrimitive
import btpos.source.vdfdsl.serialization.IVDFRepresentableValue_Trivial
import java.awt.Color

data class ChatMessage(val message: String, val color: Color) : IVDFRepresentableValue_Trivial {
	override val _vdfRepr: VDFPrimitive
		get() = TODO("Not yet implemented")
	
}