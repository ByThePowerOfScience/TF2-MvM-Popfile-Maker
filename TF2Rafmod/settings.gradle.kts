pluginManagement {
	includeBuild("../build-logic")
}
plugins {
	id("org.gradle.toolchains.foojay-resolver-convention") version "1.0.0"
}


rootProject.name = "TF2Rafmod"

dependencyResolutionManagement {
	versionCatalogs {
		create("libs") {
			from(files("../gradle/libs.versions.toml"))
		}
	}
}

includeBuild("../") {
	dependencySubstitution {
		substitute(module("btpos.source.vdfdsl:PopFileDSL")).using(project(":"))
	}
}
