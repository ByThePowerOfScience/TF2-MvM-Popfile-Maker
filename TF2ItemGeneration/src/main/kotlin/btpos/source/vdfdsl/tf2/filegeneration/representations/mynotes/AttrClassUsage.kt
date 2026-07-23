package btpos.source.vdfdsl.tf2.filegeneration.representations.mynotes

import btpos.source.vdfdsl.tf2.filegeneration.representations.ISortedNamedAttribute
import btpos.source.vdfdsl.tf2.filegeneration.representations.attrToSelector
import btpos.source.vdfdsl.tf2.filegeneration.representations.bool
import btpos.source.vdfdsl.tf2.filegeneration.representations.customCodecs
import btpos.source.vdfdsl.tf2.filegeneration.representations.selectorCodec

class AttrClassUsage(val attr_class: String, val kType: String, notes: List<String> = listOf()) : IAttrThing {
	val notes = notes.map { if (!it.endsWith('.')) it + '.' else it }
	
	
	override fun get(clsName: String): AttrClassUsage? {
		if (this.attr_class == clsName)
			return this
		return null
	}
	companion object {
		val linkRegex = Regex("""\[\w+]\(#(\w+)\)""")
		val attrRegex = Regex("""^\s*-\s*(?:On (\w+):)?\s*`(\w+)`: (?:(\w+)|$linkRegex)(\s*\W.+)?$""")
		val noteRegex = Regex("""^\s*-\s*(\w.+)$""")
		
		operator fun invoke(string: String, notes: List<String> = listOf()): AttrClassUsage {
			val (onWhat, cls, type, _extratypeinfo) = attrRegex.matchEntire(string)?.destructured
			                                          ?: error("Failed to parse attr entry for $string")
			
			val type2 = linkRegex.find(type)?.groupValues?.get(1) ?: type
			
			val notes2 = notes.map { noteRegex.matchEntire(it)!!.groupValues[1] } +
			             listOfNotNull(
							 onWhat.takeIf { it.isNotBlank() }?.let { "Checked on $it" },
							 _extratypeinfo.takeIf { it.isNotBlank() }
						 )
			
			return AttrClassUsage(cls, type2, notes2)
		}
		
		operator fun invoke(string: String): AttrClassUsage {
			val split = string.split("\n").filter { it.isNotBlank() }.ifEmpty {
				error("Empty string passed to AttrClassUsage factory")
			}
			val (onWhat, name, type, _) = attrRegex.matchEntire(split[0])?.destructured
			                              ?: error("Failed to match attr entry ${split[0]}")
			val notes = split.drop(1)
				.mapNotNull {
					noteRegex.matchEntire(it)?.groupValues[1]
				} + listOfNotNull(onWhat.takeIf { !it.isEmpty() }?.let { "Checked on $it." })
			
			return AttrClassUsage(name, type, notes)
		}
		
	}
	
	override fun contains(clsName: String): Boolean {
		return attr_class == clsName
	}
	
	
	override fun absorb(classToNamed: Map<String, List<ISortedNamedAttribute>>): List<ISortedNamedAttribute> {
		return classToNamed[attr_class]?.map { attr ->
			attr.clone()
				.apply {
					setCodec {
						if (attr_class == "set_weapon_mode") {
							selectorCodec(
								attrToSelector.values.flatMap { it.entries }
									.find { (k, v) -> k == it.attrName }?.value
								?: error("no selector found for ${it.attrName}")
							)
						} else if (kType == "Boolean") {
							bool
						} else {
							customCodecs[it.className] ?: it.codec
						}
					}
					notes = this@AttrClassUsage.notes
				}
		}
			.orEmpty()
	}
	
	override fun toString(): String {
		return "Usage(class=$attr_class)"
	}
}