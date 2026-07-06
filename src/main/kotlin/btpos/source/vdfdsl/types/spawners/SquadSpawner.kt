package btpos.source.vdfdsl.types.spawners

import btpos.source.vdfdsl.modeling.ExtensibleSubtreeImpl
import btpos.source.vdfdsl.modeling.IExtensibleSubtree.Companion.multiStruct
import btpos.source.vdfdsl.modeling.IExtensibleSubtree.Companion.addField
import btpos.source.vdfdsl.modeling.IExtensibleSubtree_VDFRepresentable

class SquadSpawner(_subtree: IExtensibleSubtree_VDFRepresentable = ExtensibleSubtreeImpl()) : Spawner(_subtree) {
	/*
	Squad
	- float     FormationSize       (default: -1.0)
	- bool      ShouldPreserveSquad (default: 0) [see note 4]
	- subtree[] (spawner)
	 */
	
	override val _structIdentifier: String
		get() = "Squad"
	
	override fun copy() = SquadSpawner(copyInternal())
	
	operator fun Spawner.unaryPlus() {
		this@SquadSpawner.spawners += this@unaryPlus.copy()
	}
	
	
	var formationSize: Double? by addField("FormationSize")
	
	/**
	 * Note: Squad.ShouldPreserveSquad is parsed correctly, but will cause a spurious error to show up in console; ignore the error
	 */
	var shouldPreserveSquad: Boolean? by addField("ShouldPreserveSquad")
	
	val spawners: MutableList<Spawner> by multiStruct()
	
	/**
	 * Add the same spawner multiple times.
	 */
	fun addMultiple(spawner: Spawner, amount: Int) {
		val copy = spawner.copy()
		for (i in 0 until amount) {
			this.spawners += copy
		}
	}
	
	operator fun Spawner.times(amount: Int) = this to amount
	
	operator fun Pair<Spawner, Int>.unaryPlus() {
		addMultiple(first, second)
	}
}

fun Spawner.Companion.Squad(configure: SquadSpawner.() -> Unit) = SquadSpawner().apply(configure)

fun Squad(configure: SquadSpawner.() -> Unit) = Spawner.Squad(configure)

