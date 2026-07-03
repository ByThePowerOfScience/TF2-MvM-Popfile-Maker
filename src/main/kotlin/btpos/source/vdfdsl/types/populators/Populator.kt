package btpos.source.vdfdsl.types.populators

import btpos.source.vdfdsl.modeling.AbstractVDFStruct
import btpos.source.vdfdsl.modeling.ExtensibleSubtreeImpl
import btpos.source.vdfdsl.tf2.PopFileDSL

@PopFileDSL
abstract class Populator(_subtree: ExtensibleSubtreeImpl = ExtensibleSubtreeImpl()) : AbstractVDFStruct(_subtree) {
	companion object
}