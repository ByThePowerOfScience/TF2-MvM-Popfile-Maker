package btpos.source.vdfdsl.codegen

import btpos.source.vdfdsl.backing.VDFKeyValue
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
	
	private class CompositeTypeNavigator(
		val subclassNav: StructSubclassNavigator,
		val ownFields: Decoder<KtExpression>?
	) : Decoder<KtExpression> {
		override fun decode(keyvalue: VDFKeyValue): List<KtExpression> {
			return subclassNav.decode(keyvalue).ifEmpty {
				ownFields?.decode(keyvalue).orEmpty()
			}
		}
	}
	
	private fun getTypeDecoder(type: KClass<*>): Decoder<KtExpression>? {
		return services.firstNotNullOfOrNull { it.typeDecoders[type] }
	}
	
	fun forType(type: KClass<*>): Decoder<KtExpression> {
		val subclassNav = services.firstNotNullOfOrNull {
			it.subtypeNavigation[type]
		}
		
		val type = getTypeDecoder(type)
		
		if (subclassNav != null) {
			return CompositeTypeNavigator(
				subclassNav,
				type
			)
		}
		
		return type ?: error("No decoder(s) defined for '$type'.")
	}
}
