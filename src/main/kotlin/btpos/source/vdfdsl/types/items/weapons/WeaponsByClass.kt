@file:Suppress("unused")

package btpos.source.vdfdsl.types.items.weapons

object WeaponsByClass {
	
	object Scout {
		object Primary {
			
			val FORCEANATURE get() = WeaponsAll.FORCEANATURE
			/**
			 * A version of stock that can have qualities like "unique", "strange", "killstreak", etc.
			 *
			 * @see WeaponsAll.TrueStock.SCATTERGUN
			 */
			val STOCK_SCATTERGUN get() = WeaponsAll.STOCK_SCATTERGUN
			val STOCK_SCATTERGUN_FESTIVE get() = WeaponsAll.STOCK_SCATTERGUN_FESTIVE
			val Botkiller get() = WeaponsAll.ScattergunBotkillers
			val FORCEANATURE_FESTIVE get() = WeaponsAll.FORCEANATURE_FESTIVE
			val BACK_SCATTER get() = WeaponsAll.BACK_SCATTER
			
			val SHORTSTOP get() = WeaponsAll.SHORTSTOP
			
			val SODA_POPPER get() = WeaponsAll.SODA_POPPER
			val BABY_FACES_BLASTER get() = WeaponsAll.BABY_FACES_BLASTER
		}
		
		object Secondary {
			val BONK_ATOMIC_PUNCH get() = WeaponsAll.BONK_ATOMIC_PUNCH
			val CRITACOLA get() = WeaponsAll.CRITACOLA
			val BONK_FESTIVE get() = WeaponsAll.BONK_FESTIVE
			val WINGER get() = WeaponsAll.WINGER
			val PRETTY_BOYS_POCKET_PISTOL get() = WeaponsAll.PRETTY_BOYS_POCKET_PISTOL
			/**
			 * A version of stock that can have qualities like "unique", "strange", "killstreak", etc.
			 *
			 * @see WeaponsAll.TrueStock.PISTOL
			 */
			val STOCK_PISTOL get() = WeaponsAll.STOCK_PISTOL
			
			val LUGERMORPH get() = WeaponsAll.LUGERMORPH
			val CAPPER get() = WeaponsAll.CAPPER
			
			val MAD_MILK get() = WeaponsAll.MAD_MILK
			val MUTATED_MILK get() = WeaponsAll.MUTATED_MILK
			
			val FLYING_GUILLOTINE get() = WeaponsAll.FLYING_GUILLOTINE
			val FLYING_GUILLOTINE_PROMO get() = WeaponsAll.FLYING_GUILLOTINE_PROMO
			
		}
		
		object Melee {
			/**
			 * A version of stock that can have qualities like "unique", "strange", "killstreak", etc.
			 *
			 * @see WeaponsAll.TrueStock.BAT
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
			 * @see WeaponsAll.TrueStock.ROCKETLAUNCHER
			 */
			val STOCK_ROCKET_LAUNCHER get() = WeaponsAll.STOCK_ROCKET_LAUNCHER
			val BLACK_BOX get() = WeaponsAll.BLACK_BOX
			val ROCKET_JUMPER get() = WeaponsAll.ROCKET_JUMPER
			val LIBERTY_LAUNCHER get() = WeaponsAll.LIBERTY_LAUNCHER
			val ORIGINAL get() = WeaponsAll.ORIGINAL
			val STOCK_ROCKET_LAUNCHER_FESTIVE get() = WeaponsAll.STOCK_ROCKET_LAUNCHER_FESTIVE
			val BEGGARS_BAZOOKA get() = WeaponsAll.BEGGARS_BAZOOKA
			
			val BLACK_BOX_FESTIVE get() = WeaponsAll.BLACK_BOX_FESTIVE
			val DIRECT_HIT get() = WeaponsAll.DIRECT_HIT
			val COW_MANGLER_5000 get() = WeaponsAll.COW_MANGLER_5000
			val AIR_STRIKE get() = WeaponsAll.AIR_STRIKE
			
			
			val Botkillers get() = WeaponsAll.RocketLauncherBotkillers
		}
		
