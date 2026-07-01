pluginManagement {
	includeBuild("../build-logic")
}

plugins {
	id("org.gradle.toolchains.foojay-resolver-convention") version "1.0.0"
}


rootProject.name = "vdf-translation"

dependencyResolutionManagement {
	versionCatalogs {
		create("libs") {
			from(files("../gradle/libs.versions.toml"))
		}
	}
}

includeBuild("../vdf-modeling") {
	dependencySubstitution {
		substitute(module("btpos.source.vdfdsl.vdf:vdf-modeling")).using(project(":"))
	}
}
includeBuild("../vdf-parser") {
	dependencySubstitution {
		substitute(module("btpos.source.vdfdsl.vdf:vdf-parser")).using(project(":"))
	}
}