import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    `kotlin-dsl`
}

group = "com.etisilattask.movies.convention"

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}

tasks.withType<KotlinCompile>().configureEach {
    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_17.toString()
    }
}

dependencies {
    compileOnly(libs.android.gradlePlugin)
    compileOnly(libs.kotlin.gradlePlugin)
    compileOnly(libs.ksp.gradlePlugin)
}

gradlePlugin {
    plugins {
        register("androidApplicationCompose") {
            id = "movies.android.application.compose"
            implementationClass = "AndroidApplicationComposeConventionPlugin"
        }
        register("androidLibrary") {
            id = "movies.android.library"
            implementationClass = "AndroidLibraryConventionPlugin"
        }
        register("androidLibraryCompose") {
            id = "movies.android.library.compose"
            implementationClass = "AndroidLibraryComposeConventionPlugin"
        }
        register("hilt") {
            id = "hilt"
            implementationClass = "library.HiltPlugin"
        }
        register("appModule") {
            id = "app"
            implementationClass = "module.AppPlugin"
        }
        register("coreModule") {
            id = "core"
            implementationClass = "module.CorePlugin"
        }
        register("commonDataRemoteModule") {
            id = "common.data.remote"
            implementationClass = "module.common.data.RemoteDataPlugin"
        }
        register("commonDomainModule") {
            id = "common.domain"
            implementationClass = "module.common.DomainPlugin"
        }
        register("commonPresentationModule") {
            id = "common.presentation"
            implementationClass = "module.common.PresentationPlugin"
        }
        register("feature") {
            id = "feature"
            implementationClass = "module.FeaturePlugin"
        }
        register("featureSplashPresentationModule") {
            id = "feature.splash.presentation"
            implementationClass = "module.feature.splash.PresentationPlugin"
        }
    }
}
