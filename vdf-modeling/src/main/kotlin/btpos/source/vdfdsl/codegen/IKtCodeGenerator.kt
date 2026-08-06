package btpos.source.vdfdsl.codegen

fun interface IKtCodeGenerator {
	val importsNeeded: Sequence<String> get() = emptySequence()
	
	fun toKotlinCode(): String
}
