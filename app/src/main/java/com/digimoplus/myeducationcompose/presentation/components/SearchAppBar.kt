package com.digimoplus.myeducationcompose.presentation.components

import android.util.Log
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester.Companion.createRefs
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.widget.ConstraintLayout
import com.digimoplus.myeducationcompose.presentation.ui.recipe_list.FoodCategory
import com.digimoplus.myeducationcompose.presentation.ui.recipe_list.getAllFoodCategories
import com.digimoplus.myeducationcompose.util.TAG
import kotlinx.coroutines.NonDisposableHandle.parent
import kotlinx.coroutines.launch

@Composable
fun SearchAppBar(
    query: String,
    onQueryChanged: (String) -> Unit,
    newSearch: () -> Unit,
    selectedCategory: FoodCategory?,
    onSelectedCategoryChanged: (String) -> Unit,
    onChangeCategoryScrollPosition: (Int, Int) -> Unit,
    categoryScrollIndex: Int,
    categoryScrollOffset: Int,
    onToggleTheme: () -> Unit
) {
    Surface(
        modifier = Modifier.fillMaxWidth(),
        color = MaterialTheme.colors.secondary,
        elevation = 8.dp,
    ) {
        Column(modifier = Modifier.fillMaxWidth()) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(end = 8.dp, start = 8.dp)
            ) {
                val focusManager = LocalFocusManager.current
                TextField(modifier = Modifier
                    .fillMaxWidth(.9f),
                    value = query,
                    onValueChange = {
                        onQueryChanged(it)
                    }, label = {
                        Text(text = "search")
                    },
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Text,
                        imeAction = ImeAction.Search
                    ),
                    keyboardActions = KeyboardActions(
                        onSearch = {
                            focusManager.clearFocus()
                            newSearch()
                        }
                    ),
                    leadingIcon = {
                        Icon(Icons.Filled.Search, contentDescription = null)
                    },
                    textStyle = TextStyle(color = MaterialTheme.colors.onSurface),
                    colors = TextFieldDefaults.textFieldColors(
                        backgroundColor = MaterialTheme.colors.surface
                    )
                )
                IconButton(
                    onClick = onToggleTheme,
                    modifier = Modifier
                        .fillMaxWidth()
                        .align(
                            Alignment.CenterVertically
                        )
                ) {
                    Icon(
                        modifier = Modifier
                            .fillMaxWidth()
                            .align(Alignment.CenterVertically),
                        imageVector = Icons.Filled.MoreVert,
                        contentDescription = ""
                    )
                }
            }

            val listState = rememberLazyListState()
            val coroutineScope = rememberCoroutineScope()
            LazyRow(
                modifier = Modifier.padding(8.dp),
                state = listState,

                ) {
                itemsIndexed(items = getAllFoodCategories()) { _, foodCategory ->
                    FoodCategoryChip(
                        category = foodCategory.value,
                        isSelected = selectedCategory == foodCategory,
                        onSelectedCategoryChange = {
                            onSelectedCategoryChanged(it)
                            onChangeCategoryScrollPosition(
                                listState.firstVisibleItemIndex,
                                listState.firstVisibleItemScrollOffset
                            )
                        },
                        onExecuteSearch = {
                            newSearch()
                        },
                    )
                }
                coroutineScope.launch {
                    listState.animateScrollToItem(
                        categoryScrollIndex,
                        categoryScrollOffset
                    )
                }
            }
        }
    }
}