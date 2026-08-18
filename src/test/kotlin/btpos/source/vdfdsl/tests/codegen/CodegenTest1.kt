package btpos.source.vdfdsl.tests.codegen

import btpos.source.vdfdsl.backing.VDFSubtree
import btpos.source.vdfdsl.codegen.Decoders
import btpos.source.vdfdsl.types.bots.BotSkill
import btpos.source.vdfdsl.types.bots.TFClass
import btpos.source.vdfdsl.types.spawners.AbstractSpawner
import btpos.source.vdfdsl.types.spawners.Spawners.TFBot
import btpos.source.vdfdsl.types.spawners.skill
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Test

class CodegenTest1 {
	
	@Test
	fun basic() {
		val spawner = VDFSubtree(VDFSubtree(null)).also {
			TFBot {
				`class` = TFClass.HeavyWeapons
				skill = BotSkill.Hard
				autoJumpMin = 100
				autoJumpMax = 25
			}._serializeInto(it)
		}
		
		val toCode = Decoders.getDecoder(AbstractSpawner::class)?.decode(spawner)
//		assertEquals(
//			KtFunctionCall(
//				KtName(Spawners::TFBot),
//				listOf(
//
//				)
//			),
//			toCode.first())
		
		
		println(AbstractSpawner.CODEGEN_NAV.get().decode(spawner.first()).forEach {
			println(it.toKotlinCode())
		})
	}
	
	companion object {
		@JvmStatic
		@BeforeAll
		fun foo() {
			System.setProperty("vdfdsl.codegen", "true")
		}
	}
}