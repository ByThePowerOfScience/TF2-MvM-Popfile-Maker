package btpos.source.vdfdsl.tf2.itemattributes

import btpos.source.vdfdsl.modeling.*
import btpos.source.vdfdsl.serialization.codecs.*
import btpos.source.vdfdsl.tf2.itemattributes.impl.*
import java.util.*

/**
 * Items: The Huntsman, Festive Huntsman, The Fortified Compound
 */
interface CompoundBowAttributes : StickybombLauncherAttributes, IBlockScoped {
	companion object : CompoundBowAttributes
	
	/**
	 * In-Game: "+N% faster reload time"
	 *
	 * 
	 *
	 * Used if the gun draws directly from the ammo supply without using a clip.
	 *
	 * Mult applied to reload speed.
	 */
	context(attrs: IKeyValueMap)
	override var fasterReloadRate: Number?
		get() = super.fasterReloadRate
		set(value) { super.fasterReloadRate = value }
}

