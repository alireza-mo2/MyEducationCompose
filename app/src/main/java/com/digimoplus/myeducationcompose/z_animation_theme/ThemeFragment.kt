package com.digimoplus.myeducationcompose.z_animation_theme

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.unit.dp
import androidx.fragment.app.Fragment

class ThemeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return ComposeView(requireContext()).apply {
            setContent {

                var isLightTheme by remember {
                    mutableStateOf(true)
                }
                val animatedColors = (
                        if (isLightTheme) ColorsThemeAnim(
                            Color.Green,
                            Color.Green,
                            Color.Green,
                            Color.Green,
                        ) else ColorsThemeAnim(
                            Color.Gray,
                            Color.Gray,
                            Color.Gray,
                            Color.Gray,
                        )).switch()

                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Text(text = "hi bro", color = animatedColors.baseColor)
                    Button(
                        onClick = { isLightTheme = !isLightTheme },
                        colors = ButtonDefaults.buttonColors(backgroundColor = animatedColors.darker)
                    ) {
                    }
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(250.dp)
                            .background(color = animatedColors.darker)
                    )
                }

            }
        }
    }

}