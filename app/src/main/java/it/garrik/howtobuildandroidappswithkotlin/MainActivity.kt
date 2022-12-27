package it.garrik.howtobuildandroidappswithkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import it.garrik.howtobuildandroidappswithkotlin.model.CatBreed
import it.garrik.howtobuildandroidappswithkotlin.model.CatUiModel
import it.garrik.howtobuildandroidappswithkotlin.model.Gender

class MainActivity : AppCompatActivity() {
    private val recyclerView: RecyclerView
        by lazy { findViewById(R.id.recycler_view) }
    private val catsAdapter
        by lazy { CatsAdapter(
            layoutInflater,
            GlideImageLoader(this),
            object : CatsAdapter.OnClickListener {
                override fun onItemClick(catData: CatUiModel) =
                    showSelectionDialog(catData)
            })
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recyclerView.adapter = catsAdapter
        recyclerView.layoutManager = LinearLayoutManager(this,
            LinearLayoutManager.VERTICAL, false)
        catsAdapter.setData(
            listOf(
                CatUiModel(
                    Gender.Male,
                    CatBreed.BalineseJavanese,
                    "Fred",
                    "Silent and deadly",
                    "https://cdn2.thecatapi.com/images/DBmIBhhyv.jpg"
                ),
                CatUiModel(
                    Gender.Female,
                    CatBreed.ExoticShorthair,
                    "Wilma",
                    "Cuddly assassin",
                    "https://cdn2.thecatapi.com/images/KJF8fB_20.jpg"
                ),
                CatUiModel(
                    Gender.Unknown,
                    CatBreed.AmericanCurl,
                    "Curious George",
                    "Award winning investigator",
                    "https://cdn2.thecatapi.com/images/vJB8rwfdX.jpg"
               )
            )
        )
    }

    private fun showSelectionDialog(catData: CatUiModel) {
        AlertDialog.Builder(this)
        .setTitle("Agent Selected")
        .setMessage("You have selected agent ${catData.name}")
        .setPositiveButton("OK") { _, _ -> }
        .show()
    }
}