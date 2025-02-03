package com.etisalattask.movies.feature.movies.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import coil.compose.AsyncImage
import com.etisalattask.movies.common.presentation.component.BackToolBar
import com.etisalattask.movies.common.presentation.state.CommonUiState
import com.etisalattask.movies.common.presentation.ui.theme.BackgroundDark
import com.etisalattask.movies.common.presentation.ui.theme.HighlightBlue
import com.etisalattask.movies.common.presentation.ui.theme.OnBackgroundText
import com.etisalattask.movies.common.presentation.ui.theme.OnSecondaryText
import com.etisalattask.movies.common.presentation.ui.theme.PrimaryRed
import com.etisalattask.movies.common.presentation.ui.theme.moviesAppTypography
import com.etisalattask.movies.feature.movies.presentation.components.MovieDetailsShimmer
import dto.MovieDetailsResponse


@Composable
fun MovieDetailsRoute(navController: androidx.navigation.NavController, movieId:Int?) {
    Column(
        modifier = Modifier
            .verticalScroll(rememberScrollState())
            .fillMaxSize()
            .padding(vertical = 24.dp)
    ) {
        BackToolBar(pageTitle="Movie Details", onBackClick = { navController.popBackStack() })
        Spacer(Modifier.height(24.dp))
        FetchMovieDetails(movieId)
    }
}

@Composable
fun FetchMovieDetails(movieId: Int?) {
    val context = LocalContext.current
    val viewModel: MoviesViewModel = hiltViewModel()
    val movieDetailsUiState by viewModel.movieDetailsUiState.collectAsStateWithLifecycle()

    LaunchedEffect(movieId) {
        viewModel.fetchMovieDetails(movieId = movieId)
    }

    when (movieDetailsUiState) {
        is CommonUiState.Content -> {
            val response = (movieDetailsUiState as CommonUiState.Content).model as MovieDetailsResponse
            MovieDetailsContent(response)
        }
        is CommonUiState.Fail -> {
            android.widget.Toast.makeText(
                context,
                (movieDetailsUiState as CommonUiState.Fail).errorMessage,
                android.widget.Toast.LENGTH_SHORT
            ).show()
        }
        is CommonUiState.Loading -> {
            MovieDetailsShimmer()
        }
        else -> Unit
    }
}



@Composable
fun MovieDetailsContent(movie: MovieDetailsResponse) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .background(BackgroundDark)
    ) {
        AsyncImage(
            model = "https://image.tmdb.org/t/p/w500${movie.poster_path}",
            contentDescription = movie.title,
            contentScale = androidx.compose.ui.layout.ContentScale.FillBounds,
            modifier = Modifier
                .fillMaxWidth()
                .height(400.dp)
                .clip(RoundedCornerShape(12.dp))
        )
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = movie.title ?: "Unknown Title",
            style = moviesAppTypography().titleLarge,
            fontWeight = FontWeight.Bold,
            color = PrimaryRed,
            maxLines = 1,
            overflow = androidx.compose.ui.text.style.TextOverflow.Ellipsis
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = "Overview",
            style = moviesAppTypography().titleMedium,
            color = OnBackgroundText,
            fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier.height(4.dp))
        Text(
            text = movie.overview ?: "N/A",
            style = moviesAppTypography().bodyMedium,
            color = OnSecondaryText
        )
        Spacer(modifier = Modifier.height(12.dp))
        Text(
            text = "Genres: ${movie.genres?.joinToString { it.name ?: "N/A" }}",
            style = moviesAppTypography().bodyLarge,
            color = HighlightBlue
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = "Runtime: ${movie.runtime} minutes",
            style = moviesAppTypography().bodyLarge,
            color = OnSecondaryText
        )
        Spacer(modifier = Modifier.height(12.dp))
    }
}

