		object Secondary {
			/**
			 * A version of stock that can have qualities like "unique", "strange", "killstreak", etc.
			 *
			 * @see WeaponsAll.TrueStock.SHOTGUN_SOLDIER
			 */
			val STOCK_SHOTGUN get() = WeaponsAll.STOCK_SHOTGUN
			val RESERVE_SHOOTER get() = WeaponsAll.RESERVE_SHOOTER
			val STOCK_SHOTGUN_FESTIVE get() = WeaponsAll.STOCK_SHOTGUN_FESTIVE
			val PANIC_ATTACK_SHOTGUN get() = WeaponsAll.PANIC_ATTACK_SHOTGUN
			
			
			val BUFF_BANNER get() = WeaponsAll.BUFF_BANNER
			val BUFF_BANNER_FESTIVE get() = WeaponsAll.BUFF_BANNER_FESTIVE
			val BATTALIONS_BACKUP get() = WeaponsAll.BATTALIONS_BACKUP
			val CONCHEROR get() = WeaponsAll.CONCHEROR
			val BASE_JUMPER get() = WeaponsAll.BASE_JUMPER
			
			val RIGHTEOUS_BISON get() = WeaponsAll.RIGHTEOUS_BISON
			
			val THE_GUNBOATS get() = WeaponsAll.THE_GUNBOATS
			
			val THE_MANTREADS get() = WeaponsAll.THE_MANTREADS
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
			 * @see WeaponsAll.TrueStock.SHOVEL
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
			 * @see WeaponsAll.TrueStock.FLAMETHROWER
			 */
			val STOCK_FLAMETHROWER get() = WeaponsAll.STOCK_FLAMETHROWER
			val STOCK_FLAMETHROWER_FESTIVE get() = WeaponsAll.STOCK_FLAMETHROWER_FESTIVE
			val BACKBURNER get() = WeaponsAll.BACKBURNER
			val DEGREASER get() = WeaponsAll.DEGREASER
			val PHLOGISTINATOR get() = WeaponsAll.PHLOGISTINATOR
			val RAINBLOWER get() = WeaponsAll.RAINBLOWER
			
			val Botkillers get() = WeaponsAll.FlamethrowerBotkillers
			val BACKBURNER_FESTIVE get() = WeaponsAll.BACKBURNER_FESTIVE
			val NOSTROMO_NAPALMER get() = WeaponsAll.NOSTROMO_NAPALMER
			
			val DRAGONS_FURY get() = WeaponsAll.DRAGONS_FURY
		}
		
		object Secondary {
			val THERMAL_THRUSTER get() = WeaponsAll.THERMAL_THRUSTER
			val GAS_PASSER get() = WeaponsAll.GAS_PASSER
			
			val FLARE_GUN get() = WeaponsAll.FLARE_GUN
			val DETONATOR get() = WeaponsAll.DETONATOR
			val SCORCH_SHOT get() = WeaponsAll.SCORCH_SHOT
			val FLARE_GUN_FESTIVE get() = WeaponsAll.FLARE_GUN_FESTIVE
			val MANMELTER get() = WeaponsAll.MANMELTER
			
			/**
			 * A version of stock that can have qualities like "unique", "strange", "killstreak", etc.
			 *
			 * @see WeaponsAll.TrueStock.SHOTGUN_PYRO
			 */
			val STOCK_SHOTGUN get() = WeaponsAll.STOCK_SHOTGUN
			val RESERVE_SHOOTER get() = WeaponsAll.RESERVE_SHOOTER
			val STOCK_SHOTGUN_FESTIVE get() = WeaponsAll.STOCK_SHOTGUN_FESTIVE
			val PANIC_ATTACK_SHOTGUN get() = WeaponsAll.PANIC_ATTACK_SHOTGUN
			
		}
		
