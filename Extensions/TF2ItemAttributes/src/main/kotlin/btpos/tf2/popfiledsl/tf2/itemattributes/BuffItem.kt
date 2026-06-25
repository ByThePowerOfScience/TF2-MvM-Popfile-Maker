package btpos.tf2.popfiledsl.tf2.itemattributes

import btpos.tf2.popfiledsl.modeling.*
import btpos.tf2.popfiledsl.serialization.codecs.*


/**
 * Items: The Buff Banner, The Battalion's Backup, The Concheror, Festive Buff Banner
 * 
 */
abstract class BuffItemAttributes : BaseMeleeAttributes() {
	companion object : BuffItemAttributes() {
		operator fun invoke(scope: BuffItemAttributes.Companion.() -> Unit) {
			this.apply(scope)
		}
	}
	
	/**
	 * Sets which banner is used
	 * 0 = Buff Banner
	 * 1 = Battalion's Backup
	 * 2 = Concheror
	 */
	context(attrs: IKeyValueMap)
	var modSoldierBuffType: Int?
		get() = attrs.getTyped("mod soldier buff type")
		set(value) = attrs.setNullable("mod soldier buff type", value)
	
	/**
	 * Value type: percentage
	 * 
	 * Multiplier to buff duration
	 * Weirdly it just modifies when the "BuffBanner Flag" (the prop) detaches from the player, which means it's actually the _flag_ that does the buffing, lmao
	 */
	context(attrs: IKeyValueMap)
	var increaseBuffDuration: Float?
		get() = attrs.getTyped("increase buff duration")
		set(value) = attrs.setNullable("increase buff duration", value)
}

