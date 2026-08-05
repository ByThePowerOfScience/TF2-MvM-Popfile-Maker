package btpos.source.vdfdsl.tf2.items

import btpos.source.vdfdsl.tf2.itemattributes.*
import btpos.source.vdfdsl.modeling.*
import btpos.source.vdfdsl.serialization.*
import btpos.source.vdfdsl.serialization.codecs.*
import btpos.source.vdfdsl.tf2.itemattributes.impl.*
import btpos.source.vdfdsl.tf2.tftypes.*
import java.util.*
import kotlin.time.Duration

object TFItemFactories {
	@JvmField val BASEENTITY = TFItemFactory(BaseEntityAttributes.Inherited)

	@JvmField val BASEPROJECTILE = TFItemFactory(BaseProjectileAttributes.Inherited)

	@JvmField val BASEGRENADEPROJECTILE = TFItemFactory(BaseGrenadeProjectileAttributes.Inherited)

	@JvmField val PLAYER = TFItemFactory(PlayerAttributes.Inherited)

	@JvmField val BASEROCKET = TFItemFactory(BaseRocketAttributes.Inherited)

	@JvmField val PROJECTILEFLARE = TFItemFactory(ProjectileFlareAttributes.Inherited)

	@JvmField val PROJECTILEENERGYRING = TFItemFactory(ProjectileEnergyRingAttributes.Inherited)

	@JvmField val PROJECTILESTICKYBOMB = TFItemFactory(ProjectileStickybombAttributes.Inherited)

	@JvmField val PROJECTILESYRINGE = TFItemFactory(ProjectileSyringeAttributes.Inherited)

	@JvmField val MVMBOT = TFItemFactory(MvMBotAttributes.Inherited)

	@JvmField val PROJECTILEROCKET = TFItemFactory(ProjectileRocketAttributes.Inherited)

	@JvmField val PROJECTILEARROW = TFItemFactory(ProjectileArrowAttributes.Inherited)

	@JvmField val ECONENTITY = TFItemFactory(EconEntityAttributes.Inherited)

	@JvmField val PROJECTILEJAR = TFItemFactory(ProjectileJarAttributes.Inherited)

	@JvmField val PROJECTILEENERGYBALL = TFItemFactory(ProjectileEnergyBallAttributes.Inherited)

	@JvmField val BASECOMBATWEAPON = TFItemFactory(BaseCombatWeaponAttributes.Inherited)

	@JvmField val WEARABLE = TFItemFactory(WearableAttributes.Inherited)

	@JvmField val PROJECTILEHEALINGBOLT = TFItemFactory(ProjectileHealingBoltAttributes.Inherited)

	@JvmField val PROJECTILESPELLFIREBALL = TFItemFactory(ProjectileSpellFireballAttributes.Inherited)

	@JvmField val PROJECTILESPELLBATS = TFItemFactory(ProjectileSpellBatsAttributes.Inherited)

	@JvmField val PROJECTILEGRAPPLINGHOOK = TFItemFactory(ProjectileGrapplingHookAttributes.Inherited)

	@JvmField val PROJECTILEDRAGONSFURY = TFItemFactory(ProjectileDragonsFuryAttributes.Inherited)

	@JvmField val PROJECTILEMECHANICALARMORB = TFItemFactory(ProjectileMechanicalArmOrbAttributes.Inherited)

	@JvmField val PROJECTILECLEAVER = TFItemFactory(ProjectileCleaverAttributes.Inherited)

	@JvmField val PROJECTILESENTRYROCKET = TFItemFactory(ProjectileSentryRocketAttributes.Inherited)

	@JvmField val PROJECTILEJARMILK = TFItemFactory(ProjectileJarMilkAttributes.Inherited)

	@JvmField val WEAPONBASE = TFItemFactory(WeaponBaseAttributes.Inherited)

	@JvmField val WEARABLEDEMOSHIELD = TFItemFactory(WearableDemoShieldAttributes.Inherited)

	@JvmField val POWERUPBOTTLE = TFItemFactory(PowerUpBottleAttributes.Inherited)

	@JvmField val PROJECTILESPELLLIGHTNINGORB = TFItemFactory(ProjectileSpellLightningOrbAttributes.Inherited)

	@JvmField val PROJECTILESPELLSPAWNHORDE = TFItemFactory(ProjectileSpellSpawnHordeAttributes.Inherited)

