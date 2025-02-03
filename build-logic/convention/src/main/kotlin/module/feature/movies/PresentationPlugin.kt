package module.feature.movies

import com.etisalattask.movies.convention.util.implementation
import com.etisalattask.movies.convention.util.library
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.project

class PresentationPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            pluginManager.apply {
                apply("feature")
            }

            dependencies {
                implementation(project(":common:domain"))
                implementation(project(":feature:movies:domain"))
                implementation(library("compose.constraint"))
                implementation(library("placeholdermaterial3"))
            }
        }
    }
}