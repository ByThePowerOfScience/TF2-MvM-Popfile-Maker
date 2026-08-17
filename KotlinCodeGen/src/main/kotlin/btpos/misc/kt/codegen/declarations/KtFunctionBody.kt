package btpos.misc.kt.codegen.declarations

import btpos.misc.kt.codegen.KtElement
import btpos.misc.kt.codegen.KtExpression
import btpos.misc.kt.codegen.KtStatement

sealed class KtFunctionBody : KtElement {
	abstract override fun toKotlinCode(): String
	
	class Expression(var expression: KtExpression) : KtFunctionBody() {
		override val importsNeeded: Sequence<String>
			get() = expression.importsNeeded
		
		override fun toKotlinCode(): String {
			return "= ${expression.toKotlinCode()}"
		}
	}
	
	class Block : KtFunctionBody() {
		override val importsNeeded: Sequence<String>
			get() = statements.asSequence().flatMap { it.importsNeeded }
		
		val statements = mutableListOf<KtStatement>()
		
		override fun toKotlinCode(): String {
			return " {\n\t" +
			       statements.joinToString("\n\t") { it.toKotlinCode() } +
			       "\n}"
		}
	}
}