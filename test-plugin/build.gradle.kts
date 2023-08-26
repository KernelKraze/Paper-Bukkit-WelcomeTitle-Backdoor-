plugins {
    id("xyz.jpenilla.run-paper") version "2.1.0"
    id("java")
}

repositories {
    // 这里添加 Maven 仓库
    mavenCentral()
    maven("https://papermc.io/repo/repository/maven-public/")
}

tasks {
    runServer {
        minecraftVersion("1.20.1")
    }
}

dependencies {
    compileOnly("io.papermc.paper:paper-api:1.20.1-R0.1-SNAPSHOT")
}

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(17))
    }
}
