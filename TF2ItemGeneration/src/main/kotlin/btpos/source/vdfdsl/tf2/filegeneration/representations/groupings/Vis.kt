package btpos.source.vdfdsl.tf2.filegeneration.representations.groupings

import btpos.source.vdfdsl.tf2.filegeneration.representations.FakeCodec
import btpos.source.vdfdsl.tf2.filegeneration.representations.ISortedNamedAttribute
import btpos.source.vdfdsl.tf2.filegeneration.representations.NamedAttribute
import btpos.source.vdfdsl.tf2.filegeneration.representations.PropertyBuilder
import btpos.source.vdfdsl.tf2.filegeneration.representations.overrideVarName
import btpos.source.vdfdsl.tf2.filegeneration.representations.removeBonusPenaltyHiddenStuff

class Vis(
	val visible: ISortedNamedAttribute,
	val hidden: ISortedNamedAttribute,
	val _varName: String
) : ISortedNamedAttribute {
	init {
		require(visible.getKotlinType() == hidden.getKotlinType()) {
			"Visible and hidden don't share a type\n" +
			"Visible (${visible.getKotlinType()}): $visible\n" +
			"Hidden (${hidden.getKotlinType()}): $hidden"
		}
	}
	
	override fun toString(): String {
		return """Vis($visible, $hidden, "$varName")"""
	}
	
	override fun clone(): ISortedNamedAttribute {
		return Vis(visible.clone(), hidden.clone(), _varName).also {
			it.varName = varName
		}
	}
	
	override var varName: String =  visible.varName.removeBonusPenaltyHiddenStuff().overrideVarName()
	
	override val innateDescription: List<String> = buildList {
		add("Visible:")
		addAll(visible.innateDescription.filter { it.isNotBlank() }.map { "\t- $it" })
		add("")
		add("Hidden:")
		addAll(hidden.innateDescription.filter { it.isNotBlank() }.map { "\t- $it" })
	}
	
	
	override var notes: List<String> = listOf()
		set(value) {
			field = value
			visible.notes = value
			hidden.notes = value
		}
	
	
	override fun propertyBuilder(): PropertyBuilder {
		return PropertyBuilder(varName, "VisHidden<${getKotlinType()}>") {
			docComment += notes
			docComment += innateDescription
			initializer = "VisHidden(" +
			              "\n${visible.propertyBuilder().initializer.prependIndent()}," +
			              "\n${hidden.propertyBuilder().initializer.prependIndent()}" +
			              "\n)"
		}
	}
	
	override fun getKotlinType(): String {
		return visible.getKotlinType()
	}
	
	override fun setCodec(codec: (NamedAttribute) -> FakeCodec?) {
		hidden.setCodec(codec)
		visible.setCodec(codec)
	}
	
	override fun contains(attrName: String): Boolean {
		return attrName in visible || attrName in hidden
	}
}