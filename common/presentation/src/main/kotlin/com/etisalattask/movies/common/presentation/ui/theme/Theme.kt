package com.etisalattask.movies.common.presentation.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.*
import androidx.compose.runtime.Composable

private val LightColors = lightColorScheme(
    primary = PrimaryRed,
    onPrimary = OnPrimaryText,
    secondary = SecondaryGold,
    onSecondary = OnSecondaryText,
    background = BackgroundDark,
    onBackground =  DarkOnBackground,
    surface = DarkSurface,
    onSurface = DarkOnBackground
)

private val DarkColors = darkColorScheme(
    primary = DarkPrimary,
    onPrimary = OnPrimaryText,
    secondary = SecondaryGold,
    onSecondary = OnSecondaryText,
    background = BackgroundDark,
    onBackground = DarkOnBackground,
    surface = DarkSurface,
    onSurface = DarkOnBackground
)

@Composable
fun MoviesAppTheme(
    useDarkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colors = if (useDarkTheme) DarkColors else LightColors

    MaterialTheme(
        colorScheme = colors,
        typography = moviesAppTypography(),
        shapes = AppShapes,
        content = content
    )
}
