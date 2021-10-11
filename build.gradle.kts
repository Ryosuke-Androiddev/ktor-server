val ktor_version: String by project
val kotlin_version: String by project
val logback_version: String by project

val exposed_version: String by project
val postgres_version: String by project
val hikari_version: String by project

plugins {
    application
    kotlin("jvm") version "1.5.30"
                id("org.jetbrains.kotlin.plugin.serialization") version "1.5.31"
}

group = "com.example"
version = "0.0.1"
application {
    mainClass.set("io.ktor.server.netty.EngineMain")
}

repositories {
    mavenCentral()
}

tasks.create("stage"){
    dependsOn("installDist")
}

dependencies {
    implementation("io.ktor:ktor-server-core:$ktor_version")
    implementation("io.ktor:ktor-serialization:$ktor_version")
    implementation("io.ktor:ktor-server-host-common:$ktor_version")
    implementation("io.ktor:ktor-server-netty:$ktor_version")
    implementation("ch.qos.logback:logback-classic:$logback_version")
    testImplementation("io.ktor:ktor-server-tests:$ktor_version")
    testImplementation("org.jetbrains.kotlin:kotlin-test:$kotlin_version")

    // https://mvnrepository.com/artifact/mysql/mysql-connector-java
    implementation("mysql:mysql-connector-java:8.0.26")


    implementation("io.ktor:ktor-locations:$ktor_version")

    // https://mvnrepository.com/artifact/org.ktorm/ktorm-core
    implementation("org.ktorm:ktorm-core:3.4.1")

    // https://mvnrepository.com/artifact/org.jetbrains.exposed/exposed-core
    implementation("org.jetbrains.exposed:exposed-core:0.35.1")

    // https://mvnrepository.com/artifact/org.jetbrains.exposed/exposed-jdbc
    implementation("org.jetbrains.exposed:exposed-jdbc:0.35.1")

    // https://mvnrepository.com/artifact/org.jetbrains.exposed/exposed-dao
    implementation("org.jetbrains.exposed:exposed-dao:0.35.1")

    // https://mvnrepository.com/artifact/org.postgresql/postgresql
    implementation("org.postgresql:postgresql:42.2.24")

    // https://mvnrepository.com/artifact/com.zaxxer/HikariCP
    implementation("com.zaxxer:HikariCP:5.0.0")

    // https://mvnrepository.com/artifact/com.h2database/h2
    testImplementation("com.h2database:h2:1.4.200")
}