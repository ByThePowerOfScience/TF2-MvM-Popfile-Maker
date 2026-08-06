package btpos.source.vdfdsl.codegen.kt

import btpos.source.vdfdsl.codegen.IKtCodeGenerator

open class KtFunctionCall(var callee: KtQualifiedName, args: List<IKtCodeGenerator> = listOf()) : KtExpression {
	override val importsNeeded: Sequence<String>
		get() = callee.importsNeeded + args.asSequence().flatMap { it.importsNeeded }
	
	var receiver: KtExpression? = null
	
	val args = args.toMutableList()
	
	override fun toKotlinCode(): String {
		val argsString = if (args.last() is KtLambda) "(${args.dropLast(1).joinToString(", ") { it.toKotlinCode() } }) " + args.last().toKotlinCode()
		else "(${args.joinToString(", ") { it.toKotlinCode() } })"
		return receiver?.let { "$it." }.orEmpty() + callee.toKotlinCode() + argsString
	}
}