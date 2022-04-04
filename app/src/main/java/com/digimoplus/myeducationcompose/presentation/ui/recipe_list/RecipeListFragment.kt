package com.digimoplus.myeducationcompose.presentation.ui.recipe_list

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.digimoplus.myeducationcompose.presentation.BaseApplication
import com.digimoplus.myeducationcompose.presentation.components.CircularIndeterminateProgressBar
import com.digimoplus.myeducationcompose.presentation.components.RecipeCard
import com.digimoplus.myeducationcompose.presentation.components.SearchAppBar
import com.digimoplus.myeducationcompose.presentation.theme.AppTheme
import com.digimoplus.myeducationcompose.util.TAG
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject


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
                AppTheme(darkTheme = application.isDark.value) {
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .background(color = MaterialTheme.colors.background),
                    ) {
                        SearchAppBar(
                            query = query,
                            onQueryChanged = viewModel::onQueryChanged,
                            newSearch = viewModel::newSearch,
                            selectedCategory = selectedCategory,
                            onSelectedCategoryChanged = viewModel::onSelectedCategoryChanged,
                            onChangeCategoryScrollPosition = viewModel::onChangeCategoryScrollPosition,
                            categoryScrollIndex = viewModel.categoryScrollIndex,
                            categoryScrollOffset = viewModel.categoryScrollOffset,
                            onToggleTheme = application::toggleLightTheme
                        )
                        Box(modifier = Modifier.fillMaxSize()) {
                            LazyColumn {
                                itemsIndexed(items = recipes ?: listOf()) { _, recipe ->
                                    RecipeCard(recipe = recipe, onClick = {})
                                }
                            }
                            CircularIndeterminateProgressBar(isDisplay = loading)
                        }
                    }
                }
            }
        }
    }

}