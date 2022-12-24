package it.garrik.howtobuildandroidappswithkotlin.model

data class CatUiModel(
    val gender: Gender,
    val breed: CatBreed,
    val name: String,
    val biography: String,
    val imageUrl: String
)