package btpos.source.vdfdsl.tf2.rafmod.attributes

import btpos.source.vdfdsl.tf2.itemattributes.BaseEntityAttributes
import btpos.source.vdfdsl.tf2.itemattributes.BaseGrenadeProjectileAttributes
import btpos.source.vdfdsl.tf2.itemattributes.BaseGunAttributes
import btpos.source.vdfdsl.tf2.itemattributes.BaseMeleeAttributes
import btpos.source.vdfdsl.tf2.itemattributes.BaseProjectileAttributes
import btpos.source.vdfdsl.tf2.itemattributes.BaseRocketAttributes
import btpos.source.vdfdsl.tf2.itemattributes.ColorCodec
import btpos.source.vdfdsl.tf2.itemattributes.CompoundBowAttributes
import btpos.source.vdfdsl.tf2.itemattributes.EconEntityAttributes
import btpos.source.vdfdsl.tf2.itemattributes.FlamethrowerAttributes
import btpos.source.vdfdsl.tf2.itemattributes.IAttributeContainer
import btpos.source.vdfdsl.tf2.itemattributes.ItemAttributeNamed
import btpos.source.vdfdsl.tf2.itemattributes.JarAttributes
import btpos.source.vdfdsl.tf2.itemattributes.LaserPointerAttributes
import btpos.source.vdfdsl.tf2.itemattributes.LunchboxDrinkAttributes
import btpos.source.vdfdsl.tf2.itemattributes.MedigunAttributes
import btpos.source.vdfdsl.tf2.itemattributes.MinigunAttributes
import btpos.source.vdfdsl.tf2.itemattributes.MvMBotAttributes
import btpos.source.vdfdsl.tf2.itemattributes.PlayerAttributes
import btpos.source.vdfdsl.tf2.itemattributes.ProjectileArrowAttributes
import btpos.source.vdfdsl.tf2.itemattributes.ProjectileFlareAttributes
import btpos.source.vdfdsl.tf2.itemattributes.ProjectileStickybombAttributes
import btpos.source.vdfdsl.tf2.itemattributes.RayGunAttributes
import btpos.source.vdfdsl.tf2.itemattributes.SapperAttributes
import btpos.source.vdfdsl.tf2.itemattributes.WeaponBaseAttributes
import btpos.source.vdfdsl.tf2.itemattributes.impl.IBlockScoped
import btpos.source.vdfdsl.tf2.rafmod.RafmodSerializers
import btpos.source.vdfdsl.tf2.rafmod.codecs.SetToIntCodec
import btpos.source.vdfdsl.tf2.rafmod.codecs.TFCondIndexSetCodec
import btpos.source.vdfdsl.tf2.rafmod.data.Rot3
import btpos.source.vdfdsl.tf2.rafmod.data.Vec3
import btpos.source.vdfdsl.tf2.rafmod.types.AttributesContainerAsAttribute
import btpos.source.vdfdsl.tf2.rafmod.types.AttrContainerWithDuration
import btpos.source.vdfdsl.tf2.rafmod.types.ItemModelAttachment
import btpos.source.vdfdsl.tf2.rafmod.types.Sound
import btpos.source.vdfdsl.tf2.rafmod.types.StunOnHitType
import btpos.source.vdfdsl.tf2.tftypes.TFCondition
import btpos.source.vdfdsl.utils.toSeconds
import java.awt.Color
import kotlin.time.Duration

object PotatoCustomAttributes {
	/**
	 * Disables movement prediction for homing projectiles. Might be useful for very slow projectiles.
	 *
	 * In-Game: "N range"
	 */
	val BaseProjectileAttributes.modProjectileHeatNoPredictTargetSpeed: ItemAttributeNamed<Int> by ItemAttributeNamed("mod projectile heat no predict target speed")
	
	/**
	 * Time in seconds before the projectile starts homing.
	 */
	val BaseProjectileAttributes.modProjectileHeatAimStartTime: ItemAttributeNamed<Int> by ItemAttributeNamed("mod projectile heat aim start time")
	
	/**
	 * Damage dealt to teammates multiplier. **Requires** "allow friendly fire" to be true.
	 *
	 * In-Game: "Allies receive (+-)N% damage"
	 */
	val BaseEntityAttributes.DamageAttributes.multDmgFriendlyFire: ItemAttributeNamed<Boolean> by ItemAttributeNamed("mult dmg friendly fire")
	
	/**
	 * Damage multiplier vs giants
	 *
	 * In-Game: "(+-)N% damage vs giants"
	 */
	val BaseEntityAttributes.DamageAttributes.multDmgVsGiants: ItemAttributeNamed<Number> by ItemAttributeNamed("mult dmg vs giants")
	
	/**
	 * Damage multiplier vs tanks
	 *
	 * In-Game: "(+-)N% damage vs tanks"
	 */
	val BaseEntityAttributes.DamageAttributes.multDmgVsTanks: ItemAttributeNamed<Number> by ItemAttributeNamed("mult dmg vs tanks")
	
	/**
	 * Damage multiplier vs npc - including Halloween bosses and tanks, excluding player bots
	 *
	 * In-Game: "(+-)N% damage vs npc"
	 */
	val BaseEntityAttributes.DamageAttributes.multDmgVsNpc: ItemAttributeNamed<Number> by ItemAttributeNamed("mult dmg vs npc")
	
	/**
	 * Custom sound played when an enemy is hit with the weapon
	 *
	 * 
	 */
	val BaseEntityAttributes.customHitSound: ItemAttributeNamed<Sound> by ItemAttributeNamed("custom hit sound")
	
	/**
	 * Custom sound played when a rocket / projectile / bullet hits something
	 *
	 * 
	 */
	val BaseEntityAttributes.customImpactSound: ItemAttributeNamed<Sound> by ItemAttributeNamed("custom impact sound")
	
	/**
	 * Custom weapon reload sound
	 *
	 * 
	 */
	val BaseEntityAttributes.customWeaponReloadSound: ItemAttributeNamed<Sound> by ItemAttributeNamed("custom weapon reload sound")
	
	/**
	 * No explosion particles and sounds
	 */
	val BaseProjectileAttributes.noExplosionParticles: ItemAttributeNamed<Boolean> by ItemAttributeNamed("no explosion particles")
	
	/**
	 * Special version of [override projectile type][BaseGunAttributes.ProjectilesAttributes.overrideProjectileType] that adds more projectile types.
	 */
	val BaseProjectileAttributes.overrideProjectileTypeExtra: ItemAttributeNamed<RafmodProjectileType> by ItemAttributeNamed("override projectile type extra", RafmodProjectileType::name)
	
	open class RafmodProjectileType(val name: String) {
		companion object {
			/**
			 * The projectile fired by the post-"Blue Moon" Short Circuit's alt-fire.
			 */
			val ShortCircuitOrb = RafmodProjectileType("mechanicalarmorb")
			
			/**
			 * The Sandman's alt-fire projectile.
			 */
			val Baseball = RafmodProjectileType("stunball")
			
			/**
			 * The Wrap Assassin's alt-fire projectile.
			 */
			val Ornament = RafmodProjectileType("ornament")
			
			val Jarate = RafmodProjectileType("jarate")
			
			val MadMilk = RafmodProjectileType("madmilk")
			
			val Cleaver = RafmodProjectileType("cleaver")
			
			/**
			 * The model used by the Gas Passer.
			 */
			val GasCan = RafmodProjectileType("gas")
			
			/**
			 * Uses the bread model that flies out of teleporters sometimes. Deals 40 damage on hit.
			 */
			val Bread = RafmodProjectileType("brick")
			
			val Repel = RafmodProjectileType("repel")
			
			/**
			 * The tumorous bread model that sticks to enemies from the Self-Aware Beauty Mark and Mutated Milk.
			 */
			val BreadMonster = RafmodProjectileType("breadmonster")
			
			/**
			 * Note: this is the only spell that will trigger `ShootTemplate` brushes.
			 */
			val SpellFireball = RafmodProjectileType("spellfireball")
			
			/**
			 * Note: This spell will not trigger `ShootTemplate` blocks.  For a spell that will, see [SpellFireball].
			 */
			val SpellLightningOrb = RafmodProjectileType("spelllightningorb")
			
			/**
			 * The "explosive boxing glove" spell from the Carnival of Carnage minigames.  (AKA "spell kart orb")
			 * 
			 * Note: This spell will not trigger `ShootTemplate` blocks.  For a spell that will, see [SpellFireball].
			 */
			val SpellBoxingGlove = RafmodProjectileType("spellkartorb")
			/**
			 * Note: This spell will not trigger `ShootTemplate` blocks.  For a spell that will, see [SpellFireball].
			 */
			val SpellBats = RafmodProjectileType("spellbats")
			
			/**
			 * AKA "MIRV": spawns a cluster of pumpkin bombs on the ground.  Requires the spellbook to be equipped.
			 * 
			 * Note: This spell will not trigger `ShootTemplate` blocks.  For a spell that will, see [SpellFireball].
			 */
			val SpellPumpkinBombs = RafmodProjectileType("spellmirv")
			
			/**
			 * Note: This spell will not trigger `ShootTemplate` blocks.  For a spell that will, see [SpellFireball].
			 */
			val SpellTransposeTeleport = RafmodProjectileType("spelltransposeteleport")
			/**
			 * Note: This spell will not trigger `ShootTemplate` blocks.  For a spell that will, see [SpellFireball].
			 */
			val SpellMeteorShower = RafmodProjectileType("spellmeteorshower")
			
			/**
			 * AKA "spawn boss". Summons a spectral team-aligned Monoculus that shoots enemy players.
			 * 
			 * Note: This spell will not trigger `ShootTemplate` blocks.  For a spell that will, see [SpellFireball].
			 */
			val SpellMonoculus = RafmodProjectileType("spellspawnboss")
			/**
			 * AKA "spawn horde". Summons team-colored skeletons. Requires the spellbook to be equipped.
			 *
			 * Note: This spell will not trigger `ShootTemplate` blocks.  For a spell that will, see [SpellFireball].
			 */
			val SpellSkeletons = RafmodProjectileType("spellspawnhorde")
		}
	}
	
	/**
	 * Deal additional damage; x * target's current health.
	 *
	 * In-Game: "On Hit: N% of enemy current health is applied as damage"
	 */
	val BaseEntityAttributes.DamageAttributes.dmgCurrentHealth: ItemAttributeNamed<Number> by ItemAttributeNamed("dmg current health")
	
