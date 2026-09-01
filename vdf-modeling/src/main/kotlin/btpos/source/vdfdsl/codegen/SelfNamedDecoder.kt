package btpos.source.vdfdsl.codegen

import btpos.source.vdfdsl.backing.VDFKeyValue
import btpos.source.vdfdsl.backing.VDFPrimitive
import btpos.source.vdfdsl.backing.asPrimitive
import btpos.misc.kt.codegen.KtStatement
import btpos.misc.kt.codegen.KtExpression
import btpos.misc.kt.codegen.identifiers.KtName
import btpos.misc.kt.codegen.util.ReflectionUtils.getUpperBounds
import btpos.source.vdfdsl.backing.VDFObject
import btpos.source.vdfdsl.backing.VDFSubtree
import btpos.source.vdfdsl.backing.VDFValue
import btpos.source.vdfdsl.serialization.IVDFRepresentableValue_Trivial
import btpos.source.vdfdsl.util.ReflectionUtils.actuallyGet
import btpos.source.vdfdsl.util.ReflectionUtils.canAccess
import btpos.source.vdfdsl.util.ifNullOrEmpty
import kotlin.properties.ReadOnlyProperty
import kotlin.reflect.KClass
import kotlin.reflect.KProperty
import kotlin.reflect.KProperty1
import kotlin.reflect.full.companionObject
import kotlin.reflect.full.companionObjectInstance
import kotlin.reflect.full.declaredMemberProperties
import kotlin.reflect.full.isSubclassOf
import kotlin.reflect.jvm.javaField
import kotlin.reflect.jvm.javaGetter

fun interface SelfNamedDecoder<out T : KtStatement> {
	/**
	 * Destructively convert one or more [VDFKeyValues][VDFKeyValue] from this subtree
	 * into one or more Kotlin statements.
	 *
	 * Keyvalues should be removed from [subtree] if this parser was successful,
	 * and the subtree should not be modified at all on failure to parse.
	 *
	 * Since the subtree can be mutated, it's possible that this will be called with an empty subtree.
	 * For performance, make sure to check if the subtree is empty first before calling other decoders down the line.
	 *
	 * @return On successful parse, a list of statements representing keyvalues extracted and removed from [subtree].
	 *
	 * `null` or an empty list signifies that the input could not be parsed by this decoder.
	 * This could be due to just not finding a value in the subtree this decoder is applicable to,
	 * or it could be an error in decoding a value this would otherwise be able to decode.
	 *
	 * In the case of a null or empty return, the caller should proceed as though
	 * this decoder just didn't find anything it could act on, as some other decoder may be able to
	 * process an entry that was considered "malformed" to this decoder.
	 */
	fun decode(subtree: VDFSubtree): List<T>?
}

fun <T : KtStatement> SelfNamedDecoder<T>.orElse(other: SelfNamedDecoder<T>): SelfNamedDecoder<T> {
	return SelfNamedDecoder { kv ->
		this.decode(kv).ifNullOrEmpty { other.decode(kv) }
	}
}

fun <T : KtStatement> ValueDecoder<T>.orElse(other: ValueDecoder<T>): ValueDecoder<T> {
	return ValueDecoder { value, s ->
		this.decodeValue(value, s).ifNullOrEmpty { other.decodeValue(value, s) }
	}
}



/**
 * A helper that only calls [decodePrimitive] if the value of the keyvalue given is a [VDFPrimitive].
 */
