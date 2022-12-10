package it.garrik.howtobuildandroidappswithkotlin.model

import com.squareup.moshi.Json

data class ImageResultData (
    @field:Json(name = "url") val imageUrl: String,
    val breeds: List<CatBreedData>
)