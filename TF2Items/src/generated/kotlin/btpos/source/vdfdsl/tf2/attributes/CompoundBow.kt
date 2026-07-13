package btpos.source.vdfdsl.tf2.attributes

import btpos.source.vdfdsl.modeling.*
import btpos.source.vdfdsl.serialization.codecs.*
import btpos.source.vdfdsl.tf2.attributes.impl.*
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
	 * This is what's used for weapons that draw directly from reserve ammo, like the flare gun and sniper rifle.
	 *
	 * Mult applied to reload speed.
	 */
	context(attrs: IKeyValueMap)
	override var fasterReloadRate: Float?
		get() = super.fasterReloadRate
		set(value) { super.fasterReloadRate = value }
}

