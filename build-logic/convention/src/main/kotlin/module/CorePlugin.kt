package module

import com.etisalattask.movies.convention.configureKotlinJvm
import com.etisalattask.movies.convention.util.implementation
import com.etisalattask.movies.convention.util.library
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies

class CorePlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            pluginManager.apply {
                apply("java-library")
                apply("org.jetbrains.kotlin.jvm")
            }
            configureKotlinJvm()
            dependencies {
                implementation(library("coroutines.core"))
            }
        }
    }
}