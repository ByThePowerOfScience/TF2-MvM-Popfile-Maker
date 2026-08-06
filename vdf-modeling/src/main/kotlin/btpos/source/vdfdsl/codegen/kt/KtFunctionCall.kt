package btpos.source.vdfdsl.codegen.kt

import btpos.source.vdfdsl.codegen.IKtCodeGenerator

open class KtFunctionCall(var callee: KtName, args: List<KtExpression> = listOf()) : KtExpression {
	override val importsNeeded: Sequence<String>
		get() = callee.importsNeeded + args.asSequence().flatMap { it.importsNeeded }
	
	var receiver: KtExpression? = null
	
	val args: MutableList<KtExpression> = args.toMutableList()
	
	override fun toKotlinCode(): String {
		val argsString = when {
			args.size == 1 && args[0] is KtLambda -> " " + args[0].toKotlinCode()
			args.isNotEmpty() && args.last() is KtLambda -> "(${
				args.dropLast(1).joinToString(", ") { it.toKotlinCode() }
			}) " + args.last().toKotlinCode()
			else -> "(${args.joinToString(", ") { it.toKotlinCode() }})"
		}
		
		return receiver?.let { "${it.toKotlinCode()}." }.orEmpty() + callee.toKotlinCode() + argsString
	}
	
	companion object {
		/**
		 * Create `FunctionName(...args).apply { ...body }`
		 */
		fun createApply(functionName: KtName, args: List<KtExpression>, body: List<IKtCodeGenerator>): KtFunctionCall {
			return KtFunctionCall(KtName("apply")).apply {
				receiver = KtFunctionCall(functionName, args)
				
				this.args += KtLambda().apply {
					lines += body
				}
			}
		}
	}
}