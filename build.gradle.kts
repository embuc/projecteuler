import org.gradle.api.tasks.testing.logging.TestExceptionFormat

plugins {
    kotlin("jvm") version "1.9.21"
    // Apply the Lombok plugin
    id("io.freefair.lombok") version "6.3.0"
}

group = "se.embuc"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation("org.jetbrains.kotlin:kotlin-test-junit5")
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.10.1")
    testImplementation("org.junit.jupiter:junit-jupiter-params:5.10.1")
    testImplementation("org.junit.jupiter:junit-jupiter:5.10.0")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.10.1")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher:1.10.1")
    implementation("org.projectlombok:lombok:1.18.24")
    annotationProcessor("org.projectlombok:lombok:1.18.24")

}

tasks{
    test {
        useJUnitPlatform()
        // Enable detailed test output
        testLogging {
            events("passed", "skipped", "failed") // Log when tests pass, skip, or fail
            exceptionFormat = TestExceptionFormat.SHORT // Use SHORT or FULL here
            showCauses = true // Display root causes
            showExceptions = true // Show exception stack traces
            showStandardStreams = true // Show stdout/stderr output of tests
        }
    }
}
kotlin {
    jvmToolchain(17)
}
tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile>().configureEach {
    kotlinOptions {
        freeCompilerArgs += "-Xjvm-default=all"
    }
}
