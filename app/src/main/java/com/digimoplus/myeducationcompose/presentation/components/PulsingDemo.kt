package com.digimoplus.myeducationcompose.presentation.components
/*

import androidx.compose.animation.animateColor
import androidx.compose.animation.core.*
import androidx.compose.runtime.*
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.digimoplus.myeducationcompose.presentation.components.PulseAnimationDefinitions.PulseState.*


enum class PulseState {
    INITIAL, FINAL
}

@Composable
fun myTest() {

    var currentState by remember { mutableStateOf(PulseState.INITIAL) }
    val transition = updateTransition(currentState, label = "")

    val rect by transition.animateRect(label = "") { state ->
        when (state) {
            PulseState.INITIAL -> Rect(0f, 0f, 100f, 100f)
            PulseState.FINAL -> Rect(100f, 100f, 300f, 300f)
        }
    }
    val borderWidth by transition.animateDp(label = "") { state ->
        when (state) {
            PulseState.INITIAL -> 1.dp
            PulseState.FINAL -> 0.dp
        }
    }

    val color by transition.animateColor(
        transitionSpec = {
            when {
                PulseState.FINAL isTransitioningTo PulseState.INITIAL ->
                    spring(stiffness = 50f)
                else ->
                    tween(durationMillis = 500)
            }
        }, label = ""
    ) { state ->
        when (state) {
            PulseState.INITIAL -> Color.Blue
            PulseState.FINAL -> Color.Black
        }
    }



}




object PulseAnimationDefinitions {


    ////

    val pulsePropKey = FloatPropKey("pulseKey")

    val pulseDefinition = transitionDefinition<PulseState> {
        state(INITIAL) { this[pulsePropKey] = 40f }
        state(FINAL) { this[pulsePropKey] = 50f }

        transition(
            INITIAL to FINAL,
        ) {
            pulsePropKey using infiniteRepeatable(
                animation = tween(
                    durationMillis = 500,
                    easing = FastOutSlowInEasing
                ),
                repeatMode = RepeatMode.Restart
            )
        }
    }
}*/
