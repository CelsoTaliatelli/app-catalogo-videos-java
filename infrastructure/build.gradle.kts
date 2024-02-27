buildscript {
    repositories{
        mavenCentral()
    }
    dependencies {
        classpath("org.flywaydb:flyway-mysql:9.11.0")
    }
}


plugins {
    id("java")
    id("application")
    id ("org.springframework.boot") version ("2.7.7")
    id ("io.spring.dependency-management") version ("1.1.0")
    id("org.flywaydb.flyway") version ("9.11.0")
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

    testRuntimeOnly("com.h2database:h2")
}

flyway {
    url = System.getenv("FLYWAY_DB") ?: "jdbc:mysql://localhost:3306/adm_videos"
    user = System.getenv("FLYWAY_USER") ?: "root"
    password = System.getenv("FLYWAY_PASS") ?: "123456"
}

tasks.test {
    useJUnitPlatform()
}