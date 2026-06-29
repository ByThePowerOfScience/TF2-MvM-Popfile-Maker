plugins {
	kotlin("jvm") version "2.3.10"
}

group = "btpos.tf2.popfiledsl.vdfparser"
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