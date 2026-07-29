package btpos.source.vdfdsl.tf2.filegeneration.representations

import btpos.source.vdfdsl.tf2.filegeneration.RE_WHITESPACE

class PropertyBuilder(var name: String, var kType: String) {
	companion object {
	    inline operator fun invoke(name: String, kType: String, configure: PropertyBuilder.() -> Unit): PropertyBuilder {
	        return PropertyBuilder(name, kType).apply(configure)
	    }
		
		val re_genericTypes = Regex("""<.+>""")
	}
	
	lateinit var initializer: String
	
	var extensionOf: String? = null
	
	var modality: Modality = Modality.FINAL
	
	var isGetter: Boolean = false
	
	var delegatesToSuper: Boolean = false
	
	val docComment = mutableListOf<String>()
	
	var access: AccessModifier = AccessModifier.PUBLIC
	
	
	
	
	fun copy() = PropertyBuilder(name, kType).apply {
		initializer = this@PropertyBuilder.initializer
		extensionOf = this@PropertyBuilder.extensionOf
		modality = this@PropertyBuilder.modality
		isGetter = this@PropertyBuilder.isGetter
		delegatesToSuper = this@PropertyBuilder.delegatesToSuper
		docComment += this@PropertyBuilder.docComment
		access = this@PropertyBuilder.access
	}
	
	fun build(classType: ClassBuilder.Type? = null): String {
		val overrideString = if (extensionOf != null) "" else when (modality) {
			Modality.OPEN -> when (classType) {
				ClassBuilder.Type.INTERFACE, ClassBuilder.Type.COMPANION_OBJECT, ClassBuilder.Type.OBJECT -> "" // straight up cannot make it open
				else -> "open "
			}
			Modality.OVERRIDE -> "override "
			Modality.FINAL -> ""
		}
		
		val extString = extensionOf?.let { "$it." }.orEmpty()
		
		val docComment = if (docComment.isNotEmpty()) "/**\n" + docComment.joinToString("\n\n").prependIndent(" * ") + "\n */\n" else ""
		
		// elide implicit generic types
		val newInitializer = run {
			val genericInInitializer = re_genericTypes.find(initializer)
			val genericInType = re_genericTypes.find(kType)
			
			if (genericInInitializer != null && genericInType != null && genericInInitializer.value.replace(RE_WHITESPACE, "") == genericInType.value.replace(RE_WHITESPACE, "")) {
				initializer.replace(re_genericTypes, "")
			} else {
				initializer
			}
		}
		
		val body = when {
			delegatesToSuper -> "get() = super.$name"
			isGetter -> "get() = $newInitializer"
			else -> "= $newInitializer"
		}
		
		val accessQualifier = when (access) {
			AccessModifier.PUBLIC -> ""
			AccessModifier.INTERNAL -> "internal "
			AccessModifier.PRIVATE -> "private "
			AccessModifier.PROTECTED -> "protected "
		}
		
		return docComment +
		       "${accessQualifier}${overrideString}val $extString$name: $kType " + body
	}
	
	
	enum class Modality {
		FINAL,
		OPEN,
		OVERRIDE;
	}
	
	enum class AccessModifier {
		PUBLIC,
		PRIVATE,
		INTERNAL,
		PROTECTED
	}
	
	override fun toString(): String {
		return "PropertyBuilder($name, $kType)"
	}
}