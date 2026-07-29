package btpos.source.vdfdsl.tf2.itemattributes

import btpos.source.vdfdsl.modeling.*
import btpos.source.vdfdsl.serialization.codecs.*
import btpos.source.vdfdsl.tf2.itemattributes.impl.*
import btpos.source.vdfdsl.tf2.tftypes.*
import java.util.*




interface ScoutPistolAttributes : PistolAttributes {
	
	companion object {
		/**
		 * If true, can headshot when behind an enemy.
		 */
		val backHeadshot: ItemAttributeNamed<Boolean> = ItemAttributeNamed("back headshot")
	}

	/**
	 * If true, can headshot when behind an enemy.
	 */
	val backHeadshot: ItemAttributeNamed<Boolean> get() = ScoutPistolAttributes.backHeadshot
}