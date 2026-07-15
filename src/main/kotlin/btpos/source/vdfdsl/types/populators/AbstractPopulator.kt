package btpos.source.vdfdsl.types.populators

import btpos.source.vdfdsl.modeling.AbstractVDFStruct
import btpos.source.vdfdsl.modeling.ExtensibleSubtreeImpl
import btpos.source.vdfdsl.modeling.IExtensibleSubtree.Companion.selfNamed
import btpos.source.vdfdsl.modeling.IExtensibleSubtree_VDFRepresentable
import btpos.source.vdfdsl.tf2.PopFileDSL
import btpos.source.vdfdsl.types.PopulationManager
import btpos.source.vdfdsl.types.spawners.AbstractSpawner
import btpos.source.vdfdsl.utils.ReadOnlyConstant
import kotlin.collections.plus
import kotlin.properties.PropertyDelegateProvider
import kotlin.properties.ReadOnlyProperty

/**
 * Something that can hold a [spawner].  See the subclasses for more details. (in IntelliJ, click the `o↓` symbol on the left near the line numbers.)
 */
@PopFileDSL
abstract class AbstractPopulator(_subtree: IExtensibleSubtree_VDFRepresentable = ExtensibleSubtreeImpl()) : AbstractVDFStruct(_subtree) {
	companion object;
	
	
	/**
	 * The spawner used for this populator.
	 *
	 * @see AbstractSpawner
	 */
	var spawner: AbstractSpawner? by selfNamed()
	
	abstract override fun copy(): AbstractPopulator
	
	operator fun AbstractSpawner.unaryPlus() {
		this@AbstractPopulator.spawner = this@unaryPlus.copy()
	}
}

@MustUseReturnValues
object Populators {
	
	/**
	 * Define a set of bots that spawn on a cooldown instead of based on the normal wave schedule.
	 *
	 * Example: sentry busters, snipers, spies.
	 *
	 * @param waveNumber What wave this mission should start proc'ing on.
	 * @param runForWaves How many waves this mission should run for, including its start wave.  Defaults to `1`.
	 */
	inline fun Mission(waveNumber: Int? = null, runForWaves: Int = 1, configure: MissionPopulator.() -> Unit): MissionPopulator {
		return MissionPopulator().also {
			if (waveNumber != null)
				it.beginAtWave = waveNumber
			
			it.runForThisManyWaves = runForWaves
		}.apply(configure)
	}
	
	/**
	 * Configure multiple subwaves to go off at once.
	 *
	 * Any settings applied in [configureAll] will be applied to all inner items, and all inner items will be given the name set in [name] for the purpose of linking.
	 */
	inline fun WaveSpawn_Multi(name: String?, vararg waveSpawns: WaveSpawnPopulator, configureAll: MultiSubwavePopulator.() -> Unit = {}): WaveSpawnPopulator {
		return MultiSubwavePopulator().apply {
			waveSpawns.mapTo(items) { it.copy() }
			if (name != null)
				this.name = name
		}.apply(configureAll)
	}
	
	
	/**
	 * Configure multiple subwaves to go off at once.
	 *
	 * Any settings applied in [configureAll] will be applied to all inner items.
	 * All inner items will be given the name of the property this is a delegate for for the purpose of linking.
	 *
	 * This function should only be used with a delegated property (e.g. `val x by WaveSpawn_Multi(...)`).
	 *
	 * @param waveSpawns The WaveSpawns that should be given this name and settings.
	 * @param configureAll Block scope to configure (copies of) all given [waveSpawns].
	 */
	inline fun WaveSpawn_Multi(vararg waveSpawns: WaveSpawnPopulator, configureAll: MultiSubwavePopulator.() -> Unit = {}): PropertyDelegateProvider<Any?, ReadOnlyProperty<Any?, WaveSpawnPopulator>> {
		val inst = MultiSubwavePopulator().apply {
			waveSpawns.mapTo(items) { it.copy() }
		}.apply(configureAll)
		
		return PropertyDelegateProvider { _, prop ->
			ReadOnlyConstant(inst.apply { name = prop.name })
		}
	}
	
	
	inline fun PeriodicSpawn(configure: PeriodicSpawnPopulator.() -> Unit) = PeriodicSpawnPopulator().apply(configure)
	
	
	inline fun RandomPlacement(configure: RandomPlacementPopulator.() -> Unit) = RandomPlacementPopulator().apply(configure)
}