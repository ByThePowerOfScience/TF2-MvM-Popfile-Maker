package btpos.source.vdfdsl.tf2.itemattributes

import btpos.source.vdfdsl.modeling.*
import btpos.source.vdfdsl.serialization.codecs.*
import btpos.source.vdfdsl.tf2.itemattributes.impl.*
import btpos.source.vdfdsl.tf2.tftypes.*
import java.util.*



/**
 * Items: TF_WEAPON_SHOVEL, The Equalizer, The Pain Train, Upgradeable TF_WEAPON_SHOVEL, The Market Gardener, The Disciplinary Action, The Escape Plan
 */
interface ShovelAttributes : IBlockScoped {
	companion object {
		/**
		 * In-Game: "Damage increases as the user becomes injured"
		 *
		 * 
		 *
		 * Used to specify "shovel type".
		 *
		 * 0 = Standard.
		 *
		 * 1 = Equalizer.
		 *
		 * 2 = Escape Plan.
		 *
		 * If not 0, DMG_TYPE is "Pickaxe", else "Shovel".
		 */
		val isEqualizer = ItemAttributeNamed<Boolean>("mod shovel damage boost", NumberSelectorCodec(1))
		
		/**
		 * In-Game: "Move speed increases as the user becomes injured"
		 *
		 * 
		 *
		 * Used to specify "shovel type".
		 *
		 * 0 = Standard.
		 *
		 * 1 = Equalizer.
		 *
		 * 2 = Escape Plan.
		 *
		 * If not 0, DMG_TYPE is "Pickaxe", else "Shovel".
		 */
		val isEscapePlan = ItemAttributeNamed<Boolean>("mod shovel speed boost", NumberSelectorCodec(2))
		
		/**
		 * 
		 *
		 * On primary attack, send player flying in the direction they're facing.
		 */
		val airJumpOnAttack = ItemAttributeNamed<Boolean>("air jump on attack")
	}

	/**
	 * In-Game: "Damage increases as the user becomes injured"
	 *
	 * 
	 *
	 * Used to specify "shovel type".
	 *
	 * 0 = Standard.
	 *
	 * 1 = Equalizer.
	 *
	 * 2 = Escape Plan.
	 *
	 * If not 0, DMG_TYPE is "Pickaxe", else "Shovel".
	 */
	val isEqualizer: ItemAttribute<Boolean> get() = ShovelAttributes.isEqualizer
	
	/**
	 * In-Game: "Move speed increases as the user becomes injured"
	 *
	 * 
	 *
	 * Used to specify "shovel type".
	 *
	 * 0 = Standard.
	 *
	 * 1 = Equalizer.
	 *
	 * 2 = Escape Plan.
	 *
	 * If not 0, DMG_TYPE is "Pickaxe", else "Shovel".
	 */
	val isEscapePlan: ItemAttribute<Boolean> get() = ShovelAttributes.isEscapePlan
	
	/**
	 * 
	 *
	 * On primary attack, send player flying in the direction they're facing.
	 */
	val airJumpOnAttack: ItemAttribute<Boolean> get() = ShovelAttributes.airJumpOnAttack

   
}

