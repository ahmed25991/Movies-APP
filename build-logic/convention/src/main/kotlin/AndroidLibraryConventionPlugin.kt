import com.android.build.gradle.LibraryExtension
import com.etisalattask.movies.convention.configureKotlinAndroid
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.getByType

class AndroidLibraryConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            with(pluginManager) {
                apply("com.android.library")
                apply("org.jetbrains.kotlin.android")
                apply("org.jetbrains.kotlin.plugin.compose")
            }
            val extension = extensions.getByType<LibraryExtension>()
            configureKotlinAndroid(extension)
        }
    }
}