package btpos.source.vdfdsl.types.spawners

import btpos.source.vdfdsl.codegen.Codegen
import btpos.source.vdfdsl.modeling.ExtensibleSubtreeImpl
import btpos.source.vdfdsl.modeling.IExtensibleSubtree
import btpos.source.vdfdsl.modeling.IExtensibleSubtree.Companion.addField
import btpos.source.vdfdsl.modeling.IExtensibleSubtree_VDFRepresentable
import btpos.source.vdfdsl.types.specifics.OutputAction

class TankSpawner(_subtree: IExtensibleSubtree_VDFRepresentable = ExtensibleSubtreeImpl()) : AbstractSpawner(_subtree) {
	override val _structIdentifier: String
		get() = "Tank"
	
	override fun copy() = TankSpawner(copyInternal())
	
	
	val health by addField<Int>("Health")
	
	val speed by addField<Number>("Speed")
	
	val name by addField<String>("Name")
	
	val skin by addField<Int>("Skin")
	
	val startingPathTrackNode by addField<String>("StartingPathTrackNode")
	
	val onKilledOutput by addField<OutputAction>("OnKilledOutput")
	
	val onBombDroppedOutput by addField<OutputAction>("OnBombDroppedOutput")
	
	companion object {
		val CODEGEN = IExtensibleSubtree.Codegen.registerCodegen<TankSpawner>(factoryMethod = { Codegen.basicBlockScope(Spawners::Tank) })
	}
}