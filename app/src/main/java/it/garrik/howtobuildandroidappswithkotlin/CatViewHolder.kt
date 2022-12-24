package it.garrik.howtobuildandroidappswithkotlin

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.core.text.HtmlCompat
import androidx.recyclerview.widget.RecyclerView

import it.garrik.howtobuildandroidappswithkotlin.model.CatBreed
import it.garrik.howtobuildandroidappswithkotlin.model.CatUiModel
import it.garrik.howtobuildandroidappswithkotlin.model.Gender

private val FEMALE_SYMBOL by lazy {
    HtmlCompat.fromHtml("&#9793;", HtmlCompat.FROM_HTML_MODE_LEGACY)
}
private val MALE_SYMBOL by lazy {
    HtmlCompat.fromHtml("&#9794;", HtmlCompat.FROM_HTML_MODE_LEGACY)
}
private const val UNKNOWN_SYMBOL = "?"

class CatViewHolder(
    containerView: View,
    private val imageLoader: ImageLoader
) : RecyclerView.ViewHolder(containerView) {
    private val catPhotoView: ImageView
        by lazy { containerView.findViewById(R.id. item_cat_photo) }
    private val catNameView: TextView
        by lazy { containerView.findViewById(R.id. item_cat_name) }
    private val catBreedView: TextView
        by lazy { containerView.findViewById(R.id. item_cat_breed) }
    private val catBioView: TextView
        by lazy { containerView.findViewById(R.id. item_cat_biography) }
    private val catGenderView: TextView
        by lazy { containerView.findViewById(R.id. item_cat_gender) }

    fun bindData(catData: CatUiModel) {
        imageLoader.loadImage(catData.imageUrl, catPhotoView)
        catNameView.text = catData.name
        catBreedView.text = when (catData.breed) {
            CatBreed.AmericanCurl -> "American Curl"
            CatBreed.BalineseJavanese -> "Balinese-Javanese"
            CatBreed.ExoticShorthair -> "Exotic Shorthair"
        }
        catBioView.text = catData.biography
        catGenderView.text = when (catData.gender) {
            Gender.Female -> FEMALE_SYMBOL
            Gender.Male -> MALE_SYMBOL
            else -> UNKNOWN_SYMBOL
        }
    }
}