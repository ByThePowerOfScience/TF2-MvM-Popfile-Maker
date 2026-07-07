package btpos.source.vdfdsl.types.spawners

import btpos.source.vdfdsl.modeling.ExtensibleSubtreeImpl
import btpos.source.vdfdsl.modeling.IExtensibleSubtree.Companion.multiStruct
import btpos.source.vdfdsl.modeling.IExtensibleSubtree.Companion.addField
import btpos.source.vdfdsl.modeling.IExtensibleSubtree_VDFRepresentable

class SquadSpawner(_subtree: IExtensibleSubtree_VDFRepresentable = ExtensibleSubtreeImpl()) : AbstractSpawner(_subtree) {
	/*
	Squad
	- float     FormationSize       (default: -1.0)
	- bool      ShouldPreserveSquad (default: 0) [see note 4]
	- subtree[] (spawner)
	 */
	
	override val _structIdentifier: String
		get() = "Squad"
	
	override fun copy() = SquadSpawner(copyInternal())
	
	operator fun AbstractSpawner.unaryPlus() {
		this@SquadSpawner.spawners += this@unaryPlus.copy()
	}
	
	
	var formationSize: Number? by addField("FormationSize")
	
	/**
	 * Note: Squad.ShouldPreserveSquad is parsed correctly, but will cause a spurious error to show up in console; ignore the error
	 */
	var shouldPreserveSquad: Boolean? by addField("ShouldPreserveSquad")
	
	val spawners: MutableList<AbstractSpawner> by multiStruct()
	
	/**
	 * Add the same spawner multiple times.
	 */
	fun addMultiple(amount: Int, spawner: AbstractSpawner) {
		val copy = spawner.copy()
		for (i in 0 until amount) {
			this.spawners += copy
		}
	}
	
	operator fun AbstractSpawner.times(amount: Int) = this to amount
	
	operator fun Pair<AbstractSpawner, Int>.unaryPlus() {
		addMultiple(second, first)
	}
}

fun Spawners.Squad(configure: SquadSpawner.() -> Unit) = SquadSpawner().apply(configure)

fun Squad(configure: SquadSpawner.() -> Unit) = Spawners.Squad(configure)

