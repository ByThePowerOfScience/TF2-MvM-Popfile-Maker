package btpos.source.vdfdsl.tf2.filegeneration.representations.mynotes

import btpos.source.vdfdsl.tf2.filegeneration.MyNotesFormatted
import btpos.source.vdfdsl.tf2.filegeneration.notesToAttrClassUsages
import btpos.source.vdfdsl.tf2.filegeneration.representations.ISortedNamedAttribute
import btpos.source.vdfdsl.tf2.filegeneration.representations.NamedAttribute
import btpos.source.vdfdsl.tf2.filegeneration.representations.attrToSelector
import btpos.source.vdfdsl.tf2.filegeneration.representations.groupings.HierarchyNamedAttributeScope

class HierarchyAttrClassScope(name: String, attrClassesOrNestedScopes: List<IAttrThing> = listOf(), applicableWeapons: List<Any> = listOf()) : AttrClassScope(name, attrClassesOrNestedScopes, applicableWeapons) {
	constructor(name: String, vararg attrClassesOrNestedScopes: Any, applicableWeapons: List<Any> = listOf()) : this(
		name,
		attrClassesOrNestedScopes.fold(mutableListOf()) { list, it ->
		when (it) {
			is String -> list.addAll(it.notesToAttrClassUsages())
			is IAttrThing -> list.add(it)
			else -> error("Expected either string or attrs")
		}
		list
	}, applicableWeapons)
	
	init {
		require(name in MyNotesFormatted.hierarchy || MyNotesFormatted.hierarchy.values.any { name in it }) { "Name $name not found in hierarchy" }
	}
	
	override fun absorb(classToNamed: Map<String, List<ISortedNamedAttribute>>): List<ISortedNamedAttribute> {
		val classToNamed = classToNamed.toMutableMap()
			.also { map ->
				val applicableWeaponModeAttrs = attrToSelector[this.name]?.keys ?: emptySet()
				if (applicableWeaponModeAttrs.isEmpty()) {
					map.remove("set_weapon_mode")
				} else {
					map["set_weapon_mode"]?.let { weaponModeAttrs ->
						map["set_weapon_mode"] = weaponModeAttrs.filter { it is NamedAttribute && it.attrName in applicableWeaponModeAttrs }
					}
				}
			}
		val mapped = attrClassesOrNestedScopes.flatMap { it.absorb(classToNamed) }
		return listOf(
			HierarchyNamedAttributeScope(
				this.name, MyNotesFormatted.getParent(this.name), *mapped.toTypedArray(), _note = applicableWeapons.takeIf { it.isNotEmpty() }
					?.flatten()
					?.joinToString(", ")
					?.let { "Items: $it" })
		)
	}
	
	override fun toString(): String {
		return "Hierarchy(name=$name)"
	}
}