	/**
	 * Deal additional damage; x * target's max health
	 *
	 * In-Game: "On Hit: N% of enemy max health is applied as damage"
	 */
	val BaseEntityAttributes.DamageAttributes.dmgMaxHealth: ItemAttributeNamed<Number> by ItemAttributeNamed("dmg max health")
	
	/**
	 * Deal additional damage; x * target's missing health
	 *
	 * In-Game: "On Hit: N% of enemy missing health is applied as damage"
	 */
	val BaseEntityAttributes.DamageAttributes.dmgMissingHealth: ItemAttributeNamed<Number> by ItemAttributeNamed("dmg missing health")
	
	/**
	 * If true, the player cannot be teleported
	 *
	 * In-Game: "Cannot be teleported"
	 */
	val PlayerAttributes.MovementAttributes.cannotBeTeleported: ItemAttributeNamed<Boolean> by ItemAttributeNamed("cannot be teleported")
	
	/**
	 * Medigun range multiplier
	 *
	 * In-Game: "(+-)N% medigun range"
	 */
	val MedigunAttributes.multMedigunRange: ItemAttributeNamed<Number> by ItemAttributeNamed("mult medigun range")
	
	/**
	 * Penetration limit for projectiles
	 *
	 * In-Game: "Penetrate up to N enemies"
	 */
	val BaseProjectileAttributes.projectilePenetrationLimit: ItemAttributeNamed<Int> by ItemAttributeNamed("projectile penetration limit")
	
	
	/**
	 * Max targets affected by explosives and flamethrowers
	 *
	 * In-Game: "Applies damage to N enemies"
	 */
	val BaseRocketAttributes.maxAoeTargets: ItemAttributeNamed<Int> by ItemAttributeNamed("max aoe targets")
	/**
	 * Max targets affected by explosives and flamethrowers
	 *
	 * In-Game: "Applies damage to N enemies"
	 */
	val BaseGrenadeProjectileAttributes.maxAoeTargets: ItemAttributeNamed<Int> by ItemAttributeNamed("max aoe targets")
	
	/**
	 * Max targets affected by explosives and flamethrowers
	 *
	 * In-Game: "Applies damage to N enemies"
	 */
	val FlamethrowerAttributes.FlamesAttributes.maxAoeTargets: ItemAttributeNamed<Int> by ItemAttributeNamed("max aoe targets")
	
	/**
	 * Effect condition override on drinks, jars, medigun ubercharges, and many other effect-causing weapons.
	 */
	val WeaponBaseAttributes.StatusEffectsAttributes.effectCondOverride: ItemAttributeNamed<TFCondition> by ItemAttributeNamed("effect cond override", serializer=TFCondition::index)
	
	/**
	 * Adds up to 4 conditions to the target on hit.
	 *
	 * @see addCondToTargetDuration
	 */
	val PlayerAttributes.OnHitAttributes.addCondToTarget: ItemAttributeNamed<Set<TFCondition>> by ItemAttributeNamed("add cond on hit", TFCondIndexSetCodec)
	
	/**
	 * How long the condition specified in [addCondToTarget] should be applied.
	 */
	val PlayerAttributes.OnHitAttributes.addCondToTargetDuration: ItemAttributeNamed<Duration> by ItemAttributeNamed("add cond on hit duration", Duration::toSeconds)
	
	/**
	 * Remove up to 4 conditions from the target on hit.
	 */
	val PlayerAttributes.OnHitAttributes.removeCondFromTarget: ItemAttributeNamed<Set<TFCondition>> by ItemAttributeNamed("remove cond on hit", TFCondIndexSetCodec)
	
	/**
	 * Adds condition to self when hitting a target
	 *
	 * @see addCondToSelfDuration
	 */
	val PlayerAttributes.OnHitAttributes.addCondToSelf: ItemAttributeNamed<TFCondition> by ItemAttributeNamed("self add cond on hit", TFCondition::index)
	
	/**
	 * Duration of the condition added to self by [addCondToSelf] when hitting a target.
	 */
	val PlayerAttributes.OnHitAttributes.addCondToSelfDuration: ItemAttributeNamed<Duration> by ItemAttributeNamed("self add cond on hit duration", Duration::toSeconds)
	
	/**
	 * Adds condition to self when killing a target.
	 *
	 * @see addCondOnKillDuration
	 */
	val PlayerAttributes.OnKillAttributes.addCondOnKill: ItemAttributeNamed<TFCondition> by ItemAttributeNamed("add cond on kill", TFCondition::index)
	
	/**
	 * How long the condition applied to yourself by [addCondOnKill] lasts.
	 */
	val PlayerAttributes.OnKillAttributes.addCondOnKillDuration: ItemAttributeNamed<Duration> by ItemAttributeNamed("add cond on kill duration", Duration::toSeconds)
	
	/**
	 * Add condition when weapon is active.
	 */
	val PlayerAttributes.SwapWeaponsAttributes.addCondWhenActive: ItemAttributeNamed<TFCondition> by ItemAttributeNamed("add cond when active")
	
	/**
	 * Add damage type to the attack. See [https://developer.valvesoftware.com/wiki/Half-Life_2/Damage_types] for a list of damage types.
	 */
	val PlayerAttributes.DamageAttributes.addDamageType: ItemAttributeNamed<Int> by ItemAttributeNamed("add damage type")
	
	/**
	 * Remove damage type from the attack
	 */
	val PlayerAttributes.DamageAttributes.removeDamageType: ItemAttributeNamed<Int> by ItemAttributeNamed("remove damage type")
	
	/**
	 * Sets a special damage type to a range from 1-3, to interact with the [multDmgTakenFromSpecialDamageType1], [multDmgTakenFromSpecialDamageType2], and [multDmgTakenFromSpecialDamageType3] attributes. Has no effect otherwise.
	 */
	val PlayerAttributes.DamageAttributes.specialDamageType: ItemAttributeNamed<Int> by ItemAttributeNamed("special damage type")
	
	/**
	 * Multiplier to damage taken from weapons with "[specialDamageType] = 1".
	 */
	val PlayerAttributes.ResistanceAttributes.multDmgTakenFromSpecialDamageType1: ItemAttributeNamed<Number> by ItemAttributeNamed("dmg taken mult from special damage type 1")
	
	/**
	 * Multiplier to damage taken from weapons with "[specialDamageType] = 2".
	 */
	val PlayerAttributes.ResistanceAttributes.multDmgTakenFromSpecialDamageType2: ItemAttributeNamed<Number> by ItemAttributeNamed("dmg taken mult from special damage type 2")
	
	/**
	 * Multiplier to damage taken from weapons with "[specialDamageType] = 3".
	 */
	val PlayerAttributes.ResistanceAttributes.multDmgTakenFromSpecialDamageType3: ItemAttributeNamed<Number> by ItemAttributeNamed("dmg taken mult from special damage type 3")
	
	/**
	 * Effect duration multiplier on drinks and jars (Crit-a-Cola, Jarate, etc.)
	 *
	 * In-Game: "(+-)N% effect duration"
	 */
	val JarAttributes.StatusEffectsAttributes.multEffectDuration: ItemAttributeNamed<Number> by ItemAttributeNamed("mult effect duration")
	
	/**
	 * Effect duration multiplier on drinks and jars (Crit-a-Cola, Jarate, etc.)
	 *
	 * In-Game: "(+-)N% effect duration"
	 */
	val LunchboxDrinkAttributes.StatusEffectsAttributes.multEffectDuration: ItemAttributeNamed<Number> by ItemAttributeNamed("mult effect duration")
	
	/**
	 * Shows text as an attribute if the weapon is inspected or shown as a custom weapon.
	 */
	val BaseEntityAttributes.MetaAttributes.specialItemDescription: ItemAttributeNamed<String> by ItemAttributeNamed("special item description")
	
	/**
	 * Flag carrier move speed multiplier
	 *
	 * In-Game: "(+-)N% flag carrier move speed"
	 */
	val PlayerAttributes.MovementAttributes.multFlagCarrierMoveSpeed: ItemAttributeNamed<Number> by ItemAttributeNamed("mult flag carrier move speed")
	
	/**
	 * If true and the weapon heals on kill, it can provide overheal
	 *
	 * In-Game: "Overheal from heal on kill"
	 */
	val PlayerAttributes.OnKillAttributes.overhealFromHealOnKill: ItemAttributeNamed<Boolean> by ItemAttributeNamed("overheal from heal on kill")
	
	/**
	 * Fire an input on hit targets. The player with the attribute is considered the !activator, the target hit is considered the !self. The format is &lt;target&gt;^&lt;input&gt;^&lt;param&gt;. If omitted, default param is damage received
	 */
	val PlayerAttributes.OnHitAttributes.fireInputOnTarget: ItemAttributeNamed<String> by ItemAttributeNamed("fire input on hit") // TODO Input
	
	/**
	 * Only fire an [input on hit][fireInputOnTarget] to the specified targetname or classname. Wildcards are allowed.
	 */
	val PlayerAttributes.OnHitAttributes.fireInputOnTargetNameRestrictions: ItemAttributeNamed<String> by ItemAttributeNamed("fire input on hit name restrict")
	
	/**
	 * Grenades bounce off walls, retaining x% of speed after each bounce. Also works on arrows.
	 *
	 * In-Game: "Grenades bounce off walls"
	 */
	val BaseGrenadeProjectileAttributes.bounceSpeed: ItemAttributeNamed<Number> by ItemAttributeNamed("grenade bounce speed")
	
	/**
	 * Grenades bounce off walls, retaining x% of speed after each bounce. Also works on arrows.
	 *
	 * In-Game: "Grenades bounce off walls"
	 */
	val ProjectileArrowAttributes.bounceSpeed: ItemAttributeNamed<Number> by ItemAttributeNamed("grenade bounce speed")
	
	/**
	 * Grenade bounce speed in xy direction multiplier
	 *
	 * In-Game: "(+-)N% xy bounce speed"
	 */
	val BaseGrenadeProjectileAttributes.bounceSpeedXy: ItemAttributeNamed<Number> by ItemAttributeNamed("grenade bounce speed xy")
	/**
	 * Grenade bounce speed in xy direction multiplier
	 *
	 * In-Game: "(+-)N% xy bounce speed"
	 */
	val ProjectileArrowAttributes.bounceSpeedXy: ItemAttributeNamed<Number> by ItemAttributeNamed("grenade bounce speed xy")
	
