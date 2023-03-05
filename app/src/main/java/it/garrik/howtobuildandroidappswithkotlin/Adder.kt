package it.garrik.howtobuildandroidappswithkotlin

class Adder {
    fun sum(n: Int): Long {
        var result = 0L
        for (i in 1..n) {
            result += i
        }
        return result
    }
}