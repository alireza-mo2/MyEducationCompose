package com.digimoplus.myeducationcompose.di

import com.digimoplus.myeducationcompose.network.RecipeService
import com.digimoplus.myeducationcompose.network.model.RecipeDtoMapper
import com.digimoplus.myeducationcompose.repository.RecipeRepository
import com.digimoplus.myeducationcompose.repository.RecipeRepository_Impl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Singleton
    @Provides
    fun provideRecipeRepository(
        recipeService: RecipeService,
        recipeDtoMapper: RecipeDtoMapper
    ): RecipeRepository {
        return RecipeRepository_Impl(
            recipeService = recipeService,
            recipeDtoMapper = recipeDtoMapper
        )
    }
}