@file:Suppress("unused")

package btpos.source.vdfdsl.tf2.items.weapons


object WeaponsByClass {
	object Scout {
		object Primary {
			
			val FORCEANATURE get() = Weapons.FORCEANATURE
			/**
			 * A version of stock that can have qualities like "unique", "strange", "killstreak", etc.
			 *
			 * @see Weapons.TrueStock.SCATTERGUN
			 */
			val STOCK_SCATTERGUN get() = Weapons.STOCK_SCATTERGUN
			val STOCK_SCATTERGUN_FESTIVE get() = Weapons.STOCK_SCATTERGUN_FESTIVE
			val Botkiller get() = Weapons.ScattergunBotkillers
			val FORCEANATURE_FESTIVE get() = Weapons.FORCEANATURE_FESTIVE
			val BACK_SCATTER get() = Weapons.BACK_SCATTER
			
			val SHORTSTOP get() = Weapons.SHORTSTOP
			
			val SODA_POPPER get() = Weapons.SODA_POPPER
			val BABY_FACES_BLASTER get() = Weapons.BABY_FACES_BLASTER
		}
		
		object Secondary {
			val BONK_ATOMIC_PUNCH get() = Weapons.BONK_ATOMIC_PUNCH
			val CRITACOLA get() = Weapons.CRITACOLA
			val BONK_FESTIVE get() = Weapons.BONK_FESTIVE
			val WINGER get() = Weapons.WINGER
			val PRETTY_BOYS_POCKET_PISTOL get() = Weapons.PRETTY_BOYS_POCKET_PISTOL
			/**
			 * A version of stock that can have qualities like "unique", "strange", "killstreak", etc.
			 *
			 * @see Weapons.TrueStock.PISTOL
			 */
			val STOCK_PISTOL get() = Weapons.STOCK_PISTOL
			
			val LUGERMORPH get() = Weapons.LUGERMORPH
			val CAPPER get() = Weapons.CAPPER
			
			val MAD_MILK get() = Weapons.MAD_MILK
			val MUTATED_MILK get() = Weapons.MUTATED_MILK
			
			val FLYING_GUILLOTINE get() = Weapons.FLYING_GUILLOTINE
			val FLYING_GUILLOTINE_PROMO get() = Weapons.FLYING_GUILLOTINE_PROMO
			
		}
		
		object Melee {
			/**
			 * A version of stock that can have qualities like "unique", "strange", "killstreak", etc.
			 *
			 * @see Weapons.TrueStock.BAT
			 */
			val STOCK_BAT get() = WeaponsMelee.STOCK_BAT
			val CANDY_CANE get() = WeaponsMelee.CANDY_CANE
			val BOSTON_BASHER get() = WeaponsMelee.BOSTON_BASHER
			val SUNONASTICK get() = WeaponsMelee.SUNONASTICK
			val FAN_OWAR get() = WeaponsMelee.FAN_OWAR
			val ATOMIZER get() = WeaponsMelee.ATOMIZER
			val THREERUNE_BLADE get() = WeaponsMelee.THREERUNE_BLADE
			val STOCK_BAT_FESTIVE get() = WeaponsMelee.STOCK_BAT_FESTIVE
			val BATSABER get() = WeaponsMelee.BATSABER
			val SANDMAN get() = WeaponsMelee.SANDMAN
			val HOLY_MACKEREL get() = WeaponsMelee.HOLY_MACKEREL
			val UNARMED_COMBAT get() = WeaponsMelee.UNARMED_COMBAT
			val HOLY_MACKEREL_FESTIVE get() = WeaponsMelee.HOLY_MACKEREL_FESTIVE
			val WRAP_ASSASSIN get() = WeaponsMelee.WRAP_ASSASSIN
			
			val AllClass get() = WeaponsMelee.AllClass
		}
	}
	
	object SoldierWeapons {
		object Primary {
			
