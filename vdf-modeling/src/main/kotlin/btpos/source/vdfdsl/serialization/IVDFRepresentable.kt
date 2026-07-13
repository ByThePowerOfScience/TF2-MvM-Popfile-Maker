package btpos.source.vdfdsl.serialization

/**
 * Something that can be represented by a [VDFObject][btpos.source.vdfdsl.backing.VDFObject].
 *
 * Sealed such that only two types of representables exist: [values][IVDFRepresentableValue_Trivial] and [keyvalues][IVDFRepresentableKeyValue].
 * Both types can be extended freely.
 */
sealed interface IVDFRepresentable