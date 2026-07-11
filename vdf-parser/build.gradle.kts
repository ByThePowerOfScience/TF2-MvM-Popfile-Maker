plugins {
	id("general-convention")
}

group = "btpos.source.vdfdsl.vdf"
version = "1.0-SNAPSHOT"

repositories {
	mavenCentral()
	maven(url="https://libraries.minecraft.net")
	
	flatDir {
		dir("../libs")
	}
}

dependencies {
	api(libs.datafixerupper)
	// Source: https://mvnrepository.com/artifact/org.antlr/antlr4-runtime
	api("org.antlr:antlr4-runtime:4.13.2")
}

sourceSets.main {
	java.srcDir("src/generated/java")
}