package btpos.tf2.popfiledsl

import btpos.tf2.popfiledsl.types.populators.*
import btpos.tf2.popfiledsl.types.populators.Populator
import btpos.tf2.popfiledsl.types.spawners.Spawner
import btpos.tf2.popfiledsl.types.spawners.*
import btpos.tf2.popfiledsl.types.spawners.TFBot

fun main() {
	val mission = Populator.Mission {
		beginAtWave = 4
		runForThisManyWaves = 12
		
		spawner = Spawner.TFBot {
			name = "Gary"
			
		}
	}
}

