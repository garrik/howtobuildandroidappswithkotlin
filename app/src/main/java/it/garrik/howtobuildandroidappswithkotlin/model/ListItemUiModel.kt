package it.garrik.howtobuildandroidappswithkotlin.model

sealed class ListItemUiModel {
    data class Title(val title: String) : ListItemUiModel()
    data class Cat(val data: CatUiModel) : ListItemUiModel()
}
