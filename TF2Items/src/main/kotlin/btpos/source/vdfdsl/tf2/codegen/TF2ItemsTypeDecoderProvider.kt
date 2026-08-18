package btpos.source.vdfdsl.tf2.codegen

import btpos.misc.kt.codegen.KtExpression
import btpos.source.vdfdsl.backing.VDFPrimitive
import btpos.source.vdfdsl.codegen.Codegen
import btpos.source.vdfdsl.codegen.SelfNamedDecoder
import btpos.source.vdfdsl.codegen.StringDecoderMap
import btpos.source.vdfdsl.codegen.ValueDecoder
import btpos.source.vdfdsl.codegen.services.TypeDecoderProvider
import btpos.source.vdfdsl.tf2.items.TFItem
import btpos.source.vdfdsl.tf2.items.weapons.Weapons
import kotlin.reflect.KClass

object TF2ItemsTypeDecoderProvider : TypeDecoderProvider {
	private val x get() =
		sequenceOf(
			"Upgradeable TF_WEAPON_SCATTERGUN" to "Weapons.STOCK_SCATTERGUN",
			"Festive Scattergun 2011" to "Weapons.STOCK_SCATTERGUN_FESTIVE",
			
			"Festive Force-a-Nature" to "Weapons.FORCEANATURE_FESTIVE",
			"The Back Scatter" to "Weapons.BACK_SCATTER",
			
			"The Shortstop" to "Weapons.SHORTSTOP",
			
			"The Soda Popper" to "Weapons.SODA_POPPER",
			"Baby Face's Blaster" to "Weapons.BABY_FACES_BLASTER",
			"The Force-a-Nature" to "Weapons.FORCEANATURE",
			
			"Upgradeable TF_WEAPON_ROCKETLAUNCHER" to "Weapons.STOCK_ROCKET_LAUNCHER",
			"Festive Rocket Launcher 2011" to "Weapons.STOCK_ROCKET_LAUNCHER_FESTIVE",
			"The Black Box" to "Weapons.BLACK_BOX",
			"Festive Black Box" to "Weapons.BLACK_BOX_FESTIVE",
			"Rocket Jumper" to "Weapons.ROCKET_JUMPER",
			"The Liberty Launcher" to "Weapons.LIBERTY_LAUNCHER",
			"The Original" to "Weapons.ORIGINAL",
			"The Beggar's Bazooka" to "Weapons.BEGGARS_BAZOOKA",
			"The Direct Hit" to "Weapons.DIRECT_HIT",
			"The Cow Mangler 5000" to "Weapons.COW_MANGLER_5000",
			"The Air Strike" to "Weapons.AIR_STRIKE",
			
			"The Buff Banner" to "Weapons.BUFF_BANNER",
			"Festive Buff Banner" to "Weapons.BUFF_BANNER_FESTIVE",
			"The Battalion's Backup" to "Weapons.BATTALIONS_BACKUP",
			"The Concheror" to "Weapons.CONCHEROR",
			"The B.A.S.E. Jumper" to "Weapons.BASE_JUMPER",
			
			"Upgradeable TF_WEAPON_FLAMETHROWER" to "Weapons.STOCK_FLAMETHROWER",
			"Festive Flamethrower 2011" to "Weapons.STOCK_FLAMETHROWER_FESTIVE",
			"The Backburner" to "Weapons.BACKBURNER",
			"The Degreaser" to "Weapons.DEGREASER",
			"The Phlogistinator" to "Weapons.PHLOGISTINATOR",
			"The Rainblower" to "Weapons.RAINBLOWER",
			"Festive Backburner 2014" to "Weapons.BACKBURNER_FESTIVE",
			"The Nostromo Napalmer" to "Weapons.NOSTROMO_NAPALMER",
			"The Dragon's Fury" to "Weapons.DRAGONS_FURY",
			
			"The Flare Gun" to "Weapons.FLARE_GUN",
			"The Detonator" to "Weapons.DETONATOR",
			"The Scorch Shot" to "Weapons.SCORCH_SHOT",
			"Festive Flare Gun" to "Weapons.FLARE_GUN_FESTIVE",
			"The Manmelter" to "Weapons.MANMELTER",
			
			"The Thermal Thruster" to "Weapons.THERMAL_THRUSTER",
			
			"Upgradeable TF_WEAPON_GRENADELAUNCHER" to "Weapons.STOCK_GRENADE_LAUNCHER",
			"The Loch-n-Load" to "Weapons.LOCHNLOAD",
			"Festive Grenade Launcher" to "Weapons.GRENADE_LAUNCHER_FESTIVE",
			"The Iron Bomber" to "Weapons.IRON_BOMBER",
			"The Loose Cannon" to "Weapons.LOOSE_CANNON",
			
			"Upgradeable TF_WEAPON_MINIGUN" to "Weapons.STOCK_MINIGUN",
			"The Brass Beast" to "Weapons.BRASS_BEAST",
			"Tomislav" to "Weapons.TOMISLAV",
			"Festive Minigun 2011" to "Weapons.STOCK_MINIGUN_FESTIVE",
			"The Huo Long Heatmaker" to "Weapons.HUO_LONG_HEATMAKER",
			"Promo Huo Long Heatmaker" to "Weapons.HUO_LONG_HEATMAKER_PROMO",
			"Natascha" to "Weapons.NATASCHA",
			
			"Deflector" to "Weapons.DEFLECTOR_MVM",
			
			"The Sandvich" to "Weapons.SANDVICH",
			"The Dalokohs Bar" to "Weapons.DALOKOHS_BAR",
			"The Buffalo Steak Sandvich" to "Weapons.BUFFALO_STEAK_SANDVICH",
			"Fishcake" to "Weapons.FISHCAKE",
			"The Robo-Sandvich" to "Weapons.ROBOSANDVICH",
			"Festive Sandvich" to "Weapons.SANDVICH_FESTIVE",
			"The Second Banana" to "Weapons.SECOND_BANANA",
			
			"The Winger" to "Weapons.WINGER",
			"Pretty Boy's Pocket Pistol" to "Weapons.PRETTY_BOYS_POCKET_PISTOL",
			
			"The Gunboats" to "Weapons.GUNBOATS",
			
			"The Mantreads" to "Weapons.MANTREADS",
			
			"The Huntsman" to "Weapons.HUNTSMAN",
			"Festive Huntsman" to "Weapons.HUNTSMAN_FESTIVE",
			"The Fortified Compound" to "Weapons.FORTIFIED_COMPOUND",
			
			"Bonk! Atomic Punch" to "Weapons.BONK_ATOMIC_PUNCH",
			"Crit-a-Cola" to "Weapons.CRITACOLA",
			"Festive Bonk 2014" to "Weapons.BONK_FESTIVE",
			
			"The Chargin' Targe" to "Weapons.THE_CHARGIN_TARGE",
			"The Splendid Screen" to "Weapons.THE_SPLENDID_SCREEN",
			"The Tide Turner" to "Weapons.THE_TIDE_TURNER",
			"Festive Targe 2014" to "Weapons.FESTIVE_TARGE_2014",
			
			"Ali Baba's Wee Booties" to "Weapons.ALI_BABAS_WEE_BOOTIES",
			"The Bootlegger" to "Weapons.THE_BOOTLEGGER",
			
			"Upgradeable TF_WEAPON_PIPEBOMBLAUNCHER" to "Weapons.STOCK_STICKYBOMB_LAUNCHER",
			"Festive Stickybomb Launcher 2011" to "Weapons.STICKYBOMB_LAUNCHER_FESTIVE",
			
			"The Scottish Resistance" to "Weapons.SCOTTISH_RESISTANCE",
			
			"Stickybomb Jumper" to "Weapons.STICKYBOMB_JUMPER",
			
			"The Quickiebomb Launcher" to "Weapons.QUICKIEBOMB_LAUNCHER",
			
			"Upgradeable TF_WEAPON_SYRINGEGUN_MEDIC" to "Weapons.STOCK_SYRINGE_GUN",
			"The Blutsauger" to "Weapons.BLUTSAUGER",
			"The Overdose" to "Weapons.OVERDOSE",
			
			"The Crusader's Crossbow" to "Weapons.CRUSADERS_CROSSBOW",
			"Festive Crusader's Crossbow" to "Weapons.CRUSADERS_CROSSBOW_FESTIVE",
			
			"The Dead Ringer" to "Weapons.DEAD_RINGER",
			"The Cloak and Dagger" to "Weapons.CLOAK_AND_DAGGER",
			
			"Upgradeable TF_WEAPON_INVIS" to "Weapons.STOCK_INVIS_WATCH",
			"The Quackenbirdt" to "Weapons.QUACKENBIRDT",
			
			"The Wrangler" to "Weapons.WRANGLER",
			"Festive Wrangler" to "Weapons.WRANGLER_FESTIVE",
			"The Giger Counter" to "Weapons.GIGER_COUNTER",
			
			"The Short Circuit" to "Weapons.SHORT_CIRCUIT",
			
			"Upgradeable TF_WEAPON_PISTOL" to "Weapons.STOCK_PISTOL",
			
			"TTG Max Pistol" to "Weapons.LUGERMORPH",
			"The C.A.P.P.E.R" to "Weapons.CAPPER",
			
			"The Red-Tape Recorder" to "Weapons.REDTAPE_RECORDER",
			"Promo Red-Tape Recorder" to "Weapons.REDTAPE_RECORDER_PROMO",
			"The Ap-Sap" to "Weapons.APSAP",
			"Festive Sapper" to "Weapons.STOCK_SAPPER_FESTIVE",
			"The Snack Attack" to "Weapons.SNACK_ATTACK",
			
			"Upgradeable TF_WEAPON_BUILDER_SPY" to "Weapons.STOCK_SAPPER",
			
			"Jarate" to "Weapons.JARATE",
			"Festive Jarate" to "Weapons.JARATE_FESTIVE",
			"The Self-Aware Beauty Mark" to "Weapons.SELFAWARE_BEAUTY_MARK",
			
			"Mad Milk" to "Weapons.MAD_MILK",
			"Mutated Milk" to "Weapons.MUTATED_MILK",
			
			"The Flying Guillotine" to "Weapons.FLYING_GUILLOTINE",
			"Promo Flying Guillotine" to "Weapons.FLYING_GUILLOTINE_PROMO",
			
			"The Gas Passer" to "Weapons.GAS_PASSER",
			
			"The Righteous Bison" to "Weapons.RIGHTEOUS_BISON",
			"The Pomson 6000" to "Weapons.POMSON_6000",
			
			"The Razorback" to "Weapons.RAZORBACK",
			
			"Upgradeable TF_WEAPON_SHOTGUN_PRIMARY" to "Weapons.STOCK_SHOTGUN",
			"The Reserve Shooter" to "Weapons.RESERVE_SHOOTER",
			"Festive Shotgun 2014" to "Weapons.STOCK_SHOTGUN_FESTIVE",
			"Panic Attack Shotgun" to "Weapons.PANIC_ATTACK_SHOTGUN",
			"The Frontier Justice" to "Weapons.FRONTIER_JUSTICE",
			
			"Festive Frontier Justice" to "Weapons.FRONTIER_JUSTICE_FESTIVE",
			"The Widowmaker" to "Weapons.WIDOWMAKER",
			"The Rescue Ranger" to "Weapons.RESCUE_RANGER",
			
			"The Family Business" to "Weapons.FAMILY_BUSINESS",
			
			"Upgradeable TF_WEAPON_MEDIGUN" to "Weapons.STOCK_MEDIGUN",
			"The Quick-Fix" to "Weapons.QUICKFIX",
			"Festive Medigun 2011" to "Weapons.STOCK_MEDIGUN_FESTIVE",
			"The Vaccinator" to "Weapons.VACCINATOR",
			"The Kritzkrieg" to "Weapons.KRITZKRIEG",
			
			"Upgradeable TF_WEAPON_SNIPERRIFLE" to "Weapons.STOCK_SNIPER_RIFLE",
			"Festive Sniper Rifle 2011" to "Weapons.STOCK_SNIPER_RIFLE_FESTIVE",
			"The Sydney Sleeper" to "Weapons.SYDNEY_SLEEPER",
			"The Machina" to "Weapons.MACHINA",
			"The Hitman's Heatmaker" to "Weapons.HITMANS_HEATMAKER",
			"The AWPer Hand" to "Weapons.AWPER_HAND",
			"Shooting Star" to "Weapons.SHOOTING_STAR",
			"The Bazaar Bargain" to "Weapons.BAZAAR_BARGAIN",
			"The Classic" to "Weapons.CLASSIC",
			
			"Upgradeable TF_WEAPON_SMG" to "Weapons.STOCK_SMG",
			"Festive SMG 2014" to "Weapons.STOCK_SMG_FESTIVE",
			"The Cleaner's Carbine" to "Weapons.CLEANERS_CARBINE",
			
			"Upgradeable TF_WEAPON_REVOLVER" to "Weapons.STOCK_REVOLVER",
			"Festive Revolver 2014" to "Weapons.STOCK_REVOLVER_FESTIVE",
			"L'Etranger" to "Weapons.LETRANGER",
			"The Enforcer" to "Weapons.ENFORCER",
			"The Diamondback" to "Weapons.DIAMONDBACK",
			"The Ambassador" to "Weapons.AMBASSADOR",
			"Festive Ambassador" to "Weapons.AMBASSADOR_FESTIVE",
			"TTG Sam Revolver" to "Weapons.BIG_KILL",
			
			"TF_WEAPON_PDA_SPY" to "Weapons.DISGUISE_KIT",
			
			"TF_WEAPON_BUILDER" to "Weapons.TOOLBOX",
			
			"Upgradeable TF_WEAPON_PDA_ENGINEER_BUILD" to "Weapons.BUILD_PDA_UNIQUE",
			
			"TF_WEAPON_PDA_ENGINEER_DESTROY" to "Weapons.DESTRUCTION_PDA",
			
			"TF_WEAPON_GRAPPLINGHOOK" to "Weapons.TF_WEAPON_GRAPPLINGHOOK",
		).run {
			val name = Weapons::class.qualifiedName!!.intern()
			map { VDFPrimitive(it.first) to Codegen.code(it.second, name) }
		}
	
	init {
		TFItem.CODEGEN.applyToContained {
			it.itemNameToTFItemInstance += x
		}
	}
}