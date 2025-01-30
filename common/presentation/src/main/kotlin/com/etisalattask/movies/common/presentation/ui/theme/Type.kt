package com.etisalattask.movies.common.presentation.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.sp
import com.etisilattask.movies.common.presentation.R

@Composable
fun adaptiveFont(defaultSize: Float): Float {
    return with(LocalDensity.current) { defaultSize / fontScale }
}

val Poppins = FontFamily(
    Font(R.font.poppins_regular),
    Font(R.font.poppins_medium),
    Font(R.font.poppins_bold),
    Font(R.font.poppins_semibold)
)

@Composable
fun moviesAppTypography(): Typography {
    return Typography(
        titleLarge = TextStyle(
            fontFamily = Poppins,
            fontSize = adaptiveFont(22f).sp, // Adaptive
        ),
        titleMedium = TextStyle(
            fontFamily = Poppins,
            fontSize = adaptiveFont(18f).sp,
        ),
        bodyLarge = TextStyle(
            fontFamily = Poppins,
            fontSize = adaptiveFont(16f).sp,
        ),
        bodyMedium = TextStyle(
            fontFamily = Poppins,
            fontSize = adaptiveFont(14f).sp,
        ),
        labelSmall = TextStyle(
            fontFamily = Poppins,
            fontSize = adaptiveFont(12f).sp,
        )
    )
}
