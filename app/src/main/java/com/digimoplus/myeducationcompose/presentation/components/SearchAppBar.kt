package com.digimoplus.myeducationcompose.presentation.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.digimoplus.myeducationcompose.presentation.ui.recipe_list.FoodCategory
import com.digimoplus.myeducationcompose.presentation.ui.recipe_list.getAllFoodCategories
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
    ) {
    Surface(
        modifier = Modifier.fillMaxWidth(),
        color = MaterialTheme.colors.primary,
        elevation = 8.dp
    ) {
        Column(modifier = Modifier.fillMaxWidth()) {
            Row(modifier = Modifier.fillMaxWidth()) {
                val focusManager = LocalFocusManager.current
                TextField(modifier = Modifier.fillMaxWidth(.8f),
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
                    textStyle = TextStyle(color = Color.Green),
                    colors = TextFieldDefaults.textFieldColors(
                        backgroundColor = Color.Cyan
                    )
                )
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