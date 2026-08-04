package btpos.source.vdfdsl.tf2.rafmod.attributes

import btpos.source.vdfdsl.tf2.itemattributes.BaseGunAttributes
import btpos.source.vdfdsl.tf2.itemattributes.BaseMeleeAttributes
import btpos.source.vdfdsl.tf2.itemattributes.BuffItemAttributes
import btpos.source.vdfdsl.tf2.itemattributes.CompoundBowAttributes
import btpos.source.vdfdsl.tf2.itemattributes.CrossbowAttributes
import btpos.source.vdfdsl.tf2.itemattributes.FlamethrowerAttributes
import btpos.source.vdfdsl.tf2.itemattributes.ItemAttributeNamed
import btpos.source.vdfdsl.tf2.itemattributes.MedigunAttributes
import btpos.source.vdfdsl.tf2.itemattributes.MinigunAttributes
import btpos.source.vdfdsl.tf2.itemattributes.MvMBotAttributes
import btpos.source.vdfdsl.tf2.itemattributes.PlayerAttributes
import btpos.source.vdfdsl.tf2.itemattributes.RevolverAttributes
import btpos.source.vdfdsl.tf2.itemattributes.SniperRifleAttributes
import btpos.source.vdfdsl.tf2.itemattributes.WeaponBaseAttributes
import btpos.source.vdfdsl.tf2.itemattributes.WearableAttributes
import btpos.source.vdfdsl.tf2.rafmod.codecs.SetToIntCodec
import btpos.source.vdfdsl.utils.toSeconds
import kotlin.time.Duration

/**
 * Modifications made to vanilla attributes.
 */
@Suppress("UnusedReceiverParameter")
object RafmodVanillaAttributes {
	/**
	 * Rafmod implementation of a vanilla attribute.
	 *
	 * Prevents the user from using alt-fire on their weapon.
	 */
	val WeaponBaseAttributes.altFireDisabled: ItemAttributeNamed<Boolean> by ItemAttributeNamed("alt-fire disabled")
	
	/**
	 * Rafmod expansion of a vanilla attribute.  Now works on any weapon, not just melee weapons.
	 *
	 * @see BaseMeleeAttributes.dmgPenaltyWhileHalfAlive
	 */
	val WeaponBaseAttributes.DamageAttributes.multDmgWhileHalfDead get() = BaseMeleeAttributes.damage.multDmgWhileHalfDead
	
	
	/**
	 * Rafmod expansion of a vanilla attribute.  Now works on any weapon, not just melee weapons.
	 *
	 * @see BaseMeleeAttributes.DamageAttributes.multDmgWhileHalfAlive
	 */
	val WeaponBaseAttributes.DamageAttributes.multDmgWhileHalfAlive get() = BaseMeleeAttributes.damage.multDmgWhileHalfAlive
	
	/**
	 * Rafmod expansion of a vanilla attribute.  Now works on the [Mantreads][btpos.source.vdfdsl.tf2.items.weapons.Weapons.MANTREADS].
	 *
	 * @see WeaponBaseAttributes.DamageAttributes.damage
	 */
	val WearableAttributes.DamageAttributes.damage get() = WeaponBaseAttributes.damage.damage
	
	/**
	 * Rafmod expansion of a vanilla attribute.  Now works on the [Mantreads][btpos.source.vdfdsl.tf2.items.weapons.Weapons.MANTREADS].
	 *
	 * @see WeaponBaseAttributes.DamageAttributes.dmgPenaltyVsPlayers
	 */
	val WearableAttributes.DamageAttributes.dmgPenaltyVsPlayers get() = WeaponBaseAttributes.damage.dmgPenaltyVsPlayers
	
