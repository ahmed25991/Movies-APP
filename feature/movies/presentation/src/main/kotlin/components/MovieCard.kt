package com.etisalattask.movies.feature.movies.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.etisalattask.movies.common.presentation.utils.formatDateString
import dto.MovieModel

@Composable
fun MovieCard(movie: MovieModel, onViewDetails: () -> Unit) {
    Card(
        shape = androidx.compose.foundation.shape.RoundedCornerShape(12.dp),
        elevation = androidx.compose.material3.CardDefaults.cardElevation(defaultElevation = 6.dp),
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onViewDetails() }
    ) {
        Column(
            modifier = Modifier
                .background(MaterialTheme.colorScheme.surface)
        ) {
            AsyncImage(
                model = "https://image.tmdb.org/t/p/w500${movie.poster_path}",
                contentDescription = movie.title,
                contentScale = androidx.compose.ui.layout.ContentScale.FillBounds,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
                    .clip(androidx.compose.foundation.shape.RoundedCornerShape(12.dp))
            )
            Column(modifier = Modifier.padding(12.dp)) {
                Text(
                    text = movie.title ?: "Unknown Title",
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = androidx.compose.ui.text.font.FontWeight.Bold,
                    maxLines = 1,
                    overflow = androidx.compose.ui.text.style.TextOverflow.Ellipsis
                )
                Text(
                    text = "Release Date: ${formatDateString(movie.release_date)}",
                    style = MaterialTheme.typography.bodyMedium,
                    color = Color.Gray
                )
            }
        }
    }
}