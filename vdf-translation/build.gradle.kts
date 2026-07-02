import org.gradle.api.internal.artifacts.dsl.dependencies.DependenciesExtensionModule.module

plugins {
	id("general-convention")
}

group = "btpos.source.vdfdsl.vdf"
version = "1.0-SNAPSHOT"

repositories {
	mavenCentral()
	
	flatDir {
		dir("../libs")
	}
}

dependencies {
	api("btpos.source.vdfdsl.vdf:vdf-modeling:1.0-SNAPSHOT")
	api("btpos.source.vdfdsl.vdf:vdf-parser:1.0-SNAPSHOT")
	
	testImplementation(kotlin("test"))
}

kotlin {
	jvmToolchain(21)
}

tasks.test {
	useJUnitPlatform()
}