	/**
	 * Grenades explode on direct hits even if the grenade already touched a wall, dealing x% additional damage. Values below 1 will make the grenade deal less damage.
	 *
	 * In-Game: "Grenades can explode on direct hit after bouncing off walls, dealing (+-)N% damage"
	 */
	val BaseGrenadeProjectileAttributes.grenadeBounceDamage: ItemAttributeNamed<Number> by ItemAttributeNamed("grenade bounce damage")
	
	/**
	 * If true on the Huntsman, when the arrow bounces, allow it to hit the same target again. Requires "grenade bounce speed" or "arrow target bounce speed"
	 *
	 * In-Game: "Hits targets for another time after bounce"
	 */
	val ProjectileArrowAttributes.resetArrowHitsOnBounce: ItemAttributeNamed<Boolean> by ItemAttributeNamed("reset arrow hits on bounce")
	
	/**
	 * Projectiles bounce off hit targets, retaining x% of speed after each bounce.
	 *
	 * In-Game: "Projectiles bounce off hit targets"
	 */
	val ProjectileArrowAttributes.arrowTargetBounceSpeed: ItemAttributeNamed<Number> by ItemAttributeNamed("arrow target bounce speed")
	
	/**
	 * Gravity for arrows and flares. 0 is default gravity. For grenades and stickybombs, any value will disable gravity.
	 */
	val BaseProjectileAttributes.projectileGravityNative: ItemAttributeNamed<Number> by ItemAttributeNamed("projectile gravity native")
	
	/**
	 * No drag for grenades and stickybombs, slightly changes projectile arc.
	 *
	 * In-Game: "No drag on projectiles"
	 */
	val BaseGrenadeProjectileAttributes.disableAirResistance: ItemAttributeNamed<Boolean> by ItemAttributeNamed("grenade no drag")
	
	/**
	 * Stickybombs can stick to enemies on hit. If already stuck to the world, they will not get stuck on players.
	 *
	 * In-Game: "Stickbombs stick to enemies"
	 */
	val ProjectileStickybombAttributes.canStickToEnemies: ItemAttributeNamed<Boolean> by ItemAttributeNamed("stickybomb stick to enemies")
	
	/**
	 * Stickybombs do not stick to ground
	 *
	 * In-Game: "Stickbombs don't stick"
	 */
	val ProjectileStickybombAttributes.stickybombNoStick: ItemAttributeNamed<Boolean> by ItemAttributeNamed("stickybomb no stick")
	
	/**
	 * Bots killed by the weapon distribute their currency, like with sniper kills (red money)
	 *
	 * In-Game: "Automatically collects currency from destroyed robots"
	 */
	val WeaponBaseAttributes.OnKillAttributes.collectCurrency: ItemAttributeNamed<Boolean> by ItemAttributeNamed("collect currency on kill")
	
	/**
	 * Damage applied to enemies when touching them
	 *
	 * In-Game: "Deals N damage to touched enemies"
	 */
	val PlayerAttributes.DamageAttributes.stompPlayerDamage: ItemAttributeNamed<Int> by ItemAttributeNamed("stomp player damage")
	
	/**
	 * Time between each instance of stomp damage and push. By default, it happens every tick
	 *
	 */
	val PlayerAttributes.DamageAttributes.stompPlayerTime: ItemAttributeNamed<Duration> by ItemAttributeNamed("stomp player time", Duration::toSeconds)
	
	/**
	 * Force applied to enemies when touching them. 260 is the minimum amount to knock players up.
	 *
	 * In-Game: "Touched enemy players are knocked back"
	 */
	val PlayerAttributes.DamageAttributes.stompPlayerForce: ItemAttributeNamed<Number> by ItemAttributeNamed("stomp player force")
	
	/**
	 * Damage dealt to enemy buildings on touch
	 */
	val PlayerAttributes.DamageAttributes.stompBuildingDamage: ItemAttributeNamed<Int> by ItemAttributeNamed("stomp building damage")
	
	/**
	 * Projectiles reflected by this weapon keep their original team
	 *
	 * In-Game: "Reflected projectiles keep their original team"
	 */
	val WeaponBaseAttributes.reflectedProjectilesKeepTeam: ItemAttributeNamed<Boolean> by ItemAttributeNamed("reflect keep team")
	
	/**
	 * Custom minigun wind up sound. Does not override default sound
	 */
	val MinigunAttributes.customWindUpSound: ItemAttributeNamed<Sound> by ItemAttributeNamed("custom wind up sound")
	
	/**
	 * Custom minigun wind down sound. Does not override default sound
	 */
	val MinigunAttributes.customWindDownSound: ItemAttributeNamed<Sound> by ItemAttributeNamed("custom wind down sound")
	
	/**
	 * Custom minigun spin sound. The sound will not loop unless its made to loop
	 */
	val MinigunAttributes.customMinigunSpinSound: ItemAttributeNamed<Sound> by ItemAttributeNamed("custom minigun spin sound")
	
	/**
	 * If true, reflected projectiles aim towards the reflector
	 *
	 * In-Game: "Reflects projectiles towards pyro"
	 */
	val FlamethrowerAttributes.AirblastAttributes.reflectMagnet: ItemAttributeNamed<Boolean> by ItemAttributeNamed("reflect magnet")
	
	/**
	 * If true, the weapon will stay after touching a resupply cabinet or upgrading, if the weapon in the inventory in the slot is different
	 */
	val BaseEntityAttributes.stayAfterRegenerate: ItemAttributeNamed<Boolean> by ItemAttributeNamed("stay after regenerate")
	
	/**
	 * If set to any value other than 0, sets custom arrow kill time after hitting something
	 */
	val ProjectileArrowAttributes.arrowHitKillTime: ItemAttributeNamed<Duration> by ItemAttributeNamed("arrow hit kill time", Duration::toSeconds)
	
	/**
	 * Sentry cost multiplier
	 *
	 * In-Game: "(+-)N% sentry cost"
	 */
	val PlayerAttributes.BuildingsAttributes.SentryGunAttributes.modSentryCost: ItemAttributeNamed<Number> by ItemAttributeNamed("mod sentry cost")
	
	/**
	 * Dispenser cost multiplier
	 *
	 * In-Game: "(+-)N% dispenser cost"
	 */
	val PlayerAttributes.BuildingsAttributes.DispenserAttributes.modDispenserCost: ItemAttributeNamed<Number> by ItemAttributeNamed("mod dispenser cost")
	
	/**
	 * Bullets and projectiles penetrate teammates, like sniper rifles.
	 */
	val BaseProjectileAttributes.canPenetrateTeammates: ItemAttributeNamed<Boolean> by ItemAttributeNamed("penetrate teammates")
	
	/**
	 * Step height multiplier (x * 18hu); allows the player to not need to jump for greater heights
	 *
	 * In-Game: "(+-)N% step height"
	 */
	val PlayerAttributes.MovementAttributes.multStepHeight: ItemAttributeNamed<Number> by ItemAttributeNamed("mult step height")
	
	/**
	 * Ignore player clip brushes
	 */
	val PlayerAttributes.ignorePlayerClipBrushes: ItemAttributeNamed<Boolean> by ItemAttributeNamed("ignore player clip")
	
	/**
	 * Allow bunny hopping. 1 - auto bhop. 2 - manual bhop
	 *
	 * In-Game: "Can bunny hop"
	 */
	val PlayerAttributes.MovementAttributes.allowBunnyHop: ItemAttributeNamed<Int> by ItemAttributeNamed("allow bunny hop")
	
	/**
	 * Fire input on killed targets. The player with the attribute is considered the !activator, the target killed is considered the !self. The format is <target>^<input>^<param>. If omitted, default param is damage received. !projectile is the projectile entity
	 */
	val PlayerAttributes.OnKillAttributes.fireInputOnTarget: ItemAttributeNamed<String> by ItemAttributeNamed("fire input on kill") // TODO input
	
	/**
	 * Only fire an [input on kill][fireInputOnTarget] if the target has the specified targetname. Wildcards are allowed
	 */
	val PlayerAttributes.OnKillAttributes.fireInputOnTargetNameRestriction: ItemAttributeNamed<String> by ItemAttributeNamed("fire input on kill name restrict")
	
	/**
	 * Fire the weapon's entire clip in a single burst.  For one shot at a time, see [forceFireFullClip].
	 *
	 * In-Game: "Fires full clip at once"
	 */
	val BaseGunAttributes.FiringAttributes.fireFullClipAtOnce: ItemAttributeNamed<Int> by ItemAttributeNamed("fire full clip at once")
	
	/**
	 * Reload full clip at once, like pistols
	 *
	 * In-Game: "Reloads full clip at once"
	 */
	val BaseGunAttributes.ReloadingAttributes.reloadFullClipAtOnce: ItemAttributeNamed<Int> by ItemAttributeNamed("reload full clip at once")
	
	/**
	 * Automatically fire full clip, one shot at a time. Not to be confused with [fireFullClipAtOnce].
	 *
	 * In-Game: "Fires full clip automatically"
	 */
	val BaseGunAttributes.FiringAttributes.forceFireFullClip: ItemAttributeNamed<Int> by ItemAttributeNamed("force fire full clip")
	
	/**
	 * Sound played when the projectile is fired
	 */
	val BaseProjectileAttributes.projectileSound: ItemAttributeNamed<Sound> by ItemAttributeNamed("projectile sound")
	
	/**
	 * Fire this many rounds in a burst. If negative, forces to fire this many rounds even if attack button is only pressed once
	 *
	 * In-Game: "Fires N rounds in burst"
	 */
	val BaseGunAttributes.FiringAttributes.burstFireCount: ItemAttributeNamed<Int> by ItemAttributeNamed("burst fire count")
	
	/**
	 * Fire rate multiplier between bursts. Regular fire rate is used for the time between shots in a burst.
	 *
	 * In-Game: "(+-)N% fire rate in burst"
	 */
	val BaseGunAttributes.FiringAttributes.burstFireRateMult: ItemAttributeNamed<Number> by ItemAttributeNamed("burst fire rate mult")
	
	/**
	 * Accuracy multiplier, continous attacking increases/decreases accuracy up to specified value over the duration of "continous accuracy time" attribute. Overwrites "spread penalty" attribute
	 *
	 * In-Game: "(+-)N% accurate over time"
	 *
	 * @see continuousAccuracyTime
	 */
	val BaseGunAttributes.FiringAttributes.continuousAccuracyMult: ItemAttributeNamed<Number> by ItemAttributeNamed("continous accuracy mult")
	
