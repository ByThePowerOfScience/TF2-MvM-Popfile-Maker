package btpos.misc.kt.codegen.declarations

import btpos.misc.kt.codegen.identifiers.KtParameter
import btpos.misc.kt.codegen.KtStatement
import btpos.misc.kt.codegen.types.KtType
import btpos.misc.kt.codegen.enums.AccessModifier
import btpos.misc.kt.codegen.enums.Modality
import kotlin.collections.joinToString

class KtFunctionDeclaration(var name: String, var returnType: KtType = KtType.UNIT) : KtStatement {
	var access: AccessModifier = AccessModifier.PUBLIC
	
	var modality: Modality = Modality.FINAL
	
	var isInline = false
	
	val docCommentLines = mutableListOf<String>()
	
	val valueParameters = mutableListOf<KtParameter>()
	
	val contextParameters = mutableListOf<KtParameter>()
	
	var extensionReceiver: KtType? = null
	
	lateinit var body: KtFunctionBody
	
	override fun toKotlinCode(): String {
		val modalityString = when (modality) {
			Modality.FINAL -> ""
			Modality.OPEN -> "open "
			Modality.OVERRIDE -> "override "
		}
		
		val accessString = access.kcode + " "
		
		val modifiersString = "$modalityString$accessString"
		
		val returnString = returnType.takeIf { it != KtType.UNIT }?.let { ": $it" }.orEmpty()
		
		val contextString = contextParameters.takeIf { it.isNotEmpty() }
			?.joinToString(", ") { it.toKotlinCode() }
			?.let { "context($it)\n" }
			.orEmpty()
		
		val params = valueParameters.joinToString { it.toKotlinCode() }
		
		return "$contextString${modifiersString}fun $name($params)$returnString " +
		       body.toKotlinCode()
	}
	
	override fun equals(other: Any?): Boolean {
		if (this === other) return true
		if (javaClass != other?.javaClass) return false
		
		other as KtFunctionDeclaration
		
		if (isInline != other.isInline) return false
		if (name != other.name) return false
		if (returnType != other.returnType) return false
		if (access != other.access) return false
		if (modality != other.modality) return false
		if (docCommentLines != other.docCommentLines) return false
		if (valueParameters != other.valueParameters) return false
		if (contextParameters != other.contextParameters) return false
		if (extensionReceiver != other.extensionReceiver) return false
		if (body != other.body) return false
		
		return true
	}
	
	override fun hashCode(): Int {
		var result = isInline.hashCode()
		result = 31 * result + name.hashCode()
		result = 31 * result + returnType.hashCode()
		result = 31 * result + access.hashCode()
		result = 31 * result + modality.hashCode()
		result = 31 * result + docCommentLines.hashCode()
		result = 31 * result + valueParameters.hashCode()
		result = 31 * result + contextParameters.hashCode()
		result = 31 * result + (extensionReceiver?.hashCode() ?: 0)
		result = 31 * result + body.hashCode()
		return result
	}
	
	override val importsNeeded: Sequence<String>
		get() = sequenceOf(
			this.body.importsNeeded,
			this.valueParameters.asSequence().flatMap { it.importsNeeded },
			this.extensionReceiver?.importsNeeded,
			this.contextParameters.asSequence().flatMap { it.importsNeeded },
			this.returnType.importsNeeded,
		).filterNotNull().flatten()
	
	
}

val KtFunctionBody.statements: List<KtStatement> get() = when (this) {
	is KtFunctionBody.Expression -> listOf(this.expression)
	is KtFunctionBody.Block -> statements
}



