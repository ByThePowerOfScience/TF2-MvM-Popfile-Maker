package btpos.source.vdfdsl.serialization.codecs

import btpos.source.vdfdsl.serialization.VDFStringLiteral

object StringLiteralCodec : Codec<String, VDFStringLiteral> {
	override fun read(data: VDFStringLiteral): String = data.string
	
	override fun write(input: String): VDFStringLiteral = VDFStringLiteral(input)
}

val Codec.Companion.StringLiteral
	get() = StringLiteralCodec