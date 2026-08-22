package btpos.misc.kt.codegen.identifiers

import btpos.misc.kt.codegen.KtExpression
import btpos.misc.kt.codegen.types.KtClass
import btpos.misc.kt.codegen.types.KtType
import btpos.misc.kt.codegen.types.toName
import kotlin.reflect.KClass

data class KtObjectReference(val type: KtClass) : KtExpression {
	constructor(klass: KClass<*>) : this(KtClass(klass))
	
	override val importsNeeded: Sequence<String>
		get() = type.importsNeeded
	
	override fun toKotlinCode(): String {
		return type.simpleName
	}
}