		object Melee {
			/**
			 * A version of stock that can have qualities like "unique", "strange", "killstreak", etc.
			 *
			 * @see WeaponsAll.TrueStock.FIREAXE
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
			
			val ALI_BABAS_WEE_BOOTIES get() = WeaponsAll.ALI_BABAS_WEE_BOOTIES
			val THE_BOOTLEGGER get() = WeaponsAll.THE_BOOTLEGGER
			/**
			 * A version of stock that can have qualities like "unique", "strange", "killstreak", etc.
			 *
			 * @see WeaponsAll.TrueStock.GRENADELAUNCHER
			 */
			val STOCK_GRENADE_LAUNCHER get() = WeaponsAll.STOCK_GRENADE_LAUNCHER
			val LOCHNLOAD get() = WeaponsAll.LOCHNLOAD
			val GRENADE_LAUNCHER_FESTIVE get() = WeaponsAll.GRENADE_LAUNCHER_FESTIVE
			val IRON_BOMBER get() = WeaponsAll.IRON_BOMBER
			
			val LOOSE_CANNON get() = WeaponsAll.LOOSE_CANNON
		}
		
		object Secondary {
			
			/**
			 * A version of stock that can have qualities like "unique", "strange", "killstreak", etc.
			 *
			 * @see WeaponsAll.TrueStock.STICKYBOMB_LAUNCHER
			 */
			val STOCK_STICKYBOMB_LAUNCHER get() = WeaponsAll.STOCK_STICKYBOMB_LAUNCHER
			
			val STICKYBOMB_LAUNCHER_FESTIVE get() = WeaponsAll.STICKYBOMB_LAUNCHER_FESTIVE
			
			val THE_CHARGIN_TARGE get() = WeaponsAll.THE_CHARGIN_TARGE
			val THE_SPLENDID_SCREEN get() = WeaponsAll.THE_SPLENDID_SCREEN
			val THE_TIDE_TURNER get() = WeaponsAll.THE_TIDE_TURNER
			val FESTIVE_TARGE_2014 get() = WeaponsAll.FESTIVE_TARGE_2014
			val SCOTTISH_RESISTANCE get() = WeaponsAll.SCOTTISH_RESISTANCE
			
			val STICKYBOMB_JUMPER get() = WeaponsAll.STICKYBOMB_JUMPER
			
			val Botkillers get() = WeaponsAll.StickybombLauncherBotkillers
			
			val QUICKIEBOMB_LAUNCHER get() = WeaponsAll.QUICKIEBOMB_LAUNCHER
		}
		
		/**
		 * @see WeaponsMelee.AllClass
		 */
		object Melee {
			
			/**
			 * A version of stock that can have qualities like "unique", "strange", "killstreak", etc.
			 *
			 * @see WeaponsAll.TrueStock.BOTTLE
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
			
			val NATASCHA get() = WeaponsAll.NATASCHA
			/**
			 * A version of stock that can have qualities like "unique", "strange", "killstreak", etc.
			 *
			 * @see WeaponsAll.TrueStock.MINIGUN
			 */
			val STOCK_MINIGUN get() = WeaponsAll.STOCK_MINIGUN
			val BRASS_BEAST get() = WeaponsAll.BRASS_BEAST
			val TOMISLAV get() = WeaponsAll.TOMISLAV
			val STOCK_MINIGUN_FESTIVE get() = WeaponsAll.STOCK_MINIGUN_FESTIVE
			val HUO_LONG_HEATMAKER get() = WeaponsAll.HUO_LONG_HEATMAKER
			val HUO_LONG_HEATMAKER_PROMO get() = WeaponsAll.HUO_LONG_HEATMAKER_PROMO
			
			/**
			 * Given to MvM Deflector Heavies.
			 */
			val DEFLECTOR_MVM get() = WeaponsAll.DEFLECTOR_MVM
			val Botkiller get() = WeaponsAll.MinigunBotkillers
		}
		
		object Secondary {
			
