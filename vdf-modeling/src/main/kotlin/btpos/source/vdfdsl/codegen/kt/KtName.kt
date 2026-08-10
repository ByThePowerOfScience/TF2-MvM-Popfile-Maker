package btpos.source.vdfdsl.codegen.kt

import btpos.source.vdfdsl.codegen.IKtCodeGenerator
import kotlin.error
import kotlin.reflect.KCallable
import kotlin.reflect.KClass
import kotlin.reflect.KFunction
import kotlin.reflect.KProperty
import kotlin.reflect.full.instanceParameter
import kotlin.reflect.jvm.javaConstructor
import kotlin.reflect.jvm.javaField
import kotlin.reflect.jvm.javaGetter
import kotlin.reflect.jvm.javaMethod

open class KtName(val name: String, val qualifier: String? = null) : KtExpression {
	override val importsNeeded: Sequence<String> get() = qualifier?.let { sequenceOf(it + "." + name) }.orEmpty()
	
	override fun toKotlinCode(): String {
		return name
	}
	
	companion object {
		fun qualified(fqName: String): KtName {
			val idx = fqName.lastIndexOf('.')
			return KtName(fqName.substring(0, idx), fqName.substring(idx + 1))
		}
		
		operator fun invoke(cls: KClass<*>) = qualified(cls.qualifiedName ?: error("Cannot create code generation for a class with no name: $cls"))
		
	    operator fun invoke(ref: KFunction<*>): KtName {
		    val declaringClass = (ref.javaMethod?.let {
			    it.declaringClass
		    } ?: ref.javaConstructor!!.let {
			    it.declaringClass
		    })
		    
		    return invoke(ref, declaringClass)
	    }
		
		operator fun invoke(ref: KProperty<*>): KtName {
			return invoke(ref, ref.javaGetter?.declaringClass ?: ref.javaField!!.declaringClass)
	    }
		
		operator fun invoke(ref: KCallable<*>, declaringClass: Class<*>): KtName {
			val qualifier = if (ref.instanceParameter == null) { // top level
				declaringClass.packageName
			} else {
				declaringClass.name
			}
			
			return KtName(ref.name, qualifier)
		}
	}
}