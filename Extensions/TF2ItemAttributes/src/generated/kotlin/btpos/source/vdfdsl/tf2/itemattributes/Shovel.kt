package btpos.source.vdfdsl.tf2.itemattributes

import btpos.source.vdfdsl.modeling.*
import btpos.source.vdfdsl.serialization.codecs.*


/**
 * Items: TF_WEAPON_SHOVEL, The Equalizer, The Pain Train, Upgradeable TF_WEAPON_SHOVEL, The Market Gardener, The Disciplinary Action, The Escape Plan
 */
interface ShovelAttributes : btpos.source.vdfdsl.tf2.itemattributes.BaseMeleeAttributes, btpos.source.vdfdsl.tf2.itemattributes.IBlockScoped {
	companion object : ShovelAttributes
	
	/**
	 * In-Game: "Damage increases as the user becomes injured"
	 *
	 * 
	 *
	 * Solely determines the "damage type" of the weapon, with any custom values setting it to "pickaxe" and the default being determined by the weapon itself.
	 */
	context(attrs: btpos.source.vdfdsl.modeling.IKeyValueMap)
	var isEqualizer: Boolean?
		get() = attrs.getTyped("mod shovel damage boost", _root_ide_package_.btpos.source.vdfdsl.serialization.codecs.NumberSelectorCodec(1))
		set(value) = attrs.setNullable("mod shovel damage boost", value, _root_ide_package_.btpos.source.vdfdsl.serialization.codecs.NumberSelectorCodec(1))
	
	/**
	 * In-Game: "Move speed increases as the user becomes injured"
	 *
	 * 
	 *
	 * Solely determines the "damage type" of the weapon, with any custom values setting it to "pickaxe" and the default being determined by the weapon itself.
	 */
	context(attrs: btpos.source.vdfdsl.modeling.IKeyValueMap)
	var isEscapePlan: Boolean?
		get() = attrs.getTyped("mod shovel speed boost", _root_ide_package_.btpos.source.vdfdsl.serialization.codecs.NumberSelectorCodec(2))
		set(value) = attrs.setNullable("mod shovel speed boost", value, _root_ide_package_.btpos.source.vdfdsl.serialization.codecs.NumberSelectorCodec(2))
	
	/**
	 * 
	 *
	 * On primary attack, send player flying in the direction they're facing.
	 */
	context(attrs: btpos.source.vdfdsl.modeling.IKeyValueMap)
	var airJumpOnAttack: Boolean?
		get() = attrs.getTyped("air jump on attack", _root_ide_package_.btpos.source.vdfdsl.serialization.codecs.BinaryIntCodec)
		set(value) = attrs.setNullable("air jump on attack", value, _root_ide_package_.btpos.source.vdfdsl.serialization.codecs.BinaryIntCodec)
}

