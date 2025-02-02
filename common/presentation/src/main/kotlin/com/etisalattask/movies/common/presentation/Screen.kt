package com.etisalattask.movies.common.presentation

sealed class Screen(val route: String) {
    data object AllMoviesScreen : Screen("all_movies_screen")

    data object MovieDetailsScreen : Screen("movie_details_screen/{movieId}"){
        fun createRoute(movieId: Int?) = "movie_details_screen/$movieId"
    }

}








