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
}
