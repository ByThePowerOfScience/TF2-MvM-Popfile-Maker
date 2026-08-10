package btpos.source.vdfdsl.codegen

import btpos.source.vdfdsl.codegen.kt.KtExpression
import btpos.source.vdfdsl.codegen.services.TypeDecoderProvider
import btpos.source.vdfdsl.modeling.IExtensibleSubtree
import java.util.ServiceLoader
import kotlin.collections.plusAssign
import kotlin.reflect.KClass
import kotlin.time.Duration

object Decoders {
	private val typeDecoders: Map<KClass<*>, Decoder<KtExpression>>
	
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
	
	init {
		val services = ServiceLoader.load(TypeDecoderProvider::class.java)
		val valueDecodersTemp = mutableMapOf<KClass<*>, Decoder<KtExpression>>()
		
		services.forEach {
			valueDecodersTemp += it.valueDecoders
		}
		
		valueDecodersTemp[Int::class] = INT
		valueDecodersTemp[Double::class] = NUMBER
		valueDecodersTemp[Float::class] = NUMBER
		valueDecodersTemp[Number::class] = NUMBER
		valueDecodersTemp[Duration::class] = DURATION
		valueDecodersTemp[String::class] = StringDecoder.IDENTITY
		
		typeDecoders = valueDecodersTemp
	}
	
	fun forType(type: KClass<*>): Decoder<KtExpression> {
		return typeDecoders[type] ?: error("No decoder(s) defined for '$type'.")
	}
}
