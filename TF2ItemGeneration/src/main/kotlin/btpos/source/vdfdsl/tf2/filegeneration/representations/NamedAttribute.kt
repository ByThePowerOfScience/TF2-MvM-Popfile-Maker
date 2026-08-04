package btpos.source.vdfdsl.tf2.filegeneration.representations

import btpos.source.vdfdsl.tf2.filegeneration.ArmoryDesc
import btpos.source.vdfdsl.tf2.filegeneration.camelCase

/**
 * This should correspond to a raw row from the wiki table, or a raw scope from the attributes schema.
 */
data class NamedAttribute(
	val attrName: String,
	/** Like `additive_percentage` */
	val attrType: String,
	val className: String,
	val inGameDesc: String?,
	val isHidden: Boolean?,
	/** positive, negative, or null */
	val effectType: EffectType = EffectType.Neutral,
	val armory_desc: ArmoryDesc? = null
) : ISortedNamedAttribute {
	enum class EffectType {
		Positive,
		Negative,
		Neutral;
	}
	
	
	
	override fun clone(): NamedAttribute {
		return this.copy().also {
			it.forceType = forceType
			it.codec = codec
			it.varName = varName
			it.notes = notes
		}
	}
	var forceType: String? = null
	
	var codec: FakeCodec? = null
	
	override var varName: String = attrName.sanitizeNamedAttributeName().camelCase().overrideVarName()

	override var notes: List<String> = listOf()
	
	override val innateDescription: List<String> = listOfNotNull(inGameDesc).map { "In-Game: \"$it\"" }
	
	override fun getKotlinType(): String {
		codec?.let { // trust codecs over attribute class notes
			return it.visibleType
		}
		forceType?.let {
			return it.takeIf { it != "Float" && it != "Double" } ?: "Number"
		}
		
		if ("percentage" in attrType)
			return "Number"
		
		return when (attrType) {
			"additive" -> "Int"
			"particle_index" -> "Int"
			"or" -> "Boolean"
			"date" -> "Date"
			"account_id" -> "AccountId"
			"" -> "Any"
			"item_def" -> "ItemDef"
			"killstreakeffect_index" -> "Int"
			"killstreak_idleeffect_index" -> "Int"
			"from_lookup_table" -> "Int"
			else -> error("unexpected type: $attrType")
		}
	}
	
	override fun setCodec(codec: (NamedAttribute) -> FakeCodec?) {
		this.codec = codec(this)
	}
	
	override fun propertyBuilder(): PropertyBuilder {
		val codec = codec?.codecIdentifier?.let { ", $it" } ?: ""
		return PropertyBuilder(varName, "ItemAttributeNamed<${getKotlinType()}>") {
			initializer = "ItemAttributeNamed<${getKotlinType()}>(\"${attrName}\"$codec)"
			docComment += innateDescription
			if (attrName == "set_weapon_node" && "NumberSelectorCodec" in codec) {
				// don't add notes since we're autoselecting the number
			} else {
				docComment += notes
			}
		}
	}
	
	override fun toString(): String {
		return "NamedAttribute(attrName='$attrName', attrType='$attrType', clsName='$className')"
	}
	
	override fun contains(attrName: String): Boolean {
		return attrName == this.attrName
	}
}