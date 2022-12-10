package it.garrik.howtobuildandroidappswithkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.TextView

import it.garrik.howtobuildandroidappswithkotlin.api.TheCatApiService
import it.garrik.howtobuildandroidappswithkotlin.model.ImageResultData

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory


class MainActivity : AppCompatActivity() {
    private val serverResponseView: TextView
            by lazy { findViewById(R.id.main_server_response) }
    private val profileImageView: ImageView
            by lazy { findViewById(R.id.main_profile_image) }
    private val imageLoader: ImageLoader by lazy { GlideImageLoader(this) }

    private val retrofit by lazy {
        Retrofit.Builder()
            .baseUrl("https://api.thecatapi.com/v1/")
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
    }

    private val theCatApiService by lazy { retrofit.create(TheCatApiService::class.java) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        getCatImageResponse()
    }

    private fun getCatImageResponse() {
        val call = theCatApiService.searchImages(1, "full")
        call.enqueue(object : Callback<List<ImageResultData>> {
            override fun onFailure(call: Call<List<ImageResultData>>, t: Throwable) {
                Log.e("MainActivity", "Failed to get search results", t)
            }

            override fun onResponse(
                call: Call<List<ImageResultData>>,
                response: Response<List<ImageResultData>>
            ) {
                if (response.isSuccessful) {
                    val imageResults = response.body()
                    val firstImageUrl = imageResults?.firstOrNull()?.imageUrl ?: ""
                    serverResponseView.text = "Image URL: $firstImageUrl"

                    if (!firstImageUrl.isBlank()) {
                        imageLoader.loadImage(firstImageUrl, profileImageView)
                    } else {
                        Log.d("MainActivity", "Missing image URL")
                    }
                } else {
                    Log.e(
                        "MainActivity",
                        "Failed to get search results\n${response.errorBody()?.string() ?: ""}"
                    )
                }
            }
        })
    }
}
