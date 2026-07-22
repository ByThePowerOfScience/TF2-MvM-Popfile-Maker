package btpos.source.vdfdsl.tf2.rafmod

import btpos.source.vdfdsl.modeling.IExtensibleSubtree.Companion.addField
import btpos.source.vdfdsl.modeling.IExtensibleSubtree.Serializers.durationInSeconds
import btpos.source.vdfdsl.modeling.IExtensibleSubtree.Serializers.flatListWithKey
import btpos.source.vdfdsl.tf2.rafmod.RafmodConstants.SIGSEGV
import btpos.source.vdfdsl.tf2.rafmod.RafmodSerializers.BOOL_SER_INVERT
import btpos.source.vdfdsl.tf2.rafmod.waveschedule.RafmodBomb
import btpos.source.vdfdsl.tf2.rafmod.waveschedule.RafmodBotBehavior
import btpos.source.vdfdsl.tf2.rafmod.waveschedule.RafmodCash
import btpos.source.vdfdsl.tf2.rafmod.waveschedule.RafmodGameplay
import btpos.source.vdfdsl.tf2.rafmod.waveschedule.RafmodHalloween
import btpos.source.vdfdsl.tf2.rafmod.waveschedule.RafmodModelsAndAnimations
import btpos.source.vdfdsl.tf2.rafmod.waveschedule.RafmodMovement
import btpos.source.vdfdsl.tf2.rafmod.waveschedule.RafmodPrecache
import btpos.source.vdfdsl.tf2.rafmod.waveschedule.RafmodReverseMvM
import btpos.source.vdfdsl.tf2.rafmod.waveschedule.RafmodTeleporters
import btpos.source.vdfdsl.types.WaveSchedule
import kotlin.time.Duration

abstract class RafmodWaveScheduleScope {
	companion object {
		@PublishedApi @JvmField internal val INSTANCE = object : RafmodWaveScheduleScope() {}
	}
	
	open fun bomb(configure: RafmodBomb.() -> Unit) {
		RafmodBomb.INSTANCE.configure()
	}
	
	open fun botBehavior(configure: RafmodBotBehavior.() -> Unit) {
		RafmodBotBehavior.INSTANCE.configure()
	}
	
	open fun cash(configure: RafmodCash.() -> Unit) {
		RafmodCash.INSTANCE.configure()
	}
	
	open fun gameplay(configure: RafmodGameplay.() -> Unit) {
		RafmodGameplay.INSTANCE.configure()
	}
	
	open fun halloween(configure: RafmodHalloween.() -> Unit) {
		RafmodHalloween.INSTANCE.configure()
	}
	
	open fun modelsAndAnimations(configure: RafmodModelsAndAnimations.() -> Unit) {
		RafmodModelsAndAnimations.INSTANCE.configure()
	}
	
	open fun movement(configure: RafmodMovement.() -> Unit) {
		RafmodMovement.INSTANCE.configure()
	}
	
	open fun precache(configure: RafmodPrecache.() -> Unit) {
		RafmodPrecache.INSTANCE.configure()
	}
	
	open fun reverseMvM(configure: RafmodReverseMvM.() -> Unit) {
		RafmodReverseMvM.INSTANCE.configure()
	}
	
	open fun teleporters(configure: RafmodTeleporters.() -> Unit) {
		RafmodTeleporters.INSTANCE.configure()
	}
	
	open fun upgradeStation(configure: RafmodBotBehavior.() -> Unit) {
		RafmodBotBehavior.INSTANCE.configure()
	}
	
	
	/**
	 * If true, players no longer drop reanimators (that would let a Medic resurrect them) on death.
	 */
	open var WaveSchedule.disableReanimators: Boolean? by addField("NoReanimators", conditional = SIGSEGV)
	
	
	/**
	 * If true, disables the sound played when a player dies.
	 */
	open var WaveSchedule.disableMvMDeathTune: Boolean? by addField("NoMvMDeathTune", conditional = SIGSEGV)
	
	
	/**
	 * Grappling hooks are destroyed after this amount of time.
	 * 
	 * Example:
	 * ```kotlin
	 * grapplingHooksDisconnectAfter = 1.seconds
	 * ```
	 */
	open var WaveSchedule.grapplingHooksDisconnectAfter: Duration? by addField("RemoveGrapplingHooks", conditional = SIGSEGV, serializer = durationInSeconds())
	
