import org.gradle.api.internal.DocumentationRegistry.BASE_URL
import java.io.FileInputStream
import java.util.Properties

plugins {
    id("common.data.remote")
}

val localProperties = Properties().apply {
    val file = rootProject.file("local.properties")
    if (file.exists()) {
        load(FileInputStream(file))
    }
}

val BASE_URL: String = localProperties.getProperty("BASE_URL")
val ACCESS_TOKEN: String = localProperties.getProperty("ACCESS_TOKEN")






android {
    buildFeatures {
        buildConfig = true
    }
    namespace = "com.etisilattask.movies.common.data.remote"
    compileSdk = libs.versions.compileSdk.get().toInt()

    defaultConfig {
        buildConfigField("String", "BASE_URL", "\"$BASE_URL\"")
        buildConfigField("String", "ACCESS_TOKEN", "\"$ACCESS_TOKEN\"")
        minSdk = libs.versions.minSdk.get().toInt()

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
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