plugins {
    id("java-library")
    id("com.github.hierynomus.license") version "0.16.1"
}

allprojects {
    repositories {
        mavenLocal()
        mavenCentral()
        maven("https://hub.spigotmc.org/nexus/content/groups/public/")
    }
}

subprojects {

    apply {
        plugin("java-library")
        plugin("com.github.hierynomus.license")
    }

    group = "dev.triumphteam"
    version = "3.1.5"

    dependencies {
        compileOnly("org.jetbrains:annotations:21.0.1")
        compileOnly("org.spigotmc:spigot-api:1.19.4-R0.1-SNAPSHOT")
        compileOnly("org.apache.commons:commons-lang3:3.12.0")

        val adventureVersion = "4.13.1"
        api("net.kyori:adventure-api:$adventureVersion")
        api("net.kyori:adventure-text-serializer-legacy:$adventureVersion")
        api("net.kyori:adventure-text-serializer-gson:$adventureVersion")
    }

    license {
        header = rootProject.file("LICENSE")
        encoding = "UTF-8"
        mapping("java", "JAVADOC_STYLE")
        include("**/*.java")
    }

    tasks {
        withType<JavaCompile> {
            sourceCompatibility = "17"
            targetCompatibility = "17"
            options.encoding = "UTF-8"
        }
    }

}
