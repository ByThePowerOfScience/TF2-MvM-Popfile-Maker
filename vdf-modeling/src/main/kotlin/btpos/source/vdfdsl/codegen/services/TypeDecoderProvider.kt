package btpos.source.vdfdsl.codegen.services

import btpos.source.vdfdsl.codegen.Decoder
import btpos.source.vdfdsl.codegen.TypeDecoder
import kotlin.reflect.KClass

interface TypeDecoderProvider {
	val decoders: Map<KClass<*>, TypeDecoder>
}