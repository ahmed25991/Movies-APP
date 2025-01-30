package module.common

import com.android.build.api.dsl.LibraryExtension
import com.etisalattask.movies.convention.util.androidTestImplementation
import com.etisalattask.movies.convention.util.implementation
import com.etisalattask.movies.convention.util.library
import com.etisalattask.movies.convention.util.versionInt
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.getByType
import org.gradle.kotlin.dsl.project

class PresentationPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            pluginManager.apply {
                apply("movies.android.library.compose")
                apply("org.jetbrains.kotlin.plugin.parcelize")
                apply("hilt")
            }

            dependencies {
                //modules
                implementation(project(":core"))
                implementation(project(":common:domain"))
                //libraries
                implementation(library("lifecycle.runtime.ktx"))
                implementation(library("lifecycle.runtime.compose"))
                implementation(library("hilt.navigation"))
                implementation(library("navigation.common.ktx"))
                implementation(library("gson"))
                implementation(library("lottie"))
                implementation(library("compose.constraint"))
                androidTestImplementation(library("espresso.core"))
                androidTestImplementation(platform(library("compose.bom")))
            }


            extensions.getByType<LibraryExtension>().apply {
                compileSdk = versionInt("compileSdk")
                buildFeatures {
                    buildConfig = true
                }
                defaultConfig {
                    minSdk = versionInt("minSdk")
                    testInstrumentationRunner =
                        "com.etisilattask.movies.common.presentation.HiltTestRunner"
                    consumerProguardFiles("consumer-rules.pro")
                }
                buildTypes {
                    release {
                        isMinifyEnabled = false
                        proguardFiles(
                            getDefaultProguardFile("proguard-android-optimize.txt"),
                            "proguard-rules.pro"
                        )
                    }
                }
            }

        }
    }
}