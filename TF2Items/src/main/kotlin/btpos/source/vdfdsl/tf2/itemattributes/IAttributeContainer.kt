package btpos.source.vdfdsl.tf2.itemattributes

import btpos.source.vdfdsl.backing.VDFSubtree
import btpos.source.vdfdsl.serialization.IVDFRepresentableValue_Subtree

interface IAttributeContainer {
	operator fun <T : Any> get(key: ItemAttributeNamed<T>): T?
	
	operator fun <T : Any> set(key: ItemAttributeNamed<T>, value: T?)
	
	fun copy(): IAttributeContainer
}

open class AttributeContainerImpl(protected val map: MutableMap<ItemAttributeNamed<Any>, Any?> = mutableMapOf())
	: IAttributeContainer
{
	@Suppress("UNCHECKED_CAST")
	override operator fun <T : Any> get(key: ItemAttributeNamed<T>): T? {
		return map[key as ItemAttributeNamed<Any>] as T?
	}
	
	@Suppress("UNCHECKED_CAST")
	override operator fun <T : Any> set(key: ItemAttributeNamed<T>, value: T?) {
		map[key as ItemAttributeNamed<Any>] = value
	}
	
	override fun copy() = AttributeContainerImpl(map.toMutableMap())
}


open class AttributeContainerSubtreeSerializable(_map: MutableMap<ItemAttributeNamed<Any>, Any?> = mutableMapOf())
	: AttributeContainerImpl(_map), IVDFRepresentableValue_Subtree
{
	override fun _vdfRepr(parent: VDFSubtree): VDFSubtree {
		return VDFSubtree(parent).also {
			map.forEach { (attr, value) ->
				value?.let { attr.serialize(it, null) }
			}
		}
	}
	
	override fun copy() = AttributeContainerSubtreeSerializable(map.toMutableMap())
}