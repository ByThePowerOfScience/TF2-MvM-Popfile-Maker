package btpos.source.vdfdsl.tests.valvepopfiles

import btpos.source.vdfdsl.backing.VDFPrimitive
import btpos.source.vdfdsl.backing.VDFSubtree
import btpos.source.vdfdsl.backing.getString
import btpos.source.vdfdsl.backing.toFormattedString
import btpos.source.vdfdsl.modeling.invoke
import btpos.source.vdfdsl.tf2.itemattributes.BuffItemAttributes
import btpos.source.vdfdsl.tf2.items.weapons.Weapons
import btpos.source.vdfdsl.tf2.templates.RobotGiantTemplates
import btpos.source.vdfdsl.tf2.templates.RobotStandardTemplates
import btpos.source.vdfdsl.types.WaveSchedule
import btpos.source.vdfdsl.types.bots.Attributes
import btpos.source.vdfdsl.types.bots.BehaviorModifiers
import btpos.source.vdfdsl.types.bots.BotSkill
import btpos.source.vdfdsl.types.bots.BotSkill.Companion.Easy
import btpos.source.vdfdsl.types.bots.TFBotAttributes
import btpos.source.vdfdsl.types.bots.TFClass
import btpos.source.vdfdsl.types.bots.WeaponRestrictions
import btpos.source.vdfdsl.types.populators.*
import btpos.source.vdfdsl.types.populators.Populators.Mission
import btpos.source.vdfdsl.types.populators.Populators.WaveSpawn_Multi
import btpos.source.vdfdsl.types.populators.WaveSpawnPopulator.Support
import btpos.source.vdfdsl.types.spawners.Spawners.RandomChoice
import btpos.source.vdfdsl.types.spawners.Spawners.Squad
import btpos.source.vdfdsl.types.spawners.Spawners.TFBot
import btpos.source.vdfdsl.types.spawners.Spawners.Tank
import btpos.source.vdfdsl.types.spawners.TFBotSpawner
import btpos.source.vdfdsl.types.spawners.TankSpawner
import btpos.source.vdfdsl.types.spawners.critBoosted
import btpos.source.vdfdsl.types.spawners.addAttributesForExisting
import btpos.source.vdfdsl.types.spawners.attributes
import btpos.source.vdfdsl.types.spawners.behaviorModifiers
import btpos.source.vdfdsl.types.spawners.characterAttributes
import btpos.source.vdfdsl.types.spawners.items
import btpos.source.vdfdsl.types.spawners.maxVisionRange
import btpos.source.vdfdsl.types.spawners.skill
import btpos.source.vdfdsl.types.spawners.tags
import btpos.source.vdfdsl.types.spawners.weaponRestriction
import btpos.source.vdfdsl.types.specifics.OutputAction
import btpos.source.vdfdsl.utils.plus
import btpos.source.vdfdsl.vdfparser.ParseVDF
import org.junit.jupiter.api.Test
import kotlin.io.path.Path
import kotlin.io.path.inputStream
import kotlin.test.assertEquals
import kotlin.test.assertNotNull
import kotlin.time.Duration.Companion.seconds


private const val basicSpawn = "spawnbot"

private const val tag_preferFlankRight = "nav_prefer_flank_right"
private const val tag_preferFlankLeft = "nav_prefer_flank_left"

private const val tag_specialmainright = "special_main_right"

private const val tag_specialmainleft = "special_main_left"

class mvm_coaltown_expert1 {
	val GIANT_SCOUT get() = TFBot(template = RobotGiantTemplates.Scout.`Super Scout`)
	
	val HEAVY_FIST get() = TFBot(template= RobotStandardTemplates.Heavyweapons.FIST)
	val GIANT_HEAVY get() = TFBot(template = RobotGiantTemplates.Heavyweapons.`Giant Heavy`)
	val GIANT_DEFLECTOR_HEAVY = TFBot(template = RobotGiantTemplates.Heavyweapons.`Giant Deflector Heavy`)
	val QUICKFIX_MEDIC get() = TFBot(template = RobotStandardTemplates.Medic.QUICKUBER)
	val EASY_SCOUT
		get() = TFBot {
			`class` = TFClass.Scout
			skill = Easy
		}
	