	/**
	 * How long in seconds should the weapon be fired continously to reach full [continuousAccuracyMult] value
	 *
	 * In-Game: "Up to (+-)N% accurate over time"
	 */
	val BaseGunAttributes.FiringAttributes.continuousAccuracyTime: ItemAttributeNamed<Duration> by ItemAttributeNamed("continous accuracy time", Duration::toSeconds)
	
	/**
	 * Accuracy multiplier when ducking. Overwrites "spread penalty" attribute
	 *
	 * In-Game: "(+-)N% accurate when crouching"
	 */
	val BaseGunAttributes.FiringAttributes.duckAccuracyMult: ItemAttributeNamed<Number> by ItemAttributeNamed("duck accuracy mult")
	
	/**
	 * Accuracy multiplier when moving. Overwrites "spread penalty" attribute
	 *
	 * In-Game: "(+-)N% accurate when moving"
	 */
	val BaseGunAttributes.FiringAttributes.moveAccuracyMult: ItemAttributeNamed<Number> by ItemAttributeNamed("move accuracy mult")
	
	/**
	 * Additional item description line
	 */
	val EconEntityAttributes.MetaAttributes.ItemsAttributes.specialItemDescription2: ItemAttributeNamed<String> by ItemAttributeNamed("special item description 2")
	
	/**
	 * Additional item description line
	 */
	val EconEntityAttributes.MetaAttributes.ItemsAttributes.specialItemDescription3: ItemAttributeNamed<String> by ItemAttributeNamed("special item description 3")
	
	/**
	 * Additional item description line
	 */
	val EconEntityAttributes.MetaAttributes.ItemsAttributes.specialItemDescription4: ItemAttributeNamed<String> by ItemAttributeNamed("special item description 4")
	
	/**
	 * Allowed building types, add values together to allow multiple buildings:
	 *
	 * 1 - dispenser
	 *
	 *
	 *
	 * 2 - teleporter
	 *
	 *
	 *
	 * 4 - sentry gun
	 *
	 *
	 *
	 * 8 - sapper
	 *
	 * In-Game: "Allowed build types"
	 */
	val PlayerAttributes.BuildingsAttributes.allowedToBuild: ItemAttributeNamed<Set<AllowedBuildingType>> by ItemAttributeNamed("allowed build types", SetToIntCodec(AllowedBuildingType::i) { 0 })
	
	class AllowedBuildingType(val i: Int) {
		companion object {
			val Dispenser = AllowedBuildingType(1)
			val Teleporter = AllowedBuildingType(2)
			val SentryGun = AllowedBuildingType(4)
			val Sapper = AllowedBuildingType(8)
		}
	}
	
	/**
	 * Max bullet range in hu
	 *
	 * In-Game: "N range"
	 */
	val BaseGunAttributes.ProjectilesAttributes.BulletsAttributes.maxBulletRange: ItemAttributeNamed<Int> by ItemAttributeNamed("max bullet range")
	
	/**
	 * Make weapons that apply addcond effects, such as banners, jars, etc., also apply attributes to the affected player for the duration of the status effect.
	 *
	 * Example:
	 * ```kotlin
	 * TFBot {
	 *   items += Weapons.JARATE.withAttributes {
	 *      // Make the Jarate cut health received in half
	 *      applyAttributesOnEffect = AttributeContainer {
	 *          PlayerAttributes.healthAndHealing.multHealthFromHealers = 0.5
	 *      }
	 *   }
	 * }
	 * ```
	 */
	val WeaponBaseAttributes.StatusEffectsAttributes.applyAttributesOnEffect: ItemAttributeNamed<IAttributeContainer> by ItemAttributeNamed("effect add attributes", ::AttributesContainerAsAttribute)
	
	/**
	 * Attributes added passively to the player being healed by this Medi-Gun.
	 *
	 * Example:
	 * ```kotlin
	 * TFBot {
	 *   items += Weapons.MEDIGUN.withAttributes {
	 *      // Make it increase reload speed for the heal target
	 *      applyAttributesToPatient = AttributeContainer {
	 *          PlayerAttributes.reloading.multReloadTime = 0.5
	 *      }
	 *   }
	 * }
	 * ```
	 */
	val MedigunAttributes.applyAttributesToPatient: ItemAttributeNamed<IAttributeContainer> by ItemAttributeNamed("medigun passive attributes", ::AttributesContainerAsAttribute)
	
	/**
	 * Attributes added passively to yourself while healing someone.
	 *
	 * Example:
	 * ```kotlin
	 * TFBot {
	 *   items += Weapons.MEDIGUN.withAttributes {
	 *      // Make yourself 50% tankier while healing someone
	 *      applyAttributesToSelfWhileHealing = AttributeContainer {
	 *          PlayerAttributes.resistance.multDmgFromRanged = 0.5
	 *      }
	 *   }
	 * }
	 * ```
	 */
	val MedigunAttributes.applyAttributesToSelfWhileHealing: ItemAttributeNamed<IAttributeContainer> by ItemAttributeNamed("medigun passive attributes", ::AttributesContainerAsAttribute)
	
	/**
	 * Attributes added passively to the medic healing you
	 *
	 * Example:
	 * ```kotlin
	 * TFBot {
	 *   characterAttributes {
	 *      // Make your medic 50% tankier while they're healing you
	 *      PlayerAttributes {
	 *          healthAndHealing.applyAttributesToHealer = AttributeContainer {
	 *              resistance.multDmgFromRanged = 0.5
	 *          }
	 *      }
	 *   }
	 * }
	 * ```
	 */
	val PlayerAttributes.HealthAndHealingAttributes.applyAttributesToHealer: ItemAttributeNamed<IAttributeContainer> by ItemAttributeNamed("medigun passive attributes owner", ::AttributesContainerAsAttribute)
	
	/**
	 * Damage multiplier vs blast-jumping players
	 *
	 * In-Game: "(+-)N% damage vs players launched by explosions"
	 */
	val WeaponBaseAttributes.DamageAttributes.multDmgVsAirborne: ItemAttributeNamed<Number> by ItemAttributeNamed("mult dmg vs airborne")
	
	/**
	 * Medigun revive speed multiplier
	 *
	 * In-Game: "(+-)N% revive rate"
	 */
	val MedigunAttributes.multReviveRate: ItemAttributeNamed<Number> by ItemAttributeNamed("revive rate")
	
	/**
	 * Taunt attack happens even after taunt ends or is interrupted
	 *
	 * In-Game: "Taunt attack may happen even after the taunt ended"
	 */
	val PlayerAttributes.TauntingAttributes.tauntAttackAfterEnd: ItemAttributeNamed<Int> by ItemAttributeNamed("taunt attack after end")
	
	/**
	 * Taunt attack time multiplier, making it happen earlier/later
	 *
	 * In-Game: "(+-)N% taunt attack time"
	 */
	val PlayerAttributes.TauntingAttributes.tauntAttackTimeMult: ItemAttributeNamed<Number> by ItemAttributeNamed("taunt attack time mult")
	
	/**
	 * Returns `x * damage dealt` as health
	 *
	 * In-Game: "(+-)N% damage dealt is returned as health"
	 */
	val WeaponBaseAttributes.HealthAndHealingAttributes.healOnDamage: ItemAttributeNamed<Number> by ItemAttributeNamed("damage returns as health")
	
	/**
	 * Cannot resupply from cabinets
	 *
	 * In-Game: "Cannot resupply"
	 */
	val PlayerAttributes.AmmoAttributes.noResupply: ItemAttributeNamed<Boolean> by ItemAttributeNamed("no resupply")
	
	/**
	 * No view flinch from taking damage
	 *
	 * In-Game: "No view flinch when taking damage"
	 */
	val PlayerAttributes.WhenHitAttributes.noDamageViewFlinch: ItemAttributeNamed<Boolean> by ItemAttributeNamed("no damage view flinch")
	
	/**
	 * If true, the Wrangler's sentry shield is disabled
	 *
	 * In-Game: "No wrangler shield"
	 */
	val LaserPointerAttributes.disableWranglerShield: ItemAttributeNamed<Boolean> by ItemAttributeNamed("disable wrangler shield")
	
	/**
	 * Allow infinite mid-air parachute redeploying
	 *
	 * In-Game: "Parachute redeploying is allowed"
	 */
	val PlayerAttributes.MovementAttributes.parachuteRedeploy: ItemAttributeNamed<Boolean> by ItemAttributeNamed("parachute redeploy")
	
	/**
	 * Ducking speed multiplier. 3 is for walking speed. Cannot be faster than walking speed
	 *
	 * In-Game: "(+-)N% move speed while crouching"
	 */
	val PlayerAttributes.MovementAttributes.multDuckSpeed: ItemAttributeNamed<Number> by ItemAttributeNamed("mult duck speed")
	
	/**
	 * RGB color for projectile particles that support it (Bison, Pomson)
	 */
	val RayGunAttributes.particleColorRgb: ItemAttributeNamed<Color> by ItemAttributeNamed("particle color rgb", ColorCodec::write)
	
	/**
	 * Cycles colors for the projectile particle. Higher values cycle faster
	 *
	 */
	val RayGunAttributes.particleColorRainbow: ItemAttributeNamed<Boolean> by ItemAttributeNamed("particle color rainbow")
	
	/**
	 * If true, enemy sentries ignore the player
	 *
	 * In-Game: "Ignored by enemy sentries"
	 */
	val PlayerAttributes.ignoredByEnemySentries: ItemAttributeNamed<Boolean> by ItemAttributeNamed("ignored by enemy sentries")
	
	/**
	 * If true, melee swings will reflect projectiles
	 *
	 * In-Game: "Attack reflects projectiles"
	 */
	val BaseMeleeAttributes.canReflectProjectiles: ItemAttributeNamed<Boolean> by ItemAttributeNamed("melee airblast")
	
	/**
	 * Automatically reloads the weapon while not active. Since the reload speed is tied to animations this will make weapons reload faster than usual
	 *
	 * In-Game: "Weapon is automatically reloaded when not active"
	 */
	val WeaponBaseAttributes.ReloadingAttributes.passiveReload: ItemAttributeNamed<Boolean> by ItemAttributeNamed("passive reload")
	
	/**
	 * Attributes enabling and controlling a slam attack that occurs when hitting the ground at speed.
	 */
	val PlayerAttributes.fallingSlam get() = FallingSlamAttributes
	
