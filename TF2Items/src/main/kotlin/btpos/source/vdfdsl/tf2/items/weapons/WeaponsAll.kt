package btpos.source.vdfdsl.tf2.items.weapons

import btpos.source.vdfdsl.tf2.items.TFItemFactory


object WeaponsAll {
	/**
	 * The grey "stock weapon" that exists when you don't have any other item in that slot.
	 */
	object TrueStock {
		/**
		 * The grey "stock weapon" that exists when you don't have any other item in that slot.
		 */
		val SMG = TFItemFactory.SMG("TF_WEAPON_SMG")
		/**
		 * The grey "stock weapon" that exists when you don't have any other item in that slot.
		 */
		val SHOTGUN_PRIMARY = TFItemFactory.SHOTGUN("TF_WEAPON_SHOTGUN_PRIMARY")
		/**
		 * The grey "stock weapon" that exists when you don't have any other item in that slot.
		 */
		val SHOTGUN_SOLDIER = TFItemFactory.SHOTGUN("TF_WEAPON_SHOTGUN_SOLDIER")
		/**
		 * The grey "stock weapon" that exists when you don't have any other item in that slot.
		 */
		val SHOTGUN_HWG = TFItemFactory.SHOTGUN("TF_WEAPON_SHOTGUN_HWG")
		/**
		 * The grey "stock weapon" that exists when you don't have any other item in that slot.
		 */
		val SHOTGUN_PYRO = TFItemFactory.SHOTGUN("TF_WEAPON_SHOTGUN_PYRO")
		
		/**
		 * The grey "stock weapon" that exists when you don't have any other item in that slot.
		 */
		val MEDIGUN = TFItemFactory.MEDIGUN("TF_WEAPON_MEDIGUN")
		/**
		 * The grey "stock weapon" that exists when you don't have any other item in that slot.
		 */
		val SYRINGEGUN_MEDIC = TFItemFactory.SYRINGE_GUN("TF_WEAPON_SYRINGEGUN_MEDIC")
		/**
		 * The grey "stock weapon" that exists when you don't have any other item in that slot.
		 */
		val BUILD_PDA = TFItemFactory.WEAPON_BASE("TF_WEAPON_PDA_ENGINEER_BUILD")
		/**
		 * The grey "stock weapon" that exists when you don't have any other item in that slot.
		 */
		val PISTOL = TFItemFactory.PISTOL("TF_WEAPON_PISTOL")
		/**
		 * The grey "stock weapon" that exists when you don't have any other item in that slot.
		 */
		val PISTOL_SCOUT = TFItemFactory.PISTOL("TF_WEAPON_PISTOL_SCOUT")
		/**
		 * The grey "stock weapon" that exists when you don't have any other item in that slot.
		 */
		val INVIS = TFItemFactory.INVIS("TF_WEAPON_INVIS")
		/**
		 * The grey "stock weapon" that exists when you don't have any other item in that slot.
		 */
		val REVOLVER = TFItemFactory.REVOLVER("TF_WEAPON_REVOLVER")
		/**
		 * The grey "stock weapon" that exists when you don't have any other item in that slot.
		 */
		val FIREAXE = TFItemFactory.FIRE_AXE("TF_WEAPON_FIREAXE")
		/**
		 * The grey "stock weapon" that exists when you don't have any other item in that slot.
		 */
		val FLAMETHROWER = TFItemFactory.FLAMETHROWER("TF_WEAPON_FLAMETHROWER")
		/**
		 * The grey "stock weapon" that exists when you don't have any other item in that slot.
		 */
		val STICKYBOMB_LAUNCHER = TFItemFactory.STICKYBOMB_LAUNCHER("TF_WEAPON_PIPEBOMBLAUNCHER")
		/**
		 * The grey "stock weapon" that exists when you don't have any other item in that slot.
		 */
		val GRENADELAUNCHER = TFItemFactory.GRENADE_LAUNCHER("TF_WEAPON_GRENADELAUNCHER")
		/**
		 * The grey "stock weapon" that exists when you don't have any other item in that slot.
		 */
		val ROCKETLAUNCHER = TFItemFactory.ROCKETLAUNCHER("TF_WEAPON_ROCKETLAUNCHER")
		/**
		 * The grey "stock weapon" that exists when you don't have any other item in that slot.
		 */
		val MINIGUN = TFItemFactory.MINIGUN("TF_WEAPON_MINIGUN")
		/**
		 * The grey "stock weapon" that exists when you don't have any other item in that slot.
		 */
		val SNIPERRIFLE = TFItemFactory.SNIPERRIFLE("TF_WEAPON_SNIPERRIFLE")
		/**
		 * The grey "stock weapon" that exists when you don't have any other item in that slot.
		 */
		val SCATTERGUN = TFItemFactory.SCATTERGUN("TF_WEAPON_SCATTERGUN")
		/**
		 * The grey "stock weapon" that exists when you don't have any other item in that slot.
		 */
		val BOTTLE = TFItemFactory.BOTTLE("TF_WEAPON_BOTTLE")
		/**
		 * The grey "stock weapon" that exists when you don't have any other item in that slot.
		 */
		val BONESAW = TFItemFactory.BONESAW("TF_WEAPON_BONESAW")
		/**
		 * The grey "stock weapon" that exists when you don't have any other item in that slot.
		 */
		val WRENCH = TFItemFactory.WRENCH("TF_WEAPON_WRENCH")
		/**
		 * The grey "stock weapon" that exists when you don't have any other item in that slot.
		 */
		val SHOVEL = TFItemFactory.SHOVEL("TF_WEAPON_SHOVEL")
		/**
		 * The grey "stock weapon" that exists when you don't have any other item in that slot.
		 */
		val FISTS = TFItemFactory.FISTS("TF_WEAPON_FISTS")
		/**
		 * The grey "stock weapon" that exists when you don't have any other item in that slot.
		 */
		val KUKRI = TFItemFactory.BASE_MELEE("TF_WEAPON_CLUB")
		/**
		 * The grey "stock weapon" that exists when you don't have any other item in that slot.
		 */
		val BAT = TFItemFactory.BAT("TF_WEAPON_BAT")
		
