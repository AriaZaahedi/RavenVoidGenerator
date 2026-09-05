plugins {
    id("java")
}

group = "ir.ariwuh.plugin.ravenvoidgenerator"
version = "1.0"

java {
    toolchain.languageVersion.set(JavaLanguageVersion.of(26))
}

repositories {
    mavenCentral()
    maven("https://repo.papermc.io/repository/maven-public/")
}

dependencies {
    compileOnly("io.papermc.paper:paper-api:26.2.build.+")
}