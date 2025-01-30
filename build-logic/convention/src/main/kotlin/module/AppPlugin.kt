package module

import com.etisalattask.movies.convention.util.androidTestImplementation
import com.etisalattask.movies.convention.util.debugImplementation
import com.etisalattask.movies.convention.util.implementation
import com.etisalattask.movies.convention.util.library
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.project

class AppPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            pluginManager.apply {
                apply("movies.android.application.compose")
                apply("hilt")
            }
            dependencies {
                //modules
                implementation(project(":core"))
                implementation(project(":common:domain"))
                implementation(project(":common:presentation"))
                implementation(project(":feature:splash:presentation"))
                //libraries
                implementation(library("systemControlUi"))
                implementation(library("navigation.compose"))
                implementation(library("compose.constraint"))
                implementation(library("core.ktx"))
                implementation(library("lifecycle.runtime.ktx"))
                implementation(library("activity.compose"))
                implementation(platform(library("compose.bom")))
                implementation(library("ui"))
                implementation(library("ui.graphics"))
                implementation(library("ui.tooling.preview"))
                implementation(library("material3"))
                androidTestImplementation(library("espresso.core"))
                androidTestImplementation(platform(library("compose.bom")))
                androidTestImplementation(library("navigation.testing"))
                androidTestImplementation(library("hilt.navigation"))
                debugImplementation(library("ui.tooling"))
                debugImplementation(library("ui.test.manifest"))
            }
        }
    }
}
