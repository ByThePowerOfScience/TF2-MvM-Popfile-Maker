package btpos.source.vdfdsl

import btpos.source.vdfdsl.types.populators.*
import btpos.source.vdfdsl.types.populators.AbstractPopulator
import btpos.source.vdfdsl.types.spawners.AbstractSpawner
import btpos.source.vdfdsl.types.spawners.Spawners
import btpos.source.vdfdsl.types.spawners.TFBot

fun main() {
	val mission = Populators.Mission {
		beginAtWave = 4
		runForThisManyWaves = 12
		
		spawner = Spawners.TFBot {
			name = "Gary"
			
		}
	}
}

