package btpos.source.vdfdsl.tests.valvepopfiles

import btpos.source.vdfdsl.tf2.items.weapons.WeaponsAll
import btpos.source.vdfdsl.types.populators.*
import btpos.source.vdfdsl.types.*
import btpos.source.vdfdsl.types.bots.BotSkill
import btpos.source.vdfdsl.types.bots.BotSkill.Companion.Easy
import btpos.source.vdfdsl.types.bots.TFBotAttribute
import btpos.source.vdfdsl.types.bots.TFClass
import btpos.source.vdfdsl.types.spawners.Spawner
import btpos.source.vdfdsl.types.spawners.*
import btpos.source.vdfdsl.types.specifics.*
import kotlin.test.Test

private const val basicSpawn = "spawnbot"

class mvm_coaltown_expert1 {
	fun spyMission(startCooldown: Int) = Populator.Mission {
		objective = Objective.Spy
		initialCooldown = startCooldown
		where = "spawnbot_mission_spy"
		cooldownTime = 30
		desiredCount = 4
		
		TFBot {
			`class` = TFClass.Spy
			skill = BotSkill.Expert
			name = "Spy"
		}
	}
	
	@Test
	fun `test name`() {
		val x = WaveSchedule {
			startingCurrency = 400
			respawnWaveTime = 7
			canBotsAttackWhileInSpawnRoom = false
			
			Mission {
				objective = Objective.DestroySentries
				
				initialCooldown = 5.0
				where = basicSpawn
				beginAtWave = 1
				runForThisManyWaves = 9
				
				cooldownTime = 20.0
				
				TFBot {
					template = "T_TFBot_SentryBuster"
				}
			}
			
			
			
			
			Mission(5) {
				objective = Objective.Sniper
				initialCooldown = 30
				cooldownTime = 20
				desiredCount = 6
				
				TFBot {
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
	fun makeWave() = Populator.Wave {
		startWaveOutput {
			trigger("wave_start_relay")
		}
		doneOutput {
			trigger("wave_finished_relay")
		}
		waitWhenDone = 65
		checkpoint = true
	}
	
	fun WaveSpawnPopulator.spawnMiddle() {
		this.where = "spawnbot"
	}
	
	/**
	 * Currency 800
	 */
	context(_: WaveSchedule)
	fun wave1() = makeWave().apply {
		// Sniper mission - 4 active (late appearance)
		// Spy mission - 4 active
		
//		addMission(spyMission(30))
		
		val wave01a by WaveSpawn {
			spawnMiddle()
			
			totalCount = 30
			maxActive = 10
			spawnCount = 10
			waitBeforeStarting = 0
			waitBetweenSpawns = 0
			
			totalCurrency = 200
			
			TFBot(template="T_TFBot_Scout_Bonk")
		}
		
		val wave01b by WaveSpawn {
			spawnMiddle()
			
			totalCount = 16
			maxActive = 12
			spawnCount = 2
			waitBeforeStarting = 0
			waitBetweenSpawns = 7
			totalCurrency = 100
			
			Squad {
				spawners += listOf(
					TFBotSpawner(template="T_TFBot_Heavyweapons_Fist"),
					TFBotSpawner(template="T_TFBot_Medic_QuickUber"),
				)
			}
		}
		
		val wave01c by WaveSpawn {
			spawnMiddle()
			waitForAllDead = wave01a
			
			totalCount = 30
			maxActive = 10
			spawnCount = 5
			waitBeforeStarting = 0
			waitBetweenSpawns = 0
			totalCurrency = 200
			
			TFBot {
				`class` = TFClass.Scout
				skill = BotSkill.Easy
			}
		}
		
		val wave01d by WaveSpawn {
			spawnMiddle()
			
			totalCount = 15
			maxActive = 12
			spawnCount = 3
			waitForAllDead = wave01b
			waitBeforeStarting = 0
			waitBetweenSpawns = 5
			totalCurrency = 150
			
			Squad {
				spawners += listOf(
					Spawner.TFBot(template="T_TFBot_Heavyweapons_Fist"),
					Spawner.TFBot(template="T_TFBot_Medic_QuickUber"),
					Spawner.TFBot {
						`class` = TFClass.Pyro
						skill = Easy
						attributes = listOf(TFBotAttribute.AlwaysFireWeapon)
					}
				)
			}
		}
		
		val wave01e by WaveSpawn {
			spawnMiddle()
			
			waitForAllDead = wave01b
			totalCount = 12
			maxActive = 12
			spawnCount = 12
			waitBeforeStarting = 0
			waitBetweenSpawns = 0
			totalCurrency = 150
			
			
			TFBot {
				`class` = TFClass.Soldier
				skill = BotSkill.HARD
			}
		}
	}
	
	fun WaveSchedule.wave2() = makeWave().apply {
	
	}
}