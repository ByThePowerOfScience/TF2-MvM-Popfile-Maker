package btpos.tf2.popfiledsl

import btpos.tf2.popfiledsl.types.populators.*
import btpos.tf2.popfiledsl.types.populators.Populator
import btpos.tf2.popfiledsl.types.spawners.Spawner
import btpos.tf2.popfiledsl.types.spawners.TFBot
import btpos.tf2.popfiledsl.types.spawners.Spawners
import btpos.tf2.popfiledsl.types.specifics.Where

fun main() {
	val mission = Populator.Mission {
		beginAtWave = 4
		runForThisManyWaves = 12
		
		spawner = Spawner.TFBot {
			where = Where.ANYWHERE
		}
	}
}

