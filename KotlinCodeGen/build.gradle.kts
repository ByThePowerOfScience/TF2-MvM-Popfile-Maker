plugins {
	id("general-convention")
}

group = "btpos.misc.kt"
version = "1.0-SNAPSHOT"

repositories {
	mavenCentral()
}

dependencies {
	implementation(libs.kotlinpoet)
	implementation(kotlin("reflect"))
}