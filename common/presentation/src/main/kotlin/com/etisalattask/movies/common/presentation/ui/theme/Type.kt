package com.etisilattask.movies.common.presentation.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import com.etisilattask.movies.common.presentation.R


val Lato = FontFamily(Font(R.font.lato_black))

val Poppins = FontFamily(
    Font(R.font.poppins_regular, FontWeight.Normal),
    Font(R.font.poppins_medium, FontWeight.Medium),
    Font(R.font.poppins_semibold, FontWeight.SemiBold),
    Font(R.font.poppins_bold, FontWeight.Bold)
)

val Typography = Typography()


@Composable
fun dpToSp(dp: Float): TextUnit {
    val density = LocalDensity.current
    return with(density) { dp.dp.toSp() }
}




object CustomTypography  {


    val HeadingNumH1 : TextStyle
        @Composable
        get() = TextStyle(
        fontFamily = Lato,
        fontWeight = FontWeight.Black,
        fontSize = dpToSp( 48f),
        letterSpacing = dpToSp(  (-1.44).toFloat()),
        lineHeight = dpToSp( 52.8f),
    )




    val HeadingH1 : TextStyle
        @Composable
        get() = TextStyle(
        fontFamily = Poppins,
        fontWeight = FontWeight.Bold,
        fontSize = dpToSp( 48f),
        letterSpacing = dpToSp( (-1.44).toFloat()),
        lineHeight = dpToSp( 52.8f)
    )


    val HeadingNumH2 : TextStyle
        @Composable
        get() = TextStyle(
        fontFamily = Lato,
        fontWeight = FontWeight.Black,
        fontSize = dpToSp( 40f),
        letterSpacing = dpToSp( (-1.2).toFloat()),
        lineHeight = dpToSp( 44f)
    )


    val HeadingH2 : TextStyle
        @Composable
        get() = TextStyle(
        fontFamily = Poppins,
        fontWeight = FontWeight.Bold,
        fontSize = dpToSp( 40f),
        letterSpacing = dpToSp( (-1.2).toFloat()),
        lineHeight = dpToSp( 44f)
    )


    val HeadingNumH3 : TextStyle
        @Composable
        get() = TextStyle(
        fontFamily = Lato,
        fontWeight = FontWeight.Black,
        fontSize = dpToSp( 32f),
        letterSpacing = dpToSp( (-0.64).toFloat()),
        lineHeight = dpToSp( 41.6f)
    )


    val HeadingH3 : TextStyle
        @Composable
        get() = TextStyle(
        fontFamily = Poppins,
        fontWeight = FontWeight.Bold,
        fontSize = dpToSp( 24f),
        letterSpacing = dpToSp( (-0.64).toFloat()),
        lineHeight = dpToSp( 41.6f)
    )


    val HeadingNumH4 : TextStyle
        @Composable
        get() = TextStyle(
        fontFamily = Lato,
        fontWeight = FontWeight.Black,
        fontSize = dpToSp( 24f),
        letterSpacing = dpToSp( (-0.48).toFloat()),
        lineHeight = dpToSp( 31.2f)
    )


    val HeadingH4 : TextStyle
        @Composable
        get() = TextStyle(
        fontFamily = Poppins,
        fontWeight = FontWeight.Bold,
        fontSize = dpToSp( 24f),
        letterSpacing = dpToSp( (-0.48).toFloat()),
        lineHeight = dpToSp( 31.2f)
    )


    val HeadingNumH5 : TextStyle
        @Composable
        get() = TextStyle(
        fontFamily = Lato,
        fontWeight = FontWeight.Black,
        fontSize = dpToSp( 20f),
        letterSpacing = dpToSp( (-0.4).toFloat()),
        lineHeight = dpToSp( 24f)
    )

    val HeadingH5 : TextStyle
        @Composable
        get() = TextStyle(
        fontFamily = Poppins,
        fontWeight = FontWeight.Bold,
        fontSize = dpToSp( 20f),
        letterSpacing = dpToSp( (-0.4).toFloat()),
        lineHeight = dpToSp( 24f)
    )


    val HeadingNumH6 : TextStyle
        @Composable
        get() = TextStyle(
        fontFamily = Lato,
        fontWeight = FontWeight.Black,
        fontSize = dpToSp( 18f),
        letterSpacing = dpToSp( (-0.36).toFloat()),
        lineHeight = dpToSp( 21.6f)
    )


    val HeadingH6 : TextStyle
        @Composable
        get() = TextStyle(
        fontFamily = Poppins,
        fontWeight = FontWeight.Bold,
        fontSize = dpToSp( 18f),
        letterSpacing = dpToSp( (-0.36).toFloat()),
        lineHeight = dpToSp( 21.6f)
    )


    val HeadingNumH7 : TextStyle
        @Composable
        get() = TextStyle(
        fontFamily = Lato,
        fontWeight = FontWeight.Black,
        fontSize = dpToSp( 16f),
        letterSpacing = dpToSp( (-0.32).toFloat()),
        lineHeight = dpToSp( 19.2f)
    )


    val HeadingH7 : TextStyle
        @Composable
        get() = TextStyle(
        fontFamily = Poppins,
        fontWeight = FontWeight.Bold,
        fontSize = dpToSp( 16f),
        letterSpacing = dpToSp( (-0.32).toFloat()),
        lineHeight = dpToSp( 19.2f)
    )


    val BodyXLargeBold : TextStyle
        @Composable
        get() = TextStyle(
        fontFamily = Poppins,
        fontWeight = FontWeight.Bold,
        fontSize = dpToSp( 18f),
        letterSpacing = dpToSp( 0.3f),
        lineHeight = dpToSp( 25.2f)
    )