			/**
			 * A version of stock that can have qualities like "unique", "strange", "killstreak", etc.
			 *
			 * @see Weapons.TrueStock.ROCKETLAUNCHER
			 */
			val STOCK_ROCKET_LAUNCHER get() = Weapons.STOCK_ROCKET_LAUNCHER
			val BLACK_BOX get() = Weapons.BLACK_BOX
			val ROCKET_JUMPER get() = Weapons.ROCKET_JUMPER
			val LIBERTY_LAUNCHER get() = Weapons.LIBERTY_LAUNCHER
			val ORIGINAL get() = Weapons.ORIGINAL
			val STOCK_ROCKET_LAUNCHER_FESTIVE get() = Weapons.STOCK_ROCKET_LAUNCHER_FESTIVE
			val BEGGARS_BAZOOKA get() = Weapons.BEGGARS_BAZOOKA
			
			val BLACK_BOX_FESTIVE get() = Weapons.BLACK_BOX_FESTIVE
			val DIRECT_HIT get() = Weapons.DIRECT_HIT
			val COW_MANGLER_5000 get() = Weapons.COW_MANGLER_5000
			val AIR_STRIKE get() = Weapons.AIR_STRIKE
			
			
			val Botkillers get() = Weapons.RocketLauncherBotkillers
		}
		
		object Secondary {
			/**
			 * A version of stock that can have qualities like "unique", "strange", "killstreak", etc.
			 *
			 * @see Weapons.TrueStock.SHOTGUN_SOLDIER
			 */
			val STOCK_SHOTGUN get() = Weapons.STOCK_SHOTGUN
			val RESERVE_SHOOTER get() = Weapons.RESERVE_SHOOTER
			val STOCK_SHOTGUN_FESTIVE get() = Weapons.STOCK_SHOTGUN_FESTIVE
			val PANIC_ATTACK_SHOTGUN get() = Weapons.PANIC_ATTACK_SHOTGUN
			
			
			val BUFF_BANNER get() = Weapons.BUFF_BANNER
			val BUFF_BANNER_FESTIVE get() = Weapons.BUFF_BANNER_FESTIVE
			val BATTALIONS_BACKUP get() = Weapons.BATTALIONS_BACKUP
			val CONCHEROR get() = Weapons.CONCHEROR
			val BASE_JUMPER get() = Weapons.BASE_JUMPER
			
			val RIGHTEOUS_BISON get() = Weapons.RIGHTEOUS_BISON
			
			val THE_GUNBOATS get() = Weapons.GUNBOATS
			
			val THE_MANTREADS get() = Weapons.MANTREADS
		}
		
		/**
		 * @see WeaponsMelee.AllClass
		 */
		object Melee {
			val EQUALIZER get() = WeaponsMelee.EQUALIZER
			val PAIN_TRAIN get() = WeaponsMelee.PAIN_TRAIN
			/**
			 * A version of stock that can have qualities like "unique", "strange", "killstreak", etc.
			 *
			 * @see Weapons.TrueStock.SHOVEL
			 */
			val STOCK_SHOVEL get() = WeaponsMelee.STOCK_SHOVEL
			val MARKET_GARDENER get() = WeaponsMelee.MARKET_GARDENER
			val DISCIPLINARY_ACTION get() = WeaponsMelee.DISCIPLINARY_ACTION
			val ESCAPE_PLAN get() = WeaponsMelee.ESCAPE_PLAN
			
			val HALF_ZATOICHI get() = WeaponsMelee.HALFZATOICHI
			val AllClass get() = WeaponsMelee.AllClass
		}
	}
	
	object Pyro {
		object Primary {
			
