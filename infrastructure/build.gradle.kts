plugins {
    id("java")
    id("application")
    id ("org.springframework.boot") version ("2.7.7")
    id ("io.spring.dependency-management") version ("1.1.0")
}

group = "com.cht.admin.catalogo.infrastructure"

repositories {
    mavenCentral()
}

tasks.bootJar {
    archiveFileName.set("application.jar")
    destinationDirectory.set(file("${rootProject.buildDir}/libs"))
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-web"){
        exclude(module = "spring-boot-starter-tomcat")
    }
    implementation("org.springframework.boot:spring-boot-starter-undertow")
    implementation(project(":domain"))
    implementation(project(":application"))


    testImplementation("org.springframework.boot:spring-boot-starter-test")
}

tasks.test {
    useJUnitPlatform()
}