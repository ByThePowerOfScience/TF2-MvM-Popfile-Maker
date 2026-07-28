package btpos.source.vdfdsl.tf2.itemattributes

import kotlin.reflect.KProperty


@Target(AnnotationTarget.CLASS)
@Retention(AnnotationRetention.SOURCE)
annotation class SupportsCustomAssignment

interface ItemAttribute<T : Any> {
	context(attrs: IAttributeContainer)
	fun assign(value: T?) {
		attrs[this] = value
	}
	
	context(attrs: IAttributeContainer)
	fun get(): T? {
		return attrs[this]
	}
}

@SupportsCustomAssignment
data class ItemAttributeNamed<T : Any>(
	val key: String,
	val serializer: (T) -> Any = { it }
) : ItemAttribute<T> {
	override fun hashCode(): Int = key.hashCode()
	
	override fun equals(other: Any?) = key == other
	
	operator fun getValue(_self: Any?, _prop: KProperty<*>): ItemAttribute<T> = this
}


