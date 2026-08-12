package btpos.source.vdfdsl.tf2.itemattributes

import btpos.source.vdfdsl.tf2.itemattributes.*
import btpos.source.vdfdsl.modeling.*
import btpos.source.vdfdsl.serialization.*
import btpos.source.vdfdsl.serialization.codecs.*
import btpos.source.vdfdsl.tf2.itemattributes.impl.*
import btpos.source.vdfdsl.tf2.tftypes.*
import java.util.*
import kotlin.time.Duration

private val _spellLightningOrb = object : ProjectileSpellLightningOrbAttributes {}
val BaseGunAttributes.ProjectilesAttributes.spellLightningOrb: ProjectileSpellLightningOrbAttributes get() = _spellLightningOrb

private val _spellSpawnHorde = object : ProjectileSpellSpawnHordeAttributes {}
val BaseGunAttributes.ProjectilesAttributes.spellSpawnHorde: ProjectileSpellSpawnHordeAttributes get() = _spellSpawnHorde

private val _jarGas = object : ProjectileJarGasAttributes {}
val BaseGunAttributes.ProjectilesAttributes.jarGas: ProjectileJarGasAttributes get() = _jarGas

private val _energyRing = object : ProjectileEnergyRingAttributes {}
/**
 * Items: The Righteous Bison, The Pomson 6000
 */
val BaseGunAttributes.ProjectilesAttributes.energyRing: ProjectileEnergyRingAttributes get() = _energyRing

private val _spellMirv = object : ProjectileSpellMirvAttributes {}
val BaseGunAttributes.ProjectilesAttributes.spellMirv: ProjectileSpellMirvAttributes get() = _spellMirv

private val _jar = object : ProjectileJarAttributes {}
val BaseGunAttributes.ProjectilesAttributes.jar: ProjectileJarAttributes get() = _jar

private val _throwableBrick = object : ProjectileThrowableBrickAttributes {}
val BaseGunAttributes.ProjectilesAttributes.throwableBrick: ProjectileThrowableBrickAttributes get() = _throwableBrick

private val _spellKartPumpkin = object : ProjectileSpellKartPumpkinAttributes {}
val BaseGunAttributes.ProjectilesAttributes.spellKartPumpkin: ProjectileSpellKartPumpkinAttributes get() = _spellKartPumpkin

private val _spellTransposeTeleport = object : ProjectileSpellTransposeTeleportAttributes {}
val BaseGunAttributes.ProjectilesAttributes.spellTransposeTeleport: ProjectileSpellTransposeTeleportAttributes get() = _spellTransposeTeleport

private val _healingBolt = object : ProjectileHealingBoltAttributes {}
val BaseGunAttributes.ProjectilesAttributes.healingBolt: ProjectileHealingBoltAttributes get() = _healingBolt

private val _spellFireball = object : ProjectileSpellFireballAttributes {}
val BaseGunAttributes.ProjectilesAttributes.spellFireball: ProjectileSpellFireballAttributes get() = _spellFireball

private val _grenade = object : ProjectileGrenadeAttributes {}
/**
 * Items: Stock Grenade Launcher, The Iron Bomber, The Loose Cannon
 */
val BaseGunAttributes.ProjectilesAttributes.grenade: ProjectileGrenadeAttributes get() = _grenade

private val _spellBats = object : ProjectileSpellBatsAttributes {}
val BaseGunAttributes.ProjectilesAttributes.spellBats: ProjectileSpellBatsAttributes get() = _spellBats

private val _spellMeteorShower = object : ProjectileSpellMeteorShowerAttributes {}
val BaseGunAttributes.ProjectilesAttributes.spellMeteorShower: ProjectileSpellMeteorShowerAttributes get() = _spellMeteorShower

private val _baseMisc = object : ProjectileBaseMiscAttributes {}
val BaseGunAttributes.ProjectilesAttributes.baseMisc: ProjectileBaseMiscAttributes get() = _baseMisc

private val _baseball = object : ProjectileBaseballAttributes {}
val BaseGunAttributes.ProjectilesAttributes.baseball: ProjectileBaseballAttributes get() = _baseball

private val _energyBall = object : ProjectileEnergyBallAttributes {}
val BaseGunAttributes.ProjectilesAttributes.energyBall: ProjectileEnergyBallAttributes get() = _energyBall

private val _spellSpawnBoss = object : ProjectileSpellSpawnBossAttributes {}
val BaseGunAttributes.ProjectilesAttributes.spellSpawnBoss: ProjectileSpellSpawnBossAttributes get() = _spellSpawnBoss

