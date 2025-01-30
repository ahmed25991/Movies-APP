package com.etisalattask.movies.common.presentation

sealed class Screen(val route: String) {
    data object SplashScreen : Screen("splash_screen")
}








