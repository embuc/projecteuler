plugins {
	kotlin("jvm") version "1.9.0" // Replace with the Kotlin version you are using
}

repositories {
	mavenCentral()
}

dependencies {
	implementation(gradleApi()) // Provides Gradle APIs
	implementation(localGroovy()) // Provides Groovy for Gradle
}
