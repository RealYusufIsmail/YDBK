import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.7.10"
    kotlin("plugin.allopen") version "1.7.10"
}

group = "io.github.realyusufismail"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
    maven("https://jitpack.io/")
}

dependencies {
    //JDA
    implementation("net.dv8tion:JDA:5.0.0-alpha.17")
    implementation("com.github.minndevelopment:jda-ktx:0.9.2-alpha.13")
    //logger
    implementation("ch.qos.logback:logback-classic:1.3.0-alpha16")
    implementation("ch.qos.logback:logback-core:1.3.0-alpha16")
    //config
    implementation("io.github.yusufsdiscordbot:config:1.0.4")
    testImplementation(kotlin("test"))
}

tasks.test {
    useJUnitPlatform()
}

configurations {
    all {
        exclude(group = "org.slf4j", module = "slf4j-log4j12")
    }
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "17"
}