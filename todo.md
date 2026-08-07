change attribute interfaces to be specifically THEIR attributes, and then add an "inherited" variant that's used for the item scopes, that way people will only see the attributes for a specific type when they do for example BuffItemAttributes.XXX

Add the ability to take vscript file references, allowing people to use a vscript editor to write and then import it as a global snippet


Assess VMTs and map files, auto-import and auto-generate bindings using a gradle plugin


MAKE AN ACTUALLY USEFUL EXAMPLE FILE

Add spellbooks to cosmetics

// TODO make a proper DSL for this
// TODO rename to IOAction


NoCrouchButtonRelease 1 in TFBot


Rafmod chat message coloring parsing, components etc



**JUST ONE LEVEL OF NESTING. NO DEEPER. (except for different attributes for the same attr class)
"damage", "reloading", "firerate", "deploying", "holstering", all of those at the top level. 
a bunch of top-level categories instead of nesting them works far better with how they'll be searched for**

# Creating code from existing popfiles

We want to turn something like this:

```
WaveSchedule
{

	StartingCurrency		20000                               // How much currency each player starts with. Normally 400 is a good starting point, but increased to 20k for the purpose of this test script.

	RespawnWaveTime 10                                        	// This is the maximum respawn time, in seconds for players when they die. Starting at 2 seconds, it grows 2 seconds per wave.
																// In this case, wave 1 will have a respawn time of 2 seconds. Wave 2 - 4 seconds. Wave 3 - 6 seocnds, and so on until it hits the cap of 10 seconds for wave 5 and beyond.

	CanBotsAttackWhileInSpawnRoom no                          	// Sets the robots to not attack players while they are inside of their respawn room volume.

/////////////////
//MISSIONS
/////////////////

	Mission 													// This is a sentry buster mission. It creates sentry busters for any player sentries deemed too dangerous.
	{
		Objective DestroySentries

		InitialCooldown 5										// Amount of time once a wave starts before the mission becomes active.
		Where spawnbot_mission_sentrybuster						// Entity at which to spawn.
		BeginAtWave 1											// The mission becomes active on this wave.
		RunForThisManyWaves 11									// It remains active for this many waves. Generally, this is the same as the total number of waves.
		CooldownTime 35            								// This is the time, in seconds, between when Sentry Busters are allowed to spawn, should their spawning conditions be met.

        TFBot
        {
            Template T_TFBot_SentryBuster					// This references a template to use for its TFBot.
        }
	}
	Mission 													// This is a sniper mission. This spawns sniper(s) at periodic intervals, it will not spawn more snipers unless its conditions are met, and all previous snipers from this mission are dead.
	{
		Objective Sniper

		InitialCooldown 10										// Amount of time once a wave starts before the mission becomes active.
		Where spawnbot_mission_sniper							// Entity at which to spawn.
		BeginAtWave 4											// The mission becomes active on this wave.
		RunForThisManyWaves 1									// It remains active for this many waves.
		CooldownTime 35											// This is the time, in seconds, between when Sniper Missions are allowed to spawn, should their spawning conditions be met.
		DesiredCount 2											// Number of snipers to spawn each time this mission's criteria are met.

		TFBot
		{
			Class Sniper
			Skill Expert
			Name Sniper
		}
	}
	Mission 													// This is a spy mission. This spawns spy(s) at periodic intervals, it will not spawn more spies unless its conditions are met, and all previous spies from this mission are dead.
	{
		Objective Spy

		InitialCooldown 20										// Amount of time once a wave starts before the mission becomes active.
		Where spawnbot_mission_spy								// Entity at which to spawn.
		BeginAtWave 3											// The mission becomes active on this wave.
		RunForThisManyWaves 1									// It remains active for this many waves.
		CooldownTime 15											// This is the time, in seconds, between when Sniper Missions are allowed to spawn, should their spawning conditions be met.
		DesiredCount 4											// Number of spies to spawn each time this mission's criteria are met.

		TFBot
		{
			Class Spy
			Skill Expert
			Name Spy
		}
	}

/////////////////
//WAVES
/////////////////

//WAVE 1  /////////////////////////////////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// This wave consists of 15 scouts, with 400 currency divided between them.
// At the start of the wave scouts are spawned in groups of 5, 5 seconds apart, until there are 10 bots are in the world.
// They spawn at the spawnpoint named spawnbot, and if multiple spawnbot spawn points exist, they choose a random spawnbot each time a group of 2 spawn.
// As bots are eliminated, new bots spawn in groups of 5 as long as there are enough slots in the max active count.
// The wave is over when all 15 bot scouts have been eliminated.
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	Wave
	{
		StartWaveOutput											// Output which occurs at moment the wave begins.
		{
			Target wave_start_relay								// Name of the entity in the map to target.
			Action Trigger										// Input to give the targeted entity.
		}
		DoneOutput												// Output which occurrs at moment the wave is completed.
		{
			Target wave_finished_relay							// Name of the entity in the map to target.
			Action trigger										// Input to give the targeted entity.
		}

		Checkpoint Yes											// Sets a checkpoint at the end of this wave.

		WaveSpawn
		{
			Where spawnbot										// Entity at which to spawn.
			TotalCount 15										// The total number of individual bots that will spawn.
			MaxActive 10										// The maximum number of bots, from this WaveSpawn, that can be alive in the world at any moment.
			SpawnCount 5										// Defines the number of bots to spawn at a time as a group.

			WaitBeforeStarting 0								// Amount of time to wait before spawning the first bot.
			WaitBetweenSpawns 5									// Amount of time to wait between spawning each group (defined by the spawncount) of bots.

			TotalCurrency 400									// Amount of money dropped by all of the bots in the WaveSpawn. Money is divided equally between each bot.

            TFBot
            {
                Class Scout									// Type of bot to spawn.
                Skill Normal 								// Skill level of bot. options are Easy, Normal, Hard, Expert in ascending difficulty.
            }
		}
	}
}
```