	/**
	 * Rafmod expansion of a vanilla attribute.  Now works on the [Mantreads][btpos.source.vdfdsl.tf2.items.weapons.Weapons.MANTREADS].
	 *
	 * @see WeaponBaseAttributes.OnKillAttributes.restoreHealthOnKill
	 */
	val WearableAttributes.restoreHealthOnKill get() = WeaponBaseAttributes.onKill.healOnKill
	
	
	/**
	 * Rafmod reimplementation of a vanilla attribute.
	 *
	 * Multiplier to firing speed, inversely scaled by the user's "current health to maximum health" proportion.
	 *
	 * Formerly the attribute used for the Panic Attack, now unused in the base game.
	 */
	val WeaponBaseAttributes.FiringAttributes.multFireRateWithReducedHealth: ItemAttributeNamed<Number> by ItemAttributeNamed("fire rate bonus with reduced health")
	
	/**
	 * Rafmod expansion of a vanilla attribute.  Now works on any weapon.
	 *
	 * @see MinigunAttributes.attackProjectiles
	 */
	val WeaponBaseAttributes.canAttackProjectiles get() = MinigunAttributes.attackProjectiles
	
	/**
	 * Rafmod expansion of a vanilla attribute.  Now works on any weapon.
	 *
	 * @see BaseMeleeAttributes.CritsAttributes.critFromBehind
	 */
	val WeaponBaseAttributes.CritsAttributes.critFromBehind get() = BaseMeleeAttributes.crits.critFromBehind
	
	
	
	
	
	/**
	 * Unused base-game attribute made accessible by Rafmod.
	 *
	 * Prevents parachute from being deployed, but still allows it to be retracted.
	 */
	val PlayerAttributes.MovementAttributes.parachuteDisabled: ItemAttributeNamed<Boolean> by ItemAttributeNamed("parachute disabled")
	/**
	 * Unused base-game attribute made accessible by Rafmod.
	 *
	 * If true, alt-fire fires a crossbow bolt that applies Mad Milk to its target.
	 */
	val CrossbowAttributes.firesMilkBolt: ItemAttributeNamed<Boolean> by ItemAttributeNamed("fires milk bolt")
	/**
	 * Unused base-game attribute made accessible by Rafmod.
	 *
	 * Hit all targets in swing instead of just the first valid one.
	 */
	val BaseMeleeAttributes.meleeCleaveAttack: ItemAttributeNamed<Boolean> by ItemAttributeNamed("melee cleave attack")
	/**
	 * Unused base-game attribute made accessible by Rafmod.
	 *
	 * Gain this many heads on hitting a target with this weapon.
	 *
	 * @see extraDamageOnHit
	 */
	val WeaponBaseAttributes.HeadsAttributes.headsGainedOnHit: ItemAttributeNamed<Int> by ItemAttributeNamed("extra damage on hit")
	
	/**
	 * Unused base-game attribute made accessible by Rafmod.
	 *
	 * Gain this many heads on hit.  Deal +1% extra damage per head.
	 *
	 * Same attribute as [headsGainedOnHit], but the damage is only valid for the Revolver.
	 *
	 * @see headsGainedOnHit
	 * @see extraDamageOnHitPenalty
	 */
	val RevolverAttributes.DamageAttributes.extraDamageOnHit: ItemAttributeNamed<Int> by ItemAttributeNamed("extra damage on hit")
	
