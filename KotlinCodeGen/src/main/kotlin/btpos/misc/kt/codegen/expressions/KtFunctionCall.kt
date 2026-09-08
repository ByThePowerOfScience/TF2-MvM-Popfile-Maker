package btpos.misc.kt.codegen.expressions

import btpos.misc.kt.codegen.KtExpression
import btpos.misc.kt.codegen.KtStatement
import btpos.misc.kt.codegen.identifiers.KtCallable
import btpos.misc.kt.codegen.identifiers.KtMemberReference
import btpos.misc.kt.codegen.identifiers.StandardNames
import kotlin.collections.plusAssign

data class KtFunctionCall(
	var callee: KtCallable,
	val args: MutableList<KtExpression> = mutableListOf(),
	var receiver: KtExpression? = null
) : KtExpression {
	constructor(callee: KtCallable, args: Iterable<KtExpression>) : this(callee, args.toMutableList())
	
	override val importsNeeded: Sequence<String>
		get() = callee.importsNeeded + args.asSequence().flatMap { it.importsNeeded }
	
	override fun toKotlinCode(): String {
		val operator = if (callee.callableName.name == "invoke" && receiver != null) {
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
			return KtFunctionCall(KtMemberReference(StandardNames.FUNC_APPLY, isExtension = true)).apply {
				this.receiver = call
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