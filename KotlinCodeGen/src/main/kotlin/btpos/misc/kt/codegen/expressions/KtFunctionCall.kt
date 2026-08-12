package btpos.misc.kt.codegen.expressions

import btpos.misc.kt.codegen.KtExpression
import btpos.misc.kt.codegen.identifiers.KtName
import btpos.misc.kt.codegen.KtStatement
import kotlin.collections.plusAssign

class KtFunctionCall(var callee: KtName, args: List<KtExpression> = listOf()) : KtExpression {
	override val importsNeeded: Sequence<String>
		get() = callee.importsNeeded + args.asSequence().flatMap { it.importsNeeded }
	
	var receiver: KtExpression? = null
	
	val args: MutableList<KtExpression> = args.toMutableList()
	
	override fun toKotlinCode(): String {
		val operator = if (callee.name == "invoke" && receiver != null) {
			receiver!!.toKotlinCode()
		} else {
			receiver?.let { "${it.toKotlinCode()}." }.orEmpty() + callee.toKotlinCode()
		}
		
		val operand = when {
			args.size == 1 && args[0] is KtLambda -> " " + args[0].toKotlinCode()
			args.isNotEmpty() && args.last() is KtLambda -> "(${
				args.dropLast(1).joinToString(", ") { it.toKotlinCode() }
			}) " + args.last().toKotlinCode()
			else -> "(${args.joinToString(", ") { it.toKotlinCode() }})"
		}
		
		return operator + operand
	}
	
	companion object {
		/**
		 * Create `<FunctionCall>.apply { ...body }`
		 */
		fun createApply(call: KtFunctionCall, lambdaBody: List<KtStatement>): KtFunctionCall {
			return KtFunctionCall(KtName("apply")).apply {
				receiver = call
				
				this.args += KtLambda().apply {
					lines += lambdaBody
				}
			}
		}
		
		fun KtFunctionCall.thenApply(lambdaBody: List<KtStatement>): KtFunctionCall {
			return createApply(this, lambdaBody)
		}
	}
}

open class KtNamedFunctionCallArgument(val name: String, val value: KtExpression) : KtExpression {
	override fun toKotlinCode(): String {
		return "$name = ${value.toKotlinCode()}"
	}
}