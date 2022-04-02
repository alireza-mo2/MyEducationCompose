package com.digimoplus.myeducationcompose.z_animation_button

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.ui.tooling.preview.Preview
import com.digimoplus.myeducationcompose.z_animation_button.ui.FavenimateTheme

@Preview
@Composable
fun MainContent() {
    FavenimateTheme {
        Surface(color = Color.White) {
            Column(
                Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                AnimatedFavButton()

            }
        }
    }
}