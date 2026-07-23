package btpos.source.vdfdsl.tf2.filegeneration.representations.mynotes

import btpos.source.vdfdsl.tf2.filegeneration.notesToAttrClassUsages
import btpos.source.vdfdsl.tf2.filegeneration.representations.ISortedNamedAttribute
import btpos.source.vdfdsl.tf2.filegeneration.representations.groupings.NamedAttributeScope
import btpos.source.vdfdsl.tf2.filegeneration.representations.mynotes.HierarchyAttrClassScope

open class AttrClassScope(val name: String, val attrClassesOrNestedScopes: List<IAttrThing>, applicableWeapons: List<Any> = listOf()) : IAttrThing {
	val applicableWeapons = applicableWeapons.map { if (it is String) it.split(", ") else it as List<String> }
	
	constructor(name: String, vararg attrs: IAttrThing, applicableWeapons: List<Any> = listOf()) : this(name, attrs.asList(), applicableWeapons)
	
	constructor(name: String, vararg attrClassesOrNestedScopes: Any, applicableWeapons: List<Any> = listOf()) : this(name, attrClassesOrNestedScopes.fold(mutableListOf()) { list, it ->
		when (it) {
			is String -> list.addAll(it.notesToAttrClassUsages())
			is IAttrThing -> list.add(it)
			else -> error("Expected either string or attrs")
		}
		list
	}, applicableWeapons)
	
	override operator fun contains(clsName: String): Boolean {
		return attrClassesOrNestedScopes.any { clsName in it }
	}
	
	override fun get(clsName: String): AttrClassUsage? {
		return attrClassesOrNestedScopes.firstNotNullOfOrNull { it[clsName] }
	}
	
	/**
	 * Turn this nested scoped mess of CLASSES into a nested scoped mess of NAMED ATTRIBUTES
	 */
	override fun absorb(classToNamed: Map<String, List<ISortedNamedAttribute>>): List<ISortedNamedAttribute> {
		val mapped = attrClassesOrNestedScopes.flatMap { it.absorb(classToNamed) }
		return listOf(NamedAttributeScope(this.name, *mapped.toTypedArray()))
	}
	
	override fun toString(): String {
		return "Scope(name=$name)"
	}
}