		/**
		 * The grey "stock weapon" that exists when you don't have any other item in that slot.
		 */
		val KNIFE = TFItemFactory.KNIFE("TF_WEAPON_KNIFE")
		
		/**
		 * Stock sapper. The grey "stock weapon" that exists when you don't have any other item in that slot.
		 */
		val SAPPER = TFItemFactory.BUILDER("TF_WEAPON_BUILDER_SPY")
		
	}
	
	
	/**
	 * A version of stock that can have qualities like "unique", "strange", "killstreak", etc.
	 *
	 * @see TrueStock
	 */
	val STOCK_FLAMETHROWER = TFItemFactory.FLAMETHROWER("Upgradeable TF_WEAPON_FLAMETHROWER")
	val STOCK_FLAMETHROWER_FESTIVE = TFItemFactory.FLAMETHROWER("Festive Flamethrower 2011")
	val BACKBURNER = TFItemFactory.FLAMETHROWER("The Backburner")
	val DEGREASER = TFItemFactory.FLAMETHROWER("The Degreaser")
	val PHLOGISTINATOR = TFItemFactory.FLAMETHROWER("The Phlogistinator")
	val RAINBLOWER = TFItemFactory.FLAMETHROWER("The Rainblower")
	
	object FlamethrowerBotkillers {
		val SILVER_BOTKILLER_FLAME_THROWER_MKI = TFItemFactory.FLAMETHROWER("Silver Botkiller Flame Thrower Mk.I")
		val GOLD_BOTKILLER_FLAME_THROWER_MKI = TFItemFactory.FLAMETHROWER("Gold Botkiller Flame Thrower Mk.I")
		val RUST_BOTKILLER_FLAME_THROWER_MKI = TFItemFactory.FLAMETHROWER("Rust Botkiller Flame Thrower Mk.I")
		val BLOOD_BOTKILLER_FLAME_THROWER_MKI = TFItemFactory.FLAMETHROWER("Blood Botkiller Flame Thrower Mk.I")
		val CARBONADO_BOTKILLER_FLAME_THROWER_MKI = TFItemFactory.FLAMETHROWER("Carbonado Botkiller Flame Thrower Mk.I")
		val DIAMOND_BOTKILLER_FLAME_THROWER_MKI = TFItemFactory.FLAMETHROWER("Diamond Botkiller Flame Thrower Mk.I")
		val SILVER_BOTKILLER_FLAME_THROWER_MKII = TFItemFactory.FLAMETHROWER("Silver Botkiller Flame Thrower Mk.II")
		val GOLD_BOTKILLER_FLAME_THROWER_MKII = TFItemFactory.FLAMETHROWER("Gold Botkiller Flame Thrower Mk.II")
	}
	val BACKBURNER_FESTIVE = TFItemFactory.FLAMETHROWER("Festive Backburner 2014")
	val NOSTROMO_NAPALMER = TFItemFactory.FLAMETHROWER("The Nostromo Napalmer")
	
