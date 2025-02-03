package com.etisalattask.movies.common.presentation.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Text
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import com.etisilattask.movies.common.presentation.R


@androidx.compose.runtime.Composable
fun BackToolBar(
    modifier: Modifier = Modifier,
    pageTitle:String,
    onBackClick: () -> Unit){
    ConstraintLayout(
        modifier = modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .padding(start = 16.dp, end = 16.dp, top = 32.dp)
    ) {
        val (backBtn, mPageTitle) = createRefs()

        Image(
            painter = painterResource(id = R.drawable.ic_back_arrow),
            contentDescription = "back arrow",
            modifier = Modifier
                .wrapContentSize()
                .clickable { onBackClick() }
                .constrainAs(backBtn) {
                    top.linkTo(mPageTitle.top)
                    bottom.linkTo(mPageTitle.bottom)
                    start.linkTo(parent.start)
                }
        )


        Text(
            text = pageTitle,
            modifier = Modifier
                .wrapContentSize()
                .constrainAs(mPageTitle) {
                    top.linkTo(parent.top, margin = 32.dp)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                },
            color =  androidx.compose.material3.MaterialTheme.colorScheme.onBackground,
            style = androidx.compose.material3.MaterialTheme.typography.titleMedium
        )
    }
}