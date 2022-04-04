package com.digimoplus.myeducationcompose.z_animation_theme

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.AnimationSpec
import androidx.compose.animation.core.tween
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.ui.graphics.Color

@Stable
data class ColorsThemeAnim(
    val background: Color,
    val baseColor: Color,
    val lighter: Color,
    val darker: Color,
    // more colors
) {
    private val animateSpec: AnimationSpec<Color> = tween(durationMillis = 1500)

    @Composable
    private fun animateColor(
        targetValue: Color,
        //finishedListener: ((Color) -> Unit)? = null
    ) = animateColorAsState(targetValue = targetValue, animationSpec = animateSpec).value

    @Composable
    fun switch() = copy(
        background = animateColor(background),
        lighter = animateColor(lighter),
        darker = animateColor(darker),
        baseColor = animateColor(baseColor),
        // more colors
    )
}