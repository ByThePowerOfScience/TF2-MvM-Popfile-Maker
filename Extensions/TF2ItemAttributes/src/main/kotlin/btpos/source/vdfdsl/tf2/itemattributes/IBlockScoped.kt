package btpos.source.vdfdsl.tf2.itemattributes

@DslMarker
annotation class BlockScoped

/**
 * Marker interface to make it so you can do this:
 *
 * ```
 * myThing {
 *      myThing1 = 2
 *      myThing2 = 3
 * }
 * ```
 */
@btpos.source.vdfdsl.tf2.itemattributes.BlockScoped
interface IBlockScoped

inline operator fun <T : btpos.source.vdfdsl.tf2.itemattributes.IBlockScoped> T.invoke(action: T.() -> Unit) {
	this.apply(action)
}