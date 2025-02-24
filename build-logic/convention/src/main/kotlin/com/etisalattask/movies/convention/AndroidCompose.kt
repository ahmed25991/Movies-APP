package com.etisalattask.movies.convention

import com.android.build.api.dsl.CommonExtension
import com.etisalattask.movies.convention.util.libs
import org.gradle.api.Project

/**
 * Configure Compose-specific options
 */
internal fun Project.configureAndroidCompose(
    commonExtension: CommonExtension<*, *, *, *, *,*>,
) {
    commonExtension.apply {
        buildFeatures {
            compose = true
        }

        composeOptions {
            kotlinCompilerExtensionVersion ="1.5.3"

        }
    }

    configureKotlinAndroid(commonExtension)
}
