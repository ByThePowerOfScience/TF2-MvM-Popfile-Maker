package btpos.source.vdfdsl.tf2.items

import btpos.source.vdfdsl.tf2.itemattributes.*
import btpos.source.vdfdsl.modeling.*
import btpos.source.vdfdsl.serialization.codecs.*
import btpos.source.vdfdsl.tf2.itemattributes.impl.*
import btpos.source.vdfdsl.tf2.tftypes.*
import java.util.*
import kotlin.time.Duration

object TFItemFactories {
	@JvmField val BASEENTITY = TFItemFactory(BaseEntityAttributes)

	@JvmField val BASEPROJECTILE = TFItemFactory(BaseProjectileAttributes)

	@JvmField val BASEGRENADEPROJECTILE = TFItemFactory(BaseGrenadeProjectileAttributes)

	@JvmField val PLAYER = TFItemFactory(PlayerAttributes)

	@JvmField val BASEROCKET = TFItemFactory(BaseRocketAttributes)

	@JvmField val PROJECTILEFLARE = TFItemFactory(ProjectileFlareAttributes)

	@JvmField val PROJECTILEENERGYRING = TFItemFactory(ProjectileEnergyRingAttributes)

	@JvmField val PROJECTILESTICKYBOMB = TFItemFactory(ProjectileStickybombAttributes)

	@JvmField val ECONENTITY = TFItemFactory(EconEntityAttributes)

	@JvmField val PROJECTILESYRINGE = TFItemFactory(ProjectileSyringeAttributes)

	@JvmField val BASECOMBATWEAPON = TFItemFactory(BaseCombatWeaponAttributes)

	@JvmField val WEARABLE = TFItemFactory(WearableAttributes)

	@JvmField val MVMBOT = TFItemFactory(MvMBotAttributes)

	@JvmField val PROJECTILEROCKET = TFItemFactory(ProjectileRocketAttributes)

	@JvmField val PROJECTILEARROW = TFItemFactory(ProjectileArrowAttributes)

	@JvmField val PROJECTILEJAR = TFItemFactory(ProjectileJarAttributes)

	@JvmField val PROJECTILEENERGYBALL = TFItemFactory(ProjectileEnergyBallAttributes)

	@JvmField val WEAPONBASE = TFItemFactory(WeaponBaseAttributes)

	@JvmField val WEARABLEDEMOSHIELD = TFItemFactory(WearableDemoShieldAttributes)

	@JvmField val POWERUPBOTTLE = TFItemFactory(PowerUpBottleAttributes)

	@JvmField val WEARABLERAZORBACK = TFItemFactory(WearableRazorbackAttributes)

	@JvmField val WEARABLEROBOTARM = TFItemFactory(WearableRobotArmAttributes)

	@JvmField val PROJECTILEHEALINGBOLT = TFItemFactory(ProjectileHealingBoltAttributes)

	@JvmField val PROJECTILESPELLFIREBALL = TFItemFactory(ProjectileSpellFireballAttributes)

	@JvmField val PDAEXPANSIONTELEPORTER = TFItemFactory(PDAExpansionTeleporterAttributes)

	@JvmField val PROJECTILESPELLBATS = TFItemFactory(ProjectileSpellBatsAttributes)

	@JvmField val PDAEXPANSIONDISPENSER = TFItemFactory(PDAExpansionDispenserAttributes)

	@JvmField val PROJECTILEGRAPPLINGHOOK = TFItemFactory(ProjectileGrapplingHookAttributes)

	@JvmField val PROJECTILEDRAGONSFURY = TFItemFactory(ProjectileDragonsFuryAttributes)

	@JvmField val PROJECTILEMECHANICALARMORB = TFItemFactory(ProjectileMechanicalArmOrbAttributes)

	@JvmField val PROJECTILECLEAVER = TFItemFactory(ProjectileCleaverAttributes)

	@JvmField val PROJECTILESENTRYROCKET = TFItemFactory(ProjectileSentryRocketAttributes)

	@JvmField val PROJECTILEJARMILK = TFItemFactory(ProjectileJarMilkAttributes)

	@JvmField val WEARABLECAMPAIGNITEM = TFItemFactory(WearableCampaignItemAttributes)

	@JvmField val WEARABLEVM = TFItemFactory(WearableVMAttributes)

	@JvmField val WEARABLELEVELABLEITEM = TFItemFactory(WearableLevelableItemAttributes)

	@JvmField val BASEGUN = TFItemFactory(BaseGunAttributes)

	@JvmField val BASEMELEE = TFItemFactory(BaseMeleeAttributes)

	@JvmField val INVIS = TFItemFactory(InvisAttributes)

	@JvmField val LUNCHBOX = TFItemFactory(LunchboxAttributes)

	@JvmField val BUILDER = TFItemFactory(BuilderAttributes)

	@JvmField val PROJECTILEGRENADE = TFItemFactory(ProjectileGrenadeAttributes)

	@JvmField val PROJECTILESPELLLIGHTNINGORB = TFItemFactory(ProjectileSpellLightningOrbAttributes)

