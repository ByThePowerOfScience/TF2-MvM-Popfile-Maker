package btpos.tf2.popfiledsl.itemattributesgenerator

fun String.camelCase(): String {
	return this[0].lowercaseChar() + this.zipWithNext { a, b -> if ((a == ' ' || a == '_') && b.isLetter()) b.uppercaseChar() else b }
		.filter { it != ' ' && it != '_' }
		.joinToString("")
	
}

sealed class ISortedNamedAttribute {
	abstract val varName: String
	
	/**
	 * Applied once to the outermost item, and expected to only exist once on the inner ones too, but not propogate back out when we check the inner ones' comments
	 */
	protected val commentsFromNotes = mutableListOf<String>()
	
	/**
	 * In-game descs and in-game descs of contained attributes
	 */
	open val commentsNotFromNotes = mutableListOf<String>()
	
	
	abstract fun addCommentsFromNotes(comments: List<String>)
	
	/**
	 * Expose the comment for anything that overrides the property creation
	 * Just a number of lines that should be in the thing, separated by line separators, indenting, * characters
	 *
	 * For empty lines, use empty strings
	 */
	abstract fun commentForOwnProperty(): List<String>
	
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
	
	
	abstract fun getKotlinType(): String
	
	abstract fun setCodec(codec: (NamedAttribute) -> FakeCodec?)
	
	companion object {
		fun buildCommentForProperty(comment: ISortedNamedAttribute): String = buildCommentForProperty(comment.commentForOwnProperty())
		
		fun buildCommentForProperty(comments: List<String>): String = comments
			                                                              .takeIf { it.isNotEmpty() }
			                                                              ?.let {
				                                                              "/**\n" +
				                                                              " * ${it.joinToString("\n * ")}\n" +
				                                                              " */"
			                                                              } ?: ""
	}
	
}

data class NamedAttribute(
	val attrName: String,
	/** Like `additive_percentage` */
	val attrType: String,
	val className: String,
	override val varName: String = attrName.camelCase().replace(":", ""),
	/** positive, negative, or null */
	val effectType: String? = null,
	var codec: FakeCodec? = null,
	val isUnimplemented: Boolean = false,
	var forceType: String? = null
) : ISortedNamedAttribute() {
	constructor(attrName: String, inGameDesc: String?, attrType: String, className: String, varName: String = attrName.camelCase().replace(":", ""),
		effectType: String? = null, codec: FakeCodec? = null, isUnimplemented: Boolean = false, forceType: String? = null)
			: this(attrName, attrType, className, varName, effectType, codec, isUnimplemented, forceType)
	{
		inGameDesc?.let { commentsNotFromNotes.add(it.replace("'''%s1'''", "N")); commentsNotFromNotes.add("") }
	}
	
	init {
		if (attrType != "additive") {
			commentsNotFromNotes.add("Value type: $attrType")
			commentsNotFromNotes.add("")
		}
	}
	
//	init {
//		if (type == "set_weapon_mode" && codec == null)
//			error("Forgot the weapon mode on $this")
//	}
	
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
	
	override fun commentForOwnProperty(): List<String> {
		return buildList {
			addAll(commentsNotFromNotes)
			
			addAll(commentsFromNotes)
		}
	}
	
	override fun addCommentsFromNotes(comments: List<String>) {
		this.commentsFromNotes += comments
	}
	
	override fun withVarName(name: String): ISortedNamedAttribute {
		return this.copy(varName = name)
	}
	
	override fun propertyValue(): String {
		error("Shouldn't be called")
	}
	
	override fun toString(): String {
		return """Attr("$attrName", "$attrType", "$className", "$varName", "$codec", "$isUnimplemented", "$forceType")"""
	}
}

val removeFromPBName = listOf("decreased?", "lower(?:ed)?", ).map { Regex(it) }
/**
 * Penalty and bonus combined into a single little namespace
 */
