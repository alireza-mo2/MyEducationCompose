package com.digimoplus.myeducationcompose.z_animation_button

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.*
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Composable
fun FavButton() {

    val coroutineScope = rememberCoroutineScope()
    val itemState = remember { mutableStateOf(ButtonState.IsOpen) }
    val timeState = remember { mutableStateOf(true) }

    val sizeWith by animateDpAsState(
        targetValue = itemState.value.state[0].value as Dp,
        animationSpec = tween(
            delayMillis = 200,
            durationMillis = 1500,
            easing = FastOutLinearInEasing
        )
    )

    val cornerRadius by animateDpAsState(
        targetValue = itemState.value.state[1].value as Dp,
        animationSpec = tween(
            delayMillis = 200,
            durationMillis = 1500,
            easing = FastOutLinearInEasing
        )
    )

    val textColor by animateColorAsState(
        targetValue = itemState.value.state[2].value as Color,
        animationSpec = tween(
            delayMillis = 200,
            durationMillis = 1500,
            easing = FastOutLinearInEasing
        )
    )

    val backColor by animateColorAsState(
        targetValue = itemState.value.state[3].value as Color,
        animationSpec = tween(
            delayMillis = 200,
            durationMillis = 1500,
            easing = FastOutLinearInEasing
        )
    )

    val iconAlpha by animateFloatAsState(
        targetValue = itemState.value.state[4].value as Float,
        animationSpec = tween(
            delayMillis = 0,
            durationMillis = 800,
            easing = FastOutLinearInEasing
        )
    )

    val myTransition = rememberInfiniteTransition()

    val iconAnim by myTransition.animateValue(
        initialValue = 24.dp,
        targetValue = 12.dp,
        typeConverter = Dp.VectorConverter,
        animationSpec = infiniteRepeatable(
            keyframes {
                delayMillis = 1300
                durationMillis = 1000
                24.dp at 400
                12.dp at 500
                24.dp at 600
                12.dp at 700
            },
            repeatMode = RepeatMode.Restart
        )
    )





    Button(
        colors = ButtonDefaults.buttonColors(backgroundColor = backColor),
        border = BorderStroke(1.dp, Color.Blue),
        shape = RoundedCornerShape(cornerRadius),
        modifier = Modifier.size(sizeWith, 60.dp),
        onClick = {
            if (itemState.value == ButtonState.IsOpen) {
                itemState.value = ButtonState.IsClose
                coroutineScope.launch {
                    delay(1400)
                    timeState.value = false
                }
            } else {
                itemState.value = ButtonState.IsOpen
                coroutineScope.launch {
                    delay(200)
                    timeState.value = true
                }
            }
        }
    ) {
        ButtonContent(
            textColor,
            timeState,
            iconAlpha,
            iconAnim
        )
    }

}

enum class ButtonValue(val value: Any) {
    SizeOpen(300.dp),
    SizeClose(60.dp),
    CornerOpen(12.dp),
    CornerClose(40.dp),
    TextColorOpen(Color.Blue),
    TextColorClose(Color.White),
    BackColorOpen(Color.White),
    BackColorClose(Color.Blue),
    IconAlphaOpen(0f),
    IconAlphaClose(1f)
}

enum class ButtonState(val state: List<ButtonValue>) {
    IsOpen(
        listOf(
            ButtonValue.SizeOpen,
            ButtonValue.CornerOpen,
            ButtonValue.TextColorOpen,
            ButtonValue.BackColorOpen,
            ButtonValue.IconAlphaOpen,
        )
    ),
    IsClose(
        listOf(
            ButtonValue.SizeClose,
            ButtonValue.CornerClose,
            ButtonValue.TextColorClose,
            ButtonValue.BackColorClose,
            ButtonValue.IconAlphaClose,
        )
    )
}


