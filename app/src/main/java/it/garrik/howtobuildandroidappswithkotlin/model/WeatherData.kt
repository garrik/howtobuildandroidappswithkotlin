package it.garrik.howtobuildandroidappswithkotlin.model


data class WeatherData(
    val id: Int,
    val main: String,
    val description: String,
    val icon: String
)
