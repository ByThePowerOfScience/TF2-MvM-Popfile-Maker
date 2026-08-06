package btpos.source.vdfdsl.codegen

import btpos.source.vdfdsl.backing.VDFObject
import btpos.source.vdfdsl.codegen.kt.KtExpression
import btpos.source.vdfdsl.codegen.services.TypeDecoderProvider
import java.util.ServiceLoader
import kotlin.reflect.KClass

interface TypeDecoder : Decoder {
	override fun decode(obj: VDFObject): List<IKtCodeGenerator> {
		return listOfNotNull(decodeValue(obj))
	}
	
	fun decodeValue(obj: VDFObject): KtExpression?
}

object Decoders {
	private val decoders: Map<KClass<*>, TypeDecoder> = ServiceLoader.load(TypeDecoderProvider::class.java).fold(mutableMapOf()) { acc, it -> acc += it.decoders; acc }
	
	fun getTypeDecoder(type: KClass<*>): TypeDecoder {
		return decoders[type] ?: error("No decoder(s) defined for '$type'.")
	}
	
	val DURATION: StringDecoder = { str ->
		str.toDoubleOrNull()?.let {
			listOf(Codegen.code("$str.seconds", "kotlin.time.Duration"))
		} ?: emptyList()
	}
	
	val NUMBER: StringDecoder = { str ->
		str.toDoubleOrNull()?.run {
			listOf(Codegen.code(str))
		}.orEmpty()
	}
	
	val INT: StringDecoder = { str ->
		str.toIntOrNull()?.run {
			listOf(Codegen.code(str))
		}.orEmpty()
	}
}