			/**
			 * A version of stock that can have qualities like "unique", "strange", "killstreak", etc.
			 *
			 * @see WeaponsAll.TrueStock.SHOTGUN_HWG
			 */
			val STOCK_SHOTGUN get() = WeaponsAll.STOCK_SHOTGUN
			val STOCK_SHOTGUN_FESTIVE get() = WeaponsAll.STOCK_SHOTGUN_FESTIVE
			val PANIC_ATTACK_SHOTGUN get() = WeaponsAll.PANIC_ATTACK_SHOTGUN
			
			val FAMILY_BUSINESS get() = WeaponsAll.FAMILY_BUSINESS
			
			
			val SANDVICH get() = WeaponsAll.SANDVICH
			val DALOKOHS_BAR get() = WeaponsAll.DALOKOHS_BAR
			val BUFFALO_STEAK_SANDVICH get() = WeaponsAll.BUFFALO_STEAK_SANDVICH
			val FISHCAKE get() = WeaponsAll.FISHCAKE
			val ROBOSANDVICH get() = WeaponsAll.ROBOSANDVICH
			val SANDVICH_FESTIVE get() = WeaponsAll.SANDVICH_FESTIVE
		}
		
		
		object Melee {
			/**
			 * A version of stock that can have qualities like "unique", "strange", "killstreak", etc.
			 *
			 * @see WeaponsAll.TrueStock.FISTS
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
			 * @see WeaponsAll.TrueStock.SHOTGUN_PRIMARY
			 */
			val STOCK_SHOTGUN get() = WeaponsAll.STOCK_SHOTGUN
			val STOCK_SHOTGUN_FESTIVE get() = WeaponsAll.STOCK_SHOTGUN_FESTIVE
			val PANIC_ATTACK_SHOTGUN get() = WeaponsAll.PANIC_ATTACK_SHOTGUN
			val FRONTIER_JUSTICE get() = WeaponsAll.FRONTIER_JUSTICE
			
			val FRONTIER_JUSTICE_FESTIVE get() = WeaponsAll.FRONTIER_JUSTICE_FESTIVE
			val WIDOWMAKER get() = WeaponsAll.WIDOWMAKER
			val RESCUE_RANGER get() = WeaponsAll.RESCUE_RANGER
			
			val POMSON_6000 get() = WeaponsAll.POMSON_6000
			
		}
		
		object Secondary {
			/**
			 * A version of stock that can have qualities like "unique", "strange", "killstreak", etc.
			 *
			 * @see WeaponsAll.TrueStock.WRENCH
			 */
			val STOCK_PISTOL get() = WeaponsAll.STOCK_PISTOL
			
			val LUGERMORPH get() = WeaponsAll.LUGERMORPH
			val CAPPER get() = WeaponsAll.CAPPER
			
			val WRANGLER get() = WeaponsAll.WRANGLER
			val WRANGLER_FESTIVE get() = WeaponsAll.WRANGLER_FESTIVE
			val GIGER_COUNTER get() = WeaponsAll.GIGER_COUNTER
			
			val SHORT_CIRCUIT get() = WeaponsAll.SHORT_CIRCUIT
		}
		
		object Melee {
			val SOUTHERN_HOSPITALITY get() = WeaponsMelee.SOUTHERN_HOSPITALITY
			val GOLDEN_WRENCH get() = WeaponsMelee.GOLDEN_WRENCH
			/**
			 * A version of stock that can have qualities like "unique", "strange", "killstreak", etc.
			 *
			 * @see WeaponsAll.TrueStock.WRENCH
			 */
			val STOCK_WRENCH get() = WeaponsMelee.STOCK_WRENCH
			val JAG get() = WeaponsMelee.JAG
			val EUREKA_EFFECT get() = WeaponsMelee.EUREKA_EFFECT
			val STOCK_WRENCH_FESTIVE get() = WeaponsMelee.STOCK_WRENCH_FESTIVE
			val Botkillers get() = WeaponsMelee.WrenchBotkiller
			
			val GUNSLINGER get() = WeaponsMelee.GUNSLINGER
			
