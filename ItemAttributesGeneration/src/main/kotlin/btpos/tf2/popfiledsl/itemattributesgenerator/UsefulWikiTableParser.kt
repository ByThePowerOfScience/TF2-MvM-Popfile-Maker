package btpos.tf2.popfiledsl.itemattributesgenerator

import btpos.tf2.popfiledsl.itemattributesgenerator.ItemAttributesGeneration.BuildConfig
import java.io.FileReader

object UsefulWikiTableParser {
	val attrName = Regex("""\|name=([^|]+)\|""")
	val attrId = Regex("""\|id=([^|]+)\|""")
	val englishInGameDesc = Regex("""\|en=([^|]+)\|""")
	val attrClass = Regex("""\|class=([^|]+)\|""")
	val valueType = Regex("""\|value-type=([^|]+)\|""")
	val effectType = Regex("""\|effect-type=([^|]+)\|""")
	

	class FileToCharIteratorAdapter(val reader: FileReader) : CharIterator() {
		var haveAlreadyRetrievedNext = false
		var current: Int = -1
		
		// when calling hasnext multiple times, it should return the same result
		// when calling next, it should clear what hasnext has created already
		override fun hasNext(): Boolean {
			if (!haveAlreadyRetrievedNext) {
				current = reader.read()
				haveAlreadyRetrievedNext = true
			}
			return current != -1
		}
		
		override fun nextChar(): Char {
			if (!hasNext()) {
				throw NoSuchElementException()
			}
			return current.toChar().also {
				haveAlreadyRetrievedNext = false
			}
		}
	}
	/**
	 * Track the { and } to make sure we get a full table into a single string
	 */
	class BracketedSectionIterator(val iter: CharIterator) : Iterator<String> {
		fun getNextTable(): String? {
			val builder = StringBuilder()
			var currentNesting = 0
			for (currentChar in iter) {
				if (currentChar == '}') {
					--currentNesting
					if (currentNesting == 0)
						return builder.toString()
					else if (currentNesting < 0) {
						return null
					}
				} else if (currentChar == '{') {
					++currentNesting
				} else if (currentNesting == 0)
					continue;
				
				builder.append(currentChar)
			}
			return null;
		}
		
		private var reachedEOF = false
		private var current: String? = null
		
		override fun hasNext(): Boolean {
			if (!reachedEOF && current == null) {
				current = getNextTable()
				if (current == null)
					reachedEOF = true
			}
			
			return current != null
		}
		
		override fun next(): String {
			if (!hasNext()) {
				throw NoSuchElementException()
			}
			return current!!.also {
				current = null
			}
		}
	}
	
	fun parseWiki(): Sequence<NamedAttribute> {
		val wikiFile = BracketedSectionIterator(FileToCharIteratorAdapter(FileReader(BuildConfig.WIKI_TABLE_FILE)))
		return wikiFile.asSequence()
			.map { it.replace("\n", " ") }
			.mapNotNull {
				val name = attrName.find(it)?.groupValues?.get(1) ?: return@mapNotNull null
//				val (id) = attrId.find(it)?.destructured ?: return@mapNotNull null
				val desc = englishInGameDesc.find(it)?.groupValues?.get(1)
				val cls = attrClass.find(it)?.groupValues?.get(1) ?: return@mapNotNull null
				val valuetype = valueType.find(it)?.groupValues?.get(1) ?: return@mapNotNull null
				val effecttype = effectType.find(it)?.groupValues?.get(1)
				
				NamedAttribute(attrName = name, inGameDesc = desc, attrType = valuetype, className = cls, effectType = effecttype.orEmpty())
			}
	}
}