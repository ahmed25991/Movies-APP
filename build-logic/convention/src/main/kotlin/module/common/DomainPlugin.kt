package module.common


import com.etisalattask.movies.convention.configureKotlinJvm
import com.etisalattask.movies.convention.util.implementation
import com.etisalattask.movies.convention.util.library
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.project

class DomainPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            pluginManager.apply {
                apply("core")
            }

            configureKotlinJvm()

            dependencies {
                //modules
                implementation(project(":core"))
                //libraries
                implementation(library("javax.inject"))
                implementation(library("coroutines.test"))
            }
        }
    }
}