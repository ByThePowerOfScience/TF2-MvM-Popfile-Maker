package btpos.source.vdfdsl.types.specifics

import btpos.source.vdfdsl.codegen.CodegenProvider
import btpos.source.vdfdsl.codegen.StringDecoderMap
import btpos.source.vdfdsl.codegen.kt.KtName

/**
 * Presets for where
 */
object Where {
	val DECODER by CodegenProvider {
		StringDecoderMap(
			AHEAD to KtName(Where::AHEAD),
			BEHIND to KtName(Where::BEHIND),
			ANYWHERE to KtName(Where::ANYWHERE)
		)
	}
	
	const val AHEAD = "Ahead"
	const val BEHIND = "Behind"
	const val ANYWHERE = "Anywhere"
}