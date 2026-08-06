plugins {
	id("general-convention")
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
}