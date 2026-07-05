package btpos.source.vdfdsl.tests.valvepopfiles

import btpos.source.vdfdsl.tf2.items.TFItem
import btpos.source.vdfdsl.tf2.items.weapons.WeaponsAll
import btpos.source.vdfdsl.types.WaveSchedule
import btpos.source.vdfdsl.types.bots.BotSkill
import btpos.source.vdfdsl.types.bots.TFClass
import btpos.source.vdfdsl.types.canBotsAttackWhileInSpawnRoom
import btpos.source.vdfdsl.types.populators
import btpos.source.vdfdsl.types.populators.Mission
import btpos.source.vdfdsl.types.populators.Objective
import btpos.source.vdfdsl.types.populators.Populator
import btpos.source.vdfdsl.types.populators.Wave
import btpos.source.vdfdsl.types.populators.WavePopulator
import btpos.source.vdfdsl.types.populators.beginAtWave
import btpos.source.vdfdsl.types.populators.checkpoint
import btpos.source.vdfdsl.types.populators.cooldownTime
import btpos.source.vdfdsl.types.populators.desiredCount
import btpos.source.vdfdsl.types.populators.doneOutput
import btpos.source.vdfdsl.types.populators.initialCooldown
import btpos.source.vdfdsl.types.populators.objective
import btpos.source.vdfdsl.types.populators.runForThisManyWaves
import btpos.source.vdfdsl.types.populators.spawner
import btpos.source.vdfdsl.types.populators.startWaveOutput
import btpos.source.vdfdsl.types.populators.where
import btpos.source.vdfdsl.types.respawnWaveTime
import btpos.source.vdfdsl.types.spawners.Spawner
import btpos.source.vdfdsl.types.spawners.TFBot
import btpos.source.vdfdsl.types.spawners.items
import btpos.source.vdfdsl.types.spawners.maxVisionRange
import btpos.source.vdfdsl.types.spawners.name
import btpos.source.vdfdsl.types.spawners.skill
import btpos.source.vdfdsl.types.spawners.template
import btpos.source.vdfdsl.types.spawners.tfclass
import btpos.source.vdfdsl.types.specifics.OutputAction
import btpos.source.vdfdsl.types.specifics.action
import btpos.source.vdfdsl.types.specifics.target
import btpos.source.vdfdsl.types.specifics.trigger
import btpos.source.vdfdsl.types.startingCurrency
import kotlin.test.Test

private const val basicSpawn = "spawnbot"

class mvm_coaltown_expert1 {
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
			fun spyMission(beginWave: Int, startCooldown: Int) = Mission {
				objective = Objective.Spy
				initialCooldown = startCooldown
				where = "spawnbot_mission_spy"
				beginAtWave = beginWave
				runForThisManyWaves = 1
				cooldownTime = 30
				desiredCount = 4
				
				TFBot {
					tfclass = TFClass.Spy
					skill = BotSkill.Expert
					name = "Spy"
				}
			}
			spyMission(1, 10)
			spyMission(2, 20)
			spyMission(4, 80)
			
			Mission(1) {
				objective = Objective.Sniper
				
				initialCooldown = 75
				where = "spawnbot_mission_sniper"
				cooldownTime = 20
				desiredCount = 4
				
				TFBot("Sniper") {
					tfclass = TFClass.Sniper
					skill = BotSkill.HARD
					maxVisionRange = 3000
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
			
			
		}
	}
	
	fun makeWave() = Populator.Wave {
		startWaveOutput {
			trigger("wave_start_relay")
		}
		doneOutput {
			trigger("wave_finished_relay")
		}
		checkpoint = true
	}
	
	/**
	 * Currency 800
	 */
	fun wave1() = Populator.Wave {
	
	}
}