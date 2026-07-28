package btpos.source.vdfdsl.tf2.filegeneration.representations


class ClassBuilder(var name: String, var type: Type) {
	companion object {
		inline operator fun invoke(name: String, type: Type, configure: ClassBuilder.() -> Unit): ClassBuilder {
			return ClassBuilder(name, type).apply(configure)
		}
	}
	
	val docComment = mutableListOf<String>()
	
	var baseClass: String? = null
	
	var parentInterfaces = mutableSetOf<String>()
	
	val properties: MutableMap<String, PropertyBuilder> = mutableMapOf()
	
	
	val nestedClasses = mutableMapOf<String, ClassBuilder>()
	
	var companionObject: ClassBuilder? = null
	
	var isOpen: Boolean = false
	
	
	enum class Type {
		INTERFACE,
		ABSTRACT_CLASS,
		CLASS,
		OBJECT,
		COMPANION_OBJECT;
	}
	
	fun copy(): ClassBuilder = ClassBuilder(name, type).apply {
		baseClass = this@ClassBuilder.baseClass
		parentInterfaces = this@ClassBuilder.parentInterfaces
		properties += this@ClassBuilder.properties.mapValues { it.value.copy() }
		nestedClasses += this@ClassBuilder.nestedClasses.mapValues { it.value.copy() }
		docComment += this@ClassBuilder.docComment
		companionObject = this@ClassBuilder.companionObject?.copy()
	}
	
	
	fun build(): String {
		val classType = when (type) {
			Type.INTERFACE -> "interface"
			Type.ABSTRACT_CLASS -> "abstract class"
			Type.CLASS -> "class"
			Type.OBJECT -> "object"
			Type.COMPANION_OBJECT -> "companion object"
		}
		
		val extends = (listOfNotNull(baseClass?.let { "$it()" }) + parentInterfaces).joinToString(", ").let {
			if (!it.isBlank())
				": $it "
			else ""
		}
		
		if (this.type == Type.COMPANION_OBJECT && companionObject != null) {
			error("Companion object cannot have a companion object.")
		}
		
		companionObject?.let {
			it.type = Type.COMPANION_OBJECT
		}
		
		val companionObjectString = companionObject?.let {
			it.build().prependIndent("\t")
		}.orEmpty()
		
		val classTypeClassName = if (type == Type.COMPANION_OBJECT)
			"companion object"
		else "$classType $name"
		
		return """
			/**
			${docComment.joinToString("\n\n").prependIndent(" * ")}
			 */
			$classTypeClassName $extends{
			$companionObjectString
				
			${properties.values.joinToString("\n") { it.build() }.prependIndent("\t") }
				
				
				
			${nestedClasses.entries.joinToString("\n") { it.value.build() }.prependIndent("\t")}
			}
		""".trimIndent()
	}
	
	
	
	
	
	operator fun contains(prop: PropertyBuilder) = prop.name in properties
	
	operator fun contains(cls: ClassBuilder) = cls.name in nestedClasses
	
	
	
	fun addProperty(property: PropertyBuilder) {
		this.properties[property.name] = property
	}
	
	fun addProperties(properties: Iterable<PropertyBuilder>) {
		properties.forEach(::addProperty)
	}
	fun addNestedClass(nestedClass: ClassBuilder) {
		this.nestedClasses[nestedClass.name] = nestedClass
	}
	
	fun addNestedClasses(nestedClasses: Iterable<ClassBuilder>) {
		nestedClasses.forEach(::addNestedClass)
	}
	
	operator fun plusAssign(nestedClass: ClassBuilder) {
		addNestedClass(nestedClass)
	}
	
	operator fun plusAssign(nestedClasses: Iterable<ClassBuilder>) {
		nestedClasses.forEach(::addNestedClass)
	}
}






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
	
	fun build(): String {
		val body = when {
			delegatesToSuper -> "get() = super.$name"
			isGetter -> "get() = $initializer"
			else -> "= $initializer"
		}
		
		val overrideString = if (extensionOf != null) "" else when (modality) {
			Modality.OPEN -> "open "
			Modality.OVERRIDE -> "override "
			Modality.FINAL -> ""
		}
		
		val extString = extensionOf?.let { "$it." }.orEmpty()
		
		val docComment = "/**\n" + docComment.joinToString("\n\n").prependIndent(" * ") + "\n */"
		
		return docComment + "\n" +
		       "${overrideString}val $extString$name: $kType " + body
	}
	
	
	enum class Modality {
		OPEN,
		OVERRIDE,
		FINAL;
	}
}