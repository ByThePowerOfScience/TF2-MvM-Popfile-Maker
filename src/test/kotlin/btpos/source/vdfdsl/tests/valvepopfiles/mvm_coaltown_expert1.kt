package btpos.source.vdfdsl.tests.valvepopfiles

import btpos.source.vdfdsl.types.WaveSchedule
import btpos.source.vdfdsl.types.bots.BotSkill
import btpos.source.vdfdsl.types.bots.TFClass
import btpos.source.vdfdsl.types.canBotsAttackWhileInSpawnRoom
import btpos.source.vdfdsl.types.populators.Mission
import btpos.source.vdfdsl.types.populators.MissionPopulator
import btpos.source.vdfdsl.types.populators.Objective
import btpos.source.vdfdsl.types.populators.Populator
import btpos.source.vdfdsl.types.populators.Wave
import btpos.source.vdfdsl.types.populators.WavePopulator
import btpos.source.vdfdsl.types.populators.beginAtWave
import btpos.source.vdfdsl.types.populators.cooldownTime
import btpos.source.vdfdsl.types.populators.desiredCount
import btpos.source.vdfdsl.types.populators.initialCooldown
import btpos.source.vdfdsl.types.populators.objective
import btpos.source.vdfdsl.types.populators.runForThisManyWaves
import btpos.source.vdfdsl.types.populators.where
import btpos.source.vdfdsl.types.respawnWaveTime
import btpos.source.vdfdsl.types.spawners.TFBot
import btpos.source.vdfdsl.types.spawners.name
import btpos.source.vdfdsl.types.spawners.skill
import btpos.source.vdfdsl.types.spawners.template
import btpos.source.vdfdsl.types.spawners.tfclass
import btpos.source.vdfdsl.types.specifics.Where
import btpos.source.vdfdsl.types.startingCurrency
import kotlin.test.Test

class mvm_coaltown_expert1 {
	@Test
	fun `test name`() {
	    val x = WaveSchedule {
			startingCurrency = 400
		    respawnWaveTime = 7
		    canBotsAttackWhileInSpawnRoom = false
		    
		    Mission {
				objective = Objective.DESTROY_SENTRIES
			    
			    initialCooldown = 5.0
			    where = Where("spawnbot")
			    beginAtWave = 1
			    runForThisManyWaves = 9
			    
			    cooldownTime = 20.0
			    
			    TFBot {
					template = "T_TFBot_SentryBuster"
			    }
		    }
		    Mission {
				objective = Objective.SPY
			    initialCooldown = 10
			    where = Where("spawnbot_mission_spy")
			    beginAtWave = 1
			    runForThisManyWaves = 1
			    cooldownTime = 30
			    desiredCount = 4
			    
			    TFBot {
					tfclass = TFClass.Spy
				    skill = BotSkill.Expert
				    name = "Spy"
			    }
		    }
		    Mission {
				objective = Objective.SPY
			    initialCooldown = 20
		    }
	    }
	}
}