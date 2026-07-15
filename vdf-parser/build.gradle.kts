plugins {
	id("general-convention")
}

group = "btpos.source.vdfdsl.vdf"
version = Constants.PROJECT_VERSION

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
	api("btpos.source.vdfdsl.vdf:vdf-modeling:${Constants.PROJECT_VERSION}")
}

sourceSets.main {
	java.srcDir("src/generated/java")
}