			/**
			 * A version of stock that can have qualities like "unique", "strange", "killstreak", etc.
			 *
			 * @see Weapons.TrueStock.FLAMETHROWER
			 */
			val STOCK_FLAMETHROWER get() = Weapons.STOCK_FLAMETHROWER
			val STOCK_FLAMETHROWER_FESTIVE get() = Weapons.STOCK_FLAMETHROWER_FESTIVE
			val BACKBURNER get() = Weapons.BACKBURNER
			val DEGREASER get() = Weapons.DEGREASER
			val PHLOGISTINATOR get() = Weapons.PHLOGISTINATOR
			val RAINBLOWER get() = Weapons.RAINBLOWER
			
			val Botkillers get() = Weapons.FlamethrowerBotkillers
			val BACKBURNER_FESTIVE get() = Weapons.BACKBURNER_FESTIVE
			val NOSTROMO_NAPALMER get() = Weapons.NOSTROMO_NAPALMER
			
			val DRAGONS_FURY get() = Weapons.DRAGONS_FURY
		}
		
		object Secondary {
			val THERMAL_THRUSTER get() = Weapons.THERMAL_THRUSTER
			val GAS_PASSER get() = Weapons.GAS_PASSER
			
			val FLARE_GUN get() = Weapons.FLARE_GUN
			val DETONATOR get() = Weapons.DETONATOR
			val SCORCH_SHOT get() = Weapons.SCORCH_SHOT
			val FLARE_GUN_FESTIVE get() = Weapons.FLARE_GUN_FESTIVE
			val MANMELTER get() = Weapons.MANMELTER
			
			/**
			 * A version of stock that can have qualities like "unique", "strange", "killstreak", etc.
			 *
			 * @see Weapons.TrueStock.SHOTGUN_PYRO
			 */
			val STOCK_SHOTGUN get() = Weapons.STOCK_SHOTGUN
			val RESERVE_SHOOTER get() = Weapons.RESERVE_SHOOTER
			val STOCK_SHOTGUN_FESTIVE get() = Weapons.STOCK_SHOTGUN_FESTIVE
			val PANIC_ATTACK_SHOTGUN get() = Weapons.PANIC_ATTACK_SHOTGUN
			
		}
		
		object Melee {
			/**
			 * A version of stock that can have qualities like "unique", "strange", "killstreak", etc.
			 *
			 * @see Weapons.TrueStock.FIREAXE
			 */
			val STOCK_FIREAXE get() = WeaponsMelee.STOCK_FIREAXE
			
			val AXTINGUISHER get() = WeaponsMelee.AXTINGUISHER
			val HOMEWRECKER get() = WeaponsMelee.HOMEWRECKER
			val POWERJACK get() = WeaponsMelee.POWERJACK
			val BACK_SCRATCHER get() = WeaponsMelee.BACK_SCRATCHER
			val SHARPENED_VOLCANO_FRAGMENT get() = WeaponsMelee.SHARPENED_VOLCANO_FRAGMENT
			val POSTAL_PUMMELER get() = WeaponsMelee.POSTAL_PUMMELER
			val MAUL get() = WeaponsMelee.MAUL
			val THIRD_DEGREE get() = WeaponsMelee.THIRD_DEGREE
			val LOLLICHOP get() = WeaponsMelee.LOLLICHOP
			val AXTINGUISHER_FESTIVE get() = WeaponsMelee.AXTINGUISHER_FESTIVE
			
			val NEON_ANNIHILATOR get() = WeaponsMelee.NEON_ANNIHILATOR
			val NEON_ANNIHILATOR_PROMO get() = WeaponsMelee.NEON_ANNIHILATOR_PROMO
			
			val HOT_HAND get() = WeaponsMelee.HOT_HAND
			val AllClass get() = WeaponsMelee.AllClass
		}
	}
	
	
	object Demoman {
		object Primary {
			