fun interface StringDecoder : ValueDecoder<KtExpression> {
	override fun decodeValue(value: VDFValue, parentSubtree: VDFSubtree): List<KtExpression> {
		return value.asPrimitive?.let { listOfNotNull(decodePrimitive(it)) }.orEmpty()
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
inline fun <reified T : IVDFRepresentableValue_Trivial> ConstantsDecoder(): CodegenProvider<ValueDecoderMulti<KtExpression>> {
	return ConstantsDecoder(T::class)
}

inline fun <reified T : Any> ConstantsCodegen(noinline equalsCheck: T.(value: VDFObject, parent: VDFSubtree) -> Boolean): ReadOnlyProperty<Any, CodegenProvider<ValueDecoderMulti<KtExpression>>> {
	return ConstantsCodegen(T::class, equalsCheck)
}

/**
 * Creates a CodegenProvider that will use reflection to identify any instances of class T in [lookIn], its companion object, and any nested objects.
 */
fun <T : Any> ConstantsCodegen(lookIn: KClass<*>, lookingFor: KClass<T>, equalsCheck: T.(value: VDFObject, parent: VDFSubtree) -> Boolean): CodegenProvider<ValueDecoderMulti<KtExpression>> {
	return CodegenProvider {
		val nav = ValueDecoderMulti<KtExpression>()
		ConstantsFinder(lookIn, lookingFor) { owner, prop, objInst ->
			val propGet = (prop.javaGetter?.invoke(objInst) ?: prop.javaField!!.get(objInst)) as T
			val propName = prop.name
			
			val ownerSimpleName = owner.simpleName
			                      ?: return@ConstantsFinder
			val ownerQualName = owner.qualifiedName
			                    ?: return@ConstantsFinder
			
			nav.decoders += ValueDecoder<KtExpression> { item, parent ->
				if (propGet.equalsCheck(item, parent)) {
					listOf(Codegen.code(ownerSimpleName + "." + propName, ownerQualName))
				} else {
					null
				}
			}
		}
		nav
	}
}

fun <T : Any> ConstantsFinder(lookingIn: KClass<*>, lookingFor: KClass<T>, onEnterClass: ((KClass<*>) -> Unit)? = null, action: (ownerClass: KClass<*>, property: KProperty1<Any, T>, objectInstance: Any) -> Unit) {
	fun <C : Any> KClass<C>.findRecursive(lookingFor: KClass<T>) {
		onEnterClass?.invoke(this)
		
		(this.objectInstance?.let { this to it }
			?: this.companionObject?.let { it to it.objectInstance!! }
            ?: return)
		.let { (cls, inst) ->
			cls.declaredMemberProperties.forEach { prop ->
				if (!prop.canAccess(inst))
					return@forEach;
				
				if (prop.returnType.classifier.let { it != null && it.getUpperBounds().any { it.isSubclassOf(lookingFor) } }) {
					@Suppress("UNCHECKED_CAST") val prop = prop as KProperty1<Any, T>
					action(this@findRecursive, prop, inst)
				}
			}
			
			cls.nestedClasses.forEach {
				it.findRecursive(lookingFor)
			}
		}
	}
	
	lookingIn.findRecursive(lookingFor)
}
/**
 * Creates a delegate that will create CodegenProvider that will use reflection to identify any instances of class T in this object, its companion object, and any nested objects.
 */
fun <T : Any> ConstantsCodegen(cls: KClass<T>, equalsCheck: T.(value: VDFObject, parent: VDFSubtree) -> Boolean): ReadOnlyProperty<Any, CodegenProvider<ValueDecoderMulti<KtExpression>>> {
	return object : ReadOnlyProperty<Any, CodegenProvider<ValueDecoderMulti<KtExpression>>> {
		private var provider: CodegenProvider<ValueDecoderMulti<KtExpression>>? = null
		
		override fun getValue(thisRef: Any, property: KProperty<*>): CodegenProvider<ValueDecoderMulti<KtExpression>> {
			return provider ?: ConstantsCodegen(thisRef::class, cls, equalsCheck).also {
				provider = it
			}
		}
	}
}
/**
 * Create a default code generator for constants in the companion object of a class using reflection.
 *
 * More entries can be added to the resulting MultiDecoder.
 */
fun <T : IVDFRepresentableValue_Trivial> ConstantsDecoder(cls: KClass<T>): CodegenProvider<ValueDecoderMulti<KtExpression>> {
	return CodegenProvider {
		val companionInst = cls.companionObjectInstance ?: error("No companion object")
		
		StringDecoderMap(
			cls.companionObject!!.declaredMemberProperties.mapNotNull {
				if (it.returnType.classifier != cls)
					return@mapNotNull null;
				
				val it = it as KProperty1<Any, T>
				
				it.actuallyGet(companionInst)._vdfRepr to KtName(it.name, cls)
			}
		)
	}
}

fun StringDecoderMap(vararg vanillaStringMappings: Pair<String, KtExpression>) = StringDecoderMap(vanillaStringMappings.asList())

fun StringDecoderMap(vanillaStringMappings: Iterable<Pair<String, KtExpression>>): ValueDecoderMulti<KtExpression> {
	return StringDecoderMap(vanillaStringMappings.map {
		VDFPrimitive(it.first) to it.second
	})
}

@JvmName("StringDecoderMap_Primitive")
fun StringDecoderMap(vanillaStringMappings: Iterable<Pair<VDFPrimitive, KtExpression>>): ValueDecoderMulti<KtExpression> {
	return ValueDecoderMulti(vanillaStringMappings.mapTo(mutableListOf()) { StringToCodeDecoder(it.first, it.second) })
		.apply {
			finalDecoder = StringDecoder.IDENTITY
		}
}

class StringToCodeDecoder(val string: VDFPrimitive, val expr: KtExpression) : StringDecoder {
	override fun decodePrimitive(primitive: VDFPrimitive): KtExpression? {
		return expr.takeIf { primitive == string }
	}
}

class DecoderMulti<T : KtStatement>(val decoders: MutableList<SelfNamedDecoder<T>> = mutableListOf()) : SelfNamedDecoder<T> {
	var finalDecoder: SelfNamedDecoder<T>? = null
	
	constructor(decoders: Iterable<SelfNamedDecoder<T>>) : this(decoders.toMutableList())
	
	override fun decode(subtree: VDFSubtree): List<T>? {
		for (decoder in decoders) {
			val x = decoder.decode(subtree)
			if (!x.isNullOrEmpty())
				return x;
		}
		
		return finalDecoder?.let { it.decode(subtree) }
	}
}

/**
 * Takes the first decoder that successfully parses the input value.
 */
class ValueDecoderMulti<T : KtStatement>(val decoders: MutableList<ValueDecoder<T>> = mutableListOf()) : ValueDecoder<T> {
	/**
	 * The final decoder that will be run in the set.
	 */
	var finalDecoder: ValueDecoder<T>? = null
	
	constructor(decoders: Iterable<ValueDecoder<T>>) : this(decoders.toMutableList())
	
	override fun decodeValue(value: VDFValue, parentSubtree: VDFSubtree): List<T>? {
		for (decoder in decoders) {
			val x = decoder.decodeValue(value, parentSubtree)
			if (!x.isNullOrEmpty())
				return x;
		}
		
		return finalDecoder?.let { it.decodeValue(value, parentSubtree) }
	}
}