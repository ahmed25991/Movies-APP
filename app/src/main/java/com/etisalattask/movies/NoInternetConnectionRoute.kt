package com.etisalattask.movies

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout

@Composable
fun NoInternetConnectionRoute() {
    val scrollState = rememberScrollState()

    ConstraintLayout(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp)
            .verticalScroll(scrollState)
    ) {
        val (imageView, title, subtitle, button) = createRefs()


        Text(
            text = "No Internet Connection",
            modifier = Modifier.constrainAs(title) {
                top.linkTo(parent.top, margin = 48.dp)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
            },
            textAlign = androidx.compose.ui.text.style.TextAlign.Center

        )

        Text(
            text = "Make Sure you connected to internet\nand try again",
            modifier = Modifier.constrainAs(subtitle) {
                top.linkTo(title.bottom, margin = 12.dp)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
            },
            textAlign = androidx.compose.ui.text.style.TextAlign.Center
        )




    }
}