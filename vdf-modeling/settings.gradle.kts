pluginManagement {
	includeBuild("../build-logic")
}

plugins {
	id("org.gradle.toolchains.foojay-resolver-convention") version "1.0.0"
}


rootProject.name = "vdf-modeling"

dependencyResolutionManagement {
	versionCatalogs {
		create("libs") {
			from(files("../gradle/libs.versions.toml"))
		}
	}
}

includeBuild("../KotlinCodeGen") {
	dependencySubstitution {
		substitute(module("btpos.misc.kt.codegen:KotlinCodeGen")).using(project(":"))
	}
}