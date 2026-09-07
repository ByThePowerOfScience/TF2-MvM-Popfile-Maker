import org.gradle.kotlin.dsl.invoke
import org.jetbrains.kotlin.gradle.internal.builtins.StandardNames.FqNames.annotation

plugins {
	kotlin("plugin.assignment")
}

assignment {
	annotation("btpos.source.vdfdsl.util.SupportsCustomAssignment")
}