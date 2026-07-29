package btpos.source.vdfdsl.tf2.itemattributes

import btpos.source.vdfdsl.modeling.*
import btpos.source.vdfdsl.serialization.codecs.*
import btpos.source.vdfdsl.tf2.itemattributes.impl.*
import btpos.source.vdfdsl.tf2.tftypes.*
import java.util.*




interface ChargedSMGAttributes : SMGAttributes {
	
	companion object {
		/**
		 * In-Game: "Secondary fire when charged grants mini-crits for N seconds."
		 * 
		 * Minicrit buff duration.
		 */
		val minicritBoostWhenCharged: ItemAttributeNamed<Float> = ItemAttributeNamed("minicrit_boost_when_charged")
	}

	/**
	 * In-Game: "Secondary fire when charged grants mini-crits for N seconds."
	 * 
	 * Minicrit buff duration.
	 */
	val minicritBoostWhenCharged: ItemAttributeNamed<Float> get() = ChargedSMGAttributes.minicritBoostWhenCharged
}