	@JvmField val WEARABLERAZORBACK = TFItemFactory(WearableRazorbackAttributes.Inherited)

	@JvmField val PROJECTILESPELLMIRV = TFItemFactory(ProjectileSpellMirvAttributes.Inherited)

	@JvmField val PROJECTILESPELLTRANSPOSETELEPORT = TFItemFactory(ProjectileSpellTransposeTeleportAttributes.Inherited)

	@JvmField val WEARABLEROBOTARM = TFItemFactory(WearableRobotArmAttributes.Inherited)

	@JvmField val PDAEXPANSIONTELEPORTER = TFItemFactory(PDAExpansionTeleporterAttributes.Inherited)

	@JvmField val PROJECTILESPELLMETEORSHOWER = TFItemFactory(ProjectileSpellMeteorShowerAttributes.Inherited)

	@JvmField val PROJECTILESPELLSPAWNBOSS = TFItemFactory(ProjectileSpellSpawnBossAttributes.Inherited)

	@JvmField val PDAEXPANSIONDISPENSER = TFItemFactory(PDAExpansionDispenserAttributes.Inherited)

	@JvmField val PROJECTILESPELLPUMPKIN = TFItemFactory(ProjectileSpellPumpkinAttributes.Inherited)

	@JvmField val PROJECTILESPELLSPAWNZOMBIE = TFItemFactory(ProjectileSpellSpawnZombieAttributes.Inherited)

	@JvmField val WEARABLECAMPAIGNITEM = TFItemFactory(WearableCampaignItemAttributes.Inherited)

	@JvmField val PROJECTILESPELLKARTBATS = TFItemFactory(ProjectileSpellKartBatsAttributes.Inherited)

	@JvmField val WEARABLEVM = TFItemFactory(WearableVMAttributes.Inherited)

	@JvmField val WEARABLELEVELABLEITEM = TFItemFactory(WearableLevelableItemAttributes.Inherited)

	@JvmField val BASEGUN = TFItemFactory(BaseGunAttributes.Inherited)

	@JvmField val BASEMELEE = TFItemFactory(BaseMeleeAttributes.Inherited)

	@JvmField val INVIS = TFItemFactory(InvisAttributes.Inherited)

	@JvmField val LUNCHBOX = TFItemFactory(LunchboxAttributes.Inherited)

	@JvmField val BUILDER = TFItemFactory(BuilderAttributes.Inherited)

	@JvmField val PROJECTILEGRENADE = TFItemFactory(ProjectileGrenadeAttributes.Inherited)

	@JvmField val PROJECTILESPELLKARTPUMPKIN = TFItemFactory(ProjectileSpellKartPumpkinAttributes.Inherited)

	@JvmField val PASSTIMEGUN = TFItemFactory(PassTimeGunAttributes.Inherited)

	@JvmField val WEAPONBASEGRENADE = TFItemFactory(WeaponBaseGrenadeAttributes.Inherited)

	@JvmField val PDA = TFItemFactory(PDAAttributes.Inherited)

	@JvmField val PROJECTILESPELLKARTMIRV = TFItemFactory(ProjectileSpellKartMirvAttributes.Inherited)

	@JvmField val FLAMETHROWER = TFItemFactory(FlamethrowerAttributes.Inherited)

	@JvmField val SMG = TFItemFactory(SMGAttributes.Inherited)

	@JvmField val SAPPER = TFItemFactory(SapperAttributes.Inherited)

	@JvmField val FISTS = TFItemFactory(FistsAttributes.Inherited)

	@JvmField val SHOVEL = TFItemFactory(ShovelAttributes.Inherited)

	@JvmField val FIREAXE = TFItemFactory(FireAxeAttributes.Inherited)

	@JvmField val BONESAW = TFItemFactory(BonesawAttributes.Inherited)

	@JvmField val MINIGUN = TFItemFactory(MinigunAttributes.Inherited)

	@JvmField val PISTOL = TFItemFactory(PistolAttributes.Inherited)

	@JvmField val REVOLVER = TFItemFactory(RevolverAttributes.Inherited)

	@JvmField val SYRINGEGUN = TFItemFactory(SyringeGunAttributes.Inherited)

	@JvmField val ROCKETPACK = TFItemFactory(RocketPackAttributes.Inherited)