			val ALI_BABAS_WEE_BOOTIES get() = Weapons.ALI_BABAS_WEE_BOOTIES
			val THE_BOOTLEGGER get() = Weapons.THE_BOOTLEGGER
			/**
			 * A version of stock that can have qualities like "unique", "strange", "killstreak", etc.
			 *
			 * @see Weapons.TrueStock.GRENADELAUNCHER
			 */
			val STOCK_GRENADE_LAUNCHER get() = Weapons.STOCK_GRENADE_LAUNCHER
			val LOCHNLOAD get() = Weapons.LOCHNLOAD
			val GRENADE_LAUNCHER_FESTIVE get() = Weapons.GRENADE_LAUNCHER_FESTIVE
			val IRON_BOMBER get() = Weapons.IRON_BOMBER
			
			val LOOSE_CANNON get() = Weapons.LOOSE_CANNON
		}
		
		object Secondary {
			
			/**
			 * A version of stock that can have qualities like "unique", "strange", "killstreak", etc.
			 *
			 * @see Weapons.TrueStock.STICKYBOMB_LAUNCHER
			 */
			val STOCK_STICKYBOMB_LAUNCHER get() = Weapons.STOCK_STICKYBOMB_LAUNCHER
			
			val STICKYBOMB_LAUNCHER_FESTIVE get() = Weapons.STICKYBOMB_LAUNCHER_FESTIVE
			
			val THE_CHARGIN_TARGE get() = Weapons.THE_CHARGIN_TARGE
			val THE_SPLENDID_SCREEN get() = Weapons.THE_SPLENDID_SCREEN
			val THE_TIDE_TURNER get() = Weapons.THE_TIDE_TURNER
			val FESTIVE_TARGE_2014 get() = Weapons.FESTIVE_TARGE_2014
			val SCOTTISH_RESISTANCE get() = Weapons.SCOTTISH_RESISTANCE
			
			val STICKYBOMB_JUMPER get() = Weapons.STICKYBOMB_JUMPER
			
			val Botkillers get() = Weapons.StickybombLauncherBotkillers
			
			val QUICKIEBOMB_LAUNCHER get() = Weapons.QUICKIEBOMB_LAUNCHER
		}
		
		/**
		 * @see WeaponsMelee.AllClass
		 */
		object Melee {
			
			/**
			 * A version of stock that can have qualities like "unique", "strange", "killstreak", etc.
			 *
			 * @see Weapons.TrueStock.BOTTLE
			 */
			val STOCK_BOTTLE get() = WeaponsMelee.STOCK_BOTTLE
			val SCOTTISH_HANDSHAKE get() = WeaponsMelee.SCOTTISH_HANDSHAKE
			
			val ULLAPOOL_CABER get() = WeaponsMelee.ULLAPOOL_CABER
			val EYELANDER get() = WeaponsMelee.EYELANDER
			val SCOTSMANS_SKULLCUTTER get() = WeaponsMelee.SCOTSMANS_SKULLCUTTER
			val HORSELESS_HEADLESS_HORSEMANS_HEADTAKER get() = WeaponsMelee.HORSELESS_HEADLESS_HORSEMANS_HEADTAKER
			val CLAIDHEAMOHMOR get() = WeaponsMelee.CLAIDHEAMOHMOR
			val PERSIAN_PERSUADER get() = WeaponsMelee.PERSIAN_PERSUADER
			val NESSIES_NINE_IRON get() = WeaponsMelee.NESSIES_NINE_IRON
			val EYELANDER_FESTIVE get() = WeaponsMelee.EYELANDER_FESTIVE
			
			val HALFZATOICHI get() = WeaponsMelee.HALFZATOICHI
			
			val AllClass get() = WeaponsMelee.AllClass
		}
	}
	
	
	object HeavyWeapons {
		object Primary {
			
			val NATASCHA get() = Weapons.NATASCHA
			/**
			 * A version of stock that can have qualities like "unique", "strange", "killstreak", etc.
			 *
			 * @see Weapons.TrueStock.MINIGUN
			 */
			val STOCK_MINIGUN get() = Weapons.STOCK_MINIGUN
			val BRASS_BEAST get() = Weapons.BRASS_BEAST
			val TOMISLAV get() = Weapons.TOMISLAV
			val STOCK_MINIGUN_FESTIVE get() = Weapons.STOCK_MINIGUN_FESTIVE
			val HUO_LONG_HEATMAKER get() = Weapons.HUO_LONG_HEATMAKER
			val HUO_LONG_HEATMAKER_PROMO get() = Weapons.HUO_LONG_HEATMAKER_PROMO
			
