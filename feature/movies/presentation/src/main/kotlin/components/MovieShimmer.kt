package com.etisalattask.movies.feature.movies.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.etisalattask.movies.common.presentation.ui.theme.BackgroundDark
import com.google.accompanist.placeholder.material3.placeholder

@Composable
fun MovieDetailsShimmer() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .background(BackgroundDark)
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(400.dp)
                .clip(RoundedCornerShape(12.dp))
                .placeholder(visible = true, color = Color.Gray)
        )

        Spacer(modifier = Modifier.height(16.dp))
        Box(
            modifier = Modifier
                .fillMaxWidth(0.6f)
                .height(24.dp)
                .placeholder(visible = true, color = Color.Gray)
        )

        Spacer(modifier = Modifier.height(8.dp))
        Box(
            modifier = Modifier
                .fillMaxWidth(0.3f)
                .height(20.dp)
                .placeholder(visible = true, color = Color.Gray)
        )

        Spacer(modifier = Modifier.height(4.dp))
        repeat(3) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(16.dp)
                    .placeholder(visible = true, color = Color.Gray)
            )
            Spacer(modifier = Modifier.height(4.dp))
        }

        Spacer(modifier = Modifier.height(12.dp))
        Box(
            modifier = Modifier
                .fillMaxWidth(0.5f)
                .height(18.dp)
                .placeholder(visible = true, color = Color.Gray)
        )

        Spacer(modifier = Modifier.height(8.dp))
        Box(
            modifier = Modifier
                .fillMaxWidth(0.3f)
                .height(18.dp)
                .placeholder(visible = true, color = Color.Gray)
        )

        Spacer(modifier = Modifier.height(12.dp))
    }
}




@Composable
fun MovieCardShimmer() {
    Card(
        shape = RoundedCornerShape(12.dp),
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
    ) {
        Column(
            modifier = Modifier.background(Color.DarkGray)
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
                    .placeholder(visible = true, color = Color.Gray)
            )
            Spacer(modifier = Modifier.height(8.dp))
            Box(
                modifier = Modifier
                    .fillMaxWidth(0.6f)
                    .height(20.dp)
                    .padding(horizontal = 12.dp)
                    .placeholder(visible = true, color = Color.Gray)
            )
            Spacer(modifier = Modifier.height(4.dp))
            Box(
                modifier = Modifier
                    .fillMaxWidth(0.4f)
                    .height(16.dp)
                    .padding(horizontal = 12.dp)
                    .placeholder(visible = true, color = Color.Gray)
            )
            Spacer(modifier = Modifier.height(12.dp))
        }
    }
}

