package btpos.source.vdfdsl.tf2.rafmod.bot.tasks

import btpos.source.vdfdsl.modeling.ExtensibleSubtreeImpl
import btpos.source.vdfdsl.modeling.IExtensibleSubtree.Companion.addField
import btpos.source.vdfdsl.modeling.IExtensibleSubtree_VDFRepresentable
import btpos.source.vdfdsl.tf2.rafmod.RafmodConstants.SIGSEGV
import btpos.source.vdfdsl.tf2.rafmod.types.PointTemplate

/**
 * Allows connecting [point templates][PointTemplate] to a bot.
 *
 * Point templates spawned this way will automatically be parented to the bot this block is on.
 *
 * Bone names can be found using HLMV, whcih is available by default in your `Team Fortress 2/bin` folder (which is one directory out from your `/tf/` folder).
 */
open class SpawnTemplate(sub: IExtensibleSubtree_VDFRepresentable = ExtensibleSubtreeImpl()) : RafmodPeriodicTask(sub) {
	override fun copy() = SpawnTemplate(copyInternal())
	
	override val _structIdentifier: String
		get() = "SpawnTemplate"
	
	
	/**
	 * The template that should be spawned by this spawner.
	 *
	 * Example:
	 * ```kotlin
	 * template = MyPointTemplates.Sentry
	 * ```
	 */
	open var template: PointTemplate? by addField("Name", conditional = SIGSEGV)
	
	/**
	 * The name of the bone this template should be attached to.
	 *
	 * Example:
	 * ```kotlin
	 * bone = "bip_head"
	 * ```
	 *
	 * @see CommonBones
	 */
	open var bone: String? by addField("Bone", conditional = SIGSEGV)
	
	
	object CommonBones {
		const val HEAD = "bip_head"
		
		/**
		 * Attach along the spine. Used by the CTF flag and bomb.
		 */
		const val FLAG = "bip_spine_2"
		
		const val HAND_LEFT = "bip_hand_L"
		
		const val HAND_RIGHT = "bip_hand_R"
		
		
		const val WEAPON_RIGHT = "weapon_bone_R"
		const val WEAPON_LEFT = "weapon_bone_L"
		
		const val FOOT_LEFT = "bip_foot_L"
		const val FOOT_RIGHT = "bip_foot_R"
		//
		//bip_hand_R
		//weapon_bone_R
		//weapon_bone_L
		//bip_foot_L
		//bip_foot_R
	}
}