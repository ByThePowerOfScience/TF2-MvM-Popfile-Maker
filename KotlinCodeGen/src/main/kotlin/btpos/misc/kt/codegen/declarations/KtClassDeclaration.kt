package btpos.misc.kt.codegen.declarations

import btpos.misc.kt.codegen.IKtCodeGenerator
import btpos.misc.kt.codegen.identifiers.KtType


class KtClassDeclaration(var name: String, var type: Type) : IKtCodeGenerator {
	companion object {
		inline operator fun invoke(name: String, type: Type, configure: KtClassDeclaration.() -> Unit): KtClassDeclaration {
			return KtClassDeclaration(name, type).apply(configure)
		}
		
		/**
		 * Factory preset to make a new "companion object" builder
		 */
		fun newCompanionObject() = KtClassDeclaration("", Type.COMPANION_OBJECT)
	}
	
	val docComment = mutableListOf<String>()
	
	var baseClass: KtType? = null
	
	var parentInterfaces = mutableSetOf<KtType>()
	
	val properties: MutableMap<String, KtPropertyDeclaration> = mutableMapOf()
	
	val nestedClasses = mutableMapOf<String, KtClassDeclaration>()
	
	var companionObject: KtClassDeclaration? = null
	
	var isOpen: Boolean = false
	
	val functions: MutableList<KtFunctionDeclaration> = mutableListOf()
	
	enum class Type {
		INTERFACE,
		ABSTRACT_CLASS,
		CLASS,
		OBJECT,
		COMPANION_OBJECT;
	}
	
	fun clearBody() {
		properties.clear()
		nestedClasses.clear()
		companionObject = null
		functions.clear()
	}
	
	fun copy(): KtClassDeclaration = KtClassDeclaration(name, type).apply {
		baseClass = this@KtClassDeclaration.baseClass
		parentInterfaces = this@KtClassDeclaration.parentInterfaces
		properties += this@KtClassDeclaration.properties.mapValues { it.value.copy() }
		nestedClasses += this@KtClassDeclaration.nestedClasses.mapValues { it.value.copy() }
		docComment += this@KtClassDeclaration.docComment
		companionObject = this@KtClassDeclaration.companionObject?.copy()
		isOpen = this@KtClassDeclaration.isOpen
		functions += this@KtClassDeclaration.functions
	}
	
	/**
	 * Get a nested class at `this.1.2.3.etc`
	 */
	fun getNestedClassFromPath(path: List<String>): KtClassDeclaration? {
		if (path.isEmpty())
			return this;
		
		return this.nestedClasses[path.first()]?.let {
			it.getNestedClassFromPath(path.drop(1))
		}
	}
	
	override fun toKotlinCode(): String {
		val classType = when (type) {
			Type.INTERFACE -> "interface"
			Type.ABSTRACT_CLASS -> "abstract class"
			Type.CLASS -> "class"
			Type.OBJECT -> "object"
			Type.COMPANION_OBJECT -> "companion object"
		}
		
		val extends = (listOfNotNull(baseClass?.let { "${it.toKotlinCode()}()" }) + parentInterfaces.map { it.toKotlinCode() })
			.joinToString(", ")
			.let {
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
		
		val companionObjectString = companionObject?.toKotlinCode()
		
		val classTypeClassName = if (type == Type.COMPANION_OBJECT)
			"companion object"
		else "$classType $name"
		
		
		val modalityString = if (isOpen && type.let { it != Type.ABSTRACT_CLASS && it != Type.INTERFACE }) "open " else ""
		
		
		val docCommentString = if (docComment.isNotEmpty()) "/**\n" +
								docComment.joinToString("\n\n").prependIndent(" * ") +
                               "\n*/\n" else ""
		
		val body = if (properties.isEmpty() && companionObject == null) {
			""
		} else {
			"{\n" +
			listOfNotNull(
				companionObjectString,
				properties.takeIf { it.isNotEmpty() }?.values?.joinToString("\n\n") { it.toKotlinCode() },
				nestedClasses.takeIf { it.isNotEmpty() }?.entries?.joinToString("\n\n") { it.value.toKotlinCode() },
				functions.takeIf { it.isNotEmpty() }?.joinToString("\n\n") { it.toKotlinCode() }
			).joinToString("\n\n").prependIndent("\t") +
			"\n}"
		}
		
		return """$docCommentString$modalityString$classTypeClassName $extends$body"""
	}
	
	
	
	
	
	operator fun contains(prop: KtPropertyDeclaration) = prop.name in properties
	
	operator fun contains(cls: KtClassDeclaration) = cls.name in nestedClasses
	
	
	
	fun addProperty(property: KtPropertyDeclaration) {
		if (property.name !in this.properties)
			this.properties[property.name] = property
	}
	
	fun addProperties(properties: Iterable<KtPropertyDeclaration>) {
		properties.forEach(::addProperty)
	}
	fun addNestedClass(nestedClass: KtClassDeclaration) {
		if (nestedClass.name !in this.nestedClasses)
			this.nestedClasses[nestedClass.name] = nestedClass
	}
	
	fun addNestedClasses(nestedClasses: Iterable<KtClassDeclaration>) {
		nestedClasses.forEach(::addNestedClass)
	}
	
	operator fun plusAssign(nestedClass: KtClassDeclaration) {
		addNestedClass(nestedClass)
	}
	
	operator fun plusAssign(nestedClasses: Iterable<KtClassDeclaration>) {
		nestedClasses.forEach(::addNestedClass)
	}
	
	fun getOrCreateCompanionObject(): KtClassDeclaration {
		return companionObject ?: newCompanionObject().also {
			this.companionObject = it
		}
	}
	
	override fun toString(): String {
		return "ClassBuilder($name, $type)"
	}
	
	
	override val importsNeeded: Sequence<String>
		get() = sequenceOf(
			this.companionObject?.importsNeeded,
			this.nestedClasses.values.asSequence().flatMap { it.importsNeeded },
			this.properties.values.asSequence().flatMap { it.importsNeeded },
			this.functions.asSequence().flatMap { it.importsNeeded },
			this.parentInterfaces.asSequence().flatMap { it.importsNeeded },
			this.baseClass?.importsNeeded,
		).filterNotNull().flatten()
}


