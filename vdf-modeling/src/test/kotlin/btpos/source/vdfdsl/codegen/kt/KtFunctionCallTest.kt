package btpos.source.vdfdsl.codegen.kt

import org.junit.jupiter.api.Test

class KtFunctionCallTest {
	@Test
	fun createApply() {
	    val x = KtFunctionCall.createApply(KtName("foo"), listOf(), listOf(
		    KtAssignmentExpression(KtName("foo"), KtLiteral("bar")),
		    KtFunctionCall(KtName("Ohio"))
		))
		println(x.toKotlinCode())
	}
}