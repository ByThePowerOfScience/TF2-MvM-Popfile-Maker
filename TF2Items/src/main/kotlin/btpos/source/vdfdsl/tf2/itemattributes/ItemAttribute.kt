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
	
	context(attrs: IAttributeContainer)
	fun assign(value: T?) = set(value)
}


@JvmName("plusAssignList")
context(_: IAttributeContainer)
operator fun <T> ItemAttribute<List<T>>.plusAssign(item: T) {
	this.set((this.get() ?: emptyList()) + item)
}

@JvmName("plusAssignSet")
context(_: IAttributeContainer)
operator fun <T> ItemAttribute<Set<T>>.plusAssign(item: T) {
	this.set((this.get() ?: emptySet()) + item)
}

@JvmName("plusAssignListIterable")
context(_: IAttributeContainer)
operator fun <T> ItemAttribute<List<T>>.plusAssign(items: Iterable<T>) {
	this.set((this.get() ?: emptyList()) + items)
}

@JvmName("plusAssignSetIterable")
context(_: IAttributeContainer)
operator fun <T> ItemAttribute<Set<T>>.plusAssign(items: Iterable<T>) {
	this.set((this.get() ?: emptySet()) + items)
}