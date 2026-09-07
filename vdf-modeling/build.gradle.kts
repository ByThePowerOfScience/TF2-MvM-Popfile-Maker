plugins {
	id("general-convention")
	id("assignment-convention")
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