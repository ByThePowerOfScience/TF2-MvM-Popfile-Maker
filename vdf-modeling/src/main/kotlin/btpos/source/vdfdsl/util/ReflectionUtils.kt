package btpos.source.vdfdsl.util

import java.lang.reflect.AccessFlag
import java.lang.reflect.Member
import kotlin.reflect.KClass
import kotlin.reflect.KProperty
import kotlin.reflect.KProperty1
import kotlin.reflect.jvm.javaField
import kotlin.reflect.jvm.javaGetter

object ReflectionUtils {
	private fun KClass<*>.getSuperTypesRecursive(): Sequence<KClass<*>> {
		return this.supertypes.asSequence().mapNotNull { it.classifier as? KClass<*> } +
		       this.supertypes.asSequence().flatMap { (it.classifier as? KClass<*>)?.getSuperTypesRecursive().orEmpty() }
	}
	
	val KClass<*>.supertypesInOrder get() = this.getSuperTypesRecursive()
	
	fun KProperty<*>.canAccess(inst: Any): Boolean {
		(this.javaGetter ?: this.javaField!!).let {
			if (it.accessFlags().contains(AccessFlag.STATIC)) {
				return it.canAccess(null)
			} else {
				return it.canAccess(inst)
			}
		}
	}
	
	
	private inline fun <T : Member, R> T.staticOrNot(ifStatic: (T) -> R, ifNotStatic: (T) -> R): R {
		if (AccessFlag.STATIC in accessFlags()) {
			return ifStatic(this)
		} else {
			return ifNotStatic(this)
		}
	}
	
	// why don't properties conform to their own contract when it's an object.
	// why are they randomly static despite not being defined as static and only allowing a get method that takes a receiver.
	// why do they not just discard the receiver.
	fun <T : Any, U> KProperty1<T, U>.actuallyGet(receiver: T): U {
		return this.javaGetter?.staticOrNot(ifStatic={ it.invoke(null) as U }, ifNotStatic = { it(receiver) as U })
	        ?: this.javaField!!.staticOrNot(ifStatic = { it.get(null) as U }, ifNotStatic = { it.get(receiver) as U })
	}
}