	@JvmField val STICKYBOMBLAUNCHER = TFItemFactory(StickybombLauncherAttributes.Inherited)

	@JvmField val BUFFITEM = TFItemFactory(BuffItemAttributes.Inherited)

	@JvmField val WRENCH = TFItemFactory(WrenchAttributes.Inherited)

	@JvmField val ROCKETLAUNCHER = TFItemFactory(RocketLauncherAttributes.Inherited)

	@JvmField val GRENADELAUNCHER = TFItemFactory(GrenadeLauncherAttributes.Inherited)

	@JvmField val SHOTGUN = TFItemFactory(ShotgunAttributes.Inherited)

	@JvmField val KNIFE = TFItemFactory(KnifeAttributes.Inherited)

	@JvmField val SWORD = TFItemFactory(SwordAttributes.Inherited)

	@JvmField val FLAREGUN = TFItemFactory(FlareGunAttributes.Inherited)

	@JvmField val JAR = TFItemFactory(JarAttributes.Inherited)

	@JvmField val MECHANICALARM = TFItemFactory(MechanicalArmAttributes.Inherited)

	@JvmField val SNIPERRIFLE = TFItemFactory(SniperRifleAttributes.Inherited)

	@JvmField val MEDIGUN = TFItemFactory(MedigunAttributes.Inherited)

	@JvmField val BAT = TFItemFactory(BatAttributes.Inherited)

	@JvmField val NAILGUN = TFItemFactory(NailgunAttributes.Inherited)

	@JvmField val PDAENGINEERDESTROY = TFItemFactory(PDAEngineerDestroyAttributes.Inherited)

	@JvmField val GRENADEHEAL = TFItemFactory(GrenadeHealAttributes.Inherited)

	@JvmField val TRANQ = TFItemFactory(TranqAttributes.Inherited)

	@JvmField val GRENADEMIRV = TFItemFactory(GrenadeMirvAttributes.Inherited)

	@JvmField val BREAKABLEMELEE = TFItemFactory(BreakableMeleeAttributes.Inherited)

	@JvmField val FLAG = TFItemFactory(FlagAttributes.Inherited)

	@JvmField val PDASPY = TFItemFactory(PDASpyAttributes.Inherited)

	@JvmField val PDAENGINEERBUILD = TFItemFactory(PDAEngineerBuildAttributes.Inherited)

	@JvmField val BOOMERANG = TFItemFactory(BoomerangAttributes.Inherited)

	@JvmField val GRENADENAIL = TFItemFactory(GrenadeNailAttributes.Inherited)

	@JvmField val SLAP = TFItemFactory(SlapAttributes.Inherited)

	@JvmField val GRENADECALTROP = TFItemFactory(GrenadeCaltropAttributes.Inherited)

	@JvmField val GRENADESMOKEBOMB = TFItemFactory(GrenadeSmokeBombAttributes.Inherited)

	@JvmField val CLUB = TFItemFactory(ClubAttributes.Inherited)

	@JvmField val LUNCHBOXDRINK = TFItemFactory(LunchboxDrinkAttributes.Inherited)

	@JvmField val GRENADENAPALM = TFItemFactory(GrenadeNapalmAttributes.Inherited)

	@JvmField val GRENADEEMP = TFItemFactory(GrenadeEMPAttributes.Inherited)

	@JvmField val GRENADEGAS = TFItemFactory(GrenadeGasAttributes.Inherited)

	@JvmField val GRENADENORMAL = TFItemFactory(GrenadeNormalAttributes.Inherited)

	@JvmField val LASERPOINTER = TFItemFactory(LaserPointerAttributes.Inherited)

	@JvmField val CROWBAR = TFItemFactory(CrowbarAttributes.Inherited)

	@JvmField val CHARGEDSMG = TFItemFactory(ChargedSMGAttributes.Inherited)

	@JvmField val STICKBOMB = TFItemFactory(StickBombAttributes.Inherited)

	@JvmField val SCOUTPISTOL = TFItemFactory(ScoutPistolAttributes.Inherited)

	@JvmField val ROCKETLAUNCHER_AIRSTRIKE = TFItemFactory(RocketLauncher_AirStrikeAttributes.Inherited)

	@JvmField val CROSSBOW = TFItemFactory(CrossbowAttributes.Inherited)

