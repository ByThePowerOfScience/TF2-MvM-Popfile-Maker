package btpos.source.vdfdsl

import btpos.source.vdfdsl.types.populators.*
import btpos.source.vdfdsl.types.populators.Populator
import btpos.source.vdfdsl.types.spawners.Spawner
import btpos.source.vdfdsl.types.spawners.*
import btpos.source.vdfdsl.types.spawners.TFBot

fun main() {
	val mission = Populator.Mission {
		beginAtWave = 4
		runForThisManyWaves = 12
		
		spawner = Spawner.TFBot {
			name = "Gary"
			
		}
	}
}