	/**
	 * A version of stock that can have qualities like "unique", "strange", "killstreak", etc.
	 *
	 * @see TrueStock
	 */
	val STOCK_GRENADE_LAUNCHER = TFItemFactory.GRENADE_LAUNCHER("Upgradeable TF_WEAPON_GRENADELAUNCHER")
	val LOCHNLOAD = TFItemFactory.GRENADE_LAUNCHER("The Loch-n-Load")
	val GRENADE_LAUNCHER_FESTIVE = TFItemFactory.GRENADE_LAUNCHER("Festive Grenade Launcher")
	val IRON_BOMBER = TFItemFactory.GRENADE_LAUNCHER("The Iron Bomber")
	
	val LOOSE_CANNON = TFItemFactory.GRENADE_LAUNCHER("The Loose Cannon")
	val DRAGONS_FURY = TFItemFactory.ROCKETLAUNCHER("The Dragon's Fury")
	val THERMAL_THRUSTER = TFItemFactory.ROCKETPACK("The Thermal Thruster")
	val TF_WEAPON_GRAPPLINGHOOK = TFItemFactory.WEAPON_BASE("TF_WEAPON_GRAPPLINGHOOK")
	val DISGUISE_KIT = TFItemFactory.WEAPON_BASE("TF_WEAPON_PDA_SPY")
	val FLARE_GUN = TFItemFactory.FLARE_GUN("The Flare Gun")
	val DETONATOR = TFItemFactory.FLARE_GUN("The Detonator")
	val SCORCH_SHOT = TFItemFactory.FLARE_GUN("The Scorch Shot")
	val FLARE_GUN_FESTIVE = TFItemFactory.FLARE_GUN("Festive Flare Gun")
	val MANMELTER = TFItemFactory.FLARE_GUN("The Manmelter")
	val BUFF_BANNER = TFItemFactory.BUFF_ITEM("The Buff Banner")
	val BUFF_BANNER_FESTIVE = TFItemFactory.BUFF_ITEM("Festive Buff Banner")
	val BATTALIONS_BACKUP = TFItemFactory.BUFF_ITEM("The Battalion's Backup")
	val CONCHEROR = TFItemFactory.BUFF_ITEM("The Concheror")
	val BASE_JUMPER = TFItemFactory.PARACHUTE("The B.A.S.E. Jumper")
	
	/**
	 * A version of stock that can have qualities like "unique", "strange", "killstreak", etc.
	 *
	 * @see TrueStock.SMG
	 */
	val STOCK_SMG = TFItemFactory.SMG("Upgradeable TF_WEAPON_SMG")
	val STOCK_SMG_FESTIVE = TFItemFactory.SMG("Festive SMG 2014")
	val CLEANERS_CARBINE = TFItemFactory.CHARGED_SMG("The Cleaner's Carbine")
	
	
	val WINGER = TFItemFactory.SCOUT_PISTOL("The Winger")
	val PRETTY_BOYS_POCKET_PISTOL = TFItemFactory.SCOUT_PISTOL("Pretty Boy's Pocket Pistol")
	
	val THE_GUNBOATS = TFItemFactory.WEARABLE("The Gunboats")
	
	val THE_MANTREADS = TFItemFactory.WEARABLE("The Mantreads")
	
	/**
	 * A version of stock that can have qualities like "unique", "strange", "killstreak", etc.
	 *
	 * @see TrueStock
	 */
	val STOCK_SNIPER_RIFLE = TFItemFactory.SNIPERRIFLE("Upgradeable TF_WEAPON_SNIPERRIFLE")
	val SYDNEY_SLEEPER = TFItemFactory.SNIPERRIFLE("The Sydney Sleeper")
	val MACHINA = TFItemFactory.SNIPERRIFLE("The Machina")
	val STOCK_SNIPER_RIFLE_FESTIVE = TFItemFactory.SNIPERRIFLE("Festive Sniper Rifle 2011")
	val HITMANS_HEATMAKER = TFItemFactory.SNIPERRIFLE("The Hitman's Heatmaker")
	val AWPER_HAND = TFItemFactory.SNIPERRIFLE("The AWPer Hand")
	object SniperRifleBotkillers {
		val SILVER_BOTKILLER_SNIPER_RIFLE_MKI = TFItemFactory.SNIPERRIFLE("Silver Botkiller Sniper Rifle Mk.I")
		val GOLD_BOTKILLER_SNIPER_RIFLE_MKI = TFItemFactory.SNIPERRIFLE("Gold Botkiller Sniper Rifle Mk.I")
		val RUST_BOTKILLER_SNIPER_RIFLE_MKI = TFItemFactory.SNIPERRIFLE("Rust Botkiller Sniper Rifle Mk.I")
		val BLOOD_BOTKILLER_SNIPER_RIFLE_MKI = TFItemFactory.SNIPERRIFLE("Blood Botkiller Sniper Rifle Mk.I")
		val CARBONADO_BOTKILLER_SNIPER_RIFLE_MKI = TFItemFactory.SNIPERRIFLE("Carbonado Botkiller Sniper Rifle Mk.I")
		val DIAMOND_BOTKILLER_SNIPER_RIFLE_MKI = TFItemFactory.SNIPERRIFLE("Diamond Botkiller Sniper Rifle Mk.I")
		val SILVER_BOTKILLER_SNIPER_RIFLE_MKII = TFItemFactory.SNIPERRIFLE("Silver Botkiller Sniper Rifle Mk.II")
		val GOLD_BOTKILLER_SNIPER_RIFLE_MKII = TFItemFactory.SNIPERRIFLE("Gold Botkiller Sniper Rifle Mk.II")
	}
	val SHOOTING_STAR = TFItemFactory.SNIPERRIFLE("Shooting Star")
	