	@JvmField val PROJECTILESPELLSPAWNHORDE = TFItemFactory(ProjectileSpellSpawnHordeAttributes)

	@JvmField val PROJECTILESPELLMIRV = TFItemFactory(ProjectileSpellMirvAttributes)

	@JvmField val PROJECTILESPELLTRANSPOSETELEPORT = TFItemFactory(ProjectileSpellTransposeTeleportAttributes)

	@JvmField val PROJECTILESPELLMETEORSHOWER = TFItemFactory(ProjectileSpellMeteorShowerAttributes)

	@JvmField val PASSTIMEGUN = TFItemFactory(PassTimeGunAttributes)

	@JvmField val PROJECTILESPELLSPAWNBOSS = TFItemFactory(ProjectileSpellSpawnBossAttributes)

	@JvmField val WEAPONBASEGRENADE = TFItemFactory(WeaponBaseGrenadeAttributes)

	@JvmField val PROJECTILESPELLPUMPKIN = TFItemFactory(ProjectileSpellPumpkinAttributes)

	@JvmField val PROJECTILESPELLSPAWNZOMBIE = TFItemFactory(ProjectileSpellSpawnZombieAttributes)

	@JvmField val PROJECTILESPELLKARTBATS = TFItemFactory(ProjectileSpellKartBatsAttributes)

	@JvmField val PDA = TFItemFactory(PDAAttributes)

	@JvmField val FLAMETHROWER = TFItemFactory(FlamethrowerAttributes)

	@JvmField val SMG = TFItemFactory(SMGAttributes)

	@JvmField val SAPPER = TFItemFactory(SapperAttributes)

	@JvmField val FISTS = TFItemFactory(FistsAttributes)

	@JvmField val SHOVEL = TFItemFactory(ShovelAttributes)

	@JvmField val FIREAXE = TFItemFactory(FireAxeAttributes)

	@JvmField val BONESAW = TFItemFactory(BonesawAttributes)

	@JvmField val MINIGUN = TFItemFactory(MinigunAttributes)

	@JvmField val PISTOL = TFItemFactory(PistolAttributes)

	@JvmField val REVOLVER = TFItemFactory(RevolverAttributes)

	@JvmField val SYRINGEGUN = TFItemFactory(SyringeGunAttributes)

	@JvmField val ROCKETPACK = TFItemFactory(RocketPackAttributes)

	@JvmField val STICKYBOMBLAUNCHER = TFItemFactory(StickybombLauncherAttributes)

	@JvmField val BUFFITEM = TFItemFactory(BuffItemAttributes)

	@JvmField val WRENCH = TFItemFactory(WrenchAttributes)

	@JvmField val ROCKETLAUNCHER = TFItemFactory(RocketLauncherAttributes)

	@JvmField val GRENADELAUNCHER = TFItemFactory(GrenadeLauncherAttributes)

	@JvmField val SHOTGUN = TFItemFactory(ShotgunAttributes)

	@JvmField val KNIFE = TFItemFactory(KnifeAttributes)

	@JvmField val SWORD = TFItemFactory(SwordAttributes)

	@JvmField val FLAREGUN = TFItemFactory(FlareGunAttributes)

	@JvmField val JAR = TFItemFactory(JarAttributes)

	@JvmField val MECHANICALARM = TFItemFactory(MechanicalArmAttributes)

	@JvmField val SNIPERRIFLE = TFItemFactory(SniperRifleAttributes)

	@JvmField val MEDIGUN = TFItemFactory(MedigunAttributes)

	@JvmField val BAT = TFItemFactory(BatAttributes)

	@JvmField val NAILGUN = TFItemFactory(NailgunAttributes)

	@JvmField val PDAENGINEERDESTROY = TFItemFactory(PDAEngineerDestroyAttributes)

	@JvmField val PROJECTILESPELLKARTPUMPKIN = TFItemFactory(ProjectileSpellKartPumpkinAttributes)

	@JvmField val GRENADEHEAL = TFItemFactory(GrenadeHealAttributes)

	@JvmField val TRANQ = TFItemFactory(TranqAttributes)

	@JvmField val GRENADEMIRV = TFItemFactory(GrenadeMirvAttributes)

	@JvmField val BREAKABLEMELEE = TFItemFactory(BreakableMeleeAttributes)

	@JvmField val FLAG = TFItemFactory(FlagAttributes)

	@JvmField val PDASPY = TFItemFactory(PDASpyAttributes)

	@JvmField val PDAENGINEERBUILD = TFItemFactory(PDAEngineerBuildAttributes)

	@JvmField val BOOMERANG = TFItemFactory(BoomerangAttributes)

	@JvmField val GRENADENAIL = TFItemFactory(GrenadeNailAttributes)

	@JvmField val SLAP = TFItemFactory(SlapAttributes)

	@JvmField val GRENADECALTROP = TFItemFactory(GrenadeCaltropAttributes)

	@JvmField val GRENADESMOKEBOMB = TFItemFactory(GrenadeSmokeBombAttributes)

	@JvmField val CLUB = TFItemFactory(ClubAttributes)

