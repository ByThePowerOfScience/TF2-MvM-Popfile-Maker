package btpos.tf2.popfiledsl.itemattributesgenerator.representations.groupings

import btpos.tf2.popfiledsl.itemattributesgenerator.overrideVarName
import btpos.tf2.popfiledsl.itemattributesgenerator.representations.FakeCodec
import btpos.tf2.popfiledsl.itemattributesgenerator.representations.ISortedNamedAttribute
import btpos.tf2.popfiledsl.itemattributesgenerator.representations.ISortedNamedAttribute.Companion.buildComment
import btpos.tf2.popfiledsl.itemattributesgenerator.representations.NamedAttribute
import btpos.tf2.popfiledsl.itemattributesgenerator.sanitize

class Vis(
	val visible: NamedAttribute,
	val hidden: NamedAttribute,
	val additionalItems: List<NamedAttribute>,
	val _varName: String
) : ISortedNamedAttribute {
	override fun toString(): String {
		return """Vis($visible, $hidden, listOf(${additionalItems.joinToString(", ")}), "$varName")"""
	}
	
	override fun clone(): ISortedNamedAttribute {
		return Vis(visible.clone() as NamedAttribute, hidden.clone() as NamedAttribute, additionalItems.map { it.clone() } as List<NamedAttribute>, _varName)
	}
	
	override val varName: String =  visible.varName.sanitize().overrideVarName()
	
	
	constructor(visible: NamedAttribute, hidden: NamedAttribute, vararg additionalItems: NamedAttribute, varName: String = visible.varName) : this(visible, hidden, additionalItems.asList(), varName)
	
	override val innateDescription: List<String> = buildList {
		add("Visible:")
		addAll(visible.innateDescription.filter { it.isNotBlank() }.map { "\t- $it" })
		add("")
		add("Hidden:")
		addAll(hidden.innateDescription.filter { it.isNotBlank() }.map { "\t- $it" })
		for (item in additionalItems) {
			add("")
			add(item.varName.capitalize() + ":")
			addAll(item.innateDescription.filter { it.isNotBlank() }.map { "\t- $it" })
		}
	}
	
	
	override var notes: List<String> = listOf()
		set(value) {
			field = value
			visible.notes = value
			hidden.notes = value
			additionalItems.forEach { it.notes = value }
		}
	
	val customClassName = if (additionalItems.isNotEmpty()) {
		varName.capitalize() + "Attributes"
	} else null
	
	
	fun inheritedTemplate(): String {
		val attrsInBody = additionalItems.joinToString("\n\n") {
			buildComment(it.innateDescription) + "\n" + it.propertyString(false)
		}
		
		return """class $customClassName<VIS : Any, HIDDEN : Any>(vis_attrName: String, hidden_attrName: String) : VisHidden<VIS, HIDDEN>(vis_attrName, hidden_attrName) {
${attrsInBody.prependIndent("\t")}
}"""
	}
	
	
	override fun propertyString(isOverridden: Boolean): String {
		if (isOverridden)
			return "override val $varName get() = super.$varName"
		return "val $varName get() = ${propertyValue()}"
	}
	
	override fun propertyValue(): String {
		return "${getKotlinType()}(\"${visible.attrName}\", \"${hidden.attrName}\")"
	}
	
	override fun generateTopLevelMembers(): List<String> {
		return (visible.generateTopLevelMembers() + hidden.generateTopLevelMembers() + additionalItems.flatMap { it.generateTopLevelMembers() }).let {
			if (customClassName != null)
				it + inheritedTemplate()
			else
				it
		}
	}
	
	override fun getKotlinType(): String {
		return "${customClassName ?: "VisHidden"}<${visible.getKotlinType()}, ${hidden.getKotlinType()}>"
	}
	
	override fun setCodec(codec: (NamedAttribute) -> FakeCodec?) {
		hidden.setCodec(codec)
		visible.setCodec(codec)
		additionalItems.forEach { it.setCodec(codec) }
	}
	
}