	val BAZAAR_BARGAIN = TFItemFactory.SNIPERRIFLE("The Bazaar Bargain")
	
	val CLASSIC = TFItemFactory.SNIPERRIFLE("The Classic")
	val HUNTSMAN = TFItemFactory.COMPOUND_BOW("The Huntsman")
	val HUNTSMAN_FESTIVE = TFItemFactory.COMPOUND_BOW("Festive Huntsman")
	val FORTIFIED_COMPOUND = TFItemFactory.COMPOUND_BOW("The Fortified Compound")
	
	val BONK_ATOMIC_PUNCH = TFItemFactory.LUNCHBOX("Bonk! Atomic Punch")
	val CRITACOLA = TFItemFactory.LUNCHBOX("Crit-a-Cola")
	val BONK_FESTIVE = TFItemFactory.LUNCHBOX("Festive Bonk 2014")
	
	val THE_CHARGIN_TARGE = TFItemFactory.WEARABLE_DEMOSHIELD("The Chargin' Targe")
	val THE_SPLENDID_SCREEN = TFItemFactory.WEARABLE_DEMOSHIELD("The Splendid Screen")
	val THE_TIDE_TURNER = TFItemFactory.WEARABLE_DEMOSHIELD("The Tide Turner")
	val FESTIVE_TARGE_2014 = TFItemFactory.WEARABLE_DEMOSHIELD("Festive Targe 2014")
	
	val ALI_BABAS_WEE_BOOTIES = TFItemFactory.WEARABLE("Ali Baba's Wee Booties")
	val THE_BOOTLEGGER = TFItemFactory.WEARABLE("The Bootlegger")
	
	/**
	 * A version of stock that can have qualities like "unique", "strange", "killstreak", etc.
	 *
	 * @see TrueStock.STICKYBOMB_LAUNCHER
	 */
	val STOCK_STICKYBOMB_LAUNCHER = TFItemFactory.STICKYBOMB_LAUNCHER("Upgradeable TF_WEAPON_PIPEBOMBLAUNCHER")
	
	val STICKYBOMB_LAUNCHER_FESTIVE = TFItemFactory.STICKYBOMB_LAUNCHER("Festive Stickybomb Launcher 2011")
	
	
	val SCOTTISH_RESISTANCE = TFItemFactory.STICKYBOMB_LAUNCHER("The Scottish Resistance")
	
	val STICKYBOMB_JUMPER = TFItemFactory.STICKYBOMB_LAUNCHER("Stickybomb Jumper")
	
	object StickybombLauncherBotkillers {
		val SILVER_BOTKILLER_STICKYBOMB_LAUNCHER_MKI = TFItemFactory.STICKYBOMB_LAUNCHER("Silver Botkiller Stickybomb Launcher Mk.I")
		val GOLD_BOTKILLER_STICKYBOMB_LAUNCHER_MKI = TFItemFactory.STICKYBOMB_LAUNCHER("Gold Botkiller Stickybomb Launcher Mk.I")
		val RUST_BOTKILLER_STICKYBOMB_LAUNCHER_MKI = TFItemFactory.STICKYBOMB_LAUNCHER("Rust Botkiller Stickybomb Launcher Mk.I")
		val BLOOD_BOTKILLER_STICKYBOMB_LAUNCHER_MKI = TFItemFactory.STICKYBOMB_LAUNCHER("Blood Botkiller Stickybomb Launcher Mk.I")
		val CARBONADO_BOTKILLER_STICKYBOMB_LAUNCHER_MKI = TFItemFactory.STICKYBOMB_LAUNCHER("Carbonado Botkiller Stickybomb Launcher Mk.I")
		val DIAMOND_BOTKILLER_STICKYBOMB_LAUNCHER_MKI = TFItemFactory.STICKYBOMB_LAUNCHER("Diamond Botkiller Stickybomb Launcher Mk.I")
		val SILVER_BOTKILLER_STICKYBOMB_LAUNCHER_MKII = TFItemFactory.STICKYBOMB_LAUNCHER("Silver Botkiller Stickybomb Launcher Mk.II")
		val GOLD_BOTKILLER_STICKYBOMB_LAUNCHER_MKII = TFItemFactory.STICKYBOMB_LAUNCHER("Gold Botkiller Stickybomb Launcher Mk.II")
	}
	
