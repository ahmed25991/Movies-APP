package com.etisalattask.movies.networkcheckers

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.etisalattask.movies.common.presentation.ui.theme.Dimensions
import com.etisilattask.movies.common.presentation.R

@Composable
fun NoInternetConnectionRoute(
    onRetry: () -> Unit = {}
) {
    val scrollState = rememberScrollState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = Dimensions.MediumPadding)
            .verticalScroll(scrollState),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_no_internet),
            contentDescription = "No Internet",
            modifier = Modifier
                .size(80.dp)
                .padding(top = Dimensions.MediumPadding)
        )

        Text(
            text = "No Internet Connection",
            modifier = Modifier.padding(top = Dimensions.MediumPadding),
            color = MaterialTheme.colorScheme.onBackground,
            style = MaterialTheme.typography.titleLarge,
            textAlign = TextAlign.Center
        )

        Text(
            text = "Make sure you're connected to the internet\nand try again.",
            modifier = Modifier.padding(top = Dimensions.SmallPadding),
            color = MaterialTheme.colorScheme.onSecondary,
            style = MaterialTheme.typography.bodyMedium,
            textAlign = TextAlign.Center
        )

        Button(
            onClick = onRetry,
            modifier = Modifier
                .fillMaxWidth(0.7f)
                .padding(top = Dimensions.LargePadding)
        ) {
            Text("Retry",
                color = MaterialTheme.colorScheme.onPrimary,
                style = MaterialTheme.typography.bodyLarge,
                textAlign = TextAlign.Center
                )
        }
    }
}
