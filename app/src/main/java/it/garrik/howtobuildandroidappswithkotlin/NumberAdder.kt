package it.garrik.howtobuildandroidappswithkotlin

import java.math.BigInteger

class NumberAdder {
    @Throws(InvalidNumberException::class)
    fun sum(n: Int, callback: (BigInteger) -> Unit) {
        if (n < 0) {
            throw InvalidNumberException
        }
        var result = BigInteger.ZERO
        for (i in 1..n){
            result = result.plus(i.toBigInteger())
        }
        callback(result)

    }
    object InvalidNumberException : Throwable()
}