package btpos.source.vdfdsl.types.spawners

import btpos.source.vdfdsl.codegen.Codegen
import btpos.source.vdfdsl.modeling.ExtensibleSubtreeImpl
import btpos.source.vdfdsl.modeling.IExtensibleSubtree
import btpos.source.vdfdsl.modeling.IExtensibleSubtree.Companion.addField
import btpos.source.vdfdsl.modeling.IExtensibleSubtree_VDFRepresentable

@Deprecated("According to sigsegv: \"Old and crusty\"")
class SentryGunSpawner(_subtree: IExtensibleSubtree_VDFRepresentable = ExtensibleSubtreeImpl()) : AbstractSpawner(_subtree) {
	override val _structIdentifier: String
		get() = "SentryGun"
	
	var level: Int? by addField("Level")
	
	@Suppress("DEPRECATION")
	override fun copy() = SentryGunSpawner(copyInternal())
	
	@Suppress("DEPRECATION")
	companion object {
		init {
			if (Codegen.IS_DOING_CODEGEN) {
				IExtensibleSubtree._registerStructFactory<SentryGunSpawner>(Codegen.basicApplyFactory<SentryGunSpawner>())
			}
		}
		
		val CODEGEN get() = IExtensibleSubtree._codegen<SentryGunSpawner>()
	}
}