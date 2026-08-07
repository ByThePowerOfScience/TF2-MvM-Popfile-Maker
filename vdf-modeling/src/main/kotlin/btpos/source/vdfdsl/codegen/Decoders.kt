package btpos.source.vdfdsl.codegen

import btpos.source.vdfdsl.backing.VDFKeyValue
import btpos.source.vdfdsl.backing.VDFObject
import btpos.source.vdfdsl.codegen.kt.KtExpression
import btpos.source.vdfdsl.codegen.services.TypeDecoderProvider
import java.util.ServiceLoader
import kotlin.collections.plusAssign
import kotlin.reflect.KClass
import kotlin.time.Duration

/**
 * Doesn't use the key or other information, just a raw value.
 */
fun interface ValueDecoder : Decoder {
	override fun decode(obj: VDFObject): List<IKtCodeGenerator> {
		return listOfNotNull(decodeValue(obj))
	}
	
	fun decodeValue(obj: VDFObject): KtExpression?
}

object Decoders {
	private val valueDecoders: Map<KClass<*>, ValueDecoder>
	
	private val selfNamedDecoders: Map<KClass<*>, StructSubclassDecoder>
	
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
		val valueDecodersTemp = mutableMapOf<KClass<*>, ValueDecoder>()
		val navTemp = mutableMapOf<KClass<*>, StructSubclassDecoder>()
		
		services.forEach {
			valueDecodersTemp += it.valueDecoders
			navTemp += it.selfNamedDecoders
		}
		
		valueDecodersTemp[Int::class] = INT
		valueDecodersTemp[Double::class] = NUMBER
		valueDecodersTemp[Float::class] = NUMBER
		valueDecodersTemp[Number::class] = NUMBER
		valueDecodersTemp[Duration::class] = DURATION
		valueDecodersTemp[String::class] = StringDecoder.IDENTITY
		
		valueDecoders = valueDecodersTemp
		selfNamedDecoders = navTemp
	}
	
	
	fun getTypeDecoder(type: KClass<*>): ValueDecoder {
		return valueDecoders[type] ?: error("No decoder(s) defined for '$type'.")
	}
	
	fun getSelfNamedDecoder(type: KClass<*>): StructSubclassDecoder {
		return selfNamedDecoders[type] ?: error("No decoder defined for '$type'.")
	}
	
}
