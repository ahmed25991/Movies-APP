package module.feature.splash

import com.etisalattask.movies.convention.util.implementation
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.project

class DataPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            pluginManager.apply {
                apply("common.data.remote")
            }

            dependencies {
                implementation(project(":common:data:remote"))
                implementation(project(":feature:splash:domain"))
            }
        }
    }
}