plugins {
	id("general-convention")
	id("clojure-convention")
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
	implementation(libs.datafixerupper)
	
	testImplementation(kotlin("test"))
}

kotlin {
	jvmToolchain(21)
}

tasks.test {
	useJUnitPlatform()
}