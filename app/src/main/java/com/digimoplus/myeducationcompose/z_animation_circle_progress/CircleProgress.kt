package com.digimoplus.myeducationcompose.z_animation_circle_progress

import android.util.Log
import androidx.compose.animation.core.*
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Colors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import com.digimoplus.myeducationcompose.util.TAG


@Composable
fun CircleProgress() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
    ) {

        //The distance between the size of each point
        val pointsSizeDistance = 3f
        //the points radius
        val pointsRadius = 15f

        val baseCircleHeightRadius = 200f

        val allPointsRadius =
            (pointsRadius - (pointsSizeDistance * 0)) + (pointsRadius - (pointsSizeDistance * 1)) + (pointsRadius - (pointsSizeDistance * 2)) + (pointsRadius - (pointsSizeDistance * 3))
        Log.d(TAG, "CircleProgress: alll = $allPointsRadius")
        val pointsDistance = (baseCircleHeightRadius - (allPointsRadius * 2)) / 2f
        Log.d(TAG, "CircleProgress: dis = $pointsDistance")
        ////////////////////////////////////////////////////


        val radius1 = baseCircleHeightRadius - (pointsDistance * 0)
        val radius2 = baseCircleHeightRadius - (pointsDistance * 1)
        val radius3 = baseCircleHeightRadius - (pointsDistance * 2)
        val radius4 = baseCircleHeightRadius - (pointsDistance * 3)

        Log.d(TAG, "CircleProgress 1: $radius1")
        Log.d(TAG, "CircleProgress 2: $radius2")
        Log.d(TAG, "CircleProgress 3: $radius3")
        Log.d(TAG, "CircleProgress 4: $radius4")


        val animateFloat1 = remember { Animatable(0f) }
        LaunchedEffect(animateFloat1) {
            animateFloat1.animateTo(
                targetValue = 1f,
                animationSpec = infiniteRepeatable(
                    animation = tween(
                        delayMillis = 300,
                        durationMillis = 2000,
                        easing = LinearEasing
                    ),
                    repeatMode = RepeatMode.Restart
                )
            )
        }
        val animateFloat2 = remember { Animatable(0f) }
        LaunchedEffect(animateFloat2) {
            animateFloat2.animateTo(
                targetValue = 1f,
                animationSpec = infiniteRepeatable(
                    animation = tween(
                        delayMillis = 300,
                        durationMillis = 2000,
                        easing = LinearEasing
                    ),
                    repeatMode = RepeatMode.Restart
                )
            )
        }
        val animateFloat3 = remember { Animatable(0f) }
        LaunchedEffect(animateFloat3) {
            animateFloat3.animateTo(
                targetValue = 1f,
                animationSpec = infiniteRepeatable(
                    animation = tween(
                        delayMillis = 300,
                        durationMillis = 2000,
                        easing = LinearEasing
                    ),
                    repeatMode = RepeatMode.Restart
                )
            )
        }
        val animateFloat4 = remember { Animatable(0f) }
        LaunchedEffect(animateFloat4) {
            animateFloat4.animateTo(
                targetValue = 1f,
                animationSpec = infiniteRepeatable(
                    animation = tween(
                        delayMillis = 300,
                        durationMillis =2000,
                        easing = LinearEasing
                    ),
                    repeatMode = RepeatMode.Restart
                )
            )
        }

        Canvas(modifier = Modifier.fillMaxSize()) {


            // this has changed
            val startInDisplay = size.height * 0.156f

            drawCircle(
                color = Color.Black,
                radius = pointsRadius - (pointsSizeDistance * 0),
                center = Offset(size.width * 0.5f, startInDisplay + (pointsDistance * 0))
            )
            drawCircle(
                color = Color.Black,
                radius = pointsRadius - (pointsSizeDistance * 1),
                center = Offset(size.width * 0.5f, startInDisplay + (pointsDistance * 1))
            )
            drawCircle(
                color = Color.Black,
                pointsRadius - (pointsSizeDistance * 2),
                center = Offset(size.width * 0.5f, startInDisplay + (pointsDistance * 2))
            )
            drawCircle(
                color = Color.Black,
                pointsRadius - (pointsSizeDistance * 3),
                center = Offset(size.width * 0.5f, startInDisplay + (pointsDistance * 3))
            )

            ///////////////////////////////////////////////////////////////////////////

            //case 1
            drawArc(
                color = Color.Black,
                startAngle = 270f,
                sweepAngle = 360f * animateFloat1.value,
                useCenter = false,
                topLeft = Offset(
                    (size.width * 0.5f) - radius1,
                    startInDisplay + (pointsDistance * 0)
                ),
                size = Size(
                    radius1 * 2,
                    radius1 * 2
                ),
                style = Stroke((pointsRadius - (pointsSizeDistance * 0)) * 2, cap = StrokeCap.Round)
            )

            //case 2
            drawArc(
                color = Color.Black,
                startAngle = 270f,
                sweepAngle = 360f * animateFloat2.value,
                useCenter = false,
                topLeft = Offset(
                    (size.width * 0.5f) - radius2,
                    startInDisplay + (pointsDistance * 1)
                ),
                size = Size(
                    radius2 * 2,
                    radius2 * 2
                ),
                style = Stroke((pointsRadius - (pointsSizeDistance * 1)) * 2, cap = StrokeCap.Round)
            )

            //case 3
            drawArc(
                color = Color.Black,
                startAngle = 270f,
                sweepAngle = 360f * animateFloat3.value,
                useCenter = false,
                topLeft = Offset(
                    (size.width * 0.5f) - radius3,
                    startInDisplay + (pointsDistance * 2)
                ),
                size = Size(
                    radius3 * 2,
                    radius3 * 2
                ),
                style = Stroke((pointsRadius - (pointsSizeDistance * 2)) * 2, cap = StrokeCap.Round)
            )

            //case 4
            drawArc(
                color = Color.Black,
                startAngle = 270f,
                sweepAngle = 360f * animateFloat4.value,
                useCenter = false,
                topLeft = Offset(
                    (size.width * 0.5f) - radius4,
                    startInDisplay + (pointsDistance * 3)
                ),
                size = Size(
                    radius4 * 2,
                    radius4 * 2
                ),
                style = Stroke((pointsRadius - (pointsSizeDistance * 3)) * 2, cap = StrokeCap.Round)
            )

        }


    }
}
