package btpos.source.vdfdsl.util

import kotlin.properties.PropertyDelegateProvider
import kotlin.reflect.KProperty

class TrivialDelegateProvider<O, T>(private val value: T) : PropertyDelegateProvider<O, T> {
	override fun provideDelegate(thisRef: O, property: KProperty<*>): T {
		return value
	}
}