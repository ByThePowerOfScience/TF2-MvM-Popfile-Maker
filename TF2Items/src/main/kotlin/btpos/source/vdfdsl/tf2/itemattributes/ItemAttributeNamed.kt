package btpos.source.vdfdsl.tf2.itemattributes

import btpos.source.vdfdsl.backing.VDFPrimitive
import btpos.source.vdfdsl.serialization.IVDFRepresentableKeyValue
import btpos.source.vdfdsl.serialization.IVDFRepresentableValue
import kotlin.reflect.KClass
import kotlin.reflect.KProperty

data class ItemAttributeNamed<T : Any>(
	val key: VDFPrimitive,
	val serializer: ((T) -> Any)? = null,
	val type: KClass<T>
) : ItemAttribute<T> {
	override fun hashCode(): Int = key.hashCode()
	
	override fun equals(other: Any?) = key == (other as? ItemAttributeNamed<*>)?.key
	
	operator fun getValue(_self: Any?, _prop: KProperty<*>): ItemAttributeNamed<T> = this
	
	override fun serialize(value: T?): IVDFRepresentableKeyValue {
		if (value == null)
			return IVDFRepresentableKeyValue { _, _ -> }
		
		return IVDFRepresentableValue.serializeDynamic(key, serializer?.invoke(value) ?: value)
	}
	
	context(attrs: IAttributeContainer)
	override fun get(): T? {
		return attrs[this]
	}
	
	context(attrs: IAttributeContainer)
	override fun set(value: T?) {
		attrs[this] = value
	}
	
	
	companion object {
	    inline operator fun <reified T : Any> invoke(key: String, noinline serializer: ((T) -> Any)? = null): ItemAttributeNamed<T> {
	        return ItemAttributeNamed(VDFPrimitive.notInterned(key), serializer, T::class)
	    }
	}
}