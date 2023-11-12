val taboolibVersion: String by project

plugins {
    id("org.jetbrains.kotlin.jvm") version "1.7.20"
    id("io.izzel.taboolib") version "1.56"
    id("org.jetbrains.dokka") version "1.7.20"
}

taboolib {
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
        "module-nms-util",
        "expansion-geek-tool"
    )
    description {
        contributors {
            name("HSDLao_liao")
        }
        dependencies {
            bukkitApi("1.13")
            name("PlaceholderAPI").optional(true)
            name("Vault").optional(true)
            name("PlayerPoints").optional(true)
            name("ItemsAdder").optional(true)
            name("TrHologram").optional(true)
            name("MythicMobs").optional(true)
        }
    }

    relocate("me.geek.mail", group.toString())
    relocate("com.zaxxer.hikari", "com.zaxxer.hikari_4_0_3_mail")
    relocate("redis.clients.jedis", "redis.clients.mail.jedis_4_2_2")
   // relocate("com.google.gson", "com.google.gson2_9_1")
    classifier = null
    version = taboolibVersion
}

repositories {
    mavenCentral()
    maven("https://repo.tabooproject.org/repository/releases")
    maven("https://oss.sonatype.org/content/repositories/snapshots")
    maven("https://repo.extendedclip.com/content/repositories/placeholderapi/")
    maven("https://repo.codemc.org/repository/maven-public")
    maven("https://repo.rosewooddev.io/repository/public/")
    maven("https://repo.opencollab.dev/maven-snapshots/")
    maven("https://maven.aliyun.com/repository/central")
    maven("https://jitpack.io")
    maven("https://maven.pkg.github.com/LoneDev6/API-ItemsAdder")
    maven("https://mvn.lumine.io/repository/maven-public/")
}

tasks.dokkaHtml.configure {
    outputDirectory.set(buildDir.resolve("dokka"))
}

dependencies {


    dokkaHtmlPlugin("org.jetbrains.dokka:kotlin-as-java-plugin:1.7.20")

    compileOnly("io.lumine.xikage:MythicMobs:4.11.0")

    compileOnly(kotlin("stdlib"))
    // Libraries
    compileOnly(fileTree("libs"))
    compileOnly("com.zaxxer:HikariCP:4.0.3")
    compileOnly("redis.clients:jedis:4.2.2")
    compileOnly("javax.mail:javax.mail-api:1.6.2") { isTransitive = false }
    compileOnly("javax.activation:activation:1.1.1") { isTransitive = false }
 //   compileOnly("com.google.code.gson:gson:2.9.1")
    compileOnly("org.xerial.snappy:snappy-java:1.1.8.4")


    compileOnly("ink.ptms.core:v11701:11701-minimize:mapped")
    compileOnly("ink.ptms.core:v11701:11701-minimize:universal")
    compileOnly("ink.ptms.core:v11604:11604")

    compileOnly("me.clip:placeholderapi:2.10.9") { isTransitive = false }
    compileOnly("com.github.MilkBowl:VaultAPI:-SNAPSHOT") { isTransitive = false }
    compileOnly("org.black_ixx:playerpoints:3.1.1") { isTransitive = false }
    compileOnly("com.github.LoneDev6:api-itemsadder:3.2.3c")

}

