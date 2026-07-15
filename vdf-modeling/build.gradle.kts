plugins {
	id("general-convention")
	id("clojure-convention")
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
	implementation(libs.datafixerupper)
	
	testImplementation(kotlin("test"))
}

kotlin {
	jvmToolchain(21)
}

tasks.test {
	useJUnitPlatform()
}