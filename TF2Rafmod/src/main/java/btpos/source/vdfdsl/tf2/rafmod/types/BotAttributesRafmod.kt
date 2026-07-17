package btpos.source.vdfdsl.tf2.rafmod.types

import btpos.source.vdfdsl.backing.VDFPrimitive
import btpos.source.vdfdsl.serialization.IVDFRepresentableKeyValue
import btpos.source.vdfdsl.tf2.rafmod.RafmodConstants.SIGSEGV
import btpos.source.vdfdsl.types.bots.TFBotAttributes

class BotAttributesRafmod(name: String) : TFBotAttributes(name) {
	override fun _toKeyValueRepresentable(key: VDFPrimitive, conditional: String?): IVDFRepresentableKeyValue {
		return super._toKeyValueRepresentable(key, SIGSEGV)
	}
	
	companion object {
		/**
		 * If the bot is a Medic: can turn around to look at threats
		 */
		@JvmField val MedicLookAtThreats = BotAttributesRafmod("MedicLookAtThreats")
		/**
		 * Target and destroy stickies
		 */
		@JvmField val TargetStickies = BotAttributesRafmod("TargetStickies")
		/**
		 * Ignore buildings
		 */
		@JvmField val IgnoreBuildings = BotAttributesRafmod("IgnoreBuildings")
		/**
		 * Ignore players (including bots)
		 *
		 * @see IgnoreBots
		 * @see IgnoreRealPlayers
		 */
		@JvmField val IgnorePlayers = BotAttributesRafmod("IgnorePlayers")
		/**
		 * Ignore bots
		 *
		 * @see IgnorePlayers
		 * @see IgnoreRealPlayers
		 */
		@JvmField val IgnoreBots = BotAttributesRafmod("IgnoreBots")
		/**
		 * Ignore non-bot players
		 *
		 * @see IgnorePlayers
		 * @see IgnoreBots
		 */
		@JvmField val IgnoreRealPlayers = BotAttributesRafmod("IgnoreRealPlayers")
		/**
		 * Ignore NPCs such as Tanks, skeletons, and halloween bosses
		 */
		@JvmField val IgnoreNPC = BotAttributesRafmod("IgnoreNPC")
		/**
		 * Always use secondary fire
		 */
		@JvmField val AlwaysFireWeaponAlt = BotAttributesRafmod("AlwaysFireWeaponAlt")
		/**
		 * If set, the bot will not automatically activate canteens when looking at an enemy
		 */
		@JvmField val SuppressCanteenUse = BotAttributesRafmod("SuppressCanteenUse")
		/**
		 * Try to jump over and stomp obstracles
		 */
		@JvmField val JumpStomp = BotAttributesRafmod("JumpStomp")
		/**
		 * Engineer only: Builds dispenser instead of teleporter
		 */
		@JvmField val BuildDispenserAsTeleporter = BotAttributesRafmod("BuildDispenserAsTeleporter")
		/**
		 * Engineer only: Builds dispenser instead of sentry gun
		 */
		@JvmField val BuildDispenserAsSentryGun = BotAttributesRafmod("BuildDispenserAsSentryGun")
		/**
		 * Disables a fix where a medic activating ubercharge inside spawn will not be invulnerable when exiting spawn
		 */
		@JvmField val DisableSpawnProtectionFix = BotAttributesRafmod("DisableSpawnProtectionFix")
	}
}