/*
package com.digimoplus.myeducationcompose.uz

import androidx.compose.animation.animateColor
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.*
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Colors
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.digimoplus.myeducationcompose.uz.ui.purple500
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Composable
fun FavButton() {

    val coroutineScope = rememberCoroutineScope()
    val sizeState = remember { mutableStateOf(ButtonState.SizeOpen) }
    val cornerState = remember { mutableStateOf(ButtonState.CornerOpen) }
    val textColorState = remember { mutableStateOf(ButtonState.TextColorOpen) }
    val backColorState = remember { mutableStateOf(ButtonState.BackColorOpen) }
    val iconAlphaState = remember { mutableStateOf(ButtonState.IconAlphaOpen) }

    val sizeWith by animateDpAsState(
        targetValue = sizeState.value.value as Dp,
        animationSpec = tween(
            delayMillis = 200,
            durationMillis = 1500,
            easing = FastOutLinearInEasing
        )
    )

    val cornerRadius by animateDpAsState(
        targetValue = cornerState.value.value as Dp,
        animationSpec = tween(
            delayMillis = 200,
            durationMillis = 1500,
            easing = FastOutLinearInEasing
        )
    )

    val textColor by animateColorAsState(
        targetValue = textColorState.value.value as Color,
        animationSpec = tween(
            delayMillis = 200,
            durationMillis = 1500,
            easing = FastOutLinearInEasing
        )
    )

    val backColor by animateColorAsState(
        targetValue = backColorState.value.value as Color,
        animationSpec = tween(
            delayMillis = 200,
            durationMillis = 1500,
            easing = FastOutLinearInEasing
        )
    )

    val iconAlpha by animateFloatAsState(
        targetValue = iconAlphaState.value.value as Float,
        animationSpec = tween(
            delayMillis = 0,
            durationMillis = 800,
            easing = FastOutLinearInEasing
        )
    )

    val myTransition = rememberInfiniteTransition()

    val iconAnim by myTransition.animateValue(
        initialValue = 24.dp,
        targetValue = 12.dp,
        typeConverter = Dp.VectorConverter,
        animationSpec = infiniteRepeatable(
            keyframes {
                delayMillis = 1300
                durationMillis = 1000
                24.dp at 400
                12.dp at 500
                24.dp at 600
                12.dp at 700
            },
            repeatMode = RepeatMode.Restart
        )
    )


    //  val myTransition = rememberInfiniteTransition()
    */
/* val borderWith by myTransition.animateColor(
         initialValue = MaterialTheme.colors.primary,
         targetValue = Color.Red,
         animationSpec = infiniteRepeatable(
             tween(
                 delayMillis = 1000,
                 durationMillis = 200,
                 easing = FastOutLinearInEasing
             ),
             repeatMode = RepeatMode.Reverse
         )
     )*//*



    Button(
        colors = ButtonDefaults.buttonColors(backgroundColor = backColor),
        border = BorderStroke(1.dp, Color.Blue),
        shape = RoundedCornerShape(cornerRadius),
        modifier = Modifier.size(sizeWith, 60.dp),
        onClick = {
            if (sizeState.value == ButtonState.SizeOpen) {
                sizeState.value = ButtonState.SizeClose
                cornerState.value = ButtonState.CornerClose
                textColorState.value = ButtonState.TextColorClose
                backColorState.value = ButtonState.BackColorClose
                coroutineScope.launch {
                    delay(1050)
                    iconAlphaState.value = ButtonState.IconAlphaClose
                }
            } else {
                sizeState.value = ButtonState.SizeOpen
                cornerState.value = ButtonState.CornerOpen
                textColorState.value = ButtonState.TextColorOpen
                backColorState.value = ButtonState.BackColorOpen
                coroutineScope.launch {
                    delay(200)
                    iconAlphaState.value = ButtonState.IconAlphaOpen
                }
            }
        }
    ) {
        ButtonContent(
            textColor,
            iconAlphaState,
            iconAlpha,
            iconAnim
        )
    }

}

enum class ButtonValue(val value: Any) {
    SizeOpen(300.dp),
    SizeClose(60.dp),
    CornerOpen(12.dp),
    CornerClose(40.dp),
    TextColorOpen(Color.Blue),
    TextColorClose(Color.White),
    BackColorOpen(Color.White),
    BackColorClose(Color.Blue),
    IconAlphaOpen(0f),
    IconAlphaClose(1f)
}

enum class ButtonState(val value:List<ButtonValue>){
    IsOpen(listOf(
        ButtonValue.SizeOpen,
        ButtonValue.CornerOpen,
        ButtonValue.TextColorOpen,
        ButtonValue.BackColorOpen,
        ButtonValue.IconAlphaOpen,
    )),
    IsClose(listOf(
        ButtonValue.SizeClose,
        ButtonValue.CornerClose,
        ButtonValue.TextColorClose,
        ButtonValue.BackColorClose,
        ButtonValue.IconAlphaClose,
    ))
}*/

//  val myTransition = rememberInfiniteTransition()
/* val borderWith by myTransition.animateColor(
     initialValue = MaterialTheme.colors.primary,
     targetValue = Color.Red,
     animationSpec = infiniteRepeatable(
         tween(
             delayMillis = 1000,
             durationMillis = 200,
             easing = FastOutLinearInEasing
         ),
         repeatMode = RepeatMode.Reverse
     )
 )*/