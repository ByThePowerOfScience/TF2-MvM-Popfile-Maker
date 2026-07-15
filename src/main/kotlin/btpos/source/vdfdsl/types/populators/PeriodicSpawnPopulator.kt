package btpos.source.vdfdsl.types.populators

import btpos.source.vdfdsl.modeling.AbstractVDFStruct
import btpos.source.vdfdsl.modeling.ExtensibleSubtreeImpl
import btpos.source.vdfdsl.modeling.IExtensibleSubtree.Companion.addField
import btpos.source.vdfdsl.modeling.IExtensibleSubtree_VDFRepresentable
import btpos.source.vdfdsl.types.PopulationManager
import btpos.source.vdfdsl.types.spawners.AbstractSpawner
import btpos.source.vdfdsl.types.specifics.Where

class PeriodicSpawnPopulator(_subtree: IExtensibleSubtree_VDFRepresentable = ExtensibleSubtreeImpl()) : AbstractPopulator(_subtree) {
	open class When(_subtree: IExtensibleSubtree_VDFRepresentable = ExtensibleSubtreeImpl()) : AbstractVDFStruct(_subtree) {
		override val _structIdentifier: String get() = "When"
		
		open var minInterval: Number? by addField("MinInterval")
		
		open var maxInterval: Number? by addField("MaxInterval")
		
		override fun copy() = When(copyInternal())
	}
	
	override val _structIdentifier: String
		get() = "PeriodicSpawn"
	
	override fun copy() = PeriodicSpawnPopulator(this.copyInternal())
	
	/**
	 * Will usually be a [RandomChoice][btpos.source.vdfdsl.types.spawners.RandomChoiceSpawner].
	 *
	 * [Squad][btpos.source.vdfdsl.types.spawners.SquadSpawner] and [Mob (deprecated)][btpos.source.vdfdsl.types.spawners.MobSpawner] work as well, but there is no practical use for this.
	 */
	override var spawner: AbstractSpawner?
		get() = super.spawner
		set(value) { super.spawner = value }
	
	
	
	var where: Where? by addField("Where")
	
	/**
	 * Can be either a [Float] or a [When] instance
	 */
	var `when`: Any? by addField("When")
}

inline fun Populators.PeriodicSpawn(configure: PeriodicSpawnPopulator.() -> Unit) = PeriodicSpawnPopulator().apply(configure)
/**
 * Creates and adds a new PeriodicSpawn populator to the PopulationManager
 */
fun PopulationManager.PeriodicSpawn(configure: PeriodicSpawnPopulator.() -> Unit) = PeriodicSpawnPopulator().apply(configure).also {
	this.populators += it
}


