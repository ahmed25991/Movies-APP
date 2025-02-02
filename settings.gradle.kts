pluginManagement {
    includeBuild("build-logic")
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
        maven(url = "https://jitpack.io")
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
        maven(url = "https://jitpack.io")
    }
}

rootProject.name = "MoviesApp"
include(":app")
include(":core")
include(":common:data:remote")
include(":common:domain")
include(":common:presentation")

include(":feature:movies:data")
include(":feature:movies:domain")
include(":feature:movies:presentation")


 