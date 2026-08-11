package btpos.source.vdfdsl.codegen.kt

import btpos.misc.kt.codegen.statements.KtAssignment
import btpos.misc.kt.codegen.expressions.KtFunctionCall
import btpos.misc.kt.codegen.expressions.KtLiteral
import btpos.misc.kt.codegen.identifiers.KtName
import org.junit.jupiter.api.Test

class KtFunctionCallTest {
	@Test
	fun createApply() {
	    val x = KtFunctionCall.createApply(
		    KtFunctionCall(KtName("foo")), listOf(
			    KtAssignment(KtName("foo"), KtLiteral("bar")),
			    KtFunctionCall(KtName("Ohio"))
		))
		println(x.toKotlinCode())
	}
}