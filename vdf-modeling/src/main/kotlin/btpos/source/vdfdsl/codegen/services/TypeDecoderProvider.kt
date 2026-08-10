package btpos.source.vdfdsl.codegen.services

import btpos.source.vdfdsl.codegen.Decoder
import btpos.source.vdfdsl.codegen.IKtCodeGenerator
import btpos.source.vdfdsl.codegen.kt.KtExpression
import kotlin.reflect.KClass

interface TypeDecoderProvider {
	val valueDecoders: Map<KClass<*>, Decoder<KtExpression>>
}