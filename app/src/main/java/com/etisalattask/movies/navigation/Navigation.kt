package com.etisalattask.movies.navigation

import androidx.activity.compose.BackHandler
import androidx.activity.compose.LocalActivity
import androidx.compose.animation.core.tween
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.etisalattask.movies.common.presentation.Screen
import com.etisalattask.movies.common.presentation.Screen.AllMoviesScreen
import com.etisalattask.movies.feature.movies.presentation.AllMoviesRoute
import com.etisalattask.movies.feature.movies.presentation.MovieDetailsRoute

@Composable
fun AppNavigation() {
    val navController: NavHostController = rememberNavController()

    Box(modifier = Modifier.fillMaxSize()) {
        NavHost(
            navController = navController,
            startDestination = AllMoviesScreen.route,
            modifier = Modifier.background(Color.Transparent),
            enterTransition = { defaultEnterTransition() },
            exitTransition = { defaultExitTransition() },
            popEnterTransition = { defaultPopEnterTransition() },
            popExitTransition = { defaultPopExitTransition() }
        ) {
            composable(AllMoviesScreen.route) {
                HandleBackPress()
                AllMoviesRoute(navController)
            }

            composable(
                route = Screen.MovieDetailsScreen.route,
                arguments = listOf(navArgument("movieId") { type = NavType.IntType })
            ) { backStackEntry ->
                val movieId = backStackEntry.arguments?.getInt("movieId")
                MovieDetailsRoute(navController, movieId)
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
    val activity = LocalActivity.current
    BackHandler(enabled = true) { activity?.finish() }
}
