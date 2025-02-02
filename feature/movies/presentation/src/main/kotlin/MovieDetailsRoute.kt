package com.etisalattask.movies.feature.movies.presentation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController


@Composable
fun MovieDetailsRoute(navController: NavController,movieId:Int?) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp, vertical = 64.dp)
    ) {
        MovieDetailsContent(navController,movieId)
    }
}


@Composable
fun MovieDetailsContent(navController: NavController, movieId: Int?) {

}
















