package btpos.tf2.popfiledsl.serialization.codecs

import btpos.tf2.popfiledsl.serialization.PopFileStringLiteral

object StringLiteralCodec : Codec<String, PopFileStringLiteral> {
	override fun read(data: PopFileStringLiteral): String = data.string
	
	override fun write(input: String): PopFileStringLiteral = PopFileStringLiteral(input)
}

val Codec.Companion.StringLiteral
	get() = StringLiteralCodec