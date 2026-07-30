package btpos.source.vdfdsl.tf2.filegeneration

import btpos.source.vdfdsl.tf2.filegeneration.representations.groupings.HierarchyNamedAttributeScope

private val spaceUnderscore = Regex("[_\\s\\-]+")

fun String.camelCase(): String {
	val split = this.lowercase().split(spaceUnderscore)
	
	val camelCased = when (split.size) {
		1 -> this
		else -> split.joinToString("") { it.replaceFirstChar { it.uppercaseChar() } }
	}
	
	return camelCased.replaceFirstChar { it.lowercaseChar() }
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


