package btpos.source.vdfdsl.tf2.filegeneration

context(appendable: Appendable)
operator fun String.unaryPlus() = appendable.append(this)

operator fun Appendable.plus(other: String) = append(other)