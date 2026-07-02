package btpos.source.vdfdsl.types.spawners

import btpos.source.vdfdsl.modeling.IExtensibleSubtree.Companion.addField

@Deprecated("According to sigsegv: \"Old and crusty\"")
class SentryGunSpawner : Spawner() {
	override val _structIdentifier: String
		get() = "SentryGun"
	
	var level: Int? by addField("Level")
}