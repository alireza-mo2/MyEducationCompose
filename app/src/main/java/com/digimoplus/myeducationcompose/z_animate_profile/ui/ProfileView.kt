package com.digimoplus.myeducationcompose.z_animate_profile.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.digimoplus.myeducationcompose.R
import com.digimoplus.myeducationcompose.util.DEFAULT_RECIPE_IMAGE
import com.digimoplus.myeducationcompose.util.loadPicture


@Composable
fun ProfileView() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .height(300.dp)
            .background(Color.LightGray),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Box(
            modifier = Modifier
                .size(100.dp)
                .clip(CircleShape)
                .border(2.dp, color = Color.Red, shape = CircleShape)
        ) {
            Row(
                modifier = Modifier.fillMaxSize(),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                /*Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(Color.Blue),
                    contentAlignment = Alignment.Center
                ) {
                    Text(text = "M", style = MaterialTheme.typography.h4, color = Color.White)
                }*/
                /* val image = loadPicture(url = "url", defaultImage = R.drawable.logo).value
                 image?.let { img ->
                     Image(
                         bitmap = img.asImageBitmap(),
                         contentDescription = "",
                         modifier = Modifier
                             .fillMaxSize(),
                         contentScale = ContentScale.Crop
                     )
                 }*/
            }
        }
    }


}