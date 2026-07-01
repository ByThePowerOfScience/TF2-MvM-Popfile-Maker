plugins {
	id("general-convention")
}

group = "btpos.source.vdfdsl.vdf"
version = "1.0-SNAPSHOT"

repositories {
	mavenCentral()
	maven(url="https://libraries.minecraft.net")
}

dependencies {
	testImplementation(kotlin("test"))
	api("com.mojang:datafixerupper:1.0.20")
}

kotlin {
	jvmToolchain(21)
}

tasks.test {
	useJUnitPlatform()
}