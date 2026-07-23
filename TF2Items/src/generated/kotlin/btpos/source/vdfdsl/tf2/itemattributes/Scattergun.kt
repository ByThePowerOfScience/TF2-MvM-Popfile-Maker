package btpos.source.vdfdsl.tf2.itemattributes

import btpos.source.vdfdsl.modeling.*
import btpos.source.vdfdsl.serialization.codecs.*
import btpos.source.vdfdsl.tf2.itemattributes.impl.*
import java.util.*

/**
 * Items: Stock Scattergun + Reskins, The Force-a-Nature, The Back Scatter, The Soda Popper, The Baby Face's Blaster
 */
interface ScattergunAttributes : ShotgunAttributes, IBlockScoped {
	companion object : ScattergunAttributes
	
	/**
	 * In-Game: "Knockback on the target and shooter"
	 *
	 * 
	 *
	 * Note: if `scattergun_knockback_mult` is greater than 1.0, this is not necessary.
	 */
	context(attrs: IKeyValueMap)
	var scattergunHasKnockback: Boolean?
		get() = attrs.getTyped("scattergun has knockback", BinaryIntCodec)
		set(value) = attrs.setNullable("scattergun has knockback", value, BinaryIntCodec)
	
	/**
	 * 
	 */
	context(attrs: IKeyValueMap)
	var scattergunKnockbackMult: Number?
		get() = attrs.getTyped("scattergun knockback mult")
		set(value) = attrs.setNullable("scattergun knockback mult", value)
	
	/**
	 * 
	 *
	 * Checked in the same place.  If true, weapon does not reload one shot at a time. (e.g. FaN).
	 *
	 * Note that for the most part, this logic is set inside the weapon itself. The scattergun thing is weirdly the only way to control this with attributes.
	 *
	 * If 1, reloads entire clip at once.
	 */
	context(attrs: IKeyValueMap)
	override var scattergunNoReloadSingle: Boolean?
		get() = super.scattergunNoReloadSingle
		set(value) { super.scattergunNoReloadSingle = value }
}