	val QUICKIEBOMB_LAUNCHER = TFItemFactory.STICKYBOMB_LAUNCHER("The Quickiebomb Launcher")
	
	
	val BLUTSAUGER = TFItemFactory.SYRINGE_GUN("The Blutsauger")
	/**
	 * A version of stock that can have qualities like "unique", "strange", "killstreak", etc.
	 *
	 * @see btpos.source.vdfdsl.types.items.AllWeapons.TrueStock.SYRINGEGUN_MEDIC
	 */
	val STOCK_SYRINGE_GUN = TFItemFactory.SYRINGE_GUN("Upgradeable TF_WEAPON_SYRINGEGUN_MEDIC")
	val OVERDOSE = TFItemFactory.SYRINGE_GUN("The Overdose")
	
	val CRUSADERS_CROSSBOW = TFItemFactory.CROSSBOW("The Crusader's Crossbow")
	val CRUSADERS_CROSSBOW_FESTIVE = TFItemFactory.CROSSBOW("Festive Crusader's Crossbow")
	
	val DEAD_RINGER = TFItemFactory.INVIS("The Dead Ringer")
	val CLOAK_AND_DAGGER = TFItemFactory.INVIS("The Cloak and Dagger")
	/**
	 * A version of stock that can have qualities like "unique", "strange", "killstreak", etc.
	 *
	 * @see TrueStock
	 */
	val STOCK_INVIS_WATCH = TFItemFactory.INVIS("Upgradeable TF_WEAPON_INVIS")
	val QUACKENBIRDT = TFItemFactory.INVIS("The Quackenbirdt")
	val TF_WEAPON_BUILDER = TFItemFactory.BUILDER("TF_WEAPON_BUILDER")
	
	val WRANGLER = TFItemFactory.BASE_GUN("The Wrangler")
	val WRANGLER_FESTIVE = TFItemFactory.BASE_GUN("Festive Wrangler")
	val GIGER_COUNTER = TFItemFactory.BASE_GUN("The Giger Counter")
	
	val SHORT_CIRCUIT = TFItemFactory.MECHANICAL_ARM("The Short Circuit")
	/**
	 * A version of stock that can have qualities like "unique", "strange", "killstreak", etc.
	 *
	 * @see btpos.source.vdfdsl.types.items.weapons.TrueStock
	 */
	val STOCK_PISTOL = TFItemFactory.PISTOL("Upgradeable TF_WEAPON_PISTOL")
	
	val LUGERMORPH = TFItemFactory.PISTOL("TTG Max Pistol")
	val CAPPER = TFItemFactory.PISTOL("The C.A.P.P.E.R")
	
	val REDTAPE_RECORDER = TFItemFactory.SAPPER("The Red-Tape Recorder")
	val REDTAPE_RECORDER_PROMO = TFItemFactory.SAPPER("Promo Red-Tape Recorder")
	val APSAP = TFItemFactory.SAPPER("The Ap-Sap")
	val STOCK_SAPPER_FESTIVE = TFItemFactory.SAPPER("Festive Sapper")
	val SNACK_ATTACK = TFItemFactory.SAPPER("The Snack Attack")
	/**
	 * A version of stock that can have qualities like "unique", "strange", "killstreak", etc.
	 *
	 * @see btpos.source.vdfdsl.types.items.AllWeapons.TrueStock.SAPPER
	 */
	val STOCK_SAPPER = TFItemFactory.BUILDER("Upgradeable TF_WEAPON_BUILDER_SPY")
	
	val JARATE = TFItemFactory.JAR("Jarate")
	val JARATE_FESTIVE = TFItemFactory.JAR("Festive Jarate")
	val SELFAWARE_BEAUTY_MARK = TFItemFactory.JAR("The Self-Aware Beauty Mark")
	
	val MAD_MILK = TFItemFactory.JAR("Mad Milk")
	val MUTATED_MILK = TFItemFactory.JAR("Mutated Milk")
	
