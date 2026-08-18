package btpos.source.vdfdsl.codegen.services

import btpos.source.vdfdsl.codegen.SelfNamedDecoder
import btpos.source.vdfdsl.codegen.StructSubclassNavigator
import btpos.misc.kt.codegen.KtExpression
import btpos.source.vdfdsl.codegen.ValueDecoder
import kotlin.reflect.KClass

interface TypeDecoderProvider {
	/**
	 * How to convert a specific class into Kotlin code.  Assumes no supertypes exist.
	 */
	val valueDecoders: Map<KClass<*>, ValueDecoder<KtExpression>> get() = emptyMap()
	
	val selfNamedDecoders: Map<KClass<*>, SelfNamedDecoder<KtExpression>> get() = emptyMap()
}