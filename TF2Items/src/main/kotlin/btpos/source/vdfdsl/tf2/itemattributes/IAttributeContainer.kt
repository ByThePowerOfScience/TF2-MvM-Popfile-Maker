package btpos.source.vdfdsl.tf2.itemattributes

import btpos.source.vdfdsl.backing.VDFSubtree
import btpos.source.vdfdsl.serialization.IVDFRepresentableValue_Subtree

interface IAttributeContainer : Iterable<Pair<ItemAttribute<Any>, Any?>> {
	operator fun <T : Any> get(key: ItemAttribute<T>): T?
	
	operator fun <T : Any> set(key: ItemAttribute<T>, value: T?)
	
	fun copy(): IAttributeContainer
}

open class AttributeContainerImpl(protected val map: MutableMap<ItemAttribute<Any>, Any?> = mutableMapOf())
	: IAttributeContainer
{
	override fun iterator(): Iterator<Pair<ItemAttribute<Any>, Any?>> {
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