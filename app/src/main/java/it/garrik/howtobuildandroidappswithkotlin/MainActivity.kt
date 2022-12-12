package it.garrik.howtobuildandroidappswithkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.TextView
import it.garrik.howtobuildandroidappswithkotlin.api.TheWeatherService
import it.garrik.howtobuildandroidappswithkotlin.model.WeatherResultData
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

class MainActivity : AppCompatActivity() {

    private val apiKey: String = "???"
    private val latitudeOfIvrea: Double = 45.4673
    private val longitudeOfIvrea: Double = 7.8801
    private val shortDescriptionView: TextView
            by lazy { findViewById(R.id.weather_short_description) }
    private val longDescriptionView: TextView
            by lazy { findViewById(R.id.weather_long_description) }
    private val weatherImageView: ImageView
            by lazy { findViewById(R.id.weather_image) }

    private val retrofit by lazy {
        Retrofit.Builder()
            .baseUrl("https://api.openweathermap.org/data/2.5/")
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
    }
    private val theWeatherService by lazy { retrofit.create(TheWeatherService::class.java) }

    private val imageLoader: ImageLoader by lazy { GlideImageLoader(this) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        getWeatherResponse()
    }

    private fun getWeatherResponse() {
        val call = theWeatherService.weather(apiKey, latitudeOfIvrea, longitudeOfIvrea)
        call.enqueue(object : Callback<WeatherResultData> {
            override fun onFailure(call: Call<WeatherResultData>, t: Throwable) {
                Log.e("MainActivity", "Failed to get search results", t)
            }

            override fun onResponse(
                call: Call<WeatherResultData>,
                response: Response<WeatherResultData>
            ) {
                if (response.isSuccessful) {
                    val weatherResultData = response.body()
                    val firstWeather = weatherResultData?.weathers?.firstOrNull()
                    val firstWeatherIcon = firstWeather?.icon ?: ""

                    if (!firstWeatherIcon.isBlank()) {
                        imageLoader.loadImage(getIconUrl(firstWeatherIcon), weatherImageView)
                    } else {
                        Log.d("MainActivity", "Missing image URL")
                    }
                    val title = "weather in " + weatherResultData?.name ?: "Unknown"
                    getSupportActionBar()?.setTitle(title)
                    shortDescriptionView.text = firstWeather?.main ?: "Unknown"
                    longDescriptionView.text = firstWeather?.description ?: "Unknown"
                } else {
                    Log.e(
                        "MainActivity",
                        "Failed to get search results\n${response.errorBody()?.string() ?: ""}"
                    )
                }
            }
        })
    }

    private fun getIconUrl(icon: String) : String {
        return "https://openweathermap.org/img/w/${icon ?: ""}.png"
    }
}