	/**
	 * If true, players can only use melee weapons. Bots are not weapon-restricted.
	 */
	open var WaveSchedule.isMedievalMode: Boolean? by addField("MedievalMode", conditional = SIGSEGV)
	
	/**
	 * If true, allows equipping the Mannpower grappling hook, which replaces the Power-Up Canteen.
	 */
	open var WaveSchedule.enableGrapplingHook: Boolean? by addField("GrapplingHook", conditional = SIGSEGV)
	
	/**
	 * List of sounds to be disabled. Note that client-side sounds cannot be disabled, and you must use a sound script unless there is only a raw version of the sound.
	 * 
	 * Example:
	 * ```kotlin
	 * disabledSounds += "Weapon_Shotgun.Single"
	 * ```
	 */
	open var WaveSchedule.disabledSounds: List<String> by addField("DisableSound", conditional = SIGSEGV, serializer = flatListWithKey(), initialValue = ::listOf)
	
	/**
	 * Configures the robot limit. (Default: 22)
	 *
	 * There is a maximum server size of 32 by default, with 6 players and 4 extra spectators.  
	 * As such, increasing the robot count over 26 (22 + 4 spectators) will then start to eat into the maximum player count.
	 * 
	 * Example:
	 * ```kotlin
	 * robotLimit = 26
	 * ```
	 */
	open var WaveSchedule.robotLimit: Int? by addField("RobotLimit", conditional = SIGSEGV)
	
	/**
	 * If true, allows players or bots to dominate players. (Default: true)
	 */
	open var WaveSchedule.enableDominations: Boolean? by addField("EnableDominations", conditional = SIGSEGV)
	
	/**
	 * If true, sends dead bots directly to spectator after dying. Use this if your mission consists of lots of easy-to-kill enemies.
	 */
	open var WaveSchedule.sendBotsToSpectatorOnDeath: Boolean? by addField("SendBotsToSpectatorImmediately", conditional = SIGSEGV)
	
	/**
	 * Configure the maximum number of spectaotrs. (Default: infinite)
	 * 
	 * Example:
	 * ```kotlin
	 * maxSpectators = 0
	 * ```
	 */
	open var WaveSchedule.maxSpectators: Int? by addField("MaxSpectators", conditional = SIGSEGV)
	
	/**
	 * OVerride the maximum RED player count. (Default: 6)
	 * 
	 * Example:
	 * ```kotlin
	 * maxRedPlayers = 6
	 * ```
	 */
	open var WaveSchedule.maxRedPlayers: Int? by addField("MaxRedPlayers", conditional = SIGSEGV)
	
	/**
	 * If true, regular robot deaths show up in the killfeed for all players. (Default: false)
	 */
	open var WaveSchedule.displayRobotDeathNotice: Boolean? by addField("DisplayRobotDeathNotice", conditional = SIGSEGV)
	
	/**
	 * How fast a line from the wave description is displayed in the middle of the screen. Use 0 to disable. (default: 4 seconds)
	 * 
	 * Example:
	 * ```kotlin
	 * textPrintTime = 7.seconds
	 * ```
	 */
	open var WaveSchedule.textPrintTime: Duration? by addField("TextPrintTime", conditional = SIGSEGV)
	
	/**
	 * If true, disables the `!missioninfo` command. (Default: false)
	 */
	open var WaveSchedule.disableMissionInfo: Boolean? by addField("NoMissionInfo", conditional = SIGSEGV)
	
	/**
	 * The maximum number of Skeletons that may be alive at any given time. (Default: 30)
	 *
	 * Example:
	 * ```kotlin
	 * maxActiveSkeletons = 999
	 * ```
	 */
	open var WaveSchedule.maxActiveSkeletons: Int? by addField("MaxActiveSkeletons", conditional = SIGSEGV)
	