			/**
			 * Given to MvM Deflector Heavies.
			 */
			val DEFLECTOR_MVM get() = Weapons.DEFLECTOR_MVM
			val Botkiller get() = Weapons.MinigunBotkillers
		}
		
		object Secondary {
			
			/**
			 * A version of stock that can have qualities like "unique", "strange", "killstreak", etc.
			 *
			 * @see Weapons.TrueStock.SHOTGUN_HWG
			 */
			val STOCK_SHOTGUN get() = Weapons.STOCK_SHOTGUN
			val STOCK_SHOTGUN_FESTIVE get() = Weapons.STOCK_SHOTGUN_FESTIVE
			val PANIC_ATTACK_SHOTGUN get() = Weapons.PANIC_ATTACK_SHOTGUN
			
			val FAMILY_BUSINESS get() = Weapons.FAMILY_BUSINESS
			
			
			val SANDVICH get() = Weapons.SANDVICH
			val DALOKOHS_BAR get() = Weapons.DALOKOHS_BAR
			val BUFFALO_STEAK_SANDVICH get() = Weapons.BUFFALO_STEAK_SANDVICH
			val FISHCAKE get() = Weapons.FISHCAKE
			val ROBOSANDVICH get() = Weapons.ROBOSANDVICH
			val SANDVICH_FESTIVE get() = Weapons.SANDVICH_FESTIVE
			val SECOND_BANANA get() = Weapons.SECOND_BANANA
		}
		
		
		object Melee {
			/**
			 * A version of stock that can have qualities like "unique", "strange", "killstreak", etc.
			 *
			 * @see Weapons.TrueStock.FISTS
			 */
			val STOCK_FISTS get() = WeaponsMelee.STOCK_FISTS
			val KILLING_GLOVES_OF_BOXING get() = WeaponsMelee.KILLING_GLOVES_OF_BOXING
			val GLOVES_OF_RUNNING_URGENTLY get() = WeaponsMelee.GLOVES_OF_RUNNING_URGENTLY
			val WARRIORS_SPIRIT get() = WeaponsMelee.WARRIORS_SPIRIT
			val FISTS_OF_STEEL get() = WeaponsMelee.FISTS_OF_STEEL
			val EVICTION_NOTICE get() = WeaponsMelee.EVICTION_NOTICE
			val APOCOFISTS get() = WeaponsMelee.APOCOFISTS
			val HOLIDAY_PUNCH get() = WeaponsMelee.HOLIDAY_PUNCH
			val GLOVES_OF_RUNNING_URGENTLY_FESTIVE get() = WeaponsMelee.GLOVES_OF_RUNNING_URGENTLY_FESTIVE
			val BREAD_BITE get() = WeaponsMelee.BREAD_BITE
			val GLOVES_OF_RUNNING_URGENTLY_MVM get() = WeaponsMelee.GLOVES_OF_RUNNING_URGENTLY_MVM
			
			val AllClass get() = WeaponsMelee.AllClass
		}
	}
	
	
	object EngineerWeapons {
		object Primary {
			/**
			 * A version of stock that can have qualities like "unique", "strange", "killstreak", etc.
			 *
			 * @see Weapons.TrueStock.SHOTGUN_PRIMARY
			 */
			val STOCK_SHOTGUN get() = Weapons.STOCK_SHOTGUN
			val STOCK_SHOTGUN_FESTIVE get() = Weapons.STOCK_SHOTGUN_FESTIVE
			val PANIC_ATTACK_SHOTGUN get() = Weapons.PANIC_ATTACK_SHOTGUN
			val FRONTIER_JUSTICE get() = Weapons.FRONTIER_JUSTICE
			
