plugins {
	id("general-convention")
	kotlin("plugin.assignment") version libs.versions.kotlin
}

group = "btpos.source.vdfdsl.vdf"
version = Constants.PROJECT_VERSION

repositories {
	mavenCentral()
	
	flatDir {
		dir("../libs")
	}
}

dependencies {
	implementation(kotlin("reflect"))
	implementation(libs.kotlinpoet)
	api("btpos.misc.kt.codegen:KotlinCodeGen:1.0-SNAPSHOT")
}