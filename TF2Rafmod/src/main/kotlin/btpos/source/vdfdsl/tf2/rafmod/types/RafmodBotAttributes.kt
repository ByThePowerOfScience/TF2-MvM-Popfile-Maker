package btpos.source.vdfdsl.tf2.rafmod.types

import btpos.source.vdfdsl.backing.VDFPrimitive
import btpos.source.vdfdsl.serialization.IVDFRepresentableKeyValue
import btpos.source.vdfdsl.serialization.IVDFRepresentableValue_Trivial
import btpos.source.vdfdsl.tf2.rafmod.RafmodConstants.SIGSEGV
import btpos.source.vdfdsl.types.bots.TFBotAttributes

class RafmodBotAttributes(override val _vdfRepr: VDFPrimitive) : IVDFRepresentableValue_Trivial {
	constructor(name: String) : this(VDFPrimitive(name))
	
	override fun _toKeyValueRepresentable(key: VDFPrimitive, conditional: String?): IVDFRepresentableKeyValue {
		return super._toKeyValueRepresentable(key, SIGSEGV)
	}
	
	companion object {
		/**
		 * If the bot is a Medic: can turn around to look at threats
		 */
		@JvmField val MedicLookAtThreats = RafmodBotAttributes("MedicLookAtThreats")
		/**
		 * Target and destroy stickies
		 */
		@JvmField val TargetStickies = RafmodBotAttributes("TargetStickies")
		/**
		 * Ignore buildings
		 */
		@JvmField val IgnoreBuildings = RafmodBotAttributes("IgnoreBuildings")
		/**
		 * Ignore players (including bots)
		 *
		 * @see IgnoreBots
		 * @see IgnoreRealPlayers
		 */
		@JvmField val IgnorePlayers = RafmodBotAttributes("IgnorePlayers")
		/**
		 * Ignore bots
		 *
		 * @see IgnorePlayers
		 * @see IgnoreRealPlayers
		 */
		@JvmField val IgnoreBots = RafmodBotAttributes("IgnoreBots")
		/**
		 * Ignore non-bot players
		 *
		 * @see IgnorePlayers
		 * @see IgnoreBots
		 */
		@JvmField val IgnoreRealPlayers = RafmodBotAttributes("IgnoreRealPlayers")
		/**
		 * Ignore NPCs such as Tanks, skeletons, and halloween bosses
		 */
		@JvmField val IgnoreNPC = RafmodBotAttributes("IgnoreNPC")
		/**
		 * Always use secondary fire
		 */
		@JvmField val AlwaysFireWeaponAlt = RafmodBotAttributes("AlwaysFireWeaponAlt")
		/**
		 * If set, the bot will not automatically activate canteens when looking at an enemy
		 */
		@JvmField val SuppressCanteenUse = RafmodBotAttributes("SuppressCanteenUse")
		/**
		 * Try to jump over and stomp obstracles
		 */
		@JvmField val JumpStomp = RafmodBotAttributes("JumpStomp")
		/**
		 * Engineer only: Builds dispenser instead of teleporter
		 */
		@JvmField val BuildDispenserAsTeleporter = RafmodBotAttributes("BuildDispenserAsTeleporter")
		/**
		 * Engineer only: Builds dispenser instead of sentry gun
		 */
		@JvmField val BuildDispenserAsSentryGun = RafmodBotAttributes("BuildDispenserAsSentryGun")
		/**
		 * Disables a fix where a medic activating ubercharge inside spawn will not be invulnerable when exiting spawn
		 */
		@JvmField val DisableSpawnProtectionFix = RafmodBotAttributes("DisableSpawnProtectionFix")
	}
}