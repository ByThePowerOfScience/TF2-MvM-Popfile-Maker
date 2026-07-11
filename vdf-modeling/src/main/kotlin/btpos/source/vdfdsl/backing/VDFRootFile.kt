package btpos.source.vdfdsl.backing

data class VDFRootFile(val pragmas: List<Pair<String, String>>, val keyvalues: List<VDFKeyValue>) : VDFObject() {
	override fun writeToVDF(writer: Appendable, indent: Int) {
		for ((pragma, arg) in pragmas) {
			writer.append('#').append(pragma).append(' ').append(arg).appendLine()
		}
		writer.appendLine()
		keyvalues.forEach {
			it.writeToVDF(writer, indent)
		}
	}
}