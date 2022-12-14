package com.digimoplus.myeducationcompose.di

import com.digimoplus.myeducationcompose.network.RecipeService
import com.digimoplus.myeducationcompose.network.model.RecipeDtoMapper
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Named
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Singleton
    @Provides
    fun provideRetrofitBuilder(): Retrofit.Builder {
        return Retrofit.Builder()
            .baseUrl("https://food2fork.ca/api/recipe/")
            .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
    }

    @Singleton
    @Provides
    fun provideRecipeService(builder: Retrofit.Builder): RecipeService {
        return builder.build()
            .create(RecipeService::class.java)
    }

    @Singleton
    @Provides
    fun provideRecipeDtoMapper(): RecipeDtoMapper {
        return RecipeDtoMapper()
    }

    @Singleton
    @Provides
    @Named("auth_token")
    fun provideAuthToken(): String{
        return "Token 9c8b06d329136da358c2d00e76946b0111ce2c48"
    }
}