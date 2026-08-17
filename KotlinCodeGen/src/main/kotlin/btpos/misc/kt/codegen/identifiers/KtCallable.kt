package btpos.misc.kt.codegen.identifiers

import btpos.misc.kt.codegen.KtExpression

/**
 * A marker interface signifying that an item can be used as a property/function identifier.
 */
sealed interface KtCallable : KtExpression {
	val callableName: KtName
}