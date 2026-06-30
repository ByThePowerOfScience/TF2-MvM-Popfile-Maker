package btpos.tf2.popfiledsl.itemattributesgenerator.representations

import btpos.tf2.popfiledsl.itemattributesgenerator.ArmoryDesc
import btpos.tf2.popfiledsl.itemattributesgenerator.camelCase
import btpos.tf2.popfiledsl.itemattributesgenerator.overrideVarName

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
		if (codec != null)
			return codec!!.visibleType
		else if (forceType != null)
			return forceType!!
		
		if ("percentage" in attrType)
			return "Float"
		
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
			"from_lookup_table" -> "FromLookupTable"
			else -> error("unexpected type: $attrType")
		}
	}
	
	
	
	override fun setCodec(codec: (NamedAttribute) -> FakeCodec?) {
		this.codec = codec(this)
	}
	
	override fun propertyString(isOverridden: Boolean): String {
		val codec = codec?.codecIdentifier?.let { ", $it" } ?: ""
		val (getter, setter) = if (isOverridden) {
			"get() = super.${varName}" to "set(value) { super.${varName} = value }"
		} else {
			"""get() = attrs.getTyped("$attrName"$codec)""" to """set(value) = attrs.setNullable("$attrName", value$codec)"""
		}
		return """
			context(attrs: IKeyValueMap)
			${if (isOverridden) "override " else ""}var $varName: ${getKotlinType()}?
				$getter
				$setter
		""".trimIndent()
	}
	
	override fun propertyValue(): String {
		error("Shouldn't be called")
	}
	
}