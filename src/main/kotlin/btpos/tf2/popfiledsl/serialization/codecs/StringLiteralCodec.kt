package btpos.tf2.popfiledsl.serialization.codecs

import btpos.tf2.popfiledsl.serialization.VDFStringLiteral

object StringLiteralCodec : Codec<String, VDFStringLiteral> {
	override fun read(data: VDFStringLiteral): String = data.string
	
	override fun write(input: String): VDFStringLiteral = VDFStringLiteral(input)
}

val Codec.Companion.StringLiteral
	get() = StringLiteralCodec