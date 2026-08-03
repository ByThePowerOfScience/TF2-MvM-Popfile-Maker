package btpos.source.vdfdsl.tf2.items

import btpos.source.vdfdsl.tf2.itemattributes.impl.IBlockScoped

/**
 * Helper class for creating weapons
 */
class TFItemFactory<ATTR : IBlockScoped>(val scope: ATTR) {
	operator fun invoke(name: String): TFItem<ATTR> {
		return TFItem(name, null, scope)
	}
}