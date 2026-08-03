
pluginManagement {
	includeBuild("../build-logic")
}

plugins {
	id("org.gradle.toolchains.foojay-resolver-convention") version "1.0.0"
}

dependencyResolutionManagement {
	versionCatalogs {
		create("libs") {
			from(files("../gradle/libs.versions.toml"))
		}
	}
}

includeBuild("../TF2Items")
includeBuild("../vdf-parser") {
	dependencySubstitution {
		substitute(module("btpos.source.vdfdsl.vdf:vdf-parser")).using(project(":"))
	}
}