private val _ornament = object : ProjectileOrnamentAttributes {}
val BaseGunAttributes.ProjectilesAttributes.ornament: ProjectileOrnamentAttributes get() = _ornament

private val _merasmusGrenade = object : ProjectileMerasmusGrenadeAttributes {}
val BaseGunAttributes.ProjectilesAttributes.merasmusGrenade: ProjectileMerasmusGrenadeAttributes get() = _merasmusGrenade

private val _grapplingHook = object : ProjectileGrapplingHookAttributes {}
val BaseGunAttributes.ProjectilesAttributes.grapplingHook: ProjectileGrapplingHookAttributes get() = _grapplingHook

private val _rocket = object : ProjectileRocketAttributes {}
val BaseGunAttributes.ProjectilesAttributes.rocket: ProjectileRocketAttributes get() = _rocket

private val _spellPumpkin = object : ProjectileSpellPumpkinAttributes {}
val BaseGunAttributes.ProjectilesAttributes.spellPumpkin: ProjectileSpellPumpkinAttributes get() = _spellPumpkin

private val _throwableBreadMonster = object : ProjectileThrowableBreadMonsterAttributes {}
val BaseGunAttributes.ProjectilesAttributes.throwableBreadMonster: ProjectileThrowableBreadMonsterAttributes get() = _throwableBreadMonster

private val _dragonsFury = object : ProjectileDragonsFuryAttributes {}
val BaseGunAttributes.ProjectilesAttributes.dragonsFury: ProjectileDragonsFuryAttributes get() = _dragonsFury

private val _mechanicalArmOrb = object : ProjectileMechanicalArmOrbAttributes {}
val BaseGunAttributes.ProjectilesAttributes.mechanicalArmOrb: ProjectileMechanicalArmOrbAttributes get() = _mechanicalArmOrb

private val _cleaver = object : ProjectileCleaverAttributes {}
val BaseGunAttributes.ProjectilesAttributes.cleaver: ProjectileCleaverAttributes get() = _cleaver

private val _sentryRocket = object : ProjectileSentryRocketAttributes {}
val BaseGunAttributes.ProjectilesAttributes.sentryRocket: ProjectileSentryRocketAttributes get() = _sentryRocket

private val _repel = object : ProjectileRepelAttributes {}
val BaseGunAttributes.ProjectilesAttributes.repel: ProjectileRepelAttributes get() = _repel

private val _spellSpawnZombie = object : ProjectileSpellSpawnZombieAttributes {}
val BaseGunAttributes.ProjectilesAttributes.spellSpawnZombie: ProjectileSpellSpawnZombieAttributes get() = _spellSpawnZombie

private val _jarMilk = object : ProjectileJarMilkAttributes {}
val BaseGunAttributes.ProjectilesAttributes.jarMilk: ProjectileJarMilkAttributes get() = _jarMilk

private val _spellKartBats = object : ProjectileSpellKartBatsAttributes {}
val BaseGunAttributes.ProjectilesAttributes.spellKartBats: ProjectileSpellKartBatsAttributes get() = _spellKartBats

private val _throwable = object : ProjectileThrowableAttributes {}
val BaseGunAttributes.ProjectilesAttributes.throwable: ProjectileThrowableAttributes get() = _throwable

private val _arrow = object : ProjectileArrowAttributes {}
/**
 * Items: The Huntsman, The Crusader's Crossbow, The Rescue Ranger
 */
val BaseGunAttributes.ProjectilesAttributes.arrow: ProjectileArrowAttributes get() = _arrow

private val _pipebomb = object : ProjectilePipebombAttributes {}
val BaseGunAttributes.ProjectilesAttributes.pipebomb: ProjectilePipebombAttributes get() = _pipebomb

private val _flare = object : ProjectileFlareAttributes {}
/**
 * Items: The Flare Gun, The Detonator, The Manmelter, The Scorch Shot
 */
val BaseGunAttributes.ProjectilesAttributes.flare: ProjectileFlareAttributes get() = _flare

private val _spellKartMirv = object : ProjectileSpellKartMirvAttributes {}
val BaseGunAttributes.ProjectilesAttributes.spellKartMirv: ProjectileSpellKartMirvAttributes get() = _spellKartMirv

private val _syringe = object : ProjectileSyringeAttributes {}
val BaseGunAttributes.ProjectilesAttributes.syringe: ProjectileSyringeAttributes get() = _syringe
