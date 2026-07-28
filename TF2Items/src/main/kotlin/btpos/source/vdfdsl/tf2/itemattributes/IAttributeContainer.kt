package btpos.source.vdfdsl.tf2.itemattributes

interface IAttributeContainer {
	operator fun <T : Any> get(key: ItemAttribute<T>): T?
	
	operator fun <T : Any> set(key: ItemAttribute<T>, value: T?)
}

open class AttributeContainerImpl(private val map: MutableMap<ItemAttribute<*>, Any?> = mutableMapOf())
	: IAttributeContainer
{
	@Suppress("UNCHECKED_CAST")
	override operator fun <T : Any> get(key: ItemAttribute<T>): T? {
		return map[key] as T?
	}
	
	override operator fun <T : Any> set(key: ItemAttribute<T>, value: T?) {
		map[key] = value
	}
}