	/**
	 * Unused base-game attribute made accessible by Rafmod.
	 *
	 * Lose this many heads per missed shot.
	 *
	 * @see extraDamageOnHit
	 * @see headsGainedOnHit
	 */
	val RevolverAttributes.HeadsAttributes.extraDamageOnHitPenalty: ItemAttributeNamed<Int> by ItemAttributeNamed("extra damage on hit penalty")
	/**
	 * Unused base-game attribute made accessible by Rafmod.
	 *
	 * If true, teleporter adds the [speed boost condition][btpos.source.vdfdsl.tf2.tftypes.TFCondition.SpeedBoost] for 4 seconds to players it teleports.
	 */
	val PlayerAttributes.BuildingsAttributes.TeleporterAttributes.givesSpeedBoost: ItemAttributeNamed<Boolean> by ItemAttributeNamed("mod teleporter speed boost")
	/**
	 * Unused base-game attribute made accessible by Rafmod.
	 *
	 * If true, the player can breathe underwater.
	 */
	val PlayerAttributes.MovementAttributes.canBreatheUnderwater: ItemAttributeNamed<Boolean> by ItemAttributeNamed("can breathe under water")
	/**
	 * Unused base-game attribute made accessible by Rafmod.
	 *
	 * If true, forbids you from Numbering upwards with the jump button in the water.
	 */
	val PlayerAttributes.MovementAttributes.cannotSwim: ItemAttributeNamed<Boolean> by ItemAttributeNamed("cannot swim")
	/**
	 * Unused base-game attribute made accessible by Rafmod.
	 *
	 * If false or not present, move speed is 80% while swimming.
	 */
	val PlayerAttributes.MovementAttributes.swimmingMastery: ItemAttributeNamed<Boolean> by ItemAttributeNamed("swimming mastery")
	/**
	 * Unused base-game attribute made accessible by Rafmod.
	 *
	 * If true, add `kills + captures + defenses + buildingsdestroyed - (3 * deaths)` to player score, on top of the default scoring algorithm.
	 */
	val PlayerAttributes.MetaAttributes.scoreboardMinigame: ItemAttributeNamed<Boolean> by ItemAttributeNamed("scoreboard minigame")
	/**
	 * Unused base-game attribute made accessible by Rafmod.
	 *
	 * If true, makes the player immune to "wet" status effects: Jarate, Mad Milk, Gas Passer.
	 */
	val PlayerAttributes.ResistanceAttributes.wetImmunity: ItemAttributeNamed<Boolean> by ItemAttributeNamed("wet immunity")
	/**
	 * Unused base-game attribute made accessible by Rafmod.
	 *
	 * Mult to zoom/unzoom delay on clipless weapons
	 * - Mult by level: 1=0.6, 2=0.3
	 * Mult to charge speed
	 * - 1=1.5, 2=3.0
	 *
	 * Value: the level of the ability.
	 */
	val SniperRifleAttributes.masterSniperLevel: ItemAttributeNamed<Int> by ItemAttributeNamed("ability master sniper")
	
	/**
	 * Unused base-game attribute made accessible by Rafmod.
	 *
	 * Applies mult to reload speed: 1 = 0.6, 2 = 0.3
	 *
	 * Does not stack with Haste powerup.
	 */
	val CompoundBowAttributes.masterSniperLevel: ItemAttributeNamed<Int> by ItemAttributeNamed("ability master sniper")
	
	
	/**
	 * Unused base-game attribute made accessible by Rafmod.
	 *
	 * When reloading, if you only have 1 round left in your clip, get crit-boosted.
	 */
	val WeaponBaseAttributes.lastShotCrits: ItemAttributeNamed<Boolean> by ItemAttributeNamed("last shot crits")
	
	/**
	 * Unused base-game attribute made accessible by Rafmod.
	 *
	 * If true, spies will keep their disguise when attacking with this weapon.
	 */
	val BaseGunAttributes.DisguiseAttributes.keepDisguiseOnAttacking: ItemAttributeNamed<Boolean> by ItemAttributeNamed("keep disguise on attack")
	
	/**
	 * Unused base-game attribute made accessible by Rafmod.
	 *
	 * Transfer this amount of health from yourself to your teammate when hitting them.
	 */
	val BaseMeleeAttributes.OnHitAttributes.giveHealthToTeammate: ItemAttributeNamed<Int> by ItemAttributeNamed("add give health to teammate on hit")
	
	/**
	 * Unused base-game attribute made accessible by Rafmod.
	 *
	 * Can switch to other weapons while spinning minigun.
	 */
	val MinigunAttributes.canHolsterWhileSpinning: ItemAttributeNamed<Boolean> by ItemAttributeNamed("mod minigun can holster while spinning")
	
	/**
	 * Unused base-game attribute made accessible by Rafmod.
	 *
	 * On kill, gives N% fire-rate bonus, stacking up to 3 times.  Killing a different class than the previous kill resets the combo.
	 */
	val WeaponBaseAttributes.FiringAttributes.FireRateAttributes.killComboFireRateBoost: ItemAttributeNamed<Number> by ItemAttributeNamed("kill combo fire rate boost")
	
