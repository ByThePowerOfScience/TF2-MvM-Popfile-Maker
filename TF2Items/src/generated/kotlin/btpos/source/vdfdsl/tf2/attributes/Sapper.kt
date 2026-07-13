package btpos.source.vdfdsl.tf2.attributes

import btpos.source.vdfdsl.modeling.*
import btpos.source.vdfdsl.serialization.codecs.*
import btpos.source.vdfdsl.tf2.attributes.impl.*
import java.util.*

/**
 * Items: Stock Sapper, The Red-Tape Recorder, Promo Red-Tape Recorder, The Ap-Sap, Festive Sapper, The Snack Attack
 */
interface SapperAttributes : BuilderAttributes, IBlockScoped {
	companion object : SapperAttributes
	
	/**
	 * In-Game: "Reverses enemy building construction"
	 *
	 * 
	 *
	 * On player.
	 *
	 * How fast the building should reverse construction.
	 */
	context(attrs: IKeyValueMap)
	var sapperDegeneratesBuildings: Int?
		get() = attrs.getTyped("sapper degenerates buildings")
		set(value) = attrs.setNullable("sapper degenerates buildings", value)
	
	/**
	 * In-Game: "Increased robot Sapper radius and duration"
	 *
	 * 
	 *
	 * If building an OBJ_ATTACHMENT_SAPPER on a mode that allows upgrades and it's built on a player (or MvM bot):.
	 *
	 * Gives the sapper a radius instead of being single-target.
	 *
	 * When the sapper is applied to a player (including MvM bots):.
	 *
	 * 2 - stun time is 5.5 seconds, radius is 225 hammer units.
	 *
	 * 3 - stuns for 7 seconds, radius is 250 hammer units.
	 *
	 * else stuns for 4 seconds and radius is 200 HU.
	 */
	context(attrs: IKeyValueMap)
	override var roboSapper: Int?
		get() = super.roboSapper
		set(value) { super.roboSapper = value }
}

