package it.garrik.howtobuildandroidappswithkotlin

import android.widget.ImageView

interface ImageLoader {
    fun loadImage(imageUrl: String, imageView: ImageView)
}