	/**
	 * Unused base-game attribute made accessible by Rafmod.
	 *
	 * Multiplier for health, ammo, and metal dispenser rate. Queried on the builder.
	 */
	val PlayerAttributes.BuildingsAttributes.DispenserAttributes.multDispenserResupplyRate: ItemAttributeNamed<Number> by ItemAttributeNamed("mult dispenser rate")
	
	/**
	 * Unused base-game attribute made accessible by Rafmod.
	 *
	 * Sentry max ammo multiplier. Queried on the builder.
	 */
	val PlayerAttributes.BuildingsAttributes.SentryGunAttributes.multSentryAmmo: ItemAttributeNamed<Number> by ItemAttributeNamed("mvm sentry ammo")
	/**
	 * Sentry is 20% smaller with 33% less health, and requires 25% less metal to upgrade. Queried on the builder.
	 */
	val PlayerAttributes.BuildingsAttributes.SentryGunAttributes.buildSmallSentries: ItemAttributeNamed<Boolean> by ItemAttributeNamed("build small sentries")
	/**
	 * Teleporter recharge duration multiplier. Queried on the builder.
	 */
	val PlayerAttributes.BuildingsAttributes.TeleporterAttributes.multRechargeRate: ItemAttributeNamed<Number> by ItemAttributeNamed("mult teleporter recharge rate")
	/**
	 * Disguise as a dispenser when crouching. Hardcoded to only work on Spy.
	 */
	val PlayerAttributes.DisguiseAttributes.disguiseAsDispenserOnCrouch: ItemAttributeNamed<Boolean> by ItemAttributeNamed("disguise as dispenser on crouch")
	/**
	 * If a Syringe Gun, uses this much ubercharge % per shot instead of normal ammunition.  Otherwise does nothing.
	 *
	 * Using Ubercharge for ammo only works on Syringe guns, but [uberchargeTransfer] works on all weapons.
	 */
	val WeaponBaseAttributes.AmmoAttributes.uberchargeAmmo: ItemAttributeNamed<Number> by ItemAttributeNamed("ubercharge ammo")
	
	/**
	 * If [uberchargeAmmo] is set, hitting any other medic with the weapon will transfer this much ubercharge % to them.
	 */
	val WeaponBaseAttributes.OnHitAttributes.uberchargeTransfer: ItemAttributeNamed<Number> by ItemAttributeNamed("ubercharge transfer")
	
	/**
	 * On receiving fatal damage: x% chance of being immediately revived at spawn with 1 health.
	 */
	val PlayerAttributes.WhenHitAttributes.teleportInsteadOfDie: ItemAttributeNamed<Number> by ItemAttributeNamed("teleport instead of die")
	
	/**
	 * Damage vs same class multiplier
	 */
	val WeaponBaseAttributes.DamageAttributes.multDmgVsSameClass: ItemAttributeNamed<Number> by ItemAttributeNamed("mult dmg vs same class")
	
	/**
	 * On taking damage: x% chance of being ubercharged for 3 seconds
	 */
	val PlayerAttributes.WhenHitAttributes.uberOnDamageTaken: ItemAttributeNamed<Number> by ItemAttributeNamed("uber on damage taken")
	
	/**
	 * Damage taken from melee multiplier
	 */
	val PlayerAttributes.ResistanceAttributes.multDmgTakenFromMelee: ItemAttributeNamed<Number> by ItemAttributeNamed("mult dmgtaken from melee")
	
	/**
	 * Gain crit boost when below this proportion of health. (e.g. 0.6 = 60%)
	 */
	val PlayerAttributes.CritsAttributes.multCritWhenHealthIsBelowPercent: ItemAttributeNamed<Number> by ItemAttributeNamed("mult crit when health is below percent")
	