	val PUSHING_SOLDIER_LEFT
		get() = TFBot {
			`class` = TFClass.Soldier
			skill = BotSkill.Hard
			tags += tag_preferFlankLeft
			behaviorModifiers += BehaviorModifiers.Push
		}
	val PUSHING_SOLDIER_RIGHT
		get() = PUSHING_SOLDIER_LEFT {
			tags = listOf(tag_preferFlankRight)
		}
	
	fun spyMission(startWave: Int, startCooldown: Int) = Mission {
		objective = Objective.Spy
		initialCooldown = startCooldown
		where = "spawnbot_mission_spy"
		beginAtWave = startWave
		runForThisManyWaves = 1
		cooldownTime = 30
		desiredCount = 4
		
		+TFBot {
			`class` = TFClass.Spy
			skill = BotSkill.Expert
			name = "Spy"
		}
	}
	
	@Test
	fun coaltownExpert1() {
		val x = WaveSchedule {
			startingCurrency = 400
			respawnWaveTime = 7
			canBotsAttackWhileInSpawnRoom = false
			
			+Mission(1, 9) {
				objective = Objective.DestroySentries
				
				initialCooldown = 5
				where = basicSpawn
				
				cooldownTime = 20
				
				+TFBot(template = RobotGiantTemplates.SENTRY_BUSTER)
			}
			
			+spyMission(1, 10)
			+spyMission(2, 20)
			+spyMission(4, 80).apply {
				cooldownTime = 50
			}
			
			+Mission(1) {
				objective = Objective.Sniper
				initialCooldown = 75
				where = "spawnbot_mission_sniper"
				cooldownTime = 20
				desiredCount = 4
				
				+TFBot("Sniper") {
					`class` = TFClass.Sniper
					skill = BotSkill.Hard
					maxVisionRange = 3000
				}
			}
			+Mission(5) {
				objective = Objective.Sniper
				where = "spawnbot_mission_sniper"
				initialCooldown = 30
				cooldownTime = 20
				desiredCount = 6
				
				+TFBot {
					template = RobotStandardTemplates.Sniper.SYDNEY_SLEEPER
					items += Weapons.RAZORBACK
				}
			}.also {
				populators += it.copy().apply {
						beginAtWave = 7
						desiredCount = 4
					}
			}
			
			+wave1()
			+wave2()
			+wave3()
			+wave4()
			+wave5()
			+wave6()
			+wave7()
		}
		
		val asSubtree = VDFSubtree(null).also { x._serializeInto(it) }
		
		compareSubtreesUnordered(emptyList(), ParseVDF.parse(Path("mvm_coaltown_expert1.pop").inputStream()), asSubtree)
	}
	
	
	
	/**
	 * Presets for all waves
	 */
	fun WavePopulator.myDefaultWaveSettings() {
		startWaveOutput {
			trigger("wave_start_relay")
		}
		doneOutput {
			trigger("wave_finished_relay")
		}
		waitWhenDone = 65
		@Suppress("Deprecation")
		checkpoint = true
	}
	
	fun WaveSpawnPopulator.defaultSpawnLocation() {
		this.where = "spawnbot"
	}
	
	fun WaveSpawnPopulator.giantSpawnLocation() {
		this.where = "spawnbot_giant"
	}
	
