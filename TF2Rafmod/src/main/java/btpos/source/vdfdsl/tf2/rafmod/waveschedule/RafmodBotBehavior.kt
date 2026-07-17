package btpos.source.vdfdsl.tf2.rafmod.waveschedule

import btpos.source.vdfdsl.modeling.IExtensibleSubtree.Companion.addField
import btpos.source.vdfdsl.serialization.codecs.BinaryIntCodec
import btpos.source.vdfdsl.tf2.rafmod.RafmodConstants.SIGSEGV
import btpos.source.vdfdsl.tf2.rafmod.RafmodSerializers.BOOL_SER_INVERT
import btpos.source.vdfdsl.types.WaveSchedule

abstract class RafmodBotBehavior {
	companion object {
		@JvmField val INSTANCE = object : RafmodBotBehavior() {}
	}
	
	/**
	 * If true, Medic-bots' projectile shields will damage players.
	 *
	 * Use the [dmg penalty vs players][btpos.source.vdfdsl.tf2.itemattributes.WeaponBaseAttributes.dmgPenaltyVsPlayers] attribute to control damage dealt.
	 */
	var WaveSchedule.canBotShieldsDamagePlayers: Boolean? by addField("MedigunShieldDamage", conditional = SIGSEGV, serializer = BinaryIntCodec::write)
	
	/**
	 * If true, robots will not push players off of their heads.
	 */
	var WaveSchedule.canPlayersStandOnRobotHeads: Boolean? by addField("StandableHeads", conditional = SIGSEGV, serializer = BinaryIntCodec::write)
	
	/**
	 * If true, robots will not wear Romevision cosmetics when a player is wearing the Hardy Laurel, unless said cosmetics are directly added to their [items][btpos.source.vdfdsl.types.spawners.TFBotSpawner.items].
	 */
	var WaveSchedule.disableRomevision: Boolean? by addField("NoRomevisionCosmetics", conditional = SIGSEGV, serializer = BinaryIntCodec::write)
	
	/**
	 * If true, robots' weapons can randomly crit.
	 *
	 * Use the [crit mod disabled][btpos.source.vdfdsl.tf2.itemattributes.WeaponBaseAttributes.critModDisabled] attribute to control crit chance per bot.
	 */
	var WaveSchedule.canBotsRandomCrit: Boolean? by addField("BotsRandomCrit", conditional = SIGSEGV, serializer = BinaryIntCodec::write)
	
	/**
	 * Scales the aim tracking interval for robots.
	 *
	 * Example:
	 * ```kotlin
	 * aimTrackingIntervalMultiplier = 3
	 * ```
	 */
	var WaveSchedule.aimTrackingIntervalMultiplier: Double? by addField("AimTrackingIntervalMultiplier", conditional = SIGSEGV)
	
	/**
	 * If true, robot snipers (and Ambassador spies) can headshot.
	 */
	var WaveSchedule.canSniperBotsHeadshot: Boolean? by addField("SniperAllowHeadshots", conditional = SIGSEGV, serializer = BinaryIntCodec::write)
	
	/**
	 * If true, robot Pyros can deflect arrows, grenades, and stickybombs.
	 */
	var WaveSchedule.enableImprovedAirblast: Boolean? by addField("ImprovedAirblast", conditional = SIGSEGV, serializer = BinaryIntCodec::write)
	
	/**
	 * If true, Spy bots will not target unowned buildings.
	 */
	var WaveSchedule.noSapUnownedBuildings: Boolean? by addField("NoSapUnownedBuildings", conditional = SIGSEGV, serializer = BinaryIntCodec::write)
	
	/**
	 * If true, Sentry Busters will not deal damage other robots.
	 */
	var WaveSchedule.disableSentryBusterFriendlyFire: Boolean? by addField("SentryBusterFriendlyFire", conditional = SIGSEGV, serializer = BOOL_SER_INVERT)
	
	/**
	 * If true, robots will not push each other away when standing inside one another.
	 */
	var WaveSchedule.disableBotPushaway: Boolean? by addField("BotPushaway", conditional = SIGSEGV, serializer = BOOL_SER_INVERT)
	
	/**
	 * If true, the Sandman ball can stun players. (Default: true)
	 */
	var WaveSchedule.canSandmanStunPlayers: Boolean? by addField("SandmanStun", conditional = SIGSEGV, serializer = BinaryIntCodec::write)
	
	/**
	 * If true, snipers will not display lasers when aiming.
	 */
	var WaveSchedule.isSniperLaserVisible: Boolean? by addField("SniperHideLasers", conditional = SIGSEGV, serializer = BinaryIntCodec::write)
	
	/**
	 * If true, robots are able to bleed.
	 */
	var WaveSchedule.canRobotsBleed: Boolean? by addField("ForceRobotBleed", conditional = SIGSEGV, serializer = BinaryIntCodec::write)
}

