package btpos.tf2.popfiledsl.tf2.itemattributes

import btpos.tf2.popfiledsl.modeling.*
import btpos.tf2.popfiledsl.serialization.codecs.*


/**
 * Items: The Huntsman, Festive Huntsman, The Fortified Compound
 */
interface CompoundBowAttributes : StickybombLauncherAttributes {
	companion object : CompoundBowAttributes
	
	/**
	 * In-Game: "+N% faster reload time"
	 *
	 * 
	 *
	 * This is what's used for weapons that draw directly from reserve ammo, like the flare gun and sniper rifle.
	 *
	 * Mult applied to reload speed
	 */
	context(attrs: IKeyValueMap)
	override var fasterReloadRate: Float?
		get() = super.fasterReloadRate
		set(value) { super.fasterReloadRate = value }
}

inline operator fun CompoundBowAttributes.invoke(scope: CompoundBowAttributes.() -> Unit) {
	this.apply(scope)
}