	@JvmField val RAYGUN = TFItemFactory(RayGunAttributes.Inherited)

	@JvmField val SHOTGUNREVENGE = TFItemFactory(ShotgunRevengeAttributes.Inherited)

	@JvmField val SCATTERGUN = TFItemFactory(ScattergunAttributes.Inherited)

	@JvmField val THROWABLE = TFItemFactory(ThrowableAttributes.Inherited)

	@JvmField val COMPOUNDBOW = TFItemFactory(CompoundBowAttributes.Inherited)

	@JvmField val BATWOOD = TFItemFactory(BatWoodAttributes.Inherited)

	@JvmField val ROBOTARM = TFItemFactory(RobotArmAttributes.Inherited)

	@JvmField val REVOLVERSECONDARY = TFItemFactory(RevolverSecondaryAttributes.Inherited)

	@JvmField val BOTTLE = TFItemFactory(BottleAttributes.Inherited)

	@JvmField val PARTICLECANNON = TFItemFactory(ParticleCannonAttributes.Inherited)

	@JvmField val FLAREGUNREVENGE = TFItemFactory(FlareGunRevengeAttributes.Inherited)

	@JvmField val BREAKABLESIGN = TFItemFactory(BreakableSignAttributes.Inherited)

	@JvmField val ROCKETLAUNCHER_DIRECTHIT = TFItemFactory(RocketLauncher_DirectHitAttributes.Inherited)

	@JvmField val SHOTGUNBUILDINGRESCUE = TFItemFactory(ShotgunBuildingRescueAttributes.Inherited)

	@JvmField val CANNON = TFItemFactory(CannonAttributes.Inherited)

	@JvmField val DRAGONSFURY = TFItemFactory(DragonsFuryAttributes.Inherited)

	@JvmField val ROCKETLAUNCHER_MORTAR = TFItemFactory(RocketLauncher_MortarAttributes.Inherited)

	@JvmField val CLEAVER = TFItemFactory(CleaverAttributes.Inherited)

	@JvmField val PARACHUTE = TFItemFactory(ParachuteAttributes.Inherited)

	@JvmField val JARGAS = TFItemFactory(JarGasAttributes.Inherited)

	@JvmField val SNIPERRIFLEDECAP = TFItemFactory(SniperRifleDecapAttributes.Inherited)

	@JvmField val SNIPERRIFLECLASSIC = TFItemFactory(SniperRifleClassicAttributes.Inherited)

	@JvmField val BATFISH = TFItemFactory(BatFishAttributes.Inherited)

	@JvmField val DECOY = TFItemFactory(DecoyAttributes.Inherited)

	@JvmField val JARMILK = TFItemFactory(JarMilkAttributes.Inherited)

	@JvmField val GRAPPLINGHOOK = TFItemFactory(GrapplingHookAttributes.Inherited)

	@JvmField val SODAPOPPER = TFItemFactory(SodaPopperAttributes.Inherited)

	@JvmField val THROWABLEUTILITY = TFItemFactory(ThrowableUtilityAttributes.Inherited)

	@JvmField val SCOUTPISTOLPRIMARY = TFItemFactory(ScoutPistolPrimaryAttributes.Inherited)

	@JvmField val DRGPOMSON = TFItemFactory(DRGPomsonAttributes.Inherited)

	@JvmField val SCOUTPISTOLSECONDARY = TFItemFactory(ScoutPistolSecondaryAttributes.Inherited)

	@JvmField val RAYGUN_REVENGE = TFItemFactory(Raygun_RevengeAttributes.Inherited)

	@JvmField val SPELLBOOK = TFItemFactory(SpellBookAttributes.Inherited)

	@JvmField val THROWABLESECONDARY = TFItemFactory(ThrowableSecondaryAttributes.Inherited)

	@JvmField val BATGIFTWRAP = TFItemFactory(BatGiftwrapAttributes.Inherited)

	@JvmField val PEPBRAWLERBLASTER = TFItemFactory(PEPBrawlerBlasterAttributes.Inherited)

	@JvmField val THROWABLEPRIMARY = TFItemFactory(ThrowablePrimaryAttributes.Inherited)

	@JvmField val THROWABLEMELEE = TFItemFactory(ThrowableMeleeAttributes.Inherited)

}