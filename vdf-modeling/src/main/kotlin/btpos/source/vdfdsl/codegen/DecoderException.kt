package btpos.source.vdfdsl.codegen

open class DecoderException(override val message: String?, override val cause: Throwable? = null) : RuntimeException(message, cause)
