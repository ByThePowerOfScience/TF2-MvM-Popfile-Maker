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

val VDFObject.asSubtree get() = this as? VDFSubtree

val VDFObject.asPrimitive get() = this as? VDFPrimitive

val VDFObject.asKeyValue get() = this as? VDFKeyValue

val VDFObject.asString get() = asPrimitive?.stringValue