	val FLYING_GUILLOTINE = TFItemFactory.JAR("The Flying Guillotine")
	val FLYING_GUILLOTINE_PROMO = TFItemFactory.JAR("Promo Flying Guillotine")
	
	val GAS_PASSER = TFItemFactory.JAR("The Gas Passer")
	
	val SANDVICH = TFItemFactory.LUNCHBOX("The Sandvich")
	val DALOKOHS_BAR = TFItemFactory.LUNCHBOX("The Dalokohs Bar")
	val BUFFALO_STEAK_SANDVICH = TFItemFactory.LUNCHBOX("The Buffalo Steak Sandvich")
	val FISHCAKE = TFItemFactory.LUNCHBOX("Fishcake")
	val ROBOSANDVICH = TFItemFactory.LUNCHBOX("The Robo-Sandvich")
	val SANDVICH_FESTIVE = TFItemFactory.LUNCHBOX("Festive Sandvich")
	val SECOND_BANANA = TFItemFactory.LUNCHBOX("The Second Banana")
	val RIGHTEOUS_BISON = TFItemFactory.RAYGUN("The Righteous Bison")
	val POMSON_6000 = TFItemFactory.RAYGUN("The Pomson 6000")
	
	
	
	/**
	 * A version of stock that can have qualities like "unique", "strange", "killstreak", etc.
	 *
	 * @see TrueStock
	 */
	val STOCK_SHOTGUN = TFItemFactory.SHOTGUN("Upgradeable TF_WEAPON_SHOTGUN_PRIMARY")
	val RESERVE_SHOOTER = TFItemFactory.SHOTGUN("The Reserve Shooter")
	val STOCK_SHOTGUN_FESTIVE = TFItemFactory.SHOTGUN("Festive Shotgun 2014")
	val PANIC_ATTACK_SHOTGUN = TFItemFactory.SHOTGUN("Panic Attack Shotgun")
	val FRONTIER_JUSTICE = TFItemFactory.SHOTGUN_REVENGE("The Frontier Justice")
	
	val FRONTIER_JUSTICE_FESTIVE = TFItemFactory.SHOTGUN_REVENGE("Festive Frontier Justice")
	val WIDOWMAKER = TFItemFactory.SHOTGUN("The Widowmaker")
	val RESCUE_RANGER = TFItemFactory.SHOTGUN("The Rescue Ranger")
	
	val FAMILY_BUSINESS = TFItemFactory.SHOTGUN("The Family Business")
	val FORCEANATURE = TFItemFactory.SCATTERGUN("The Force-a-Nature")
	/**
	 * A version of stock that can have qualities like "unique", "strange", "killstreak", etc.
	 *
	 * @see TrueStock
	 */
	val STOCK_SCATTERGUN = TFItemFactory.SCATTERGUN("Upgradeable TF_WEAPON_SCATTERGUN")
	val STOCK_SCATTERGUN_FESTIVE = TFItemFactory.SCATTERGUN("Festive Scattergun 2011")
	object ScattergunBotkillers {
		val SILVER_BOTKILLER_SCATTERGUN_MKI = TFItemFactory.SCATTERGUN("Silver Botkiller Scattergun Mk.I")
		val GOLD_BOTKILLER_SCATTERGUN_MKI = TFItemFactory.SCATTERGUN("Gold Botkiller Scattergun Mk.I")
		val RUST_BOTKILLER_SCATTERGUN_MKI = TFItemFactory.SCATTERGUN("Rust Botkiller Scattergun Mk.I")
		val BLOOD_BOTKILLER_SCATTERGUN_MKI = TFItemFactory.SCATTERGUN("Blood Botkiller Scattergun Mk.I")
		val CARBONADO_BOTKILLER_SCATTERGUN_MKI = TFItemFactory.SCATTERGUN("Carbonado Botkiller Scattergun Mk.I")
		val DIAMOND_BOTKILLER_SCATTERGUN_MKI = TFItemFactory.SCATTERGUN("Diamond Botkiller Scattergun Mk.I")
		val SILVER_BOTKILLER_SCATTERGUN_MKII = TFItemFactory.SCATTERGUN("Silver Botkiller Scattergun Mk.II")
		val GOLD_BOTKILLER_SCATTERGUN_MKII = TFItemFactory.SCATTERGUN("Gold Botkiller Scattergun Mk.II")
	}
	val FORCEANATURE_FESTIVE = TFItemFactory.SCATTERGUN("Festive Force-a-Nature")
	val BACK_SCATTER = TFItemFactory.SCATTERGUN("The Back Scatter")
	
	val SHORTSTOP = TFItemFactory.SCOUT_PISTOL("The Shortstop")
	
