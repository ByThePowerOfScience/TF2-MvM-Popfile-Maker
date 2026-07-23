package btpos.source.vdfdsl.tf2.filegeneration.representations.mynotes

import btpos.source.vdfdsl.tf2.filegeneration.representations.ISortedNamedAttribute

sealed interface IAttrThing {
	operator fun contains(clsName: String): Boolean
	
	operator fun get(clsName: String): AttrClassUsage?
	
	fun absorb(classToNamed: Map<String, List<ISortedNamedAttribute>>): List<ISortedNamedAttribute>
}