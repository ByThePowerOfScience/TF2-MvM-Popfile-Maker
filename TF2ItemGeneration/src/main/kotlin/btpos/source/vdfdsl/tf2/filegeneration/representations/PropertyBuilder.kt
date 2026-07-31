package btpos.source.vdfdsl.tf2.filegeneration.representations

import btpos.source.vdfdsl.tf2.filegeneration.RE_WHITESPACE

class PropertyBuilder(var name: String, var kType: String) {
	companion object {
	    inline operator fun invoke(name: String, kType: String, configure: PropertyBuilder.() -> Unit): PropertyBuilder {
	        return PropertyBuilder(name, kType).apply(configure)
	    }
		
		val re_genericTypes = Regex("""<.+>""")
	}
	
	var isVal = true
	
	var usesGetter: Boolean = false
	
	lateinit var initializer: String
	
	var setter: String? = null
	
	var extensionOf: String? = null
	
	var modality: Modality = Modality.FINAL
	
	var delegatesToSuper: Boolean = false
	
	val docComment = mutableListOf<String>()
	
	var access: AccessModifier = AccessModifier.PUBLIC
	
	var contextParams: List<Pair<String, String>> = listOf()
	
	fun copy() = PropertyBuilder(name, kType).apply {
		isVal = this@PropertyBuilder.isVal
		initializer = this@PropertyBuilder.initializer
		setter = this@PropertyBuilder.setter
		extensionOf = this@PropertyBuilder.extensionOf
		modality = this@PropertyBuilder.modality
		usesGetter = this@PropertyBuilder.usesGetter
		delegatesToSuper = this@PropertyBuilder.delegatesToSuper
		docComment += this@PropertyBuilder.docComment
		access = this@PropertyBuilder.access
		contextParams = this@PropertyBuilder.contextParams
	}
	
	fun build(classType: ClassBuilder.Type? = null): String {
		if (!isVal && usesGetter) {
			require(delegatesToSuper || setter != null) {
				"Setter may not be null on a variable property without a backing field that doesn't delegate to super."
			}
		}
		
		val valOrVar = if (isVal) "val" else "var"
		
		
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
		
		val context = if (contextParams.isNotEmpty()) {
			"context(${contextParams.joinToString { (name, type) -> "$name: $type" } })\n"
		} else ""
		
		val getIndent = if (isVal) "" else "\n\t"
		
		val body = when {
			delegatesToSuper -> "${getIndent}get() = super.$name"
			usesGetter -> "${getIndent}get() = $newInitializer"
			else -> "= $newInitializer"
		}
		
		val setter = if (!isVal) {
			"\n\tset(value) { " + if (delegatesToSuper) {
				"super.$name = value"
			} else {
				setter!!
			} + " }"
		} else ""
		
		val accessQualifier = when (access) {
			AccessModifier.PUBLIC -> ""
			AccessModifier.INTERNAL -> "internal "
			AccessModifier.PRIVATE -> "private "
			AccessModifier.PROTECTED -> "protected "
		}
		
		return docComment +
		       "${context}${accessQualifier}${overrideString}$valOrVar $extString$name: $kType " + body + setter
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