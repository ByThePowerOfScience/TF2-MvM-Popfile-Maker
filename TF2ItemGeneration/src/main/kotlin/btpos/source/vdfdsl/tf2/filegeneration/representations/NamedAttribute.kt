package btpos.source.vdfdsl.tf2.filegeneration.representations

import btpos.source.vdfdsl.tf2.filegeneration.ArmoryDesc
import btpos.source.vdfdsl.tf2.filegeneration.UsefulWikiTableParser.attrName
import btpos.source.vdfdsl.tf2.filegeneration.camelCase
import btpos.source.vdfdsl.tf2.filegeneration.unaryPlus

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
	
	override val innateDescription: List<String> get() = listOfNotNull(
		inGameDesc?.let {"In-Game: \"$it\"" },
//		when (attrType) {
//			"percentage", "inverted_percentage" -> "a multiplier".takeIf {
//				"mult" !in this.varName && notes.none { it.contains("multiplier", ignoreCase = true) }
//			}
//			"additive" -> null
//			"additive_percentage" -> "an additive percentage"
//			else -> null
//		}?.let { "Value is $it." }
	)
	
	override fun getKotlinType(): String {
		codec?.let { // trust codecs over attribute class notes
			return it.visibleType
		}
		
		if ("percentage" in attrType) // trust percentage over in-game usage, since those can be applied like that
			return "Number"
		
		forceType?.let {
			return it.takeIf { it != "Float" && it != "Double" } ?: "Number"
		}
		
		return when (attrType) {
			"additive" -> "Int"
			"additive_percentage" -> "Number" // TODO force-type these manually
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