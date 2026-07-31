package btpos.source.vdfdsl.tf2.itemattributes

import btpos.source.vdfdsl.backing.VDFPrimitive
import btpos.source.vdfdsl.serialization.IVDFRepresentableKeyValue
import btpos.source.vdfdsl.serialization.IVDFRepresentableValue
import kotlin.reflect.KProperty

@MustBeDocumented
@Target(AnnotationTarget.CLASS)
@Retention(AnnotationRetention.RUNTIME)
annotation class SupportsCustomAssignment

@SupportsCustomAssignment
interface ItemAttribute<T : Any> {
	context(attrs: IAttributeContainer)
	fun set(value: T?)
	
	context(attrs: IAttributeContainer)
	fun get(): T?
}

context(attrs: IAttributeContainer)
fun <T : Any> ItemAttribute<T>.assign(value: T?) = set(value)

data class ItemAttributeNamed<T : Any>(
	val key: String,
	val serializer: ((T) -> Any)? = null
) : ItemAttribute<T> {
	private val prim by lazy {
		VDFPrimitive(key)
	}
	
	override fun hashCode(): Int = key.hashCode()
	
	override fun equals(other: Any?) = key == other
	
	operator fun getValue(_self: Any?, _prop: KProperty<*>): ItemAttribute<T> = this
	
	fun serialize(value: T, conditional: String?): IVDFRepresentableKeyValue {
		return IVDFRepresentableValue.serializeDynamic(prim, value, conditional)
	}
	
	context(attrs: IAttributeContainer)
	override fun set(value: T?) {
		attrs[this] = value
	}
	
	context(attrs: IAttributeContainer)
	override fun get(): T? {
		return attrs[this]
	}
}


