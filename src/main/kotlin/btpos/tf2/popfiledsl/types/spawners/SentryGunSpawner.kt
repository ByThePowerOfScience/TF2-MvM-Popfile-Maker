package btpos.tf2.popfiledsl.types.spawners

@Deprecated("According to sigsegv: \"Old and crusty\"")
class SentryGunSpawner(level: Int) : BaseSpawner() {
	override val popFileStructIdentifier: Any
		get() = "SentryGun"
	
	var level: Int? by singleKeyedValue("Level")
}