	object FallingSlamAttributes : IBlockScoped {
		/**
		 * Enables knockback, stun and damage nearby enemies when landing. The value specifies the minimum fall velocity in HU/s before applying knockback.
		 *
		 * In-Game: "On fall, all enemies nearby are knocked back"
		 */
		val minVelocity: ItemAttributeNamed<Number> by ItemAttributeNamed("kb fall min velocity")
		
		/**
		 * The radius of the fall knockback caused by [minVelocity]. 230 HU by default
		 *
		 * In-Game: "On fall, all enemies nearby are knocked back"
		 */
		val slamRadius: ItemAttributeNamed<Int> by ItemAttributeNamed("kb fall radius")
		
		/**
		 * Small robot stun time of the fall knockback caused by [minVelocity]. 5 seconds by default
		 *
		 * In-Game: "On fall, all enemies nearby are knocked back"
		 */
		val stunTime: ItemAttributeNamed<Duration> by ItemAttributeNamed("kb fall stun time", Duration::toSeconds)
		
		/**
		 * Fall knockback force caused by [minVelocity]. 300 by default
		 *
		 * In-Game: "On fall, all enemies nearby are knocked back"
		 */
		val force: ItemAttributeNamed<Number> by ItemAttributeNamed("kb fall force")
		
		/**
		 * Fall knockback damage caused by [minVelocity]. 50 by default
		 *
		 * In-Game: "On fall, all enemies nearby are knocked back"
		 */
		val damage: ItemAttributeNamed<Int> by ItemAttributeNamed("kb fall damage")
	}
	
	
	/**
	 * Melee attacks grant protection from attacks for x seconds
	 *
	 * In-Game: "Attacking with this weapon gives you resistance to incoming damage for a brief period of time"
	 */
	val BaseMeleeAttributes.ResistanceAttributes.gainResistanceOnSwing: ItemAttributeNamed<Duration> by ItemAttributeNamed("melee grants protection", Duration::toSeconds)
	
	/**
	 * If set on the Huntsman, snaps the arrow to the next closest available target within range
	 *
	 * In-Game: "Projectiles snap to the next nearest target after being hit"
	 */
	val CompoundBowAttributes.arrowSnapToNextTargetRadius: ItemAttributeNamed<Boolean> by ItemAttributeNamed("arrow snap to next target radius")
	
	/**
	 * Credit collection radius multiplier. Scouts have a 4x bigger collection radius
	 *
	 * In-Game: "(+-)N% credit collection range"
	 */
	val PlayerAttributes.multCreditCollectRange: ItemAttributeNamed<Number> by ItemAttributeNamed("mult credit collect range")
	
	/**
	 * Additional health gained from collecting credits. Scouts usually gain 50 health on collecting credits
	 *
	 * In-Game: "(+-)N health gained from credits"
	 */
	val PlayerAttributes.HealthAndHealingAttributes.healthFromCredits: ItemAttributeNamed<Int> by ItemAttributeNamed("health from credits")
	
	/**
	 * Delay between bleed damage ticks. Lower values causes bleed damage to happen more times per second.
	 *
	 * In-Game: "(+-)N% bleeding damage delay"
	 */
	val WeaponBaseAttributes.StatusEffectsAttributes.multBleedingDelay: ItemAttributeNamed<Number> by ItemAttributeNamed("mult bleeding delay")
	
	/**
	 * Bleeding damage multiplier
	 *
	 * In-Game: "(+-)N% bleeding damage"
	 */
	val WeaponBaseAttributes.DamageAttributes.multBleedDmg: ItemAttributeNamed<Number> by ItemAttributeNamed("mult bleeding dmg")
	
	/**
	 * If true, the player can phase though walls
	 *
	 * In-Game: "Player is not solid"
	 */
	val PlayerAttributes.MovementAttributes.canGoThroughWalls: ItemAttributeNamed<Boolean> by ItemAttributeNamed("not solid")
	
	/**
	 * Self damage multiplier for the player
	 *
	 * In-Game: "(+-)N% damage taken from self"
	 */
	val PlayerAttributes.ResistanceAttributes.multSelfDamageTaken: ItemAttributeNamed<Number> by ItemAttributeNamed("dmg taken from self reduced")
	
	/**
	 * If true, the player is ignored by bots.
	 *
	 * In-Game: "Ignored by bots"
	 */
	val PlayerAttributes.ignoredByBots: ItemAttributeNamed<Boolean> by ItemAttributeNamed("ignored by bots")
	
	/**
	 * Apply attributes to victim on hit with the weapon for the given length of time.
	 *
	 * Example:
	 * ```kotlin
	 * TFBot {
	 *   items += Weapons.SMG.withAttributes {
	 *      // Make your enemy take 50% more damage for 30 seconds on hit
	 *      onHit.addAttributesToTarget(defaultDuration = 5.seconds) {
	 *      	PlayerAttributes {
	 *              resistance {
	 *                 multDmgFromMelee = 1.5 to 30.seconds
	 *
	 *                 // alternate way to set an attribute with a duration
	 *                 multDmgFromRanged.setWithDuration(1.5, 30.seconds)
	 *             }
	 *
	 *             // Uses the default duration of 5 seconds set in addAttributes()
	 *             damage.multDmg = 0.5
	 *          }
	 *      }
	 *   }
	 * }
	 * ```
	 */
	val WeaponBaseAttributes.OnHitAttributes.addAttributesToTarget: ItemAttributeNamed<AttrContainerWithDuration> by ItemAttributeNamed("add attributes on hit")
	
	
	context(_: IAttributeContainer)
	inline operator fun ItemAttributeNamed<AttrContainerWithDuration>.invoke(defaultDuration: Duration? = null, configure: context(AttrContainerWithDuration) () -> Unit) {
		val current = this.get() ?: AttrContainerWithDuration(defaultDuration)
		
		context (current) {
			configure()
		}
		
		this.set(current)
	}
	
	/**
	 * Apply attributes to yourself on dealing damage with the weapon.
	 *
	 * In-Game: "Attribute on hit"
	 *
	 * Example:
	 * ```kotlin
	 * items += Weapons.AMPUTATOR.withAttributes {
	 *   // Increase healing and ubercharge rate on hit for 15 seconds, using explicit duration:
	 *   onHit.addAttributesToSelf(15.seconds) {
	 *     MedigunAttributes.healRate = 1.5 to 15.seconds
	 *     MedigunAttributes.uberchargeRate.setWithDuration(4.0, 15.seconds)
	 *   }
	 *
	 *   // Increase the same for 15 seconds on kill, using a default duration:
	 *   onKill.addAttributesToSelf(defaultDuration = 15.seconds) {
	 *     MedigunAttributes.healRate = 3.0
	 *     MedigunAttributes.uberchargeRate.set(8.0)
	 *   }
	 * }
	 * ```
	 *
	 * @see WeaponBaseAttributes.OnHitAttributes.addAttributesToTarget
	 * @see WeaponBaseAttributes.OnKillAttributes.addAttributesToSelf
	 */
	val WeaponBaseAttributes.OnHitAttributes.addAttributesToSelf: ItemAttributeNamed<AttrContainerWithDuration> by ItemAttributeNamed("self add attributes on hit")
	
	/**
	 * `Apply attributes to self on kill with the weapon. Format: attribute|value|duration ...`
	 *
	 * In-Game: "Attribute on kill"
	 *
	 * Example:
	 * ```kotlin
	 * items += Weapons.AMPUTATOR.withAttributes {
	 *   // Increase healing and ubercharge rate on hit for 15 seconds, using explicit duration:
	 *   onHit.addAttributesToSelf(15.seconds) {
	 *     MedigunAttributes.healRate = 1.5 to 15.seconds
	 *     MedigunAttributes.uberchargeRate.setWithDuration(4.0, 15.seconds)
	 *   }
	 *
	 *   // Increase the same on kill for 15 seconds, using default duration:
	 *   onKill.addAttributesToSelf(15.seconds) {
	 *     MedigunAttributes.healRate = 3.0
	 *     MedigunAttributes.uberchargeRate.set(8.0)
	 *   }
	 * }
	 * ```
	 *
	 * @see WeaponBaseAttributes.OnHitAttributes.addAttributesToSelf
	 */
	val WeaponBaseAttributes.OnKillAttributes.addAttributesToSelf: ItemAttributeNamed<AttrContainerWithDuration> by ItemAttributeNamed("add attributes on kill")
	
	/**
	 * Multiply move speed up to x with decreasing health
	 *
	 * In-Game: "Up to (+-)N% move speed as health decreases"
	 */
	val PlayerAttributes.MovementAttributes.moveSpeedAsHealthDecreases: ItemAttributeNamed<Int> by ItemAttributeNamed("move speed as health decreases")
	
	/**
	 * If true, the weapon cannot ignite or cause bleeding to the wielder
	 *
	 * In-Game: "Cannot ignite or cause bleeding to the wielder"
	 */
	val WeaponBaseAttributes.StatusEffectsAttributes.noSelfEffect: ItemAttributeNamed<Boolean> by ItemAttributeNamed("no self effect")
	
	/**
	 * Cannot pickup spells
	 *
	 * In-Game: "Cannot pickup spells"
	 */
	val PlayerAttributes.MetaAttributes.GameplayAttributes.cannotPickupSpells: ItemAttributeNamed<Boolean> by ItemAttributeNamed("cannot pickup spells")
	
	/**
	 * Max health multiplier
	 *
	 * In-Game: "(+-)N% Max health"
	 */
	val PlayerAttributes.HealthAndHealingAttributes.multMaxHealth: ItemAttributeNamed<Number> by ItemAttributeNamed("mult max health")
	
	/**
	 * Bullet spread additive. Does not affect clientside effects
	 *
	 * In-Game: "(+-)N bullet spread"
	 */
	val WeaponBaseAttributes.ProjectilesAttributes.BulletsAttributes.addSpread: ItemAttributeNamed<Int> by ItemAttributeNamed("add spread")
	
	/**
	 * Projectile spread angle multiplier
	 *
	 * In-Game: "(+-)N% projectile spread angle"
	 */
	val BaseProjectileAttributes.projectileSpreadAngleMult: ItemAttributeNamed<Number> by ItemAttributeNamed("projectile spread angle mult")
	
	/**
	 * Always allow the spy to disguise
	 *
	 * In-Game: "always allow disguising"
	 */
	val PlayerAttributes.DisguiseAttributes.alwaysAllowDisguise: ItemAttributeNamed<Boolean> by ItemAttributeNamed("always allow disguise")
	