	/**
	 * Multiplier applied to a bullet's damage after each successive player it penetrates.
	 */
	val WeaponBaseAttributes.DamageAttributes.multDmgAfterPenetration: ItemAttributeNamed<Number> by ItemAttributeNamed("penetration damage penalty")
	
	/**
	 * Pulls the user forward with x velocity while firing the weapon.  Limited by ground move speed cap.
	 */
	val WeaponBaseAttributes.FiringAttributes.firingForwardPull: ItemAttributeNamed<Number> by ItemAttributeNamed("firing forward pull")
	
	/**
	 * On all weapons, pulls the user forward with x velocity while firing the weapon.  Limited by ground move speed cap.
	 *
	 * Additionally on the flamethrower: applies [speed boost condition][btpos.source.vdfdsl.tf2.tftypes.TFCondition.SpeedBoost] while firing.
	 */
	val FlamethrowerAttributes.FiringAttributes.firingForwardPull: ItemAttributeNamed<Number> by ItemAttributeNamed("firing forward pull")
	
	/**
	 * Multiplier for Soldier's banner buff range. Base is 450 HU.
	 */
	val BuffItemAttributes.BuffItemsAttributes.multBuffRange: ItemAttributeNamed<Number> by ItemAttributeNamed("mod soldier buff range")
	
	/**
	 * Deploy speed bonus when rocket jumping
	 */
	val WeaponBaseAttributes.SwapWeaponsAttributes.DeployAttributes.multRocketjumpDeployTime: ItemAttributeNamed<Number> by ItemAttributeNamed("mult rocketjump deploy time")
	
	/**
	 * Fire rate multiplier when not rocket jumping.
	 */
	val BaseGunAttributes.FiringAttributes.FireRateAttributes.multNonRocketJumpFireRate: ItemAttributeNamed<Number> by ItemAttributeNamed("mul nonrocketjump attackrate")
	/**
	 * On hit: `refire time * (x/60)` % chance for AoE heal for 1s (24 hp healed total). use 60 for 100% chance on 1s refire time weapon, 600 for 0.1s
	 */
	val WeaponBaseAttributes.HealthAndHealingAttributes.aoeHealChance: ItemAttributeNamed<Number> by ItemAttributeNamed("aoe heal chance")
	/**
	 * On hit: `refire time * (x/60)` % chance for crit boost for 3s.  use 60 for 100% chance on 1s refire time weapon, 600 for 0.1s
	 */
	val WeaponBaseAttributes.OnHitAttributes.gainCritBoostChance: ItemAttributeNamed<Number> by ItemAttributeNamed("crits on damage")
	/**
	 * On hit: `refire time * (x/60)` % chance for stun for 3s. use 60 for 100% chance on 1s refire time weapon, 600 for 0.1s
	 */
	val WeaponBaseAttributes.OnHitAttributes.stunTargetChance: ItemAttributeNamed<Number> by ItemAttributeNamed("stun on damage")
	/**
	 * On hit: `refire time * (x/60)` % chance for 100 hu blast that stuns players for 2 seconds and applies bleed. use 60 for 100% chance on 1s refire time weapon, 600 for 0.1s
	 */
	val WeaponBaseAttributes.aoeBlastChance: ItemAttributeNamed<Number> by ItemAttributeNamed("aoe blast on damage")
	/**
	 * Multiplier applied to damage proportion that is multiplied by "player maximum health" / "player current health".
	 */
	val BaseMeleeAttributes.DamageAttributes.multDmgWithReducedHealth: ItemAttributeNamed<Number> by ItemAttributeNamed("mult dmg with reduced health")
	
	/**
	 * Multiplier of how fast primary fire specifically can be used after airblasting.
	 *
	 * Primary attack delay = this * refire_time * base
	 */
	val FlamethrowerAttributes.AirblastAttributes.multPrimaryRefireTime: ItemAttributeNamed<Number> by ItemAttributeNamed("mult airblast primary refire time")
	
