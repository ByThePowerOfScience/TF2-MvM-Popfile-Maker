package btpos.source.vdfdsl.types.populators

import btpos.source.vdfdsl.modeling.ExtensibleSubtreeImpl
import btpos.source.vdfdsl.modeling.IExtensibleSubtree_VDFRepresentable
import btpos.source.vdfdsl.utils.toSeconds
import kotlin.collections.plusAssign
import kotlin.time.Duration
import kotlin.time.Duration.Companion.seconds

/**
 * A [WavePopulator] with some additional utilities for timing.
 *
 * @see wait
 */
class WaveBuilder(subtree: IExtensibleSubtree_VDFRepresentable = ExtensibleSubtreeImpl()) : WavePopulator(subtree) {
	interface WaitingFor {
		companion object {
			interface ConflictDetector {
				fun overwriteConflicts(waveSpawn: WaveSpawnPopulator)
				
				fun failConflicts(waveSpawn: WaveSpawnPopulator): Throwable?
			}
			
			
			@PublishedApi internal val conflicts = mutableListOf<Pair<Class<out WaitingFor>, ConflictDetector>>()
			
			/**
			 * Your `WaitingFor` has some item it needs to set.
			 *
			 * If that's already set on a WaveSpawn that someone's trying to provide, we need to either overwrite that with null (if the user says we can) or just outright fail to apply it.
			 */
			inline fun <reified T : WaitingFor> registerConflict(predicate: ConflictDetector) {
				this.conflicts += Pair(T::class.java, predicate)
			}
			
			init {
				registerConflict<TotalTimeElapsed>(TotalTimeElapsed.Detector)
				registerConflict<AllDead>(AllDead.Detector)
				registerConflict<AllSpawned>(AllSpawned.Detector)
			}
		}
		
		fun applyToWaveSpawn(waveSpawn: WaveSpawnPopulator, timeElapsed: Duration)
		
		class TotalTimeElapsed : WaitingFor {
			object Detector : ConflictDetector {
				override fun overwriteConflicts(waveSpawn: WaveSpawnPopulator) {}
				
				override fun failConflicts(waveSpawn: WaveSpawnPopulator): Throwable? = null
			}
			
			override fun applyToWaveSpawn(waveSpawn: WaveSpawnPopulator, timeElapsed: Duration) {
				waveSpawn.waitBeforeStarting = timeElapsed.toSeconds()
			}
		}
		
		class AllDead(val waitingOn: WaveSpawnPopulator) : WaitingFor {
			object Detector : ConflictDetector {
				override fun overwriteConflicts(waveSpawn: WaveSpawnPopulator) {
					waveSpawn.waitForAllDead = null
				}
				
				override fun failConflicts(waveSpawn: WaveSpawnPopulator): Throwable? {
					if (waveSpawn.waitForAllDead != null)
						return IllegalArgumentException("waitForAllDead was already set on wavespawn.")
					return null;
				}
			}
			
			override fun applyToWaveSpawn(waveSpawn: WaveSpawnPopulator, timeElapsed: Duration) {
				waveSpawn.waitForAllDead = waitingOn
				waveSpawn.waitBeforeStarting = timeElapsed.toSeconds()
			}
		}
		
		class AllSpawned(val waitingOn: WaveSpawnPopulator) : WaitingFor {
			object Detector : ConflictDetector {
				override fun overwriteConflicts(waveSpawn: WaveSpawnPopulator) {
					waveSpawn.waitForAllSpawned = null
				}
				
				override fun failConflicts(waveSpawn: WaveSpawnPopulator): Throwable? {
					if (waveSpawn.waitForAllSpawned != null)
						return IllegalArgumentException("waitForAllSpawned was already set")
					return null;
				}
			}
			
			override fun applyToWaveSpawn(waveSpawn: WaveSpawnPopulator, timeElapsed: Duration) {
				waveSpawn.waitForAllSpawned = this.waitingOn
				waveSpawn.waitBeforeStarting = timeElapsed.toSeconds()
			}
		}
	}
	
	var _offsetAfter: WaitingFor = WaitingFor.TotalTimeElapsed()
	
	var _currentTimeOffset: Duration = 0.seconds
	
	/**
	 * The default `Where` field for any WaveSpawns that don't have it set.
	 */
	lateinit var defaultSpawnLocation: String
	