	/**
	 * Always allow the spy to cloak
	 *
	 * In-Game: "always allow cloaking"
	 */
	val PlayerAttributes.CloakAttributes.alwaysAllowCloak: ItemAttributeNamed<Boolean> by ItemAttributeNamed("always allow cloak")
	
	/**
	 * Always allow the player to teleport
	 *
	 * In-Game: "always allow teleporting"
	 */
	val PlayerAttributes.MovementAttributes.alwaysAllowTeleport: ItemAttributeNamed<Boolean> by ItemAttributeNamed("always allow teleport")
	
	/**
	 * Destroy owned buildings on death
	 *
	 * In-Game: "Owned buildings are destroyed on death"
	 */
	val PlayerAttributes.BuildingsAttributes.destroyBuildingsOnDeath: ItemAttributeNamed<Boolean> by ItemAttributeNamed("destroy buildings on death")
	
	/**
	 * Sentry bullet weapon name. Can be a custom weapon name
	 *
	 * In-Game: "Sentry bullet weapon"
	 */
	val PlayerAttributes.BuildingsAttributes.SentryGunAttributes.sentryBulletWeapon: ItemAttributeNamed<String> by ItemAttributeNamed("sentry bullet weapon")
	
	/**
	 * Sentry rocket weapon name. Can be a custom weapon name
	 *
	 * In-Game: "Sentry rocket weapon"
	 */
	val PlayerAttributes.BuildingsAttributes.SentryGunAttributes.sentryRocketWeapon: ItemAttributeNamed<String> by ItemAttributeNamed("sentry rocket weapon")
	
	/**
	 * Custom sentry model file name or prefix
	 
	 */
	val PlayerAttributes.BuildingsAttributes.SentryGunAttributes.customSentryModel: ItemAttributeNamed<String> by ItemAttributeNamed("custom sentry model")
	
	/**
	 * Custom dispenser model file name or prefix
	 
	 */
	val PlayerAttributes.BuildingsAttributes.DispenserAttributes.customDispenserModel: ItemAttributeNamed<String> by ItemAttributeNamed("custom dispenser model")
	
	/**
	 * Custom teleporter model file name or prefix
	 
	 */
	val PlayerAttributes.BuildingsAttributes.TeleporterAttributes.customTeleporterModel: ItemAttributeNamed<String> by ItemAttributeNamed("custom teleporter model")
	
	/**
	 * Sentry rocket ammo multiplier
	 *
	 * In-Game: "(+-)N% sentry rocket ammo capacity"
	 */
	val PlayerAttributes.BuildingsAttributes.SentryGunAttributes.multSentryRocketAmmo: ItemAttributeNamed<Number> by ItemAttributeNamed("mult sentry rocket ammo")
	
	/**
	 * Midair accuracy multiplier
	 *
	 * In-Game: "(+-)N% accurate when midair"
	 */
	val PlayerAttributes.FiringAttributes.midairAccuracyMult: ItemAttributeNamed<Number> by ItemAttributeNamed("midair accuracy mult")
	
	/**
	 * Damage bonus for every target hit by explosion
	 *
	 * In-Game: "(+-)N% damage for every target hit by explosion"
	 */
	val PlayerAttributes.DamageAttributes.addDamagePerTarget: ItemAttributeNamed<Number> by ItemAttributeNamed("add damage per target")
	
	/**
	 * Projectile self detonation time in seconds
	 *
	 * In-Game: "Projectiles self detonate in N seconds after being fired"
	 */
	val BaseProjectileAttributes.projectileDetonateTime: ItemAttributeNamed<Duration> by ItemAttributeNamed("projectile detonate time", Duration::toSeconds)
	
	/**
	 * Multiplier for the delay between afterburn damage ticks, similar to [multBleedingDelay]. Lower values result in more damage per second.
	 *
	 * In-Game: "(+-)N% afterburn damage delay"
	 */
	val WeaponBaseAttributes.AfterburnAttributes.multAfterburnDelay: ItemAttributeNamed<Number> by ItemAttributeNamed("mult afterburn delay")
	
	/**
	 * Custom view model. This typically affects first person hands and their animations
	 *
	 * Example:
	 * ```
	 * customViewModel = "models/model.mdl"
	 * ```
	 */
	val PlayerAttributes.MetaAttributes.customViewModel: ItemAttributeNamed<String> by ItemAttributeNamed("custom view model")
	
	/**
	 * Damage multiplier while midair, regardless of if you're blast-jumping.
	 *
	 * In-Game: "(+-)N% damage while midair"
	 */
	val PlayerAttributes.DamageAttributes.multDmgWhileMidair: ItemAttributeNamed<Number> by ItemAttributeNamed("mult dmg while midair")
	
	/**
	 * Attribute for storing hidden text in items.
	 */
	val BaseEntityAttributes.MetaAttributes.hiddenStringAttribute1: ItemAttributeNamed<String> by ItemAttributeNamed("hidden string attribute 1")
	/**
	 * Attribute for storing hidden text in items.
	 */
	val BaseEntityAttributes.MetaAttributes.hiddenStringAttribute2: ItemAttributeNamed<String> by ItemAttributeNamed("hidden string attribute 2")
	/**
	 * Attribute for storing hidden text in items.
	 */
	val BaseEntityAttributes.MetaAttributes.hiddenStringAttribute3: ItemAttributeNamed<String> by ItemAttributeNamed("hidden string attribute 3")
	/**
	 * Attribute for storing hidden text in items.
	 */
	val BaseEntityAttributes.MetaAttributes.hiddenStringAttribute4: ItemAttributeNamed<String> by ItemAttributeNamed("hidden string attribute 4")
	
	/**
	 * Keep custom medigun uber effect after the beam is disconnected until the uber meter runs out
	 */
	val MedigunAttributes.medigunKeepChargedEffect: ItemAttributeNamed<Boolean> by ItemAttributeNamed("medigun keep charged effect")
	
	/**
	 * This projectile will never collide with other projectiles.
	 */
	val BaseProjectileAttributes.ignoresOtherProjectiles: ItemAttributeNamed<Boolean> by ItemAttributeNamed("ignores other projectiles")
	
	/**
	 * This weapon always gibs killed enemies
	 *
	 * In-Game: "Always gibs enemies"
	 */
	val WeaponBaseAttributes.RagdollsAttributes.alwaysGibs: ItemAttributeNamed<Boolean> by ItemAttributeNamed("weapon always gib")
	
	/**
	 * This weapon never gibs killed enemies
	 *
	 * In-Game: "Never gibs enemies"
	 */
	val WeaponBaseAttributes.RagdollsAttributes.neverGibs: ItemAttributeNamed<Boolean> by ItemAttributeNamed("weapon never gib")
	
	/**
	 * Always gib on death
	 *
	 * In-Game: "Always gib"
	 */
	val PlayerAttributes.MetaAttributes.alwaysGib: ItemAttributeNamed<Boolean> by ItemAttributeNamed("always gib")
	
	/**
	 * Never gib on death
	 *
	 * In-Game: "Never gib"
	 */
	val PlayerAttributes.MetaAttributes.neverGib: ItemAttributeNamed<Int> by ItemAttributeNamed("never gib")
	
	/**
	 * Sap ally players instead of enemies
	 *
	 * In-Game: "Place on ally players instead of enemies"
	 */
	val SapperAttributes.canOnlySapAllies: ItemAttributeNamed<Boolean> by ItemAttributeNamed("sapper sap allies")
	
	/**
	 * Custom sapper model; accept either a prefix or full model path
	 *
	 * Example: `"models/buildables/sd_sapper"`
	 */
	val SapperAttributes.customSapperModel: ItemAttributeNamed<String> by ItemAttributeNamed("custom sapper model")
	
	/**
	 * Custom sapper sound.
	 *
	 * Example: `Sound("Weapon_Sapper.Timer")`
	 */
	val SapperAttributes.customSapperSound: ItemAttributeNamed<Sound> by ItemAttributeNamed("custom sapper sound")
	
	/**
	 * Give noclip. 1 for regular player speed, otherwise the value is the movement speed.
	 */
	val PlayerAttributes.MovementAttributes.noClip: ItemAttributeNamed<Int> by ItemAttributeNamed("no clip")
	
	/**
	 * If true, automatically ignites arrows
	 *
	 * In-Game: "Arrows are always lit"
	 */
	val CompoundBowAttributes.arrowsAlwaysLit: ItemAttributeNamed<Boolean> by ItemAttributeNamed("arrow ignite")
	
	/**
	 * Use weapon animations of the weapon's original class if the weapon is given to an unintended class
	 *
	 * In-Game: "Arrows are always lit"
	 */
	val WeaponBaseAttributes.MetaAttributes.ViewmodelAttributes.useOriginalClassWeaponAnimations: ItemAttributeNamed<Boolean> by ItemAttributeNamed("use original class weapon animations")
	
	/**
	 * Deals up to x damage inversely scaled by the distance to the target from the [maximum distance it can travel before the mult becomes 0][multByDistanceFromTargetMaxDistance]. (default: 2048 HU)
	 *
	 * For example, if [multByDistanceFromTargetMaxDistance] is 100 HU and this attribute is set to 1.0,
	 * then when the player is 25 HU from the target, this weapon will deal `((100 - 25) / 100) * 1.0 = 75` damage. TODO make sure this is right
	 *
	 * In-Game: "Deals up to (+-)N% damage, the closer to the target"
	 *
	 * @see multByDistanceFromTargetMaxDistance
	 */
	val WeaponBaseAttributes.DamageAttributes.multByDistanceFromTarget: ItemAttributeNamed<Number> by ItemAttributeNamed("mult dmg before distance")
	
	/**
	 * The distance where the multiplier from [multByDistanceFromTarget] is 0x.
	 */
	val WeaponBaseAttributes.DamageAttributes.multByDistanceFromTargetMaxDistance: ItemAttributeNamed<Number> by ItemAttributeNamed("mult dmg before distance specify")
	
	/**
	 * Can move while ducking when shooting. Bots can also jump
	 *
	 * In-Game: "Can move while ducking when shooting"
	 */
	val MinigunAttributes.MovementAttributes.fullMovementWhileShooting: ItemAttributeNamed<Boolean> by ItemAttributeNamed("minigun full movement")
	
	/**
	 * Use player animations of the weapon's original class if the weapon is given to an unintended class
	 *
	 */
	val PlayerAttributes.useOriginalClassPlayerAnimations: ItemAttributeNamed<Int> by ItemAttributeNamed("use original class player animations")
	
