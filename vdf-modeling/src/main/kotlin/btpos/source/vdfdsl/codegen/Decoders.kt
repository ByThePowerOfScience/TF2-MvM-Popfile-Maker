package btpos.source.vdfdsl.codegen

import btpos.misc.kt.codegen.KtExpression
import btpos.source.vdfdsl.codegen.services.TypeDecoderProvider
import java.util.ServiceLoader
import kotlin.reflect.KClass

object Decoders {
	val DURATION = StringDecoder { str ->
		str.stringValue.toDoubleOrNull()?.let {
			Codegen.code("$str.seconds", "kotlin.time.Duration")
		}
	}
	
	val NUMBER = StringDecoder { str ->
		str.stringValue.toDoubleOrNull()?.run {
			Codegen.code(str.stringValue)
		}
	}
	
	val INT = StringDecoder { str ->
		str.stringValue.toIntOrNull()?.run {
			Codegen.code(str.stringValue)
		}
	}
	
	private val services = ServiceLoader.load(TypeDecoderProvider::class.java)
	
	/**
	 * Return a decoder suitable for evaluating an already-identified type.
	 */
	fun getValueDecoder(type: KClass<*>): ValueDecoder<KtExpression>? {
		return services.firstNotNullOfOrNull { it.valueDecoders[type] }
	}
	
	/**
	 * Return a decoder suitable for evaluating instances of this self-named type
	 */
	fun getDecoder(type: KClass<*>): SelfNamedDecoder<KtExpression>? {
		return services.firstNotNullOfOrNull { it.selfNamedDecoders[type] }
	}
	
	
	fun getDecoderOrThrow(type: KClass<*>): SelfNamedDecoder<KtExpression> {
		return getDecoder(type)
		       ?: error("No decoder(s) defined for '${type}'.")
	}
}
