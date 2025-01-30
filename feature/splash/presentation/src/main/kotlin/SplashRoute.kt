package com.etisilattask.movies.feature.splash.presentation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.navigation.NavController


@Composable
fun SplashRoute(navController: NavController) { SplashScreenWithUI(navController) }

@Composable
internal fun SplashScreenWithUI(navController: NavController) {
    val context = LocalContext.current
    ConstraintLayout(modifier = Modifier.fillMaxSize()) {
        val (splashImgRef, loadingBarRef) = createRefs()

    }
}





