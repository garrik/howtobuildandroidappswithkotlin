package it.garrik.howtobuildandroidappswithkotlin

import android.app.Application
import androidx.test.espresso.idling.CountingIdlingResource
import java.util.*

class MyApplication : Application() {
    val countingIdlingResource = CountingIdlingResource("Timer resource")
    val randomizer = Randomizer(Random())
    val synchronizer = Synchronizer(randomizer, Timer(), countingIdlingResource)
}