package btpos.source.vdfdsl.tf2.filegeneration.representations.groupings

import btpos.source.vdfdsl.tf2.filegeneration.hierarchiesByName
import btpos.source.vdfdsl.tf2.filegeneration.representations.ISortedNamedAttribute

class HierarchyNamedAttributeScope(scopeName: String, val extendsFrom: String?, vararg attrs: ISortedNamedAttribute, val _note: String? = null)
	: NamedAttributeScope(scopeName, attrs = attrs, mutableListOf<String>().apply { _note?.let { add(it) } })
{
	fun getParentsRecursive(): Sequence<HierarchyNamedAttributeScope> {
		return generateSequence(this.extendsFrom?.let { hierarchiesByName[it] }) { it.extendsFrom?.let { that -> hierarchiesByName[that] } }
	}
	
	init {
		hierarchiesByName[scopeName] = this
	}
	
	override fun clone(): ISortedNamedAttribute {
		return HierarchyNamedAttributeScope(_scopeName, extendsFrom, attrs=attrs.map { it.clone() }.toTypedArray(), _note)
	}
	
	override fun generateTopLevelMembers(): List<String> {
		val inherited = getParentsRecursive().flatMap { it.attrs }.toList()
		
		fun getOverriddenAttribute(attr: ISortedNamedAttribute): ISortedNamedAttribute? {
			return inherited.firstOrNull { it.varName == attr.varName }
		}
		
		// For the comments: if it extends a property, tack on the parent's entire comment and don't use any innate description, and also tack on its notes.
		val attrsInBody = attrs.joinToString("\n\n") { attr ->
			val overridesAttr = getOverriddenAttribute(attr)
			val comment = ISortedNamedAttribute.buildComment(overridesAttr?.let { overridden -> overridden.innateDescription + "" + overridden.notes + attr.notes }
			                                                 ?: (attr.innateDescription + "" + attr.notes))
			
			comment + "\n" + attr.propertyString(overridesAttr != null)
		}
		
		return listOf(
			ISortedNamedAttribute.buildComment(this.innateDescription) + "\n" +
			"""interface $clsname : ${extendsFrom?.let { "${it}Attributes, " } ?: ""}IBlockScoped {
	companion object : $clsname
	
${attrsInBody.prependIndent("\t")}
}""") + attrs.filter { getOverriddenAttribute(it) == null }.flatMap { it.generateTopLevelMembers() }
	}
}