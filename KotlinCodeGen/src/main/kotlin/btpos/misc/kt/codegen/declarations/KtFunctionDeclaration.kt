package btpos.misc.kt.codegen.declarations

import btpos.misc.kt.codegen.identifiers.KtParameter
import btpos.misc.kt.codegen.KtStatement
import btpos.misc.kt.codegen.identifiers.KtType
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



