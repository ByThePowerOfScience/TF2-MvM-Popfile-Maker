package btpos.source.vdfdsl.tests.valvepopfiles

import btpos.source.vdfdsl.tf2.items.weapons.WeaponsAll
import btpos.source.vdfdsl.types.populators.*
import btpos.source.vdfdsl.types.*
import btpos.source.vdfdsl.types.bots.BotSkill
import btpos.source.vdfdsl.types.bots.BotSkill.Companion.Easy
import btpos.source.vdfdsl.types.bots.TFBotAttribute
import btpos.source.vdfdsl.types.bots.TFClass
import btpos.source.vdfdsl.types.spawners.*
import btpos.source.vdfdsl.types.specifics.*

private const val basicSpawn = "spawnbot"

class mvm_coaltown_expert1 {
	val STEEL_GAUNTLET = TFBot(template="T_TFBot_Giant_Heavyweapons")
	val QUICKFIX_MEDIC = TFBotSpawner(template = "T_TFBot_Medic_QuickUber")
	val EASY_SCOUT = TFBot {
		`class` = TFClass.Scout
		skill = Easy
	}
	
	fun spyMission(startWave: Int, startCooldown: Int) = Populator.Mission {
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
	fun coaltownExpert1() {
		val x = WaveSchedule {
			startingCurrency = 400
			respawnWaveTime = 7
			canBotsAttackWhileInSpawnRoom = false
			
			+Mission {
				objective = Objective.DestroySentries
				
				initialCooldown = 5.0
				where = basicSpawn
				beginAtWave = 1
				runForThisManyWaves = 9
				
				cooldownTime = 20.0
				
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
				populators += it.copy().apply {
					beginAtWave = 7
					desiredCount = 4
				}
			}
			
			// TODO serialize with base #base robot_giant.pop, #base robot_standard.pop
		}
	}
	
	/**
	 * Presets for all waves
	 */
	fun myDefaultWaveSettings() = Wave {
		startWaveOutput {
			trigger("wave_start_relay")
		}
		doneOutput {
			trigger("wave_finished_relay")
		}
		waitWhenDone = 65
		checkpoint = true
	}
	
	fun WaveSpawnPopulator.atMiddleSpawn() {
		this.where = "spawnbot"
	}
	
	fun WaveSpawnPopulator.atGiantSpawn() {
		this.where = "spawnbot_giant"
	}
	
	/**
	 * Currency 800
	 */
	fun wave1(): WavePopulator {
		return myDefaultWaveSettings().apply {
			// Sniper mission - 4 active (late appearance)
			// Spy mission - 4 active
			
			val wave01a by WaveSpawn {
				atMiddleSpawn()
				
				totalCount = 30
				maxActive = 10
				spawnCount = 10
				waitBeforeStarting = 0
				waitBetweenSpawns = 0
				
				totalCurrency = 200
				
				+TFBot(template="T_TFBot_Scout_Bonk")
			}
			
			val wave01b by WaveSpawn {
				atMiddleSpawn()
				
				totalCount = 16
				maxActive = 12
				spawnCount = 2
				waitBeforeStarting = 0
				waitBetweenSpawns = 7
				totalCurrency = 100
				
				+Squad {
					+STEEL_GAUNTLET
					+QUICKFIX_MEDIC
				}
			}
			
			val wave01c by WaveSpawn {
				atMiddleSpawn()
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
				atMiddleSpawn()
				
				totalCount = 15
				maxActive = 12
				spawnCount = 3
				waitForAllDead = wave01b
				waitBeforeStarting = 0
				waitBetweenSpawns = 5
				totalCurrency = 150
				
				+Squad {
					+STEEL_GAUNTLET
					+QUICKFIX_MEDIC
					+TFBot {
						`class` = TFClass.Pyro
						skill = Easy
						attributes = listOf(TFBotAttribute.AlwaysFireWeapon)
					}
				}
			}
			
			val wave01e by WaveSpawn {
				atMiddleSpawn()
				
				waitForAllDead = wave01b
				totalCount = 12
				maxActive = 12
				spawnCount = 12
				waitBeforeStarting = 0
				waitBetweenSpawns = 0
				totalCurrency = 150
				
				
				+TFBot {
					`class` = TFClass.Soldier
					skill = BotSkill.HARD
				}
			}
			
			+wave01a
			+wave01b
			+wave01c
			+wave01d
			+wave01e
		}
	}
	
	fun wave2() = myDefaultWaveSettings().apply {
		val wave02a by WaveSpawn {
			atMiddleSpawn()
			
			totalCount = 6
			maxActive = 6
			spawnCount = 1
			waitBeforeStarting = 0
			waitBetweenSpawns = 7
			totalCurrency = 100
			
			+TFBot(template="T_TFBot_Giant_Scout_Fast")
		}
		
		val wave02b by WaveSpawn {
			atGiantSpawn()
			
			totalCount = 18
			maxActive = 9
			spawnCount = 9
			waitBeforeStarting = 0
			waitBetweenSpawns = 0
			totalCurrency = 200
			
			+Squad {
				+STEEL_GAUNTLET
				+(QUICKFIX_MEDIC * 8)
			}
		}
		
		val wave02c by WaveSpawn {
			atMiddleSpawn()
			
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
			atMiddleSpawn()
			
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
			atMiddleSpawn()
			
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
				tags += "nav_prefer_flank_right"
			}
		}
		
		+wave02a
		+wave02b
		+wave02c
		+wave02d
		+wave02e
	}
	
	inline fun tankSubWave(health: Int, speed: Number, configure: WaveSpawnPopulator.() -> Unit) = WaveSpawn {
		firstSpawnOutput = OutputAction {
			trigger("boss_spawn_relay")
		}
		
		configure()
		
		+Tank {
			this.health = health
			this.speed = speed
			this.name = "tankboss"
			this.startingPathTrackNode = "boss_path_a1"
			
			onKilledOutput = OutputAction {
				trigger("boss_dead_relay")
			}
			onBombDroppedOutput = OutputAction {
				trigger("boss_deploy_relay")
			}
		}
	}
	
	fun wave3() = myDefaultWaveSettings().apply {
		val wave03a by tankSubWave(35_000, 75) {
			totalCount = 1
			waitBeforeStarting = 0
			totalCurrency = 300
		}
		
	}
	
	
	
	
	fun wave4() = Wave {
		val wave04a by tankSubWave(health=20_000, speed=75) {
			totalCount = 4
			waitBeforeStarting = 0
			waitBetweenSpawns = 30
			totalCurrency = 200
		}
	}
}