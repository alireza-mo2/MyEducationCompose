package com.digimoplus.myeducationcompose.network.response

import com.digimoplus.myeducationcompose.network.model.RecipeDto
import com.google.gson.annotations.SerializedName

data class RecipeSearchResponse(

    @SerializedName("count")
    var count: Int,

    @SerializedName("results")
    var recipes: List<RecipeDto>
)