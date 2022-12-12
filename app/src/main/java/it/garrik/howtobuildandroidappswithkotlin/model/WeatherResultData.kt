package it.garrik.howtobuildandroidappswithkotlin.model

import com.squareup.moshi.Json

data class WeatherResultData(
    @field:Json(name = "weather") val weathers: List<WeatherData>,
    val name: String,
    val id: Int
)
