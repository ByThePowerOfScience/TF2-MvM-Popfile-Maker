package btpos.misc.kt.codegen.declarations

import btpos.misc.kt.codegen.KtExpression
import btpos.misc.kt.codegen.KtStatement
import btpos.misc.kt.codegen.identifiers.KtParameter
import btpos.misc.kt.codegen.types.KtType
import btpos.misc.kt.codegen.enums.AccessModifier
import btpos.misc.kt.codegen.enums.Modality
import kotlin.collections.joinToString

class KtPropertyDeclaration(var name: String, var rType: KtType): KtStatement {
	var isVar = false
	
	/**
	 * If set, this property will have a backing field
	 */
	var backingFieldInitializer: KtExpression? = null
	
	var getter: KtFunctionBody? = null
	
	var setter: KtFunctionBody? = null
	
	var extensionOf: KtType? = null
	
	var access: AccessModifier = AccessModifier.PUBLIC
	
	var modality: Modality = Modality.FINAL
	
	val contextParams: MutableList<KtParameter> = mutableListOf()
	
	val docComment = mutableListOf<String>()
	
	fun copy() = KtPropertyDeclaration(name, rType).apply {
		isVar = this@KtPropertyDeclaration.isVar
		backingFieldInitializer = this@KtPropertyDeclaration.backingFieldInitializer
		getter = this@KtPropertyDeclaration.getter
		setter = this@KtPropertyDeclaration.setter
		extensionOf = this@KtPropertyDeclaration.extensionOf
		access = this@KtPropertyDeclaration.access
		modality = this@KtPropertyDeclaration.modality
		docComment += this@KtPropertyDeclaration.docComment
		contextParams += this@KtPropertyDeclaration.contextParams
	}
	
	override fun toKotlinCode(): String {
		val valOrVar = if (isVar) "var" else "val"
		
		val accessQualifier = access.kcode
		
		val overrideString = modality.kcode
		
		val extString = extensionOf?.let { "$it." }.orEmpty()
		
		val docComment = if (docComment.isNotEmpty()) "/**\n" + docComment.joinToString("\n\n").prependIndent(" * ") + "\n */\n" else ""
		
		
		val contextLine = if (contextParams.isNotEmpty()) {
			"context(${contextParams.joinToString { it.toKotlinCode() } })\n"
		} else ""
		
		
		val propInitializerString = backingFieldInitializer?.let {
			" = " + it.toKotlinCode()
		}.orEmpty()
		
		val getterString = getter?.let {
			"\n\tget() " + it.toKotlinCode()
		}.orEmpty()
		
		val setterString = setter?.let {
			"\n\tset(value) " + it.toKotlinCode()
		}.orEmpty()
		
		
		return docComment +
		       contextLine +
		       "${accessQualifier}${overrideString}$valOrVar $extString$name: ${rType.toKotlinCode()}" +
		       propInitializerString +
		       getterString +
		       setterString
	}
	
	override fun toString(): String {
		return "PropertyBuilder($name, $rType)"
	}
	
	override fun equals(other: Any?): Boolean {
		if (this === other) return true
		if (javaClass != other?.javaClass) return false
		
		other as KtPropertyDeclaration
		
		if (isVar != other.isVar) return false
		if (name != other.name) return false
		if (rType != other.rType) return false
		if (backingFieldInitializer != other.backingFieldInitializer) return false
		if (getter != other.getter) return false
		if (setter != other.setter) return false
		if (extensionOf != other.extensionOf) return false
		if (access != other.access) return false
		if (modality != other.modality) return false
		if (contextParams != other.contextParams) return false
		if (docComment != other.docComment) return false
		
		return true
	}
	
	override fun hashCode(): Int {
		var result = isVar.hashCode()
		result = 31 * result + name.hashCode()
		result = 31 * result + rType.hashCode()
		result = 31 * result + (backingFieldInitializer?.hashCode() ?: 0)
		result = 31 * result + (getter?.hashCode() ?: 0)
		result = 31 * result + (setter?.hashCode() ?: 0)
		result = 31 * result + (extensionOf?.hashCode() ?: 0)
		result = 31 * result + access.hashCode()
		result = 31 * result + modality.hashCode()
		result = 31 * result + contextParams.hashCode()
		result = 31 * result + docComment.hashCode()
		return result
	}
	
	override val importsNeeded: Sequence<String>
		get() = sequenceOf(
			rType.importsNeeded,
			backingFieldInitializer?.importsNeeded,
			getter?.importsNeeded,
			setter?.importsNeeded,
			extensionOf?.importsNeeded,
			contextParams.asSequence().flatMap { it.importsNeeded },
		).filterNotNull().flatten()
	
	
	
	
	companion object {
		inline operator fun invoke(name: String, rType: KtType, configure: KtPropertyDeclaration.() -> Unit): KtPropertyDeclaration {
			return KtPropertyDeclaration(name, rType).apply(configure)
		}
	}
	
}