			val FRONTIER_JUSTICE_FESTIVE get() = Weapons.FRONTIER_JUSTICE_FESTIVE
			val WIDOWMAKER get() = Weapons.WIDOWMAKER
			val RESCUE_RANGER get() = Weapons.RESCUE_RANGER
			
			val POMSON_6000 get() = Weapons.POMSON_6000
			
		}
		
		object Secondary {
			/**
			 * A version of stock that can have qualities like "unique", "strange", "killstreak", etc.
			 *
			 * @see Weapons.TrueStock.WRENCH
			 */
			val STOCK_PISTOL get() = Weapons.STOCK_PISTOL
			
			val LUGERMORPH get() = Weapons.LUGERMORPH
			val CAPPER get() = Weapons.CAPPER
			
			val WRANGLER get() = Weapons.WRANGLER
			val WRANGLER_FESTIVE get() = Weapons.WRANGLER_FESTIVE
			val GIGER_COUNTER get() = Weapons.GIGER_COUNTER
			
			val SHORT_CIRCUIT get() = Weapons.SHORT_CIRCUIT
		}
		
		object Melee {
			val SOUTHERN_HOSPITALITY get() = WeaponsMelee.SOUTHERN_HOSPITALITY
			val GOLDEN_WRENCH get() = WeaponsMelee.GOLDEN_WRENCH
			/**
			 * A version of stock that can have qualities like "unique", "strange", "killstreak", etc.
			 *
			 * @see Weapons.TrueStock.WRENCH
			 */
			val STOCK_WRENCH get() = WeaponsMelee.STOCK_WRENCH
			val JAG get() = WeaponsMelee.JAG
			val EUREKA_EFFECT get() = WeaponsMelee.EUREKA_EFFECT
			val STOCK_WRENCH_FESTIVE get() = WeaponsMelee.STOCK_WRENCH_FESTIVE
			val Botkillers get() = WeaponsMelee.WrenchBotkiller
			
			val GUNSLINGER get() = WeaponsMelee.GUNSLINGER
			
			val SAXXY get() = WeaponsMelee.AllClass.SAXXY
			val MEMORY_MAKER get() = WeaponsMelee.AllClass.MEMORY_MAKER
			val PRINNY_MACHETE get() = WeaponsMelee.AllClass.PRINNY_MACHETE
			val GOLDEN_FRYING_PAN get() = WeaponsMelee.AllClass.GOLDEN_FRYING_PAN
		}
		
		/**
		 * @see Weapons.TrueStock.BUILD_PDA
		 */
		val BUILD_PDA get() = Weapons.BUILD_PDA_UNIQUE
		val DESTRUCTION_PDA get() = Weapons.DESTRUCTION_PDA
	}
	
	
	object Medic {
		object Primary {
			
			val BLUTSAUGER get() = Weapons.BLUTSAUGER
			/**
			 * A version of stock that can have qualities like "unique", "strange", "killstreak", etc.
			 *
			 * @see Weapons.TrueStock.SYRINGEGUN_MEDIC
			 */
			val STOCK_SYRINGE_GUN get() = Weapons.STOCK_SYRINGE_GUN
			val OVERDOSE get() = Weapons.OVERDOSE
			
			val CRUSADERS_CROSSBOW get() = Weapons.CRUSADERS_CROSSBOW
			val CRUSADERS_CROSSBOW_FESTIVE get() = Weapons.CRUSADERS_CROSSBOW_FESTIVE
		}
		
		object Secondary {
			
			val KRITZKRIEG get() = Weapons.KRITZKRIEG
			/**
			 * A version of stock that can have qualities like "unique", "strange", "killstreak", etc.
			 *
			 * @see Weapons.TrueStock.MEDIGUN
			 */
			val STOCK_MEDIGUN get() = Weapons.STOCK_MEDIGUN
			val QUICKFIX get() = Weapons.QUICKFIX
			val STOCK_MEDIGUN_FESTIVE get() = Weapons.STOCK_MEDIGUN_FESTIVE
			val Botkillers get() = Weapons.MedigunBotkillers
			
