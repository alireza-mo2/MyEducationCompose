package com.digimoplus.myeducationcompose.presentation.ui.recipe_list

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.digimoplus.myeducationcompose.domain.model.Recipe
import com.digimoplus.myeducationcompose.network.RecipeService
import com.digimoplus.myeducationcompose.repository.RecipeRepository
import com.digimoplus.myeducationcompose.util.TAG
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import java.util.concurrent.Flow
import javax.inject.Inject
import javax.inject.Named

@HiltViewModel
class RecipeListViewModel
@Inject constructor(
    private val recipeRepository: RecipeRepository,
    @Named("auth_token") private val token: String
) : ViewModel() {

    val recipes: MutableState<List<Recipe>?> = mutableStateOf(null)
    val query = mutableStateOf("chicken")
    val selectedCategory: MutableState<FoodCategory?> = mutableStateOf(null)
    val loading = mutableStateOf(false)
    var categoryScrollIndex: Int = 0
    var categoryScrollOffset: Int = 0
    val page = mutableStateOf(1)
    private var recipeListScrollPosition = 0

    init {
        newSearch()
    }

    fun newSearch() {
        viewModelScope.launch {
            loading.value = true
            resetSearchState()
            delay(2000)
            val result = recipeRepository.search(
                token = token,
                page = 1,
                query = query.value
            )
            recipes.value = result
            loading.value = false
        }
    }

    fun onNextPage() {
        viewModelScope.launch {
            if ((recipeListScrollPosition + 1) >= page.value * PAGE_SIZE) {
                loading.value = true
                Log.d(TAG, "onNextPage: ${page.value}")
                incrementPage()
                delay(1000)
                val result = recipeRepository.search(
                    token = token,
                    page.value,
                    query.value
                )
                appendNewList(result)
                loading.value = false
            }
        }
    }

    private fun incrementPage() {
        page.value = page.value + 1
    }

    fun onChangeRecipesScrollPosition(position: Int) {
        recipeListScrollPosition = position
    }

    // Append new list to current list of recipes
    private fun appendNewList(recipes: List<Recipe>) {
        val current = this.recipes.value?.toMutableList() ?: mutableListOf()
        current.addAll(recipes)
        this.recipes.value = current
    }

    private fun resetSearchState() {
        recipes.value = listOf()
        page.value = 1
        onChangeRecipesScrollPosition(0)
        if (selectedCategory.value?.value != query.value) {
            clearSelectedCategory()
        }
    }

    private fun clearSelectedCategory() {
        selectedCategory.value = null
    }

    fun onQueryChanged(query: String) {
        this.query.value = query
    }

    fun onSelectedCategoryChanged(category: String) {
        val newCategory = getFoodCategory(category)
        selectedCategory.value = newCategory
        onQueryChanged(category)
    }

    fun onChangeCategoryScrollPosition(index: Int, offset: Int) {
        categoryScrollIndex = index
        categoryScrollOffset = offset
    }
}