data class PenaltyBonus private constructor(
	val penalty: ISortedNamedAttribute,
	val bonus: ISortedNamedAttribute,
) : IContainMultipleAttributes() {
	override fun toString(): String {
		return """PenaltyBonus($penalty, $bonus)"""
	}
	
	override val varName: String
		get() = penalty.varName.let { name ->
			removeFromPBName.fold(name) { it, re -> it.replace(re, "") }
		}
	override val containedAttributes: Collection<ISortedNamedAttribute>
		get() = listOf(penalty, bonus)
	
	companion object {
		const val NEITHER_NESTED = "BonusPenalty"
		const val BOTH_NESTED = "BonusPenalty_BothNested"
		const val BONUS_IS_NESTED = "BonusPenalty_BonusNested"
		const val PENALTY_IS_NESTED = "BonusPenalty_PenaltyNested"
		
		operator fun invoke(decrease: ISortedNamedAttribute, increase: ISortedNamedAttribute, note: String? = null) = PenaltyBonus(decrease, increase).apply {
			note?.let { commentsNotFromNotes.add(it) }
		}
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
			"$NEITHER_NESTED$typeParamsString(\"${bonus.attrName}\", \"${penalty.attrName}\")"
		} else if (penalty !is NamedAttribute && bonus !is NamedAttribute) {
			"$BOTH_NESTED$typeParamsString(${bonus.propertyValue()}, ${penalty.propertyValue()})"
		} else if (bonus is NamedAttribute) {
			"$PENALTY_IS_NESTED$typeParamsString(\"${bonus.attrName}\", ${penalty.propertyValue()})"
		} else if (penalty is NamedAttribute) {
			"$BONUS_IS_NESTED$typeParamsString(${bonus.propertyValue()}, \"${penalty.attrName}\")"
		} else {
			error("no this won't happen")
		}
	}
	
	
	override fun propertyString(): String {
		return "val $varName get() = ${propertyValue()}"
	}
	
	
	override fun generateTopLevelMembers(): List<String> {
		return penalty.generateTopLevelMembers() + bonus.generateTopLevelMembers()
	}
	
	init {
		this.commentsNotFromNotes.run {
			add("Bonus:")
			addAll(bonus.commentsNotFromNotes.filter { it.isNotBlank() }.map { if (!it.trimStart().startsWith("- ")) "- $it" else it  }.map { "\t" + it })
			add("")
			add("Penalty:")
			addAll(penalty.commentsNotFromNotes.filter { it.isNotBlank() }.map { "\t- $it" })
		}
	}
	
	override fun commentForOwnProperty(): List<String> {
		return buildList {
			addAll(commentsFromNotes)
			add("")
			addAll(commentsNotFromNotes)
		}
	}
	
	
	override fun iterator(): Iterator<ISortedNamedAttribute> {
		return listOf(penalty, bonus).iterator()
	}
	
	override fun withVarName(name: String): ISortedNamedAttribute {
		return this.copy()
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

val removeFromThing = listOf("hidden").map { Regex(it) }
data class Vis(
	val visible: NamedAttribute,
	val hidden: NamedAttribute,
	val additionalItems: List<NamedAttribute>,
	override val varName: String = visible.varName.run {
		removeFromThing.fold(this) { el: String, it: Regex -> el.replace(it, "") }
	}
) : IContainMultipleAttributes() {
	override fun toString(): String {
		return """Vis($visible, $hidden, listOf(${additionalItems.joinToString(", ")}), "$varName")"""
	}
	
	override val containedAttributes: Collection<ISortedNamedAttribute>
		get() = listOf(visible, hidden) + additionalItems
	
	constructor(visible: NamedAttribute, hidden: NamedAttribute, vararg additionalItems: NamedAttribute, varName: String = visible.varName) : this(visible, hidden, additionalItems.asList(), varName)
	
	override val commentsNotFromNotes: MutableList<String> = mutableListOf<String>().apply {
		add("Visible:")
		addAll(visible.commentsNotFromNotes.filter{ it.isNotBlank() }.map { "\t- $it" })
		add("")
		add("Hidden:")
		addAll(hidden.commentsNotFromNotes.filter{ it.isNotBlank() }.map { "\t- $it" })
		for (item in additionalItems) {
			add("")
			add(item.varName.capitalize() + ":")
			addAll(item.commentsNotFromNotes.filter{ it.isNotBlank() }.map { "\t- $it" })
		}
	}
	
	override fun commentForOwnProperty(): List<String> {
		return commentsNotFromNotes + commentsFromNotes
	}
	
	override fun addCommentsFromNotes(comments: List<String>) {
		additionalItems.forEach { it.addCommentsFromNotes(comments) }
	}
	
	val customClassName = if (additionalItems.isNotEmpty()) {
		varName.capitalize() + "Attributes"
	} else null
	
	
	fun inheritedTemplate(): String {
		return """class $customClassName<VIS : Any, HIDDEN : Any>(vis_attrName: String, hidden_attrName: String) : VisHidden<VIS, HIDDEN>(vis_attrName, hidden_attrName) {
${writeAttributesInClassBody(additionalItems, "\t")}
}"""
	}
	
	
	override fun propertyString(): String {
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
	
	override fun withVarName(name: String): ISortedNamedAttribute {
		return copy(varName = name)
	}
	
	override fun getKotlinType(): String {
		return "${customClassName ?: "VisHidden"}<${visible.getKotlinType()}, ${hidden.getKotlinType()}>"
	}
	
	override fun iterator(): Iterator<ISortedNamedAttribute> {
		return sequenceOf(listOf(visible, hidden) + additionalItems).flatten()
			.iterator()
	}
}


abstract class IContainMultipleAttributes : Iterable<ISortedNamedAttribute>, ISortedNamedAttribute() {
	abstract val containedAttributes: Collection<ISortedNamedAttribute>
	
	open fun writeAttributesInClassBody(attrs: List<ISortedNamedAttribute>, indent: String): String {
		return attrs.joinToString("\n\n") { buildCommentForProperty(it) + "\n" + it.propertyString() }.prependIndent(indent)
	}
	
	override fun setCodec(codec: (NamedAttribute) -> FakeCodec?) {
		containedAttributes.forEach {
			it.setCodec(codec)
		}
	}
	
	override fun addCommentsFromNotes(comments: List<String>) {
		this.commentsFromNotes += comments
		this.containedAttributes.forEach { it.addCommentsFromNotes(comments) }
	}
}

/**
 * Scopes are all top-level object declarations. Any properties just reference them with getters.
 */
open class NamedAttributeScope(
	val scopeName: String,
	vararg attrs: ISortedNamedAttribute,
	override val commentsNotFromNotes: MutableList<String> = mutableListOf(),
	override val varName: String = scopeName.decapitalize()
) : IContainMultipleAttributes() {
	override fun toString(): String {
		return """Scope("$scopeName", ${attrs.joinToString(", ")}, "$commentsNotFromNotes", "$varName")"""
	}
	
	val attrs = attrs.distinct()
	
	override val containedAttributes: Collection<ISortedNamedAttribute>
		get() = attrs
	
	constructor(scopeName: String, vararg namesToAttrs: Pair<String, NamedAttribute>) : this(scopeName, attrs=namesToAttrs.map { it.second.copy(varName = it.first) }.toTypedArray())
	
	override fun iterator(): Iterator<ISortedNamedAttribute> {
		return attrs.iterator()
	}
	
	override fun propertyValue(): String {
		return clsname
	}
	
	val clsname = scopeName + "Attributes"
	
	override fun withVarName(name: String): ISortedNamedAttribute {
		return NamedAttributeScope(scopeName = name.capitalize(), attrs = attrs.toTypedArray(), commentsNotFromNotes)
	}
	
	override fun generateTopLevelMembers(): List<String> {
		return listOf(
			buildCommentForProperty(this) + "\n" + """object $clsname {
	operator fun invoke(scope: $clsname.() -> Unit) {
		this.apply(scope)
	}
	
${writeAttributesInClassBody(attrs, "\t")}
}"""
		) + attrs.flatMap { it.generateTopLevelMembers() }
	}
	
	override fun getKotlinType(): String {
		return scopeName
	}
	
	override fun propertyString(): String {
		return "val $varName get() = ${propertyValue()}"
	}
	
	override fun commentForOwnProperty(): List<String> {
		return commentsNotFromNotes + "" + commentsFromNotes
	}
}

val hierarchiesByName = mutableMapOf<String, HierarchyNamedAttributeScope>()

class HierarchyNamedAttributeScope(scopeName: String, val extendsFrom: String?, vararg attrs: ISortedNamedAttribute, note: String? = null) : NamedAttributeScope(scopeName, attrs = attrs, mutableListOf<String>().apply { note?.let { add(it) } }) {
	
	fun getParentsRecursive(): Sequence<HierarchyNamedAttributeScope> {
		return generateSequence(this.extendsFrom?.let { hierarchiesByName[it] }) { it.extendsFrom?.let { that -> hierarchiesByName[that] } }
	}
	
	init {
		hierarchiesByName[scopeName] = this
	}
	
	override fun generateTopLevelMembers(): List<String> {
		return listOf(
			buildCommentForProperty(this) + "\n" +
			"""interface $clsname ${extendsFrom?.let { ": ${it}Attributes " } ?: ""}{
	companion object : $clsname
	
${writeAttributesInClassBody(attrs, "\t")}
}""") +
"""operator fun ${clsname}.invoke(scope: ${clsname}.() -> Unit) {
	this.apply(scope)
}"""+ attrs.flatMap { it.generateTopLevelMembers() }
	}
	
	override fun writeAttributesInClassBody(attrs: List<ISortedNamedAttribute>, indent: String): String {
		val allParentAttrNames =  getParentsRecursive().flatMap { it.attrs.asSequence() }.toList()
		return attrs.map { attr ->
			val fromParent = allParentAttrNames.filter { it.varName == attr.varName }
			Pair(fromParent, attr)
		}.joinToString("\n\n") { (fromParent, attr) ->
			val comment = if (fromParent.isEmpty()) {
				attr.commentForOwnProperty()
			} else {
				fromParent.flatMap { it.commentForOwnProperty() } + "" + attr.commentForOwnProperty()
			}
			
			val isOverride = fromParent.isNotEmpty()
			
			buildCommentForProperty(comment) + "\n" + (if (isOverride) "override " else "") + attr.propertyString()
		}.prependIndent(indent)
	}
}

/**
 * Generates a new class for whatever set of fields is needed
 *
 * Actually this is really just a scope...
 */
class Custom(override val varName: String, fields: List<ISortedNamedAttribute>, desc: String? = null) : NamedAttributeScope(scopeName = varName.capitalize(), attrs = fields.toTypedArray(), mutableListOf<String>().apply { desc?.let { add(it) } }, varName = varName) {
	constructor(varName: String, vararg fields: Pair<String, ISortedNamedAttribute>, note: String? = null) : this(varName, fields.map { it.second.withVarName(it.first) }, note)
	
	constructor(vararg fields: Pair<String, ISortedNamedAttribute>) : this("", fields.map { it.second.withVarName(it.first) })
}

fun selectorCodec(number: Int) = FakeCodec("Boolean", "NumberSelectorCodec($number)")

class FakeCodec(val visibleType: String, val codecIdentifier: String) {
	override fun toString(): String {
		return """FakeCodec("$visibleType", "$codecIdentifier")"""
	}
}

val bool = FakeCodec("Boolean", "BinaryIntCodec")
