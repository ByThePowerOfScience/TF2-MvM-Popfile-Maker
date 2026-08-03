package btpos.source.vdfdsl.tf2.itemattributes

import btpos.source.vdfdsl.backing.VDFPrimitive
import btpos.source.vdfdsl.serialization.IVDFRepresentableKeyValue
import btpos.source.vdfdsl.serialization.IVDFRepresentableValue
import kotlin.reflect.KProperty

open class ItemAttributeNamed<T : Any>(
	val key: String,
	val serializer: ((T) -> Any)? = null
) : ItemAttribute<T> {
	private val prim by lazy {
		VDFPrimitive.Companion(key)
	}
	
	override fun hashCode(): Int = key.hashCode()
	
	override fun equals(other: Any?) = key == other
	
	operator fun getValue(_self: Any?, _prop: KProperty<*>): ItemAttributeNamed<T> = this
	
	override fun serialize(value: T?): IVDFRepresentableKeyValue {
		if (value == null)
			return IVDFRepresentableKeyValue {}
		
		return IVDFRepresentableValue.serializeDynamic(prim, serializer?.invoke(value) ?: value)
	}
	
	context(attrs: IAttributeContainer)
	override fun get(): T? {
		return attrs[this]
	}
	
	context(attrs: IAttributeContainer)
	override fun set(value: T?) {
		attrs[this] = value
	}
	
}