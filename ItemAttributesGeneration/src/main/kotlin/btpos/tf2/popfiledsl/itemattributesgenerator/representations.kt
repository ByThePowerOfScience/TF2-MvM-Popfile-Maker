package btpos.tf2.popfiledsl.itemattributesgenerator

fun String.camelCase(): String {
	return this[0] + this.zipWithNext { a, b -> if ((a == ' ' || a == '_') && b.isLetter()) b.uppercaseChar() else b }
		.filter { it != ' ' && it != '_' }
		.joinToString("")
}

sealed class ISortedNamedAttribute {
	abstract val varName: String
	
	abstract var comments: List<String>
	abstract fun addCommentsNested(comments: List<String>)
	
	/**
	 * Expose the comment for anything that overrides the property creation
	 * Just a number of lines that should be in the thing, separated by line separators, indenting, * characters
	 *
	 * For empty lines, use empty strings
	 */
	abstract fun makeComment(): List<String>
	
	/**
	 * Some property reference to this object, assuming it's given the opportunity to name its own property
	 */
	abstract fun propertyString(): String
	
	/**
	 * If this value is not an [NamedAttribute], it'll be some kind of object. This is that object.
	 */
	abstract fun propertyValue(): String
	
	/**
	 * will be called before [propertyString]
	 */
	open fun generateTopLevelMembers(): List<String> = emptyList()
	
	abstract fun withVarName(name: String): ISortedNamedAttribute
	
	
	fun buildComment() = makeComment().takeIf { it.isNotEmpty() }?.let {"/**\n" +
	                     " * ${it.joinToString("\n * ")}\n" +
	                     " */" } ?: ""
	
	abstract fun getKotlinType(): String
	
	abstract fun setCodec(codec: (NamedAttribute) -> FakeCodec?)
	
}

data class NamedAttribute(
	val attrName: String,
	val inGameDesc: String?,
	/** Like `additive_percentage` */
	val attrType: String,
	val className: String,
	override val varName: String = attrName.camelCase(),
	/** positive, negative, or null */
	val effectType: String? = null,
	var codec: FakeCodec? = null,
	override var comments: List<String> = listOf(),
	val isUnimplemented: Boolean = false,
	var forceType: String? = null
) : ISortedNamedAttribute() {
//	init {
//		if (type == "set_weapon_mode" && codec == null)
//			error("Forgot the weapon mode on $this")
//	}
	override fun addCommentsNested(comments: List<String>) {
		this.comments += comments
	}
	
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
			"particle_index" -> "ParticleIndex"
			"or" -> "Boolean"
			"date" -> "Date"
			"account_id" -> "AccountId"
			"" -> "Any"
			"item_def" -> "ItemDef"
			"killstreakeffect_index" -> "KillstreakEffectIndex"
			"killstreak_idleeffect_index" -> "KillstreakIdleEffect"
			"from_lookup_table" -> "FromLookupTable"
			else -> error("unexpected type: $attrType")
		}
	}
	
	override fun setCodec(codec: (NamedAttribute) -> FakeCodec?) {
		this.codec = codec(this)
	}
	
	override fun propertyString(): String {
		val codec = codec?.codecIdentifier?.let { ", $it" } ?: ""
		return """
			context(attrs: IKeyValueMap)
			var $varName: ${getKotlinType()}?
				get() = attrs.getTyped("$attrName"$codec)
				set(value) = attrs.setNullable("$attrName", value$codec)
		""".trimIndent()
	}
	
	override fun makeComment(): List<String> {
		return buildList(2) {
			inGameDesc?.let { add(it.replace("'''%s1'''", "N")); add("") }
			
			add("Value type: $attrType")
			if (comments.isNotEmpty()) {
				add("")
				addAll(comments)
			}
		}
	}
	
	override fun withVarName(name: String): ISortedNamedAttribute {
		return this.copy(varName = name)
	}
	
	override fun propertyValue(): String {
		error("Shouldn't be called")
	}
	
	override fun toString(): String {
		return """Attr("$attrName", "$inGameDesc", "$attrType", "$className", "$varName", "$codec", "$isUnimplemented", "$comments", "$forceType")"""
	}
}

/**
 * Penalty and bonus combined into a single little namespace
 */
