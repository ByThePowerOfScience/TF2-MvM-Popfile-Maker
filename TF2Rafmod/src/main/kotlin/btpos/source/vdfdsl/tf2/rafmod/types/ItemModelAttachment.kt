package btpos.source.vdfdsl.tf2.rafmod.types

import btpos.source.vdfdsl.tf2.rafmod.data.Rot3
import btpos.source.vdfdsl.tf2.rafmod.data.Vec3
import java.awt.Color

open class ItemModelAttachment {
	companion object {
		val SERIALIZER: (List<ItemModelAttachment>) -> String = {
			it.joinToString("|") { it.toAttribute() }
		}
	}
	
	lateinit var modelPath: String
	
	/**
	 * Leave empty for bonemerge. Put `"none"` for no attachment.
	 */
	var playerAttachmentName: String? = null
	
	var color: Color? = null
	
	var offset: Vec3? = null
	
	var rotation: Rot3? = null
	
	var scale: Number? = null
	
	fun toAttribute(): String {
		require(::modelPath.isInitialized) {
			"Error ItemModelAttachment: model path is null for $this"
		}
		
		var curr = listOf(
			modelPath,
			playerAttachmentName.orEmpty(),
			color?.run { "$red $green $blue" }.orEmpty(),
		)
		
		if (playerAttachmentName != null) {
			curr += listOf(
				offset?.run { "$x $y $z" }.orEmpty(),
				rotation?.vec?.run { "$x $y $z" }.orEmpty(),
				scale?.toString().orEmpty()
			)
		}
		
		return curr.joinToString(",")
	}
	
	override fun toString(): String {
		return "ItemModelAttachment(modelPath='$modelPath', playerAttachmentName=$playerAttachmentName, color=$color, offset=$offset, rotation=$rotation, scale=$scale)"
	}
}