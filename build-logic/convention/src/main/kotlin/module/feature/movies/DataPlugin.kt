package module.feature.movies

import com.etisalattask.movies.convention.util.implementation
import com.etisalattask.movies.convention.util.library
import com.etisalattask.movies.convention.util.testImplementation
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
                implementation(project(":feature:movies:domain"))
            }
        }
    }
}
