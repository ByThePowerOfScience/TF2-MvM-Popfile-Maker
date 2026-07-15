package btpos.source.vdfdsl.tf2.itemattributes

import btpos.source.vdfdsl.modeling.*
import btpos.source.vdfdsl.serialization.codecs.*
import btpos.source.vdfdsl.tf2.itemattributes.impl.*
import java.util.*

/**
 * Items: The Buff Banner, The Battalion's Backup, The Concheror, Festive Buff Banner
 */
interface BuffItemAttributes : BaseMeleeAttributes, IBlockScoped {
	companion object : BuffItemAttributes
	
	/**
	 * 
	 *
	 * Note that Phlogistinator's rage has a small cooldown after expiring before it can gain rage again, to prevent the lingering crit flames from immediately filling it up again.
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
	context(attrs: IKeyValueMap)
	override var soldierBuffType: Int?
		get() = super.soldierBuffType
		set(value) { super.soldierBuffType = value }
	
	/**
	 * 
	 *
	 * Note that Phlogistinator's rage has a small cooldown after expiring before it can gain rage again, to prevent the lingering crit flames from immediately filling it up again.
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
	context(attrs: IKeyValueMap)
	override var demoBuffType: Int?
		get() = super.demoBuffType
		set(value) { super.demoBuffType = value }
	
	/**
	 * In-Game: "+N% buff duration"
	 *
	 * 
	 *
	 * Multiplier applied to buff duration.
	 *
	 * Multiplier to buff duration.
	 *
	 * Actually just read by the "BuffBanner _Flag_" (the prop) for when it should detach from the player, and it's actually the _flag_ that does the buffing.
	 */
	context(attrs: IKeyValueMap)
	override var increaseBuffDuration: Number?
		get() = super.increaseBuffDuration
		set(value) { super.increaseBuffDuration = value }
	
	/**
	 * In-Game: "+N% buff duration"
	 *
	 * 
	 *
	 * Multiplier applied to buff duration.
	 *
	 * Multiplier to buff duration.
	 *
	 * Actually just read by the "BuffBanner _Flag_" (the prop) for when it should detach from the player, and it's actually the _flag_ that does the buffing.
	 */
	context(attrs: IKeyValueMap)
	override var increaseBuffDurationHidden: Number?
		get() = super.increaseBuffDurationHidden
		set(value) { super.increaseBuffDurationHidden = value }
}

