package com.digimoplus.myeducationcompose.presentation.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.selection.toggleable
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.internal.illegalDecoyCallException
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp


@Composable
fun FoodCategoryChip(
    category: String,
    isSelected: Boolean = false,
    onSelectedCategoryChange: (String) -> Unit,
    onExecuteSearch: () -> Unit,
) {
    Surface(
        modifier = Modifier.padding(end = 8.dp),
        shape = MaterialTheme.shapes.medium,
        color = if (isSelected) Color.Gray else Color.White,
        elevation = 8.dp,
    ) {
        Row(modifier = Modifier.toggleable(
            value = isSelected,
            onValueChange = {
                onSelectedCategoryChange(category)
                onExecuteSearch()
            }
        )) {
            Text(
                modifier = Modifier.padding(8.dp),
                text = category,
                style = MaterialTheme.typography.body2,
                color = if (isSelected) Color.White else Color.Black,
            )
        }
    }
}