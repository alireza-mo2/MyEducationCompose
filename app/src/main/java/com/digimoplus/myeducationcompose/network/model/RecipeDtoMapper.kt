package com.digimoplus.myeducationcompose.network.model

import com.digimoplus.myeducationcompose.domain.model.Recipe
import com.digimoplus.myeducationcompose.domain.util.DomainMapper

class RecipeDtoMapper : DomainMapper<RecipeDto, Recipe> {

    override fun mapToDomainModel(model: RecipeDto): Recipe {
        return Recipe(
            id = model.pk,
            title = model.title,
            publisher = model.publisher,
            featuredImage = model.featuredImage,
            rating = model.rating,
            sourceUrl = model.sourceUrl,
            ingredients = model.ingredients.orEmpty(),
            dateAdded = model.dateAdded,
            dateUpdated = model.dateUpdated
        )
    }

    override fun mapFromDomainModel(domainModel: Recipe): RecipeDto {
        return RecipeDto(
            pk = domainModel.id,
            title = domainModel.title,
            publisher = domainModel.publisher,
            featuredImage = domainModel.featuredImage,
            rating = domainModel.rating,
            sourceUrl = domainModel.sourceUrl,
            ingredients = domainModel.ingredients,
            dateAdded = domainModel.dateAdded,
            dateUpdated = domainModel.dateUpdated
        )
    }

    fun mapToDomainList(initial: List<RecipeDto>): List<Recipe> {
        return initial.map { mapToDomainModel(it) }
    }

    fun mapFromDomainModel(initial: List<Recipe>): List<RecipeDto> {
        return initial.map { mapFromDomainModel(it) }
    }

}