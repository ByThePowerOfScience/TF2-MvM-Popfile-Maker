pluginManagement {
	includeBuild("build-logic")
}

plugins {
	id("org.gradle.toolchains.foojay-resolver-convention") version "1.0.0"
}


rootProject.name = "PopFileDSL"

includeBuild("TF2Items") {
	dependencySubstitution {
		substitute(module("btpos.source.vdfdsl.tf2:TF2Items")).using(project(":"))
	}
}
includeBuild("vdf-modeling") {
	dependencySubstitution {
		substitute(module("btpos.source.vdfdsl.vdf:vdf-modeling")).using(project(":"))
	}
}
includeBuild("vdf-parser") {
	dependencySubstitution {
		substitute(module("btpos.source.vdfdsl.vdf:vdf-parser")).using(project(":"))
	}
}
includeBuild("TF2ItemGeneration")