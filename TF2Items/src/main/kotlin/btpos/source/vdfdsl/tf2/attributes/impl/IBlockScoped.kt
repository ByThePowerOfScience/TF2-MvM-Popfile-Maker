package btpos.source.vdfdsl.tf2.attributes.impl

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
@BlockScoped
interface IBlockScoped

inline operator fun <T : IBlockScoped> T.invoke(action: T.() -> Unit) {
	this.apply(action)
}