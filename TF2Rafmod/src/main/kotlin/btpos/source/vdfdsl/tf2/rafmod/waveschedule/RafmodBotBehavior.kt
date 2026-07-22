package btpos.source.vdfdsl.tf2.rafmod.waveschedule

import btpos.source.vdfdsl.modeling.IExtensibleSubtree.Companion.addField
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
	open var WaveSchedule.canBotShieldsDamagePlayers: Boolean? by addField("MedigunShieldDamage", conditional = SIGSEGV)
	
	/**
	 * If true, robots will not push players off of their heads.
	 */
	open var WaveSchedule.canPlayersStandOnRobotHeads: Boolean? by addField("StandableHeads", conditional = SIGSEGV)
	
	/**
	 * If true, robots will not wear Romevision cosmetics when a player is wearing the Hardy Laurel, unless said cosmetics are directly added to their [items][btpos.source.vdfdsl.types.spawners.TFBotSpawner.items].
	 */
	open var WaveSchedule.disableRomevision: Boolean? by addField("NoRomevisionCosmetics", conditional = SIGSEGV)
	
	/**
	 * If true, robots' weapons can randomly crit.
	 *
	 * Use the [crit mod disabled][btpos.source.vdfdsl.tf2.itemattributes.WeaponBaseAttributes.critModDisabled] attribute to control crit chance per bot.
	 */
	open var WaveSchedule.canBotsRandomCrit: Boolean? by addField("BotsRandomCrit", conditional = SIGSEGV)
	
	/**
	 * Scales the aim tracking interval for robots.
	 *
	 * Example:
	 * ```kotlin
	 * aimTrackingIntervalMultiplier = 3
	 * ```
	 */
	open var WaveSchedule.aimTrackingIntervalMultiplier: Double? by addField("AimTrackingIntervalMultiplier", conditional = SIGSEGV)
	
	/**
	 * If true, robot snipers (and Ambassador spies) can headshot.
	 */
	open var WaveSchedule.canSniperBotsHeadshot: Boolean? by addField("SniperAllowHeadshots", conditional = SIGSEGV)
	
	/**
	 * If true, robot Pyros can deflect arrows, grenades, and stickybombs.
	 */
	open var WaveSchedule.enableImprovedAirblast: Boolean? by addField("ImprovedAirblast", conditional = SIGSEGV)
	
	/**
	 * If true, Spy bots will not target unowned buildings.
	 */
	open var WaveSchedule.noSapUnownedBuildings: Boolean? by addField("NoSapUnownedBuildings", conditional = SIGSEGV)
	
	/**
	 * If true, Sentry Busters will not deal damage other robots.
	 */
	open var WaveSchedule.disableSentryBusterFriendlyFire: Boolean? by addField("SentryBusterFriendlyFire", conditional = SIGSEGV, serializer = BOOL_SER_INVERT)
	
	/**
	 * If true, robots will not push each other away when standing inside one another.
	 */
	open var WaveSchedule.disableBotPushaway: Boolean? by addField("BotPushaway", conditional = SIGSEGV, serializer = BOOL_SER_INVERT)
	
	/**
	 * If true, the Sandman ball can stun players. (Default: true)
	 */
	open var WaveSchedule.canSandmanStunPlayers: Boolean? by addField("SandmanStun", conditional = SIGSEGV)
	
	/**
	 * If true, snipers will not display lasers when aiming.
	 */
	open var WaveSchedule.isSniperLaserVisible: Boolean? by addField("SniperHideLasers", conditional = SIGSEGV)
	
	/**
	 * If true, robots are able to bleed.
	 */
	open var WaveSchedule.canRobotsBleed: Boolean? by addField("ForceRobotBleed", conditional = SIGSEGV)
}

