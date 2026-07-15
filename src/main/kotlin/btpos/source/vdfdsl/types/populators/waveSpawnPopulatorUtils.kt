package btpos.source.vdfdsl.types.populators

import btpos.source.vdfdsl.utils.toSeconds
import kotlin.time.Duration

/**
 * Spawn this many bots at a time, allowing this many bots to be alive at once.
 *
 * Alias for `maxActive = amount; spawnCount = amount`
 */
fun WaveSpawnPopulator.individualGroupsOf(amount: Int) {
	maxActive = amount
	spawnCount = amount
}

/**
 * Alias for:
 * ```
 * maxActive = totalCount
 * spawnCount = totalCount
 * waitBetweenSpawns = 0
 * ```
 */
fun WaveSpawnPopulator.allAtOnce() {
	this.maxActive = this.totalCount!!
	this.spawnCount = this.totalCount!!
	this.waitBetweenSpawns = 0
}

/**
 * Alias for:
 * ```kotlin
 * maxActive = totalCount
 * spawnCount = groupSize // defaults to 1
 * waitBetweenSpawns = delayBetweenSpawns
 * ```
 */
fun WaveSpawnPopulator.trickleInEvery(delayBetweenSpawns: Duration, groupSize: Int = 1) {
	maxActive = totalCount ?: error("Total count not set.")
	spawnCount = groupSize
	waitBetweenSpawns = delayBetweenSpawns.toSeconds()
}

/**
 * Alias for `waitBetweenSpawns = <duration>.toSeconds()`
 */
fun WaveSpawnPopulator.spawnEvery(duration: Duration) {
	waitBetweenSpawns = duration.toSeconds()
}