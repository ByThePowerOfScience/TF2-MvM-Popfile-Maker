package btpos.source.vdfdsl.tf2.itemattributes.impl

interface IEnumCustomValue {
	val value: Int
}


operator fun <T : IEnumCustomValue> T.plus(set: Set<T>) = setOf(this) + set

operator fun <T : IEnumCustomValue> T.plus(other: T) = setOf(this, other)
