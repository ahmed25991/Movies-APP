package module.common.data

import com.etisalattask.movies.convention.util.bundle
import com.etisalattask.movies.convention.util.implementation
import com.etisalattask.movies.convention.util.library
import com.etisalattask.movies.convention.util.testImplementation
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.project

class RemoteDataPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            pluginManager.apply {
                apply("movies.android.library")
                apply("org.jetbrains.kotlin.plugin.serialization")
                apply("hilt")
            }

            dependencies {
                //modules
                implementation(project(":common:domain"))
                implementation(project(":core"))
                //libraries
                implementation(library("core.ktx"))
                implementation(library("kotlin.serialization"))
                implementation(library("mockk"))
                testImplementation(library("coroutines.test"))
                implementation(library("retrofit.converter"))
                implementation(library("moshi.kotlin"))
                implementation(library("retrofit"))
                implementation(library("logging.interceptor"))
                implementation(library("gson"))
                implementation(library("converter.moshi"))
            }
        }
    }
}