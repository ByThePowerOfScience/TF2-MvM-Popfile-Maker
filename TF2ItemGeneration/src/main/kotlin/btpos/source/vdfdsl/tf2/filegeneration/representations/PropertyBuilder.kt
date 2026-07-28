package btpos.source.vdfdsl.tf2.filegeneration.representations

class PropertyBuilder(val name: String, val kType: String) {
	companion object {
	    inline operator fun invoke(name: String, kType: String, configure: PropertyBuilder.() -> Unit): PropertyBuilder {
	        return PropertyBuilder(name, kType).apply(configure)
	    }
	}
	
	lateinit var initializer: String
	
	var extensionOf: String? = null
	
	var modality: Modality = Modality.FINAL
	
	var isGetter: Boolean = false
	
	var delegatesToSuper: Boolean = false
	
	val docComment = mutableListOf<String>()
	
	
	fun copy() = PropertyBuilder(name, kType).apply {
		initializer = this@PropertyBuilder.initializer
		extensionOf = this@PropertyBuilder.extensionOf
		modality = this@PropertyBuilder.modality
		isGetter = this@PropertyBuilder.isGetter
		delegatesToSuper = this@PropertyBuilder.delegatesToSuper
		docComment += this@PropertyBuilder.docComment
	}
	
	fun build(classType: ClassBuilder.Type? = null): String {
		val body = when {
			delegatesToSuper -> "get() = super.$name"
			isGetter -> "get() = $initializer"
			else -> "= $initializer"
		}
		
		val overrideString = if (extensionOf != null) "" else when (modality) {
			Modality.OPEN -> when (classType) {
				ClassBuilder.Type.INTERFACE, ClassBuilder.Type.COMPANION_OBJECT, ClassBuilder.Type.OBJECT -> "" // straight up cannot make it
				else -> "open "
			}
			Modality.OVERRIDE -> "override "
			Modality.FINAL -> ""
		}
		
		val extString = extensionOf?.let { "$it." }.orEmpty()
		
		val docComment = if (docComment.isNotEmpty()) "/**\n" + docComment.joinToString("\n\n").prependIndent(" * ") + "\n */" else ""
		
		return docComment + "\n" +
		       "${overrideString}val $extString$name: $kType " + body
	}
	
	
	enum class Modality {
		OPEN,
		OVERRIDE,
		FINAL;
	}
}