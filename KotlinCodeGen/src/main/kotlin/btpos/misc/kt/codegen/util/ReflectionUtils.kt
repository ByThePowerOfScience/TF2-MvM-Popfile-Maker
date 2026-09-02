package btpos.misc.kt.codegen.util

import btpos.misc.kt.codegen.identifiers.KtName
import java.lang.reflect.AccessFlag
import java.lang.reflect.Member
import kotlin.reflect.KClass
import kotlin.reflect.KClassifier
import kotlin.reflect.KFunction
import kotlin.reflect.KProperty
import kotlin.reflect.KProperty1
import kotlin.reflect.KTypeParameter
import kotlin.reflect.full.declaredMemberProperties
import kotlin.reflect.full.extensionReceiverParameter
import kotlin.reflect.jvm.javaConstructor
import kotlin.reflect.jvm.javaField
import kotlin.reflect.jvm.javaGetter
import kotlin.reflect.jvm.javaMethod

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
	
	val KFunction<*>.declaringClass: KClass<*>
		get() = (this.javaMethod?.declaringClass ?: this.javaConstructor!!.declaringClass).kotlin
	
	val KProperty<*>.declaringClass: KClass<*>
		get() = (this.javaField?.declaringClass ?: this.javaGetter!!.declaringClass).kotlin
	
	val KFunction<*>.fqName: KtName
		get() {
			val decl = declaringClass
			if (decl.isTopLevelClass)
				return KtName(this.name, decl.java.packageName) // skip class name in qualifier
			
			return KtName(this.name, decl.qualifiedName)
		}
	
	val KProperty<*>.fqName: KtName
		get() {
			val decl = declaringClass
			if (decl.isTopLevelClass)
				return KtName(this.name, decl.java.packageName) // skip class name in qualifier
			
			return KtName(this.name, decl.qualifiedName)
		}
	
	val KClass<*>.isTopLevelClass: Boolean
		get() = this.simpleName.let { it != null && it.endsWith("Kt") }
	
	val KProperty<*>.isExtension get() = this.extensionReceiverParameter != null
	
	
	/**
	 * Remove star projection that randomly gets added to the properties that makes the `get` method unusable
	 */
	@Suppress("UNCHECKED_CAST")
	fun <T : Any> KClass<T>.declaredMemberPropertiesGettable() = this.declaredMemberProperties as Collection<KProperty1<Any, Any>>
	
	/**
	 * Turn a classifier that might be a type parameter into whatever upper bounds have a real class, or empty if nothing exists
	 */
	fun KClassifier.getUpperBounds(): Sequence<KClass<*>> {
		return when (this) {
			is KClass<*> -> sequenceOf(this)
			is KTypeParameter -> upperBounds.asSequence()
				.flatMap { it.classifier?.getUpperBounds().orEmpty() }
			else -> error("Unrecognized KClassifier subclass '${this::class.qualifiedName}' for pseudo-sealed KClassifier class.")
		}
	}
}