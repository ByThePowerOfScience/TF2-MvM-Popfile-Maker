package btpos.source.vdfdsl.tf2.itemattributes

import btpos.source.vdfdsl.tf2.itemattributes.impl.IBlockScoped


/**
 * Items: The Buff Banner, The Battalion's Backup, The Concheror, Festive Buff Banner
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
	 *
	 * 3 = Parachute.
	 *
	 * Note that the Base Jumper specifically checks the buff type of the user, and if it is not 'parachute', cancels its animation.
	 */
	context(attrs: btpos.source.vdfdsl.modeling.IKeyValueMap)
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
	 *
	 * 3 = Parachute.
	 *
	 * Note that the Base Jumper specifically checks the buff type of the user, and if it is not 'parachute', cancels its animation.
	 */
	context(attrs: btpos.source.vdfdsl.modeling.IKeyValueMap)
	var demoBuffType: Int?
		get() = attrs.getTyped("mod demo buff type")
		set(value) = attrs.setNullable("mod demo buff type", value)
	
	/**
	 * In-Game: "+N% buff duration"
	 *
	 * 
	 *
	 * Multiplier to buff duration.
	 *
	 * Actually just read by the "BuffBanner _Flag_" (the prop) for when it should detach from the player, and it's actually the _flag_ that does the buffing.
	 */
	context(attrs: btpos.source.vdfdsl.modeling.IKeyValueMap)
	var increaseBuffDuration: Float?
		get() = attrs.getTyped("increase buff duration")
		set(value) = attrs.setNullable("increase buff duration", value)
	
	/**
	 * In-Game: "+N% buff duration"
	 *
	 * 
	 *
	 * Multiplier to buff duration.
	 *
	 * Actually just read by the "BuffBanner _Flag_" (the prop) for when it should detach from the player, and it's actually the _flag_ that does the buffing.
	 */
	context(attrs: btpos.source.vdfdsl.modeling.IKeyValueMap)
	var increaseBuffDurationHidden: Float?
		get() = attrs.getTyped("increase buff duration HIDDEN")
		set(value) = attrs.setNullable("increase buff duration HIDDEN", value)
}

