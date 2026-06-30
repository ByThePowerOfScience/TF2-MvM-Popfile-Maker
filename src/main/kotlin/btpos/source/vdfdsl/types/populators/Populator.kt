package btpos.source.vdfdsl.types.populators

import btpos.source.vdfdsl.modeling.AbstractMvMStruct
import btpos.source.vdfdsl.modeling.PopFileDSL

@PopFileDSL
abstract class Populator : AbstractMvMStruct() {
	companion object
}