	/**
	 * Sentry rocket projectile speed multiplier
	 *
	 * In-Game: "(+-)N% sentry rocket projectile speed"
	 */
	val BaseProjectileAttributes.multSentryRocketProjectileSpeed: ItemAttributeNamed<Number> by ItemAttributeNamed("mult sentry rocket projectile speed")
	
	/**
	 * Critical hit when the enemy has specified cond
	 */
	val PlayerAttributes.CritsAttributes.critOnCond: ItemAttributeNamed<TFCondition> by ItemAttributeNamed("crit on cond", TFCondition::index)
	
	/**
	 * Mini crit hit when the enemy has specified cond
	 */
	val PlayerAttributes.CritsAttributes.minicritOnCond: ItemAttributeNamed<TFCondition> by ItemAttributeNamed("minicrit on cond", TFCondition::index)
	
	/**
	 * Add attributes when the weapon is active
	 */
	val WeaponBaseAttributes.SwapWeaponsAttributes.addAttributesWhenActive: ItemAttributeNamed<IAttributeContainer> by ItemAttributeNamed("add attributes when active", ::AttributesContainerAsAttribute)
	
	/**
	 * Add the conditions and attributes defined in [addCondToTarget] and [addAttributesToTarget] in a radius of this many HU.
	 */
	val WeaponBaseAttributes.OnHitAttributes.radialCond: ItemAttributeNamed<Int> by ItemAttributeNamed("radial cond")
	
	/**
	 * Explosion radius multiplier on direct hit
	 *
	 * In-Game: "(+-)N% explosion radius on direct hit"
	 */
	val BaseRocketAttributes.multExplosionRadiusDirectHit: ItemAttributeNamed<Number> by ItemAttributeNamed("mult explosion radius direct hit")
	
	/**
	 * Explosion radius multiplier on direct hit
	 *
	 * In-Game: "(+-)N% explosion radius on direct hit"
	 */
	val BaseGrenadeProjectileAttributes.multExplosionRadiusDirectHit: ItemAttributeNamed<Number> by ItemAttributeNamed("mult explosion radius direct hit")
	
	/**
	 * Buldings cannot be sapped
	 *
	 * In-Game: "Buildings cannot be sapped"
	 */
	val PlayerAttributes.BuildingsAttributes.buildingsCannotBeSapped: ItemAttributeNamed<Boolean> by ItemAttributeNamed("buildings cannot be sapped")
	
	/**
	 * Damage multiplier on a direct hit with an explosive.
	 *
	 * In-Game: "(+-)N% damage on direct hit"
	 */
	val BaseGrenadeProjectileAttributes.multDmgDirectHit: ItemAttributeNamed<Number> by ItemAttributeNamed("mult dmg direct hit")
	
	/**
	 * Damage multiplier on a direct hit with an explosive.
	 *
	 * In-Game: "(+-)N% damage on direct hit"
	 */
	val BaseRocketAttributes.multDmgDirectHit: ItemAttributeNamed<Number> by ItemAttributeNamed("mult dmg direct hit")
	
	/**
	 * Explosion particle on direct hit
	 */
	val BaseRocketAttributes.explosionParticleOnDirectHit: ItemAttributeNamed<String> by ItemAttributeNamed("explosion particle on direct hit")
	
	/**
	 * Explosion particle on direct hit
	 */
	val BaseGrenadeProjectileAttributes.explosionParticleOnDirectHit: ItemAttributeNamed<String> by ItemAttributeNamed("explosion particle on direct hit")
	
	
	
	/**
	 * Bomb cannot be upgraded
	 *
	 * In-Game: "Cannot upgrade the bomb as a carrier"
	 */
	val MvMBotAttributes.cannotUpgradeBomb: ItemAttributeNamed<Boolean> by ItemAttributeNamed("cannot upgrade bomb")
	
	/**
	 * Custom carried by player sentry toolbox model
	 */
	val PlayerAttributes.BuildingsAttributes.SentryGunAttributes.sentryToolboxModel: ItemAttributeNamed<String> by ItemAttributeNamed("sentry toolbox model")
	
	/**
	 * Custom carried by player dispenser toolbox model
	 */
	val PlayerAttributes.BuildingsAttributes.DispenserAttributes.dispenserToolboxModel: ItemAttributeNamed<String> by ItemAttributeNamed("dispenser toolbox model")
	
	/**
	 * Custom carried by player teleporter toolbox model
	 *
	 */
	val PlayerAttributes.BuildingsAttributes.TeleporterAttributes.teleporterToolboxModel: ItemAttributeNamed<String> by ItemAttributeNamed("teleporter toolbox model")
	
	/**
	 * Can attack enemies, dealing damage equal to % heal rate
	 *
	 * In-Game: "Can attack enemies, dealing damage equal to N% heal rate"
	 */
	val MedigunAttributes.medigunAttackEnemy: ItemAttributeNamed<Number> by ItemAttributeNamed("medigun attack enemy")
	
	/**
	 * Drain health equal to % heal rate from the user when healing
	 *
	 * In-Game: "Drain health equal to N% heal rate from the user when healing"
	 */
	val MedigunAttributes.medigunSelfDrain: ItemAttributeNamed<Number> by ItemAttributeNamed("medigun self drain")
	
	/**
	 * Fire input on attack. Player is !activator, projectile is !projectile (must be input target), weapon is !self
	 */
	val WeaponBaseAttributes.FiringAttributes.fireInputOnAttack: ItemAttributeNamed<String> by ItemAttributeNamed("fire input on attack") // TODO input
	
	/**
	 * Attributes stunning the target on hit, what type that stun should be, how long it should last, and how much it should slow movement by.
	 */
	val WeaponBaseAttributes.OnHitAttributes.stunOnHit get() = StunOnHitAttributes
	
	
	object StunOnHitAttributes : IBlockScoped {
		
		/**
		 * How long the stun applied from [type] should be applied.
		 *
		 * In-Game: "On Hit: Stun target for N seconds"
		 */
		val duration: ItemAttributeNamed<Duration> by ItemAttributeNamed("stun on hit", Duration::toSeconds)
		
		/**
		 * Giant robots cannot be affected by [type].
		 *
		 * In-Game: "Cannot stun giants"
		 */
		val cannotAffectGiants: ItemAttributeNamed<Boolean> by ItemAttributeNamed("stun on hit no giants")
		
		/**
		 * If set, stuns the target using the [btpos.source.vdfdsl.tf2.rafmod.types.StunOnHitType] setting.
		 *
		 * @see multMoveSpeed
		 * @see cannotAffectGiants
		 */
		val type: ItemAttributeNamed<StunOnHitType> by ItemAttributeNamed("stun on hit type")
		
		/**
		 * Movement penalty applied when [type] is [StunOnHitType.Movement].
		 *
		 * In-Game: "Stun slows players by N%"
		 */
		val PlayerAttributes.OnHitAttributes.multMoveSpeed: ItemAttributeNamed<Number> by ItemAttributeNamed("stun on hit slow")
		
	}
	
	
	/**
	 * Multiplier of health gained from attacking enemies
	 *
	 * In-Game: "N% of damage dealt is returned as health"
	 */
	val MedigunAttributes.medigunAttackEnemyHealMult: ItemAttributeNamed<Number> by ItemAttributeNamed("medigun attack enemy heal mult")
	
	/**
	 * Medigun custom particle. Automatically uses _red and _blue particles when not specified. Sometimes ~ has to be added so that the particle disappears when needed
	 */
	val MedigunAttributes.medigunParticle: ItemAttributeNamed<String> by ItemAttributeNamed("medigun particle")
	
	/**
	 * Medigun custom particle when attacking enemies. Sometimes ~ has to be added so that the particle disappears when needed
	 *
	 * In-Game: "(+-)N% sentry rocket projectile speed"
	 */
	val MedigunAttributes.medigunParticleEnemy: ItemAttributeNamed<String> by ItemAttributeNamed("medigun particle enemy")
	
	/**
	 * Medigun custom particle when uber is released. Sometimes ~ has to be added so that the particle disappears when needed
	 *
	 * In-Game: "(+-)N% sentry rocket projectile speed"
	 */
	val MedigunAttributes.medigunParticleRelease: ItemAttributeNamed<String> by ItemAttributeNamed("medigun particle release")
	
	/**
	 * Medigun custom particle for full charge sparks
	 *
	 * In-Game: "(+-)N% sentry rocket projectile speed"
	 */
	val MedigunAttributes.medigunParticleSpark: ItemAttributeNamed<String> by ItemAttributeNamed("medigun particle spark")
	
	/**
	 * Immune to effects applied by other players
	 *
	 * In-Game: "Immune to effects applied by allies and enemies"
	 */
	val PlayerAttributes.ResistanceAttributes.effectImmunity: ItemAttributeNamed<Boolean> by ItemAttributeNamed("effect immunity")
	
	/**
	 * Use robot voicelines
	 */
	val PlayerAttributes.MetaAttributes.useRobotVoice: ItemAttributeNamed<Boolean> by ItemAttributeNamed("use robot voice")
	
	/**
	 * Use human voicelines
	 */
	val PlayerAttributes.MetaAttributes.useHumanVoice: ItemAttributeNamed<Boolean> by ItemAttributeNamed("use human voice")
	
	/**
	 * Alt fire fires an attack. Value higher than 1 specifies fire rate multipler when using secondary attack
	 
	 */
	val WeaponBaseAttributes.FiringAttributes.altFireAttack: ItemAttributeNamed<Number> by ItemAttributeNamed("alt fire attack")
	
	/**
	 * Attributes to apply when alt fire button is pressed
	 
	 */
	val WeaponBaseAttributes.FiringAttributes.altFireAttributes: ItemAttributeNamed<IAttributeContainer> by ItemAttributeNamed("alt fire attributes")
	
	/**
	 * No revive marker on death
	 *
	 * In-Game: "No reanimator on death"
	 */
	val PlayerAttributes.MetaAttributes.GameplayAttributes.noRevive: ItemAttributeNamed<Boolean> by ItemAttributeNamed("no revive")
	
	/**
	 * Fire input when an addcond effect is applied by this weapon. Provider is !activator. The receiver is !caller
	 */
	val WeaponBaseAttributes.StatusEffectsAttributes.fireInputOnEffect: ItemAttributeNamed<String> by ItemAttributeNamed("fire input on effect") // TODO input
	
	/**
	 * Additional step sound
	 */
	val PlayerAttributes.MetaAttributes.PlayerAttributes.additionalStepSound: ItemAttributeNamed<Sound> by ItemAttributeNamed("additional step sound")
	
