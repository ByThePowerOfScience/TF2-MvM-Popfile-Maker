package btpos.source.vdfdsl.types.populators

import btpos.source.vdfdsl.modeling.AbstractVDFStruct
import btpos.source.vdfdsl.tf2.PopFileDSL

@PopFileDSL
abstract class Populator : AbstractVDFStruct() {
	companion object
}