	@JvmField val LUNCHBOXDRINK = TFItemFactory(LunchboxDrinkAttributes)

	@JvmField val GRENADENAPALM = TFItemFactory(GrenadeNapalmAttributes)

	@JvmField val GRENADEEMP = TFItemFactory(GrenadeEMPAttributes)

	@JvmField val GRENADEGAS = TFItemFactory(GrenadeGasAttributes)

	@JvmField val GRENADENORMAL = TFItemFactory(GrenadeNormalAttributes)

	@JvmField val LASERPOINTER = TFItemFactory(LaserPointerAttributes)

	@JvmField val PROJECTILESPELLKARTMIRV = TFItemFactory(ProjectileSpellKartMirvAttributes)

	@JvmField val CROWBAR = TFItemFactory(CrowbarAttributes)

	@JvmField val CHARGEDSMG = TFItemFactory(ChargedSMGAttributes)

	@JvmField val STICKBOMB = TFItemFactory(StickBombAttributes)

	@JvmField val SCOUTPISTOL = TFItemFactory(ScoutPistolAttributes)

	@JvmField val ROCKETLAUNCHER_AIRSTRIKE = TFItemFactory(RocketLauncher_AirStrikeAttributes)

	@JvmField val CROSSBOW = TFItemFactory(CrossbowAttributes)

	@JvmField val RAYGUN = TFItemFactory(RayGunAttributes)

	@JvmField val SHOTGUNREVENGE = TFItemFactory(ShotgunRevengeAttributes)

	@JvmField val SCATTERGUN = TFItemFactory(ScattergunAttributes)

	@JvmField val THROWABLE = TFItemFactory(ThrowableAttributes)

	@JvmField val COMPOUNDBOW = TFItemFactory(CompoundBowAttributes)

	@JvmField val BATWOOD = TFItemFactory(BatWoodAttributes)

	@JvmField val ROBOTARM = TFItemFactory(RobotArmAttributes)

	@JvmField val REVOLVERSECONDARY = TFItemFactory(RevolverSecondaryAttributes)

	@JvmField val BOTTLE = TFItemFactory(BottleAttributes)

	@JvmField val PARTICLECANNON = TFItemFactory(ParticleCannonAttributes)

	@JvmField val FLAREGUNREVENGE = TFItemFactory(FlareGunRevengeAttributes)

	@JvmField val BREAKABLESIGN = TFItemFactory(BreakableSignAttributes)

	@JvmField val ROCKETLAUNCHER_DIRECTHIT = TFItemFactory(RocketLauncher_DirectHitAttributes)

	@JvmField val SHOTGUNBUILDINGRESCUE = TFItemFactory(ShotgunBuildingRescueAttributes)

	@JvmField val CANNON = TFItemFactory(CannonAttributes)

	@JvmField val DRAGONSFURY = TFItemFactory(DragonsFuryAttributes)

	@JvmField val ROCKETLAUNCHER_MORTAR = TFItemFactory(RocketLauncher_MortarAttributes)

	@JvmField val CLEAVER = TFItemFactory(CleaverAttributes)

	@JvmField val PARACHUTE = TFItemFactory(ParachuteAttributes)

	@JvmField val JARGAS = TFItemFactory(JarGasAttributes)

	@JvmField val SNIPERRIFLEDECAP = TFItemFactory(SniperRifleDecapAttributes)

	@JvmField val SNIPERRIFLECLASSIC = TFItemFactory(SniperRifleClassicAttributes)

	@JvmField val BATFISH = TFItemFactory(BatFishAttributes)

	@JvmField val DECOY = TFItemFactory(DecoyAttributes)

	@JvmField val JARMILK = TFItemFactory(JarMilkAttributes)

	@JvmField val GRAPPLINGHOOK = TFItemFactory(GrapplingHookAttributes)

	@JvmField val SODAPOPPER = TFItemFactory(SodaPopperAttributes)

	@JvmField val THROWABLEUTILITY = TFItemFactory(ThrowableUtilityAttributes)

	@JvmField val SCOUTPISTOLPRIMARY = TFItemFactory(ScoutPistolPrimaryAttributes)

	@JvmField val DRGPOMSON = TFItemFactory(DRGPomsonAttributes)

	@JvmField val SCOUTPISTOLSECONDARY = TFItemFactory(ScoutPistolSecondaryAttributes)

	@JvmField val RAYGUN_REVENGE = TFItemFactory(Raygun_RevengeAttributes)

	@JvmField val SPELLBOOK = TFItemFactory(SpellBookAttributes)

	@JvmField val THROWABLESECONDARY = TFItemFactory(ThrowableSecondaryAttributes)

	@JvmField val BATGIFTWRAP = TFItemFactory(BatGiftwrapAttributes)

	@JvmField val PEPBRAWLERBLASTER = TFItemFactory(PEPBrawlerBlasterAttributes)

	@JvmField val THROWABLEPRIMARY = TFItemFactory(ThrowablePrimaryAttributes)

	@JvmField val THROWABLEMELEE = TFItemFactory(ThrowableMeleeAttributes)

}