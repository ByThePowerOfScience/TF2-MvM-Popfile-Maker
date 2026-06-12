package btpos.tf2.popfiledsl.types.spawners

import btpos.tf2.popfiledsl.modeling.IMvMSubtree.Companion.addField
import btpos.tf2.popfiledsl.modeling.IMvMSubtree.Companion.singleStruct

@Deprecated("According to sigsegv: \"Old and crusty\"")
class MobSpawner : Spawner() {
	override val popFileStructIdentifier: Any
		get() = "Mob"
}

var MobSpawner.count: Int? by addField<Int>("Count")
var MobSpawner.spawner: Spawner? by singleStruct()



fun Spawner.Companion.Mob(count: Int, spawner: Spawner): MobSpawner {
	return MobSpawner().apply {
		this.count = count
		this.spawner = spawner
	}
}

/*
Wait a second, why don't I just use property-indexing for ALL fields, and then only provide the key they should be SERIALIZED with instead of STORED with?
This will allow people to add a list version of what was previously a single-field, etc.

Combine the "read" and "write" functions into a "SerializerCodec" that can just be passed to the function

Create a "List" class that stores a key and serializes into Key Value Key Value


 */