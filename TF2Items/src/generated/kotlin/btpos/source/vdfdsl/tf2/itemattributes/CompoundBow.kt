package btpos.source.vdfdsl.tf2.itemattributes

import btpos.source.vdfdsl.modeling.*
import btpos.source.vdfdsl.serialization.codecs.*
import btpos.source.vdfdsl.tf2.itemattributes.impl.*
import btpos.source.vdfdsl.tf2.tftypes.*
import java.util.*



interface CompoundBowAttributes : StickybombLauncherAttributes {
	companion object {
		/**
		 * In-Game: "+N% faster reload time"
		 * 
		 * Mult applied to reload speed.
		 */
		val fasterReloadRate: ItemAttributeNamed<Float> = ItemAttributeNamed("faster reload rate")
	}

	/**
	 * In-Game: "+N% faster reload time"
	 * 
	 * Mult applied to reload speed.
	 */
	val fasterReloadRate: ItemAttributeNamed<Float> get() = CompoundBowAttributes.fasterReloadRate
}