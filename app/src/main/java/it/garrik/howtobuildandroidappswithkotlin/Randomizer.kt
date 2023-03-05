package it.garrik.howtobuildandroidappswithkotlin

import java.util.*

class Randomizer(private val random: Random) {
    fun getTimeToWait(): Int {
        return random.nextInt(5) + 1
    }
}