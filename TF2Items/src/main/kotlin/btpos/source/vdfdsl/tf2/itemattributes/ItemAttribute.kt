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


