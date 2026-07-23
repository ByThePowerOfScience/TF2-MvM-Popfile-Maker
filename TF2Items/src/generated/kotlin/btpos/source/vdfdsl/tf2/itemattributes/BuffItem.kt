package btpos.source.vdfdsl.tf2.itemattributes

import btpos.source.vdfdsl.modeling.*
import btpos.source.vdfdsl.serialization.codecs.*
import btpos.source.vdfdsl.tf2.itemattributes.impl.*
import java.util.*

/**
 * Items: The Buff Banner, The Battalion's Backup, The Concheror, Festive Buff Banner, The B.A.S.E Jumper
 */
interface BuffItemAttributes : BaseMeleeAttributes, IBlockScoped {
	companion object : BuffItemAttributes
	
	/**
	 * 
	 *
	 * Sets which banner is used.
	 *
	 * 0 = Buff Banner.
	 *
	 * 1 = Battalion's Backup.
	 *
	 * 2 = Concheror.
	 */
	context(attrs: IKeyValueMap)
	var soldierBuffType: Int?
		get() = attrs.getTyped("mod soldier buff type")
		set(value) = attrs.setNullable("mod soldier buff type", value)
	
	/**
	 * 
	 *
	 * Sets which banner is used.
	 *
	 * 0 = Buff Banner.
	 *
	 * 1 = Battalion's Backup.
	 *
	 * 2 = Concheror.
	 */
	context(attrs: IKeyValueMap)
	var demoBuffType: Int?
		get() = attrs.getTyped("mod demo buff type")
		set(value) = attrs.setNullable("mod demo buff type", value)
	
	/**
	 * In-Game: "+N% buff duration"
	 *
	 * 
	 *
	 * Multiplier to buff duration.
	 */
	context(attrs: IKeyValueMap)
	var increaseBuffDuration: Number?
		get() = attrs.getTyped("increase buff duration")
		set(value) = attrs.setNullable("increase buff duration", value)
	
	/**
	 * In-Game: "+N% buff duration"
	 *
	 * 
	 *
	 * Multiplier to buff duration.
	 */
	context(attrs: IKeyValueMap)
	var increaseBuffDurationHidden: Number?
		get() = attrs.getTyped("increase buff duration HIDDEN")
		set(value) = attrs.setNullable("increase buff duration HIDDEN", value)
}

