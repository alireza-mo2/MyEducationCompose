package com.digimoplus.myeducationcompose.z_animation_cardshimmer


import androidx.compose.animation.core.*
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.*
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun GradientShimmerCard(
    modifier: Modifier,
    colors: List<Color>,
    cardHeight: Dp
) {
    val myTransition = rememberInfiniteTransition()
    BoxWithConstraints {

        var widthPx = LocalDensity.current.run { (maxWidth).toPx() }
        var heightPx = LocalDensity.current.run { cardHeight.toPx() }
        heightPx += if (cardHeight < maxWidth) widthPx - heightPx else heightPx - widthPx
        widthPx = heightPx


        val gradientWith: Float = heightPx * 0.11f

        // animate width
        val widthAnimate by myTransition.animateFloat(
            initialValue = 0f,
            targetValue = widthPx + gradientWith,
            animationSpec = infiniteRepeatable(
                tween(
                    delayMillis = 200,
                    durationMillis = 1500,
                    easing = LinearEasing
                ),
                repeatMode = RepeatMode.Restart
            )
        )

        // animate height
        val heightAnimate by myTransition.animateFloat(
            initialValue = 0f,
            targetValue = heightPx + gradientWith,
            animationSpec = infiniteRepeatable(
                tween(
                    delayMillis = 200,
                    durationMillis = 1500,
                    easing = LinearEasing
                ),
                repeatMode = RepeatMode.Restart
            )
        )

        // create content
        GradientShimmerContent(
            colors = colors,
            widthAnimate = widthAnimate,
            heightAnimate = heightAnimate,
            gradientWith = gradientWith,
            modifier = modifier,
            cardHeight
        )

    }
}