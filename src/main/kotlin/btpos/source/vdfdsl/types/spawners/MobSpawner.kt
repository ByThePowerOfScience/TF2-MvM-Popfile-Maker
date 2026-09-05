@file:Suppress("DEPRECATION")

package btpos.source.vdfdsl.types.spawners

import btpos.source.vdfdsl.codegen.Codegen
import btpos.source.vdfdsl.modeling.ExtensibleSubtreeImpl
import btpos.source.vdfdsl.modeling.IExtensibleSubtree
import btpos.source.vdfdsl.modeling.IExtensibleSubtree.Companion.addField
import btpos.source.vdfdsl.modeling.IExtensibleSubtree.Companion.selfNamed
import btpos.source.vdfdsl.modeling.IExtensibleSubtree_VDFRepresentable

@Deprecated("According to sigsegv: \"Old and crusty\"")
class MobSpawner(_subtree: IExtensibleSubtree_VDFRepresentable = ExtensibleSubtreeImpl()) : AbstractSpawner(_subtree) {
	override val _structIdentifier: String
		get() = "Mob"
	
	val count by addField<Int>("Count")
	
	val spawner by selfNamed<AbstractSpawner>()
	
	
	override fun copy() = MobSpawner(copyInternal())
	
	companion object {
		val CODEGEN = IExtensibleSubtree.Codegen.registerCodegen<MobSpawner> { Codegen.basicApplyFactory<MobSpawner>() }
	}
}