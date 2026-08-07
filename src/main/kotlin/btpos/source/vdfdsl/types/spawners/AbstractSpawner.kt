package btpos.source.vdfdsl.types.spawners

import btpos.source.vdfdsl.codegen.Decoders
import btpos.source.vdfdsl.codegen.StructSubclassDecoder
import btpos.source.vdfdsl.modeling.AbstractVDFStruct
import btpos.source.vdfdsl.modeling.ExtensibleSubtreeImpl
import btpos.source.vdfdsl.modeling.IExtensibleSubtree_VDFRepresentable
import btpos.source.vdfdsl.tf2.PopFileDSL



@PopFileDSL
abstract class AbstractSpawner(_subtree: IExtensibleSubtree_VDFRepresentable = ExtensibleSubtreeImpl()) : AbstractVDFStruct(_subtree) {
	companion object {
		val CODEGEN get() =
			StructSubclassDecoder(
				"Mob" to MobSpawner.CODEGEN,
				"RandomChoice" to RandomChoiceSpawner.CODEGEN,
				"SentryGun" to SentryGunSpawner.CODEGEN,
				"Squad" to SquadSpawner.CODEGEN,
				"Tank" to TankSpawner.CODEGEN,
				"TFBot" to TFBotSpawner.CODEGEN
			)
		
	}
	
	abstract override fun copy(): AbstractSpawner
}