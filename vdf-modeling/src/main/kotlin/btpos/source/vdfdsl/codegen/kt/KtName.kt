package btpos.source.vdfdsl.codegen.kt

import btpos.source.vdfdsl.codegen.IKtCodeGenerator
import kotlin.jvm.kotlin
import kotlin.reflect.KFunction
import kotlin.reflect.jvm.javaConstructor
import kotlin.reflect.jvm.javaMethod

open class KtName(val name: String, val qualifier: String? = null) : IKtCodeGenerator {
	override val importsNeeded: Sequence<String> get() = qualifier?.let { sequenceOf(it + "." + name) }.orEmpty()
	
	override fun toKotlinCode(): String {
		return name
	}
	
	companion object {
	    operator fun invoke(ref: KFunction<*>): KtName {
	        val name = ref.name
		    val qualifier = (ref.javaMethod?.let {
				it.declaringClass
		    } ?: ref.javaConstructor!!.let {
			    it.declaringClass
		    }).kotlin.qualifiedName
		    
		    return KtName(name, qualifier)
	    }
	}
}