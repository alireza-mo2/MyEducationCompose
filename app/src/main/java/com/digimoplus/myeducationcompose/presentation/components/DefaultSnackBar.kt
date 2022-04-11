package com.digimoplus.myeducationcompose.presentation.components

import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import okhttp3.internal.wait


@Composable
fun DefaultSnackBar(
    snackBarHostState: SnackbarHostState,
    modifier: Modifier = Modifier,
    onDismiss: () -> Unit
) {
    SnackbarHost(
        hostState = snackBarHostState,
        snackbar = { data ->
            Snackbar(
                modifier = Modifier.padding(16.dp),
                backgroundColor = Color.DarkGray,
                action = {
                    data.actionLabel?.let {
                        TextButton(onClick = onDismiss) {
                            Text(
                                text = it,
                                style = MaterialTheme.typography.body2,
                                color = Color.White
                            )
                        }
                    }
                }
            ) {
                Text(
                    text = data.message,
                    style = MaterialTheme.typography.body2,
                    color = Color.White
                )
            }

        },
        modifier = modifier
    )
}