package btpos.source.vdfdsl.codegen.services.impl

import btpos.source.vdfdsl.codegen.SelfNamedDecoder
import btpos.source.vdfdsl.codegen.Decoders.DURATION
import btpos.source.vdfdsl.codegen.Decoders.INT
import btpos.source.vdfdsl.codegen.Decoders.NUMBER
import btpos.source.vdfdsl.codegen.StringDecoder
import btpos.source.vdfdsl.codegen.StructSubclassNavigator
import btpos.misc.kt.codegen.KtExpression
import btpos.source.vdfdsl.codegen.Decoders.BOOLEAN
import btpos.source.vdfdsl.codegen.ValueDecoder
import btpos.source.vdfdsl.codegen.services.TypeDecoderProvider
import kotlin.collections.set
import kotlin.reflect.KClass
import kotlin.time.Duration

class StandardTypeDecoderProvider : TypeDecoderProvider {
	override val valueDecoders: Map<KClass<*>, ValueDecoder<KtExpression>> = buildMap {
			setOf(
				Int::class, Integer.TYPE.kotlin, Integer::class,
				Long::class, java.lang.Long.TYPE.kotlin, java.lang.Long::class,
			).forEach {
				put(it, INT)
			}
			setOf(
				Boolean::class, java.lang.Boolean.TYPE.kotlin, java.lang.Boolean::class,
			).forEach {
				put(it, BOOLEAN)
			}
			
			setOf(
				Double::class, java.lang.Double.TYPE.kotlin, java.lang.Double::class,
				Float::class, java.lang.Float.TYPE.kotlin, java.lang.Float::class,
				Number::class, java.lang.Number::class,
			).distinct().forEach {
				put(it, NUMBER)
			}
			
			sequenceOf(
				Char::class, Character::class, Character.TYPE.kotlin,
				String::class, java.lang.String::class,
				CharSequence::class, java.lang.CharSequence::class
			).forEach {
				put(it, StringDecoder.IDENTITY)
			}
			
			this[Duration::class] = DURATION
		}
	
}