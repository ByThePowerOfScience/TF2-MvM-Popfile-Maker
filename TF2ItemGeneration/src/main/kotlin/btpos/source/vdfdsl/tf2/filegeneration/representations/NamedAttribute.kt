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
	/** positive, negative, or null */
	val effectType: String? = null,
	val armory_desc: ArmoryDesc? = null
) : ISortedNamedAttribute {
	override fun clone(): ISortedNamedAttribute {
		return this.copy().also {
			it.forceType = forceType
			it.codec = codec
			it.varName = varName
			it.notes = notes
		}
	}
	var forceType: String? = null
	
	var codec: FakeCodec? = null
	
	override var varName: String = attrName.replace(Regex("^mod[ _]"), "").replace("SPELL", "spell").replace(":", " ").camelCase().overrideVarName()
	
	override val innateDescription: List<String> = listOfNotNull(inGameDesc).map { "In-Game: \"$it\"" }
	
	override var notes: List<String> = listOf()
	
	
	val positiveOrNegative get() = when (effectType) {
		"positive" -> true
		"negative" -> false
		else -> null
	}
	
	override fun getKotlinType(): String {
		if (codec != null) // trust codecs over attribute class notes
			return codec!!.visibleType
		else if (forceType != null)
			return forceType!!
		
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
		return PropertyBuilder(varName, getKotlinType()) {
			initializer = "ItemAttributeNamed<${getKotlinType()}>(\"${attrName}\"$codec)"
			docComment += innateDescription
			docComment += notes
		}
	}
	
	override fun toString(): String {
		return "NamedAttribute(attrName='$attrName', attrType='$attrType')"
	}
	
	
}