data class PenaltyBonus private constructor(
	override val varName: String,
	val penalty: ISortedNamedAttribute,
	val bonus: ISortedNamedAttribute,
	override var comments: List<String> = emptyList()
) : IContainMultipleAttributes() {
	override fun toString(): String {
		return """PenaltyBonus("$varName", $penalty, $bonus, "$comments")"""
	}
	
	override val containedAttributes: Collection<ISortedNamedAttribute>
		get() = listOf(penalty, bonus)
	
	companion object {
		const val NEITHER_NESTED = "BonusPenalty"
		const val BOTH_NESTED = "BonusPenalty_BothNested"
		const val BONUS_IS_NESTED = "BonusPenalty_BonusNested"
		const val PENALTY_IS_NESTED = "BonusPenalty_PenaltyNested"
		
		operator fun invoke(varName: String, decrease: ISortedNamedAttribute, increase: ISortedNamedAttribute, note: String? = null) = PenaltyBonus(varName, decrease.withVarName("decrease"), increase.withVarName("increase"), listOfNotNull(note))
	}
	
	private val whenThing
		get() = when {
			penalty is NamedAttribute && bonus is NamedAttribute -> 0
			penalty !is NamedAttribute && bonus !is NamedAttribute -> 1
			bonus is NamedAttribute -> 2
			else -> 3
		}
	
	override fun propertyValue(): String {
		val typeParamsString = "<${bonus.getKotlinType()}, ${penalty.getKotlinType()}>"
		
		return if (penalty is NamedAttribute && bonus is NamedAttribute) {
			"$NEITHER_NESTED$typeParamsString(${bonus.attrName}, ${penalty.attrName})"
		} else if (penalty !is NamedAttribute && bonus !is NamedAttribute) {
			"$BOTH_NESTED$typeParamsString(${bonus.propertyValue()}, ${penalty.propertyValue()})"
		} else if (bonus is NamedAttribute) {
			"$PENALTY_IS_NESTED$typeParamsString(${bonus.attrName}, ${penalty.propertyValue()})"
		} else if (penalty is NamedAttribute) {
			"$BONUS_IS_NESTED$typeParamsString(${bonus.propertyValue()}, ${penalty.attrName})"
		} else {
			error("no this won't happen")
		}
	}
	
	
	override fun propertyString(): String {
		return "val $varName = ${propertyValue()}"
	}
	
	
	override fun generateTopLevelMembers(): List<String> {
		return penalty.generateTopLevelMembers() + bonus.generateTopLevelMembers()
	}
	
	override fun makeComment(): List<String> {
		return buildList {
			addAll(comments)
			add("Bonus:")
			addAll(penalty.makeComment().map { "\t" + it })
			add("")
			add("Penalty:")
			addAll(penalty.makeComment().map { "\t" + it })
		}
	}
	
	
	override fun iterator(): Iterator<ISortedNamedAttribute> {
		return listOf(penalty, bonus).iterator()
	}
	
	override fun withVarName(name: String): ISortedNamedAttribute {
		return this.copy(varName = name)
	}
	
	override fun getKotlinType(): String {
		return when (whenThing) {
			0 -> NEITHER_NESTED
			1 -> BOTH_NESTED
			2 -> BONUS_IS_NESTED
			3 -> PENALTY_IS_NESTED
			else -> error("fuck")
		}
	}
}

abstract class IContainMultipleAttributes : Iterable<ISortedNamedAttribute>, ISortedNamedAttribute() {
	abstract val containedAttributes: Collection<ISortedNamedAttribute>
	
	fun writeAttributesInClassBody(attrs: List<ISortedNamedAttribute>, indent: String): String {
		return attrs.joinToString("\n\n") { it.buildComment() + "\n" + it.propertyString() }.prependIndent(indent)
	}
	
	override fun setCodec(codec: (NamedAttribute) -> FakeCodec?) {
		containedAttributes.forEach {
			it.setCodec(codec)
		}
	}
	
	override fun addCommentsNested(comments: List<String>) {
		this.comments += comments
		this.containedAttributes.forEach { it.addCommentsNested(comments) }
	}
}

val WEAPON_BASE = "AllWeaponAttributes"
val BASE_GUN = "AllGunAttributes"

/**
 * Scopes are all top-level object declarations. Any properties just reference them with getters.
 */
open class NamedAttributeScope(
	val scopeName: String,
	vararg val attrs: ISortedNamedAttribute,
	override var comments: List<String> = emptyList(),
	override val varName: String = scopeName.decapitalize()
) : IContainMultipleAttributes() {
	override fun toString(): String {
		return """Scope("$scopeName", ${attrs.joinToString(", ")}, "$comments", "$varName")"""
	}
	
	override val containedAttributes: Collection<ISortedNamedAttribute>
		get() = attrs.asList()
	
	constructor(scopeName: String, vararg namesToAttrs: Pair<String, NamedAttribute>) : this(scopeName, *namesToAttrs.map { it.second.copy(varName = it.first) }
		.toTypedArray())
	
	override fun iterator(): Iterator<ISortedNamedAttribute> {
		return attrs.iterator()
	}
	
	override fun propertyValue(): String {
		return scopeName
	}
	
	override fun withVarName(name: String): ISortedNamedAttribute {
		return NamedAttributeScope(scopeName = name.capitalize(), attrs = attrs, comments = comments)
	}
	
	override fun generateTopLevelMembers(): List<String> {
		val clsname = scopeName + "Attributes"
		return listOf(
			buildComment() + "\n" + """object $clsname {
	operator fun invoke(scope: $clsname.() -> Unit) {
		this.apply(scope)
	}
	
${writeAttributesInClassBody(attrs.asList(), "\t")}
}"""
		) + attrs.flatMap { it.generateTopLevelMembers() }
	}
	
	override fun getKotlinType(): String {
		return scopeName
	}
	
	override fun propertyString(): String {
		return "val $varName get() = ${propertyValue()}"
	}
	
	override fun makeComment(): List<String> {
		return comments
	}
}

