package btpos.source.vdfdsl.tf2.attributes

import btpos.source.vdfdsl.modeling.*
import btpos.source.vdfdsl.serialization.codecs.*
import btpos.source.vdfdsl.tf2.attributes.impl.*
import java.util.*

/**
 * Items: TF_WEAPON_SHOVEL, The Equalizer, The Pain Train, Upgradeable TF_WEAPON_SHOVEL, The Market Gardener, The Disciplinary Action, The Escape Plan
 */
interface ShovelAttributes : BaseMeleeAttributes, IBlockScoped {
	companion object : ShovelAttributes
	
	/**
	 * In-Game: "Damage increases as the user becomes injured"
	 *
	 * 
	 *
	 * Solely determines the "damage type" of the weapon, with any custom values setting it to "pickaxe" and the default being determined by the weapon itself.
	 */
	context(attrs: IKeyValueMap)
	var isEqualizer: Boolean?
		get() = attrs.getTyped("mod shovel damage boost", NumberSelectorCodec(1))
		set(value) = attrs.setNullable("mod shovel damage boost", value, NumberSelectorCodec(1))
	
	/**
	 * In-Game: "Move speed increases as the user becomes injured"
	 *
	 * 
	 *
	 * Solely determines the "damage type" of the weapon, with any custom values setting it to "pickaxe" and the default being determined by the weapon itself.
	 */
	context(attrs: IKeyValueMap)
	var isEscapePlan: Boolean?
		get() = attrs.getTyped("mod shovel speed boost", NumberSelectorCodec(2))
		set(value) = attrs.setNullable("mod shovel speed boost", value, NumberSelectorCodec(2))
	
	/**
	 * 
	 *
	 * On primary attack, send player flying in the direction they're facing.
	 */
	context(attrs: IKeyValueMap)
	var airJumpOnAttack: Boolean?
		get() = attrs.getTyped("air jump on attack", BinaryIntCodec)
		set(value) = attrs.setNullable("air jump on attack", value, BinaryIntCodec)
}

