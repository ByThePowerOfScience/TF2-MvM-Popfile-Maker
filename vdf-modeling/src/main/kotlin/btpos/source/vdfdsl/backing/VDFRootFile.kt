package btpos.source.vdfdsl.backing

class VDFRootFile : VDFSubtree {
	val pragmas: MutableList<Pair<String, String>>
	
	constructor(pragmas: MutableList<Pair<String, String>> = mutableListOf()) : super(null) {
		this.pragmas = pragmas
	}
	
	constructor(pragmas: MutableList<Pair<String, String>>, entries: MutableList<VDFKeyValue>) : super(null, entries) {
		this.pragmas = pragmas
	}
	
	
	override fun writeToVDF(writer: Appendable, indent: Int) {
		for ((pragma, arg) in pragmas) {
			writer.append('#').append(pragma).append(' ').append(arg).appendLine()
		}
		writer.appendLine()
		entries.forEach {
			it.writeToVDF(writer, indent)
		}
	}
}

fun VDFSubtree.getRootFile(): VDFRootFile? {
	if (this is VDFRootFile)
		return this;
	
	var parent = this.parent
	while (parent != null && parent !is VDFRootFile) {
		parent = parent.parent
	}
	return parent;
}