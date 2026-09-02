package btpos.source.vdfdsl.tests.valvepopfiles.codegen

import btpos.source.vdfdsl.codegen.WeirdMutableIterableSubtree
import btpos.source.vdfdsl.types.WaveSchedule
import btpos.source.vdfdsl.vdfparser.ParseVDF
import kotlin.test.Test
import kotlin.test.assertNotNull

class mvm_coaltown_expert1 {
	@Test
	fun doCodegen() {
		System.setProperty("vdfdsl.codegen", "true")
		val popfile = ParseVDF.parse(ClassLoader.getSystemResourceAsStream("mvm_coaltown_expert1.pop")!!)
		val codegen = WaveSchedule.CODEGEN_TYPE.get().decode(WeirdMutableIterableSubtree(null, popfile))
		assertNotNull(codegen)
		assert(codegen.isNotEmpty())
		codegen.forEach {
			println(it.toKotlinCode())
		}
	}
}