	/**
	 * The next wavespawns added with `+` should happen after [duration] amount of time has passed since the previous subwaves began.
	 *
	 * Example:
	 * ```kotlin
	 * val myWave = Wave {
	 *    +WaveSpawn { ... } // WaitBeforeStarting 0
	 * 	  wait(30.seconds)
	 * 	  +WaveSpawn { ... } // WaitBeforeStarting 30
	 * 	  wait(30.seconds)
	 * 	  +WaveSpawn { ... } // WaitBeforeStarting 60
	 * }
	 * ```
	 *
	 * @see Duration.Companion.seconds
	 */
	fun wait(duration: Duration) {
		_currentTimeOffset += duration
	}
	
	/**
	 * Add a WaveSpawn that may already have its [waitBeforeStarting][WaveSpawnPopulator.waitBeforeStarting] field set to trigger at the current time, regardless of its existing field.
	 */
	fun addOverridingConflicts(waveSpawn: WaveSpawnPopulator) {
		addAtTime(waveSpawn, true)
	}
	
	override fun WaveSpawnPopulator.unaryPlus() {
		this@WaveBuilder.addAtTime(this, false)
	}
	
	fun addAtTime(waveSpawn: WaveSpawnPopulator, overwriteConflicts: Boolean) {
		waveSpawns += waveSpawn.copy().apply {
			val waitingFor = this@WaveBuilder._offsetAfter
			val waitingForClass = waitingFor.javaClass
			for ((goodClass, conflictDetector) in WaitingFor.conflicts) {
				if (waitingForClass == goodClass)
					continue;
				
				if (overwriteConflicts)
					conflictDetector.overwriteConflicts(this)
				else
					conflictDetector.failConflicts(this)?.let { throw it }
			}
			
			waitingFor.applyToWaveSpawn(this, this@WaveBuilder._currentTimeOffset)
			
			
			if (this.where == null) {
				if (this@WaveBuilder::defaultSpawnLocation.isInitialized) {
					this.where = this@WaveBuilder.defaultSpawnLocation
				} else {
					error("WaveSpawn did not have a `where`, but WaveBuilder#defaultSpawnLocation is not set.")
				}
			}
		}
	}
}


/**
 * All next wavespawns added with `+` should happen after the given [subwave] has been beaten.
 *
 * Any further [wait] calls will be delays off of that moment.
 *
 * Example:
 * ```kotlin
 * val myWave = Wave {
 *    val subwave1 by WaveSpawn { ... }
 *    val subwave2 by WaveSpawn { ... }
 *    val subwave3 by WaveSpawn { ... }
 *
 *    +subwave1  // WaitBeforeStarting 0
 * 	  wait(30.seconds)
 * 	  +subwave2  // WaitBeforeStarting 30
 * 	  waitForAllDead(subwave2)
 * 	  wait(5.seconds)
 * 	  +subwave3 // WaitBeforeStarting 5, WaitForAllDead "subwave2"
 * }
 * ```
 *
 * @see Duration.Companion.seconds
 */
fun WaveBuilder.waitForAllDead(subwave: WaveSpawnPopulator) {
	this._currentTimeOffset = 0.seconds
	this._offsetAfter = WaveBuilder.WaitingFor.AllDead(subwave)
}


/**
 * All next wavespawns added with `+` should happen after all bots in the given [subwave] have finished spawning.
 *
 * Any further [wait] calls will be delays off of that moment.
 *
 * Example:
 * ```kotlin
 * val myWave = Wave {
 *    val subwave1 by WaveSpawn { ... }
 *    val subwave2 by WaveSpawn { ... }
 *    val subwave3 by WaveSpawn { ... }
 *
 *    +subwave1  // WaitBeforeStarting 0
 * 	  wait(30.seconds)
 * 	  +subwave2  // WaitBeforeStarting 30
 * 	  waitForAllSpawned(subwave2)
 * 	  wait(5.seconds)
 * 	  +subwave3 // WaitForAllSpawned "subwave2", WaitBeforeStarting 5
 * }
 * ```
 *
 * @see Duration.Companion.seconds
 */
fun WaveBuilder.waitForAllSpawned(subwave: WaveSpawnPopulator) {
	this._currentTimeOffset = 0.seconds
	this._offsetAfter = WaveBuilder.WaitingFor.AllSpawned(subwave)
}


inline fun WaveBuilder(configure: WaveBuilder.() -> Unit) = WaveBuilder().apply(configure)