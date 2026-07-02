package btpos.source.vdfdsl.backing

import btpos.source.vdfdsl.serialization.IVDFRepresentableValue

/**
 * This doesn't _really_ exist, but it needs to be here to
 */
object VDFNull : VDFObject(), IVDFRepresentableValue<VDFNull> {
	override val _vdfRepr: VDFNull
		get() = this
}