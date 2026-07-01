
pluginManagement {
	includeBuild("../build-logic")
}

plugins {
	id("org.gradle.toolchains.foojay-resolver-convention") version "1.0.0"
}


includeBuild("../TF2Items")
includeBuild("../vdf-parser") {
	dependencySubstitution {
		substitute(module("btpos.source.vdfdsl.vdf:vdf-parser")).using(project(":"))
	}
}