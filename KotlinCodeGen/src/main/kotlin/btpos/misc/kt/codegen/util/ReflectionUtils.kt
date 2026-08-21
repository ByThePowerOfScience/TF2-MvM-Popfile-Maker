package btpos.misc.kt.codegen.util

import btpos.misc.kt.codegen.identifiers.KtName
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
	 * Turn a classifier that might be a type parameter into whatever upper bound has a real class if it is one, or null if nothing exists
	 */
	fun KClassifier.toAbsoluteType(): KClass<*>? {
		return when (this) {
			is KClass<*> -> this
			is KTypeParameter -> upperBounds.firstNotNullOfOrNull { it.classifier }?.toAbsoluteType()
			else -> error("Unrecognized KClassifier subclass '${this::class.qualifiedName}' for pseudo-sealed KClassifier class")
		}
	}
}