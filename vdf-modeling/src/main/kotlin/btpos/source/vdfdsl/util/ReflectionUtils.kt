package btpos.source.vdfdsl.util

import kotlin.reflect.KClass

object ReflectionUtils {
	private fun KClass<*>.getSuperTypesRecursive(): Sequence<KClass<*>> {
		return this.supertypes.asSequence().mapNotNull { it.classifier as? KClass<*> } +
		       this.supertypes.asSequence().flatMap { (it.classifier as? KClass<*>)?.getSuperTypesRecursive().orEmpty() }
	}
	
	val KClass<*>.supertypesInOrder get() = this.getSuperTypesRecursive()
}