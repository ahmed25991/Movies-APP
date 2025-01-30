package com.etisalattask.movies.navigation

import androidx.activity.ComponentActivity
import androidx.activity.compose.BackHandler
import androidx.compose.animation.core.tween
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.etisalattask.movies.common.presentation.Screen
import com.etisilattask.movies.feature.splash.presentation.SplashRoute

@Composable
fun AppNavigation() {
    val navController: NavHostController = rememberNavController()

    Box(modifier = Modifier.fillMaxSize()) {
        NavHost(
            navController = navController,
            startDestination = Screen.SplashScreen.route,
            modifier = Modifier.background(Color.Transparent),
            enterTransition = { defaultEnterTransition() },
            exitTransition = { defaultExitTransition() },
            popEnterTransition = { defaultPopEnterTransition() },
            popExitTransition = { defaultPopExitTransition() }
        ) {
            composable(Screen.SplashScreen.route) {
                HandleBackPress()
                SplashRoute(navController)
            }
        }
    }
}


private fun defaultEnterTransition() = slideInHorizontally(
    initialOffsetX = { it },
    animationSpec = tween(700)
)

private fun defaultExitTransition() = slideOutHorizontally(
    targetOffsetX = { -it },
    animationSpec = tween(700)
)

private fun defaultPopEnterTransition() = slideInHorizontally(
    initialOffsetX = { -it },
    animationSpec = tween(700)
)

private fun defaultPopExitTransition() = slideOutHorizontally(
    targetOffsetX = { it },
    animationSpec = tween(700)
)


@Composable
private fun HandleBackPress() {
    val activity = LocalContext.current as ComponentActivity
    BackHandler(enabled = true) { activity.finish() }
}
