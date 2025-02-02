package com.etisalattask.movies.feature.movies.presentation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.etisalattask.movies.feature.movies.presentation.components.MovieCard
import com.etisalattask.movies.feature.movies.presentation.components.MovieTabs
import com.etisalattask.movies.feature.movies.presentation.components.PaginatedMovieContent


@Composable
fun AllMoviesRoute(navController: NavController) {
    val tabs = listOf("Now Playing", "Popular", "Upcoming")
    var selectedTab by remember { mutableIntStateOf(0) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp, vertical = 64.dp)
    ) {
        MovieTabs(tabs, selectedTab) { index -> selectedTab = index }
        MoviesContent(navController, tabs[selectedTab].lowercase().replace(" ", "_"))
    }
}


@Composable
fun MoviesContent(navController: NavController, pageType: String) {
    PaginatedMovieContent(navController, pageType) { movie, onViewDetails ->
        MovieCard(movie, onViewDetails)
    }
}
















