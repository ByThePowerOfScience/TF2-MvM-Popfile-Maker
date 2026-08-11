package btpos.source.vdfdsl.codegen

import btpos.source.vdfdsl.backing.VDFKeyValue
import btpos.source.vdfdsl.backing.VDFObject
import btpos.source.vdfdsl.backing.VDFPrimitive
import btpos.source.vdfdsl.backing.asPrimitive
import btpos.misc.kt.codegen.KtStatement
import btpos.misc.kt.codegen.KtExpression
import btpos.misc.kt.codegen.identifiers.KtName
import btpos.source.vdfdsl.serialization.IVDFRepresentableValue_Trivial
import kotlin.jvm.java
import kotlin.reflect.KClass
import kotlin.reflect.KProperty1
import kotlin.reflect.full.companionObject
import kotlin.reflect.full.companionObjectInstance
import kotlin.reflect.full.declaredMemberProperties

fun interface Decoder<out T : KtStatement> {
	/**
	 * Transforms a [VDFKeyValue] into a list of Kotlin statements.
	 *
	 * @return A list of the statement(s) that represent this keyvalue, or an empty list if this is not applicable.
	 */
	fun decode(keyvalue: VDFKeyValue): List<T>
}

fun <T : KtStatement> Decoder<T>.orElse(other: Decoder<T>): Decoder<T> {
	return Decoder { kv ->
		this.decode(kv).ifEmpty { other.decode(kv) }
	}
}

/**
 * A helper that only calls [decodePrimitive] if the value of the keyvalue given is a [VDFPrimitive].
 */
fun interface StringDecoder : ValueDecoder<KtExpression> {
	override fun decodeValue(obj: VDFObject): List<KtExpression> {
		return obj.asPrimitive?.let { listOfNotNull(decodePrimitive(it)) }.orEmpty()
	}
	
	fun decodePrimitive(primitive: VDFPrimitive): KtExpression?
	
	companion object {
		val IDENTITY = StringDecoder {
			Codegen.string(it.stringValue)
		}
	}
}

/**
 * Create a default code generator for constants in the companion object of a class using reflection.
 *
 * More entries can be added to the resulting MultiDecoder.
 */
inline fun <reified T : IVDFRepresentableValue_Trivial> ConstantsDecoder(): CodegenProvider<MultiDecoder<KtExpression>> {
	return ConstantsDecoder(T::class)
}

/**
 * Create a default code generator for constants in the companion object of a class using reflection.
 *
 * More entries can be added to the resulting MultiDecoder.
 */
fun <T : IVDFRepresentableValue_Trivial> ConstantsDecoder(cls: KClass<T>): CodegenProvider<MultiDecoder<KtExpression>> {
	return CodegenProvider {
		val clsjava = cls.java
		val companionInst = cls.companionObjectInstance ?: error("No companion object")
		
		StringDecoderMap(
			cls.companionObject!!.declaredMemberProperties.mapNotNull {
				if (it.returnType.classifier != cls)
					return@mapNotNull null;
				
				val it = it as KProperty1<Any, T>
				
				it.get(companionInst)._vdfRepr to KtName(it, clsjava)
			}
		)
	}
}

fun StringDecoderMap(vararg vanillaStringMappings: Pair<String, KtExpression>) = StringDecoderMap(vanillaStringMappings.asList())

fun StringDecoderMap(vanillaStringMappings: Iterable<Pair<String, KtExpression>>): MultiDecoder<KtExpression> {
	return StringDecoderMap(vanillaStringMappings.map {
		VDFPrimitive(it.first) to it.second
	})
}

@JvmName("StringDecoderMap_Primitive")
fun StringDecoderMap(vanillaStringMappings: Iterable<Pair<VDFPrimitive, KtExpression>>): MultiDecoder<KtExpression> {
	return MultiDecoder(vanillaStringMappings.mapTo(mutableListOf()) { StringToCodeDecoder(it.first, it.second) })
		.apply {
			finalDecoder = StringDecoder.IDENTITY
		}
}

class StringToCodeDecoder(val string: VDFPrimitive, val expr: KtExpression) : StringDecoder {
	override fun decodePrimitive(primitive: VDFPrimitive): KtExpression? {
		return expr.takeIf { primitive == string }
	}
}

/**
 * Takes the first decoder that returns a valid value
 */
class MultiDecoder<T : KtStatement>(val decoders: MutableList<Decoder<T>> = mutableListOf()) : Decoder<T> {
	/**
	 * The final decoder that will be run in the set.
	 */
	var finalDecoder: Decoder<T>? = null
	
	constructor(decoders: Iterable<Decoder<T>>) : this(decoders.toMutableList())
	
	override fun decode(keyvalue: VDFKeyValue): List<T> {
		decoders.forEach {
			val x = it.decode(keyvalue)
			if (x.isEmpty())
				return@forEach;
			else
				return x;
		}
		
		finalDecoder?.decode(keyvalue)?.let {
			return it
		}
		
		return emptyList()
	}
}