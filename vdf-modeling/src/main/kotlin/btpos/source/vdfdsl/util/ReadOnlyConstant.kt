package btpos.source.vdfdsl.util

import kotlin.properties.ReadOnlyProperty
import kotlin.reflect.KProperty

class ReadOnlyConstant<T>(val item: T) : ReadOnlyProperty<Any?, T> {
	override fun getValue(thisRef: Any?, property: KProperty<*>): T {
		return item
	}
}