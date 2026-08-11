package btpos.misc.kt.codegen

interface IKtCodeGenerator {
	val importsNeeded: Sequence<String> get() = emptySequence()
	
	fun toKotlinCode(): String
}