	/**
	 * Field of view override. Sniper rifles reset this
	 */
	val PlayerAttributes.MetaAttributes.fovOverride: ItemAttributeNamed<Int> by ItemAttributeNamed("fov override")
	
	/**
	 * Overlay material
	 */
	val PlayerAttributes.MetaAttributes.hudOverlay: ItemAttributeNamed<String> by ItemAttributeNamed("hud overlay")
	
	/**
	 * Fire input when taunting
	 */
	val PlayerAttributes.TauntingAttributes.fireInputOnTaunt: ItemAttributeNamed<String> by ItemAttributeNamed("fire input on taunt")
	
	/**
	 * Move enemies out of the way. Deal x damage per tick to stuck enemies
	 *
	 * In-Game: "Push away enemies"
	 */
	val PlayerAttributes.displaceTouchedEnemies: ItemAttributeNamed<Int> by ItemAttributeNamed("displace touched enemies")
	
	/**
	 * `Immune to specific addconds, separated by |`
	 *
	 */
	val PlayerAttributes.ResistanceAttributes.addcondImmunity: ItemAttributeNamed<Set<TFCondition>> by ItemAttributeNamed("addcond immunity", { it.joinToString("|") { it.TF_COND } })
	
	/**
	 * `Player immune to specific attributes, separated by |`
	 *
	 */
	val PlayerAttributes.ResistanceAttributes.attributeImmunity: ItemAttributeNamed<Set<ItemAttributeNamed<*>>> by ItemAttributeNamed("attribute immunity", { it.joinToString("|") { it.key } })
	
	/**
	 * Hold fire until full reload. Set to 2 to disable weapon switch if weapon is not fully loaded, even if not currently reloading
	 *
	 * In-Game: "Hold fire until full reload"
	 */
	val WeaponBaseAttributes.FiringAttributes.holdFireUntilFullReload: ItemAttributeNamed<Int> by ItemAttributeNamed("hold fire until full reload")
	
	/**
	 * Attributes governing if and how projectiles fired by this weapon can be damaged and destroyed by attacks.
	 */
	val WeaponBaseAttributes.ProjectilesAttributes.damageableProjectiles get() = DamageableProjectilesAttributes
	
	object DamageableProjectilesAttributes : IBlockScoped {
		
		/**
		 * Weapons hitting this far around the projectile will be counted as hitting this projectile.
		 */
		val projectileHitRadius: ItemAttributeNamed<Int> by ItemAttributeNamed("projectile hit radius")
		
		/**
		 * Projectiles penetrate walls. Cannot hit anything unless [projectileHitRadius] is set
		 *
		 * In-Game: "Projectiles penetrate walls"
		 */
		val noclipProjectiles: ItemAttributeNamed<Boolean> by ItemAttributeNamed("noclip projectiles")
		
		/**
		 * Projectiles have specified amount of health. Not every projectile is compatible, the owner cannot shoot his own non grenade projectiles. "custom projectile size" might be required to hit some projectiles with bullets
		 */
		val projectileHealth: ItemAttributeNamed<Int> by ItemAttributeNamed("projectile health")
		
		/**
		 * Damage taken by projectile restrictions:
		 *
		 * 0 - no restrictions
		 *
		 *
		 *
		 * 1 - only owner can damage
		 *
		 *
		 *
		 * 2 - own team only
		 *
		 *
		 *
		 * 3 - enemies only
		 */
		val projectileTakeDamageType: ItemAttributeNamed<Int> by ItemAttributeNamed("projectile take damage type")
		
		/**
		 * How long after being fired before this projectile can take damage
		 */
		val projectileTakeDamageTime: ItemAttributeNamed<Duration> by ItemAttributeNamed("projectile take damage time", Duration::toSeconds)
		
		/**
		 * Projectiles explode when destroyed. Can be one of those values:
		 *
		 * 0 - do not explode
		 *
		 * 1 - explode
		 *
		 * 2 - explode, the damage belongs to the attacker
		 *
		 * 3 - explode only if destroyed by the same team
		 */
		val projectileExplodeOnDestroy: ItemAttributeNamed<Int> by ItemAttributeNamed("projectile explode on destroy")
		
		
		/**
		 * Projectiles detonate after delay
		 *
		 * In-Game: "Explodes after Ns delay"
		 */
		val projectileExplodeTime: ItemAttributeNamed<Duration> by ItemAttributeNamed("projectile explode time", Duration::toSeconds)
		
	}
	
	/**
	 * View punch angle when shooting
	 
	 */
	val PlayerAttributes.FiringAttributes.shootViewPunchAngle: ItemAttributeNamed<Rot3> by ItemAttributeNamed("shoot view punch angle", RafmodSerializers.ROT3)
	
	/**
	 * View punch angle random variance when shooting
	 
	 */
	val PlayerAttributes.FiringAttributes.shootViewPunchAngleRandom: ItemAttributeNamed<Rot3> by ItemAttributeNamed("shoot view punch angle random", RafmodSerializers.ROT3)
	
	/**
	 * Custom additional item models.
	 *
	 * @see customItemModelAttachment2
	 * @see customItemModelAttachment3
	 */
	val EconEntityAttributes.MetaAttributes.customItemModelAttachment1: ItemAttributeNamed<List<ItemModelAttachment>> by ItemAttributeNamed("custom item model attachment", ItemModelAttachment.SERIALIZER)
	
	/**
	 * Custom additional item models.
	 *
	 * @see customItemModelAttachment1
	 * @see customItemModelAttachment3
	 */
	val EconEntityAttributes.MetaAttributes.customItemModelAttachment2: ItemAttributeNamed<List<ItemModelAttachment>> by ItemAttributeNamed("custom item model attachment 2", ItemModelAttachment.SERIALIZER)
	
	/**
	 * Custom additional item models.
	 *
	 * @see customItemModelAttachment1
	 * @see customItemModelAttachment2
	 */
	val EconEntityAttributes.MetaAttributes.customItemModelAttachment3: ItemAttributeNamed<List<ItemModelAttachment>> by ItemAttributeNamed("custom item model attachment 3", ItemModelAttachment.SERIALIZER)
	
	/**
	 * Custom additional item models in view model.
	 */
	val EconEntityAttributes.MetaAttributes.customItemModelAttachmentViewmodel1: ItemAttributeNamed<List<ItemModelAttachment>> by ItemAttributeNamed("custom item model attachment viewmodel", ItemModelAttachment.SERIALIZER)
	
	/**
	 * Additional item model attribute in view model
	 */
	val EconEntityAttributes.MetaAttributes.customItemModelAttachmentViewmodel2: ItemAttributeNamed<List<ItemModelAttachment>> by ItemAttributeNamed("custom item model attachment viewmodel 2", ItemModelAttachment.SERIALIZER)
	
	/**
	 * Additional item model attribute in view model
	 */
	val EconEntityAttributes.MetaAttributes.customItemModelAttachmentViewmodel3: ItemAttributeNamed<List<ItemModelAttachment>> by ItemAttributeNamed("custom item model attachment viewmodel 3", ItemModelAttachment.SERIALIZER)
	
	/**
	 * Custom deploy sound
	 */
	val WeaponBaseAttributes.SwapWeaponsAttributes.customWeaponDeploySound: ItemAttributeNamed<Sound> by ItemAttributeNamed("custom weapon deploy sound")
	
	/**
	 * Spread angle (pitch, yaw, roll) pattern, the pattern cycles with each projectile fired
	 
	 */
	val PlayerAttributes.FiringAttributes.spreadAnglePattern: ItemAttributeNamed<List<Rot3>> by ItemAttributeNamed("spread angle pattern") {
		it.joinToString("|") { RafmodSerializers.COORD3D(it.vec) }
	}
	
	/**
	 * Spread offset (front, left, up) pattern, the pattern cycles with each projectile fired
	 
	 */
	val PlayerAttributes.FiringAttributes.spreadOffsetPattern: ItemAttributeNamed<List<Vec3>> by ItemAttributeNamed("spread offset pattern") {
		it.joinToString("|") { RafmodSerializers.COORD3D(it) }
	}
	
	/**
	 * `Attribute pattern, cycles with each projectile fired. Attributes separated with |, cycles separated with &`
	 
	 */
	val PlayerAttributes.FiringAttributes.projAttributePattern: ItemAttributeNamed<List<IAttributeContainer>> by ItemAttributeNamed("proj attribute pattern") {
		it.joinToString("&") { AttributesContainerAsAttribute(it)._vdfRepr.stringValue }
	}
	
	/**
	 * Reset the pattern this many seconds after last attack. By default, pattern is reset as soon as the player stops firing
	 
	 */
	val PlayerAttributes.FiringAttributes.shootPatternResetTime: ItemAttributeNamed<Duration> by ItemAttributeNamed("shoot pattern reset time", Duration::toSeconds)
	
	/**
	 * If true, do not roll back the pattern when reaching the last cycle.
	 
	 */
	val PlayerAttributes.FiringAttributes.shootPatternNoRollback: ItemAttributeNamed<Boolean> by ItemAttributeNamed("shoot pattern no rollback")
	
	/**
	 * Change custom damage type to something else. Usually it only changes kill icon but sometimes it applies some effects. Available custom damage types: [https://developer.valvesoftware.com/wiki/Team_Fortress_2/Scripting/Script_Functions/Constants#ETFDmgCustom]
	 */
	val PlayerAttributes.DamageAttributes.customDamageTypeOverride: ItemAttributeNamed<Int> by ItemAttributeNamed("custom damage type override")
	
	/**
	 * Disable crit on burning players for flares
	 *
	 * In-Game: "Flares do not critically hit burning enemies"
	 */
	val ProjectileFlareAttributes.flareNoCritBurning: ItemAttributeNamed<Boolean> by ItemAttributeNamed("flare no crit burning")
	
	/**
	 * Scale for damage being received
	 *
	 * In-Game: "(+-)N% rage gain"
	 */
	val PlayerAttributes.MeterAttributes.rageReceiveScale: ItemAttributeNamed<Int> by ItemAttributeNamed("rage receive scale")
	
	/**
	 * Fire input on hit allied players. May require allow friendly fire to work. The player is the activator. The format is <target>^<input>^<param>. If omitted, default param is damage received. !projectile is the projectile entity
	 */
	val WeaponBaseAttributes.OnHitAttributes.fireInputOnHitAlly: ItemAttributeNamed<String> by ItemAttributeNamed("fire input on hit ally") // TODO input
	
	
}