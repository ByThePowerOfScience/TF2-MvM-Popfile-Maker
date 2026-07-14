package btpos.source.vdfdsl.workshop

import btpos.source.vdfdsl.tf2.templates.RobotStandardTemplates
import btpos.source.vdfdsl.types.populators.WaveSpawnPopulator
import btpos.source.vdfdsl.types.populators.provideDelegate
import btpos.source.vdfdsl.types.spawners.AbstractSpawner
import btpos.source.vdfdsl.types.spawners.Spawners.TFBot
import btpos.source.vdfdsl.utils.toSeconds
import kotlin.reflect.KProperty
import kotlin.time.Duration
import kotlin.time.Duration.Companion.seconds

/**
 * Showcase of another possible syntax: infix "sentence-like" grammar.
 *
 * I'm not a fan, but it _is_ cool that you can do this without any allocations.
 */
@Suppress("NOTHING_TO_INLINE")
@JvmInline value class WaveSpawnBuilder(val internal: WaveSpawnPopulator) {
	/**
	 * Spawn the bots after this much time has elapsed since the start of the wave.
	 *
	 * @see Duration.Companion.seconds
	 */
	inline infix fun after(timing: Duration) = WaveSpawnBuilder(internal.apply {
		waitBeforeStarting = timing.toSeconds()
	})
	
	inline infix fun afterFinishSpawning(subwave: WaveSpawnPopulator) = WaveSpawnBuilder(internal.apply {
		waitForAllSpawned = subwave
	})
	
	inline infix fun afterBeating(subwave: WaveSpawnPopulator) = WaveSpawnBuilder(internal.apply {
		waitForAllDead = subwave
	})
	
	inline infix fun inGroupsOf(number: Int) = WaveSpawnBuilder(internal.apply {
		maxActive = number
		spawnCount = number
	})
	
	inline infix fun waitingBetweenSpawns(timing: Duration) = WaveSpawnBuilder(internal.apply {
		waitBetweenSpawns = timing.toSeconds()
	})
	
	inline operator fun provideDelegate(thisRef: Any?, prop: KProperty<*>) = internal.provideDelegate(thisRef, prop)
}

fun spawn(number: Int, spawner: AbstractSpawner) = WaveSpawnBuilder(WaveSpawnPopulator().apply {
	totalCount = number
	this.spawner = spawner
})

fun foo() {
	val wave01b by spawn(2, TFBot(template=RobotStandardTemplates.Soldier.BUFF_BANNER)) after 2.seconds inGroupsOf 1 waitingBetweenSpawns 2.seconds
}