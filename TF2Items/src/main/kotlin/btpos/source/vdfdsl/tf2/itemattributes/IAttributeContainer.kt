package btpos.source.vdfdsl.tf2.itemattributes

import btpos.misc.kt.codegen.KtExpression
import btpos.misc.kt.codegen.expressions.KtFunctionCall
import btpos.misc.kt.codegen.expressions.KtLambda
import btpos.misc.kt.codegen.identifiers.KtName
import btpos.source.vdfdsl.backing.VDFSubtree
import btpos.source.vdfdsl.backing.VDFValue
import btpos.source.vdfdsl.backing.asSubtree
import btpos.source.vdfdsl.codegen.CodegenProvider
import btpos.source.vdfdsl.codegen.ValueDecoder
import btpos.source.vdfdsl.serialization.IVDFRepresentableValue_Subtree
import btpos.source.vdfdsl.tf2.codegen.AttributesCodegenTraverser
import btpos.source.vdfdsl.util.ifNullOrEmpty

interface IAttributeContainer {
	operator fun <T : Any> get(key: ItemAttribute<T>): T?
	
	operator fun <T : Any> set(key: ItemAttribute<T>, value: T?)
	
	fun copy(): IAttributeContainer
	
	operator fun iterator(): Iterator<Pair<ItemAttribute<Any>, Any?>>
	
	companion object {
		val CODEGEN_ATTRS = CodegenProvider { AttributesCodegenTraverser() }
		
		/**
		 * New locations of named attributes in code can be added to [AttributesCodegenTraverser.IAttributeContainerCodegen.attributeLocations]
		 */
		val CODEGEN_SCOPE: CodegenProvider<AttributesCodegenTraverser.IAttributeContainerCodegen> = CodegenProvider {
			CODEGEN_ATTRS.get().build()
		}
		
		val CODEGEN_TYPE = CodegenProvider {
			object : ValueDecoder<KtExpression> {
				override fun decodeValue(value: VDFValue, parentSubtree: VDFSubtree): List<KtExpression>? {
					val subtreeToCfgScope = CODEGEN_SCOPE.get().decodeToLambdaLines(value.asSubtree ?: return null).ifNullOrEmpty { return null; }!!
					return listOf(KtFunctionCall(KtName(::AttributeContainer), listOf(KtLambda(lines=subtreeToCfgScope))))
				}
			}
		}
	}
}

open class AttributeContainerImpl(protected val map: MutableMap<ItemAttribute<Any>, Any?> = mutableMapOf())
	: IAttributeContainer
{
	override operator fun iterator(): Iterator<Pair<ItemAttribute<Any>, Any?>> {
		return map.entries.asSequence().map { it.key to it.value }.iterator()
	}
	
	@Suppress("UNCHECKED_CAST")
	override operator fun <T : Any> get(key: ItemAttribute<T>): T? {
		return map[key as ItemAttribute<Any>] as T?
	}
	
	@Suppress("UNCHECKED_CAST")
	override operator fun <T : Any> set(key: ItemAttribute<T>, value: T?) {
		map[key as ItemAttribute<Any>] = value
	}
	
	override fun copy() = AttributeContainerImpl(map.toMutableMap())
}

inline fun AttributeContainer(configure: AttributeContainerImpl.() -> Unit) = AttributeContainerImpl().apply(configure)

fun IAttributeContainer.collectToSubtree(subtree: VDFSubtree) {
	iterator().forEach { (attr, value) ->
		value?.let { attr.serialize(value)._serializeInto(subtree, null) }
	}
}


class AttributeContainerSubtreeSerializable(private val impl: IAttributeContainer = AttributeContainerImpl())
	: IAttributeContainer by impl, IVDFRepresentableValue_Subtree
{
	override fun _vdfRepr(parent: VDFSubtree): VDFSubtree {
		return VDFSubtree(parent).also {
			impl.collectToSubtree(it)
		}
	}
	
	override fun copy() = AttributeContainerSubtreeSerializable(impl.copy())
}

