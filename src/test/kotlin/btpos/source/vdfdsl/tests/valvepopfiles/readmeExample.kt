/*
package btpos.source.vdfdsl.tests.valvepopfiles

import btpos.source.vdfdsl.tf2.items.cosmetics.Cosmetics
import btpos.source.vdfdsl.tf2.items.weapons.Weapons
import btpos.source.vdfdsl.tf2.items.weapons.WeaponsByClass
import btpos.source.vdfdsl.tf2.templates.RobotStandardTemplates
import btpos.source.vdfdsl.types.WaveSchedule
import btpos.source.vdfdsl.types.bots.BotSkill
import btpos.source.vdfdsl.types.bots.TFBotAttributes
import btpos.source.vdfdsl.types.bots.TFClass
import btpos.source.vdfdsl.types.bots.WeaponRestrictions
import btpos.source.vdfdsl.types.populators.Wave
import btpos.source.vdfdsl.types.populators.WaveBuilder
import btpos.source.vdfdsl.types.populators.WavePopulator
import btpos.source.vdfdsl.types.populators.WaveSpawn
import btpos.source.vdfdsl.types.populators.WaveSpawnPopulator
import btpos.source.vdfdsl.types.populators.allAtOnce
import btpos.source.vdfdsl.types.populators.provideDelegate
import btpos.source.vdfdsl.types.populators.spawnEvery
import btpos.source.vdfdsl.types.populators.waitForAllDead
import btpos.source.vdfdsl.types.spawners.Spawners.Squad
import btpos.source.vdfdsl.types.spawners.Spawners.TFBot
import btpos.source.vdfdsl.types.spawners.Spawners.Tank
import btpos.source.vdfdsl.types.spawners.addAttributesForExisting
import btpos.source.vdfdsl.types.specifics.OutputAction
import btpos.source.vdfdsl.types.writeToFile
import btpos.source.vdfdsl.workshop.spawn
import kotlin.time.Duration.Companion.seconds

// FILE: Main.kt

// (This is the entry point to the program)
fun main() {
	val myWaveSchedule = WaveSchedule {
		// Inside this block, you can do things exactly like you would in a VDF:
		startingCurrency = 300
		canBotsAttackWhileInSpawnRoom = true
		fixedRespawnWaveTime = true
		
		// Add waves with `+`:
		+wave1()
		+Wave {
			initWaveOutput {
				target = "my_map_ent"
				action = "trigger"
				// alternatively: trigger("my_map_ent")
			}
			
			// Declare a subwave
			val swarmOfFishScouts = WaveSpawn(name="wave02a") {
				where = MAIN_SPAWN_LOCATION
				
				totalCount = 100
				maxActive = 100
				spawnCount = 20
				waitBetweenSpawns = 0
				
				totalCurrency = 100
				
				// Set the spawner for this subwave
				+TFBot(name="Fish Scout") {
					`class` = TFClass.Scout
					skill = BotSkill.Hard
					
					attributes += TFBotAttributes.AlwaysCrit
					weaponRestriction = WeaponRestrictions.MeleeOnly
					
					items += WeaponsByClass.Scout.Melee.HOLY_MACKEREL {
						fireRate.bonus.visible = 30
					}
				}
			}
		}
	}
	
	myWaveSchedule.writeToFile("./my_popfile.pop") // <-- Writes everything to a VDF, exactly as if you'd written it by hand
}

// ## Utilities!

// ### Implicit subwave naming:

// Normal:
val mySubwave = WaveSpawn {
	name = "mySubwave"
}

// If you use `by`, it implicitly uses the name of the variable it's assigned to:
val mySubwave2 by WaveSpawn {
	// name = "mySubwave2"
}

// ### Automatic subwave timing:
val wave7 = WaveBuilder {
	val huntsmenWithMedics by WaveSpawn {
		where = MAIN_SPAWN_LOCATION
		
		totalCount = 30
		allAtOnce()
		
		totalCurrency = 300
		
		+Squad {
			+TFBot(template = RobotStandardTemplates.Sniper.HUNTSMAN) {
				addAttributesForExisting(Weapons.HUNTSMAN) {
					damage.bonus.visible = 0.075f
					fasterReloadRate = 0.4f
				}
			}
			+TFBot(template = RobotStandardTemplates.Medic.QUICKUBER)
		}
	}
	
	val sendInTheGnomes by WaveSpawn {
		where = MAIN_SPAWN_LOCATION
		
		spawn(54) inGroupsOf 6 waitingBetweenSpawns 5.seconds
		
		+TFBot(template = RobotStandardTemplates.Heavyweapons.GNOME)
	}
	
	+huntsmenWithMedics
	waitForAllDead(huntsmenWithMedics)
	wait(2.seconds)
	+sendInTheGnomes // WaitForAllDead "huntsmenWithMedics"; Wait
}

// ## Items
// This is the part that took the longest: **every single item and item attribute in TF2 has a constant value**.
//
// NO. MORE. TYPOS.

val myBot = TFBot {
	items += Weapons.HITMANS_HEATMAKER
	items += Cosmetics.STOUT_SHAKO
}

// ### **EVERY WEAPON KNOWS WHAT ATTRIBUTES IT CAN USE**
// I went through the SDK and found every usage of every single attribute in the entire game.
// When you call `withAttributes`, you only have access to the attributes that will work on that weapon within that block.

val mySniper = TFBot {
	items += Weapons.HITMANS_HEATMAKER.withAttributes {
		fasterReloadRate = 0.4
	}
}















// ## Advanced

// Since this is in a programming language, you can go all-out with custom utilities.


// ### Define constants: Change once, change everywhere!
const val MAIN_SPAWN_LOCATION = "spawnbot"

// ### Sort your code by putting each wave in its own section
fun wave1(): WavePopulator {
	return Wave {
		// ...
	}
}

// Note: You can also use `=` to make a function immediately return whatever goes after the equals sign:
fun wave1() = Wave {
	// ...
}

// ### Make subwaves from default settings, no matter how complicated

inline fun tankSubWave(health: Int, speed: Number, additionalConfiguration: WaveSpawnPopulator.() -> Unit) = WaveSpawn {
	firstSpawnOutput = OutputAction {
		trigger("boss_spawn_relay")
	}
	
	additionalConfiguration()
	
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

val tanksEvery30seconds = tankSubWave(health=20_000, speed=75) {
	totalCount = 10
	spawnEvery(30.seconds)
	totalCurrency = 500
}



*/
