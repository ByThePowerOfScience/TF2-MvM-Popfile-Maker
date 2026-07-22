package btpos.source.vdfdsl.tf2.rafmod.bot

import btpos.source.vdfdsl.modeling.ExtensibleSubtreeImpl
import btpos.source.vdfdsl.modeling.IExtensibleSubtree.Companion.addField
import btpos.source.vdfdsl.modeling.IExtensibleSubtree_VDFRepresentable
import btpos.source.vdfdsl.serialization.codecs.BinaryIntCodec
import btpos.source.vdfdsl.tf2.rafmod.RafmodConstants.SIGSEGV

/**
 * Allows rockets (but no other projectiles) to home in on enemies.
 * 
 * To make other projectiles home in on enemies, use [heatSeekProjectiles].
 */
open class HomingRocketsBotExt(subtree: IExtensibleSubtree_VDFRepresentable = ExtensibleSubtreeImpl()) : RafmodBotExtension(subtree) {
	override fun copy() = HomingRocketsBotExt(copyInternal())
	
	override val _structIdentifier: String
		get() = "HomingRockets"
	
	/**
	 * If true, homing rockets ignore spies that are disguised as the team this is from.
	 */
	open var ignoreDisguisedSpies: Boolean? by addField("IgnoreDisguisedSpies", conditional = SIGSEGV, serializer = BinaryIntCodec::write)
	
	/**
	 * If true, homing rockets ignore spies that are currently cloaked.
	 */
	open var ignoreCloakedSpies: Boolean? by addField("IgnoreStealthedSpies", conditional = SIGSEGV, serializer = BinaryIntCodec::write)
	
	/**
	 * Multiplier applied to rocket speed. 1 = default speed.
	 * 
	 * Example:
	 * ```kotlin
	 * rocketSpeedMult = 0.25
	 * ```
	 */
	open var rocketSpeedMult: Number? by addField("RocketSpeed", conditional = SIGSEGV)
	
	/**
	 * How fast the rocket can rotate to face its target, in degrees per second.
	 * 
	 * Example:
	 * ```kotlin
	 * turnPower = 90
	 * ```
	 */
	open var turnPower: Number? by addField("TurnPower", conditional = SIGSEGV)
	
	/**
	 * How large of an angle may exist between the rocket and its target before the rocket decides it has lost its target and continues on a straight path from there.
	 *
	 * `360` will make it so it never considers the target "escaped", and will continue to heat-seek even if the target has dodged perfectly past it and the rocket would now need to do a perfect 180 to reach them.
	 *
	 * Example:
	 * ```kotlin
	 * maxErrorBeforeDisengaging = 360 // Rockets will never forget their target no matter how hard they miss.
	 * ```
	 */
	open var maxErrorBeforeDisengaging: Number? by addField("MaxAimError", conditional = SIGSEGV)
}