	/**
	 * Currency 800
	 */
	fun wave1(): WavePopulator {
		return Wave {
			myDefaultWaveSettings()
			// Sniper mission - 4 active (late appearance)
			// Spy mission - 4 active
			
			val wave01a by WaveSpawn {
				defaultSpawnLocation()
				
				totalCount = 30
				maxActive = 10
				spawnCount = 10
				waitBeforeStarting = 0
				waitBetweenSpawns = 0
				
				totalCurrency = 200
				
				+TFBot(template = RobotStandardTemplates.Scout.BONK)
			}
			
			val wave01b by WaveSpawn {
				defaultSpawnLocation()
				
				totalCount = 16
				maxActive = 12
				spawnCount = 2
				waitBeforeStarting = 0
				waitBetweenSpawns = 7
				totalCurrency = 100
				
				+Squad {
					+HEAVY_FIST
					+QUICKFIX_MEDIC
				}
			}
			
			val wave01c by WaveSpawn {
				defaultSpawnLocation()
				waitForAllDead = wave01a
				
				totalCount = 30
				maxActive = 10
				spawnCount = 5
				waitBeforeStarting = 0
				waitBetweenSpawns = 0
				totalCurrency = 200
				
				+EASY_SCOUT
			}
			
			val wave01d by WaveSpawn {
				defaultSpawnLocation()
				
				totalCount = 15
				maxActive = 12
				spawnCount = 3
				waitForAllDead = wave01b
				waitBeforeStarting = 0
				waitBetweenSpawns = 5
				totalCurrency = 150
				
				+Squad {
					+HEAVY_FIST
					+QUICKFIX_MEDIC
					+TFBot {
						`class` = TFClass.Pyro
						skill = Easy
						attributes = listOf(TFBotAttributes.AlwaysFireWeapon)
					}
				}
			}
			
			val wave01e by WaveSpawn {
				defaultSpawnLocation()
				
				waitForAllDead = wave01b
				totalCount = 12
				maxActive = 12
				spawnCount = 12
				waitBeforeStarting = 0
				waitBetweenSpawns = 0
				totalCurrency = 150
				
				
				+TFBot {
					`class` = TFClass.Soldier
					skill = BotSkill.Hard
				}
			}
			
			+wave01a
			+wave01b
			+wave01c
			+wave01d
			+wave01e
		}
	}
	
	fun wave2(): WavePopulator {
		return Wave {
			myDefaultWaveSettings()
			val wave02a by WaveSpawn {
				defaultSpawnLocation()
				
				totalCount = 6
				maxActive = 6
				spawnCount = 1
				waitBeforeStarting = 0
				waitBetweenSpawns = 7
				totalCurrency = 100
				
				+GIANT_SCOUT
			}
			
			val wave02b by WaveSpawn {
				giantSpawnLocation()
				
				totalCount = 18
				maxActive = 9
				spawnCount = 9
				waitBeforeStarting = 0
				waitBetweenSpawns = 0
				totalCurrency = 200
				
				+Squad {
					+GIANT_HEAVY
					+(QUICKFIX_MEDIC * 8)
				}
			}
			
			val wave02c by WaveSpawn {
				defaultSpawnLocation()
				
				totalCount = 30
				maxActive = 10
				spawnCount = 10
				waitForAllDead = wave02a
				waitBeforeStarting = 0
				waitBetweenSpawns = 0
				totalCurrency = 250
				
				+EASY_SCOUT
			}
			
			val wave02d by WaveSpawn {
				defaultSpawnLocation()
				
				totalCount = 10
				maxActive = 10
				spawnCount = 10
				waitForAllSpawned = wave02b
				waitBeforeStarting = 0
				waitBetweenSpawns = 0
				totalCurrency = 150
				
				+TFBot {
					`class` = TFClass.HeavyWeapons
					skill = Easy
				}
			}
			
			val wave02e by WaveSpawn {
				defaultSpawnLocation()
				
				waitForAllSpawned = wave02b
				totalCount = 6
				maxActive = 2
				spawnCount = 2
				waitBeforeStarting = 0
				waitBetweenSpawns = 0
				totalCurrency = 100
				
				+TFBot {
					`class` = TFClass.Soldier
					skill = BotSkill.Expert
					items += Weapons.DIRECT_HIT
					tags += tag_preferFlankRight
				}
			}
			
			+wave02a
			+wave02b
			+wave02c
			+wave02d
			+wave02e
		}
	}
	
	inline fun tankSubWave(health: Int, speed: Number, tankConfiguration: TankSpawner.() -> Unit = {}, additionalConfiguration: WaveSpawnPopulator.() -> Unit = {}) = WaveSpawn {
		firstSpawnOutput = OutputAction {
			trigger("boss_spawn_relay")
		}
		
		additionalConfiguration()
		
		+Tank {
			this.health = health
			this.speed = speed
			this.name = "tankboss"
			this.startingPathTrackNode = "boss_path_a1"
			
			tankConfiguration()
			
			onKilledOutput = OutputAction {
				trigger("boss_dead_relay")
			}
			onBombDroppedOutput = OutputAction {
				trigger("boss_deploy_relay")
			}
		}
	}
	
