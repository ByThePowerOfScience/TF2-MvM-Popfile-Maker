package btpos.misc.kt.codegen.identifiers

import btpos.misc.kt.codegen.IKtCodeGenerator
import kotlin.reflect.KClass

/**
 * The name of a class or interface. Not to be confused with [KtName]
 */
data class KtType(val fqName: String): IKtCodeGenerator {
	override val importsNeeded: Sequence<String> get() = sequenceOf(fqName)
	
	override fun toKotlinCode(): String {
		return fqName.substringAfterLast('.')
	}
	
	companion object {
		@JvmField val UNIT = KtType("kotlin.Unit")
		
	    operator fun invoke(cls: KClass<*>): KtType {
	        return KtType(cls.qualifiedName ?: throw IllegalArgumentException("Cannot create KtType for class with no qualified name: $cls"))
	    }
	}
}