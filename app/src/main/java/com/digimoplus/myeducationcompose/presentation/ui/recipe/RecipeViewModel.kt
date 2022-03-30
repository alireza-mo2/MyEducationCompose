package com.digimoplus.myeducationcompose.presentation.ui.recipe

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.digimoplus.myeducationcompose.domain.model.Recipe
import com.digimoplus.myeducationcompose.repository.RecipeRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import javax.inject.Inject
import javax.inject.Named

const val STATE_KEY_RECIPE = "recipe.state.recipe.key"

@HiltViewModel
class RecipeViewModel
@Inject constructor(
    private val recipeRepository: RecipeRepository,
    @Named("auth_token") private val token: String
) : ViewModel() {

    val loading = mutableStateOf(false)
    val recipe: MutableState<Recipe?> = mutableStateOf(null)

    private suspend fun getRecipe(id: Int) {
        loading.value = true

        delay(1000)

        val recipe = recipeRepository.get(token = token, id = id)
        this.recipe.value = recipe

        //state.set(STATE_KEY_RECIPE, recipe.id)

        loading.value = false
    }

}