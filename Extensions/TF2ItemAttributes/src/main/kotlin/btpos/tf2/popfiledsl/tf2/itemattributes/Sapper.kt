package btpos.tf2.popfiledsl.tf2.itemattributes

import btpos.tf2.popfiledsl.modeling.*
import btpos.tf2.popfiledsl.serialization.codecs.*


/**
 * Items: Stock Sapper, The Red-Tape Recorder, Promo Red-Tape Recorder, The Ap-Sap, Festive Sapper, The Snack Attack
 * 
 */
abstract class SapperAttributes : BuilderAttributes() {
	companion object : SapperAttributes() {
		operator fun invoke(scope: SapperAttributes.Companion.() -> Unit) {
			this.apply(scope)
		}
	}
	
	/**
	 * On player
	 * How fast the building should reverse construction
	 */
	context(attrs: IKeyValueMap)
	var sapperDegeneratesBuildings: Int?
		get() = attrs.getTyped("sapper degenerates buildings")
		set(value) = attrs.setNullable("sapper degenerates buildings", value)
	
	/**
	 * If building an OBJ_ATTACHMENT_SAPPER on a mode that allows upgrades and it's built on a player (or MvM bot):
	 * Gives the sapper a radius instead of being single-target
	 * 
	 * When the sapper is applied to a player (including MvM bots):
	 * 2 - stun time is 5.5 seconds, radius is 225 hammer units
	 * 3 - stuns for 7 seconds, radius is 250 hammer units
	 * else stuns for 4 seconds and radius is 200 HU
	 */
	override context(attrs: IKeyValueMap)
	var roboSapper: Int?
		get() = attrs.getTyped("robo sapper")
		set(value) = attrs.setNullable("robo sapper", value)
}

