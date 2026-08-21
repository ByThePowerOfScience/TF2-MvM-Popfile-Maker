package btpos.source.vdfdsl.utils

import btpos.source.vdfdsl.modeling.ExtensibleSubtreeImpl
import btpos.source.vdfdsl.modeling.ExtensibleSubtreeMergedImpl
import btpos.source.vdfdsl.tf2.itemattributes.impl.IBlockScoped

/**
 * A [ExtensibleSubtreeMergedImpl] that also implements [IBlockScoped] so I don't have to include it each time
 */
abstract class NestedScope(subtree: ExtensibleSubtreeImpl) : ExtensibleSubtreeMergedImpl(subtree), IBlockScoped {
	
	abstract override fun copy(): NestedScope
}