	/**
	 * How long of a countdown should be given after all players ready up. (Default: 10)
	 *
	 * Values 9 or lower disable the announcer. 
	 * 
	 * Values 8 or lower disable the starting music.
	 *
	 * Example:
	 * ```kotlin
	 * waveStartCountdown = 9
	 * ```
	 */
	open var WaveSchedule.waveStartCountdown: Int? by addField("WaveStartCountdown", conditional = SIGSEGV)
	
	/**
	 * If true, NPCs such as Halloween bosses will update every tick. (Default: false)
	 */
	open var WaveSchedule.fastNPCUpdate: Boolean? by addField("FastNPCUpdate", conditional = SIGSEGV)
	
	/**
	 * If true, players that join the server while a wave is in prograss may not spawn unless they buy back. (Default: false)
	 */
	open var WaveSchedule.canJoinMidwave: Boolean? by addField("NoJoinMidwave", conditional = SIGSEGV)
	
	/**
	 * If true, minibosses only count as a single kill on a sentry gun instead of TODO
	 */
	open var WaveSchedule.minibossSentrySingleKill: Boolean? by addField("MinibossSentrySingleKill", conditional = SIGSEGV)
	
	/**
	 * If true, bots with human models have the robot voice. (Default: false)
	 */
	open var WaveSchedule.botHumansHaveRobotVoice: Boolean? by addField("BotHumansHaveRobotVoice", conditional = SIGSEGV)
	
	/**
	 * If true, robots that use human models will have glowing eyes. (Default: false)
	 */
	open var WaveSchedule.botHumansHaveEyeGlow: Boolean? by addField("BotHumansHaveEyeGlow", conditional = SIGSEGV)
	
	/**
	 * Custom particle to use on bots' eyes. (Default: `""`)
	 * 
	 * Example:
	 * ```kotlin
	 * customEyeParticle = "eye_powerup_green_lvl_4"
	 * ```
	 */
	open var WaveSchedule.customEyeParticle: String? by addField("CustomEyeParticle", conditional = SIGSEGV)
	
	/**
	 * If true, medium Skeletons will not split into small skeletons on death. (Default: false)
	 */
	open var WaveSchedule.noSkeletonSplit: Boolean? by addField("NoSkeletonSplit", conditional = SIGSEGV)
	
	/**
	 * Multiplier for how fast a robot detects that it's stuck. By default, detects after staying in the same 100 HU area for 12 seconds.
	 *
	 *
	 * Example:
	 * ```kotlin
	 * stuckTimeMultiplier = 3 // Detects that it's stuck after 4 seconds, 3 times faster
	 * ```
	 */
	open var WaveSchedule.stuckTimeMultiplier: Number? by addField("StuckTimeMultiplier", conditional = SIGSEGV)
	
	/**
	 * If true, hitting a target for negative damage will heal them.
	 */
	open var WaveSchedule.negativeDamageHealsTargets: Boolean? by addField("RestoreNegativeDamageHealing", conditional = SIGSEGV)
	
	/**
	 * If true, disables "turbo physics", but allows players to interact with physics objects like vehicles.
	 */
	open var WaveSchedule.disableTurboPhysics: Boolean? by addField("TurboPhysics", conditional = SIGSEGV, serializer = BOOL_SER_INVERT)
	
	/**
	 * Custom "sound script"
	 * 
	 * Example:
	 * ```kotlin
	 * customSoundScriptFile = "scripts/sigsegv_sound_overrides.txt"
	 * ```
	 */
	open var WaveSchedule.customSoundScriptFile: String? by addField("CustomSoundScriptFile", conditional = SIGSEGV)
	
	/**
	 * If true, decreases entity lookup time by 2-4 times.  (Default: true)
	 *
	 * Set to false if you are reading m_iName or m_iClassname from datamaps directly and expecting uppercase letters (with `$getdata` or `$setdata` input for example).
	 */
	open var WaveSchedule.useFastEntityNameLookup: Boolean? by addField("FastEntityNameLookup", conditional = SIGSEGV)
	
	
}

@Suppress("UnusedReceiverParameter")
inline fun WaveSchedule.rafmod(scope: RafmodWaveScheduleScope.() -> Unit) {
	RafmodWaveScheduleScope.INSTANCE.scope()
}