package it.garrik.howtobuildandroidappswithkotlin

import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import it.garrik.howtobuildandroidappswithkotlin.model.CatBreed
import it.garrik.howtobuildandroidappswithkotlin.model.CatUiModel
import it.garrik.howtobuildandroidappswithkotlin.model.Gender
import it.garrik.howtobuildandroidappswithkotlin.model.ListItemUiModel

class MainActivity : AppCompatActivity() {
    private val recyclerView: RecyclerView
            by lazy { findViewById(R.id.recycler_view) }
    private val listItemAdapter by lazy {
        ListItemAdapter(
            layoutInflater,
            GlideImageLoader(this),
            object : ListItemAdapter.OnClickListener {
                override fun onItemClick(catData: CatUiModel) = showSelectionDialog(catData)
            }
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recyclerView.adapter = listItemAdapter
        recyclerView.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        val itemTouchHelper = ItemTouchHelper(listItemAdapter.swipeToDeleteCallback)
        itemTouchHelper.attachToRecyclerView(recyclerView)

        listItemAdapter.setData(
            listOf(
                ListItemUiModel.Title("Sleeper Agents"),
                ListItemUiModel.Cat(
                    CatUiModel(
                        Gender.Male,
                        CatBreed.ExoticShorthair,
                        "Garvey",
                        "Garvey is as a lazy, fat, and cynical orange cat.",
                        "https://cdn2.thecatapi.com/images/FZpeiLi4n.jpg"
                    )
                ),
                ListItemUiModel.Cat(
                    CatUiModel(
                        Gender.Unknown,
                        CatBreed.AmericanCurl,
                        "Curious George",
                        "Award winning investigator",
                        "https://cdn2.thecatapi.com/images/vJB8rwfdX.jpg"
                    )
                ),
                ListItemUiModel.Title("Active Agents"),
                ListItemUiModel.Cat(
                    CatUiModel(
                        Gender.Male,
                        CatBreed.BalineseJavanese,
                        "Fred",
                        "Silent and deadly",
                        "https://cdn2.thecatapi.com/images/DBmIBhhyv.jpg"
                    )
                ),
                ListItemUiModel.Cat(
                    CatUiModel(
                        Gender.Female,
                        CatBreed.ExoticShorthair,
                        "Wilma",
                        "Cuddly assassin",
                        "https://cdn2.thecatapi.com/images/KJF8fB_20.jpg"
                    )
                ),
                ListItemUiModel.Cat(
                    CatUiModel(
                        Gender.Male,
                        CatBreed.ExoticShorthair,
                        "Tim",
                        "Tim, AKA Jasper, is very energetic, determined yet somewhat... Slow.",
                        "https://cdn2.thecatapi.com/images/y61B6bFCh.jpg"
                    )
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
