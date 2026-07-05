package btpos.source.vdfdsl.types.populators

import btpos.source.vdfdsl.modeling.AbstractVDFStruct
import btpos.source.vdfdsl.modeling.ExtensibleSubtreeImpl
import btpos.source.vdfdsl.modeling.IExtensibleSubtree.Companion.singleStruct
import btpos.source.vdfdsl.tf2.PopFileDSL
import btpos.source.vdfdsl.types.spawners.Spawner

@PopFileDSL
abstract class Populator(_subtree: ExtensibleSubtreeImpl = ExtensibleSubtreeImpl()) : AbstractVDFStruct(_subtree) {
	companion object;
	
	
	/**
	 * The spawner used for this populator.
	 *
	 * @see Spawner
	 */
	open var spawner: Spawner? by singleStruct()
}