			val PRINNY_MACHETE get() = WeaponsMelee.AllClass.PRINNY_MACHETE
			val GOLDEN_FRYING_PAN get() = WeaponsMelee.AllClass.GOLDEN_FRYING_PAN
			
		}
		
		/**
		 * @see WeaponsAll.TrueStock.BUILD_PDA
		 */
		val BUILD_PDA get() = WeaponsAll.BUILD_PDA_UNIQUE
		val DESTRUCTION_PDA get() = WeaponsAll.DESTRUCTION_PDA
	}
	
	
	object Medic {
		object Primary {
			
			val BLUTSAUGER get() = WeaponsAll.BLUTSAUGER
			/**
			 * A version of stock that can have qualities like "unique", "strange", "killstreak", etc.
			 *
			 * @see WeaponsAll.TrueStock.SYRINGEGUN_MEDIC
			 */
			val STOCK_SYRINGE_GUN get() = WeaponsAll.STOCK_SYRINGE_GUN
			val OVERDOSE get() = WeaponsAll.OVERDOSE
			
			val CRUSADERS_CROSSBOW get() = WeaponsAll.CRUSADERS_CROSSBOW
			val CRUSADERS_CROSSBOW_FESTIVE get() = WeaponsAll.CRUSADERS_CROSSBOW_FESTIVE
		}
		
		object Secondary {
			
			val KRITZKRIEG get() = WeaponsAll.KRITZKRIEG
			/**
			 * A version of stock that can have qualities like "unique", "strange", "killstreak", etc.
			 *
			 * @see WeaponsAll.TrueStock.MEDIGUN
			 */
			val STOCK_MEDIGUN get() = WeaponsAll.STOCK_MEDIGUN
			val QUICKFIX get() = WeaponsAll.QUICKFIX
			val STOCK_MEDIGUN_FESTIVE get() = WeaponsAll.STOCK_MEDIGUN_FESTIVE
			val Botkillers get() = WeaponsAll.MedigunBotkillers
			
			val VACCINATOR get() = WeaponsAll.VACCINATOR
			
		}
		
		object Melee {
			
			val UBERSAW get() = WeaponsMelee.UBERSAW
			val VITASAW get() = WeaponsMelee.VITASAW
			/**
			 * A version of stock that can have qualities like "unique", "strange", "killstreak", etc.
			 *
			 * @see WeaponsAll.TrueStock.BONESAW
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
			val HUNTSMAN get() = WeaponsAll.HUNTSMAN
			val HUNTSMAN_FESTIVE get() = WeaponsAll.HUNTSMAN_FESTIVE
			val FORTIFIED_COMPOUND get() = WeaponsAll.FORTIFIED_COMPOUND
			
			
			/**
			 * A version of stock that can have qualities like "unique", "strange", "killstreak", etc.
			 *
			 * @see WeaponsAll.TrueStock.SNIPERRIFLE
			 */
			val STOCK_SNIPER_RIFLE get() = WeaponsAll.STOCK_SNIPER_RIFLE
			val SYDNEY_SLEEPER get() = WeaponsAll.SYDNEY_SLEEPER
			val MACHINA get() = WeaponsAll.MACHINA
			val STOCK_SNIPER_RIFLE_FESTIVE get() = WeaponsAll.STOCK_SNIPER_RIFLE_FESTIVE
			val HITMANS_HEATMAKER get() = WeaponsAll.HITMANS_HEATMAKER
			val AWPER_HAND get() = WeaponsAll.AWPER_HAND
			val Botkillers get() = WeaponsAll.SniperRifleBotkillers
			val SHOOTING_STAR get() = WeaponsAll.SHOOTING_STAR
			
			val BAZAAR_BARGAIN get() = WeaponsAll.BAZAAR_BARGAIN
			
			val CLASSIC get() = WeaponsAll.CLASSIC
		}
		
		object Secondary {
			val JARATE get() = WeaponsAll.JARATE
			val JARATE_FESTIVE get() = WeaponsAll.JARATE_FESTIVE
			val SELFAWARE_BEAUTY_MARK get() = WeaponsAll.SELFAWARE_BEAUTY_MARK
			
