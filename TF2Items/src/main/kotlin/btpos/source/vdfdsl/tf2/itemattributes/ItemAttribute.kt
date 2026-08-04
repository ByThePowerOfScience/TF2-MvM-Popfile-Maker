package btpos.source.vdfdsl.tf2.itemattributes

import btpos.source.vdfdsl.serialization.IVDFRepresentableKeyValue

@MustBeDocumented
@Target(AnnotationTarget.CLASS)
@Retention(AnnotationRetention.RUNTIME)
annotation class SupportsCustomAssignment

@SupportsCustomAssignment
interface ItemAttribute<T : Any> {
	context(attrs: IAttributeContainer)
	fun set(value: T?) {
		attrs[this] = value
	}
	
	context(attrs: IAttributeContainer)
	fun get(): T? {
		return attrs[this]
	}
	
	fun serialize(value: T?): IVDFRepresentableKeyValue
}

context(attrs: IAttributeContainer)
fun <T : Any> ItemAttribute<T>.assign(value: T?) = set(value)


context(_: IAttributeContainer)
operator fun <T> ItemAttribute<List<T>>.plusAssign(item: T) {
	this.set((this.get() ?: emptyList()) + item)
}

context(_: IAttributeContainer)
operator fun <T> ItemAttribute<Set<T>>.plusAssign(item: T) {
	this.set((this.get() ?: emptySet()) + item)
}

context(_: IAttributeContainer)
operator fun <T> ItemAttribute<List<T>>.plusAssign(items: Iterable<T>) {
	this.set((this.get() ?: emptyList()) + items)
}

context(_: IAttributeContainer)
operator fun <T> ItemAttribute<Set<T>>.plusAssign(items: Iterable<T>) {
	this.set((this.get() ?: emptySet()) + items)
}