    val BodyXLargeSemiBold : TextStyle
        @Composable
        get() = TextStyle(
        fontFamily = Poppins,
        fontWeight = FontWeight.SemiBold,
        fontSize = dpToSp( 18f),
        letterSpacing = dpToSp( 0.2f),
        lineHeight = dpToSp( 27f)
    )


    val BodyXLargeMedium : TextStyle
        @Composable
        get() = TextStyle(
        fontFamily = Poppins,
        fontWeight = FontWeight.Medium,
        fontSize = dpToSp( 18f),
        letterSpacing = dpToSp( 0.2f),
        lineHeight = dpToSp( 25.2f)
    )


    val BodyXLargeRegular : TextStyle
        @Composable
        get() = TextStyle(
        fontFamily = Poppins,
        fontWeight = FontWeight.Normal,
        fontSize = dpToSp( 18f),
        letterSpacing = dpToSp( 0.2f),
        lineHeight = dpToSp( 25.2f)
    )


    val BodyLargeBold : TextStyle
        @Composable
        get() = TextStyle(
        fontFamily = Poppins,
        fontWeight = FontWeight.Bold,
        fontSize = dpToSp( 16f),
        letterSpacing = dpToSp( 0.2f),
        lineHeight = dpToSp( 22.4f)
    )


    val BodyLargeSemiBold : TextStyle
        @Composable
        get() = TextStyle(
        fontFamily = Poppins,
        fontWeight = FontWeight.SemiBold,
        fontSize = dpToSp( 12f),
        letterSpacing = dpToSp( 0.1f),
        lineHeight = dpToSp( 24f)
    )


    val BodyLargeMedium : TextStyle
        @Composable
        get() = TextStyle(
        fontFamily = Poppins,
        fontWeight = FontWeight.Medium,
        fontSize = dpToSp( 16f),
        letterSpacing = dpToSp( 0.1f),
        lineHeight = dpToSp( 22.4f)
    )


    val BodyLargeRegular : TextStyle
        @Composable
        get() = TextStyle(
        fontFamily = Poppins,
        fontWeight = FontWeight.Normal,
        fontSize = dpToSp( 12f),
        letterSpacing = dpToSp( 0.1f),
        lineHeight = dpToSp( 24f)
    )


    val BodyMediumBold : TextStyle
        @Composable
        get() = TextStyle(
        fontFamily = Poppins,
        fontWeight = FontWeight.Bold,
        fontSize = dpToSp( 14f),
        letterSpacing = dpToSp( 0.2f),
        lineHeight = dpToSp( 19.6f)
    )


    val BodyMediumSemiBold : TextStyle
        @Composable
        get() = TextStyle(
        fontFamily = Poppins,
        fontWeight = FontWeight.SemiBold,
        fontSize = dpToSp( 14f),
        letterSpacing = dpToSp( 0.2f),
        lineHeight = dpToSp( 19.6f)
    )


    val BodyMedium : TextStyle
        @Composable
        get() = TextStyle(
        fontFamily = Poppins,
        fontWeight = FontWeight.Medium,
        fontSize = dpToSp( 14f),
        letterSpacing = dpToSp( 0.2f),
        lineHeight = dpToSp( 19.6f)
    )

    val BodyMediumRegular : TextStyle
        @Composable
        get() = TextStyle(
        fontFamily = Poppins,
        fontWeight = FontWeight.Normal,
        fontSize = dpToSp( 14f),
        letterSpacing = dpToSp( 0.2f),
        lineHeight = dpToSp( 19.6f)
    )


    val BodySmallBold : TextStyle
        @Composable
        get() = TextStyle(
        fontFamily = Poppins,
        fontWeight = FontWeight.Bold,
        fontSize = dpToSp( 12f),
        letterSpacing = dpToSp( 0.2f)
    )

    val BodySmallSemiBold : TextStyle
        @Composable
        get() = TextStyle(
        fontFamily = Poppins,
        fontWeight = FontWeight.SemiBold,
        fontSize = dpToSp( 12f),
        letterSpacing = dpToSp( 0.2f)
    )


    val BodySmallMedium : TextStyle
        @Composable
        get() = TextStyle(
        fontFamily = Poppins,
        fontWeight = FontWeight.Medium,
        fontSize = dpToSp( 12f),
        letterSpacing = dpToSp( 0.2f)
    )


    val BodySmallRegular : TextStyle
        @Composable
        get() = TextStyle(
        fontFamily = Poppins,
        fontWeight = FontWeight.Normal,
        fontSize = dpToSp( 12f),
        letterSpacing = dpToSp( 0.2f)
    )


    val BodyXSmallBold : TextStyle
        @Composable
        get() = TextStyle(
        fontFamily = Poppins,
        fontWeight = FontWeight.Bold,
        fontSize = dpToSp( 10f),
        letterSpacing = dpToSp( 0.2f)
    )


    val BodyXSmallSemiBold : TextStyle
        @Composable
        get() = TextStyle(
        fontFamily = Poppins,
        fontWeight = FontWeight.SemiBold,
        fontSize = dpToSp( 10f),
        letterSpacing = dpToSp( 0.2f)
    )


    val BodyXSmallMedium : TextStyle
        @Composable
        get() = TextStyle(
        fontFamily = Poppins,
        fontWeight = FontWeight.Medium,
        fontSize = dpToSp( 10f),
        letterSpacing = dpToSp( 0.2f)
    )


    val BodyXSmallRegular : TextStyle
        @Composable
        get() = TextStyle(
        fontFamily = Poppins,
        fontWeight = FontWeight.Normal,
        fontSize = dpToSp( 10f),
        letterSpacing = dpToSp( 0.2f),
        lineHeight = dpToSp( 15f)
    )
}
