package btpos.source.vdfdsl.vdfparser

import btpos.source.vdfdsl.backing.asPrimitive
import btpos.source.vdfdsl.backing.asSubtree
import org.junit.jupiter.api.assertAll
import org.junit.jupiter.api.assertDoesNotThrow
import kotlin.test.Test
import kotlin.test.assertContentEquals
import kotlin.test.assertEquals
import kotlin.test.assertNotNull

class VdfParserTest {
	@Test
	fun `no comments`() {
		val vdf1 = """Squad
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
}"""
		
		val parsed = assertDoesNotThrow { ParseVDF.parse(vdf1.byteInputStream()) }.keyvalues.single()
		assertAll("rootkey",
			{ assertEquals("Squad", parsed.key.stringValue) },
			{ assertNotNull(parsed.value.asSubtree, "rootkey.value is table") }
		)
		val table = assertNotNull(parsed.value.asSubtree).also {
			assertEquals(7, it.size, "table has 7 entries")
		}
		
		
		table[0].let {
			assertAll("table[0]",
				{ assertEquals("FormationSize", it.key.stringValue) },
				{ assertNotNull(it.value.asPrimitive?.stringValue, "formationsize.value is string") { assertEquals("225", it) } },
			)
		}
		
		val rest = (1..<table.size).map {
			table[it]
		}
		
		assertAll(
			"All rest are tfbots",
			rest.flatMapIndexed { i, it ->
				listOf(
					{ assertEquals("TFBot", it.key.stringValue, "table[${i + 1}]") },
					{ assertNotNull(it.value.asSubtree, "table[${i+1}] is a table") }
				)
			}
		)
		
		val rest2 = rest.map { it.value.asSubtree!! }
		
		rest2.subList(0, 3).forEachIndexed { i, table ->
			assertContentEquals(
				listOf(
					Pair("Class", "Heavyweapons"),
					Pair("Skill", "Hard"),
					Pair("Tag", "special_main_left")
				),
				table.map { it.key.stringValue to assertNotNull(it.value.asPrimitive?.stringValue, "value not string for key ${it.key}") },
				"table[${i + 1}]"
			)
		}
		
		rest2.drop(3).forEachIndexed { i, table ->
			val i = i + 4
			assertAll("table[$i]",
				{ assertEquals(2, table.size) },
				{ assertEquals("Template", table[0].key.stringValue) },
				{ assertEquals("T_TFBot_Sniper_Huntsman", table[0].value.asPrimitive?.stringValue) },
				{ assertEquals("ItemAttributes", table[1].key.stringValue) },
				{
					assertContentEquals(listOf(
							"ItemName" to "The Huntsman",
							"damage bonus" to "0.075",
							"faster reload rate" to "0.4"
						),
						assertNotNull(table[1].value.asSubtree)
							.map { it.key.stringValue to it.value.asPrimitive?.stringValue }
					)
				}
			)
		}
	}
}