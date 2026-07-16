plugins {
	id("general-convention")
}

group = Constants.Groups.TF2
version = Constants.PROJECT_VERSION

repositories {
	mavenCentral()
	
	flatDir {
		dir("../libs")
	}
}

dependencies {
	api("btpos.source.vdfdsl.vdf:vdf-modeling:${Constants.PROJECT_VERSION}")
	
	testImplementation(platform("org.junit:junit-bom:6.0.0"))
	testImplementation("org.junit.jupiter:junit-jupiter")
	testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}

sourceSets.main {
	kotlin.srcDir("src/generated/kotlin")
}

tasks.test {
	useJUnitPlatform()
}