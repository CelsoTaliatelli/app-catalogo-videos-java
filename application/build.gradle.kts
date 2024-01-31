plugins {
    id("java")
}

group = "com.cht.admin.catalogo.application"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.9.1"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    implementation(project(":domain"))
}

tasks.test {
    useJUnitPlatform()
}