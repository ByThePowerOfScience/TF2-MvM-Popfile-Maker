package btpos.source.vdfdsl.codegen

open class CodegenException(override val message: String?, override val cause: Throwable? = null) : RuntimeException(message, cause)
