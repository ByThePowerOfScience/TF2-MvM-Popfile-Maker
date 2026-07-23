package btpos.source.vdfdsl.tf2.filegeneration

import btpos.source.vdfdsl.tf2.filegeneration.representations.groupings.HierarchyNamedAttributeScope
import btpos.source.vdfdsl.tf2.filegeneration.representations.removeFromPBName
import btpos.source.vdfdsl.tf2.filegeneration.representations.removeFromThing

private val spaceUnderscore = Regex("[_\\s\\-]+")
fun String.camelCase(): String {
	val split = this.lowercase().split(spaceUnderscore)
	if (split.size == 1) {
		return this.replaceFirstChar { it.lowercaseChar() }
	}
	val camelCase = split.joinToString("") { it.replaceFirstChar { it.uppercaseChar() } }.replaceFirstChar { it.lowercaseChar() }
	
	return camelCase
}


class ArmoryDesc(val all: List<String>) {
	
	companion object {
	    operator fun invoke(item: String?): ArmoryDesc? {
	        return item?.let { it.split(' ') }?.let { ArmoryDesc(it) }
	    }
	}
	
	val isOnHit get() = "on_hit" in all
	
	val isOnWearer get() = "on_wearer" in all
	
	val isOnActive get() = "on_active" in all
}


val hierarchiesByName = mutableMapOf<String, HierarchyNamedAttributeScope>()

fun String.sanitize(): String {
	return (removeFromPBName + removeFromThing).fold(this) { it, re -> it.replace(re, "") }
}


