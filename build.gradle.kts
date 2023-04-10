plugins {
    java
    kotlin("jvm") version "1.8.0"
    id("io.izzel.taboolib") version "1.56"
    application
}
taboolib {
    description {
        contributors {
            name("AyolK")
            name("Doofenshmirtz")
        }
        dependencies {
            bukkitApi("1.13")
            name("PlayerPoints")
        }
    }
    install(
        "common",
        "common-5",
        "platform-bukkit",
        "module-configuration",
        "module-chat",
        "module-lang",
        "module-kether",
        "module-metrics",
        "module-nms",
        "module-nms-util"

    )

    version = "6.0.10-113"
    classifier = null
}

group = "cn.Yumcraft"
version = "1.0.2-SNAPSHOT"
repositories {
    mavenCentral()
    maven ("https://repo.rosewooddev.io/repository/public/")
}

dependencies {
    compileOnly(kotlin("stdlib"))
    // server
    compileOnly("ink.ptms:nms-all:1.0.0")
    compileOnly("ink.ptms.core:v11902:11902-minimize:mapped")
    compileOnly("ink.ptms.core:v11902:11902-minimize:universal")
    compileOnly("org.black_ixx:playerpoints:3.2.5")
    compileOnly(fileTree("libs"))
}

tasks.test {
    useJUnitPlatform()
}

kotlin {
    jvmToolchain(11)
}

application {
    mainClass.set("MainKt")
}