package btpos.misc.kt.codegen.expressions

import btpos.misc.kt.codegen.KtExpression
import btpos.misc.kt.codegen.identifiers.KtName

data class KtThis(
	/**
	 * The `@` target for this, e.g. `this@MyClass`
	 */
	val target: KtName?
) : KtExpression {
	override fun toKotlinCode(): String {
		val x = "this"
		
		if (target != null) {
			return x + "@" + target.name
		} else {
			return x
		}
	}
	
	companion object {
		private val THIS = KtThis(null)
		
	    operator fun invoke(): KtThis {
	        return THIS
	    }
	}
}