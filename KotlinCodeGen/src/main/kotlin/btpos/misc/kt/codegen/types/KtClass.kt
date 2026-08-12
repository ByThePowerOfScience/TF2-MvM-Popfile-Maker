package btpos.misc.kt.codegen.types

import btpos.misc.kt.codegen.IKtCodeGenerator
import btpos.misc.kt.codegen.identifiers.KtName
import kotlin.reflect.KClass

/**
 * The name of a class or interface. Not to be confused with [btpos.misc.kt.codegen.identifiers.KtName]
 */
data class KtClass(val fqName: String): IKtCodeGenerator {
	override val importsNeeded: Sequence<String> get() = sequenceOf(fqName)
	
	val simpleName get() = fqName.substringAfterLast('.')
	
	override fun toKotlinCode(): String {
		return simpleName
	}
	
	companion object {
		@JvmField val UNIT = KtClass("kotlin.Unit")
		
	    operator fun invoke(cls: KClass<*>): KtClass {
	        return KtClass(cls.qualifiedName ?: throw IllegalArgumentException("Cannot create KtType for class with no qualified name: $cls"))
	    }
		
		val KtClass.defaultType get() = KtSimpleType(this, false)
	}
}

/**
 * Used to reference this object instance
 */
fun KtClass.toName(): KtName {
	return KtName.qualified(fqName)
}