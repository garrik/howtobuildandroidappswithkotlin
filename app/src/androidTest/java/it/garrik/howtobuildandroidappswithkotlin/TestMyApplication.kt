package it.garrik.howtobuildandroidappswithkotlin

import java.util.*

class TestMyApplication : MyApplication() {
    override fun createRandomizer(): Randomizer {
        return TestRandomizer(Random())
    }
}