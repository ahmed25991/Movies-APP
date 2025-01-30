import com.android.build.gradle.LibraryExtension
import com.etisalattask.movies.convention.configureAndroidCompose
import com.etisalattask.movies.convention.util.androidTestImplementation
import com.etisalattask.movies.convention.util.debugImplementation
import com.etisalattask.movies.convention.util.implementation
import com.etisalattask.movies.convention.util.library
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.getByType

class AndroidLibraryComposeConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            with(pluginManager) {
                apply("com.android.library")
                apply("org.jetbrains.kotlin.android")
                apply("org.jetbrains.kotlin.plugin.compose")
            }
            val extension = extensions.getByType<LibraryExtension>()
            configureAndroidCompose(extension)
            dependencies {
                implementation(library("core.ktx"))
                implementation(platform(library("compose.bom")))
                implementation(library("ui"))
                implementation(library("ui.graphics"))
                implementation(library("ui.tooling.preview"))
                implementation(library("material3"))
                androidTestImplementation(platform(library("compose.bom")))
                debugImplementation(library("ui.tooling"))
                debugImplementation(library("ui.test.manifest"))
            }
        }
    }
}
