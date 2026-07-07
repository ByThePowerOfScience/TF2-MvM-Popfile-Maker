package btpos.source.vdfdsl.types.populators

import btpos.source.vdfdsl.modeling.AbstractVDFStruct
import btpos.source.vdfdsl.modeling.ExtensibleSubtreeImpl
import btpos.source.vdfdsl.modeling.IExtensibleSubtree.Companion.singleStruct
import btpos.source.vdfdsl.modeling.IExtensibleSubtree_VDFRepresentable
import btpos.source.vdfdsl.tf2.PopFileDSL
import btpos.source.vdfdsl.types.spawners.AbstractSpawner

/**
 * Something that can hold a [spawner].  See the subclasses for more details. (in IntelliJ, click the `o↓` symbol on the left near the line numbers.)
 */
@PopFileDSL
abstract class AbstractPopulator(_subtree: IExtensibleSubtree_VDFRepresentable = ExtensibleSubtreeImpl()) : AbstractVDFStruct(_subtree) {
	companion object;
	
	
	/**
	 * The spawner used for this populator.
	 *
	 * @see AbstractSpawner
	 */
	var spawner: AbstractSpawner? by singleStruct()
	
	abstract override fun copy(): AbstractPopulator
	
	operator fun AbstractSpawner.unaryPlus() {
		this@AbstractPopulator.spawner = this@unaryPlus.copy()
	}
}

object Populators;