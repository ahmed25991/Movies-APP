package com.etisalattask.movies.feature.movies.presentation.components

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.itemsIndexed
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import com.etisalattask.movies.common.presentation.Screen
import com.etisalattask.movies.common.presentation.component.LoadingType
import com.etisalattask.movies.common.presentation.state.CommonUiState
import com.etisalattask.movies.feature.movies.presentation.MoviesViewModel
import dto.MovieModel
import dto.MoviesResponse

@SuppressLint("MutableCollectionMutableState")
@Composable
fun PaginatedMovieContent(
    navController: NavController,
    pageType: String,
    cardContent: @Composable (MovieModel, () -> Unit) -> Unit
) {
    val context = LocalContext.current
    val viewModel: MoviesViewModel = hiltViewModel()
    val moviesUiState by viewModel.moviesUiState.collectAsStateWithLifecycle()

    var allMovies by remember { mutableStateOf<List<MovieModel>>(emptyList()) }
    var isLoadingMore by remember { mutableStateOf(LoadingType.Initial) }
    var currentPage by remember { mutableIntStateOf(1) }
    var totalPages by remember { mutableIntStateOf(1) }

    // Reset the list when the pageType changes (user switches tabs)
    LaunchedEffect(pageType) {
        allMovies = emptyList() // Clear movies when switching tabs
        currentPage = 1 // Reset to first page
        viewModel.fetchMovies(currentPage = currentPage, pageType = pageType)
    }

    // Fetch additional pages when scrolling
    LaunchedEffect(currentPage) {
        viewModel.fetchMovies(currentPage = currentPage, pageType = pageType)
    }

    when (moviesUiState) {
        is CommonUiState.Content -> {
            val response = (moviesUiState as CommonUiState.Content).model as MoviesResponse
            totalPages = response.total_pages ?: 1

            // Ensure only unique movies are added to the list
            allMovies = (allMovies + (response.results ?: emptyList()))
                .distinctBy { it.id } // Prevent duplicate movies

            isLoadingMore = if (allMovies.isEmpty()) LoadingType.EmptyData else LoadingType.GotData
        }
        is CommonUiState.Fail -> {
            isLoadingMore = LoadingType.Error
            android.widget.Toast.makeText(
                context,
                (moviesUiState as CommonUiState.Fail).errorMessage,
                android.widget.Toast.LENGTH_SHORT
            ).show()
        }
        is CommonUiState.Loading -> {
            isLoadingMore = LoadingType.Loading
        }
        else -> Unit
    }


    Box(modifier = Modifier.fillMaxSize()) {
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            modifier = Modifier.fillMaxSize(),
            contentPadding = PaddingValues(16.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            itemsIndexed(allMovies) { index, movie ->
                cardContent(movie){
                    navController.navigate(Screen.MovieDetailsScreen.createRoute(movie.id))
                }
                if (index == allMovies.size - 1 &&
                    currentPage < totalPages &&
                    isLoadingMore == LoadingType.GotData
                ) {
                    currentPage++
                }
            }
        }

        if (allMovies.isEmpty() && isLoadingMore == LoadingType.EmptyData) {
            EmptyDataView()
        }
    }
}



@Composable
fun EmptyDataView() {
    Column(
        modifier = Modifier
            .padding(horizontal = 16.dp)
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "No movies available",
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.onBackground
        )
    }
}