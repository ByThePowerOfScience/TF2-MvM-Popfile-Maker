package btpos.source.vdfdsl.tf2.itemattributes

import btpos.source.vdfdsl.tf2.itemattributes.impl.IBlockScoped


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
	context(attrs: btpos.source.vdfdsl.modeling.IKeyValueMap)
	override var fasterReloadRate: Float?
		get() = super.fasterReloadRate
		set(value) {
			super.fasterReloadRate = value
		}
}

