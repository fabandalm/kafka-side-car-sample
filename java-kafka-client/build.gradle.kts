plugins {
    java
    id("org.springframework.boot") version "3.0.3"
    id("io.spring.dependency-management") version "1.1.1"
}

group = "com.meshtier"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    implementation("org.springframework.boot:spring-boot-starter-web")
    testImplementation("org.springframework.boot:spring-boot-starter-test")
}

tasks.test {
    useJUnitPlatform()
}

tasks.bootJar {
    archiveBaseName.set("java-kafka-sidecar-app")
    archiveVersion.set("1.0.0")
    archiveClassifier.set("")
    archiveExtension.set("jar")
    enabled = true // Ensure the bootJar task is enabled
}

// Optionally disable the standard jar task if not needed
tasks.jar {
    enabled = false
}