	fun wave3() = Wave {
		myDefaultWaveSettings()
		val wave03a by WaveSpawn_Multi(
			tankSubWave(35_000, 75) {
				totalCount = 1
				waitBeforeStarting = 0
				totalCurrency = 300
			},
			WaveSpawn {
				defaultSpawnLocation()
				totalCount = 20
				maxActive = 2
				spawnCount = 2
				waitBeforeStarting = 0
				waitBetweenSpawns = 0
				totalCurrency = 100
				
				support = Support.INFINITE
				
				+EASY_SCOUT {
					weaponRestriction = WeaponRestrictions.MeleeOnly
					attributes += TFBotAttributes.AlwaysCrit
				}
			}
		)
		
		
		val wave03b by WaveSpawn {
			defaultSpawnLocation()
			
			totalCount = 20
			maxActive = 10
			spawnCount = 10
			waitBeforeStarting = 15
			waitBetweenSpawns = 0
			totalCurrency = 200
			
			+PUSHING_SOLDIER_RIGHT
		}
		val wave03c by WaveSpawn {
			defaultSpawnLocation()
			
			totalCount = 20
			maxActive = 10
			spawnCount = 10
			waitBeforeStarting = wave03b.waitBeforeStarting!! + 8
			waitBetweenSpawns = 0
			totalCurrency = 200
			
			+PUSHING_SOLDIER_LEFT
		}
		val wave03d by WaveSpawn {
			giantSpawnLocation()
			
			totalCount = 3
			maxActive = 3
			spawnCount = 1
			waitBeforeStarting = wave03c.waitBeforeStarting!! + 22
			waitBetweenSpawns = 25
			totalCurrency = 100
			
			+GIANT_DEFLECTOR_HEAVY
		}
		
		+wave03a
		+wave03b
		+wave03c
		+wave03d
	}
	
	val TFBotSpawner.fromRight
		get() = this {
			tags += tag_preferFlankRight
		}
	val TFBotSpawner.fromLeft
		get() = this {
			tags += tag_preferFlankLeft
		}
	
	
	fun wave4() = Wave {
		myDefaultWaveSettings()
		val wave04a by tankSubWave(health = 20_000, speed = 75) {
			totalCount = 4
			waitBeforeStarting = 0
			waitBetweenSpawns = 30
			totalCurrency = 200
		}
		
		val wave04b by WaveSpawn {
			defaultSpawnLocation()
			totalCount = 48
			individualGroupsOf(12)
			waitBeforeStarting = 30
			waitBetweenSpawns = 20
			totalCurrency = 200
			
			+TFBot {
				`class` = TFClass.Scout
				skill = BotSkill.Hard
				weaponRestriction = WeaponRestrictions.MeleeOnly
				attributes += TFBotAttributes.AlwaysCrit
			}
		}
		
		val wave04c by WaveSpawn {
			defaultSpawnLocation()
			
			totalCount = 24
			individualGroupsOf(6)
			
			waitBeforeStarting = 60
			waitBetweenSpawns = 20
			totalCurrency = 200
			
			val huntsman = TFBot {
				template = RobotStandardTemplates.Sniper.HUNTSMAN
				behaviorModifiers += BehaviorModifiers.Push
			}
			+RandomChoice(huntsman.fromRight, huntsman.fromLeft)
		}
		
		val heavy = TFBot {
			`class` = TFClass.HeavyWeapons
			skill = BotSkill.Hard
			behaviorModifiers += BehaviorModifiers.Push
		}
		
		val wave04de by WaveSpawn_Multi(
			WaveSpawn {
				+Squad {
					+heavy {
						tags += tag_specialmainright
					}
					+QUICKFIX_MEDIC
				}
			},
			WaveSpawn {
				+Squad {
					+heavy {
						tags += tag_specialmainleft
					}
					+QUICKFIX_MEDIC
				}
			}
		) {
			defaultSpawnLocation()
			
			totalCount = 8
			maxActive = 2
			spawnCount = 2
			waitBeforeStarting = 45
			waitBetweenSpawns = 15
			totalCurrency = 50
		}
		
		val wave04f by WaveSpawn {
			giantSpawnLocation()
			
			totalCount = 5
			allAtOnce()
			waitForAllSpawned = wave04de
			waitBeforeStarting = 15
			totalCurrency = 100
			
			+Squad {
				+GIANT_HEAVY {
					tags += tag_specialmainleft
					behaviorModifiers += BehaviorModifiers.Push
				}
				addMultiple(4, QUICKFIX_MEDIC)
			}
		}
		
		val wave04g by WaveSpawn {
			giantSpawnLocation()
			
			totalCount = 5
			allAtOnce()
			
			waitForAllSpawned = wave04de
			waitBeforeStarting = 15
			
			totalCurrency = 100
			
			+Squad {
				+GIANT_HEAVY {
					tags += tag_specialmainright
					behaviorModifiers += BehaviorModifiers.Push
				}
				addMultiple(4, QUICKFIX_MEDIC)
			}
		}
		+wave04a
		+wave04b
		+wave04c
		+wave04de
		+wave04f
		+wave04g
	}
	
	
	fun wave5() = Wave {
		myDefaultWaveSettings()
		val wave05a by WaveSpawn {
			defaultSpawnLocation()
			
			totalCount = 112
			maxActive = 16
			spawnCount = 8
			waitBeforeStarting = 0
			waitBetweenSpawns = 7
			totalCurrency = 350
			
			+TFBot(template = RobotStandardTemplates.Demoman.KNIGHT).critBoosted
		}
		
		fun squadWithSoldier(sideTag: String) = Squad {
			+TFBot(template = RobotGiantTemplates.Soldier.`Giant Rapid Fire Soldier`) {
				tags += sideTag
				behaviorModifiers += BehaviorModifiers.Push
			}
			+QUICKFIX_MEDIC
		}
		
		val wave05b by WaveSpawn {
			giantSpawnLocation()
			
			totalCount = 6
			maxActive = 4
			spawnCount = 2
			
			waitBeforeStarting = 30
			waitBetweenSpawns = 60
			totalCurrency = 100
			
			spawner = squadWithSoldier(tag_specialmainleft)
		}
		val wave05c by wave05b.copy()
			.apply {
				spawner = squadWithSoldier(tag_specialmainright)
			}
		
		val wave05d by WaveSpawn {
			giantSpawnLocation()
			
			totalCount = 4
			trickleInEvery(45.seconds)
			waitBeforeStarting = 60
			totalCurrency = 50
			
			+GIANT_SCOUT
		}
		
		val wave05e by WaveSpawn {
			giantSpawnLocation()
			
			totalCount = 6
			trickleInEvery(2.seconds)
			waitForAllSpawned = wave05d
			waitBeforeStarting = 60
			totalCurrency = 50
			
			+GIANT_SCOUT
		}
		
		+wave05a
		+wave05b
		+wave05c
		+wave05d
		+wave05e
	}
	
