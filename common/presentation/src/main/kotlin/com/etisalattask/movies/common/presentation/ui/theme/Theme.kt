package com.etisalattask.movies.common.presentation.ui.theme

import android.app.Activity
import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat

private val DarkColorScheme = darkColorScheme(
    primary = GreenLuminance500,
    onPrimary = WhiteLuminance50,
    primaryContainer = GreenLuminance700,
    onPrimaryContainer = GreenLuminance100,
    secondary = PurpleLuminance500,
    onSecondary = WhiteLuminance50,
    secondaryContainer = PurpleLuminance700,
    onSecondaryContainer = PurpleLuminance100,
    tertiary = PinkLuminance500,
    onTertiary = WhiteLuminance50,
    tertiaryContainer = PinkLuminance700,
    onTertiaryContainer = PinkLuminance100,
    background = BlackLightness500,
    onBackground = WhiteLuminance100,
    surface = GreyLuminance900,
    onSurface = WhiteLuminance50,
    surfaceVariant = GreyLuminance800,
    onSurfaceVariant = WhiteLuminance100,
    error = RedLuminance500,
    onError = WhiteLuminance50,
    outline = GreyLuminance600
)

private val LightColorScheme = lightColorScheme(
    primary = GreenLuminance400,
    onPrimary = BlackLightness500,
    primaryContainer = GreenLuminance100,
    onPrimaryContainer = GreenLuminance900,
    secondary = PurpleLuminance400,
    onSecondary = BlackLightness500,
    secondaryContainer = PurpleLuminance100,
    onSecondaryContainer = PurpleLuminance900,
    tertiary = PinkLuminance400,
    onTertiary = BlackLightness500,
    tertiaryContainer = PinkLuminance100,
    onTertiaryContainer = PinkLuminance900,
    background = WhiteLuminance50,
    onBackground = GreyLuminance900,
    surface = GreyLuminance100,
    onSurface = GreyLuminance800,
    surfaceVariant = GreyLuminance200,
    onSurfaceVariant = GreyLuminance800,
    error = RedLuminance400,
    onError = RedLuminance900,
    outline = GreyLuminance400
)

data class CustomColorScheme(
    val black: List<Color>,
    val white: List<Color>,
    val grey: List<Color>,
    val purple: List<Color>,
    val red: List<Color>,
    val pink: List<Color>,
    val green: List<Color>,
)

val LightCustomColorScheme = CustomColorScheme(
    black = listOf(BlackLightness50, BlackLightness100, BlackLightness200, BlackLightness300, BlackLightness400, BlackLightness500),
    white = listOf(WhiteLightness50, WhiteLightness100, WhiteLightness200, WhiteLightness300, WhiteLightness400, WhiteLightness500, WhiteLightness600),
    grey = listOf(GreyLightness50, GreyLightness100, GreyLightness200, GreyLightness300, GreyLightness400, GreyLightness500, GreyLightness600, GreyLightness700, GreyLightness800, GreyLightness900, GreyLightness950),
    purple = listOf(PurpleLightness50, PurpleLightness100, PurpleLightness200, PurpleLightness300, PurpleLightness400, PurpleLightness500, PurpleLightness600, PurpleLightness700, PurpleLightness800, PurpleLightness900, PurpleLightness950),
    red = listOf(RedLightness50, RedLightness100, RedLightness200, RedLightness300, RedLightness400, RedLightness500, RedLightness600, RedLightness700, RedLightness800, RedLightness900, RedLightness950),
    pink = listOf(PinkLightness50, PinkLightness100, PinkLightness200, PinkLightness300, PinkLightness400, PinkLightness500, PinkLightness600, PinkLightness700, PinkLightness800, PinkLightness900, PinkLightness950),
    green = listOf(GreenLightness50, GreenLightness100, GreenLightness200, GreenLightness300, GreenLightness400, GreenLightness500, GreenLightness600, GreenLightness700, GreenLightness800, GreenLightness900, GreenLightness950)
)

val DarkCustomColorScheme = CustomColorScheme(
    black = listOf(BlackLuminance50, BlackLuminance100, BlackLuminance200, BlackLuminance300, BlackLuminance400, BlackLuminance500),
    white = listOf(WhiteLuminance50, WhiteLuminance100, WhiteLuminance200, WhiteLuminance300, WhiteLuminance400, WhiteLuminance500),
    grey = listOf(GreyLuminance50, GreyLuminance100, GreyLuminance200, GreyLuminance300, GreyLuminance400, GreyLuminance500, GreyLuminance600, GreyLuminance700, GreyLuminance800, GreyLuminance900, GreyLuminance950),
    purple = listOf(PurpleLuminance50, PurpleLuminance100, PurpleLuminance200, PurpleLuminance300, PurpleLuminance400, PurpleLuminance500, PurpleLuminance600, PurpleLuminance700, PurpleLuminance800, PurpleLuminance900, PurpleLuminance950),
    red = listOf(RedLuminance50, RedLuminance100, RedLuminance200, RedLuminance300, RedLuminance400, RedLuminance500, RedLuminance600, RedLuminance700, RedLuminance800, RedLuminance900, RedLuminance950),
    pink = listOf(PinkLuminance50, PinkLuminance100, PinkLuminance200, PinkLuminance300, PinkLuminance400, PinkLuminance500, PinkLuminance600, PinkLuminance700, PinkLuminance800, PinkLuminance900, PinkLuminance950),
    green = listOf(GreenLuminance50, GreenLuminance100, GreenLuminance200, GreenLuminance300, GreenLuminance400, GreenLuminance500, GreenLuminance600, GreenLuminance700, GreenLuminance800, GreenLuminance900, GreenLuminance950),
)


@Composable
fun DTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    dynamicColor: Boolean = true,
    content: @Composable (CustomColorScheme) -> Unit
) {
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }
        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }

    val customColorScheme = if (darkTheme) DarkCustomColorScheme else LightCustomColorScheme

    val view = LocalView.current
    if (!view.isInEditMode) {
        SideEffect {
            val window = (view.context as Activity).window
            WindowCompat.setDecorFitsSystemWindows(window, false)
            val insetsController = WindowCompat.getInsetsController(window, view)
            insetsController.isAppearanceLightStatusBars = !darkTheme
            insetsController.isAppearanceLightNavigationBars = !darkTheme
        }
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = { content(customColorScheme) }
    )
}