			/**
			 * A version of stock that can have qualities like "unique", "strange", "killstreak", etc.
			 *
			 * @see WeaponsAll.TrueStock.SMG
			 */
			val STOCK_SMG get() = WeaponsAll.STOCK_SMG
			val STOCK_SMG_FESTIVE get() = WeaponsAll.STOCK_SMG_FESTIVE
			val CLEANERS_CARBINE get() = WeaponsAll.CLEANERS_CARBINE
		}
		
		/**
		 * @see WeaponsMelee.AllClass
		 */
		object Melees {
			val TRIBALMANS_SHIV get() = WeaponsMelee.TRIBALMANS_SHIV
			/**
			 * A version of stock that can have qualities like "unique", "strange", "killstreak", etc.
			 *
			 * @see WeaponsAll.TrueStock.KUKRI
			 */
			val STOCK_KUKRI get() = WeaponsMelee.STOCK_KUKRI
			val BUSHWACKA get() = WeaponsMelee.BUSHWACKA
			val SHAHANSHAH get() = WeaponsMelee.SHAHANSHAH
			
			val AllClass get() = WeaponsMelee.AllClass
		}
	}
	
	object Spy {
		object Primary {
			val AMBASSADOR get() = WeaponsAll.AMBASSADOR
			val BIG_KILL get() = WeaponsAll.BIG_KILL
			/**
			 * A version of stock that can have qualities like "unique", "strange", "killstreak", etc.
			 *
			 * @see WeaponsAll.TrueStock.REVOLVER
			 */
			val STOCK_REVOLVER get() = WeaponsAll.STOCK_REVOLVER
			val LETRANGER get() = WeaponsAll.LETRANGER
			val ENFORCER get() = WeaponsAll.ENFORCER
			val DIAMONDBACK get() = WeaponsAll.DIAMONDBACK
			val AMBASSADOR_FESTIVE get() = WeaponsAll.AMBASSADOR_FESTIVE
			val STOCK_REVOLVER_FESTIVE get() = WeaponsAll.STOCK_REVOLVER_FESTIVE
		}
		
		object Secondary {
			val REDTAPE_RECORDER get() = WeaponsAll.REDTAPE_RECORDER
			val REDTAPE_RECORDER_PROMO get() = WeaponsAll.REDTAPE_RECORDER_PROMO
			val APSAP get() = WeaponsAll.APSAP
			val STOCK_SAPPER_FESTIVE get() = WeaponsAll.STOCK_SAPPER_FESTIVE
			val SNACK_ATTACK get() = WeaponsAll.SNACK_ATTACK
			/**
			 * A version of stock that can have qualities like "unique", "strange", "killstreak", etc.
			 *
			 * @see WeaponsAll.TrueStock.SAPPER
			 */
			val STOCK_SAPPER get() = WeaponsAll.STOCK_SAPPER
		}
		
		object Melee {
			/**
			 * A version of stock that can have qualities like "unique", "strange", "killstreak", etc.
			 *
			 * @see WeaponsAll.TrueStock.KNIFE
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
			
			val PRINNY_MACHETE get() = WeaponsMelee.AllClass.PRINNY_MACHETE
			val GOLDEN_FRYING_PAN get() = WeaponsMelee.AllClass.GOLDEN_FRYING_PAN
		}
		
		object InvisWatches {
			
			/**
			 * A version of stock that can have qualities like "unique", "strange", "killstreak", etc.
			 *
			 * @see WeaponsAll.TrueStock.INVIS
			 */
			val STOCK_INVIS_WATCH get() = WeaponsAll.STOCK_INVIS_WATCH
			val DEAD_RINGER get() = WeaponsAll.DEAD_RINGER
			val CLOAK_AND_DAGGER get() = WeaponsAll.CLOAK_AND_DAGGER
			val QUACKENBIRDT get() = WeaponsAll.QUACKENBIRDT
		}
		
		val DISGUISE_KIT get() = WeaponsAll.DISGUISE_KIT
	}
}