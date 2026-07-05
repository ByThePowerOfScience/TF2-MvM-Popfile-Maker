package btpos.source.vdfdsl.types.spawners

import btpos.source.vdfdsl.modeling.AbstractVDFStruct
import btpos.source.vdfdsl.modeling.ExtensibleSubtreeImpl
import btpos.source.vdfdsl.tf2.PopFileDSL

@PopFileDSL
abstract class Spawner(_subtree: ExtensibleSubtreeImpl = ExtensibleSubtreeImpl()) : AbstractVDFStruct(_subtree) {
	/**
	 * This is Kotlin's version of a "static namespace", AKA where you put stuff to reference it as `Spawner.something`.
	 *
	 * What's cool is that by defining it empty, you can make extension properties for it elsewhere,
	 * adding completely arbitrary "static fields" to the namespace.
	 */
	companion object
}