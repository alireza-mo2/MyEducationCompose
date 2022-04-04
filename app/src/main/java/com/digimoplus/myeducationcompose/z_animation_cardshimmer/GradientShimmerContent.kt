package com.digimoplus.myeducationcompose.z_animation_cardshimmer

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp


@Composable
fun GradientShimmerContent(
    colors: List<Color>,
    widthAnimate: Float,
    heightAnimate: Float,
    gradientWith: Float,
    modifier: Modifier,
    cardHeight: Dp
) {
    Surface(
        shape = MaterialTheme.shapes.small,
        modifier = modifier
    ) {
        Spacer(
            modifier = Modifier
                .fillMaxWidth()
                .height(cardHeight)
                .background(
                    brush = Brush.linearGradient(
                        colors = colors,
                        start = Offset(widthAnimate - gradientWith, heightAnimate - gradientWith),
                        end = Offset(widthAnimate, widthAnimate),
                    )
                )
        )
    }
}

















