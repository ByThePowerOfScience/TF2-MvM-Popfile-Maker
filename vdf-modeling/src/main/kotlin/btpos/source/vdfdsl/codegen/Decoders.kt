package btpos.source.vdfdsl.codegen

import btpos.misc.kt.codegen.KtExpression
import btpos.misc.kt.codegen.KtStatement
import btpos.source.vdfdsl.backing.VDFObject
import btpos.source.vdfdsl.backing.VDFSubtree
import btpos.source.vdfdsl.codegen.services.TypeDecoderProvider
import btpos.source.vdfdsl.util.ClassHierarchyGraph
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
	
	/**
	 * Return a decoder suitable for evaluating an already-identified type.
	 */
	fun getValueDecoder(type: KClass<*>): ValueDecoder<KtExpression>? {
		if (services.none { type in it.valueDecoders })
			return null;
		
		return CompositeValueDecoder(type)
	}
	
	private val allClassHierarchyGraph = ClassHierarchyGraph()
	
	private class CompositeValueDecoder(val type: KClass<*>) : ValueDecoder<KtExpression> {
		override fun decodeValue(value: VDFObject, parentSubtree: VDFSubtree): List<KtExpression>? {
			return services.firstNotNullOfOrNull {
				it.valueDecoders[type]?.decodeValue(value, parentSubtree)
					?.takeIf { it.isNotEmpty() }
			}
		}
	}
	
	private class CompositeSelfNamedDecoder(val type: KClass<*>) : SelfNamedDecoder<KtExpression> {
		override fun decode(subtree: VDFSubtree): List<KtExpression>? {
			return services.firstNotNullOfOrNull {
				it.selfNamedDecoders[type]?.decode(subtree)
					?.takeIf { it.isNotEmpty() }
			}
		}
	}
	
	/**
	 * Return a decoder suitable for evaluating instances of this self-named type
	 */
	fun getDecoder(type: KClass<*>): SelfNamedDecoder<KtExpression>? {
		if (services.none { type in it.selfNamedDecoders })
			return null;
		
		return CompositeSelfNamedDecoder(type)
	}
//
//	fun getValueDecoderBestFit(obj: Any): ValueDecoder<KtExpression> {
//		allClassHierarchyGraph.add(obj::class)
//		return ValueDecoder { value, parent ->
//			allClassHierarchyGraph.getParentsRecursive(obj::class).firstNotNullOfOrNull { getValueDecoder(it)?.decodeValue(value, parent) }
//		}
//	}
	
	
	fun getDecoderOrThrow(type: KClass<*>): SelfNamedDecoder<KtExpression> {
		return getDecoder(type)
		       ?: error("No decoder(s) defined for '${type}'.")
	}
}
