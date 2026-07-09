package btpos.source.vdfdsl.vdfparser

import org.junit.jupiter.api.assertAll
import org.junit.jupiter.api.assertDoesNotThrow
import kotlin.test.Test
import kotlin.test.assertContentEquals
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class VdfParserTest {
	@Test
	fun `no comments`() {
		val vdf1 = """
			Squad
			{
				FormationSize 225

				TFBot
				{
					Class Heavyweapons
					Skill Hard
					Tag special_main_left
				}
				TFBot
				{
					Class Heavyweapons
					Skill Hard
					Tag special_main_left
				}
				TFBot
				{
					Class Heavyweapons
					Skill Hard
					Tag special_main_left
				}
				TFBot
				{
					Template T_TFBot_Sniper_Huntsman
					ItemAttributes
					{
						ItemName "The Huntsman"
						"damage bonus" 0.075
						"faster reload rate" 0.4
					}
				}
				TFBot
				{
					Template T_TFBot_Sniper_Huntsman
					ItemAttributes
					{
						ItemName "The Huntsman"
						"damage bonus" 0.075
						"faster reload rate" 0.4
					}
				}
				TFBot
				{
					Template T_TFBot_Sniper_Huntsman
					ItemAttributes
					{
						ItemName "The Huntsman"
						"damage bonus" 0.075
						"faster reload rate" 0.4
					}
				}
			}
		""".trimIndent()
		
		val parsed = assertDoesNotThrow { VdfParser.parse(vdf1) }
		assertAll("rootkey",
			{ assertEquals("Squad", parsed.first) },
			{ assertTrue("rootkey.second is table") { parsed.second.isTable } }
		)
		val table = parsed.second.tableOrNull()!!
		
		assertEquals(7, table.size, "table has 7 entries")
		
		table[0].let {
			assertAll("table[0]",
				{ assertEquals("FormationSize", it.first) },
				{ assertTrue("formationsize.second is string") { it.second.isString } },
				{ assertEquals("225", it.second.stringOrNull()) }
			)
		}
		
		val rest = (1..<table.size).map {
			table[it]
		}
		
		assertAll("All rest are tfbots", *rest.flatMapIndexed { i, it -> listOf({ assertEquals("TFBot", it.first, "table[${i + 1}]") }, { assertTrue("table[${i+1}] is a table") { it.second.isTable } }) }.toTypedArray())
		
		val rest2 = rest.map { it.second.tableOrNull()!! }
		
		rest2.subList(0, 3).forEachIndexed { i, table ->
			assertContentEquals(listOf(
				Pair("Class", "Heavyweapons"),
				Pair("Skill", "Hard"),
				Pair("Tag", "special_main_left")
			), table.map { it.first to it.second.stringOrNull() }, "table[${i + 1}]")
		}
		
		rest2.drop(3).forEachIndexed { i, table ->
			val i = i + 4
			assertAll("table[$i]",
				{ assertEquals(2, table.size) },
				{ assertEquals(com.mojang.datafixers.util.Pair("Template", "T_TFBot_Sniper_Huntsman"), table[0].mapSecond { it.stringOrNull() }) },
				{ assertEquals("ItemAttributes", table[1].first) },
				{ assertContentEquals(listOf(
					"ItemName" to "The Huntsman",
					"damage bonus" to "0.075",
					"faster reload rate" to "0.4"
				), table[1].second.tableOrNull()!!.map { it.first to it.second.stringOrNull() }) }
			)
		}
	}
}