package btpos.source.vdfdsl.tf2.itemattributes

import btpos.misc.kt.codegen.KtExpression
import btpos.misc.kt.codegen.expressions.KtFunctionCall
import btpos.misc.kt.codegen.expressions.KtLambda
import btpos.misc.kt.codegen.identifiers.KtName
import btpos.source.vdfdsl.backing.VDFObject
import btpos.source.vdfdsl.backing.VDFPrimitive
import btpos.source.vdfdsl.backing.VDFSubtree
import btpos.source.vdfdsl.backing.asSubtree
import btpos.source.vdfdsl.codegen.CodegenProvider
import btpos.source.vdfdsl.codegen.ValueDecoder
import btpos.source.vdfdsl.serialization.IVDFRepresentableValue_Subtree

interface IAttributeContainer {
	operator fun <T : Any> get(key: ItemAttribute<T>): T?
	
	operator fun <T : Any> set(key: ItemAttribute<T>, value: T?)
	
	fun copy(): IAttributeContainer
	
	operator fun iterator(): Iterator<Pair<ItemAttribute<Any>, Any?>>
	
	companion object {
		/**
		 * A map of "named attribute" to "location of that attribute in code", like this:
		 * - `"fire rate bonus"` -> "WeaponBaseAttributes.Inherited.fireRate.bonus"
		 * there's something we could do here with actual decoders that extract from the subtree, though.
		 * Like each sub-thing finding all of the ones that can be grouped into a single scope.
		 *
		 * oh but that doesn't work with extensibility nvm
		 */
		val CODEGEN_ATTRIBUTE_LOCATIONS = CodegenProvider {
			HashMap<VDFPrimitive, KtExpression>()
		}
		
		val CODEGEN_SCOPE = CodegenProvider<ScopeCodegen> {
			TODO()
		}
		
		val CODEGEN_TYPE = CodegenProvider {
			ValueDecoder<KtExpression> { obj ->
				val subtreeToCfgScope = obj.asSubtree?.let { CODEGEN_SCOPE.get().decodeValue(it) }
				              ?: return@ValueDecoder null;
				listOf(KtFunctionCall(KtName(::AttributeContainer), listOf(subtreeToCfgScope)))
			}
		}
	}
	
	class ScopeCodegen : ValueDecoder<KtLambda> {
		override fun decodeValue(value: VDFObject, parentSubtree: VDFSubtree): List<KtLambda>? {
			return value.asSubtree?.let { listOfNotNull(decodeValue(it)) }
		}
		
		
		fun decodeValue(subtree: VDFSubtree): KtLambda? {
		
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
		value?.let { attr.serialize(value)._serializeInto(subtree) }
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

