package btpos.source.vdfdsl.types.spawners

import btpos.source.vdfdsl.modeling.IMvMSubtree.Companion.addField

@Deprecated("According to sigsegv: \"Old and crusty\"")
class SentryGunSpawner : Spawner() {
	override val _popFileStructIdentifier: Any
		get() = "SentryGun"
	
	var level: Int? by addField("Level")
}