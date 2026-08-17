package btpos.misc.kt.codegen.util

import btpos.misc.kt.codegen.identifiers.KtName
import com.squareup.kotlinpoet.FunSpec
import kotlin.reflect.KClass
import kotlin.reflect.KFunction
import kotlin.reflect.KProperty
import kotlin.reflect.full.extensionReceiverParameter
import kotlin.reflect.jvm.javaConstructor
import kotlin.reflect.jvm.javaMethod

object ReflectionUtils {
	val KFunction<*>.declaringClass: KClass<*>
		get() = (this.javaMethod?.declaringClass ?: this.javaConstructor!!.declaringClass).kotlin
	
	val KFunction<*>.fqName: KtName
		get() {
			val decl = declaringClass
			if (decl.isTopLevelClass)
				return KtName(this.name, decl.java.packageName) // skip class name in qualifier
			
			return KtName(this.name, decl.qualifiedName)
		}
	
	val KClass<*>.isTopLevelClass: Boolean
		get() = this.simpleName.let { it != null && it.endsWith("Kt") }
	
	val KProperty<*>.isExtension get() = this.extensionReceiverParameter != null
}