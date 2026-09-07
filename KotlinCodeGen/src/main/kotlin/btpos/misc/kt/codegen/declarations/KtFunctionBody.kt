package btpos.misc.kt.codegen.declarations

import btpos.misc.kt.codegen.KtElement
import btpos.misc.kt.codegen.KtExpression
import btpos.misc.kt.codegen.KtStatement

sealed class KtFunctionBody : KtElement {
	abstract override fun toKotlinCode(): String
	
	data class Expression(var expression: KtExpression) : KtFunctionBody() {
		override val importsNeeded: Sequence<String>
			get() = expression.importsNeeded
		
		override fun toKotlinCode(): String {
			return "= ${expression.toKotlinCode()}"
		}
	}
	
	data class Block(val statements: MutableList<KtStatement> = mutableListOf<KtStatement>()) : KtFunctionBody() {
		override val importsNeeded: Sequence<String>
			get() = statements.asSequence().flatMap { it.importsNeeded }
		
		
		
		override fun toKotlinCode(): String {
			return " {\n\t" +
			       statements.joinToString("\n\t") { it.toKotlinCode() } +
			       "\n}"
		}
	}
}