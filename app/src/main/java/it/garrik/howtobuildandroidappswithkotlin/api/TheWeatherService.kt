package it.garrik.howtobuildandroidappswithkotlin.api

import it.garrik.howtobuildandroidappswithkotlin.model.WeatherResultData
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface TheWeatherService {
    @GET("weather")
    fun weather(
        @Query("appid") key: String,
        @Query("lat") latitude: Double,
        @Query("lon") longitude: Double
    ) : Call<WeatherResultData>
}