Into this:

```kotlin
WaveSchedule {
	startingCurrency = 20000
    respawnWaveTime = 10.seconds
    canBotsAttackWhileInSpawnRoom = false
    
    +Mission(1, runForThisManyWaves=11) {
		objective = Objective.DestroySentries
        initialCooldown = 5
        where = "spawnbot_mission_sentrybuster"
        cooldownTime = 35
        
        +TFBot(template=RobotStandardTemplates.SENTRY_BUSTER)
    }
    +Mission(4) {
		objective = Objective.Sniper
	    initialCooldown = 10
		cooldownTime = 35
        where = "spawnbot_mission_sniper"
        desiredCount = 2
        
        +TFBot("Sniper") {
			`class` = TFClass.Sniper
            skill = BotSkill.Expert
        }
    }
    +Mission(3) {
		objective = Objective.Spy
        initialCooldown = 20
        where = "spawnbot_mission_spy"
        cooldownTime = 15
        desiredCount = 4
        
        +TFBot("Spy") {
			`class` = TFClass.Spy
            skill = BotSkill.Expert
        }
    }
    
}
```

immediately I can see how this might work:

```kotlin

inline fun VDFSubtree.removeMatching(key: String, action: (VDFKeyValue) -> List<KtGenerator>) {
	for (el in this.getAll(key)) {
		
	}
}

val decoders = mutableListOf<VDFSubtree.() -> List<KtGenerator>>(
	{ getAll("TFBot").map { "+" + TFBot.decoder(it) } },
	{ getAll("Objective").map { "objective = it" } }
)

val missionDecoder = { subtree: VDFSubtree ->
	decoders.map { it(subtree) }
}

```



IF NO MAPPING IS FOUND, PUT THE WHOLE UNMAPPED THING IN A COMMENT INSTEAD OF FAILING!!!