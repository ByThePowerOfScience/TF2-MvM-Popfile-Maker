package btpos.misc.kt.codegen

interface KtElement {
	val importsNeeded: Sequence<String> get() = emptySequence()
	
	fun toKotlinCode(): String
}