package btpos.source.vdfdsl.codegen.services

import btpos.source.vdfdsl.codegen.Decoder
import btpos.source.vdfdsl.codegen.StructSubclassNavigator
import btpos.misc.kt.codegen.KtExpression
import kotlin.reflect.KClass

interface TypeDecoderProvider {
	/**
	 * How to convert a specific class into Kotlin code.  Assumes no supertypes exist.
	 */
	val typeDecoders: Map<KClass<*>, Decoder<KtExpression>>
	
	val subtypeNavigation: Map<KClass<*>, StructSubclassNavigator> get() = emptyMap()
}