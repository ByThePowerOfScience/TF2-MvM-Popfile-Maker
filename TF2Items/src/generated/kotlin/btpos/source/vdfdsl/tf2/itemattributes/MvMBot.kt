package btpos.source.vdfdsl.tf2.itemattributes

import btpos.source.vdfdsl.modeling.*
import btpos.source.vdfdsl.serialization.codecs.*
import btpos.source.vdfdsl.tf2.itemattributes.impl.*
import java.util.*


interface MvMBotAttributes : EntityAttributes, IBlockScoped {
	companion object : MvMBotAttributes
	
	/**
	 * 
	 *
	 * If true, spawns a rocketjump particle whenever the robot jumps.
	 */
	context(attrs: IKeyValueMap)
	var customJumpParticle: Boolean?
		get() = attrs.getTyped("bot custom jump particle", BinaryIntCodec)
		set(value) = attrs.setNullable("bot custom jump particle", value, BinaryIntCodec)
	
	/**
	 * 
	 *
	 * Defaults to 50, I guess it's a percentage.
	 */
	context(attrs: IKeyValueMap)
	var medicUberHealthThreshold: Int?
		get() = attrs.getTyped("bot medic uber health threshold")
		set(value) = attrs.setNullable("bot medic uber health threshold", value)
	
	/**
	 * 
	 *
	 * Defaults to -1.
	 */
	context(attrs: IKeyValueMap)
	var medicUberDeployDelayDuration: Int?
		get() = attrs.getTyped("bot medic uber deploy delay duration")
		set(value) = attrs.setNullable("bot medic uber deploy delay duration", value)
}