	val SODA_POPPER = TFItemFactory.SCATTERGUN("The Soda Popper")
	val BABY_FACES_BLASTER = TFItemFactory.SCATTERGUN("Baby Face's Blaster")
	
	val KRITZKRIEG = TFItemFactory.MEDIGUN("The Kritzkrieg")
	/**
	 * A version of stock that can have qualities like "unique", "strange", "killstreak", etc.
	 *
	 * @see TrueStock
	 */
	val STOCK_MEDIGUN = TFItemFactory.MEDIGUN("Upgradeable TF_WEAPON_MEDIGUN")
	val QUICKFIX = TFItemFactory.MEDIGUN("The Quick-Fix")
	val STOCK_MEDIGUN_FESTIVE = TFItemFactory.MEDIGUN("Festive Medigun 2011")
	object MedigunBotkillers {
		val SILVER_BOTKILLER_MEDI_GUN_MKI = TFItemFactory.MEDIGUN("Silver Botkiller Medi Gun Mk.I")
		val GOLD_BOTKILLER_MEDI_GUN_MKI = TFItemFactory.MEDIGUN("Gold Botkiller Medi Gun Mk.I")
		val RUST_BOTKILLER_MEDI_GUN_MKI = TFItemFactory.MEDIGUN("Rust Botkiller Medi Gun Mk.I")
		val BLOOD_BOTKILLER_MEDI_GUN_MKI = TFItemFactory.MEDIGUN("Blood Botkiller Medi Gun Mk.I")
		val CARBONADO_BOTKILLER_MEDI_GUN_MKI = TFItemFactory.MEDIGUN("Carbonado Botkiller Medi Gun Mk.I")
		val DIAMOND_BOTKILLER_MEDI_GUN_MKI = TFItemFactory.MEDIGUN("Diamond Botkiller Medi Gun Mk.I")
		val SILVER_BOTKILLER_MEDI_GUN_MKII = TFItemFactory.MEDIGUN("Silver Botkiller Medi Gun Mk.II")
		val GOLD_BOTKILLER_MEDI_GUN_MKII = TFItemFactory.MEDIGUN("Gold Botkiller Medi Gun Mk.II")
	}
	val VACCINATOR = TFItemFactory.MEDIGUN("The Vaccinator")
	
	
	val NATASCHA = TFItemFactory.MINIGUN("Natascha")
	/**
	 * A version of stock that can have qualities like "unique", "strange", "killstreak", etc.
	 *
	 * @see TrueStock
	 */
	val STOCK_MINIGUN = TFItemFactory.MINIGUN("Upgradeable TF_WEAPON_MINIGUN")
	val BRASS_BEAST = TFItemFactory.MINIGUN("The Brass Beast")
	val TOMISLAV = TFItemFactory.MINIGUN("Tomislav")
	val STOCK_MINIGUN_FESTIVE = TFItemFactory.MINIGUN("Festive Minigun 2011")
	val HUO_LONG_HEATMAKER = TFItemFactory.MINIGUN("The Huo Long Heatmaker")
	val HUO_LONG_HEATMAKER_PROMO = TFItemFactory.MINIGUN("Promo Huo Long Heatmaker")
	
	/**
	 * Given to MvM Deflector Heavies.
	 */
	val DEFLECTOR_MVM = TFItemFactory.MINIGUN("Deflector")
	object MinigunBotkillers {
		val SILVER_BOTKILLER_MINIGUN_MKI = TFItemFactory.MINIGUN("Silver Botkiller Minigun Mk.I")
		val GOLD_BOTKILLER_MINIGUN_MKI = TFItemFactory.MINIGUN("Gold Botkiller Minigun Mk.I")
		val RUST_BOTKILLER_MINIGUN_MKI = TFItemFactory.MINIGUN("Rust Botkiller Minigun Mk.I")
		val BLOOD_BOTKILLER_MINIGUN_MKI = TFItemFactory.MINIGUN("Blood Botkiller Minigun Mk.I")
		val CARBONADO_BOTKILLER_MINIGUN_MKI = TFItemFactory.MINIGUN("Carbonado Botkiller Minigun Mk.I")
		val DIAMOND_BOTKILLER_MINIGUN_MKI = TFItemFactory.MINIGUN("Diamond Botkiller Minigun Mk.I")
		val SILVER_BOTKILLER_MINIGUN_MKII = TFItemFactory.MINIGUN("Silver Botkiller Minigun Mk.II")
		val GOLD_BOTKILLER_MINIGUN_MKII = TFItemFactory.MINIGUN("Gold Botkiller Minigun Mk.II")
	}
	
