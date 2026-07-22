package btpos.source.vdfdsl.tf2.rafmod.types

import btpos.source.vdfdsl.backing.VDFPrimitive
import btpos.source.vdfdsl.serialization.IVDFRepresentableValue_Trivial

/**
 * A custom mission sound, with associated volume.
 */
open class Sound(
	/**
	 * The sound file to play, e.g. `"GoldPipe_MissionIntro.mp3"`
	 */
	val path: String,
	/**
	 * The volume in Decibels that the sound should be played at.
	 */
	val volume: Int? = null
) : IVDFRepresentableValue_Trivial {
	override val _vdfRepr: VDFPrimitive
		get() {
			val str = volume?.let { "=$it|" }.orEmpty() + path
			return VDFPrimitive(str)
		}
}