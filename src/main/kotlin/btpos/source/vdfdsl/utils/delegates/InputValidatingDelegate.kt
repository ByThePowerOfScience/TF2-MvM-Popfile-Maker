package btpos.source.vdfdsl.utils.delegates

import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

class InputValidatingDelegate<T, V>(
	val delegate: ReadWriteProperty<T, V>,
	val inputValidator: (V) -> Result<V>
) : ReadWriteProperty<T, V> {
	override fun getValue(thisRef: T, property: KProperty<*>): V {
		return delegate.getValue(thisRef, property)
	}
	
	override fun setValue(thisRef: T, property: KProperty<*>, value: V) {
		val newValue = inputValidator(value).getOrThrow()
		
		return delegate.setValue(thisRef, property, newValue)
	}
}

fun <T, V> ReadWriteProperty<T, V>.withSetter(validator: (V) -> Result<V>) = InputValidatingDelegate(this, validator)