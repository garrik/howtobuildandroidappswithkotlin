package it.garrik.howtobuildandroidappswithkotlin

import java.util.*

open class Randomizer(private val random: Random) {
    open fun getTimeToWait(): Int {
        return random.nextInt(5) + 1
    }
}