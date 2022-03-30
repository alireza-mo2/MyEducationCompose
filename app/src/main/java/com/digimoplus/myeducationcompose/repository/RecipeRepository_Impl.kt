package com.digimoplus.myeducationcompose.repository

import com.digimoplus.myeducationcompose.domain.model.Recipe
import com.digimoplus.myeducationcompose.network.RecipeService
import com.digimoplus.myeducationcompose.network.model.RecipeDtoMapper

class RecipeRepository_Impl
constructor(
    private val recipeService: RecipeService,
    private val recipeDtoMapper: RecipeDtoMapper
) : RecipeRepository {
    override suspend fun search(token: String, page: Int, query: String): List<Recipe> {
        return recipeDtoMapper.mapToDomainList(
            recipeService.search(
                token = token,
                page = page,
                query = query
            ).recipes
        )
    }

    override suspend fun get(token: String, id: Int): Recipe {
        return recipeDtoMapper.mapToDomainModel(recipeService.get(token, id))
    }

}