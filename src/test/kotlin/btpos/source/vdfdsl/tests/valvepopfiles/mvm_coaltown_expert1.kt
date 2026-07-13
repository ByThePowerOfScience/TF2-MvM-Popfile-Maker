package btpos.source.vdfdsl.tests.valvepopfiles

import btpos.source.vdfdsl.backing.VDFRootFile
import btpos.source.vdfdsl.backing.VDFSubtree
import btpos.source.vdfdsl.modeling.invoke
import btpos.source.vdfdsl.tf2.itemattributes.BuffItemAttributes
import btpos.source.vdfdsl.tf2.items.weapons.WeaponsAll
import btpos.source.vdfdsl.types.WaveSchedule
import btpos.source.vdfdsl.types.bots.Attributes
import btpos.source.vdfdsl.types.bots.BehaviorModifiers
import btpos.source.vdfdsl.types.bots.BotSkill
import btpos.source.vdfdsl.types.bots.BotSkill.Companion.Easy
import btpos.source.vdfdsl.types.bots.TFBotAttributes
import btpos.source.vdfdsl.types.bots.TFClass
import btpos.source.vdfdsl.types.bots.WeaponRestrictions
import btpos.source.vdfdsl.types.canBotsAttackWhileInSpawnRoom
import btpos.source.vdfdsl.types.populators
import btpos.source.vdfdsl.types.populators.*
import btpos.source.vdfdsl.types.populators.WaveSpawnPopulator.Support
import btpos.source.vdfdsl.types.respawnWaveTime
import btpos.source.vdfdsl.types.spawners.RandomChoice
import btpos.source.vdfdsl.types.spawners.Squad
import btpos.source.vdfdsl.types.spawners.TFBot
import btpos.source.vdfdsl.types.spawners.TFBotSpawner
import btpos.source.vdfdsl.types.spawners.Tank
import btpos.source.vdfdsl.types.spawners.TankSpawner
import btpos.source.vdfdsl.types.spawners.critBoosted
import btpos.source.vdfdsl.types.specifics.OutputAction
import btpos.source.vdfdsl.types.startingCurrency
import btpos.source.vdfdsl.utils.plus
import org.junit.jupiter.api.Test
import kotlin.time.Duration.Companion.seconds


private const val basicSpawn = "spawnbot"

private const val tag_preferFlankRight = "nav_prefer_flank_right"
private const val tag_preferFlankLeft = "nav_prefer_flank_left"

private const val tag_specialmainright = "special_main_right"

private const val tag_specialmainleft = "special_main_left"

class mvm_coaltown_expert1 {
	val GIANT_SCOUT get() = TFBot(template = "T_TFBot_Giant_Scout_Fast")
	
	
	val GIANT_HEAVY get() = TFBot(template = "T_TFBot_Giant_Heavyweapons")
	val QUICKFIX_MEDIC get() = TFBotSpawner(template = "T_TFBot_Medic_QuickUber")
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
			
			+Mission {
				objective = Objective.DestroySentries
				
				initialCooldown = 5
				where = basicSpawn
				beginAtWave = 1
				runForThisManyWaves = 9
				
				cooldownTime = 20
				
				TFBot(template = "T_TFBot_SentryBuster")
			}
			
			spyMission(1, 10)
			spyMission(2, 20)
			spyMission(4, 80)
			
			
			+Mission(5) {
				objective = Objective.Sniper
				initialCooldown = 30
				cooldownTime = 20
				desiredCount = 6
				
				+TFBot {
					template = "T_TFBot_Sniper_Sydney_Sleeper"
					items += WeaponsAll.RAZORBACK
				}
			}.also {
				populators += it.copy()
					.apply {
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
			// TODO serialize with base #base robot_giant.pop, #base robot_standard.pop
		}
		
		val file = VDFRootFile(pragmas = mutableListOf("base" to "base.pop"))
		x._serializeInto(file)
		file.writeToVDF(System.out)
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
				
				+TFBot(template = "T_TFBot_Scout_Bonk")
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
					+GIANT_HEAVY
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
					+GIANT_HEAVY
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
					items += WeaponsAll.DIRECT_HIT
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
			
			+TFBot(template = "T_TFBot_Giant_Heavyweapons_Deflector")
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
				template = "T_TFBot_Sniper_Huntsman"
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
			
			+TFBot(template = "T_TFBot_Demoman_Knight").critBoosted
		}
		
		fun squadWithSoldier(sideTag: String) = Squad {
			+TFBot(template = "T_TFBot_Giant_Soldier_Spawner") {
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
			
			spawner = squadWithSoldier(tag_specialmainright)
		}
		val wave05c by wave05b.copy()
			.apply {
				spawner = squadWithSoldier(tag_specialmainleft)
			}
		
		val wave05d by WaveSpawn {
			giantSpawnLocation()
			
			
			trickleIn(45)
			waitBeforeStarting = 60
			totalCurrency = 50
			
			+GIANT_SCOUT
		}
		
		val wave05e by WaveSpawn {
			giantSpawnLocation()
			
			trickleIn(delayBetweenSpawns = 2)
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
		
		defaultSpawnLocation = basicSpawn
		
		val hardScouts = WaveSpawn("wave06a") {
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
				+GIANT_HEAVY
				+TFBot(template="T_TFBot_Giant_Medic")
			}
		}
		
		val fastScouts = WaveSpawn("wave06c") {
			totalCount = 5
			maxActive = 5
			spawnCount = 2
			waitBetweenSpawns = 25
			
			totalCurrency = 200
			
			+GIANT_SCOUT
		}
		
		val hardSoldiers = WaveSpawn("wave06d") {
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
	
	defaultSpawnLocation = basicSpawn
	
	val tanksEvery30Seconds = tankSubWave(20_000, 75) {
		name = "wave07a"
		
		totalCount = 5
		spawnEvery(30.seconds)
		totalCurrency = 500
	}
	val hardScoutsWithMedics = WaveSpawn(name="wave07c") {
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
		val huntsmanSniper = TFBot(template = "T_TFBot_Sniper_Huntsman") {
			items += WeaponsAll.HUNTSMAN {
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
		totalCount = 36
		maxActive = 12
		spawnCount = 6
		waitBetweenSpawns = 15
		
		totalCurrency = 200
	}
	
	val directHitBannerSoldiers = WaveSpawn("wave07e") {
		totalCount = 12
		maxActive = 12
		spawnCount = 6
		waitBetweenSpawns = 15
		totalCurrency = 50
		
		+TFBot {
			`class` = TFClass.Soldier
			skill = BotSkill.Expert
			weaponRestriction = WeaponRestrictions.PrimaryOnly
			items += WeaponsAll.DIRECT_HIT
			items += WeaponsAll.BUFF_BANNER
			attributes += Attributes.SpawnWithFullCharge
			characterAttributes {
				BuffItemAttributes.increaseBuffDuration = 9.0f
			}
		}
	}
	
	fun giantHeavy(letter: String, tag: String) = WaveSpawn(name="wave07$letter") {
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