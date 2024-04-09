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
    implementation ("io.vavr:vavr:0.10.4")
    implementation("org.springframework.boot:spring-boot-starter-undertow")
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    implementation(project(":domain"))
    implementation(project(":application"))

    implementation("org.springdoc:springdoc-openapi-webmvc-core:1.6.8")
    implementation("org.springdoc:springdoc-openapi-ui:1.6.8")

    implementation("com.fasterxml.jackson.module:jackson-module-afterburner")

    implementation("mysql:mysql-connector-java")

    testImplementation("org.flywaydb:flyway-core")
    testImplementation("org.springframework.boot:spring-boot-starter-test")

    testImplementation("org.testcontainers:testcontainers:1.17.2")
    testImplementation("org.testcontainers:mysql:1.17.2")
    testImplementation("org.testcontainers:junit-jupiter:1.17.2")

    testRuntimeOnly("com.h2database:h2")
}

flyway {
    url = System.getenv("FLYWAY_DB") ?: "jdbc:mysql://localhost:3306/adm_videos"
    user = System.getenv("FLYWAY_USER") ?: "root"
    password = System.getenv("FLYWAY_PASS") ?: "admin"
}

tasks.test {
    useJUnitPlatform()
}