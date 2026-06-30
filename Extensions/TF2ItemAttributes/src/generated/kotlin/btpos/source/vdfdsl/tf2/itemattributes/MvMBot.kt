package btpos.source.vdfdsl.tf2.itemattributes

import btpos.source.vdfdsl.modeling.*
import btpos.source.vdfdsl.serialization.codecs.*



interface MvMBotAttributes : btpos.source.vdfdsl.tf2.itemattributes.EntityAttributes, btpos.source.vdfdsl.tf2.itemattributes.IBlockScoped {
	companion object : MvMBotAttributes
	
	/**
	 * 
	 *
	 * If true, spawns a rocketjump particle whenever the robot jumps.
	 */
	context(attrs: btpos.source.vdfdsl.modeling.IKeyValueMap)
	var customJumpParticle: Boolean?
		get() = attrs.getTyped("bot custom jump particle", _root_ide_package_.btpos.source.vdfdsl.serialization.codecs.BinaryIntCodec)
		set(value) = attrs.setNullable("bot custom jump particle", value, _root_ide_package_.btpos.source.vdfdsl.serialization.codecs.BinaryIntCodec)
	
	/**
	 * 
	 *
	 * Defaults to 50, I guess it's a percentage.
	 */
	context(attrs: btpos.source.vdfdsl.modeling.IKeyValueMap)
	var medicUberHealthThreshold: Int?
		get() = attrs.getTyped("bot medic uber health threshold")
		set(value) = attrs.setNullable("bot medic uber health threshold", value)
	
	/**
	 * 
	 *
	 * Defaults to -1.
	 */
	context(attrs: btpos.source.vdfdsl.modeling.IKeyValueMap)
	var medicUberDeployDelayDuration: Int?
		get() = attrs.getTyped("bot medic uber deploy delay duration")
		set(value) = attrs.setNullable("bot medic uber deploy delay duration", value)
}

