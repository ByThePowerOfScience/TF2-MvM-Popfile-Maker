package btpos.tf2.popfiledsl.itemattributesgenerator

object MyNotesParser {
	
	
	data class TreeWithAttrs(
		/**
		 *
		 */
		val parentsToChildren: MutableMap<String, MutableList<String>> = mutableMapOf(),
		
		val entryAttrClasses: MutableMap<String, MutableList<AttrClassEntry>> = mutableMapOf()
	)
	
	data class AttrClassEntry(val onWhat: String, val attrClass: String, val kType: String, val notes: List<String>)
	
	fun parseMyNotes(myNotes: String): TreeWithAttrs {
		val myNotes = myNotes.split('#').asSequence().filter { it.isNotEmpty() }
		
		val inheritsFromRegex = Regex("""\(#(\w+)\)""")
		val attrEntryRegex = Regex("""^\s*-( On [\w\s]+:)? `(\w+)`: (\w+)( .*)$""")
		val alsoRegex = Regex("""^\s+- Also: """)
		val indented = Regex("""^\s+- (.+)$""")
		
		val out = TreeWithAttrs()
		
		for (note in myNotes) {
			val note = note.lines()
			val weaponClass = note[0].trim()
			val parent = inheritsFromRegex.find(note[1])?.groupValues?.get(1)
			
			val lineIter = note.iterator()
			if (!lineIter.hasNext())
				continue;
			var line = lineIter.next()
			
			
			val implementingItems = mutableListOf<String>()
			val attributes = mutableListOf<AttrClassEntry>()
			
			while (true) {
				if (line.startsWith("- Items:")) {
					implementingItems.addAll(line.substring("- Items:".length).split(",").map { it.trim() })
					continue;
				}
				if (line.matches(alsoRegex)) {
					implementingItems.addAll(line.substring("- Also:".length).split(",").map { it.trim() })
					continue;
				}
				attrEntryRegex.matchEntire(line)?.let { matchResult ->
					val (onWhat, cls, type, addtlNotes) = matchResult.destructured
					// check if the next lines are indented, indicating they're notes
					
					val notes = mutableListOf<String>()
					while (lineIter.hasNext()) {
						line = lineIter.next() // this is why the loop is weird, we need to keep this around for the next iteration to not skip a line
						indented.matchEntire(line)?.destructured?.also { (note) ->
							notes += note
						} ?: break;
					}
					attributes += AttrClassEntry(onWhat, cls, type, notes + addtlNotes)
					continue;
				}
				
				if (!lineIter.hasNext())
					break;
				line = lineIter.next()
			}
			
			parent?.let { out.parentsToChildren.computeIfAbsent(it) { mutableListOf() }.add(weaponClass) }
			out.entryAttrClasses[weaponClass] = attributes
			
		}
		
		return out;
	}
}