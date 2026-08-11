package btpos.source.vdfdsl.types.specifics

import btpos.source.vdfdsl.codegen.CodegenProvider
import btpos.source.vdfdsl.codegen.StringDecoderMap
import btpos.misc.kt.codegen.identifiers.KtName

/**
 * Presets for where
 */
object Where {
	val CODEGEN = CodegenProvider {
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