	/**
	 * A version of stock that can have qualities like "unique", "strange", "killstreak", etc.
	 *
	 * @see TrueStock.BUILD_PDA
	 */
	val BUILD_PDA_UNIQUE = TFItemFactory.WEAPON_BASE("Upgradeable TF_WEAPON_PDA_ENGINEER_BUILD")
	
	/**
	 * The grey "stock weapon" that exists when you don't have any other item in that slot.
	 *
	 * Since Engineer does not have a strange "destruction PDA", this is the only version of it that exists.
	 */
	val DESTRUCTION_PDA = TFItemFactory.WEAPON_BASE("TF_WEAPON_PDA_ENGINEER_DESTROY")
	
	
	val AMBASSADOR = TFItemFactory.REVOLVER("The Ambassador")
	val BIG_KILL = TFItemFactory.REVOLVER("TTG Sam Revolver")
	/**
	 * A version of stock that can have qualities like "unique", "strange", "killstreak", etc.
	 *
	 * @see TrueStock
	 */
	val STOCK_REVOLVER = TFItemFactory.REVOLVER("Upgradeable TF_WEAPON_REVOLVER")
	val LETRANGER = TFItemFactory.REVOLVER("L'Etranger")
	val ENFORCER = TFItemFactory.REVOLVER("The Enforcer")
	val DIAMONDBACK = TFItemFactory.REVOLVER("The Diamondback")
	val AMBASSADOR_FESTIVE = TFItemFactory.REVOLVER("Festive Ambassador")
	val STOCK_REVOLVER_FESTIVE = TFItemFactory.REVOLVER("Festive Revolver 2014")
	
	
	/**
	 * A version of stock that can have qualities like "unique", "strange", "killstreak", etc.
	 *
	 * @see TrueStock
	 */
	val STOCK_ROCKET_LAUNCHER = TFItemFactory.ROCKETLAUNCHER("Upgradeable TF_WEAPON_ROCKETLAUNCHER")
	val BLACK_BOX = TFItemFactory.ROCKETLAUNCHER("The Black Box")
	val ROCKET_JUMPER = TFItemFactory.ROCKETLAUNCHER("Rocket Jumper")
	val LIBERTY_LAUNCHER = TFItemFactory.ROCKETLAUNCHER("The Liberty Launcher")
	val ORIGINAL = TFItemFactory.ROCKETLAUNCHER("The Original")
	val STOCK_ROCKET_LAUNCHER_FESTIVE = TFItemFactory.ROCKETLAUNCHER("Festive Rocket Launcher 2011")
	val BEGGARS_BAZOOKA = TFItemFactory.ROCKETLAUNCHER("The Beggar's Bazooka")
	
	val BLACK_BOX_FESTIVE = TFItemFactory.ROCKETLAUNCHER("Festive Black Box")
	val DIRECT_HIT = TFItemFactory.ROCKETLAUNCHER("The Direct Hit")
	val COW_MANGLER_5000 = TFItemFactory.ROCKETLAUNCHER("The Cow Mangler 5000")
	val AIR_STRIKE = TFItemFactory.ROCKETLAUNCHER_AIRSTRIKE("The Air Strike")
	
	
	object RocketLauncherBotkillers {
		val SILVER_BOTKILLER_ROCKET_LAUNCHER_MKI = TFItemFactory.ROCKETLAUNCHER("Silver Botkiller Rocket Launcher Mk.I")
		val GOLD_BOTKILLER_ROCKET_LAUNCHER_MKI = TFItemFactory.ROCKETLAUNCHER("Gold Botkiller Rocket Launcher Mk.I")
		val RUST_BOTKILLER_ROCKET_LAUNCHER_MKI = TFItemFactory.ROCKETLAUNCHER("Rust Botkiller Rocket Launcher Mk.I")
		val BLOOD_BOTKILLER_ROCKET_LAUNCHER_MKI = TFItemFactory.ROCKETLAUNCHER("Blood Botkiller Rocket Launcher Mk.I")
		val CARBONADO_BOTKILLER_ROCKET_LAUNCHER_MKI = TFItemFactory.ROCKETLAUNCHER("Carbonado Botkiller Rocket Launcher Mk.I")
		val DIAMOND_BOTKILLER_ROCKET_LAUNCHER_MKI = TFItemFactory.ROCKETLAUNCHER("Diamond Botkiller Rocket Launcher Mk.I")
		val SILVER_BOTKILLER_ROCKET_LAUNCHER_MKII = TFItemFactory.ROCKETLAUNCHER("Silver Botkiller Rocket Launcher Mk.II")
		val GOLD_BOTKILLER_ROCKET_LAUNCHER_MKII = TFItemFactory.ROCKETLAUNCHER("Gold Botkiller Rocket Launcher Mk.II")
	}
}