package btpos.source.vdfdsl.backing


/**
 * Raw data directly representative of the VDF.
 */
sealed class VDFObject {
	protected fun Appendable.writeLine(indent: Int): Appendable {
		append('\n')
		for (_i in 0 until indent) {
			append('\t')
		}
		return this
	}
	
	abstract fun writeToVDF(writer: Appendable, indent: Int = 0)
}