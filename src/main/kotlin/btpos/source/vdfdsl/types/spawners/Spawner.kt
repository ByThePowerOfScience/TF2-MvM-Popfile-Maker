package btpos.source.vdfdsl.types.spawners

import btpos.source.vdfdsl.modeling.AbstractMvMStruct
import btpos.source.vdfdsl.modeling.PopFileDSL

@PopFileDSL
abstract class Spawner : AbstractMvMStruct() {
	/**
	 * This is Kotlin's version of a "static namespace", AKA where you put stuff to reference it as `Spawner.something`.
	 *
	 * What's cool is that by defining it empty, you can make extension properties for it elsewhere,
	 * adding completely arbitrary "static fields" to the namespace.
	 *
	 * @see SquadSpawner
	 */
	companion object
}