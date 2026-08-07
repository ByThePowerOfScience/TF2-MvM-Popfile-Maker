package btpos.source.vdfdsl.codegen.services

import btpos.source.vdfdsl.codegen.StructSubclassDecoder
import btpos.source.vdfdsl.codegen.ValueDecoder
import kotlin.reflect.KClass

interface TypeDecoderProvider {
	val valueDecoders: Map<KClass<*>, ValueDecoder>
	
	/**
	 * Things that name themselves need to know their key to be able to get their value
	 */
	val selfNamedDecoders: Map<KClass<*>, StructSubclassDecoder>
}