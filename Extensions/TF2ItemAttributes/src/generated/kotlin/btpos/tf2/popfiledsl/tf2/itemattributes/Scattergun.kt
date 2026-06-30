package btpos.tf2.popfiledsl.tf2.itemattributes

import btpos.tf2.popfiledsl.modeling.*
import btpos.tf2.popfiledsl.serialization.codecs.*


/**
 * Items: TF_WEAPON_SCATTERGUN, The Force-a-Nature, Upgradeable TF_WEAPON_SCATTERGUN, Festive Scattergun 2011, Silver Botkiller Scattergun Mk.I, Gold Botkiller Scattergun Mk.I, Rust Botkiller Scattergun Mk.I, Blood Botkiller Scattergun Mk.I, Carbonado Botkiller Scattergun Mk.I, Diamond Botkiller Scattergun Mk.I, Silver Botkiller Scattergun Mk.II, Gold Botkiller Scattergun Mk.II, Festive Force-a-Nature, The Back Scatter
 */
interface ScattergunAttributes : ShotgunAttributes {
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
	var scattergunKnockbackMult: Float?
		get() = attrs.getTyped("scattergun knockback mult")
		set(value) = attrs.setNullable("scattergun knockback mult", value)
	
	/**
	 * 
	 *
	 * Checked in `DoesReloadSingly`.  If true, weapon does not reload one shot at a time. (e.g. FaN)
	 *
	 * Note that for the most part, this logic is set inside the weapon itself. The scattergun thing is weirdly the only way to control this with attributes.
	 *
	 * If true, reloads entire clip at once.
	 */
	override context(attrs: IKeyValueMap)
	var scattergunNoReloadSingle: Boolean?
		get() = attrs.getTyped("scattergun no reload single", BinaryIntCodec)
		set(value) = attrs.setNullable("scattergun no reload single", value, BinaryIntCodec)
}

inline operator fun ScattergunAttributes.invoke(scope: ScattergunAttributes.() -> Unit) {
	this.apply(scope)
}

