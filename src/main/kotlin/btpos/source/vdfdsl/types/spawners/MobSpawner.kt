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
	
	var count: Int? by addField("Count")
	var spawner: AbstractSpawner? by selfNamed()
	
	
	override fun copy() = MobSpawner(copyInternal())
	
	companion object {
		init {
			if (Codegen.IS_DOING_CODEGEN) {
				IExtensibleSubtree.Codegen._registerStructFactory<MobSpawner> { Codegen.basicApplyFactory<MobSpawner>() }
				MobSpawner()
			}
		}
		
		val CODEGEN get() = IExtensibleSubtree.Codegen.forType<MobSpawner>()
	}
}