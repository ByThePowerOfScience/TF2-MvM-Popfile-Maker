package btpos.misc.kt.codegen.identifiers

import btpos.misc.kt.codegen.KtExpression
import kotlin.reflect.KCallable
import kotlin.reflect.KClass
import kotlin.reflect.KFunction
import kotlin.reflect.KProperty
import kotlin.reflect.full.instanceParameter
import kotlin.reflect.jvm.javaConstructor
import kotlin.reflect.jvm.javaField
import kotlin.reflect.jvm.javaGetter
import kotlin.reflect.jvm.javaMethod

/**
 * The [name] of a callable.  May or may not be namespaced with [qualifier].
 */
data class KtName(val name: String, val qualifier: String? = null) : KtExpression {
	val sanitizedName = if (name in reservedWords || name.contains(re_notWord)) "`$name`" else name
	
	override val importsNeeded: Sequence<String>
		get() = qualifier?.let { sequenceOf(it + "." + sanitizedName) }.orEmpty()
	
	override fun toKotlinCode(): String {
		return sanitizedName
	}
	
	companion object {
		private val re_notWord = Regex("\\W")
		private val reservedWords = setOf(
			"as",
			"as?",
			"break",
			"class",
			"continue",
			"do",
			"else",
			"false",
			"for",
			"fun",
			"if",
			"in",
			"!in",
			"interface",
			"is",
			"!is",
			"null",
			"object",
			"package",
			"return",
			"super",
			"this",
			"throw",
			"true",
			"try",
			"typealias",
			"typeof",
			"val",
			"var",
			"when",
			"while",
		)
		
		/**
		 * The implicit name for referencing the backing field in a property's getter/setter.
		 */
		@JvmField val FIELD = KtName("field")
		
		fun qualified(fqName: String): KtName {
			val idx = fqName.lastIndexOf('.')
			return KtName(fqName.substring(0, idx), fqName.substring(idx + 1))
		}
		
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
		
		private operator fun invoke(ref: KCallable<*>, declaringClass: Class<*>): KtName {
			val qualifier = if (ref.instanceParameter == null) { // top level
				declaringClass.packageName
			} else {
				declaringClass.name
			}
			
			return KtName(ref.name, qualifier)
		}
		
		operator fun invoke(name: String, declaringClass: KClass<*>): KtName {
			return KtName(name, declaringClass.qualifiedName)
		}
	}
}