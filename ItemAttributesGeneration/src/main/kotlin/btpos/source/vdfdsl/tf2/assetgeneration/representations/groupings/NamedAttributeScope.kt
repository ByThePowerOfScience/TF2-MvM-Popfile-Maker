package btpos.source.vdfdsl.tf2.assetgeneration.representations.groupings

import btpos.source.vdfdsl.tf2.assetgeneration.overrideScopeName
import btpos.source.vdfdsl.tf2.assetgeneration.representations.FakeCodec
import btpos.source.vdfdsl.tf2.assetgeneration.representations.ISortedNamedAttribute
import btpos.source.vdfdsl.tf2.assetgeneration.representations.NamedAttribute
import btpos.source.vdfdsl.tf2.assetgeneration.sanitize

/**
 * Scopes are all top-level object declarations. Any properties just reference them with getters.
 */
open class NamedAttributeScope(
	val _scopeName: String,
	vararg attrs: ISortedNamedAttribute,
	override val innateDescription: List<String> = emptyList(),
	val _varName: String? = null,
) : ISortedNamedAttribute {
	val scopeName = _scopeName.sanitize().overrideScopeName()
	
	override val varName: String = (_varName?.overrideScopeName() ?: this.scopeName).decapitalize()
	
	
	override fun clone(): ISortedNamedAttribute {
		return NamedAttributeScope(this._scopeName, attrs=attrs.map { it.clone() }.toTypedArray(), innateDescription = innateDescription, _varName=_varName)
	}
	
	val attrs = attrs.distinct()
	
	override fun propertyValue(): String {
		return clsname
	}
	
	val clsname = scopeName + "Attributes"
	
	override fun generateTopLevelMembers(): List<String> {
		val attrsInBody = attrs.joinToString("\n\n") {
			ISortedNamedAttribute.buildComment(it.innateDescription) + "\n" + it.propertyString(false)
		}.prependIndent("\t")
		
		
		return listOf(
			ISortedNamedAttribute.buildComment(innateDescription) + "\n" + """object $clsname {
	inline operator fun invoke(scope: $clsname.() -> Unit) {
		this.apply(scope)
	}""" + "\n" + attrsInBody + "\n}"
		) + attrs.flatMap { it.generateTopLevelMembers() }
	}
	
	override fun getKotlinType(): String {
		return scopeName
	}
	
	override var notes = listOf<String>()
		set(value) {
			field = value
			attrs.forEach { it.notes = value }
		}
	
	
	override fun setCodec(codec: (NamedAttribute) -> FakeCodec?) {
		this.attrs.forEach {
			it.setCodec(codec)
		}
	}
	
	override fun propertyString(isOverridden: Boolean): String {
		if (isOverridden)
			return "override val $varName get() = super.$varName"
		return "val $varName get() = ${propertyValue()}"
	}
}