package com.digimoplus.myeducationcompose.uz

import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.digimoplus.myeducationcompose.uz.ui.purple500
import kotlinx.coroutines.launch

@Composable
fun ButtonContent(
    textColor: Color,
    timeState: MutableState<Boolean>,
    iconAlpha: Float,
    iconAnim: Dp
) {


    if (timeState.value) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Column(Modifier.width(24.dp), horizontalAlignment = Alignment.CenterHorizontally) {
                Icon(
                    tint = textColor,
                    imageVector = Icons.Default.FavoriteBorder,
                    modifier = Modifier.size(iconAnim),
                    contentDescription = "",
                )
            }
            Spacer(modifier = Modifier.width(16.dp))
            Text(
                "ADD TO FAVORITES!",
                softWrap = false,
                color = textColor
            )
        }
    } else {
        Icon(
            tint = textColor.copy(alpha = iconAlpha),
            imageVector = Icons.Default.Favorite,
            modifier = Modifier.size(iconAnim),
            contentDescription = ""
        )
    }
}

