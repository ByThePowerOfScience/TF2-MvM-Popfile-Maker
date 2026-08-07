package btpos.source.vdfdsl.types.specifics

import btpos.source.vdfdsl.backing.VDFPrimitive
import btpos.source.vdfdsl.codegen.Codegen
import btpos.source.vdfdsl.codegen.StringDecoder
import btpos.source.vdfdsl.codegen.StringDecoderMapImpl

/**
 * Presets for where
 */
object Where {
	val DECODER = StringDecoderMapImpl().apply {
		values += sequenceOf(
			VDFPrimitive(AHEAD) to Codegen.code("Where.AHEAD"),
			VDFPrimitive(BEHIND) to Codegen.code("Where.BEHIND"),
			VDFPrimitive(ANYWHERE) to Codegen.code("Where.ANYWHERE"),
		)
		default = StringDecoder.IDENTITY
	}
	
	
	const val AHEAD = "Ahead"
	const val BEHIND = "Behind"
	const val ANYWHERE = "Anywhere"
}