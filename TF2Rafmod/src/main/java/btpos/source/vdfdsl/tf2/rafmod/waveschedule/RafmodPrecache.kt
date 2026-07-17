package btpos.source.vdfdsl.tf2.rafmod.waveschedule

import btpos.source.vdfdsl.modeling.IExtensibleSubtree
import btpos.source.vdfdsl.tf2.rafmod.RafmodConstants
import btpos.source.vdfdsl.types.WaveSchedule

/**
 * Precaching helps to ensure that the content used in the mission will be loaded properly and downloaded to the clients.
 */
abstract class RafmodPrecache {
	companion object {
		@PublishedApi @JvmField internal val INSTANCE = object : RafmodPrecache() {}
	}
	/**
	 * If your mission contains custom sounds that are used by pointtemplate entities or sound overrides, you must include those sounds here.
	 *
	 * Precaching helps to ensure that content used in the mission will be loaded properly and downloaded to all clients.
	 *
	 * Example:
	 * ```kotlin
	 * precachedSounds += "weapons/rocket_directhit_shoot_crit.wav"
	 * ```
	 */
	var WaveSchedule.sounds: List<String> by IExtensibleSubtree.addField("PrecacheSound", conditional = RafmodConstants.SIGSEGV, serializer = IExtensibleSubtree.Serializers.flatListWithKey(), initialValue = ::listOf)
	
	/**
	 * If your mission contains custom sounds that are used by pointtemplate entities or sound overrides, you must include those sounds here.
	 *
	 * Precaching helps to ensure that content used in the mission will be loaded properly and downloaded to all clients.
	 *
	 * Example:
	 * ```kotlin
	 * precachedScriptSounds += "Weapon_RPG.Single"
	 * ```
	 *
	 * Script sound version of [sounds]
	 */
	var WaveSchedule.scriptSounds: List<String> by IExtensibleSubtree.addField("PrecacheScriptSound", conditional = RafmodConstants.SIGSEGV, serializer = IExtensibleSubtree.Serializers.flatListWithKey(), initialValue = ::listOf)
	
	/**
	 * Precaches model. This might be required in some circumstances, such as "custom projectile model" attribute, or prop with custom model.
	 *
	 * Precaching helps to ensure that content used in the mission will be loaded properly and downloaded to all clients.
	 *
	 * Example:
	 * ```kotlin
	 * precachedModels += "models/props_soho/bookstand002.mdl"
	 * ```
	 */
	var WaveSchedule.models: List<String> by IExtensibleSubtree.addField("PrecacheModel", conditional = RafmodConstants.SIGSEGV, serializer = IExtensibleSubtree.Serializers.flatListWithKey(), initialValue = ::listOf)
	
	/**
	 *
	 *
	 * Precaching helps to ensure that content used in the mission will be loaded properly and downloaded to all clients.
	 *
	 * Example:
	 * ```kotlin
	 * precachedSentenceFiles += "scripts/sentences.txt"
	 * ```
	 */
	var WaveSchedule.sentenceFiles: List<String> by IExtensibleSubtree.addField("PrecacheSentenceFile", conditional = RafmodConstants.SIGSEGV, serializer = IExtensibleSubtree.Serializers.flatListWithKey(), initialValue = ::listOf)
	
	/**
	 * Precache decals.
	 *
	 * Precaching helps to ensure that content used in the mission will be loaded properly and downloaded to all clients.
	 *
	 * Example:
	 * ```kotlin
	 * precachedDecals += "decals/tscorch"
	 * ```
	 */
	var WaveSchedule.decals: List<String> by IExtensibleSubtree.addField("PrecacheDecal", conditional = RafmodConstants.SIGSEGV, serializer = IExtensibleSubtree.Serializers.flatListWithKey(), initialValue = ::listOf)
	
	/**
	 * Precache generic files.
	 *
	 * Precaching helps to ensure that content used in the mission will be loaded properly and downloaded to all clients.
	 *
	 * Example:
	 * ```kotlin
	 * precachedGenericFiles += ""
	 * ```
	 */
	var WaveSchedule.genericFiles: List<String> by IExtensibleSubtree.addField("PrecacheGeneric", conditional = RafmodConstants.SIGSEGV, serializer = IExtensibleSubtree.Serializers.flatListWithKey(), initialValue = ::listOf)
	
	/**
	 * Precache particles.
	 *
	 * Precaching helps to ensure that content used in the mission will be loaded properly and downloaded to all clients.
	 *
	 * Example:
	 * ```kotlin
	 * precachedParticles += "env_fire_large_smoke"
	 * ```
	 */
	var WaveSchedule.particles: List<String> by IExtensibleSubtree.addField("PrecacheParticle", conditional = RafmodConstants.SIGSEGV, serializer = IExtensibleSubtree.Serializers.flatListWithKey(), initialValue = ::listOf)
}