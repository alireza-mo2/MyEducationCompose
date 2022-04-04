package com.digimoplus.myeducationcompose.presentation.theme

import androidx.compose.material.Colors
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color


@Composable
fun AppTheme(
    darkTheme: Boolean = false,
    content: @Composable () -> Unit,
) {
    val animatedColors = (
            if (darkTheme) ColorsAppThemeAnim(
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
                onError = Color.Gray,
                secondaryVariant = Color.DarkGray
            ) else ColorsAppThemeAnim(
                primary = Blue600,
                primaryVariant = Blue400,
                onPrimary = Black2,
                secondary = Color.White,
                secondaryVariant = Teal300,
                onSecondary = Black2,
                error = RedErrorDark,
                onError = RedErrorLight,
                background = Grey1,
                onBackground = Color.Black,
                surface = Color.White,
                onSurface = Black2,
            )).switch()


    MaterialTheme(
        colors = animatedColors
    ) {
        content()
    }
}