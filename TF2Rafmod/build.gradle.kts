plugins {
	id("general-convention")
	kotlin("plugin.assignment") version libs.versions.kotlin
}

group = "btpos.source.vdfdsl.tf2.rafmod"
version = "1.0-SNAPSHOT"

repositories {
	mavenCentral()
}

dependencies {
	api("btpos.source.vdfdsl:PopFileDSL:${Constants.PROJECT_VERSION}")
	
	testImplementation(platform("org.junit:junit-bom:6.0.0"))
	testImplementation("org.junit.jupiter:junit-jupiter")
	testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}

assignment {
	annotation("btpos.source.vdfdsl.util.SupportsCustomAssignment")
}

tasks.test {
	useJUnitPlatform()
}