			val VACCINATOR get() = Weapons.VACCINATOR
			
		}
		
		object Melee {
			
			val UBERSAW get() = WeaponsMelee.UBERSAW
			val VITASAW get() = WeaponsMelee.VITASAW
			/**
			 * A version of stock that can have qualities like "unique", "strange", "killstreak", etc.
			 *
			 * @see Weapons.TrueStock.BONESAW
			 */
			val STOCK_BONESAW get() = WeaponsMelee.STOCK_BONESAW
			val AMPUTATOR get() = WeaponsMelee.AMPUTATOR
			val SOLEMN_VOW get() = WeaponsMelee.SOLEMN_VOW
			val UBERSAW_FESTIVE get() = WeaponsMelee.UBERSAW_FESTIVE
			val STOCK_BONESAW_FESTIVE get() = WeaponsMelee.STOCK_BONESAW_FESTIVE
			
			val AllClass get() = WeaponsMelee.AllClass
		}
	}
	
	object Sniper {
		object Primary {
			val HUNTSMAN get() = Weapons.HUNTSMAN
			val HUNTSMAN_FESTIVE get() = Weapons.HUNTSMAN_FESTIVE
			val FORTIFIED_COMPOUND get() = Weapons.FORTIFIED_COMPOUND
			
			
			/**
			 * A version of stock that can have qualities like "unique", "strange", "killstreak", etc.
			 *
			 * @see Weapons.TrueStock.SNIPERRIFLE
			 */
			val STOCK_SNIPER_RIFLE get() = Weapons.STOCK_SNIPER_RIFLE
			val SYDNEY_SLEEPER get() = Weapons.SYDNEY_SLEEPER
			val MACHINA get() = Weapons.MACHINA
			val STOCK_SNIPER_RIFLE_FESTIVE get() = Weapons.STOCK_SNIPER_RIFLE_FESTIVE
			val HITMANS_HEATMAKER get() = Weapons.HITMANS_HEATMAKER
			val AWPER_HAND get() = Weapons.AWPER_HAND
			val Botkillers get() = Weapons.SniperRifleBotkillers
			val SHOOTING_STAR get() = Weapons.SHOOTING_STAR
			
			val BAZAAR_BARGAIN get() = Weapons.BAZAAR_BARGAIN
			
			val CLASSIC get() = Weapons.CLASSIC
		}
		
		object Secondary {
			val JARATE get() = Weapons.JARATE
			val JARATE_FESTIVE get() = Weapons.JARATE_FESTIVE
			val SELFAWARE_BEAUTY_MARK get() = Weapons.SELFAWARE_BEAUTY_MARK
			
			/**
			 * A version of stock that can have qualities like "unique", "strange", "killstreak", etc.
			 *
			 * @see Weapons.TrueStock.SMG
			 */
			val STOCK_SMG get() = Weapons.STOCK_SMG
			val STOCK_SMG_FESTIVE get() = Weapons.STOCK_SMG_FESTIVE
			val CLEANERS_CARBINE get() = Weapons.CLEANERS_CARBINE
			
			val RAZORBACK get() = Weapons.RAZORBACK
		}
		
		/**
		 * @see WeaponsMelee.AllClass
		 */
		object Melees {
			val TRIBALMANS_SHIV get() = WeaponsMelee.TRIBALMANS_SHIV
			/**
			 * A version of stock that can have qualities like "unique", "strange", "killstreak", etc.
			 *
			 * @see Weapons.TrueStock.KUKRI
			 */
			val STOCK_KUKRI get() = WeaponsMelee.STOCK_KUKRI
			val BUSHWACKA get() = WeaponsMelee.BUSHWACKA
			val SHAHANSHAH get() = WeaponsMelee.SHAHANSHAH
			