	/**
	 * Spin up time for flamethrowers, like the delay between starting to rev up a minigun and being able to fire.
	 */
	val FlamethrowerAttributes.spinupTime: ItemAttributeNamed<Duration> by ItemAttributeNamed("mod flamethrower spinup time", Duration::toSeconds)
	/**
	 * Scales the cone used to push players by this amount.
	 */
	val FlamethrowerAttributes.AirblastAttributes.multConeScale: ItemAttributeNamed<Number> by ItemAttributeNamed("mult airblast cone scale")
	
	/**
	 * Combination of flamethrower flags, used to limit airblast functionality.
	 *
	 * If empty or not set, all abilities will work.
	 */
	val FlamethrowerAttributes.airblastFunctionalityFlags: ItemAttributeNamed<Set<AirblastFunctionalityFlag>> by ItemAttributeNamed<Set<AirblastFunctionalityFlag>>("airblast functionality flags", SetToIntCodec({ 1 shl it.ordinal }, { 0 }))
	
	/**
	 * Determines which of these things an airblast can do.
	 *
	 * @see airblastFunctionalityFlags
	 */
	open class AirblastFunctionalityFlag(val ordinal: Int) {
		companion object {
			/**
			 * If set, airblast knocks targets away from the user in a cone.
			 *
			 * @see PUSHBACK_STUN
			 * @see PUSHBACK_VIEW_PUNCH
			 */
			@JvmField val PUSHBACK = AirblastFunctionalityFlag(0)
			
			/** If set, airblast can put out teammates that are on fire. */
			@JvmField val EXTINGUISH_TEAMMATES = AirblastFunctionalityFlag(1)
			/** If set, the airblast can reflect any projectiles back at enemy players. */
			@JvmField val REFLECT_PROJECTILES = AirblastFunctionalityFlag(2)
			/**
			 * If set, airblast hinders players' air acceleration until they next touch the ground.
			 *
			 * Requires [PUSHBACK].
			 */
			@JvmField val PUSHBACK_STUN = AirblastFunctionalityFlag(3)
			/**
			 * If set, airblast flinches ("aimpunches") players it connects with.
			 *
			 * Requires [PUSHBACK].
			 */
			@JvmField val PUSHBACK_VIEW_PUNCH = AirblastFunctionalityFlag(4)
			
		}
		
	}
	
	/**
	 * Airblast pushes players towards the user.
	 *
	 * If [airblastFunctionalityFlags] is configured, requires [the ability to push enemies back][AirblastFunctionalityFlag.PUSHBACK].
	 */
	val FlamethrowerAttributes.AirblastAttributes.reverseAirblast: ItemAttributeNamed<Boolean> by ItemAttributeNamed("reverse airblast")
	/**
	 * Airblast pushes the pyro instead of enemies. Affected by airblast push force.
	 *
	 * Flamethrowers with this attribute cannot reflect projectiles.
	 */
	val FlamethrowerAttributes.AirblastAttributes.airblastDashes: ItemAttributeNamed<Boolean> by ItemAttributeNamed("airblast dashes")
	/**
	 * Sniper rifle charge rate when looking at the enemy. Still subject to the 200% charge rate limit
	 */
	val SniperRifleAttributes.multSniperChargePerSecWithEnemyUnderCrosshair: ItemAttributeNamed<Number> by ItemAttributeNamed("mult sniper charge per sec with enemy under crosshair")
	/**
	 * Plays `doomsday.warhead` sound when an enemy appears under your crosshair.
	 */
	val SniperRifleAttributes.sniperBeepWithEnemyUnderCrosshair: ItemAttributeNamed<Boolean> by ItemAttributeNamed("sniper beep with enemy under crosshair")
	/**
	 * If set to 1, enables healing buildings as medic. increases building healing rate by 10% for each point
	 */
	val MedigunAttributes.medicMachineryBeam: ItemAttributeNamed<Int> by ItemAttributeNamed("medic machinery beam")
	/**
	 * Bots with this attribute distribute their currency on death, like with sniper kills (red money)
	 */
	val MvMBotAttributes.forceDistributeCurrencyOnDeath by ItemAttributeNamed<Boolean>("force distribute currency on death")
}
