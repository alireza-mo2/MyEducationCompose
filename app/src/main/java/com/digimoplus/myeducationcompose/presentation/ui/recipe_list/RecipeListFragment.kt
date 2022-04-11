package com.digimoplus.myeducationcompose.presentation.ui.recipe_list

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.*
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.unit.dp
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.viewmodel.compose.viewModel
import com.digimoplus.myeducationcompose.presentation.BaseApplication
import com.digimoplus.myeducationcompose.presentation.components.CircularIndeterminateProgressBar
import com.digimoplus.myeducationcompose.presentation.components.DefaultSnackBar
import com.digimoplus.myeducationcompose.presentation.components.RecipeCard
import com.digimoplus.myeducationcompose.presentation.components.SearchAppBar
import com.digimoplus.myeducationcompose.presentation.theme.AppTheme
import com.digimoplus.myeducationcompose.util.TAG
import com.digimoplus.myeducationcompose.z_animation_cardshimmer.GradientShimmerCard
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import javax.inject.Inject

const val PAGE_SIZE = 30

@AndroidEntryPoint
class RecipeListFragment : Fragment() {

    private val viewModel: RecipeListViewModel by viewModels()

    @Inject
    lateinit var application: BaseApplication

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return ComposeView(requireContext()).apply {
            setContent {
                val recipes = viewModel.recipes.value
                val query = viewModel.query.value
                val selectedCategory = viewModel.selectedCategory.value
                val loading = viewModel.loading.value
                val page = viewModel.page.value
                val scaffoldState = rememberScaffoldState()
                AppTheme(darkTheme = application.isDark.value) {
                    Scaffold(
                        modifier = Modifier
                            .fillMaxSize()
                            .background(color = MaterialTheme.colors.background),
                        scaffoldState = scaffoldState,
                        snackbarHost = {
                            scaffoldState.snackbarHostState
                        },
                        topBar = {
                            SearchAppBar(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(top = 8.dp),
                                query = query,
                                onQueryChanged = viewModel::onQueryChanged,
                                newSearch = {
                                    if (viewModel.selectedCategory.value?.value == "Milk") {
                                        lifecycleScope.launch {
                                            scaffoldState.snackbarHostState.showSnackbar(
                                                message = "Hey look a SnackBar",
                                                actionLabel = "Hide",
                                            )
                                        }
                                    } else {
                                        viewModel.newSearch()
                                    }
                                },
                                selectedCategory = selectedCategory,
                                onSelectedCategoryChanged = viewModel::onSelectedCategoryChanged,
                                onChangeCategoryScrollPosition = viewModel::onChangeCategoryScrollPosition,
                                categoryScrollIndex = viewModel.categoryScrollIndex,
                                categoryScrollOffset = viewModel.categoryScrollOffset,
                                onToggleTheme = application::toggleLightTheme
                            )
                        },
                        drawerContent = {
                            Column {
                                Text(text = "hi brother hihihih")
                                Text(text = "hi brother hihihih")
                                Text(text = "hi brother hihihih")
                                Text(text = "hi brother hihihih")
                            }
                        },

                        ) {
                        Box(
                            modifier = Modifier
                                .background(color = MaterialTheme.colors.background)
                                .fillMaxSize()
                        ) {
                            if (loading && recipes?.isEmpty() == true) {
                                Column {
                                    repeat(5) {
                                        GradientShimmerCard(
                                            modifier = Modifier.padding(8.dp),
                                            cardHeight = 300.dp,
                                            colors = listOf(
                                                Color.LightGray.copy(alpha = 0.8f),
                                                Color.Gray.copy(alpha = 0.1f),
                                                Color.LightGray.copy(alpha = 0.8f)
                                            ),
                                        )
                                    }
                                }
                            } else {
                                LazyColumn {
                                    itemsIndexed(items = recipes ?: listOf()) { index, recipe ->
                                        viewModel.onChangeRecipesScrollPosition(index)
                                        if ((index + 1) >= page * PAGE_SIZE && !loading) {
                                            viewModel.onNextPage()
                                        }
                                        RecipeCard(recipe = recipe, onClick = {})
                                    }
                                }
                            }
                            CircularIndeterminateProgressBar(isDisplay = loading)
                            DefaultSnackBar(
                                snackBarHostState = scaffoldState.snackbarHostState,
                                modifier = Modifier.align(Alignment.BottomCenter),
                                onDismiss = {
                                    scaffoldState.snackbarHostState.currentSnackbarData?.dismiss()
                                }
                            )
                        }
                    }
                }
            }
        }
    }
}