			val AllClass get() = WeaponsMelee.AllClass
		}
	}
	
	object Spy {
		object Primary {
			val AMBASSADOR get() = Weapons.AMBASSADOR
			val BIG_KILL get() = Weapons.BIG_KILL
			/**
			 * A version of stock that can have qualities like "unique", "strange", "killstreak", etc.
			 *
			 * @see Weapons.TrueStock.REVOLVER
			 */
			val STOCK_REVOLVER get() = Weapons.STOCK_REVOLVER
			val LETRANGER get() = Weapons.LETRANGER
			val ENFORCER get() = Weapons.ENFORCER
			val DIAMONDBACK get() = Weapons.DIAMONDBACK
			val AMBASSADOR_FESTIVE get() = Weapons.AMBASSADOR_FESTIVE
			val STOCK_REVOLVER_FESTIVE get() = Weapons.STOCK_REVOLVER_FESTIVE
		}
		
		object Secondary {
			val REDTAPE_RECORDER get() = Weapons.REDTAPE_RECORDER
			val REDTAPE_RECORDER_PROMO get() = Weapons.REDTAPE_RECORDER_PROMO
			val APSAP get() = Weapons.APSAP
			val STOCK_SAPPER_FESTIVE get() = Weapons.STOCK_SAPPER_FESTIVE
			val SNACK_ATTACK get() = Weapons.SNACK_ATTACK
			/**
			 * A version of stock that can have qualities like "unique", "strange", "killstreak", etc.
			 *
			 * @see Weapons.TrueStock.SAPPER
			 */
			val STOCK_SAPPER get() = Weapons.STOCK_SAPPER
		}
		
		object Melee {
			/**
			 * A version of stock that can have qualities like "unique", "strange", "killstreak", etc.
			 *
			 * @see Weapons.TrueStock.KNIFE
			 */
			val STOCK_KNIFE get() = WeaponsMelee.STOCK_KNIFE
			val STOCK_KNIFE_FESTIVE get() = WeaponsMelee.STOCK_KNIFE_FESTIVE
			val YOUR_ETERNAL_REWARD get() = WeaponsMelee.YOUR_ETERNAL_REWARD
			val CONNIVERS_KUNAI get() = WeaponsMelee.CONNIVERS_KUNAI
			val BIG_EARNER get() = WeaponsMelee.BIG_EARNER
			val WANGA_PRICK get() = WeaponsMelee.WANGA_PRICK
			val SHARP_DRESSER get() = WeaponsMelee.SHARP_DRESSER
			val SPYCICLE get() = WeaponsMelee.SPYCICLE
			val BLACK_ROSE get() = WeaponsMelee.BLACK_ROSE
			val Botkillers get() = WeaponsMelee.KnifeBotkiller
			
			val SAXXY get() = WeaponsMelee.AllClass.SAXXY
			val MEMORY_MAKER get() = WeaponsMelee.AllClass.MEMORY_MAKER
			val PRINNY_MACHETE get() = WeaponsMelee.AllClass.PRINNY_MACHETE
			val GOLDEN_FRYING_PAN get() = WeaponsMelee.AllClass.GOLDEN_FRYING_PAN
		}
		
		object InvisWatches {
			
			/**
			 * A version of stock that can have qualities like "unique", "strange", "killstreak", etc.
			 *
			 * @see Weapons.TrueStock.INVIS
			 */
			val STOCK_INVIS_WATCH get() = Weapons.STOCK_INVIS_WATCH
			val DEAD_RINGER get() = Weapons.DEAD_RINGER
			val CLOAK_AND_DAGGER get() = Weapons.CLOAK_AND_DAGGER
			val QUACKENBIRDT get() = Weapons.QUACKENBIRDT
		}
		
		val DISGUISE_KIT get() = Weapons.DISGUISE_KIT
	}
}