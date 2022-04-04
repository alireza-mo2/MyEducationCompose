package com.digimoplus.myeducationcompose.presentation.theme

import android.text.BoringLayout
import android.util.Log
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.AnimationSpec
import androidx.compose.animation.core.tween
import androidx.compose.material.Colors
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.ui.graphics.Color
import com.digimoplus.myeducationcompose.util.TAG

@Stable
data class ColorsAppThemeAnim(
    val primary: Color,
    val primaryVariant: Color,
    val onPrimary: Color,
    val secondary: Color,
    val secondaryVariant: Color,
    val onSecondary: Color,
    val error: Color,
    val onError: Color,
    val background: Color,
    val onBackground: Color,
    val surface: Color,
    val onSurface: Color,
) {
    private val animateSpec: AnimationSpec<Color> = tween(durationMillis = 1000)

    @Composable
    private fun animateColor(
        targetValue: Color,
        finishedListener: ((Color) -> Unit)? = null
    ) = animateColorAsState(targetValue = targetValue, animationSpec = animateSpec).value

    @Composable
    fun switch(): Colors = Colors(
        background = animateColor(background),
        secondaryVariant = animateColor(secondaryVariant),
        surface = animateColor(surface),
        secondary = animateColor(secondary),
        primaryVariant = animateColor(primaryVariant),
        primary = animateColor(primary),
        error = animateColor(error),
        onBackground = animateColor(onBackground),
        onError = animateColor(onError),
        onPrimary = animateColor(onPrimary),
        onSecondary = animateColor(onSecondary),
        onSurface = animateColor(onSurface),
        isLight = false
        //etc
    )
}


/*
@Stable
data class ColorsAppThemeAnim(
    val primary: Color = Blue600,
    val primaryVariant: Color = Blue400,
    val onPrimary: Color = Black2,
    val secondary: Color = Color.White,
    val secondaryVariant: Color = Teal300,
    val onSecondary: Color = Black2,
    val error: Color = RedErrorDark,
    val onError: Color = RedErrorLight,
    val background: Color = Grey1,
    val onBackground: Color = Color.Black,
    val surface: Color = Color.White,
    val onSurface: Color = Black2,
) {
    private val animateSpec: AnimationSpec<Color> = tween(durationMillis = 5000)

    private val lightThemeColors = lightColors(

    )

    private val darkThemeColors = darkColors(
        primary = Blue700,
        primaryVariant = Color.White,
        onPrimary = Color.White,
        secondary = Black1,
        onSecondary = Color.White,
        error = RedErrorLight,
        background = Color.Black,
        onBackground = Color.White,
        surface = Black1,
        onSurface = Color.White,
    )

    @Composable
    private fun animateColor(
        targetValue: Color,
        //finishedListener: ((Color) -> Unit)? = null
    ) = animateColorAsState(targetValue = targetValue, animationSpec = animateSpec).value


    @Composable
    fun switch() = copy(
        background = animateColor(background),

        //etc
    )
}
*/
