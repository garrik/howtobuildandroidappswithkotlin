package it.garrik.howtobuildandroidappswithkotlin

class Adder {
    fun sum(n: Int): Long {
        return (n * (n.toLong() + 1)) / 2
    }
}