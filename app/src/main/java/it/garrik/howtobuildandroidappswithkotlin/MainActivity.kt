package it.garrik.howtobuildandroidappswithkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

interface StarSignListener {
    fun onSelected(id: Int)
}

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}