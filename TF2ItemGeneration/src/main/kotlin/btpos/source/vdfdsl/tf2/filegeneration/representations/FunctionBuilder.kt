package btpos.source.vdfdsl.tf2.filegeneration.representations

class FunctionBuilder(var name: String, var returnType: String? = null) {
	var modality: Modality = Modality.FINAL
	
	var isInline = false
	
	val valueParams = mutableListOf<Pair<String, String>>()
	
	val body = mutableListOf<String>()
	
	val contextParams = mutableListOf<Pair<String, String>>()
	
	fun copy() = FunctionBuilder(this.name, this.returnType).let {
		it.modality = this.modality
		it.isInline = this.isInline
		it.valueParams += this.valueParams
		it.body += this.body
		it.contextParams += contextParams
	}
	
	fun build(): String {
		val modalityString = when (modality) {
			Modality.FINAL -> ""
			Modality.OPEN -> "open "
			Modality.OVERRIDE -> "override "
		}
		
		val returnString = returnType?.takeIf { it != "Unit" }?.let { ": $it" }.orEmpty()
		
		val contextString = contextParams.takeIf { it.isNotEmpty() }
				?.joinToString(", ") { (name, type) ->  "$name: $type" }
				?.let { "context($it)\n" }
				.orEmpty()
		
		return "$contextString${modalityString}fun $name(${valueParams.joinToString(", ") { "${it.first}: ${it.second}"  } })$returnString {\n" +
		       body.joinToString("\n") { it.prependIndent() } +
		       "\n}"
	}
}