	fun wave6() = WaveBuilder {
		myDefaultWaveSettings()
		
		val hardScouts = WaveSpawn("wave06a") {
			defaultSpawnLocation()
			
			totalCount = 36
			individualGroupsOf(18)
			waitBetweenSpawns = 10
			
			totalCurrency = 300
			
			+TFBot {
				`class` = TFClass.Scout
				skill = BotSkill.Hard
			}
		}
		
		val giantHeavyWithMedic = WaveSpawn("wave06b") {
			giantSpawnLocation()
			
			totalCount = 8
			maxActive = 4
			spawnCount = 2
			waitBetweenSpawns = 20
			
			totalCurrency = 100
			
			+Squad {
				+GIANT_DEFLECTOR_HEAVY
				+TFBot(template= RobotGiantTemplates.Medic.`Giant Medic`)
			}
		}
		
		val fastScouts = WaveSpawn("wave06c") {
			defaultSpawnLocation()
			totalCount = 5
			maxActive = 5
			spawnCount = 2
			waitBetweenSpawns = 25
			
			totalCurrency = 200
			
			+GIANT_SCOUT
		}
		
		val hardSoldiers = WaveSpawn("wave06d") {
			defaultSpawnLocation()
			totalCount = 12
			allAtOnce()
			totalCurrency = 100
			
			+TFBot {
				`class` = TFClass.Soldier
				skill = BotSkill.Hard
			}
		}
		
		+hardScouts
		wait(5.seconds)
		+giantHeavyWithMedic
		waitForAllDead(hardScouts)
		+fastScouts
		wait(5.seconds)
		+hardSoldiers
	}
	
fun wave7() = WaveBuilder {
	myDefaultWaveSettings()
	
	
	val tanksEvery30Seconds = tankSubWave(20_000, 75) {
		name = "wave07a"
		
		totalCount = 5
		spawnEvery(30.seconds)
		totalCurrency = 500
	}
	val hardScoutsWithMedics = WaveSpawn(name="wave07c") {
		defaultSpawnLocation()
		totalCount = 54
		maxActive = 6
		spawnCount = 4
		waitBetweenSpawns = 5
		
		totalCurrency = 300
		
		+Squad {
			+EASY_SCOUT {
				skill = BotSkill.Hard
			}
			+QUICKFIX_MEDIC
		}
	}
	
	val heavyHuntsmanSwarm = WaveSpawn_Multi("wave07cd") {
		val heavy = TFBot {
			`class` = TFClass.HeavyWeapons
			skill = BotSkill.Hard
		}
		val huntsmanSniper = TFBot(template = RobotStandardTemplates.Sniper.HUNTSMAN) {
			addAttributesForExisting(Weapons.HUNTSMAN) {
				damage.bonus.visible = 0.075f
				fasterReloadRate = 0.4f
			}
		}
		
		+WaveSpawn {
			+Squad {
				formationSize = 225
				
				addMultiple(3, heavy {
					tags += tag_specialmainleft
				})
				
				addMultiple(3, huntsmanSniper)
			}
		}
		+WaveSpawn {
			+Squad {
				formationSize = 175
				addMultiple(3, heavy {
					tags += tag_specialmainright
				})
				addMultiple(3, huntsmanSniper)
			}
		}
		defaultSpawnLocation()
		totalCount = 36
		maxActive = 12
		spawnCount = 6
		waitBetweenSpawns = 15
		
		totalCurrency = 200
	}
	
	val directHitBannerSoldiers = WaveSpawn("wave07e") {
		defaultSpawnLocation()
		totalCount = 12
		maxActive = 12
		spawnCount = 6
		waitBetweenSpawns = 15
		totalCurrency = 50
		
		+TFBot {
			`class` = TFClass.Soldier
			skill = BotSkill.Expert
			weaponRestriction = WeaponRestrictions.PrimaryOnly
			items += Weapons.DIRECT_HIT
			items += Weapons.BUFF_BANNER
			attributes += Attributes.SpawnWithFullCharge
			characterAttributes {
				BuffItemAttributes.increaseBuffDuration = 9.0f
			}
		}
	}
	
	fun giantHeavy(letter: String, tag: String) = WaveSpawn(name="wave07$letter") {
		defaultSpawnLocation()
		totalCount = 1
		allAtOnce()
		totalCurrency = 50
		
		+GIANT_HEAVY {
			tags += tag
			behaviorModifiers += BehaviorModifiers.Push
		}
	}
	
	val finalTankBoss = tankSubWave(45_000, 75, tankConfiguration = {
		skin = 1
	}) {
		name = "wave07j"
		totalCount = 1
		waitBetweenSpawns = 0
		waitBeforeStarting = 15
		totalCurrency = 0
	}
	
	+tanksEvery30Seconds
	+hardScoutsWithMedics
	wait(60.seconds)
	+heavyHuntsmanSwarm
	waitForAllSpawned(heavyHuntsmanSwarm)
	+directHitBannerSoldiers
	waitForAllSpawned(directHitBannerSoldiers)
	+giantHeavy("f", tag_specialmainleft)
	wait(5.seconds)
	+giantHeavy("g", tag_specialmainright)
	wait(5.seconds)
	+giantHeavy("h", tag_preferFlankRight)
	wait(5.seconds)
	+giantHeavy("i", tag_preferFlankLeft)
	+finalTankBoss
}
}


