package com.etisalattask.movies.common.presentation.component

enum class LoadingType { Initial, Loading, GotData, Error, EmptyData }



//@Composable
//fun LottieView(
//    resId: Int,
//    modifier: Modifier = Modifier,
//    iterations: Int = Int.MAX_VALUE
//) {
//    val composition by rememberLottieComposition(LottieCompositionSpec.RawRes(resId))
//    LottieAnimation(
//        composition,
//        modifier = modifier.defaultMinSize(300.dp),
//        iterations = iterations
//    )
//}