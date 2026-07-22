package btpos.source.vdfdsl.utils.delegates

import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

class ComposedReadWrite<T, V, V2, DELEGATE : ReadWriteProperty<T, V>>(
	val delegate: DELEGATE,
	val getter: DELEGATE.(T, KProperty<*>) -> V2,
	val setter: DELEGATE.(T, KProperty<*>, V2) -> Unit
) : ReadWriteProperty<T, V2> {
	override fun getValue(thisRef: T, property: KProperty<*>): V2 {
		return delegate.getter(thisRef, property)
	}
	
	override fun setValue(thisRef: T, property: KProperty<*>, value: V2) {
		return delegate.setter(thisRef, property, value)
	}
}