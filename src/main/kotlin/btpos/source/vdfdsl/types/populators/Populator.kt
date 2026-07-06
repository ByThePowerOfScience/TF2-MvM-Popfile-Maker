package btpos.source.vdfdsl.types.populators

import btpos.source.vdfdsl.modeling.AbstractVDFStruct
import btpos.source.vdfdsl.modeling.ExtensibleSubtreeImpl
import btpos.source.vdfdsl.modeling.IExtensibleSubtree.Companion.singleStruct
import btpos.source.vdfdsl.modeling.IExtensibleSubtree_VDFRepresentable
import btpos.source.vdfdsl.tf2.PopFileDSL
import btpos.source.vdfdsl.types.spawners.Spawner

@PopFileDSL
abstract class Populator(_subtree: IExtensibleSubtree_VDFRepresentable = ExtensibleSubtreeImpl()) : AbstractVDFStruct(_subtree) {
	companion object;
	
	
	/**
	 * The spawner used for this populator.
	 *
	 * @see Spawner
	 */
	var spawner: Spawner? by singleStruct()
	
	abstract override fun copy(): Populator
	
	operator fun Spawner.unaryPlus() {
		this@Populator.spawner = this@unaryPlus.copy()
	}
}