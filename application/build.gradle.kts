plugins {
    id("java")
}

group = "com.cht.admin.catalogo.application"

repositories {
    mavenCentral()
}

dependencies {

    implementation ("io.vavr:vavr:0.10.4")

    testImplementation(platform("org.junit:junit-bom:5.9.1"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    testImplementation("org.mockito:mockito-junit-jupiter:4.5.1")
    implementation(project(":domain"))
}

tasks.test {
    useJUnitPlatform()
}