fun comparePrimitives(expected: VDFPrimitive, actual: VDFPrimitive): Boolean {
	return expected.stringValue.equals(actual.stringValue, ignoreCase = true) || run {
		val float = expected.stringValue.toDoubleOrNull()
		val f2 = actual.stringValue.toDoubleOrNull()
		float != null && float == f2
	}
}

fun compareSubtreesUnordered(prevKeys: List<String>, expected: VDFSubtree, actual: VDFSubtree) {
	fun pathToHere(currKey: VDFPrimitive? = null): String {
		return (currKey?.let { prevKeys + it.stringValue } ?: prevKeys).joinToString(".")
	}
	
	// check all keys present
	if (expected.size != actual.size) {
		val expectedKeySet = expected.asSequence().map { it.key.toFormattedString() }.groupingBy { it }.eachCount()
		val actualKeySet = actual.asSequence().map { it.key.toFormattedString() }.groupingBy { it }.eachCount()
		val differences = mutableSetOf<Pair<String, Int>>()
		for (key in expectedKeySet.keys) {
			val fromExpected = expectedKeySet[key]!!
			val fromActual = actualKeySet[key] ?: 0
			
			if (fromExpected != fromActual) {
				differences += key to (fromExpected - fromActual)
			}
		}
		val extraKeys = mutableListOf<Pair<String, Int>>()
		for ((actualKey, actualCount) in actualKeySet) {
			if (actualKey !in expectedKeySet) {
				extraKeys += actualKey to actualCount
			}
		}
		val keycount = { (k: String, count: Int): Map.Entry<String, Int> -> k + (if (count > 1) " [$count]" else "") }
		assertEquals(expected.size, actual.size,
			"${pathToHere()}: Key count not equal. \n" +
			"Expected keys: ${expectedKeySet.map(keycount).sorted() }\n" +
			"Actual keys: ${actualKeySet.map(keycount).sorted()}\n" +
			"Differences: \n" +
			(if (differences.isNotEmpty()) {
				"\tExpected: ${differences.map { (k, count) -> k + (if (count > 1) " [+$count]" else "") }}"
			} else "") +
			(if (extraKeys.isNotEmpty()) {
				"\tActual had extra keys: ${extraKeys.map { (k, count) -> k + (if (count > 1) " [$count]" else "") }}\n"
			} else "")
		)
	}
	
	val expectedKeys = expected.entries.groupBy ({ it.key }, { it.value })
	val actualKeys = actual.entries.groupBy ({ it.key }, { it.value })
	
	expectedKeys.forEach { (k, expectedValues) ->
		val actualValues = actualKeys[k]!!
		
		assertEquals(expectedValues.size, actualValues.size, "${pathToHere(k)}: number of values for key")
		
		// Track what keys have been matched
		val actualValuesMutable = actualValues.toMutableList()
		
		expectedValues.forEach { expectedValue ->
			// find matching value and remove it from the list
			val m = when (expectedValue) {
				is VDFPrimitive -> {
					val m = actualValuesMutable.find { it is VDFPrimitive && comparePrimitives(expectedValue, it) }
					
					assertNotNull(m, "${pathToHere(k)} - Expected value: ${expectedValue.toFormattedString()}. Actual: " + actualValuesMutable.map { it.toFormattedString() })
				}
				// TODO if it's a Wave, it has to be sequential-ish ugh this is annoying
				is VDFSubtree -> {
					val m = actualValuesMutable.asSequence()
						.filterIsInstance<VDFSubtree>().let {
							val expectedName = expectedValue.getString("Name")
							if (expectedName != null) {
								it.filter { it.getString("Name") == expectedName }
							} else {
								it
							}.mapIndexed { i, it -> i to runCatching { compareSubtreesUnordered(prevKeys + k.stringValue, expectedValue, it) } }
						}
					
					assert(m.any { (_, it) -> it.isSuccess }) {
						"${pathToHere(k)}: no matching value found.\n" +
						"Expected: \n${expectedValue.toFormattedString().prependIndent()}\n" +
						"Actual possibilities: \n" + m.joinToString("\n") { (i, it) -> "$i. { \n${it.exceptionOrNull()?.message?.prependIndent()} \n}" } + "\n\n"
					}
					
					m.first()
				}
				else -> error("Invalid type for value: $actual")
			}
			
			actualValuesMutable.remove(m)
		}
	}
}
//
//fun assertContainsAllUnordered(expected: VDFSubtree, actual: VDFSubtree) {
//	assertEquals(expected.size, actual.size, "Subtrees same size")
//
//	val expectedGroupedByKey = expected.groupByTo(LinkedHashMap()) { it.key }
//	val actualGroupedByKey = actual.groupByTo(LinkedHashMap()) { it.key }
//
//	assertEquals(expectedGroupedByKey.size, actualGroupedByKey.size, "Same number of unique keys")
//
//	expectedGroupedByKey.forEach { (key, expectedValues) ->
//		val fromActual = actual.getAll(key.stringValue)
//		assertEquals(expectedValues.size, fromActual.size, "Same number of entries for key $key")
//
//
//	}
//}