val hierarchiesByName = mutableMapOf<String, HierarchyNamedAttributeScope>()

class HierarchyNamedAttributeScope(scopeName: String, val extendsFrom: String?, vararg attrs: ISortedNamedAttribute, note: String? = null) : NamedAttributeScope(scopeName, attrs = attrs, listOfNotNull(note)) {
	init {
		hierarchiesByName[scopeName] = this
	}
	
	override fun generateTopLevelMembers(): List<String> {
		val clsname = scopeName + "Attributes"
		return listOf(
			buildComment() + "\n" +
			"""abstract class $clsname ${extendsFrom?.let { ": $it()" } ?: ""}{
	companion object : ${clsname}() {
		operator fun invoke(scope: ${clsname}.Companion.() -> Unit) {
			this.apply(scope)
		}
	}
	
	
	
${writeAttributesInClassBody(attrs.asList(), "\t")}
}""") + attrs.flatMap { it.generateTopLevelMembers() }
	}
}

/**
 * Generates a new class for whatever set of fields is needed
 *
 * Actually this is really just a scope...
 */
class Custom(override val varName: String, fields: List<ISortedNamedAttribute>, desc: String? = null) : NamedAttributeScope(scopeName = varName.capitalize(), attrs = fields.toTypedArray(), comments = listOfNotNull(desc), varName = varName) {
	constructor(varName: String, vararg fields: Pair<String, ISortedNamedAttribute>, note: String? = null) : this(varName, fields.map { it.second.withVarName(it.first) }, note)
	
	constructor(vararg fields: Pair<String, ISortedNamedAttribute>) : this("", fields.map { it.second.withVarName(it.first) })
}

data class Vis(
	val visible: NamedAttribute,
	val hidden: NamedAttribute,
	val additionalItems: List<NamedAttribute>,
	override val varName: String = visible.varName
) : IContainMultipleAttributes() {
	override fun toString(): String {
		return """Vis($visible, $hidden, listOf(${additionalItems.joinToString(", ")}), "$varName")"""
	}
	
	override val containedAttributes: Collection<ISortedNamedAttribute>
		get() = listOf(visible, hidden) + additionalItems
	
	constructor(visible: NamedAttribute, hidden: NamedAttribute, vararg additionalItems: NamedAttribute, varName: String = visible.varName) : this(visible, hidden, additionalItems.asList(), varName)
	
	override var comments: List<String> = emptyList()
	
	override fun makeComment(): List<String> {
		return buildList {
			add("Visible:")
			addAll(visible.makeComment())
			add("")
			add("Hidden:")
			addAll(hidden.makeComment())
			for (item in additionalItems) {
				add("")
				add(item.varName.capitalize() + ":")
				addAll(item.makeComment())
			}
		}
	}
	
	val customClassName = if (additionalItems.isNotEmpty()) {
		varName!!.capitalize() + "Attributes"
	} else null
	
	
	fun inheritedTemplate(): String {
		return """class $customClassName<VIS : Any, HIDDEN : Any, FROM1 : Any, TO1 : Any, FROM2 : Any, TO2 : Any>(vis_attrName: String, hidden_attrName: String) : VisHidden<VIS, HIDDEN>(vis_attrName, hidden_attrName) {
${writeAttributesInClassBody(additionalItems, "\t")}
}"""
	}
	
	
	override fun propertyString(): String {
		return "val ${varName!!} = ${propertyValue()}"
	}
	
	override fun propertyValue(): String {
		return "${customClassName ?: "VisHidden"}<${visible.getKotlinType()}, ${hidden.getKotlinType()}>(${visible.attrName}, ${hidden.attrName})"
	}
	
	override fun generateTopLevelMembers(): List<String> {
		return listOf(inheritedTemplate()) + visible.generateTopLevelMembers() + hidden.generateTopLevelMembers() + additionalItems.flatMap { it.generateTopLevelMembers() }
	}
	
	override fun withVarName(name: String): ISortedNamedAttribute {
		return copy(varName = name)
	}
	
	override fun getKotlinType(): String {
		return customClassName ?: "VisHidden"
	}
	
	override fun iterator(): Iterator<ISortedNamedAttribute> {
		return sequenceOf(listOf(visible, hidden) + additionalItems).flatten()
			.iterator()
	}
}

fun selectorCodec(number: Int) = FakeCodec("Boolean", "NumberSelectorCodec($number)")

class FakeCodec(val visibleType: String, val codecIdentifier: String) {
	override fun toString(): String {
		return """FakeCodec("$visibleType", "$codecIdentifier")"""
	}
}

val bool = FakeCodec("Boolean", "BinaryIntCodec")
