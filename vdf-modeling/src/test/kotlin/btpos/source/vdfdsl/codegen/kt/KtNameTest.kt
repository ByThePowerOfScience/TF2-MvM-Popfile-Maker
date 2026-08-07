package btpos.source.vdfdsl.codegen.kt

import org.junit.jupiter.api.Assertions.*
import kotlin.test.Test

class KtNameTest {
	fun dummyFunction() {
	
	}
	
	
	@Test
	fun forFunction() {
	    val name = KtName(KtNameTest::dummyFunction)
		
		assertEquals(name.name, KtNameTest::dummyFunction.name)
		assertEquals(name.qualifier, KtNameTest::class.qualifiedName)
	}
}